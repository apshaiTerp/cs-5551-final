package com.ac.games.agent.thread;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.Game;
import com.ac.games.db.mongo.CollectionConverter;
import com.ac.games.db.mongo.CollectionItemConverter;
import com.ac.games.db.mongo.GameConverter;
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
public class GameSyncThread extends Thread {
  
  public GameSyncThread() {
    super();
  }
  
  @Override
  public void run() {
    System.out.println ("Beginning GameSyncThread!");
    
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
      
      DBCollection gameCollection = mongoDB.getCollection("game");
      DBCollection colCollection  = mongoDB.getCollection("collection");
      DBCollection itemCollection = mongoDB.getCollection("collectionitem");
      
      //Let's start with the collection objects
      List<Collection> collections = new LinkedList<Collection>();
      DBCursor cursor = colCollection.find();
      while (cursor.hasNext())
        collections.add(CollectionConverter.convertMongoToCollection(cursor.next()));
      try { cursor.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      
      //For each collection, review and update all games in that collection
      for (Collection curCollection : collections) {
        List<CollectionItem> items = curCollection.getGames();
        
        System.out.println ("Inspecting Collection ID: " + curCollection.getCollectionID());
        
        if (items != null) {
          
          System.out.println ("Items is not null");
          
          for (CollectionItem item : items) {
            long gameID = item.getGameID();
            
            System.out.println ("  Item ID: " + item.getItemID() + "   Game ID: " + item.getGameID());
            System.out.println ("  Game Name: " + item.getGame().getName());
            
            BasicDBObject searchObject = new BasicDBObject("gameID", gameID);
            DBCursor gameCursor = gameCollection.find(searchObject);
            Game game = null;
            while (gameCursor.hasNext())
              game = GameConverter.convertMongoToGame(gameCursor.next());
            try { gameCursor.close(); } catch (Throwable t2) { /** Igmore Errors */ }

            if (game != null) {
              System.out.println ("  Replacing game content...");
              
              item.setGame(game);
            } else {
              System.out.println ("I have a problem here");
            }
          }
        } else {
          items = new ArrayList<CollectionItem>();
        }
        curCollection.setGames(items);
        
        BasicDBObject searchObject = new BasicDBObject("collectionID", curCollection.getCollectionID());
        colCollection.update(searchObject, CollectionConverter.convertCollectionToMongo(curCollection));
      }//end for
      
      System.out.println ("Beginning to Process individual games...");
      
      List<CollectionItem> allItems = new LinkedList<CollectionItem>();
      cursor = itemCollection.find();
      while (cursor.hasNext())
        allItems.add(CollectionItemConverter.convertMongoToCollectionItem(cursor.next()));
      
      try { cursor.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      
      //For each individual collection item, update the game content
      for (CollectionItem item : allItems) {
        long gameID = item.getGameID();
        
        System.out.println ("  Item ID: " + item.getItemID() + "   Game ID: " + item.getGameID());
        System.out.println ("  Game Name: " + item.getGame().getName());
        
        BasicDBObject searchObject = new BasicDBObject("gameID", gameID);
        DBCursor gameCursor = gameCollection.find(searchObject);
        Game game = null;
        while (gameCursor.hasNext())
          game = GameConverter.convertMongoToGame(gameCursor.next());
        try { gameCursor.close(); } catch (Throwable t2) { /** Igmore Errors */ }
        
        if (game != null) {
          System.out.println ("  Replacing game content...");
          
          item.setGame(game);
        } else {
          System.out.println ("I have a problem here");
        }
        
        searchObject = new BasicDBObject("itemID", item.getItemID());
        itemCollection.update(searchObject, CollectionItemConverter.convertCollectionItemToMongo(item));
      }
      
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }

      System.out.println ("GameSyncThread Finished Successfully!");
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      return;
    }
  }
      
}
