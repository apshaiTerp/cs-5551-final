package com.ac.games.rest.controller;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.CompactPriceData;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.GameReltn;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the core Game
 * information.
 * <p>
 * It should handle all request that come in under the /gamereltn entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/gamereltn")
public class GameReltnController {

  private final static DecimalFormat formatter = new DecimalFormat("'$'0.00");
  
  /**
   * GET method designed to handle retrieving {@link GameReltn} data from the database.<p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>gameid=&lt;gameID&gt;</code> - The gameID.  This is required.</li>
   * </ul>
   * 
   * @param gameID The gameID that we are using to base this request on.
   * 
   * @return A {@link GameReltn} object or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getGameReltn(@RequestParam(value="gameid") long gameID,
                             @RequestParam(value="vendor", defaultValue="none") String vendor) {
    if (gameID <= 0)
      return new SimpleErrorData("User Data Error", "There was no valid game request data provided");
    
    if ((!vendor.equalsIgnoreCase("none")) && (!vendor.equalsIgnoreCase("all")) && 
        (!vendor.equalsIgnoreCase("csi")) && (!vendor.equalsIgnoreCase("mm")) && (!vendor.equalsIgnoreCase("amazon")))
      return new SimpleErrorData("User Data Error", "The provided vendor " + vendor + " is not a valid vendor option");
    
    GamesDatabase database = null; 
    
    Object result = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      GameReltn gameReltn = database.readGameReltn(gameID);
      if (vendor.equalsIgnoreCase("none"))
        result = gameReltn;
      else {
        //If we're here, we want game price information, which means we want price information.
        //Since we don't need a button, we just need to be able to build a link.
        List<CompactPriceData> priceData = new LinkedList<CompactPriceData>();
        
        if (vendor.equalsIgnoreCase("csi")) {
          List<Long> csiIDs = gameReltn.getCsiIDs();
          if (csiIDs == null)
            result = priceData;
          else if (csiIDs.size() == 0)
            result = priceData;
          else {
            for (long csiID : csiIDs) {
              CoolStuffIncPriceData data = database.readCSIPriceData(csiID);
              if (data != null) {
                CompactPriceData price = new CompactPriceData();
                price.setTitleDisplay(data.getTitle() + " (CSI ID: " + data.getCsiID() + ")");
                
                String availString = "";
                switch (data.getAvailability()) {
                  case INSTOCK            : availString = "[This Game is In Stock]"; break;
                  case PREORDER           : availString = "[Accepting Pre-Orders]"; break;
                  case OUTOFSTOCK         : availString = "[This Game is Out of Stock]"; break;
                  case NOTYETTAKINGORDERS : availString = "[This Game is Not Yet Taking Orders]"; break;
                  default                 : availString = "";
                }
                String priceString = "";
                if (data.getCurPrice() < 0.0) {
                  if (data.getMsrpValue() < 0.0)
                    priceString = "";
                  else 
                    priceString = "MSRP " + formatter.format(data.getMsrpValue());
                } else
                  priceString = formatter.format(data.getCurPrice());
                
                String priceDisplayString = priceString + "  " + availString;
                price.setPriceDisplay(priceDisplayString.trim());
                
                price.setLinkURL("http://www.coolstuffinc.com/p/" + data.getCsiID());
                price.setThumbnailURL(data.getImageURL());
                
                priceData.add(price);
              }
            }//end for each CSI ID
            result = priceData;
          }//end else we have csi data to investigate
        }//end if csi
        else if (vendor.equalsIgnoreCase("mm")) {
          List<Long> mmIDs = gameReltn.getMmIDs();
          if (mmIDs == null)
            result = priceData;
          else if (mmIDs.size() == 0)
            result = priceData;
          else {
            for (long mmID : mmIDs) {
              MiniatureMarketPriceData data = database.readMMPriceData(mmID);
              if (data != null) {
                CompactPriceData price = new CompactPriceData();
                price.setTitleDisplay(data.getTitle() + " (MM ID: " + data.getMmID() + ")");
                
                String availString = "";
                switch (data.getAvailability()) {
                  case INSTOCK            : availString = "[This Game is In Stock]"; break;
                  case PREORDER           : availString = "[Accepting Pre-Orders]"; break;
                  case OUTOFSTOCK         : availString = "[This Game is Out of Stock]"; break;
                  case NOTYETTAKINGORDERS : availString = "[This Game is Not Yet Taking Orders]"; break;
                  default                 : availString = "";
                }
                String priceString = "";
                if (data.getCurPrice() < 0.0) {
                  if (data.getMsrpValue() < 0.0)
                    priceString = "";
                  else 
                    priceString = "MSRP " + formatter.format(data.getMsrpValue());
                } else
                  priceString = formatter.format(data.getCurPrice());
                
                String priceDisplayString = priceString + "  " + availString;
                price.setPriceDisplay(priceDisplayString.trim());
                
                if (data.getSku() != null)
                  price.setLinkURL("http://www.miniaturemarket.com/" + data.getSku().toLowerCase() + ".html");
                else price.setLinkURL("http://www.miniaturemarket.com/catalog/product/view/id/" + data.getMmID());
                
                price.setThumbnailURL(data.getImageURL());
                
                priceData.add(price);
              }
            }//end for each MM ID
            result = priceData;
          }//end else we have mm data to investigate
        }//end if mm
      }//end else we have a vendor option
      
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
    
    if (result == null)
      return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");

    return result;
  }

  /**
   * PUT Method, which should update (or potentially upsert) the provided game object.
   * 
   * @param gameID
   * @param gameReltn
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putGameReltn(@RequestParam(value="gameid") long gameID,
                             @RequestBody GameReltn gameReltn) {
    if (gameID <= 0)
      return new SimpleErrorData("Game Data Error", "There was no valid Game Relation data provided");
    if (gameReltn == null)
      return new SimpleErrorData("Game Data Error", "There was no valid Game Relation data provided");
    if (gameReltn.getGameID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game relation has no Game ID");
    if (gameReltn.getReltnID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game relation has no Relation ID");
    if (gameReltn.getGameID() != gameID)
      return new SimpleErrorData("Game Data Invalid", "The provided game relation content does not match the gameID parameter");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.updateGameReltn(gameReltn);
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
   * @param gameReltn
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postGameReltn(@RequestBody GameReltn gameReltn) {
    if (gameReltn == null)
      return new SimpleErrorData("Game Data Error", "There was no valid Game Relation data provided");
    
    if (gameReltn.getGameID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game relation has no Game ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (gameReltn.getReltnID() == -1)
        gameReltn.setReltnID(database.getMaxGameReltnID());
      
      database.insertGameReltn(gameReltn);
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
   * @param reltnID
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteGameReltn(@RequestParam(value="reltnid") long reltnID) {
    if (reltnID <= 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no Game Relation ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.deleteGameReltn(reltnID);
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
