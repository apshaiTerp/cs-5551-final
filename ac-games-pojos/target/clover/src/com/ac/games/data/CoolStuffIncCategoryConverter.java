/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class CoolStuffIncCategoryConverter {public static class __CLR3_3_0i0i0i96a0zmx{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,698,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no CoolStuffIncCategory found */
  public final static int DEFAULT_FLAG     = -1;
  /** Integer flag corresponding to CCGs */
  public final static int COLLECTIBLE_FLAG = 0; 
  /** Integer flag corresponding to Dice Masters (which is a subtype of CCG that matters) */
  public final static int DICEMASTERS_FLAG = 1;
  /** Integer flag corresponding to Board Games */
  public final static int BOARDGAMES_FLAG  = 2;
  /** Integer flag corresponding to Role Playing Games */
  public final static int RPGS_FLAG        = 3;
  /** Integer flag corresponding to Living Card Games */
  public final static int LCGS_FLAG        = 4;
  /** Integer flag corresponding to Supplies */
  public final static int SUPPLIES_FLAG    = 5;
  /** Integer flag corresponding to Miniatures */
  public final static int MINIATURES_FLAG  = 6;
  /** Integer flag corresponding to Video Games */
  public final static int VIDEOGAMES_FLAG  = 7;
  /** Integer flag corresponding to I couldn't find anything... */
  public final static int UNKNOWN_FLAG     = 8;
  
  /**
   * Helper method to convert from CoolStuffIncCategory enum to a static flag value.
   * @param category
   * @return
   */
  public static int convertCSICategoryToFlag(CoolStuffIncCategory category) {try{__CLR3_3_0i0i0i96a0zmx.R.inc(648);
    __CLR3_3_0i0i0i96a0zmx.R.inc(649);if ((((category == null)&&(__CLR3_3_0i0i0i96a0zmx.R.iget(650)!=0|true))||(__CLR3_3_0i0i0i96a0zmx.R.iget(651)==0&false))) {__CLR3_3_0i0i0i96a0zmx.R.inc(652);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_0i0i0i96a0zmx.R.inc(653);switch (category) {
      case COLLECTIBLE :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(654);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(655);return COLLECTIBLE_FLAG;
      case DICEMASTERS :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(656);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(657);return DICEMASTERS_FLAG;
      case BOARDGAMES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(658);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(659);return BOARDGAMES_FLAG;
      case RPGS        :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(660);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(661);return RPGS_FLAG;
      case LCGS        :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(662);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(663);return LCGS_FLAG;
      case SUPPLIES    :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(664);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(665);return SUPPLIES_FLAG;
      case MINIATURES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(666);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(667);return MINIATURES_FLAG;
      case VIDEOGAMES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(668);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(669);return VIDEOGAMES_FLAG;
      case UNKNOWN     :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(670);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(671);return UNKNOWN_FLAG;
      default          :if (!__CLB3_3_0_bool0) {__CLR3_3_0i0i0i96a0zmx.R.inc(672);__CLB3_3_0_bool0=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(673);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_0i0i0i96a0zmx.R.flushNeeded();}}

  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static CoolStuffIncCategory convertFlagToCSICategory(int flag) {try{__CLR3_3_0i0i0i96a0zmx.R.inc(674);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0i0i0i96a0zmx.R.inc(675);switch (flag) {
      case DEFAULT_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(676);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(677);return null;
      case COLLECTIBLE_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(678);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(679);return CoolStuffIncCategory.COLLECTIBLE;
      case DICEMASTERS_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(680);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(681);return CoolStuffIncCategory.DICEMASTERS;
      case BOARDGAMES_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(682);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(683);return CoolStuffIncCategory.BOARDGAMES;
      case RPGS_FLAG        :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(684);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(685);return CoolStuffIncCategory.RPGS;
      case LCGS_FLAG        :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(686);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(687);return CoolStuffIncCategory.LCGS;
      case SUPPLIES_FLAG    :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(688);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(689);return CoolStuffIncCategory.SUPPLIES;
      case MINIATURES_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(690);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(691);return CoolStuffIncCategory.MINIATURES;
      case VIDEOGAMES_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(692);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(693);return CoolStuffIncCategory.VIDEOGAMES;
      case UNKNOWN_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(694);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(695);return CoolStuffIncCategory.UNKNOWN;
      default               :if (!__CLB3_3_0_bool1) {__CLR3_3_0i0i0i96a0zmx.R.inc(696);__CLB3_3_0_bool1=true;} __CLR3_3_0i0i0i96a0zmx.R.inc(697);return null;
    }
  }finally{__CLR3_3_0i0i0i96a0zmx.R.flushNeeded();}}
}
