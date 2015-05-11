package com.ac.games.rest.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.GameType;
import com.ac.games.data.GameWeight;
import com.ac.games.data.User;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.RecommendValues;
import com.ac.games.rest.data.WrapList;
import com.ac.games.rest.message.SimpleErrorData;
import com.ac.games.rest.message.SimpleMessageData;

/**
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {

  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getRecommend(@RequestParam(value="userid") long userID,
                             @RequestParam(value="mode") String mode,
                             @RequestParam(value="recnum", defaultValue="-1") int recommendNumber) {
    if (userID < 0)
      return new SimpleErrorData("Recommend Data Error", "The provided userID was not valid");
    if ((!mode.equalsIgnoreCase("mechanics")) && (!mode.equalsIgnoreCase("random")))
      return new SimpleErrorData("Recommend Data Error", "This execution mode is not supported");
    
    GamesDatabase database = null;
    Object result = null;
    
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
    
      User user = database.readUser(userID);
      if (user == null)
        return new SimpleErrorData("User Not Found", "No User could be found with the provided userID");
      
      Collection curCollection = database.readCollection(user.getCollectionID());
      if (curCollection == null)
        return new SimpleErrorData("Collection Not Found", "No Collection could be found for this userID");
      
      if (mode.equalsIgnoreCase("mechanics")) {
        //We want to loop through each game and index the mechanics
        List<CollectionItem> games = curCollection.getGames();
        //Need this to ensure we include child games with no parent in our list
        List<Long> parentGameIDs = new LinkedList<Long>();
        List<String> mechanics   = new LinkedList<String>();
        
        //First pass, only parent games
        for (CollectionItem item : games) {
          if ((item.getGame().getGameType() == GameType.BASE) || (item.getGame().getGameType() == GameType.COLLECTIBLE)) {
            parentGameIDs.add(item.getGameID());
            
            List<String> gameMechanisms = item.getGame().getMechanisms();
            if (gameMechanisms != null) {
              for (String singleMechanic : gameMechanisms) {
                boolean found = false;
                for (String mechanic : mechanics) {
                  if (singleMechanic.equalsIgnoreCase(mechanic)) {
                    found = true;
                    break;
                  }
                }
                if (!found)
                  mechanics.add(singleMechanic);
              }
            }
          }
        }//end for first pass
        
        //Second pass, only expansions, if the parent is not part of our collection
        for (CollectionItem item : games) {
          if (item.getGame().getGameType() == GameType.EXPANSION) {
            if ((item.getGame().getParentGameID() != -1) && (!parentGameIDs.contains(item.getGame().getParentGameID()))) {
              List<String> gameMechanisms = item.getGame().getMechanisms();
              if (gameMechanisms != null) {
                for (String singleMechanic : gameMechanisms) {
                  boolean found = false;
                  for (String mechanic : mechanics) {
                    if (singleMechanic.equalsIgnoreCase(mechanic)) {
                      found = true;
                      break;
                    }
                  }
                  if (!found)
                    mechanics.add(singleMechanic);
                }
              }
            }
          }
        }
        
        Collections.sort(mechanics);
        mechanics.add(0, "Any");
        
        result = new WrapList(mechanics);
      } else if (mode.equalsIgnoreCase("random")) {
        
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
    
    if (result == null)
      return new SimpleErrorData("Game Not Found", "The requested item could not be found in the database.");

    return result;
  }
  
  /**
   * POST method, will actually run our recommendation logic and generate a result
   * 
   * @param values the parameters to constrain our search 
   * 
   * @return A {@link SimpleMessageData} or {@link SimpleErrorData} message indicating the operation status
   */
  @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
  public Object postWishlist(@RequestBody RecommendValues values) {
    if (values == null)
      return new SimpleErrorData("Recommend Data Error", "There was no recommend data provided");
    
    if (values.getUserID() < 0)
      return new SimpleErrorData("Recommend Data Error", "There was no userID data provided");
    
    if ((values.getPlayerCount() == -1) && (values.getGameLength() == -1) && 
        (values.getGameWeight() == null) && (values.getMechanic() == null))
      return new SimpleErrorData("Recommend Data Error", "At least one parameter must be chosen");
    
    GameWeight findWeight = null;
    if ((values.getGameWeight() != null) & (!values.getGameWeight().equalsIgnoreCase("Any"))) {
      findWeight = convertWeight(values.getGameWeight());
      if (findWeight == null)
        return new SimpleErrorData("Recommend Data Error", "The provided game weight value is not valid");
    }
    
    GamesDatabase database = null;
    Object result = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
    
      User user = database.readUser(values.getUserID());
      if (user == null)
        return new SimpleErrorData("User Not Found", "No User could be found with the provided userID");
      
      Collection curCollection = database.readCollection(user.getCollectionID());
      if (curCollection == null)
        return new SimpleErrorData("Collection Not Found", "No Collection could be found for this userID");
      
      List<CollectionItem> games = curCollection.getGames();
      Collections.sort(games);

      if (values.getRecommendNum() == -1)
        values.setRecommendNum(games.size() + 1);

      //This will be our result list
      List<CollectionItem> matchingGames = new LinkedList<CollectionItem>();
      
      List<Long> parentGameIDs = new LinkedList<Long>();
      //First loop, only consider parent games (no expansions)
      for (CollectionItem item : games) {
        if ((item.getGame().getGameType() == GameType.BASE) || (item.getGame().getGameType() == GameType.COLLECTIBLE)) {
          parentGameIDs.add(item.getGameID());
          
          boolean isPlayerCountMatch = false;
          if (values.getPlayerCount() != -1) {
            int trueMinPlayer = item.getGame().getMinPlayers();
            if (item.getOverrideMinPlayers() != -1) trueMinPlayer = item.getOverrideMinPlayers();
            int trueMaxPlayer = item.getGame().getMaxPlayers();
            if (item.getOverrideMaxPlayers() != -1) trueMaxPlayer = item.getOverrideMaxPlayers();
            
            if ((trueMinPlayer <= values.getPlayerCount()) && (trueMaxPlayer >= values.getPlayerCount()))
              isPlayerCountMatch = true;
          } else isPlayerCountMatch = true;
        
          boolean isGameLengthMatch = false;
          if (values.getGameLength() != -1) {
            int trueMinTime = item.getGame().getMinPlayingTime();
            if (item.getOverrideMinTime() != -1) trueMinTime = item.getOverrideMinTime();
            int trueMaxTime = item.getGame().getMaxPlayingTime();
            if (item.getOverrideMaxTime() != -1) trueMaxTime = item.getOverrideMaxTime();
            
            //Add in margin of error
            trueMinTime -= 15;
            trueMaxTime += 15;
            if ((trueMinTime <= values.getGameLength()) && (trueMaxTime >= values.getGameLength()))
              isGameLengthMatch = true;
          } else isGameLengthMatch = true;
        
          boolean isGameWeightMatch = false;
          if (findWeight != null) {
            List<GameWeight> weights = item.getWeights();
            if (weights != null) {
              if (weights.contains(findWeight))
                isGameWeightMatch = true;
            }
          } else isGameWeightMatch = true;
          
          boolean isMechanismMatch = false;
          if ((values.getMechanic() != null) && (!values.getMechanic().equalsIgnoreCase("Any"))) {
            List<String> mechanisms = item.getGame().getMechanisms();
            if (mechanisms != null) {
              for (String curMechanic : mechanisms) {
                if (curMechanic.equalsIgnoreCase(values.getMechanic())) {
                  isMechanismMatch = true;
                  break;
                }
              }
            }
          } else isMechanismMatch = true;
          
          if (isPlayerCountMatch && isGameLengthMatch && isGameWeightMatch && isMechanismMatch) {
            matchingGames.add(item);
          }
        }
        if (matchingGames.size() >= values.getRecommendNum())
          break;
      }
      
      //Now, if there's a need, check through expansion titles
      if (matchingGames.size() < values.getRecommendNum()) {
        for (CollectionItem item : games) {
          if (item.getGame().getGameType() == GameType.EXPANSION) {
            if ((item.getGame().getParentGameID() != -1) && (!parentGameIDs.contains(item.getGame().getParentGameID()))) {
              boolean isPlayerCountMatch = false;
              if (values.getPlayerCount() != -1) {
                int trueMinPlayer = item.getGame().getMinPlayers();
                if (item.getOverrideMinPlayers() != -1) trueMinPlayer = item.getOverrideMinPlayers();
                int trueMaxPlayer = item.getGame().getMaxPlayers();
                if (item.getOverrideMaxPlayers() != -1) trueMaxPlayer = item.getOverrideMaxPlayers();
                
                if ((trueMinPlayer <= values.getPlayerCount()) && (trueMaxPlayer >= values.getPlayerCount()))
                  isPlayerCountMatch = true;
              } else isPlayerCountMatch = true;
            
              boolean isGameLengthMatch = false;
              if (values.getGameLength() != -1) {
                int trueMinTime = item.getGame().getMinPlayingTime();
                if (item.getOverrideMinTime() != -1) trueMinTime = item.getOverrideMinTime();
                int trueMaxTime = item.getGame().getMaxPlayingTime();
                if (item.getOverrideMaxTime() != -1) trueMaxTime = item.getOverrideMaxTime();
                
                //Add in margin of error
                trueMinTime -= 15;
                trueMaxTime += 15;
                if ((trueMinTime <= values.getGameLength()) && (trueMaxTime >= values.getGameLength()))
                  isGameLengthMatch = true;
              } else isGameLengthMatch = true;
            
              boolean isGameWeightMatch = false;
              if (findWeight != null) {
                List<GameWeight> weights = item.getWeights();
                if (weights != null) {
                  if (weights.contains(findWeight))
                    isGameWeightMatch = true;
                }
              } else isGameWeightMatch = true;
              
              boolean isMechanismMatch = false;
              if ((values.getMechanic() != null) && (!values.getMechanic().equalsIgnoreCase("Any"))) {
                List<String> mechanisms = item.getGame().getMechanisms();
                if (mechanisms != null) {
                  for (String curMechanic : mechanisms) {
                    if (curMechanic.equalsIgnoreCase(values.getMechanic())) {
                      isMechanismMatch = true;
                      break;
                    }
                  }
                }
              } else isMechanismMatch = true;
              
              if (isPlayerCountMatch && isGameLengthMatch && isGameWeightMatch && isMechanismMatch) {
                matchingGames.add(item);
              }
            }
          }
        }
      }
    
      result = matchingGames;
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

    return result;
  }
  
  private GameWeight convertWeight(String weight) {
    if (weight.equalsIgnoreCase("Children")) return GameWeight.CHILDREN;
    if (weight.equalsIgnoreCase("Filler"))   return GameWeight.FILLER;
    if (weight.equalsIgnoreCase("Social"))   return GameWeight.SOCIAL;
    if (weight.equalsIgnoreCase("Light"))    return GameWeight.LIGHT;
    if (weight.equalsIgnoreCase("Family"))   return GameWeight.FAMILY;
    if (weight.equalsIgnoreCase("Medium"))   return GameWeight.MEDIUM;
    if (weight.equalsIgnoreCase("Heavy"))    return GameWeight.HEAVY;
    return null;
  }
}
