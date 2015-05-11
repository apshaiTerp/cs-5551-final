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
public class CompactPriceData {
  
  /** The title text for the media item */
  private String titleDisplay;
  /** The price Information to be displayed */
  private String priceDisplay;
  /** The link to open the vendor site */
  private String linkURL;
  /** The thumbnail image used to create a small image for this object */
  private String thumbnailURL;

  public CompactPriceData() {
    titleDisplay = null;
    priceDisplay = null;
    linkURL      = null;
    thumbnailURL = null;
  }
  
  public CompactPriceData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      CompactPriceData data = mapper.readValue(jsonString, CompactPriceData.class);
      titleDisplay = data.titleDisplay;
      priceDisplay = data.priceDisplay;
      linkURL      = data.linkURL;
      thumbnailURL = data.thumbnailURL;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the titleDisplay
   */
  public String getTitleDisplay() {
    return titleDisplay;
  }

  /**
   * @param titleDisplay the titleDisplay to set
   */
  public void setTitleDisplay(String titleDisplay) {
    this.titleDisplay = titleDisplay;
  }

  /**
   * @return the priceDisplay
   */
  public String getPriceDisplay() {
    return priceDisplay;
  }

  /**
   * @param priceDisplay the priceDisplay to set
   */
  public void setPriceDisplay(String priceDisplay) {
    this.priceDisplay = priceDisplay;
  }

  /**
   * @return the linkURL
   */
  public String getLinkURL() {
    return linkURL;
  }

  /**
   * @param linkURL the linkURL to set
   */
  public void setLinkURL(String linkURL) {
    this.linkURL = linkURL;
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
