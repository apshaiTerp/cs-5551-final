package com.ac.games.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Game;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the core Game
 * information.
 * <p>
 * It should handle all request that come in under the /game entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/game")
public class GameController {
  
  /**
   * GET method designed to handle retrieving {@link Game} data from the database.<p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>gameid=&lt;gameID&gt;</code> - The gameID.  This is required.</li>
   * <li><code>batch=n</code> - This indicates whether to generate a batch on game requests including bggID and up
   * to 'n' additional sequential elements.  Default is 1.</li></ul>
   * 
   * @param gameID The gameID that we are using to base this request on.
   * @param batch The number of rows to retrieve in batch from the server.
   * 
   * @return A {@link Game} object or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getGame(@RequestParam(value="gameid") long gameID,
                        @RequestParam(value="batch", defaultValue="1") int batch) {
    
    GamesDatabase database = null; 
    
    if (batch == 1) {
      Game game = new Game();
      try {
        if (Application.database == null)
          Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
        database = Application.database;
        database.initializeDBConnection();
        
        game = database.readGame(gameID);
      } catch (DatabaseOperationException doe) {
        doe.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
        return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
      } finally {
        //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      }
      
      if (game == null)
        return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
      return game;
    } else {
      //I'm not really prepared to handle this option at this time.
      return new SimpleErrorData("Operation Error", "This operation is not yet supported");
    }
  }

  /**
   * PUT Method, which should update (or potentially upsert) the provided game object.
   * 
   * @param game
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putGame(@RequestParam(value="gameid") long gameID,
                        @RequestBody Game game) {
    if (gameID <= 0)
      return new SimpleErrorData("Game Data Error", "There was no valid Game data provided");
    if (game == null)
      return new SimpleErrorData("Game Data Error", "There was no valid Game data provided");
    if (game.getGameID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no Game ID");
    if (game.getGameID() != gameID)
      return new SimpleErrorData("Game Data Invalid", "The provided game content does not match the gameID parameter");
      
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.updateGame(game);
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Put Request Completed Successfully");
  }
  
  /**
   * POST Method, which should insert (or potentially upsert) the provided game object.
   * 
   * @param game
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postGame(@RequestBody Game game) {
    if (game == null)
      return new SimpleErrorData("Game Data Error", "There was no valid Game data provided");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();

      if (game.getGameID() == -1)
        game.setGameID(database.getMaxGameID() + 1);
      
      database.insertGame(game);
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Post Request Completed Successfully");
  }
  
  /**
   * DELETE Method, which should delete the provided game reference, if it exists
   * 
   * @param data
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
  public Object deleteGame(@RequestParam(value="gameid") long gameID) {
    if (gameID <= 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no Game ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.deleteGame(gameID);
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return new SimpleMessageData("Operation Successful", "The Delete Request Completed Successfully");
  }
}
