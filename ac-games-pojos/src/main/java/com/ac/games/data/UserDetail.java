package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class encapsulates all the data for users that should not be made visible.
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {
  
  /** The userID for this user */
  private long     userID;
  /** The user's password */
  private String   pass;
  /** The users role, based on {@link UserRole} */
  private UserRole userRole;
  /** The date when this user was created */
  private Date     createdOnDate;
  /** The last time this user logged in */
  private Date     lastLoginDate;

  public UserDetail() {
    userID        = -1;
    pass          = null;
    userRole      = null;
    createdOnDate = null;
    lastLoginDate = null;
  }
  
  public UserDetail(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      UserDetail jsonData = mapper.readValue(jsonString, UserDetail.class);
      userID        = jsonData.userID;
      pass          = jsonData.pass;
      userRole      = jsonData.userRole;
      createdOnDate = jsonData.createdOnDate;
      lastLoginDate = jsonData.lastLoginDate;
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
   * @return the pass
   */
  public String getPass() {
    return pass;
  }

  /**
   * @param pass the pass to set
   */
  public void setPass(String pass) {
    this.pass = pass;
  }

  /**
   * @return the userRole
   */
  public UserRole getUserRole() {
    return userRole;
  }

  /**
   * @param userRole the userRole to set
   */
  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  /**
   * @return the createdOnDate
   */
  public Date getCreatedOnDate() {
    return createdOnDate;
  }

  /**
   * @param createdOnDate the createdOnDate to set
   */
  public void setCreatedOnDate(Date createdOnDate) {
    this.createdOnDate = createdOnDate;
  }

  /**
   * @return the lastLoginDate
   */
  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  /**
   * @param lastLoginDate the lastLoginDate to set
   */
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }
}
