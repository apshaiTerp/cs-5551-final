package com.ac.games.db.mongo;

import com.ac.games.data.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class UserConverter {

  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToIDQuery(User user) {
    if (user == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param userID The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToIDQuery(long userID) {
    if (userID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", userID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userName from the provided user.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToNameQuery(User user) {
    if (user == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userName", user.getUserName());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userName from the provided user.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToNameQuery(String userName) {
    if (userName == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userName", userName);
    return dbObject;
  }
  
  
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertUserToMongo(User user) {
    if (user == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    if (user.getUserName() != null)     dbObject.append("userName", user.getUserName());
    if (user.getFirstName() != null)    dbObject.append("firstName", user.getFirstName());
    if (user.getLastName() != null)     dbObject.append("lastName", user.getLastName());
    if (user.getEmailAddress() != null) dbObject.append("emailAddress", user.getEmailAddress());
    if (user.getCollectionID() != -1)   dbObject.append("collectionID", user.getCollectionID());
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link User} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link User} object, or null if the dbObject was null
   */
  public static User convertMongoToUser(DBObject dbObject) {
    if (dbObject == null) return null;
    
    User user = new User();
    if (dbObject.containsField("userID"))       user.setUserID((Long)dbObject.get("userID"));
    if (dbObject.containsField("userName"))     user.setUserName((String)dbObject.get("userName"));
    if (dbObject.containsField("firstName"))    user.setFirstName((String)dbObject.get("firstName"));
    if (dbObject.containsField("lastName"))     user.setLastName((String)dbObject.get("lastName"));
    if (dbObject.containsField("emailAddress")) user.setEmailAddress((String)dbObject.get("emailAddress"));
    if (dbObject.containsField("collectionID")) user.setCollectionID((Long)dbObject.get("collectionID"));
    
    return user;
  }
}
