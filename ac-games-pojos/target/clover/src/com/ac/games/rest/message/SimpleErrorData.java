/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.rest.message;

/**
 * @author ac010168
 *
 */
public class SimpleErrorData {public static class __CLR3_3_01xu1xui96a100m{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2528,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** A placeholder for the error type.  This may get converted to an enum at some point. */
  private String errorType;
  /** The text we want returned for this message. */
  private String errorMessage;
  
  
  public SimpleErrorData() {try{__CLR3_3_01xu1xui96a100m.R.inc(2514);
    __CLR3_3_01xu1xui96a100m.R.inc(2515);errorType    = "";
    __CLR3_3_01xu1xui96a100m.R.inc(2516);errorMessage = "";
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}
  
  public SimpleErrorData(String errorType, String errorMessage) {try{__CLR3_3_01xu1xui96a100m.R.inc(2517);
    __CLR3_3_01xu1xui96a100m.R.inc(2518);this.errorType    = errorType;
    __CLR3_3_01xu1xui96a100m.R.inc(2519);this.errorMessage = errorMessage;
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}

  /**
   * @return the errorType
   */
  public String getErrorType() {try{__CLR3_3_01xu1xui96a100m.R.inc(2520);
    __CLR3_3_01xu1xui96a100m.R.inc(2521);return errorType;
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}

  /**
   * @param errorType the errorType to set
   */
  public void setErrorType(String errorType) {try{__CLR3_3_01xu1xui96a100m.R.inc(2522);
    __CLR3_3_01xu1xui96a100m.R.inc(2523);this.errorType = errorType;
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}

  /**
   * @param errorMessage the errorMessage to set
   */
  public void setErrorMessage(String errorMessage) {try{__CLR3_3_01xu1xui96a100m.R.inc(2524);
    __CLR3_3_01xu1xui96a100m.R.inc(2525);this.errorMessage = errorMessage;
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}

  /**
   * @return the errorMessage
   */
  public String getErrorMessage() {try{__CLR3_3_01xu1xui96a100m.R.inc(2526);
    __CLR3_3_01xu1xui96a100m.R.inc(2527);return errorMessage;
  }finally{__CLR3_3_01xu1xui96a100m.R.flushNeeded();}}
}
