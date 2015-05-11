package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is just a container for the bggID to help with Serialization.
 * 
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BGGIDOnlyData {

  /** The objectid for this game on bgg */
  private long bggID;
  
  public BGGIDOnlyData() {
    bggID = -1;
  }
  
  public BGGIDOnlyData(long bggID) {
    this.bggID = bggID;
  }

  public BGGIDOnlyData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      BGGIDOnlyData jsonData = mapper.readValue(jsonString, BGGIDOnlyData.class);
      bggID = jsonData.bggID;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the bggID
   */
  public long getBggID() {
    return bggID;
  }

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {
    this.bggID = bggID;
  }
}
