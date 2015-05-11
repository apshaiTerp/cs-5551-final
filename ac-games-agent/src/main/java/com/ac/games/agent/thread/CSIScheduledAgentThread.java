package com.ac.games.agent.thread;

import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;

/**
 * @author ac010168
 *
 */
public class CSIScheduledAgentThread extends Thread {
  
  private final static long minRangeOffset = 100L;
  private final static long maxRangeOffset = 100L;
  
  public CSIScheduledAgentThread() {
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
        maxID = database.getMaxCSIDataID();
      } catch (DatabaseOperationException doe) {
        doe.printStackTrace();
        try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
        return;
      } catch (ConfigurationException ce) {
        ce.printStackTrace();
        try { database.closeDBConnection(); } catch (Throwable t) { /** Ignore errors */ }
        return;
      }
      
      Thread thread = new CSIDataAgentThread(maxID - minRangeOffset, maxID + maxRangeOffset);
      thread.start();
      
      thread.join();
      
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      return;
    }
  }
}
