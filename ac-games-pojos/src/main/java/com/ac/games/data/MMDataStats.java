package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author ac010168
 *
 */
public class MMDataStats {

  public final static String MM_DATA_STATS = "mmDataStats";

  private int boardGameCount;
  private int tableTopCount;
  private int ccgCount;
  private int collectiblesCount;
  private int rpgCount;
  private int lcgCount;
  private int accessoriesCount;
  private int unknownCount;
  
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public MMDataStats() {
    boardGameCount    = 0;
    tableTopCount     = 0;
    ccgCount          = 0;
    lcgCount          = 0;
    collectiblesCount = 0;
    rpgCount          = 0;
    accessoriesCount  = 0;
    unknownCount      = 0;
    approvedCount     = 0;
    rejectedCount     = 0;
    pendingCount      = 0;
  }
  
  public MMDataStats(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      MMDataStats jsonData = mapper.readValue(jsonString, MMDataStats.class);
      boardGameCount    = jsonData.boardGameCount;
      tableTopCount     = jsonData.tableTopCount;
      ccgCount          = jsonData.ccgCount;
      lcgCount          = jsonData.lcgCount;
      collectiblesCount = jsonData.collectiblesCount;
      rpgCount          = jsonData.rpgCount;
      accessoriesCount  = jsonData.accessoriesCount;
      unknownCount      = jsonData.unknownCount;
      approvedCount     = jsonData.approvedCount;
      rejectedCount     = jsonData.rejectedCount;
      pendingCount      = jsonData.pendingCount;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the boardGameCount
   */
  public int getBoardGameCount() {
    return boardGameCount;
  }

  /**
   * @param boardGameCount the boardGameCount to set
   */
  public void setBoardGameCount(int boardGameCount) {
    this.boardGameCount = boardGameCount;
  }

  /**
   * @return the tableTopCount
   */
  public int getTableTopCount() {
    return tableTopCount;
  }

  /**
   * @param tableTopCount the tableTopCount to set
   */
  public void setTableTopCount(int tableTopCount) {
    this.tableTopCount = tableTopCount;
  }

  /**
   * @return the ccgCount
   */
  public int getCcgCount() {
    return ccgCount;
  }

  /**
   * @param ccgCount the ccgCount to set
   */
  public void setCcgCount(int ccgCount) {
    this.ccgCount = ccgCount;
  }

  /**
   * @return the collectiblesCount
   */
  public int getCollectiblesCount() {
    return collectiblesCount;
  }

  /**
   * @param collectiblesCount the collectiblesCount to set
   */
  public void setCollectiblesCount(int collectiblesCount) {
    this.collectiblesCount = collectiblesCount;
  }

  /**
   * @return the rpgCount
   */
  public int getRpgCount() {
    return rpgCount;
  }

  /**
   * @param rpgCount the rpgCount to set
   */
  public void setRpgCount(int rpgCount) {
    this.rpgCount = rpgCount;
  }

  /**
   * @return the accessoriesCount
   */
  public int getAccessoriesCount() {
    return accessoriesCount;
  }

  /**
   * @param accessoriesCount the accessoriesCount to set
   */
  public void setAccessoriesCount(int accessoriesCount) {
    this.accessoriesCount = accessoriesCount;
  }

  /**
   * @return the unknownCount
   */
  public int getUnknownCount() {
    return unknownCount;
  }

  /**
   * @param unknownCount the unknownCount to set
   */
  public void setUnknownCount(int unknownCount) {
    this.unknownCount = unknownCount;
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

  /**
   * @return the lcgCount
   */
  public int getLcgCount() {
    return lcgCount;
  }

  /**
   * @param lcgCount the lcgCount to set
   */
  public void setLcgCount(int lcgCount) {
    this.lcgCount = lcgCount;
  }
}
