package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class CSIDataStats {
  
  public final static String CSI_DATA_STATS = "csiDataStats";

  private int boardGameCount;
  private int collectibleGameCount;
  private int diceMastersCount;
  private int rpgCount;
  private int lcgCount;
  private int suppliesCount;
  private int miniatureCount;
  private int videoGameCount;
  private int unknownCount;
  
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public CSIDataStats() {
    boardGameCount       = 0;
    collectibleGameCount = 0;
    diceMastersCount     = 0;
    rpgCount             = 0;
    lcgCount             = 0;
    suppliesCount        = 0;
    miniatureCount       = 0;
    videoGameCount       = 0;
    unknownCount         = 0;
    approvedCount        = 0;
    rejectedCount        = 0;
    pendingCount         = 0;
  }
  
  public CSIDataStats(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      CSIDataStats jsonData = mapper.readValue(jsonString, CSIDataStats.class);
      boardGameCount       = jsonData.boardGameCount;
      collectibleGameCount = jsonData.collectibleGameCount;
      diceMastersCount     = jsonData.diceMastersCount;
      rpgCount             = jsonData.rpgCount;
      lcgCount             = jsonData.lcgCount;
      suppliesCount        = jsonData.suppliesCount;
      miniatureCount       = jsonData.miniatureCount;
      videoGameCount       = jsonData.videoGameCount;
      unknownCount         = jsonData.unknownCount;
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
   * @return the diceMastersCount
   */
  public int getDiceMastersCount() {
    return diceMastersCount;
  }

  /**
   * @param diceMastersCount the diceMastersCount to set
   */
  public void setDiceMastersCount(int diceMastersCount) {
    this.diceMastersCount = diceMastersCount;
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

  /**
   * @return the suppliesCount
   */
  public int getSuppliesCount() {
    return suppliesCount;
  }

  /**
   * @param suppliesCount the suppliesCount to set
   */
  public void setSuppliesCount(int suppliesCount) {
    this.suppliesCount = suppliesCount;
  }

  /**
   * @return the miniatureCount
   */
  public int getMiniatureCount() {
    return miniatureCount;
  }

  /**
   * @param miniatureCount the miniatureCount to set
   */
  public void setMiniatureCount(int miniatureCount) {
    this.miniatureCount = miniatureCount;
  }

  /**
   * @return the videoGameCount
   */
  public int getVideoGameCount() {
    return videoGameCount;
  }

  /**
   * @param videoGameCount the videoGameCount to set
   */
  public void setVideoGameCount(int videoGameCount) {
    this.videoGameCount = videoGameCount;
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
}
