package com.ac.games.rest.data;

import java.util.List;

/**
 * @author ac010168
 *
 */
public class WrapList {

  private List<String> wrapList;
  
  public WrapList(List<String> wrapList) {
    this.setWrapList(wrapList);
  }

  /**
   * @return the wrapList
   */
  public List<String> getWrapList() {
    return wrapList;
  }

  /**
   * @param wrapList the wrapList to set
   */
  public void setWrapList(List<String> wrapList) {
    this.wrapList = wrapList;
  }
}
