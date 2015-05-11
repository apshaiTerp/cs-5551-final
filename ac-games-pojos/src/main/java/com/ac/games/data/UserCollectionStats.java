package com.ac.games.data;

/**
 * @author ac010168
 *
 */
public class UserCollectionStats {
  
  private int baseOwned;
  private int expOwned;
  private int colOwned;
  
  private String mech1;
  private String mech2;
  private String mech3;
  
  private String des1;
  private String des2;
  private String des3;
  
  private String pub1;
  private String pub2;
  private String pub3;
  
  public UserCollectionStats() {
    baseOwned = 0;
    expOwned  = 0;
    colOwned  = 0;
    
    mech1     = "---"; 
    mech2     = "---"; 
    mech3     = "---";
    
    des1      = "---";
    des2      = "---";
    des3      = "---";
    
    pub1      = "---";
    pub2      = "---";
    pub3      = "---";
  }

  /**
   * @return the baseOwned
   */
  public int getBaseOwned() {
    return baseOwned;
  }

  /**
   * @param baseOwned the baseOwned to set
   */
  public void setBaseOwned(int baseOwned) {
    this.baseOwned = baseOwned;
  }

  /**
   * @return the expOwned
   */
  public int getExpOwned() {
    return expOwned;
  }

  /**
   * @param expOwned the expOwned to set
   */
  public void setExpOwned(int expOwned) {
    this.expOwned = expOwned;
  }

  /**
   * @return the colOwned
   */
  public int getColOwned() {
    return colOwned;
  }

  /**
   * @param colOwned the colOwned to set
   */
  public void setColOwned(int colOwned) {
    this.colOwned = colOwned;
  }

  /**
   * @return the mech1
   */
  public String getMech1() {
    return mech1;
  }

  /**
   * @param mech1 the mech1 to set
   */
  public void setMech1(String mech1) {
    this.mech1 = mech1;
  }

  /**
   * @return the mech2
   */
  public String getMech2() {
    return mech2;
  }

  /**
   * @param mech2 the mech2 to set
   */
  public void setMech2(String mech2) {
    this.mech2 = mech2;
  }

  /**
   * @return the mech3
   */
  public String getMech3() {
    return mech3;
  }

  /**
   * @param mech3 the mech3 to set
   */
  public void setMech3(String mech3) {
    this.mech3 = mech3;
  }

  /**
   * @return the des1
   */
  public String getDes1() {
    return des1;
  }

  /**
   * @param des1 the des1 to set
   */
  public void setDes1(String des1) {
    this.des1 = des1;
  }

  /**
   * @return the des2
   */
  public String getDes2() {
    return des2;
  }

  /**
   * @param des2 the des2 to set
   */
  public void setDes2(String des2) {
    this.des2 = des2;
  }

  /**
   * @return the des3
   */
  public String getDes3() {
    return des3;
  }

  /**
   * @param des3 the des3 to set
   */
  public void setDes3(String des3) {
    this.des3 = des3;
  }

  /**
   * @return the pub1
   */
  public String getPub1() {
    return pub1;
  }

  /**
   * @param pub1 the pub1 to set
   */
  public void setPub1(String pub1) {
    this.pub1 = pub1;
  }

  /**
   * @return the pub2
   */
  public String getPub2() {
    return pub2;
  }

  /**
   * @param pub2 the pub2 to set
   */
  public void setPub2(String pub2) {
    this.pub2 = pub2;
  }

  /**
   * @return the pub3
   */
  public String getPub3() {
    return pub3;
  }

  /**
   * @param pub3 the pub3 to set
   */
  public void setPub3(String pub3) {
    this.pub3 = pub3;
  }
}
