/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class BGGGameStats {public static class __CLR3_3_07878i96a0zir{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,305,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  public final static String BGG_GAME_STATS = "bggGameStats";

  private int baseGameCount;
  private int expansionGameCount;
  private int collectibleGameCount;
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public BGGGameStats() {try{__CLR3_3_07878i96a0zir.R.inc(260);
    __CLR3_3_07878i96a0zir.R.inc(261);baseGameCount        = 0;
    __CLR3_3_07878i96a0zir.R.inc(262);expansionGameCount   = 0;
    __CLR3_3_07878i96a0zir.R.inc(263);collectibleGameCount = 0;
    __CLR3_3_07878i96a0zir.R.inc(264);approvedCount        = 0;
    __CLR3_3_07878i96a0zir.R.inc(265);rejectedCount        = 0;
    __CLR3_3_07878i96a0zir.R.inc(266);pendingCount         = 0;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}
  
  public BGGGameStats(String jsonString) {
    super();__CLR3_3_07878i96a0zir.R.inc(268);try{__CLR3_3_07878i96a0zir.R.inc(267);
    __CLR3_3_07878i96a0zir.R.inc(269);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_07878i96a0zir.R.inc(270);try {
      __CLR3_3_07878i96a0zir.R.inc(271);BGGGameStats jsonData = mapper.readValue(jsonString, BGGGameStats.class);
      __CLR3_3_07878i96a0zir.R.inc(272);baseGameCount        = jsonData.baseGameCount;
      __CLR3_3_07878i96a0zir.R.inc(273);expansionGameCount   = jsonData.expansionGameCount;
      __CLR3_3_07878i96a0zir.R.inc(274);collectibleGameCount = jsonData.collectibleGameCount;
      __CLR3_3_07878i96a0zir.R.inc(275);approvedCount        = jsonData.approvedCount;
      __CLR3_3_07878i96a0zir.R.inc(276);rejectedCount        = jsonData.rejectedCount;
      __CLR3_3_07878i96a0zir.R.inc(277);pendingCount         = jsonData.pendingCount;
    } catch (JsonParseException jpe) {
      __CLR3_3_07878i96a0zir.R.inc(278);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_07878i96a0zir.R.inc(279);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_07878i96a0zir.R.inc(280);ioe.printStackTrace();
    }
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the baseGameCount
   */
  public int getBaseGameCount() {try{__CLR3_3_07878i96a0zir.R.inc(281);
    __CLR3_3_07878i96a0zir.R.inc(282);return baseGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param baseGameCount the baseGameCount to set
   */
  public void setBaseGameCount(int baseGameCount) {try{__CLR3_3_07878i96a0zir.R.inc(283);
    __CLR3_3_07878i96a0zir.R.inc(284);this.baseGameCount = baseGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the expansionGameCount
   */
  public int getExpansionGameCount() {try{__CLR3_3_07878i96a0zir.R.inc(285);
    __CLR3_3_07878i96a0zir.R.inc(286);return expansionGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param expansionGameCount the expansionGameCount to set
   */
  public void setExpansionGameCount(int expansionGameCount) {try{__CLR3_3_07878i96a0zir.R.inc(287);
    __CLR3_3_07878i96a0zir.R.inc(288);this.expansionGameCount = expansionGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the collectibleGameCount
   */
  public int getCollectibleGameCount() {try{__CLR3_3_07878i96a0zir.R.inc(289);
    __CLR3_3_07878i96a0zir.R.inc(290);return collectibleGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param collectibleGameCount the collectibleGameCount to set
   */
  public void setCollectibleGameCount(int collectibleGameCount) {try{__CLR3_3_07878i96a0zir.R.inc(291);
    __CLR3_3_07878i96a0zir.R.inc(292);this.collectibleGameCount = collectibleGameCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the approvedCount
   */
  public int getApprovedCount() {try{__CLR3_3_07878i96a0zir.R.inc(293);
    __CLR3_3_07878i96a0zir.R.inc(294);return approvedCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param approvedCount the approvedCount to set
   */
  public void setApprovedCount(int approvedCount) {try{__CLR3_3_07878i96a0zir.R.inc(295);
    __CLR3_3_07878i96a0zir.R.inc(296);this.approvedCount = approvedCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the rejectedCount
   */
  public int getRejectedCount() {try{__CLR3_3_07878i96a0zir.R.inc(297);
    __CLR3_3_07878i96a0zir.R.inc(298);return rejectedCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param rejectedCount the rejectedCount to set
   */
  public void setRejectedCount(int rejectedCount) {try{__CLR3_3_07878i96a0zir.R.inc(299);
    __CLR3_3_07878i96a0zir.R.inc(300);this.rejectedCount = rejectedCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @return the pendingCount
   */
  public int getPendingCount() {try{__CLR3_3_07878i96a0zir.R.inc(301);
    __CLR3_3_07878i96a0zir.R.inc(302);return pendingCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}

  /**
   * @param pendingCount the pendingCount to set
   */
  public void setPendingCount(int pendingCount) {try{__CLR3_3_07878i96a0zir.R.inc(303);
    __CLR3_3_07878i96a0zir.R.inc(304);this.pendingCount = pendingCount;
  }finally{__CLR3_3_07878i96a0zir.R.flushNeeded();}}
}
