package com.ac.games.data;

/**
 * This class is just a container for the csiID to help with Serialization.
 * 
 * @author ac010168
 *
 */
public class CSIIDOnlyData {

  /** The objectid for this game on Cool Stuff */
  private long csiID;
  
  public CSIIDOnlyData() {
    csiID = -1;
  }
  
  public CSIIDOnlyData(long csiID) {
    this.csiID = csiID;
  }

  /**
   * @return the csiID
   */
  public long getCsiID() {
    return csiID;
  }

  /**
   * @param csiID the csiID to set
   */
  public void setCsiID(long csiID) {
    this.csiID = csiID;
  }
}
