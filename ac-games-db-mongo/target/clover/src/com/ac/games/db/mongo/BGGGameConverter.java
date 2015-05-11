/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ac.games.data.BGGGame;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.GameTypeConverter;
import com.ac.games.data.ReviewStateConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class BGGGameConverter {public static class __CLR3_3_088i96a4ybf{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,269,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /**
   * Helper method that will construct a basic query using the bggID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(BGGGame game) {try{__CLR3_3_088i96a4ybf.R.inc(8);
    __CLR3_3_088i96a4ybf.R.inc(9);if ((((game == null)&&(__CLR3_3_088i96a4ybf.R.iget(10)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(11)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(12);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(13);BasicDBObject dbObject = new BasicDBObject("bggID", game.getBggID());
    __CLR3_3_088i96a4ybf.R.inc(14);return dbObject;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic query using the bggID representing the provided game.
   * 
   * @param bggID The game ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(long bggID) {try{__CLR3_3_088i96a4ybf.R.inc(15);
    __CLR3_3_088i96a4ybf.R.inc(16);if ((((bggID < 0)&&(__CLR3_3_088i96a4ybf.R.iget(17)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(18)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(19);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(20);BasicDBObject dbObject = new BasicDBObject("bggID", new Long(bggID));
    __CLR3_3_088i96a4ybf.R.inc(21);return dbObject;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic database record for the provided game object.
   * 
   * @param game The Game we want to build a database record for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if no game was provided
   */
  public static BasicDBObject convertGameToMongo(BGGGame game) {try{__CLR3_3_088i96a4ybf.R.inc(22);
    __CLR3_3_088i96a4ybf.R.inc(23);if ((((game == null)&&(__CLR3_3_088i96a4ybf.R.iget(24)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(25)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(26);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(27);BasicDBObject dbObject = new BasicDBObject("bggID", game.getBggID());
    
    __CLR3_3_088i96a4ybf.R.inc(28);if ((((game.getName() != null)&&(__CLR3_3_088i96a4ybf.R.iget(29)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(30)==0&false)))              {__CLR3_3_088i96a4ybf.R.inc(31);dbObject.append("name", game.getName());
    }__CLR3_3_088i96a4ybf.R.inc(32);if ((((game.getYearPublished() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(33)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(34)==0&false)))       {__CLR3_3_088i96a4ybf.R.inc(35);dbObject.append("yearPublished", game.getYearPublished());
    }__CLR3_3_088i96a4ybf.R.inc(36);if ((((game.getMinPlayers() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(37)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(38)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(39);dbObject.append("minPlayers", game.getMinPlayers());
    }__CLR3_3_088i96a4ybf.R.inc(40);if ((((game.getMaxPlayers() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(41)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(42)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(43);dbObject.append("maxPlayers", game.getMaxPlayers());
    }__CLR3_3_088i96a4ybf.R.inc(44);if ((((game.getMinPlayingTime() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(45)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(46)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(47);dbObject.append("minPlayingTime", game.getMinPlayingTime());
    }__CLR3_3_088i96a4ybf.R.inc(48);if ((((game.getMaxPlayingTime() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(49)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(50)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(51);dbObject.append("maxPlayingTime", game.getMaxPlayingTime());
    }__CLR3_3_088i96a4ybf.R.inc(52);if ((((game.getImageURL() != null)&&(__CLR3_3_088i96a4ybf.R.iget(53)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(54)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(55);dbObject.append("imageURL", game.getImageURL());
    }__CLR3_3_088i96a4ybf.R.inc(56);if ((((game.getImageThumbnailURL() != null)&&(__CLR3_3_088i96a4ybf.R.iget(57)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(58)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(59);dbObject.append("imageThumbnailURL", game.getImageThumbnailURL());
    }__CLR3_3_088i96a4ybf.R.inc(60);if ((((game.getDescription() != null)&&(__CLR3_3_088i96a4ybf.R.iget(61)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(62)==0&false)))       {__CLR3_3_088i96a4ybf.R.inc(63);dbObject.append("description", game.getDescription());
    }__CLR3_3_088i96a4ybf.R.inc(64);if ((((game.getBggRating() != -1.0)&&(__CLR3_3_088i96a4ybf.R.iget(65)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(66)==0&false)))         {__CLR3_3_088i96a4ybf.R.inc(67);dbObject.append("bggRating", game.getBggRating());
    }__CLR3_3_088i96a4ybf.R.inc(68);if ((((game.getBggRatingUsers() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(69)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(70)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(71);dbObject.append("bggRatingUsers", game.getBggRatingUsers());
    }__CLR3_3_088i96a4ybf.R.inc(72);if ((((game.getPublishers() != null)&&(__CLR3_3_088i96a4ybf.R.iget(73)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(74)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(75);dbObject.append("publishers", convertList(game.getPublishers()));
    }__CLR3_3_088i96a4ybf.R.inc(76);if ((((game.getDesigners() != null)&&(__CLR3_3_088i96a4ybf.R.iget(77)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(78)==0&false)))         {__CLR3_3_088i96a4ybf.R.inc(79);dbObject.append("designers", convertList(game.getDesigners()));
    }__CLR3_3_088i96a4ybf.R.inc(80);if ((((game.getCategories() != null)&&(__CLR3_3_088i96a4ybf.R.iget(81)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(82)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(83);dbObject.append("categories", convertList(game.getCategories()));
    }__CLR3_3_088i96a4ybf.R.inc(84);if ((((game.getMechanisms() != null)&&(__CLR3_3_088i96a4ybf.R.iget(85)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(86)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(87);dbObject.append("mechanisms", convertList(game.getMechanisms()));
    }__CLR3_3_088i96a4ybf.R.inc(88);if ((((game.getBggRank() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(89)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(90)==0&false)))             {__CLR3_3_088i96a4ybf.R.inc(91);dbObject.append("bggRank", game.getBggRank());
    }__CLR3_3_088i96a4ybf.R.inc(92);if ((((game.getExpansionIDs() != null)&&(__CLR3_3_088i96a4ybf.R.iget(93)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(94)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(95);dbObject.append("expansionIDs", convertList(game.getExpansionIDs()));
    }__CLR3_3_088i96a4ybf.R.inc(96);if ((((game.getParentGameID() != -1)&&(__CLR3_3_088i96a4ybf.R.iget(97)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(98)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(99);dbObject.append("parentGameID", game.getParentGameID());
    //Need a converter here because BSON won't accept Enums for serializability
    }__CLR3_3_088i96a4ybf.R.inc(100);if ((((game.getGameType() != null)&&(__CLR3_3_088i96a4ybf.R.iget(101)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(102)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(103);dbObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(game.getGameType()));
    }__CLR3_3_088i96a4ybf.R.inc(104);if ((((game.getReviewState() != null)&&(__CLR3_3_088i96a4ybf.R.iget(105)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(106)==0&false)))       {__CLR3_3_088i96a4ybf.R.inc(107);dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(game.getReviewState()));
    }__CLR3_3_088i96a4ybf.R.inc(108);if ((((game.getAddDate() != null)&&(__CLR3_3_088i96a4ybf.R.iget(109)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(110)==0&false)))           {__CLR3_3_088i96a4ybf.R.inc(111);dbObject.append("addDate", game.getAddDate());
    }__CLR3_3_088i96a4ybf.R.inc(112);if ((((game.getReviewDate() != null)&&(__CLR3_3_088i96a4ybf.R.iget(113)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(114)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(115);dbObject.append("reviewDate", game.getReviewDate());
    
    }__CLR3_3_088i96a4ybf.R.inc(116);return dbObject;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}
  
  public static BGGGame convertMongoToGame(DBObject dbObject) {try{__CLR3_3_088i96a4ybf.R.inc(117);
    __CLR3_3_088i96a4ybf.R.inc(118);if ((((dbObject == null)&&(__CLR3_3_088i96a4ybf.R.iget(119)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(120)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(121);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(122);BGGGame game = new BGGGame();
    
    __CLR3_3_088i96a4ybf.R.inc(123);if ((((dbObject.containsField("bggID"))&&(__CLR3_3_088i96a4ybf.R.iget(124)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(125)==0&false)))             {__CLR3_3_088i96a4ybf.R.inc(126);game.setBggID((Long)dbObject.get("bggID"));
    }__CLR3_3_088i96a4ybf.R.inc(127);if ((((dbObject.containsField("name"))&&(__CLR3_3_088i96a4ybf.R.iget(128)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(129)==0&false)))              {__CLR3_3_088i96a4ybf.R.inc(130);game.setName((String)dbObject.get("name"));
    }__CLR3_3_088i96a4ybf.R.inc(131);if ((((dbObject.containsField("yearPublished"))&&(__CLR3_3_088i96a4ybf.R.iget(132)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(133)==0&false)))     {__CLR3_3_088i96a4ybf.R.inc(134);game.setYearPublished((Integer)dbObject.get("yearPublished"));
    }__CLR3_3_088i96a4ybf.R.inc(135);if ((((dbObject.containsField("minPlayers"))&&(__CLR3_3_088i96a4ybf.R.iget(136)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(137)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(138);game.setMinPlayers((Integer)dbObject.get("minPlayers"));
    }__CLR3_3_088i96a4ybf.R.inc(139);if ((((dbObject.containsField("maxPlayers"))&&(__CLR3_3_088i96a4ybf.R.iget(140)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(141)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(142);game.setMaxPlayers((Integer)dbObject.get("maxPlayers"));
    }__CLR3_3_088i96a4ybf.R.inc(143);if ((((dbObject.containsField("minPlayingTime"))&&(__CLR3_3_088i96a4ybf.R.iget(144)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(145)==0&false)))    {__CLR3_3_088i96a4ybf.R.inc(146);game.setMinPlayingTime((Integer)dbObject.get("minPlayingTime"));
    }__CLR3_3_088i96a4ybf.R.inc(147);if ((((dbObject.containsField("maxPlayingTime"))&&(__CLR3_3_088i96a4ybf.R.iget(148)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(149)==0&false)))    {__CLR3_3_088i96a4ybf.R.inc(150);game.setMaxPlayingTime((Integer)dbObject.get("maxPlayingTime"));
    }__CLR3_3_088i96a4ybf.R.inc(151);if ((((dbObject.containsField("imageURL"))&&(__CLR3_3_088i96a4ybf.R.iget(152)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(153)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(154);game.setImageURL((String)dbObject.get("imageURL"));
    }__CLR3_3_088i96a4ybf.R.inc(155);if ((((dbObject.containsField("imageThumbnailURL"))&&(__CLR3_3_088i96a4ybf.R.iget(156)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(157)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(158);game.setImageThumbnailURL((String)dbObject.get("imageThumbnailURL"));
    }__CLR3_3_088i96a4ybf.R.inc(159);if ((((dbObject.containsField("description"))&&(__CLR3_3_088i96a4ybf.R.iget(160)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(161)==0&false)))       {__CLR3_3_088i96a4ybf.R.inc(162);game.setDescription((String)dbObject.get("description"));
    }__CLR3_3_088i96a4ybf.R.inc(163);if ((((dbObject.containsField("bggRating"))&&(__CLR3_3_088i96a4ybf.R.iget(164)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(165)==0&false)))         {__CLR3_3_088i96a4ybf.R.inc(166);game.setBggRating((Double)dbObject.get("bggRating"));
    }__CLR3_3_088i96a4ybf.R.inc(167);if ((((dbObject.containsField("bggRatingUsers"))&&(__CLR3_3_088i96a4ybf.R.iget(168)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(169)==0&false)))    {__CLR3_3_088i96a4ybf.R.inc(170);game.setBggRatingUsers((Integer)dbObject.get("bggRatingUsers"));
    }__CLR3_3_088i96a4ybf.R.inc(171);if ((((dbObject.containsField("publishers"))&&(__CLR3_3_088i96a4ybf.R.iget(172)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(173)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(174);game.setPublishers(convertDBListToStringList((BasicDBList)dbObject.get("publishers")));
    }__CLR3_3_088i96a4ybf.R.inc(175);if ((((dbObject.containsField("designers"))&&(__CLR3_3_088i96a4ybf.R.iget(176)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(177)==0&false)))         {__CLR3_3_088i96a4ybf.R.inc(178);game.setDesigners(convertDBListToStringList((BasicDBList)dbObject.get("designers")));
    }__CLR3_3_088i96a4ybf.R.inc(179);if ((((dbObject.containsField("categories"))&&(__CLR3_3_088i96a4ybf.R.iget(180)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(181)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(182);game.setCategories(convertDBListToStringList((BasicDBList)dbObject.get("categories")));
    }__CLR3_3_088i96a4ybf.R.inc(183);if ((((dbObject.containsField("mechanisms"))&&(__CLR3_3_088i96a4ybf.R.iget(184)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(185)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(186);game.setMechanisms(convertDBListToStringList((BasicDBList)dbObject.get("mechanisms")));
    }__CLR3_3_088i96a4ybf.R.inc(187);if ((((dbObject.containsField("bggRank"))&&(__CLR3_3_088i96a4ybf.R.iget(188)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(189)==0&false)))           {__CLR3_3_088i96a4ybf.R.inc(190);game.setBggRank((Integer)dbObject.get("bggRank"));
    }__CLR3_3_088i96a4ybf.R.inc(191);if ((((dbObject.containsField("expansionIDs"))&&(__CLR3_3_088i96a4ybf.R.iget(192)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(193)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(194);game.setExpansionIDs(convertDBListToLongList((BasicDBList)dbObject.get("expansionIDs")));
    }__CLR3_3_088i96a4ybf.R.inc(195);if ((((dbObject.containsField("parentGameID"))&&(__CLR3_3_088i96a4ybf.R.iget(196)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(197)==0&false)))      {__CLR3_3_088i96a4ybf.R.inc(198);game.setParentGameID((Long)dbObject.get("parentGameID"));
    //Need a converter here because BSON won't accept Enums for serializability
    }__CLR3_3_088i96a4ybf.R.inc(199);if ((((dbObject.containsField("gameType"))&&(__CLR3_3_088i96a4ybf.R.iget(200)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(201)==0&false)))          {__CLR3_3_088i96a4ybf.R.inc(202);game.setGameType(GameTypeConverter.convertFlagToGameType((Integer)dbObject.get("gameType")));
    }__CLR3_3_088i96a4ybf.R.inc(203);if ((((dbObject.containsField("reviewState"))&&(__CLR3_3_088i96a4ybf.R.iget(204)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(205)==0&false)))       {__CLR3_3_088i96a4ybf.R.inc(206);game.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    }__CLR3_3_088i96a4ybf.R.inc(207);if ((((dbObject.containsField("addDate"))&&(__CLR3_3_088i96a4ybf.R.iget(208)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(209)==0&false)))           {__CLR3_3_088i96a4ybf.R.inc(210);game.setAddDate((Date)dbObject.get("addDate"));
    }__CLR3_3_088i96a4ybf.R.inc(211);if ((((dbObject.containsField("reviewDate"))&&(__CLR3_3_088i96a4ybf.R.iget(212)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(213)==0&false)))        {__CLR3_3_088i96a4ybf.R.inc(214);game.setReviewDate((Date)dbObject.get("reviewDate"));
    
    }__CLR3_3_088i96a4ybf.R.inc(215);return game;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}
  
  public static CompactSearchData convertMongoToCompact(DBObject dbObject) {try{__CLR3_3_088i96a4ybf.R.inc(216);
    __CLR3_3_088i96a4ybf.R.inc(217);if ((((dbObject == null)&&(__CLR3_3_088i96a4ybf.R.iget(218)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(219)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(220);return null;
      
    }__CLR3_3_088i96a4ybf.R.inc(221);CompactSearchData data = new CompactSearchData();
    
    __CLR3_3_088i96a4ybf.R.inc(222);if ((((dbObject.containsField("bggID"))&&(__CLR3_3_088i96a4ybf.R.iget(223)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(224)==0&false))) {{
      __CLR3_3_088i96a4ybf.R.inc(225);data.setSourceID((Long)dbObject.get("bggID"));  
      __CLR3_3_088i96a4ybf.R.inc(226);data.setSourceField("bggID");
    }
    }__CLR3_3_088i96a4ybf.R.inc(227);String nameText = "Unavailable";
    __CLR3_3_088i96a4ybf.R.inc(228);if ((((dbObject.containsField("name"))&&(__CLR3_3_088i96a4ybf.R.iget(229)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(230)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(231);nameText = (String)dbObject.get("name");
    }__CLR3_3_088i96a4ybf.R.inc(232);if ((((dbObject.containsField("yearPublished"))&&(__CLR3_3_088i96a4ybf.R.iget(233)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(234)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(235);nameText += " (" + (Integer)dbObject.get("yearPublished") + ")";
    }__CLR3_3_088i96a4ybf.R.inc(236);data.setDisplayString(nameText);
    
    __CLR3_3_088i96a4ybf.R.inc(237);if ((((dbObject.containsField("imageThumbnailURL"))&&(__CLR3_3_088i96a4ybf.R.iget(238)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(239)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(240);data.setThumbnailURL((String)dbObject.get("imageThumbnailURL"));

    }__CLR3_3_088i96a4ybf.R.inc(241);return data;  
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<?> curList) {try{__CLR3_3_088i96a4ybf.R.inc(242);
    __CLR3_3_088i96a4ybf.R.inc(243);if ((((curList == null)&&(__CLR3_3_088i96a4ybf.R.iget(244)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(245)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(246);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(247);BasicDBList newList = new BasicDBList();
    __CLR3_3_088i96a4ybf.R.inc(248);for (Object obj : curList)
      {__CLR3_3_088i96a4ybf.R.inc(249);newList.add(obj);
    }__CLR3_3_088i96a4ybf.R.inc(250);return newList;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<String> convertDBListToStringList(BasicDBList curList) {try{__CLR3_3_088i96a4ybf.R.inc(251);
    __CLR3_3_088i96a4ybf.R.inc(252);if ((((curList == null)&&(__CLR3_3_088i96a4ybf.R.iget(253)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(254)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(255);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(256);List<String> newList = new ArrayList<String>(curList.size());
    __CLR3_3_088i96a4ybf.R.inc(257);for (Object obj : curList) {{
      __CLR3_3_088i96a4ybf.R.inc(258);newList.add((String)obj);
    }
    }__CLR3_3_088i96a4ybf.R.inc(259);return newList;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<Long> format.
   */
  private static List<Long> convertDBListToLongList(BasicDBList curList) {try{__CLR3_3_088i96a4ybf.R.inc(260);
    __CLR3_3_088i96a4ybf.R.inc(261);if ((((curList == null)&&(__CLR3_3_088i96a4ybf.R.iget(262)!=0|true))||(__CLR3_3_088i96a4ybf.R.iget(263)==0&false))) {__CLR3_3_088i96a4ybf.R.inc(264);return null;
    
    }__CLR3_3_088i96a4ybf.R.inc(265);List<Long> newList = new ArrayList<Long>(curList.size());
    __CLR3_3_088i96a4ybf.R.inc(266);for (Object obj : curList) {{
      __CLR3_3_088i96a4ybf.R.inc(267);newList.add((Long)obj);
    }
    }__CLR3_3_088i96a4ybf.R.inc(268);return newList;
  }finally{__CLR3_3_088i96a4ybf.R.flushNeeded();}}
}
