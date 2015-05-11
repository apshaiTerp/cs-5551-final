package com.ac.games.db.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.ac.games.data.BGGGame;
import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.GameAvailability;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameWeight;
import com.ac.games.data.MMDataStats;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.User;
import com.ac.games.data.UserDetail;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.db.mock.MockDataFactory;

/**
 * @author ac010168
 *
 */
public class TestMongoGamesDatabase extends TestCase {

  /** Reference to the host address for mongo. */
  protected final String mongoHostAddress     = "localhost";
  /** Reference to the true remote host for mongo */
  protected final String mongoTrueHostAddress = "107.188.249.238";
  /** Port number used for mongo. */
  protected final int mongoPort               = 27017;
  /** Database name to be connected to. */
  protected final String databaseName         = "mockDB";
  
  /** The database to be used during the tests */
  private GamesDatabase database;
  /*
   * (non-Javadoc)
   * @see junit.framework.TestCase#setUp()
   */
  @Override
  protected void setUp() throws Exception {
    //Attempting to initialize Database connection for test
    System.out.println ("Initializing Database Connection...");
    
    database = MongoDBFactory.createMongoGamesDatabase(mongoHostAddress, mongoPort, databaseName);
    //database = MongoDBFactory.createMongoGamesDatabase(mongoTrueHostAddress, mongoPort, databaseName);
    database.initializeDBConnection();
  }
  
