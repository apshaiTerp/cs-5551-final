/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class MiniatureMarketCategoryConverter {public static class __CLR3_3_015x15xi96a0ztl{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1553,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no CoolStuffIncCategory found */
  public final static int DEFAULT_FLAG      = -1;
  /** Integer flag corresponding to CCGs */
  public final static int BOARDGAMES_FLAG   = 0; 
  /** Integer flag corresponding to Dice Masters (which is a subtype of CCG that matters) */
  public final static int TABLETOP_FLAG     = 1;
  /** Integer flag corresponding to CCGs */
  public final static int CCGS_FLAG         = 2;
  /** Integer flag corresponding to LCGs */
  public final static int LCGS_FLAG         = 3;
  /** Integer flag corresponding to Role Playing Games */
  public final static int COLLECTIBLES_FLAG = 4;
  /** Integer flag corresponding to Living Card Games */
  public final static int RPGS_FLAG         = 5;
  /** Integer flag corresponding to Supplies */
  public final static int ACCESSORIES_FLAG  = 6;
  /** Integer flag corresponding to Miniatures */
  public final static int UNKNOWN_FLAG      = 7;
  
  /**
   * Helper method to convert from MiniatureMarketCategory enum to a static flag value.
   * @param category
   * @return
   */
  public static int convertMMCategoryToFlag(MiniatureMarketCategory category) {try{__CLR3_3_015x15xi96a0ztl.R.inc(1509);
    __CLR3_3_015x15xi96a0ztl.R.inc(1510);if ((((category == null)&&(__CLR3_3_015x15xi96a0ztl.R.iget(1511)!=0|true))||(__CLR3_3_015x15xi96a0ztl.R.iget(1512)==0&false))) {__CLR3_3_015x15xi96a0ztl.R.inc(1513);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_015x15xi96a0ztl.R.inc(1514);switch (category) {
      case BOARDGAMES   :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1515);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1516);return BOARDGAMES_FLAG;
      case TABLETOP     :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1517);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1518);return TABLETOP_FLAG;
      case CCGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1519);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1520);return CCGS_FLAG;
      case LCGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1521);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1522);return LCGS_FLAG;
      case COLLECTIBLES :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1523);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1524);return COLLECTIBLES_FLAG;
      case RPGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1525);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1526);return RPGS_FLAG;
      case ACCESSORIES  :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1527);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1528);return ACCESSORIES_FLAG;
      case UNKNOWN      :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1529);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1530);return UNKNOWN_FLAG;
      default           :if (!__CLB3_3_0_bool0) {__CLR3_3_015x15xi96a0ztl.R.inc(1531);__CLB3_3_0_bool0=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1532);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_015x15xi96a0ztl.R.flushNeeded();}}

  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static MiniatureMarketCategory convertFlagToMMCategory(int flag) {try{__CLR3_3_015x15xi96a0ztl.R.inc(1533);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_015x15xi96a0ztl.R.inc(1534);switch (flag) {
      case BOARDGAMES_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1535);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1536);return MiniatureMarketCategory.BOARDGAMES;
      case TABLETOP_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1537);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1538);return MiniatureMarketCategory.TABLETOP;
      case CCGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1539);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1540);return MiniatureMarketCategory.CCGS;
      case LCGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1541);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1542);return MiniatureMarketCategory.LCGS;
      case COLLECTIBLES_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1543);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1544);return MiniatureMarketCategory.COLLECTIBLES;
      case RPGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1545);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1546);return MiniatureMarketCategory.RPGS;
      case ACCESSORIES_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1547);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1548);return MiniatureMarketCategory.ACCESSORIES;
      case UNKNOWN_FLAG      :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1549);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1550);return MiniatureMarketCategory.UNKNOWN;
      default                :if (!__CLB3_3_0_bool1) {__CLR3_3_015x15xi96a0ztl.R.inc(1551);__CLB3_3_0_bool1=true;} __CLR3_3_015x15xi96a0ztl.R.inc(1552);return null;
    }
  }finally{__CLR3_3_015x15xi96a0ztl.R.flushNeeded();}}
}
