package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.MediaItem;
import com.ac.games.data.MediaItemTypeConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class MediaItemConverter {
  
  /**
   * Helper method that will construct a basic query using the mediaID from the provided game.
   * 
   * @param user The MediaItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertMediaItemToIDQuery(MediaItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("mediaID", item.getMediaID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param fieldName The field we want to build our query on.
   * @param genericID The generic ID value we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertMediaItemToGenericIDQuery(String fieldName, long genericID) {
    if (genericID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject(fieldName, genericID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertMediaItemToMongo(MediaItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("mediaID", item.getMediaID());
    if (item.getGameID() <= -1)             dbObject.append("gameID", item.getGameID());
    if (item.getUserID() <= -1)             dbObject.append("userID", item.getUserID());
    if (item.getUserName() != null)         dbObject.append("userName", item.getUserName());
    if (item.getItemType() != null)         dbObject.append("itemType", MediaItemTypeConverter.convertMediaItemTypeToFlag(item.getItemType()));
    if (item.getMediaLink() != null)        dbObject.append("mediaLink", item.getMediaLink());
    if (item.getMediaDescription() != null) dbObject.append("mediaDescription", item.getMediaDescription());
    if (item.getAddedDate() != null)        dbObject.append("addedDate", item.getAddedDate());
    dbObject.append("privateItem", item.isPrivateItem());
    
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link MediaItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link MediaItem} object, or null if the dbObject was null
   */
  public static MediaItem convertMongoToMediaItem(DBObject dbObject) {
    if (dbObject == null) return null;
    
    MediaItem item = new MediaItem();
    if (dbObject.containsField("mediaID"))          item.setMediaID((Long)dbObject.get("mediaID"));
    if (dbObject.containsField("gameID"))           item.setGameID((Long)dbObject.get("gameID"));
    if (dbObject.containsField("userID"))           item.setUserID((Long)dbObject.get("userID"));
    if (dbObject.containsField("userName"))         item.setUserName((String)dbObject.get("userName"));
    if (dbObject.containsField("itemType"))         item.setItemType(MediaItemTypeConverter.convertFlagToMediaItemType((Integer)dbObject.get("itemType")));
    if (dbObject.containsField("mediaLink"))        item.setMediaLink((String)dbObject.get("mediaLink"));
    if (dbObject.containsField("mediaDescription")) item.setMediaDescription((String)dbObject.get("mediaDescription"));
    if (dbObject.containsField("addedDate"))        item.setAddedDate((Date)dbObject.get("addedDate"));
    if (dbObject.containsField("privateItem"))      item.setPrivateItem((Boolean)dbObject.get("privateItem"));
    
    return item;
  }
}
