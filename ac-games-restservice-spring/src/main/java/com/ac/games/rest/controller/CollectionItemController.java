package com.ac.games.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.GameWeight;
import com.ac.games.data.User;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.UpdateItemEditables;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/collectionitem")
public class CollectionItemController {
  /**
   * GET method designed to handle retrieving {@link CollectionItem} data from the database.
   * This method supports the following parameters:
   * 
   * <ul>
   * <li><code>itemid=&lt;itemID&gt;</code></li>
   * </ul>
   * 
   * @param itemID
   * 
   * @return A {@link CollectionItem} object or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getCollectionItem(@RequestParam(value="itemid") long itemID) {
    if (itemID <= 0)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid collection request data provided");
      
    GamesDatabase database = null; 
    CollectionItem collection  = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      collection = database.readCollectionItem(itemID);
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
    
    if (collection == null)
      return new SimpleErrorData("Item Not Found", "The requested collection could not be found in the database.");
    return collection;
  }
  
  /**
   * A simple PUT command to update the user.  This will update all fields for a collection, but
   * the itemID cannot be changed.  This value must match the param itemID.
   * 
   * @param itemID The itemID we intend to update.  This is required
   * @param collection   The collection data we want to update.  This is required.
   * 
   * @return a {@link SimpleMessageData} indicating the operation succeeded, or a {@link SimpleErrorData} 
   * indicating it failed.
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putCollectionItem(@RequestParam(value="itemid", defaultValue="-1") long itemID,
                                  @RequestParam(value="collectionid", defaultValue="-1") long collectionID,
                                  @RequestBody UpdateItemEditables itemEdits) {
    if (itemID <= 0)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid CollectionItem request data provided");
    if (itemEdits == null)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid CollectionItem request data provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      CollectionItem item = database.readCollectionItem(itemID);
      if (item == null)
        return new SimpleErrorData("CollectionItem Not Found", "No CollectionItem with this ItemID exists");
      
      boolean hasChanged = false;
      //Now we need to inspect the fields and validate if we have meaningful values.
      if (itemEdits.getOverrideMinPlayers() != null) {
        //If it has no spaces, try to convert it into a number
        String parseString = itemEdits.getOverrideMinPlayers();
        if (parseString.indexOf(" ") != -1) 
          parseString = parseString.substring(0, parseString.indexOf(" ")).trim();
        
        try {
          int newMinPlayers = Integer.parseInt(parseString);
          if (newMinPlayers < 1)
            return new SimpleErrorData("Data Parsing Error", "The provided overrideMinPlayers value of " + itemEdits.getOverrideMinPlayers() + 
                " is not a valid player count");
          if (newMinPlayers != item.getOverrideMinPlayers()) {
            item.setOverrideMinPlayers(newMinPlayers);
            hasChanged = true;
          }
        } catch (NumberFormatException nfe) {
          return new SimpleErrorData("Data Parsing Error", "The provided overrideMinPlayers value of " + itemEdits.getOverrideMinPlayers() + 
              " could not be parsed into a player count");
        }
      }
      if (itemEdits.getOverrideMaxPlayers() != null) {
        //If it has no spaces, try to convert it into a number
        String parseString = itemEdits.getOverrideMaxPlayers();
        if (parseString.indexOf(" ") != -1) 
          parseString = parseString.substring(0, parseString.indexOf(" ")).trim();
        
        try {
          int newMaxPlayers = Integer.parseInt(parseString);
          if (newMaxPlayers < 1)
            return new SimpleErrorData("Data Parsing Error", "The provided overrideMaxPlayers value of " + itemEdits.getOverrideMaxPlayers() + 
                " is not a valid player count");
          if (newMaxPlayers != item.getOverrideMaxPlayers()) {
            item.setOverrideMinPlayers(newMaxPlayers);
            hasChanged = true;
          }
        } catch (NumberFormatException nfe) {
          return new SimpleErrorData("Data Parsing Error", "The provided overrideMaxPlayers value of " + itemEdits.getOverrideMaxPlayers() + 
              " could not be parsed into a player count");
        }
      }
      
      if (itemEdits.getOverrideMinTime() != null) {
        //If it has no spaces, try to convert it into a number
        String parseString = itemEdits.getOverrideMinTime();
        if (parseString.indexOf(" ") != -1) 
          parseString = parseString.substring(0, parseString.indexOf(" ")).trim();
        
        try {
          int newMinTime = Integer.parseInt(parseString);
          if (newMinTime < 1)
            return new SimpleErrorData("Data Parsing Error", "The provided overrideMinTime value of " + itemEdits.getOverrideMinTime() + 
                " is not a valid playing time");
          if (newMinTime != item.getOverrideMinTime()) {
            item.setOverrideMinTime(newMinTime);
            hasChanged = true;
          }
        } catch (NumberFormatException nfe) {
          return new SimpleErrorData("Data Parsing Error", "The provided overrideMinTime value of " + itemEdits.getOverrideMinTime() + 
              " could not be parsed into a playing time");
        }
      }
      if (itemEdits.getOverrideMaxTime() != null) {
        //If it has no spaces, try to convert it into a number
        String parseString = itemEdits.getOverrideMaxTime();
        if (parseString.indexOf(" ") != -1) 
          parseString = parseString.substring(0, parseString.indexOf(" ")).trim();
        
        try {
          int newMaxTime = Integer.parseInt(parseString);
          if (newMaxTime < 1)
            return new SimpleErrorData("Data Parsing Error", "The provided overrideMaxTime value of " + itemEdits.getOverrideMaxTime() + 
                " is not a valid playing time");
          if (newMaxTime != item.getOverrideMaxTime()) {
            item.setOverrideMaxTime(newMaxTime);
            hasChanged = true;
          }
        } catch (NumberFormatException nfe) {
          return new SimpleErrorData("Data Parsing Error", "The provided overrideMaxTime value of " + itemEdits.getOverrideMaxTime() + 
              " could not be parsed into a playing time");
        }
      }
      
      if (itemEdits.getOverrideWhere() != null) {
        if (itemEdits.getOverrideWhere().trim().length() > 0) {
          item.setWhereAcquired(itemEdits.getOverrideWhere().trim());
          hasChanged = true;
        }
      }
      
      //Now check the list of weights, both for what is there and what isn't.
      if (itemEdits.getGameWeights() != null) {
        List<GameWeight> newWeights = itemEdits.getGameWeights();
        if (newWeights.size() == 0) {
          if ((item.getWeights() == null) || (item.getWeights().size() > 0)) {
            item.setWeights(newWeights);
            hasChanged = true;
          }
        } else {
          if ((item.getWeights() == null) || (item.getWeights().size() == 0)) {
            item.setWeights(newWeights);
            hasChanged = true;
          } else if (newWeights.size() != item.getWeights().size()) {
            item.setWeights(newWeights);
            hasChanged = true;
          } else {
            //The lists are the same length, we need to compare to make sure they have the same elements
            boolean different = false;
            for (GameWeight newWeight : newWeights) {
              boolean found = false;
              for (GameWeight oldWeight : item.getWeights()) {
                if (newWeight == oldWeight) {
                  found = true;
                  break;
                }
              }
              if (!found) {
                different = true;
                break;
              }
            }
            if (different) {
              item.setWeights(newWeights);
              hasChanged = true;
            }
          }
        }
      }

      if (hasChanged) {
        database.updateCollectionItem(item);
        
        if (collectionID != -1) {
          Collection curCollection = database.readCollection(collectionID);
          
          if (curCollection != null) {
            boolean updateCollection = false;
            List<CollectionItem> allItems = curCollection.getGames();
            if (allItems != null) {
              for (int itemPos = 0; itemPos < allItems.size(); itemPos++) {
                CollectionItem curItem = allItems.get(itemPos);
                if (curItem.getItemID() == item.getItemID()) {
                  updateCollection = true;
                  allItems.set(itemPos, item);
                  curCollection.setGames(allItems);
                  break;
                }
              }
            }
            if (updateCollection)
              database.updateCollection(curCollection);
          }
        }
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
    
    return new SimpleMessageData("Operation Successful", "The Collection Item was Successfully Updated");
  }
  
  /**
   * A simple POST command to update the user.  This will insert a new collection.
   * 
   * @param collection   The collection data we want to insert.  This is required.
   * 
   * @return a {@link SimpleMessageData} indicating the operation succeeded, or a {@link SimpleErrorData} 
   * indicating it failed.
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postCollectionItem(@RequestBody CollectionItem item) {
    if (item == null)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid CollectionItem request data provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (item.getItemID() == -1)
        item.setItemID(database.getMaxCollectionItemID() + 1);
      
      database.insertCollectionItem(item);
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
   * DELETE Method, which should delete the provided collection reference, if it exists
   * 
   * @param itemID
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteCollectionItem(@RequestParam(value="itemid", defaultValue="-1") long itemID,
                                     @RequestParam(value="userid", defaultValue="-1") long userID,
                                     @RequestParam(value="cascade", defaultValue="no") String cascade) {
    if (itemID <= 0)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid CollectionItem request data provided");
    if (userID <= 0)
      return new SimpleErrorData("CollectionItem Data Error", "There was no valid userID provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //First we need to see if this user exists.  If it does, reject the request.
      CollectionItem existCollectionItem = database.readCollectionItem(itemID);
      if (existCollectionItem == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("No Such CollectionItem", "No CollectionItem with this ID Exists");
      }
      
      //Now we have to go fetch the user, so we can get to his collection, and trim this item out.
      User curUser = database.readUser(userID);
      if (curUser == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("No Such User", "No User with this ID Exists");
      }
      
      //DEBUG
      //System.out.println ("I'm removing the original ID");
      database.deleteCollectionItem(itemID);
      
      Collection collection = database.readCollection(curUser.getCollectionID());
      List<CollectionItem> games = collection.getGames();
      
      //DEBUG
      //System.out.println ("Scanning through " + games.size() + " items to see if I have a match in my collection");
      for (CollectionItem item : games) {
        if (item.getGameID() == existCollectionItem.getGameID()) {
          
          //DEBUG
          //System.out.println ("I think I should be removing something here...");
          games.remove(item);
          break;
        }
      }
      
      //DEBUG
      //System.out.println ("Did anything change: " + games.size());
      
      collection.setGames(games);
      switch (existCollectionItem.getGame().getGameType()) {
        case BASE        : collection.setBaseGameCount(collection.getBaseGameCount() - 1); break;
        case EXPANSION   : collection.setExpansionGameCount(collection.getExpansionGameCount() - 1); break;
        case COLLECTIBLE : collection.setCollectibleGameCount(collection.getCollectibleGameCount() - 1); break;
        default: break;
      }
      
      if (cascade.equalsIgnoreCase("yes") || cascade.equalsIgnoreCase("y")) {
        List<Long> expansionIDs = existCollectionItem.getGame().getExpansionIDs();
        //If we have child games, try to trim them from the collection
        if ((expansionIDs != null) && (expansionIDs.size() > 0)) {
          for (long expGameID : expansionIDs) {
            CollectionItem foundItem = null;
            for (CollectionItem curGame : games) {
              if (curGame.getGameID() == expGameID) {
                foundItem = curGame;
                break;
              }
            }
            if (foundItem != null) {
              games.remove(foundItem);
              collection.setExpansionGameCount(collection.getExpansionGameCount() - 1);
              
              //delete the expansion item
              database.deleteCollectionItem(foundItem.getItemID());
            }
          }
        }
      }
      
      //DEBUG
      //System.out.println ("I'm about to update the collection....");
      database.updateCollection(collection);
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
