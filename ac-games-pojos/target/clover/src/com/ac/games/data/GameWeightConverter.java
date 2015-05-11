/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class GameWeightConverter {public static class __CLR3_3_0z8z8i96a0zrj{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1310,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no GameWeight set */
  public final static int DEFAULT_FLAG  = -1;
  /** Integer flag corresponding to the CHILDREN GameWeight set */
  public final static int CHILDREN_FLAG = 0;
  /** Integer flag corresponding to the FILLER GameWeight set */
  public final static int FILLER_FLAG   = 1;
  /** Integer flag corresponding to the SOCIAL GameWeight set */
  public final static int SOCIAL_FLAG   = 2;
  /** Integer flag corresponding to the LIGHT GameWeight set */
  public final static int LIGHT_FLAG    = 3;
  /** Integer flag corresponding to the FAMILY GameWeight set */
  public final static int FAMILY_FLAG   = 4;
  /** Integer flag corresponding to the MEDIUM GameWeight set */
  public final static int MEDIUM_FLAG   = 5;
  /** Integer flag corresponding to the HEAVY GameWeight set */
  public final static int HEAVY_FLAG    = 6;
  
  /**
   * Helper method to convert from GameWeight enum to a static flag value.
   * @param weight
   * @return
   */
  public static int convertGameWeightToFlag(GameWeight weight) {try{__CLR3_3_0z8z8i96a0zrj.R.inc(1268);
    __CLR3_3_0z8z8i96a0zrj.R.inc(1269);if ((((weight == null)&&(__CLR3_3_0z8z8i96a0zrj.R.iget(1270)!=0|true))||(__CLR3_3_0z8z8i96a0zrj.R.iget(1271)==0&false))) {__CLR3_3_0z8z8i96a0zrj.R.inc(1272);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_0z8z8i96a0zrj.R.inc(1273);switch (weight) {
      case CHILDREN :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1274);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1275);return CHILDREN_FLAG;
      case FILLER   :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1276);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1277);return FILLER_FLAG;
      case SOCIAL   :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1278);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1279);return SOCIAL_FLAG;
      case LIGHT    :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1280);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1281);return LIGHT_FLAG;
      case FAMILY   :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1282);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1283);return FAMILY_FLAG;
      case MEDIUM   :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1284);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1285);return MEDIUM_FLAG;
      case HEAVY    :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1286);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1287);return HEAVY_FLAG;
      default       :if (!__CLB3_3_0_bool0) {__CLR3_3_0z8z8i96a0zrj.R.inc(1288);__CLB3_3_0_bool0=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1289);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_0z8z8i96a0zrj.R.flushNeeded();}}
  
  public static GameWeight convertFlagToGameWeight(int flag) {try{__CLR3_3_0z8z8i96a0zrj.R.inc(1290);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0z8z8i96a0zrj.R.inc(1291);switch(flag) {
      case DEFAULT_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1292);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1293);return null;
      case CHILDREN_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1294);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1295);return GameWeight.CHILDREN;
      case FILLER_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1296);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1297);return GameWeight.FILLER;
      case SOCIAL_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1298);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1299);return GameWeight.SOCIAL;
      case LIGHT_FLAG    :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1300);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1301);return GameWeight.LIGHT;
      case FAMILY_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1302);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1303);return GameWeight.FAMILY;
      case MEDIUM_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1304);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1305);return GameWeight.MEDIUM;
      case HEAVY_FLAG    :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1306);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1307);return GameWeight.HEAVY;
      default            :if (!__CLB3_3_0_bool1) {__CLR3_3_0z8z8i96a0zrj.R.inc(1308);__CLB3_3_0_bool1=true;} __CLR3_3_0z8z8i96a0zrj.R.inc(1309);return null;
    }
  }finally{__CLR3_3_0z8z8i96a0zrj.R.flushNeeded();}}
}