  /*
   * (non-Javadoc)
   * @see junit.framework.TestCase#tearDown()
   */
  @Override
  protected void tearDown() throws Exception {
    //Closing Database connection for test
    System.out.println ("Initializing Database Disconnect...");
    
    database.closeDBConnection();
  }
  
  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Cosmic Encounter</li>
   * <li>Insert Cosmic Incursion</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Cosmic Incursion and Verify</li>
   * <li>Reinsert Cosmic Encounter</li>
   * <li>Upsert Abyss</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Abyss and Verify</li>
   * <li>Modify Abyss Data</li>
   * <li>Update Abyss</li>
   * <li>Read Abyss and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Run the Max ID Query and verify that the largest id value is returned</li>
   * <li>Run the Count Query and Verify we got three games</li>
   * <li>Delete Cosmic Encounter and Cosmic Incursion</li>
   * <li>Read Nothing for two games, verify Abyss still exists</li>
   * <li>Delete Abyss</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testBGGData() {
    //MongoGamesDatabase.debugMode = true;
    try {
      //Insert Cosmic Encounter
      System.out.println ("===  Insert Cosmic Encounter  ===");
      BGGGame cosmicEncounter = MockDataFactory.createBGGGame(MockDataFactory.BGG_COSMIC_ENCOUNTER_ID);
      database.insertBGGGameData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      System.out.println ("===  Insert Cosmic Incursion  ===");
      BGGGame cosmicIncursion = MockDataFactory.createBGGGame(MockDataFactory.BGG_COSMIC_INCURSION_ID);
      database.insertBGGGameData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      BGGGame cosmicEncounter2 = database.readBGGGameData(cosmicEncounter.getBggID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter2);
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter2.getName()));
      assertTrue("The bggRatings are not equal", cosmicEncounter.getBggRating() == cosmicEncounter2.getBggRating());
      assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter2.getPublishers().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter2.getExpansionIDs().size());
      assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter2.getGameType());
      
      //Read Cosmic Incursion and Verify
      System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      BGGGame cosmicIncursion2 = database.readBGGGameData(cosmicIncursion.getBggID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicIncursion2);
      assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      assertTrue("The names are not equal", cosmicIncursion.getName().equalsIgnoreCase(cosmicIncursion2.getName()));
      assertTrue("The bggRatings are not equal", cosmicIncursion.getBggRating() == cosmicIncursion2.getBggRating());
      assertTrue("The publishers lists are not equal", cosmicIncursion.getPublishers().size() == cosmicIncursion2.getPublishers().size());
      assertTrue("The parentGameIDs are not equal", cosmicIncursion.getParentGameID() == cosmicIncursion2.getParentGameID());
      assertTrue("The GameTypes are not equal", cosmicIncursion.getGameType() == cosmicIncursion2.getGameType());
      
      //Reinsert Cosmic Encounter
      System.out.println ("===  Reinsert Cosmic Encounter  ===");
      database.insertBGGGameData(cosmicEncounter);
      
      //Upsert Abyss
      System.out.println ("===  Upsert Abyss  ===");
      BGGGame abyss = MockDataFactory.createBGGGame(MockDataFactory.BGG_ABYSS_ID);
      database.updateBGGGameData(abyss);
      
      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      BGGGame cosmicEncounter3 = database.readBGGGameData(cosmicEncounter.getBggID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter3);
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter3.getName()));
      assertTrue("The bggRatings are not equal", cosmicEncounter.getBggRating() == cosmicEncounter3.getBggRating());
      assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter3.getPublishers().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter3.getExpansionIDs().size());
      assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter3.getGameType());

      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      BGGGame abyss2 = database.readBGGGameData(abyss.getBggID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss2);
      assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      assertTrue("The names are not equal", abyss.getName().equalsIgnoreCase(abyss2.getName()));
      assertTrue("The bggRatings are not equal", abyss.getBggRating() == abyss2.getBggRating());
      assertTrue("The publishers lists are not equal", abyss.getPublishers().size() == abyss2.getPublishers().size());
      assertNull("The first expansionList was not empty", abyss.getExpansionIDs());
      assertNull("The second expansionList was not empty", abyss2.getExpansionIDs());
      assertTrue("The GameTypes are not equal", abyss.getGameType() == abyss2.getGameType());
      assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      System.out.println ("===  Modify Abyss Data and Update  ===");
      abyss.setMaxPlayingTime(abyss.getMaxPlayingTime() + 45);
      abyss.setBggRatingUsers(abyss.getBggRatingUsers() + 400);
      abyss.setBggRank(2321);
      
      //Update Abyss
      System.out.println ("===  Update Abyss  ===");
      database.updateBGGGameData(abyss);
      
      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      BGGGame abyss3 = database.readBGGGameData(abyss.getBggID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss3);
      assertTrue("The maxPlayingTimes are not equal", abyss.getMaxPlayingTime() == abyss3.getMaxPlayingTime());
      assertTrue("The bggRatingsUsers are not equal", abyss.getBggRating() == abyss3.getBggRating());
      assertTrue("The bggRanks are not equal", abyss.getBggRank() == abyss3.getBggRank());
      
      //Run the IDs select and verify all three games found
      System.out.println ("===  Run the IDs select and verify all three games found  ===");
      List<Long> bggIDList = database.getBggIDList();
      assertNotNull("I didn't get an ID List", bggIDList);
      assertTrue("My List didn't contain Cosmic Encounter", bggIDList.contains(MockDataFactory.BGG_COSMIC_ENCOUNTER_ID));
      assertTrue("My List didn't contain Cosmic Incursion", bggIDList.contains(MockDataFactory.BGG_COSMIC_INCURSION_ID));
      assertTrue("My List didn't contain Abyss", bggIDList.contains(MockDataFactory.BGG_ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      long maxValue = database.getMaxBGGGameID();
      assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.BGG_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      int count = database.getBGGGameCount();
      assertTrue("I got a value other than I was expecting for maxValue", count == 3);
      
      //Delete Cosmic Encounter and Cosmic Incursion
      System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      database.deleteBGGGameData(cosmicEncounter.getBggID());
      database.deleteBGGGameData(cosmicIncursion.getBggID());
      
      //Read Nothing for two games, verify Abyss still exists
      System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      BGGGame notFound1  = database.readBGGGameData(cosmicEncounter.getBggID());
      BGGGame notFound2  = database.readBGGGameData(cosmicIncursion.getBggID());
      BGGGame foundAbyss = database.readBGGGameData(abyss.getBggID());
      
      assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      System.out.println ("===  Delete Abyss  ===");
      database.deleteBGGGameData(abyss.getBggID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of CSI Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Cosmic Encounter</li>
   * <li>Insert Cosmic Incursion</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Cosmic Incursion and Verify</li>
   * <li>Reinsert Cosmic Encounter</li>
   * <li>Upsert Abyss</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Abyss and Verify</li>
   * <li>Modify Abyss Data</li>
   * <li>Update Abyss</li>
   * <li>Read Abyss and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Run the Max ID Query and verify that the largest id value is returned</li>
   * <li>Run the Count Query and Verify we got three games</li>
   * <li>Delete Cosmic Encounter and Cosmic Incursion</li>
   * <li>Read Nothing for two games, verify Abyss still exists</li>
   * <li>Delete Abyss</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testCSIData() {
    //MongoGamesDatabase.debugMode = true;
    try {
      //Insert Cosmic Encounter
      System.out.println ("===  Insert Cosmic Encounter  ===");
      CoolStuffIncPriceData cosmicEncounter = MockDataFactory.createCSIData(MockDataFactory.CSI_COSMIC_ENCOUNTER_ID);
      database.insertCSIPriceData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      System.out.println ("===  Insert Cosmic Incursion  ===");
      CoolStuffIncPriceData cosmicIncursion = MockDataFactory.createCSIData(MockDataFactory.CSI_COSMIC_INCURSION_ID);
      database.insertCSIPriceData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      CoolStuffIncPriceData cosmicEncounter2 = database.readCSIPriceData(cosmicEncounter.getCsiID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter2);
      assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiID() == cosmicEncounter2.getCsiID());
      assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter2.getTitle()));
      assertTrue("The publishers are not equal", cosmicEncounter.getPublisher().equalsIgnoreCase(cosmicEncounter2.getPublisher()));
      assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter2.getCategory());
      assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter2.getSku()));
      assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter2.getAvailability());
      
      //Read Cosmic Incursion and Verify
      System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      CoolStuffIncPriceData cosmicIncursion2 = database.readCSIPriceData(cosmicIncursion.getCsiID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicIncursion2);
      assertTrue("The csiIDs are not equal", cosmicIncursion.getCsiID() == cosmicIncursion2.getCsiID());
      assertTrue("The titles are not equal", cosmicIncursion.getTitle().equalsIgnoreCase(cosmicIncursion2.getTitle()));
      assertTrue("The publishers are not equal", cosmicIncursion.getPublisher().equalsIgnoreCase(cosmicIncursion2.getPublisher()));
      assertTrue("The categories are not equal", cosmicIncursion.getCategory() == cosmicIncursion2.getCategory());
      assertTrue("The skus are not equal", cosmicIncursion.getSku().equalsIgnoreCase(cosmicIncursion2.getSku()));
      assertTrue("The curPrices are not equal", cosmicIncursion.getCurPrice() == cosmicIncursion2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicIncursion.getAvailability() == cosmicIncursion2.getAvailability());
      
      //Reinsert Cosmic Encounter
      System.out.println ("===  Reinsert Cosmic Encounter  ===");
      database.insertCSIPriceData(cosmicEncounter);
      
      //Upsert Abyss
      System.out.println ("===  Upsert Abyss  ===");
      CoolStuffIncPriceData abyss = MockDataFactory.createCSIData(MockDataFactory.CSI_ABYSS_ID);
      database.updateCSIPriceData(abyss);
      
      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      CoolStuffIncPriceData cosmicEncounter3 = database.readCSIPriceData(cosmicEncounter.getCsiID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter3);
      assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiID() == cosmicEncounter3.getCsiID());
      assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter3.getTitle()));
      assertTrue("The publishers are not equal", cosmicEncounter.getPublisher().equalsIgnoreCase(cosmicEncounter3.getPublisher()));
      assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter3.getCategory());
      assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter3.getSku()));
      assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter3.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter3.getAvailability());

      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      CoolStuffIncPriceData abyss2 = database.readCSIPriceData(abyss.getCsiID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss2);
      assertTrue("The csiIDs are not equal", abyss.getCsiID() == abyss2.getCsiID());
      assertTrue("The titles are not equal", abyss.getTitle().equalsIgnoreCase(abyss2.getTitle()));
      assertTrue("The publishers are not equal", abyss.getPublisher().equalsIgnoreCase(abyss2.getPublisher()));
      assertTrue("The skus are not equal", abyss.getSku().equalsIgnoreCase(abyss2.getSku()));
      assertTrue("The categories are not equal", abyss.getCategory() == abyss2.getCategory());
      assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", abyss.getAvailability() == abyss2.getAvailability());
      assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      System.out.println ("===  Modify Abyss Data and Update  ===");
      abyss.setCurPrice(abyss.getCurPrice() + 12.75);
      abyss.setAvailability(GameAvailability.PREORDER);
      
      //Update Abyss
      System.out.println ("===  Update Abyss  ===");
      database.updateCSIPriceData(abyss);
      
      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      CoolStuffIncPriceData abyss3 = database.readCSIPriceData(abyss.getCsiID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss3);
      assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss3.getCurPrice());
      assertTrue("The availabilities are not equal", abyss.getAvailability() == abyss3.getAvailability());
      
      //Run the IDs select and verify all three games found
      System.out.println ("===  Run the IDs select and verify all three games found  ===");
      List<Long> csiIDList = database.getCSIIDList();
      assertNotNull("I didn't get an ID List", csiIDList);
      assertTrue("My List didn't contain Cosmic Encounter", csiIDList.contains(MockDataFactory.CSI_COSMIC_ENCOUNTER_ID));
      assertTrue("My List didn't contain Cosmic Incursion", csiIDList.contains(MockDataFactory.CSI_COSMIC_INCURSION_ID));
      assertTrue("My List didn't contain Abyss", csiIDList.contains(MockDataFactory.CSI_ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      long maxValue = database.getMaxCSIDataID();
      assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.CSI_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      int count = database.getCSIDataCount();
      assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      database.deleteCSIPriceData(cosmicEncounter.getCsiID());
      database.deleteCSIPriceData(cosmicIncursion.getCsiID());
      
      //Read Nothing for two games, verify Abyss still exists
      System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      CoolStuffIncPriceData notFound1  = database.readCSIPriceData(cosmicEncounter.getCsiID());
      CoolStuffIncPriceData notFound2  = database.readCSIPriceData(cosmicIncursion.getCsiID());
      CoolStuffIncPriceData foundAbyss = database.readCSIPriceData(abyss.getCsiID());
      
      assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      System.out.println ("===  Delete Abyss  ===");
      database.deleteCSIPriceData(abyss.getCsiID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of CSI Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Cosmic Encounter</li>
   * <li>Insert Cosmic Incursion</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Cosmic Incursion and Verify</li>
   * <li>Reinsert Cosmic Encounter</li>
   * <li>Upsert Abyss</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Abyss and Verify</li>
   * <li>Modify Abyss Data</li>
   * <li>Update Abyss</li>
   * <li>Read Abyss and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Run the Max ID Query and verify that the largest id value is returned</li>
   * <li>Run the Count Query and Verify we got three games</li>
   * <li>Delete Cosmic Encounter and Cosmic Incursion</li>
   * <li>Read Nothing for two games, verify Abyss still exists</li>
   * <li>Delete Abyss</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testMMData() {
    //MongoGamesDatabase.debugMode = true;
    try {
      //Insert Cosmic Encounter
      System.out.println ("===  Insert Cosmic Encounter  ===");
      MiniatureMarketPriceData cosmicEncounter = MockDataFactory.createMMData(MockDataFactory.MM_COSMIC_ENCOUNTER_ID);
      database.insertMMPriceData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      System.out.println ("===  Insert Cosmic Incursion  ===");
      MiniatureMarketPriceData cosmicIncursion = MockDataFactory.createMMData(MockDataFactory.MM_COSMIC_INCURSION_ID);
      database.insertMMPriceData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      MiniatureMarketPriceData cosmicEncounter2 = database.readMMPriceData(cosmicEncounter.getMmID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter2);
      assertTrue("The mmIDs are not equal", cosmicEncounter.getMmID() == cosmicEncounter2.getMmID());
      assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter2.getTitle()));
      assertTrue("The manufacturers are not equal", cosmicEncounter.getManufacturer().equalsIgnoreCase(cosmicEncounter2.getManufacturer()));
      assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter2.getCategory());
      assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter2.getSku()));
      assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter2.getAvailability());
      
      //Read Cosmic Incursion and Verify
      System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      MiniatureMarketPriceData cosmicIncursion2 = database.readMMPriceData(cosmicIncursion.getMmID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicIncursion2);
      assertTrue("The mmIDs are not equal", cosmicIncursion.getMmID() == cosmicIncursion2.getMmID());
      assertTrue("The titles are not equal", cosmicIncursion.getTitle().equalsIgnoreCase(cosmicIncursion2.getTitle()));
      assertTrue("The manufacturers are not equal", cosmicIncursion.getManufacturer().equalsIgnoreCase(cosmicIncursion2.getManufacturer()));
      assertTrue("The categories are not equal", cosmicIncursion.getCategory() == cosmicIncursion2.getCategory());
      assertTrue("The skus are not equal", cosmicIncursion.getSku().equalsIgnoreCase(cosmicIncursion2.getSku()));
      assertTrue("The curPrices are not equal", cosmicIncursion.getCurPrice() == cosmicIncursion2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicIncursion.getAvailability() == cosmicIncursion2.getAvailability());
      
      //Reinsert Cosmic Encounter
      System.out.println ("===  Reinsert Cosmic Encounter  ===");
      database.insertMMPriceData(cosmicEncounter);
      
      //Upsert Abyss
      System.out.println ("===  Upsert Abyss  ===");
      MiniatureMarketPriceData abyss = MockDataFactory.createMMData(MockDataFactory.MM_ABYSS_ID);
      database.updateMMPriceData(abyss);
      
      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      MiniatureMarketPriceData cosmicEncounter3 = database.readMMPriceData(cosmicEncounter.getMmID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter3);
      assertTrue("The mmIDs are not equal", cosmicEncounter.getMmID() == cosmicEncounter3.getMmID());
      assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter3.getTitle()));
      assertTrue("The manufacturers are not equal", cosmicEncounter.getManufacturer().equalsIgnoreCase(cosmicEncounter3.getManufacturer()));
      assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter3.getCategory());
      assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter3.getSku()));
      assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter3.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter3.getAvailability());

      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      MiniatureMarketPriceData abyss2 = database.readMMPriceData(abyss.getMmID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss2);
      assertTrue("The mmIDs are not equal", abyss.getMmID() == abyss2.getMmID());
      assertTrue("The titles are not equal", abyss.getTitle().equalsIgnoreCase(abyss2.getTitle()));
      assertTrue("The manufacturers are not equal", abyss.getManufacturer().equalsIgnoreCase(abyss2.getManufacturer()));
      assertTrue("The categories are not equal", abyss.getCategory() == abyss2.getCategory());
      assertTrue("The skus are not equal", abyss.getSku().equalsIgnoreCase(abyss2.getSku()));
      assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss2.getCurPrice());
      assertTrue("The GameAvailabilities are not equal", abyss.getAvailability() == abyss2.getAvailability());
      assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      System.out.println ("===  Modify Abyss Data and Update  ===");
      abyss.setCurPrice(abyss.getCurPrice() + 12.75);
      abyss.setAvailability(GameAvailability.PREORDER);
      
      //Update Abyss
      System.out.println ("===  Update Abyss  ===");
      database.updateMMPriceData(abyss);
      
      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      MiniatureMarketPriceData abyss3 = database.readMMPriceData(abyss.getMmID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss3);
      assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss3.getCurPrice());
      assertTrue("The availabilities are not equal", abyss.getAvailability() == abyss3.getAvailability());
      
      //Run the IDs select and verify all three games found
      System.out.println ("===  Run the IDs select and verify all three games found  ===");
      List<Long> mmIDList = database.getMMIDList();
      assertNotNull("I didn't get an ID List", mmIDList);
      assertTrue("My List didn't contain Cosmic Encounter", mmIDList.contains(MockDataFactory.MM_COSMIC_ENCOUNTER_ID));
      assertTrue("My List didn't contain Cosmic Incursion", mmIDList.contains(MockDataFactory.MM_COSMIC_INCURSION_ID));
      assertTrue("My List didn't contain Abyss", mmIDList.contains(MockDataFactory.MM_ABYSS_ID));

      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      long maxValue = database.getMaxMMDataID();
      assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.MM_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      int count = database.getMMDataCount();
      assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      database.deleteMMPriceData(cosmicEncounter.getMmID());
      database.deleteMMPriceData(cosmicIncursion.getMmID());
      
      //Read Nothing for two games, verify Abyss still exists
      System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      MiniatureMarketPriceData notFound1  = database.readMMPriceData(cosmicEncounter.getMmID());
      MiniatureMarketPriceData notFound2  = database.readMMPriceData(cosmicIncursion.getMmID());
      MiniatureMarketPriceData foundAbyss = database.readMMPriceData(abyss.getMmID());
      
      assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      System.out.println ("===  Delete Abyss  ===");
      database.deleteMMPriceData(abyss.getMmID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Cosmic Encounter</li>
   * <li>Insert Cosmic Incursion</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Cosmic Incursion and Verify</li>
   * <li>Reinsert Cosmic Encounter</li>
   * <li>Upsert Abyss</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Abyss and Verify</li>
   * <li>Modify Abyss Data</li>
   * <li>Update Abyss</li>
   * <li>Read Abyss and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Run the Max ID Query and verify that the largest id value is returned</li>
   * <li>Run the Count Query and Verify we got three games</li>
   * <li>Delete Cosmic Encounter and Cosmic Incursion</li>
   * <li>Read Nothing for two games, verify Abyss still exists</li>
   * <li>Delete Abyss</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testGameData() {
    //MongoGamesDatabase.debugMode = true;
    try {
      //Insert Cosmic Encounter
      System.out.println ("===  Insert Cosmic Encounter  ===");
      Game cosmicEncounter = MockDataFactory.createGameData(MockDataFactory.COSMIC_ENCOUNTER_ID);
      database.insertGame(cosmicEncounter);
      
      //Insert Cosmic Incursion
      System.out.println ("===  Insert Cosmic Incursion  ===");
      Game cosmicIncursion = MockDataFactory.createGameData(MockDataFactory.COSMIC_INCURSION_ID);
      database.insertGame(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      Game cosmicEncounter2 = database.readGame(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter2);
      assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter2.getGameID());
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter2.getName()));
      assertTrue("The primaryPublishers are not equal", cosmicEncounter.getPrimaryPublisher().equalsIgnoreCase(cosmicEncounter2.getPrimaryPublisher()));
      assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter2.getPublishers().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter2.getExpansionIDs().size());
      assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter2.getGameType());
      
      //Read Cosmic Incursion and Verify
      System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      Game cosmicIncursion2 = database.readGame(cosmicIncursion.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicIncursion2);
      assertTrue("The gameIDs are not equal", cosmicIncursion.getGameID() == cosmicIncursion2.getGameID());
      assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      assertTrue("The names are not equal", cosmicIncursion.getName().equalsIgnoreCase(cosmicIncursion2.getName()));
      assertTrue("The primaryPublishers are not equal", cosmicIncursion.getPrimaryPublisher().equalsIgnoreCase(cosmicIncursion2.getPrimaryPublisher()));
      assertTrue("The publishers lists are not equal", cosmicIncursion.getPublishers().size() == cosmicIncursion2.getPublishers().size());
      assertTrue("The parentGameIDs are not equal", cosmicIncursion.getParentGameID() == cosmicIncursion2.getParentGameID());
      assertTrue("The GameTypes are not equal", cosmicIncursion.getGameType() == cosmicIncursion2.getGameType());
      
      //Reinsert Cosmic Encounter
      System.out.println ("===  Reinsert Cosmic Encounter  ===");
      database.insertGame(cosmicEncounter);
      
      //Upsert Abyss
      System.out.println ("===  Upsert Abyss  ===");
      Game abyss = MockDataFactory.createGameData(MockDataFactory.ABYSS_ID);
      database.updateGame(abyss);
      
      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      Game cosmicEncounter3 = database.readGame(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter3);
      assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter3.getGameID());
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter3.getName()));
      assertTrue("The primaryPublishers are not equal", cosmicEncounter.getPrimaryPublisher().equalsIgnoreCase(cosmicEncounter3.getPrimaryPublisher()));
      assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter3.getPublishers().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter3.getExpansionIDs().size());
      assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter3.getGameType());

      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      Game abyss2 = database.readGame(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss2);
      assertTrue("The gameIDs are not equal", abyss.getGameID() == abyss2.getGameID());
      assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      assertTrue("The names are not equal", abyss.getName().equalsIgnoreCase(abyss2.getName()));
      assertTrue("The primaryPublishers are not equal", abyss.getPrimaryPublisher().equalsIgnoreCase(abyss2.getPrimaryPublisher()));
      assertTrue("The publishers lists are not equal", abyss.getPublishers().size() == abyss2.getPublishers().size());
      assertNull("The first expansionList was not empty", abyss.getExpansionIDs());
      assertNull("The second expansionList was not empty", abyss2.getExpansionIDs());
      assertTrue("The GameTypes are not equal", abyss.getGameType() == abyss2.getGameType());
      assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());

      //Modify Abyss Data and Update
      System.out.println ("===  Modify Abyss Data and Update  ===");
      abyss.setMaxPlayingTime(abyss.getMaxPlayingTime() + 45);
      
      //Update Abyss
      System.out.println ("===  Update Abyss  ===");
      database.updateGame(abyss);
      
      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      Game abyss3 = database.readGame(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss3);
      assertTrue("The maxPlayingTimes are not equal", abyss.getMaxPlayingTime() == abyss3.getMaxPlayingTime());
      
      //Run the IDs select and verify all three games found
      System.out.println ("===  Run the IDs select and verify all three games found  ===");
      List<Long> gameIDList = database.getGameIDList();
      assertNotNull("I didn't get an ID List", gameIDList);
      assertTrue("My List didn't contain Cosmic Encounter", gameIDList.contains(MockDataFactory.COSMIC_ENCOUNTER_ID));
      assertTrue("My List didn't contain Cosmic Incursion", gameIDList.contains(MockDataFactory.COSMIC_INCURSION_ID));
      assertTrue("My List didn't contain Abyss", gameIDList.contains(MockDataFactory.ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Cosmic Incursion) is returned
      System.out.println ("===  Run the Max ID Query and verify that the largest id value is returned  ===");
      long maxValue = database.getMaxGameID();
      assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.COSMIC_INCURSION_ID);
      
      //Run the Count Query and Verify we got three games
      System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      int count = database.getGameCount();
      assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      database.deleteGame(cosmicEncounter.getGameID());
      database.deleteGame(cosmicIncursion.getGameID());
      
      //Read Nothing for two games, verify Abyss still exists
      System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      Game notFound1  = database.readGame(cosmicEncounter.getGameID());
      Game notFound2  = database.readGame(cosmicIncursion.getGameID());
      Game foundAbyss = database.readGame(abyss.getGameID());
      
      assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      System.out.println ("===  Delete Abyss  ===");
      database.deleteGame(abyss.getGameID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }
  
  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Cosmic Encounter</li>
   * <li>Insert Cosmic Incursion</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Cosmic Incursion and Verify</li>
   * <li>Reinsert Cosmic Encounter</li>
   * <li>Upsert Abyss</li>
   * <li>Read Cosmic Encounter and Verify</li>
   * <li>Read Abyss and Verify</li>
   * <li>Modify Abyss Data</li>
   * <li>Update Abyss</li>
   * <li>Read Abyss and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Delete Cosmic Encounter and Cosmic Incursion</li>
   * <li>Read Nothing for two games, verify Abyss still exists</li>
   * <li>Delete Abyss</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testGameReltnData() {
    //MongoGamesDatabase.debugMode = true;
    try {
      //Insert Cosmic Encounter
      System.out.println ("===  Insert Cosmic Encounter  ===");
      GameReltn cosmicEncounter = MockDataFactory.createGameReltnData(MockDataFactory.COSMIC_ENCOUNTER_RELTN_ID);
      database.insertGameReltn(cosmicEncounter);
      
      //Insert Cosmic Incursion
      System.out.println ("===  Insert Cosmic Incursion  ===");
      GameReltn cosmicIncursion = MockDataFactory.createGameReltnData(MockDataFactory.COSMIC_INCURSION_RELTN_ID);
      database.insertGameReltn(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      GameReltn cosmicEncounter2 = database.readGameReltn(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter2);
      assertTrue("The reltnIDs are not equal", cosmicEncounter.getReltnID() == cosmicEncounter2.getReltnID());
      assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter2.getGameID());
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiIDs().size() == cosmicEncounter2.getCsiIDs().size());
      assertTrue("The mmIDs are not equal", cosmicEncounter.getMmIDs().size() == cosmicEncounter2.getMmIDs().size());
      assertTrue("The publishers lists are not equal", cosmicEncounter.getAsinKeys().size() == cosmicEncounter2.getAsinKeys().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getOtherSites().size() == cosmicEncounter2.getOtherSites().size());
      
      //Read Cosmic Incursion and Verify
      System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      GameReltn cosmicIncursion2 = database.readGameReltn(cosmicIncursion.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicIncursion2);
      assertTrue("The reltnIDs are not equal", cosmicIncursion.getReltnID() == cosmicIncursion2.getReltnID());
      assertTrue("The gameIDs are not equal", cosmicIncursion.getGameID() == cosmicIncursion2.getGameID());
      assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      assertTrue("The csiIDs are not equal", cosmicIncursion.getCsiIDs().size() == cosmicIncursion2.getCsiIDs().size());
      assertTrue("The mmIDs are not equal", cosmicIncursion.getMmIDs().size() == cosmicIncursion2.getMmIDs().size());
      assertTrue("The publishers lists are not equal", cosmicIncursion.getAsinKeys().size() == cosmicIncursion2.getAsinKeys().size());
      //Should be null
      assertTrue("The expansion lists are not equal", cosmicIncursion.getOtherSites() == cosmicIncursion2.getOtherSites());
      
      //Reinsert Cosmic Encounter
      System.out.println ("===  Reinsert Cosmic Encounter  ===");
      database.insertGameReltn(cosmicEncounter);
      
      //Upsert Abyss
      System.out.println ("===  Upsert Abyss  ===");
      GameReltn abyss = MockDataFactory.createGameReltnData(MockDataFactory.ABYSS_RELTN_ID);
      database.updateGameReltn(abyss);
      
      //Read Cosmic Encounter and Verify
      System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      GameReltn cosmicEncounter3 = database.readGameReltn(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", cosmicEncounter3);
      assertTrue("The reltnIDs are not equal", cosmicEncounter.getReltnID() == cosmicEncounter3.getReltnID());
      assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter3.getGameID());
      assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiIDs().size() == cosmicEncounter3.getCsiIDs().size());
      assertTrue("The mmIDs are not equal", cosmicEncounter.getMmIDs().size() == cosmicEncounter3.getMmIDs().size());
      assertTrue("The publishers lists are not equal", cosmicEncounter.getAsinKeys().size() == cosmicEncounter3.getAsinKeys().size());
      assertTrue("The expansion lists are not equal", cosmicEncounter.getOtherSites().size() == cosmicEncounter3.getOtherSites().size());

      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      GameReltn abyss2 = database.readGameReltn(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss2);
      assertTrue("The reltnIDs are not equal", abyss.getReltnID() == abyss2.getReltnID());
      assertTrue("The gameIDs are not equal", abyss.getGameID() == abyss2.getGameID());
      assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      assertTrue("The csiIDs are not equal", abyss.getCsiIDs().size() == abyss2.getCsiIDs().size());
      assertTrue("The mmIDs are not equal", abyss.getMmIDs().size() == abyss2.getMmIDs().size());
      assertTrue("The publishers lists are not equal", abyss.getAsinKeys().size() == abyss2.getAsinKeys().size());
      //Should be null
      assertTrue("The expansion lists are not equal", cosmicIncursion.getOtherSites() == abyss2.getOtherSites());

      //Modify Abyss Data and Update
      System.out.println ("===  Modify Abyss Data and Update  ===");
      List<Long> csiList = abyss.getCsiIDs();
      csiList.add(MockDataFactory.CSI_ABYSS_ID + 20);
      List<Long> mmList = abyss.getMmIDs();
      mmList.add(MockDataFactory.MM_ABYSS_ID + 20);
      
      abyss.setCsiIDs(csiList);
      abyss.setMmIDs(mmList);
      
      //Update Abyss
      System.out.println ("===  Update Abyss  ===");
      database.updateGameReltn(abyss);
      
      //Read Abyss and Verify
      System.out.println ("===  Read Abyss and Verify  ===");
      GameReltn abyss3 = database.readGameReltn(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", abyss3);
      assertTrue("The csiIDs are not equal", abyss.getCsiIDs().size() == abyss3.getCsiIDs().size());
      assertTrue("The mmIDs are not equal", abyss.getMmIDs().size() == abyss3.getMmIDs().size());
      
      //Run the IDs select and verify all three games found
      System.out.println ("===  Run the IDs select and verify all three games found  ===");
      List<Long> reltnIDList = database.getGameReltnIDList();
      assertNotNull("I didn't get an ID List", reltnIDList);
      assertTrue("My List didn't contain Cosmic Encounter", reltnIDList.contains(MockDataFactory.COSMIC_ENCOUNTER_RELTN_ID));
      assertTrue("My List didn't contain Cosmic Incursion", reltnIDList.contains(MockDataFactory.COSMIC_INCURSION_RELTN_ID));
      assertTrue("My List didn't contain Abyss", reltnIDList.contains(MockDataFactory.ABYSS_RELTN_ID));
      
      //Delete Cosmic Encounter and Cosmic Incursion
      System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      database.deleteGameReltn(cosmicEncounter.getReltnID());
      database.deleteGameReltn(cosmicIncursion.getReltnID());
      
      //Read Nothing for two games, verify Abyss still exists
      System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      GameReltn notFound1  = database.readGameReltn(cosmicEncounter.getGameID());
      GameReltn notFound2  = database.readGameReltn(cosmicIncursion.getGameID());
      GameReltn foundAbyss = database.readGameReltn(abyss.getGameID());
      
      assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      System.out.println ("===  Delete Abyss  ===");
      database.deleteGameReltn(abyss.getReltnID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }
  
  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert User One</li>
   * <li>Insert User Two</li>
   * <li>Read User One and Verify</li>
   * <li>Read User Two and Verify</li>
   * <li>Reinsert User One</li>
   * <li>Upsert User Three</li>
   * <li>Read User One and Verify</li>
   * <li>Read User Three and Verify</li>
   * <li>Modify User Three Data</li>
   * <li>Update User Three</li>
   * <li>Read User Three and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Delete User One and User Two</li>
   * <li>Read Nothing for two games, verify User Three still exists</li>
   * <li>Delete User Three</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testUsers() {
    try {
      //Insert User One
      System.out.println ("===  Insert User One  ===");
      User userOne = MockDataFactory.createUserData(MockDataFactory.USER_ONE_ID);
      database.insertUser(userOne);
      
      //Insert User Two
      System.out.println ("===  Insert User Two  ===");
      User userTwo = MockDataFactory.createUserData(MockDataFactory.USER_TWO_ID);
      database.insertUser(userTwo);

      //Read User One and Verify
      System.out.println ("===  Read User One and Verify  ===");
      User userOne2 = database.readUser(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userOne2);
      assertTrue("The userIDs are not equal", userOne.getUserID() == userOne2.getUserID());
      assertTrue("The firstNames don't match", userOne.getFirstName().equalsIgnoreCase(userOne2.getFirstName()));
      assertTrue("The lastNames don't match", userOne.getLastName().equalsIgnoreCase(userOne2.getLastName()));
      assertTrue("The emailAddresses don't match", userOne.getEmailAddress().equalsIgnoreCase(userOne2.getEmailAddress()));
      assertTrue("The collectionIDs are not equal", userOne.getCollectionID() == userOne2.getCollectionID());
      
      //Read User Two and Verify
      System.out.println ("===  Read User Two and Verify  ===");
      User userTwo2 = database.readUser(userTwo.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userTwo2);
      assertTrue("The userIDs are not equal", userTwo.getUserID() == userTwo2.getUserID());
      assertTrue("The firstNames don't match", userTwo.getFirstName().equalsIgnoreCase(userTwo2.getFirstName()));
      assertTrue("The lastNames don't match", userTwo.getLastName().equalsIgnoreCase(userTwo2.getLastName()));
      assertTrue("The emailAddresses don't match", userTwo.getEmailAddress().equalsIgnoreCase(userTwo2.getEmailAddress()));
      assertTrue("The collectionIDs are not equal", userTwo.getCollectionID() == userTwo2.getCollectionID());
      
      //Reinsert User One
      System.out.println ("===  Reinsert User One  ===");
      database.insertUser(userOne);
      
      //Upsert User Three
      System.out.println ("===  Upsert User Three  ===");
      User userThree = MockDataFactory.createUserData(MockDataFactory.USER_THREE_ID);
      database.updateUser(userThree);
      
      //Read User One and Verify
      System.out.println ("===  Read User One and Verify  ===");
      User userOne3 = database.readUser(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userOne3);
      assertTrue("The userIDs are not equal", userOne.getUserID() == userOne3.getUserID());
      assertTrue("The firstNames don't match", userOne.getFirstName().equalsIgnoreCase(userOne3.getFirstName()));
      assertTrue("The lastNames don't match", userOne.getLastName().equalsIgnoreCase(userOne3.getLastName()));
      assertTrue("The emailAddresses don't match", userOne.getEmailAddress().equalsIgnoreCase(userOne3.getEmailAddress()));
      assertTrue("The collectionIDs are not equal", userOne.getCollectionID() == userOne3.getCollectionID());

      //Read User Three and Verify
      System.out.println ("===  Read User Three and Verify  ===");
      User userThree2 = database.readUser(userThree.getUserName());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userThree2);
      assertTrue("The userIDs are not equal", userThree.getUserID() == userThree2.getUserID());
      assertTrue("The firstNames don't match", userThree.getFirstName().equalsIgnoreCase(userThree2.getFirstName()));
      assertTrue("The lastNames don't match", userThree.getLastName().equalsIgnoreCase(userThree2.getLastName()));
      assertTrue("The emailAddresses don't match", userThree.getEmailAddress().equalsIgnoreCase(userThree2.getEmailAddress()));
      assertTrue("The collectionIDs are not equal", userThree.getCollectionID() == userThree2.getCollectionID());

      //Modify User Three Data and Update
      System.out.println ("===  Modify User Three Data and Update  ===");
      userThree.setFirstName("Hammy");
      userThree.setLastName("Porkchop");
      
      //Update User Three
      System.out.println ("===  Update User Three  ===");
      database.updateUser(userThree);
      
      //Read User Three and Verify
      System.out.println ("===  Read User Three and Verify  ===");
      User userThree3 = database.readUser(userThree.getUserName());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userThree3);
      assertTrue("The firstNames don't match", userThree.getFirstName().equalsIgnoreCase(userThree3.getFirstName()));
      assertTrue("The lastNames don't match", userThree.getLastName().equalsIgnoreCase(userThree3.getLastName()));
      
      //Delete User One and User Two
      System.out.println ("===  Delete User One and User Two  ===");
      database.deleteUser(userOne.getUserID());
      database.deleteUser(userTwo.getUserID());
      
      //Read Nothing for two games, verify User Three still exists
      System.out.println ("===  Read Nothing for two games, verify User Three still exists  ===");
      User notFound1  = database.readUser(userOne.getUserID());
      User notFound2  = database.readUser(userTwo.getUserID());
      User foundThree = database.readUser(userThree.getUserID());
      
      assertNull("I shouldn't have found User One, but did.", notFound1);
      assertNull("I shouldn't have found User Two, but did.", notFound2);
      assertNotNull("I should have found User Three, but didn't.", foundThree);
      
      //Delete User Three
      System.out.println ("===  Delete User Three  ===");
      database.deleteUser(userThree.getUserID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert UserDetail One</li>
   * <li>Insert UserDetail Two</li>
   * <li>Read UserDetail One and Verify</li>
   * <li>Read UserDetail Two and Verify</li>
   * <li>Reinsert UserDetail One</li>
   * <li>Upsert UserDetail Three</li>
   * <li>Read UserDetail One and Verify</li>
   * <li>Read UserDetail Three and Verify</li>
   * <li>Modify UserDetail Three Data</li>
   * <li>Update UserDetail Three</li>
   * <li>Read UserDetail Three and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Delete UserDetail One and UserDetail Two</li>
   * <li>Read Nothing for two games, verify UserDetail Three still exists</li>
   * <li>Delete UserDetail Three</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testUserDetails() {
    try {
      //Insert UserDetail One
      System.out.println ("===  Insert UserDetail One  ===");
      UserDetail userOne = MockDataFactory.createUserDetailData(MockDataFactory.USER_ONE_ID);
      database.insertUserDetail(userOne);
      
      //Insert UserDetail Two
      System.out.println ("===  Insert UserDetail Two  ===");
      UserDetail userTwo = MockDataFactory.createUserDetailData(MockDataFactory.USER_TWO_ID);
      database.insertUserDetail(userTwo);

      //Read UserDetail One and Verify
      System.out.println ("===  Read UserDetail One and Verify  ===");
      UserDetail userOne2 = database.readUserDetail(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userOne2);
      assertTrue("The userIDs are not equal", userOne.getUserID() == userOne2.getUserID());
      assertTrue("The passwords don't match", userOne.getPass().equalsIgnoreCase(userOne2.getPass()));
      assertTrue("The userRoles are not equal", userOne.getUserRole() == userOne2.getUserRole());
      assertTrue("The createdOnDates don't match", userOne.getCreatedOnDate().compareTo(userOne2.getCreatedOnDate()) == 0);
      assertTrue("The lastLoginDates don't match", userOne.getLastLoginDate().compareTo(userOne2.getLastLoginDate()) == 0);
      
      //Read UserDetail Two and Verify
      System.out.println ("===  Read UserDetail Two and Verify  ===");
      UserDetail userTwo2 = database.readUserDetail(userTwo.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userTwo2);
      assertTrue("The userIDs are not equal", userTwo.getUserID() == userTwo2.getUserID());
      assertTrue("The passwords don't match", userTwo.getPass().equalsIgnoreCase(userTwo2.getPass()));
      assertTrue("The userRoles are not equal", userTwo.getUserRole() == userTwo2.getUserRole());
      assertTrue("The createdOnDates don't match", userTwo.getCreatedOnDate().compareTo(userTwo2.getCreatedOnDate()) == 0);
      assertTrue("The lastLoginDates don't match", userTwo.getLastLoginDate().compareTo(userTwo2.getLastLoginDate()) == 0);
      
      //Reinsert UserDetail One
      System.out.println ("===  Reinsert UserDetail One  ===");
      database.insertUserDetail(userOne);
      
      //Upsert UserDetail Three
      System.out.println ("===  Upsert UserDetail Three  ===");
      UserDetail userThree = MockDataFactory.createUserDetailData(MockDataFactory.USER_THREE_ID);
      database.updateUserDetail(userThree);
      
      //Read UserDetail One and Verify
      System.out.println ("===  Read UserDetail One and Verify  ===");
      UserDetail userOne3 = database.readUserDetail(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userOne3);
      assertTrue("The userIDs are not equal", userOne.getUserID() == userOne3.getUserID());
      assertTrue("The passwords don't match", userOne.getPass().equalsIgnoreCase(userOne3.getPass()));
      assertTrue("The userRoles are not equal", userOne.getUserRole() == userOne3.getUserRole());
      assertTrue("The createdOnDates don't match", userOne.getCreatedOnDate().compareTo(userOne3.getCreatedOnDate()) == 0);
      assertTrue("The lastLoginDates don't match", userOne.getLastLoginDate().compareTo(userOne3.getLastLoginDate()) == 0);

      //Read UserDetail Three and Verify
      System.out.println ("===  Read UserDetail Three and Verify  ===");
      UserDetail userThree2 = database.readUserDetail(userThree.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userThree2);
      assertTrue("The userIDs are not equal", userThree.getUserID() == userThree2.getUserID());
      assertTrue("The passwords don't match", userThree.getPass().equalsIgnoreCase(userThree2.getPass()));
      assertTrue("The userRoles are not equal", userThree.getUserRole() == userThree2.getUserRole());
      assertTrue("The createdOnDates don't match", userThree.getCreatedOnDate().compareTo(userThree2.getCreatedOnDate()) == 0);
      assertTrue("The lastLoginDates don't match", userThree.getLastLoginDate().compareTo(userThree2.getLastLoginDate()) == 0);

      //Modify UserDetail Three Data and Update
      System.out.println ("===  Modify UserDetail Three Data and Update  ===");
      userThree.setPass("popoioip");
      userThree.setLastLoginDate(new Date());
      
      //Update UserDetail Three
      System.out.println ("===  Update UserDetail Three  ===");
      database.updateUserDetail(userThree);
      
      //Read UserDetail Three and Verify
      System.out.println ("===  Read UserDetail Three and Verify  ===");
      UserDetail userThree3 = database.readUserDetail(userThree.getUserID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", userThree3);
      assertTrue("The passwords don't match", userThree.getPass().equalsIgnoreCase(userThree3.getPass()));
      assertTrue("The userRoles are not equal", userThree.getUserRole() == userThree3.getUserRole());
      assertTrue("The createdOnDates don't match", userThree.getCreatedOnDate().compareTo(userThree3.getCreatedOnDate()) == 0);
      assertTrue("The lastLoginDates don't match", userThree.getLastLoginDate().compareTo(userThree3.getLastLoginDate()) == 0);
      
      //Delete UserDetail One and UserDetail Two
      System.out.println ("===  Delete UserDetail One and UserDetail Two  ===");
      database.deleteUserDetail(userOne.getUserID());
      database.deleteUserDetail(userTwo.getUserID());
      
      //Read Nothing for two games, verify UserDetail Three still exists
      System.out.println ("===  Read Nothing for two games, verify UserDetail Three still exists  ===");
      UserDetail notFound1  = database.readUserDetail(userOne.getUserID());
      UserDetail notFound2  = database.readUserDetail(userTwo.getUserID());
      UserDetail foundThree = database.readUserDetail(userThree.getUserID());
      
      assertNull("I shouldn't have found UserDetail One, but did.", notFound1);
      assertNull("I shouldn't have found UserDetail Two, but did.", notFound2);
      assertNotNull("I should have found UserDetail Three, but didn't.", foundThree);
      
      //Delete UserDetail Three
      System.out.println ("===  Delete UserDetail Three  ===");
      database.deleteUserDetail(userThree.getUserID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of BGG Data operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert CollectionItem One</li>
   * <li>Insert CollectionItem Two</li>
   * <li>Read CollectionItem One and Verify</li>
   * <li>Read CollectionItem Two and Verify</li>
   * <li>Reinsert CollectionItem One</li>
   * <li>Upsert CollectionItem Three</li>
   * <li>Read CollectionItem One and Verify</li>
   * <li>Read CollectionItem Three and Verify</li>
   * <li>Modify CollectionItem Three Data</li>
   * <li>Update CollectionItem Three</li>
   * <li>Read CollectionItem Three and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Delete CollectionItem One and CollectionItem Two</li>
   * <li>Read Nothing for two games, verify CollectionItem Three still exists</li>
   * <li>Delete CollectionItem Three</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testCollectionItems() {
    try {
      //Insert CollectionItem One
      System.out.println ("===  Insert CollectionItem One  ===");
      CollectionItem itemOne = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_ONE_ID);
      database.insertCollectionItem(itemOne);
      
      //Insert CollectionItem Two
      System.out.println ("===  Insert CollectionItem Two  ===");
      CollectionItem itemTwo = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_TWO_ID);
      database.insertCollectionItem(itemTwo);

      //Read CollectionItem One and Verify
      System.out.println ("===  Read CollectionItem One and Verify  ===");
      CollectionItem itemOne2 = database.readCollectionItem(itemOne.getItemID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", itemOne2);
      assertTrue("The itemIDs are not equal", itemOne.getItemID() == itemOne2.getItemID());
      assertTrue("The gameIDs are not equal", itemOne.getGameID() == itemOne2.getGameID());
      assertTrue("The Game Names don't match", itemOne.getGame().getName().equalsIgnoreCase(itemOne2.getGame().getName()));
      assertTrue("The weights are not equal", itemOne.getWeights().size() == itemOne2.getWeights().size());
      assertTrue("The dateAcquireds don't match", itemOne.getDateAcquired() == itemOne2.getDateAcquired());
      assertTrue("The whereAcquired don't match", itemOne.getWhereAcquired() == itemOne2.getWhereAcquired());
      
      //Read CollectionItem Two and Verify
      System.out.println ("===  Read CollectionItem Two and Verify  ===");
      CollectionItem itemTwo2 = database.readCollectionItem(itemTwo.getItemID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", itemTwo2);
      assertTrue("The itemIDs are not equal", itemTwo.getItemID() == itemTwo2.getItemID());
      assertTrue("The gameIDs are not equal", itemTwo.getGameID() == itemTwo2.getGameID());
      assertTrue("The Game Names don't match", itemTwo.getGame().getName().equalsIgnoreCase(itemTwo2.getGame().getName()));
      assertTrue("The weights are not equal", itemTwo.getWeights().size() == itemTwo2.getWeights().size());
      assertTrue("The dateAcquireds don't match", itemTwo.getDateAcquired().compareTo(itemTwo2.getDateAcquired()) == 0);
      assertTrue("The whereAcquired don't match", itemTwo.getWhereAcquired().equalsIgnoreCase(itemTwo2.getWhereAcquired()));
      
      //Reinsert CollectionItem One
      System.out.println ("===  Reinsert CollectionItem One  ===");
      database.insertCollectionItem(itemOne);
      
      //Upsert CollectionItem Three
      System.out.println ("===  Upsert CollectionItem Three  ===");
      CollectionItem itemThree = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_THREE_ID);
      database.updateCollectionItem(itemThree);
      
      //Read CollectionItem One and Verify
      System.out.println ("===  Read CollectionItem One and Verify  ===");
      CollectionItem itemOne3 = database.readCollectionItem(itemOne.getItemID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", itemOne3);
      assertTrue("The itemIDs are not equal", itemOne.getItemID() == itemOne3.getItemID());
      assertTrue("The gameIDs are not equal", itemOne.getGameID() == itemOne3.getGameID());
      assertTrue("The Game Names don't match", itemOne.getGame().getName().equalsIgnoreCase(itemOne3.getGame().getName()));
      assertTrue("The weights are not equal", itemOne.getWeights().size() == itemOne3.getWeights().size());
      assertTrue("The dateAcquireds don't match", itemOne.getDateAcquired() == itemOne3.getDateAcquired());
      assertTrue("The whereAcquired don't match", itemOne.getWhereAcquired() == itemOne3.getWhereAcquired());

      //Read CollectionItem Three and Verify
      System.out.println ("===  Read CollectionItem Three and Verify  ===");
      CollectionItem itemThree2 = database.readCollectionItem(itemThree.getItemID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", itemThree2);
      assertTrue("The itemIDs are not equal", itemThree.getItemID() == itemThree2.getItemID());
      assertTrue("The gameIDs are not equal", itemThree.getGameID() == itemThree2.getGameID());
      assertTrue("The Game Names don't match", itemThree.getGame().getName().equalsIgnoreCase(itemThree2.getGame().getName()));
      assertTrue("The weights are not equal", itemThree.getWeights() == itemThree2.getWeights());
      assertTrue("The dateAcquireds don't match", itemThree.getDateAcquired().compareTo(itemThree2.getDateAcquired()) == 0);
      assertTrue("The whereAcquired don't match", itemThree.getWhereAcquired() == itemThree2.getWhereAcquired());

      //Modify CollectionItem Three Data and Update
      System.out.println ("===  Modify CollectionItem Three Data and Update  ===");
      List<GameWeight> weights = new ArrayList<GameWeight>(2);
      weights.add(GameWeight.FILLER);
      weights.add(GameWeight.SOCIAL);
      itemThree.setWeights(weights);
      itemThree.setWhereAcquired("Somewhere");
      
      //Update CollectionItem Three
      System.out.println ("===  Update CollectionItem Three  ===");
      database.updateCollectionItem(itemThree);
      
      //Read CollectionItem Three and Verify
      System.out.println ("===  Read CollectionItem Three and Verify  ===");
      CollectionItem itemThree3 = database.readCollectionItem(itemThree.getItemID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", itemThree3);
      assertTrue("The weights are not equal", itemThree.getWeights().size() == itemThree3.getWeights().size());
      assertTrue("The whereAcquired don't match", itemThree.getWhereAcquired().equalsIgnoreCase(itemThree3.getWhereAcquired()));
      
      //Delete CollectionItem One and CollectionItem Two
      System.out.println ("===  Delete CollectionItem One and CollectionItem Two  ===");
      database.deleteCollectionItem(itemOne.getItemID());
      database.deleteCollectionItem(itemTwo.getItemID());
      
      //Read Nothing for two games, verify CollectionItem Three still exists
      System.out.println ("===  Read Nothing for two games, verify CollectionItem Three still exists  ===");
      CollectionItem notFound1  = database.readCollectionItem(itemOne.getItemID());
      CollectionItem notFound2  = database.readCollectionItem(itemTwo.getItemID());
      CollectionItem foundThree = database.readCollectionItem(itemThree.getItemID());
      
      assertNull("I shouldn't have found CollectionItem One, but did.", notFound1);
      assertNull("I shouldn't have found CollectionItem Two, but did.", notFound2);
      assertNotNull("I should have found CollectionItem Three, but didn't.", foundThree);
      
      //Delete CollectionItem Three
      System.out.println ("===  Delete CollectionItem Three  ===");
      database.deleteCollectionItem(itemThree.getItemID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }

  /**
   * Method to test features of Collection operations.  The basic steps of this test are:
   * <ol>
   * <li>Insert Collection One</li>
   * <li>Insert Collection Two</li>
   * <li>Read Collection One and Verify</li>
   * <li>Read Collection Two and Verify</li>
   * <li>Reinsert Collection One</li>
   * <li>Upsert Collection Three</li>
   * <li>Read Collection One and Verify</li>
   * <li>Read Collection Three and Verify</li>
   * <li>Modify Collection Three Data</li>
   * <li>Update Collection Three</li>
   * <li>Read Collection Three and Verify</li>
   * <li>Run the IDs select and verify all three games found</li>
   * <li>Delete Collection One and UserDetail Two</li>
   * <li>Read Nothing for two games, verify Collection Three still exists</li>
   * <li>Delete Collection Three</li>
   * <li>Test Complete</li></ol>
   */
  @Test
  public void testCollectionSimple() {
    try {
      //Insert Collection One
      System.out.println ("===  Insert Collection One  ===");
      Collection collectionOne = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_ONE_ID);
      database.insertCollection(collectionOne);
      
      //Insert Collection Two
      System.out.println ("===  Insert Collection Two  ===");
      Collection collectionTwo = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_TWO_ID);
      database.insertCollection(collectionTwo);

      //Read Collection One and Verify
      System.out.println ("===  Read Collection One and Verify  ===");
      Collection collectionOne2 = database.readCollection(collectionOne.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", collectionOne2);
      assertTrue("The collectionIDs are not equal", collectionOne.getCollectionID() == collectionOne2.getCollectionID());
      assertTrue("The games list sizes are not equal", collectionOne.getGames().size() == collectionOne2.getGames().size());
      assertTrue("The baseGameCount are not equal", collectionOne.getBaseGameCount() == collectionOne2.getBaseGameCount());
      assertTrue("The collectibleGameCount are not equal", collectionOne.getCollectibleGameCount() == collectionOne2.getCollectibleGameCount());
      assertTrue("The expansionGameCount are not equal", collectionOne.getExpansionGameCount() == collectionOne2.getExpansionGameCount());
      
      //Read Collection Two and Verify
      System.out.println ("===  Read Collection Two and Verify  ===");
      Collection collectionTwo2 = database.readCollection(collectionTwo.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", collectionTwo2);
      assertTrue("The collectionIDs are not equal", collectionTwo.getCollectionID() == collectionTwo2.getCollectionID());
      assertTrue("The games list sizes are not equal", collectionTwo.getGames().size() == collectionTwo2.getGames().size());
      assertTrue("The baseGameCount are not equal", collectionTwo.getBaseGameCount() == collectionTwo2.getBaseGameCount());
      assertTrue("The collectibleGameCount are not equal", collectionTwo.getCollectibleGameCount() == collectionTwo2.getCollectibleGameCount());
      assertTrue("The expansionGameCount are not equal", collectionTwo.getExpansionGameCount() == collectionTwo2.getExpansionGameCount());
      assertTrue("The gameIDs of the first game are not equal", collectionTwo.getGames().get(0).getGameID() == collectionTwo2.getGames().get(0).getGameID());
      
      //Reinsert Collection One
      System.out.println ("===  Reinsert Collection One  ===");
      database.insertCollection(collectionOne);
      
      //Upsert Collection Three
      System.out.println ("===  Upsert Collection Three  ===");
      Collection collectionThree = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_THREE_ID);
      database.updateCollection(collectionThree);
      
      //Read Collection One and Verify
      System.out.println ("===  Read Collection One and Verify  ===");
      Collection collectionOne3 = database.readCollection(collectionOne.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", collectionOne3);
      assertTrue("The collectionIDs are not equal", collectionOne.getCollectionID() == collectionOne3.getCollectionID());
      assertTrue("The games list sizes are not equal", collectionOne.getGames().size() == collectionOne3.getGames().size());
      assertTrue("The baseGameCount are not equal", collectionOne.getBaseGameCount() == collectionOne3.getBaseGameCount());
      assertTrue("The collectibleGameCount are not equal", collectionOne.getCollectibleGameCount() == collectionOne3.getCollectibleGameCount());
      assertTrue("The expansionGameCount are not equal", collectionOne.getExpansionGameCount() == collectionOne3.getExpansionGameCount());

      //Read Collection Three and Verify
      System.out.println ("===  Read Collection Three and Verify  ===");
      Collection collectionThree2 = database.readCollection(collectionThree.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", collectionThree2);
      assertTrue("The collectionIDs are not equal", collectionThree.getCollectionID() == collectionThree2.getCollectionID());
      assertTrue("The games list sizes are not equal", collectionThree.getGames().size() == collectionThree2.getGames().size());
      assertTrue("The baseGameCount are not equal", collectionThree.getBaseGameCount() == collectionThree2.getBaseGameCount());
      assertTrue("The collectibleGameCount are not equal", collectionThree.getCollectibleGameCount() == collectionThree2.getCollectibleGameCount());
      assertTrue("The expansionGameCount are not equal", collectionThree.getExpansionGameCount() == collectionThree2.getExpansionGameCount());
      assertTrue("The gameIDs of the first game are not equal", collectionThree.getGames().get(0).getGameID() == collectionThree2.getGames().get(0).getGameID());

      //Modify Collection Three Data and Update
      System.out.println ("===  Modify Collection Three Data and Update  ===");
      collectionThree.addGame(MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_TWO_ID));
      
      //Update Collection Three
      System.out.println ("===  Update Collection Three  ===");
      database.updateCollection(collectionThree);
      
      //Read Collection Three and Verify
      System.out.println ("===  Read Collection Three and Verify  ===");
      Collection collectionThree3 = database.readCollection(collectionThree.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", collectionThree3);
      assertTrue("The games list sizes are not equal", collectionThree.getGames().size() == collectionThree3.getGames().size());
      assertTrue("The baseGameCount are not equal", collectionThree.getBaseGameCount() == collectionThree3.getBaseGameCount());
      assertTrue("The collectibleGameCount are not equal", collectionThree.getCollectibleGameCount() == collectionThree3.getCollectibleGameCount());
      assertTrue("The expansionGameCount are not equal", collectionThree.getExpansionGameCount() == collectionThree3.getExpansionGameCount());
      
      //Delete Collection One and Collection Two
      System.out.println ("===  Delete Collection One and Collection Two  ===");
      database.deleteCollection(collectionOne.getCollectionID());
      database.deleteCollection(collectionTwo.getCollectionID());
      
      //Read Nothing for two games, verify Collection Three still exists
      System.out.println ("===  Read Nothing for two games, verify Collection Three still exists  ===");
      Collection notFound1  = database.readCollection(collectionOne.getCollectionID());
      Collection notFound2  = database.readCollection(collectionTwo.getCollectionID());
      Collection foundThree = database.readCollection(collectionThree.getCollectionID());
      
      assertNull("I shouldn't have found Collection One, but did.", notFound1);
      assertNull("I shouldn't have found Collection Two, but did.", notFound2);
      assertNotNull("I should have found Collection Three, but didn't.", foundThree);
      
      //Delete Collection Three
      System.out.println ("===  Delete Collection Three  ===");
      database.deleteCollection(collectionThree.getCollectionID());
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }
  
  /**
   * This method is going to work a little different.  We're going to test adding each stat type, but
   * this test is simpler than the others, because there is no update method to support
   */
  @Test
  public void testStats() {
    try {
      //Insert BGGGameStats
      System.out.println ("===  Insert BGGGameStats  ===");
      BGGGameStats bggStats = MockDataFactory.createBGGGameStats();
      database.insertBGGGameStats(bggStats);
      
      //Insert CSIDataStats
      System.out.println ("===  Insert CSIDataStats  ===");
      CSIDataStats csiStats = MockDataFactory.createCSIDataStats();
      database.insertCSIDataStats(csiStats);

      //Read CSIDataStats and Verify
      System.out.println ("===  Read BGGGameStats and Verify  ===");
      BGGGameStats bggStats2 = database.readBGGGameStats();
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", bggStats2);
      assertTrue("The baseGameCounts are not equal", bggStats.getBaseGameCount() == bggStats2.getBaseGameCount());
      assertTrue("The expansionGameCounts are not equal", bggStats.getExpansionGameCount() == bggStats2.getExpansionGameCount());
      assertTrue("The collectibleGameCounts are not equal", bggStats.getCollectibleGameCount() == bggStats2.getCollectibleGameCount());
      assertTrue("The approvedCounts are not equal", bggStats.getApprovedCount() == bggStats2.getApprovedCount());
      assertTrue("The rejectedCounts are not equal", bggStats.getRejectedCount() == bggStats2.getRejectedCount());
      assertTrue("The pendingCounts are not equal", bggStats.getPendingCount() == bggStats2.getPendingCount());
      
      //Read CSIDataStats and Verify
      System.out.println ("===  Read CSIDataStats and Verify  ===");
      CSIDataStats csiStats2 = database.readCSIDataStats();
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", csiStats2);
      assertTrue("The boardGameCounts are not equal", csiStats.getBoardGameCount() == csiStats2.getBoardGameCount());
      assertTrue("The collectibleGameCounts are not equal", csiStats.getCollectibleGameCount() == csiStats2.getCollectibleGameCount());
      assertTrue("The diceMastersCounts are not equal", csiStats.getDiceMastersCount() == csiStats2.getDiceMastersCount());
      assertTrue("The rpgCounts are not equal", csiStats.getRpgCount() == csiStats2.getRpgCount());
      assertTrue("The lcgCounts are not equal", csiStats.getLcgCount() == csiStats2.getLcgCount());
      assertTrue("The suppliesCounts are not equal", csiStats.getSuppliesCount() == csiStats2.getSuppliesCount());
      assertTrue("The miniatureCounts are not equal", csiStats.getMiniatureCount() == csiStats2.getMiniatureCount());
      assertTrue("The videoGameCounts are not equal", csiStats.getVideoGameCount() == csiStats2.getVideoGameCount());
      assertTrue("The unknownCounts are not equal", csiStats.getUnknownCount() == csiStats2.getUnknownCount());
      assertTrue("The approvedCounts are not equal", csiStats.getApprovedCount() == csiStats2.getApprovedCount());
      assertTrue("The rejectedCounts are not equal", csiStats.getRejectedCount() == csiStats2.getRejectedCount());
      assertTrue("The pendingCounts are not equal", csiStats.getPendingCount() == csiStats2.getPendingCount());
      
      //Reinsert BGGGameStats
      System.out.println ("===  Reinsert BGGGameStats  ===");
      database.insertBGGGameStats(bggStats);
      
      //Upsert MMDataStats
      System.out.println ("===  Upsert MMDataStats  ===");
      MMDataStats mmStats = MockDataFactory.createMMDataStats();
      database.insertMMDataStats(mmStats);
      
      //Read BGGGameStats and Verify
      System.out.println ("===  Read BGGGameStats and Verify  ===");
      BGGGameStats bggStats3 = database.readBGGGameStats();
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", bggStats3);
      assertTrue("The baseGameCounts are not equal", bggStats.getBaseGameCount() == bggStats3.getBaseGameCount());
      assertTrue("The expansionGameCounts are not equal", bggStats.getExpansionGameCount() == bggStats3.getExpansionGameCount());
      assertTrue("The collectibleGameCounts are not equal", bggStats.getCollectibleGameCount() == bggStats3.getCollectibleGameCount());
      assertTrue("The approvedCounts are not equal", bggStats.getApprovedCount() == bggStats3.getApprovedCount());
      assertTrue("The rejectedCounts are not equal", bggStats.getRejectedCount() == bggStats3.getRejectedCount());
      assertTrue("The pendingCounts are not equal", bggStats.getPendingCount() == bggStats3.getPendingCount());

      //Read MMDataStats and Verify
      System.out.println ("===  Read MMDataStats and Verify  ===");
      MMDataStats mmStats2 = database.readMMDataStats();
      
      //Spot checking as opposed to all possible values.
      assertNotNull("I didn't find my result", mmStats2);
      assertTrue("The boardGameCounts are not equal", mmStats.getBoardGameCount() == mmStats2.getBoardGameCount());
      assertTrue("The tableTopCounts are not equal", mmStats.getTableTopCount() == mmStats2.getTableTopCount());
      assertTrue("The ccgCounts are not equal", mmStats.getCcgCount() == mmStats2.getCcgCount());
      assertTrue("The collectiblesCounts are not equal", mmStats.getCollectiblesCount() == mmStats2.getCollectiblesCount());
      assertTrue("The rpgCounts are not equal", mmStats.getRpgCount() == mmStats2.getRpgCount());
      assertTrue("The accessoriesCounts are not equal", mmStats.getAccessoriesCount() == mmStats2.getAccessoriesCount());
      assertTrue("The unknownCounts are not equal", mmStats.getUnknownCount() == mmStats2.getUnknownCount());
      assertTrue("The approvedCounts are not equal", mmStats.getApprovedCount() == mmStats2.getApprovedCount());
      assertTrue("The rejectedCounts are not equal", mmStats.getRejectedCount() == mmStats2.getRejectedCount());
      assertTrue("The pendingCounts are not equal", mmStats.getPendingCount() == mmStats2.getPendingCount());

      //Delete BGGGameStats and CSIDataStats
      System.out.println ("===  Delete BGGGameStats and CSIDataStats  ===");
      database.deleteStatsRow(BGGGameStats.BGG_GAME_STATS);
      database.deleteStatsRow(CSIDataStats.CSI_DATA_STATS);
      
      //Read Nothing for two games, verify MMDataStats still exists
      System.out.println ("===  Read Nothing for two games, verify MMDataStats still exists  ===");
      BGGGameStats notFound1 = database.readBGGGameStats();
      CSIDataStats notFound2 = database.readCSIDataStats();
      MMDataStats foundThree = database.readMMDataStats();
      
      assertNull("I shouldn't have found BGGGameStats, but did.", notFound1);
      assertNull("I shouldn't have found CSIDataStats, but did.", notFound2);
      assertNotNull("I should have found MMDataStats, but didn't.", foundThree);
      
      //Delete Collection Three
      System.out.println ("===  Delete MMDataStats  ===");
      database.deleteStatsRow(MMDataStats.MM_DATA_STATS);
      
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }
}
