package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.PlaythruItem;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class PlaythruItemConverter {

  /**
   * Helper method that will construct a basic query using the playthruID from the provided playthru item.
   * 
   * @param item The PlaythruItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertPlaythruItemToIDQuery(PlaythruItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("playthruID", item.getPlaythruID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the playthruID from the provided playthru item.
   * 
   * @param playthruID The PlaythruItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertPlaythruItemToIDQuery(long playthruID) {
    if (playthruID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("playthruID", playthruID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertPlaythruItemToMongo(PlaythruItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("playthruID", item.getPlaythruID());
    if (item.getUserID() <= -1)         dbObject.append("userID", item.getUserID());
    if (item.getGameID() <= -1)         dbObject.append("gameID", item.getGameID());
    if (item.getGameName() != null)     dbObject.append("gameName", item.getGameName());
    if (item.getDatePlayed() != null)   dbObject.append("datePlayed", item.getDatePlayed());
    if (item.getNumPlayers() <= -1)     dbObject.append("numPlayers", item.getNumPlayers());
    if (item.getWinnerText() != null)   dbObject.append("winnerText", item.getWinnerText());
    if (item.getPlaythruText() != null) dbObject.append("playthruText", item.getPlaythruText());
    
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link PlaythruItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link PlaythruItem} object, or null if the dbObject was null
   */
  public static PlaythruItem convertMongoToPlaythruItem(DBObject dbObject) {
    if (dbObject == null) return null;
    
    PlaythruItem item = new PlaythruItem();
    if (dbObject.containsField("playthruID"))   item.setPlaythruID((Long)dbObject.get("playthruID"));
    if (dbObject.containsField("userID"))       item.setUserID((Long)dbObject.get("userID"));
    if (dbObject.containsField("gameID"))       item.setGameID((Long)dbObject.get("gameID"));
    if (dbObject.containsField("gameName"))     item.setGameName((String)dbObject.get("gameName"));
    if (dbObject.containsField("datePlayed"))   item.setDatePlayed((Date)dbObject.get("datePlayed"));
    if (dbObject.containsField("numPlayers"))   item.setNumPlayers((Integer)dbObject.get("numPlayers"));
    if (dbObject.containsField("winnerText"))   item.setWinnerText((String)dbObject.get("winnerText"));
    if (dbObject.containsField("playthruText")) item.setPlaythruText((String)dbObject.get("playthruText"));
    return item;
  }
}
