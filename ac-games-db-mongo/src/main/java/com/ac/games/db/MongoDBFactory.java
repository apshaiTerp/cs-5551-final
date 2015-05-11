package com.ac.games.db;

import com.ac.games.db.mongo.MongoGamesDatabase;

/**
 * @author ac010168
 *
 */
public class MongoDBFactory {

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
  public final static GamesDatabase createMongoGamesDatabase(String mongoHostAddress, int mongoPort, String databaseName) {
    if (database == null) 
      database = new MongoGamesDatabase(mongoHostAddress, mongoPort, databaseName);
    return database;
  }
  
  /**
   * This method is helpful when the database connection has already been opened.
   * 
   * @return the {@link GamesDatabase} reference, or null if it hasn't been created
   */
  public final static GamesDatabase getMongoGamesDatabase() {
    return database;
  }
}
