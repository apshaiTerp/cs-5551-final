/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompactSearchData {public static class __CLR3_3_0h3h3i96a0zmc{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,648,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** The string that should be displayed in the auto-complete or quick search window */
  private String displayString;
  /** The source field (typically the mongo field name, like bggID, of this ID value */
  private String sourceField;
  /** The actual ID value for the corresponding object */
  private long   sourceID;
  /** The thumbnail image used to create a small image for this object */
  private String thumbnailURL;

  public CompactSearchData() {try{__CLR3_3_0h3h3i96a0zmc.R.inc(615);
    __CLR3_3_0h3h3i96a0zmc.R.inc(616);displayString = null;
    __CLR3_3_0h3h3i96a0zmc.R.inc(617);sourceField   = null;
    __CLR3_3_0h3h3i96a0zmc.R.inc(618);sourceID      = -1L;
    __CLR3_3_0h3h3i96a0zmc.R.inc(619);thumbnailURL  = null;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}
  
  public CompactSearchData(String jsonString) {
    super();__CLR3_3_0h3h3i96a0zmc.R.inc(621);try{__CLR3_3_0h3h3i96a0zmc.R.inc(620);
    __CLR3_3_0h3h3i96a0zmc.R.inc(622);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0h3h3i96a0zmc.R.inc(623);try {
      __CLR3_3_0h3h3i96a0zmc.R.inc(624);CompactSearchData data = mapper.readValue(jsonString, CompactSearchData.class);
      __CLR3_3_0h3h3i96a0zmc.R.inc(625);displayString = data.displayString;
      __CLR3_3_0h3h3i96a0zmc.R.inc(626);sourceField   = data.sourceField;
      __CLR3_3_0h3h3i96a0zmc.R.inc(627);sourceID      = data.sourceID;
      __CLR3_3_0h3h3i96a0zmc.R.inc(628);thumbnailURL  = data.thumbnailURL;
    } catch (JsonParseException jpe) {
      __CLR3_3_0h3h3i96a0zmc.R.inc(629);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0h3h3i96a0zmc.R.inc(630);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0h3h3i96a0zmc.R.inc(631);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @return the displayString
   */
  public String getDisplayString() {try{__CLR3_3_0h3h3i96a0zmc.R.inc(632);
    __CLR3_3_0h3h3i96a0zmc.R.inc(633);return displayString;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @param displayString the displayString to set
   */
  public void setDisplayString(String displayString) {try{__CLR3_3_0h3h3i96a0zmc.R.inc(634);
    __CLR3_3_0h3h3i96a0zmc.R.inc(635);this.displayString = displayString;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @return the sourceField
   */
  public String getSourceField() {try{__CLR3_3_0h3h3i96a0zmc.R.inc(636);
    __CLR3_3_0h3h3i96a0zmc.R.inc(637);return sourceField;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @param sourceField the sourceField to set
   */
  public void setSourceField(String sourceField) {try{__CLR3_3_0h3h3i96a0zmc.R.inc(638);
    __CLR3_3_0h3h3i96a0zmc.R.inc(639);this.sourceField = sourceField;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @return the sourceID
   */
  public long getSourceID() {try{__CLR3_3_0h3h3i96a0zmc.R.inc(640);
    __CLR3_3_0h3h3i96a0zmc.R.inc(641);return sourceID;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @param sourceID the sourceID to set
   */
  public void setSourceID(long sourceID) {try{__CLR3_3_0h3h3i96a0zmc.R.inc(642);
    __CLR3_3_0h3h3i96a0zmc.R.inc(643);this.sourceID = sourceID;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @return the thumbnailURL
   */
  public String getThumbnailURL() {try{__CLR3_3_0h3h3i96a0zmc.R.inc(644);
    __CLR3_3_0h3h3i96a0zmc.R.inc(645);return thumbnailURL;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}

  /**
   * @param thumbnailURL the thumbnailURL to set
   */
  public void setThumbnailURL(String thumbnailURL) {try{__CLR3_3_0h3h3i96a0zmc.R.inc(646);
    __CLR3_3_0h3h3i96a0zmc.R.inc(647);this.thumbnailURL = thumbnailURL;
  }finally{__CLR3_3_0h3h3i96a0zmc.R.flushNeeded();}}
}
