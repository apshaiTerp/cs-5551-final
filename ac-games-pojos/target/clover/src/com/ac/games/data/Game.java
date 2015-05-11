/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) @JsonIgnoreProperties(ignoreUnknown = true)
public class Game {public static class __CLR3_3_0ododi96a0zor{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1090,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** The gameID assigned at creation */
  private long gameID;
  /** The objectid for this game on bgg */
  private long bggID;
  /** The game name indicated with the primary attribute on bgg */
  private String name;
  /** The year this game was published according to bgg */
  private int yearPublished;
  /** The minimum number of players capable of playing this game according to bgg */
  private int minPlayers;
  /** The maximum number of players capable of playing this game according to bgg */
  private int maxPlayers;
  /** The minimum playing time for this game according to bgg */
  private int minPlayingTime;
  /** The maximum playing time for this game according to bgg */
  private int maxPlayingTime;
  /** The primary game image shown for the game on bgg */
  private String imageURL;
  /** The primary game thumbnail image shown for the game on bgg */
  private String imageThumbnailURL;
  /** The game description text from bgg */
  private String description;

  /** Since many games list international publishers, we want to list out the 'true' */
  private String primaryPublisher;

  /** 
   * The is the list of publisher companies associated with the release of this game on bgg.
   * This list also includes overseas publishers and distributers.
   */
  private List<String> publishers;
  /**
   * This is the list of designers credited with designing this game on bgg.
   * Some people like following certain designers, so this list needs to be searchable as well.
   */
  private List<String> designers;
  /**
   * This is the list of categories associated with this game on bgg.
   * This is more informative and less rigidly defined than other categories.
   * Would probably be good to make this searchable.
   */
  private List<String> categories;
  /**
   * This is the list of mechanisms used by the game according to bgg.
   * This is also a subjective list built wikipedia-style.  It's more informative
   * than defining.
   */
  private List<String> mechanisms;

  /** 
   * This is only defined for BASE games.  This will be a list of expansion titles
   * that references the objectIDs of those expansion games. 
   */
  private List<Long> expansionIDs;
  /**
   * This is only defined for EXPANSION games.  This is a reference to the parent
   * objectID value to tie the expansion to it's parent game.
   */
  private long parentGameID;
  
  //**********  This is my only imposed metadata field, which is required  ********** 
  //**********  to help sort out the other optional fields.                **********
  /** Helps identify which type of game this is. */
  private GameType gameType;

  /** Date this record was added to the system */
  private Date addDate;

