/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * Helper class to make sorting categories easier
 * 
 * @author ac010168
 *
 */
public class SimpleSortable implements Comparable<SimpleSortable> {public static class __CLR3_3_01dz1dzi96a0zvd{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1815,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  private String content;
  private int hits;
  
  public SimpleSortable() {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1799);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1800);content = null;
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1801);hits = 0;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}
  
  public SimpleSortable(String content) {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1802);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1803);this.content = content;
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1804);hits = 0;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}
  
  public int compareTo(SimpleSortable o) {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1805);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1806);return (o.hits - hits);
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}

  /**
   * @return the content
   */
  public String getContent() {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1807);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1808);return content;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}

  /**
   * @param content the content to set
   */
  public void setContent(String content) {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1809);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1810);this.content = content;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}

  /**
   * @return the hits
   */
  public int getHits() {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1811);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1812);return hits;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}

  /**
   * @param hits the hits to set
   */
  public void setHits(int hits) {try{__CLR3_3_01dz1dzi96a0zvd.R.inc(1813);
    __CLR3_3_01dz1dzi96a0zvd.R.inc(1814);this.hits = hits;
  }finally{__CLR3_3_01dz1dzi96a0zvd.R.flushNeeded();}}

}
