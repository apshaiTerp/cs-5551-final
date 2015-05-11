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
public class CompactPriceData {public static class __CLR3_3_0g6g6i96a0zlz{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,615,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** The title text for the media item */
  private String titleDisplay;
  /** The price Information to be displayed */
  private String priceDisplay;
  /** The link to open the vendor site */
  private String linkURL;
  /** The thumbnail image used to create a small image for this object */
  private String thumbnailURL;

  public CompactPriceData() {try{__CLR3_3_0g6g6i96a0zlz.R.inc(582);
    __CLR3_3_0g6g6i96a0zlz.R.inc(583);titleDisplay = null;
    __CLR3_3_0g6g6i96a0zlz.R.inc(584);priceDisplay = null;
    __CLR3_3_0g6g6i96a0zlz.R.inc(585);linkURL      = null;
    __CLR3_3_0g6g6i96a0zlz.R.inc(586);thumbnailURL = null;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}
  
  public CompactPriceData(String jsonString) {
    super();__CLR3_3_0g6g6i96a0zlz.R.inc(588);try{__CLR3_3_0g6g6i96a0zlz.R.inc(587);
    __CLR3_3_0g6g6i96a0zlz.R.inc(589);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0g6g6i96a0zlz.R.inc(590);try {
      __CLR3_3_0g6g6i96a0zlz.R.inc(591);CompactPriceData data = mapper.readValue(jsonString, CompactPriceData.class);
      __CLR3_3_0g6g6i96a0zlz.R.inc(592);titleDisplay = data.titleDisplay;
      __CLR3_3_0g6g6i96a0zlz.R.inc(593);priceDisplay = data.priceDisplay;
      __CLR3_3_0g6g6i96a0zlz.R.inc(594);linkURL      = data.linkURL;
      __CLR3_3_0g6g6i96a0zlz.R.inc(595);thumbnailURL = data.thumbnailURL;
    } catch (JsonParseException jpe) {
      __CLR3_3_0g6g6i96a0zlz.R.inc(596);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0g6g6i96a0zlz.R.inc(597);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0g6g6i96a0zlz.R.inc(598);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @return the titleDisplay
   */
  public String getTitleDisplay() {try{__CLR3_3_0g6g6i96a0zlz.R.inc(599);
    __CLR3_3_0g6g6i96a0zlz.R.inc(600);return titleDisplay;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @param titleDisplay the titleDisplay to set
   */
  public void setTitleDisplay(String titleDisplay) {try{__CLR3_3_0g6g6i96a0zlz.R.inc(601);
    __CLR3_3_0g6g6i96a0zlz.R.inc(602);this.titleDisplay = titleDisplay;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @return the priceDisplay
   */
  public String getPriceDisplay() {try{__CLR3_3_0g6g6i96a0zlz.R.inc(603);
    __CLR3_3_0g6g6i96a0zlz.R.inc(604);return priceDisplay;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @param priceDisplay the priceDisplay to set
   */
  public void setPriceDisplay(String priceDisplay) {try{__CLR3_3_0g6g6i96a0zlz.R.inc(605);
    __CLR3_3_0g6g6i96a0zlz.R.inc(606);this.priceDisplay = priceDisplay;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @return the linkURL
   */
  public String getLinkURL() {try{__CLR3_3_0g6g6i96a0zlz.R.inc(607);
    __CLR3_3_0g6g6i96a0zlz.R.inc(608);return linkURL;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @param linkURL the linkURL to set
   */
  public void setLinkURL(String linkURL) {try{__CLR3_3_0g6g6i96a0zlz.R.inc(609);
    __CLR3_3_0g6g6i96a0zlz.R.inc(610);this.linkURL = linkURL;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @return the thumbnailURL
   */
  public String getThumbnailURL() {try{__CLR3_3_0g6g6i96a0zlz.R.inc(611);
    __CLR3_3_0g6g6i96a0zlz.R.inc(612);return thumbnailURL;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}

  /**
   * @param thumbnailURL the thumbnailURL to set
   */
  public void setThumbnailURL(String thumbnailURL) {try{__CLR3_3_0g6g6i96a0zlz.R.inc(613);
    __CLR3_3_0g6g6i96a0zlz.R.inc(614);this.thumbnailURL = thumbnailURL;
  }finally{__CLR3_3_0g6g6i96a0zlz.R.flushNeeded();}}
}
