package com.ac.games.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.User;
import com.ac.games.data.UserDetail;
import com.ac.games.data.UserRole;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.NewUserData;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
  
  /**
   * Simple GET Request for a User.  This request can use either the userID or userName, but will
   * prefer userID.
   * 
   * @param userID   The userID.  This is optional, but at least one param must be provided
   * @param userName The userName.  This is optional, but at least one param must be provided
   * 
   * @return A {@link User} object or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getUser(@RequestParam(value="userid", defaultValue="-1") long userID,
                        @RequestParam(value="username", defaultValue="") String userName) {
    if ((userID <= 0) && (userName.trim().length() == 0))
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    
    GamesDatabase database = null; 
    User user              = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (userID > 0) user = database.readUser(userID);
      else user = database.readUser(userName);
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
    
    if (user == null)
      return new SimpleErrorData("User Not Found", "The requested user could not be found in the database.");
    return user;
  }
  
  /**
   * A simple PUT command to update the user.  This will update all fields for a user, but
   * the userID cannot be changed.  This value must match the param userID.
   * 
   * @param userID The userID we intend to update.  This is required
   * @param user   The user data we want to update.  This is required.
   * 
   * @return a {@link SimpleMessageData} indicating the operation succeeded, or a {@link SimpleErrorData} 
   * indicating it failed.
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putUser(@RequestParam(value="userid", defaultValue="-1") long userID,
                        @RequestBody User user) {
    if (userID <= 0)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    if (user == null)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    if (userID != user.getUserID())
      return new SimpleErrorData("User Data Error", "The userID parameter and userID value of the RequestBody do not match");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.updateUser(user);
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
   * This POST command has the job of not only validating that the user can be created, but of creating
   * the corresponding Collection and UserDetail records as well that are associated to this new user.
   * 
   * @param userData The provided content needed to create a user.  All fields must be filled out.
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postUser(@RequestBody NewUserData userData) {
    if (userData == null)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    if (userData.getUserName() == null)
      return new SimpleErrorData("User Data Error", "The new User request was missing a User Name");
    if (userData.getFirstName() == null)
      return new SimpleErrorData("User Data Error", "The new User request was missing a First Name");
    if (userData.getLastName() == null)
      return new SimpleErrorData("User Data Error", "The new User request was missing a Last Name");
    if (userData.getEmailAddress() == null)
      return new SimpleErrorData("User Data Error", "The new User request was missing an Email Address");
    if (userData.getPassword() == null)
      return new SimpleErrorData("User Data Error", "The new User request was missing a password");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //First we need to see if this user exists.  If it does, reject the request.
      User existUser = database.readUser(userData.getUserName());
      if (existUser != null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("User Already Exists", "This User Name already exists in the database");
      }
      
      //Pop our sequence values
      long newUserID       = database.getMaxUserID() + 1;
      long newCollectionID = database.getMaxCollectionID() + 1;
      
      Collection newCollection = new Collection();
      newCollection.setCollectionID(newCollectionID);
      
      User newUser = new User();
      newUser.setUserID(newUserID);
      newUser.setUserName(userData.getUserName());
      newUser.setFirstName(userData.getFirstName());
      newUser.setLastName(userData.getLastName());
      newUser.setEmailAddress(userData.getEmailAddress());
      newUser.setCollectionID(newCollectionID);
      
      UserDetail newUserDetail = new UserDetail();
      newUserDetail.setUserID(newUserID);
      newUserDetail.setPass(userData.getPassword());
      newUserDetail.setUserRole(UserRole.USER);
      newUserDetail.setCreatedOnDate(new Date());

      //We'll insert the three data items now
      database.insertUserDetail(newUserDetail);
      database.insertUser(newUser);
      database.insertCollection(newCollection);
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

    return new SimpleMessageData("Operation Successful", "The New User " + userData.getUserName() + " was created.");
  }

  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteUser(@RequestParam(value="userid", defaultValue="-1") long userID) {
    if (userID <= 0)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");

    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //First we need to see if this user exists.  If it does, reject the request.
      User existUser = database.readUser(userID);
      if (existUser == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("No Such User", "No User with this ID Exists");
      }
      
      //We need to then delete all the dependent items, including collections and collection items.
      Collection deleteCollection = database.readCollection(existUser.getCollectionID());
      List<CollectionItem> deleteItems = deleteCollection.getGames();
      for (CollectionItem item : deleteItems) 
        database.deleteCollectionItem(item.getItemID());
      database.deleteCollection(deleteCollection.getCollectionID());
      database.deleteUserDetail(userID);
      database.deleteUser(userID);
      
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
