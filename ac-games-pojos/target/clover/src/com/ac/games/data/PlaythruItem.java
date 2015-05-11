/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class PlaythruItem {public static class __CLR3_3_01bo1boi96a0zup{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1773,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  private long    playthruID;
  private long    userID;
  private long    gameID;
  private String  gameName;
  private Date    datePlayed;
  private int     numPlayers;
  private String  winnerText;
  private String  playthruText;
  
  public PlaythruItem() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1716);
    __CLR3_3_01bo1boi96a0zup.R.inc(1717);playthruID   = -1L;
    __CLR3_3_01bo1boi96a0zup.R.inc(1718);userID       = -1L;
    __CLR3_3_01bo1boi96a0zup.R.inc(1719);gameID       = -1L;
    __CLR3_3_01bo1boi96a0zup.R.inc(1720);gameName     = null;
    __CLR3_3_01bo1boi96a0zup.R.inc(1721);datePlayed   = null;
    __CLR3_3_01bo1boi96a0zup.R.inc(1722);numPlayers   = -1;
    __CLR3_3_01bo1boi96a0zup.R.inc(1723);winnerText   = null;
    __CLR3_3_01bo1boi96a0zup.R.inc(1724);playthruText = null;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}
  
  public PlaythruItem(String jsonString) {
    super();__CLR3_3_01bo1boi96a0zup.R.inc(1726);try{__CLR3_3_01bo1boi96a0zup.R.inc(1725);
    __CLR3_3_01bo1boi96a0zup.R.inc(1727);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_01bo1boi96a0zup.R.inc(1728);try {
      __CLR3_3_01bo1boi96a0zup.R.inc(1729);PlaythruItem jsonData = mapper.readValue(jsonString, PlaythruItem.class);
      __CLR3_3_01bo1boi96a0zup.R.inc(1730);playthruID   = jsonData.playthruID;
      __CLR3_3_01bo1boi96a0zup.R.inc(1731);userID       = jsonData.userID;
      __CLR3_3_01bo1boi96a0zup.R.inc(1732);gameID       = jsonData.gameID;
      __CLR3_3_01bo1boi96a0zup.R.inc(1733);gameName     = jsonData.gameName;
      __CLR3_3_01bo1boi96a0zup.R.inc(1734);datePlayed   = jsonData.datePlayed;
      __CLR3_3_01bo1boi96a0zup.R.inc(1735);numPlayers   = jsonData.numPlayers;
      __CLR3_3_01bo1boi96a0zup.R.inc(1736);winnerText   = jsonData.winnerText;
      __CLR3_3_01bo1boi96a0zup.R.inc(1737);playthruText = jsonData.playthruText;
    } catch (JsonParseException jpe) {
      __CLR3_3_01bo1boi96a0zup.R.inc(1738);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_01bo1boi96a0zup.R.inc(1739);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_01bo1boi96a0zup.R.inc(1740);ioe.printStackTrace();
    }
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the playthruID
   */
  public long getPlaythruID() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1741);
    __CLR3_3_01bo1boi96a0zup.R.inc(1742);return playthruID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param playthruID the playthruID to set
   */
  public void setPlaythruID(long playthruID) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1743);
    __CLR3_3_01bo1boi96a0zup.R.inc(1744);this.playthruID = playthruID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the userID
   */
  public long getUserID() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1745);
    __CLR3_3_01bo1boi96a0zup.R.inc(1746);return userID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1747);
    __CLR3_3_01bo1boi96a0zup.R.inc(1748);this.userID = userID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1749);
    __CLR3_3_01bo1boi96a0zup.R.inc(1750);return gameID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1751);
    __CLR3_3_01bo1boi96a0zup.R.inc(1752);this.gameID = gameID;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the gameName
   */
  public String getGameName() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1753);
    __CLR3_3_01bo1boi96a0zup.R.inc(1754);return gameName;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param gameName the gameName to set
   */
  public void setGameName(String gameName) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1755);
    __CLR3_3_01bo1boi96a0zup.R.inc(1756);this.gameName = gameName;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the datePlayed
   */
  public Date getDatePlayed() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1757);
    __CLR3_3_01bo1boi96a0zup.R.inc(1758);return datePlayed;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param datePlayed the datePlayed to set
   */
  public void setDatePlayed(Date datePlayed) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1759);
    __CLR3_3_01bo1boi96a0zup.R.inc(1760);this.datePlayed = datePlayed;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the numPlayers
   */
  public int getNumPlayers() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1761);
    __CLR3_3_01bo1boi96a0zup.R.inc(1762);return numPlayers;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param numPlayers the numPlayers to set
   */
  public void setNumPlayers(int numPlayers) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1763);
    __CLR3_3_01bo1boi96a0zup.R.inc(1764);this.numPlayers = numPlayers;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the winnerText
   */
  public String getWinnerText() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1765);
    __CLR3_3_01bo1boi96a0zup.R.inc(1766);return winnerText;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param winnerText the winnerText to set
   */
  public void setWinnerText(String winnerText) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1767);
    __CLR3_3_01bo1boi96a0zup.R.inc(1768);this.winnerText = winnerText;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @return the playthruText
   */
  public String getPlaythruText() {try{__CLR3_3_01bo1boi96a0zup.R.inc(1769);
    __CLR3_3_01bo1boi96a0zup.R.inc(1770);return playthruText;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}

  /**
   * @param playthruText the playthruText to set
   */
  public void setPlaythruText(String playthruText) {try{__CLR3_3_01bo1boi96a0zup.R.inc(1771);
    __CLR3_3_01bo1boi96a0zup.R.inc(1772);this.playthruText = playthruText;
  }finally{__CLR3_3_01bo1boi96a0zup.R.flushNeeded();}}
}
