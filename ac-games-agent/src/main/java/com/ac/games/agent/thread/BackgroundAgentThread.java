package com.ac.games.agent.thread;

/**
 * @author ac010168
 *
 */
public abstract class BackgroundAgentThread extends Thread {

  protected long startID;
  
  protected long stopID;
  
  protected int failCount;
  
  protected int notFoundCount;
  
  public BackgroundAgentThread() {
    startID   = 0;
    stopID    = 0;
    failCount = 0;
  }
  
  public BackgroundAgentThread(long startID, long stopID) {
    this.startID = startID;
    this.stopID  = stopID;
    failCount    = 0;
  }

  /**
   * @return the startID
   */
  public long getStartID() {
    return startID;
  }

  /**
   * @param startID the startID to set
   */
  public void setStartID(long startID) {
    this.startID = startID;
  }

  /**
   * @return the stopID
   */
  public long getStopID() {
    return stopID;
  }

  /**
   * @param stopID the stopID to set
   */
  public void setStopID(long stopID) {
    this.stopID = stopID;
  }

  /**
   * @return the failCount
   */
  public int getFailCount() {
    return failCount;
  }

  /**
   * @param failCount the failCount to set
   */
  public void setFailCount(int failCount) {
    this.failCount = failCount;
  }
}
