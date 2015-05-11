package com.ac.games.rest.test;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.ac.games.data.BGGGame;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.Game;
import com.ac.games.data.GameWeight;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.controller.BGGDataController;
import com.ac.games.rest.controller.CollectionController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author ac010168
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-mvc-configuration.xml")
@WebAppConfiguration
public class CollectionControllerTest {

  @Autowired
  private WebApplicationContext wac;

  //private MockMvc mockMvc;

  @Before
  public void setup() {
    //TODO - Eventually decide on how to dynamically define the database parameters
    Application.databaseHost = "localhost";
    Application.databasePort = 27017;
    Application.databaseName = "mockDB";
    try {
      Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      Application.database.initializeDBConnection();
      
      System.out.println ("**********  Database Configuration Enabled  **********");
    } catch (ConfigurationException e) {
      e.printStackTrace();
      System.out.println ("Shutting down system!");
    }
  }
  
  @After
  public void tearDown() {
    try {
      Application.database.closeDBConnection();
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
  }

  /**
   * This should test all the basic functions of this service in the following order:
   * <ol>
   * <li>Generate Mock Data</li>
   * <li>POST Abyss to database through service</li>
   * <li>GET Abyss from database and validate</li>
   * <li>Modify Abyss Values</li>
   * <li>PUT Updated Abyss into database through service</li>
   * <li>GET Abyss from database and validate changes were affected</li>
   * <li>DELETE Abyss from database through service</li>
   * <li>GET Abyss and verify the Game Not Found message</li></ol>
   */
  @Test
  public void testGameController() {
    RestAssuredMockMvc.standaloneSetup(new BGGDataController());
    
    System.out.println ("===  Validation GET Request from BoardGameGeek through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("bggid", 155987L).
    when().
      get("/external/bggdata").
    then().
      assertThat().
        statusCode(200).
        body("bggID", equalTo(155987)).
        body("name", equalTo("Abyss")).
        body("yearPublished", equalTo(2014)).
        body("minPlayers", equalTo(2)).
        body("maxPlayers", equalTo(4)).
        body("minPlayingTime", equalTo(30)).
        body("maxPlayingTime", equalTo(60)).
        body("publishers", hasItems("Bombyx", "Asmodee", "Asterion Press", "REBEL.pl"));
    
    //Quick Version
    System.out.println ("===  GET for Use Request from BoardGameGeek through Service  ===");
    BGGGame reqBGGGame = given().param("bggid", 155987L).when().get("/external/bggdata").as(BGGGame.class);
    
    Game reqGame = new Game();
    reqGame.setGameID(1234L);
    reqGame.setBggID(reqBGGGame.getBggID());
    reqGame.setName(reqBGGGame.getName());
    reqGame.setYearPublished(reqBGGGame.getYearPublished());
    reqGame.setMinPlayers(reqBGGGame.getMinPlayers());
    reqGame.setMaxPlayers(reqBGGGame.getMaxPlayers());
    reqGame.setMinPlayingTime(reqBGGGame.getMinPlayingTime());
    reqGame.setMaxPlayingTime(reqBGGGame.getMaxPlayingTime());
    reqGame.setImageURL(reqBGGGame.getImageURL());
    reqGame.setImageThumbnailURL(reqBGGGame.getImageThumbnailURL());
    reqGame.setDescription(reqBGGGame.getDescription());
    reqGame.setPrimaryPublisher("Asmodee");
    reqGame.setPublishers(reqBGGGame.getPublishers());
    reqGame.setDesigners(reqBGGGame.getDesigners());
    reqGame.setCategories(reqBGGGame.getCategories());
    reqGame.setMechanisms(reqBGGGame.getMechanisms());
    reqGame.setExpansionIDs(reqBGGGame.getExpansionIDs());
    reqGame.setParentGameID(reqBGGGame.getParentGameID());
    reqGame.setGameType(reqBGGGame.getGameType());
    reqGame.setAddDate(reqBGGGame.getAddDate());
    
    RestAssuredMockMvc.standaloneSetup(new CollectionController());
    
    System.out.println ("===  Generate Mock Data  ===");
    CollectionItem item = new CollectionItem();
    item.setItemID(7766L);
    item.setGame(reqGame);
    item.setGameID(reqGame.getGameID());
    item.setDateAcquired(new Date(10000000));
    item.setWhereAcquired("During a JUnit Test");
    
    List<GameWeight> weights = new ArrayList<GameWeight>(1);
    weights.add(GameWeight.MEDIUM);
    item.setWeights(weights);
    
    Collection collection = new Collection();
    collection.setCollectionID(9999L);
    collection.addGame(item);
    
    System.out.println ("===  POST Request from BoardGameGeek through Service  ===");
    given().
      contentType("application/json").
      body(collection).
    when().
      post("/collection").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Post Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous POST through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("collectionid", 9999L).
    when().
      get("/collection").
    then().
      assertThat().
        statusCode(200).
        body("collectionID", equalTo(9999)).
        body("baseGameCount", equalTo(1)).
        body("collectibleGameCount", equalTo(0)).
        body("expansionGameCount", equalTo(0));
    
    System.out.println ("===  PUT Request from Altered Content through Service  ===");
    collection.setCollectibleGameCount(5);
    collection.setBaseGameCount(12);
    collection.setExpansionGameCount(2);
    
    given().
      param("collectionid", 9999L).
      contentType("application/json").
      body(collection).
    when().
      put("/collection").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Put Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous PUT through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("collectionid", 9999L).
    when().
      get("/collection").
    then().
      assertThat().
        statusCode(200).
        body("baseGameCount", equalTo(12)).
        body("collectibleGameCount", equalTo(5)).
        body("expansionGameCount", equalTo(2));

    System.out.println ("===  DELETE Request through Service  ===");
    given().
      param("collectionid", 9999L).
    when().
      delete("/collection").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Delete Request Completed Successfully"));
    
    System.out.println ("===  GET Request from Database through Service that finds nothing  ===");
    given().
      param("collectionid", 9999L).
    when().
      get("/collection").
    then().
      assertThat().
        statusCode(200).
        body("errorType", equalTo("Collection Not Found"));
  }
}
