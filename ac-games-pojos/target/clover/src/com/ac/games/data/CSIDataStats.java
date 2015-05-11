/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class CSIDataStats {public static class __CLR3_3_08y8yi96a0zjq{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,403,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  public final static String CSI_DATA_STATS = "csiDataStats";

  private int boardGameCount;
  private int collectibleGameCount;
  private int diceMastersCount;
  private int rpgCount;
  private int lcgCount;
  private int suppliesCount;
  private int miniatureCount;
  private int videoGameCount;
  private int unknownCount;
  
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public CSIDataStats() {try{__CLR3_3_08y8yi96a0zjq.R.inc(322);
    __CLR3_3_08y8yi96a0zjq.R.inc(323);boardGameCount       = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(324);collectibleGameCount = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(325);diceMastersCount     = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(326);rpgCount             = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(327);lcgCount             = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(328);suppliesCount        = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(329);miniatureCount       = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(330);videoGameCount       = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(331);unknownCount         = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(332);approvedCount        = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(333);rejectedCount        = 0;
    __CLR3_3_08y8yi96a0zjq.R.inc(334);pendingCount         = 0;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}
  
  public CSIDataStats(String jsonString) {
    super();__CLR3_3_08y8yi96a0zjq.R.inc(336);try{__CLR3_3_08y8yi96a0zjq.R.inc(335);
    __CLR3_3_08y8yi96a0zjq.R.inc(337);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_08y8yi96a0zjq.R.inc(338);try {
      __CLR3_3_08y8yi96a0zjq.R.inc(339);CSIDataStats jsonData = mapper.readValue(jsonString, CSIDataStats.class);
      __CLR3_3_08y8yi96a0zjq.R.inc(340);boardGameCount       = jsonData.boardGameCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(341);collectibleGameCount = jsonData.collectibleGameCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(342);diceMastersCount     = jsonData.diceMastersCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(343);rpgCount             = jsonData.rpgCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(344);lcgCount             = jsonData.lcgCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(345);suppliesCount        = jsonData.suppliesCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(346);miniatureCount       = jsonData.miniatureCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(347);videoGameCount       = jsonData.videoGameCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(348);unknownCount         = jsonData.unknownCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(349);approvedCount        = jsonData.approvedCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(350);rejectedCount        = jsonData.rejectedCount;
      __CLR3_3_08y8yi96a0zjq.R.inc(351);pendingCount         = jsonData.pendingCount;
    } catch (JsonParseException jpe) {
      __CLR3_3_08y8yi96a0zjq.R.inc(352);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_08y8yi96a0zjq.R.inc(353);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_08y8yi96a0zjq.R.inc(354);ioe.printStackTrace();
    }
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the boardGameCount
   */
  public int getBoardGameCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(355);
    __CLR3_3_08y8yi96a0zjq.R.inc(356);return boardGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param boardGameCount the boardGameCount to set
   */
  public void setBoardGameCount(int boardGameCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(357);
    __CLR3_3_08y8yi96a0zjq.R.inc(358);this.boardGameCount = boardGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the collectibleGameCount
   */
  public int getCollectibleGameCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(359);
    __CLR3_3_08y8yi96a0zjq.R.inc(360);return collectibleGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param collectibleGameCount the collectibleGameCount to set
   */
  public void setCollectibleGameCount(int collectibleGameCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(361);
    __CLR3_3_08y8yi96a0zjq.R.inc(362);this.collectibleGameCount = collectibleGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the diceMastersCount
   */
  public int getDiceMastersCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(363);
    __CLR3_3_08y8yi96a0zjq.R.inc(364);return diceMastersCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param diceMastersCount the diceMastersCount to set
   */
  public void setDiceMastersCount(int diceMastersCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(365);
    __CLR3_3_08y8yi96a0zjq.R.inc(366);this.diceMastersCount = diceMastersCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the rpgCount
   */
  public int getRpgCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(367);
    __CLR3_3_08y8yi96a0zjq.R.inc(368);return rpgCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param rpgCount the rpgCount to set
   */
  public void setRpgCount(int rpgCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(369);
    __CLR3_3_08y8yi96a0zjq.R.inc(370);this.rpgCount = rpgCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the lcgCount
   */
  public int getLcgCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(371);
    __CLR3_3_08y8yi96a0zjq.R.inc(372);return lcgCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param lcgCount the lcgCount to set
   */
  public void setLcgCount(int lcgCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(373);
    __CLR3_3_08y8yi96a0zjq.R.inc(374);this.lcgCount = lcgCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the suppliesCount
   */
  public int getSuppliesCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(375);
    __CLR3_3_08y8yi96a0zjq.R.inc(376);return suppliesCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param suppliesCount the suppliesCount to set
   */
  public void setSuppliesCount(int suppliesCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(377);
    __CLR3_3_08y8yi96a0zjq.R.inc(378);this.suppliesCount = suppliesCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the miniatureCount
   */
  public int getMiniatureCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(379);
    __CLR3_3_08y8yi96a0zjq.R.inc(380);return miniatureCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param miniatureCount the miniatureCount to set
   */
  public void setMiniatureCount(int miniatureCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(381);
    __CLR3_3_08y8yi96a0zjq.R.inc(382);this.miniatureCount = miniatureCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the videoGameCount
   */
  public int getVideoGameCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(383);
    __CLR3_3_08y8yi96a0zjq.R.inc(384);return videoGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param videoGameCount the videoGameCount to set
   */
  public void setVideoGameCount(int videoGameCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(385);
    __CLR3_3_08y8yi96a0zjq.R.inc(386);this.videoGameCount = videoGameCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the unknownCount
   */
  public int getUnknownCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(387);
    __CLR3_3_08y8yi96a0zjq.R.inc(388);return unknownCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param unknownCount the unknownCount to set
   */
  public void setUnknownCount(int unknownCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(389);
    __CLR3_3_08y8yi96a0zjq.R.inc(390);this.unknownCount = unknownCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the approvedCount
   */
  public int getApprovedCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(391);
    __CLR3_3_08y8yi96a0zjq.R.inc(392);return approvedCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param approvedCount the approvedCount to set
   */
  public void setApprovedCount(int approvedCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(393);
    __CLR3_3_08y8yi96a0zjq.R.inc(394);this.approvedCount = approvedCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the rejectedCount
   */
  public int getRejectedCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(395);
    __CLR3_3_08y8yi96a0zjq.R.inc(396);return rejectedCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param rejectedCount the rejectedCount to set
   */
  public void setRejectedCount(int rejectedCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(397);
    __CLR3_3_08y8yi96a0zjq.R.inc(398);this.rejectedCount = rejectedCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @return the pendingCount
   */
  public int getPendingCount() {try{__CLR3_3_08y8yi96a0zjq.R.inc(399);
    __CLR3_3_08y8yi96a0zjq.R.inc(400);return pendingCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}

  /**
   * @param pendingCount the pendingCount to set
   */
  public void setPendingCount(int pendingCount) {try{__CLR3_3_08y8yi96a0zjq.R.inc(401);
    __CLR3_3_08y8yi96a0zjq.R.inc(402);this.pendingCount = pendingCount;
  }finally{__CLR3_3_08y8yi96a0zjq.R.flushNeeded();}}
}
