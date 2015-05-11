/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * This class exists because even though Enums are serializable by default, they don't
 * serialize when converting through BSON, so we need to have a conversion mapper that
 * translates the Enum into a common flag to assist BSON parsing.
 * 
 * @author ac010168
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class GameTypeConverter {public static class __CLR3_3_0yiyii96a0zr2{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1268,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** Integer flag corresponding to no GameType set */
  public final static int DEFAULT_FLAG     = -1;
  /** Integer flag corresponding to GameType.BASE */
  public final static int BASE_FLAG        = 0;
  /** Integer flag corresponding to GameType.EXPANSION */
  public final static int EXPANSION_FLAG   = 1;
  /** Integer flag corresponding to GameType,COLLECTIBLE */
  public final static int COLLECTIBLE_FLAG = 2;

  /**
   * Helper method to convert from GameType enum to a static flag value.
   * @param type
   * @return
   */
  public static int convertGameTypeToFlag(GameType type) {try{__CLR3_3_0yiyii96a0zr2.R.inc(1242);
    __CLR3_3_0yiyii96a0zr2.R.inc(1243);if ((((type == null)&&(__CLR3_3_0yiyii96a0zr2.R.iget(1244)!=0|true))||(__CLR3_3_0yiyii96a0zr2.R.iget(1245)==0&false))) {__CLR3_3_0yiyii96a0zr2.R.inc(1246);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_0yiyii96a0zr2.R.inc(1247);switch (type) {
      case BASE        :if (!__CLB3_3_0_bool0) {__CLR3_3_0yiyii96a0zr2.R.inc(1248);__CLB3_3_0_bool0=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1249);return BASE_FLAG;
      case EXPANSION   :if (!__CLB3_3_0_bool0) {__CLR3_3_0yiyii96a0zr2.R.inc(1250);__CLB3_3_0_bool0=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1251);return EXPANSION_FLAG;
      case COLLECTIBLE :if (!__CLB3_3_0_bool0) {__CLR3_3_0yiyii96a0zr2.R.inc(1252);__CLB3_3_0_bool0=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1253);return COLLECTIBLE_FLAG;
      default          :if (!__CLB3_3_0_bool0) {__CLR3_3_0yiyii96a0zr2.R.inc(1254);__CLB3_3_0_bool0=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1255);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_0yiyii96a0zr2.R.flushNeeded();}}
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static GameType convertFlagToGameType(int flag) {try{__CLR3_3_0yiyii96a0zr2.R.inc(1256);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0yiyii96a0zr2.R.inc(1257);switch (flag) {
      case DEFAULT_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_0yiyii96a0zr2.R.inc(1258);__CLB3_3_0_bool1=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1259);return null;
      case BASE_FLAG        :if (!__CLB3_3_0_bool1) {__CLR3_3_0yiyii96a0zr2.R.inc(1260);__CLB3_3_0_bool1=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1261);return GameType.BASE;
      case EXPANSION_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0yiyii96a0zr2.R.inc(1262);__CLB3_3_0_bool1=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1263);return GameType.EXPANSION;
      case COLLECTIBLE_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0yiyii96a0zr2.R.inc(1264);__CLB3_3_0_bool1=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1265);return GameType.COLLECTIBLE;
      default               :if (!__CLB3_3_0_bool1) {__CLR3_3_0yiyii96a0zr2.R.inc(1266);__CLB3_3_0_bool1=true;} __CLR3_3_0yiyii96a0zr2.R.inc(1267);return null;
    }
  }finally{__CLR3_3_0yiyii96a0zr2.R.flushNeeded();}}
}
