package com.ac.games.data;

import java.io.IOException;
import java.util.LinkedList;
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
public class Collection {
  
  /**  */
  private long                 collectionID;
  private List<CollectionItem> games;
  private int                  baseGameCount;
  private int                  collectibleGameCount;
  private int                  expansionGameCount;
  
  //TODO - May be some other things coming later
  
  public Collection() {
    collectionID         = -1;
    games                = new LinkedList<CollectionItem>();
    baseGameCount        = 0;
    collectibleGameCount = 0;
    expansionGameCount   = 0;
  }
  
  public Collection(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      Collection jsonData = mapper.readValue(jsonString, Collection.class);
      collectionID         = jsonData.collectionID;
      games                = jsonData.games;
      baseGameCount        = jsonData.baseGameCount;
      collectibleGameCount = jsonData.collectibleGameCount;
      expansionGameCount   = jsonData.expansionGameCount;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  
  /**
   * This constructor should initialize an empty collection.
   * 
   * @param collectionID The ID for this new collection
   */
  public Collection(long collectionID) {
    this.collectionID    = collectionID;
    games                = new LinkedList<CollectionItem>();
    baseGameCount        = 0;
    collectibleGameCount = 0;
    expansionGameCount   = 0;
  }
  
  public void addGame(CollectionItem game) {
    if (game == null)           return;
    if (game.getGame() == null) return;
    
    //We should check to make sure the item doesn't already exist in our collection
    for (CollectionItem curGame : games) {
      if (curGame.getGameID() == game.getGameID())
        return;
    }

    games.add(game);
    if (game.getGame().getGameType() == GameType.BASE)        baseGameCount++;
    if (game.getGame().getGameType() == GameType.COLLECTIBLE) collectibleGameCount++;
    if (game.getGame().getGameType() == GameType.EXPANSION)   expansionGameCount++;
  }
  
  public void removeGame(CollectionItem game) {
    if (game == null)           return;
    if (game.getGame() == null) return;
    
    for (CollectionItem curGame : games) {
      if (curGame.getGameID() == game.getGameID()) {
        games.remove(curGame);
        if (curGame.getGame().getGameType() == GameType.BASE)        baseGameCount--;
        if (curGame.getGame().getGameType() == GameType.COLLECTIBLE) collectibleGameCount--;
        if (curGame.getGame().getGameType() == GameType.EXPANSION)   expansionGameCount--;
        return;
      }
    }
  }

  /**
   * @return the collectionID
   */
  public long getCollectionID() {
    return collectionID;
  }

  /**
   * @param collectionID the collectionID to set
   */
  public void setCollectionID(long collectionID) {
    this.collectionID = collectionID;
  }

  /**
   * @return the games
   */
  public List<CollectionItem> getGames() {
    return games;
  }

  /**
   * @param games the games to set
   */
  public void setGames(List<CollectionItem> games) {
    this.games = games;
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
}
