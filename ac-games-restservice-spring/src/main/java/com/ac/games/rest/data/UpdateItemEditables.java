package com.ac.games.rest.data;

import java.io.IOException;
import java.util.List;

import com.ac.games.data.GameWeight;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateItemEditables {

  private String overrideMinPlayers;
  private String overrideMaxPlayers;
  private String overrideMinTime;
  private String overrideMaxTime;
  private String overrideWhere;
  private List<GameWeight> gameWeights;
  
  public UpdateItemEditables() {
    overrideMinPlayers = null;
    overrideMaxPlayers = null;
    overrideMinTime    = null;
    overrideMaxTime    = null;
    overrideWhere      = null;
    gameWeights        = null;
  }
  
  public UpdateItemEditables(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      UpdateItemEditables jsonData = mapper.readValue(jsonString, UpdateItemEditables.class);
      overrideMinPlayers = jsonData.overrideMinPlayers;
      overrideMaxPlayers = jsonData.overrideMaxPlayers;
      overrideMinTime    = jsonData.overrideMinTime;
      overrideMaxTime    = jsonData.overrideMaxTime;
      overrideWhere      = jsonData.overrideWhere;
      gameWeights        = jsonData.gameWeights;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the overrideMinPlayers
   */
  public String getOverrideMinPlayers() {
    return overrideMinPlayers;
  }

  /**
   * @param overrideMinPlayers the overrideMinPlayers to set
   */
  public void setOverrideMinPlayers(String overrideMinPlayers) {
    this.overrideMinPlayers = overrideMinPlayers;
  }

  /**
   * @return the overrideMaxPlayers
   */
  public String getOverrideMaxPlayers() {
    return overrideMaxPlayers;
  }

  /**
   * @param overrideMaxPlayers the overrideMaxPlayers to set
   */
  public void setOverrideMaxPlayers(String overrideMaxPlayers) {
    this.overrideMaxPlayers = overrideMaxPlayers;
  }

  /**
   * @return the overrideMinTime
   */
  public String getOverrideMinTime() {
    return overrideMinTime;
  }

  /**
   * @param overrideMinTime the overrideMinTime to set
   */
  public void setOverrideMinTime(String overrideMinTime) {
    this.overrideMinTime = overrideMinTime;
  }

  /**
   * @return the overrideMaxTime
   */
  public String getOverrideMaxTime() {
    return overrideMaxTime;
  }

  /**
   * @param overrideMaxTime the overrideMaxTime to set
   */
  public void setOverrideMaxTime(String overrideMaxTime) {
    this.overrideMaxTime = overrideMaxTime;
  }

  /**
   * @return the overrideWhere
   */
  public String getOverrideWhere() {
    return overrideWhere;
  }

  /**
   * @param overrideWhere the overrideWhere to set
   */
  public void setOverrideWhere(String overrideWhere) {
    this.overrideWhere = overrideWhere;
  }

  /**
   * @return the gameWeights
   */
  public List<GameWeight> getGameWeights() {
    return gameWeights;
  }

  /**
   * @param gameWeights the gameWeights to set
   */
  public void setGameWeights(List<GameWeight> gameWeights) {
    this.gameWeights = gameWeights;
  }
}
