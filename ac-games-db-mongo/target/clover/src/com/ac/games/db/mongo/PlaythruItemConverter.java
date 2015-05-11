/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.PlaythruItem;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class PlaythruItemConverter {public static class __CLR3_3_02x82x8i96a4yu6{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,3876,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the playthruID from the provided playthru item.
   * 
   * @param item The PlaythruItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertPlaythruItemToIDQuery(PlaythruItem item) {try{__CLR3_3_02x82x8i96a4yu6.R.inc(3788);
    __CLR3_3_02x82x8i96a4yu6.R.inc(3789);if ((((item == null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3790)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3791)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3792);return null;
    
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3793);BasicDBObject dbObject = new BasicDBObject("playthruID", item.getPlaythruID());
    __CLR3_3_02x82x8i96a4yu6.R.inc(3794);return dbObject;
  }finally{__CLR3_3_02x82x8i96a4yu6.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the playthruID from the provided playthru item.
   * 
   * @param playthruID The PlaythruItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertPlaythruItemToIDQuery(long playthruID) {try{__CLR3_3_02x82x8i96a4yu6.R.inc(3795);
    __CLR3_3_02x82x8i96a4yu6.R.inc(3796);if ((((playthruID < 0)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3797)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3798)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3799);return null;
    
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3800);BasicDBObject dbObject = new BasicDBObject("playthruID", playthruID);
    __CLR3_3_02x82x8i96a4yu6.R.inc(3801);return dbObject;
  }finally{__CLR3_3_02x82x8i96a4yu6.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertPlaythruItemToMongo(PlaythruItem item) {try{__CLR3_3_02x82x8i96a4yu6.R.inc(3802);
    __CLR3_3_02x82x8i96a4yu6.R.inc(3803);if ((((item == null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3804)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3805)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3806);return null;
    
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3807);BasicDBObject dbObject = new BasicDBObject("playthruID", item.getPlaythruID());
    __CLR3_3_02x82x8i96a4yu6.R.inc(3808);if ((((item.getUserID() <= -1)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3809)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3810)==0&false)))         {__CLR3_3_02x82x8i96a4yu6.R.inc(3811);dbObject.append("userID", item.getUserID());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3812);if ((((item.getGameID() <= -1)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3813)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3814)==0&false)))         {__CLR3_3_02x82x8i96a4yu6.R.inc(3815);dbObject.append("gameID", item.getGameID());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3816);if ((((item.getGameName() != null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3817)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3818)==0&false)))     {__CLR3_3_02x82x8i96a4yu6.R.inc(3819);dbObject.append("gameName", item.getGameName());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3820);if ((((item.getDatePlayed() != null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3821)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3822)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3823);dbObject.append("datePlayed", item.getDatePlayed());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3824);if ((((item.getNumPlayers() <= -1)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3825)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3826)==0&false)))     {__CLR3_3_02x82x8i96a4yu6.R.inc(3827);dbObject.append("numPlayers", item.getNumPlayers());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3828);if ((((item.getWinnerText() != null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3829)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3830)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3831);dbObject.append("winnerText", item.getWinnerText());
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3832);if ((((item.getPlaythruText() != null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3833)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3834)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3835);dbObject.append("playthruText", item.getPlaythruText());
    
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3836);return dbObject;
  }finally{__CLR3_3_02x82x8i96a4yu6.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link PlaythruItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link PlaythruItem} object, or null if the dbObject was null
   */
  public static PlaythruItem convertMongoToPlaythruItem(DBObject dbObject) {try{__CLR3_3_02x82x8i96a4yu6.R.inc(3837);
    __CLR3_3_02x82x8i96a4yu6.R.inc(3838);if ((((dbObject == null)&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3839)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3840)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3841);return null;
    
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3842);PlaythruItem item = new PlaythruItem();
    __CLR3_3_02x82x8i96a4yu6.R.inc(3843);if ((((dbObject.containsField("playthruID"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3844)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3845)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3846);item.setPlaythruID((Long)dbObject.get("playthruID"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3847);if ((((dbObject.containsField("userID"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3848)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3849)==0&false)))       {__CLR3_3_02x82x8i96a4yu6.R.inc(3850);item.setUserID((Long)dbObject.get("userID"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3851);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3852)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3853)==0&false)))       {__CLR3_3_02x82x8i96a4yu6.R.inc(3854);item.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3855);if ((((dbObject.containsField("gameName"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3856)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3857)==0&false)))     {__CLR3_3_02x82x8i96a4yu6.R.inc(3858);item.setGameName((String)dbObject.get("gameName"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3859);if ((((dbObject.containsField("datePlayed"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3860)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3861)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3862);item.setDatePlayed((Date)dbObject.get("datePlayed"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3863);if ((((dbObject.containsField("numPlayers"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3864)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3865)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3866);item.setNumPlayers((Integer)dbObject.get("numPlayers"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3867);if ((((dbObject.containsField("winnerText"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3868)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3869)==0&false)))   {__CLR3_3_02x82x8i96a4yu6.R.inc(3870);item.setWinnerText((String)dbObject.get("winnerText"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3871);if ((((dbObject.containsField("playthruText"))&&(__CLR3_3_02x82x8i96a4yu6.R.iget(3872)!=0|true))||(__CLR3_3_02x82x8i96a4yu6.R.iget(3873)==0&false))) {__CLR3_3_02x82x8i96a4yu6.R.inc(3874);item.setPlaythruText((String)dbObject.get("playthruText"));
    }__CLR3_3_02x82x8i96a4yu6.R.inc(3875);return item;
  }finally{__CLR3_3_02x82x8i96a4yu6.R.flushNeeded();}}
}
