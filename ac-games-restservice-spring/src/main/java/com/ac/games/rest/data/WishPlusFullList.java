package com.ac.games.rest.data;

import java.util.LinkedList;
import java.util.List;

import com.ac.games.data.CompactPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.WishlistItem;

/**
 * @author ac010168
 *
 */
public class WishPlusFullList extends WishlistItem {
  
  private Game game;
  
  private List<CompactPriceData> csiPriceList;
  private List<CompactPriceData> mmPriceList;
  
  public WishPlusFullList(WishlistItem item) {
    setWishID(item.getWishID());
    setGameID(item.getGameID());
    setUserID(item.getUserID());
    setDateAdded(item.getDateAdded());
    setNotifyUser(item.isNotifyUser());
    
    game = null;
    csiPriceList = new LinkedList<CompactPriceData>();
    mmPriceList  = new LinkedList<CompactPriceData>();
  }
  
  /**
   * @param price
   */
  public void addCSIData(CompactPriceData price) {
    csiPriceList.add(price);
  }

  /**
   * @param data
   */
  public void addMMData(CompactPriceData data) {
    mmPriceList.add(data);
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
   * @return the csiPriceList
   */
  public List<CompactPriceData> getCsiPriceList() {
    return csiPriceList;
  }

  /**
   * @param csiPriceList the csiPriceList to set
   */
  public void setCsiPriceList(List<CompactPriceData> csiPriceList) {
    this.csiPriceList = csiPriceList;
  }

  /**
   * @return the mmPriceList
   */
  public List<CompactPriceData> getMmPriceList() {
    return mmPriceList;
  }

  /**
   * @param mmPriceList the mmPriceList to set
   */
  public void setMmPriceList(List<CompactPriceData> mmPriceList) {
    this.mmPriceList = mmPriceList;
  }
}
