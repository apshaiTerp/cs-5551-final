package com.ac.games.data;

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
public class GameIDOnlyData {

  private long gameID;
  
  public GameIDOnlyData() {
    setGameID(-1);
  }
  
  public GameIDOnlyData(long gameID) {
    this.gameID = gameID;
  }
  
  public GameIDOnlyData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      GameIDOnlyData jsonData = mapper.readValue(jsonString, GameIDOnlyData.class);
      gameID = jsonData.gameID;
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
}
