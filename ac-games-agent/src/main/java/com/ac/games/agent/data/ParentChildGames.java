package com.ac.games.agent.data;

/**
 * @author ac010168
 *
 */
public class ParentChildGames {
  private long parentID;
  private long childID;
  
  public ParentChildGames() {
    parentID = -1;
    childID  = -1;
  }

  /**
   * @return the parentID
   */
  public long getParentID() {
    return parentID;
  }

  /**
   * @param parentID the parentID to set
   */
  public void setParentID(long parentID) {
    this.parentID = parentID;
  }

  /**
   * @return the childID
   */
  public long getChildID() {
    return childID;
  }

  /**
   * @param childID the childID to set
   */
  public void setChildID(long childID) {
    this.childID = childID;
  }
}
