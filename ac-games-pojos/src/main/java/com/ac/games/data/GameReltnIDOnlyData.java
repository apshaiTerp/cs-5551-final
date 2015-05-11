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
public class GameReltnIDOnlyData {

  private long reltnID;
  
  public GameReltnIDOnlyData() {
    reltnID = -1;
  }
  
  public GameReltnIDOnlyData(long reltnID) {
    this.reltnID = reltnID;
  }

  public GameReltnIDOnlyData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      GameReltnIDOnlyData jsonData = mapper.readValue(jsonString, GameReltnIDOnlyData.class);
      reltnID = jsonData.reltnID;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  
  /**
   * @return the reltnID
   */
  public long getReltnID() {
    return reltnID;
  }

  /**
   * @param reltnID the reltnID to set
   */
  public void setReltnID(long reltnID) {
    this.reltnID = reltnID;
  }
}
