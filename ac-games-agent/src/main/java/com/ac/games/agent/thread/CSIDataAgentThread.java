package com.ac.games.agent.thread;

import java.io.IOException;
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
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.ReviewState;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.message.SimpleErrorData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class CSIDataAgentThread extends BackgroundAgentThread {
  
  /** Service access point */
  public final static String SERVICE_ROOT = "/external/csidata";
  /** Parameter Request list for read requests */
  public final static String PARAM_LIST   = "?csiid=<gameID>";
  /** Parameter Replace Tag */
  public final static String REPLACE_TAG  = "<gameID>";

  public CSIDataAgentThread() {
    super();
  }
  
  public CSIDataAgentThread(long startID, long stopID) {
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
    
    //Step 1 - Get the list of bggIDs from database
    List<Long> csiIDList = null;
    try {
      csiIDList = database.getCSIIDList();
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
      return;
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
      return;
    }
    
    List<Long> gamesToSearch = new LinkedList<Long>();
    for (long curID = startID; curID <= stopID; curID++) {
      if (!csiIDList.contains(curID))
        gamesToSearch.add(curID);
    }
    
    System.out.println ("About to scan documents ranging from [" + startID + "-" + stopID + "]");
    System.out.println ("The number of games we are going to find is: " + gamesToSearch.size());
    
    //Now begin looking through the games I want to search
    if (gamesToSearch.size() > 0) {
      
      RestTemplate restTemplate  = new RestTemplate();
      ObjectMapper mapper        = new ObjectMapper();
      HttpHeaders headers        = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<String> request = new HttpEntity<String>(headers);
      
      
      for (int pos = 0; pos < gamesToSearch.size(); pos++) {
        long curID = gamesToSearch.get(pos);
        
        System.out.println ("Processing CSI ID: " + curID);
        
        String url = GamesAgent.serverAddress + SERVICE_ROOT + PARAM_LIST.replace(REPLACE_TAG, "" + curID);
        System.out.println ("The url we are requesting is: " + url);
        
        
        CoolStuffIncPriceData game = null;
        SimpleErrorData data = null;
        
        try {
          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
          String responseBody = response.getBody();
          
          if (responseBody.contains("\"errorType\"") && responseBody.contains("\"errorMessage\"")) {
            data = mapper.readValue(responseBody, SimpleErrorData.class);
          } else {
            game = mapper.readValue(responseBody, CoolStuffIncPriceData.class);
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

        if (game != null) {
          failCount = 0;
          notFoundCount = 0;
          
          System.out.println ("  I'm looking at game: " + game.getTitle());
          
          //Now we should upload this game, since it doesn't exist.
          game.setReviewState(ReviewState.PENDING);
          game.setAddDate(new Date());
          
          try {
            database.insertCSIPriceData(game);
          } catch (DatabaseOperationException doe) {
            doe.printStackTrace();
          } catch (ConfigurationException ce) {
            ce.printStackTrace();
          }
        }
        else if (data != null) {
          System.out.println ("  I had a problem: ");
          System.out.println ("    Error: " + data.getErrorType() + " - " + data.getErrorMessage());
          
          if (data.getErrorType().equalsIgnoreCase("Server Timeout 503")) {
            System.out.println ("Looks like I've been a pest.  Time to sleep it off (60 seconds)");
            pos--;
            try { Thread.sleep(60000); } catch (Throwable t) {}
          } else if (data.getErrorType().equalsIgnoreCase("Game Not Found")) {
            failCount = 0;
            System.out.println ("    This game was not found.");
            notFoundCount++;
            System.out.println ("Nothing Found Count: " + notFoundCount);

            if (notFoundCount > 20000) {
              System.out.println ("I think we found too many empty batches.  Exiting now.");
              return;
            }
          } else {
            failCount++;
            pos--;
            System.out.println ("  The current failCount is now " + failCount);
            
            if (failCount == 10) {
              System.out.println ("I'm out of here.  Too many failures.");
              return;
            }
          }
        } else {
          System.out.println ("I couldn't get the game I wanted to find...");
          failCount++;
          System.out.println ("  The current failCount is now " + failCount);
          
          if (failCount == 10) {
            System.out.println ("I'm out of here.  Too many failures.");
            return;
          }
        }
        
      }
    }
  }
}
