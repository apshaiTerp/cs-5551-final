/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * This class exists because even though Enums are serializable by default, they don't
 * serialize when converting through BSON, so we need to have a conversion mapper that
 * translates the Enum into a common flag to assist BSON parsing.
 *
 * @author ac010168
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class GameAvailabilityConverter {public static class __CLR3_3_0uauai96a0zpe{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1120,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no GameAvailability set */
  public final static int DEFAULT_FLAG            = -1;
  /** Integer flag corresponding to In Stock */
  public final static int INSTOCK_FLAG            = 0;
  /** Integer flag corresponding to Out of Stock */
  public final static int OUTOFSTOCK_FLAG         = 1;
  /** Integer flag corresponding to Pre Orders */
  public final static int PREORDER_FLAG           = 2;
  /** Integer flag corresponding to Not Yet Taking Orders */
  public final static int NOTYETTAKINGORDERS_FLAG = 3;
  
  /**
   * Helper method to convert from GameAvailability enum to a static flag value.
   * @param availability
   * @return
   */
  public static int convertGameAvailabilityToFlag(GameAvailability availability) {try{__CLR3_3_0uauai96a0zpe.R.inc(1090);
    __CLR3_3_0uauai96a0zpe.R.inc(1091);if ((((availability == null)&&(__CLR3_3_0uauai96a0zpe.R.iget(1092)!=0|true))||(__CLR3_3_0uauai96a0zpe.R.iget(1093)==0&false))) {__CLR3_3_0uauai96a0zpe.R.inc(1094);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_0uauai96a0zpe.R.inc(1095);switch (availability) {
      case INSTOCK            :if (!__CLB3_3_0_bool0) {__CLR3_3_0uauai96a0zpe.R.inc(1096);__CLB3_3_0_bool0=true;} __CLR3_3_0uauai96a0zpe.R.inc(1097);return INSTOCK_FLAG;
      case OUTOFSTOCK         :if (!__CLB3_3_0_bool0) {__CLR3_3_0uauai96a0zpe.R.inc(1098);__CLB3_3_0_bool0=true;} __CLR3_3_0uauai96a0zpe.R.inc(1099);return OUTOFSTOCK_FLAG;
      case PREORDER           :if (!__CLB3_3_0_bool0) {__CLR3_3_0uauai96a0zpe.R.inc(1100);__CLB3_3_0_bool0=true;} __CLR3_3_0uauai96a0zpe.R.inc(1101);return PREORDER_FLAG;
      case NOTYETTAKINGORDERS :if (!__CLB3_3_0_bool0) {__CLR3_3_0uauai96a0zpe.R.inc(1102);__CLB3_3_0_bool0=true;} __CLR3_3_0uauai96a0zpe.R.inc(1103);return NOTYETTAKINGORDERS_FLAG;
      default                 :if (!__CLB3_3_0_bool0) {__CLR3_3_0uauai96a0zpe.R.inc(1104);__CLB3_3_0_bool0=true;} __CLR3_3_0uauai96a0zpe.R.inc(1105);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_0uauai96a0zpe.R.flushNeeded();}}
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static GameAvailability convertFlagToGameAvailability(int flag) {try{__CLR3_3_0uauai96a0zpe.R.inc(1106);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0uauai96a0zpe.R.inc(1107);switch (flag) {
      case DEFAULT_FLAG            :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1108);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1109);return null;
      case INSTOCK_FLAG            :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1110);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1111);return GameAvailability.INSTOCK;
      case OUTOFSTOCK_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1112);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1113);return GameAvailability.OUTOFSTOCK;
      case PREORDER_FLAG           :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1114);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1115);return GameAvailability.PREORDER;
      case NOTYETTAKINGORDERS_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1116);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1117);return GameAvailability.NOTYETTAKINGORDERS;
      default                      :if (!__CLB3_3_0_bool1) {__CLR3_3_0uauai96a0zpe.R.inc(1118);__CLB3_3_0_bool1=true;} __CLR3_3_0uauai96a0zpe.R.inc(1119);return null;
    }
  }finally{__CLR3_3_0uauai96a0zpe.R.flushNeeded();}}
}
