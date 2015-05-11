/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishlistItem implements Comparable<WishlistItem> {public static class __CLR3_3_01j21j2i96a0zx9{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2023,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  private long    wishID;
  private long    userID;
  private long    gameID;
  private Date    dateAdded;
  private boolean notifyUser;
  
  public WishlistItem() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(1982);
    __CLR3_3_01j21j2i96a0zx9.R.inc(1983);wishID     = -1L;
    __CLR3_3_01j21j2i96a0zx9.R.inc(1984);userID     = -1L;
    __CLR3_3_01j21j2i96a0zx9.R.inc(1985);gameID     = -1L;
    __CLR3_3_01j21j2i96a0zx9.R.inc(1986);dateAdded  = null;
    __CLR3_3_01j21j2i96a0zx9.R.inc(1987);notifyUser = false;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}
  
  public WishlistItem(String jsonString) {
    super();__CLR3_3_01j21j2i96a0zx9.R.inc(1989);try{__CLR3_3_01j21j2i96a0zx9.R.inc(1988);
    __CLR3_3_01j21j2i96a0zx9.R.inc(1990);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_01j21j2i96a0zx9.R.inc(1991);try {
      __CLR3_3_01j21j2i96a0zx9.R.inc(1992);WishlistItem jsonData = mapper.readValue(jsonString, WishlistItem.class);
      __CLR3_3_01j21j2i96a0zx9.R.inc(1993);wishID       = jsonData.wishID;
      __CLR3_3_01j21j2i96a0zx9.R.inc(1994);userID       = jsonData.userID;
      __CLR3_3_01j21j2i96a0zx9.R.inc(1995);gameID       = jsonData.gameID;
      __CLR3_3_01j21j2i96a0zx9.R.inc(1996);dateAdded    = jsonData.dateAdded;
      __CLR3_3_01j21j2i96a0zx9.R.inc(1997);notifyUser   = jsonData.notifyUser;
    } catch (JsonParseException jpe) {
      __CLR3_3_01j21j2i96a0zx9.R.inc(1998);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_01j21j2i96a0zx9.R.inc(1999);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_01j21j2i96a0zx9.R.inc(2000);ioe.printStackTrace();
    }
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @return the wishID
   */
  public long getWishID() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2001);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2002);return wishID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @param wishID the wishID to set
   */
  public void setWishID(long wishID) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2003);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2004);this.wishID = wishID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @return the userID
   */
  public long getUserID() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2005);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2006);return userID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2007);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2008);this.userID = userID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2009);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2010);return gameID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2011);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2012);this.gameID = gameID;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @return the dateAdded
   */
  public Date getDateAdded() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2013);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2014);return dateAdded;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @param dateAdded the dateAdded to set
   */
  public void setDateAdded(Date dateAdded) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2015);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2016);this.dateAdded = dateAdded;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @return the notifyUser
   */
  public boolean isNotifyUser() {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2017);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2018);return notifyUser;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /**
   * @param notifyUser the notifyUser to set
   */
  public void setNotifyUser(boolean notifyUser) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2019);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2020);this.notifyUser = notifyUser;
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}

  /*
   * (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(WishlistItem o) {try{__CLR3_3_01j21j2i96a0zx9.R.inc(2021);
    __CLR3_3_01j21j2i96a0zx9.R.inc(2022);return (int)(o.wishID - wishID);
  }finally{__CLR3_3_01j21j2i96a0zx9.R.flushNeeded();}}
}
