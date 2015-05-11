package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.GameReltn;
import com.ac.games.data.ReviewState;
import com.ac.games.data.parser.CoolStuffIncParser;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.exception.GameNotFoundException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the CoolStuffInc game
 * information.
 * <p>
 * It should handle all request that come in under the /external/csidata entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/external/csidata")
public class CSIDataController {

  /** The standard URI template by which games can be accessed by csiid */
  public final static String URL_TEMPLATE = "http://www.coolstuffinc.com/p/<csiid>";
  /** The replacement marker in the URL_TEMPLATE */
  public final static String CSIID_MARKER = "<csiid>";
  
  /**
   * GET method designed to handle retrieving the CoolStuffInc content from the
   * coolstuffinc website and return the formatted {@link CoolStuffIncPriceData} object.
   * <p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>csiid=&lt;gameid&gt;</code> - The gameID.  This is required.</li>
   * <li><code>source=&lt;csi|db&gt;</code> - This indicated whether to request the game from BoardGameGeek (bgg)
   * or from our cached database (db).  Default is csi.</li></ul>
   * 
   * @param csiID
   * @return A {@link CoolStuffIncPriceData} object or {@link SimpleErrorData} message reporting the failure
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getCSIData(@RequestParam(value="csiid", defaultValue="-1") long csiID, 
                           @RequestParam(value="source", defaultValue="csi") String source,
                           @RequestParam(value="sync", defaultValue="n") String sync,
                           @RequestParam(value="review", defaultValue="null") String review) {
    if ((!source.equalsIgnoreCase("csi")) && (!source.equalsIgnoreCase("db")) && (!source.equalsIgnoreCase("hybrid")))
      return new SimpleErrorData("Invalid Parameters", "The source parameter value of " + source + " is not a valid source value.");
    if ((!sync.equalsIgnoreCase("n")) && (!sync.equalsIgnoreCase("y")))
      return new SimpleErrorData("Invalid Parameters", "The sync parameter value of " + sync + " is not a valid sync value");
    if ((!review.equalsIgnoreCase("new")) && (!review.equalsIgnoreCase("old")) && (!review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "The review parameter value of " + review + " is not a valid review value");

    if ((csiID == -1) && (review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "No CSI ID was provided for this request.");
    //DEBUG
    System.out.println ("Processing csi request for csiid " + csiID + "...");
    
    CoolStuffIncPriceData csiSource = null;
    CoolStuffIncPriceData dbSource  = null;
    
    if ((source.equalsIgnoreCase("db")) || (source.equalsIgnoreCase("hybrid"))) {
      GamesDatabase database = null; 
      CoolStuffIncPriceData data = null;
      
      try {
        if (Application.database == null)
          Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
        database = Application.database;
        database.initializeDBConnection();
        
        if (!review.equalsIgnoreCase("null"))
          data = database.readCSIDataForReview(review);
        else data = database.readCSIPriceData(csiID);
        
        //DEBUG
        //if (data == null) System.out.println ("I didn't find anything...");
        //else              System.out.println ("I found game: " + data.getTitle());
        
      } catch (DatabaseOperationException doe) {
        doe.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
      } finally {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      }
      
      if (data == null)
        return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
      
      if (source.equalsIgnoreCase("db"))
        return data;
      else dbSource = data;
    }
    if ((source.equalsIgnoreCase("csi")) || (source.equalsIgnoreCase("hybrid"))) {
      if (source.equalsIgnoreCase("hybrid") && (csiID == -1))
        csiID = dbSource.getCsiID();
      
      //System.out.println ("Preparing to process csiID through remote call: " + csiID);
      
      //Create the RestTemplate to access the external HTML page
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
      
      CoolStuffIncPriceData data = null;
      try {
        //Run the GET command to retrieve the HTML Body
        ResponseEntity<String> gameResponse = restTemplate.exchange(URL_TEMPLATE.replace(CSIID_MARKER, "" + csiID), 
            HttpMethod.GET, entity, String.class);

        String htmlText = gameResponse.getBody();
        data = CoolStuffIncParser.parseCSIHTML(htmlText, csiID);
      } catch (HttpServerErrorException hsee) {
        if (hsee.getMessage().contains("503 Service Unavailable")) {
          System.out.println ("The CSI server is icing me out again...");
          return new SimpleErrorData("Server Timeout 503", "The CSI server has stopped answering my requests");
        } else {
          System.out.println ("Something probably wrong happened here...");
          hsee.printStackTrace();
          return new SimpleErrorData("Operation Error", "An error has occurred: " + hsee.getMessage());
        }
      } catch (HttpClientErrorException hcee) {
        if (hcee.getMessage().contains("404 Not Found")) {
          System.out.println ("I could not find this game.");
          return new SimpleErrorData("Game Not Found", "The requested csiid of " + csiID + " could not be found.");
        } else {
          System.out.println ("Something probably wrong happened here...");
          hcee.printStackTrace();
          return new SimpleErrorData("Operation Error", "An error has occurred: " + hcee.getMessage());
        }
      } catch (GameNotFoundException gnfe) {
        System.out.println ("I could not find this game.");
        return new SimpleErrorData("Game Not Found", "The requested csiid of " + csiID + " could not be found.");
      } catch (Throwable t) {
        System.out.println ("Something terribly wrong happened here...");
        t.printStackTrace();
        return new SimpleErrorData("Operation Error", "An error has occurred: " + t.getMessage());
      }

      if (source.equalsIgnoreCase("csi"))
        return data;
      else csiSource = data;
    } 
    
    //If we made it this far, we're in hybrid mode, so we need to do our comparisons.
    //We need to keep all the Review States, and other fields that we made decisions about
    //otherwise prioritize new fields from BGG
    //Note, we need to check for nulls on any field that may have nulls.
    if (!dbSource.getTitle().equalsIgnoreCase(csiSource.getTitle())) dbSource.setTitle(csiSource.getTitle());
    if (dbSource.getAvailability() != csiSource.getAvailability())   dbSource.setAvailability(csiSource.getAvailability());
    if (dbSource.getMsrpValue() != csiSource.getMsrpValue())         dbSource.setMsrpValue(csiSource.getMsrpValue());
    if (dbSource.getCurPrice() != csiSource.getCurPrice())           dbSource.setCurPrice(csiSource.getCurPrice());
    
    if (dbSource.getImageURL() == null) dbSource.setImageURL(csiSource.getImageURL());
    else if (csiSource.getImageURL() != null) {
      if (dbSource.getImageURL().equalsIgnoreCase(csiSource.getImageURL()))                 
        dbSource.setImageURL(csiSource.getImageURL());
    }
    if (dbSource.getReleaseDate() == null) dbSource.setReleaseDate(csiSource.getReleaseDate());
    else if (csiSource.getReleaseDate() != null) {
      if (dbSource.getReleaseDate().equalsIgnoreCase(csiSource.getReleaseDate()))                 
        dbSource.setReleaseDate(csiSource.getReleaseDate());
    }
    if (dbSource.getPublisher() == null) dbSource.setPublisher(csiSource.getPublisher());
    else if (csiSource.getPublisher() != null) {
      if (dbSource.getPublisher().equalsIgnoreCase(csiSource.getPublisher()))                 
        dbSource.setPublisher(csiSource.getPublisher());
    }

    if (sync.equalsIgnoreCase("y")) {
      GamesDatabase database = null; 
      try {
        database = Application.database;
        database.initializeDBConnection();
        
        database.updateCSIPriceData(dbSource);
      } catch (DatabaseOperationException doe) {
        doe.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
      } finally {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      }
    }
    return dbSource;

  }

  /**
   * PUT Method, which should update (or potentially upsert) the provided data object.
   * 
   * @param data
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putCSIData(@RequestParam(value="csiid") long csiID, 
                           @RequestParam(value="review", defaultValue="null") String review,
                           @RequestParam(value="gameid", defaultValue="-1") long gameID,
                           @RequestBody CoolStuffIncPriceData data) {
    if (csiID <= 0)
      return new SimpleErrorData("Game Data Error", "There was no valid CSI data provided");
    if (data == null)
      return new SimpleErrorData("Game Data Error", "There was no valid CSI data provided");
    if (data.getCsiID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no CSI ID");
    if (data.getCsiID() != csiID)
      return new SimpleErrorData("Game Data Invalid", "The provided game content does not match the csiID parameter");

    if ((!review.equalsIgnoreCase("approve")) && (!review.equalsIgnoreCase("reject")) && 
        (!review.equalsIgnoreCase("reset")) && (!review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "The review parameter value of " + review + " is not a valid review value");

    ReviewState newState = null;
    if (review.equalsIgnoreCase("approve")) newState = ReviewState.REVIEWED;
    if (review.equalsIgnoreCase("reject"))  newState = ReviewState.REJECTED;
    if (review.equalsIgnoreCase("reset"))   newState = ReviewState.PENDING;
    
    if ((newState == ReviewState.REVIEWED) && (gameID == -1))
      return new SimpleErrorData("Invalid Parameters", "This game cannot be reviewed without a gameID provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (newState == null)
        database.updateCSIPriceData(data);
      else {
        //We now need to find out if the state is changing
        CoolStuffIncPriceData prevData = database.readCSIPriceData(csiID);
        if (prevData.getReviewState() == newState)
          database.updateCSIPriceData(data);
        else {
          //The state of the game is changing, so we need to flex what we do based on the new state
          if (newState == ReviewState.REVIEWED) {
            //We know the previous state was not reviewed, so we need to link this game
            //to the GameReltn entry
            GameReltn reltn = database.readGameReltn(gameID);
            if (reltn == null)
              return new SimpleErrorData("No Game Relation Found", "Unable to link this CSI entry to a GameReltn");
            
            List<Long> csiIDs = reltn.getCsiIDs();
            if (csiIDs == null)
              csiIDs = new ArrayList<Long>();
            csiIDs.add(csiID);
            reltn.setCsiIDs(csiIDs);
            
            data.setReviewState(newState);
            data.setReviewDate(new Date());
            
            database.updateCSIPriceData(data);
            database.updateGameReltn(reltn);
          } else if ((newState == ReviewState.REJECTED) || (newState == ReviewState.PENDING)) {
            //This is only complicated if the game was previously approved
            if (prevData.getReviewState() == ReviewState.REVIEWED) {
              //All we really need to do in this case is remove the CSI ID from the List of CSI IDs
              GameReltn reltn = database.readGameReltn(gameID);
              if (reltn == null)
                return new SimpleErrorData("No Game Relation Found", "Unable to link this CSI entry to a GameReltn");
              
              List<Long> csiIDs = reltn.getCsiIDs();
              if (csiIDs != null) {
                for (int i = 0; i < csiIDs.size(); i++) {
                  long curValue = csiIDs.get(i);
                  if (curValue == csiID) {
                    csiIDs.remove(i);
                    break;
                  }
                }
              } else csiIDs = new ArrayList<Long>();
              reltn.setCsiIDs(csiIDs);
              
              data.setReviewState(newState);
              data.setReviewDate(new Date());
              
              database.updateCSIPriceData(data);
              database.updateGameReltn(reltn);
            } else {
              //Just adjust the actual record.
              data.setReviewState(newState);
              data.setReviewDate(new Date());
              
              database.updateCSIPriceData(data);
            }
          }
          
        }//end else the reviewState changed
      }//end else we have a good state
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Put Request Completed Successfully");
  }
  
  /**
   * POST Method, which should insert (or potentially upsert) the provided game object.
   * 
   * @param data
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postCSIData(@RequestBody CoolStuffIncPriceData data) {
    if (data == null)
      return new SimpleErrorData("Game Data Error", "There was no valid CSI data provided");
    
    if (data.getCsiID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no CSI ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.insertCSIPriceData(data);
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Post Request Completed Successfully");
  }

  /**
   * DELETE Method, which should delete the provided game reference, if it exists
   * 
   * @param data
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteCSIData(@RequestParam(value="csiid") long csiID) {
    if (csiID <= 0)
      return new SimpleErrorData("Game Data Invalid", "The provided data has no CSI ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.deleteCSIPriceData(csiID);
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Delete Request Completed Successfully");
  }
}
