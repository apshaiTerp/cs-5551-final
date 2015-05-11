/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.LinkedList;
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
public class Collection {public static class __CLR3_3_0bfbfi96a0zkp{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,510,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /**  */
  private long                 collectionID;
  private List<CollectionItem> games;
  private int                  baseGameCount;
  private int                  collectibleGameCount;
  private int                  expansionGameCount;
  
  //TODO - May be some other things coming later
  
  public Collection() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(411);
    __CLR3_3_0bfbfi96a0zkp.R.inc(412);collectionID         = -1;
    __CLR3_3_0bfbfi96a0zkp.R.inc(413);games                = new LinkedList<CollectionItem>();
    __CLR3_3_0bfbfi96a0zkp.R.inc(414);baseGameCount        = 0;
    __CLR3_3_0bfbfi96a0zkp.R.inc(415);collectibleGameCount = 0;
    __CLR3_3_0bfbfi96a0zkp.R.inc(416);expansionGameCount   = 0;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}
  
  public Collection(String jsonString) {
    super();__CLR3_3_0bfbfi96a0zkp.R.inc(418);try{__CLR3_3_0bfbfi96a0zkp.R.inc(417);
    __CLR3_3_0bfbfi96a0zkp.R.inc(419);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0bfbfi96a0zkp.R.inc(420);try {
      __CLR3_3_0bfbfi96a0zkp.R.inc(421);Collection jsonData = mapper.readValue(jsonString, Collection.class);
      __CLR3_3_0bfbfi96a0zkp.R.inc(422);collectionID         = jsonData.collectionID;
      __CLR3_3_0bfbfi96a0zkp.R.inc(423);games                = jsonData.games;
      __CLR3_3_0bfbfi96a0zkp.R.inc(424);baseGameCount        = jsonData.baseGameCount;
      __CLR3_3_0bfbfi96a0zkp.R.inc(425);collectibleGameCount = jsonData.collectibleGameCount;
      __CLR3_3_0bfbfi96a0zkp.R.inc(426);expansionGameCount   = jsonData.expansionGameCount;
    } catch (JsonParseException jpe) {
      __CLR3_3_0bfbfi96a0zkp.R.inc(427);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0bfbfi96a0zkp.R.inc(428);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0bfbfi96a0zkp.R.inc(429);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}
  
  /**
   * This constructor should initialize an empty collection.
   * 
   * @param collectionID The ID for this new collection
   */
  public Collection(long collectionID) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(430);
    __CLR3_3_0bfbfi96a0zkp.R.inc(431);this.collectionID    = collectionID;
    __CLR3_3_0bfbfi96a0zkp.R.inc(432);games                = new LinkedList<CollectionItem>();
    __CLR3_3_0bfbfi96a0zkp.R.inc(433);baseGameCount        = 0;
    __CLR3_3_0bfbfi96a0zkp.R.inc(434);collectibleGameCount = 0;
    __CLR3_3_0bfbfi96a0zkp.R.inc(435);expansionGameCount   = 0;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}
  
  public void addGame(CollectionItem game) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(436);
    __CLR3_3_0bfbfi96a0zkp.R.inc(437);if ((((game == null)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(438)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(439)==0&false)))           {__CLR3_3_0bfbfi96a0zkp.R.inc(440);return;
    }__CLR3_3_0bfbfi96a0zkp.R.inc(441);if ((((game.getGame() == null)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(442)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(443)==0&false))) {__CLR3_3_0bfbfi96a0zkp.R.inc(444);return;
    
    //We should check to make sure the item doesn't already exist in our collection
    }__CLR3_3_0bfbfi96a0zkp.R.inc(445);for (CollectionItem curGame : games) {{
      __CLR3_3_0bfbfi96a0zkp.R.inc(446);if ((((curGame.getGameID() == game.getGameID())&&(__CLR3_3_0bfbfi96a0zkp.R.iget(447)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(448)==0&false)))
        {__CLR3_3_0bfbfi96a0zkp.R.inc(449);return;
    }}

    }__CLR3_3_0bfbfi96a0zkp.R.inc(450);games.add(game);
    __CLR3_3_0bfbfi96a0zkp.R.inc(451);if ((((game.getGame().getGameType() == GameType.BASE)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(452)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(453)==0&false)))        {__CLR3_3_0bfbfi96a0zkp.R.inc(454);baseGameCount++;
    }__CLR3_3_0bfbfi96a0zkp.R.inc(455);if ((((game.getGame().getGameType() == GameType.COLLECTIBLE)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(456)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(457)==0&false))) {__CLR3_3_0bfbfi96a0zkp.R.inc(458);collectibleGameCount++;
    }__CLR3_3_0bfbfi96a0zkp.R.inc(459);if ((((game.getGame().getGameType() == GameType.EXPANSION)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(460)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(461)==0&false)))   {__CLR3_3_0bfbfi96a0zkp.R.inc(462);expansionGameCount++;
  }}finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}
  
