/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.List;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class CollectionConverter {public static class __CLR3_3_0b1b1i96a4ydb{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,470,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param item The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionToIDQuery(Collection collection) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(397);
    __CLR3_3_0b1b1i96a4ydb.R.inc(398);if ((((collection == null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(399)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(400)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(401);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(402);BasicDBObject dbObject = new BasicDBObject("collectionID", collection.getCollectionID());
    __CLR3_3_0b1b1i96a4ydb.R.inc(403);return dbObject;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the collectionID from the provided game.
   * 
   * @param collectionID The Collection we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionToIDQuery(long collectionID) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(404);
    __CLR3_3_0b1b1i96a4ydb.R.inc(405);if ((((collectionID < 0)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(406)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(407)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(408);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(409);BasicDBObject dbObject = new BasicDBObject("collectionID", collectionID);
    __CLR3_3_0b1b1i96a4ydb.R.inc(410);return dbObject;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param item The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertCollectionToMongo(Collection collection) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(411);
    __CLR3_3_0b1b1i96a4ydb.R.inc(412);if ((((collection == null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(413)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(414)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(415);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(416);BasicDBObject dbObject = new BasicDBObject("collectionID", collection.getCollectionID());
    __CLR3_3_0b1b1i96a4ydb.R.inc(417);if ((((collection.getGames() != null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(418)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(419)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(420);dbObject.append("games", convertList(collection.getGames()));
    //Default values are always 0, so we should write them no matter what
    }__CLR3_3_0b1b1i96a4ydb.R.inc(421);dbObject.append("baseGameCount", collection.getBaseGameCount());
    __CLR3_3_0b1b1i96a4ydb.R.inc(422);dbObject.append("collectibleGameCount", collection.getCollectibleGameCount());
    __CLR3_3_0b1b1i96a4ydb.R.inc(423);dbObject.append("expansionGameCount", collection.getExpansionGameCount());

    __CLR3_3_0b1b1i96a4ydb.R.inc(424);return dbObject;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link Collection} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link Collection} object, or null if the dbObject was null
   */
  public static Collection convertMongoToCollection(DBObject dbObject) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(425);
    __CLR3_3_0b1b1i96a4ydb.R.inc(426);if ((((dbObject == null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(427)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(428)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(429);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(430);Collection collection = new Collection();
    __CLR3_3_0b1b1i96a4ydb.R.inc(431);if ((((dbObject.containsField("collectionID"))&&(__CLR3_3_0b1b1i96a4ydb.R.iget(432)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(433)==0&false)))         {__CLR3_3_0b1b1i96a4ydb.R.inc(434);collection.setCollectionID((Long)dbObject.get("collectionID"));
    }__CLR3_3_0b1b1i96a4ydb.R.inc(435);if ((((dbObject.containsField("games"))&&(__CLR3_3_0b1b1i96a4ydb.R.iget(436)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(437)==0&false)))                {__CLR3_3_0b1b1i96a4ydb.R.inc(438);collection.setGames(convertDBListToCollectionItemList((BasicDBList)dbObject.get("games")));
    }__CLR3_3_0b1b1i96a4ydb.R.inc(439);if ((((dbObject.containsField("baseGameCount"))&&(__CLR3_3_0b1b1i96a4ydb.R.iget(440)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(441)==0&false)))        {__CLR3_3_0b1b1i96a4ydb.R.inc(442);collection.setBaseGameCount((Integer)dbObject.get("baseGameCount"));
    }__CLR3_3_0b1b1i96a4ydb.R.inc(443);if ((((dbObject.containsField("collectibleGameCount"))&&(__CLR3_3_0b1b1i96a4ydb.R.iget(444)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(445)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(446);collection.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    }__CLR3_3_0b1b1i96a4ydb.R.inc(447);if ((((dbObject.containsField("expansionGameCount"))&&(__CLR3_3_0b1b1i96a4ydb.R.iget(448)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(449)==0&false)))   {__CLR3_3_0b1b1i96a4ydb.R.inc(450);collection.setExpansionGameCount((Integer)dbObject.get("expansionGameCount"));

    }__CLR3_3_0b1b1i96a4ydb.R.inc(451);return collection;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}

  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<CollectionItem> curList) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(452);
    __CLR3_3_0b1b1i96a4ydb.R.inc(453);if ((((curList == null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(454)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(455)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(456);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(457);BasicDBList newList = new BasicDBList();
    __CLR3_3_0b1b1i96a4ydb.R.inc(458);for (CollectionItem obj : curList)
      {__CLR3_3_0b1b1i96a4ydb.R.inc(459);newList.add(CollectionItemConverter.convertCollectionItemToMongo(obj));
    }__CLR3_3_0b1b1i96a4ydb.R.inc(460);return newList;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<CollectionItem> convertDBListToCollectionItemList(BasicDBList curList) {try{__CLR3_3_0b1b1i96a4ydb.R.inc(461);
    __CLR3_3_0b1b1i96a4ydb.R.inc(462);if ((((curList == null)&&(__CLR3_3_0b1b1i96a4ydb.R.iget(463)!=0|true))||(__CLR3_3_0b1b1i96a4ydb.R.iget(464)==0&false))) {__CLR3_3_0b1b1i96a4ydb.R.inc(465);return null;
    
    }__CLR3_3_0b1b1i96a4ydb.R.inc(466);List<CollectionItem> newList = new ArrayList<CollectionItem>(curList.size());
    __CLR3_3_0b1b1i96a4ydb.R.inc(467);for (Object obj : curList) {{
      __CLR3_3_0b1b1i96a4ydb.R.inc(468);newList.add(CollectionItemConverter.convertMongoToCollectionItem((DBObject)obj));
    }
    }__CLR3_3_0b1b1i96a4ydb.R.inc(469);return newList;
  }finally{__CLR3_3_0b1b1i96a4ydb.R.flushNeeded();}}
}
