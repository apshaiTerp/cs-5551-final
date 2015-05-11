package com.ac.games.data.mock;

import java.util.List;

import org.junit.Test;

import com.ac.games.data.BGGGame;
import com.ac.games.data.parser.BGGGameParser;
import com.ac.games.exception.GameNotFoundException;

import junit.framework.TestCase;

/**
 * @author ac010168
 *
 */
public class TestBGGParser extends TestCase {
  
  public final static long ABYSS_GAME_ID               = 155987L;
  public final static long COSMIC_ENCOUNTER_GAME_ID    = 39463L;
  public final static long COSMIC_INCURSION_GAME_ID    = 61001L;
  public final static long MAGIC_THE_GATHERING_GAME_ID = 463L;
  public final static long DC_DICE_MASTERS_GAME_ID     = 138649L;
  public final static long NOT_FOUND_GAME_ID           = 999999L;

  @Test
  public void testAbyssParser() {
    System.out.println ("Launching Test testAbyssParser()!");
    
    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_ABYSS);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Abyss...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
  
  @Test
  public void testCosmicEncounterParser() {
    System.out.println ("Launching Test testCosmicEncounterParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_COSMIC_ENCOUNTER);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Cosmic Encounter...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testCosmicIncursionParser() {
    System.out.println ("Launching Test testCosmicIncursionParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_COSMIC_INCURSION);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Cosmic Incursion...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testMagicTheGatheringParser() {
    System.out.println ("Launching Test testMagicTheGatheringParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_MAGIC_THE_GATHERING);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Magic the Gathering...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testDCDiceMastersParser() {
    System.out.println ("Launching Test testDCDiceMastersParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_DC_DICE_MASTERS);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing DC Dice Masters...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testNotFoundParser() {
    System.out.println ("Launching Test testNotFoundParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_NOT_FOUND);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing A Non-Existant Game...");
    System.out.println ("------------------------------------------------------");
    
    try {
      BGGGameParser.parseBGGXML(xmlContent);
      fail("This game should not have been found, this should be an error!");
    } catch (GameNotFoundException gnfe) { 
      assertNotNull("This is the only correct outcome for this test", gnfe.getMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw other errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
  
  @Test
  public void testBGG53Parser() {
    System.out.println ("Launching Test testBGG53Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_53);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Brauerei...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGG1369Parser() {
    System.out.println ("Launching Test testBGG1369Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_1369);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Earthdefenders...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGG1818Parser() {
    System.out.println ("Launching Test testBGG1818Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_1818);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Black Ice...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
  
  @Test
  public void testBGGMultiFullParser() {
    System.out.println ("Launching Test testBGGMultiFullParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_12001_12020);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing List of 20 Games...");
    System.out.println ("------------------------------------------------------");
    
    List<BGGGame> games = null;
    try {
      games = BGGGameParser.parseMultiBGGXML(xmlContent);
      System.out.println ("The total games parsed from list is: " + games.size());
      for (BGGGame game : games) {
        System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 20);
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGGMultiPartiallParser() {
    System.out.println ("Launching Test testBGGMultiPartiallParser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_BATCH_ALT);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing List of 17 Games...");
    System.out.println ("------------------------------------------------------");
    
    List<BGGGame> games = null;
    try {
      games = BGGGameParser.parseMultiBGGXML(xmlContent);
      System.out.println ("The total games parsed from list is: " + games.size());
      for (BGGGame game : games) {
        System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 17);
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGGNested18460Parser() {
    System.out.println ("Launching Test testBGGNested18460Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_NESTED_18460);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing List of 20 Games...");
    System.out.println ("------------------------------------------------------");
    
    List<BGGGame> games = null;
    try {
      games = BGGGameParser.parseMultiBGGXML(xmlContent);
      System.out.println ("The total games parsed from list is: " + games.size());
      for (BGGGame game : games) {
        System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 20);
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGGMultiNest29663Parser() {
    System.out.println ("Launching Test testBGGMultiNest29663Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_MULTINEST_29663);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing List of 19 Games...");
    System.out.println ("------------------------------------------------------");
    
    List<BGGGame> games = null;
    try {
      games = BGGGameParser.parseMultiBGGXML(xmlContent);
      System.out.println ("The total games parsed from list is: " + games.size());
      for (BGGGame game : games) {
        System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 19);
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testBGG50968Parser() {
    System.out.println ("Launching Test testBGG50968Parser()!");

    String xmlContent = MockGameData.generateContentString(MockGameData.BGG_50968);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    System.out.println ("Processing Gary Gygax's Living Fantasy...");
    System.out.println ("------------------------------------------------------");
    
    BGGGame game = null;
    try {
      game = BGGGameParser.parseBGGXML(xmlContent);
      game.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
}
