package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class MediaItem {

  private long          mediaID;
  private long          gameID;
  private long          userID;
  private String        userName;
  private MediaItemType itemType;
  private String        mediaLink;
  private String        mediaDescription;
  private Date          addedDate;
  private boolean       privateItem;
  
  public MediaItem() {
    mediaID          = -1L;
    gameID           = -1L;
    userID           = -1L;
    userName         = null;
    itemType         = null;
    mediaLink        = null;
    mediaDescription = null;
    addedDate        = null;
    privateItem      = true;
  }
  
  public MediaItem(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      MediaItem jsonData = mapper.readValue(jsonString, MediaItem.class);
      mediaID          = jsonData.mediaID;
      gameID           = jsonData.gameID;
      userID           = jsonData.userID;
      userName         = jsonData.userName;
      itemType         = jsonData.itemType;
      mediaLink        = jsonData.mediaLink;
      mediaDescription = jsonData.mediaDescription;
      addedDate        = jsonData.addedDate;
      privateItem      = jsonData.privateItem;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the mediaID
   */
  public long getMediaID() {
    return mediaID;
  }

  /**
   * @param mediaID the mediaID to set
   */
  public void setMediaID(long mediaID) {
    this.mediaID = mediaID;
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
   * @return the itemType
   */
  public MediaItemType getItemType() {
    return itemType;
  }

  /**
   * @param itemType the itemType to set
   */
  public void setItemType(MediaItemType itemType) {
    this.itemType = itemType;
  }

  /**
   * @return the mediaLink
   */
  public String getMediaLink() {
    return mediaLink;
  }

  /**
   * @param mediaLink the mediaLink to set
   */
  public void setMediaLink(String mediaLink) {
    this.mediaLink = mediaLink;
  }

  /**
   * @return the mediaDescription
   */
  public String getMediaDescription() {
    return mediaDescription;
  }

  /**
   * @param mediaDescription the mediaDescription to set
   */
  public void setMediaDescription(String mediaDescription) {
    this.mediaDescription = mediaDescription;
  }

  /**
   * @return the addedDate
   */
  public Date getAddedDate() {
    return addedDate;
  }

  /**
   * @param addedDate the addedDate to set
   */
  public void setAddedDate(Date addedDate) {
    this.addedDate = addedDate;
  }

  /**
   * @return the privateItem
   */
  public boolean isPrivateItem() {
    return privateItem;
  }

  /**
   * @param privateItem the privateItem to set
   */
  public void setPrivateItem(boolean privateItem) {
    this.privateItem = privateItem;
  }
}
