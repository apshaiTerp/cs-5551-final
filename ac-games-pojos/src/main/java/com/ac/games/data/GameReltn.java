package com.ac.games.data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameReltn {
  
  private long         reltnID;
  private long         gameID;
  private long         bggID;
  private List<Long>   csiIDs;
  private List<Long>   mmIDs;
  private List<String> asinKeys;
  private List<Long>   otherSites;

  public GameReltn() {
    reltnID    = -1L;
    gameID     = -1L;
    bggID      = -1L;
    csiIDs     = null;
    mmIDs      = null;
    asinKeys   = null;
    otherSites = null;
  }
  
  public GameReltn(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      GameReltn jsonData = mapper.readValue(jsonString, GameReltn.class);
      reltnID    = jsonData.reltnID;
      gameID     = jsonData.gameID;
      bggID      = jsonData.bggID;
      csiIDs     = jsonData.csiIDs;
      mmIDs      = jsonData.mmIDs;
      asinKeys   = jsonData.asinKeys;
      otherSites = jsonData.otherSites;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  
  public void printContentsForDebug() {
    System.out.println ("Printing contents for GameReltn ID " + getReltnID());
    System.out.println ("============================================================");
    System.out.println ("Game ID:             " + (gameID == -1L ? "-" : getGameID()));
    System.out.println ("BoardGameGeek ID:    " + (bggID == -1L ? "-" : getBggID()));
    
    if (getCsiIDs() != null) {
      System.out.println ("CoolStuffInc IDs:    [" + csiIDs.size() + "]");
      for (long csiID : csiIDs)
        System.out.println ("                     " + csiID);
    } else System.out.println ("CoolStuffInc IDs:    [-]");

    if (getMmIDs() != null) {
      System.out.println ("MiniatureMarket IDs: [" + mmIDs.size() + "]");
      for (long mmID : mmIDs)
        System.out.println ("                     " + mmID);
    } else System.out.println ("MiniatureMarket IDs: [-]");

    if (getAsinKeys() != null) {
      System.out.println ("AsinKeys:            [" + asinKeys.size() + "]");
      for (String asinKey : asinKeys)
        System.out.println ("                     " + asinKey);
    } else System.out.println ("AsinKeys:            [-]");
    
    if (getOtherSites() != null) {
      System.out.println ("Other Sites:         [" + otherSites.size() + "]");
      for (long site : otherSites)
        System.out.println ("                     " + site);
    } else System.out.println ("Other Sites:         [-]");
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

  /**
   * @return the csiIDs
   */
  public List<Long> getCsiIDs() {
    return csiIDs;
  }

  /**
   * @param csiIDs the csiIDs to set
   */
  public void setCsiIDs(List<Long> csiIDs) {
    this.csiIDs = csiIDs;
  }

  /**
   * @return the mmIDs
   */
  public List<Long> getMmIDs() {
    return mmIDs;
  }

  /**
   * @param mmIDs the mmIDs to set
   */
  public void setMmIDs(List<Long> mmIDs) {
    this.mmIDs = mmIDs;
  }

  /**
   * @return the asinKeys
   */
  public List<String> getAsinKeys() {
    return asinKeys;
  }

  /**
   * @param asinKeys the asinKeys to set
   */
  public void setAsinKeys(List<String> asinKeys) {
    this.asinKeys = asinKeys;
  }

  /**
   * @return the otherSites
   */
  public List<Long> getOtherSites() {
    return otherSites;
  }

  /**
   * @param otherSites the otherSites to set
   */
  public void setOtherSites(List<Long> otherSites) {
    this.otherSites = otherSites;
  }
}
