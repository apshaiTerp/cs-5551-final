package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.BGGGame;
import com.ac.games.data.GameType;
import com.ac.games.data.ReviewState;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;

/**
 * This class is the interceptor for REST service access to searching content via dynamic
 * queries
 * <p>
 * This should only support the GET option.  All other options should not be supported.
 * <p>
 * Look to the parameter lists for options.  There will be a lot.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/search")
public class SearchController {

  public Object searchData(@RequestParam(value="index", defaultValue="none") String index,
                           @RequestParam(value="gameid", defaultValue="-1") long gameID,
                           @RequestParam(value="name", defaultValue="none") String name,
                           @RequestParam(value="players", defaultValue="-1") int players,
                           @RequestParam(value="publisher", defaultValue="none") String publisher,
                           @RequestParam(value="ppublisher", defaultValue="none") String ppublisher,
                           @RequestParam(value="designer", defaultValue="none") String designer,
                           @RequestParam(value="category", defaultValue="none") String category,
                           @RequestParam(value="mechanism", defaultValue="none") String mechanism,
                           @RequestParam(value="parentid", defaultValue="-1") long parentID,
                           @RequestParam(value="gameType", defaultValue="none") String gameType,
                           @RequestParam(value="reviewstate", defaultValue="none") String reviewState,
                           @RequestParam(value="adddate", defaultValue="none") String addDate,
                           @RequestParam(value="limit", defaultValue="-1") int limit) {
    
    if ((index == null) || (index.equalsIgnoreCase("none")))
      return new SimpleErrorData("Invalid Parameters", "No Index Parameter was provided.");
    
    //TODO - Change handling of gameID to allow for comma-separated list of values.
    
    //Validate parameters in as much as we need to.  Number defaults should be fine.
    //Fix the basic strings
    if (name.equalsIgnoreCase("none"))       name = null;
    if (publisher.equalsIgnoreCase("none"))  publisher = null;
    if (ppublisher.equalsIgnoreCase("none")) ppublisher = null;
    if (designer.equalsIgnoreCase("none"))   designer = null;
    if (category.equalsIgnoreCase("none"))   category = null;
    if (mechanism.equalsIgnoreCase("none"))  mechanism = null;
    
    //Now fix the more complicated Enum values
    ReviewState trueReviewState = null;
    GameType trueGameType       = null;
    try {
      trueReviewState = mapReviewState(reviewState);
      trueGameType    = mapGameType(gameType);
    } catch (RuntimeException re) {
      return new SimpleErrorData("Invalid Parameters", re.getMessage());
    }
    
    //TODO - Develop a date format for parsing dates.  Might be better to go with hourly increments, like 12, 24, 48, etc
    Date trueAddDate = new Date();
    
    if (index.equalsIgnoreCase("bgg")) 
      return processBGGQuery(gameID, name, players, publisher, designer, category, mechanism, 
          parentID, trueGameType, trueReviewState, trueAddDate, limit);
    
    return new SimpleErrorData("Unsupported Index", "The Requested Index " + index + " has not yet been implemented.");
  }
  
  /**
   * All of these are optional fields that we can use to assemble a dynamic BGG Query.  We need at least one to work.
   * 
   * @param bggID
   * @param name
   * @param players
   * @param publisher
   * @param designer
   * @param category
   * @param mechanism
   * @param parentGameID
   * @param gameType
   * @param reviewState
   * @param addDate
   * @param limit
   * 
   * @return An Object, which could be a single {@link BGGGame}, a List of {@link BGGGame}s, a game not found message
   * or an error message, depending on what happens.
   */
  private Object processBGGQuery(long bggID, String name, int players, String publisher, String designer, String category, 
      String mechanism, long parentGameID, GameType gameType, ReviewState reviewState, Date addDate, int limit) {
    BGGGame gameQuery = new BGGGame();
    int setFields = 0;
    if (bggID != -1) {
      setFields++;
      gameQuery.setBggID(bggID);
    }
    if (name != null) {
      setFields++;
      gameQuery.setName(name);
    }
    if (players != -1) {
      setFields++;
      gameQuery.setMinPlayers(players);
      gameQuery.setMaxPlayers(players);
    }
    if (publisher != null) {
      setFields++;
      List<String> pubList = new ArrayList<String>(1);
      pubList.add(publisher);
      gameQuery.setPublishers(pubList);
    }
    if (designer != null) {
      setFields++;
      List<String> desList = new ArrayList<String>(1);
      desList.add(designer);
      gameQuery.setPublishers(desList);
    }
    if (category != null) {
      setFields++;
      List<String> catList = new ArrayList<String>(1);
      catList.add(category);
      gameQuery.setPublishers(catList);
    }
    if (mechanism != null) {
      setFields++;
      List<String> mechList = new ArrayList<String>(1);
      mechList.add(mechanism);
      gameQuery.setPublishers(mechList);
    }
    if (parentGameID != -1) {
      setFields++;
      gameQuery.setParentGameID(parentGameID);
    }
    if (gameType != null) {
      setFields++;
      gameQuery.setGameType(gameType);
    }
    if (reviewState != null) {
      setFields++;
      gameQuery.setReviewState(reviewState);
    }
    if (addDate != null) {
      setFields++;
      gameQuery.setAddDate(addDate);
    }
    //If no fields were actually added to this query, bail
    if (setFields == 0) {
      return new SimpleErrorData("Incomplete Query Specification", "There were not enough query terms provided to execute this query");
    }
    
    //Call some database method here that performs our ad-hoc query
    GamesDatabase database = null;
    List<BGGGame> games = null;
    
    try {
      database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database.initializeDBConnection();
      
      games = database.readBGGGameByName(name, true, null);
      if (games == null)
        return new SimpleErrorData("Game Not Found", "The requested item(s) could not be found in the database.");
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    if (games.size() == 1)
      return games.get(0);
    return games;
  }
  
  private ReviewState mapReviewState(String reviewState) throws RuntimeException {
    if (reviewState.equalsIgnoreCase("none"))     return null;
    if (reviewState.equalsIgnoreCase("pending"))  return ReviewState.PENDING;
    if (reviewState.equalsIgnoreCase("reviewed")) return ReviewState.REVIEWED;
    if (reviewState.equalsIgnoreCase("rejected")) return ReviewState.REJECTED;
    throw new RuntimeException("Invalid Review State: " + reviewState);
  }

  private GameType mapGameType(String gameType) throws RuntimeException {
    if (gameType.equalsIgnoreCase("none"))        return null;
    if (gameType.equalsIgnoreCase("base"))        return GameType.BASE;
    if (gameType.equalsIgnoreCase("expansion"))   return GameType.EXPANSION;
    if (gameType.equalsIgnoreCase("collectible")) return GameType.COLLECTIBLE;
    throw new RuntimeException("Invalid Game Type: " + gameType);
  }
}
