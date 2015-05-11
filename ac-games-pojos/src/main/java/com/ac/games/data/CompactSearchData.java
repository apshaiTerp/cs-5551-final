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
public class CompactSearchData {
  
  /** The string that should be displayed in the auto-complete or quick search window */
  private String displayString;
  /** The source field (typically the mongo field name, like bggID, of this ID value */
  private String sourceField;
  /** The actual ID value for the corresponding object */
  private long   sourceID;
  /** The thumbnail image used to create a small image for this object */
  private String thumbnailURL;

  public CompactSearchData() {
    displayString = null;
    sourceField   = null;
    sourceID      = -1L;
    thumbnailURL  = null;
  }
  
  public CompactSearchData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      CompactSearchData data = mapper.readValue(jsonString, CompactSearchData.class);
      displayString = data.displayString;
      sourceField   = data.sourceField;
      sourceID      = data.sourceID;
      thumbnailURL  = data.thumbnailURL;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the displayString
   */
  public String getDisplayString() {
    return displayString;
  }

  /**
   * @param displayString the displayString to set
   */
  public void setDisplayString(String displayString) {
    this.displayString = displayString;
  }

  /**
   * @return the sourceField
   */
  public String getSourceField() {
    return sourceField;
  }

  /**
   * @param sourceField the sourceField to set
   */
  public void setSourceField(String sourceField) {
    this.sourceField = sourceField;
  }

  /**
   * @return the sourceID
   */
  public long getSourceID() {
    return sourceID;
  }

  /**
   * @param sourceID the sourceID to set
   */
  public void setSourceID(long sourceID) {
    this.sourceID = sourceID;
  }

  /**
   * @return the thumbnailURL
   */
  public String getThumbnailURL() {
    return thumbnailURL;
  }

  /**
   * @param thumbnailURL the thumbnailURL to set
   */
  public void setThumbnailURL(String thumbnailURL) {
    this.thumbnailURL = thumbnailURL;
  }
}
