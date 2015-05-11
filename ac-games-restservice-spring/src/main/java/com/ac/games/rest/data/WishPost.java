package com.ac.games.rest.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishPost {
  
  private long userID;
  private long gameID;
  
  public WishPost() {
    userID = -1;
    gameID = -1;
  }

  public WishPost(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      WishPost jsonData = mapper.readValue(jsonString, WishPost.class);
      this.userID = jsonData.userID;
      this.gameID = jsonData.gameID;
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
}
