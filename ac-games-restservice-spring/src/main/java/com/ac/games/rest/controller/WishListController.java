package com.ac.games.rest.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.CompactPriceData;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.User;
import com.ac.games.data.WishlistItem;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.WishPlusFullList;
import com.ac.games.rest.data.WishPlusGameList;
import com.ac.games.rest.data.WishPost;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the wishlist information
 * information.
 * <p>
 * It should handle all request that come in under the /wishlist entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/wishlist")
public class WishListController {

  private final static DecimalFormat formatter = new DecimalFormat("'$'0.00");

  /**
   * GET method designed to handle retrieving various incarnations of wishlist data.
   * 
   * @param userID The userID.  This is required
   * @param gameID The gameID, which is used to get the single row, if any, for this gameID
   * @param display Flag to indicate if we should assemble all outside data for display
   * 
   * @return Some version of Wishlist stuff
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getWishlist(@RequestParam(value="userid") long userID,
                            @RequestParam(value="gameid", defaultValue="-1") long gameID,
                            @RequestParam(value="display", defaultValue="none") String display,
                            @RequestParam(value="topx", defaultValue="-1") int topX) {
     if (userID < 0)
       return new SimpleErrorData("Wishlist Data Error", "The provided userID was not valid");
     if ((!display.equalsIgnoreCase("none")) && (!display.equalsIgnoreCase("game")) && 
         (!display.equalsIgnoreCase("compact")) && (!display.equalsIgnoreCase("full")))
       return new SimpleErrorData("Wishlist Data Error", "The display value of " + display + " is not a valid display option");
     
     GamesDatabase database = null;
     Object result = null;
     
     try {
       if (Application.database == null)
         Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
       database = Application.database;
       database.initializeDBConnection();
       
       if ((gameID == -1) && (display.equalsIgnoreCase("none"))) {
         //This is the get simple list of all by user
         List<WishlistItem> wishlist = database.readWishlistForUser(userID);
         Collections.sort(wishlist);
         result = wishlist;
       } else if (gameID > 0) {
         result = database.readWishlistItem(userID, gameID);
       } else if (!display.equalsIgnoreCase("none")) {
         //We know at least we need to start building a list of games
         List<WishlistItem> wishlist = database.readWishlistForUser(userID);
         Collections.sort(wishlist);
         
         if (display.equalsIgnoreCase("compact")) {
           List<CompactSearchData> compactList = new ArrayList<CompactSearchData>();
           
           for (WishlistItem item : wishlist) {
             List<CompactSearchData> games = database.readGamesCompact("" + item.getGameID());
             if (games != null) {
               compactList.add(games.get(0));
               if ((topX > 0) && (compactList.size() >= topX)) {
                 break;
               }
             }
           }
           
           result = compactList;
         } else if (display.equalsIgnoreCase("game")) {
           List<WishPlusGameList> gameList = new LinkedList<WishPlusGameList>();
           
           for (WishlistItem item : wishlist) {
             Game game = database.readGame(item.getGameID());
             if (game != null) {
               WishPlusGameList gameItem = new WishPlusGameList(item);
               gameItem.setGame(game);
               gameList.add(gameItem);
               
               if ((topX > 0) && (gameList.size() >= topX)) {
                 break;
               }
             }
           }
           
           result = gameList;
         } else if (display.equalsIgnoreCase("full")) {
           List<WishPlusFullList> gameList = new LinkedList<WishPlusFullList>();
           
           for (WishlistItem item : wishlist) {
             Game game = database.readGame(item.getGameID());
             if (game != null) {
               WishPlusFullList gameItem = new WishPlusFullList(item);
               gameItem.setGame(game);
               
               GameReltn gameReltn = database.readGameReltn(item.getGameID());
               if (gameReltn != null) {
                 
                 List<Long> csiIDs = gameReltn.getCsiIDs();
                 if ((csiIDs != null) && (csiIDs.size() >= 0)) {
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
                       
                       gameItem.addCSIData(price);
                     }
                   }//end for each CSI ID
                 }//end if we have csi data to investigate
                 
                 List<Long> mmIDs = gameReltn.getMmIDs();
                 if ((mmIDs != null) && (mmIDs.size() >= 0)) {
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
                       
                       gameItem.addMMData(price);
                     }
                   }//end for each CSI ID
                 }//end if we have mm data to investigate
               }//end if we have gameReltn data to investigate
               gameList.add(gameItem);
             }//end if game is not null
             result = gameList;
           }//end for all wishlist items
         }//end if display = full
       }
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
   * POST method, which should insert (no upserting)
   * 
   * @param wish 
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postWishlist(@RequestBody WishPost wish) {
    if (wish == null)
      return new SimpleErrorData("Wishlist Data Error", "There was no wishlist data provided");
    
    if (wish.getGameID() < 0)
      return new SimpleErrorData("Wishlist Data Error", "There was no gameID data provided");
    if (wish.getUserID() < 0)
      return new SimpleErrorData("Wishlist Data Error", "There was no userID data provided");

    GamesDatabase database = null; 
    
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //We need to make sure the user and the game are both valid, and that this item isn't already on wishlist
      WishlistItem item = database.readWishlistItem(wish.getUserID(), wish.getGameID());
      if (item != null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleMessageData("Operation Successful", "This Game is already in your Wishlist!");
      }
      
      User user = database.readUser(wish.getUserID());
      if (user == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid User Error", "There was no User matching the provided userID value");
      }
      
      Game game = database.readGame(wish.getGameID());
      if (game == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid Game Error", "There was no Game matching the provided gameID value");
      }
      
      item = new WishlistItem();
      item.setUserID(wish.getUserID());
      item.setGameID(wish.getGameID());
      item.setDateAdded(new Date());
      //Improve this
      item.setNotifyUser(false);
      long wishSequence = database.getMaxWishlistItemID() + 1;
      item.setWishID(wishSequence);
      
      database.insertWishlistItem(item);
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
    
    return new SimpleMessageData("Operation Successful", "The Game was successfully added to your Wishlist!");
  }

  /**
   * DELETE Method, which should delete the provided game reference, if it exists
   * 
   * @param reltnID
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteWishlist(@RequestParam(value="userid") long userID,
                               @RequestParam(value="gameid") long gameID) {
    if (userID < 0)
      return new SimpleErrorData("Wishlist Data Invalid", "The userID provided is not valid.");
    if (gameID < 0)
      return new SimpleErrorData("Wishlist Data Invalid", "The gameID provided is not valid.");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      WishlistItem item = database.readWishlistItem(userID, gameID);
      if (item != null)
        database.deleteWishlistItem(item.getWishID());
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
