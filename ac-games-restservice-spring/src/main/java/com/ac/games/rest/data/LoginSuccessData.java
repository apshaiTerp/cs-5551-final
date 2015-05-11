package com.ac.games.rest.data;

import com.ac.games.rest.message.SimpleMessageData;

/**
 * We want to tack on a few extra fields to help identify the user on a successful login
 * 
 * @author ac010168
 */
public class LoginSuccessData extends SimpleMessageData {
  
  private long userID;
  private String userFirstName;
  private String userRole;
  private long collectionID;
  
  public LoginSuccessData() {
    super("Login Successful", "The Login Validated Successfully");  
    userID        = -1;
    userFirstName = null;
    userRole      = null;
    setCollectionID(-1);
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
   * @return the userFirstName
   */
  public String getUserFirstName() {
    return userFirstName;
  }

  /**
   * @param userFirstName the userFirstName to set
   */
  public void setUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
  }

  /**
   * @return the userRole
   */
  public String getUserRole() {
    return userRole;
  }

  /**
   * @param userRole the userRole to set
   */
  public void setUserRole(String userRole) {
    this.userRole = userRole;
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
