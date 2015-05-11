/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.MiniatureMarketCategoryConverter;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.GameAvailabilityConverter;
import com.ac.games.data.ReviewStateConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class MMDataConverter {public static class __CLR3_3_0qgqgi96a4yhd{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,1072,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the mmID from the provided price data.
   * 
   * @param data The MM data we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToIDQuery(MiniatureMarketPriceData data) {try{__CLR3_3_0qgqgi96a4yhd.R.inc(952);
    __CLR3_3_0qgqgi96a4yhd.R.inc(953);if ((((data == null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(954)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(955)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(956);return null;
    
    }__CLR3_3_0qgqgi96a4yhd.R.inc(957);BasicDBObject dbObject = new BasicDBObject("mmID", data.getMmID());
    __CLR3_3_0qgqgi96a4yhd.R.inc(958);return dbObject;
  }finally{__CLR3_3_0qgqgi96a4yhd.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param mmID The Miniature Market ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToIDQuery(long mmID) {try{__CLR3_3_0qgqgi96a4yhd.R.inc(959);
    __CLR3_3_0qgqgi96a4yhd.R.inc(960);if ((((mmID < 0)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(961)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(962)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(963);return null;

    }__CLR3_3_0qgqgi96a4yhd.R.inc(964);BasicDBObject dbObject = new BasicDBObject("mmID", mmID);
    __CLR3_3_0qgqgi96a4yhd.R.inc(965);return dbObject;
  }finally{__CLR3_3_0qgqgi96a4yhd.R.flushNeeded();}}
  
  /**
   * Conversion method used to map our price data into a mongo object.
   * 
   * @param data
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToMongo(MiniatureMarketPriceData data) {try{__CLR3_3_0qgqgi96a4yhd.R.inc(966);
    __CLR3_3_0qgqgi96a4yhd.R.inc(967);if ((((data == null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(968)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(969)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(970);return null;
    
    }__CLR3_3_0qgqgi96a4yhd.R.inc(971);BasicDBObject dbObject = new BasicDBObject("mmID", data.getMmID());
    
    __CLR3_3_0qgqgi96a4yhd.R.inc(972);if ((((data.getSku() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(973)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(974)==0&false)))          {__CLR3_3_0qgqgi96a4yhd.R.inc(975);dbObject.append("sku", data.getSku());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(976);if ((((data.getTitle() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(977)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(978)==0&false)))        {__CLR3_3_0qgqgi96a4yhd.R.inc(979);dbObject.append("title", data.getTitle());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(980);if ((((data.getManufacturer() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(981)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(982)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(983);dbObject.append("manufacturer", data.getManufacturer());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(984);if ((((data.getCategory() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(985)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(986)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(987);dbObject.append("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(data.getCategory()));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(988);if ((((data.getImageURL() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(989)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(990)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(991);dbObject.append("imageURL", data.getImageURL());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(992);if ((((data.getAvailability() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(993)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(994)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(995);dbObject.append("availability", GameAvailabilityConverter.convertGameAvailabilityToFlag(data.getAvailability()));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(996);if ((((data.getMsrpValue() != -1.0)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(997)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(998)==0&false)))    {__CLR3_3_0qgqgi96a4yhd.R.inc(999);dbObject.append("msrpValue", data.getMsrpValue());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1000);if ((((data.getCurPrice() != -1.0)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1001)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1002)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(1003);dbObject.append("curPrice", data.getCurPrice());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1004);if ((((data.getReviewState() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1005)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1006)==0&false)))  {__CLR3_3_0qgqgi96a4yhd.R.inc(1007);dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(data.getReviewState()));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1008);if ((((data.getAddDate() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1009)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1010)==0&false)))      {__CLR3_3_0qgqgi96a4yhd.R.inc(1011);dbObject.append("addDate", data.getAddDate());
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1012);if ((((data.getReviewDate() != null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1013)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1014)==0&false)))   {__CLR3_3_0qgqgi96a4yhd.R.inc(1015);dbObject.append("reviewDate", data.getReviewDate());
    
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1016);return dbObject;
  }finally{__CLR3_3_0qgqgi96a4yhd.R.flushNeeded();}}
  
  public static MiniatureMarketPriceData convertMongoToMM(DBObject dbObject) {try{__CLR3_3_0qgqgi96a4yhd.R.inc(1017);
    __CLR3_3_0qgqgi96a4yhd.R.inc(1018);if ((((dbObject == null)&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1019)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1020)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(1021);return null;
    
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1022);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    __CLR3_3_0qgqgi96a4yhd.R.inc(1023);if ((((dbObject.containsField("mmID"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1024)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1025)==0&false)))         {__CLR3_3_0qgqgi96a4yhd.R.inc(1026);data.setMmID((Long)dbObject.get("mmID"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1027);if ((((dbObject.containsField("sku"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1028)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1029)==0&false)))          {__CLR3_3_0qgqgi96a4yhd.R.inc(1030);data.setSku((String)dbObject.get("sku"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1031);if ((((dbObject.containsField("title"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1032)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1033)==0&false)))        {__CLR3_3_0qgqgi96a4yhd.R.inc(1034);data.setTitle((String)dbObject.get("title"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1035);if ((((dbObject.containsField("manufacturer"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1036)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1037)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(1038);data.setManufacturer((String)dbObject.get("manufacturer"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1039);if ((((dbObject.containsField("category"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1040)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1041)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(1042);data.setCategory(MiniatureMarketCategoryConverter.convertFlagToMMCategory((Integer)dbObject.get("category")));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1043);if ((((dbObject.containsField("imageURL"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1044)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1045)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(1046);data.setImageURL((String)dbObject.get("imageURL"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1047);if ((((dbObject.containsField("availability"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1048)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1049)==0&false))) {__CLR3_3_0qgqgi96a4yhd.R.inc(1050);data.setAvailability(GameAvailabilityConverter.convertFlagToGameAvailability((Integer)dbObject.get("availability")));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1051);if ((((dbObject.containsField("msrpValue"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1052)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1053)==0&false)))    {__CLR3_3_0qgqgi96a4yhd.R.inc(1054);data.setMsrpValue((Double)dbObject.get("msrpValue"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1055);if ((((dbObject.containsField("curPrice"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1056)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1057)==0&false)))     {__CLR3_3_0qgqgi96a4yhd.R.inc(1058);data.setCurPrice((Double)dbObject.get("curPrice"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1059);if ((((dbObject.containsField("reviewState"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1060)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1061)==0&false)))  {__CLR3_3_0qgqgi96a4yhd.R.inc(1062);data.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1063);if ((((dbObject.containsField("addDate"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1064)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1065)==0&false)))      {__CLR3_3_0qgqgi96a4yhd.R.inc(1066);data.setAddDate((Date)dbObject.get("addDate"));
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1067);if ((((dbObject.containsField("reviewDate"))&&(__CLR3_3_0qgqgi96a4yhd.R.iget(1068)!=0|true))||(__CLR3_3_0qgqgi96a4yhd.R.iget(1069)==0&false)))   {__CLR3_3_0qgqgi96a4yhd.R.inc(1070);data.setReviewDate((Date)dbObject.get("reviewDate"));
    
    }__CLR3_3_0qgqgi96a4yhd.R.inc(1071);return data;
  }finally{__CLR3_3_0qgqgi96a4yhd.R.flushNeeded();}}
}
