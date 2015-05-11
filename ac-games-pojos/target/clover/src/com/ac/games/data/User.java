/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class encapsulates all the public data visible for a user. 
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {public static class __CLR3_3_01ef1efi96a0zvs{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1860,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** The userID for this user */
  private long   userID;
  /** The userName for this user */
  private String userName;
  /** The first name for the person */
  private String firstName;
  /** The last name for the person */
  private String lastName;
  /** The email address for this user */
  private String emailAddress;
  /** The users collection link.  This is created up front */
  private long   collectionID;

  /** The List of Playthru data for this user */
  //private List<PlaythruItem> playthroughs;
  /** The wishlist for this user. */
  //private List<WishlistItem> wishlist;
  
  public User() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1815);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1816);userID       = -1;
    __CLR3_3_01ef1efi96a0zvs.R.inc(1817);userName     = null;
    __CLR3_3_01ef1efi96a0zvs.R.inc(1818);firstName    = null;
    __CLR3_3_01ef1efi96a0zvs.R.inc(1819);lastName     = null;
    __CLR3_3_01ef1efi96a0zvs.R.inc(1820);emailAddress = null;
    __CLR3_3_01ef1efi96a0zvs.R.inc(1821);collectionID = -1;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}
  
  public User(String jsonString) {
    super();__CLR3_3_01ef1efi96a0zvs.R.inc(1823);try{__CLR3_3_01ef1efi96a0zvs.R.inc(1822);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1824);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_01ef1efi96a0zvs.R.inc(1825);try {
      __CLR3_3_01ef1efi96a0zvs.R.inc(1826);User jsonData = mapper.readValue(jsonString, User.class);
      __CLR3_3_01ef1efi96a0zvs.R.inc(1827);userID       = jsonData.userID;
      __CLR3_3_01ef1efi96a0zvs.R.inc(1828);userName     = jsonData.userName;
      __CLR3_3_01ef1efi96a0zvs.R.inc(1829);firstName    = jsonData.firstName;
      __CLR3_3_01ef1efi96a0zvs.R.inc(1830);lastName     = jsonData.lastName;
      __CLR3_3_01ef1efi96a0zvs.R.inc(1831);emailAddress = jsonData.emailAddress;
      __CLR3_3_01ef1efi96a0zvs.R.inc(1832);collectionID = jsonData.collectionID;
    } catch (JsonParseException jpe) {
      __CLR3_3_01ef1efi96a0zvs.R.inc(1833);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_01ef1efi96a0zvs.R.inc(1834);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_01ef1efi96a0zvs.R.inc(1835);ioe.printStackTrace();
    }
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the userID
   */
  public long getUserID() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1836);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1837);return userID;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1838);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1839);this.userID = userID;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the userName
   */
  public String getUserName() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1840);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1841);return userName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1842);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1843);this.userName = userName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the firstName
   */
  public String getFirstName() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1844);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1845);return firstName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1846);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1847);this.firstName = firstName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the lastName
   */
  public String getLastName() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1848);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1849);return lastName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1850);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1851);this.lastName = lastName;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the emailAddress
   */
  public String getEmailAddress() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1852);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1853);return emailAddress;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(String emailAddress) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1854);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1855);this.emailAddress = emailAddress;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @return the collectionID
   */
  public long getCollectionID() {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1856);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1857);return collectionID;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}

  /**
   * @param collectionID the collectionID to set
   */
  public void setCollectionID(long collectionID) {try{__CLR3_3_01ef1efi96a0zvs.R.inc(1858);
    __CLR3_3_01ef1efi96a0zvs.R.inc(1859);this.collectionID = collectionID;
  }finally{__CLR3_3_01ef1efi96a0zvs.R.flushNeeded();}}
}
