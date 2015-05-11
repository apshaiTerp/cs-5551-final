package com.ac.games.db.mongo;

import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.MMDataStats;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 * Unlike many of the other Converter classes, this one will process all the basic stats objects, 
 * with the assumption that all values in the stats blocks are not optional.
 * 
 * This is also operating under the assumption that we never update stats.  We will always
 * be performing delete/reinsert with this data.  The other assumption is that only one row will
 * exist per statType, with the statType values being defined as static constants in the
 * corresponding data class.
 */
public class StatsConverter {

  /**
   * Helper method that will construct a basic query using the gameID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertStatsToTypeQuery(String statType) {
    if (statType == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("statType", statType);
    return dbObject;
  }

  public static BasicDBObject convertStatsToMongo(BGGGameStats stats) {
    if (stats == null) return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    BasicDBObject dbObject = new BasicDBObject("statType", BGGGameStats.BGG_GAME_STATS);
    dbObject.append("baseGameCount", stats.getBaseGameCount());
    dbObject.append("expansionGameCount", stats.getExpansionGameCount());
    dbObject.append("collectibleGameCount", stats.getCollectibleGameCount());
    dbObject.append("approvedCount", stats.getApprovedCount());
    dbObject.append("rejectedCount", stats.getRejectedCount());
    dbObject.append("pendingCount", stats.getPendingCount());
    
    return dbObject;
  }
  
  public static BasicDBObject convertStatsToMongo(CSIDataStats stats) {
    if (stats == null) return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    BasicDBObject dbObject = new BasicDBObject("statType", CSIDataStats.CSI_DATA_STATS);
    dbObject.append("boardGameCount", stats.getBoardGameCount());
    dbObject.append("collectibleGameCount", stats.getCollectibleGameCount());
    dbObject.append("diceMastersCount", stats.getDiceMastersCount());
    dbObject.append("rpgCount", stats.getRpgCount());
    dbObject.append("lcgCount", stats.getLcgCount());
    dbObject.append("suppliesCount", stats.getSuppliesCount());
    dbObject.append("miniatureCount", stats.getMiniatureCount());
    dbObject.append("videoGameCount", stats.getVideoGameCount());
    dbObject.append("unknownCount", stats.getUnknownCount());
    dbObject.append("approvedCount", stats.getApprovedCount());
    dbObject.append("rejectedCount", stats.getRejectedCount());
    dbObject.append("pendingCount", stats.getPendingCount());

    return dbObject;
  }
  
  public static BasicDBObject convertStatsToMongo(MMDataStats stats) {
    if (stats == null) return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    BasicDBObject dbObject = new BasicDBObject("statType", MMDataStats.MM_DATA_STATS);
    dbObject.append("boardGameCount", stats.getBoardGameCount());
    dbObject.append("tableTopCount", stats.getTableTopCount());
    dbObject.append("ccgCount", stats.getCcgCount());
    dbObject.append("lcgCount", stats.getLcgCount());
    dbObject.append("collectiblesCount", stats.getCollectiblesCount());
    dbObject.append("rpgCount", stats.getRpgCount());
    dbObject.append("accessoriesCount", stats.getAccessoriesCount());
    dbObject.append("unknownCount", stats.getUnknownCount());
    dbObject.append("approvedCount", stats.getApprovedCount());
    dbObject.append("rejectedCount", stats.getRejectedCount());
    dbObject.append("pendingCount", stats.getPendingCount());

    return dbObject;
  }
  
  public static BGGGameStats convertMongoToBGGGameStats(DBObject dbObject) {
    if (dbObject == null) return null;

    BGGGameStats stats = new BGGGameStats();
    stats.setBaseGameCount((Integer)dbObject.get("baseGameCount"));
    stats.setExpansionGameCount((Integer)dbObject.get("expansionGameCount"));
    stats.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    stats.setPendingCount((Integer)dbObject.get("pendingCount"));
    
    return stats;
  }
  
  public static CSIDataStats convertMongoToCSIDataStats(DBObject dbObject) {
    if (dbObject == null) return null;

    CSIDataStats stats = new CSIDataStats();
    stats.setBoardGameCount((Integer)dbObject.get("boardGameCount"));
    stats.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    stats.setDiceMastersCount((Integer)dbObject.get("diceMastersCount"));
    stats.setRpgCount((Integer)dbObject.get("rpgCount"));
    stats.setLcgCount((Integer)dbObject.get("lcgCount"));
    stats.setSuppliesCount((Integer)dbObject.get("suppliesCount"));
    stats.setMiniatureCount((Integer)dbObject.get("miniatureCount"));
    stats.setVideoGameCount((Integer)dbObject.get("videoGameCount"));
    stats.setUnknownCount((Integer)dbObject.get("unknownCount"));
    stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    stats.setPendingCount((Integer)dbObject.get("pendingCount"));

    return stats;
  }

  public static MMDataStats convertMongoToMMDataStats(DBObject dbObject) {
    if (dbObject == null) return null;

    MMDataStats stats = new MMDataStats();
    
    stats.setBoardGameCount((Integer)dbObject.get("boardGameCount"));
    stats.setTableTopCount((Integer)dbObject.get("tableTopCount"));
    stats.setCcgCount((Integer)dbObject.get("ccgCount"));
    stats.setLcgCount((Integer)dbObject.get("lcgCount"));
    stats.setCollectiblesCount((Integer)dbObject.get("collectiblesCount"));
    stats.setRpgCount((Integer)dbObject.get("rpgCount"));
    stats.setAccessoriesCount((Integer)dbObject.get("accessoriesCount"));
    stats.setUnknownCount((Integer)dbObject.get("unknownCount"));
    stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    stats.setPendingCount((Integer)dbObject.get("pendingCount"));

    return stats;
  }
}
