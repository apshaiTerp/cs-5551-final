/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * This class exists because even though Enums are serializable by default, they don't
 * serialize when converting through BSON, so we need to have a conversion mapper that
 * translates the Enum into a common flag to assist BSON parsing.
 *
 * @author ac010168
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class ReviewStateConverter {public static class __CLR3_3_01d91d9i96a0zv4{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1799,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no ReviewState set */
  public final static int DEFAULT_FLAG  = -1;
  /** Integer flag corresponding to Pending */
  public final static int PENDING_FLAG  = 0;
  /** Integer flag corresponding to Reviewed */
  public final static int REVIEWED_FLAG = 1;
  /** Integer flag corresponding to Rejected */
  public final static int REJECTED_FLAG = 2;
  
  /**
   * Helper method to convert from ReviewState enum to a static flag value.
   * @param state
   * @return
   */
  public static int convertReviewStateToFlag(ReviewState state) {try{__CLR3_3_01d91d9i96a0zv4.R.inc(1773);
    __CLR3_3_01d91d9i96a0zv4.R.inc(1774);if ((((state == null)&&(__CLR3_3_01d91d9i96a0zv4.R.iget(1775)!=0|true))||(__CLR3_3_01d91d9i96a0zv4.R.iget(1776)==0&false))) {__CLR3_3_01d91d9i96a0zv4.R.inc(1777);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_01d91d9i96a0zv4.R.inc(1778);switch (state) {
      case PENDING  :if (!__CLB3_3_0_bool0) {__CLR3_3_01d91d9i96a0zv4.R.inc(1779);__CLB3_3_0_bool0=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1780);return PENDING_FLAG;
      case REVIEWED :if (!__CLB3_3_0_bool0) {__CLR3_3_01d91d9i96a0zv4.R.inc(1781);__CLB3_3_0_bool0=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1782);return REVIEWED_FLAG;
      case REJECTED :if (!__CLB3_3_0_bool0) {__CLR3_3_01d91d9i96a0zv4.R.inc(1783);__CLB3_3_0_bool0=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1784);return REJECTED_FLAG;
      default       :if (!__CLB3_3_0_bool0) {__CLR3_3_01d91d9i96a0zv4.R.inc(1785);__CLB3_3_0_bool0=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1786);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_01d91d9i96a0zv4.R.flushNeeded();}}

  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static ReviewState convertFlagToReviewState(int flag) {try{__CLR3_3_01d91d9i96a0zv4.R.inc(1787);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_01d91d9i96a0zv4.R.inc(1788);switch (flag) {
      case DEFAULT_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_01d91d9i96a0zv4.R.inc(1789);__CLB3_3_0_bool1=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1790);return null;
      case PENDING_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_01d91d9i96a0zv4.R.inc(1791);__CLB3_3_0_bool1=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1792);return ReviewState.PENDING;
      case REVIEWED_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_01d91d9i96a0zv4.R.inc(1793);__CLB3_3_0_bool1=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1794);return ReviewState.REVIEWED;
      case REJECTED_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_01d91d9i96a0zv4.R.inc(1795);__CLB3_3_0_bool1=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1796);return ReviewState.REJECTED;
      default            :if (!__CLB3_3_0_bool1) {__CLR3_3_01d91d9i96a0zv4.R.inc(1797);__CLB3_3_0_bool1=true;} __CLR3_3_01d91d9i96a0zv4.R.inc(1798);return null;
    }
  }finally{__CLR3_3_01d91d9i96a0zv4.R.flushNeeded();}}
}
