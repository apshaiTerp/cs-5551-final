/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
public class MediaItem {public static class __CLR3_3_012y12yi96a0zsq{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1465,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  private long          mediaID;
  private long          gameID;
  private long          userID;
  private String        userName;
  private MediaItemType itemType;
  private String        mediaLink;
  private String        mediaDescription;
  private Date          addedDate;
  private boolean       privateItem;
  
  public MediaItem() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1402);
    __CLR3_3_012y12yi96a0zsq.R.inc(1403);mediaID          = -1L;
    __CLR3_3_012y12yi96a0zsq.R.inc(1404);gameID           = -1L;
    __CLR3_3_012y12yi96a0zsq.R.inc(1405);userID           = -1L;
    __CLR3_3_012y12yi96a0zsq.R.inc(1406);userName         = null;
    __CLR3_3_012y12yi96a0zsq.R.inc(1407);itemType         = null;
    __CLR3_3_012y12yi96a0zsq.R.inc(1408);mediaLink        = null;
    __CLR3_3_012y12yi96a0zsq.R.inc(1409);mediaDescription = null;
    __CLR3_3_012y12yi96a0zsq.R.inc(1410);addedDate        = null;
    __CLR3_3_012y12yi96a0zsq.R.inc(1411);privateItem      = true;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}
  
  public MediaItem(String jsonString) {
    super();__CLR3_3_012y12yi96a0zsq.R.inc(1413);try{__CLR3_3_012y12yi96a0zsq.R.inc(1412);
    __CLR3_3_012y12yi96a0zsq.R.inc(1414);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_012y12yi96a0zsq.R.inc(1415);try {
      __CLR3_3_012y12yi96a0zsq.R.inc(1416);MediaItem jsonData = mapper.readValue(jsonString, MediaItem.class);
      __CLR3_3_012y12yi96a0zsq.R.inc(1417);mediaID          = jsonData.mediaID;
      __CLR3_3_012y12yi96a0zsq.R.inc(1418);gameID           = jsonData.gameID;
      __CLR3_3_012y12yi96a0zsq.R.inc(1419);userID           = jsonData.userID;
      __CLR3_3_012y12yi96a0zsq.R.inc(1420);userName         = jsonData.userName;
      __CLR3_3_012y12yi96a0zsq.R.inc(1421);itemType         = jsonData.itemType;
      __CLR3_3_012y12yi96a0zsq.R.inc(1422);mediaLink        = jsonData.mediaLink;
      __CLR3_3_012y12yi96a0zsq.R.inc(1423);mediaDescription = jsonData.mediaDescription;
      __CLR3_3_012y12yi96a0zsq.R.inc(1424);addedDate        = jsonData.addedDate;
      __CLR3_3_012y12yi96a0zsq.R.inc(1425);privateItem      = jsonData.privateItem;
    } catch (JsonParseException jpe) {
      __CLR3_3_012y12yi96a0zsq.R.inc(1426);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_012y12yi96a0zsq.R.inc(1427);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_012y12yi96a0zsq.R.inc(1428);ioe.printStackTrace();
    }
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the mediaID
   */
  public long getMediaID() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1429);
    __CLR3_3_012y12yi96a0zsq.R.inc(1430);return mediaID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param mediaID the mediaID to set
   */
  public void setMediaID(long mediaID) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1431);
    __CLR3_3_012y12yi96a0zsq.R.inc(1432);this.mediaID = mediaID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1433);
    __CLR3_3_012y12yi96a0zsq.R.inc(1434);return gameID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1435);
    __CLR3_3_012y12yi96a0zsq.R.inc(1436);this.gameID = gameID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the userID
   */
  public long getUserID() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1437);
    __CLR3_3_012y12yi96a0zsq.R.inc(1438);return userID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1439);
    __CLR3_3_012y12yi96a0zsq.R.inc(1440);this.userID = userID;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the userName
   */
  public String getUserName() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1441);
    __CLR3_3_012y12yi96a0zsq.R.inc(1442);return userName;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1443);
    __CLR3_3_012y12yi96a0zsq.R.inc(1444);this.userName = userName;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the itemType
   */
  public MediaItemType getItemType() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1445);
    __CLR3_3_012y12yi96a0zsq.R.inc(1446);return itemType;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param itemType the itemType to set
   */
  public void setItemType(MediaItemType itemType) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1447);
    __CLR3_3_012y12yi96a0zsq.R.inc(1448);this.itemType = itemType;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the mediaLink
   */
  public String getMediaLink() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1449);
    __CLR3_3_012y12yi96a0zsq.R.inc(1450);return mediaLink;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param mediaLink the mediaLink to set
   */
  public void setMediaLink(String mediaLink) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1451);
    __CLR3_3_012y12yi96a0zsq.R.inc(1452);this.mediaLink = mediaLink;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the mediaDescription
   */
  public String getMediaDescription() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1453);
    __CLR3_3_012y12yi96a0zsq.R.inc(1454);return mediaDescription;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param mediaDescription the mediaDescription to set
   */
  public void setMediaDescription(String mediaDescription) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1455);
    __CLR3_3_012y12yi96a0zsq.R.inc(1456);this.mediaDescription = mediaDescription;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the addedDate
   */
  public Date getAddedDate() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1457);
    __CLR3_3_012y12yi96a0zsq.R.inc(1458);return addedDate;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param addedDate the addedDate to set
   */
  public void setAddedDate(Date addedDate) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1459);
    __CLR3_3_012y12yi96a0zsq.R.inc(1460);this.addedDate = addedDate;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @return the privateItem
   */
  public boolean isPrivateItem() {try{__CLR3_3_012y12yi96a0zsq.R.inc(1461);
    __CLR3_3_012y12yi96a0zsq.R.inc(1462);return privateItem;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}

  /**
   * @param privateItem the privateItem to set
   */
  public void setPrivateItem(boolean privateItem) {try{__CLR3_3_012y12yi96a0zsq.R.inc(1463);
    __CLR3_3_012y12yi96a0zsq.R.inc(1464);this.privateItem = privateItem;
  }finally{__CLR3_3_012y12yi96a0zsq.R.flushNeeded();}}
}
