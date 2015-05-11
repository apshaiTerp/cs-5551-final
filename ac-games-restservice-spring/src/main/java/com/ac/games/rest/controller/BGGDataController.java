package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.ac.games.data.BGGGame;
import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameType;
import com.ac.games.data.ReviewState;
import com.ac.games.data.parser.BGGGameParser;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.exception.GameNotFoundException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * This class should be the intercepter for REST service access to the BoardGameGeek game
 * information.
 * <p>
 * It should handle all request that come in under the /external/bggdata entry.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 */
@RestController
@RequestMapping("/external/bggdata")
public class BGGDataController {

  /** The standard URI template by which games can be accessed by bggid */
  public final static String URL_TEMPLATE = "http://www.boardgamegeek.com/xmlapi/boardgame/<bggid>?stats=1";
  /** The replacement marker in the URL_TEMPLATE */
  public final static String BGGID_MARKER = "<bggid>";
  
  private static final int BGGID_EXEC_MODE      = 0;
  private static final int NAME_EXEC_MODE       = 1;
  private static final int REVIEW_NEW_EXEC_MODE = 2;
  private static final int REVIEW_OLD_EXEC_MODE = 3;
  
  /**
   * GET method designed to handle retrieving the BoardGameGeek content from the
   * BGG XML API and return the formatted {@link BGGGame} object.
   * <p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>bggid=&lt;gameid&gt;</code> - The gameID.</li>
   * <li><code>name=&lt;game name&gt;</code> - The name of the game we want to search for</li>
   * <li><code>review=<&lt;new|old|null&gt;/code> - The fetch order for unreviewed content</li>
   * <li><code>source=&lt;bgg|db|hybrid&gt;</code> - This indicated whether to request the game from BoardGameGeek (bgg)
   * or from our cached database (db).  Default is bgg.</li>
   * <li><code>batch=n</code> - This indicates whether to generate a batch on game requests including bggID and up
   * to 'n' additional sequential elements.  Default is 1.</li>
   * <li><code>sync=&lt;y|n&gt;</code> - Only useful on hybrid requests, once we build hybrid, automatically commit it back to database</li>
   * </ul>
   * 
   * @param bggID The bggID that we are using to base this request on.
   * @param name The game name that we want to search for wit this request
   * @param review Indicated the order in which we want to process pending results
   * @param source The source, either bgg or db we are requesting data from
   * @param batch The number of rows to retrieve in batch from the server
   * @param sync  A flag indicating whether we should automatically post an update if we determine that newly read content
   * has changed.  This simplifies front-end workflow.
   * 
   * @return A {@link BGGGame} object or {@link SimpleErrorData} message reporting the failure
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getBGGData(@RequestParam(value="bggid", defaultValue="-1") long bggID,
                           @RequestParam(value="name", defaultValue="null") String name,
                           @RequestParam(value="review", defaultValue="null") String review,
                           @RequestParam(value="source", defaultValue="bgg") String source,
                           @RequestParam(value="batch", defaultValue="1") int batch,
                           @RequestParam(value="sync", defaultValue="n") String sync,
                           @RequestParam(value="filter", defaultValue="null") String filter) {
    
    if ((!source.equalsIgnoreCase("bgg")) && (!source.equalsIgnoreCase("db")) && (!source.equalsIgnoreCase("hybrid")))
      return new SimpleErrorData("Invalid Parameters", "The source parameter value of " + source + " is not a valid source value.");
    if ((!sync.equalsIgnoreCase("n")) && (!sync.equalsIgnoreCase("y")))
      return new SimpleErrorData("Invalid Parameters", "The sync parameter value of " + sync + " is not a valid sync value");
    if ((!review.equalsIgnoreCase("new")) && (!review.equalsIgnoreCase("old")) && (!review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "The review parameter value of " + review + " is not a valid review value");
    
    //Now validate that one and only one of these values is being used
    if ((bggID == -1) && (name.equalsIgnoreCase("null")) && (review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "At least one of the search terms of bggid, name, or review must be used");
    if ((bggID != -1) && ((!name.equalsIgnoreCase("null")) || (!review.equalsIgnoreCase("null"))))
      return new SimpleErrorData("Invalid Parameters", "Only one value of bggID, name, and review can be used per query");
    if ((!name.equalsIgnoreCase("null")) && ((bggID != -1) || (!review.equalsIgnoreCase("null"))))
      return new SimpleErrorData("Invalid Parameters", "Only one value of bggID, name, and review can be used per query");
    if ((!review.equalsIgnoreCase("null")) && ((bggID != -1) || (!name.equalsIgnoreCase("null"))))
      return new SimpleErrorData("Invalid Parameters", "Only one value of bggID, name, and review can be used per query");
    
    if ((!filter.equalsIgnoreCase("null")) && (!filter.equalsIgnoreCase("base")) && 
        (!filter.equalsIgnoreCase("exp")) && (!filter.equalsIgnoreCase("ccg")) && (!filter.equalsIgnoreCase("baseccg")))
      return new SimpleErrorData("Invalid Parameters", "The filter parameter value of " + filter + " is not a valid filter");
    
    //now that we've validated we can only use one approach, we need to flag what that is.
    int execMode = -1;
    if (bggID != -1)                           execMode = BGGID_EXEC_MODE;
    else if (!name.equalsIgnoreCase("null"))   execMode = NAME_EXEC_MODE;
    else if (!review.equalsIgnoreCase("null")) {
      if (review.equalsIgnoreCase("new"))      execMode = REVIEW_NEW_EXEC_MODE;
      else                                     execMode = REVIEW_OLD_EXEC_MODE;
    }
    if (execMode == -1)
      return new SimpleErrorData("Invalid Parameters", "I have no idea what type of query you are asking me to perform.");
    
    if (source.equalsIgnoreCase("bgg") && (execMode == NAME_EXEC_MODE))
      return new SimpleErrorData("Invalid Parameters", "Source bgg cannot be used with name-based queries");
    else if (source.equalsIgnoreCase("bgg") && (execMode != BGGID_EXEC_MODE))
      return new SimpleErrorData("Invalid Parameters", "Source bgg cannot be used with review queries");
    
    List<BGGGame> bggSources = new LinkedList<BGGGame>();
    List<BGGGame> dbSources  = new LinkedList<BGGGame>();
    
    //TODO - DEBUG
    System.out.println ("bggID:    " + bggID);
    System.out.println ("name:     " + name);
    System.out.println ("review:   " + review);
    System.out.println ("source:   " + source);
    System.out.println ("batch:    " + batch);
    System.out.println ("sync:     " + sync);
    System.out.println ("filter:   " + filter);
    
    System.out.println ("execMode: " + execMode);
    
    if (source.equalsIgnoreCase("db") || source.equalsIgnoreCase("hybrid")) {
      GamesDatabase database = null; 
      BGGGame singleGame     = null;
      List<BGGGame> allGames = new LinkedList<BGGGame>();
      
      try {
        if (Application.database == null)
          Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
        database = Application.database;
        database.initializeDBConnection();
        
        if (execMode == BGGID_EXEC_MODE) {
          System.out.println ("I'm running in BGGID Exec Mode");
          if (batch == 1)
            singleGame = database.readBGGGameData(bggID);
          else {
            for (long i = bggID; i < (bggID + batch); i++) {
              singleGame = database.readBGGGameData(i);
              if (singleGame != null) 
                allGames.add(singleGame);
            }
          }
        } else if (execMode == NAME_EXEC_MODE) {
          System.out.println ("I'm running in Name Exec Mode");
          
          GameType filterType = null;
          if (filter.equalsIgnoreCase("base"))    filterType = GameType.BASE;
          if (filter.equalsIgnoreCase("exp"))     filterType = GameType.EXPANSION;
          if (filter.equalsIgnoreCase("ccg"))     filterType = GameType.COLLECTIBLE;
          if (filter.equalsIgnoreCase("baseccg")) filterType = GameType.BASE_AND_COLLECTIBLE;

          List<BGGGame> results = database.readBGGGameByName(name, true, filterType);
          System.out.println ("results.size(): " + results.size());
          
          allGames.addAll(results);
        } else if ((execMode == REVIEW_NEW_EXEC_MODE) || (execMode == REVIEW_OLD_EXEC_MODE)) {
          System.out.println ("I'm running in Review Exec Mode");

          singleGame = database.readBGGGameForReview(review);
        } 
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
      
      if (execMode == BGGID_EXEC_MODE) {
        if (batch == 1) {
          if (singleGame == null)
            return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
    
          if (source.equalsIgnoreCase("db"))
            return singleGame;
          else dbSources.add(singleGame);
        } else {
          if (allGames.size() == 0)
            return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
          
          if (source.equalsIgnoreCase("db"))
            return allGames;
          else dbSources = allGames;
        }
      } else if (execMode == NAME_EXEC_MODE) {
        //This will always be a list or nothing
        if (allGames.size() == 0)
          return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
        
        if (source.equalsIgnoreCase("db"))
          return allGames;
        else dbSources = allGames;
      } else if ((execMode == REVIEW_NEW_EXEC_MODE) || (execMode == REVIEW_OLD_EXEC_MODE)) {
        if (singleGame == null)
          return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");
  
        if (source.equalsIgnoreCase("db"))
          return singleGame;
        else dbSources.add(singleGame);
      }
    }
    if (source.equalsIgnoreCase("bgg") || source.equalsIgnoreCase("hybrid")) {
      String bggIDString = "";
      //Figure out what to put here in case we are in a non-BGGID exec mode to fill out
      //the bggID value or bggIDString value, in the case of name-based searches
      
      if (execMode == BGGID_EXEC_MODE) {
        //Build the ID string (or list of bggIDs) that need to be submitted to BGG.
        bggIDString = "" + bggID;
        for (int offset = 1; offset < batch; offset++)
          bggIDString += "," + (bggID + offset);
      } else if (execMode == NAME_EXEC_MODE) {
        //This relies on there having been entries found previously under the DB side of the name search
        if (dbSources.size() == 0)
          return new SimpleErrorData("Game Not Found", "No games found to search for in bgg");
        
        bggIDString = "" + dbSources.get(0).getBggID();
        for (int offset = 1; offset < dbSources.size(); offset++)
          bggIDString += "," + dbSources.get(offset).getBggID();
      } else if ((execMode == REVIEW_NEW_EXEC_MODE) || (execMode == REVIEW_NEW_EXEC_MODE)) {
        //This relies on there having been entries found previously under the DB side of the name search
        if (dbSources.size() == 0)
          return new SimpleErrorData("Game Not Found", "No games found to search for in bgg");

        bggIDString += "" + dbSources.get(0).getBggID();
      }
      
      Object gameResult = processHTMLRequest(bggIDString, batch);
      
      if (source.equalsIgnoreCase("bgg"))
        return gameResult;
      else {
        if (batch == 1) bggSources.add((BGGGame)gameResult);
        else            bggSources = (List<BGGGame>)gameResult;
      }
    } 
    
    //If we made it this far, we're in hybrid mode, so we need to do our comparisons.
    //We need to keep all the Review States, and other fields that we made decisions about
    //otherwise prioritize new fields from BGG
    //Note, we need to check for nulls on any field that may have nulls.
    List<BGGGame> finalList = new ArrayList<BGGGame>(dbSources.size());
    for (BGGGame dbSource : dbSources) {
      BGGGame bggSource = null;
      for (BGGGame searchSource : bggSources) {
        if (searchSource.getBggID() == dbSource.getBggID()) {
          bggSource = searchSource;
          break;
        }
      }
      //If we didn't find a matching BGG item (for whatever reason, BGG can be flaky sometimes)
      if (bggSource == null)
        finalList.add(bggSource);
      else {
        if (!dbSource.getName().equalsIgnoreCase(bggSource.getName()))     dbSource.setName(bggSource.getName());
        if (dbSource.getYearPublished() != bggSource.getYearPublished())   dbSource.setYearPublished(bggSource.getYearPublished());
        if (dbSource.getMinPlayers() != bggSource.getMinPlayers())         dbSource.setMinPlayers(bggSource.getMinPlayers());
        if (dbSource.getMaxPlayers() != bggSource.getMaxPlayers())         dbSource.setMaxPlayers(bggSource.getMaxPlayers());
        if (dbSource.getMinPlayingTime() != bggSource.getMinPlayingTime()) dbSource.setMinPlayingTime(bggSource.getMinPlayingTime());
        if (dbSource.getMaxPlayingTime() != bggSource.getMaxPlayingTime()) dbSource.setMaxPlayingTime(bggSource.getMaxPlayingTime());
        
        if (dbSource.getBggRating() != bggSource.getBggRating())           dbSource.setBggRating(bggSource.getBggRating());
        if (dbSource.getBggRatingUsers() != bggSource.getBggRatingUsers()) dbSource.setBggRatingUsers(bggSource.getBggRatingUsers());
        if (dbSource.getBggRank() != bggSource.getBggRank())               dbSource.setBggRank(bggSource.getBggRank());

        if (dbSource.getParentGameID() != bggSource.getParentGameID())     dbSource.setParentGameID(bggSource.getParentGameID());
        if (dbSource.getGameType() != bggSource.getGameType())             dbSource.setGameType(bggSource.getGameType());

        if (dbSource.getImageURL() == null) dbSource.setImageURL(bggSource.getImageURL());
        else if (bggSource.getImageURL() != null) {
          if (dbSource.getImageURL().equalsIgnoreCase(bggSource.getImageURL()))                 
            dbSource.setImageURL(bggSource.getImageURL());
        }
        if (dbSource.getImageThumbnailURL() == null) dbSource.setImageThumbnailURL(bggSource.getImageThumbnailURL());
        else if (bggSource.getImageThumbnailURL() != null) {
          if (dbSource.getImageThumbnailURL().equalsIgnoreCase(bggSource.getImageThumbnailURL()))                 
            dbSource.setImageThumbnailURL(bggSource.getImageThumbnailURL());
        }
        if (dbSource.getDescription() == null) dbSource.setDescription(bggSource.getDescription());
        else if (bggSource.getDescription() != null) {
          if (dbSource.getDescription().equalsIgnoreCase(bggSource.getDescription()))                 
            dbSource.setDescription(bggSource.getDescription());
        }

        if (dbSource.getPublishers() == null) dbSource.setPublishers(bggSource.getPublishers());
        else if (bggSource.getPublishers() != null) {
          if (dbSource.getPublishers().size() != bggSource.getPublishers().size())                 
            dbSource.setPublishers(bggSource.getPublishers());
        }
        if (dbSource.getDesigners() == null) dbSource.setDesigners(bggSource.getDesigners());
        else if (bggSource.getDesigners() != null) {
          if (dbSource.getDesigners().size() != bggSource.getDesigners().size())                 
            dbSource.setDesigners(bggSource.getDesigners());
        }
        if (dbSource.getCategories() == null) dbSource.setCategories(bggSource.getCategories());
        else if (bggSource.getCategories() != null) {
          if (dbSource.getCategories().size() != bggSource.getCategories().size())                 
            dbSource.setCategories(bggSource.getCategories());
        }
        if (dbSource.getMechanisms() == null) dbSource.setMechanisms(bggSource.getMechanisms());
        else if (bggSource.getMechanisms() != null) {
          if (dbSource.getMechanisms().size() != bggSource.getMechanisms().size())                 
            dbSource.setMechanisms(bggSource.getMechanisms());
        }
        if (dbSource.getExpansionIDs() == null) dbSource.setExpansionIDs(bggSource.getExpansionIDs());
        else if (bggSource.getExpansionIDs() != null) {
          if (dbSource.getExpansionIDs().size() != bggSource.getExpansionIDs().size())                 
            dbSource.setExpansionIDs(bggSource.getExpansionIDs());
        }
        
        finalList.add(dbSource);
      }
    }
    
    if (sync.equalsIgnoreCase("y")) {
      GamesDatabase database = null; 
      try {
        database = Application.database;
        database.initializeDBConnection();
        
        for (BGGGame curGame : finalList)
          database.updateBGGGameData(curGame);
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
    }
    
    if ((batch == 1) && (execMode != NAME_EXEC_MODE)) return finalList.get(0);
    else                                              return finalList;
  }  

  /**
   * PUT Method, which should update (or potentially upsert) the provided game object.
   * 
   * @param bggID The bggID that we are updating.  This element is required
   * @param review The reviewFlag, corresponding the the Review State value
   * @param primaryPub The primary publisher selected for this game.  Required to create a new Game entry
   * 
   * @param game The BGG Game content body we are updating.
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object putBGGData(@RequestParam(value="bggid") long bggID,
                           @RequestParam(value="review", defaultValue="null") String review,
                           @RequestParam(value="primarypub", defaultValue="null") String primaryPub,
                           @RequestBody BGGGame game) {
    if (bggID <= 0)
      return new SimpleErrorData("Game Data Error", "There was no valid BGGGame data provided");
    if (game == null)
      return new SimpleErrorData("Game Data Error", "There was no valid BGGGame data provided");
    if (game.getBggID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no Game ID");
    if (game.getBggID() != bggID)
      return new SimpleErrorData("Game Data Invalid", "The provided game content does not match the bggID parameter");
    
    if ((!review.equalsIgnoreCase("approve")) && (!review.equalsIgnoreCase("reject")) && 
        (!review.equalsIgnoreCase("reset")) && (!review.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "The review parameter value of " + review + " is not a valid review value");
    if ((!primaryPub.equalsIgnoreCase("null")) && (primaryPub.trim().length() == 0))
      return new SimpleErrorData("Invalid Parameters", "The review primary publsher value is invalid.");
    
    ReviewState newState = null;
    if (review.equalsIgnoreCase("approve")) newState = ReviewState.REVIEWED;
    if (review.equalsIgnoreCase("reject"))  newState = ReviewState.REJECTED;
    if (review.equalsIgnoreCase("reset"))   newState = ReviewState.PENDING;
    
    if ((newState == ReviewState.REVIEWED) && (primaryPub.equalsIgnoreCase("null")))
      return new SimpleErrorData("Invalid Parameters", "This game cannot be reviewed without a primary publisher");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      //No newState value means we're running a simple PUT, no other changes required.
      if (newState == null)
        database.updateBGGGameData(game);
      else {
        //We now need to find out if the state is changing.
        BGGGame prevGame = database.readBGGGameData(bggID);
        //If the state isn't changing, then nothing else needed but to run the update
        if (prevGame.getReviewState() == newState)
          database.updateBGGGameData(game);
        else {
          //The state of the game is changing, so we need to flex our actions based on what is was and what it will now be.
          if (newState == ReviewState.REVIEWED) {
            //Because we know the state is not the same, the previous state was either REJECTED or PENDING, meaning we need to
            //create the new Game entry, as well as the GameReltn entry
            
            //First we have to figure out if this game is an expansion, what the actual gameID value of the parent game is.
            long parentGameID = -1;
            Game parentGame   = null;
            if (game.getGameType() == GameType.EXPANSION) {
              parentGame = database.readGameByBGGID(game.getParentGameID());
              if (parentGame == null)
                return new SimpleErrorData("Parent Not Found", "The Parent Game for this Expansion could not be found");
              parentGameID = parentGame.getGameID();
            }
            
            game.setReviewState(newState);
            game.setReviewDate(new Date());
            database.updateBGGGameData(game);
            
            //Now we need to create the new Game and GameReltn entries
            long gameID      = database.getMaxGameID() + 1;
            Game newGame = convertBGGGameToGame(game, gameID, parentGameID, primaryPub);
            database.insertGame(newGame);
            
            long gameReltnID = database.getMaxGameReltnID() + 1;
            GameReltn newReltn = new GameReltn();
            newReltn.setReltnID(gameReltnID);
            newReltn.setGameID(gameID);
            newReltn.setBggID(game.getBggID());
            newReltn.setCsiIDs(new ArrayList<Long>());
            newReltn.setMmIDs(new ArrayList<Long>());
            newReltn.setAsinKeys(new ArrayList<String>());
            newReltn.setOtherSites(new ArrayList<Long>());
            database.insertGameReltn(newReltn);
            
            //If we have a parent ID that needs updating to include this child, update it now
            if (parentGame != null) {
              List<Long> expansionIDs = parentGame.getExpansionIDs();
              if (expansionIDs == null) expansionIDs = new ArrayList<Long>(1);
              expansionIDs.add(gameID);
              parentGame.setExpansionIDs(expansionIDs);
              database.updateGame(parentGame);
            }
            
          } else if ((newState == ReviewState.REJECTED) || (newState == ReviewState.PENDING)) {
            //This is only complicated if the game was previously approved
            if (prevGame.getReviewState() == ReviewState.REVIEWED) {
              //First, we need to find the actual Game entry for the game in the system
              Game convertedGame = database.readGameByBGGID(bggID);
              if (convertedGame != null)
                database.deleteGame(convertedGame.getGameID());
              
              //Next we have to figure out if this game is an expansion, what the actual gameID value of the parent game is.
              if ((game.getGameType() == GameType.EXPANSION) && (convertedGame != null)) {
                Game parentGame   = null;
                parentGame = database.readGameByBGGID(game.getParentGameID());
                if (parentGame != null) {
                  List<Long> expansionIDs = parentGame.getExpansionIDs();
                  if (expansionIDs != null) {
                    expansionIDs.remove(convertedGame.getGameID());
                    parentGame.setExpansionIDs(expansionIDs);
                    database.updateGame(parentGame);
                  }
                }
              }
              
              game.setReviewState(newState);
              game.setReviewDate(new Date());
              database.updateBGGGameData(game);
            } else {
              game.setReviewState(newState);
              game.setReviewDate(new Date());
              database.updateBGGGameData(game);
            }
          } 
        }
        
      }
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
  public Object postBGGData(@RequestBody BGGGame game) {
    if (game == null)
      return new SimpleErrorData("Game Data Error", "There was no valid BGGGame data provided");
    
    if (game.getBggID() < 0)
      return new SimpleErrorData("Game Data Invalid", "The provided game has no Game ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.insertBGGGameData(game);
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
  public Object deleteBGGData(@RequestParam(value="bggid") long bggID) {
    if (bggID <= 0)
      return new SimpleErrorData("Game Data Invalid", "The request has no Game ID");
    
    GamesDatabase database = null; 
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      database.deleteBGGGameData(bggID);
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
  
  /**
   * Helper method to break out the parsing of HTML requests to handle processing multiple requests.
   * 
   * @param bggIDs the bggID list we want to search for
   * 
   * return an Object, either a BGGGame object, or the various error message bodies.  Use instanceof to validate what values
   * were returned.
   */
  private Object processHTMLRequest(String bggIDs, int batch) {
    //Create the RestTemplate to access the external XML API
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.TEXT_XML));
    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    
    Object gameResult = null;
    try {
      System.out.println ("Beginning to parse BGG ID(s): " + bggIDs + "...");
      
      //Run the GET command to retrieve the XML Body
      ResponseEntity<String> gameResponse = restTemplate.exchange(URL_TEMPLATE.replace(BGGID_MARKER, bggIDs), 
          HttpMethod.GET, entity, String.class);

      String xmlText = gameResponse.getBody();
      if (batch > 1) gameResult = BGGGameParser.parseMultiBGGXML(xmlText);
      else           gameResult = BGGGameParser.parseBGGXML(xmlText);
      
      return gameResult;
    } catch (GameNotFoundException gnfe) {
      System.out.println ("I could not find this game.");
      return new SimpleErrorData("Game Not Found", "The requested bggid of " + bggIDs + " could not be found.");
    } catch (HttpServerErrorException hsee) {
      if (hsee.getMessage().contains("503 Service Unavailable")) {
        System.out.println ("The BGG server is icing me out again...");
        return new SimpleErrorData("Server Timeout 503", "The BGG server has stopped answering my requests");
      } else {
        System.out.println ("Something probably wrong happened here...");
        hsee.printStackTrace();
        return new SimpleErrorData("Operation Error", "An error has occurred: " + hsee.getMessage());
      }
    } catch (HttpClientErrorException hcee) {
      if (hcee.getMessage().contains("404 Not Found")) {
        System.out.println ("I could not find this game.");
        return new SimpleErrorData("Game Not Found", "The requested bggid of " + bggIDs + " could not be found.");
      } else {
        System.out.println ("Something probably wrong happened here...");
        hcee.printStackTrace();
        return new SimpleErrorData("Operation Error", "An error has occurred: " + hcee.getMessage());
      }
    } catch (Throwable t) {
      System.out.println ("Something terribly wrong happened here...");
      t.printStackTrace();
      return new SimpleErrorData("Operation Error", "An error has occurred: " + t.getMessage());
    }
  }
  
  /**
   * Helper method to convert a BGGGame object into a Game Object
   * 
   * @param bggGame The game we want to convert
   * @param gameID  The new gameID sequence chosen for the game
   * @param parentGameID The parentGameID (only required for expansion games)
   * @param primaryPublisher The primary publisher chosen for this game
   * 
   * @return A completed Game object
   */
  private Game convertBGGGameToGame(BGGGame bggGame, long gameID, long parentGameID, String primaryPublisher) {
    Game game = new Game();
    game.setGameID(gameID);
    game.setBggID(bggGame.getBggID());
    game.setName(bggGame.getName());
    game.setYearPublished(bggGame.getYearPublished());
    game.setMinPlayers(bggGame.getMinPlayers());
    game.setMaxPlayers(bggGame.getMaxPlayers());
    game.setMinPlayingTime(bggGame.getMinPlayingTime());
    game.setMaxPlayingTime(bggGame.getMaxPlayingTime());
    game.setImageURL(bggGame.getImageURL());
    game.setImageThumbnailURL(bggGame.getImageThumbnailURL());
    game.setDescription(bggGame.getDescription());
    game.setPrimaryPublisher(primaryPublisher);
    game.setPublishers(bggGame.getPublishers());
    game.setDesigners(bggGame.getDesigners());
    game.setCategories(bggGame.getCategories());
    game.setMechanisms(bggGame.getMechanisms());
    game.setGameType(bggGame.getGameType());
    game.setAddDate(new Date());
    
    //If it's a parent game, Let's set an empty list so we can make it easier to update later
    if ((game.getGameType() == GameType.BASE) || (game.getGameType() == GameType.COLLECTIBLE))
      game.setExpansionIDs(new LinkedList<Long>());
    else
      game.setParentGameID(parentGameID);
    
    return game;
  }
}
