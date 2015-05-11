package com.ac.games.agent.thread;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.MiniatureMarketCategoryConverter;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.ReviewState;
import com.ac.games.db.mongo.GameConverter;
import com.ac.games.db.mongo.GameReltnConverter;
import com.ac.games.db.mongo.MMDataConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author ac010168
 *
 */
public class MMAutoReviewAgentThread extends Thread {

  public MMAutoReviewAgentThread() {
    super();
  }
  
  public void run() {
    executeMainTask();
  }
  
  private void executeMainTask() {
    //We want to start by weeding out any junk data entries, which should be less when finalized, but could be a lot now.
    //For most of this class, we are going to bypass the service and communicate directly with the database because the
    //queryies we need to run are too specific.
    //Console console = System.console();
    
    MongoClient client = null;
    try {
      client = new MongoClient("localhost", 27017);
    } catch (UnknownHostException e) {
      e.printStackTrace();
      return;
    }
    
    DB mongoDB = client.getDB("livedb");
    DBCollection mmCollection    = mongoDB.getCollection("mmdata");
    DBCollection gameCollection  = mongoDB.getCollection("game");
    DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
    
    //Categories of invalid of junk criteria
    //Base game with no player data
    //db.mdata.find( { reviewState: 0, minPlayers: {$exists:false}} )
    BasicDBList rejectCategoryList = new BasicDBList();
    rejectCategoryList.add(MiniatureMarketCategoryConverter.DEFAULT_FLAG);
    rejectCategoryList.add(MiniatureMarketCategoryConverter.CCGS_FLAG);
    rejectCategoryList.add(MiniatureMarketCategoryConverter.RPGS_FLAG);
    rejectCategoryList.add(MiniatureMarketCategoryConverter.ACCESSORIES_FLAG);
    rejectCategoryList.add(MiniatureMarketCategoryConverter.UNKNOWN_FLAG);
    rejectCategoryList.add(MiniatureMarketCategoryConverter.COLLECTIBLES_FLAG);
    
    BasicDBObject queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("category", new BasicDBObject("$in", rejectCategoryList));
    
    System.out.println ("Running the following Query:\n  db.mmdata.find( "  + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}

    DBCursor cursor = mmCollection.find(queryObject);
    List<MiniatureMarketPriceData> gamesToReject = new LinkedList<MiniatureMarketPriceData>();
    
    cursor.limit(40000);
    int readCount = 0;
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      MiniatureMarketPriceData data = MMDataConverter.convertMongoToMM(object);
      data.setReviewState(ReviewState.REJECTED);
      data.setReviewDate(new Date());
      gamesToReject.add(data);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    System.out.println ("I found " + gamesToReject.size() + " MM items that don't belong to categories we care about that are about to be rejected");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    int count = 0;
    for (MiniatureMarketPriceData data : gamesToReject) {
      count++;
      System.out.println ("[" + count + "/" + gamesToReject.size() + "] Rejecting " + data.getTitle() + " (mmID:" + data.getMmID() + ")");
      
      DBObject matchObject = MMDataConverter.convertMMToIDQuery(data);
      DBObject writeObject = MMDataConverter.convertMMToMongo(data);
      
      mmCollection.update(matchObject, writeObject, true, false);
    }
    gamesToReject.clear();
    
    if (readCount == 40000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting");
      return;
    }
    
    //Now we need to process anything left to be evaluated and check for automatic game matching
    queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    
    System.out.println ("Running the following Query:\n  db.mmdata.find( "  + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}

    cursor = mmCollection.find(queryObject);
    List<MiniatureMarketPriceData> gamesToApprove = new LinkedList<MiniatureMarketPriceData>();
    
    cursor.limit(40000);
    readCount = 0;
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      MiniatureMarketPriceData data = MMDataConverter.convertMongoToMM(object);
      gamesToApprove.add(data);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }

    System.out.println ("I found " + gamesToApprove.size() + " MM items that need approval.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    count                 = 0;
    int approveCount      = 0;
    int noMatchCount      = 0;
    int tooManyMatchCount = 0;
    int noReltnCount      = 0;
    
    //TODO Update this list of keywords that have to be removed
    final String BOARD_GAME_TAG = " Board Game";
    final String EXPANSION_TAG  = " Expansion";
    
    for (MiniatureMarketPriceData data : gamesToApprove) {
      count++;
      System.out.println ("[" + count + "/" + gamesToApprove.size() + "] Reviewing " + data.getTitle() + " (mmID:" + data.getMmID() + ")");

      String origGameName = data.getTitle().trim();
      String altGameName  = origGameName.replace(BOARD_GAME_TAG, "").replace(EXPANSION_TAG, "").trim();
      
      queryObject = new BasicDBObject();
      if (origGameName.equalsIgnoreCase(altGameName)) {
        queryObject.append("name", origGameName);
      } else {
        BasicDBList gameNameList = new BasicDBList();
        gameNameList.add(origGameName);
        gameNameList.add(altGameName);
        queryObject.append("name", new BasicDBObject("$in", gameNameList));
      }
      
      cursor = gameCollection.find(queryObject);
      int hitCount = 0;
      Game foundGame = null;
      while (cursor.hasNext()) {
        hitCount++;
        foundGame = GameConverter.convertMongoToGame(cursor.next());
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      if (hitCount == 0) {
        noMatchCount++;
        System.out.println ("  No Existing Game Matches Found.  Skipping MM Entry");
      } else if (hitCount > 1) {
        tooManyMatchCount++;
        System.out.println ("  Multiple Game Matches Found.  Skipping MM Entry");
      } else {
        approveCount++;
        System.out.println ("  Found exact match.  Approving Game Entry");
        
        data.setReviewDate(new Date());
        data.setReviewState(ReviewState.REVIEWED);
        
        //Generate the list query objects, but wait till we make sure we can get the
        //reltn object to fill it all out.
        DBObject matchObject = MMDataConverter.convertMMToIDQuery(data);
        DBObject writeObject = MMDataConverter.convertMMToMongo(data);
        
        //Now link it in to the GameReltn Object
        BasicDBObject reltnQuery = new BasicDBObject("gameID", foundGame.getGameID());
        cursor = reltnCollection.find(reltnQuery);
        GameReltn reltn = null;
        while (cursor.hasNext()) {
          reltn = GameReltnConverter.convertMongoToGameReltn(cursor.next());
        }
        if (reltn == null) {
          approveCount--;
          noReltnCount++;
          System.out.println ("  !! Data issue, no Relation Data found.  Skipping MM Entry.");
        } else {
          List<Long> mmIDs = reltn.getMmIDs();
          if (mmIDs == null) mmIDs = new LinkedList<Long>();
          mmIDs.add(data.getMmID());
          reltn.setMmIDs(mmIDs);
          
          //Now push our objects into the database
          mmCollection.update(matchObject, writeObject, true, false);
          reltnCollection.update(reltnQuery, GameReltnConverter.convertGameReltnToMongo(reltn), true, false);
          
          System.out.println ("  Approved!");
        }
      }
    }//end for
    System.out.println ("I considered " + count + " items for approval.");
    System.out.println ("  I approved " + approveCount + " items!");
    System.out.println ("  I had data issues trying to approve " + noReltnCount + " items.");
    System.out.println ("  I skipped " + noMatchCount + " items because I couldn't find a matching game.");
    System.out.println ("  I skipped " + tooManyMatchCount + " items items because I found multiple matching games.");

    System.out.println ("Automated Approval Complete!");
    
    try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
  }
}
