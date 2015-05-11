package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is just a container for the mmID to help with Serialization.
 * 
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MMIDOnlyData {

  /** The objectid for this game on miniature market */
  private long mmID;
  
  public MMIDOnlyData() {
    mmID = -1;
  }
  
  public MMIDOnlyData(long mmID) {
    this.mmID = mmID;
  }
  
  public MMIDOnlyData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      MMIDOnlyData jsonData = mapper.readValue(jsonString, MMIDOnlyData.class);
      mmID = jsonData.mmID;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the mmID
   */
  public long getMmID() {
    return mmID;
  }

  /**
   * @param mmID the mmID to set
   */
  public void setMmID(long mmID) {
    this.mmID = mmID;
  }
}
