package com.ac.games.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class CollectionItem implements Comparable<CollectionItem> {
  
  /** The itemID for this collection item */
  private long             itemID;
  /** The gameID of the game that this item represents */
  private long             gameID;
  /** The reference to the game object we want */
  private Game             game;
  /** The list of custom weights assigned by the user to this game */
  private List<GameWeight> weights;
  /** The date the user acquired this game */
  private Date             dateAcquired;
  /** The date when this game was acquired */
  private String           whereAcquired;
  
  //Override fields to replace the basic game numbers (increased player count, etc)
  /** The substitiute value for the minimum player count */
  private int              overrideMinPlayers;
  /** The substitiute value for the maximum player count */
  private int              overrideMaxPlayers;
  /** The substitiute value for the minimum playing time */
  private int              overrideMinTime;
  /** The substitiute value for the maximum playing time */
  private int              overrideMaxTime;
  
  /** Helper list to help render expansions in the collections view */
  private List<CompactSearchData> expansionList;
  
  public CollectionItem() {
    itemID        = -1;
    gameID        = -1;
    game          = null;
    weights       = null;
    dateAcquired  = null;
    whereAcquired = null;
    
    overrideMinPlayers = -1;
    overrideMaxPlayers = -1;
    overrideMinTime    = -1;
    overrideMaxTime    = -1;
    
    expansionList      = new ArrayList<CompactSearchData>();
  }
  
  public CollectionItem(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      CollectionItem jsonData = mapper.readValue(jsonString, CollectionItem.class);
      itemID        = jsonData.itemID;
      gameID        = jsonData.gameID;
      game          = jsonData.game;
      weights       = jsonData.weights;
      dateAcquired  = jsonData.dateAcquired;
      whereAcquired = jsonData.whereAcquired;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the itemID
   */
  public long getItemID() {
    return itemID;
  }

  /**
   * @param itemID the itemID to set
   */
  public void setItemID(long itemID) {
    this.itemID = itemID;
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
   * @return the weights
   */
  public List<GameWeight> getWeights() {
    return weights;
  }

  /**
   * @param weights the weights to set
   */
  public void setWeights(List<GameWeight> weights) {
    this.weights = weights;
  }

  /**
   * @return the dateAcquired
   */
  public Date getDateAcquired() {
    return dateAcquired;
  }

  /**
   * @param dateAcquired the dateAcquired to set
   */
  public void setDateAcquired(Date dateAcquired) {
    this.dateAcquired = dateAcquired;
  }

  /**
   * @return the whereAcquired
   */
  public String getWhereAcquired() {
    return whereAcquired;
  }

  /**
   * @param whereAcquired the whereAcquired to set
   */
  public void setWhereAcquired(String whereAcquired) {
    this.whereAcquired = whereAcquired;
  }

  /**
   * @return the game
   */
  public Game getGame() {
    return game;
  }

  /**
   * @param game the game to set
   */
  public void setGame(Game game) {
    this.game = game;
  }

  /**
   * We want reverse Sort order, so prioritize it that way.
   */
  public int compareTo(CollectionItem o) {
    return (int)(o.itemID - itemID);
  }

  /**
   * @return the overrideMinPlayers
   */
  public int getOverrideMinPlayers() {
    return overrideMinPlayers;
  }

  /**
   * @param overrideMinPlayers the overrideMinPlayers to set
   */
  public void setOverrideMinPlayers(int overrideMinPlayers) {
    this.overrideMinPlayers = overrideMinPlayers;
  }

  /**
   * @return the overrideMaxPlayers
   */
  public int getOverrideMaxPlayers() {
    return overrideMaxPlayers;
  }

  /**
   * @param overrideMaxPlayers the overrideMaxPlayers to set
   */
  public void setOverrideMaxPlayers(int overrideMaxPlayers) {
    this.overrideMaxPlayers = overrideMaxPlayers;
  }

  /**
   * @return the overrideMinTime
   */
  public int getOverrideMinTime() {
    return overrideMinTime;
  }

  /**
   * @param overrideMinTime the overrideMinTime to set
   */
  public void setOverrideMinTime(int overrideMinTime) {
    this.overrideMinTime = overrideMinTime;
  }

  /**
   * @return the overrideMaxTime
   */
  public int getOverrideMaxTime() {
    return overrideMaxTime;
  }

  /**
   * @param overrideMaxTime the overrideMaxTime to set
   */
  public void setOverrideMaxTime(int overrideMaxTime) {
    this.overrideMaxTime = overrideMaxTime;
  }

  /**
   * @return the expansionList
   */
  public List<CompactSearchData> getExpansionList() {
    return expansionList;
  }

  /**
   * @param expansionList the expansionList to set
   */
  public void setExpansionList(List<CompactSearchData> expansionList) {
    this.expansionList = expansionList;
  }
}
