/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ac.games.data.CompactSearchData;
import com.ac.games.data.Game;
import com.ac.games.data.GameTypeConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * 
 * @author ac010168
 *
 */
public class GameConverter {public static class __CLR3_3_0ggggi96a4yfd{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,841,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the gameID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(Game game) {try{__CLR3_3_0ggggi96a4yfd.R.inc(592);
    __CLR3_3_0ggggi96a4yfd.R.inc(593);if ((((game == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(594)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(595)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(596);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(597);BasicDBObject dbObject = new BasicDBObject("gameID", game.getGameID());
    __CLR3_3_0ggggi96a4yfd.R.inc(598);return dbObject;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic query using the gameID representing the provided game.
   * 
   * @param gameID The game ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(long gameID) {try{__CLR3_3_0ggggi96a4yfd.R.inc(599);
    __CLR3_3_0ggggi96a4yfd.R.inc(600);if ((((gameID < 0)&&(__CLR3_3_0ggggi96a4yfd.R.iget(601)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(602)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(603);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(604);BasicDBObject dbObject = new BasicDBObject("gameID", new Long(gameID));
    __CLR3_3_0ggggi96a4yfd.R.inc(605);return dbObject;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic query using the gameID representing the provided game.
   * 
   * @param bggID The bggID used to create this game that we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToBGGIDQuery(long bggID) {try{__CLR3_3_0ggggi96a4yfd.R.inc(606);
    __CLR3_3_0ggggi96a4yfd.R.inc(607);if ((((bggID < 0)&&(__CLR3_3_0ggggi96a4yfd.R.iget(608)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(609)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(610);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(611);BasicDBObject dbObject = new BasicDBObject("bggID", new Long(bggID));
    __CLR3_3_0ggggi96a4yfd.R.inc(612);return dbObject;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic database record for the provided game object.
   * 
   * @param game The Game we want to build a database record for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if no game was provided
   */
  public static BasicDBObject convertGameToMongo(Game game) {try{__CLR3_3_0ggggi96a4yfd.R.inc(613);
    __CLR3_3_0ggggi96a4yfd.R.inc(614);if ((((game == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(615)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(616)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(617);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(618);BasicDBObject dbObject = new BasicDBObject("gameID", game.getGameID());
    
    __CLR3_3_0ggggi96a4yfd.R.inc(619);if ((((game.getBggID() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(620)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(621)==0&false)))               {__CLR3_3_0ggggi96a4yfd.R.inc(622);dbObject.append("bggID", game.getBggID());
    }__CLR3_3_0ggggi96a4yfd.R.inc(623);if ((((game.getName() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(624)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(625)==0&false)))              {__CLR3_3_0ggggi96a4yfd.R.inc(626);dbObject.append("name", game.getName());
    }__CLR3_3_0ggggi96a4yfd.R.inc(627);if ((((game.getYearPublished() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(628)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(629)==0&false)))       {__CLR3_3_0ggggi96a4yfd.R.inc(630);dbObject.append("yearPublished", game.getYearPublished());
    }__CLR3_3_0ggggi96a4yfd.R.inc(631);if ((((game.getMinPlayers() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(632)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(633)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(634);dbObject.append("minPlayers", game.getMinPlayers());
    }__CLR3_3_0ggggi96a4yfd.R.inc(635);if ((((game.getMaxPlayers() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(636)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(637)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(638);dbObject.append("maxPlayers", game.getMaxPlayers());
    }__CLR3_3_0ggggi96a4yfd.R.inc(639);if ((((game.getMinPlayingTime() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(640)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(641)==0&false)))      {__CLR3_3_0ggggi96a4yfd.R.inc(642);dbObject.append("minPlayingTime", game.getMinPlayingTime());
    }__CLR3_3_0ggggi96a4yfd.R.inc(643);if ((((game.getMaxPlayingTime() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(644)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(645)==0&false)))      {__CLR3_3_0ggggi96a4yfd.R.inc(646);dbObject.append("maxPlayingTime", game.getMaxPlayingTime());
    }__CLR3_3_0ggggi96a4yfd.R.inc(647);if ((((game.getImageURL() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(648)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(649)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(650);dbObject.append("imageURL", game.getImageURL());
    }__CLR3_3_0ggggi96a4yfd.R.inc(651);if ((((game.getImageThumbnailURL() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(652)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(653)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(654);dbObject.append("imageThumbnailURL", game.getImageThumbnailURL());
    }__CLR3_3_0ggggi96a4yfd.R.inc(655);if ((((game.getDescription() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(656)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(657)==0&false)))       {__CLR3_3_0ggggi96a4yfd.R.inc(658);dbObject.append("description", game.getDescription());
    }__CLR3_3_0ggggi96a4yfd.R.inc(659);if ((((game.getPrimaryPublisher() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(660)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(661)==0&false)))  {__CLR3_3_0ggggi96a4yfd.R.inc(662);dbObject.append("primaryPublisher", game.getPrimaryPublisher());
    }__CLR3_3_0ggggi96a4yfd.R.inc(663);if ((((game.getPublishers() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(664)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(665)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(666);dbObject.append("publishers", convertList(game.getPublishers()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(667);if ((((game.getDesigners() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(668)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(669)==0&false)))         {__CLR3_3_0ggggi96a4yfd.R.inc(670);dbObject.append("designers", convertList(game.getDesigners()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(671);if ((((game.getCategories() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(672)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(673)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(674);dbObject.append("categories", convertList(game.getCategories()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(675);if ((((game.getMechanisms() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(676)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(677)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(678);dbObject.append("mechanisms", convertList(game.getMechanisms()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(679);if ((((game.getExpansionIDs() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(680)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(681)==0&false)))      {__CLR3_3_0ggggi96a4yfd.R.inc(682);dbObject.append("expansionIDs", convertList(game.getExpansionIDs()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(683);if ((((game.getParentGameID() != -1)&&(__CLR3_3_0ggggi96a4yfd.R.iget(684)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(685)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(686);dbObject.append("parentGameID", game.getParentGameID());
    //Need a converter here because BSON won't accept Enums for serializability
    }__CLR3_3_0ggggi96a4yfd.R.inc(687);if ((((game.getGameType() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(688)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(689)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(690);dbObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(game.getGameType()));
    }__CLR3_3_0ggggi96a4yfd.R.inc(691);if ((((game.getAddDate() != null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(692)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(693)==0&false)))           {__CLR3_3_0ggggi96a4yfd.R.inc(694);dbObject.append("addDate", game.getAddDate());
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(695);return dbObject;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link Game} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link Game} object, or null if the dbObject was null
   */
  public static Game convertMongoToGame(DBObject dbObject) {try{__CLR3_3_0ggggi96a4yfd.R.inc(696);
    __CLR3_3_0ggggi96a4yfd.R.inc(697);if ((((dbObject == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(698)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(699)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(700);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(701);Game game = new Game();
    
    __CLR3_3_0ggggi96a4yfd.R.inc(702);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(703)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(704)==0&false)))            {__CLR3_3_0ggggi96a4yfd.R.inc(705);game.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(706);if ((((dbObject.containsField("bggID"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(707)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(708)==0&false)))             {__CLR3_3_0ggggi96a4yfd.R.inc(709);game.setBggID((Long)dbObject.get("bggID"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(710);if ((((dbObject.containsField("name"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(711)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(712)==0&false)))              {__CLR3_3_0ggggi96a4yfd.R.inc(713);game.setName((String)dbObject.get("name"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(714);if ((((dbObject.containsField("yearPublished"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(715)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(716)==0&false)))     {__CLR3_3_0ggggi96a4yfd.R.inc(717);game.setYearPublished((Integer)dbObject.get("yearPublished"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(718);if ((((dbObject.containsField("minPlayers"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(719)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(720)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(721);game.setMinPlayers((Integer)dbObject.get("minPlayers"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(722);if ((((dbObject.containsField("maxPlayers"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(723)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(724)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(725);game.setMaxPlayers((Integer)dbObject.get("maxPlayers"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(726);if ((((dbObject.containsField("minPlayingTime"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(727)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(728)==0&false)))    {__CLR3_3_0ggggi96a4yfd.R.inc(729);game.setMinPlayingTime((Integer)dbObject.get("minPlayingTime"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(730);if ((((dbObject.containsField("maxPlayingTime"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(731)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(732)==0&false)))    {__CLR3_3_0ggggi96a4yfd.R.inc(733);game.setMaxPlayingTime((Integer)dbObject.get("maxPlayingTime"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(734);if ((((dbObject.containsField("imageURL"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(735)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(736)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(737);game.setImageURL((String)dbObject.get("imageURL"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(738);if ((((dbObject.containsField("imageThumbnailURL"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(739)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(740)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(741);game.setImageThumbnailURL((String)dbObject.get("imageThumbnailURL"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(742);if ((((dbObject.containsField("description"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(743)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(744)==0&false)))       {__CLR3_3_0ggggi96a4yfd.R.inc(745);game.setDescription((String)dbObject.get("description"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(746);if ((((dbObject.containsField("primaryPublisher"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(747)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(748)==0&false)))  {__CLR3_3_0ggggi96a4yfd.R.inc(749);game.setPrimaryPublisher((String)dbObject.get("primaryPublisher"));
    }__CLR3_3_0ggggi96a4yfd.R.inc(750);if ((((dbObject.containsField("publishers"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(751)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(752)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(753);game.setPublishers(convertDBListToStringList((BasicDBList)dbObject.get("publishers")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(754);if ((((dbObject.containsField("designers"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(755)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(756)==0&false)))         {__CLR3_3_0ggggi96a4yfd.R.inc(757);game.setDesigners(convertDBListToStringList((BasicDBList)dbObject.get("designers")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(758);if ((((dbObject.containsField("categories"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(759)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(760)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(761);game.setCategories(convertDBListToStringList((BasicDBList)dbObject.get("categories")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(762);if ((((dbObject.containsField("mechanisms"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(763)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(764)==0&false)))        {__CLR3_3_0ggggi96a4yfd.R.inc(765);game.setMechanisms(convertDBListToStringList((BasicDBList)dbObject.get("mechanisms")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(766);if ((((dbObject.containsField("expansionIDs"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(767)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(768)==0&false)))      {__CLR3_3_0ggggi96a4yfd.R.inc(769);game.setExpansionIDs(convertDBListToLongList((BasicDBList)dbObject.get("expansionIDs")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(770);if ((((dbObject.containsField("parentGameID"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(771)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(772)==0&false)))      {__CLR3_3_0ggggi96a4yfd.R.inc(773);game.setParentGameID((Long)dbObject.get("parentGameID"));
    //Need a converter here because BSON won't accept Enums for serializability
    }__CLR3_3_0ggggi96a4yfd.R.inc(774);if ((((dbObject.containsField("gameType"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(775)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(776)==0&false)))          {__CLR3_3_0ggggi96a4yfd.R.inc(777);game.setGameType(GameTypeConverter.convertFlagToGameType((Integer)dbObject.get("gameType")));
    }__CLR3_3_0ggggi96a4yfd.R.inc(778);if ((((dbObject.containsField("addDate"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(779)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(780)==0&false)))           {__CLR3_3_0ggggi96a4yfd.R.inc(781);game.setAddDate((Date)dbObject.get("addDate"));
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(782);return game;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}
  
  public static CompactSearchData convertMongoToCompact(DBObject dbObject) {try{__CLR3_3_0ggggi96a4yfd.R.inc(783);
    __CLR3_3_0ggggi96a4yfd.R.inc(784);if ((((dbObject == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(785)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(786)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(787);return null;
      
    }__CLR3_3_0ggggi96a4yfd.R.inc(788);CompactSearchData data = new CompactSearchData();
    
    __CLR3_3_0ggggi96a4yfd.R.inc(789);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(790)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(791)==0&false))) {{
      __CLR3_3_0ggggi96a4yfd.R.inc(792);data.setSourceID((Long)dbObject.get("gameID"));  
      __CLR3_3_0ggggi96a4yfd.R.inc(793);data.setSourceField("gameID");
    }
    }__CLR3_3_0ggggi96a4yfd.R.inc(794);String nameText = "Unavailable";
    __CLR3_3_0ggggi96a4yfd.R.inc(795);if ((((dbObject.containsField("name"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(796)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(797)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(798);nameText = (String)dbObject.get("name");
    }__CLR3_3_0ggggi96a4yfd.R.inc(799);int yearPublished = -1;
    __CLR3_3_0ggggi96a4yfd.R.inc(800);if ((((dbObject.containsField("yearPublished"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(801)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(802)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(803);yearPublished = (Integer)dbObject.get("yearPublished");
    }__CLR3_3_0ggggi96a4yfd.R.inc(804);if ((((yearPublished > 0)&&(__CLR3_3_0ggggi96a4yfd.R.iget(805)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(806)==0&false)))
      {__CLR3_3_0ggggi96a4yfd.R.inc(807);nameText += " (" + (Integer)dbObject.get("yearPublished") + ")";
    }__CLR3_3_0ggggi96a4yfd.R.inc(808);data.setDisplayString(nameText);
    
    __CLR3_3_0ggggi96a4yfd.R.inc(809);if ((((dbObject.containsField("imageThumbnailURL"))&&(__CLR3_3_0ggggi96a4yfd.R.iget(810)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(811)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(812);data.setThumbnailURL((String)dbObject.get("imageThumbnailURL"));

    }__CLR3_3_0ggggi96a4yfd.R.inc(813);return data;  
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<?> curList) {try{__CLR3_3_0ggggi96a4yfd.R.inc(814);
    __CLR3_3_0ggggi96a4yfd.R.inc(815);if ((((curList == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(816)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(817)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(818);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(819);BasicDBList newList = new BasicDBList();
    __CLR3_3_0ggggi96a4yfd.R.inc(820);for (Object obj : curList)
      {__CLR3_3_0ggggi96a4yfd.R.inc(821);newList.add(obj);
    }__CLR3_3_0ggggi96a4yfd.R.inc(822);return newList;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<String> convertDBListToStringList(BasicDBList curList) {try{__CLR3_3_0ggggi96a4yfd.R.inc(823);
    __CLR3_3_0ggggi96a4yfd.R.inc(824);if ((((curList == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(825)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(826)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(827);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(828);List<String> newList = new ArrayList<String>(curList.size());
    __CLR3_3_0ggggi96a4yfd.R.inc(829);for (Object obj : curList) {{
      __CLR3_3_0ggggi96a4yfd.R.inc(830);newList.add((String)obj);
    }
    }__CLR3_3_0ggggi96a4yfd.R.inc(831);return newList;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<Long> format.
   */
  private static List<Long> convertDBListToLongList(BasicDBList curList) {try{__CLR3_3_0ggggi96a4yfd.R.inc(832);
    __CLR3_3_0ggggi96a4yfd.R.inc(833);if ((((curList == null)&&(__CLR3_3_0ggggi96a4yfd.R.iget(834)!=0|true))||(__CLR3_3_0ggggi96a4yfd.R.iget(835)==0&false))) {__CLR3_3_0ggggi96a4yfd.R.inc(836);return null;
    
    }__CLR3_3_0ggggi96a4yfd.R.inc(837);List<Long> newList = new ArrayList<Long>(curList.size());
    __CLR3_3_0ggggi96a4yfd.R.inc(838);for (Object obj : curList) {{
      __CLR3_3_0ggggi96a4yfd.R.inc(839);newList.add((Long)obj);
    }
    }__CLR3_3_0ggggi96a4yfd.R.inc(840);return newList;
  }finally{__CLR3_3_0ggggi96a4yfd.R.flushNeeded();}}
}
