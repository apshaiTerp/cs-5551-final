package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.List;

import com.ac.games.data.GameReltn;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


/**
 * 
 * @author ac010168
 *
 */
public class GameReltnConverter {

  /**
   * Helper method that will construct a basic query using the gameID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToIDQuery(GameReltn gameReltn) {
    if (gameReltn == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("reltnID", gameReltn.getReltnID());
    return dbObject;
  }

  /**
   * Helper method that will construct a basic query using the gameID representing the provided game relation.
   * 
   * @param gameID The game ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToGameIDQuery(long gameID) {
    if (gameID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("gameID", new Long(gameID));
    return dbObject;
  }

  /**
   * Helper method that will construct a basic query using the reltnID representing the provided game relation.
   * 
   * @param reltnID The game relation ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToReltnIDQuery(long reltnID) {
    if (reltnID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("reltnID", new Long(reltnID));
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database record for the provided game object.
   * 
   * @param game The Game we want to build a database record for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToMongo(GameReltn gameReltn) {
    if (gameReltn == null) return null;
    
    //These two fields are required
    BasicDBObject dbObject = new BasicDBObject("reltnID", gameReltn.getReltnID());
    dbObject.append("gameID", gameReltn.getGameID());
    
    if (gameReltn.getBggID() != -1)        dbObject.append("bggID", gameReltn.getBggID());
    if (gameReltn.getCsiIDs() != null)     dbObject.append("csiIDs", convertList(gameReltn.getCsiIDs()));
    if (gameReltn.getMmIDs() != null)      dbObject.append("mmIDs", convertList(gameReltn.getMmIDs()));
    if (gameReltn.getAsinKeys() != null)   dbObject.append("asinKeys", convertList(gameReltn.getAsinKeys()));
    if (gameReltn.getOtherSites() != null) dbObject.append("otherSites", convertList(gameReltn.getOtherSites()));
    
    return dbObject;
  } 
  
  /**
   * Convert a Mongo BSON record back into a {@link GameReltn} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link GameReltn} object, or null if the dbObject was null
   */
  public static GameReltn convertMongoToGameReltn(DBObject dbObject) {
    if (dbObject == null) return null;
    
    GameReltn gameReltn = new GameReltn();
    
    if (dbObject.containsField("reltnID"))    gameReltn.setReltnID((Long)dbObject.get("reltnID"));
    if (dbObject.containsField("gameID"))     gameReltn.setGameID((Long)dbObject.get("gameID"));
    if (dbObject.containsField("bggID"))      gameReltn.setBggID((Long)dbObject.get("bggID"));
    if (dbObject.containsField("csiIDs"))     gameReltn.setCsiIDs(convertDBListToLongList((BasicDBList)dbObject.get("csiIDs")));
    if (dbObject.containsField("mmIDs"))      gameReltn.setMmIDs(convertDBListToLongList((BasicDBList)dbObject.get("mmIDs")));
    if (dbObject.containsField("asinKeys"))   gameReltn.setAsinKeys(convertDBListToStringList((BasicDBList)dbObject.get("asinKeys")));
    if (dbObject.containsField("otherSites")) gameReltn.setOtherSites(convertDBListToLongList((BasicDBList)dbObject.get("otherSites")));

    return gameReltn;
  }

  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<?> curList) {
    if (curList == null) return null;
    
    BasicDBList newList = new BasicDBList();
    for (Object obj : curList)
      newList.add(obj);
    return newList;
  }
  
  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<String> convertDBListToStringList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<String> newList = new ArrayList<String>(curList.size());
    for (Object obj : curList) {
      newList.add((String)obj);
    }
    return newList;
  }

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<Long> format.
   */
  private static List<Long> convertDBListToLongList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<Long> newList = new ArrayList<Long>(curList.size());
    for (Object obj : curList) {
      newList.add((Long)obj);
    }
    return newList;
  }
}
