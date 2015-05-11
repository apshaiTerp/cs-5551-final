package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishlistItem implements Comparable<WishlistItem> {
  
  private long    wishID;
  private long    userID;
  private long    gameID;
  private Date    dateAdded;
  private boolean notifyUser;
  
  public WishlistItem() {
    wishID     = -1L;
    userID     = -1L;
    gameID     = -1L;
    dateAdded  = null;
    notifyUser = false;
  }
  
  public WishlistItem(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      WishlistItem jsonData = mapper.readValue(jsonString, WishlistItem.class);
      wishID       = jsonData.wishID;
      userID       = jsonData.userID;
      gameID       = jsonData.gameID;
      dateAdded    = jsonData.dateAdded;
      notifyUser   = jsonData.notifyUser;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the wishID
   */
  public long getWishID() {
    return wishID;
  }

  /**
   * @param wishID the wishID to set
   */
  public void setWishID(long wishID) {
    this.wishID = wishID;
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
   * @return the gameID
   */
  public long getGameID() {
    return gameID;
  }

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {
    this.gameID = gameID;
  }

  /**
   * @return the dateAdded
   */
  public Date getDateAdded() {
    return dateAdded;
  }

  /**
   * @param dateAdded the dateAdded to set
   */
  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }

  /**
   * @return the notifyUser
   */
  public boolean isNotifyUser() {
    return notifyUser;
  }

  /**
   * @param notifyUser the notifyUser to set
   */
  public void setNotifyUser(boolean notifyUser) {
    this.notifyUser = notifyUser;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(WishlistItem o) {
    return (int)(o.wishID - wishID);
  }
}
