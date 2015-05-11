package com.ac.games.agent.thread;

import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;

/**
 * @author ac010168
 *
 */
public class BGGScheduledAgentThread extends Thread {
  
  private final static long minRangeOffset = 1000L;
  private final static long maxRangeOffset = 1000L;
  
  public BGGScheduledAgentThread() {
    super();
  }

  @Override
  public void run() {
    try {
      GamesDatabase database = MongoDBFactory.createMongoGamesDatabase("localhost", 27017, "livedb");
      try {
        database.initializeDBConnection();
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
        return;
      }
      
      long maxID = -1;
      try {
        maxID = database.getMaxBGGGameID();
      } catch (DatabaseOperationException doe) {
        doe.printStackTrace();
        try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
        return;
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
        return;
      }
      
      Thread thread = new BatchBGGGameAgentThread(maxID - minRangeOffset, maxID + maxRangeOffset);
      thread.start();
      
      thread.join();
      
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      return;
    }
  }
}
