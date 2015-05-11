/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.WishlistItem;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class WishlistItemConverter {public static class __CLR3_3_036t36ti96a4yvq{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,4194,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the itemID from the provided wishlist item.
   * 
   * @param item The WishlistItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertWishlistItemToIDQuery(WishlistItem item) {try{__CLR3_3_036t36ti96a4yvq.R.inc(4133);
    __CLR3_3_036t36ti96a4yvq.R.inc(4134);if ((((item == null)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4135)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4136)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4137);return null;
    
    }__CLR3_3_036t36ti96a4yvq.R.inc(4138);BasicDBObject dbObject = new BasicDBObject("wishID", item.getWishID());
    __CLR3_3_036t36ti96a4yvq.R.inc(4139);return dbObject;
  }finally{__CLR3_3_036t36ti96a4yvq.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userID from the provided wishlist item.
   * 
   * @param wishID The WishlistItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertWishlistItemToIDQuery(long wishID) {try{__CLR3_3_036t36ti96a4yvq.R.inc(4140);
    __CLR3_3_036t36ti96a4yvq.R.inc(4141);if ((((wishID < 0)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4142)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4143)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4144);return null;
    
    }__CLR3_3_036t36ti96a4yvq.R.inc(4145);BasicDBObject dbObject = new BasicDBObject("wishID", wishID);
    __CLR3_3_036t36ti96a4yvq.R.inc(4146);return dbObject;
  }finally{__CLR3_3_036t36ti96a4yvq.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertWishlistItemToMongo(WishlistItem item) {try{__CLR3_3_036t36ti96a4yvq.R.inc(4147);
    __CLR3_3_036t36ti96a4yvq.R.inc(4148);if ((((item == null)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4149)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4150)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4151);return null;
    
    }__CLR3_3_036t36ti96a4yvq.R.inc(4152);BasicDBObject dbObject = new BasicDBObject("wishID", item.getWishID());
    __CLR3_3_036t36ti96a4yvq.R.inc(4153);if ((((item.getUserID() >= -1)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4154)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4155)==0&false)))      {__CLR3_3_036t36ti96a4yvq.R.inc(4156);dbObject.append("userID", item.getUserID());
    }__CLR3_3_036t36ti96a4yvq.R.inc(4157);if ((((item.getGameID() >= -1)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4158)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4159)==0&false)))      {__CLR3_3_036t36ti96a4yvq.R.inc(4160);dbObject.append("gameID", item.getGameID());
    }__CLR3_3_036t36ti96a4yvq.R.inc(4161);if ((((item.getDateAdded() != null)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4162)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4163)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4164);dbObject.append("dateAdded", item.getDateAdded());
    }__CLR3_3_036t36ti96a4yvq.R.inc(4165);dbObject.append("notifyUser", item.isNotifyUser());
    
    __CLR3_3_036t36ti96a4yvq.R.inc(4166);return dbObject;
  }finally{__CLR3_3_036t36ti96a4yvq.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link WishlistItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link WishlistItem} object, or null if the dbObject was null
   */
  public static WishlistItem convertMongoToWishlistItem(DBObject dbObject) {try{__CLR3_3_036t36ti96a4yvq.R.inc(4167);
    __CLR3_3_036t36ti96a4yvq.R.inc(4168);if ((((dbObject == null)&&(__CLR3_3_036t36ti96a4yvq.R.iget(4169)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4170)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4171);return null;
    
    }__CLR3_3_036t36ti96a4yvq.R.inc(4172);WishlistItem item = new WishlistItem();
    __CLR3_3_036t36ti96a4yvq.R.inc(4173);if ((((dbObject.containsField("wishID"))&&(__CLR3_3_036t36ti96a4yvq.R.iget(4174)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4175)==0&false)))     {__CLR3_3_036t36ti96a4yvq.R.inc(4176);item.setWishID((Long)dbObject.get("wishID"));
    }__CLR3_3_036t36ti96a4yvq.R.inc(4177);if ((((dbObject.containsField("userID"))&&(__CLR3_3_036t36ti96a4yvq.R.iget(4178)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4179)==0&false)))     {__CLR3_3_036t36ti96a4yvq.R.inc(4180);item.setUserID((Long)dbObject.get("userID"));
    }__CLR3_3_036t36ti96a4yvq.R.inc(4181);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_036t36ti96a4yvq.R.iget(4182)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4183)==0&false)))     {__CLR3_3_036t36ti96a4yvq.R.inc(4184);item.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_036t36ti96a4yvq.R.inc(4185);if ((((dbObject.containsField("dateAdded"))&&(__CLR3_3_036t36ti96a4yvq.R.iget(4186)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4187)==0&false)))  {__CLR3_3_036t36ti96a4yvq.R.inc(4188);item.setDateAdded((Date)dbObject.get("dateAdded"));
    }__CLR3_3_036t36ti96a4yvq.R.inc(4189);if ((((dbObject.containsField("notifyUser"))&&(__CLR3_3_036t36ti96a4yvq.R.iget(4190)!=0|true))||(__CLR3_3_036t36ti96a4yvq.R.iget(4191)==0&false))) {__CLR3_3_036t36ti96a4yvq.R.inc(4192);item.setNotifyUser((Boolean)dbObject.get("notifyUser"));
    }__CLR3_3_036t36ti96a4yvq.R.inc(4193);return item;
  }finally{__CLR3_3_036t36ti96a4yvq.R.flushNeeded();}}
}
