package com.ac.games.rest.data;

import com.ac.games.data.Game;
import com.ac.games.data.WishlistItem;

/**
 * @author ac010168
 *
 */
public class WishPlusGameList extends WishlistItem {
  
  private Game game;

  public WishPlusGameList(WishlistItem item) {
    setWishID(item.getWishID());
    setGameID(item.getGameID());
    setUserID(item.getUserID());
    setDateAdded(item.getDateAdded());
    setNotifyUser(item.isNotifyUser());
    
    game = null;
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
}
