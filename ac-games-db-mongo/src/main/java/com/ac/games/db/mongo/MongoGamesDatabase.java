package com.ac.games.db.mongo;

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
public class MongoGamesDatabase implements GamesDatabase {
  
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
  public MongoGamesDatabase(String mongoHostAddress, int mongoPort, String databaseName) {
    this.mongoHostAddress = mongoHostAddress;
    this.mongoPort        = mongoPort;
    this.databaseName     = databaseName;
    
    setMongoClient(null);
    setMongoDB(null);
  }

  /**
   * @return the mongoHostAddress
   */
  public String getMongoHostAddress() {
    return mongoHostAddress;
  }

  /**
   * @return the mongoPort
   */
  public int getMongoPort() {
    return mongoPort;
  }

  /**
   * @return the databaseName
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * @return the mongoClient
   */
  public MongoClient getMongoClient() {
    return mongoClient;
  }

  /**
   * @param mongoClient the mongoClient to set
   */
  public void setMongoClient(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  /**
   * @return the mongoDB
   */
  public DB getMongoDB() {
    return mongoDB;
  }

  /**
   * @param mongoDB the mongoDB to set
   */
  public void setMongoDB(DB mongoDB) {
    this.mongoDB = mongoDB;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#initializeDBConnection()
   */
  public void initializeDBConnection() throws ConfigurationException {
    //Checking to see if connection is already open...
    if (mongoClient != null) {
      System.out.println ("The connection is already open, do not reset.");
      return;
    }
    
    //Initializing Database Connection Client
    try {
      mongoClient = new MongoClient(mongoHostAddress, mongoPort);
      mongoClient.setWriteConcern(WriteConcern.JOURNALED);
    } catch (Throwable t) {
      mongoClient = null;
      throw new ConfigurationException("Unable to connect to MongoDB at " + mongoHostAddress + ":" + mongoPort);      
    }

    try {
      mongoDB = mongoClient.getDB(databaseName);
    } catch (Throwable t) {
      try { mongoClient.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      mongoClient = null;
      mongoDB     = null;
      throw new ConfigurationException("Unable to connect to Mongo Database [" + databaseName + "]");
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#closeDBConnection()
   */
  public void closeDBConnection() throws ConfigurationException {
    //Close the current collection
    try {
      if (mongoClient != null)
        mongoClient.close();
    } catch (Throwable t) {
      t.printStackTrace();
    }
    
    mongoClient = null;
    mongoDB     = null;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameData(long)
   */
  public BGGGame readBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (bggID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      BasicDBObject searchObject  = BGGGameConverter.convertGameToIDQuery(bggID);
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      BGGGame game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = BGGGameConverter.convertMongoToGame(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (game == null ? "Nothing Found" : game.getName()));
      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertBGGGameData(com.ac.games.data.BGGGame)
   */
  public void insertBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (game == null)
      throw new DatabaseOperationException("The provided game object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingBGGDocID(game.getBggID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateBGGGameData(game);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      BasicDBObject addObject = BGGGameConverter.convertGameToMongo(game);
      WriteResult result = gameCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateBGGGameData(com.ac.games.data.BGGGame)
   */
  public void updateBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (game == null)
      throw new DatabaseOperationException("The provided game object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      BasicDBObject queryObject  = BGGGameConverter.convertGameToIDQuery(game);
      BasicDBObject updateObject = BGGGameConverter.convertGameToMongo(game);
      WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteBGGGameData(long)
   */
  public void deleteBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (bggID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      BasicDBObject deleteObject  = BGGGameConverter.convertGameToIDQuery(bggID);
      WriteResult result = gameCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }
  
  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingBGGDocID(long bggID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection gameCollection = mongoDB.getCollection("bgggame");
    BasicDBObject searchObject  = BGGGameConverter.convertGameToIDQuery(bggID);
    
    DBCursor cursor = gameCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIPriceData(long)
   */
  public CoolStuffIncPriceData readCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (csiID < 0)
      throw new DatabaseOperationException("The provided price data object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("csidata");
      BasicDBObject searchObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      CoolStuffIncPriceData data = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        data = CSIDataConverter.convertMongoToCSI(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (data == null ? "Nothing Found" : data.getTitle()));
      return data;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCSIPriceData(com.ac.games.data.CoolStuffIncPriceData)
   */
  public void insertCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (csiData == null)
      throw new DatabaseOperationException("The provided price data object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingCSIDocID(csiData.getCsiID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateCSIPriceData(csiData);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("csidata");
      
      BasicDBObject addObject = CSIDataConverter.convertCSIToMongo(csiData);
      WriteResult result = gameCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCSIPriceData(com.ac.games.data.CoolStuffIncPriceData)
   */
  public void updateCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (csiData == null)
      throw new DatabaseOperationException("The provided price data object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("csidata");
      BasicDBObject queryObject  = CSIDataConverter.convertCSIToIDQuery(csiData);
      BasicDBObject updateObject = CSIDataConverter.convertCSIToMongo(csiData);
      WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCSIPriceData(long)
   */
  public void deleteCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (csiID < 0)
      throw new DatabaseOperationException("The provided price data object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("csidata");
      BasicDBObject deleteObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
      WriteResult result = gameCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param csiID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCSIDocID(long csiID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection gameCollection = mongoDB.getCollection("csidata");
    BasicDBObject searchObject  = CSIDataConverter.convertCSIToIDQuery(csiID);
    
    DBCursor cursor = gameCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMPriceData(long)
   */
  public MiniatureMarketPriceData readMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mmID < 0)
      throw new DatabaseOperationException("The provided price data object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("mmdata");
      BasicDBObject searchObject  = MMDataConverter.convertMMToIDQuery(mmID);
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      MiniatureMarketPriceData data = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        data = MMDataConverter.convertMongoToMM(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      
      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (data == null ? "Nothing Found" : data.getTitle()));
      return data;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMMPriceData(com.ac.games.data.MiniatureMarketPriceData)
   */
  public void insertMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mmData == null)
      throw new DatabaseOperationException("The provided price data object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingMMDocID(mmData.getMmID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateMMPriceData(mmData);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("mmdata");
      
      BasicDBObject addObject = MMDataConverter.convertMMToMongo(mmData);
      WriteResult result = gameCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateMMPriceData(com.ac.games.data.MiniatureMarketPriceData)
   */
  public void updateMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mmData == null)
      throw new DatabaseOperationException("The provided price data object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("mmdata");
      BasicDBObject queryObject  = MMDataConverter.convertMMToIDQuery(mmData);
      BasicDBObject updateObject = MMDataConverter.convertMMToMongo(mmData);
      WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteMMPriceData(long)
   */
  public void deleteMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mmID < 0)
      throw new DatabaseOperationException("The provided price data object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("mmdata");
      BasicDBObject deleteObject  = MMDataConverter.convertMMToIDQuery(mmID);
      WriteResult result = gameCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param mmID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingMMDocID(long mmID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection gameCollection = mongoDB.getCollection("mmdata");
    BasicDBObject searchObject  = MMDataConverter.convertMMToIDQuery(mmID);
    
    DBCursor cursor = gameCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getBggIDList()
   */
  public List<Long> getBggIDList() throws ConfigurationException, DatabaseOperationException {
    return getGenericIDList("bgggame", "bggID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getCSIIDList()
   */
  public List<Long> getCSIIDList() throws ConfigurationException, DatabaseOperationException {
    return getGenericIDList("csidata", "csiID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMMIDList()
   */
  public List<Long> getMMIDList() throws ConfigurationException, DatabaseOperationException {
    return getGenericIDList("mmdata", "mmID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGame(long)
   */
  public Game readGame(long gameID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      BasicDBObject searchObject  = GameConverter.convertGameToIDQuery(gameID);
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      Game game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = GameConverter.convertMongoToGame(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (game == null ? "Nothing Found" : game.getName()));
      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGame(long)
   */
  public Game readGameByBGGID(long bggID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (bggID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      BasicDBObject searchObject  = GameConverter.convertGameToBGGIDQuery(bggID);
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      Game game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = GameConverter.convertMongoToGame(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (game == null ? "Nothing Found" : game.getName()));
      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertGame(com.ac.games.data.Game)
   */
  public void insertGame(Game game) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (game == null)
      throw new DatabaseOperationException("The provided game object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingGameDocID(game.getGameID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateGame(game);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      
      BasicDBObject addObject = GameConverter.convertGameToMongo(game);
      WriteResult result = gameCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateGame(com.ac.games.data.Game)
   */
  public void updateGame(Game game) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (game == null)
      throw new DatabaseOperationException("The provided game object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      BasicDBObject queryObject  = GameConverter.convertGameToIDQuery(game);
      BasicDBObject updateObject = GameConverter.convertGameToMongo(game);
      WriteResult result = gameCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteGame(long)
   */
  public void deleteGame(long gameID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      BasicDBObject deleteObject  = GameConverter.convertGameToIDQuery(gameID);
      WriteResult result = gameCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getGameIDList()
   */
  public List<Long> getGameIDList() throws ConfigurationException, DatabaseOperationException {
    return getGenericIDList("game", "gameID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingGameDocID(long gameID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection gameCollection = mongoDB.getCollection("game");
    BasicDBObject searchObject  = GameConverter.convertGameToIDQuery(gameID);
    
    DBCursor cursor = gameCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGameReltn(long)
   */
  public GameReltn readGameReltn(long gameID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameID < 0)
      throw new DatabaseOperationException("The provided game relation data was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      BasicDBObject searchObject  = GameReltnConverter.convertGameReltnToGameIDQuery(gameID);
      
      DBCursor cursor = reltnCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      GameReltn gameReltn = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        gameReltn = GameReltnConverter.convertMongoToGameReltn(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (gameReltn == null ? "Nothing Found" : gameReltn.getReltnID()));
      return gameReltn;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertGameReltn(com.ac.games.data.GameReltn)
   */
  public void insertGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameReltn == null)
      throw new DatabaseOperationException("The provided game relation object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingGameReltnDocID(gameReltn.getReltnID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateGameReltn(gameReltn);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      
      BasicDBObject addObject = GameReltnConverter.convertGameReltnToMongo(gameReltn);
      WriteResult result = reltnCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateGameReltn(com.ac.games.data.GameReltn)
   */
  public void updateGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameReltn == null)
      throw new DatabaseOperationException("The provided game relation object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      BasicDBObject queryObject  = GameReltnConverter.convertGameReltnToIDQuery(gameReltn);
      BasicDBObject updateObject = GameReltnConverter.convertGameReltnToMongo(gameReltn);
      WriteResult result = reltnCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteGameReltn(long)
   */
  public void deleteGameReltn(long reltnID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (reltnID < 0)
      throw new DatabaseOperationException("The provided game object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
      BasicDBObject deleteObject  = GameReltnConverter.convertGameReltnToReltnIDQuery(reltnID);
      WriteResult result = reltnCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param bggID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingGameReltnDocID(long reltnID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
    BasicDBObject searchObject  = GameReltnConverter.convertGameReltnToReltnIDQuery(reltnID);
    
    DBCursor cursor = reltnCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getGameReltnIDList()
   */
  public List<Long> getGameReltnIDList() throws ConfigurationException, DatabaseOperationException {
    return getGenericIDList("gamereltn", "reltnID");
  }
  
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
  private List<Long> getGenericIDList(String collection, String fieldName) {
    List<Long> resultList = new LinkedList<Long>();
    try {
      DBCollection reltnCollection = mongoDB.getCollection(collection);
      //Limit the result set to reltnIDs
      BasicDBObject columns = new BasicDBObject();
      columns.put(fieldName, 1);
      columns.put("_id", 0);
      //Search for all documents, return only the bggID values
      DBCursor cursor = reltnCollection.find(new BasicDBObject(), columns); 
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        long curID = (Long)object.get(fieldName);
        if (!resultList.contains(curID))
          resultList.add(curID);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
    
    return resultList;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxBGGGameID()
   */
  public long getMaxBGGGameID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("bgggame", "bggID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCSIDataID()
   */
  public long getMaxCSIDataID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("csidata", "csiID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxMMDataID()
   */
  public long getMaxMMDataID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("mmdata", "mmID");
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxGameID()
   */
  public long getMaxGameID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("game", "gameID");
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxGameReltnID()
   */
  public long getMaxGameReltnID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("gamereltn", "reltnID");
  }
  
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
  private long getGenericMaxID(String collection, String fieldName) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    long result = 0;
    try {
      DBCollection curCollection = mongoDB.getCollection(collection);
      
      //This is the format we are trying to emulate:
      //db.bgggame.aggregate( { $group : { _id  : "", maxValue : { $max : "$bggID" } } } )

      DBObject maxObject         = new BasicDBObject("$max", "$" + fieldName);
      DBObject groupFieldsObject = new BasicDBObject("_id", "");
      groupFieldsObject.put("maxValue", maxObject);
      DBObject groupObject       = new BasicDBObject("$group", groupFieldsObject);
      
      List<DBObject> pipeline = new ArrayList<DBObject>(1);
      pipeline.add(groupObject);
      
      AggregationOutput output = curCollection.aggregate(pipeline);
      for (DBObject object : output.results()) {
        if (object.containsField("maxValue")) result = (Long)object.get("maxValue");
      }

      return result;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public int getBGGGameCount() throws ConfigurationException, DatabaseOperationException {
    return getGenericCount("bgggame");
  }

  public int getCSIDataCount() throws ConfigurationException, DatabaseOperationException {
    return getGenericCount("csidata");
  }

  public int getMMDataCount() throws ConfigurationException, DatabaseOperationException {
    return getGenericCount("mmdata");
  }

  public int getGameCount() throws ConfigurationException, DatabaseOperationException {
    return getGenericCount("game");
  }

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
  private int getGenericCount(String collection) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    int result = -1;
    try {
      DBCollection curCollection = mongoDB.getCollection(collection);
      
      //This is the format we are trying to emulate:
      //db.collection.aggregate( { $group : { _id  : "", count : { $sum : 1 } } } )

      DBObject maxObject         = new BasicDBObject("$sum", 1);
      DBObject groupFieldsObject = new BasicDBObject("_id", "");
      groupFieldsObject.put("count", maxObject);
      DBObject groupObject       = new BasicDBObject("$group", groupFieldsObject);
      
      List<DBObject> pipeline = new ArrayList<DBObject>(1);
      pipeline.add(groupObject);
      
      AggregationOutput output = curCollection.aggregate(pipeline);
      for (DBObject object : output.results()) {
        if (object.containsField("count")) result = (Integer)object.get("count");
      }
      return result;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUser(java.lang.String)
   */
  public User readUser(String userName) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userName == null)
      throw new DatabaseOperationException("The provided user name was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("user");
      BasicDBObject searchObject  = UserConverter.convertUserToNameQuery(userName);
      
      DBCursor cursor = userCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      User user = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        user = UserConverter.convertMongoToUser(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      if (debugMode)
        System.out.println ("The user found by this query was:                   " + (user == null ? "Nothing Found" : user.getUserName()));
      return user;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUser(java.lang.String)
   */
  public User readUser(long userID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userID < 0)
      throw new DatabaseOperationException("The provided user ID was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("user");
      BasicDBObject searchObject  = UserConverter.convertUserToIDQuery(userID);
      
      DBCursor cursor = userCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      User user = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        user = UserConverter.convertMongoToUser(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      if (debugMode)
        System.out.println ("The user found by this query was:                   " + (user == null ? "Nothing Found" : user.getUserName()));
      return user;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertUser(com.ac.games.data.User)
   */
  public void insertUser(User user) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (user == null)
      throw new DatabaseOperationException("The provided user object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingUserDocID(user.getUserID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateUser(user);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("user");
      
      BasicDBObject addObject = UserConverter.convertUserToMongo(user);
      WriteResult result = userCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateUser(com.ac.games.data.User)
   */
  public void updateUser(User user) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (user == null)
      throw new DatabaseOperationException("The provided user object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("user");
      BasicDBObject queryObject  = UserConverter.convertUserToIDQuery(user);
      BasicDBObject updateObject = UserConverter.convertUserToMongo(user);
      WriteResult result = userCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteUser(long)
   */
  public void deleteUser(long userID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userID < 0)
      throw new DatabaseOperationException("The provided user object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("user");
      BasicDBObject deleteObject  = UserConverter.convertUserToIDQuery(userID);
      WriteResult result = userCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxUserID()
   */
  public long getMaxUserID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("user", "userID");
  }
  
  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingUserDocID(long userID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection userCollection = mongoDB.getCollection("user");
    BasicDBObject searchObject  = UserConverter.convertUserToIDQuery(userID);
    
    DBCursor cursor = userCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readUserDetail(long)
   */
  public UserDetail readUserDetail(long userID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userID < 0)
      throw new DatabaseOperationException("The provided User Detail object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("userdetail");
      BasicDBObject searchObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
      
      DBCursor cursor = userCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      UserDetail user = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        user = UserDetailConverter.convertMongoToUserDetail(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The user found by this query was:                   " + (user == null ? "Nothing Found" : user.getUserID()));
      return user;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertUserDetail(com.ac.games.data.UserDetail)
   */
  public void insertUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userDetail == null)
      throw new DatabaseOperationException("The provided user detail object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingUserDetailDocID(userDetail.getUserID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateUserDetail(userDetail);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("userdetail");
      
      BasicDBObject addObject = UserDetailConverter.convertUserDetailToMongo(userDetail);
      WriteResult result = userCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateUserDetail(com.ac.games.data.UserDetail)
   */
  public void updateUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userDetail == null)
      throw new DatabaseOperationException("The provided game object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("userdetail");
      BasicDBObject queryObject  = UserDetailConverter.convertUserDetailToIDQuery(userDetail);
      BasicDBObject updateObject = UserDetailConverter.convertUserDetailToMongo(userDetail);
      WriteResult result = userCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteUserDetail(long)
   */
  public void deleteUserDetail(long userID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userID < 0)
      throw new DatabaseOperationException("The provided user object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection userCollection = mongoDB.getCollection("userdetail");
      BasicDBObject deleteObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
      WriteResult result = userCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingUserDetailDocID(long userID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection userCollection = mongoDB.getCollection("userdetail");
    BasicDBObject searchObject  = UserDetailConverter.convertUserDetailToIDQuery(userID);
    
    DBCursor cursor = userCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCollection(long)
   */
  public Collection readCollection(long collectionID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (collectionID < 0)
      throw new DatabaseOperationException("The provided collection ID was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collection");
      BasicDBObject searchObject        = CollectionConverter.convertCollectionToIDQuery(collectionID);
      
      DBCursor cursor = collectionCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      Collection collection = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        collection = CollectionConverter.convertMongoToCollection(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The Collection found by this query was:             " + (collection == null ? "Nothing Found" : collection.getCollectionID()));
      return collection;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCollection(com.ac.games.data.Collection)
   */
  public void insertCollection(Collection collection) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (collection == null)
      throw new DatabaseOperationException("The provided collection object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingCollectionDocID(collection.getCollectionID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateCollection(collection);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collection");
      
      BasicDBObject addObject = CollectionConverter.convertCollectionToMongo(collection);
      WriteResult result = collectionCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCollection(com.ac.games.data.Collection)
   */
  public void updateCollection(Collection collection) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (collection == null)
      throw new DatabaseOperationException("The provided collection object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collection");
      BasicDBObject queryObject  = CollectionConverter.convertCollectionToIDQuery(collection);
      BasicDBObject updateObject = CollectionConverter.convertCollectionToMongo(collection);
      WriteResult result = collectionCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCollection(long)
   */
  public void deleteCollection(long collectionID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (collectionID < 0)
      throw new DatabaseOperationException("The provided collection object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collection");
      BasicDBObject deleteObject  = CollectionConverter.convertCollectionToIDQuery(collectionID);
      WriteResult result = collectionCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCollectionID()
   */
  public long getMaxCollectionID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("collection", "collectionID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCollectionDocID(long collectionID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection collectionCollection = mongoDB.getCollection("collection");
    BasicDBObject searchObject  = CollectionConverter.convertCollectionToIDQuery(collectionID);
    
    DBCursor cursor = collectionCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCollectionItem(long)
   */
  public CollectionItem readCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (itemID < 0)
      throw new DatabaseOperationException("The provided Collection Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("collectionitem");
      BasicDBObject searchObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
      
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      CollectionItem item = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        item = CollectionItemConverter.convertMongoToCollectionItem(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      if (debugMode)
        System.out.println ("The game found by this query was:                   " + (item == null ? "Nothing Found" : item.getItemID()));
      return item;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCollectionItem(com.ac.games.data.CollectionItem)
   */
  public void insertCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided collection item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingCollectionItemDocID(item.getItemID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateCollectionItem(item);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      
      BasicDBObject addObject = CollectionItemConverter.convertCollectionItemToMongo(item);
      WriteResult result = collectionCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateCollectionItem(com.ac.games.data.CollectionItem)
   */
  public void updateCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided collection item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      BasicDBObject queryObject  = CollectionItemConverter.convertCollectionItemToIDQuery(item);
      BasicDBObject updateObject = CollectionItemConverter.convertCollectionItemToMongo(item);
      WriteResult result = collectionCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteCollectionItem(long)
   */
  public void deleteCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (itemID < 0)
      throw new DatabaseOperationException("The provided collection item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
      BasicDBObject deleteObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
      WriteResult result = collectionCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxCollectionItemID()
   */
  public long getMaxCollectionItemID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("collectionitem", "itemID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param userID The game we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingCollectionItemDocID(long itemID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection collectionCollection = mongoDB.getCollection("collectionitem");
    BasicDBObject searchObject  = CollectionItemConverter.convertCollectionItemToIDQuery(itemID);
    
    DBCursor cursor = collectionCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemByMediaID(long)
   */
  public MediaItem readMediaItemByMediaID(long mediaID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mediaID < 0)
      throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      MediaItem item = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        item = MediaItemConverter.convertMongoToMediaItem(object);
      }
      return item;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemsByUserID(long)
   */
  public List<MediaItem> readMediaItemsByUserID(long userID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (userID < 0)
      throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("userID", userID);
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<MediaItem> items = new LinkedList<MediaItem>();
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        items.add(MediaItemConverter.convertMongoToMediaItem(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return items;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMediaItemsByGameID(long)
   */
  public List<MediaItem> readMediaItemsByGameID(long gameID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameID < 0)
      throw new DatabaseOperationException("The provided Media Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("gameID", gameID);
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<MediaItem> items = new LinkedList<MediaItem>();
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        items.add(MediaItemConverter.convertMongoToMediaItem(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return items;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMediaItem(com.ac.games.data.MediaItem)
   */
  public void insertMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided media item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingMediaItemDocID(item.getMediaID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateMediaItem(item);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      
      BasicDBObject addObject = MediaItemConverter.convertMediaItemToMongo(item);
      WriteResult result = itemCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateMediaItem(com.ac.games.data.MediaItem)
   */
  public void updateMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided media item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      BasicDBObject queryObject  = MediaItemConverter.convertMediaItemToIDQuery(item);
      BasicDBObject updateObject = MediaItemConverter.convertMediaItemToMongo(item);
      WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteMediaItem(long)
   */
  public void deleteMediaItem(long mediaID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (mediaID < 0)
      throw new DatabaseOperationException("The provided media item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("media");
      BasicDBObject deleteObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
      WriteResult result = itemCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxMediaItemID()
   */
  public long getMaxMediaItemID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("media", "mediaID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param mediaID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingMediaItemDocID(long mediaID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection itemCollection = mongoDB.getCollection("media");
    BasicDBObject searchObject  = MediaItemConverter.convertMediaItemToGenericIDQuery("mediaID", mediaID);
    
    DBCursor cursor = itemCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistItem(long)
   */
  public WishlistItem readWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (wishID < 0)
      throw new DatabaseOperationException("The provided Wishlist Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("wishlist");
      BasicDBObject searchObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      WishlistItem item = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        item = WishlistItemConverter.convertMongoToWishlistItem(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return item;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertWishlistItem(com.ac.games.data.WishlistItem)
   */
  public void insertWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided wishlist item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingWishlistItemDocID(item.getWishID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updateWishlistItem(item);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("wishlist");
      
      BasicDBObject addObject = WishlistItemConverter.convertWishlistItemToMongo(item);
      WriteResult result = itemCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updateWishlistItem(com.ac.games.data.WishlistItem)
   */
  public void updateWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided wishlist item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("wishlist");
      BasicDBObject queryObject  = WishlistItemConverter.convertWishlistItemToIDQuery(item);
      BasicDBObject updateObject = WishlistItemConverter.convertWishlistItemToMongo(item);
      WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteWishlistItem(long)
   */
  public void deleteWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (wishID < 0)
      throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("wishlist");
      BasicDBObject deleteObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
      WriteResult result = itemCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxWishlistItemID()
   */
  public long getMaxWishlistItemID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("wishlist", "wishID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param wishID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingWishlistItemDocID(long wishID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection itemCollection = mongoDB.getCollection("wishlist");
    BasicDBObject searchObject  = WishlistItemConverter.convertWishlistItemToIDQuery(wishID);
    
    DBCursor cursor = itemCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readPlaythruItem(long)
   */
  public PlaythruItem readPlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (playthruID < 0)
      throw new DatabaseOperationException("The provided Playthru Item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("playthru");
      BasicDBObject searchObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
      DBCursor cursor = itemCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      PlaythruItem item = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        item = PlaythruItemConverter.convertMongoToPlaythruItem(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return item;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertPlaythruItem(com.ac.games.data.PlaythruItem)
   */
  public void insertPlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided playthru item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Because we are using non-Mongo based primary keys, we need to specifically check first to see if the object
      //exists, and if it does, we need to do an update instead
      ObjectId prevDocID = queryForExistingPlaythruItemDocID(item.getPlaythruID());
      if (prevDocID != null) {
        if (debugMode)
          System.out.println ("Converting insert into update because of prior document");
        updatePlaythruItem(item);
        return;
      }
      
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("wishlist");
      
      BasicDBObject addObject = PlaythruItemConverter.convertPlaythruItemToMongo(item);
      WriteResult result = itemCollection.insert(addObject);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this insert converted to an upsert?             " + result.isUpdateOfExisting());
        System.out.println ("The new document _id value added:                   " + addObject.get("_id"));
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#updatePlaythruItem(com.ac.games.data.PlaythruItem)
   */
  public void updatePlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (item == null)
      throw new DatabaseOperationException("The provided playthru item object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("playthru");
      BasicDBObject queryObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(item);
      BasicDBObject updateObject = PlaythruItemConverter.convertPlaythruItemToMongo(item);
      WriteResult result = itemCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this update: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the update", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deletePlaythruItem(long)
   */
  public void deletePlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (playthruID < 0)
      throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection itemCollection = mongoDB.getCollection("playthru");
      BasicDBObject deleteObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
      WriteResult result = itemCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#getMaxPlaythruItemID()
   */
  public long getMaxPlaythruItemID() throws ConfigurationException, DatabaseOperationException {
    return getGenericMaxID("playthru", "playthruID");
  }

  /**
   * We're going to use this method to avoid the work of running our queries.  Because of reliance
   * on this method in update and insert tasks, we can assume only one other version of this object
   * can exist in the database.
   * 
   * @param playthruID The item we want to verify if it exists or not.
   * 
   * @return The "_id" key from our existing object, or null if not found
   */
  private ObjectId queryForExistingPlaythruItemDocID(long playthruID) throws MongoException {
    //Open the collection, i.e. table
    DBCollection itemCollection = mongoDB.getCollection("wishlist");
    BasicDBObject searchObject  = PlaythruItemConverter.convertPlaythruItemToIDQuery(playthruID);
    
    DBCursor cursor = itemCollection.find(searchObject);
    ObjectId docID = null;
    while (cursor.hasNext()) {
      docID = (ObjectId)cursor.next().get("_id");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    return docID;
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#deleteStatsRow(java.lang.String)
   */
  public void deleteStatsRow(String statType) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (statType == null)
      throw new DatabaseOperationException("The provided wishlist item object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      BasicDBObject deleteObject  = StatsConverter.convertStatsToTypeQuery(statType);
      WriteResult result = statsCollection.remove(deleteObject);
      
      if (debugMode)
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this delete: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the delete", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameStats()
   */
  public BGGGameStats readBGGGameStats() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(BGGGameStats.BGG_GAME_STATS);
      DBCursor cursor = statsCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      BGGGameStats stats = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        stats = StatsConverter.convertMongoToBGGGameStats(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return stats;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertBGGGameStats(com.ac.games.data.BGGGameStats)
   */
  public void insertBGGGameStats(BGGGameStats stats) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (stats == null)
      throw new DatabaseOperationException("The provided stats object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(BGGGameStats.BGG_GAME_STATS);
      BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataStats()
   */
  public CSIDataStats readCSIDataStats() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(CSIDataStats.CSI_DATA_STATS);
      DBCursor cursor = statsCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      CSIDataStats stats = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        stats = StatsConverter.convertMongoToCSIDataStats(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return stats;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertCSIDataStats(com.ac.games.data.CSIDataStats)
   */
  public void insertCSIDataStats(CSIDataStats stats) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (stats == null)
      throw new DatabaseOperationException("The provided stats object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(CSIDataStats.CSI_DATA_STATS);
      BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataStats()
   */
  public MMDataStats readMMDataStats() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      BasicDBObject searchObject  = StatsConverter.convertStatsToTypeQuery(MMDataStats.MM_DATA_STATS);
      DBCursor cursor = statsCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      MMDataStats stats = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        stats = StatsConverter.convertMongoToMMDataStats(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return stats;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#insertMMDataStats(com.ac.games.data.MMDataStats)
   */
  public void insertMMDataStats(MMDataStats stats) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (stats == null)
      throw new DatabaseOperationException("The provided stats object was null.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection statsCollection = mongoDB.getCollection("stats");
      //Even though this is an insert method, we'll do the upsert to avoid having to implement an addition
      //'unsupported' update method.  The upsert ensures we have one and only one stat record per type
      BasicDBObject queryObject  = StatsConverter.convertStatsToTypeQuery(MMDataStats.MM_DATA_STATS);
      BasicDBObject updateObject = StatsConverter.convertStatsToMongo(stats);
      WriteResult result = statsCollection.update(queryObject, updateObject, true, false);
      
      if (debugMode) {
        System.out.println ("The number of documents impacted by this operation: " + result.getN());
        System.out.println ("Was this update converted to an insert?             " + !result.isUpdateOfExisting());
      }
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this insert: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the insert", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameByName(java.lang.String, boolean)
   */
  public List<BGGGame> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameName == null)
      throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      BasicDBObject regexObject = new BasicDBObject();
      if (addWildCard)   regexObject.append("$regex", "(?i)" + gameName.trim() + ".*");
      else               regexObject.append("$regex", "(?i)" + gameName.trim());
      
      BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      if ((gameTypeFilter == null) || (gameTypeFilter == GameType.BASE_AND_COLLECTIBLE)) {
        BasicDBList filterList = new BasicDBList();
        filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.BASE));
        filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.COLLECTIBLE));
        searchObject.append("gameType", new BasicDBObject("$in", filterList));
      } else {
        searchObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(gameTypeFilter));
      }
      
      //DEBUG
      System.out.println ("The query I'm about to run is: db.bgggame.find(" + searchObject + ")");
      debugMode = true;
      
      DBCursor cursor = gameCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<BGGGame> games = new ArrayList<BGGGame>(cursor.size());
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        games.add(BGGGameConverter.convertMongoToGame(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      debugMode = false;
      System.out.println ("games.size(): " + games.size());
      
      return games;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readBGGGameForReview(java.lang.String)
   */
  public BGGGame readBGGGameForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (reviewType == null)
      throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      BasicDBObject sortObject = new BasicDBObject("gameType", 1);
      if (reviewType.equalsIgnoreCase("new")) sortObject.append("bggID", -1);
      else                                    sortObject.append("bggID", 1);
      
      DBCursor cursor = gameCollection.find(findObject).sort(sortObject).limit(1);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      BGGGame game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = BGGGameConverter.convertMongoToGame(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataByTitle(java.lang.String, boolean)
   */
  public List<CoolStuffIncPriceData> readCSIDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (title == null)
      throw new DatabaseOperationException("The provided title object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection csiCollection = mongoDB.getCollection("csidata");
      
      BasicDBObject regexObject = new BasicDBObject();
      if (addWildCard)   regexObject.append("$regex", "(?i)" + title.trim() + ".*");
      else               regexObject.append("$regex", "(?i)" + title.trim());
      
      BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED));
      ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      DBCursor cursor = csiCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<CoolStuffIncPriceData> games = new ArrayList<CoolStuffIncPriceData>(cursor.size());
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        games.add(CSIDataConverter.convertMongoToCSI(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return games;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readCSIDataForReview(java.lang.String)
   */
  public CoolStuffIncPriceData readCSIDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (reviewType == null)
      throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection csiCollection = mongoDB.getCollection("csidata");
      
      BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      BasicDBObject sortObject = null;
      if (reviewType.equalsIgnoreCase("new"))
        sortObject = new BasicDBObject("csiID", -1);
      else sortObject = new BasicDBObject("csiID", 1);
      
      //DEBUG
      System.out.println ("The query that is being run is db.csidata.find(" + findObject + ".sort(" + sortObject + ").limit(1)");
      
      DBCursor cursor = csiCollection.find(findObject).sort(sortObject).limit(1);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      CoolStuffIncPriceData game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = CSIDataConverter.convertMongoToCSI(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataByTitle(java.lang.String, boolean)
   */
  public List<MiniatureMarketPriceData> readMMDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (title == null)
      throw new DatabaseOperationException("The provided title object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection mmCollection = mongoDB.getCollection("mmdata");
      
      BasicDBObject regexObject = new BasicDBObject();
      if (addWildCard)   regexObject.append("$regex", "(?i)" + title.trim() + ".*");
      else               regexObject.append("$regex", "(?i)" + title.trim());
      
      BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED));
      ignoreRejectList.add(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      DBCursor cursor = mmCollection.find(searchObject);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<MiniatureMarketPriceData> games = new ArrayList<MiniatureMarketPriceData>(cursor.size());
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        games.add(MMDataConverter.convertMongoToMM(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return games;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readMMDataForReview(java.lang.String)
   */
  public MiniatureMarketPriceData readMMDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (reviewType == null)
      throw new DatabaseOperationException("The provided reviewType object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection mmCollection = mongoDB.getCollection("mmdata");
      
      BasicDBObject findObject = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
      BasicDBObject sortObject = null;
      if (reviewType.equalsIgnoreCase("new"))
        sortObject = new BasicDBObject("mmID", -1);
      else sortObject = new BasicDBObject("mmID", 1);
      
      DBCursor cursor = mmCollection.find(findObject).sort(sortObject).limit(1);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      MiniatureMarketPriceData game = null;
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        game = MMDataConverter.convertMongoToMM(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      return game;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<Game> readGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException,
      DatabaseOperationException {
    // TODO Auto-generated method stub
    return null;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readGameFromAutoName(java.lang.String, java.lang.String, int)
   */
  public CompactSearchData readGameFromAutoName(String gameName, String primaryPublisher, int yearPublished)
      throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameName == null)
      throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      
      BasicDBObject queryObject = new BasicDBObject("name", gameName);
      if (primaryPublisher != null)
        queryObject.append("primaryPublisher", primaryPublisher);
      if (yearPublished != -1)
        queryObject.append("yearPublished", yearPublished);
      
      BasicDBObject columnsObject = new BasicDBObject("gameID", 1);
      columnsObject.append("name", 1);
      columnsObject.append("yearPublished", 1);
      columnsObject.append("imageThumbnailURL", 1);
      
      //DEBUG
      System.out.println ("The query we are about to run is: db.game.find({" + queryObject + "}, {" + columnsObject + "})");
      
      DBCursor cursor = gameCollection.find(queryObject, columnsObject);
      CompactSearchData data = null;
      
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        data = GameConverter.convertMongoToCompact(object);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      return data;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<CompactSearchData> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter, int resultLimit)
      throws ConfigurationException, DatabaseOperationException {
    //Check basic pre-conditions
    if (gameName == null)
      throw new DatabaseOperationException("The provided gameName object was not valid.");
    
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      BasicDBObject regexObject = new BasicDBObject();
      if (addWildCard)   regexObject.append("$regex", "(?i)" + gameName.trim() + ".*");
      else               regexObject.append("$regex", "(?i)" + gameName.trim());
      
      BasicDBObject searchObject  = new BasicDBObject("name", regexObject);
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));
      
      if ((gameTypeFilter == null) || (gameTypeFilter == GameType.BASE_AND_COLLECTIBLE)) {
        BasicDBList filterList = new BasicDBList();
        filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.BASE));
        filterList.add(GameTypeConverter.convertGameTypeToFlag(GameType.COLLECTIBLE));
        searchObject.append("gameType", new BasicDBObject("$in", filterList));
      } else {
        searchObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(gameTypeFilter));
      }
      
      BasicDBObject columnsObject = new BasicDBObject("bggID", 1);
      columnsObject.append("name", 1);
      columnsObject.append("yearPublished", 1);
      columnsObject.append("imageThumbnailURL", 1);
      
      //TODO - DEBUG
      System.out.println ("The query I'm about to run is: db.bgggame.find({" + searchObject + "}, {" + columnsObject + "})");
      debugMode = true;
      
      DBCursor cursor = gameCollection.find(searchObject, columnsObject).limit(resultLimit);
      
      if (debugMode)
        System.out.println ("Total documents found during this query:            " + cursor.size());
      
      List<CompactSearchData> games = new ArrayList<CompactSearchData>(cursor.size());
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        games.add(BGGGameConverter.convertMongoToCompact(object));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

      debugMode = false;
      System.out.println ("games.size(): " + games.size());
      
      return games;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<CompactSearchData> readCSIDataByTitle(String title, boolean addWildCard, int rowLimit)
      throws ConfigurationException, DatabaseOperationException {
    // TODO Auto-generated method stub
    return null;
  }

  public List<CompactSearchData> readMMDataByTitle(String title, boolean addWildCard, int rowLimit)
      throws ConfigurationException, DatabaseOperationException {
    // TODO Auto-generated method stub
    return null;
  }

  public List<String> readGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      
      BasicDBObject searchObject = new BasicDBObject("gameID", new BasicDBObject("$gt", 0));
      
      BasicDBObject columnsObject = new BasicDBObject("name", 1);
      columnsObject.append("primaryPublisher", 1);
      columnsObject.append("yearPublished", 1);
      
      DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      List<String> results = new LinkedList<String>();
      
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        
        String gameName   = (String)object.get("name");
        String primaryPub = (String)object.get("primaryPublisher");
        int yearPublished = -1;
        if (object.containsField("yearPublished"))
          yearPublished = (Integer)object.get("yearPublished");
        
        boolean writePub  = !primaryPub.startsWith("(");
        boolean writeYear = (yearPublished > 1);
        
        String searchResult = gameName;
        
        if (writePub && writeYear)
          searchResult += " (" + primaryPub + " - " + yearPublished + ")";
        else if (writePub && !writeYear)
          searchResult += " (" + primaryPub + ")";
        else if (!writePub && writeYear)
          searchResult += " (" + writeYear + ")";
        
        results.add(searchResult);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      Collections.sort(results);
      return results;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<String> readBGGGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("bgggame");
      
      BasicDBObject searchObject = new BasicDBObject();
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      BasicDBObject columnsObject = new BasicDBObject("name", 1);
      columnsObject.append("bggID", 1);
      columnsObject.append("yearPublished", 1);
      
      DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      List<String> results = new LinkedList<String>();
      
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        
        String gameName   = (String)object.get("name");
        long bggID        = (Long)object.get("bggID");
        
        int yearPublished = -1;
        if (object.containsField("yearPublished"))
          yearPublished = (Integer)object.get("yearPublished");
        
        boolean writeYear = (yearPublished > 1);
        
        String searchResult = gameName;
        
        if (writeYear)
          searchResult += " (" + bggID + " - " + yearPublished + ")";
        else 
          searchResult += " (" + bggID + ")";
        
        results.add(searchResult);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      Collections.sort(results);
      return results;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      t.printStackTrace();
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<String> readCSITitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("csidata");
      
      BasicDBObject searchObject = new BasicDBObject();
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      BasicDBObject columnsObject = new BasicDBObject("title", 1);
      columnsObject.append("csiID", 1);
      columnsObject.append("category", 1);
      
      DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      List<String> results = new LinkedList<String>();
      
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        
        String gameName   = (String)object.get("title");
        long csiID        = (Long)object.get("csiID");
        int catValue      = (Integer)object.get("category");
        String category   = null;
        
        switch (catValue) {
        case CoolStuffIncCategoryConverter.COLLECTIBLE_FLAG : category = "Collectible"; break;
        case CoolStuffIncCategoryConverter.DICEMASTERS_FLAG : category = "Dice Masters"; break;
        case CoolStuffIncCategoryConverter.BOARDGAMES_FLAG  : category = "Board Game"; break;
        case CoolStuffIncCategoryConverter.RPGS_FLAG        : category = "RPG"; break;
        case CoolStuffIncCategoryConverter.LCGS_FLAG        : category = "LCG"; break;
        case CoolStuffIncCategoryConverter.SUPPLIES_FLAG    : category = "Supplies"; break;
        case CoolStuffIncCategoryConverter.MINIATURES_FLAG  : category = "Miniature"; break;
        case CoolStuffIncCategoryConverter.VIDEOGAMES_FLAG  : category = "Video Game"; break;
        case CoolStuffIncCategoryConverter.UNKNOWN_FLAG     : category = "Unknown"; break;
        default : category = null;
        }
        
        String searchResult = gameName + " (" + csiID + " - " + category + ")";
        results.add(searchResult);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      Collections.sort(results);
      return results;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<String> readMMTitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //Run the operation
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("mmdata");
      
      BasicDBObject searchObject = new BasicDBObject();
      BasicDBList ignoreRejectList = new BasicDBList();
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED)));
      ignoreRejectList.add(new Integer(ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING)));
      searchObject.append("reviewState", new BasicDBObject("$in", ignoreRejectList));

      BasicDBObject columnsObject = new BasicDBObject("title", 1);
      columnsObject.append("mmID", 1);
      columnsObject.append("category", 1);
      
      DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      List<String> results = new LinkedList<String>();
      
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        
        String gameName   = (String)object.get("title");
        long mmID         = (Long)object.get("mmID");
        int catValue      = (Integer)object.get("category");
        String category   = null;
        
        switch (catValue) {
        case MiniatureMarketCategoryConverter.BOARDGAMES_FLAG   : category = "Board Game"; break;
        case MiniatureMarketCategoryConverter.TABLETOP_FLAG     : category = "Table Top"; break;
        case MiniatureMarketCategoryConverter.CCGS_FLAG         : category = "CCG"; break;
        case MiniatureMarketCategoryConverter.LCGS_FLAG         : category = "LCG"; break;
        case MiniatureMarketCategoryConverter.COLLECTIBLES_FLAG : category = "Collectibles"; break;
        case MiniatureMarketCategoryConverter.RPGS_FLAG         : category = "RPG"; break;
        case MiniatureMarketCategoryConverter.ACCESSORIES_FLAG  : category = "Accessories"; break;
        case MiniatureMarketCategoryConverter.UNKNOWN_FLAG      : category = "Unknown"; break;
        default : category = null;
        }
        
        String searchResult = gameName + " (" + mmID + " - " + category + ")";
        results.add(searchResult);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Me */ }
      Collections.sort(results);
      return results;
      
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<CompactSearchData> readGamesCompact(String gameIDs) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    //DEBUG
    System.out.println ("The gameIDs list: " + gameIDs);
    
    List<Long> processIDs = new LinkedList<Long>();
    if (gameIDs.indexOf(",") != -1) {
      String processString = new String(gameIDs);
      while (true) {
        int commaPos = processString.indexOf(",");
        if (commaPos == -1) {
          try {
            processIDs.add(Long.parseLong(processString));
            break;
          } catch (NumberFormatException nfe) {
            throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
          }
        } else {
          String singleTerm = processString.substring(0, commaPos);
          processString = processString.substring(commaPos + 1);
          try {
            processIDs.add(Long.parseLong(singleTerm));
          } catch (NumberFormatException nfe) {
            throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
          }
        }
      }
    } else {
      try {
        processIDs.add(Long.parseLong(gameIDs));
      } catch (NumberFormatException nfe) {
        throw new ConfigurationException("The gameIDs list provided is not in the correct format.");
      }
    }
    
    //DEBUG
    System.out.println ("The number of IDs we want to process is: " + processIDs.size());
    
    try {
      //Open the collection, i.e. table
      DBCollection gameCollection = mongoDB.getCollection("game");
      
      List<CompactSearchData> results = new ArrayList<CompactSearchData>(processIDs.size());
      for (long curID : processIDs) {
        BasicDBObject searchObject = new BasicDBObject("gameID", curID);
        
        BasicDBObject columnsObject = new BasicDBObject("gameID", 1);
        columnsObject.append("name", 1);
        columnsObject.append("yearPublished", 1);
        columnsObject.append("imageThumbnailURL", 1);
        
        CompactSearchData data = null;
        DBCursor cursor = gameCollection.find(searchObject, columnsObject);
        
        while (cursor.hasNext()) {
          DBObject object = cursor.next();
          data = GameConverter.convertMongoToCompact(object);
        }
        try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
        
        if (data != null)
          results.add(data);
      }
      
      return results;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public UserCollectionStats readCollectionStats(long userID) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    if (userID <= 0)
      throw new DatabaseOperationException("The provided userID was invalid");
    
    try {
      User user = readUser(userID);
      if (user == null)
        return new UserCollectionStats();
      
      Collection collection = readCollection(user.getCollectionID());
      if (collection == null)
        return new UserCollectionStats();
      
      //We have a valid user and a valid collection.
      UserCollectionStats stats = new UserCollectionStats();
      stats.setBaseOwned(collection.getBaseGameCount());
      stats.setExpOwned(collection.getExpansionGameCount());
      stats.setColOwned(collection.getCollectibleGameCount());
      
      List<CollectionItem> items = collection.getGames();
      
      List<SimpleSortable> mechList = new LinkedList<SimpleSortable>();
      List<SimpleSortable> desList  = new LinkedList<SimpleSortable>();
      List<SimpleSortable> pubList  = new LinkedList<SimpleSortable>();
      
      for (CollectionItem item : items) {
        Game game = item.getGame();
        
        //Start with mechanisms
        List<String> mechanisms = game.getMechanisms();
        if (mechanisms != null) {
          for (String mech : mechanisms) {
            boolean found = false;
            for (SimpleSortable simple : mechList) {
              if (simple.getContent().equalsIgnoreCase(mech)) {
                found = true;
                simple.setHits(simple.getHits() + 1);
                break;
              }
            }
            if (!found) {
              SimpleSortable simple = new SimpleSortable(mech);
              simple.setHits(simple.getHits() + 1);
              mechList.add(simple);
            }
          }
        }
        
        List<String> designers = game.getDesigners();
        if (designers != null) {
          for (String des : designers) {
            boolean found = false;
            for (SimpleSortable simple : desList) {
              if (simple.getContent().equalsIgnoreCase(des)) {
                found = true;
                simple.setHits(simple.getHits() + 1);
                break;
              }
            }
            if (!found) {
              SimpleSortable simple = new SimpleSortable(des);
              simple.setHits(simple.getHits() + 1);
              desList.add(simple);
            }
          }
        }
        
        //Note: we count only the primary publisher first
        boolean found = false;
        for (SimpleSortable simple : pubList) {
          if (simple.getContent().equalsIgnoreCase(game.getPrimaryPublisher())) {
            found = true;
            simple.setHits(simple.getHits() + 1);
            break;
          }
        }
        if (!found) {
          SimpleSortable simple = new SimpleSortable(game.getPrimaryPublisher());
          simple.setHits(simple.getHits() + 1);
          pubList.add(simple);
        }
      }//end for all items
      
      //We want a second pass through the publishers to see if we can make this count smarter
      for (CollectionItem item : items) {
        Game game = item.getGame();
        
        //Note: we count the primary publisher twice to help weight those higher
        List<String> publishers = game.getPublishers();
        if (publishers != null) {
          publishers.remove(game.getPrimaryPublisher());
          for (String pub : publishers) {
            //Unlike other models, we aren't adding new entries, only incrementing existing hits
            for (SimpleSortable simple : pubList) {
              if (simple.getContent().equalsIgnoreCase(pub)) {
                simple.setHits(simple.getHits() + 1);
                break;
              }
            }
          }
        }
      }
      
      Collections.sort(mechList);
      Collections.sort(desList);
      Collections.sort(pubList);
      
      if (mechList.size() >= 3) stats.setMech3(mechList.get(2).getContent() + " (" + mechList.get(2).getHits() + ")");
      if (mechList.size() >= 2) stats.setMech2(mechList.get(1).getContent() + " (" + mechList.get(1).getHits() + ")");
      if (mechList.size() >= 1) stats.setMech1(mechList.get(0).getContent() + " (" + mechList.get(0).getHits() + ")");
      
      if (desList.size() >= 3) stats.setDes3(desList.get(2).getContent() + " (" + desList.get(2).getHits() + ")");
      if (desList.size() >= 2) stats.setDes2(desList.get(1).getContent() + " (" + desList.get(1).getHits() + ")");
      if (desList.size() >= 1) stats.setDes1(desList.get(0).getContent() + " (" + desList.get(0).getHits() + ")");

      if (pubList.size() >= 3) stats.setPub3(pubList.get(2).getContent() + " (" + pubList.get(2).getHits() + ")");
      if (pubList.size() >= 2) stats.setPub2(pubList.get(1).getContent() + " (" + pubList.get(1).getHits() + ")");
      if (pubList.size() >= 1) stats.setPub1(pubList.get(0).getContent() + " (" + pubList.get(0).getHits() + ")");
      
      return stats;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  public List<CollectionItem> getNewestCollectionItems(long userID, int topX) throws ConfigurationException,
      DatabaseOperationException {
    // TODO Auto-generated method stub
    return null;
  }
  
  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistForUser(long)
   */
  public List<WishlistItem> readWishlistForUser(long userID) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    if (userID <= 0)
      throw new DatabaseOperationException("The provided userID was invalid");
      
    try {
      DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      BasicDBObject searchObject = new BasicDBObject("userID", userID);
      DBCursor cursor = wishCollection.find(searchObject);
      List<WishlistItem> wishlist = new LinkedList<WishlistItem>();
      while (cursor.hasNext()) {
        wishlist.add(WishlistItemConverter.convertMongoToWishlistItem(cursor.next()));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      return wishlist;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistByGame(long)
   */
  public List<WishlistItem> readWishlistByGame(long gameID) throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    if (gameID <= 0)
      throw new DatabaseOperationException("The provided gameID was invalid");
      
    try {
      DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      BasicDBObject searchObject = new BasicDBObject("gameID", gameID);
      DBCursor cursor = wishCollection.find(searchObject);
      List<WishlistItem> wishlist = new LinkedList<WishlistItem>();
      while (cursor.hasNext()) {
        wishlist.add(WishlistItemConverter.convertMongoToWishlistItem(cursor.next()));
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      return wishlist;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }

  /*
   * (non-Javadoc)
   * @see com.ac.games.db.GamesDatabase#readWishlistItem(long, long)
   */
  public WishlistItem readWishlistItem(long userID, long gameID)  throws ConfigurationException, DatabaseOperationException {
    if (mongoClient == null || mongoDB == null)
      throw new ConfigurationException("There is a problem with the database connection.");
    
    if (userID <= 0)
      throw new DatabaseOperationException("The provided userID was invalid");
    if (gameID <= 0)
      throw new DatabaseOperationException("The provided gameID was invalid");
      
    try {
      DBCollection wishCollection = mongoDB.getCollection("wishlist");
      
      BasicDBObject searchObject = new BasicDBObject("userID", userID);
      searchObject.append("gameID", gameID);
      
      DBCursor cursor = wishCollection.find(searchObject);
      WishlistItem wishlist = null;
      while (cursor.hasNext()) {
        wishlist = WishlistItemConverter.convertMongoToWishlistItem(cursor.next());
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      return wishlist;
    } catch (MongoException me) {
      throw new DatabaseOperationException("Mongo raised an exception to this select: " + me.getMessage(), me);
    } catch (Throwable t) {
      throw new DatabaseOperationException("Something bad happened executing the select", t);
    }
  }
}
