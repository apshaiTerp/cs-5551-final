package com.ac.games.agent.test;

import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.ac.games.agent.thread.CSIAutoReviewAgentThread;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.GameReltn;
import com.ac.games.data.ReviewState;
import com.ac.games.db.mongo.CSIDataConverter;
import com.ac.games.db.mongo.GameReltnConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * @author ac010168
 *
 */
public class TestPublisherDump {

  @Test
  public void testPubDump() {
    System.out.println ("Starting the pub dump test");
    
    MongoClient client = null;
    try {
      client = new MongoClient("192.168.1.9", 27017);
    } catch (UnknownHostException e) {
      e.printStackTrace();
      return;
    }
    
    DB mongoDB = client.getDB("livedb");
    DBCollection csiCollection   = mongoDB.getCollection("csidata");
    DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
    
    List<GameReltn> reltnsWithCSIData = new LinkedList<GameReltn>();
    DBCursor cursor = reltnCollection.find();
    while (cursor.hasNext()) {
      GameReltn reltn = GameReltnConverter.convertMongoToGameReltn(cursor.next());
      List<Long> csiIDs = reltn.getCsiIDs();
      if ((csiIDs != null) && (csiIDs.size() > 0))
        reltnsWithCSIData.add(reltn);
    }
    try { cursor.close(); } catch (Throwable t) {}
    
    System.out.println ("I have " + reltnsWithCSIData.size() + " GameReltns with CSI Data in them");
    
    int count = 0;
    for (GameReltn reltn : reltnsWithCSIData) {
      count++;
      System.out.println ("[" + count + "/" + reltnsWithCSIData.size() + "] Processing GameReltn " + reltn.getGameID());
      List<Long> csiIDs = reltn.getCsiIDs();
      List<Long> newCSIs = new LinkedList<Long>();
      
      for (long csiID : csiIDs) {
        BasicDBObject searchObject = new BasicDBObject("csiID", csiID);
        cursor = csiCollection.find(searchObject);
        CoolStuffIncPriceData data = null;
        while (cursor.hasNext()) {
          data = CSIDataConverter.convertMongoToCSI(cursor.next());
        }
        try { cursor.close(); } catch (Throwable t) {}
        
        if (data == null) {
          System.out.println ("  CSI Entry " + csiID + " is not valid!");
        } else {
          newCSIs.add(csiID);
        }
      }
      reltn.setCsiIDs(newCSIs);
      
      if (newCSIs.size() < csiIDs.size()) {
        System.out.println ("  Updating GameReltn entry to now have " + newCSIs.size() + " csiIDs mapped (was " + csiIDs.size() + ")");
        reltnCollection.update(new BasicDBObject("reltnID", reltn.getReltnID()), GameReltnConverter.convertGameReltnToMongo(reltn));
      }
    }
    
    //Searching for all Reviewed CSI entries
    BasicDBObject searchObject = new BasicDBObject("reviewState", 1);
    cursor = csiCollection.find(searchObject);
    List<CoolStuffIncPriceData> reviewedCSIs = new LinkedList<CoolStuffIncPriceData>();
    while (cursor.hasNext()) {
      reviewedCSIs.add(CSIDataConverter.convertMongoToCSI(cursor.next()));
    }
    try { cursor.close(); } catch (Throwable t) {}
    
    //Now we verify that every
    count = 0;
    for (CoolStuffIncPriceData data : reviewedCSIs) {
      count++;
      System.out.println ("[" + count + "/" + reviewedCSIs.size() + "] Processing CSI ID " + data.getCsiID());
      
      BasicDBList csiList = new BasicDBList();
      csiList.add(data.getCsiID());
      searchObject = new BasicDBObject("csiIDs", new BasicDBObject("$in", csiList));
      
      cursor = reltnCollection.find(searchObject);
      GameReltn reltn = null;
      while (cursor.hasNext()) {
        reltn = GameReltnConverter.convertMongoToGameReltn(cursor.next());
      }
      try { cursor.close(); } catch (Throwable t) {}

      if (reltn == null) {
        System.out.println ("  This game is reviewed, but isn't mapped to a GameReltn!");
        data.setReviewState(ReviewState.PENDING);
        data.setReviewDate(null);
        
        System.out.println ("  !! Resetting CSI ID: " + data.getCsiID() + " - " + data.getTitle());
        csiCollection.update(new BasicDBObject("csiID", data.getCsiID()), CSIDataConverter.convertCSIToMongo(data));
      }
    }
    
    client.close();
    
    assertTrue("The world did not end", true);
  }
}

class PublisherData implements Comparable<PublisherData> {

  private String publisherName;
  private int    gameHits;
  
  /**
   * @return the publisherName
   */
  public String getPublisherName() {
    return publisherName;
  }

  /**
   * @param publisherName the publisherName to set
   */
  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  /**
   * @return the gameHits
   */
  public int getGameHits() {
    return gameHits;
  }

  /**
   * @param gameHits the gameHits to set
   */
  public void setGameHits(int gameHits) {
    this.gameHits = gameHits;
  }

  @Override
  public int compareTo(PublisherData data) {
    return gameHits - data.getGameHits();
  }
}
