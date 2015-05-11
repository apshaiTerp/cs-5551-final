/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import com.ac.games.data.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class UserConverter {public static class __CLR3_3_032n32ni96a4yv5{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,4069,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToIDQuery(User user) {try{__CLR3_3_032n32ni96a4yv5.R.inc(3983);
    __CLR3_3_032n32ni96a4yv5.R.inc(3984);if ((((user == null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(3985)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(3986)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(3987);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(3988);BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    __CLR3_3_032n32ni96a4yv5.R.inc(3989);return dbObject;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param userID The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToIDQuery(long userID) {try{__CLR3_3_032n32ni96a4yv5.R.inc(3990);
    __CLR3_3_032n32ni96a4yv5.R.inc(3991);if ((((userID < 0)&&(__CLR3_3_032n32ni96a4yv5.R.iget(3992)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(3993)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(3994);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(3995);BasicDBObject dbObject = new BasicDBObject("userID", userID);
    __CLR3_3_032n32ni96a4yv5.R.inc(3996);return dbObject;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userName from the provided user.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToNameQuery(User user) {try{__CLR3_3_032n32ni96a4yv5.R.inc(3997);
    __CLR3_3_032n32ni96a4yv5.R.inc(3998);if ((((user == null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(3999)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4000)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4001);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(4002);BasicDBObject dbObject = new BasicDBObject("userName", user.getUserName());
    __CLR3_3_032n32ni96a4yv5.R.inc(4003);return dbObject;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userName from the provided user.
   * 
   * @param user The User we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserToNameQuery(String userName) {try{__CLR3_3_032n32ni96a4yv5.R.inc(4004);
    __CLR3_3_032n32ni96a4yv5.R.inc(4005);if ((((userName == null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4006)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4007)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4008);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(4009);BasicDBObject dbObject = new BasicDBObject("userName", userName);
    __CLR3_3_032n32ni96a4yv5.R.inc(4010);return dbObject;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
  
  
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertUserToMongo(User user) {try{__CLR3_3_032n32ni96a4yv5.R.inc(4011);
    __CLR3_3_032n32ni96a4yv5.R.inc(4012);if ((((user == null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4013)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4014)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4015);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(4016);BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    __CLR3_3_032n32ni96a4yv5.R.inc(4017);if ((((user.getUserName() != null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4018)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4019)==0&false)))     {__CLR3_3_032n32ni96a4yv5.R.inc(4020);dbObject.append("userName", user.getUserName());
    }__CLR3_3_032n32ni96a4yv5.R.inc(4021);if ((((user.getFirstName() != null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4022)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4023)==0&false)))    {__CLR3_3_032n32ni96a4yv5.R.inc(4024);dbObject.append("firstName", user.getFirstName());
    }__CLR3_3_032n32ni96a4yv5.R.inc(4025);if ((((user.getLastName() != null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4026)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4027)==0&false)))     {__CLR3_3_032n32ni96a4yv5.R.inc(4028);dbObject.append("lastName", user.getLastName());
    }__CLR3_3_032n32ni96a4yv5.R.inc(4029);if ((((user.getEmailAddress() != null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4030)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4031)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4032);dbObject.append("emailAddress", user.getEmailAddress());
    }__CLR3_3_032n32ni96a4yv5.R.inc(4033);if ((((user.getCollectionID() != -1)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4034)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4035)==0&false)))   {__CLR3_3_032n32ni96a4yv5.R.inc(4036);dbObject.append("collectionID", user.getCollectionID());
    }__CLR3_3_032n32ni96a4yv5.R.inc(4037);return dbObject;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link User} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link User} object, or null if the dbObject was null
   */
  public static User convertMongoToUser(DBObject dbObject) {try{__CLR3_3_032n32ni96a4yv5.R.inc(4038);
    __CLR3_3_032n32ni96a4yv5.R.inc(4039);if ((((dbObject == null)&&(__CLR3_3_032n32ni96a4yv5.R.iget(4040)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4041)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4042);return null;
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(4043);User user = new User();
    __CLR3_3_032n32ni96a4yv5.R.inc(4044);if ((((dbObject.containsField("userID"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4045)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4046)==0&false)))       {__CLR3_3_032n32ni96a4yv5.R.inc(4047);user.setUserID((Long)dbObject.get("userID"));
    }__CLR3_3_032n32ni96a4yv5.R.inc(4048);if ((((dbObject.containsField("userName"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4049)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4050)==0&false)))     {__CLR3_3_032n32ni96a4yv5.R.inc(4051);user.setUserName((String)dbObject.get("userName"));
    }__CLR3_3_032n32ni96a4yv5.R.inc(4052);if ((((dbObject.containsField("firstName"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4053)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4054)==0&false)))    {__CLR3_3_032n32ni96a4yv5.R.inc(4055);user.setFirstName((String)dbObject.get("firstName"));
    }__CLR3_3_032n32ni96a4yv5.R.inc(4056);if ((((dbObject.containsField("lastName"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4057)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4058)==0&false)))     {__CLR3_3_032n32ni96a4yv5.R.inc(4059);user.setLastName((String)dbObject.get("lastName"));
    }__CLR3_3_032n32ni96a4yv5.R.inc(4060);if ((((dbObject.containsField("emailAddress"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4061)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4062)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4063);user.setEmailAddress((String)dbObject.get("emailAddress"));
    }__CLR3_3_032n32ni96a4yv5.R.inc(4064);if ((((dbObject.containsField("collectionID"))&&(__CLR3_3_032n32ni96a4yv5.R.iget(4065)!=0|true))||(__CLR3_3_032n32ni96a4yv5.R.iget(4066)==0&false))) {__CLR3_3_032n32ni96a4yv5.R.inc(4067);user.setCollectionID((Long)dbObject.get("collectionID"));
    
    }__CLR3_3_032n32ni96a4yv5.R.inc(4068);return user;
  }finally{__CLR3_3_032n32ni96a4yv5.R.flushNeeded();}}
}
