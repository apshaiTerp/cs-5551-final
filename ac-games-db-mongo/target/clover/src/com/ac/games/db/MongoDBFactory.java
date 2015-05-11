/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db;

import com.ac.games.db.mongo.MongoGamesDatabase;

/**
 * @author ac010168
 *
 */
public class MongoDBFactory {public static class __CLR3_3_000i96a4y8f{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,8,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** This is the static reference to access the Mongo Database class as a singleton. */
  private static GamesDatabase database = null;
  
  /**
   * Factory Creation method to generate a new MongoDB Game Database connection.
   * 
   * @param mongoHostAddress The hostAddress where the mongoDB server is running
   * @param mongoPort The port to connect to MongoDB
   * @param databaseName The database name we want to work with.
   *
   * @return A new {@link MongoGamesDatabase} object.
   */
  public final static GamesDatabase createMongoGamesDatabase(String mongoHostAddress, int mongoPort, String databaseName) {try{__CLR3_3_000i96a4y8f.R.inc(0);
    __CLR3_3_000i96a4y8f.R.inc(1);if ((((database == null)&&(__CLR3_3_000i96a4y8f.R.iget(2)!=0|true))||(__CLR3_3_000i96a4y8f.R.iget(3)==0&false))) 
      {__CLR3_3_000i96a4y8f.R.inc(4);database = new MongoGamesDatabase(mongoHostAddress, mongoPort, databaseName);
    }__CLR3_3_000i96a4y8f.R.inc(5);return database;
  }finally{__CLR3_3_000i96a4y8f.R.flushNeeded();}}
  
  /**
   * This method is helpful when the database connection has already been opened.
   * 
   * @return the {@link GamesDatabase} reference, or null if it hasn't been created
   */
  public final static GamesDatabase getMongoGamesDatabase() {try{__CLR3_3_000i96a4y8f.R.inc(6);
    __CLR3_3_000i96a4y8f.R.inc(7);return database;
  }finally{__CLR3_3_000i96a4y8f.R.flushNeeded();}}
}
