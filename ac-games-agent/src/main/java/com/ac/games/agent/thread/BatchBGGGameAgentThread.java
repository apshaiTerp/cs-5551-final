package com.ac.games.agent.thread;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ac.games.agent.GamesAgent;
import com.ac.games.data.BGGGame;
import com.ac.games.data.ReviewState;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.message.SimpleErrorData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class BatchBGGGameAgentThread extends BackgroundAgentThread {

  /** Service access point */
  public final static String SERVICE_ROOT = "/external/bggdata";
  /** Parameter Request list for read requests */
  public final static String PARAM_LIST   = "?bggid=<gameID>";
  /** Parameter Replace Tag */
  public final static String REPLACE_TAG  = "<gameID>";
  /** Parameter for addition of batch size parameter */
  public final static String BATCH_PARAM  = "&batch=50";

  public BatchBGGGameAgentThread(long startID, long stopID) {
    super(startID, stopID);
  }
  
  /**
   * Primary Execution Method 
   */
  @Override
  public void run() {
    if (startID == 0 && stopID == 0)
      throw new RuntimeException("No Valid Start and Stop Range has been provided.  Terminating Thread.");
    
    executeSimpleTask();
  }
  
  private void executeSimpleTask() {
    GamesDatabase database = MongoDBFactory.createMongoGamesDatabase("localhost", 27017, "livedb");
    try {
      database.initializeDBConnection();
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
      return;
    }
    
    //Step 1 - Get the list of bggIDs from database - we don't want to overwrite these
    List<Long> bggIDList = null;
    try {
      bggIDList = database.getBggIDList();
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
      return;
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
      return;
    }

    //This is the list of every document we don't have any information for
    List<Long> gamesToSearch = new LinkedList<Long>();
    for (long curID = startID; curID <= stopID; curID++) {
      if (!bggIDList.contains(curID))
        gamesToSearch.add(curID);
    }
    
    Collections.sort(gamesToSearch);
    
    System.out.println ("About to scan documents ranging from [" + startID + "-" + stopID + "]");
    System.out.println ("We are hoping to find " + gamesToSearch.size() + " documents");
    
    if (gamesToSearch.size() > 0) {
      //Set up the calling framework
      RestTemplate restTemplate  = new RestTemplate();
      ObjectMapper mapper        = new ObjectMapper();
      HttpHeaders headers        = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<String> request = new HttpEntity<String>(headers);
      
      long curID = gamesToSearch.get(0);
      while (curID < stopID) {
        
        System.out.println ("Processing batch beginning with BGG ID: " + curID);
        
        String url = GamesAgent.serverAddress + SERVICE_ROOT + PARAM_LIST.replace(REPLACE_TAG, "" + curID) + BATCH_PARAM;
        System.out.println ("The url we are requesting is: " + url);
        
        List<BGGGame> games  = null;
        SimpleErrorData data = null;
        
        try {
          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
          String responseBody = response.getBody();
          
          if (responseBody.contains("\"errorType\"") && responseBody.contains("\"errorMessage\"")) {
            data = mapper.readValue(responseBody, SimpleErrorData.class);
          } else {
            games = mapper.readValue(responseBody, new TypeReference<List<BGGGame>>(){});
          }
        } catch (JsonParseException jpe) {
          jpe.printStackTrace();
        } catch (JsonMappingException jme) {
          jme.printStackTrace();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        } catch (Throwable t) {
          System.out.println ("Something else bad happened here: " + t.getMessage());
          failCount++;
          if (failCount >= 10) {
            System.out.println ("That's it!  I'm out.  Game ID: " + curID + " could not be processed!");
            return;
          }
        }
        
        if (games != null) {
          failCount = 0;
          System.out.println ("  I got the following number of games back: " + games.size());
          
          if (games.size() == 0) {
            notFoundCount++;
            System.out.println ("Nothing Found Count: " + notFoundCount);

            if (notFoundCount > 20) {
              System.out.println ("I think we found too many empty batches.  Exiting now.");
              return;
            }
          } else notFoundCount = 0;

          for (BGGGame game : games) {
            if (gamesToSearch.contains(game.getBggID())) {
              gamesToSearch.remove(game.getBggID());
              
              System.out.println (" + I'm looking at game: " + game.getName());
              
              //Now we should upload this game, since it doesn't exist.
              game.setReviewState(ReviewState.PENDING);
              game.setAddDate(new Date());
              
              try {
                database.insertBGGGameData(game);
              } catch (DatabaseOperationException doe) {
                doe.printStackTrace();
              } catch (ConfigurationException ce) {
                ce.printStackTrace();
              }

            } else {
              System.out.println (" - I'm bypassing " + game.getName() + " because it is already in the database");
            }
          }//end for
          
        }//end if games != null
        else if (data != null) {
          System.out.println ("  I had a problem: ");
          System.out.println ("    Error: " + data.getErrorType() + " - " + data.getErrorMessage());
          
          if (data.getErrorType().equalsIgnoreCase("Server Timeout 503")) {
            System.out.println ("Looks like I've been a pest.  Time to sleep it off (60 seconds)");
            curID -= 50;
            try { Thread.sleep(60000); } catch (Throwable t) {}
          } else if (data.getErrorType().equalsIgnoreCase("Game Not Found")) {
            failCount = 0;
            System.out.println ("    This game was not found.");
            notFoundCount++;
            System.out.println ("Nothing Found Count: " + notFoundCount);

            if (notFoundCount > 20) {
              System.out.println ("I think we found too many empty batches.  Exiting now.");
              return;
            }
          } else {
            failCount++;
            curID -= 50;
            System.out.println ("  The current failCount is now " + failCount);
            
            if (failCount == 10) {
              System.out.println ("I'm out of here.  Too many failures.");
              return;
            }
          }
        } else {
          System.out.println ("I couldn't get the game I wanted to find...");
          failCount++;
          curID -= 50;
          System.out.println ("  The current failCount is now " + failCount);
          
          if (failCount == 10) {
            System.out.println ("I'm out of here.  Too many failures.");
            return;
          }
        }
        curID += 50;
      }//end while
    }
  }
}
