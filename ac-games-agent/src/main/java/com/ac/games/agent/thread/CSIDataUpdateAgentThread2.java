package com.ac.games.agent.thread;

import java.io.IOException;
import java.net.UnknownHostException;
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
import com.ac.games.db.mongo.CSIDataConverter;
import com.ac.games.rest.message.SimpleErrorData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * @author ac010168
 *
 */
public class CSIDataUpdateAgentThread2 extends BackgroundAgentThread {
  
  /** Service access point */
  public final static String SERVICE_ROOT = "/external/csidata";
  /** Parameter Request list for read requests */
  public final static String PARAM_LIST   = "?csiid=<gameID>&source=hybrid&sync=y";
  /** Parameter Replace Tag */
  public final static String REPLACE_TAG  = "<gameID>";

  public CSIDataUpdateAgentThread2() {
    super(0,0);
  }
  
  /**
   * Primary Execution Method 
   */
  @Override
  public void run() {
    executeSimpleTask();
  }
  
  private void executeSimpleTask() {
    System.out.println ("Beginning CSIDataUpdateAgentThread2!");
    
    MongoClient client = null;
    try {
      try {
        client = new MongoClient("localhost", 27017);
        client.setWriteConcern(WriteConcern.JOURNALED);
      } catch (UnknownHostException e) {
        e.printStackTrace();
        return;
      }
      
      DB mongoDB = client.getDB("livedb");
      
      DBCollection csiCollection = mongoDB.getCollection("csidata");
      
      List<CoolStuffIncPriceData> csiApprovedList = new LinkedList<CoolStuffIncPriceData>();
      BasicDBObject searchObject = new BasicDBObject("reviewState", 1);
            
      DBCursor cursor = csiCollection.find(searchObject);
      while (cursor.hasNext()) {
        CoolStuffIncPriceData data = CSIDataConverter.convertMongoToCSI(cursor.next());
        csiApprovedList.add(data);
      }
      
      System.out.println ("How many CSI entries am I about to review: " + csiApprovedList.size());
      
      List<CoolStuffIncPriceData> changedGames = new LinkedList<CoolStuffIncPriceData>();
      int count = 0;
      for (CoolStuffIncPriceData data : csiApprovedList) {
        count++;
        System.out.println ("[" + count + "/" + csiApprovedList.size() + "] Processing csiID " + data.getCsiID() + " - " + data.getTitle());
        
        RestTemplate restTemplate  = new RestTemplate();
        ObjectMapper mapper        = new ObjectMapper();
        HttpHeaders headers        = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        
        String url = GamesAgent.serverAddress + SERVICE_ROOT + PARAM_LIST.replace(REPLACE_TAG, "" + data.getCsiID());
        System.out.println ("  The url we are requesting is: " + url);
        
        CoolStuffIncPriceData game = null;
        SimpleErrorData errorData  = null;
        
        try {
          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
          String responseBody = response.getBody();
          
          if (responseBody.contains("\"errorType\"") && responseBody.contains("\"errorMessage\"")) {
            errorData = mapper.readValue(responseBody, SimpleErrorData.class);
          } else {
            game = mapper.readValue(responseBody, CoolStuffIncPriceData.class);
          }
          
          if (errorData != null) {
            System.out.println ("  I had an error processing this request: ");
            System.out.println ("    Type: " + errorData.getErrorType() + "   Message: " + errorData.getErrorMessage());
          } else {
            System.out.println ("  I got the results back!");
            
            boolean hasMeaningfulChange = false;
            if (data.getAvailability() != game.getAvailability()) hasMeaningfulChange = true;
            if (data.getMsrpValue() != game.getMsrpValue())       hasMeaningfulChange = true;
            if (data.getCurPrice() != game.getCurPrice())         hasMeaningfulChange = true;
            
            if (hasMeaningfulChange) {
              System.out.println ("  !!! Something changed and you should know");
              changedGames.add(data);
            }
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
            System.out.println ("That's it!  I'm out.  Game ID: " + data.getCsiID() + " could not be processed!");
            return;
          }
        }
      }//end for process all items
      
      System.out.println ("=============================================================================================");
      System.out.println ("The following games saw meaningful change [" + changedGames.size() + "].");
      System.out.println ("=============================================================================================");
      
      count = 0;
      for (CoolStuffIncPriceData data : changedGames) {
        count++;
        System.out.println("[" + count + "/" + changedGames.size() + "] CSI ID: " + data.getCsiID() + " - " + data.getTitle());
      }
      
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }

      System.out.println ("CSIDataUpdateAgentThread2 Finished Successfully!");
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      return;
    }
  }
}
