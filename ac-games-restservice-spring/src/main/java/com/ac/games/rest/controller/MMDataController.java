package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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

import com.ac.games.data.GameReltn;
import com.ac.games.data.MiniatureMarketCategory;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.ReviewState;
import com.ac.games.data.parser.MiniatureMarketParser;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.exception.GameNotFoundException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the MiniatureMarket game
 * information.
 * <p>
 * It should handle all request that come in under the /external/mmdata entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/external/mmdata")
public class MMDataController {

  /** The standard URI template by which games can be accessed by csiid */
  public final static String URL_TEMPLATE = "http://www.miniaturemarket.com/catalog/product/view/id/<mmid>";
  /** The replacement marker in the URL_TEMPLATE */
  public final static String MMID_MARKER  = "<mmid>";
  
  /**
   * GET method designed to handle retrieving the Miniature Market content from the
   * miniaturemarket website and return the formatted {@link MiniatureMarketPriceData} object.
   * <p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>mmid=&lt;gameid&gt;</code> - The gameID.  This is required.</li>
   * <li><code>source=&lt;mm|db|hybrid&gt;</code> - This indicated whether to request the game from BoardGameGeek (bgg)
   * or from our cached database (db).  Default is mm.</li></ul>
   * 
   * @param mmID
   * @return A {@link MiniatureMarketPriceData} object or {@link SimpleErrorData} message reporting the failure
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getMMData(@RequestParam(value="mmid", defaultValue="-1") long mmID, 
                          @RequestParam(value="source", defaultValue="mm") String source,
                          @RequestParam(value="sync", defaultValue="n") String sync,
                          @RequestParam(value="review", defaultValue="null") String review) {
    if ((!source.equalsIgnoreCase("mm")) && (!source.equalsIgnoreCase("db")) && (!source.equalsIgnoreCase("hybrid")))
      return new SimpleErrorData("Invalid Parameters", "The source parameter value of " + source + " is not a valid source value.");
    if ((!sync.equalsIgnoreCase("n")) && (!sync.equalsIgnoreCase("y")))
      return new SimpleErrorData("Invalid Parameters", "The sync parameter value of " + sync + " is not a valid sync value");
    if ((!review.equalsIgnoreCase("new")) && (!review.equalsIgnoreCase("old")) && (!review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "The review parameter value of " + review + " is not a valid review value");

    if ((mmID == -1) && (review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "No MM ID was provided for this request.");

    //DEBUG
    System.out.println ("Processing mm request for mmID " + mmID + "...");

    MiniatureMarketPriceData mmSource = null;
    MiniatureMarketPriceData dbSource = null;
    
    if ((source.equalsIgnoreCase("db")) || (source.equalsIgnoreCase("hybrid"))) {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      GamesDatabase database = null; 
      MiniatureMarketPriceData data = null;
      
      try {
        database = Application.database;
        database.initializeDBConnection();
        
        if (!review.equalsIgnoreCase("null"))
          data = database.readMMDataForReview(review);
        else data = database.readMMPriceData(mmID);
        
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
    if ((source.equalsIgnoreCase("mm")) || (source.equalsIgnoreCase("hybrid"))) {
      if (source.equalsIgnoreCase("hybrid") && (mmID == -1))
        mmID = dbSource.getMmID();

      //Create the RestTemplate to access the external HTML page
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
      
      MiniatureMarketPriceData data = null;
      try {
        //Run the GET command to retrieve the HTML Body
        ResponseEntity<String> gameResponse = restTemplate.exchange(URL_TEMPLATE.replace(MMID_MARKER, "" + mmID), 
            HttpMethod.GET, entity, String.class);

        String htmlText = gameResponse.getBody();
        data = MiniatureMarketParser.parseMMHTML(htmlText);
        
        //if we got data, we need to start looking for our content type, which we desperately need to make sorting easier
        //To do this, we're going to blindly hammer away at seeding the type breadcrumbs till we find it or run out
        //of breadcrumbs
        if ((data != null) && (data.getSku() != null) && (source.equalsIgnoreCase("mm"))) {
          String htmlRoot = "http://www.miniaturemarket.com";
          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.TABLE_TOP_MINIS_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.TABLETOP);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.COLLECTIBLE_MINIS_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.COLLECTIBLES);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.LCGS_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.LCGS);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.BOARD_GAMES_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.BOARDGAMES);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.SUPPLIES_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.ACCESSORIES);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.CCGS_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.CCGS);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.RPGS_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.RPGS);
            } catch (Throwable t2) {}
          }

          //Always check if set, then process the next category
          if (data.getCategory() == MiniatureMarketCategory.UNKNOWN) {
            try {
              gameResponse = restTemplate.exchange(htmlRoot + MiniatureMarketPriceData.ACCESSORIES_CATEGORY + data.getSku().toLowerCase() + ".html", 
                  HttpMethod.GET, entity, String.class);
              if (gameResponse.getStatusCode() == HttpStatus.OK)
                data.setCategory(MiniatureMarketCategory.ACCESSORIES);
            } catch (Throwable t2) {}
          }
        }
      } catch (GameNotFoundException gnfe) {
        System.out.println ("I could not find this game.");
        return new SimpleErrorData("Game Not Found", "The requested csiid of " + mmID + " could not be found.");
      } catch (HttpServerErrorException hsee) {
        if (hsee.getMessage().contains("503 Service Unavailable")) {
          System.out.println ("The MM server is icing me out again...");
          return new SimpleErrorData("Server Timeout 503", "The MM server has stopped answering my requests");
        } else {
          System.out.println ("Something probably wrong happened here...");
          hsee.printStackTrace();
          return new SimpleErrorData("Operation Error", "An error has occurred: " + hsee.getMessage());
        }
      } catch (HttpClientErrorException hcee) {
        if (hcee.getMessage().contains("404 Not Found")) {
          System.out.println ("I could not find this game.");
          return new SimpleErrorData("Game Not Found", "The requested mmid of " + mmID + " could not be found.");
        } else {
          System.out.println ("Something probably wrong happened here...");
          hcee.printStackTrace();
          return new SimpleErrorData("Operation Error", "An error has occurred: " + hcee.getMessage());
        }
      } catch (Throwable t) {
        System.out.println ("Something terribly wrong happened here...");
        t.printStackTrace();
        return new SimpleErrorData("Operation Error", "An error has occurred: " + t.getMessage());
      }

      if (source.equalsIgnoreCase("mm"))
        return data;
      else mmSource = data;
    } 
    
    //If we made it this far, we're in hybrid mode, so we need to do our comparisons.
    //We need to keep all the Review States, and other fields that we made decisions about
    //otherwise prioritize new fields from BGG
    //Note, we need to check for nulls on any field that may have nulls.
    if (!dbSource.getTitle().equalsIgnoreCase(mmSource.getTitle())) dbSource.setTitle(mmSource.getTitle());
    if (dbSource.getAvailability() != mmSource.getAvailability())   dbSource.setAvailability(mmSource.getAvailability());
    if (dbSource.getMsrpValue() != mmSource.getMsrpValue())         dbSource.setMsrpValue(mmSource.getMsrpValue());
    if (dbSource.getCurPrice() != mmSource.getCurPrice())           dbSource.setCurPrice(mmSource.getCurPrice());

    if (dbSource.getImageURL() == null) dbSource.setImageURL(mmSource.getImageURL());
    else if (mmSource.getImageURL() != null) {
      if (dbSource.getImageURL().equalsIgnoreCase(mmSource.getImageURL()))                 
        dbSource.setImageURL(mmSource.getImageURL());
    }
    if (dbSource.getManufacturer() == null) dbSource.setManufacturer(mmSource.getManufacturer());
    else if (mmSource.getManufacturer() != null) {
      if (dbSource.getManufacturer().equalsIgnoreCase(mmSource.getManufacturer()))                 
        dbSource.setManufacturer(mmSource.getManufacturer());
    }

    if (sync.equalsIgnoreCase("y")) {
      GamesDatabase database = null; 
      try {
        database = Application.database;
        database.initializeDBConnection();
        
        database.updateMMPriceData(dbSource);
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
  public Object putMMData(@RequestParam(value="mmid") long mmID, 
                          @RequestParam(value="review", defaultValue="null") String review,
                          @RequestParam(value="gameid", defaultValue="-1") long gameID,
                          @RequestBody MiniatureMarketPriceData data) {
    if (mmID <= 0)
      return new SimpleErrorData("Game Data Error", "There was no valid MM data provided");
    if (data == null)
      return new SimpleErrorData("Game Data Error", "There was no valid MM data provided");
    if (data.getMmID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no MM ID");
    if (data.getMmID() != mmID)
      return new SimpleErrorData("Game Data Invalid", "The provided game content does not match the mmID parameter");
    
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
        database.updateMMPriceData(data);
      else {
        //We now need to find out if the state is changing
        MiniatureMarketPriceData prevData = database.readMMPriceData(mmID);
        if (prevData.getReviewState() == newState)
          database.updateMMPriceData(data);
        else {
          //The state of the game is changing, so we need to flex what we do based on the new state
          if (newState == ReviewState.REVIEWED) {
            //We know the previous state was not reviewed, so we need to link this game
            //to the GameReltn entry
            GameReltn reltn = database.readGameReltn(gameID);
            if (reltn == null)
              return new SimpleErrorData("No Game Relation Found", "Unable to link this CSI entry to a GameReltn");
            
            List<Long> mmIDs = reltn.getMmIDs();
            if (mmIDs == null)
              mmIDs = new ArrayList<Long>();
            mmIDs.add(mmID);
            reltn.setMmIDs(mmIDs);
            
            data.setReviewState(newState);
            data.setReviewDate(new Date());
            
            database.updateMMPriceData(data);
            database.updateGameReltn(reltn);
          } else if ((newState == ReviewState.REJECTED) || (newState == ReviewState.PENDING)) {
            //This is only complicated if the game was previously approved
            if (prevData.getReviewState() == ReviewState.REVIEWED) {
              //All we really need to do in this case is remove the CSI ID from the List of CSI IDs
              GameReltn reltn = database.readGameReltn(gameID);
              if (reltn == null)
                return new SimpleErrorData("No Game Relation Found", "Unable to link this CSI entry to a GameReltn");
              
              List<Long> mmIDs = reltn.getMmIDs();
              if (mmIDs != null) {
                for (int i = 0; i < mmIDs.size(); i++) {
                  long curValue = mmIDs.get(i);
                  if (curValue == mmID) {
                    mmIDs.remove(i);
                    break;
                  }
                }
              } else mmIDs = new ArrayList<Long>();
              reltn.setMmIDs(mmIDs);
              
              data.setReviewState(newState);
              data.setReviewDate(new Date());
              
              database.updateMMPriceData(data);
              database.updateGameReltn(reltn);
            } else {
              //Just adjust the actual record.
              data.setReviewState(newState);
              data.setReviewDate(new Date());
              
              database.updateMMPriceData(data);
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
  public Object postMMData(@RequestBody MiniatureMarketPriceData data) {
    if (data == null)
      return new SimpleErrorData("Game Data Error", "There was no valid MM data provided");
    
    if (data.getMmID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no MM ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.insertMMPriceData(data);
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
  public Object deleteMMData(@RequestParam(value="mmid") long mmID) {
    if (mmID <= 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no MM ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.deleteMMPriceData(mmID);
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
