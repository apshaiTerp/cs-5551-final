package com.ac.games.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.GameType;
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
 * It should handle all request that come in under the /game entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {

  private final static SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy");
  /**
   * GET method designed to handle retrieving {@link Collection} data from the database.
   * This method supports the following parameters:
   * 
   * <ul>
   * <li><code>collectionid=&lt;collectionID&gt;</code></li>
   * </ul>
   * 
   * @param collectionID
   * 
   * @return A {@link Collection} object or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getCollection(@RequestParam(value="collectionid") long collectionID,
                              @RequestParam(value="topx", defaultValue = "-1") int topX,
                              @RequestParam(value="compact", defaultValue = "no") String compact) {
    if (collectionID <= 0)
      return new SimpleErrorData("Collection Data Error", "There was no valid collection request data provided");
    
    if ((!compact.equalsIgnoreCase("no")) && (!compact.equalsIgnoreCase("yes")) && (!compact.equalsIgnoreCase("n")) && (!compact.equalsIgnoreCase("y")))
      return new SimpleErrorData("Collection Data Error", "The compact value " + compact + " is not an accepted value.");
      
    GamesDatabase database = null; 
    Object results         = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if ((topX == -1) && ((compact.equalsIgnoreCase("no") || compact.equalsIgnoreCase("n"))))
        results = database.readCollection(collectionID);
      else if (topX > 0) {
        Collection collection = database.readCollection(collectionID);
        if (collection == null)
          results = null;
        else {
          List<CollectionItem> allItems = collection.getGames();
          if ((allItems == null) || (allItems.size() == 0))
            results = new ArrayList<CompactSearchData>();
          else {
            //Now we need to sort and choose
            Collections.sort(allItems);
            List<CompactSearchData> resultList = new ArrayList<CompactSearchData>();
            for (int i = 0; ((i < topX) && (i < allItems.size())); i++) {
              CollectionItem item = allItems.get(i);
              CompactSearchData data = new CompactSearchData();
              String displayString = item.getGame().getName();
              if (item.getGame().getYearPublished() != -1)
                displayString += " (" + item.getGame().getYearPublished() + ")";
              data.setDisplayString(displayString);
              data.setSourceID(item.getItemID());
              data.setThumbnailURL(item.getGame().getImageThumbnailURL());
              //Overload the sourceField value to put displayable text
              if (item.getDateAcquired() != null)
                data.setSourceField("Game acquired on: " + formatter.format(item.getDateAcquired()));
              else data.setSourceField("Game ID: " + item.getGameID());
              resultList.add(data);
            }
            results = resultList;
          }
        }
      } else if (compact.equalsIgnoreCase("yes") || compact.equalsIgnoreCase("y")) {
        Collection collection = database.readCollection(collectionID);
        if (collection == null)
          results = null;
        else {
          List<CollectionItem> allItems = collection.getGames();
          if ((allItems == null) || (allItems.size() == 0))
            results = new ArrayList<CollectionItem>();
          else {
            List<CollectionItem> resultList = new LinkedList<CollectionItem>();
            
            //First Loop, pick out all Base and Collectible games
            for (CollectionItem item : allItems) {
              if ((item.getGame().getGameType() == GameType.BASE) || (item.getGame().getGameType() == GameType.COLLECTIBLE))
                resultList.add(item);
            }
            
            //Second Loop, pick out all Expansions, and link them to their parent game if possible.
            for (CollectionItem item : allItems) {
              if (item.getGame().getGameType() == GameType.EXPANSION) {
                boolean found = false;
                for (CollectionItem parentItem : resultList) {
                  if (parentItem.getGameID() == item.getGame().getParentGameID()) {
                    CompactSearchData data = new CompactSearchData();
                    String displayString = item.getGame().getName();
                    if (item.getGame().getYearPublished() != -1)
                      displayString += " (" + item.getGame().getYearPublished() + ")";
                    data.setDisplayString(displayString);
                    data.setSourceID(item.getItemID());
                    data.setThumbnailURL(item.getGame().getImageThumbnailURL());
                    data.setSourceField("Game ID: " + item.getGameID());
                    
                    List<CompactSearchData> expansions = parentItem.getExpansionList();
                    if (expansions == null) expansions = new ArrayList<CompactSearchData>();
                    expansions.add(data);
                    
                    parentItem.setExpansionList(expansions);
                    found = true;
                    break;
                  }
                }
                if (!found) {
                  //If we somehow have an expansion with no parent, then just add it to the list
                  resultList.add(item);
                }
              }
            }//end for second loop
            
            Collections.sort(resultList);
            results = resultList;
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
    
    if (results == null)
      return new SimpleErrorData("Collection Not Found", "The requested collection could not be found in the database.");
    return results;
  }
  
  /**
   * A simple PUT command to update the user.  This will update all fields for a collection, but
   * the collectionID cannot be changed.  This value must match the param collectionID.
   * 
   * @param collectionID The collectionID we intend to update.  This is required
   * @param collection   The collection data we want to update.  This is required.
   * 
   * @return a {@link SimpleMessageData} indicating the operation succeeded, or a {@link SimpleErrorData} 
   * indicating it failed.
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putCollection(@RequestParam(value="collectionid", defaultValue="-1") long collectionID,
                              @RequestBody Collection collection) {
    if (collectionID <= 0)
      return new SimpleErrorData("Collection Data Error", "There was no valid Collection request data provided");
    if (collection == null)
      return new SimpleErrorData("Collection Data Error", "There was no valid Collection request data provided");
    if (collectionID != collection.getCollectionID())
      return new SimpleErrorData("Collection Data Error", "The collectionID parameter and collectionID value of the RequestBody do not match");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
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
    
    return new SimpleMessageData("Operation Successful", "The Put Request Completed Successfully");
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
  public Object postCollection(@RequestBody Collection collection) {
    if (collection == null)
      return new SimpleErrorData("Collection Data Error", "There was no valid Collection request data provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (collection.getCollectionID() == -1)
        collection.setCollectionID(database.getMaxCollectionID() + 1);
      
      database.insertCollection(collection);
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
   * @param collectionID
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteCollection(@RequestParam(value="collectionid", defaultValue="-1") long collectionID) {
    if (collectionID <= 0)
      return new SimpleErrorData("Collection Data Error", "There was no valid Collection request data provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //First we need to see if this user exists.  If it does, reject the request.
      Collection existCollection = database.readCollection(collectionID);
      if (existCollection == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("No Such Collection", "No Collection with this ID Exists");
      }
      
      //We need to then delete all the dependent items, including collection items.
      List<CollectionItem> deleteItems = existCollection.getGames();
      for (CollectionItem item : deleteItems) 
        database.deleteCollectionItem(item.getItemID());
      database.deleteCollection(existCollection.getCollectionID());
      
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
