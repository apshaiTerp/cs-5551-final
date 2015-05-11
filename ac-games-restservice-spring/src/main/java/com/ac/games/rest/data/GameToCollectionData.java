package com.ac.games.rest.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameToCollectionData {
  
  private long gameID;
  private long userID;
  
  public GameToCollectionData() {
    gameID = -1;
    userID = -1;
  }

  public GameToCollectionData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      GameToCollectionData jsonData = mapper.readValue(jsonString, GameToCollectionData.class);
      setGameID(jsonData.getGameID());
      setUserID(jsonData.getUserID());
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
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
}
