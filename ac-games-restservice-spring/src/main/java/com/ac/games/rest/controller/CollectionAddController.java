package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.Game;
import com.ac.games.data.GameWeight;
import com.ac.games.data.User;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.GameToCollectionData;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/collection/add")
public class CollectionAddController {

  /**
   * A simple POST command to add a new collection item to the users collection.
   * 
   * @param data   The collection data we want to insert.  This is required.
   * 
   * @return a {@link SimpleMessageData} indicating the operation succeeded, or a {@link SimpleErrorData} 
   * indicating it failed.
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postNewCollectionItem(@RequestBody GameToCollectionData data) {
    if (data == null)
      return new SimpleErrorData("Collection Data Error", "There was no valid Collection request data provided");
    
    if (data.getGameID() < 0)
      return new SimpleErrorData("Collection Data Error", "There was no GameID provided with this request");
    if (data.getUserID() < 0)
      return new SimpleErrorData("Collection Data Error", "There was no UserID provided with this request");
    Game currentGame       = null;
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      User currentUser = database.readUser(data.getUserID());
      if (currentUser == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid User Error", "This user could not be found in the system");
      }
      
      long collectionID = currentUser.getCollectionID();
      Collection currentCollection = database.readCollection(collectionID);
      if (currentCollection == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid Collection Error", "This user has corrupted collection information");
      }
        
      currentGame = database.readGame(data.getGameID());
      if (currentGame == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid Game Error", "This game could not be found in the system");
      }
      
      //One last safety check.  We need to make sure the game isn't already in the collection (We're not allowing dups)
      List<CollectionItem> items = currentCollection.getGames();
      boolean found = false;
      for (CollectionItem item : items) {
        if (item.getGameID() == currentGame.getGameID()) {
          found = true;
          break;
        }
      }
      
      if (found) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleMessageData("Operation Successful", currentGame.getName() + " is already part of your collection!");
      }
      
      //We should have all the necessary pieces.  We need to update the Collection data and write the new Collection Item
      long newItemID = database.getMaxCollectionItemID() + 1;
      CollectionItem newItem = new CollectionItem();
      newItem.setItemID(newItemID);
      newItem.setGameID(currentGame.getGameID());
      newItem.setGame(currentGame);
      newItem.setDateAcquired(new Date());
      newItem.setWeights(new ArrayList<GameWeight>());
      newItem.setWhereAcquired("");
      
      database.insertCollectionItem(newItem);
      
      items.add(newItem);
      currentCollection.setGames(items);
      switch (currentGame.getGameType()) {
        case BASE        : currentCollection.setBaseGameCount(currentCollection.getBaseGameCount() + 1); break;
        case EXPANSION   : currentCollection.setExpansionGameCount(currentCollection.getExpansionGameCount() + 1); break;
        case COLLECTIBLE : currentCollection.setCollectibleGameCount(currentCollection.getCollectibleGameCount() + 1); break;
        default : break;
      }
      database.updateCollection(currentCollection);
    
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
    
    return new SimpleMessageData("Operation Successful", currentGame.getName() + " has been added to your collection!");
  }
}
