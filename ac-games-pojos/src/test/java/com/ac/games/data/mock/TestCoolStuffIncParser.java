package com.ac.games.data.mock;

import junit.framework.TestCase;

import org.junit.Test;

import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.parser.CoolStuffIncParser;
import com.ac.games.exception.GameNotFoundException;

/**
 * @author ac010168
 *
 */
public class TestCoolStuffIncParser extends TestCase {

  //http://www.coolstuffinc.com/p/203495
  public final static long ABYSS_GAME_ID       = 203495L;
  //http://www.coolstuffinc.com/p/136975
  public final static long COSMIC_ENCOUNTER_ID = 136975L;
  //http://www.coolstuffinc.com/p/136978
  public final static long COSMIC_INCURSION_ID = 136978L;
  //http://www.coolstuffinc.com/p/207653
  public final static long DC_DICE_MASTERS_ID  = 207653L;
  //http://www.coolstuffinc.com/p/999999
  public final static long NOT_FOUND_GAME_ID   = 999999L;
  //http://www.coolstuffinc.com/p/75069
  public final static long MTG_CARD_ID         = 75069L;
  //http://www.coolstuffinc.com/p/76069
  public final static long MTG_CARD_ID2        = 76097L;
  //http://www.coolstuffinc.com/p/94687
  public final static long MTG_APE_TOKEN_ID    = 94687L;
  //http://www.coolstuffinc.com/p/209542
  public final static long RPG_13TH_AGE_ID     = 209542L;
  //http://www.coolstuffinc.com/p/210682
  public final static long NETRUNNER_ID        = 210682L;
  //http://www.coolstuffinc.com/p/137910
  public final static long SUPPLIES_SLEEVES_ID = 137910L;
  //http://www/coolstuffinc.com/p/153126
  public final static long GIFT_CERTIFICATE_ID = 153126L;
  //http://www/coolstuffinc.com/p/169582
  public final static long VIDEO_GAME_ID       = 169582L;
  
  @Test
  public void testAbyssParser() {
    System.out.println ("Launching Test testAbyssParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_ABYSS);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Abyss...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, ABYSS_GAME_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testCosmicEncounterParser() {
    System.out.println ("Launching Test testCosmicEncounterParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_COSMIC_ENCOUNTER);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Cosmic Encounter...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, COSMIC_ENCOUNTER_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testCosmicIncursionParser() {
    System.out.println ("Launching Test testCosmicIncursionParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_COSMIC_INCURSION);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Cosmic Incursion...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, COSMIC_INCURSION_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
  
  @Test
  public void testDCDiceMastersParser() {
    System.out.println ("Launching Test testDCDiceMastersParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_DC_DICE_MASTERS);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing DC Dice Masters...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, DC_DICE_MASTERS_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testNotFoundParser() {
    System.out.println ("Launching Test testNotFoundParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_NOT_FOUND);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing A Non-Existant Game...");
    System.out.println ("------------------------------------------------------");
    
    try {
      CoolStuffIncParser.parseCSIHTML(htmlContent, NOT_FOUND_GAME_ID);
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
  public void testMTG75069Parser() {
    System.out.println ("Launching Test testMTG75069Parser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_75069);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Executioner's Hood...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_CARD_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testMTG76097Parser() {
    System.out.println ("Launching Test testMTG76097Parser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_76097);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Karador, Ghost Chieftain (Oversized Foil)...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_CARD_ID2);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testMTG94687Parser() {
    System.out.println ("Launching Test testMTG94687Parser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_94687);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Ape (Token)...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_APE_TOKEN_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testRPGParser() {
    System.out.println ("Launching Test testRPGParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_RPG);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing 13th Age: Eyes of the Stone Thief Hardcover...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, RPG_13TH_AGE_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testLCGNetrunnerParser() {
    System.out.println ("Launching Test testLCGNetrunnerParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_LCG_NETRUNNER);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Netrunner...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, NETRUNNER_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testSuppliesSleevesParser() {
    System.out.println ("Launching Test testSuppliesSleevesParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_SUPPLIES_SLEEVES);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing 7 Wonders Sleeves...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, SUPPLIES_SLEEVES_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
  
  @Test
  public void testMiniaturesParser() {
    System.out.println ("Launching Test testMiniaturesParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_MINIATURES);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Dragon Collector's Set Sleeves...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, SUPPLIES_SLEEVES_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }

  @Test
  public void testGiftCertificateParser() {
    System.out.println ("Launching Test testGiftCertificateParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_GIFT_CERTIFICATE);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing Gift Certificate...");
    System.out.println ("------------------------------------------------------");
    
    try {
      CoolStuffIncParser.parseCSIHTML(htmlContent, GIFT_CERTIFICATE_ID);
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
  public void testVideoGamesParser() {
    System.out.println ("Launching Test testVideoGamesParser()!");

    String htmlContent = MockGameData.generateContentString(MockGameData.CSI_VIDEO_GAME);
    
    System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    System.out.println ("Processing 50 Cent Blood on the Sand...");
    System.out.println ("------------------------------------------------------");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    try {
      data = CoolStuffIncParser.parseCSIHTML(htmlContent, VIDEO_GAME_ID);
      data.printContentsForDebug();
    } catch (Throwable t) {
      t.printStackTrace();
      fail("Should not throw errors: " + t.getMessage());
    }
    
    assertTrue("The world didn't end during this test", true);
  }
}
