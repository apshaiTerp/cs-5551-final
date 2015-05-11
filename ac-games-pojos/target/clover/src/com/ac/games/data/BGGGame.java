/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a POJO representing the basic information read from the BoardGameGeek XML API.
 * 
 * @author ac010168
 */
@java.lang.SuppressWarnings({"fallthrough"}) @JsonIgnoreProperties(ignoreUnknown = true)
public class BGGGame {public static class __CLR3_3_000i96a0zh1{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,260,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
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
  
  /** The game ranking from bgg.  This will change from time to time */
  private double bggRating;
  /** The number of users who contributed to the rankings on bgg.  This will also change from time to time */
  private int bggRatingUsers;
  
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
  
  //**********  The following values are only situationally defined  **********
  /** This is only defined for BASE (or COLLECTIBLE) games. */
  private int bggRank;
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

  //**********  These are fields to help with the data review  **********
  /** Flag to help us know the review state of this object */
  private ReviewState reviewState;
  /** Date this record was added to the system */
  private Date addDate;
  /** Date this record was reviewed */
  private Date reviewDate;
  
  /**
   * Some games can have a ranking, but haven't been ranked yet (not yet released titles).
   * This is to help us identify that category.
   */
  public final static int NOT_RANKED_RANKING = -999;
  
  /**
   * Basic Constructor.  Default all values to nulls or -1.
   */
  public BGGGame() {try{__CLR3_3_000i96a0zh1.R.inc(0);
    __CLR3_3_000i96a0zh1.R.inc(1);bggID             = -1L;
    __CLR3_3_000i96a0zh1.R.inc(2);name              = null;
    __CLR3_3_000i96a0zh1.R.inc(3);yearPublished     = -1;
    __CLR3_3_000i96a0zh1.R.inc(4);minPlayers        = -1;
    __CLR3_3_000i96a0zh1.R.inc(5);maxPlayers        = -1;
    __CLR3_3_000i96a0zh1.R.inc(6);minPlayingTime    = -1;
    __CLR3_3_000i96a0zh1.R.inc(7);maxPlayingTime    = -1;
    __CLR3_3_000i96a0zh1.R.inc(8);imageURL          = null;
    __CLR3_3_000i96a0zh1.R.inc(9);imageThumbnailURL = null;
    __CLR3_3_000i96a0zh1.R.inc(10);description       = null;
    
    __CLR3_3_000i96a0zh1.R.inc(11);bggRating         = -1.0;
    __CLR3_3_000i96a0zh1.R.inc(12);bggRatingUsers    = -1;
    
    __CLR3_3_000i96a0zh1.R.inc(13);publishers        = null;
    __CLR3_3_000i96a0zh1.R.inc(14);designers         = null;
    __CLR3_3_000i96a0zh1.R.inc(15);categories        = null;
    __CLR3_3_000i96a0zh1.R.inc(16);mechanisms        = null;
    
    __CLR3_3_000i96a0zh1.R.inc(17);bggRank           = -1;
    __CLR3_3_000i96a0zh1.R.inc(18);expansionIDs      = null;
    __CLR3_3_000i96a0zh1.R.inc(19);parentGameID      = -1;
    __CLR3_3_000i96a0zh1.R.inc(20);gameType          = null;
    
    __CLR3_3_000i96a0zh1.R.inc(21);reviewState       = null;
    __CLR3_3_000i96a0zh1.R.inc(22);addDate           = null;
    __CLR3_3_000i96a0zh1.R.inc(23);reviewDate        = null;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}
  
  public BGGGame(String jsonString) {
    super();__CLR3_3_000i96a0zh1.R.inc(25);try{__CLR3_3_000i96a0zh1.R.inc(24);
    __CLR3_3_000i96a0zh1.R.inc(26);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_000i96a0zh1.R.inc(27);try {
      __CLR3_3_000i96a0zh1.R.inc(28);BGGGame game = mapper.readValue(jsonString, BGGGame.class);
      __CLR3_3_000i96a0zh1.R.inc(29);bggID             = game.bggID;
      __CLR3_3_000i96a0zh1.R.inc(30);name              = game.name;
      __CLR3_3_000i96a0zh1.R.inc(31);yearPublished     = game.yearPublished;
      __CLR3_3_000i96a0zh1.R.inc(32);minPlayers        = game.minPlayers;
      __CLR3_3_000i96a0zh1.R.inc(33);maxPlayers        = game.minPlayers;
      __CLR3_3_000i96a0zh1.R.inc(34);minPlayingTime    = game.minPlayingTime;
      __CLR3_3_000i96a0zh1.R.inc(35);maxPlayingTime    = game.maxPlayingTime;
      __CLR3_3_000i96a0zh1.R.inc(36);imageURL          = game.imageURL;
      __CLR3_3_000i96a0zh1.R.inc(37);imageThumbnailURL = game.imageThumbnailURL;
      __CLR3_3_000i96a0zh1.R.inc(38);description       = game.description;
      
      __CLR3_3_000i96a0zh1.R.inc(39);bggRating         = game.bggRating;
      __CLR3_3_000i96a0zh1.R.inc(40);bggRatingUsers    = game.bggRatingUsers;
      
      __CLR3_3_000i96a0zh1.R.inc(41);publishers        = game.publishers;
      __CLR3_3_000i96a0zh1.R.inc(42);designers         = game.designers;
      __CLR3_3_000i96a0zh1.R.inc(43);categories        = game.categories;
      __CLR3_3_000i96a0zh1.R.inc(44);mechanisms        = game.mechanisms;
      
      __CLR3_3_000i96a0zh1.R.inc(45);bggRank           = game.bggRank;
      __CLR3_3_000i96a0zh1.R.inc(46);expansionIDs      = game.expansionIDs;
      __CLR3_3_000i96a0zh1.R.inc(47);parentGameID      = game.parentGameID;
      __CLR3_3_000i96a0zh1.R.inc(48);gameType          = game.gameType;
      
      __CLR3_3_000i96a0zh1.R.inc(49);reviewState       = game.reviewState;
      __CLR3_3_000i96a0zh1.R.inc(50);addDate           = game.addDate;
      __CLR3_3_000i96a0zh1.R.inc(51);reviewDate        = game.reviewDate;
    } catch (JsonParseException jpe) {
      __CLR3_3_000i96a0zh1.R.inc(52);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_000i96a0zh1.R.inc(53);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_000i96a0zh1.R.inc(54);ioe.printStackTrace();
    }
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}
  
  /**
   * Debug Helper to dump out the contents of this object
   */
  public void printContentsForDebug() {try{__CLR3_3_000i96a0zh1.R.inc(55);
    __CLR3_3_000i96a0zh1.R.inc(56);System.out.println ("Printing contents for Game ID " + getBggID());
    __CLR3_3_000i96a0zh1.R.inc(57);System.out.println ("============================================================");
    __CLR3_3_000i96a0zh1.R.inc(58);System.out.println ("Name:                " + getName());
    __CLR3_3_000i96a0zh1.R.inc(59);System.out.println ("Year Published:      " + getYearPublished());
    __CLR3_3_000i96a0zh1.R.inc(60);System.out.println ("Players:             " + getMinPlayers() + " - " + getMaxPlayers());
    __CLR3_3_000i96a0zh1.R.inc(61);System.out.println ("Playing Time:        " + getMinPlayingTime() + " - " + getMaxPlayingTime());
    __CLR3_3_000i96a0zh1.R.inc(62);System.out.println ("Image URL:           " + getImageURL());
    __CLR3_3_000i96a0zh1.R.inc(63);System.out.println ("Image Thumbnail URL: " + getImageThumbnailURL());
    __CLR3_3_000i96a0zh1.R.inc(64);System.out.println ("Description:         " + getDescription());
    __CLR3_3_000i96a0zh1.R.inc(65);System.out.println ("BGG Rating:          " + getBggRating() + " (Rated by " + getBggRatingUsers() + ")");

    __CLR3_3_000i96a0zh1.R.inc(66);if ((((getPublishers() != null)&&(__CLR3_3_000i96a0zh1.R.iget(67)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(68)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(69);System.out.println ("Publishers:          [" + publishers.size() + "]");
      __CLR3_3_000i96a0zh1.R.inc(70);for (String publisher : publishers)
        {__CLR3_3_000i96a0zh1.R.inc(71);System.out.println ("                     " + publisher);
    }} }else     {__CLR3_3_000i96a0zh1.R.inc(72);System.out.println ("Publishers:          [-]");

    }__CLR3_3_000i96a0zh1.R.inc(73);if ((((getDesigners() != null)&&(__CLR3_3_000i96a0zh1.R.iget(74)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(75)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(76);System.out.println ("Designers:           [" + designers.size() + "]");
      __CLR3_3_000i96a0zh1.R.inc(77);for (String designer : designers)
        {__CLR3_3_000i96a0zh1.R.inc(78);System.out.println ("                     " + designer);
    }} }else     {__CLR3_3_000i96a0zh1.R.inc(79);System.out.println ("Designers:           [-]");

    }__CLR3_3_000i96a0zh1.R.inc(80);if ((((getCategories() != null)&&(__CLR3_3_000i96a0zh1.R.iget(81)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(82)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(83);System.out.println ("Categories:          [" + categories.size() + "]");
      __CLR3_3_000i96a0zh1.R.inc(84);for (String category : categories)
        {__CLR3_3_000i96a0zh1.R.inc(85);System.out.println ("                     " + category);
    }} }else     {__CLR3_3_000i96a0zh1.R.inc(86);System.out.println ("Categories:          [-]");

    }__CLR3_3_000i96a0zh1.R.inc(87);if ((((getMechanisms() != null)&&(__CLR3_3_000i96a0zh1.R.iget(88)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(89)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(90);System.out.println ("Mechanisms:          [" + mechanisms.size() + "]");
      __CLR3_3_000i96a0zh1.R.inc(91);for (String mechanism : mechanisms)
        {__CLR3_3_000i96a0zh1.R.inc(92);System.out.println ("                     " + mechanism);
    }} }else     {__CLR3_3_000i96a0zh1.R.inc(93);System.out.println ("Mechanisms:          [-]");

    }boolean __CLB3_3_0_bool0=false;__CLR3_3_000i96a0zh1.R.inc(94);switch (getGameType()) {
      case BASE        :if (!__CLB3_3_0_bool0) {__CLR3_3_000i96a0zh1.R.inc(95);__CLB3_3_0_bool0=true;} __CLR3_3_000i96a0zh1.R.inc(96);System.out.println ("Game Type:           Base");        __CLR3_3_000i96a0zh1.R.inc(97);break;
      case EXPANSION   :if (!__CLB3_3_0_bool0) {__CLR3_3_000i96a0zh1.R.inc(98);__CLB3_3_0_bool0=true;} __CLR3_3_000i96a0zh1.R.inc(99);System.out.println ("Game Type:           Expansion");   __CLR3_3_000i96a0zh1.R.inc(100);break;
      case COLLECTIBLE :if (!__CLB3_3_0_bool0) {__CLR3_3_000i96a0zh1.R.inc(101);__CLB3_3_0_bool0=true;} __CLR3_3_000i96a0zh1.R.inc(102);System.out.println ("Game Type:           Collectible"); __CLR3_3_000i96a0zh1.R.inc(103);break;
      default :if (!__CLB3_3_0_bool0) {__CLR3_3_000i96a0zh1.R.inc(104);__CLB3_3_0_bool0=true;} __CLR3_3_000i96a0zh1.R.inc(105);System.out.println ("Game Type:           Undefined");
    }
    
    __CLR3_3_000i96a0zh1.R.inc(106);if ((((getGameType() == GameType.BASE)&&(__CLR3_3_000i96a0zh1.R.iget(107)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(108)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(109);System.out.println ("bggRank:             " + (((((getBggRank() == NOT_RANKED_RANKING) )&&(__CLR3_3_000i96a0zh1.R.iget(110)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(111)==0&false))? "Not Ranked" : getBggRank()));
      __CLR3_3_000i96a0zh1.R.inc(112);System.out.println ("Parent Game:         N/A");
      __CLR3_3_000i96a0zh1.R.inc(113);if ((((getExpansionIDs() != null)&&(__CLR3_3_000i96a0zh1.R.iget(114)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(115)==0&false))) {{
        __CLR3_3_000i96a0zh1.R.inc(116);System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        __CLR3_3_000i96a0zh1.R.inc(117);for (Long expansion : expansionIDs)
          {__CLR3_3_000i96a0zh1.R.inc(118);System.out.println ("                     " + expansion);
      }} }else     {__CLR3_3_000i96a0zh1.R.inc(119);System.out.println ("Expansions:          [-]");
    }} }else {__CLR3_3_000i96a0zh1.R.inc(120);if ((((gameType == GameType.COLLECTIBLE)&&(__CLR3_3_000i96a0zh1.R.iget(121)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(122)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(123);System.out.println ("bggRank:             " + (((((getBggRank() == NOT_RANKED_RANKING) )&&(__CLR3_3_000i96a0zh1.R.iget(124)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(125)==0&false))? "Not Ranked" : getBggRank()));
      __CLR3_3_000i96a0zh1.R.inc(126);System.out.println ("Parent Game:         N/A");
      __CLR3_3_000i96a0zh1.R.inc(127);if ((((getExpansionIDs() != null)&&(__CLR3_3_000i96a0zh1.R.iget(128)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(129)==0&false))) {{
        __CLR3_3_000i96a0zh1.R.inc(130);System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        __CLR3_3_000i96a0zh1.R.inc(131);for (Long expansion : expansionIDs)
          {__CLR3_3_000i96a0zh1.R.inc(132);System.out.println ("                     " + expansion);
      }} }else     {__CLR3_3_000i96a0zh1.R.inc(133);System.out.println ("Expansions:          [-]");
    }} }else {__CLR3_3_000i96a0zh1.R.inc(134);if ((((gameType == GameType.EXPANSION)&&(__CLR3_3_000i96a0zh1.R.iget(135)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(136)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(137);System.out.println ("bggRank:             N/A");
      __CLR3_3_000i96a0zh1.R.inc(138);System.out.println ("Parent Game:         " + getParentGameID());
      __CLR3_3_000i96a0zh1.R.inc(139);System.out.println ("Expansions:          N/A");
    }
    
    }}}__CLR3_3_000i96a0zh1.R.inc(140);if ((((getReviewState() == null)&&(__CLR3_3_000i96a0zh1.R.iget(141)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(142)==0&false))) {{
      __CLR3_3_000i96a0zh1.R.inc(143);System.out.println ("Review State:        [-]");
    } }else {{
      boolean __CLB3_3_0_bool1=false;__CLR3_3_000i96a0zh1.R.inc(144);switch (reviewState) {
        case PENDING  :if (!__CLB3_3_0_bool1) {__CLR3_3_000i96a0zh1.R.inc(145);__CLB3_3_0_bool1=true;} __CLR3_3_000i96a0zh1.R.inc(146);System.out.println ("Review State:        Pending");  __CLR3_3_000i96a0zh1.R.inc(147);break;
        case REVIEWED :if (!__CLB3_3_0_bool1) {__CLR3_3_000i96a0zh1.R.inc(148);__CLB3_3_0_bool1=true;} __CLR3_3_000i96a0zh1.R.inc(149);System.out.println ("Review State:        Reviewed"); __CLR3_3_000i96a0zh1.R.inc(150);break;
        case REJECTED :if (!__CLB3_3_0_bool1) {__CLR3_3_000i96a0zh1.R.inc(151);__CLB3_3_0_bool1=true;} __CLR3_3_000i96a0zh1.R.inc(152);System.out.println ("Review State:        Rejected"); __CLR3_3_000i96a0zh1.R.inc(153);break;
      }
    }
    }__CLR3_3_000i96a0zh1.R.inc(154);if ((((getAddDate() != null)&&(__CLR3_3_000i96a0zh1.R.iget(155)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(156)==0&false))) {__CLR3_3_000i96a0zh1.R.inc(157);System.out.println ("Add Date:            " + addDate); 
    }else                      {__CLR3_3_000i96a0zh1.R.inc(158);System.out.println ("Add Date:            [-]"); 
    }__CLR3_3_000i96a0zh1.R.inc(159);if ((((getReviewDate() != null)&&(__CLR3_3_000i96a0zh1.R.iget(160)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(161)==0&false))) {__CLR3_3_000i96a0zh1.R.inc(162);System.out.println ("Review Date:         " + reviewDate); 
    }else                         {__CLR3_3_000i96a0zh1.R.inc(163);System.out.println ("Review Date:         [-]"); 
  }}finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}
  
  /**
   * @return the bggID
   */
  public long getBggID() {try{__CLR3_3_000i96a0zh1.R.inc(164);
    __CLR3_3_000i96a0zh1.R.inc(165);return bggID;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {try{__CLR3_3_000i96a0zh1.R.inc(166);
    __CLR3_3_000i96a0zh1.R.inc(167);this.bggID = bggID;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the name
   */
  public String getName() {try{__CLR3_3_000i96a0zh1.R.inc(168);
    __CLR3_3_000i96a0zh1.R.inc(169);return name;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param name the name to set
   */
  public void setName(String name) {try{__CLR3_3_000i96a0zh1.R.inc(170);
    __CLR3_3_000i96a0zh1.R.inc(171);this.name = name;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the yearPublished
   */
  public int getYearPublished() {try{__CLR3_3_000i96a0zh1.R.inc(172);
    __CLR3_3_000i96a0zh1.R.inc(173);return yearPublished;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param yearPublished the yearPublished to set
   */
  public void setYearPublished(int yearPublished) {try{__CLR3_3_000i96a0zh1.R.inc(174);
    __CLR3_3_000i96a0zh1.R.inc(175);this.yearPublished = yearPublished;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the minPlayers
   */
  public int getMinPlayers() {try{__CLR3_3_000i96a0zh1.R.inc(176);
    __CLR3_3_000i96a0zh1.R.inc(177);return minPlayers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param minPlayers the minPlayers to set
   */
  public void setMinPlayers(int minPlayers) {try{__CLR3_3_000i96a0zh1.R.inc(178);
    __CLR3_3_000i96a0zh1.R.inc(179);this.minPlayers = minPlayers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the maxPlayers
   */
  public int getMaxPlayers() {try{__CLR3_3_000i96a0zh1.R.inc(180);
    __CLR3_3_000i96a0zh1.R.inc(181);return maxPlayers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param maxPlayers the maxPlayers to set
   */
  public void setMaxPlayers(int maxPlayers) {try{__CLR3_3_000i96a0zh1.R.inc(182);
    __CLR3_3_000i96a0zh1.R.inc(183);this.maxPlayers = maxPlayers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the minPlayingTime
   */
  public int getMinPlayingTime() {try{__CLR3_3_000i96a0zh1.R.inc(184);
    __CLR3_3_000i96a0zh1.R.inc(185);return minPlayingTime;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param minPlayingTime the minPlayingTime to set
   */
  public void setMinPlayingTime(int minPlayingTime) {try{__CLR3_3_000i96a0zh1.R.inc(186);
    __CLR3_3_000i96a0zh1.R.inc(187);this.minPlayingTime = minPlayingTime;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the maxPlayingTime
   */
  public int getMaxPlayingTime() {try{__CLR3_3_000i96a0zh1.R.inc(188);
    __CLR3_3_000i96a0zh1.R.inc(189);return maxPlayingTime;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param maxPlayingTime the maxPlayingTime to set
   */
  public void setMaxPlayingTime(int maxPlayingTime) {try{__CLR3_3_000i96a0zh1.R.inc(190);
    __CLR3_3_000i96a0zh1.R.inc(191);this.maxPlayingTime = maxPlayingTime;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the imageURL
   */
  public String getImageURL() {try{__CLR3_3_000i96a0zh1.R.inc(192);
    __CLR3_3_000i96a0zh1.R.inc(193);return imageURL;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {try{__CLR3_3_000i96a0zh1.R.inc(194);
    __CLR3_3_000i96a0zh1.R.inc(195);this.imageURL = imageURL;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the imageThumbnailURL
   */
  public String getImageThumbnailURL() {try{__CLR3_3_000i96a0zh1.R.inc(196);
    __CLR3_3_000i96a0zh1.R.inc(197);return imageThumbnailURL;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param imageThumbnailURL the imageThumbnailURL to set
   */
  public void setImageThumbnailURL(String imageThumbnailURL) {try{__CLR3_3_000i96a0zh1.R.inc(198);
    __CLR3_3_000i96a0zh1.R.inc(199);this.imageThumbnailURL = imageThumbnailURL;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the description
   */
  public String getDescription() {try{__CLR3_3_000i96a0zh1.R.inc(200);
    __CLR3_3_000i96a0zh1.R.inc(201);return description;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * We've added to this method to strip out line break characters and other HTML-encoded values.
   * We may need to add more as elements get discovered.
   * 
   * @param description the description to set
   */
  public void setDescription(String description) {try{__CLR3_3_000i96a0zh1.R.inc(202);
    __CLR3_3_000i96a0zh1.R.inc(203);if ((((description == null)&&(__CLR3_3_000i96a0zh1.R.iget(204)!=0|true))||(__CLR3_3_000i96a0zh1.R.iget(205)==0&false)))
      {__CLR3_3_000i96a0zh1.R.inc(206);this.description = description;
    }else {{
      __CLR3_3_000i96a0zh1.R.inc(207);this.description = description.replaceAll("<br/>", "\n").replaceAll("&mdash;", "-").trim();
    }
  }}finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the bggRating
   */
  public double getBggRating() {try{__CLR3_3_000i96a0zh1.R.inc(208);
    __CLR3_3_000i96a0zh1.R.inc(209);return bggRating;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param bggRating the bggRating to set
   */
  public void setBggRating(double bggRating) {try{__CLR3_3_000i96a0zh1.R.inc(210);
    __CLR3_3_000i96a0zh1.R.inc(211);this.bggRating = bggRating;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the bggRatingUsers
   */
  public int getBggRatingUsers() {try{__CLR3_3_000i96a0zh1.R.inc(212);
    __CLR3_3_000i96a0zh1.R.inc(213);return bggRatingUsers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param bggRatingUsers the bggRatingUsers to set
   */
  public void setBggRatingUsers(int bggRatingUsers) {try{__CLR3_3_000i96a0zh1.R.inc(214);
    __CLR3_3_000i96a0zh1.R.inc(215);this.bggRatingUsers = bggRatingUsers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the publishers
   */
  public List<String> getPublishers() {try{__CLR3_3_000i96a0zh1.R.inc(216);
    __CLR3_3_000i96a0zh1.R.inc(217);return publishers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param publishers the publishers to set
   */
  public void setPublishers(List<String> publishers) {try{__CLR3_3_000i96a0zh1.R.inc(218);
    __CLR3_3_000i96a0zh1.R.inc(219);this.publishers = publishers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the designers
   */
  public List<String> getDesigners() {try{__CLR3_3_000i96a0zh1.R.inc(220);
    __CLR3_3_000i96a0zh1.R.inc(221);return designers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param designers the designers to set
   */
  public void setDesigners(List<String> designers) {try{__CLR3_3_000i96a0zh1.R.inc(222);
    __CLR3_3_000i96a0zh1.R.inc(223);this.designers = designers;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the categories
   */
  public List<String> getCategories() {try{__CLR3_3_000i96a0zh1.R.inc(224);
    __CLR3_3_000i96a0zh1.R.inc(225);return categories;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param categories the categories to set
   */
  public void setCategories(List<String> categories) {try{__CLR3_3_000i96a0zh1.R.inc(226);
    __CLR3_3_000i96a0zh1.R.inc(227);this.categories = categories;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the mechanisms
   */
  public List<String> getMechanisms() {try{__CLR3_3_000i96a0zh1.R.inc(228);
    __CLR3_3_000i96a0zh1.R.inc(229);return mechanisms;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param mechanisms the mechanisms to set
   */
  public void setMechanisms(List<String> mechanisms) {try{__CLR3_3_000i96a0zh1.R.inc(230);
    __CLR3_3_000i96a0zh1.R.inc(231);this.mechanisms = mechanisms;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the bggRank
   */
  public int getBggRank() {try{__CLR3_3_000i96a0zh1.R.inc(232);
    __CLR3_3_000i96a0zh1.R.inc(233);return bggRank;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param bggRank the bggRank to set
   */
  public void setBggRank(int bggRank) {try{__CLR3_3_000i96a0zh1.R.inc(234);
    __CLR3_3_000i96a0zh1.R.inc(235);this.bggRank = bggRank;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the expansionIDs
   */
  public List<Long> getExpansionIDs() {try{__CLR3_3_000i96a0zh1.R.inc(236);
    __CLR3_3_000i96a0zh1.R.inc(237);return expansionIDs;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param expansionIDs the expansionIDs to set
   */
  public void setExpansionIDs(List<Long> expansionIDs) {try{__CLR3_3_000i96a0zh1.R.inc(238);
    __CLR3_3_000i96a0zh1.R.inc(239);this.expansionIDs = expansionIDs;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the parentGameID
   */
  public long getParentGameID() {try{__CLR3_3_000i96a0zh1.R.inc(240);
    __CLR3_3_000i96a0zh1.R.inc(241);return parentGameID;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param parentGameID the parentGameID to set
   */
  public void setParentGameID(long parentGameID) {try{__CLR3_3_000i96a0zh1.R.inc(242);
    __CLR3_3_000i96a0zh1.R.inc(243);this.parentGameID = parentGameID;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the gameType
   */
  public GameType getGameType() {try{__CLR3_3_000i96a0zh1.R.inc(244);
    __CLR3_3_000i96a0zh1.R.inc(245);return gameType;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param gameType the gameType to set
   */
  public void setGameType(GameType gameType) {try{__CLR3_3_000i96a0zh1.R.inc(246);
    __CLR3_3_000i96a0zh1.R.inc(247);this.gameType = gameType;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the reviewState
   */
  public ReviewState getReviewState() {try{__CLR3_3_000i96a0zh1.R.inc(248);
    __CLR3_3_000i96a0zh1.R.inc(249);return reviewState;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param reviewState the reviewState to set
   */
  public void setReviewState(ReviewState reviewState) {try{__CLR3_3_000i96a0zh1.R.inc(250);
    __CLR3_3_000i96a0zh1.R.inc(251);this.reviewState = reviewState;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the addDate
   */
  public Date getAddDate() {try{__CLR3_3_000i96a0zh1.R.inc(252);
    __CLR3_3_000i96a0zh1.R.inc(253);return addDate;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param addDate the addDate to set
   */
  public void setAddDate(Date addDate) {try{__CLR3_3_000i96a0zh1.R.inc(254);
    __CLR3_3_000i96a0zh1.R.inc(255);this.addDate = addDate;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @return the reviewDate
   */
  public Date getReviewDate() {try{__CLR3_3_000i96a0zh1.R.inc(256);
    __CLR3_3_000i96a0zh1.R.inc(257);return reviewDate;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}

  /**
   * @param reviewDate the reviewDate to set
   */
  public void setReviewDate(Date reviewDate) {try{__CLR3_3_000i96a0zh1.R.inc(258);
    __CLR3_3_000i96a0zh1.R.inc(259);this.reviewDate = reviewDate;
  }finally{__CLR3_3_000i96a0zh1.R.flushNeeded();}}
}
