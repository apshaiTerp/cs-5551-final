package com.ac.games.agent.thread;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ac.games.agent.data.ParentChildGames;
import com.ac.games.data.Game;
import com.ac.games.db.mongo.GameConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * @author ac010168
 *
 */
public class FixExpansionThread extends Thread {
  
  public FixExpansionThread() {
    super();
  }
  
  @Override
  public void run() {
    System.out.println ("Beginning FixExpansionThread!");
    
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
      
      System.out.println ("Database Connection Established.");
      System.out.println ("Building Queries for Expansion Titles....");

      BasicDBObject searchObject  = new BasicDBObject("parentGameID", new BasicDBObject("$gt", 0));
      BasicDBObject columnsObject = new BasicDBObject("parentGameID", 1);
      columnsObject.append("gameID", 1);
      
      List<ParentChildGames> gamesList = new LinkedList<ParentChildGames>();
      DBCursor cursor = gameCollection.find(searchObject, columnsObject);
      while (cursor.hasNext()) {
        DBObject object = cursor.next();
        ParentChildGames game = new ParentChildGames();
        game.setChildID((Long)object.get("gameID"));
        game.setParentID((Long)object.get("parentGameID"));
        gamesList.add(game);
      }
      try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
      
      //Now we have a list of games with their parent, lets go make this right.
      for (ParentChildGames game : gamesList) {
        //DEBUG
        System.out.println ("Inspecting expansion gameID: " + game.getChildID());
        
        searchObject = new BasicDBObject("gameID", game.getParentID());
        
        Game parentGame = null;
        cursor = gameCollection.find(searchObject);
        while (cursor.hasNext()) {
          DBObject object = cursor.next();
          parentGame = GameConverter.convertMongoToGame(object);
        }
        try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
        
        if (parentGame != null) {
          List<Long> expansions = parentGame.getExpansionIDs();
          if (expansions == null) {
            expansions = new ArrayList<Long>(1);
            expansions.add(game.getChildID());
            parentGame.setExpansionIDs(expansions);
            
            //DEBUG
            System.out.println ("  + Adding expansion gameID [" + game.getChildID() + "] to parent gameID [" + game.getParentID() + "]");
            
            gameCollection.update(searchObject, GameConverter.convertGameToMongo(parentGame), true, false);
          } else {
            boolean found = false;
            for (long curGameID : expansions) {
              if (curGameID == game.getChildID()) {
                found = true;
                break;
              }
            }
            if (!found) {
              expansions.add(game.getChildID());
              parentGame.setExpansionIDs(expansions);

              //DEBUG
              System.out.println ("  + Adding expansion gameID [" + game.getChildID() + "] to parent gameID [" + game.getParentID() + "]");
              
              gameCollection.update(searchObject, GameConverter.convertGameToMongo(parentGame), true, false);
            } else {
              System.out.println ("  - Expansion gameID [" + game.getChildID() + "] is already part of parent gameID [" + game.getParentID() + "]");
            }
          }
        }
      }
      
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }

      System.out.println ("FixExpansionThread Finished Successfully!");
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      return;
    }
  }

}
