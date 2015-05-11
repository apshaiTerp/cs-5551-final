package com.ac.games.rest.test;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
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

import com.ac.games.data.GameReltn;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.controller.GameReltnController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author ac010168
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-mvc-configuration.xml")
@WebAppConfiguration
public class GameReltnControllerTest {

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
    RestAssuredMockMvc.standaloneSetup(new GameReltnController());
    
    System.out.println ("===  Generate Mock Data  ===");
    GameReltn reltn = new GameReltn();
    reltn.setReltnID(1234L);
    reltn.setGameID(3456L);
    reltn.setBggID(155987L);
    List<Long> csiList = new ArrayList<Long>(1);
    csiList.add(203495L);
    reltn.setCsiIDs(csiList);
    List<Long> mmList = new ArrayList<Long>(1);
    mmList.add(40693L);
    reltn.setMmIDs(mmList);
    
    List<String> asinKeys = new ArrayList<String>(1);
    asinKeys.add("B00KU10PH2");
    reltn.setAsinKeys(asinKeys);
    
    //No other site data for this item
    reltn.setOtherSites(null);
    
    System.out.println ("===  POST Request from BoardGameGeek through Service  ===");
    given().
      contentType("application/json").
      body(reltn).
    when().
      post("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Post Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous POST through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("gameid", 3456L).
    when().
      get("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("reltnID", equalTo(1234)).
        body("gameID", equalTo(3456)).
        body("bggID", equalTo(155987)).
        body("csiIDs", hasItems(203495)).
        body("mmIDs", hasItems(40693)).
        body("asinKeys", hasItems("B00KU10PH2"));
    
    System.out.println ("===  PUT Request from Altered Content through Service  ===");
    List<Long> newMMList = new ArrayList<Long>(1);
    newMMList.add(22222L);
    reltn.setMmIDs(newMMList);
    List<Long> otherSites = new ArrayList<Long>(1);
    otherSites.add(200701L);
    reltn.setOtherSites(otherSites);
    
    given().
      param("gameid", 3456L).
      contentType("application/json").
      body(reltn).
    when().
      put("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Put Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous PUT through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("gameid", 3456L).
    when().
      get("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("reltnID", equalTo(1234)).
        body("mmIDs", hasItems(22222)).
        body("otherSites", hasItems(200701));

    System.out.println ("===  DELETE Request through Service  ===");
    given().
      param("reltnid", reltn.getReltnID()).
    when().
      delete("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Delete Request Completed Successfully"));
    
    System.out.println ("===  GET Request from Database through Service that finds nothing  ===");
    given().
      param("gameid", 3456L).
    when().
      get("/gamereltn").
    then().
      assertThat().
        statusCode(200).
        body("errorType", equalTo("Game Not Found"));
  }
}
