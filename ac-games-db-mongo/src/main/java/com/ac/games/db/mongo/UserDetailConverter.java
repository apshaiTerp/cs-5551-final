package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.UserDetail;
import com.ac.games.data.UserRoleConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class UserDetailConverter {

  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param user The UserDetail we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserDetailToIDQuery(UserDetail user) {
    if (user == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param userID The UserDetail we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserDetailToIDQuery(long userID) {
    if (userID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", userID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertUserDetailToMongo(UserDetail user) {
    if (user == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    if (user.getPass() != null)          dbObject.append("pass", user.getPass());
    if (user.getUserRole() != null)      dbObject.append("userRole", UserRoleConverter.convertUserRoleToFlag(user.getUserRole()));
    if (user.getCreatedOnDate() != null) dbObject.append("createdOnDate", user.getCreatedOnDate());
    if (user.getLastLoginDate() != null) dbObject.append("lastLoginDate", user.getLastLoginDate());
    
    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link UserDetail} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link UserDetail} object, or null if the dbObject was null
   */
  public static UserDetail convertMongoToUserDetail(DBObject dbObject) {
    if (dbObject == null) return null;
    
    UserDetail user = new UserDetail();
    if (dbObject.containsField("userID"))        user.setUserID((Long)dbObject.get("userID"));
    if (dbObject.containsField("pass"))          user.setPass((String)dbObject.get("pass"));
    if (dbObject.containsField("userRole"))      user.setUserRole(UserRoleConverter.convertFlagToUserRole((Integer)dbObject.get("userRole")));
    if (dbObject.containsField("createdOnDate")) user.setCreatedOnDate((Date)dbObject.get("createdOnDate"));
    if (dbObject.containsField("lastLoginDate")) user.setLastLoginDate((Date)dbObject.get("lastLoginDate"));
    return user;
  }
}
