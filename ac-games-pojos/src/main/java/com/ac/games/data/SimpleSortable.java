package com.ac.games.data;

/**
 * Helper class to make sorting categories easier
 * 
 * @author ac010168
 *
 */
public class SimpleSortable implements Comparable<SimpleSortable> {

  private String content;
  private int hits;
  
  public SimpleSortable() {
    content = null;
    hits = 0;
  }
  
  public SimpleSortable(String content) {
    this.content = content;
    hits = 0;
  }
  
  public int compareTo(SimpleSortable o) {
    return (o.hits - hits);
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the hits
   */
  public int getHits() {
    return hits;
  }

  /**
   * @param hits the hits to set
   */
  public void setHits(int hits) {
    this.hits = hits;
  }

}
