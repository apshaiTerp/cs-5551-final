/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.ac.games.data.BGGGame;
import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.CoolStuffIncCategoryConverter;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameType;
import com.ac.games.data.GameTypeConverter;
import com.ac.games.data.MMDataStats;
import com.ac.games.data.MediaItem;
import com.ac.games.data.MiniatureMarketCategoryConverter;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.PlaythruItem;
import com.ac.games.data.ReviewState;
import com.ac.games.data.ReviewStateConverter;
import com.ac.games.data.SimpleSortable;
import com.ac.games.data.User;
import com.ac.games.data.UserCollectionStats;
import com.ac.games.data.UserDetail;
import com.ac.games.data.WishlistItem;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

/**
 * This class represents the MongoDB implementation of our {@link GamesDatabase} interface. 
 * 
 * @author ac010168
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class MongoGamesDatabase implements GamesDatabase {public static class __CLR3_3_0wdwdi96a4yrl{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,3788,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** Reference to the host address for mongo.  Might just be "localhost". */
  private final String mongoHostAddress;
  /** Port number used for mongo.  Is typically 27017. */
  private final int mongoPort;
  /** Database name to be connected to. */
  private final String databaseName;
  
  /** Reference to the active mongoClient. */
  private MongoClient mongoClient;
  /** Reference to the active database used by this connection. */
  private DB mongoDB;
  
  /** Global setting to help manage debug println statements */
  public static boolean debugMode = false;
  
  /**
   * Basic Constructor for a MongoGameDatabase Object.
   * @param mongoHostAddress The hostAddress where the mongoDB server is running
   * @param mongoPort The port to connect to MongoDB
   * @param databaseName The database name we want to work with.
   */
  public MongoGamesDatabase(String mongoHostAddress, int mongoPort, String databaseName) {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1165);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1166);this.mongoHostAddress = mongoHostAddress;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1167);this.mongoPort        = mongoPort;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1168);this.databaseName     = databaseName;
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1169);setMongoClient(null);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1170);setMongoDB(null);
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @return the mongoHostAddress
   */
  public String getMongoHostAddress() {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1171);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1172);return mongoHostAddress;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @return the mongoPort
   */
  public int getMongoPort() {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1173);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1174);return mongoPort;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @return the databaseName
   */
  public String getDatabaseName() {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1175);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1176);return databaseName;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @return the mongoClient
   */
  public MongoClient getMongoClient() {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1177);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1178);return mongoClient;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @param mongoClient the mongoClient to set
   */
  public void setMongoClient(MongoClient mongoClient) {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1179);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1180);this.mongoClient = mongoClient;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @return the mongoDB
   */
  public DB getMongoDB() {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1181);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1182);return mongoDB;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * @param mongoDB the mongoDB to set
   */
  public void setMongoDB(DB mongoDB) {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1183);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1184);this.mongoDB = mongoDB;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#initializeDBConnection()
   */
  public void initializeDBConnection() throws ConfigurationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1185);
    //Checking to see if connection is already open...
    __CLR3_3_0wdwdi96a4yrl.R.inc(1186);if ((((mongoClient != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1187)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1188)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1189);System.out.println ("The connection is already open, do not reset.");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1190);return;
    }
    
    //Initializing Database Connection Client
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1191);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1192);mongoClient = new MongoClient(mongoHostAddress, mongoPort);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1193);mongoClient.setWriteConcern(WriteConcern.JOURNALED);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1194);mongoClient = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1195);throw new ConfigurationException("Unable to connect to MongoDB at " + mongoHostAddress + ":" + mongoPort);      
    }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1196);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1197);mongoDB = mongoClient.getDB(databaseName);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1198);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1199);mongoClient.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      __CLR3_3_0wdwdi96a4yrl.R.inc(1200);mongoClient = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1201);mongoDB     = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1202);throw new ConfigurationException("Unable to connect to Mongo Database [" + databaseName + "]");
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#closeDBConnection()
   */
  public void closeDBConnection() throws ConfigurationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1203);
    //Close the current collection
    __CLR3_3_0wdwdi96a4yrl.R.inc(1204);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1205);if ((((mongoClient != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1206)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1207)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1208);mongoClient.close();
    }} catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1209);t.printStackTrace();
    }
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1210);mongoClient = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1211);mongoDB     = null;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameData(long)
   */
  public BGGGame readBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1212);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1213);if ((((bggID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1214)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1215)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1216);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1217);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1218)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1219)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1220);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1221);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1222);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1223);BasicDBObject searchObject  = BGGGameConverter.convertGameToIDQuery(bggID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1224);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1225);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1226)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1227)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1228);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1229);BGGGame game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1230);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1231)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1232)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1233);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1234);game = BGGGameConverter.convertMongoToGame(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1235);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1236);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1237);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1238)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1239)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1240);System.out.println ("The game found by this query was:                   " + ((((game == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1241)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1242)==0&false))? "Nothing Found" : game.getName()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1243);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1244);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1245);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertBGGGameData(com.ac.games.data.BGGGame)
   */
  public void insertBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1246);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1247);if ((((game == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1248)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1249)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1250);throw new DatabaseOperationException("The provided game object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1251);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1252)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1253)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1254);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1255);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(1256);ObjectId prevDocID = queryForExistingBGGDocID(game.getBggID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(1257);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1258)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1259)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1260);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1261)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1262)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1263);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(1264);updateBGGGameData(game);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1265);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1266);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1267);BasicDBObject addObject = BGGGameConverter.convertGameToMongo(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1268);WriteResult result = gameCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1269);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1270)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1271)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1272);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1273);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1274);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1275);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1276);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateBGGGameData(com.ac.games.data.BGGGame)
   */
  public void updateBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1277);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1278);if ((((game == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1279)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1280)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1281);throw new DatabaseOperationException("The provided game object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1282);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1283)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1284)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1285);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1286);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1287);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1288);BasicDBObject queryObject  = BGGGameConverter.convertGameToIDQuery(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1289);BasicDBObject updateObject = BGGGameConverter.convertGameToMongo(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1290);WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1291);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1292)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1293)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1294);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1295);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1296);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1297);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteBGGGameData(long)
   */
  public void deleteBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1298);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1299);if ((((bggID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1300)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1301)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1302);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1303);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1304)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1305)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1306);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1307);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1308);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1309);BasicDBObject deleteObject  = BGGGameConverter.convertGameToIDQuery(bggID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1310);WriteResult result = gameCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1311);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1312)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1313)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1314);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1315);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1316);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingBGGDocID(long bggID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1317);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(1318);DBCollection gameCollection = mongoDB.getCollection("bgggame");
    __CLR3_3_0wdwdi96a4yrl.R.inc(1319);BasicDBObject searchObject  = BGGGameConverter.convertGameToIDQuery(bggID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1320);DBCursor cursor = gameCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1321);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1322);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1323)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1324)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1325);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1326);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1327);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1328);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIPriceData(long)
   */
  public CoolStuffIncPriceData readCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1329);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1330);if ((((csiID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1331)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1332)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1333);throw new DatabaseOperationException("The provided price data object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1334);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1335)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1336)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1337);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1338);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1339);DBCollection gameCollection = mongoDB.getCollection("csidata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1340);BasicDBObject searchObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1341);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1342);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1343)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1344)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1345);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1346);CoolStuffIncPriceData data = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1347);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1348)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1349)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1350);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1351);data = CSIDataConverter.convertMongoToCSI(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1352);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1353);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(1354);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1355)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1356)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1357);System.out.println ("The game found by this query was:                   " + ((((data == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1358)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1359)==0&false))? "Nothing Found" : data.getTitle()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1360);return data;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1361);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1362);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCSIPriceData(com.ac.games.data.CoolStuffIncPriceData)
   */
  public void insertCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1363);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1364);if ((((csiData == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1365)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1366)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1367);throw new DatabaseOperationException("The provided price data object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1368);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1369)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1370)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1371);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1372);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(1373);ObjectId prevDocID = queryForExistingCSIDocID(csiData.getCsiID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(1374);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1375)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1376)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1377);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1378)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1379)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1380);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(1381);updateCSIPriceData(csiData);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1382);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1383);DBCollection gameCollection = mongoDB.getCollection("csidata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1384);BasicDBObject addObject = CSIDataConverter.convertCSIToMongo(csiData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1385);WriteResult result = gameCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1386);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1387)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1388)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1389);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1390);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1391);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1392);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1393);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCSIPriceData(com.ac.games.data.CoolStuffIncPriceData)
   */
  public void updateCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1394);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1395);if ((((csiData == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1396)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1397)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1398);throw new DatabaseOperationException("The provided price data object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1399);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1400)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1401)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1402);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1403);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1404);DBCollection gameCollection = mongoDB.getCollection("csidata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1405);BasicDBObject queryObject  = CSIDataConverter.convertCSIToIDQuery(csiData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1406);BasicDBObject updateObject = CSIDataConverter.convertCSIToMongo(csiData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1407);WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1408);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1409)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1410)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1411);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1412);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1413);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1414);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCSIPriceData(long)
   */
  public void deleteCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1415);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1416);if ((((csiID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1417)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1418)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1419);throw new DatabaseOperationException("The provided price data object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1420);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1421)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1422)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1423);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1424);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1425);DBCollection gameCollection = mongoDB.getCollection("csidata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1426);BasicDBObject deleteObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1427);WriteResult result = gameCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1428);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1429)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1430)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1431);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1432);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1433);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param csiID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCSIDocID(long csiID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1434);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(1435);DBCollection gameCollection = mongoDB.getCollection("csidata");
    __CLR3_3_0wdwdi96a4yrl.R.inc(1436);BasicDBObject searchObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1437);DBCursor cursor = gameCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1438);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1439);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1440)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1441)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1442);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1443);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1444);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1445);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMPriceData(long)
   */
  public MiniatureMarketPriceData readMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1446);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1447);if ((((mmID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1448)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1449)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1450);throw new DatabaseOperationException("The provided price data object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1451);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1452)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1453)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1454);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1455);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1456);DBCollection gameCollection = mongoDB.getCollection("mmdata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1457);BasicDBObject searchObject  = MMDataConverter.convertMMToIDQuery(mmID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1458);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1459);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1460)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1461)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1462);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1463);MiniatureMarketPriceData data = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1464);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1465)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1466)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1467);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1468);data = MMDataConverter.convertMongoToMM(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1469);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1470);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1471);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1472)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1473)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1474);System.out.println ("The game found by this query was:                   " + ((((data == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1475)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1476)==0&false))? "Nothing Found" : data.getTitle()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1477);return data;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1478);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1479);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMMPriceData(com.ac.games.data.MiniatureMarketPriceData)
   */
  public void insertMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1480);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1481);if ((((mmData == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1482)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1483)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1484);throw new DatabaseOperationException("The provided price data object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1485);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1486)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1487)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1488);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1489);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(1490);ObjectId prevDocID = queryForExistingMMDocID(mmData.getMmID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(1491);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1492)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1493)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1494);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1495)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1496)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1497);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(1498);updateMMPriceData(mmData);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1499);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1500);DBCollection gameCollection = mongoDB.getCollection("mmdata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1501);BasicDBObject addObject = MMDataConverter.convertMMToMongo(mmData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1502);WriteResult result = gameCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1503);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1504)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1505)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1506);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1507);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1508);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1509);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1510);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateMMPriceData(com.ac.games.data.MiniatureMarketPriceData)
   */
  public void updateMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1511);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1512);if ((((mmData == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1513)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1514)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1515);throw new DatabaseOperationException("The provided price data object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1516);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1517)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1518)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1519);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1520);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1521);DBCollection gameCollection = mongoDB.getCollection("mmdata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1522);BasicDBObject queryObject  = MMDataConverter.convertMMToIDQuery(mmData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1523);BasicDBObject updateObject = MMDataConverter.convertMMToMongo(mmData);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1524);WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1525);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1526)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1527)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1528);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1529);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1530);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1531);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteMMPriceData(long)
   */
  public void deleteMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1532);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1533);if ((((mmID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1534)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1535)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1536);throw new DatabaseOperationException("The provided price data object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1537);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1538)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1539)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1540);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1541);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1542);DBCollection gameCollection = mongoDB.getCollection("mmdata");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1543);BasicDBObject deleteObject  = MMDataConverter.convertMMToIDQuery(mmID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1544);WriteResult result = gameCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1545);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1546)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1547)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1548);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1549);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1550);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param mmID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingMMDocID(long mmID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1551);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(1552);DBCollection gameCollection = mongoDB.getCollection("mmdata");
    __CLR3_3_0wdwdi96a4yrl.R.inc(1553);BasicDBObject searchObject  = MMDataConverter.convertMMToIDQuery(mmID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1554);DBCursor cursor = gameCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1555);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1556);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1557)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1558)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1559);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1560);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1561);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1562);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getBggIDList()
   */
  public List<Long> getBggIDList() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1563);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1564);return getGenericIDList("bgggame", "bggID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getCSIIDList()
   */
  public List<Long> getCSIIDList() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1565);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1566);return getGenericIDList("csidata", "csiID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMMIDList()
   */
  public List<Long> getMMIDList() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1567);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1568);return getGenericIDList("mmdata", "mmID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGame(long)
   */
  public Game readGame(long gameID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1569);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1570);if ((((gameID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1571)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1572)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1573);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1574);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1575)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1576)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1577);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1578);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1579);DBCollection gameCollection = mongoDB.getCollection("game");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1580);BasicDBObject searchObject  = GameConverter.convertGameToIDQuery(gameID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1581);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1582);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1583)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1584)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1585);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1586);Game game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1587);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1588)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1589)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1590);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1591);game = GameConverter.convertMongoToGame(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1592);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1593);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(1594);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1595)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1596)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1597);System.out.println ("The game found by this query was:                   " + ((((game == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1598)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1599)==0&false))? "Nothing Found" : game.getName()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1600);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1601);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1602);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGame(long)
   */
  public Game readGameByBGGID(long bggID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1603);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1604);if ((((bggID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1605)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1606)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1607);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1608);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1609)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1610)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1611);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1612);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1613);DBCollection gameCollection = mongoDB.getCollection("game");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1614);BasicDBObject searchObject  = GameConverter.convertGameToBGGIDQuery(bggID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1615);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1616);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1617)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1618)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1619);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1620);Game game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1621);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1622)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1623)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1624);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1625);game = GameConverter.convertMongoToGame(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1626);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1627);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(1628);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1629)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1630)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1631);System.out.println ("The game found by this query was:                   " + ((((game == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1632)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1633)==0&false))? "Nothing Found" : game.getName()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1634);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1635);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1636);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertGame(com.ac.games.data.Game)
   */
  public void insertGame(Game game) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1637);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1638);if ((((game == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1639)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1640)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1641);throw new DatabaseOperationException("The provided game object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1642);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1643)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1644)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1645);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1646);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(1647);ObjectId prevDocID = queryForExistingGameDocID(game.getGameID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(1648);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1649)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1650)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1651);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1652)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1653)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1654);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(1655);updateGame(game);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1656);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1657);DBCollection gameCollection = mongoDB.getCollection("game");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1658);BasicDBObject addObject = GameConverter.convertGameToMongo(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1659);WriteResult result = gameCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1660);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1661)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1662)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1663);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1664);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1665);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1666);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1667);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateGame(com.ac.games.data.Game)
   */
  public void updateGame(Game game) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1668);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1669);if ((((game == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1670)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1671)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1672);throw new DatabaseOperationException("The provided game object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1673);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1674)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1675)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1676);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1677);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1678);DBCollection gameCollection = mongoDB.getCollection("game");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1679);BasicDBObject queryObject  = GameConverter.convertGameToIDQuery(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1680);BasicDBObject updateObject = GameConverter.convertGameToMongo(game);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1681);WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1682);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1683)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1684)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1685);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1686);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1687);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1688);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteGame(long)
   */
  public void deleteGame(long gameID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1689);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1690);if ((((gameID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1691)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1692)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1693);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1694);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1695)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1696)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1697);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1698);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1699);DBCollection gameCollection = mongoDB.getCollection("game");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1700);BasicDBObject deleteObject  = GameConverter.convertGameToIDQuery(gameID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1701);WriteResult result = gameCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1702);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1703)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1704)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1705);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1706);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1707);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getGameIDList()
   */
  public List<Long> getGameIDList() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1708);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1709);return getGenericIDList("game", "gameID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingGameDocID(long gameID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1710);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(1711);DBCollection gameCollection = mongoDB.getCollection("game");
    __CLR3_3_0wdwdi96a4yrl.R.inc(1712);BasicDBObject searchObject  = GameConverter.convertGameToIDQuery(gameID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1713);DBCursor cursor = gameCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1714);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1715);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1716)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1717)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1718);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1719);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1720);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1721);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGameReltn(long)
   */
  public GameReltn readGameReltn(long gameID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1722);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1723);if ((((gameID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1724)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1725)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1726);throw new DatabaseOperationException("The provided game relation data was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1727);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1728)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1729)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1730);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1731);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1732);DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1733);BasicDBObject searchObject  = GameReltnConverter.convertGameReltnToGameIDQuery(gameID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1734);DBCursor cursor = reltnCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1735);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1736)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1737)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1738);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1739);GameReltn gameReltn = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1740);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1741)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1742)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1743);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1744);gameReltn = GameReltnConverter.convertMongoToGameReltn(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1745);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1746);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(1747);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1748)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1749)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1750);System.out.println ("The game found by this query was:                   " + ((((gameReltn == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1751)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1752)==0&false))? "Nothing Found" : gameReltn.getReltnID()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1753);return gameReltn;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1754);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1755);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertGameReltn(com.ac.games.data.GameReltn)
   */
  public void insertGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1756);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1757);if ((((gameReltn == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1758)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1759)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1760);throw new DatabaseOperationException("The provided game relation object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1761);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1762)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1763)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1764);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1765);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(1766);ObjectId prevDocID = queryForExistingGameReltnDocID(gameReltn.getReltnID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(1767);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1768)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1769)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1770);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1771)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1772)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1773);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(1774);updateGameReltn(gameReltn);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1775);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1776);DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1777);BasicDBObject addObject = GameReltnConverter.convertGameReltnToMongo(gameReltn);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1778);WriteResult result = reltnCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1779);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1780)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1781)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1782);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1783);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1784);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1785);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1786);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateGameReltn(com.ac.games.data.GameReltn)
   */
  public void updateGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1787);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1788);if ((((gameReltn == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1789)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1790)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1791);throw new DatabaseOperationException("The provided game relation object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1792);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1793)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1794)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1795);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1796);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1797);DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1798);BasicDBObject queryObject  = GameReltnConverter.convertGameReltnToIDQuery(gameReltn);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1799);BasicDBObject updateObject = GameReltnConverter.convertGameReltnToMongo(gameReltn);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1800);WriteResult result = reltnCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1801);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1802)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1803)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1804);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(1805);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1806);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1807);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteGameReltn(long)
   */
  public void deleteGameReltn(long reltnID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1808);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1809);if ((((reltnID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1810)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1811)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1812);throw new DatabaseOperationException("The provided game object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1813);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1814)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1815)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1816);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1817);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1818);DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1819);BasicDBObject deleteObject  = GameReltnConverter.convertGameReltnToReltnIDQuery(reltnID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1820);WriteResult result = reltnCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1821);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1822)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1823)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1824);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1825);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1826);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingGameReltnDocID(long reltnID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1827);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(1828);DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
    __CLR3_3_0wdwdi96a4yrl.R.inc(1829);BasicDBObject searchObject  = GameReltnConverter.convertGameReltnToReltnIDQuery(reltnID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1830);DBCursor cursor = reltnCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1831);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1832);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1833)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1834)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(1835);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1836);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1837);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(1838);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getGameReltnIDList()
   */
  public List<Long> getGameReltnIDList() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1839);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1840);return getGenericIDList("gamereltn", "reltnID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /**
   * Generic Helper method to only perform this code once.
   * 
   * @param collection The collection, or table name, we are wanting the list of values for
   * @param fieldName  The field name of the column we want the list of values for
   * 
   * @return The List of requested values, or an empty list if nothing found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  private List<Long> getGenericIDList(String collection, String fieldName) {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1841);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1842);List<Long> resultList = new LinkedList<Long>();
    __CLR3_3_0wdwdi96a4yrl.R.inc(1843);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1844);DBCollection reltnCollection = mongoDB.getCollection(collection);
      //Limit the result set to reltnIDs
      __CLR3_3_0wdwdi96a4yrl.R.inc(1845);BasicDBObject columns = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(1846);columns.put(fieldName, 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1847);columns.put("_id", 0);
      //Search for all documents, return only the bggID values
      __CLR3_3_0wdwdi96a4yrl.R.inc(1848);DBCursor cursor = reltnCollection.find(new BasicDBObject(), columns); 
      __CLR3_3_0wdwdi96a4yrl.R.inc(1849);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1850)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1851)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1852);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1853);long curID = (Long)object.get(fieldName);
        __CLR3_3_0wdwdi96a4yrl.R.inc(1854);if ((((!resultList.contains(curID))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1855)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1856)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(1857);resultList.add(curID);
      }}
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1858);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1859);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1860);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1861);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(1862);return resultList;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxBGGGameID()
   */
  public long getMaxBGGGameID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1863);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1864);return getGenericMaxID("bgggame", "bggID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCSIDataID()
   */
  public long getMaxCSIDataID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1865);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1866);return getGenericMaxID("csidata", "csiID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxMMDataID()
   */
  public long getMaxMMDataID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1867);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1868);return getGenericMaxID("mmdata", "mmID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxGameID()
   */
  public long getMaxGameID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1869);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1870);return getGenericMaxID("game", "gameID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxGameReltnID()
   */
  public long getMaxGameReltnID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1871);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1872);return getGenericMaxID("gamereltn", "reltnID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /**
   * Generic Helper method to only perform this code once.
   * 
   * @param collection The collection, or table name, we are wanting the max value on
   * @param fieldName  The field name of the column we want the max performed on
   * 
   * @return The max id value for this column in this collection, or -1 if not found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  private long getGenericMaxID(String collection, String fieldName) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1873);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1874);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1875)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1876)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1877);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1878);long result = 0;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1879);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1880);DBCollection curCollection = mongoDB.getCollection(collection);
      
      //This is the format we are trying to emulate:
      //db.bgggame.aggregate( { $group : { _id  : "", maxValue : { $max : "$bggID" } } } )

      __CLR3_3_0wdwdi96a4yrl.R.inc(1881);DBObject maxObject         = new BasicDBObject("$max", "$" + fieldName);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1882);DBObject groupFieldsObject = new BasicDBObject("_id", "");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1883);groupFieldsObject.put("maxValue", maxObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1884);DBObject groupObject       = new BasicDBObject("$group", groupFieldsObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1885);List<DBObject> pipeline = new ArrayList<DBObject>(1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1886);pipeline.add(groupObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1887);AggregationOutput output = curCollection.aggregate(pipeline);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1888);for (DBObject object : output.results()) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1889);if ((((object.containsField("maxValue"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1890)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1891)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(1892);result = (Long)object.get("maxValue");
      }}

      }__CLR3_3_0wdwdi96a4yrl.R.inc(1893);return result;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1894);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1895);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public int getBGGGameCount() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1896);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1897);return getGenericCount("bgggame");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public int getCSIDataCount() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1898);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1899);return getGenericCount("csidata");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public int getMMDataCount() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1900);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1901);return getGenericCount("mmdata");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public int getGameCount() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1902);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1903);return getGenericCount("game");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * Generic Helper method to only perform this code once.
   * 
   * @param collection The collection, or table name, we are wanting the row count
   * @param fieldName  The field name of the column we want the row count for
   * 
   * @return The count of documents in this collection, or -1 if not found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  private int getGenericCount(String collection) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1904);
    __CLR3_3_0wdwdi96a4yrl.R.inc(1905);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1906)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1907)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1908);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1909);int result = -1;
    __CLR3_3_0wdwdi96a4yrl.R.inc(1910);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1911);DBCollection curCollection = mongoDB.getCollection(collection);
      
      //This is the format we are trying to emulate:
      //db.collection.aggregate( { $group : { _id  : "", count : { $sum : 1 } } } )

      __CLR3_3_0wdwdi96a4yrl.R.inc(1912);DBObject maxObject         = new BasicDBObject("$sum", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1913);DBObject groupFieldsObject = new BasicDBObject("_id", "");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1914);groupFieldsObject.put("count", maxObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1915);DBObject groupObject       = new BasicDBObject("$group", groupFieldsObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1916);List<DBObject> pipeline = new ArrayList<DBObject>(1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1917);pipeline.add(groupObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1918);AggregationOutput output = curCollection.aggregate(pipeline);
      __CLR3_3_0wdwdi96a4yrl.R.inc(1919);for (DBObject object : output.results()) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1920);if ((((object.containsField("count"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1921)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1922)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(1923);result = (Integer)object.get("count");
      }}
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1924);return result;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1925);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1926);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUser(java.lang.String)
   */
  public User readUser(String userName) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1927);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1928);if ((((userName == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1929)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1930)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1931);throw new DatabaseOperationException("The provided user name was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1932);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1933)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1934)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1935);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1936);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1937);DBCollection userCollection = mongoDB.getCollection("user");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1938);BasicDBObject searchObject  = UserConverter.convertUserToNameQuery(userName);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1939);DBCursor cursor = userCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1940);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1941)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1942)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1943);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1944);User user = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1945);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1946)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1947)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1948);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1949);user = UserConverter.convertMongoToUser(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1950);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1951);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1952);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1953)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1954)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1955);System.out.println ("The user found by this query was:                   " + ((((user == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1956)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1957)==0&false))? "Nothing Found" : user.getUserName()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1958);return user;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1959);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1960);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUser(java.lang.String)
   */
  public User readUser(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1961);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1962);if ((((userID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1963)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1964)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1965);throw new DatabaseOperationException("The provided user ID was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1966);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1967)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1968)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1969);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(1970);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(1971);DBCollection userCollection = mongoDB.getCollection("user");
      __CLR3_3_0wdwdi96a4yrl.R.inc(1972);BasicDBObject searchObject  = UserConverter.convertUserToIDQuery(userID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1973);DBCursor cursor = userCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1974);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1975)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1976)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1977);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1978);User user = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(1979);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1980)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1981)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(1982);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(1983);user = UserConverter.convertMongoToUser(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1984);try { __CLR3_3_0wdwdi96a4yrl.R.inc(1985);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(1986);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1987)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1988)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(1989);System.out.println ("The user found by this query was:                   " + ((((user == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1990)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1991)==0&false))? "Nothing Found" : user.getUserName()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(1992);return user;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1993);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(1994);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertUser(com.ac.games.data.User)
   */
  public void insertUser(User user) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(1995);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(1996);if ((((user == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(1997)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(1998)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(1999);throw new DatabaseOperationException("The provided user object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2000);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2001)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2002)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2003);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2004);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2005);ObjectId prevDocID = queryForExistingUserDocID(user.getUserID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2006);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2007)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2008)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2009);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2010)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2011)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2012);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2013);updateUser(user);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2014);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2015);DBCollection userCollection = mongoDB.getCollection("user");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2016);BasicDBObject addObject = UserConverter.convertUserToMongo(user);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2017);WriteResult result = userCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2018);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2019)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2020)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2021);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2022);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2023);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2024);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2025);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateUser(com.ac.games.data.User)
   */
  public void updateUser(User user) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2026);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2027);if ((((user == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2028)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2029)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2030);throw new DatabaseOperationException("The provided user object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2031);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2032)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2033)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2034);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2035);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2036);DBCollection userCollection = mongoDB.getCollection("user");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2037);BasicDBObject queryObject  = UserConverter.convertUserToIDQuery(user);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2038);BasicDBObject updateObject = UserConverter.convertUserToMongo(user);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2039);WriteResult result = userCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2040);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2041)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2042)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2043);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2044);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2045);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2046);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteUser(long)
   */
  public void deleteUser(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2047);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2048);if ((((userID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2049)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2050)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2051);throw new DatabaseOperationException("The provided user object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2052);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2053)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2054)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2055);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2056);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2057);DBCollection userCollection = mongoDB.getCollection("user");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2058);BasicDBObject deleteObject  = UserConverter.convertUserToIDQuery(userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2059);WriteResult result = userCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2060);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2061)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2062)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2063);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2064);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2065);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxUserID()
   */
  public long getMaxUserID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2066);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2067);return getGenericMaxID("user", "userID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingUserDocID(long userID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2068);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2069);DBCollection userCollection = mongoDB.getCollection("user");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2070);BasicDBObject searchObject  = UserConverter.convertUserToIDQuery(userID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2071);DBCursor cursor = userCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2072);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2073);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2074)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2075)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2076);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2077);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2078);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2079);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUserDetail(long)
   */
  public UserDetail readUserDetail(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2080);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2081);if ((((userID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2082)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2083)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2084);throw new DatabaseOperationException("The provided User Detail object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2085);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2086)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2087)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2088);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2089);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2090);DBCollection userCollection = mongoDB.getCollection("userdetail");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2091);BasicDBObject searchObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2092);DBCursor cursor = userCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2093);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2094)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2095)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2096);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2097);UserDetail user = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2098);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2099)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2100)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2101);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2102);user = UserDetailConverter.convertMongoToUserDetail(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2103);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2104);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2105);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2106)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2107)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2108);System.out.println ("The user found by this query was:                   " + ((((user == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2109)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2110)==0&false))? "Nothing Found" : user.getUserID()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2111);return user;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2112);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2113);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertUserDetail(com.ac.games.data.UserDetail)
   */
  public void insertUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2114);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2115);if ((((userDetail == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2116)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2117)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2118);throw new DatabaseOperationException("The provided user detail object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2119);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2120)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2121)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2122);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2123);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2124);ObjectId prevDocID = queryForExistingUserDetailDocID(userDetail.getUserID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2125);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2126)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2127)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2128);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2129)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2130)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2131);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2132);updateUserDetail(userDetail);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2133);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2134);DBCollection userCollection = mongoDB.getCollection("userdetail");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2135);BasicDBObject addObject = UserDetailConverter.convertUserDetailToMongo(userDetail);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2136);WriteResult result = userCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2137);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2138)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2139)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2140);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2141);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2142);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2143);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2144);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateUserDetail(com.ac.games.data.UserDetail)
   */
  public void updateUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2145);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2146);if ((((userDetail == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2147)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2148)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2149);throw new DatabaseOperationException("The provided game object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2150);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2151)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2152)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2153);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2154);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2155);DBCollection userCollection = mongoDB.getCollection("userdetail");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2156);BasicDBObject queryObject  = UserDetailConverter.convertUserDetailToIDQuery(userDetail);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2157);BasicDBObject updateObject = UserDetailConverter.convertUserDetailToMongo(userDetail);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2158);WriteResult result = userCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2159);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2160)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2161)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2162);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2163);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2164);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2165);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteUserDetail(long)
   */
  public void deleteUserDetail(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2166);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2167);if ((((userID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2168)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2169)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2170);throw new DatabaseOperationException("The provided user object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2171);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2172)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2173)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2174);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2175);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2176);DBCollection userCollection = mongoDB.getCollection("userdetail");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2177);BasicDBObject deleteObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2178);WriteResult result = userCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2179);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2180)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2181)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2182);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2183);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2184);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingUserDetailDocID(long userID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2185);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2186);DBCollection userCollection = mongoDB.getCollection("userdetail");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2187);BasicDBObject searchObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2188);DBCursor cursor = userCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2189);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2190);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2191)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2192)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2193);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2194);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2195);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2196);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCollection(long)
   */
  public Collection readCollection(long collectionID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2197);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2198);if ((((collectionID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2199)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2200)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2201);throw new DatabaseOperationException("The provided collection ID was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2202);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2203)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2204)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2205);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2206);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2207);DBCollection collectionCollection = mongoDB.getCollection("collection");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2208);BasicDBObject searchObject        = CollectionConverter.convertCollectionToIDQuery(collectionID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2209);DBCursor cursor = collectionCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2210);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2211)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2212)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2213);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2214);Collection collection = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2215);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2216)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2217)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2218);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2219);collection = CollectionConverter.convertMongoToCollection(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2220);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2221);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2222);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2223)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2224)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2225);System.out.println ("The Collection found by this query was:             " + ((((collection == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2226)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2227)==0&false))? "Nothing Found" : collection.getCollectionID()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2228);return collection;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2229);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2230);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCollection(com.ac.games.data.Collection)
   */
  public void insertCollection(Collection collection) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2231);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2232);if ((((collection == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2233)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2234)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2235);throw new DatabaseOperationException("The provided collection object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2236);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2237)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2238)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2239);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2240);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2241);ObjectId prevDocID = queryForExistingCollectionDocID(collection.getCollectionID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2242);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2243)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2244)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2245);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2246)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2247)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2248);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2249);updateCollection(collection);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2250);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2251);DBCollection collectionCollection = mongoDB.getCollection("collection");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2252);BasicDBObject addObject = CollectionConverter.convertCollectionToMongo(collection);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2253);WriteResult result = collectionCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2254);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2255)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2256)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2257);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2258);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2259);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2260);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2261);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCollection(com.ac.games.data.Collection)
   */
  public void updateCollection(Collection collection) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2262);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2263);if ((((collection == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2264)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2265)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2266);throw new DatabaseOperationException("The provided collection object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2267);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2268)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2269)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2270);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2271);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2272);DBCollection collectionCollection = mongoDB.getCollection("collection");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2273);BasicDBObject queryObject  = CollectionConverter.convertCollectionToIDQuery(collection);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2274);BasicDBObject updateObject = CollectionConverter.convertCollectionToMongo(collection);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2275);WriteResult result = collectionCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2276);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2277)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2278)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2279);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2280);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2281);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2282);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCollection(long)
   */
  public void deleteCollection(long collectionID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2283);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2284);if ((((collectionID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2285)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2286)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2287);throw new DatabaseOperationException("The provided collection object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2288);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2289)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2290)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2291);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2292);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2293);DBCollection collectionCollection = mongoDB.getCollection("collection");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2294);BasicDBObject deleteObject  = CollectionConverter.convertCollectionToIDQuery(collectionID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2295);WriteResult result = collectionCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2296);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2297)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2298)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2299);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2300);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2301);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCollectionID()
   */
  public long getMaxCollectionID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2302);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2303);return getGenericMaxID("collection", "collectionID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCollectionDocID(long collectionID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2304);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2305);DBCollection collectionCollection = mongoDB.getCollection("collection");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2306);BasicDBObject searchObject  = CollectionConverter.convertCollectionToIDQuery(collectionID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2307);DBCursor cursor = collectionCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2308);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2309);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2310)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2311)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2312);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2313);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2314);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2315);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCollectionItem(long)
   */
  public CollectionItem readCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2316);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2317);if ((((itemID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2318)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2319)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2320);throw new DatabaseOperationException("The provided Collection Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2321);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2322)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2323)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2324);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2325);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2326);DBCollection itemCollection = mongoDB.getCollection("collectionitem");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2327);BasicDBObject searchObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2328);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2329);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2330)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2331)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2332);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2333);CollectionItem item = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2334);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2335)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2336)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2337);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2338);item = CollectionItemConverter.convertMongoToCollectionItem(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2339);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2340);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2341);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2342)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2343)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2344);System.out.println ("The game found by this query was:                   " + ((((item == null )&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2345)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2346)==0&false))? "Nothing Found" : item.getItemID()));
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2347);return item;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2348);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2349);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCollectionItem(com.ac.games.data.CollectionItem)
   */
  public void insertCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2350);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2351);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2352)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2353)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2354);throw new DatabaseOperationException("The provided collection item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2355);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2356)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2357)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2358);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2359);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2360);ObjectId prevDocID = queryForExistingCollectionItemDocID(item.getItemID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2361);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2362)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2363)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2364);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2365)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2366)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2367);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2368);updateCollectionItem(item);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2369);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2370);DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2371);BasicDBObject addObject = CollectionItemConverter.convertCollectionItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2372);WriteResult result = collectionCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2373);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2374)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2375)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2376);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2377);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2378);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2379);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2380);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCollectionItem(com.ac.games.data.CollectionItem)
   */
  public void updateCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2381);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2382);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2383)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2384)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2385);throw new DatabaseOperationException("The provided collection item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2386);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2387)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2388)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2389);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2390);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2391);DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2392);BasicDBObject queryObject  = CollectionItemConverter.convertCollectionItemToIDQuery(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2393);BasicDBObject updateObject = CollectionItemConverter.convertCollectionItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2394);WriteResult result = collectionCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2395);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2396)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2397)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2398);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2399);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2400);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2401);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCollectionItem(long)
   */
  public void deleteCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2402);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2403);if ((((itemID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2404)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2405)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2406);throw new DatabaseOperationException("The provided collection item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2407);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2408)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2409)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2410);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2411);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2412);DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2413);BasicDBObject deleteObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2414);WriteResult result = collectionCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2415);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2416)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2417)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2418);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2419);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2420);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCollectionItemID()
   */
  public long getMaxCollectionItemID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2421);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2422);return getGenericMaxID("collectionitem", "itemID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCollectionItemDocID(long itemID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2423);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2424);DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2425);BasicDBObject searchObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2426);DBCursor cursor = collectionCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2427);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2428);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2429)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2430)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2431);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2432);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2433);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2434);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemByMediaID(long)
   */
  public MediaItem readMediaItemByMediaID(long mediaID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2435);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2436);if ((((mediaID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2437)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2438)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2439);throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2440);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2441)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2442)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2443);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2444);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2445);DBCollection itemCollection = mongoDB.getCollection("media");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2446);BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2447);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2448);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2449)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2450)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2451);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2452);MediaItem item = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2453);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2454)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2455)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2456);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2457);item = MediaItemConverter.convertMongoToMediaItem(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2458);return item;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2459);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2460);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemsByUserID(long)
   */
  public List<MediaItem> readMediaItemsByUserID(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2461);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2462);if ((((userID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2463)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2464)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2465);throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2466);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2467)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2468)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2469);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2470);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2471);DBCollection itemCollection = mongoDB.getCollection("media");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2472);BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("userID", userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2473);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2474);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2475)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2476)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2477);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2478);List<MediaItem> items = new LinkedList<MediaItem>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(2479);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2480)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2481)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2482);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2483);items.add(MediaItemConverter.convertMongoToMediaItem(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2484);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2485);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2486);return items;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2487);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2488);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemsByGameID(long)
   */
  public List<MediaItem> readMediaItemsByGameID(long gameID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2489);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2490);if ((((gameID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2491)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2492)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2493);throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2494);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2495)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2496)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2497);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2498);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2499);DBCollection itemCollection = mongoDB.getCollection("media");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2500);BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("gameID", gameID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2501);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2502);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2503)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2504)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2505);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2506);List<MediaItem> items = new LinkedList<MediaItem>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(2507);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2508)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2509)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2510);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2511);items.add(MediaItemConverter.convertMongoToMediaItem(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2512);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2513);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2514);return items;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2515);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2516);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMediaItem(com.ac.games.data.MediaItem)
   */
  public void insertMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2517);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2518);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2519)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2520)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2521);throw new DatabaseOperationException("The provided media item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2522);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2523)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2524)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2525);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2526);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2527);ObjectId prevDocID = queryForExistingMediaItemDocID(item.getMediaID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2528);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2529)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2530)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2531);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2532)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2533)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2534);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2535);updateMediaItem(item);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2536);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2537);DBCollection itemCollection = mongoDB.getCollection("media");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2538);BasicDBObject addObject = MediaItemConverter.convertMediaItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2539);WriteResult result = itemCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2540);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2541)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2542)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2543);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2544);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2545);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2546);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2547);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateMediaItem(com.ac.games.data.MediaItem)
   */
  public void updateMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2548);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2549);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2550)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2551)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2552);throw new DatabaseOperationException("The provided media item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2553);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2554)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2555)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2556);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2557);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2558);DBCollection itemCollection = mongoDB.getCollection("media");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2559);BasicDBObject queryObject  = MediaItemConverter.convertMediaItemToIDQuery(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2560);BasicDBObject updateObject = MediaItemConverter.convertMediaItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2561);WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2562);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2563)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2564)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2565);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2566);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2567);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2568);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteMediaItem(long)
   */
  public void deleteMediaItem(long mediaID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2569);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2570);if ((((mediaID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2571)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2572)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2573);throw new DatabaseOperationException("The provided media item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2574);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2575)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2576)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2577);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2578);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2579);DBCollection itemCollection = mongoDB.getCollection("media");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2580);BasicDBObject deleteObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2581);WriteResult result = itemCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2582);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2583)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2584)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2585);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2586);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2587);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxMediaItemID()
   */
  public long getMaxMediaItemID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2588);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2589);return getGenericMaxID("media", "mediaID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param mediaID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingMediaItemDocID(long mediaID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2590);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2591);DBCollection itemCollection = mongoDB.getCollection("media");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2592);BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2593);DBCursor cursor = itemCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2594);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2595);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2596)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2597)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2598);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2599);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2600);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2601);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistItem(long)
   */
  public WishlistItem readWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2602);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2603);if ((((wishID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2604)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2605)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2606);throw new DatabaseOperationException("The provided Wishlist Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2607);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2608)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2609)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2610);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2611);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2612);DBCollection itemCollection = mongoDB.getCollection("wishlist");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2613);BasicDBObject searchObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2614);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2615);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2616)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2617)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2618);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2619);WishlistItem item = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2620);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2621)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2622)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2623);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2624);item = WishlistItemConverter.convertMongoToWishlistItem(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2625);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2626);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2627);return item;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2628);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2629);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertWishlistItem(com.ac.games.data.WishlistItem)
   */
  public void insertWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2630);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2631);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2632)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2633)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2634);throw new DatabaseOperationException("The provided wishlist item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2635);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2636)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2637)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2638);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2639);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2640);ObjectId prevDocID = queryForExistingWishlistItemDocID(item.getWishID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2641);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2642)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2643)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2644);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2645)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2646)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2647);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2648);updateWishlistItem(item);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2649);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2650);DBCollection itemCollection = mongoDB.getCollection("wishlist");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2651);BasicDBObject addObject = WishlistItemConverter.convertWishlistItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2652);WriteResult result = itemCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2653);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2654)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2655)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2656);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2657);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2658);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2659);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2660);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateWishlistItem(com.ac.games.data.WishlistItem)
   */
  public void updateWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2661);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2662);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2663)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2664)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2665);throw new DatabaseOperationException("The provided wishlist item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2666);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2667)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2668)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2669);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2670);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2671);DBCollection itemCollection = mongoDB.getCollection("wishlist");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2672);BasicDBObject queryObject  = WishlistItemConverter.convertWishlistItemToIDQuery(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2673);BasicDBObject updateObject = WishlistItemConverter.convertWishlistItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2674);WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2675);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2676)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2677)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2678);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2679);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2680);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2681);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteWishlistItem(long)
   */
  public void deleteWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2682);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2683);if ((((wishID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2684)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2685)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2686);throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2687);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2688)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2689)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2690);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2691);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2692);DBCollection itemCollection = mongoDB.getCollection("wishlist");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2693);BasicDBObject deleteObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2694);WriteResult result = itemCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2695);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2696)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2697)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2698);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2699);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2700);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxWishlistItemID()
   */
  public long getMaxWishlistItemID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2701);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2702);return getGenericMaxID("wishlist", "wishID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param wishID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingWishlistItemDocID(long wishID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2703);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2704);DBCollection itemCollection = mongoDB.getCollection("wishlist");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2705);BasicDBObject searchObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2706);DBCursor cursor = itemCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2707);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2708);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2709)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2710)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2711);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2712);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2713);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2714);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readPlaythruItem(long)
   */
  public PlaythruItem readPlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2715);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2716);if ((((playthruID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2717)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2718)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2719);throw new DatabaseOperationException("The provided Playthru Item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2720);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2721)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2722)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2723);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2724);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2725);DBCollection itemCollection = mongoDB.getCollection("playthru");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2726);BasicDBObject searchObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2727);DBCursor cursor = itemCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2728);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2729)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2730)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2731);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2732);PlaythruItem item = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2733);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2734)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2735)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2736);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2737);item = PlaythruItemConverter.convertMongoToPlaythruItem(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2738);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2739);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2740);return item;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2741);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2742);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertPlaythruItem(com.ac.games.data.PlaythruItem)
   */
  public void insertPlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2743);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2744);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2745)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2746)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2747);throw new DatabaseOperationException("The provided playthru item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2748);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2749)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2750)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2751);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2752);try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      __CLR3_3_0wdwdi96a4yrl.R.inc(2753);ObjectId prevDocID = queryForExistingPlaythruItemDocID(item.getPlaythruID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(2754);if ((((prevDocID != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2755)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2756)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2757);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2758)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2759)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(2760);System.out.println ("Converting insert into update because of prior document");
        }__CLR3_3_0wdwdi96a4yrl.R.inc(2761);updatePlaythruItem(item);
        __CLR3_3_0wdwdi96a4yrl.R.inc(2762);return;
      }
      
      //Open the collection, i.e. table
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2763);DBCollection itemCollection = mongoDB.getCollection("wishlist");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2764);BasicDBObject addObject = PlaythruItemConverter.convertPlaythruItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2765);WriteResult result = itemCollection.insert(addObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2766);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2767)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2768)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2769);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2770);System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2771);System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2772);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2773);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updatePlaythruItem(com.ac.games.data.PlaythruItem)
   */
  public void updatePlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2774);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2775);if ((((item == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2776)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2777)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2778);throw new DatabaseOperationException("The provided playthru item object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2779);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2780)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2781)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2782);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2783);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2784);DBCollection itemCollection = mongoDB.getCollection("playthru");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2785);BasicDBObject queryObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2786);BasicDBObject updateObject = PlaythruItemConverter.convertPlaythruItemToMongo(item);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2787);WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2788);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2789)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2790)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2791);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2792);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2793);throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2794);throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deletePlaythruItem(long)
   */
  public void deletePlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2795);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2796);if ((((playthruID < 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2797)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2798)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2799);throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2800);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2801)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2802)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2803);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2804);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2805);DBCollection itemCollection = mongoDB.getCollection("playthru");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2806);BasicDBObject deleteObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2807);WriteResult result = itemCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2808);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2809)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2810)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2811);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2812);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2813);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxPlaythruItemID()
   */
  public long getMaxPlaythruItemID() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2814);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2815);return getGenericMaxID("playthru", "playthruID");
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param playthruID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingPlaythruItemDocID(long playthruID) throws MongoException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2816);
    //Open the collection, i.e. table
    __CLR3_3_0wdwdi96a4yrl.R.inc(2817);DBCollection itemCollection = mongoDB.getCollection("wishlist");
    __CLR3_3_0wdwdi96a4yrl.R.inc(2818);BasicDBObject searchObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(2819);DBCursor cursor = itemCollection.find(searchObject);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2820);ObjectId docID = null;
    __CLR3_3_0wdwdi96a4yrl.R.inc(2821);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2822)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2823)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(2824);docID = (ObjectId)cursor.next().get("_id");
    }
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2825);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2826);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    __CLR3_3_0wdwdi96a4yrl.R.inc(2827);return docID;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteStatsRow(java.lang.String)
   */
  public void deleteStatsRow(String statType) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2828);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2829);if ((((statType == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2830)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2831)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2832);throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2833);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2834)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2835)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2836);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2837);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2838);DBCollection statsCollection = mongoDB.getCollection("stats");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2839);BasicDBObject deleteObject  = StatsConverter.convertStatsToTypeQuery(statType);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2840);WriteResult result = statsCollection.remove(deleteObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2841);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2842)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2843)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2844);System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2845);throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2846);throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameStats()
   */
  public BGGGameStats readBGGGameStats() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2847);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2848);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2849)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2850)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2851);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2852);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2853);DBCollection statsCollection = mongoDB.getCollection("stats");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2854);BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(BGGGameStats.BGG_GAME_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2855);DBCursor cursor = statsCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2856);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2857)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2858)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2859);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2860);BGGGameStats stats = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2861);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2862)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2863)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2864);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2865);stats = StatsConverter.convertMongoToBGGGameStats(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2866);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2867);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2868);return stats;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2869);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2870);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertBGGGameStats(com.ac.games.data.BGGGameStats)
   */
  public void insertBGGGameStats(BGGGameStats stats) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2871);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2872);if ((((stats == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2873)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2874)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2875);throw new DatabaseOperationException("The provided stats object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2876);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2877)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2878)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2879);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2880);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2881);DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      __CLR3_3_0wdwdi96a4yrl.R.inc(2882);BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(BGGGameStats.BGG_GAME_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2883);BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2884);WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2885);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2886)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2887)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2888);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2889);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2890);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2891);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataStats()
   */
  public CSIDataStats readCSIDataStats() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2892);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2893);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2894)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2895)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2896);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2897);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2898);DBCollection statsCollection = mongoDB.getCollection("stats");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2899);BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(CSIDataStats.CSI_DATA_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2900);DBCursor cursor = statsCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2901);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2902)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2903)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2904);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2905);CSIDataStats stats = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2906);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2907)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2908)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2909);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2910);stats = StatsConverter.convertMongoToCSIDataStats(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2911);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2912);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2913);return stats;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2914);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2915);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCSIDataStats(com.ac.games.data.CSIDataStats)
   */
  public void insertCSIDataStats(CSIDataStats stats) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2916);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2917);if ((((stats == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2918)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2919)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2920);throw new DatabaseOperationException("The provided stats object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2921);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2922)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2923)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2924);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2925);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2926);DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      __CLR3_3_0wdwdi96a4yrl.R.inc(2927);BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(CSIDataStats.CSI_DATA_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2928);BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2929);WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2930);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2931)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2932)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2933);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2934);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2935);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2936);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataStats()
   */
  public MMDataStats readMMDataStats() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2937);
    __CLR3_3_0wdwdi96a4yrl.R.inc(2938);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2939)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2940)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2941);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2942);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2943);DBCollection statsCollection = mongoDB.getCollection("stats");
      __CLR3_3_0wdwdi96a4yrl.R.inc(2944);BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(MMDataStats.MM_DATA_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2945);DBCursor cursor = statsCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2946);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2947)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2948)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(2949);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2950);MMDataStats stats = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(2951);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2952)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2953)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2954);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(2955);stats = StatsConverter.convertMongoToMMDataStats(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2956);try { __CLR3_3_0wdwdi96a4yrl.R.inc(2957);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(2958);return stats;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2959);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2960);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMMDataStats(com.ac.games.data.MMDataStats)
   */
  public void insertMMDataStats(MMDataStats stats) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2961);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2962);if ((((stats == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2963)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2964)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2965);throw new DatabaseOperationException("The provided stats object was null.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2966);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2967)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2968)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2969);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2970);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2971);DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      __CLR3_3_0wdwdi96a4yrl.R.inc(2972);BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(MMDataStats.MM_DATA_STATS);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2973);BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      __CLR3_3_0wdwdi96a4yrl.R.inc(2974);WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2975);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2976)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2977)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(2978);System.out.println ("The number of documents impacted by this operation: " + result.getN());
        __CLR3_3_0wdwdi96a4yrl.R.inc(2979);System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    }} catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2980);throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(2981);throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameByName(java.lang.String, boolean)
   */
  public List<BGGGame> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(2982);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(2983);if ((((gameName == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2984)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2985)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2986);throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2987);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2988)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2989)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(2990);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(2991);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(2992);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(2993);BasicDBObject regexObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(2994);if ((((addWildCard)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(2995)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(2996)==0&false)))   {__CLR3_3_0wdwdi96a4yrl.R.inc(2997);regexObject.append("$regex", "(?i)" + gameName.trim() + ".*");
      }else               {__CLR3_3_0wdwdi96a4yrl.R.inc(2998);regexObject.append("$regex", "(?i)" + gameName.trim());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(2999);BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3000);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3001);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3002);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3003);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3004);if (((((gameTypeFilter == null) || (gameTypeFilter == GameType.BASE_AND_COLLECTIBLE))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3005)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3006)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3007);BasicDBList filterList = new BasicDBList();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3008);filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.BASE));
        __CLR3_3_0wdwdi96a4yrl.R.inc(3009);filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.COLLECTIBLE));
        __CLR3_3_0wdwdi96a4yrl.R.inc(3010);searchObject.append("gameType", new BasicDBObject("$in", filterList));
      } }else {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3011);searchObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(gameTypeFilter));
      }
      
      //DEBUG
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3012);System.out.println ("The query I'm about to run is: db.bgggame.find(" + searchObject + ")");
      __CLR3_3_0wdwdi96a4yrl.R.inc(3013);debugMode = true;
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3014);DBCursor cursor = gameCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3015);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3016)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3017)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3018);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3019);List<BGGGame> games = new ArrayList<BGGGame>(cursor.size());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3020);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3021)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3022)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3023);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3024);games.add(BGGGameConverter.convertMongoToGame(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3025);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3026);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3027);debugMode = false;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3028);System.out.println ("games.size(): " + games.size());
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3029);return games;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3030);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3031);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameForReview(java.lang.String)
   */
  public BGGGame readBGGGameForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3032);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3033);if ((((reviewType == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3034)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3035)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3036);throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3037);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3038)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3039)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3040);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3041);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3042);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3043);BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3044);BasicDBObject sortObject = new BasicDBObject("gameType", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3045);if ((((reviewType.equalsIgnoreCase("new"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3046)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3047)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3048);sortObject.append("bggID", -1);
      }else                                    {__CLR3_3_0wdwdi96a4yrl.R.inc(3049);sortObject.append("bggID", 1);
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3050);DBCursor cursor = gameCollection.find(findObject).sort(sortObject).limit(1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3051);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3052)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3053)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3054);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3055);BGGGame game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3056);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3057)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3058)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3059);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3060);game = BGGGameConverter.convertMongoToGame(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3061);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3062);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3063);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3064);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3065);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataByTitle(java.lang.String, boolean)
   */
  public List<CoolStuffIncPriceData> readCSIDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3066);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3067);if ((((title == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3068)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3069)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3070);throw new DatabaseOperationException("The provided title object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3071);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3072)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3073)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3074);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3075);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3076);DBCollection csiCollection = mongoDB.getCollection("csidata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3077);BasicDBObject regexObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3078);if ((((addWildCard)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3079)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3080)==0&false)))   {__CLR3_3_0wdwdi96a4yrl.R.inc(3081);regexObject.append("$regex", "(?i)" + title.trim() + ".*");
      }else               {__CLR3_3_0wdwdi96a4yrl.R.inc(3082);regexObject.append("$regex", "(?i)" + title.trim());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3083);BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3084);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3085);ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3086);ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3087);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3088);DBCursor cursor = csiCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3089);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3090)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3091)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3092);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3093);List<CoolStuffIncPriceData> games = new ArrayList<CoolStuffIncPriceData>(cursor.size());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3094);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3095)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3096)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3097);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3098);games.add(CSIDataConverter.convertMongoToCSI(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3099);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3100);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3101);return games;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3102);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3103);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataForReview(java.lang.String)
   */
  public CoolStuffIncPriceData readCSIDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3104);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3105);if ((((reviewType == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3106)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3107)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3108);throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3109);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3110)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3111)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3112);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3113);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3114);DBCollection csiCollection = mongoDB.getCollection("csidata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3115);BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3116);BasicDBObject sortObject = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3117);if ((((reviewType.equalsIgnoreCase("new"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3118)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3119)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3120);sortObject = new BasicDBObject("csiID", -1);
      }else {__CLR3_3_0wdwdi96a4yrl.R.inc(3121);sortObject = new BasicDBObject("csiID", 1);
      
      //DEBUG
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3122);System.out.println ("The query that is being run is db.csidata.find(" + findObject + ".sort(" + sortObject + ").limit(1)");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3123);DBCursor cursor = csiCollection.find(findObject).sort(sortObject).limit(1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3124);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3125)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3126)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3127);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3128);CoolStuffIncPriceData game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3129);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3130)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3131)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3132);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3133);game = CSIDataConverter.convertMongoToCSI(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3134);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3135);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3136);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3137);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3138);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataByTitle(java.lang.String, boolean)
   */
  public List<MiniatureMarketPriceData> readMMDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3139);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3140);if ((((title == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3141)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3142)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3143);throw new DatabaseOperationException("The provided title object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3144);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3145)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3146)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3147);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3148);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3149);DBCollection mmCollection = mongoDB.getCollection("mmdata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3150);BasicDBObject regexObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3151);if ((((addWildCard)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3152)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3153)==0&false)))   {__CLR3_3_0wdwdi96a4yrl.R.inc(3154);regexObject.append("$regex", "(?i)" + title.trim() + ".*");
      }else               {__CLR3_3_0wdwdi96a4yrl.R.inc(3155);regexObject.append("$regex", "(?i)" + title.trim());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3156);BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3157);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3158);ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3159);ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3160);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3161);DBCursor cursor = mmCollection.find(searchObject);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3162);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3163)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3164)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3165);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3166);List<MiniatureMarketPriceData> games = new ArrayList<MiniatureMarketPriceData>(cursor.size());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3167);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3168)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3169)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3170);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3171);games.add(MMDataConverter.convertMongoToMM(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3172);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3173);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3174);return games;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3175);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3176);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataForReview(java.lang.String)
   */
  public MiniatureMarketPriceData readMMDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3177);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3178);if ((((reviewType == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3179)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3180)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3181);throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3182);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3183)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3184)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3185);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3186);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3187);DBCollection mmCollection = mongoDB.getCollection("mmdata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3188);BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3189);BasicDBObject sortObject = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3190);if ((((reviewType.equalsIgnoreCase("new"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3191)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3192)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3193);sortObject = new BasicDBObject("mmID", -1);
      }else {__CLR3_3_0wdwdi96a4yrl.R.inc(3194);sortObject = new BasicDBObject("mmID", 1);
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3195);DBCursor cursor = mmCollection.find(findObject).sort(sortObject).limit(1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3196);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3197)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3198)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3199);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3200);MiniatureMarketPriceData game = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3201);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3202)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3203)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3204);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3205);game = MMDataConverter.convertMongoToMM(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3206);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3207);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3208);return game;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3209);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3210);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<Game> readGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException,
      DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3211);
    // TODO Auto-generated method stub
    __CLR3_3_0wdwdi96a4yrl.R.inc(3212);return null;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGameFromAutoName(java.lang.String, java.lang.String, int)
   */
  public CompactSearchData readGameFromAutoName(String gameName, String primaryPublisher, int yearPublished)
      throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3213);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3214);if ((((gameName == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3215)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3216)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3217);throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3218);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3219)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3220)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3221);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3222);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3223);DBCollection gameCollection = mongoDB.getCollection("game");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3224);BasicDBObject queryObject = new BasicDBObject("name", gameName);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3225);if ((((primaryPublisher != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3226)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3227)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3228);queryObject.append("primaryPublisher", primaryPublisher);
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3229);if ((((yearPublished != -1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3230)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3231)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3232);queryObject.append("yearPublished", yearPublished);
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3233);BasicDBObject columnsObject = new BasicDBObject("gameID", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3234);columnsObject.append("name", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3235);columnsObject.append("yearPublished", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3236);columnsObject.append("imageThumbnailURL", 1);
      
      //DEBUG
      __CLR3_3_0wdwdi96a4yrl.R.inc(3237);System.out.println ("The query we are about to run is: db.game.find({" + queryObject + "}, {" + columnsObject + "})");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3238);DBCursor cursor = gameCollection.find(queryObject, columnsObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3239);CompactSearchData data = null;
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3240);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3241)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3242)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3243);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3244);data = GameConverter.convertMongoToCompact(object);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3245);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3246);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3247);return data;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3248);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3249);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<CompactSearchData> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter, int resultLimit)
      throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3250);
    //Check basic pre-conditions
    __CLR3_3_0wdwdi96a4yrl.R.inc(3251);if ((((gameName == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3252)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3253)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3254);throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3255);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3256)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3257)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3258);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3259);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3260);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3261);BasicDBObject regexObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3262);if ((((addWildCard)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3263)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3264)==0&false)))   {__CLR3_3_0wdwdi96a4yrl.R.inc(3265);regexObject.append("$regex", "(?i)" + gameName.trim() + ".*");
      }else               {__CLR3_3_0wdwdi96a4yrl.R.inc(3266);regexObject.append("$regex", "(?i)" + gameName.trim());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3267);BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3268);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3269);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3270);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3271);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3272);if (((((gameTypeFilter == null) || (gameTypeFilter == GameType.BASE_AND_COLLECTIBLE))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3273)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3274)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3275);BasicDBList filterList = new BasicDBList();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3276);filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.BASE));
        __CLR3_3_0wdwdi96a4yrl.R.inc(3277);filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.COLLECTIBLE));
        __CLR3_3_0wdwdi96a4yrl.R.inc(3278);searchObject.append("gameType", new BasicDBObject("$in", filterList));
      } }else {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3279);searchObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(gameTypeFilter));
      }
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3280);BasicDBObject columnsObject = new BasicDBObject("bggID", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3281);columnsObject.append("name", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3282);columnsObject.append("yearPublished", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3283);columnsObject.append("imageThumbnailURL", 1);
      
      //TODO - DEBUG
      __CLR3_3_0wdwdi96a4yrl.R.inc(3284);System.out.println ("The query I'm about to run is: db.bgggame.find({" + searchObject + "}, {" + columnsObject + "})");
      __CLR3_3_0wdwdi96a4yrl.R.inc(3285);debugMode = true;
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3286);DBCursor cursor = gameCollection.find(searchObject, columnsObject).limit(resultLimit);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3287);if ((((debugMode)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3288)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3289)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3290);System.out.println ("Total documents found during this query:            " + cursor.size());
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3291);List<CompactSearchData> games = new ArrayList<CompactSearchData>(cursor.size());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3292);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3293)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3294)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3295);DBObject object = cursor.next();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3296);games.add(BGGGameConverter.convertMongoToCompact(object));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3297);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3298);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      __CLR3_3_0wdwdi96a4yrl.R.inc(3299);debugMode = false;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3300);System.out.println ("games.size(): " + games.size());
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3301);return games;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3302);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3303);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<CompactSearchData> readCSIDataByTitle(String title, boolean addWildCard, int rowLimit)
      throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3304);
    // TODO Auto-generated method stub
    __CLR3_3_0wdwdi96a4yrl.R.inc(3305);return null;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<CompactSearchData> readMMDataByTitle(String title, boolean addWildCard, int rowLimit)
      throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3306);
    // TODO Auto-generated method stub
    __CLR3_3_0wdwdi96a4yrl.R.inc(3307);return null;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<String> readGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3308);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3309);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3310)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3311)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3312);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3313);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3314);DBCollection gameCollection = mongoDB.getCollection("game");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3315);BasicDBObject searchObject = new BasicDBObject("gameID", new BasicDBObject("$gt", 0));
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3316);BasicDBObject columnsObject = new BasicDBObject("name", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3317);columnsObject.append("primaryPublisher", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3318);columnsObject.append("yearPublished", 1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3319);DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3320);List<String> results = new LinkedList<String>();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3321);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3322)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3323)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3324);DBObject object = cursor.next();
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3325);String gameName   = (String)object.get("name");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3326);String primaryPub = (String)object.get("primaryPublisher");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3327);int yearPublished = -1;
        __CLR3_3_0wdwdi96a4yrl.R.inc(3328);if ((((object.containsField("yearPublished"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3329)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3330)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3331);yearPublished = (Integer)object.get("yearPublished");
        
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3332);boolean writePub  = !primaryPub.startsWith("(");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3333);boolean writeYear = (yearPublished > 1);
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3334);String searchResult = gameName;
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3335);if ((((writePub && writeYear)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3336)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3337)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3338);searchResult += " (" + primaryPub + " - " + yearPublished + ")";
        }else {__CLR3_3_0wdwdi96a4yrl.R.inc(3339);if ((((writePub && !writeYear)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3340)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3341)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3342);searchResult += " (" + primaryPub + ")";
        }else {__CLR3_3_0wdwdi96a4yrl.R.inc(3343);if ((((!writePub && writeYear)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3344)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3345)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3346);searchResult += " (" + writeYear + ")";
        
        }}}__CLR3_3_0wdwdi96a4yrl.R.inc(3347);results.add(searchResult);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3348);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3349);cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      __CLR3_3_0wdwdi96a4yrl.R.inc(3350);Collections.sort(results);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3351);return results;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3352);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3353);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<String> readBGGGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3354);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3355);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3356)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3357)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3358);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3359);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3360);DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3361);BasicDBObject searchObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3362);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3363);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3364);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3365);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      __CLR3_3_0wdwdi96a4yrl.R.inc(3366);BasicDBObject columnsObject = new BasicDBObject("name", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3367);columnsObject.append("bggID", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3368);columnsObject.append("yearPublished", 1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3369);DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3370);List<String> results = new LinkedList<String>();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3371);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3372)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3373)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3374);DBObject object = cursor.next();
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3375);String gameName   = (String)object.get("name");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3376);long bggID        = (Long)object.get("bggID");
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3377);int yearPublished = -1;
        __CLR3_3_0wdwdi96a4yrl.R.inc(3378);if ((((object.containsField("yearPublished"))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3379)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3380)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3381);yearPublished = (Integer)object.get("yearPublished");
        
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3382);boolean writeYear = (yearPublished > 1);
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3383);String searchResult = gameName;
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3384);if ((((writeYear)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3385)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3386)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3387);searchResult += " (" + bggID + " - " + yearPublished + ")";
        }else 
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3388);searchResult += " (" + bggID + ")";
        
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3389);results.add(searchResult);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3390);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3391);cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      __CLR3_3_0wdwdi96a4yrl.R.inc(3392);Collections.sort(results);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3393);return results;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3394);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3395);t.printStackTrace();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3396);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<String> readCSITitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3397);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3398);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3399)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3400)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3401);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3402);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3403);DBCollection gameCollection = mongoDB.getCollection("csidata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3404);BasicDBObject searchObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3405);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3406);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3407);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3408);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      __CLR3_3_0wdwdi96a4yrl.R.inc(3409);BasicDBObject columnsObject = new BasicDBObject("title", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3410);columnsObject.append("csiID", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3411);columnsObject.append("category", 1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3412);DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3413);List<String> results = new LinkedList<String>();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3414);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3415)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3416)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3417);DBObject object = cursor.next();
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3418);String gameName   = (String)object.get("title");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3419);long csiID        = (Long)object.get("csiID");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3420);int catValue      = (Integer)object.get("category");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3421);String category   = null;
        
        boolean __CLB3_3_0_bool0=false;__CLR3_3_0wdwdi96a4yrl.R.inc(3422);switch (catValue) {
        case CoolStuffIncCategoryConverter.COLLECTIBLE_FLAG :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3423);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3424);category = "Collectible"; __CLR3_3_0wdwdi96a4yrl.R.inc(3425);break;
        case CoolStuffIncCategoryConverter.DICEMASTERS_FLAG :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3426);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3427);category = "Dice Masters"; __CLR3_3_0wdwdi96a4yrl.R.inc(3428);break;
        case CoolStuffIncCategoryConverter.BOARDGAMES_FLAG  :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3429);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3430);category = "Board Game"; __CLR3_3_0wdwdi96a4yrl.R.inc(3431);break;
        case CoolStuffIncCategoryConverter.RPGS_FLAG        :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3432);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3433);category = "RPG"; __CLR3_3_0wdwdi96a4yrl.R.inc(3434);break;
        case CoolStuffIncCategoryConverter.LCGS_FLAG        :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3435);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3436);category = "LCG"; __CLR3_3_0wdwdi96a4yrl.R.inc(3437);break;
        case CoolStuffIncCategoryConverter.SUPPLIES_FLAG    :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3438);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3439);category = "Supplies"; __CLR3_3_0wdwdi96a4yrl.R.inc(3440);break;
        case CoolStuffIncCategoryConverter.MINIATURES_FLAG  :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3441);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3442);category = "Miniature"; __CLR3_3_0wdwdi96a4yrl.R.inc(3443);break;
        case CoolStuffIncCategoryConverter.VIDEOGAMES_FLAG  :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3444);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3445);category = "Video Game"; __CLR3_3_0wdwdi96a4yrl.R.inc(3446);break;
        case CoolStuffIncCategoryConverter.UNKNOWN_FLAG     :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3447);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3448);category = "Unknown"; __CLR3_3_0wdwdi96a4yrl.R.inc(3449);break;
        default :if (!__CLB3_3_0_bool0) {__CLR3_3_0wdwdi96a4yrl.R.inc(3450);__CLB3_3_0_bool0=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3451);category = null;
        }
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3452);String searchResult = gameName + " (" + csiID + " - " + category + ")";
        __CLR3_3_0wdwdi96a4yrl.R.inc(3453);results.add(searchResult);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3454);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3455);cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      __CLR3_3_0wdwdi96a4yrl.R.inc(3456);Collections.sort(results);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3457);return results;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3458);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3459);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<String> readMMTitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3460);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3461);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3462)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3463)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3464);throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3465);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3466);DBCollection gameCollection = mongoDB.getCollection("mmdata");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3467);BasicDBObject searchObject = new BasicDBObject();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3468);BasicDBList ignoreRejectList = new BasicDBList();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3469);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3470);ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      __CLR3_3_0wdwdi96a4yrl.R.inc(3471);searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      __CLR3_3_0wdwdi96a4yrl.R.inc(3472);BasicDBObject columnsObject = new BasicDBObject("title", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3473);columnsObject.append("mmID", 1);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3474);columnsObject.append("category", 1);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3475);DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3476);List<String> results = new LinkedList<String>();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3477);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3478)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3479)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3480);DBObject object = cursor.next();
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3481);String gameName   = (String)object.get("title");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3482);long mmID         = (Long)object.get("mmID");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3483);int catValue      = (Integer)object.get("category");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3484);String category   = null;
        
        boolean __CLB3_3_0_bool1=false;__CLR3_3_0wdwdi96a4yrl.R.inc(3485);switch (catValue) {
        case MiniatureMarketCategoryConverter.BOARDGAMES_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3486);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3487);category = "Board Game"; __CLR3_3_0wdwdi96a4yrl.R.inc(3488);break;
        case MiniatureMarketCategoryConverter.TABLETOP_FLAG     :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3489);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3490);category = "Table Top"; __CLR3_3_0wdwdi96a4yrl.R.inc(3491);break;
        case MiniatureMarketCategoryConverter.CCGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3492);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3493);category = "CCG"; __CLR3_3_0wdwdi96a4yrl.R.inc(3494);break;
        case MiniatureMarketCategoryConverter.LCGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3495);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3496);category = "LCG"; __CLR3_3_0wdwdi96a4yrl.R.inc(3497);break;
        case MiniatureMarketCategoryConverter.COLLECTIBLES_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3498);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3499);category = "Collectibles"; __CLR3_3_0wdwdi96a4yrl.R.inc(3500);break;
        case MiniatureMarketCategoryConverter.RPGS_FLAG         :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3501);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3502);category = "RPG"; __CLR3_3_0wdwdi96a4yrl.R.inc(3503);break;
        case MiniatureMarketCategoryConverter.ACCESSORIES_FLAG  :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3504);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3505);category = "Accessories"; __CLR3_3_0wdwdi96a4yrl.R.inc(3506);break;
        case MiniatureMarketCategoryConverter.UNKNOWN_FLAG      :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3507);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3508);category = "Unknown"; __CLR3_3_0wdwdi96a4yrl.R.inc(3509);break;
        default :if (!__CLB3_3_0_bool1) {__CLR3_3_0wdwdi96a4yrl.R.inc(3510);__CLB3_3_0_bool1=true;} __CLR3_3_0wdwdi96a4yrl.R.inc(3511);category = null;
        }
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3512);String searchResult = gameName + " (" + mmID + " - " + category + ")";
        __CLR3_3_0wdwdi96a4yrl.R.inc(3513);results.add(searchResult);
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3514);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3515);cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      __CLR3_3_0wdwdi96a4yrl.R.inc(3516);Collections.sort(results);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3517);return results;
      
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3518);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3519);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<CompactSearchData> readGamesCompact(String gameIDs) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3520);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3521);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3522)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3523)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3524);throw new ConfigurationException("There is a problem with the database connection.");
    
    //DEBUG
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3525);System.out.println ("The gameIDs list: " + gameIDs);
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(3526);List<Long> processIDs = new LinkedList<Long>();
    __CLR3_3_0wdwdi96a4yrl.R.inc(3527);if ((((gameIDs.indexOf(",") != -1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3528)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3529)==0&false))) {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(3530);String processString = new String(gameIDs);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3531);while (true) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3532);int commaPos = processString.indexOf(",");
        __CLR3_3_0wdwdi96a4yrl.R.inc(3533);if ((((commaPos == -1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3534)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3535)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3536);try {
            __CLR3_3_0wdwdi96a4yrl.R.inc(3537);processIDs.add(Long.parseLong(processString));
            __CLR3_3_0wdwdi96a4yrl.R.inc(3538);break;
          } catch (NumberFormatException nfe) {
            __CLR3_3_0wdwdi96a4yrl.R.inc(3539);throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
          }
        } }else {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3540);String singleTerm = processString.substring(0, commaPos);
          __CLR3_3_0wdwdi96a4yrl.R.inc(3541);processString = processString.substring(commaPos + 1);
          __CLR3_3_0wdwdi96a4yrl.R.inc(3542);try {
            __CLR3_3_0wdwdi96a4yrl.R.inc(3543);processIDs.add(Long.parseLong(singleTerm));
          } catch (NumberFormatException nfe) {
            __CLR3_3_0wdwdi96a4yrl.R.inc(3544);throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
          }
        }
      }}
    }} }else {{
      __CLR3_3_0wdwdi96a4yrl.R.inc(3545);try {
        __CLR3_3_0wdwdi96a4yrl.R.inc(3546);processIDs.add(Long.parseLong(gameIDs));
      } catch (NumberFormatException nfe) {
        __CLR3_3_0wdwdi96a4yrl.R.inc(3547);throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
      }
    }
    
    //DEBUG
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3548);System.out.println ("The number of IDs we want to process is: " + processIDs.size());
    
    __CLR3_3_0wdwdi96a4yrl.R.inc(3549);try {
      //Open the collection, i.e. table
      __CLR3_3_0wdwdi96a4yrl.R.inc(3550);DBCollection gameCollection = mongoDB.getCollection("game");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3551);List<CompactSearchData> results = new ArrayList<CompactSearchData>(processIDs.size());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3552);for (long curID : processIDs) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3553);BasicDBObject searchObject = new BasicDBObject("gameID", curID);
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3554);BasicDBObject columnsObject = new BasicDBObject("gameID", 1);
        __CLR3_3_0wdwdi96a4yrl.R.inc(3555);columnsObject.append("name", 1);
        __CLR3_3_0wdwdi96a4yrl.R.inc(3556);columnsObject.append("yearPublished", 1);
        __CLR3_3_0wdwdi96a4yrl.R.inc(3557);columnsObject.append("imageThumbnailURL", 1);
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3558);CompactSearchData data = null;
        __CLR3_3_0wdwdi96a4yrl.R.inc(3559);DBCursor cursor = gameCollection.find(searchObject, columnsObject);
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3560);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3561)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3562)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3563);DBObject object = cursor.next();
          __CLR3_3_0wdwdi96a4yrl.R.inc(3564);data = GameConverter.convertMongoToCompact(object);
        }
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3565);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3566);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
        
        __CLR3_3_0wdwdi96a4yrl.R.inc(3567);if ((((data != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3568)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3569)==0&false)))
          {__CLR3_3_0wdwdi96a4yrl.R.inc(3570);results.add(data);
      }}
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3571);return results;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3572);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3573);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public UserCollectionStats readCollectionStats(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3574);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3575);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3576)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3577)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3578);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3579);if ((((userID <= 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3580)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3581)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3582);throw new DatabaseOperationException("The provided userID was invalid");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3583);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3584);User user = readUser(userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3585);if ((((user == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3586)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3587)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3588);return new UserCollectionStats();
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3589);Collection collection = readCollection(user.getCollectionID());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3590);if ((((collection == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3591)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3592)==0&false)))
        {__CLR3_3_0wdwdi96a4yrl.R.inc(3593);return new UserCollectionStats();
      
      //We have a valid user and a valid collection.
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3594);UserCollectionStats stats = new UserCollectionStats();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3595);stats.setBaseOwned(collection.getBaseGameCount());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3596);stats.setExpOwned(collection.getExpansionGameCount());
      __CLR3_3_0wdwdi96a4yrl.R.inc(3597);stats.setColOwned(collection.getCollectibleGameCount());
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3598);List<CollectionItem> items = collection.getGames();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3599);List<SimpleSortable> mechList = new LinkedList<SimpleSortable>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3600);List<SimpleSortable> desList  = new LinkedList<SimpleSortable>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3601);List<SimpleSortable> pubList  = new LinkedList<SimpleSortable>();
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3602);for (CollectionItem item : items) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3603);Game game = item.getGame();
        
        //Start with mechanisms
        __CLR3_3_0wdwdi96a4yrl.R.inc(3604);List<String> mechanisms = game.getMechanisms();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3605);if ((((mechanisms != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3606)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3607)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3608);for (String mech : mechanisms) {{
            __CLR3_3_0wdwdi96a4yrl.R.inc(3609);boolean found = false;
            __CLR3_3_0wdwdi96a4yrl.R.inc(3610);for (SimpleSortable simple : mechList) {{
              __CLR3_3_0wdwdi96a4yrl.R.inc(3611);if ((((simple.getContent().equalsIgnoreCase(mech))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3612)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3613)==0&false))) {{
                __CLR3_3_0wdwdi96a4yrl.R.inc(3614);found = true;
                __CLR3_3_0wdwdi96a4yrl.R.inc(3615);simple.setHits(simple.getHits() + 1);
                __CLR3_3_0wdwdi96a4yrl.R.inc(3616);break;
              }
            }}
            }__CLR3_3_0wdwdi96a4yrl.R.inc(3617);if ((((!found)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3618)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3619)==0&false))) {{
              __CLR3_3_0wdwdi96a4yrl.R.inc(3620);SimpleSortable simple = new SimpleSortable(mech);
              __CLR3_3_0wdwdi96a4yrl.R.inc(3621);simple.setHits(simple.getHits() + 1);
              __CLR3_3_0wdwdi96a4yrl.R.inc(3622);mechList.add(simple);
            }
          }}
        }}
        
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3623);List<String> designers = game.getDesigners();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3624);if ((((designers != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3625)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3626)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3627);for (String des : designers) {{
            __CLR3_3_0wdwdi96a4yrl.R.inc(3628);boolean found = false;
            __CLR3_3_0wdwdi96a4yrl.R.inc(3629);for (SimpleSortable simple : desList) {{
              __CLR3_3_0wdwdi96a4yrl.R.inc(3630);if ((((simple.getContent().equalsIgnoreCase(des))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3631)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3632)==0&false))) {{
                __CLR3_3_0wdwdi96a4yrl.R.inc(3633);found = true;
                __CLR3_3_0wdwdi96a4yrl.R.inc(3634);simple.setHits(simple.getHits() + 1);
                __CLR3_3_0wdwdi96a4yrl.R.inc(3635);break;
              }
            }}
            }__CLR3_3_0wdwdi96a4yrl.R.inc(3636);if ((((!found)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3637)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3638)==0&false))) {{
              __CLR3_3_0wdwdi96a4yrl.R.inc(3639);SimpleSortable simple = new SimpleSortable(des);
              __CLR3_3_0wdwdi96a4yrl.R.inc(3640);simple.setHits(simple.getHits() + 1);
              __CLR3_3_0wdwdi96a4yrl.R.inc(3641);desList.add(simple);
            }
          }}
        }}
        
        //Note: we count only the primary publisher first
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3642);boolean found = false;
        __CLR3_3_0wdwdi96a4yrl.R.inc(3643);for (SimpleSortable simple : pubList) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3644);if ((((simple.getContent().equalsIgnoreCase(game.getPrimaryPublisher()))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3645)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3646)==0&false))) {{
            __CLR3_3_0wdwdi96a4yrl.R.inc(3647);found = true;
            __CLR3_3_0wdwdi96a4yrl.R.inc(3648);simple.setHits(simple.getHits() + 1);
            __CLR3_3_0wdwdi96a4yrl.R.inc(3649);break;
          }
        }}
        }__CLR3_3_0wdwdi96a4yrl.R.inc(3650);if ((((!found)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3651)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3652)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3653);SimpleSortable simple = new SimpleSortable(game.getPrimaryPublisher());
          __CLR3_3_0wdwdi96a4yrl.R.inc(3654);simple.setHits(simple.getHits() + 1);
          __CLR3_3_0wdwdi96a4yrl.R.inc(3655);pubList.add(simple);
        }
      }}//end for all items
      
      //We want a second pass through the publishers to see if we can make this count smarter
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3656);for (CollectionItem item : items) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3657);Game game = item.getGame();
        
        //Note: we count the primary publisher twice to help weight those higher
        __CLR3_3_0wdwdi96a4yrl.R.inc(3658);List<String> publishers = game.getPublishers();
        __CLR3_3_0wdwdi96a4yrl.R.inc(3659);if ((((publishers != null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3660)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3661)==0&false))) {{
          __CLR3_3_0wdwdi96a4yrl.R.inc(3662);publishers.remove(game.getPrimaryPublisher());
          __CLR3_3_0wdwdi96a4yrl.R.inc(3663);for (String pub : publishers) {{
            //Unlike other models, we aren't adding new entries, only incrementing existing hits
            __CLR3_3_0wdwdi96a4yrl.R.inc(3664);for (SimpleSortable simple : pubList) {{
              __CLR3_3_0wdwdi96a4yrl.R.inc(3665);if ((((simple.getContent().equalsIgnoreCase(pub))&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3666)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3667)==0&false))) {{
                __CLR3_3_0wdwdi96a4yrl.R.inc(3668);simple.setHits(simple.getHits() + 1);
                __CLR3_3_0wdwdi96a4yrl.R.inc(3669);break;
              }
            }}
          }}
        }}
      }}
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3670);Collections.sort(mechList);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3671);Collections.sort(desList);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3672);Collections.sort(pubList);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3673);if ((((mechList.size() >= 3)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3674)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3675)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3676);stats.setMech3(mechList.get(2).getContent() + " (" + mechList.get(2).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3677);if ((((mechList.size() >= 2)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3678)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3679)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3680);stats.setMech2(mechList.get(1).getContent() + " (" + mechList.get(1).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3681);if ((((mechList.size() >= 1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3682)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3683)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3684);stats.setMech1(mechList.get(0).getContent() + " (" + mechList.get(0).getHits() + ")");
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3685);if ((((desList.size() >= 3)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3686)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3687)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3688);stats.setDes3(desList.get(2).getContent() + " (" + desList.get(2).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3689);if ((((desList.size() >= 2)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3690)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3691)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3692);stats.setDes2(desList.get(1).getContent() + " (" + desList.get(1).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3693);if ((((desList.size() >= 1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3694)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3695)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3696);stats.setDes1(desList.get(0).getContent() + " (" + desList.get(0).getHits() + ")");

      }__CLR3_3_0wdwdi96a4yrl.R.inc(3697);if ((((pubList.size() >= 3)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3698)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3699)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3700);stats.setPub3(pubList.get(2).getContent() + " (" + pubList.get(2).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3701);if ((((pubList.size() >= 2)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3702)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3703)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3704);stats.setPub2(pubList.get(1).getContent() + " (" + pubList.get(1).getHits() + ")");
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3705);if ((((pubList.size() >= 1)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3706)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3707)==0&false))) {__CLR3_3_0wdwdi96a4yrl.R.inc(3708);stats.setPub1(pubList.get(0).getContent() + " (" + pubList.get(0).getHits() + ")");
      
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3709);return stats;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3710);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3711);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  public List<CollectionItem> getNewestCollectionItems(long userID, int topX) throws ConfigurationException,
      DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3712);
    // TODO Auto-generated method stub
    __CLR3_3_0wdwdi96a4yrl.R.inc(3713);return null;
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistForUser(long)
   */
  public List<WishlistItem> readWishlistForUser(long userID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3714);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3715);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3716)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3717)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3718);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3719);if ((((userID <= 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3720)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3721)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3722);throw new DatabaseOperationException("The provided userID was invalid");
      
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3723);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3724);DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3725);BasicDBObject searchObject = new BasicDBObject("userID", userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3726);DBCursor cursor = wishCollection.find(searchObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3727);List<WishlistItem> wishlist = new LinkedList<WishlistItem>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3728);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3729)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3730)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3731);wishlist.add(WishlistItemConverter.convertMongoToWishlistItem(cursor.next()));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3732);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3733);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3734);return wishlist;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3735);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3736);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistByGame(long)
   */
  public List<WishlistItem> readWishlistByGame(long gameID) throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3737);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3738);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3739)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3740)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3741);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3742);if ((((gameID <= 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3743)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3744)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3745);throw new DatabaseOperationException("The provided gameID was invalid");
      
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3746);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3747);DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3748);BasicDBObject searchObject = new BasicDBObject("gameID", gameID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3749);DBCursor cursor = wishCollection.find(searchObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3750);List<WishlistItem> wishlist = new LinkedList<WishlistItem>();
      __CLR3_3_0wdwdi96a4yrl.R.inc(3751);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3752)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3753)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3754);wishlist.add(WishlistItemConverter.convertMongoToWishlistItem(cursor.next()));
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3755);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3756);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3757);return wishlist;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3758);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3759);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistItem(long, long)
   */
  public WishlistItem readWishlistItem(long userID, long gameID)  throws ConfigurationException, DatabaseOperationException {try{__CLR3_3_0wdwdi96a4yrl.R.inc(3760);
    __CLR3_3_0wdwdi96a4yrl.R.inc(3761);if ((((mongoClient == null || mongoDB == null)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3762)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3763)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3764);throw new ConfigurationException("There is a problem with the database connection.");
    
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3765);if ((((userID <= 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3766)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3767)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3768);throw new DatabaseOperationException("The provided userID was invalid");
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3769);if ((((gameID <= 0)&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3770)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3771)==0&false)))
      {__CLR3_3_0wdwdi96a4yrl.R.inc(3772);throw new DatabaseOperationException("The provided gameID was invalid");
      
    }__CLR3_3_0wdwdi96a4yrl.R.inc(3773);try {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3774);DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3775);BasicDBObject searchObject = new BasicDBObject("userID", userID);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3776);searchObject.append("gameID", gameID);
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3777);DBCursor cursor = wishCollection.find(searchObject);
      __CLR3_3_0wdwdi96a4yrl.R.inc(3778);WishlistItem wishlist = null;
      __CLR3_3_0wdwdi96a4yrl.R.inc(3779);while ((((cursor.hasNext())&&(__CLR3_3_0wdwdi96a4yrl.R.iget(3780)!=0|true))||(__CLR3_3_0wdwdi96a4yrl.R.iget(3781)==0&false))) {{
        __CLR3_3_0wdwdi96a4yrl.R.inc(3782);wishlist = WishlistItemConverter.convertMongoToWishlistItem(cursor.next());
      }
      }__CLR3_3_0wdwdi96a4yrl.R.inc(3783);try { __CLR3_3_0wdwdi96a4yrl.R.inc(3784);cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      __CLR3_3_0wdwdi96a4yrl.R.inc(3785);return wishlist;
    } catch (MongoException me) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3786);throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      __CLR3_3_0wdwdi96a4yrl.R.inc(3787);throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }finally{__CLR3_3_0wdwdi96a4yrl.R.flushNeeded();}}
}
