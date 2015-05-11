package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class encapsulates all the public data visible for a user. 
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  /** The userID for this user */
  private long   userID;
  /** The userName for this user */
  private String userName;
  /** The first name for the person */
  private String firstName;
  /** The last name for the person */
  private String lastName;
  /** The email address for this user */
  private String emailAddress;
  /** The users collection link.  This is created up front */
  private long   collectionID;

  /** The List of Playthru data for this user */
  //private List<PlaythruItem> playthroughs;
  /** The wishlist for this user. */
  //private List<WishlistItem> wishlist;
  
  public User() {
    userID       = -1;
    userName     = null;
    firstName    = null;
    lastName     = null;
    emailAddress = null;
    collectionID = -1;
  }
  
  public User(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      User jsonData = mapper.readValue(jsonString, User.class);
      userID       = jsonData.userID;
      userName     = jsonData.userName;
      firstName    = jsonData.firstName;
      lastName     = jsonData.lastName;
      emailAddress = jsonData.emailAddress;
      collectionID = jsonData.collectionID;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the userID
   */
  public long getUserID() {
    return userID;
  }

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {
    this.userID = userID;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the emailAddress
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * @return the collectionID
   */
  public long getCollectionID() {
    return collectionID;
  }

  /**
   * @param collectionID the collectionID to set
   */
  public void setCollectionID(long collectionID) {
    this.collectionID = collectionID;
  }
}
