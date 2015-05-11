/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.MediaItem;
import com.ac.games.data.MediaItemTypeConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class MediaItemConverter {public static class __CLR3_3_0tstsi96a4yi3{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,1165,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /**
   * Helper method that will construct a basic query using the mediaID from the provided game.
   * 
   * @param user The MediaItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertMediaItemToIDQuery(MediaItem item) {try{__CLR3_3_0tstsi96a4yi3.R.inc(1072);
    __CLR3_3_0tstsi96a4yi3.R.inc(1073);if ((((item == null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1074)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1075)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1076);return null;
    
    }__CLR3_3_0tstsi96a4yi3.R.inc(1077);BasicDBObject dbObject = new BasicDBObject("mediaID", item.getMediaID());
    __CLR3_3_0tstsi96a4yi3.R.inc(1078);return dbObject;
  }finally{__CLR3_3_0tstsi96a4yi3.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param fieldName The field we want to build our query on.
   * @param genericID The generic ID value we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertMediaItemToGenericIDQuery(String fieldName, long genericID) {try{__CLR3_3_0tstsi96a4yi3.R.inc(1079);
    __CLR3_3_0tstsi96a4yi3.R.inc(1080);if ((((genericID < 0)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1081)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1082)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1083);return null;
    
    }__CLR3_3_0tstsi96a4yi3.R.inc(1084);BasicDBObject dbObject = new BasicDBObject(fieldName, genericID);
    __CLR3_3_0tstsi96a4yi3.R.inc(1085);return dbObject;
  }finally{__CLR3_3_0tstsi96a4yi3.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertMediaItemToMongo(MediaItem item) {try{__CLR3_3_0tstsi96a4yi3.R.inc(1086);
    __CLR3_3_0tstsi96a4yi3.R.inc(1087);if ((((item == null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1088)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1089)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1090);return null;
    
    }__CLR3_3_0tstsi96a4yi3.R.inc(1091);BasicDBObject dbObject = new BasicDBObject("mediaID", item.getMediaID());
    __CLR3_3_0tstsi96a4yi3.R.inc(1092);if ((((item.getGameID() <= -1)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1093)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1094)==0&false)))             {__CLR3_3_0tstsi96a4yi3.R.inc(1095);dbObject.append("gameID", item.getGameID());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1096);if ((((item.getUserID() <= -1)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1097)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1098)==0&false)))             {__CLR3_3_0tstsi96a4yi3.R.inc(1099);dbObject.append("userID", item.getUserID());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1100);if ((((item.getUserName() != null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1101)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1102)==0&false)))         {__CLR3_3_0tstsi96a4yi3.R.inc(1103);dbObject.append("userName", item.getUserName());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1104);if ((((item.getItemType() != null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1105)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1106)==0&false)))         {__CLR3_3_0tstsi96a4yi3.R.inc(1107);dbObject.append("itemType", MediaItemTypeConverter.convertMediaItemTypeToFlag(item.getItemType()));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1108);if ((((item.getMediaLink() != null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1109)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1110)==0&false)))        {__CLR3_3_0tstsi96a4yi3.R.inc(1111);dbObject.append("mediaLink", item.getMediaLink());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1112);if ((((item.getMediaDescription() != null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1113)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1114)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1115);dbObject.append("mediaDescription", item.getMediaDescription());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1116);if ((((item.getAddedDate() != null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1117)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1118)==0&false)))        {__CLR3_3_0tstsi96a4yi3.R.inc(1119);dbObject.append("addedDate", item.getAddedDate());
    }__CLR3_3_0tstsi96a4yi3.R.inc(1120);dbObject.append("privateItem", item.isPrivateItem());
    
    __CLR3_3_0tstsi96a4yi3.R.inc(1121);return dbObject;
  }finally{__CLR3_3_0tstsi96a4yi3.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link MediaItem} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link MediaItem} object, or null if the dbObject was null
   */
  public static MediaItem convertMongoToMediaItem(DBObject dbObject) {try{__CLR3_3_0tstsi96a4yi3.R.inc(1122);
    __CLR3_3_0tstsi96a4yi3.R.inc(1123);if ((((dbObject == null)&&(__CLR3_3_0tstsi96a4yi3.R.iget(1124)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1125)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1126);return null;
    
    }__CLR3_3_0tstsi96a4yi3.R.inc(1127);MediaItem item = new MediaItem();
    __CLR3_3_0tstsi96a4yi3.R.inc(1128);if ((((dbObject.containsField("mediaID"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1129)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1130)==0&false)))          {__CLR3_3_0tstsi96a4yi3.R.inc(1131);item.setMediaID((Long)dbObject.get("mediaID"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1132);if ((((dbObject.containsField("gameID"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1133)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1134)==0&false)))           {__CLR3_3_0tstsi96a4yi3.R.inc(1135);item.setGameID((Long)dbObject.get("gameID"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1136);if ((((dbObject.containsField("userID"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1137)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1138)==0&false)))           {__CLR3_3_0tstsi96a4yi3.R.inc(1139);item.setUserID((Long)dbObject.get("userID"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1140);if ((((dbObject.containsField("userName"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1141)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1142)==0&false)))         {__CLR3_3_0tstsi96a4yi3.R.inc(1143);item.setUserName((String)dbObject.get("userName"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1144);if ((((dbObject.containsField("itemType"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1145)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1146)==0&false)))         {__CLR3_3_0tstsi96a4yi3.R.inc(1147);item.setItemType(MediaItemTypeConverter.convertFlagToMediaItemType((Integer)dbObject.get("itemType")));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1148);if ((((dbObject.containsField("mediaLink"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1149)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1150)==0&false)))        {__CLR3_3_0tstsi96a4yi3.R.inc(1151);item.setMediaLink((String)dbObject.get("mediaLink"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1152);if ((((dbObject.containsField("mediaDescription"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1153)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1154)==0&false))) {__CLR3_3_0tstsi96a4yi3.R.inc(1155);item.setMediaDescription((String)dbObject.get("mediaDescription"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1156);if ((((dbObject.containsField("addedDate"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1157)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1158)==0&false)))        {__CLR3_3_0tstsi96a4yi3.R.inc(1159);item.setAddedDate((Date)dbObject.get("addedDate"));
    }__CLR3_3_0tstsi96a4yi3.R.inc(1160);if ((((dbObject.containsField("privateItem"))&&(__CLR3_3_0tstsi96a4yi3.R.iget(1161)!=0|true))||(__CLR3_3_0tstsi96a4yi3.R.iget(1162)==0&false)))      {__CLR3_3_0tstsi96a4yi3.R.inc(1163);item.setPrivateItem((Boolean)dbObject.get("privateItem"));
    
    }__CLR3_3_0tstsi96a4yi3.R.inc(1164);return item;
  }finally{__CLR3_3_0tstsi96a4yi3.R.flushNeeded();}}
}
