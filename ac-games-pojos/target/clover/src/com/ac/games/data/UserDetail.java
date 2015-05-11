/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class encapsulates all the data for users that should not be made visible.
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {public static class __CLR3_3_01hd1hdi96a0zwl{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1960,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  /** The userID for this user */
  private long     userID;
  /** The user's password */
  private String   pass;
  /** The users role, based on {@link UserRole} */
  private UserRole userRole;
  /** The date when this user was created */
  private Date     createdOnDate;
  /** The last time this user logged in */
  private Date     lastLoginDate;

  public UserDetail() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1921);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1922);userID        = -1;
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1923);pass          = null;
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1924);userRole      = null;
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1925);createdOnDate = null;
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1926);lastLoginDate = null;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}
  
  public UserDetail(String jsonString) {
    super();__CLR3_3_01hd1hdi96a0zwl.R.inc(1928);try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1927);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1929);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1930);try {
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1931);UserDetail jsonData = mapper.readValue(jsonString, UserDetail.class);
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1932);userID        = jsonData.userID;
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1933);pass          = jsonData.pass;
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1934);userRole      = jsonData.userRole;
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1935);createdOnDate = jsonData.createdOnDate;
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1936);lastLoginDate = jsonData.lastLoginDate;
    } catch (JsonParseException jpe) {
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1937);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1938);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_01hd1hdi96a0zwl.R.inc(1939);ioe.printStackTrace();
    }
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @return the userID
   */
  public long getUserID() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1940);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1941);return userID;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @param userID the userID to set
   */
  public void setUserID(long userID) {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1942);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1943);this.userID = userID;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @return the pass
   */
  public String getPass() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1944);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1945);return pass;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @param pass the pass to set
   */
  public void setPass(String pass) {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1946);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1947);this.pass = pass;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @return the userRole
   */
  public UserRole getUserRole() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1948);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1949);return userRole;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @param userRole the userRole to set
   */
  public void setUserRole(UserRole userRole) {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1950);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1951);this.userRole = userRole;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @return the createdOnDate
   */
  public Date getCreatedOnDate() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1952);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1953);return createdOnDate;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @param createdOnDate the createdOnDate to set
   */
  public void setCreatedOnDate(Date createdOnDate) {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1954);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1955);this.createdOnDate = createdOnDate;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @return the lastLoginDate
   */
  public Date getLastLoginDate() {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1956);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1957);return lastLoginDate;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}

  /**
   * @param lastLoginDate the lastLoginDate to set
   */
  public void setLastLoginDate(Date lastLoginDate) {try{__CLR3_3_01hd1hdi96a0zwl.R.inc(1958);
    __CLR3_3_01hd1hdi96a0zwl.R.inc(1959);this.lastLoginDate = lastLoginDate;
  }finally{__CLR3_3_01hd1hdi96a0zwl.R.flushNeeded();}}
}