  public Game() {try{__CLR3_3_0ododi96a0zor.R.inc(877);
    __CLR3_3_0ododi96a0zor.R.inc(878);gameID            = -1L;
    __CLR3_3_0ododi96a0zor.R.inc(879);bggID             = -1L;
    __CLR3_3_0ododi96a0zor.R.inc(880);name              = null;
    __CLR3_3_0ododi96a0zor.R.inc(881);yearPublished     = -1;
    __CLR3_3_0ododi96a0zor.R.inc(882);minPlayers        = -1;
    __CLR3_3_0ododi96a0zor.R.inc(883);maxPlayers        = -1;
    __CLR3_3_0ododi96a0zor.R.inc(884);minPlayingTime    = -1;
    __CLR3_3_0ododi96a0zor.R.inc(885);maxPlayingTime    = -1;
    __CLR3_3_0ododi96a0zor.R.inc(886);imageURL          = null;
    __CLR3_3_0ododi96a0zor.R.inc(887);imageThumbnailURL = null;
    __CLR3_3_0ododi96a0zor.R.inc(888);description       = null;
    
    __CLR3_3_0ododi96a0zor.R.inc(889);primaryPublisher  = null;
    __CLR3_3_0ododi96a0zor.R.inc(890);publishers        = null;
    __CLR3_3_0ododi96a0zor.R.inc(891);designers         = null;
    __CLR3_3_0ododi96a0zor.R.inc(892);categories        = null;
    __CLR3_3_0ododi96a0zor.R.inc(893);mechanisms        = null;

    __CLR3_3_0ododi96a0zor.R.inc(894);expansionIDs      = null;
    __CLR3_3_0ododi96a0zor.R.inc(895);parentGameID      = -1;
    __CLR3_3_0ododi96a0zor.R.inc(896);gameType          = null;
    
    __CLR3_3_0ododi96a0zor.R.inc(897);addDate           = null;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}
  
  public Game(String jsonString) {
    super();__CLR3_3_0ododi96a0zor.R.inc(899);try{__CLR3_3_0ododi96a0zor.R.inc(898);
    __CLR3_3_0ododi96a0zor.R.inc(900);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0ododi96a0zor.R.inc(901);try {
      __CLR3_3_0ododi96a0zor.R.inc(902);Game jsonData = mapper.readValue(jsonString, Game.class);
      __CLR3_3_0ododi96a0zor.R.inc(903);gameID            = jsonData.gameID;
      __CLR3_3_0ododi96a0zor.R.inc(904);bggID             = jsonData.bggID;
      __CLR3_3_0ododi96a0zor.R.inc(905);name              = jsonData.name;
      __CLR3_3_0ododi96a0zor.R.inc(906);yearPublished     = jsonData.yearPublished;
      __CLR3_3_0ododi96a0zor.R.inc(907);minPlayers        = jsonData.minPlayers;
      __CLR3_3_0ododi96a0zor.R.inc(908);maxPlayers        = jsonData.maxPlayers;
      __CLR3_3_0ododi96a0zor.R.inc(909);minPlayingTime    = jsonData.minPlayingTime;
      __CLR3_3_0ododi96a0zor.R.inc(910);maxPlayingTime    = jsonData.maxPlayingTime;
      __CLR3_3_0ododi96a0zor.R.inc(911);imageURL          = jsonData.imageURL;
      __CLR3_3_0ododi96a0zor.R.inc(912);imageThumbnailURL = jsonData.imageThumbnailURL;
      __CLR3_3_0ododi96a0zor.R.inc(913);description       = jsonData.description;
      
      __CLR3_3_0ododi96a0zor.R.inc(914);primaryPublisher  = jsonData.primaryPublisher;
      __CLR3_3_0ododi96a0zor.R.inc(915);publishers        = jsonData.publishers;
      __CLR3_3_0ododi96a0zor.R.inc(916);designers         = jsonData.designers;
      __CLR3_3_0ododi96a0zor.R.inc(917);categories        = jsonData.categories;
      __CLR3_3_0ododi96a0zor.R.inc(918);mechanisms        = jsonData.categories;

      __CLR3_3_0ododi96a0zor.R.inc(919);expansionIDs      = jsonData.expansionIDs;
      __CLR3_3_0ododi96a0zor.R.inc(920);parentGameID      = jsonData.parentGameID;
      __CLR3_3_0ododi96a0zor.R.inc(921);gameType          = jsonData.gameType;
      
      __CLR3_3_0ododi96a0zor.R.inc(922);addDate           = jsonData.addDate;
    } catch (JsonParseException jpe) {
      __CLR3_3_0ododi96a0zor.R.inc(923);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0ododi96a0zor.R.inc(924);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0ododi96a0zor.R.inc(925);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * Debug Helper to dump out the contents of this object
   */
  public void printContentsForDebug() {try{__CLR3_3_0ododi96a0zor.R.inc(926);
    __CLR3_3_0ododi96a0zor.R.inc(927);System.out.println ("Printing contents for Game ID " + getGameID());
    __CLR3_3_0ododi96a0zor.R.inc(928);System.out.println ("============================================================");
    __CLR3_3_0ododi96a0zor.R.inc(929);System.out.println ("BoardGameGeek ID:    " + getBggID());
    __CLR3_3_0ododi96a0zor.R.inc(930);System.out.println ("Name:                " + getName());
    __CLR3_3_0ododi96a0zor.R.inc(931);System.out.println ("Year Published:      " + getYearPublished());
    __CLR3_3_0ododi96a0zor.R.inc(932);System.out.println ("Players:             " + getMinPlayers() + " - " + getMaxPlayers());
    __CLR3_3_0ododi96a0zor.R.inc(933);System.out.println ("Playing Time:        " + getMinPlayingTime() + " - " + getMaxPlayingTime());
    __CLR3_3_0ododi96a0zor.R.inc(934);System.out.println ("Image URL:           " + getImageURL());
    __CLR3_3_0ododi96a0zor.R.inc(935);System.out.println ("Image Thumbnail URL: " + getImageThumbnailURL());
    __CLR3_3_0ododi96a0zor.R.inc(936);System.out.println ("Description:         " + getDescription());

    __CLR3_3_0ododi96a0zor.R.inc(937);System.out.println ("Primary Publisher:   " + getPrimaryPublisher());
    __CLR3_3_0ododi96a0zor.R.inc(938);if ((((getPublishers() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(939)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(940)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(941);System.out.println ("Publishers:          [" + publishers.size() + "]");
      __CLR3_3_0ododi96a0zor.R.inc(942);for (String publisher : publishers)
        {__CLR3_3_0ododi96a0zor.R.inc(943);System.out.println ("                     " + publisher);
    }} }else     {__CLR3_3_0ododi96a0zor.R.inc(944);System.out.println ("Publishers:          [-]");

    }__CLR3_3_0ododi96a0zor.R.inc(945);if ((((getDesigners() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(946)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(947)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(948);System.out.println ("Designers:           [" + designers.size() + "]");
      __CLR3_3_0ododi96a0zor.R.inc(949);for (String designer : designers)
        {__CLR3_3_0ododi96a0zor.R.inc(950);System.out.println ("                     " + designer);
    }} }else     {__CLR3_3_0ododi96a0zor.R.inc(951);System.out.println ("Designers:           [-]");

    }__CLR3_3_0ododi96a0zor.R.inc(952);if ((((getCategories() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(953)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(954)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(955);System.out.println ("Categories:          [" + categories.size() + "]");
      __CLR3_3_0ododi96a0zor.R.inc(956);for (String category : categories)
        {__CLR3_3_0ododi96a0zor.R.inc(957);System.out.println ("                     " + category);
    }} }else     {__CLR3_3_0ododi96a0zor.R.inc(958);System.out.println ("Categories:          [-]");

    }__CLR3_3_0ododi96a0zor.R.inc(959);if ((((getMechanisms() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(960)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(961)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(962);System.out.println ("Mechanisms:          [" + mechanisms.size() + "]");
      __CLR3_3_0ododi96a0zor.R.inc(963);for (String mechanism : mechanisms)
        {__CLR3_3_0ododi96a0zor.R.inc(964);System.out.println ("                     " + mechanism);
    }} }else     {__CLR3_3_0ododi96a0zor.R.inc(965);System.out.println ("Mechanisms:          [-]");

    }boolean __CLB3_3_0_bool0=false;__CLR3_3_0ododi96a0zor.R.inc(966);switch (getGameType()) {
      case BASE        :if (!__CLB3_3_0_bool0) {__CLR3_3_0ododi96a0zor.R.inc(967);__CLB3_3_0_bool0=true;} __CLR3_3_0ododi96a0zor.R.inc(968);System.out.println ("Game Type:           Base");        __CLR3_3_0ododi96a0zor.R.inc(969);break;
      case EXPANSION   :if (!__CLB3_3_0_bool0) {__CLR3_3_0ododi96a0zor.R.inc(970);__CLB3_3_0_bool0=true;} __CLR3_3_0ododi96a0zor.R.inc(971);System.out.println ("Game Type:           Expansion");   __CLR3_3_0ododi96a0zor.R.inc(972);break;
      case COLLECTIBLE :if (!__CLB3_3_0_bool0) {__CLR3_3_0ododi96a0zor.R.inc(973);__CLB3_3_0_bool0=true;} __CLR3_3_0ododi96a0zor.R.inc(974);System.out.println ("Game Type:           Collectible"); __CLR3_3_0ododi96a0zor.R.inc(975);break;
      default :if (!__CLB3_3_0_bool0) {__CLR3_3_0ododi96a0zor.R.inc(976);__CLB3_3_0_bool0=true;} __CLR3_3_0ododi96a0zor.R.inc(977);System.out.println ("Game Type:           Undefined");
    }
    
    __CLR3_3_0ododi96a0zor.R.inc(978);if ((((getGameType() == GameType.BASE)&&(__CLR3_3_0ododi96a0zor.R.iget(979)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(980)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(981);System.out.println ("Parent Game:         N/A");
      __CLR3_3_0ododi96a0zor.R.inc(982);if ((((getExpansionIDs() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(983)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(984)==0&false))) {{
        __CLR3_3_0ododi96a0zor.R.inc(985);System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        __CLR3_3_0ododi96a0zor.R.inc(986);for (Long expansion : expansionIDs)
          {__CLR3_3_0ododi96a0zor.R.inc(987);System.out.println ("                     " + expansion);
      }} }else     {__CLR3_3_0ododi96a0zor.R.inc(988);System.out.println ("Expansions:          [-]");
    }} }else {__CLR3_3_0ododi96a0zor.R.inc(989);if ((((gameType == GameType.COLLECTIBLE)&&(__CLR3_3_0ododi96a0zor.R.iget(990)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(991)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(992);System.out.println ("Parent Game:         N/A");
      __CLR3_3_0ododi96a0zor.R.inc(993);if ((((getExpansionIDs() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(994)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(995)==0&false))) {{
        __CLR3_3_0ododi96a0zor.R.inc(996);System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        __CLR3_3_0ododi96a0zor.R.inc(997);for (Long expansion : expansionIDs)
          {__CLR3_3_0ododi96a0zor.R.inc(998);System.out.println ("                     " + expansion);
      }} }else     {__CLR3_3_0ododi96a0zor.R.inc(999);System.out.println ("Expansions:          [-]");
    }} }else {__CLR3_3_0ododi96a0zor.R.inc(1000);if ((((gameType == GameType.EXPANSION)&&(__CLR3_3_0ododi96a0zor.R.iget(1001)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(1002)==0&false))) {{
      __CLR3_3_0ododi96a0zor.R.inc(1003);System.out.println ("Parent Game:         " + getParentGameID());
      __CLR3_3_0ododi96a0zor.R.inc(1004);System.out.println ("Expansions:          N/A");
    }
    
    }}}__CLR3_3_0ododi96a0zor.R.inc(1005);if ((((getAddDate() != null)&&(__CLR3_3_0ododi96a0zor.R.iget(1006)!=0|true))||(__CLR3_3_0ododi96a0zor.R.iget(1007)==0&false))) {__CLR3_3_0ododi96a0zor.R.inc(1008);System.out.println ("Add Date:            " + addDate); 
    }else                      {__CLR3_3_0ododi96a0zor.R.inc(1009);System.out.println ("Add Date:            [-]"); 
  }}finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the gameID
   */
  public long getGameID() {try{__CLR3_3_0ododi96a0zor.R.inc(1010);
    __CLR3_3_0ododi96a0zor.R.inc(1011);return gameID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param gameID the gameID to set
   */
  public void setGameID(long gameID) {try{__CLR3_3_0ododi96a0zor.R.inc(1012);
    __CLR3_3_0ododi96a0zor.R.inc(1013);this.gameID = gameID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the bggID
   */
  public long getBggID() {try{__CLR3_3_0ododi96a0zor.R.inc(1014);
    __CLR3_3_0ododi96a0zor.R.inc(1015);return bggID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {try{__CLR3_3_0ododi96a0zor.R.inc(1016);
    __CLR3_3_0ododi96a0zor.R.inc(1017);this.bggID = bggID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the name
   */
  public String getName() {try{__CLR3_3_0ododi96a0zor.R.inc(1018);
    __CLR3_3_0ododi96a0zor.R.inc(1019);return name;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param name the name to set
   */
  public void setName(String name) {try{__CLR3_3_0ododi96a0zor.R.inc(1020);
    __CLR3_3_0ododi96a0zor.R.inc(1021);this.name = name;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the yearPublished
   */
  public int getYearPublished() {try{__CLR3_3_0ododi96a0zor.R.inc(1022);
    __CLR3_3_0ododi96a0zor.R.inc(1023);return yearPublished;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param yearPublished the yearPublished to set
   */
  public void setYearPublished(int yearPublished) {try{__CLR3_3_0ododi96a0zor.R.inc(1024);
    __CLR3_3_0ododi96a0zor.R.inc(1025);this.yearPublished = yearPublished;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the minPlayers
   */
  public int getMinPlayers() {try{__CLR3_3_0ododi96a0zor.R.inc(1026);
    __CLR3_3_0ododi96a0zor.R.inc(1027);return minPlayers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param minPlayers the minPlayers to set
   */
  public void setMinPlayers(int minPlayers) {try{__CLR3_3_0ododi96a0zor.R.inc(1028);
    __CLR3_3_0ododi96a0zor.R.inc(1029);this.minPlayers = minPlayers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the maxPlayers
   */
  public int getMaxPlayers() {try{__CLR3_3_0ododi96a0zor.R.inc(1030);
    __CLR3_3_0ododi96a0zor.R.inc(1031);return maxPlayers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param maxPlayers the maxPlayers to set
   */
  public void setMaxPlayers(int maxPlayers) {try{__CLR3_3_0ododi96a0zor.R.inc(1032);
    __CLR3_3_0ododi96a0zor.R.inc(1033);this.maxPlayers = maxPlayers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the minPlayingTime
   */
  public int getMinPlayingTime() {try{__CLR3_3_0ododi96a0zor.R.inc(1034);
    __CLR3_3_0ododi96a0zor.R.inc(1035);return minPlayingTime;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param minPlayingTime the minPlayingTime to set
   */
  public void setMinPlayingTime(int minPlayingTime) {try{__CLR3_3_0ododi96a0zor.R.inc(1036);
    __CLR3_3_0ododi96a0zor.R.inc(1037);this.minPlayingTime = minPlayingTime;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the maxPlayingTime
   */
  public int getMaxPlayingTime() {try{__CLR3_3_0ododi96a0zor.R.inc(1038);
    __CLR3_3_0ododi96a0zor.R.inc(1039);return maxPlayingTime;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param maxPlayingTime the maxPlayingTime to set
   */
  public void setMaxPlayingTime(int maxPlayingTime) {try{__CLR3_3_0ododi96a0zor.R.inc(1040);
    __CLR3_3_0ododi96a0zor.R.inc(1041);this.maxPlayingTime = maxPlayingTime;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the imageURL
   */
  public String getImageURL() {try{__CLR3_3_0ododi96a0zor.R.inc(1042);
    __CLR3_3_0ododi96a0zor.R.inc(1043);return imageURL;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {try{__CLR3_3_0ododi96a0zor.R.inc(1044);
    __CLR3_3_0ododi96a0zor.R.inc(1045);this.imageURL = imageURL;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the imageThumbnailURL
   */
  public String getImageThumbnailURL() {try{__CLR3_3_0ododi96a0zor.R.inc(1046);
    __CLR3_3_0ododi96a0zor.R.inc(1047);return imageThumbnailURL;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param imageThumbnailURL the imageThumbnailURL to set
   */
  public void setImageThumbnailURL(String imageThumbnailURL) {try{__CLR3_3_0ododi96a0zor.R.inc(1048);
    __CLR3_3_0ododi96a0zor.R.inc(1049);this.imageThumbnailURL = imageThumbnailURL;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the description
   */
  public String getDescription() {try{__CLR3_3_0ododi96a0zor.R.inc(1050);
    __CLR3_3_0ododi96a0zor.R.inc(1051);return description;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {try{__CLR3_3_0ododi96a0zor.R.inc(1052);
    __CLR3_3_0ododi96a0zor.R.inc(1053);this.description = description;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the primaryPublisher
   */
  public String getPrimaryPublisher() {try{__CLR3_3_0ododi96a0zor.R.inc(1054);
    __CLR3_3_0ododi96a0zor.R.inc(1055);return primaryPublisher;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param primaryPublisher the primaryPublisher to set
   */
  public void setPrimaryPublisher(String primaryPublisher) {try{__CLR3_3_0ododi96a0zor.R.inc(1056);
    __CLR3_3_0ododi96a0zor.R.inc(1057);this.primaryPublisher = primaryPublisher;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the publishers
   */
  public List<String> getPublishers() {try{__CLR3_3_0ododi96a0zor.R.inc(1058);
    __CLR3_3_0ododi96a0zor.R.inc(1059);return publishers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param publishers the publishers to set
   */
  public void setPublishers(List<String> publishers) {try{__CLR3_3_0ododi96a0zor.R.inc(1060);
    __CLR3_3_0ododi96a0zor.R.inc(1061);this.publishers = publishers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the designers
   */
  public List<String> getDesigners() {try{__CLR3_3_0ododi96a0zor.R.inc(1062);
    __CLR3_3_0ododi96a0zor.R.inc(1063);return designers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param designers the designers to set
   */
  public void setDesigners(List<String> designers) {try{__CLR3_3_0ododi96a0zor.R.inc(1064);
    __CLR3_3_0ododi96a0zor.R.inc(1065);this.designers = designers;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the categories
   */
  public List<String> getCategories() {try{__CLR3_3_0ododi96a0zor.R.inc(1066);
    __CLR3_3_0ododi96a0zor.R.inc(1067);return categories;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param categories the categories to set
   */
  public void setCategories(List<String> categories) {try{__CLR3_3_0ododi96a0zor.R.inc(1068);
    __CLR3_3_0ododi96a0zor.R.inc(1069);this.categories = categories;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the mechanisms
   */
  public List<String> getMechanisms() {try{__CLR3_3_0ododi96a0zor.R.inc(1070);
    __CLR3_3_0ododi96a0zor.R.inc(1071);return mechanisms;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param mechanisms the mechanisms to set
   */
  public void setMechanisms(List<String> mechanisms) {try{__CLR3_3_0ododi96a0zor.R.inc(1072);
    __CLR3_3_0ododi96a0zor.R.inc(1073);this.mechanisms = mechanisms;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the expansionIDs
   */
  public List<Long> getExpansionIDs() {try{__CLR3_3_0ododi96a0zor.R.inc(1074);
    __CLR3_3_0ododi96a0zor.R.inc(1075);return expansionIDs;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param expansionIDs the expansionIDs to set
   */
  public void setExpansionIDs(List<Long> expansionIDs) {try{__CLR3_3_0ododi96a0zor.R.inc(1076);
    __CLR3_3_0ododi96a0zor.R.inc(1077);this.expansionIDs = expansionIDs;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the parentGameID
   */
  public long getParentGameID() {try{__CLR3_3_0ododi96a0zor.R.inc(1078);
    __CLR3_3_0ododi96a0zor.R.inc(1079);return parentGameID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param parentGameID the parentGameID to set
   */
  public void setParentGameID(long parentGameID) {try{__CLR3_3_0ododi96a0zor.R.inc(1080);
    __CLR3_3_0ododi96a0zor.R.inc(1081);this.parentGameID = parentGameID;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the gameType
   */
  public GameType getGameType() {try{__CLR3_3_0ododi96a0zor.R.inc(1082);
    __CLR3_3_0ododi96a0zor.R.inc(1083);return gameType;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param gameType the gameType to set
   */
  public void setGameType(GameType gameType) {try{__CLR3_3_0ododi96a0zor.R.inc(1084);
    __CLR3_3_0ododi96a0zor.R.inc(1085);this.gameType = gameType;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @return the addDate
   */
  public Date getAddDate() {try{__CLR3_3_0ododi96a0zor.R.inc(1086);
    __CLR3_3_0ododi96a0zor.R.inc(1087);return addDate;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

  /**
   * @param addDate the addDate to set
   */
  public void setAddDate(Date addDate) {try{__CLR3_3_0ododi96a0zor.R.inc(1088);
    __CLR3_3_0ododi96a0zor.R.inc(1089);this.addDate = addDate;
  }finally{__CLR3_3_0ododi96a0zor.R.flushNeeded();}}

}
