/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.UserDetail;
import com.ac.games.data.UserRoleConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class UserDetailConverter {public static class __CLR3_3_0351351i96a4yvg{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,4133,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param user The UserDetail we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserDetailToIDQuery(UserDetail user) {try{__CLR3_3_0351351i96a4yvg.R.inc(4069);
    __CLR3_3_0351351i96a4yvg.R.inc(4070);if ((((user == null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4071)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4072)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4073);return null;
    
    }__CLR3_3_0351351i96a4yvg.R.inc(4074);BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    __CLR3_3_0351351i96a4yvg.R.inc(4075);return dbObject;
  }finally{__CLR3_3_0351351i96a4yvg.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the userID from the provided game.
   * 
   * @param userID The UserDetail we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertUserDetailToIDQuery(long userID) {try{__CLR3_3_0351351i96a4yvg.R.inc(4076);
    __CLR3_3_0351351i96a4yvg.R.inc(4077);if ((((userID < 0)&&(__CLR3_3_0351351i96a4yvg.R.iget(4078)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4079)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4080);return null;
    
    }__CLR3_3_0351351i96a4yvg.R.inc(4081);BasicDBObject dbObject = new BasicDBObject("userID", userID);
    __CLR3_3_0351351i96a4yvg.R.inc(4082);return dbObject;
  }finally{__CLR3_3_0351351i96a4yvg.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param user The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertUserDetailToMongo(UserDetail user) {try{__CLR3_3_0351351i96a4yvg.R.inc(4083);
    __CLR3_3_0351351i96a4yvg.R.inc(4084);if ((((user == null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4085)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4086)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4087);return null;
    
    }__CLR3_3_0351351i96a4yvg.R.inc(4088);BasicDBObject dbObject = new BasicDBObject("userID", user.getUserID());
    __CLR3_3_0351351i96a4yvg.R.inc(4089);if ((((user.getPass() != null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4090)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4091)==0&false)))          {__CLR3_3_0351351i96a4yvg.R.inc(4092);dbObject.append("pass", user.getPass());
    }__CLR3_3_0351351i96a4yvg.R.inc(4093);if ((((user.getUserRole() != null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4094)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4095)==0&false)))      {__CLR3_3_0351351i96a4yvg.R.inc(4096);dbObject.append("userRole", UserRoleConverter.convertUserRoleToFlag(user.getUserRole()));
    }__CLR3_3_0351351i96a4yvg.R.inc(4097);if ((((user.getCreatedOnDate() != null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4098)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4099)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4100);dbObject.append("createdOnDate", user.getCreatedOnDate());
    }__CLR3_3_0351351i96a4yvg.R.inc(4101);if ((((user.getLastLoginDate() != null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4102)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4103)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4104);dbObject.append("lastLoginDate", user.getLastLoginDate());
    
    }__CLR3_3_0351351i96a4yvg.R.inc(4105);return dbObject;
  }finally{__CLR3_3_0351351i96a4yvg.R.flushNeeded();}}
  
  /**
   * Convert a Mongo BSON record back into a {@link UserDetail} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link UserDetail} object, or null if the dbObject was null
   */
  public static UserDetail convertMongoToUserDetail(DBObject dbObject) {try{__CLR3_3_0351351i96a4yvg.R.inc(4106);
    __CLR3_3_0351351i96a4yvg.R.inc(4107);if ((((dbObject == null)&&(__CLR3_3_0351351i96a4yvg.R.iget(4108)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4109)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4110);return null;
    
    }__CLR3_3_0351351i96a4yvg.R.inc(4111);UserDetail user = new UserDetail();
    __CLR3_3_0351351i96a4yvg.R.inc(4112);if ((((dbObject.containsField("userID"))&&(__CLR3_3_0351351i96a4yvg.R.iget(4113)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4114)==0&false)))        {__CLR3_3_0351351i96a4yvg.R.inc(4115);user.setUserID((Long)dbObject.get("userID"));
    }__CLR3_3_0351351i96a4yvg.R.inc(4116);if ((((dbObject.containsField("pass"))&&(__CLR3_3_0351351i96a4yvg.R.iget(4117)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4118)==0&false)))          {__CLR3_3_0351351i96a4yvg.R.inc(4119);user.setPass((String)dbObject.get("pass"));
    }__CLR3_3_0351351i96a4yvg.R.inc(4120);if ((((dbObject.containsField("userRole"))&&(__CLR3_3_0351351i96a4yvg.R.iget(4121)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4122)==0&false)))      {__CLR3_3_0351351i96a4yvg.R.inc(4123);user.setUserRole(UserRoleConverter.convertFlagToUserRole((Integer)dbObject.get("userRole")));
    }__CLR3_3_0351351i96a4yvg.R.inc(4124);if ((((dbObject.containsField("createdOnDate"))&&(__CLR3_3_0351351i96a4yvg.R.iget(4125)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4126)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4127);user.setCreatedOnDate((Date)dbObject.get("createdOnDate"));
    }__CLR3_3_0351351i96a4yvg.R.inc(4128);if ((((dbObject.containsField("lastLoginDate"))&&(__CLR3_3_0351351i96a4yvg.R.iget(4129)!=0|true))||(__CLR3_3_0351351i96a4yvg.R.iget(4130)==0&false))) {__CLR3_3_0351351i96a4yvg.R.inc(4131);user.setLastLoginDate((Date)dbObject.get("lastLoginDate"));
    }__CLR3_3_0351351i96a4yvg.R.inc(4132);return user;
  }finally{__CLR3_3_0351351i96a4yvg.R.flushNeeded();}}
}
