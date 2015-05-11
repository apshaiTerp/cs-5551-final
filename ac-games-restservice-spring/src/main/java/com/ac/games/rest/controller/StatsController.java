package com.ac.games.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.MMDataStats;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.message.SimpleErrorData;

/**
 * This class should be the intercepter for REST service access to the stats
 * information.
 * <p>
 * It should handle all request that come in under the /stats entry.  At this time
 * it will only support GET requests.
 * <p>
 * Refer to the individual methods to determine the parameter lists.
 * 
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/stats")
public class StatsController {

  /**
   * GET method designed to handle retrieving Stats data from the database.<p>
   * This method supports the following parameters:
   * <ul>
   * <li><code>type=&lt;statType&gt;</code> - The type of stats we want.  This is required.</li>
   * </ul>
   * 
   * @param type The type of stats that we are requesting
   * 
   * @return One of the Stat family of objects or {@link SimpleErrorData} message reporting what failed.
   */
  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getStats(@RequestParam(value="type") String type,
                         @RequestParam(value="userid", defaultValue="-1") long userID) {
    if (type == null)
      return new SimpleErrorData("Stats Request Error", "There was no valid stat type request data provided");
    
    if ((!type.equalsIgnoreCase(BGGGameStats.BGG_GAME_STATS)) && 
        (!type.equalsIgnoreCase(CSIDataStats.CSI_DATA_STATS)) &&
        (!type.equalsIgnoreCase(MMDataStats.MM_DATA_STATS)) &&
        (!type.equalsIgnoreCase("user")))
      return new SimpleErrorData("Stats Request Error", "The Stats Type " + type + " is unknown and cannot be retrieved.");
    
    if (type.equalsIgnoreCase("user") && (userID == -1))
      return new SimpleErrorData("Stats Request Error", "The Stats Type collection requires a userID");
    
    GamesDatabase database = null; 
    Object statResult = null;
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (type.equalsIgnoreCase(BGGGameStats.BGG_GAME_STATS))
        statResult = database.readBGGGameStats();
      else if (type.equalsIgnoreCase(CSIDataStats.CSI_DATA_STATS))
        statResult = database.readCSIDataStats();
      else if (type.equalsIgnoreCase(MMDataStats.MM_DATA_STATS))
        statResult = database.readMMDataStats();
      else if (type.equalsIgnoreCase("user"))
        statResult = database.readCollectionStats(userID);
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

    if (statResult == null)
      return new SimpleErrorData("Stats Not Found", "The requested stats could not be found in the database.");
    
    return statResult;
  }
}
