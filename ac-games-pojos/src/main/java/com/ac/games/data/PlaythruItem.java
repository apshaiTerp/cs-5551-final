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
public class PlaythruItem {

  private long    playthruID;
  private long    userID;
  private long    gameID;
  private String  gameName;
  private Date    datePlayed;
  private int     numPlayers;
  private String  winnerText;
  private String  playthruText;
  
  public PlaythruItem() {
    playthruID   = -1L;
    userID       = -1L;
    gameID       = -1L;
    gameName     = null;
    datePlayed   = null;
    numPlayers   = -1;
    winnerText   = null;
    playthruText = null;
  }
  
  public PlaythruItem(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      PlaythruItem jsonData = mapper.readValue(jsonString, PlaythruItem.class);
      playthruID   = jsonData.playthruID;
      userID       = jsonData.userID;
      gameID       = jsonData.gameID;
      gameName     = jsonData.gameName;
      datePlayed   = jsonData.datePlayed;
      numPlayers   = jsonData.numPlayers;
      winnerText   = jsonData.winnerText;
      playthruText = jsonData.playthruText;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the playthruID
   */
  public long getPlaythruID() {
    return playthruID;
  }

  /**
   * @param playthruID the playthruID to set
   */
  public void setPlaythruID(long playthruID) {
    this.playthruID = playthruID;
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
   * @return the gameName
   */
  public String getGameName() {
    return gameName;
  }

  /**
   * @param gameName the gameName to set
   */
  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  /**
   * @return the datePlayed
   */
  public Date getDatePlayed() {
    return datePlayed;
  }

  /**
   * @param datePlayed the datePlayed to set
   */
  public void setDatePlayed(Date datePlayed) {
    this.datePlayed = datePlayed;
  }

  /**
   * @return the numPlayers
   */
  public int getNumPlayers() {
    return numPlayers;
  }

  /**
   * @param numPlayers the numPlayers to set
   */
  public void setNumPlayers(int numPlayers) {
    this.numPlayers = numPlayers;
  }

  /**
   * @return the winnerText
   */
  public String getWinnerText() {
    return winnerText;
  }

  /**
   * @param winnerText the winnerText to set
   */
  public void setWinnerText(String winnerText) {
    this.winnerText = winnerText;
  }

  /**
   * @return the playthruText
   */
  public String getPlaythruText() {
    return playthruText;
  }

  /**
   * @param playthruText the playthruText to set
   */
  public void setPlaythruText(String playthruText) {
    this.playthruText = playthruText;
  }
}
