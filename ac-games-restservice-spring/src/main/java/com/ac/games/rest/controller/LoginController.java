package com.ac.games.rest.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.User;
import com.ac.games.data.UserDetail;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.LoginData;
import com.ac.games.rest.data.LoginSuccessData;
import com.ac.games.rest.data.NewUserData;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object doLogin(@RequestBody LoginData loginData) {
    if (loginData == null)
      return new SimpleErrorData("Login Error", "There was no valid login data provided");
    if (loginData.getUserName() == null)
      return new SimpleErrorData("Login Error", "There was no login user name provided");
    if (loginData.getPassword() == null)
      return new SimpleErrorData("Login Error", "There was no login password provided");

    GamesDatabase database = null; 
    LoginSuccessData successData = new LoginSuccessData();
    
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      User user = database.readUser(loginData.getUserName());
      if (user == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Login Error", "There is no User with the user name " + loginData.getUserName() + " in the system");
      }
      
      UserDetail userDetail = database.readUserDetail(user.getUserID());
      if (userDetail == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Login Error", "There were problems with the user configuration");
      }
      
      if (userDetail.getPass().equals(loginData.getPassword())) {
        //Update the UserDetail record to reflect the current login date
        userDetail.setLastLoginDate(new Date());
        database.updateUserDetail(userDetail);
      } else {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Login Error", "The provided password does not match.");
      }
      
      successData.setUserID(user.getUserID());
      successData.setUserFirstName(user.getFirstName());
      switch (userDetail.getUserRole()) {
        case USER  : successData.setUserRole("User"); break;
        case ADMIN : successData.setUserRole("Admin"); break;
        default    : successData.setUserRole("None");
      }
      successData.setCollectionID(user.getCollectionID());
      
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
    
    return successData;
  }
  
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object updateLogin(@RequestParam(value="userid", defaultValue="-1") long userID,
                            @RequestBody NewUserData userData) {
    if (userID <= 0)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    if (userData == null)
      return new SimpleErrorData("User Data Error", "There was no valid User request data provided");
    if (userData.getUserName() == null)
      return new SimpleErrorData("User Data Error", "The change User request was missing a User Name");
    if (userData.getFirstName() == null)
      return new SimpleErrorData("User Data Error", "The change User request was missing a First Name");
    if (userData.getLastName() == null)
      return new SimpleErrorData("User Data Error", "The change User request was missing a Last Name");
    if (userData.getEmailAddress() == null)
      return new SimpleErrorData("User Data Error", "The change User request was missing an Email Address");
    if (userData.getPassword() == null)
      return new SimpleErrorData("User Data Error", "The change User request was missing a password");
    
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
        return new SimpleErrorData("User Already Exists", "This User Name already exists in the database");
      }
      if (!existUser.getUserName().equals(userData.getUserName())) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid Change Request", "The User Name Cannot Be Changed");
      }
      
      UserDetail userDetail = database.readUserDetail(userID);
      if (userDetail == null) {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Invalid User Error", "There were problems with the user configuration");
      }
      userDetail.setPass(userData.getPassword());
      database.updateUserDetail(userDetail);
      
      existUser.setFirstName(userData.getFirstName());
      existUser.setLastName(userData.getLastName());
      existUser.setEmailAddress(userData.getEmailAddress());
      database.updateUser(existUser);
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

    return new SimpleMessageData("Operation Successful", "The User Information for " + userData.getUserName() + " was updated.");
  }
}
