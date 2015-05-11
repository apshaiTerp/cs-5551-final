/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class UserRoleConverter {public static class __CLR3_3_01ig1igi96a0zwz{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1982,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Integer flag corresponding to no UserRole set */
  public final static int DEFAULT_FLAG = -1;
  /** Integer flag corresponding to the Admin UserRole set */
  public final static int ADMIN_FLAG   = 0;
  /** Integer flag corresponding to the User UserRole set */
  public final static int USER_FLAG    = 1;

  /**
   * Helper method to convert from UserRole enum to a static flag value.
   * @param role
   * @return
   */
  public static int convertUserRoleToFlag(UserRole role) {try{__CLR3_3_01ig1igi96a0zwz.R.inc(1960);
    __CLR3_3_01ig1igi96a0zwz.R.inc(1961);if ((((role == null)&&(__CLR3_3_01ig1igi96a0zwz.R.iget(1962)!=0|true))||(__CLR3_3_01ig1igi96a0zwz.R.iget(1963)==0&false))) {__CLR3_3_01ig1igi96a0zwz.R.inc(1964);return DEFAULT_FLAG;
    }boolean __CLB3_3_0_bool0=false;__CLR3_3_01ig1igi96a0zwz.R.inc(1965);switch (role) {
      case ADMIN :if (!__CLB3_3_0_bool0) {__CLR3_3_01ig1igi96a0zwz.R.inc(1966);__CLB3_3_0_bool0=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1967);return ADMIN_FLAG;
      case USER  :if (!__CLB3_3_0_bool0) {__CLR3_3_01ig1igi96a0zwz.R.inc(1968);__CLB3_3_0_bool0=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1969);return USER_FLAG;
      default    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ig1igi96a0zwz.R.inc(1970);__CLB3_3_0_bool0=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1971);return DEFAULT_FLAG;
    }
  }finally{__CLR3_3_01ig1igi96a0zwz.R.flushNeeded();}}
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static UserRole convertFlagToUserRole(int flag) {try{__CLR3_3_01ig1igi96a0zwz.R.inc(1972);
    boolean __CLB3_3_0_bool1=false;__CLR3_3_01ig1igi96a0zwz.R.inc(1973);switch (flag) {
      case DEFAULT_FLAG :if (!__CLB3_3_0_bool1) {__CLR3_3_01ig1igi96a0zwz.R.inc(1974);__CLB3_3_0_bool1=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1975);return null;
      case ADMIN_FLAG   :if (!__CLB3_3_0_bool1) {__CLR3_3_01ig1igi96a0zwz.R.inc(1976);__CLB3_3_0_bool1=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1977);return UserRole.ADMIN;
      case USER_FLAG    :if (!__CLB3_3_0_bool1) {__CLR3_3_01ig1igi96a0zwz.R.inc(1978);__CLB3_3_0_bool1=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1979);return UserRole.USER;
      default           :if (!__CLB3_3_0_bool1) {__CLR3_3_01ig1igi96a0zwz.R.inc(1980);__CLB3_3_0_bool1=true;} __CLR3_3_01ig1igi96a0zwz.R.inc(1981);return null;
    }
  }finally{__CLR3_3_01ig1igi96a0zwz.R.flushNeeded();}}
}
