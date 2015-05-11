package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.WishlistItem;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class WishlistItemConverter {

  /**
   * Helper method that will construct a basic query using the itemID from the provided wishlist item.
   * 
   * @param item The WishlistItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertWishlistItemToIDQuery(WishlistItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("wishID", item.getWishID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userID from the provided wishlist item.
   * 
   * @param wishID The WishlistItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertWishlistItemToIDQuery(long wishID) {
    if (wishID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("wishID", wishID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertWishlistItemToMongo(WishlistItem item) {
    if (item == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("wishID", item.getWishID());
    if (item.getUserID() >= -1)      dbObject.append("userID", item.getUserID());
    if (item.getGameID() >= -1)      dbObject.append("gameID", item.getGameID());
    if (item.getDateAdded() != null) dbObject.append("dateAdded", item.getDateAdded());
    dbObject.append("notifyUser", item.isNotifyUser());
    
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link WishlistItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link WishlistItem} object, or null if the dbObject was null
   */
  public static WishlistItem convertMongoToWishlistItem(DBObject dbObject) {
    if (dbObject == null) return null;
    
    WishlistItem item = new WishlistItem();
    if (dbObject.containsField("wishID"))     item.setWishID((Long)dbObject.get("wishID"));
    if (dbObject.containsField("userID"))     item.setUserID((Long)dbObject.get("userID"));
    if (dbObject.containsField("gameID"))     item.setGameID((Long)dbObject.get("gameID"));
    if (dbObject.containsField("dateAdded"))  item.setDateAdded((Date)dbObject.get("dateAdded"));
    if (dbObject.containsField("notifyUser")) item.setNotifyUser((Boolean)dbObject.get("notifyUser"));
    return item;
  }
}
