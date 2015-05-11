/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.test;

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
public class TestMongoGamesDatabase extends TestCase {static class __CLR3_3_03qs3qsi96a4z34{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525819932L,8589935092L,5711,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_cenqua_clover.TestNameSniffer __CLR3_3_0_TEST_NAME_SNIFFER=com_cenqua_clover.TestNameSniffer.NULL_INSTANCE;

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
  protected void setUp() throws Exception {try{__CLR3_3_03qs3qsi96a4z34.R.inc(4852);
    //Attempting to initialize Database connection for test
    __CLR3_3_03qs3qsi96a4z34.R.inc(4853);System.out.println ("Initializing Database Connection...");
    
    __CLR3_3_03qs3qsi96a4z34.R.inc(4854);database = MongoDBFactory.createMongoGamesDatabase(mongoHostAddress, mongoPort, databaseName);
    //database = MongoDBFactory.createMongoGamesDatabase(mongoTrueHostAddress, mongoPort, databaseName);
    __CLR3_3_03qs3qsi96a4z34.R.inc(4855);database.initializeDBConnection();
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
  
  /*
   * (non-Javadoc)
   * @see junit.framework.TestCase#tearDown()
   */
  @Override
  protected void tearDown() throws Exception {try{__CLR3_3_03qs3qsi96a4z34.R.inc(4856);
    //Closing Database connection for test
    __CLR3_3_03qs3qsi96a4z34.R.inc(4857);System.out.println ("Initializing Database Disconnect...");
    
    __CLR3_3_03qs3qsi96a4z34.R.inc(4858);database.closeDBConnection();
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
  
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
  public void testBGGData() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),4859);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0fiidnl3qz();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testBGGData",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),4859,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0fiidnl3qz(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(4859);
    //MongoGamesDatabase.debugMode = true;
    __CLR3_3_03qs3qsi96a4z34.R.inc(4860);try {
      //Insert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(4861);System.out.println ("===  Insert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4862);BGGGame cosmicEncounter = MockDataFactory.createBGGGame(MockDataFactory.BGG_COSMIC_ENCOUNTER_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4863);database.insertBGGGameData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(4864);System.out.println ("===  Insert Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4865);BGGGame cosmicIncursion = MockDataFactory.createBGGGame(MockDataFactory.BGG_COSMIC_INCURSION_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4866);database.insertBGGGameData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4867);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4868);BGGGame cosmicEncounter2 = database.readBGGGameData(cosmicEncounter.getBggID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4869);assertNotNull("I didn't find my result", cosmicEncounter2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4870);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4871);assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4872);assertTrue("The bggRatings are not equal", cosmicEncounter.getBggRating() == cosmicEncounter2.getBggRating());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4873);assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4874);assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter2.getExpansionIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4875);assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter2.getGameType());
      
      //Read Cosmic Incursion and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4876);System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4877);BGGGame cosmicIncursion2 = database.readBGGGameData(cosmicIncursion.getBggID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4878);assertNotNull("I didn't find my result", cosmicIncursion2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4879);assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4880);assertTrue("The names are not equal", cosmicIncursion.getName().equalsIgnoreCase(cosmicIncursion2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4881);assertTrue("The bggRatings are not equal", cosmicIncursion.getBggRating() == cosmicIncursion2.getBggRating());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4882);assertTrue("The publishers lists are not equal", cosmicIncursion.getPublishers().size() == cosmicIncursion2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4883);assertTrue("The parentGameIDs are not equal", cosmicIncursion.getParentGameID() == cosmicIncursion2.getParentGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4884);assertTrue("The GameTypes are not equal", cosmicIncursion.getGameType() == cosmicIncursion2.getGameType());
      
      //Reinsert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(4885);System.out.println ("===  Reinsert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4886);database.insertBGGGameData(cosmicEncounter);
      
      //Upsert Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(4887);System.out.println ("===  Upsert Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4888);BGGGame abyss = MockDataFactory.createBGGGame(MockDataFactory.BGG_ABYSS_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4889);database.updateBGGGameData(abyss);
      
      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4890);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4891);BGGGame cosmicEncounter3 = database.readBGGGameData(cosmicEncounter.getBggID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4892);assertNotNull("I didn't find my result", cosmicEncounter3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4893);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4894);assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter3.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4895);assertTrue("The bggRatings are not equal", cosmicEncounter.getBggRating() == cosmicEncounter3.getBggRating());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4896);assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter3.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4897);assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter3.getExpansionIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4898);assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter3.getGameType());

      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4899);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4900);BGGGame abyss2 = database.readBGGGameData(abyss.getBggID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4901);assertNotNull("I didn't find my result", abyss2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4902);assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4903);assertTrue("The names are not equal", abyss.getName().equalsIgnoreCase(abyss2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4904);assertTrue("The bggRatings are not equal", abyss.getBggRating() == abyss2.getBggRating());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4905);assertTrue("The publishers lists are not equal", abyss.getPublishers().size() == abyss2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4906);assertNull("The first expansionList was not empty", abyss.getExpansionIDs());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4907);assertNull("The second expansionList was not empty", abyss2.getExpansionIDs());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4908);assertTrue("The GameTypes are not equal", abyss.getGameType() == abyss2.getGameType());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4909);assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4910);assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4911);assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(4912);System.out.println ("===  Modify Abyss Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4913);abyss.setMaxPlayingTime(abyss.getMaxPlayingTime() + 45);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4914);abyss.setBggRatingUsers(abyss.getBggRatingUsers() + 400);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4915);abyss.setBggRank(2321);
      
      //Update Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(4916);System.out.println ("===  Update Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4917);database.updateBGGGameData(abyss);
      
      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4918);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4919);BGGGame abyss3 = database.readBGGGameData(abyss.getBggID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4920);assertNotNull("I didn't find my result", abyss3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4921);assertTrue("The maxPlayingTimes are not equal", abyss.getMaxPlayingTime() == abyss3.getMaxPlayingTime());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4922);assertTrue("The bggRatingsUsers are not equal", abyss.getBggRating() == abyss3.getBggRating());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4923);assertTrue("The bggRanks are not equal", abyss.getBggRank() == abyss3.getBggRank());
      
      //Run the IDs select and verify all three games found
      __CLR3_3_03qs3qsi96a4z34.R.inc(4924);System.out.println ("===  Run the IDs select and verify all three games found  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4925);List<Long> bggIDList = database.getBggIDList();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4926);assertNotNull("I didn't get an ID List", bggIDList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4927);assertTrue("My List didn't contain Cosmic Encounter", bggIDList.contains(MockDataFactory.BGG_COSMIC_ENCOUNTER_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4928);assertTrue("My List didn't contain Cosmic Incursion", bggIDList.contains(MockDataFactory.BGG_COSMIC_INCURSION_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4929);assertTrue("My List didn't contain Abyss", bggIDList.contains(MockDataFactory.BGG_ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      __CLR3_3_03qs3qsi96a4z34.R.inc(4930);System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4931);long maxValue = database.getMaxBGGGameID();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4932);assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.BGG_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      __CLR3_3_03qs3qsi96a4z34.R.inc(4933);System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4934);int count = database.getBGGGameCount();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4935);assertTrue("I got a value other than I was expecting for maxValue", count == 3);
      
      //Delete Cosmic Encounter and Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(4936);System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4937);database.deleteBGGGameData(cosmicEncounter.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4938);database.deleteBGGGameData(cosmicIncursion.getBggID());
      
      //Read Nothing for two games, verify Abyss still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(4939);System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4940);BGGGame notFound1  = database.readBGGGameData(cosmicEncounter.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4941);BGGGame notFound2  = database.readBGGGameData(cosmicIncursion.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4942);BGGGame foundAbyss = database.readBGGGameData(abyss.getBggID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(4943);assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4944);assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4945);assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(4946);System.out.println ("===  Delete Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4947);database.deleteBGGGameData(abyss.getBggID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(4948);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4949);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(4950);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4951);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(4952);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(4953);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testCSIData() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),4954);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0pm829k3tm();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testCSIData",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),4954,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0pm829k3tm(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(4954);
    //MongoGamesDatabase.debugMode = true;
    __CLR3_3_03qs3qsi96a4z34.R.inc(4955);try {
      //Insert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(4956);System.out.println ("===  Insert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4957);CoolStuffIncPriceData cosmicEncounter = MockDataFactory.createCSIData(MockDataFactory.CSI_COSMIC_ENCOUNTER_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4958);database.insertCSIPriceData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(4959);System.out.println ("===  Insert Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4960);CoolStuffIncPriceData cosmicIncursion = MockDataFactory.createCSIData(MockDataFactory.CSI_COSMIC_INCURSION_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4961);database.insertCSIPriceData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4962);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4963);CoolStuffIncPriceData cosmicEncounter2 = database.readCSIPriceData(cosmicEncounter.getCsiID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4964);assertNotNull("I didn't find my result", cosmicEncounter2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4965);assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiID() == cosmicEncounter2.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4966);assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4967);assertTrue("The publishers are not equal", cosmicEncounter.getPublisher().equalsIgnoreCase(cosmicEncounter2.getPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4968);assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4969);assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4970);assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4971);assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter2.getAvailability());
      
      //Read Cosmic Incursion and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4972);System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4973);CoolStuffIncPriceData cosmicIncursion2 = database.readCSIPriceData(cosmicIncursion.getCsiID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4974);assertNotNull("I didn't find my result", cosmicIncursion2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4975);assertTrue("The csiIDs are not equal", cosmicIncursion.getCsiID() == cosmicIncursion2.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4976);assertTrue("The titles are not equal", cosmicIncursion.getTitle().equalsIgnoreCase(cosmicIncursion2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4977);assertTrue("The publishers are not equal", cosmicIncursion.getPublisher().equalsIgnoreCase(cosmicIncursion2.getPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4978);assertTrue("The categories are not equal", cosmicIncursion.getCategory() == cosmicIncursion2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4979);assertTrue("The skus are not equal", cosmicIncursion.getSku().equalsIgnoreCase(cosmicIncursion2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4980);assertTrue("The curPrices are not equal", cosmicIncursion.getCurPrice() == cosmicIncursion2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4981);assertTrue("The GameAvailabilities are not equal", cosmicIncursion.getAvailability() == cosmicIncursion2.getAvailability());
      
      //Reinsert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(4982);System.out.println ("===  Reinsert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4983);database.insertCSIPriceData(cosmicEncounter);
      
      //Upsert Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(4984);System.out.println ("===  Upsert Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4985);CoolStuffIncPriceData abyss = MockDataFactory.createCSIData(MockDataFactory.CSI_ABYSS_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4986);database.updateCSIPriceData(abyss);
      
      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4987);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4988);CoolStuffIncPriceData cosmicEncounter3 = database.readCSIPriceData(cosmicEncounter.getCsiID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4989);assertNotNull("I didn't find my result", cosmicEncounter3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(4990);assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiID() == cosmicEncounter3.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4991);assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter3.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4992);assertTrue("The publishers are not equal", cosmicEncounter.getPublisher().equalsIgnoreCase(cosmicEncounter3.getPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4993);assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter3.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4994);assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter3.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(4995);assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter3.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(4996);assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter3.getAvailability());

      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(4997);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(4998);CoolStuffIncPriceData abyss2 = database.readCSIPriceData(abyss.getCsiID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(4999);assertNotNull("I didn't find my result", abyss2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5000);assertTrue("The csiIDs are not equal", abyss.getCsiID() == abyss2.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5001);assertTrue("The titles are not equal", abyss.getTitle().equalsIgnoreCase(abyss2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5002);assertTrue("The publishers are not equal", abyss.getPublisher().equalsIgnoreCase(abyss2.getPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5003);assertTrue("The skus are not equal", abyss.getSku().equalsIgnoreCase(abyss2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5004);assertTrue("The categories are not equal", abyss.getCategory() == abyss2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5005);assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5006);assertTrue("The GameAvailabilities are not equal", abyss.getAvailability() == abyss2.getAvailability());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5007);assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5008);assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5009);assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5010);System.out.println ("===  Modify Abyss Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5011);abyss.setCurPrice(abyss.getCurPrice() + 12.75);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5012);abyss.setAvailability(GameAvailability.PREORDER);
      
      //Update Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5013);System.out.println ("===  Update Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5014);database.updateCSIPriceData(abyss);
      
      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5015);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5016);CoolStuffIncPriceData abyss3 = database.readCSIPriceData(abyss.getCsiID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5017);assertNotNull("I didn't find my result", abyss3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5018);assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss3.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5019);assertTrue("The availabilities are not equal", abyss.getAvailability() == abyss3.getAvailability());
      
      //Run the IDs select and verify all three games found
      __CLR3_3_03qs3qsi96a4z34.R.inc(5020);System.out.println ("===  Run the IDs select and verify all three games found  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5021);List<Long> csiIDList = database.getCSIIDList();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5022);assertNotNull("I didn't get an ID List", csiIDList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5023);assertTrue("My List didn't contain Cosmic Encounter", csiIDList.contains(MockDataFactory.CSI_COSMIC_ENCOUNTER_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5024);assertTrue("My List didn't contain Cosmic Incursion", csiIDList.contains(MockDataFactory.CSI_COSMIC_INCURSION_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5025);assertTrue("My List didn't contain Abyss", csiIDList.contains(MockDataFactory.CSI_ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      __CLR3_3_03qs3qsi96a4z34.R.inc(5026);System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5027);long maxValue = database.getMaxCSIDataID();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5028);assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.CSI_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      __CLR3_3_03qs3qsi96a4z34.R.inc(5029);System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5030);int count = database.getCSIDataCount();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5031);assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5032);System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5033);database.deleteCSIPriceData(cosmicEncounter.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5034);database.deleteCSIPriceData(cosmicIncursion.getCsiID());
      
      //Read Nothing for two games, verify Abyss still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5035);System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5036);CoolStuffIncPriceData notFound1  = database.readCSIPriceData(cosmicEncounter.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5037);CoolStuffIncPriceData notFound2  = database.readCSIPriceData(cosmicIncursion.getCsiID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5038);CoolStuffIncPriceData foundAbyss = database.readCSIPriceData(abyss.getCsiID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5039);assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5040);assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5041);assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5042);System.out.println ("===  Delete Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5043);database.deleteCSIPriceData(abyss.getCsiID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5044);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5045);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5046);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5047);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5048);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5049);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testMMData() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5050);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0iuhjul3wa();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testMMData",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5050,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0iuhjul3wa(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5050);
    //MongoGamesDatabase.debugMode = true;
    __CLR3_3_03qs3qsi96a4z34.R.inc(5051);try {
      //Insert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5052);System.out.println ("===  Insert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5053);MiniatureMarketPriceData cosmicEncounter = MockDataFactory.createMMData(MockDataFactory.MM_COSMIC_ENCOUNTER_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5054);database.insertMMPriceData(cosmicEncounter);
      
      //Insert Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5055);System.out.println ("===  Insert Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5056);MiniatureMarketPriceData cosmicIncursion = MockDataFactory.createMMData(MockDataFactory.MM_COSMIC_INCURSION_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5057);database.insertMMPriceData(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5058);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5059);MiniatureMarketPriceData cosmicEncounter2 = database.readMMPriceData(cosmicEncounter.getMmID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5060);assertNotNull("I didn't find my result", cosmicEncounter2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5061);assertTrue("The mmIDs are not equal", cosmicEncounter.getMmID() == cosmicEncounter2.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5062);assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5063);assertTrue("The manufacturers are not equal", cosmicEncounter.getManufacturer().equalsIgnoreCase(cosmicEncounter2.getManufacturer()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5064);assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5065);assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5066);assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5067);assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter2.getAvailability());
      
      //Read Cosmic Incursion and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5068);System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5069);MiniatureMarketPriceData cosmicIncursion2 = database.readMMPriceData(cosmicIncursion.getMmID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5070);assertNotNull("I didn't find my result", cosmicIncursion2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5071);assertTrue("The mmIDs are not equal", cosmicIncursion.getMmID() == cosmicIncursion2.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5072);assertTrue("The titles are not equal", cosmicIncursion.getTitle().equalsIgnoreCase(cosmicIncursion2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5073);assertTrue("The manufacturers are not equal", cosmicIncursion.getManufacturer().equalsIgnoreCase(cosmicIncursion2.getManufacturer()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5074);assertTrue("The categories are not equal", cosmicIncursion.getCategory() == cosmicIncursion2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5075);assertTrue("The skus are not equal", cosmicIncursion.getSku().equalsIgnoreCase(cosmicIncursion2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5076);assertTrue("The curPrices are not equal", cosmicIncursion.getCurPrice() == cosmicIncursion2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5077);assertTrue("The GameAvailabilities are not equal", cosmicIncursion.getAvailability() == cosmicIncursion2.getAvailability());
      
      //Reinsert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5078);System.out.println ("===  Reinsert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5079);database.insertMMPriceData(cosmicEncounter);
      
      //Upsert Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5080);System.out.println ("===  Upsert Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5081);MiniatureMarketPriceData abyss = MockDataFactory.createMMData(MockDataFactory.MM_ABYSS_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5082);database.updateMMPriceData(abyss);
      
      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5083);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5084);MiniatureMarketPriceData cosmicEncounter3 = database.readMMPriceData(cosmicEncounter.getMmID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5085);assertNotNull("I didn't find my result", cosmicEncounter3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5086);assertTrue("The mmIDs are not equal", cosmicEncounter.getMmID() == cosmicEncounter3.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5087);assertTrue("The titles are not equal", cosmicEncounter.getTitle().equalsIgnoreCase(cosmicEncounter3.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5088);assertTrue("The manufacturers are not equal", cosmicEncounter.getManufacturer().equalsIgnoreCase(cosmicEncounter3.getManufacturer()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5089);assertTrue("The categories are not equal", cosmicEncounter.getCategory() == cosmicEncounter3.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5090);assertTrue("The skus are not equal", cosmicEncounter.getSku().equalsIgnoreCase(cosmicEncounter3.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5091);assertTrue("The curPrices are not equal", cosmicEncounter.getCurPrice() == cosmicEncounter3.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5092);assertTrue("The GameAvailabilities are not equal", cosmicEncounter.getAvailability() == cosmicEncounter3.getAvailability());

      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5093);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5094);MiniatureMarketPriceData abyss2 = database.readMMPriceData(abyss.getMmID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5095);assertNotNull("I didn't find my result", abyss2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5096);assertTrue("The mmIDs are not equal", abyss.getMmID() == abyss2.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5097);assertTrue("The titles are not equal", abyss.getTitle().equalsIgnoreCase(abyss2.getTitle()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5098);assertTrue("The manufacturers are not equal", abyss.getManufacturer().equalsIgnoreCase(abyss2.getManufacturer()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5099);assertTrue("The categories are not equal", abyss.getCategory() == abyss2.getCategory());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5100);assertTrue("The skus are not equal", abyss.getSku().equalsIgnoreCase(abyss2.getSku()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5101);assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss2.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5102);assertTrue("The GameAvailabilities are not equal", abyss.getAvailability() == abyss2.getAvailability());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5103);assertTrue("The ReviewStates are not equal", abyss.getReviewState() == abyss2.getReviewState());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5104);assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5105);assertTrue("The reviewDates are not equal", abyss.getReviewDate().getTime() == abyss2.getReviewDate().getTime());

      //Modify Abyss Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5106);System.out.println ("===  Modify Abyss Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5107);abyss.setCurPrice(abyss.getCurPrice() + 12.75);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5108);abyss.setAvailability(GameAvailability.PREORDER);
      
      //Update Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5109);System.out.println ("===  Update Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5110);database.updateMMPriceData(abyss);
      
      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5111);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5112);MiniatureMarketPriceData abyss3 = database.readMMPriceData(abyss.getMmID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5113);assertNotNull("I didn't find my result", abyss3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5114);assertTrue("The curPrices are not equal", abyss.getCurPrice() == abyss3.getCurPrice());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5115);assertTrue("The availabilities are not equal", abyss.getAvailability() == abyss3.getAvailability());
      
      //Run the IDs select and verify all three games found
      __CLR3_3_03qs3qsi96a4z34.R.inc(5116);System.out.println ("===  Run the IDs select and verify all three games found  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5117);List<Long> mmIDList = database.getMMIDList();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5118);assertNotNull("I didn't get an ID List", mmIDList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5119);assertTrue("My List didn't contain Cosmic Encounter", mmIDList.contains(MockDataFactory.MM_COSMIC_ENCOUNTER_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5120);assertTrue("My List didn't contain Cosmic Incursion", mmIDList.contains(MockDataFactory.MM_COSMIC_INCURSION_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5121);assertTrue("My List didn't contain Abyss", mmIDList.contains(MockDataFactory.MM_ABYSS_ID));

      //Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned
      __CLR3_3_03qs3qsi96a4z34.R.inc(5122);System.out.println ("===  Run the Max ID Query and verify that the largest id value (in this case, Abyss) is returned  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5123);long maxValue = database.getMaxMMDataID();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5124);assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.MM_ABYSS_ID);
      
      //Run the Count Query and Verify we got three games
      __CLR3_3_03qs3qsi96a4z34.R.inc(5125);System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5126);int count = database.getMMDataCount();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5127);assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5128);System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5129);database.deleteMMPriceData(cosmicEncounter.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5130);database.deleteMMPriceData(cosmicIncursion.getMmID());
      
      //Read Nothing for two games, verify Abyss still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5131);System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5132);MiniatureMarketPriceData notFound1  = database.readMMPriceData(cosmicEncounter.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5133);MiniatureMarketPriceData notFound2  = database.readMMPriceData(cosmicIncursion.getMmID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5134);MiniatureMarketPriceData foundAbyss = database.readMMPriceData(abyss.getMmID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5135);assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5136);assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5137);assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5138);System.out.println ("===  Delete Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5139);database.deleteMMPriceData(abyss.getMmID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5140);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5141);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5142);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5143);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5144);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5145);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testGameData() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5146);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_08tzt9x3yy();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testGameData",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5146,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_08tzt9x3yy(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5146);
    //MongoGamesDatabase.debugMode = true;
    __CLR3_3_03qs3qsi96a4z34.R.inc(5147);try {
      //Insert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5148);System.out.println ("===  Insert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5149);Game cosmicEncounter = MockDataFactory.createGameData(MockDataFactory.COSMIC_ENCOUNTER_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5150);database.insertGame(cosmicEncounter);
      
      //Insert Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5151);System.out.println ("===  Insert Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5152);Game cosmicIncursion = MockDataFactory.createGameData(MockDataFactory.COSMIC_INCURSION_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5153);database.insertGame(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5154);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5155);Game cosmicEncounter2 = database.readGame(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5156);assertNotNull("I didn't find my result", cosmicEncounter2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5157);assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5158);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5159);assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5160);assertTrue("The primaryPublishers are not equal", cosmicEncounter.getPrimaryPublisher().equalsIgnoreCase(cosmicEncounter2.getPrimaryPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5161);assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5162);assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter2.getExpansionIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5163);assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter2.getGameType());
      
      //Read Cosmic Incursion and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5164);System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5165);Game cosmicIncursion2 = database.readGame(cosmicIncursion.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5166);assertNotNull("I didn't find my result", cosmicIncursion2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5167);assertTrue("The gameIDs are not equal", cosmicIncursion.getGameID() == cosmicIncursion2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5168);assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5169);assertTrue("The names are not equal", cosmicIncursion.getName().equalsIgnoreCase(cosmicIncursion2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5170);assertTrue("The primaryPublishers are not equal", cosmicIncursion.getPrimaryPublisher().equalsIgnoreCase(cosmicIncursion2.getPrimaryPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5171);assertTrue("The publishers lists are not equal", cosmicIncursion.getPublishers().size() == cosmicIncursion2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5172);assertTrue("The parentGameIDs are not equal", cosmicIncursion.getParentGameID() == cosmicIncursion2.getParentGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5173);assertTrue("The GameTypes are not equal", cosmicIncursion.getGameType() == cosmicIncursion2.getGameType());
      
      //Reinsert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5174);System.out.println ("===  Reinsert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5175);database.insertGame(cosmicEncounter);
      
      //Upsert Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5176);System.out.println ("===  Upsert Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5177);Game abyss = MockDataFactory.createGameData(MockDataFactory.ABYSS_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5178);database.updateGame(abyss);
      
      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5179);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5180);Game cosmicEncounter3 = database.readGame(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5181);assertNotNull("I didn't find my result", cosmicEncounter3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5182);assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter3.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5183);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5184);assertTrue("The names are not equal", cosmicEncounter.getName().equalsIgnoreCase(cosmicEncounter3.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5185);assertTrue("The primaryPublishers are not equal", cosmicEncounter.getPrimaryPublisher().equalsIgnoreCase(cosmicEncounter3.getPrimaryPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5186);assertTrue("The publishers lists are not equal", cosmicEncounter.getPublishers().size() == cosmicEncounter3.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5187);assertTrue("The expansion lists are not equal", cosmicEncounter.getExpansionIDs().size() == cosmicEncounter3.getExpansionIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5188);assertTrue("The GameTypes are not equal", cosmicEncounter.getGameType() == cosmicEncounter3.getGameType());

      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5189);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5190);Game abyss2 = database.readGame(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5191);assertNotNull("I didn't find my result", abyss2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5192);assertTrue("The gameIDs are not equal", abyss.getGameID() == abyss2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5193);assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5194);assertTrue("The names are not equal", abyss.getName().equalsIgnoreCase(abyss2.getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5195);assertTrue("The primaryPublishers are not equal", abyss.getPrimaryPublisher().equalsIgnoreCase(abyss2.getPrimaryPublisher()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5196);assertTrue("The publishers lists are not equal", abyss.getPublishers().size() == abyss2.getPublishers().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5197);assertNull("The first expansionList was not empty", abyss.getExpansionIDs());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5198);assertNull("The second expansionList was not empty", abyss2.getExpansionIDs());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5199);assertTrue("The GameTypes are not equal", abyss.getGameType() == abyss2.getGameType());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5200);assertTrue("The addDates are not equal", abyss.getAddDate().getTime() == abyss2.getAddDate().getTime());

      //Modify Abyss Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5201);System.out.println ("===  Modify Abyss Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5202);abyss.setMaxPlayingTime(abyss.getMaxPlayingTime() + 45);
      
      //Update Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5203);System.out.println ("===  Update Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5204);database.updateGame(abyss);
      
      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5205);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5206);Game abyss3 = database.readGame(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5207);assertNotNull("I didn't find my result", abyss3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5208);assertTrue("The maxPlayingTimes are not equal", abyss.getMaxPlayingTime() == abyss3.getMaxPlayingTime());
      
      //Run the IDs select and verify all three games found
      __CLR3_3_03qs3qsi96a4z34.R.inc(5209);System.out.println ("===  Run the IDs select and verify all three games found  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5210);List<Long> gameIDList = database.getGameIDList();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5211);assertNotNull("I didn't get an ID List", gameIDList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5212);assertTrue("My List didn't contain Cosmic Encounter", gameIDList.contains(MockDataFactory.COSMIC_ENCOUNTER_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5213);assertTrue("My List didn't contain Cosmic Incursion", gameIDList.contains(MockDataFactory.COSMIC_INCURSION_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5214);assertTrue("My List didn't contain Abyss", gameIDList.contains(MockDataFactory.ABYSS_ID));
      
      //Run the Max ID Query and verify that the largest id value (in this case, Cosmic Incursion) is returned
      __CLR3_3_03qs3qsi96a4z34.R.inc(5215);System.out.println ("===  Run the Max ID Query and verify that the largest id value is returned  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5216);long maxValue = database.getMaxGameID();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5217);assertTrue("I got a value other than I was expecting for maxValue", maxValue == MockDataFactory.COSMIC_INCURSION_ID);
      
      //Run the Count Query and Verify we got three games
      __CLR3_3_03qs3qsi96a4z34.R.inc(5218);System.out.println ("===  Run the Count Query and Verify we got three games  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5219);int count = database.getGameCount();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5220);assertTrue("I got a value other than I was expecting for maxValue", count == 3);

      //Delete Cosmic Encounter and Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5221);System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5222);database.deleteGame(cosmicEncounter.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5223);database.deleteGame(cosmicIncursion.getGameID());
      
      //Read Nothing for two games, verify Abyss still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5224);System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5225);Game notFound1  = database.readGame(cosmicEncounter.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5226);Game notFound2  = database.readGame(cosmicIncursion.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5227);Game foundAbyss = database.readGame(abyss.getGameID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5228);assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5229);assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5230);assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5231);System.out.println ("===  Delete Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5232);database.deleteGame(abyss.getGameID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5233);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5234);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5235);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5236);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5237);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5238);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
  
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
  public void testGameReltnData() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5239);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0yy02dc41j();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testGameReltnData",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5239,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0yy02dc41j(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5239);
    //MongoGamesDatabase.debugMode = true;
    __CLR3_3_03qs3qsi96a4z34.R.inc(5240);try {
      //Insert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5241);System.out.println ("===  Insert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5242);GameReltn cosmicEncounter = MockDataFactory.createGameReltnData(MockDataFactory.COSMIC_ENCOUNTER_RELTN_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5243);database.insertGameReltn(cosmicEncounter);
      
      //Insert Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5244);System.out.println ("===  Insert Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5245);GameReltn cosmicIncursion = MockDataFactory.createGameReltnData(MockDataFactory.COSMIC_INCURSION_RELTN_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5246);database.insertGameReltn(cosmicIncursion);

      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5247);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5248);GameReltn cosmicEncounter2 = database.readGameReltn(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5249);assertNotNull("I didn't find my result", cosmicEncounter2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5250);assertTrue("The reltnIDs are not equal", cosmicEncounter.getReltnID() == cosmicEncounter2.getReltnID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5251);assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5252);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5253);assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiIDs().size() == cosmicEncounter2.getCsiIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5254);assertTrue("The mmIDs are not equal", cosmicEncounter.getMmIDs().size() == cosmicEncounter2.getMmIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5255);assertTrue("The publishers lists are not equal", cosmicEncounter.getAsinKeys().size() == cosmicEncounter2.getAsinKeys().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5256);assertTrue("The expansion lists are not equal", cosmicEncounter.getOtherSites().size() == cosmicEncounter2.getOtherSites().size());
      
      //Read Cosmic Incursion and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5257);System.out.println ("===  Read Cosmic Incursion and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5258);GameReltn cosmicIncursion2 = database.readGameReltn(cosmicIncursion.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5259);assertNotNull("I didn't find my result", cosmicIncursion2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5260);assertTrue("The reltnIDs are not equal", cosmicIncursion.getReltnID() == cosmicIncursion2.getReltnID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5261);assertTrue("The gameIDs are not equal", cosmicIncursion.getGameID() == cosmicIncursion2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5262);assertTrue("The bggIDs are not equal", cosmicIncursion.getBggID() == cosmicIncursion2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5263);assertTrue("The csiIDs are not equal", cosmicIncursion.getCsiIDs().size() == cosmicIncursion2.getCsiIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5264);assertTrue("The mmIDs are not equal", cosmicIncursion.getMmIDs().size() == cosmicIncursion2.getMmIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5265);assertTrue("The publishers lists are not equal", cosmicIncursion.getAsinKeys().size() == cosmicIncursion2.getAsinKeys().size());
      //Should be null
      __CLR3_3_03qs3qsi96a4z34.R.inc(5266);assertTrue("The expansion lists are not equal", cosmicIncursion.getOtherSites() == cosmicIncursion2.getOtherSites());
      
      //Reinsert Cosmic Encounter
      __CLR3_3_03qs3qsi96a4z34.R.inc(5267);System.out.println ("===  Reinsert Cosmic Encounter  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5268);database.insertGameReltn(cosmicEncounter);
      
      //Upsert Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5269);System.out.println ("===  Upsert Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5270);GameReltn abyss = MockDataFactory.createGameReltnData(MockDataFactory.ABYSS_RELTN_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5271);database.updateGameReltn(abyss);
      
      //Read Cosmic Encounter and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5272);System.out.println ("===  Read Cosmic Encounter and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5273);GameReltn cosmicEncounter3 = database.readGameReltn(cosmicEncounter.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5274);assertNotNull("I didn't find my result", cosmicEncounter3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5275);assertTrue("The reltnIDs are not equal", cosmicEncounter.getReltnID() == cosmicEncounter3.getReltnID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5276);assertTrue("The gameIDs are not equal", cosmicEncounter.getGameID() == cosmicEncounter3.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5277);assertTrue("The bggIDs are not equal", cosmicEncounter.getBggID() == cosmicEncounter3.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5278);assertTrue("The csiIDs are not equal", cosmicEncounter.getCsiIDs().size() == cosmicEncounter3.getCsiIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5279);assertTrue("The mmIDs are not equal", cosmicEncounter.getMmIDs().size() == cosmicEncounter3.getMmIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5280);assertTrue("The publishers lists are not equal", cosmicEncounter.getAsinKeys().size() == cosmicEncounter3.getAsinKeys().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5281);assertTrue("The expansion lists are not equal", cosmicEncounter.getOtherSites().size() == cosmicEncounter3.getOtherSites().size());

      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5282);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5283);GameReltn abyss2 = database.readGameReltn(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5284);assertNotNull("I didn't find my result", abyss2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5285);assertTrue("The reltnIDs are not equal", abyss.getReltnID() == abyss2.getReltnID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5286);assertTrue("The gameIDs are not equal", abyss.getGameID() == abyss2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5287);assertTrue("The bggIDs are not equal", abyss.getBggID() == abyss2.getBggID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5288);assertTrue("The csiIDs are not equal", abyss.getCsiIDs().size() == abyss2.getCsiIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5289);assertTrue("The mmIDs are not equal", abyss.getMmIDs().size() == abyss2.getMmIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5290);assertTrue("The publishers lists are not equal", abyss.getAsinKeys().size() == abyss2.getAsinKeys().size());
      //Should be null
      __CLR3_3_03qs3qsi96a4z34.R.inc(5291);assertTrue("The expansion lists are not equal", cosmicIncursion.getOtherSites() == abyss2.getOtherSites());

      //Modify Abyss Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5292);System.out.println ("===  Modify Abyss Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5293);List<Long> csiList = abyss.getCsiIDs();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5294);csiList.add(MockDataFactory.CSI_ABYSS_ID + 20);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5295);List<Long> mmList = abyss.getMmIDs();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5296);mmList.add(MockDataFactory.MM_ABYSS_ID + 20);
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5297);abyss.setCsiIDs(csiList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5298);abyss.setMmIDs(mmList);
      
      //Update Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5299);System.out.println ("===  Update Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5300);database.updateGameReltn(abyss);
      
      //Read Abyss and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5301);System.out.println ("===  Read Abyss and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5302);GameReltn abyss3 = database.readGameReltn(abyss.getGameID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5303);assertNotNull("I didn't find my result", abyss3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5304);assertTrue("The csiIDs are not equal", abyss.getCsiIDs().size() == abyss3.getCsiIDs().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5305);assertTrue("The mmIDs are not equal", abyss.getMmIDs().size() == abyss3.getMmIDs().size());
      
      //Run the IDs select and verify all three games found
      __CLR3_3_03qs3qsi96a4z34.R.inc(5306);System.out.println ("===  Run the IDs select and verify all three games found  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5307);List<Long> reltnIDList = database.getGameReltnIDList();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5308);assertNotNull("I didn't get an ID List", reltnIDList);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5309);assertTrue("My List didn't contain Cosmic Encounter", reltnIDList.contains(MockDataFactory.COSMIC_ENCOUNTER_RELTN_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5310);assertTrue("My List didn't contain Cosmic Incursion", reltnIDList.contains(MockDataFactory.COSMIC_INCURSION_RELTN_ID));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5311);assertTrue("My List didn't contain Abyss", reltnIDList.contains(MockDataFactory.ABYSS_RELTN_ID));
      
      //Delete Cosmic Encounter and Cosmic Incursion
      __CLR3_3_03qs3qsi96a4z34.R.inc(5312);System.out.println ("===  Delete Cosmic Encounter and Cosmic Incursion  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5313);database.deleteGameReltn(cosmicEncounter.getReltnID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5314);database.deleteGameReltn(cosmicIncursion.getReltnID());
      
      //Read Nothing for two games, verify Abyss still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5315);System.out.println ("===  Read Nothing for two games, verify Abyss still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5316);GameReltn notFound1  = database.readGameReltn(cosmicEncounter.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5317);GameReltn notFound2  = database.readGameReltn(cosmicIncursion.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5318);GameReltn foundAbyss = database.readGameReltn(abyss.getGameID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5319);assertNull("I shouldn't have found Cosmic Encounter, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5320);assertNull("I shouldn't have found Cosmic Incursion, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5321);assertNotNull("I should have found Abyss, but didn't.", foundAbyss);
      
      //Delete Abyss
      __CLR3_3_03qs3qsi96a4z34.R.inc(5322);System.out.println ("===  Delete Abyss  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5323);database.deleteGameReltn(abyss.getReltnID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5324);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5325);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5326);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5327);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5328);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5329);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
  
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
  public void testUsers() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5330);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0285nh9442();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testUsers",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5330,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0285nh9442(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5330);
    __CLR3_3_03qs3qsi96a4z34.R.inc(5331);try {
      //Insert User One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5332);System.out.println ("===  Insert User One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5333);User userOne = MockDataFactory.createUserData(MockDataFactory.USER_ONE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5334);database.insertUser(userOne);
      
      //Insert User Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5335);System.out.println ("===  Insert User Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5336);User userTwo = MockDataFactory.createUserData(MockDataFactory.USER_TWO_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5337);database.insertUser(userTwo);

      //Read User One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5338);System.out.println ("===  Read User One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5339);User userOne2 = database.readUser(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5340);assertNotNull("I didn't find my result", userOne2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5341);assertTrue("The userIDs are not equal", userOne.getUserID() == userOne2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5342);assertTrue("The firstNames don't match", userOne.getFirstName().equalsIgnoreCase(userOne2.getFirstName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5343);assertTrue("The lastNames don't match", userOne.getLastName().equalsIgnoreCase(userOne2.getLastName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5344);assertTrue("The emailAddresses don't match", userOne.getEmailAddress().equalsIgnoreCase(userOne2.getEmailAddress()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5345);assertTrue("The collectionIDs are not equal", userOne.getCollectionID() == userOne2.getCollectionID());
      
      //Read User Two and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5346);System.out.println ("===  Read User Two and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5347);User userTwo2 = database.readUser(userTwo.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5348);assertNotNull("I didn't find my result", userTwo2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5349);assertTrue("The userIDs are not equal", userTwo.getUserID() == userTwo2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5350);assertTrue("The firstNames don't match", userTwo.getFirstName().equalsIgnoreCase(userTwo2.getFirstName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5351);assertTrue("The lastNames don't match", userTwo.getLastName().equalsIgnoreCase(userTwo2.getLastName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5352);assertTrue("The emailAddresses don't match", userTwo.getEmailAddress().equalsIgnoreCase(userTwo2.getEmailAddress()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5353);assertTrue("The collectionIDs are not equal", userTwo.getCollectionID() == userTwo2.getCollectionID());
      
      //Reinsert User One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5354);System.out.println ("===  Reinsert User One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5355);database.insertUser(userOne);
      
      //Upsert User Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5356);System.out.println ("===  Upsert User Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5357);User userThree = MockDataFactory.createUserData(MockDataFactory.USER_THREE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5358);database.updateUser(userThree);
      
      //Read User One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5359);System.out.println ("===  Read User One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5360);User userOne3 = database.readUser(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5361);assertNotNull("I didn't find my result", userOne3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5362);assertTrue("The userIDs are not equal", userOne.getUserID() == userOne3.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5363);assertTrue("The firstNames don't match", userOne.getFirstName().equalsIgnoreCase(userOne3.getFirstName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5364);assertTrue("The lastNames don't match", userOne.getLastName().equalsIgnoreCase(userOne3.getLastName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5365);assertTrue("The emailAddresses don't match", userOne.getEmailAddress().equalsIgnoreCase(userOne3.getEmailAddress()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5366);assertTrue("The collectionIDs are not equal", userOne.getCollectionID() == userOne3.getCollectionID());

      //Read User Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5367);System.out.println ("===  Read User Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5368);User userThree2 = database.readUser(userThree.getUserName());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5369);assertNotNull("I didn't find my result", userThree2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5370);assertTrue("The userIDs are not equal", userThree.getUserID() == userThree2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5371);assertTrue("The firstNames don't match", userThree.getFirstName().equalsIgnoreCase(userThree2.getFirstName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5372);assertTrue("The lastNames don't match", userThree.getLastName().equalsIgnoreCase(userThree2.getLastName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5373);assertTrue("The emailAddresses don't match", userThree.getEmailAddress().equalsIgnoreCase(userThree2.getEmailAddress()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5374);assertTrue("The collectionIDs are not equal", userThree.getCollectionID() == userThree2.getCollectionID());

      //Modify User Three Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5375);System.out.println ("===  Modify User Three Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5376);userThree.setFirstName("Hammy");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5377);userThree.setLastName("Porkchop");
      
      //Update User Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5378);System.out.println ("===  Update User Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5379);database.updateUser(userThree);
      
      //Read User Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5380);System.out.println ("===  Read User Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5381);User userThree3 = database.readUser(userThree.getUserName());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5382);assertNotNull("I didn't find my result", userThree3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5383);assertTrue("The firstNames don't match", userThree.getFirstName().equalsIgnoreCase(userThree3.getFirstName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5384);assertTrue("The lastNames don't match", userThree.getLastName().equalsIgnoreCase(userThree3.getLastName()));
      
      //Delete User One and User Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5385);System.out.println ("===  Delete User One and User Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5386);database.deleteUser(userOne.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5387);database.deleteUser(userTwo.getUserID());
      
      //Read Nothing for two games, verify User Three still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5388);System.out.println ("===  Read Nothing for two games, verify User Three still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5389);User notFound1  = database.readUser(userOne.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5390);User notFound2  = database.readUser(userTwo.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5391);User foundThree = database.readUser(userThree.getUserID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5392);assertNull("I shouldn't have found User One, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5393);assertNull("I shouldn't have found User Two, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5394);assertNotNull("I should have found User Three, but didn't.", foundThree);
      
      //Delete User Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5395);System.out.println ("===  Delete User Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5396);database.deleteUser(userThree.getUserID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5397);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5398);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5399);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5400);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5401);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5402);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testUserDetails() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5403);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_01juugc463();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testUserDetails",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5403,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_01juugc463(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5403);
    __CLR3_3_03qs3qsi96a4z34.R.inc(5404);try {
      //Insert UserDetail One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5405);System.out.println ("===  Insert UserDetail One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5406);UserDetail userOne = MockDataFactory.createUserDetailData(MockDataFactory.USER_ONE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5407);database.insertUserDetail(userOne);
      
      //Insert UserDetail Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5408);System.out.println ("===  Insert UserDetail Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5409);UserDetail userTwo = MockDataFactory.createUserDetailData(MockDataFactory.USER_TWO_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5410);database.insertUserDetail(userTwo);

      //Read UserDetail One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5411);System.out.println ("===  Read UserDetail One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5412);UserDetail userOne2 = database.readUserDetail(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5413);assertNotNull("I didn't find my result", userOne2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5414);assertTrue("The userIDs are not equal", userOne.getUserID() == userOne2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5415);assertTrue("The passwords don't match", userOne.getPass().equalsIgnoreCase(userOne2.getPass()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5416);assertTrue("The userRoles are not equal", userOne.getUserRole() == userOne2.getUserRole());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5417);assertTrue("The createdOnDates don't match", userOne.getCreatedOnDate().compareTo(userOne2.getCreatedOnDate()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5418);assertTrue("The lastLoginDates don't match", userOne.getLastLoginDate().compareTo(userOne2.getLastLoginDate()) == 0);
      
      //Read UserDetail Two and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5419);System.out.println ("===  Read UserDetail Two and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5420);UserDetail userTwo2 = database.readUserDetail(userTwo.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5421);assertNotNull("I didn't find my result", userTwo2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5422);assertTrue("The userIDs are not equal", userTwo.getUserID() == userTwo2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5423);assertTrue("The passwords don't match", userTwo.getPass().equalsIgnoreCase(userTwo2.getPass()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5424);assertTrue("The userRoles are not equal", userTwo.getUserRole() == userTwo2.getUserRole());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5425);assertTrue("The createdOnDates don't match", userTwo.getCreatedOnDate().compareTo(userTwo2.getCreatedOnDate()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5426);assertTrue("The lastLoginDates don't match", userTwo.getLastLoginDate().compareTo(userTwo2.getLastLoginDate()) == 0);
      
      //Reinsert UserDetail One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5427);System.out.println ("===  Reinsert UserDetail One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5428);database.insertUserDetail(userOne);
      
      //Upsert UserDetail Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5429);System.out.println ("===  Upsert UserDetail Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5430);UserDetail userThree = MockDataFactory.createUserDetailData(MockDataFactory.USER_THREE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5431);database.updateUserDetail(userThree);
      
      //Read UserDetail One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5432);System.out.println ("===  Read UserDetail One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5433);UserDetail userOne3 = database.readUserDetail(userOne.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5434);assertNotNull("I didn't find my result", userOne3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5435);assertTrue("The userIDs are not equal", userOne.getUserID() == userOne3.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5436);assertTrue("The passwords don't match", userOne.getPass().equalsIgnoreCase(userOne3.getPass()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5437);assertTrue("The userRoles are not equal", userOne.getUserRole() == userOne3.getUserRole());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5438);assertTrue("The createdOnDates don't match", userOne.getCreatedOnDate().compareTo(userOne3.getCreatedOnDate()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5439);assertTrue("The lastLoginDates don't match", userOne.getLastLoginDate().compareTo(userOne3.getLastLoginDate()) == 0);

      //Read UserDetail Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5440);System.out.println ("===  Read UserDetail Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5441);UserDetail userThree2 = database.readUserDetail(userThree.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5442);assertNotNull("I didn't find my result", userThree2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5443);assertTrue("The userIDs are not equal", userThree.getUserID() == userThree2.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5444);assertTrue("The passwords don't match", userThree.getPass().equalsIgnoreCase(userThree2.getPass()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5445);assertTrue("The userRoles are not equal", userThree.getUserRole() == userThree2.getUserRole());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5446);assertTrue("The createdOnDates don't match", userThree.getCreatedOnDate().compareTo(userThree2.getCreatedOnDate()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5447);assertTrue("The lastLoginDates don't match", userThree.getLastLoginDate().compareTo(userThree2.getLastLoginDate()) == 0);

      //Modify UserDetail Three Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5448);System.out.println ("===  Modify UserDetail Three Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5449);userThree.setPass("popoioip");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5450);userThree.setLastLoginDate(new Date());
      
      //Update UserDetail Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5451);System.out.println ("===  Update UserDetail Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5452);database.updateUserDetail(userThree);
      
      //Read UserDetail Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5453);System.out.println ("===  Read UserDetail Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5454);UserDetail userThree3 = database.readUserDetail(userThree.getUserID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5455);assertNotNull("I didn't find my result", userThree3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5456);assertTrue("The passwords don't match", userThree.getPass().equalsIgnoreCase(userThree3.getPass()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5457);assertTrue("The userRoles are not equal", userThree.getUserRole() == userThree3.getUserRole());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5458);assertTrue("The createdOnDates don't match", userThree.getCreatedOnDate().compareTo(userThree3.getCreatedOnDate()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5459);assertTrue("The lastLoginDates don't match", userThree.getLastLoginDate().compareTo(userThree3.getLastLoginDate()) == 0);
      
      //Delete UserDetail One and UserDetail Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5460);System.out.println ("===  Delete UserDetail One and UserDetail Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5461);database.deleteUserDetail(userOne.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5462);database.deleteUserDetail(userTwo.getUserID());
      
      //Read Nothing for two games, verify UserDetail Three still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5463);System.out.println ("===  Read Nothing for two games, verify UserDetail Three still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5464);UserDetail notFound1  = database.readUserDetail(userOne.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5465);UserDetail notFound2  = database.readUserDetail(userTwo.getUserID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5466);UserDetail foundThree = database.readUserDetail(userThree.getUserID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5467);assertNull("I shouldn't have found UserDetail One, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5468);assertNull("I shouldn't have found UserDetail Two, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5469);assertNotNull("I should have found UserDetail Three, but didn't.", foundThree);
      
      //Delete UserDetail Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5470);System.out.println ("===  Delete UserDetail Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5471);database.deleteUserDetail(userThree.getUserID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5472);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5473);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5474);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5475);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5476);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5477);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testCollectionItems() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5478);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0ru6uc7486();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testCollectionItems",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5478,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0ru6uc7486(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5478);
    __CLR3_3_03qs3qsi96a4z34.R.inc(5479);try {
      //Insert CollectionItem One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5480);System.out.println ("===  Insert CollectionItem One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5481);CollectionItem itemOne = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_ONE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5482);database.insertCollectionItem(itemOne);
      
      //Insert CollectionItem Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5483);System.out.println ("===  Insert CollectionItem Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5484);CollectionItem itemTwo = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_TWO_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5485);database.insertCollectionItem(itemTwo);

      //Read CollectionItem One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5486);System.out.println ("===  Read CollectionItem One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5487);CollectionItem itemOne2 = database.readCollectionItem(itemOne.getItemID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5488);assertNotNull("I didn't find my result", itemOne2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5489);assertTrue("The itemIDs are not equal", itemOne.getItemID() == itemOne2.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5490);assertTrue("The gameIDs are not equal", itemOne.getGameID() == itemOne2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5491);assertTrue("The Game Names don't match", itemOne.getGame().getName().equalsIgnoreCase(itemOne2.getGame().getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5492);assertTrue("The weights are not equal", itemOne.getWeights().size() == itemOne2.getWeights().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5493);assertTrue("The dateAcquireds don't match", itemOne.getDateAcquired() == itemOne2.getDateAcquired());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5494);assertTrue("The whereAcquired don't match", itemOne.getWhereAcquired() == itemOne2.getWhereAcquired());
      
      //Read CollectionItem Two and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5495);System.out.println ("===  Read CollectionItem Two and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5496);CollectionItem itemTwo2 = database.readCollectionItem(itemTwo.getItemID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5497);assertNotNull("I didn't find my result", itemTwo2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5498);assertTrue("The itemIDs are not equal", itemTwo.getItemID() == itemTwo2.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5499);assertTrue("The gameIDs are not equal", itemTwo.getGameID() == itemTwo2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5500);assertTrue("The Game Names don't match", itemTwo.getGame().getName().equalsIgnoreCase(itemTwo2.getGame().getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5501);assertTrue("The weights are not equal", itemTwo.getWeights().size() == itemTwo2.getWeights().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5502);assertTrue("The dateAcquireds don't match", itemTwo.getDateAcquired().compareTo(itemTwo2.getDateAcquired()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5503);assertTrue("The whereAcquired don't match", itemTwo.getWhereAcquired().equalsIgnoreCase(itemTwo2.getWhereAcquired()));
      
      //Reinsert CollectionItem One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5504);System.out.println ("===  Reinsert CollectionItem One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5505);database.insertCollectionItem(itemOne);
      
      //Upsert CollectionItem Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5506);System.out.println ("===  Upsert CollectionItem Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5507);CollectionItem itemThree = MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_THREE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5508);database.updateCollectionItem(itemThree);
      
      //Read CollectionItem One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5509);System.out.println ("===  Read CollectionItem One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5510);CollectionItem itemOne3 = database.readCollectionItem(itemOne.getItemID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5511);assertNotNull("I didn't find my result", itemOne3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5512);assertTrue("The itemIDs are not equal", itemOne.getItemID() == itemOne3.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5513);assertTrue("The gameIDs are not equal", itemOne.getGameID() == itemOne3.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5514);assertTrue("The Game Names don't match", itemOne.getGame().getName().equalsIgnoreCase(itemOne3.getGame().getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5515);assertTrue("The weights are not equal", itemOne.getWeights().size() == itemOne3.getWeights().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5516);assertTrue("The dateAcquireds don't match", itemOne.getDateAcquired() == itemOne3.getDateAcquired());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5517);assertTrue("The whereAcquired don't match", itemOne.getWhereAcquired() == itemOne3.getWhereAcquired());

      //Read CollectionItem Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5518);System.out.println ("===  Read CollectionItem Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5519);CollectionItem itemThree2 = database.readCollectionItem(itemThree.getItemID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5520);assertNotNull("I didn't find my result", itemThree2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5521);assertTrue("The itemIDs are not equal", itemThree.getItemID() == itemThree2.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5522);assertTrue("The gameIDs are not equal", itemThree.getGameID() == itemThree2.getGameID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5523);assertTrue("The Game Names don't match", itemThree.getGame().getName().equalsIgnoreCase(itemThree2.getGame().getName()));
      __CLR3_3_03qs3qsi96a4z34.R.inc(5524);assertTrue("The weights are not equal", itemThree.getWeights() == itemThree2.getWeights());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5525);assertTrue("The dateAcquireds don't match", itemThree.getDateAcquired().compareTo(itemThree2.getDateAcquired()) == 0);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5526);assertTrue("The whereAcquired don't match", itemThree.getWhereAcquired() == itemThree2.getWhereAcquired());

      //Modify CollectionItem Three Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5527);System.out.println ("===  Modify CollectionItem Three Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5528);List<GameWeight> weights = new ArrayList<GameWeight>(2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5529);weights.add(GameWeight.FILLER);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5530);weights.add(GameWeight.SOCIAL);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5531);itemThree.setWeights(weights);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5532);itemThree.setWhereAcquired("Somewhere");
      
      //Update CollectionItem Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5533);System.out.println ("===  Update CollectionItem Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5534);database.updateCollectionItem(itemThree);
      
      //Read CollectionItem Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5535);System.out.println ("===  Read CollectionItem Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5536);CollectionItem itemThree3 = database.readCollectionItem(itemThree.getItemID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5537);assertNotNull("I didn't find my result", itemThree3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5538);assertTrue("The weights are not equal", itemThree.getWeights().size() == itemThree3.getWeights().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5539);assertTrue("The whereAcquired don't match", itemThree.getWhereAcquired().equalsIgnoreCase(itemThree3.getWhereAcquired()));
      
      //Delete CollectionItem One and CollectionItem Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5540);System.out.println ("===  Delete CollectionItem One and CollectionItem Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5541);database.deleteCollectionItem(itemOne.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5542);database.deleteCollectionItem(itemTwo.getItemID());
      
      //Read Nothing for two games, verify CollectionItem Three still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5543);System.out.println ("===  Read Nothing for two games, verify CollectionItem Three still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5544);CollectionItem notFound1  = database.readCollectionItem(itemOne.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5545);CollectionItem notFound2  = database.readCollectionItem(itemTwo.getItemID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5546);CollectionItem foundThree = database.readCollectionItem(itemThree.getItemID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5547);assertNull("I shouldn't have found CollectionItem One, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5548);assertNull("I shouldn't have found CollectionItem Two, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5549);assertNotNull("I should have found CollectionItem Three, but didn't.", foundThree);
      
      //Delete CollectionItem Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5550);System.out.println ("===  Delete CollectionItem Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5551);database.deleteCollectionItem(itemThree.getItemID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5552);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5553);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5554);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5555);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5556);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5557);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}

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
  public void testCollectionSimple() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5558);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0dm8c474ae();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testCollectionSimple",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5558,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0dm8c474ae(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5558);
    __CLR3_3_03qs3qsi96a4z34.R.inc(5559);try {
      //Insert Collection One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5560);System.out.println ("===  Insert Collection One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5561);Collection collectionOne = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_ONE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5562);database.insertCollection(collectionOne);
      
      //Insert Collection Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5563);System.out.println ("===  Insert Collection Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5564);Collection collectionTwo = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_TWO_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5565);database.insertCollection(collectionTwo);

      //Read Collection One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5566);System.out.println ("===  Read Collection One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5567);Collection collectionOne2 = database.readCollection(collectionOne.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5568);assertNotNull("I didn't find my result", collectionOne2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5569);assertTrue("The collectionIDs are not equal", collectionOne.getCollectionID() == collectionOne2.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5570);assertTrue("The games list sizes are not equal", collectionOne.getGames().size() == collectionOne2.getGames().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5571);assertTrue("The baseGameCount are not equal", collectionOne.getBaseGameCount() == collectionOne2.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5572);assertTrue("The collectibleGameCount are not equal", collectionOne.getCollectibleGameCount() == collectionOne2.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5573);assertTrue("The expansionGameCount are not equal", collectionOne.getExpansionGameCount() == collectionOne2.getExpansionGameCount());
      
      //Read Collection Two and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5574);System.out.println ("===  Read Collection Two and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5575);Collection collectionTwo2 = database.readCollection(collectionTwo.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5576);assertNotNull("I didn't find my result", collectionTwo2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5577);assertTrue("The collectionIDs are not equal", collectionTwo.getCollectionID() == collectionTwo2.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5578);assertTrue("The games list sizes are not equal", collectionTwo.getGames().size() == collectionTwo2.getGames().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5579);assertTrue("The baseGameCount are not equal", collectionTwo.getBaseGameCount() == collectionTwo2.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5580);assertTrue("The collectibleGameCount are not equal", collectionTwo.getCollectibleGameCount() == collectionTwo2.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5581);assertTrue("The expansionGameCount are not equal", collectionTwo.getExpansionGameCount() == collectionTwo2.getExpansionGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5582);assertTrue("The gameIDs of the first game are not equal", collectionTwo.getGames().get(0).getGameID() == collectionTwo2.getGames().get(0).getGameID());
      
      //Reinsert Collection One
      __CLR3_3_03qs3qsi96a4z34.R.inc(5583);System.out.println ("===  Reinsert Collection One  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5584);database.insertCollection(collectionOne);
      
      //Upsert Collection Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5585);System.out.println ("===  Upsert Collection Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5586);Collection collectionThree = MockDataFactory.createCollectionData(MockDataFactory.COLLECTION_THREE_ID);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5587);database.updateCollection(collectionThree);
      
      //Read Collection One and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5588);System.out.println ("===  Read Collection One and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5589);Collection collectionOne3 = database.readCollection(collectionOne.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5590);assertNotNull("I didn't find my result", collectionOne3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5591);assertTrue("The collectionIDs are not equal", collectionOne.getCollectionID() == collectionOne3.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5592);assertTrue("The games list sizes are not equal", collectionOne.getGames().size() == collectionOne3.getGames().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5593);assertTrue("The baseGameCount are not equal", collectionOne.getBaseGameCount() == collectionOne3.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5594);assertTrue("The collectibleGameCount are not equal", collectionOne.getCollectibleGameCount() == collectionOne3.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5595);assertTrue("The expansionGameCount are not equal", collectionOne.getExpansionGameCount() == collectionOne3.getExpansionGameCount());

      //Read Collection Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5596);System.out.println ("===  Read Collection Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5597);Collection collectionThree2 = database.readCollection(collectionThree.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5598);assertNotNull("I didn't find my result", collectionThree2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5599);assertTrue("The collectionIDs are not equal", collectionThree.getCollectionID() == collectionThree2.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5600);assertTrue("The games list sizes are not equal", collectionThree.getGames().size() == collectionThree2.getGames().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5601);assertTrue("The baseGameCount are not equal", collectionThree.getBaseGameCount() == collectionThree2.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5602);assertTrue("The collectibleGameCount are not equal", collectionThree.getCollectibleGameCount() == collectionThree2.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5603);assertTrue("The expansionGameCount are not equal", collectionThree.getExpansionGameCount() == collectionThree2.getExpansionGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5604);assertTrue("The gameIDs of the first game are not equal", collectionThree.getGames().get(0).getGameID() == collectionThree2.getGames().get(0).getGameID());

      //Modify Collection Three Data and Update
      __CLR3_3_03qs3qsi96a4z34.R.inc(5605);System.out.println ("===  Modify Collection Three Data and Update  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5606);collectionThree.addGame(MockDataFactory.createCollectionItemData(MockDataFactory.COLLECTION_ITEM_TWO_ID));
      
      //Update Collection Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5607);System.out.println ("===  Update Collection Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5608);database.updateCollection(collectionThree);
      
      //Read Collection Three and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5609);System.out.println ("===  Read Collection Three and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5610);Collection collectionThree3 = database.readCollection(collectionThree.getCollectionID());
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5611);assertNotNull("I didn't find my result", collectionThree3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5612);assertTrue("The games list sizes are not equal", collectionThree.getGames().size() == collectionThree3.getGames().size());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5613);assertTrue("The baseGameCount are not equal", collectionThree.getBaseGameCount() == collectionThree3.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5614);assertTrue("The collectibleGameCount are not equal", collectionThree.getCollectibleGameCount() == collectionThree3.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5615);assertTrue("The expansionGameCount are not equal", collectionThree.getExpansionGameCount() == collectionThree3.getExpansionGameCount());
      
      //Delete Collection One and Collection Two
      __CLR3_3_03qs3qsi96a4z34.R.inc(5616);System.out.println ("===  Delete Collection One and Collection Two  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5617);database.deleteCollection(collectionOne.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5618);database.deleteCollection(collectionTwo.getCollectionID());
      
      //Read Nothing for two games, verify Collection Three still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5619);System.out.println ("===  Read Nothing for two games, verify Collection Three still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5620);Collection notFound1  = database.readCollection(collectionOne.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5621);Collection notFound2  = database.readCollection(collectionTwo.getCollectionID());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5622);Collection foundThree = database.readCollection(collectionThree.getCollectionID());
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5623);assertNull("I shouldn't have found Collection One, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5624);assertNull("I shouldn't have found Collection Two, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5625);assertNotNull("I should have found Collection Three, but didn't.", foundThree);
      
      //Delete Collection Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5626);System.out.println ("===  Delete Collection Three  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5627);database.deleteCollection(collectionThree.getCollectionID());
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5628);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5629);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5630);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5631);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5632);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5633);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
  
  /**
   * This method is going to work a little different.  We're going to test adding each stat type, but
   * this test is simpler than the others, because there is no update method to support
   */
  @Test
  public void testStats() {__CLR3_3_03qs3qsi96a4z34.R.globalSliceStart(getClass().getName(),5634);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0cp4xt84ci();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_03qs3qsi96a4z34.R.rethrow($CLV_t2$);}finally{__CLR3_3_03qs3qsi96a4z34.R.globalSliceEnd(getClass().getName(),"com.ac.games.db.test.TestMongoGamesDatabase.testStats",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),5634,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0cp4xt84ci(){try{__CLR3_3_03qs3qsi96a4z34.R.inc(5634);
    __CLR3_3_03qs3qsi96a4z34.R.inc(5635);try {
      //Insert BGGGameStats
      __CLR3_3_03qs3qsi96a4z34.R.inc(5636);System.out.println ("===  Insert BGGGameStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5637);BGGGameStats bggStats = MockDataFactory.createBGGGameStats();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5638);database.insertBGGGameStats(bggStats);
      
      //Insert CSIDataStats
      __CLR3_3_03qs3qsi96a4z34.R.inc(5639);System.out.println ("===  Insert CSIDataStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5640);CSIDataStats csiStats = MockDataFactory.createCSIDataStats();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5641);database.insertCSIDataStats(csiStats);

      //Read CSIDataStats and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5642);System.out.println ("===  Read BGGGameStats and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5643);BGGGameStats bggStats2 = database.readBGGGameStats();
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5644);assertNotNull("I didn't find my result", bggStats2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5645);assertTrue("The baseGameCounts are not equal", bggStats.getBaseGameCount() == bggStats2.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5646);assertTrue("The expansionGameCounts are not equal", bggStats.getExpansionGameCount() == bggStats2.getExpansionGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5647);assertTrue("The collectibleGameCounts are not equal", bggStats.getCollectibleGameCount() == bggStats2.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5648);assertTrue("The approvedCounts are not equal", bggStats.getApprovedCount() == bggStats2.getApprovedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5649);assertTrue("The rejectedCounts are not equal", bggStats.getRejectedCount() == bggStats2.getRejectedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5650);assertTrue("The pendingCounts are not equal", bggStats.getPendingCount() == bggStats2.getPendingCount());
      
      //Read CSIDataStats and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5651);System.out.println ("===  Read CSIDataStats and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5652);CSIDataStats csiStats2 = database.readCSIDataStats();
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5653);assertNotNull("I didn't find my result", csiStats2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5654);assertTrue("The boardGameCounts are not equal", csiStats.getBoardGameCount() == csiStats2.getBoardGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5655);assertTrue("The collectibleGameCounts are not equal", csiStats.getCollectibleGameCount() == csiStats2.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5656);assertTrue("The diceMastersCounts are not equal", csiStats.getDiceMastersCount() == csiStats2.getDiceMastersCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5657);assertTrue("The rpgCounts are not equal", csiStats.getRpgCount() == csiStats2.getRpgCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5658);assertTrue("The lcgCounts are not equal", csiStats.getLcgCount() == csiStats2.getLcgCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5659);assertTrue("The suppliesCounts are not equal", csiStats.getSuppliesCount() == csiStats2.getSuppliesCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5660);assertTrue("The miniatureCounts are not equal", csiStats.getMiniatureCount() == csiStats2.getMiniatureCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5661);assertTrue("The videoGameCounts are not equal", csiStats.getVideoGameCount() == csiStats2.getVideoGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5662);assertTrue("The unknownCounts are not equal", csiStats.getUnknownCount() == csiStats2.getUnknownCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5663);assertTrue("The approvedCounts are not equal", csiStats.getApprovedCount() == csiStats2.getApprovedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5664);assertTrue("The rejectedCounts are not equal", csiStats.getRejectedCount() == csiStats2.getRejectedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5665);assertTrue("The pendingCounts are not equal", csiStats.getPendingCount() == csiStats2.getPendingCount());
      
      //Reinsert BGGGameStats
      __CLR3_3_03qs3qsi96a4z34.R.inc(5666);System.out.println ("===  Reinsert BGGGameStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5667);database.insertBGGGameStats(bggStats);
      
      //Upsert MMDataStats
      __CLR3_3_03qs3qsi96a4z34.R.inc(5668);System.out.println ("===  Upsert MMDataStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5669);MMDataStats mmStats = MockDataFactory.createMMDataStats();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5670);database.insertMMDataStats(mmStats);
      
      //Read BGGGameStats and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5671);System.out.println ("===  Read BGGGameStats and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5672);BGGGameStats bggStats3 = database.readBGGGameStats();
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5673);assertNotNull("I didn't find my result", bggStats3);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5674);assertTrue("The baseGameCounts are not equal", bggStats.getBaseGameCount() == bggStats3.getBaseGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5675);assertTrue("The expansionGameCounts are not equal", bggStats.getExpansionGameCount() == bggStats3.getExpansionGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5676);assertTrue("The collectibleGameCounts are not equal", bggStats.getCollectibleGameCount() == bggStats3.getCollectibleGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5677);assertTrue("The approvedCounts are not equal", bggStats.getApprovedCount() == bggStats3.getApprovedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5678);assertTrue("The rejectedCounts are not equal", bggStats.getRejectedCount() == bggStats3.getRejectedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5679);assertTrue("The pendingCounts are not equal", bggStats.getPendingCount() == bggStats3.getPendingCount());

      //Read MMDataStats and Verify
      __CLR3_3_03qs3qsi96a4z34.R.inc(5680);System.out.println ("===  Read MMDataStats and Verify  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5681);MMDataStats mmStats2 = database.readMMDataStats();
      
      //Spot checking as opposed to all possible values.
      __CLR3_3_03qs3qsi96a4z34.R.inc(5682);assertNotNull("I didn't find my result", mmStats2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5683);assertTrue("The boardGameCounts are not equal", mmStats.getBoardGameCount() == mmStats2.getBoardGameCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5684);assertTrue("The tableTopCounts are not equal", mmStats.getTableTopCount() == mmStats2.getTableTopCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5685);assertTrue("The ccgCounts are not equal", mmStats.getCcgCount() == mmStats2.getCcgCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5686);assertTrue("The collectiblesCounts are not equal", mmStats.getCollectiblesCount() == mmStats2.getCollectiblesCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5687);assertTrue("The rpgCounts are not equal", mmStats.getRpgCount() == mmStats2.getRpgCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5688);assertTrue("The accessoriesCounts are not equal", mmStats.getAccessoriesCount() == mmStats2.getAccessoriesCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5689);assertTrue("The unknownCounts are not equal", mmStats.getUnknownCount() == mmStats2.getUnknownCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5690);assertTrue("The approvedCounts are not equal", mmStats.getApprovedCount() == mmStats2.getApprovedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5691);assertTrue("The rejectedCounts are not equal", mmStats.getRejectedCount() == mmStats2.getRejectedCount());
      __CLR3_3_03qs3qsi96a4z34.R.inc(5692);assertTrue("The pendingCounts are not equal", mmStats.getPendingCount() == mmStats2.getPendingCount());

      //Delete BGGGameStats and CSIDataStats
      __CLR3_3_03qs3qsi96a4z34.R.inc(5693);System.out.println ("===  Delete BGGGameStats and CSIDataStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5694);database.deleteStatsRow(BGGGameStats.BGG_GAME_STATS);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5695);database.deleteStatsRow(CSIDataStats.CSI_DATA_STATS);
      
      //Read Nothing for two games, verify MMDataStats still exists
      __CLR3_3_03qs3qsi96a4z34.R.inc(5696);System.out.println ("===  Read Nothing for two games, verify MMDataStats still exists  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5697);BGGGameStats notFound1 = database.readBGGGameStats();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5698);CSIDataStats notFound2 = database.readCSIDataStats();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5699);MMDataStats foundThree = database.readMMDataStats();
      
      __CLR3_3_03qs3qsi96a4z34.R.inc(5700);assertNull("I shouldn't have found BGGGameStats, but did.", notFound1);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5701);assertNull("I shouldn't have found CSIDataStats, but did.", notFound2);
      __CLR3_3_03qs3qsi96a4z34.R.inc(5702);assertNotNull("I should have found MMDataStats, but didn't.", foundThree);
      
      //Delete Collection Three
      __CLR3_3_03qs3qsi96a4z34.R.inc(5703);System.out.println ("===  Delete MMDataStats  ===");
      __CLR3_3_03qs3qsi96a4z34.R.inc(5704);database.deleteStatsRow(MMDataStats.MM_DATA_STATS);
      
    } catch (ConfigurationException ce) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5705);ce.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5706);fail("I failed with a ConfigurationException: " + ce.getLocalizedMessage());
    } catch (DatabaseOperationException doe) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5707);doe.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5708);fail("I failed with a DatabaseOperationException: " + doe.getLocalizedMessage());
    } catch (Throwable t) {
      __CLR3_3_03qs3qsi96a4z34.R.inc(5709);t.printStackTrace();
      __CLR3_3_03qs3qsi96a4z34.R.inc(5710);fail("I failed for some gorram reason: " + t.getLocalizedMessage());
    }
  }finally{__CLR3_3_03qs3qsi96a4z34.R.flushNeeded();}}
}
