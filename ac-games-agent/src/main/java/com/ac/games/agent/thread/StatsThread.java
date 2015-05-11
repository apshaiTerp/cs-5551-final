package com.ac.games.agent.thread;

import java.net.UnknownHostException;

import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.CoolStuffIncCategory;
import com.ac.games.data.CoolStuffIncCategoryConverter;
import com.ac.games.data.GameType;
import com.ac.games.data.GameTypeConverter;
import com.ac.games.data.MMDataStats;
import com.ac.games.data.MiniatureMarketCategory;
import com.ac.games.data.MiniatureMarketCategoryConverter;
import com.ac.games.data.ReviewState;
import com.ac.games.data.ReviewStateConverter;
import com.ac.games.db.mongo.StatsConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * @author ac010168
 *
 */
public class StatsThread extends Thread {
  
  public StatsThread() {
    super();
  }

  @Override
  public void run() {
    System.out.println ("Beginning StatsThread!");
    
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
      DBCollection bggCollection   = mongoDB.getCollection("bgggame");
      DBCollection csiCollection   = mongoDB.getCollection("csidata");
      DBCollection mmCollection    = mongoDB.getCollection("mmdata");
      DBCollection statCollection  = mongoDB.getCollection("stats");
      
      System.out.println ("Database Connection Established.");
      System.out.println ("Building Queries for BGGGameStats....");
      
      //Start with the BGG Game Data
      BGGGameStats bggStats = new BGGGameStats();
      //Start with the game types
      BasicDBObject baseQuery        = new BasicDBObject("gameType", GameTypeConverter.convertGameTypeToFlag(GameType.BASE));
      BasicDBObject expansionQuery   = new BasicDBObject("gameType", GameTypeConverter.convertGameTypeToFlag(GameType.EXPANSION));
      BasicDBObject collectibleQuery = new BasicDBObject("gameType", GameTypeConverter.convertGameTypeToFlag(GameType.COLLECTIBLE));
      
      //Now let's look through the review states
      BasicDBObject approvedQuery = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.REVIEWED));
      BasicDBObject rejectedQuery = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.REJECTED));
      BasicDBObject pendingQuery  = new BasicDBObject("reviewState", ReviewStateConverter.convertReviewStateToFlag(ReviewState.PENDING));
        
      System.out.println ("Running Queries for BGGGameStats....");
      //Execute the queries
      bggStats.setBaseGameCount(bggCollection.find(baseQuery).count());
      bggStats.setExpansionGameCount(bggCollection.find(expansionQuery).count());
      bggStats.setCollectibleGameCount(bggCollection.find(collectibleQuery).count());
      
      bggStats.setApprovedCount(bggCollection.find(approvedQuery).count());
      bggStats.setRejectedCount(bggCollection.find(rejectedQuery).count());
      bggStats.setPendingCount(bggCollection.find(pendingQuery).count());
      
      System.out.println ("About to Write the following values to the database:");
      System.out.println ("  baseGameCount:        " + bggStats.getBaseGameCount());
      System.out.println ("  expansionGameCount:   " + bggStats.getExpansionGameCount());
      System.out.println ("  collectibleGameCount: " + bggStats.getCollectibleGameCount());
      System.out.println ("  approvedCount:        " + bggStats.getApprovedCount());
      System.out.println ("  rejectedCount:        " + bggStats.getRejectedCount());
      System.out.println ("  pendingCount:         " + bggStats.getPendingCount());
      
      System.out.println ("Writing BGGGameStats to the database....");
      BasicDBObject statsObject  = StatsConverter.convertStatsToMongo(bggStats);
      BasicDBObject deleteObject = StatsConverter.convertStatsToTypeQuery(BGGGameStats.BGG_GAME_STATS);
      statCollection.remove(deleteObject);
      statCollection.insert(statsObject);
      
      System.out.println ("BGGGameStats Complete.");
      System.out.println ("Building Queries for CSIDataStats....");
      
      //Now lets move on to the CSI Data
      CSIDataStats csiStats = new CSIDataStats();
      //Start with the CSI Categories
      BasicDBObject boardGameQuery       = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.BOARDGAMES));
      BasicDBObject collectibleGameQuery = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.COLLECTIBLE));
      BasicDBObject diceMastersQuery     = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.DICEMASTERS));
      BasicDBObject rpgQuery             = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.RPGS));
      BasicDBObject lcgQuery             = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.LCGS));
      BasicDBObject suppliesQuery        = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.SUPPLIES));
      BasicDBObject miniaturesQuery      = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.MINIATURES));
      BasicDBObject videoGameQuery       = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.VIDEOGAMES));
      BasicDBObject unknownQuery         = new BasicDBObject("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(CoolStuffIncCategory.UNKNOWN));
      
      System.out.println ("Running Queries for CSIDataStats....");

      csiStats.setBoardGameCount(csiCollection.find(boardGameQuery).count());
      csiStats.setCollectibleGameCount(csiCollection.find(collectibleGameQuery).count());
      csiStats.setDiceMastersCount(csiCollection.find(diceMastersQuery).count());
      csiStats.setRpgCount(csiCollection.find(rpgQuery).count());
      csiStats.setLcgCount(csiCollection.find(lcgQuery).count());
      csiStats.setSuppliesCount(csiCollection.find(suppliesQuery).count());
      csiStats.setMiniatureCount(csiCollection.find(miniaturesQuery).count());
      csiStats.setVideoGameCount(csiCollection.find(videoGameQuery).count());
      csiStats.setUnknownCount(csiCollection.find(unknownQuery).count());
      //Since the column name is the same, we can reuse the review state queries
      csiStats.setApprovedCount(csiCollection.find(approvedQuery).count());
      csiStats.setRejectedCount(csiCollection.find(rejectedQuery).count());
      csiStats.setPendingCount(csiCollection.find(pendingQuery).count());
      
      System.out.println ("About to Write the following values to the database:");
      System.out.println ("  boardGameCount:       " + csiStats.getBoardGameCount());
      System.out.println ("  collectibleGameCount: " + csiStats.getCollectibleGameCount());
      System.out.println ("  diceMastersCount:     " + csiStats.getDiceMastersCount());
      System.out.println ("  rpgCount:             " + csiStats.getRpgCount());
      System.out.println ("  lcgCount:             " + csiStats.getLcgCount());
      System.out.println ("  suppliesCount:        " + csiStats.getSuppliesCount());
      System.out.println ("  miniatureCount:       " + csiStats.getMiniatureCount());
      System.out.println ("  videoGameCount:       " + csiStats.getVideoGameCount());
      System.out.println ("  unknownCount:         " + csiStats.getUnknownCount());
      System.out.println ("  approvedCount:        " + csiStats.getApprovedCount());
      System.out.println ("  rejectedCount:        " + csiStats.getRejectedCount());
      System.out.println ("  pendingCount:         " + csiStats.getPendingCount());
      
      System.out.println ("Writing CSIDataStats to the database....");
      statsObject  = StatsConverter.convertStatsToMongo(csiStats);
      deleteObject = StatsConverter.convertStatsToTypeQuery(CSIDataStats.CSI_DATA_STATS);
      statCollection.remove(deleteObject);
      statCollection.insert(statsObject);

      System.out.println ("BGGGameStats Complete.");
      System.out.println ("Building Queries for MMDataStats....");
      
      //Now lets move on to the Minature Market stats
      MMDataStats mmStats = new MMDataStats();
      //Start with the MM Categories - We need to overwrite a handful of the fields CSI was using
      boardGameQuery                  = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.BOARDGAMES));
      BasicDBObject tableTopQuery     = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.TABLETOP));
      BasicDBObject ccgQuery          = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.CCGS));
      lcgQuery                        = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.LCGS));
      BasicDBObject collectiblesQuery = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.COLLECTIBLES));
      rpgQuery                        = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.RPGS));
      BasicDBObject accessoriesQuery  = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.ACCESSORIES));
      unknownQuery                    = new BasicDBObject("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(MiniatureMarketCategory.UNKNOWN));
      
      System.out.println ("Running Queries for MMDataStats....");

      mmStats.setBoardGameCount(mmCollection.find(boardGameQuery).count());
      mmStats.setTableTopCount(mmCollection.find(tableTopQuery).count());
      mmStats.setCcgCount(mmCollection.find(ccgQuery).count());
      mmStats.setLcgCount(mmCollection.find(lcgQuery).count());
      mmStats.setCollectiblesCount(mmCollection.find(collectiblesQuery).count());
      mmStats.setRpgCount(mmCollection.find(rpgQuery).count());
      mmStats.setAccessoriesCount(mmCollection.find(accessoriesQuery).count());
      mmStats.setUnknownCount(mmCollection.find(unknownQuery).count());
      //Since the column name is the same, we can reuse the review state queries
      mmStats.setApprovedCount(mmCollection.find(approvedQuery).count());
      mmStats.setRejectedCount(mmCollection.find(rejectedQuery).count());
      mmStats.setPendingCount(mmCollection.find(pendingQuery).count());
      
      System.out.println ("About to Write the following values to the database:");
      System.out.println ("  boardGameCount:    " + mmStats.getBoardGameCount());
      System.out.println ("  tableTopCount:     " + mmStats.getTableTopCount());
      System.out.println ("  ccgCount:          " + mmStats.getCcgCount());
      System.out.println ("  lcgCount:          " + mmStats.getLcgCount());
      System.out.println ("  collectiblesCount: " + mmStats.getCollectiblesCount());
      System.out.println ("  rpgCount:          " + mmStats.getRpgCount());
      System.out.println ("  accessoriesCount:  " + mmStats.getAccessoriesCount());
      System.out.println ("  unknownCount:      " + mmStats.getUnknownCount());
      System.out.println ("  approvedCount:     " + mmStats.getApprovedCount());
      System.out.println ("  rejectedCount:     " + mmStats.getRejectedCount());
      System.out.println ("  pendingCount:      " + mmStats.getPendingCount());
      
      System.out.println ("Writing MMDataStats to the database....");
      statsObject  = StatsConverter.convertStatsToMongo(mmStats);
      deleteObject = StatsConverter.convertStatsToTypeQuery(MMDataStats.MM_DATA_STATS);
      statCollection.remove(deleteObject);
      statCollection.insert(statsObject);
      
      System.out.println ("MMDataStats Complete.");

      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }

      System.out.println ("StatsThread Finished Successfully!");
    } catch (Throwable t) {
      System.out.println ("This is the master Thread Throwable: " + t.getMessage());
      t.printStackTrace();
      try { client.close(); } catch (Throwable t2) { /** Ignore Errors */ }
      return;
    }
  }
}
