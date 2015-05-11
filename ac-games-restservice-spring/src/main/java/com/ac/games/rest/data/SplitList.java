package com.ac.games.rest.data;

import java.util.LinkedList;
import java.util.List;

import com.ac.games.data.CompactSearchData;

/**
 * @author ac010168
 *
 */
public class SplitList {
  
  private List<CompactSearchData> ownedItems;
  private List<CompactSearchData> otherGames;
  
  public SplitList() {
    ownedItems = new LinkedList<CompactSearchData>();
    otherGames = new LinkedList<CompactSearchData>();
  }
  
  /**
   * @param data
   */
  public void addNewOwnedItem(CompactSearchData data) {
    ownedItems.add(data);
  }

  /**
   * @param data
   */
  public void addNewOtherGame(CompactSearchData data) {
    otherGames.add(data);
  }
  /**
   * @return the ownedItems
   */
  public List<CompactSearchData> getOwnedItems() {
    return ownedItems;
  }

  /**
   * @param ownedItems the ownedItems to set
   */
  public void setOwnedItems(List<CompactSearchData> ownedItems) {
    this.ownedItems = ownedItems;
  }

  /**
   * @return the otherGames
   */
  public List<CompactSearchData> getOtherGames() {
    return otherGames;
  }

  /**
   * @param otherGames the otherGames to set
   */
  public void setOtherGames(List<CompactSearchData> otherGames) {
    this.otherGames = otherGames;
  }

}
