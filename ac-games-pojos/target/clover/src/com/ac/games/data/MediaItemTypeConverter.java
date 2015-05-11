/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class MediaItemTypeConverter {public static class __CLR3_3_014p14pi96a0zt7{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1509,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no MediaType found */
  public final static int DEFAULT_FLAG        = -1;
  /** Media Type indicating a Video Review */
  public final static int REVIEW_VIDEO_FLAG   = 0;
  /** Media Type indicating a Playthru Review */
  public final static int PLAYTHRU_VIDEO_FLAG = 1;
  /** Media Type indicating a Tutorial Review */
  public final static int TUTORIAL_VIDEO_FLAG = 2;
  /** Media Type indicating a Game Manual */
  public final static int RULES_MANUAL_FLAG   = 3;
  /** Media Type indicating a FAQ doc */
  public final static int FAQ_DOC_FLAG        = 4;
  /** Media Type indicating a User Image */
  public final static int USER_IMAGE_FLAG     = 5;
  /** Media Type indicating a User Video */
  public final static int USER_VIDEO_FLAG     = 6;
  /** Media Type indicating a User Link */
  public final static int USER_LINK_FLAG      = 7;
  
  /**
   * Helper method to convert from MediaItemType to an integer flag.
   * @param type
   * @return
   */
  public static int convertMediaItemTypeToFlag(MediaItemType type) {try{__CLR3_3_014p14pi96a0zt7.R.inc(1465);
    __CLR3_3_014p14pi96a0zt7.R.inc(1466);if ((((type == null)&&(__CLR3_3_014p14pi96a0zt7.R.iget(1467)!=0|true))||(__CLR3_3_014p14pi96a0zt7.R.iget(1468)==0&false))) {__CLR3_3_014p14pi96a0zt7.R.inc(1469);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_014p14pi96a0zt7.R.inc(1470);switch (type) {
      case REVIEW_VIDEO   :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1471);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1472);return REVIEW_VIDEO_FLAG;
      case PLAYTHRU_VIDEO :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1473);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1474);return PLAYTHRU_VIDEO_FLAG;
      case TUTORIAL_VIDEO :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1475);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1476);return TUTORIAL_VIDEO_FLAG;
      case RULES_MANUAL   :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1477);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1478);return RULES_MANUAL_FLAG;
      case FAQ_DOC        :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1479);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1480);return FAQ_DOC_FLAG;
      case USER_IMAGE     :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1481);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1482);return USER_IMAGE_FLAG;
      case USER_VIDEO     :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1483);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1484);return USER_VIDEO_FLAG;
      case USER_LINK      :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1485);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1486);return USER_LINK_FLAG;
      default             :if (!__CLB3_3_0_bool0) {__CLR3_3_014p14pi96a0zt7.R.inc(1487);__CLB3_3_0_bool0=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1488);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_014p14pi96a0zt7.R.flushNeeded();}}
  
  /**
   * Helper method to convert from Flag back to MediaItemType
   * @param flag
   * @return
   */
  public static MediaItemType convertFlagToMediaItemType(int flag) {try{__CLR3_3_014p14pi96a0zt7.R.inc(1489);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_014p14pi96a0zt7.R.inc(1490);switch (flag) {
      case REVIEW_VIDEO_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1491);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1492);return MediaItemType.REVIEW_VIDEO;
      case PLAYTHRU_VIDEO_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1493);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1494);return MediaItemType.PLAYTHRU_VIDEO;
      case TUTORIAL_VIDEO_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1495);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1496);return MediaItemType.TUTORIAL_VIDEO;
      case RULES_MANUAL_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1497);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1498);return MediaItemType.RULES_MANUAL;
      case FAQ_DOC_FLAG        :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1499);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1500);return MediaItemType.FAQ_DOC;
      case USER_IMAGE_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1501);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1502);return MediaItemType.USER_IMAGE;
      case USER_VIDEO_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1503);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1504);return MediaItemType.USER_VIDEO;
      case USER_LINK_FLAG      :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1505);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1506);return MediaItemType.USER_LINK;
      default                  :if (!__CLB3_3_0_bool1) {__CLR3_3_014p14pi96a0zt7.R.inc(1507);__CLB3_3_0_bool1=true;} __CLR3_3_014p14pi96a0zt7.R.inc(1508);return null;
    }
  }finally{__CLR3_3_014p14pi96a0zt7.R.flushNeeded();}}
}
