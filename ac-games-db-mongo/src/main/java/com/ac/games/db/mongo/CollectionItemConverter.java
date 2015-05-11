package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ac.games.data.CollectionItem;
import com.ac.games.data.GameWeight;
import com.ac.games.data.GameWeightConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class CollectionItemConverter {

  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param item The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionItemToIDQuery(CollectionItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("itemID", item.getItemID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param itemID The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionItemToIDQuery(long itemID) {
    if (itemID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("itemID", itemID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param item The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertCollectionItemToMongo(CollectionItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("itemID", item.getItemID());
    if (item.getGameID() != -1)          dbObject.append("gameID", item.getGameID());
    if (item.getGame() != null)          dbObject.append("game", GameConverter.convertGameToMongo(item.getGame()));
    if (item.getWeights() != null)       dbObject.append("weights", convertList(item.getWeights()));
    if (item.getDateAcquired() != null)  dbObject.append("dateAcquired", item.getDateAcquired());
    if (item.getWhereAcquired() != null) dbObject.append("whereAcquired", item.getWhereAcquired());
    
    if (item.getOverrideMinPlayers() != -1) dbObject.append("overrideMinPlayers", item.getOverrideMinPlayers());
    if (item.getOverrideMaxPlayers() != -1) dbObject.append("overrideMaxPlayers", item.getOverrideMaxPlayers());
    if (item.getOverrideMinTime() != -1)    dbObject.append("overrideMinTime", item.getOverrideMinTime());
    if (item.getOverrideMaxTime() != -1)    dbObject.append("overrideMaxTime", item.getOverrideMaxTime());
    
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link CollectionItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link CollectionItem} object, or null if the dbObject was null
   */
  public static CollectionItem convertMongoToCollectionItem(DBObject dbObject) {
    if (dbObject == null) return null;
    
    CollectionItem item = new CollectionItem();
    if (dbObject.containsField("itemID"))        item.setItemID((Long)dbObject.get("itemID"));
    if (dbObject.containsField("gameID"))        item.setGameID((Long)dbObject.get("gameID"));
    if (dbObject.containsField("game"))          item.setGame(GameConverter.convertMongoToGame((DBObject)dbObject.get("game")));
    if (dbObject.containsField("weights"))       item.setWeights(convertDBListToGameWeightList((BasicDBList)dbObject.get("weights")));
    if (dbObject.containsField("dateAcquired"))  item.setDateAcquired((Date)dbObject.get("dateAcquired"));
    if (dbObject.containsField("whereAcquired")) item.setWhereAcquired((String)dbObject.get("whereAcquired"));
    
    if (dbObject.containsField("overrideMinPlayers")) item.setOverrideMinPlayers((Integer)dbObject.get("overrideMinPlayers"));
    if (dbObject.containsField("overrideMaxPlayers")) item.setOverrideMaxPlayers((Integer)dbObject.get("overrideMaxPlayers"));
    if (dbObject.containsField("overrideMinTime"))    item.setOverrideMinTime((Integer)dbObject.get("overrideMinTime"));
    if (dbObject.containsField("overrideMaxTime"))    item.setOverrideMaxTime((Integer)dbObject.get("overrideMaxTime"));
    
    return item;
  }
  
  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<GameWeight> curList) {
    if (curList == null) return null;
    
    BasicDBList newList = new BasicDBList();
    for (GameWeight obj : curList)
      newList.add(GameWeightConverter.convertGameWeightToFlag(obj));
    return newList;
  }

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<GameWeight> convertDBListToGameWeightList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<GameWeight> newList = new ArrayList<GameWeight>(curList.size());
    for (Object obj : curList) {
      newList.add(GameWeightConverter.convertFlagToGameWeight((Integer)obj));
    }
    return newList;
  }
}
