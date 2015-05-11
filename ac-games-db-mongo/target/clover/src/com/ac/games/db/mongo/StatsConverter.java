/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

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
public class StatsConverter {public static class __CLR3_3_02zo2zoi96a4yup{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,3983,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the gameID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertStatsToTypeQuery(String statType) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3876);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3877);if ((((statType == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3878)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3879)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3880);return null;
    
    }__CLR3_3_02zo2zoi96a4yup.R.inc(3881);BasicDBObject dbObject = new BasicDBObject("statType", statType);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3882);return dbObject;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}

  public static BasicDBObject convertStatsToMongo(BGGGameStats stats) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3883);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3884);if ((((stats == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3885)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3886)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3887);return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    }__CLR3_3_02zo2zoi96a4yup.R.inc(3888);BasicDBObject dbObject = new BasicDBObject("statType", BGGGameStats.BGG_GAME_STATS);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3889);dbObject.append("baseGameCount", stats.getBaseGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3890);dbObject.append("expansionGameCount", stats.getExpansionGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3891);dbObject.append("collectibleGameCount", stats.getCollectibleGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3892);dbObject.append("approvedCount", stats.getApprovedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3893);dbObject.append("rejectedCount", stats.getRejectedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3894);dbObject.append("pendingCount", stats.getPendingCount());
    
    __CLR3_3_02zo2zoi96a4yup.R.inc(3895);return dbObject;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}
  
  public static BasicDBObject convertStatsToMongo(CSIDataStats stats) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3896);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3897);if ((((stats == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3898)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3899)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3900);return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    }__CLR3_3_02zo2zoi96a4yup.R.inc(3901);BasicDBObject dbObject = new BasicDBObject("statType", CSIDataStats.CSI_DATA_STATS);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3902);dbObject.append("boardGameCount", stats.getBoardGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3903);dbObject.append("collectibleGameCount", stats.getCollectibleGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3904);dbObject.append("diceMastersCount", stats.getDiceMastersCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3905);dbObject.append("rpgCount", stats.getRpgCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3906);dbObject.append("lcgCount", stats.getLcgCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3907);dbObject.append("suppliesCount", stats.getSuppliesCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3908);dbObject.append("miniatureCount", stats.getMiniatureCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3909);dbObject.append("videoGameCount", stats.getVideoGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3910);dbObject.append("unknownCount", stats.getUnknownCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3911);dbObject.append("approvedCount", stats.getApprovedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3912);dbObject.append("rejectedCount", stats.getRejectedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3913);dbObject.append("pendingCount", stats.getPendingCount());

    __CLR3_3_02zo2zoi96a4yup.R.inc(3914);return dbObject;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}
  
  public static BasicDBObject convertStatsToMongo(MMDataStats stats) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3915);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3916);if ((((stats == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3917)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3918)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3919);return null;
    
    //We're going to assume all stats have a value, even if it's just 0, so no checking
    }__CLR3_3_02zo2zoi96a4yup.R.inc(3920);BasicDBObject dbObject = new BasicDBObject("statType", MMDataStats.MM_DATA_STATS);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3921);dbObject.append("boardGameCount", stats.getBoardGameCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3922);dbObject.append("tableTopCount", stats.getTableTopCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3923);dbObject.append("ccgCount", stats.getCcgCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3924);dbObject.append("lcgCount", stats.getLcgCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3925);dbObject.append("collectiblesCount", stats.getCollectiblesCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3926);dbObject.append("rpgCount", stats.getRpgCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3927);dbObject.append("accessoriesCount", stats.getAccessoriesCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3928);dbObject.append("unknownCount", stats.getUnknownCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3929);dbObject.append("approvedCount", stats.getApprovedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3930);dbObject.append("rejectedCount", stats.getRejectedCount());
    __CLR3_3_02zo2zoi96a4yup.R.inc(3931);dbObject.append("pendingCount", stats.getPendingCount());

    __CLR3_3_02zo2zoi96a4yup.R.inc(3932);return dbObject;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}
  
  public static BGGGameStats convertMongoToBGGGameStats(DBObject dbObject) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3933);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3934);if ((((dbObject == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3935)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3936)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3937);return null;

    }__CLR3_3_02zo2zoi96a4yup.R.inc(3938);BGGGameStats stats = new BGGGameStats();
    __CLR3_3_02zo2zoi96a4yup.R.inc(3939);stats.setBaseGameCount((Integer)dbObject.get("baseGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3940);stats.setExpansionGameCount((Integer)dbObject.get("expansionGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3941);stats.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3942);stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3943);stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3944);stats.setPendingCount((Integer)dbObject.get("pendingCount"));
    
    __CLR3_3_02zo2zoi96a4yup.R.inc(3945);return stats;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}
  
  public static CSIDataStats convertMongoToCSIDataStats(DBObject dbObject) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3946);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3947);if ((((dbObject == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3948)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3949)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3950);return null;

    }__CLR3_3_02zo2zoi96a4yup.R.inc(3951);CSIDataStats stats = new CSIDataStats();
    __CLR3_3_02zo2zoi96a4yup.R.inc(3952);stats.setBoardGameCount((Integer)dbObject.get("boardGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3953);stats.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3954);stats.setDiceMastersCount((Integer)dbObject.get("diceMastersCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3955);stats.setRpgCount((Integer)dbObject.get("rpgCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3956);stats.setLcgCount((Integer)dbObject.get("lcgCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3957);stats.setSuppliesCount((Integer)dbObject.get("suppliesCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3958);stats.setMiniatureCount((Integer)dbObject.get("miniatureCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3959);stats.setVideoGameCount((Integer)dbObject.get("videoGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3960);stats.setUnknownCount((Integer)dbObject.get("unknownCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3961);stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3962);stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3963);stats.setPendingCount((Integer)dbObject.get("pendingCount"));

    __CLR3_3_02zo2zoi96a4yup.R.inc(3964);return stats;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}

  public static MMDataStats convertMongoToMMDataStats(DBObject dbObject) {try{__CLR3_3_02zo2zoi96a4yup.R.inc(3965);
    __CLR3_3_02zo2zoi96a4yup.R.inc(3966);if ((((dbObject == null)&&(__CLR3_3_02zo2zoi96a4yup.R.iget(3967)!=0|true))||(__CLR3_3_02zo2zoi96a4yup.R.iget(3968)==0&false))) {__CLR3_3_02zo2zoi96a4yup.R.inc(3969);return null;

    }__CLR3_3_02zo2zoi96a4yup.R.inc(3970);MMDataStats stats = new MMDataStats();
    
    __CLR3_3_02zo2zoi96a4yup.R.inc(3971);stats.setBoardGameCount((Integer)dbObject.get("boardGameCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3972);stats.setTableTopCount((Integer)dbObject.get("tableTopCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3973);stats.setCcgCount((Integer)dbObject.get("ccgCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3974);stats.setLcgCount((Integer)dbObject.get("lcgCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3975);stats.setCollectiblesCount((Integer)dbObject.get("collectiblesCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3976);stats.setRpgCount((Integer)dbObject.get("rpgCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3977);stats.setAccessoriesCount((Integer)dbObject.get("accessoriesCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3978);stats.setUnknownCount((Integer)dbObject.get("unknownCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3979);stats.setApprovedCount((Integer)dbObject.get("approvedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3980);stats.setRejectedCount((Integer)dbObject.get("rejectedCount"));
    __CLR3_3_02zo2zoi96a4yup.R.inc(3981);stats.setPendingCount((Integer)dbObject.get("pendingCount"));

    __CLR3_3_02zo2zoi96a4yup.R.inc(3982);return stats;
  }finally{__CLR3_3_02zo2zoi96a4yup.R.flushNeeded();}}
}
