/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.rest.message;

/**
 * @author ac010168
 *
 */
public class SimpleMessageData {public static class __CLR3_3_01y81y8i96a100w{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2542,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** A placeholder for the error type.  This may get converted to an enum at some point. */
  private String messageType;
  /** The text we want returned for this message. */
  private String message;
  
  public SimpleMessageData() {try{__CLR3_3_01y81y8i96a100w.R.inc(2528);
    __CLR3_3_01y81y8i96a100w.R.inc(2529);messageType = "";
    __CLR3_3_01y81y8i96a100w.R.inc(2530);message     = "";
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}
  
  public SimpleMessageData(String messageType, String message) {try{__CLR3_3_01y81y8i96a100w.R.inc(2531);
    __CLR3_3_01y81y8i96a100w.R.inc(2532);this.messageType = messageType;
    __CLR3_3_01y81y8i96a100w.R.inc(2533);this.message     = message;
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}

  /**
   * @return the errorType
   */
  public String getMessageType() {try{__CLR3_3_01y81y8i96a100w.R.inc(2534);
    __CLR3_3_01y81y8i96a100w.R.inc(2535);return messageType;
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}

  /**
   * @return the errorMessage
   */
  public String getMessage() {try{__CLR3_3_01y81y8i96a100w.R.inc(2536);
    __CLR3_3_01y81y8i96a100w.R.inc(2537);return message;
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}

  /**
   * @param messageType the messageType to set
   */
  public void setMessageType(String messageType) {try{__CLR3_3_01y81y8i96a100w.R.inc(2538);
    __CLR3_3_01y81y8i96a100w.R.inc(2539);this.messageType = messageType;
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {try{__CLR3_3_01y81y8i96a100w.R.inc(2540);
    __CLR3_3_01y81y8i96a100w.R.inc(2541);this.message = message;
  }finally{__CLR3_3_01y81y8i96a100w.R.flushNeeded();}}
}
