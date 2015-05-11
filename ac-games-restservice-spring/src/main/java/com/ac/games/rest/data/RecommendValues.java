package com.ac.games.rest.data;

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
public class RecommendValues {

  private long   userID;
  private int    playerCount;
  private int    gameLength;
  private String gameWeight;
  private String mechanic;
  private int    recommendNum;
  
  public RecommendValues() {
    userID       = -1;
    playerCount  = -1;
    gameLength   = -1;
    gameWeight   = null;
    mechanic     = null;
    recommendNum = -1;
  }
  
  public RecommendValues(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      RecommendValues jsonData = mapper.readValue(jsonString, RecommendValues.class);
      userID       = jsonData.userID;
      playerCount  = jsonData.playerCount;
      gameLength   = jsonData.gameLength;
      gameWeight   = jsonData.gameWeight;
      mechanic     = jsonData.mechanic;
      recommendNum = jsonData.recommendNum;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * @return the userID
   */
  public long getUserID() {
    return userID;
  }

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {
    this.userID = userID;
  }

  /**
   * @return the playerCount
   */
  public int getPlayerCount() {
    return playerCount;
  }

  /**
   * @param playerCount the playerCount to set
   */
  public void setPlayerCount(int playerCount) {
    this.playerCount = playerCount;
  }

  /**
   * @return the gameLength
   */
  public int getGameLength() {
    return gameLength;
  }

  /**
   * @param gameLength the gameLength to set
   */
  public void setGameLength(int gameLength) {
    this.gameLength = gameLength;
  }

  /**
   * @return the gameWeight
   */
  public String getGameWeight() {
    return gameWeight;
  }

  /**
   * @param gameWeight the gameWeight to set
   */
  public void setGameWeight(String gameWeight) {
    this.gameWeight = gameWeight;
  }

  /**
   * @return the mechanic
   */
  public String getMechanic() {
    return mechanic;
  }

  /**
   * @param mechanic the mechanic to set
   */
  public void setMechanic(String mechanic) {
    this.mechanic = mechanic;
  }

  /**
   * @return the recommendNum
   */
  public int getRecommendNum() {
    return recommendNum;
  }

  /**
   * @param recommendNum the recommendNum to set
   */
  public void setRecommendNum(int recommendNum) {
    this.recommendNum = recommendNum;
  }
}
