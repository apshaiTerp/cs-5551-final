/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is just a container for the bggID to help with Serialization.
 * 
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BGGIDOnlyData {public static class __CLR3_3_08h8hi96a0zj4{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,322,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** The objectid for this game on bgg */
  private long bggID;
  
  public BGGIDOnlyData() {try{__CLR3_3_08h8hi96a0zj4.R.inc(305);
    __CLR3_3_08h8hi96a0zj4.R.inc(306);bggID = -1;
  }finally{__CLR3_3_08h8hi96a0zj4.R.flushNeeded();}}
  
  public BGGIDOnlyData(long bggID) {try{__CLR3_3_08h8hi96a0zj4.R.inc(307);
    __CLR3_3_08h8hi96a0zj4.R.inc(308);this.bggID = bggID;
  }finally{__CLR3_3_08h8hi96a0zj4.R.flushNeeded();}}

  public BGGIDOnlyData(String jsonString) {
    super();__CLR3_3_08h8hi96a0zj4.R.inc(310);try{__CLR3_3_08h8hi96a0zj4.R.inc(309);
    __CLR3_3_08h8hi96a0zj4.R.inc(311);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_08h8hi96a0zj4.R.inc(312);try {
      __CLR3_3_08h8hi96a0zj4.R.inc(313);BGGIDOnlyData jsonData = mapper.readValue(jsonString, BGGIDOnlyData.class);
      __CLR3_3_08h8hi96a0zj4.R.inc(314);bggID = jsonData.bggID;
    } catch (JsonParseException jpe) {
      __CLR3_3_08h8hi96a0zj4.R.inc(315);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_08h8hi96a0zj4.R.inc(316);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_08h8hi96a0zj4.R.inc(317);ioe.printStackTrace();
    }
  }finally{__CLR3_3_08h8hi96a0zj4.R.flushNeeded();}}

  /**
   * @return the bggID
   */
  public long getBggID() {try{__CLR3_3_08h8hi96a0zj4.R.inc(318);
    __CLR3_3_08h8hi96a0zj4.R.inc(319);return bggID;
  }finally{__CLR3_3_08h8hi96a0zj4.R.flushNeeded();}}

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {try{__CLR3_3_08h8hi96a0zj4.R.inc(320);
    __CLR3_3_08h8hi96a0zj4.R.inc(321);this.bggID = bggID;
  }finally{__CLR3_3_08h8hi96a0zj4.R.flushNeeded();}}
}
