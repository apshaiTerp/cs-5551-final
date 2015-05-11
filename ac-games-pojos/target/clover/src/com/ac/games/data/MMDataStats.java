/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author ac010168
 *
 */
public class MMDataStats {public static class __CLR3_3_010e10ei96a0zry{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1385,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  public final static String MM_DATA_STATS = "mmDataStats";

  private int boardGameCount;
  private int tableTopCount;
  private int ccgCount;
  private int collectiblesCount;
  private int rpgCount;
  private int lcgCount;
  private int accessoriesCount;
  private int unknownCount;
  
  private int approvedCount;
  private int rejectedCount;
  private int pendingCount;
  
  public MMDataStats() {try{__CLR3_3_010e10ei96a0zry.R.inc(1310);
    __CLR3_3_010e10ei96a0zry.R.inc(1311);boardGameCount    = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1312);tableTopCount     = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1313);ccgCount          = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1314);lcgCount          = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1315);collectiblesCount = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1316);rpgCount          = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1317);accessoriesCount  = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1318);unknownCount      = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1319);approvedCount     = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1320);rejectedCount     = 0;
    __CLR3_3_010e10ei96a0zry.R.inc(1321);pendingCount      = 0;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}
  
  public MMDataStats(String jsonString) {
    super();__CLR3_3_010e10ei96a0zry.R.inc(1323);try{__CLR3_3_010e10ei96a0zry.R.inc(1322);
    __CLR3_3_010e10ei96a0zry.R.inc(1324);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_010e10ei96a0zry.R.inc(1325);try {
      __CLR3_3_010e10ei96a0zry.R.inc(1326);MMDataStats jsonData = mapper.readValue(jsonString, MMDataStats.class);
      __CLR3_3_010e10ei96a0zry.R.inc(1327);boardGameCount    = jsonData.boardGameCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1328);tableTopCount     = jsonData.tableTopCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1329);ccgCount          = jsonData.ccgCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1330);lcgCount          = jsonData.lcgCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1331);collectiblesCount = jsonData.collectiblesCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1332);rpgCount          = jsonData.rpgCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1333);accessoriesCount  = jsonData.accessoriesCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1334);unknownCount      = jsonData.unknownCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1335);approvedCount     = jsonData.approvedCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1336);rejectedCount     = jsonData.rejectedCount;
      __CLR3_3_010e10ei96a0zry.R.inc(1337);pendingCount      = jsonData.pendingCount;
    } catch (JsonParseException jpe) {
      __CLR3_3_010e10ei96a0zry.R.inc(1338);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_010e10ei96a0zry.R.inc(1339);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_010e10ei96a0zry.R.inc(1340);ioe.printStackTrace();
    }
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the boardGameCount
   */
  public int getBoardGameCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1341);
    __CLR3_3_010e10ei96a0zry.R.inc(1342);return boardGameCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param boardGameCount the boardGameCount to set
   */
  public void setBoardGameCount(int boardGameCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1343);
    __CLR3_3_010e10ei96a0zry.R.inc(1344);this.boardGameCount = boardGameCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the tableTopCount
   */
  public int getTableTopCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1345);
    __CLR3_3_010e10ei96a0zry.R.inc(1346);return tableTopCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param tableTopCount the tableTopCount to set
   */
  public void setTableTopCount(int tableTopCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1347);
    __CLR3_3_010e10ei96a0zry.R.inc(1348);this.tableTopCount = tableTopCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the ccgCount
   */
  public int getCcgCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1349);
    __CLR3_3_010e10ei96a0zry.R.inc(1350);return ccgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param ccgCount the ccgCount to set
   */
  public void setCcgCount(int ccgCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1351);
    __CLR3_3_010e10ei96a0zry.R.inc(1352);this.ccgCount = ccgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the collectiblesCount
   */
  public int getCollectiblesCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1353);
    __CLR3_3_010e10ei96a0zry.R.inc(1354);return collectiblesCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param collectiblesCount the collectiblesCount to set
   */
  public void setCollectiblesCount(int collectiblesCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1355);
    __CLR3_3_010e10ei96a0zry.R.inc(1356);this.collectiblesCount = collectiblesCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the rpgCount
   */
  public int getRpgCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1357);
    __CLR3_3_010e10ei96a0zry.R.inc(1358);return rpgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param rpgCount the rpgCount to set
   */
  public void setRpgCount(int rpgCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1359);
    __CLR3_3_010e10ei96a0zry.R.inc(1360);this.rpgCount = rpgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the accessoriesCount
   */
  public int getAccessoriesCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1361);
    __CLR3_3_010e10ei96a0zry.R.inc(1362);return accessoriesCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param accessoriesCount the accessoriesCount to set
   */
  public void setAccessoriesCount(int accessoriesCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1363);
    __CLR3_3_010e10ei96a0zry.R.inc(1364);this.accessoriesCount = accessoriesCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the unknownCount
   */
  public int getUnknownCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1365);
    __CLR3_3_010e10ei96a0zry.R.inc(1366);return unknownCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param unknownCount the unknownCount to set
   */
  public void setUnknownCount(int unknownCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1367);
    __CLR3_3_010e10ei96a0zry.R.inc(1368);this.unknownCount = unknownCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the approvedCount
   */
  public int getApprovedCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1369);
    __CLR3_3_010e10ei96a0zry.R.inc(1370);return approvedCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param approvedCount the approvedCount to set
   */
  public void setApprovedCount(int approvedCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1371);
    __CLR3_3_010e10ei96a0zry.R.inc(1372);this.approvedCount = approvedCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the rejectedCount
   */
  public int getRejectedCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1373);
    __CLR3_3_010e10ei96a0zry.R.inc(1374);return rejectedCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param rejectedCount the rejectedCount to set
   */
  public void setRejectedCount(int rejectedCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1375);
    __CLR3_3_010e10ei96a0zry.R.inc(1376);this.rejectedCount = rejectedCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the pendingCount
   */
  public int getPendingCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1377);
    __CLR3_3_010e10ei96a0zry.R.inc(1378);return pendingCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param pendingCount the pendingCount to set
   */
  public void setPendingCount(int pendingCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1379);
    __CLR3_3_010e10ei96a0zry.R.inc(1380);this.pendingCount = pendingCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @return the lcgCount
   */
  public int getLcgCount() {try{__CLR3_3_010e10ei96a0zry.R.inc(1381);
    __CLR3_3_010e10ei96a0zry.R.inc(1382);return lcgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}

  /**
   * @param lcgCount the lcgCount to set
   */
  public void setLcgCount(int lcgCount) {try{__CLR3_3_010e10ei96a0zry.R.inc(1383);
    __CLR3_3_010e10ei96a0zry.R.inc(1384);this.lcgCount = lcgCount;
  }finally{__CLR3_3_010e10ei96a0zry.R.flushNeeded();}}
}
