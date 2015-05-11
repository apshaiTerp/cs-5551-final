package com.ac.games.data.mock;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * @author ac010168
 * 
 * This class exists to mock up example XML output returned from the BGG XML API
 * so that we can simulate our parsing logic. 
 */
public class MockGameData {
  
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
  
  public MockGameData() {}
  
  /**
   * Generate Content String based on a corresponding XML file.
   * 
   * @param gameFlag Constant flag that helps determine which file to load.
   * @return A String representing the content block
   */
  public static String generateContentString(int gameFlag) {
    try {
      switch (gameFlag) {
        case BGG_MAGIC_THE_GATHERING : return generateBggMagicTheGathering();
        case BGG_COSMIC_ENCOUNTER    : return generateBggCosmicEncounter();
        case BGG_COSMIC_INCURSION    : return generateBggCosmicIncursion();
        case BGG_ABYSS               : return generateBggAbyss();
        case BGG_DC_DICE_MASTERS     : return generateBggDCDiceMasters();
        case BGG_NOT_FOUND           : return generateBggNotFound();
        case BGG_53                  : return generateBgg53();
        case BGG_1369                : return generateBgg1369();
        case BGG_1818                : return generateBgg1818();
        case BGG_12001_12020         : return generateBgg12001_12020();
        case BGG_BATCH_ALT           : return generateBggBatchAlt();
        case BGG_NESTED_18460        : return generateBggNested18460();
        case BGG_MULTINEST_29663     : return generateBggMultiNest29663();
        case BGG_50968               : return generateBgg50968();
        case CSI_ABYSS               : return generateCsiAbyss();
        case CSI_COSMIC_ENCOUNTER    : return generateCsiCosmicEncounter();
        case CSI_COSMIC_INCURSION    : return generateCsiCosmicIncursion();
        case CSI_DC_DICE_MASTERS     : return generateCsiDCDiceMasters();
        case CSI_NOT_FOUND           : return generateCsiNotFound();
        case CSI_75069               : return generateCsi75069();
        case CSI_76097               : return generateCsi76097();
        case CSI_94687               : return generateCsi94687();
        case CSI_RPG                 : return generateCsiRPG();
        case CSI_LCG_NETRUNNER       : return generateCsiLCGNetrunner();
        case CSI_SUPPLIES_SLEEVES    : return generateCsiSuppliesSleeves();
        case CSI_MINIATURES          : return generateCsiMiniatures();
        case CSI_GIFT_CERTIFICATE    : return generateCsiGiftCertificate();
        case CSI_VIDEO_GAME          : return generateCsiVideoGame();
        case MM_ABYSS                : return generateMMAbyss();
        case MM_COSMIC_ENCOUNTER     : return generateMMCosmicEncounter();
        case MM_COSMIC_INCURSION     : return generateMMCosmicIncursion();
        case MM_DC_DICE_MASTERS      : return generateMMDCDiceMasters();
        case MM_XWING_IG2000         : return generateMMXWingIG2000();
        case MM_NOT_FOUND            : return generateMMNotFound();
        case MM_5137                 : return generateMM5137();
        case MM_ACCESSORIES          : return generateMMAccessories();
        case MM_BOARDGAMES           : return generateMMBoardGames();
        case MM_CCGS                 : return generateMMCCGs();
        case MM_COLLECTIBLEMINIS     : return generateMMCollectibleMinis();
        case MM_RPGS                 : return generateMMRPGs();
        case MM_TABLETOPMINIS        : return generateMMTableTopMinis();
        case MM_UNKNOWN              : return generateMMUnknown();
        default : return "";
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return "";
    }
  }
  
  private static String generateBggMagicTheGathering() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_magicthegathering.xml"));
  }
  
  private static String generateBggCosmicEncounter() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_cosmicencounter.xml"));
  }

  private static String generateBggCosmicIncursion() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_cosmicincursion.xml"));
  }

  private static String generateBggAbyss() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_abyss.xml"));
  }
  
  private static String generateBggDCDiceMasters() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_dcdicemasters.xml"));
  }
  
  private static String generateBggNotFound() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_notfound.xml"));
  }
  
  private static String generateBgg53() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_53.xml"));
  }
  
  private static String generateBgg1369() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_1369.xml"));
  }
  
  private static String generateBgg1818() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_1818.xml"));
  }
  
  private static String generateBgg12001_12020() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_12001-12020.xml"));
  }

  private static String generateBggNested18460() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_nested_18460.xml"));
  }
  
  private static String generateBggBatchAlt() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_batch_alt.xml"));
  }
  
  private static String generateBggMultiNest29663() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_multinest_29663.xml"));
  }
  
  private static String generateBgg50968() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("bgg_50968.xml"));
  }
  
  private static String generateCsiAbyss() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_abyss.html"));
  }

  private static String generateCsiCosmicEncounter() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_cosmicencounter.html"));
  }

  private static String generateCsiCosmicIncursion() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_cosmicincursion.html"));
  }

  private static String generateCsiDCDiceMasters() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_dcdicemasters.html"));
  }
  
  private static String generateCsiNotFound() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_notfound.html"));
  }
  
  private static String generateCsi75069() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_75069.html"));
  }
  
  private static String generateCsi76097() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_76097.html"));
  }
  
  private static String generateCsi94687() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_94687.html"));
  }
  
  private static String generateCsiRPG() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_rpg.html"));
  }
  
  private static String generateCsiLCGNetrunner() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_lcg_netrunner.html"));
  }
  
  private static String generateCsiSuppliesSleeves() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_supplies_sleeves.html"));
  }
  
  private static String generateCsiMiniatures() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_miniatures.html"));
  }
  
  private static String generateCsiGiftCertificate() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_153126.html"));
  }
  
  private static String generateCsiVideoGame() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("csi_videogames.html"));
  }
  
   private static String generateMMAbyss() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_abyss.html"));
  }

  private static String generateMMCosmicEncounter() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_cosmicencounter.html"));
  }

  private static String generateMMCosmicIncursion() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_cosmicincursion.html"));
  }

  private static String generateMMDCDiceMasters() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_dcdicemasters.html"));
  }
  
  private static String generateMMXWingIG2000() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_xwingig2000.html"));
  }

  private static String generateMMNotFound() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_notfound.html"));
  }

  private static String generateMM5137() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_5137.html"));
  }

  private static String generateMMAccessories() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_accessories.html"));
  }

  private static String generateMMBoardGames() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_boardgames.html"));
  }

  private static String generateMMCCGs() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_ccgs.html"));
  }

  private static String generateMMCollectibleMinis() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_collectibleminis.html"));
  }

  private static String generateMMRPGs() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_rpgs.html"));
  }

  private static String generateMMTableTopMinis() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_tabletopminis.html"));
  }

  private static String generateMMUnknown() throws IOException {
    return IOUtils.toString(gameData.getClass().getResourceAsStream("mm_unknown.html"));
  }
}
