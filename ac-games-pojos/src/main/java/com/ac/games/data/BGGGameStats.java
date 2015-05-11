package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class BGGGameStats {
  
  public final static String BGG_GAME_STATS = "bggGameStats";

  private int baseGameCount;
  private int expansionGameCount;
  private int collectibleGameCount;
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public BGGGameStats() {
    baseGameCount        = 0;
    expansionGameCount   = 0;
    collectibleGameCount = 0;
    approvedCount        = 0;
    rejectedCount        = 0;
    pendingCount         = 0;
  }
  
  public BGGGameStats(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      BGGGameStats jsonData = mapper.readValue(jsonString, BGGGameStats.class);
      baseGameCount        = jsonData.baseGameCount;
      expansionGameCount   = jsonData.expansionGameCount;
      collectibleGameCount = jsonData.collectibleGameCount;
      approvedCount        = jsonData.approvedCount;
      rejectedCount        = jsonData.rejectedCount;
      pendingCount         = jsonData.pendingCount;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the baseGameCount
   */
  public int getBaseGameCount() {
    return baseGameCount;
  }

  /**
   * @param baseGameCount the baseGameCount to set
   */
  public void setBaseGameCount(int baseGameCount) {
    this.baseGameCount = baseGameCount;
  }

  /**
   * @return the expansionGameCount
   */
  public int getExpansionGameCount() {
    return expansionGameCount;
  }

  /**
   * @param expansionGameCount the expansionGameCount to set
   */
  public void setExpansionGameCount(int expansionGameCount) {
    this.expansionGameCount = expansionGameCount;
  }

  /**
   * @return the collectibleGameCount
   */
  public int getCollectibleGameCount() {
    return collectibleGameCount;
  }

  /**
   * @param collectibleGameCount the collectibleGameCount to set
   */
  public void setCollectibleGameCount(int collectibleGameCount) {
    this.collectibleGameCount = collectibleGameCount;
  }

  /**
   * @return the approvedCount
   */
  public int getApprovedCount() {
    return approvedCount;
  }

  /**
   * @param approvedCount the approvedCount to set
   */
  public void setApprovedCount(int approvedCount) {
    this.approvedCount = approvedCount;
  }

  /**
   * @return the rejectedCount
   */
  public int getRejectedCount() {
    return rejectedCount;
  }

  /**
   * @param rejectedCount the rejectedCount to set
   */
  public void setRejectedCount(int rejectedCount) {
    this.rejectedCount = rejectedCount;
  }

  /**
   * @return the pendingCount
   */
  public int getPendingCount() {
    return pendingCount;
  }

  /**
   * @param pendingCount the pendingCount to set
   */
  public void setPendingCount(int pendingCount) {
    this.pendingCount = pendingCount;
  }
}
