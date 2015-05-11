/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.List;

import com.ac.games.data.GameReltn;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


/**
 * 
 * @author ac010168
 *
 */
public class GameReltnConverter {public static class __CLR3_3_0ndndi96a4ygh{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,952,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the gameID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToIDQuery(GameReltn gameReltn) {try{__CLR3_3_0ndndi96a4ygh.R.inc(841);
    __CLR3_3_0ndndi96a4ygh.R.inc(842);if ((((gameReltn == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(843)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(844)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(845);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(846);BasicDBObject dbObject = new BasicDBObject("reltnID", gameReltn.getReltnID());
    __CLR3_3_0ndndi96a4ygh.R.inc(847);return dbObject;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic query using the gameID representing the provided game relation.
   * 
   * @param gameID The game ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToGameIDQuery(long gameID) {try{__CLR3_3_0ndndi96a4ygh.R.inc(848);
    __CLR3_3_0ndndi96a4ygh.R.inc(849);if ((((gameID < 0)&&(__CLR3_3_0ndndi96a4ygh.R.iget(850)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(851)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(852);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(853);BasicDBObject dbObject = new BasicDBObject("gameID", new Long(gameID));
    __CLR3_3_0ndndi96a4ygh.R.inc(854);return dbObject;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}

  /**
   * Helper method that will construct a basic query using the reltnID representing the provided game relation.
   * 
   * @param reltnID The game relation ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToReltnIDQuery(long reltnID) {try{__CLR3_3_0ndndi96a4ygh.R.inc(855);
    __CLR3_3_0ndndi96a4ygh.R.inc(856);if ((((reltnID < 0)&&(__CLR3_3_0ndndi96a4ygh.R.iget(857)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(858)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(859);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(860);BasicDBObject dbObject = new BasicDBObject("reltnID", new Long(reltnID));
    __CLR3_3_0ndndi96a4ygh.R.inc(861);return dbObject;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database record for the provided game object.
   * 
   * @param game The Game we want to build a database record for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if no game was provided
   */
  public static BasicDBObject convertGameReltnToMongo(GameReltn gameReltn) {try{__CLR3_3_0ndndi96a4ygh.R.inc(862);
    __CLR3_3_0ndndi96a4ygh.R.inc(863);if ((((gameReltn == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(864)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(865)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(866);return null;
    
    //These two fields are required
    }__CLR3_3_0ndndi96a4ygh.R.inc(867);BasicDBObject dbObject = new BasicDBObject("reltnID", gameReltn.getReltnID());
    __CLR3_3_0ndndi96a4ygh.R.inc(868);dbObject.append("gameID", gameReltn.getGameID());
    
    __CLR3_3_0ndndi96a4ygh.R.inc(869);if ((((gameReltn.getBggID() != -1)&&(__CLR3_3_0ndndi96a4ygh.R.iget(870)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(871)==0&false)))        {__CLR3_3_0ndndi96a4ygh.R.inc(872);dbObject.append("bggID", gameReltn.getBggID());
    }__CLR3_3_0ndndi96a4ygh.R.inc(873);if ((((gameReltn.getCsiIDs() != null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(874)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(875)==0&false)))     {__CLR3_3_0ndndi96a4ygh.R.inc(876);dbObject.append("csiIDs", convertList(gameReltn.getCsiIDs()));
    }__CLR3_3_0ndndi96a4ygh.R.inc(877);if ((((gameReltn.getMmIDs() != null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(878)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(879)==0&false)))      {__CLR3_3_0ndndi96a4ygh.R.inc(880);dbObject.append("mmIDs", convertList(gameReltn.getMmIDs()));
    }__CLR3_3_0ndndi96a4ygh.R.inc(881);if ((((gameReltn.getAsinKeys() != null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(882)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(883)==0&false)))   {__CLR3_3_0ndndi96a4ygh.R.inc(884);dbObject.append("asinKeys", convertList(gameReltn.getAsinKeys()));
    }__CLR3_3_0ndndi96a4ygh.R.inc(885);if ((((gameReltn.getOtherSites() != null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(886)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(887)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(888);dbObject.append("otherSites", convertList(gameReltn.getOtherSites()));
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(889);return dbObject;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}} 
  
  /**
   * Convert a Mongo BSON record back into a {@link GameReltn} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link GameReltn} object, or null if the dbObject was null
   */
  public static GameReltn convertMongoToGameReltn(DBObject dbObject) {try{__CLR3_3_0ndndi96a4ygh.R.inc(890);
    __CLR3_3_0ndndi96a4ygh.R.inc(891);if ((((dbObject == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(892)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(893)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(894);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(895);GameReltn gameReltn = new GameReltn();
    
    __CLR3_3_0ndndi96a4ygh.R.inc(896);if ((((dbObject.containsField("reltnID"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(897)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(898)==0&false)))    {__CLR3_3_0ndndi96a4ygh.R.inc(899);gameReltn.setReltnID((Long)dbObject.get("reltnID"));
    }__CLR3_3_0ndndi96a4ygh.R.inc(900);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(901)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(902)==0&false)))     {__CLR3_3_0ndndi96a4ygh.R.inc(903);gameReltn.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_0ndndi96a4ygh.R.inc(904);if ((((dbObject.containsField("bggID"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(905)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(906)==0&false)))      {__CLR3_3_0ndndi96a4ygh.R.inc(907);gameReltn.setBggID((Long)dbObject.get("bggID"));
    }__CLR3_3_0ndndi96a4ygh.R.inc(908);if ((((dbObject.containsField("csiIDs"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(909)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(910)==0&false)))     {__CLR3_3_0ndndi96a4ygh.R.inc(911);gameReltn.setCsiIDs(convertDBListToLongList((BasicDBList)dbObject.get("csiIDs")));
    }__CLR3_3_0ndndi96a4ygh.R.inc(912);if ((((dbObject.containsField("mmIDs"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(913)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(914)==0&false)))      {__CLR3_3_0ndndi96a4ygh.R.inc(915);gameReltn.setMmIDs(convertDBListToLongList((BasicDBList)dbObject.get("mmIDs")));
    }__CLR3_3_0ndndi96a4ygh.R.inc(916);if ((((dbObject.containsField("asinKeys"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(917)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(918)==0&false)))   {__CLR3_3_0ndndi96a4ygh.R.inc(919);gameReltn.setAsinKeys(convertDBListToStringList((BasicDBList)dbObject.get("asinKeys")));
    }__CLR3_3_0ndndi96a4ygh.R.inc(920);if ((((dbObject.containsField("otherSites"))&&(__CLR3_3_0ndndi96a4ygh.R.iget(921)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(922)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(923);gameReltn.setOtherSites(convertDBListToLongList((BasicDBList)dbObject.get("otherSites")));

    }__CLR3_3_0ndndi96a4ygh.R.inc(924);return gameReltn;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}

  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<?> curList) {try{__CLR3_3_0ndndi96a4ygh.R.inc(925);
    __CLR3_3_0ndndi96a4ygh.R.inc(926);if ((((curList == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(927)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(928)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(929);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(930);BasicDBList newList = new BasicDBList();
    __CLR3_3_0ndndi96a4ygh.R.inc(931);for (Object obj : curList)
      {__CLR3_3_0ndndi96a4ygh.R.inc(932);newList.add(obj);
    }__CLR3_3_0ndndi96a4ygh.R.inc(933);return newList;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}
  
  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<String> convertDBListToStringList(BasicDBList curList) {try{__CLR3_3_0ndndi96a4ygh.R.inc(934);
    __CLR3_3_0ndndi96a4ygh.R.inc(935);if ((((curList == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(936)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(937)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(938);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(939);List<String> newList = new ArrayList<String>(curList.size());
    __CLR3_3_0ndndi96a4ygh.R.inc(940);for (Object obj : curList) {{
      __CLR3_3_0ndndi96a4ygh.R.inc(941);newList.add((String)obj);
    }
    }__CLR3_3_0ndndi96a4ygh.R.inc(942);return newList;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<Long> format.
   */
  private static List<Long> convertDBListToLongList(BasicDBList curList) {try{__CLR3_3_0ndndi96a4ygh.R.inc(943);
    __CLR3_3_0ndndi96a4ygh.R.inc(944);if ((((curList == null)&&(__CLR3_3_0ndndi96a4ygh.R.iget(945)!=0|true))||(__CLR3_3_0ndndi96a4ygh.R.iget(946)==0&false))) {__CLR3_3_0ndndi96a4ygh.R.inc(947);return null;
    
    }__CLR3_3_0ndndi96a4ygh.R.inc(948);List<Long> newList = new ArrayList<Long>(curList.size());
    __CLR3_3_0ndndi96a4ygh.R.inc(949);for (Object obj : curList) {{
      __CLR3_3_0ndndi96a4ygh.R.inc(950);newList.add((Long)obj);
    }
    }__CLR3_3_0ndndi96a4ygh.R.inc(951);return newList;
  }finally{__CLR3_3_0ndndi96a4ygh.R.flushNeeded();}}
}
