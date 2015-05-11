/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ac.games.data.CollectionItem;
import com.ac.games.data.GameWeight;
import com.ac.games.data.GameWeightConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class CollectionItemConverter {public static class __CLR3_3_0d2d2i96a4ye2{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,592,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param item The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionItemToIDQuery(CollectionItem item) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(470);
    __CLR3_3_0d2d2i96a4ye2.R.inc(471);if ((((item == null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(472)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(473)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(474);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(475);BasicDBObject dbObject = new BasicDBObject("itemID", item.getItemID());
    __CLR3_3_0d2d2i96a4ye2.R.inc(476);return dbObject;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param itemID The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionItemToIDQuery(long itemID) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(477);
    __CLR3_3_0d2d2i96a4ye2.R.inc(478);if ((((itemID < 0)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(479)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(480)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(481);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(482);BasicDBObject dbObject = new BasicDBObject("itemID", itemID);
    __CLR3_3_0d2d2i96a4ye2.R.inc(483);return dbObject;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param item The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertCollectionItemToMongo(CollectionItem item) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(484);
    __CLR3_3_0d2d2i96a4ye2.R.inc(485);if ((((item == null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(486)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(487)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(488);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(489);BasicDBObject dbObject = new BasicDBObject("itemID", item.getItemID());
    __CLR3_3_0d2d2i96a4ye2.R.inc(490);if ((((item.getGameID() != -1)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(491)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(492)==0&false)))          {__CLR3_3_0d2d2i96a4ye2.R.inc(493);dbObject.append("gameID", item.getGameID());
    }__CLR3_3_0d2d2i96a4ye2.R.inc(494);if ((((item.getGame() != null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(495)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(496)==0&false)))          {__CLR3_3_0d2d2i96a4ye2.R.inc(497);dbObject.append("game", GameConverter.convertGameToMongo(item.getGame()));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(498);if ((((item.getWeights() != null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(499)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(500)==0&false)))       {__CLR3_3_0d2d2i96a4ye2.R.inc(501);dbObject.append("weights", convertList(item.getWeights()));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(502);if ((((item.getDateAcquired() != null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(503)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(504)==0&false)))  {__CLR3_3_0d2d2i96a4ye2.R.inc(505);dbObject.append("dateAcquired", item.getDateAcquired());
    }__CLR3_3_0d2d2i96a4ye2.R.inc(506);if ((((item.getWhereAcquired() != null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(507)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(508)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(509);dbObject.append("whereAcquired", item.getWhereAcquired());
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(510);if ((((item.getOverrideMinPlayers() != -1)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(511)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(512)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(513);dbObject.append("overrideMinPlayers", item.getOverrideMinPlayers());
    }__CLR3_3_0d2d2i96a4ye2.R.inc(514);if ((((item.getOverrideMaxPlayers() != -1)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(515)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(516)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(517);dbObject.append("overrideMaxPlayers", item.getOverrideMaxPlayers());
    }__CLR3_3_0d2d2i96a4ye2.R.inc(518);if ((((item.getOverrideMinTime() != -1)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(519)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(520)==0&false)))    {__CLR3_3_0d2d2i96a4ye2.R.inc(521);dbObject.append("overrideMinTime", item.getOverrideMinTime());
    }__CLR3_3_0d2d2i96a4ye2.R.inc(522);if ((((item.getOverrideMaxTime() != -1)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(523)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(524)==0&false)))    {__CLR3_3_0d2d2i96a4ye2.R.inc(525);dbObject.append("overrideMaxTime", item.getOverrideMaxTime());
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(526);return dbObject;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link CollectionItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link CollectionItem} object, or null if the dbObject was null
   */
  public static CollectionItem convertMongoToCollectionItem(DBObject dbObject) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(527);
    __CLR3_3_0d2d2i96a4ye2.R.inc(528);if ((((dbObject == null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(529)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(530)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(531);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(532);CollectionItem item = new CollectionItem();
    __CLR3_3_0d2d2i96a4ye2.R.inc(533);if ((((dbObject.containsField("itemID"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(534)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(535)==0&false)))        {__CLR3_3_0d2d2i96a4ye2.R.inc(536);item.setItemID((Long)dbObject.get("itemID"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(537);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(538)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(539)==0&false)))        {__CLR3_3_0d2d2i96a4ye2.R.inc(540);item.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(541);if ((((dbObject.containsField("game"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(542)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(543)==0&false)))          {__CLR3_3_0d2d2i96a4ye2.R.inc(544);item.setGame(GameConverter.convertMongoToGame((DBObject)dbObject.get("game")));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(545);if ((((dbObject.containsField("weights"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(546)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(547)==0&false)))       {__CLR3_3_0d2d2i96a4ye2.R.inc(548);item.setWeights(convertDBListToGameWeightList((BasicDBList)dbObject.get("weights")));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(549);if ((((dbObject.containsField("dateAcquired"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(550)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(551)==0&false)))  {__CLR3_3_0d2d2i96a4ye2.R.inc(552);item.setDateAcquired((Date)dbObject.get("dateAcquired"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(553);if ((((dbObject.containsField("whereAcquired"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(554)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(555)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(556);item.setWhereAcquired((String)dbObject.get("whereAcquired"));
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(557);if ((((dbObject.containsField("overrideMinPlayers"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(558)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(559)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(560);item.setOverrideMinPlayers((Integer)dbObject.get("overrideMinPlayers"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(561);if ((((dbObject.containsField("overrideMaxPlayers"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(562)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(563)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(564);item.setOverrideMaxPlayers((Integer)dbObject.get("overrideMaxPlayers"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(565);if ((((dbObject.containsField("overrideMinTime"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(566)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(567)==0&false)))    {__CLR3_3_0d2d2i96a4ye2.R.inc(568);item.setOverrideMinTime((Integer)dbObject.get("overrideMinTime"));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(569);if ((((dbObject.containsField("overrideMaxTime"))&&(__CLR3_3_0d2d2i96a4ye2.R.iget(570)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(571)==0&false)))    {__CLR3_3_0d2d2i96a4ye2.R.inc(572);item.setOverrideMaxTime((Integer)dbObject.get("overrideMaxTime"));
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(573);return item;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<GameWeight> curList) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(574);
    __CLR3_3_0d2d2i96a4ye2.R.inc(575);if ((((curList == null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(576)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(577)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(578);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(579);BasicDBList newList = new BasicDBList();
    __CLR3_3_0d2d2i96a4ye2.R.inc(580);for (GameWeight obj : curList)
      {__CLR3_3_0d2d2i96a4ye2.R.inc(581);newList.add(GameWeightConverter.convertGameWeightToFlag(obj));
    }__CLR3_3_0d2d2i96a4ye2.R.inc(582);return newList;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<GameWeight> convertDBListToGameWeightList(BasicDBList curList) {try{__CLR3_3_0d2d2i96a4ye2.R.inc(583);
    __CLR3_3_0d2d2i96a4ye2.R.inc(584);if ((((curList == null)&&(__CLR3_3_0d2d2i96a4ye2.R.iget(585)!=0|true))||(__CLR3_3_0d2d2i96a4ye2.R.iget(586)==0&false))) {__CLR3_3_0d2d2i96a4ye2.R.inc(587);return null;
    
    }__CLR3_3_0d2d2i96a4ye2.R.inc(588);List<GameWeight> newList = new ArrayList<GameWeight>(curList.size());
    __CLR3_3_0d2d2i96a4ye2.R.inc(589);for (Object obj : curList) {{
      __CLR3_3_0d2d2i96a4ye2.R.inc(590);newList.add(GameWeightConverter.convertFlagToGameWeight((Integer)obj));
    }
    }__CLR3_3_0d2d2i96a4ye2.R.inc(591);return newList;
  }finally{__CLR3_3_0d2d2i96a4ye2.R.flushNeeded();}}
}
