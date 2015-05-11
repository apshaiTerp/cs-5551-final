/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.mock;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author ac010168
 * 
 * This class exists to mock up example XML output returned from the BGG XML API
 * so that we can simulate our parsing logic. 
 */
@java.lang.SuppressWarnings({"fallthrough"}) public class MockGameData {public static class __CLR3_3_01ym1ymi96a105a{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525634799L,8589935092L,2718,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  //This game tests the Collectible assignment
  public static final int BGG_MAGIC_THE_GATHERING = 0;
  //This game tests the Base game assignment (that has expansions)
  public static final int BGG_COSMIC_ENCOUNTER    = 1;
  //This game tests the Expansion assignment
  public static final int BGG_COSMIC_INCURSION    = 2;
  //This game tests the Base game assignment when the game is a standalone title (no expansions)
  public static final int BGG_ABYSS               = 3;
  //This game tests the Dice Masters game, which has not yet been released
  public static final int BGG_DC_DICE_MASTERS     = 4;
  //This game tests the return format of a game that doesn't exist
  public static final int BGG_NOT_FOUND           = 5;
  //This game boasts some incomplete data in the file
  public static final int BGG_53                  = 6;
  //This game boasts some incomplete data in the file
  public static final int BGG_1369                = 7;
  //This game boasts some incomplete data in the file
  public static final int BGG_1818                = 8;
  //This game tests a multiple list with all 20 rows
  public static final int BGG_12001_12020         = 9;
  //This game tests a multiple list with some rows missing
  public static final int BGG_BATCH_ALT           = 10;
  //This game batch tests a nested short <boardgame> entry in a game
  public static final int BGG_NESTED_18460        = 11;
  //This game batch tests a single game with many nested <boardgame> entries under a single game
  public static final int BGG_MULTINEST_29663     = 12;
  //This game tests having invalid or null stats data
  public static final int BGG_50968               = 13;
  
  //This game tests the In Stock lookup
  public static final int CSI_ABYSS               = 100;
  //This game tests the PreOrder lookup
  public static final int CSI_COSMIC_ENCOUNTER    = 101;
  //This game tests the Out of Stock lookup
  public static final int CSI_COSMIC_INCURSION    = 102;
  //This game tests the Out of Stock - Not yet accepting PreOrders lookup
  public static final int CSI_DC_DICE_MASTERS     = 103;
  //This game tests the return format of a game that doesn't exist
  public static final int CSI_NOT_FOUND           = 104;
  //This game is an early game that has incomplete information
  public static final int CSI_75069               = 105;
  //This game is an early game that has different information for availability
  public static final int CSI_76097               = 106;
  //This game is an early game that has missing information for availability
  public static final int CSI_94687               = 107;
  //This game tests the RPG category identification
  public static final int CSI_RPG                 = 108;
  //This game tests the LCG category identification
  public static final int CSI_LCG_NETRUNNER       = 109;
  //This game tests the supplies entries category
  public static final int CSI_SUPPLIES_SLEEVES    = 110;
  //This game tests the miniatures entries category
  public static final int CSI_MINIATURES          = 111;
  //This is some sort of weird gift certificate page
  public static final int CSI_GIFT_CERTIFICATE    = 112;
  //This game tests the video game category?
  public static final int CSI_VIDEO_GAME          = 113;
  
  //This game tests the In Stock lookup
  public static final int MM_ABYSS                = 200;
  //This game tests the Out of Stock lookup
  public static final int MM_COSMIC_ENCOUNTER     = 201;
  //This game also happens to be Out of Stock lookup
  public static final int MM_COSMIC_INCURSION     = 202;
  //This game is in a Pre-Order state and Out of Stock
  public static final int MM_DC_DICE_MASTERS      = 203;
  //This game is in a Pre-Order state and Orderable
  public static final int MM_XWING_IG2000         = 204;
  //This game tests the return format of a game that doesn't exist
  public static final int MM_NOT_FOUND            = 205;
  //This game tests incomplete data from MM
  public static final int MM_5137                 = 206;

  //This game tests the accessories category
  public static final int MM_ACCESSORIES          = 207;
  //This game tests the board games category
  public static final int MM_BOARDGAMES           = 208;
  //This game tests the CCGs category
  public static final int MM_CCGS                 = 209;
  //This game tests the Collectible Minis category
  public static final int MM_COLLECTIBLEMINIS     = 210;
  //This game tests the RPGs category
  public static final int MM_RPGS                 = 211;
  //This game tests the Table Top Minis category
  public static final int MM_TABLETOPMINIS        = 212;
  //This game tests inability to find a category and assign it to unknown
  public static final int MM_UNKNOWN              = 213;
  
  private final static MockGameData gameData = new MockGameData();
  
  public MockGameData() {try{__CLR3_3_01ym1ymi96a105a.R.inc(2542);}finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  /**
   * Generate Content String based on a corresponding XML file.
   * 
   * @param gameFlag Constant flag that helps determine which file to load.
   * @return A String representing the content block
   */
  public static String generateContentString(int gameFlag) {try{__CLR3_3_01ym1ymi96a105a.R.inc(2543);
    __CLR3_3_01ym1ymi96a105a.R.inc(2544);try {
      boolean __CLB3_3_0_bool0=false;__CLR3_3_01ym1ymi96a105a.R.inc(2545);switch (gameFlag) {
        case BGG_MAGIC_THE_GATHERING :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2546);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2547);return generateBggMagicTheGathering();
        case BGG_COSMIC_ENCOUNTER    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2548);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2549);return generateBggCosmicEncounter();
        case BGG_COSMIC_INCURSION    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2550);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2551);return generateBggCosmicIncursion();
        case BGG_ABYSS               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2552);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2553);return generateBggAbyss();
        case BGG_DC_DICE_MASTERS     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2554);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2555);return generateBggDCDiceMasters();
        case BGG_NOT_FOUND           :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2556);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2557);return generateBggNotFound();
        case BGG_53                  :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2558);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2559);return generateBgg53();
        case BGG_1369                :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2560);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2561);return generateBgg1369();
        case BGG_1818                :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2562);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2563);return generateBgg1818();
        case BGG_12001_12020         :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2564);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2565);return generateBgg12001_12020();
        case BGG_BATCH_ALT           :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2566);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2567);return generateBggBatchAlt();
        case BGG_NESTED_18460        :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2568);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2569);return generateBggNested18460();
        case BGG_MULTINEST_29663     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2570);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2571);return generateBggMultiNest29663();
        case BGG_50968               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2572);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2573);return generateBgg50968();
        case CSI_ABYSS               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2574);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2575);return generateCsiAbyss();
        case CSI_COSMIC_ENCOUNTER    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2576);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2577);return generateCsiCosmicEncounter();
        case CSI_COSMIC_INCURSION    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2578);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2579);return generateCsiCosmicIncursion();
        case CSI_DC_DICE_MASTERS     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2580);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2581);return generateCsiDCDiceMasters();
        case CSI_NOT_FOUND           :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2582);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2583);return generateCsiNotFound();
        case CSI_75069               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2584);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2585);return generateCsi75069();
        case CSI_76097               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2586);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2587);return generateCsi76097();
        case CSI_94687               :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2588);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2589);return generateCsi94687();
        case CSI_RPG                 :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2590);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2591);return generateCsiRPG();
        case CSI_LCG_NETRUNNER       :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2592);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2593);return generateCsiLCGNetrunner();
        case CSI_SUPPLIES_SLEEVES    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2594);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2595);return generateCsiSuppliesSleeves();
        case CSI_MINIATURES          :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2596);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2597);return generateCsiMiniatures();
        case CSI_GIFT_CERTIFICATE    :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2598);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2599);return generateCsiGiftCertificate();
        case CSI_VIDEO_GAME          :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2600);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2601);return generateCsiVideoGame();
        case MM_ABYSS                :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2602);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2603);return generateMMAbyss();
        case MM_COSMIC_ENCOUNTER     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2604);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2605);return generateMMCosmicEncounter();
        case MM_COSMIC_INCURSION     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2606);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2607);return generateMMCosmicIncursion();
        case MM_DC_DICE_MASTERS      :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2608);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2609);return generateMMDCDiceMasters();
        case MM_XWING_IG2000         :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2610);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2611);return generateMMXWingIG2000();
        case MM_NOT_FOUND            :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2612);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2613);return generateMMNotFound();
        case MM_5137                 :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2614);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2615);return generateMM5137();
        case MM_ACCESSORIES          :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2616);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2617);return generateMMAccessories();
        case MM_BOARDGAMES           :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2618);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2619);return generateMMBoardGames();
        case MM_CCGS                 :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2620);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2621);return generateMMCCGs();
        case MM_COLLECTIBLEMINIS     :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2622);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2623);return generateMMCollectibleMinis();
        case MM_RPGS                 :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2624);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2625);return generateMMRPGs();
        case MM_TABLETOPMINIS        :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2626);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2627);return generateMMTableTopMinis();
        case MM_UNKNOWN              :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2628);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2629);return generateMMUnknown();
        default :if (!__CLB3_3_0_bool0) {__CLR3_3_01ym1ymi96a105a.R.inc(2630);__CLB3_3_0_bool0=true;} __CLR3_3_01ym1ymi96a105a.R.inc(2631);return "";
      }
    } catch (IOException ioe) {
      __CLR3_3_01ym1ymi96a105a.R.inc(2632);ioe.printStackTrace();
      __CLR3_3_01ym1ymi96a105a.R.inc(2633);return "";
    }
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggMagicTheGathering() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2634);
    __CLR3_3_01ym1ymi96a105a.R.inc(2635);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_magicthegathering.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggCosmicEncounter() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2636);
    __CLR3_3_01ym1ymi96a105a.R.inc(2637);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_cosmicencounter.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateBggCosmicIncursion() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2638);
    __CLR3_3_01ym1ymi96a105a.R.inc(2639);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_cosmicincursion.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateBggAbyss() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2640);
    __CLR3_3_01ym1ymi96a105a.R.inc(2641);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_abyss.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggDCDiceMasters() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2642);
    __CLR3_3_01ym1ymi96a105a.R.inc(2643);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_dcdicemasters.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggNotFound() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2644);
    __CLR3_3_01ym1ymi96a105a.R.inc(2645);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_notfound.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBgg53() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2646);
    __CLR3_3_01ym1ymi96a105a.R.inc(2647);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_53.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBgg1369() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2648);
    __CLR3_3_01ym1ymi96a105a.R.inc(2649);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_1369.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBgg1818() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2650);
    __CLR3_3_01ym1ymi96a105a.R.inc(2651);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_1818.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBgg12001_12020() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2652);
    __CLR3_3_01ym1ymi96a105a.R.inc(2653);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_12001-12020.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateBggNested18460() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2654);
    __CLR3_3_01ym1ymi96a105a.R.inc(2655);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_nested_18460.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggBatchAlt() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2656);
    __CLR3_3_01ym1ymi96a105a.R.inc(2657);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_batch_alt.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBggMultiNest29663() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2658);
    __CLR3_3_01ym1ymi96a105a.R.inc(2659);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_multinest_29663.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateBgg50968() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2660);
    __CLR3_3_01ym1ymi96a105a.R.inc(2661);return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_50968.xml"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiAbyss() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2662);
    __CLR3_3_01ym1ymi96a105a.R.inc(2663);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_abyss.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateCsiCosmicEncounter() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2664);
    __CLR3_3_01ym1ymi96a105a.R.inc(2665);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_cosmicencounter.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateCsiCosmicIncursion() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2666);
    __CLR3_3_01ym1ymi96a105a.R.inc(2667);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_cosmicincursion.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateCsiDCDiceMasters() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2668);
    __CLR3_3_01ym1ymi96a105a.R.inc(2669);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_dcdicemasters.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiNotFound() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2670);
    __CLR3_3_01ym1ymi96a105a.R.inc(2671);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_notfound.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsi75069() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2672);
    __CLR3_3_01ym1ymi96a105a.R.inc(2673);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_75069.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsi76097() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2674);
    __CLR3_3_01ym1ymi96a105a.R.inc(2675);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_76097.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsi94687() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2676);
    __CLR3_3_01ym1ymi96a105a.R.inc(2677);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_94687.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiRPG() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2678);
    __CLR3_3_01ym1ymi96a105a.R.inc(2679);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_rpg.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiLCGNetrunner() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2680);
    __CLR3_3_01ym1ymi96a105a.R.inc(2681);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_lcg_netrunner.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiSuppliesSleeves() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2682);
    __CLR3_3_01ym1ymi96a105a.R.inc(2683);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_supplies_sleeves.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiMiniatures() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2684);
    __CLR3_3_01ym1ymi96a105a.R.inc(2685);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_miniatures.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiGiftCertificate() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2686);
    __CLR3_3_01ym1ymi96a105a.R.inc(2687);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_153126.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateCsiVideoGame() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2688);
    __CLR3_3_01ym1ymi96a105a.R.inc(2689);return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_videogames.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
   private static String generateMMAbyss() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2690);
    __CLR3_3_01ym1ymi96a105a.R.inc(2691);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_abyss.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMCosmicEncounter() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2692);
    __CLR3_3_01ym1ymi96a105a.R.inc(2693);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_cosmicencounter.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMCosmicIncursion() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2694);
    __CLR3_3_01ym1ymi96a105a.R.inc(2695);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_cosmicincursion.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMDCDiceMasters() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2696);
    __CLR3_3_01ym1ymi96a105a.R.inc(2697);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_dcdicemasters.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
  
  private static String generateMMXWingIG2000() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2698);
    __CLR3_3_01ym1ymi96a105a.R.inc(2699);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_xwingig2000.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMNotFound() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2700);
    __CLR3_3_01ym1ymi96a105a.R.inc(2701);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_notfound.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMM5137() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2702);
    __CLR3_3_01ym1ymi96a105a.R.inc(2703);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_5137.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMAccessories() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2704);
    __CLR3_3_01ym1ymi96a105a.R.inc(2705);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_accessories.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMBoardGames() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2706);
    __CLR3_3_01ym1ymi96a105a.R.inc(2707);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_boardgames.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMCCGs() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2708);
    __CLR3_3_01ym1ymi96a105a.R.inc(2709);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_ccgs.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMCollectibleMinis() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2710);
    __CLR3_3_01ym1ymi96a105a.R.inc(2711);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_collectibleminis.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMRPGs() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2712);
    __CLR3_3_01ym1ymi96a105a.R.inc(2713);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_rpgs.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMTableTopMinis() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2714);
    __CLR3_3_01ym1ymi96a105a.R.inc(2715);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_tabletopminis.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}

  private static String generateMMUnknown() throws IOException {try{__CLR3_3_01ym1ymi96a105a.R.inc(2716);
    __CLR3_3_01ym1ymi96a105a.R.inc(2717);return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_unknown.html"));
  }finally{__CLR3_3_01ym1ymi96a105a.R.flushNeeded();}}
}
