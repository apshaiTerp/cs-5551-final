/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class CollectionItem implements Comparable<CollectionItem> {public static class __CLR3_3_0e6e6i96a0zlh{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,582,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** The itemID for this collection item */
  private long             itemID;
  /** The gameID of the game that this item represents */
  private long             gameID;
  /** The reference to the game object we want */
  private Game             game;
  /** The list of custom weights assigned by the user to this game */
  private List<GameWeight> weights;
  /** The date the user acquired this game */
  private Date             dateAcquired;
  /** The date when this game was acquired */
  private String           whereAcquired;
  
  //Override fields to replace the basic game numbers (increased player count, etc)
  /** The substitiute value for the minimum player count */
  private int              overrideMinPlayers;
  /** The substitiute value for the maximum player count */
  private int              overrideMaxPlayers;
  /** The substitiute value for the minimum playing time */
  private int              overrideMinTime;
  /** The substitiute value for the maximum playing time */
  private int              overrideMaxTime;
  
  /** Helper list to help render expansions in the collections view */
  private List<CompactSearchData> expansionList;
  
  public CollectionItem() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(510);
    __CLR3_3_0e6e6i96a0zlh.R.inc(511);itemID        = -1;
    __CLR3_3_0e6e6i96a0zlh.R.inc(512);gameID        = -1;
    __CLR3_3_0e6e6i96a0zlh.R.inc(513);game          = null;
    __CLR3_3_0e6e6i96a0zlh.R.inc(514);weights       = null;
    __CLR3_3_0e6e6i96a0zlh.R.inc(515);dateAcquired  = null;
    __CLR3_3_0e6e6i96a0zlh.R.inc(516);whereAcquired = null;
    
    __CLR3_3_0e6e6i96a0zlh.R.inc(517);overrideMinPlayers = -1;
    __CLR3_3_0e6e6i96a0zlh.R.inc(518);overrideMaxPlayers = -1;
    __CLR3_3_0e6e6i96a0zlh.R.inc(519);overrideMinTime    = -1;
    __CLR3_3_0e6e6i96a0zlh.R.inc(520);overrideMaxTime    = -1;
    
    __CLR3_3_0e6e6i96a0zlh.R.inc(521);expansionList      = new ArrayList<CompactSearchData>();
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}
  
  public CollectionItem(String jsonString) {
    super();__CLR3_3_0e6e6i96a0zlh.R.inc(523);try{__CLR3_3_0e6e6i96a0zlh.R.inc(522);
    __CLR3_3_0e6e6i96a0zlh.R.inc(524);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0e6e6i96a0zlh.R.inc(525);try {
      __CLR3_3_0e6e6i96a0zlh.R.inc(526);CollectionItem jsonData = mapper.readValue(jsonString, CollectionItem.class);
      __CLR3_3_0e6e6i96a0zlh.R.inc(527);itemID        = jsonData.itemID;
      __CLR3_3_0e6e6i96a0zlh.R.inc(528);gameID        = jsonData.gameID;
      __CLR3_3_0e6e6i96a0zlh.R.inc(529);game          = jsonData.game;
      __CLR3_3_0e6e6i96a0zlh.R.inc(530);weights       = jsonData.weights;
      __CLR3_3_0e6e6i96a0zlh.R.inc(531);dateAcquired  = jsonData.dateAcquired;
      __CLR3_3_0e6e6i96a0zlh.R.inc(532);whereAcquired = jsonData.whereAcquired;
    } catch (JsonParseException jpe) {
      __CLR3_3_0e6e6i96a0zlh.R.inc(533);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0e6e6i96a0zlh.R.inc(534);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0e6e6i96a0zlh.R.inc(535);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the itemID
   */
  public long getItemID() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(536);
    __CLR3_3_0e6e6i96a0zlh.R.inc(537);return itemID;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param itemID the itemID to set
   */
  public void setItemID(long itemID) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(538);
    __CLR3_3_0e6e6i96a0zlh.R.inc(539);this.itemID = itemID;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(540);
    __CLR3_3_0e6e6i96a0zlh.R.inc(541);return gameID;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(542);
    __CLR3_3_0e6e6i96a0zlh.R.inc(543);this.gameID = gameID;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the weights
   */
  public List<GameWeight> getWeights() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(544);
    __CLR3_3_0e6e6i96a0zlh.R.inc(545);return weights;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param weights the weights to set
   */
  public void setWeights(List<GameWeight> weights) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(546);
    __CLR3_3_0e6e6i96a0zlh.R.inc(547);this.weights = weights;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the dateAcquired
   */
  public Date getDateAcquired() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(548);
    __CLR3_3_0e6e6i96a0zlh.R.inc(549);return dateAcquired;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param dateAcquired the dateAcquired to set
   */
  public void setDateAcquired(Date dateAcquired) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(550);
    __CLR3_3_0e6e6i96a0zlh.R.inc(551);this.dateAcquired = dateAcquired;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the whereAcquired
   */
  public String getWhereAcquired() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(552);
    __CLR3_3_0e6e6i96a0zlh.R.inc(553);return whereAcquired;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param whereAcquired the whereAcquired to set
   */
  public void setWhereAcquired(String whereAcquired) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(554);
    __CLR3_3_0e6e6i96a0zlh.R.inc(555);this.whereAcquired = whereAcquired;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the game
   */
  public Game getGame() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(556);
    __CLR3_3_0e6e6i96a0zlh.R.inc(557);return game;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param game the game to set
   */
  public void setGame(Game game) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(558);
    __CLR3_3_0e6e6i96a0zlh.R.inc(559);this.game = game;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * We want reverse Sort order, so prioritize it that way.
   */
  public int compareTo(CollectionItem o) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(560);
    __CLR3_3_0e6e6i96a0zlh.R.inc(561);return (int)(o.itemID - itemID);
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the overrideMinPlayers
   */
  public int getOverrideMinPlayers() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(562);
    __CLR3_3_0e6e6i96a0zlh.R.inc(563);return overrideMinPlayers;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param overrideMinPlayers the overrideMinPlayers to set
   */
  public void setOverrideMinPlayers(int overrideMinPlayers) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(564);
    __CLR3_3_0e6e6i96a0zlh.R.inc(565);this.overrideMinPlayers = overrideMinPlayers;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the overrideMaxPlayers
   */
  public int getOverrideMaxPlayers() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(566);
    __CLR3_3_0e6e6i96a0zlh.R.inc(567);return overrideMaxPlayers;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param overrideMaxPlayers the overrideMaxPlayers to set
   */
  public void setOverrideMaxPlayers(int overrideMaxPlayers) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(568);
    __CLR3_3_0e6e6i96a0zlh.R.inc(569);this.overrideMaxPlayers = overrideMaxPlayers;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the overrideMinTime
   */
  public int getOverrideMinTime() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(570);
    __CLR3_3_0e6e6i96a0zlh.R.inc(571);return overrideMinTime;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param overrideMinTime the overrideMinTime to set
   */
  public void setOverrideMinTime(int overrideMinTime) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(572);
    __CLR3_3_0e6e6i96a0zlh.R.inc(573);this.overrideMinTime = overrideMinTime;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the overrideMaxTime
   */
  public int getOverrideMaxTime() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(574);
    __CLR3_3_0e6e6i96a0zlh.R.inc(575);return overrideMaxTime;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param overrideMaxTime the overrideMaxTime to set
   */
  public void setOverrideMaxTime(int overrideMaxTime) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(576);
    __CLR3_3_0e6e6i96a0zlh.R.inc(577);this.overrideMaxTime = overrideMaxTime;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @return the expansionList
   */
  public List<CompactSearchData> getExpansionList() {try{__CLR3_3_0e6e6i96a0zlh.R.inc(578);
    __CLR3_3_0e6e6i96a0zlh.R.inc(579);return expansionList;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}

  /**
   * @param expansionList the expansionList to set
   */
  public void setExpansionList(List<CompactSearchData> expansionList) {try{__CLR3_3_0e6e6i96a0zlh.R.inc(580);
    __CLR3_3_0e6e6i96a0zlh.R.inc(581);this.expansionList = expansionList;
  }finally{__CLR3_3_0e6e6i96a0zlh.R.flushNeeded();}}
}