  public void removeGame(CollectionItem game) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(463);
    __CLR3_3_0bfbfi96a0zkp.R.inc(464);if ((((game == null)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(465)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(466)==0&false)))           {__CLR3_3_0bfbfi96a0zkp.R.inc(467);return;
    }__CLR3_3_0bfbfi96a0zkp.R.inc(468);if ((((game.getGame() == null)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(469)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(470)==0&false))) {__CLR3_3_0bfbfi96a0zkp.R.inc(471);return;
    
    }__CLR3_3_0bfbfi96a0zkp.R.inc(472);for (CollectionItem curGame : games) {{
      __CLR3_3_0bfbfi96a0zkp.R.inc(473);if ((((curGame.getGameID() == game.getGameID())&&(__CLR3_3_0bfbfi96a0zkp.R.iget(474)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(475)==0&false))) {{
        __CLR3_3_0bfbfi96a0zkp.R.inc(476);games.remove(curGame);
        __CLR3_3_0bfbfi96a0zkp.R.inc(477);if ((((curGame.getGame().getGameType() == GameType.BASE)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(478)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(479)==0&false)))        {__CLR3_3_0bfbfi96a0zkp.R.inc(480);baseGameCount--;
        }__CLR3_3_0bfbfi96a0zkp.R.inc(481);if ((((curGame.getGame().getGameType() == GameType.COLLECTIBLE)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(482)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(483)==0&false))) {__CLR3_3_0bfbfi96a0zkp.R.inc(484);collectibleGameCount--;
        }__CLR3_3_0bfbfi96a0zkp.R.inc(485);if ((((curGame.getGame().getGameType() == GameType.EXPANSION)&&(__CLR3_3_0bfbfi96a0zkp.R.iget(486)!=0|true))||(__CLR3_3_0bfbfi96a0zkp.R.iget(487)==0&false)))   {__CLR3_3_0bfbfi96a0zkp.R.inc(488);expansionGameCount--;
        }__CLR3_3_0bfbfi96a0zkp.R.inc(489);return;
      }
    }}
  }}finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @return the collectionID
   */
  public long getCollectionID() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(490);
    __CLR3_3_0bfbfi96a0zkp.R.inc(491);return collectionID;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @param collectionID the collectionID to set
   */
  public void setCollectionID(long collectionID) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(492);
    __CLR3_3_0bfbfi96a0zkp.R.inc(493);this.collectionID = collectionID;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @return the games
   */
  public List<CollectionItem> getGames() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(494);
    __CLR3_3_0bfbfi96a0zkp.R.inc(495);return games;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @param games the games to set
   */
  public void setGames(List<CollectionItem> games) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(496);
    __CLR3_3_0bfbfi96a0zkp.R.inc(497);this.games = games;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @return the baseGameCount
   */
  public int getBaseGameCount() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(498);
    __CLR3_3_0bfbfi96a0zkp.R.inc(499);return baseGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @param baseGameCount the baseGameCount to set
   */
  public void setBaseGameCount(int baseGameCount) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(500);
    __CLR3_3_0bfbfi96a0zkp.R.inc(501);this.baseGameCount = baseGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @return the collectibleGameCount
   */
  public int getCollectibleGameCount() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(502);
    __CLR3_3_0bfbfi96a0zkp.R.inc(503);return collectibleGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @param collectibleGameCount the collectibleGameCount to set
   */
  public void setCollectibleGameCount(int collectibleGameCount) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(504);
    __CLR3_3_0bfbfi96a0zkp.R.inc(505);this.collectibleGameCount = collectibleGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @return the expansionGameCount
   */
  public int getExpansionGameCount() {try{__CLR3_3_0bfbfi96a0zkp.R.inc(506);
    __CLR3_3_0bfbfi96a0zkp.R.inc(507);return expansionGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}

  /**
   * @param expansionGameCount the expansionGameCount to set
   */
  public void setExpansionGameCount(int expansionGameCount) {try{__CLR3_3_0bfbfi96a0zkp.R.inc(508);
    __CLR3_3_0bfbfi96a0zkp.R.inc(509);this.expansionGameCount = expansionGameCount;
  }finally{__CLR3_3_0bfbfi96a0zkp.R.flushNeeded();}}
}
