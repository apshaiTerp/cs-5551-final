/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameReltn {public static class __CLR3_3_0vlvli96a0zq6{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1225,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  private long         reltnID;
  private long         gameID;
  private long         bggID;
  private List<Long>   csiIDs;
  private List<Long>   mmIDs;
  private List<String> asinKeys;
  private List<Long>   otherSites;

  public GameReltn() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1137);
    __CLR3_3_0vlvli96a0zq6.R.inc(1138);reltnID    = -1L;
    __CLR3_3_0vlvli96a0zq6.R.inc(1139);gameID     = -1L;
    __CLR3_3_0vlvli96a0zq6.R.inc(1140);bggID      = -1L;
    __CLR3_3_0vlvli96a0zq6.R.inc(1141);csiIDs     = null;
    __CLR3_3_0vlvli96a0zq6.R.inc(1142);mmIDs      = null;
    __CLR3_3_0vlvli96a0zq6.R.inc(1143);asinKeys   = null;
    __CLR3_3_0vlvli96a0zq6.R.inc(1144);otherSites = null;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}
  
  public GameReltn(String jsonString) {
    super();__CLR3_3_0vlvli96a0zq6.R.inc(1146);try{__CLR3_3_0vlvli96a0zq6.R.inc(1145);
    __CLR3_3_0vlvli96a0zq6.R.inc(1147);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0vlvli96a0zq6.R.inc(1148);try {
      __CLR3_3_0vlvli96a0zq6.R.inc(1149);GameReltn jsonData = mapper.readValue(jsonString, GameReltn.class);
      __CLR3_3_0vlvli96a0zq6.R.inc(1150);reltnID    = jsonData.reltnID;
      __CLR3_3_0vlvli96a0zq6.R.inc(1151);gameID     = jsonData.gameID;
      __CLR3_3_0vlvli96a0zq6.R.inc(1152);bggID      = jsonData.bggID;
      __CLR3_3_0vlvli96a0zq6.R.inc(1153);csiIDs     = jsonData.csiIDs;
      __CLR3_3_0vlvli96a0zq6.R.inc(1154);mmIDs      = jsonData.mmIDs;
      __CLR3_3_0vlvli96a0zq6.R.inc(1155);asinKeys   = jsonData.asinKeys;
      __CLR3_3_0vlvli96a0zq6.R.inc(1156);otherSites = jsonData.otherSites;
    } catch (JsonParseException jpe) {
      __CLR3_3_0vlvli96a0zq6.R.inc(1157);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0vlvli96a0zq6.R.inc(1158);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0vlvli96a0zq6.R.inc(1159);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}
  
  public void printContentsForDebug() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1160);
    __CLR3_3_0vlvli96a0zq6.R.inc(1161);System.out.println ("Printing contents for GameReltn ID " + getReltnID());
    __CLR3_3_0vlvli96a0zq6.R.inc(1162);System.out.println ("============================================================");
    __CLR3_3_0vlvli96a0zq6.R.inc(1163);System.out.println ("Game ID:             " + ((((gameID == -1L )&&(__CLR3_3_0vlvli96a0zq6.R.iget(1164)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1165)==0&false))? "-" : getGameID()));
    __CLR3_3_0vlvli96a0zq6.R.inc(1166);System.out.println ("BoardGameGeek ID:    " + ((((bggID == -1L )&&(__CLR3_3_0vlvli96a0zq6.R.iget(1167)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1168)==0&false))? "-" : getBggID()));
    
    __CLR3_3_0vlvli96a0zq6.R.inc(1169);if ((((getCsiIDs() != null)&&(__CLR3_3_0vlvli96a0zq6.R.iget(1170)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1171)==0&false))) {{
      __CLR3_3_0vlvli96a0zq6.R.inc(1172);System.out.println ("CoolStuffInc IDs:    [" + csiIDs.size() + "]");
      __CLR3_3_0vlvli96a0zq6.R.inc(1173);for (long csiID : csiIDs)
        {__CLR3_3_0vlvli96a0zq6.R.inc(1174);System.out.println ("                     " + csiID);
    }} }else {__CLR3_3_0vlvli96a0zq6.R.inc(1175);System.out.println ("CoolStuffInc IDs:    [-]");

    }__CLR3_3_0vlvli96a0zq6.R.inc(1176);if ((((getMmIDs() != null)&&(__CLR3_3_0vlvli96a0zq6.R.iget(1177)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1178)==0&false))) {{
      __CLR3_3_0vlvli96a0zq6.R.inc(1179);System.out.println ("MiniatureMarket IDs: [" + mmIDs.size() + "]");
      __CLR3_3_0vlvli96a0zq6.R.inc(1180);for (long mmID : mmIDs)
        {__CLR3_3_0vlvli96a0zq6.R.inc(1181);System.out.println ("                     " + mmID);
    }} }else {__CLR3_3_0vlvli96a0zq6.R.inc(1182);System.out.println ("MiniatureMarket IDs: [-]");

    }__CLR3_3_0vlvli96a0zq6.R.inc(1183);if ((((getAsinKeys() != null)&&(__CLR3_3_0vlvli96a0zq6.R.iget(1184)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1185)==0&false))) {{
      __CLR3_3_0vlvli96a0zq6.R.inc(1186);System.out.println ("AsinKeys:            [" + asinKeys.size() + "]");
      __CLR3_3_0vlvli96a0zq6.R.inc(1187);for (String asinKey : asinKeys)
        {__CLR3_3_0vlvli96a0zq6.R.inc(1188);System.out.println ("                     " + asinKey);
    }} }else {__CLR3_3_0vlvli96a0zq6.R.inc(1189);System.out.println ("AsinKeys:            [-]");
    
    }__CLR3_3_0vlvli96a0zq6.R.inc(1190);if ((((getOtherSites() != null)&&(__CLR3_3_0vlvli96a0zq6.R.iget(1191)!=0|true))||(__CLR3_3_0vlvli96a0zq6.R.iget(1192)==0&false))) {{
      __CLR3_3_0vlvli96a0zq6.R.inc(1193);System.out.println ("Other Sites:         [" + otherSites.size() + "]");
      __CLR3_3_0vlvli96a0zq6.R.inc(1194);for (long site : otherSites)
        {__CLR3_3_0vlvli96a0zq6.R.inc(1195);System.out.println ("                     " + site);
    }} }else {__CLR3_3_0vlvli96a0zq6.R.inc(1196);System.out.println ("Other Sites:         [-]");
  }}finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the reltnID
   */
  public long getReltnID() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1197);
    __CLR3_3_0vlvli96a0zq6.R.inc(1198);return reltnID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param reltnID the reltnID to set
   */
  public void setReltnID(long reltnID) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1199);
    __CLR3_3_0vlvli96a0zq6.R.inc(1200);this.reltnID = reltnID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1201);
    __CLR3_3_0vlvli96a0zq6.R.inc(1202);return gameID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1203);
    __CLR3_3_0vlvli96a0zq6.R.inc(1204);this.gameID = gameID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the bggID
   */
  public long getBggID() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1205);
    __CLR3_3_0vlvli96a0zq6.R.inc(1206);return bggID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1207);
    __CLR3_3_0vlvli96a0zq6.R.inc(1208);this.bggID = bggID;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the csiIDs
   */
  public List<Long> getCsiIDs() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1209);
    __CLR3_3_0vlvli96a0zq6.R.inc(1210);return csiIDs;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param csiIDs the csiIDs to set
   */
  public void setCsiIDs(List<Long> csiIDs) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1211);
    __CLR3_3_0vlvli96a0zq6.R.inc(1212);this.csiIDs = csiIDs;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the mmIDs
   */
  public List<Long> getMmIDs() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1213);
    __CLR3_3_0vlvli96a0zq6.R.inc(1214);return mmIDs;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param mmIDs the mmIDs to set
   */
  public void setMmIDs(List<Long> mmIDs) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1215);
    __CLR3_3_0vlvli96a0zq6.R.inc(1216);this.mmIDs = mmIDs;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the asinKeys
   */
  public List<String> getAsinKeys() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1217);
    __CLR3_3_0vlvli96a0zq6.R.inc(1218);return asinKeys;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param asinKeys the asinKeys to set
   */
  public void setAsinKeys(List<String> asinKeys) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1219);
    __CLR3_3_0vlvli96a0zq6.R.inc(1220);this.asinKeys = asinKeys;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @return the otherSites
   */
  public List<Long> getOtherSites() {try{__CLR3_3_0vlvli96a0zq6.R.inc(1221);
    __CLR3_3_0vlvli96a0zq6.R.inc(1222);return otherSites;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}

  /**
   * @param otherSites the otherSites to set
   */
  public void setOtherSites(List<Long> otherSites) {try{__CLR3_3_0vlvli96a0zq6.R.inc(1223);
    __CLR3_3_0vlvli96a0zq6.R.inc(1224);this.otherSites = otherSites;
  }finally{__CLR3_3_0vlvli96a0zq6.R.flushNeeded();}}
}
