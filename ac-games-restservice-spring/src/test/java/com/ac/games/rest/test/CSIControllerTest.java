package com.ac.games.rest.test;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.controller.CSIDataController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author ac010168
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-mvc-configuration.xml")
@WebAppConfiguration
public class CSIControllerTest {

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
   * <li>GET Abyss from BGG XML API through GET service</li>
   * <li>Validate that the Data looks correct</li>
   * <li>GET Abyss object again and store it off</li>
   * <li>POST Abyss to database through service</li>
   * <li>GET Abyss from database and validate</li>
   * <li>Modify Abyss Values</li>
   * <li>PUT Updated Abyss into database through service</li>
   * <li>GET Abyss from database and validate changes were affected</li>
   * <li>DELETE Abyss from database through service</li>
   * <li>GET Abyss and verify the Game Not Found message</li></ol>
   */
  @Test
  public void testCSIData() {
    RestAssuredMockMvc.standaloneSetup(new CSIDataController());
    
    System.out.println ("===  Validation GET Request from CoolStuffInc through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("csiid", 203495L).
    when().
      get("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("csiID", equalTo(203495)).
        body("title", equalTo("Abyss")).
        body("sku", equalTo("ASMABY01US")).
        body("msrpValue", equalTo(59.99f)).
        body("curPrice", equalTo(40.99f));

    //Quick Version
    System.out.println ("===  GET for Use Request from CoolStuffInc through Service  ===");
    CoolStuffIncPriceData reqData = given().param("csiid", 203495L).when().get("/external/csidata").as(CoolStuffIncPriceData.class);

    System.out.println ("===  POST Request from BoardGameGeek through Service  ===");
    given().
      contentType("application/json").
      body(reqData).
    when().
      post("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Post Request Completed Successfully"));

    System.out.println ("===  Validation GET Request from Previous POST through Service  ===");
    given().
      param("csiid", 203495L).
      param("source", "db").
    when().
      get("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("csiID", equalTo(203495)).
        body("title", equalTo("Abyss")).
        body("sku", equalTo("ASMABY01US")).
        body("msrpValue", equalTo(59.99f)).
        body("curPrice", equalTo(40.99f));

    System.out.println ("===  PUT Request from Altered Content through Service  ===");
    reqData.setMsrpValue(100.99);
    //TMNT Movie Reference
    reqData.setCurPrice(9.95);

    given().
      param("csiid", 203495L).
      contentType("application/json").
      body(reqData).
    when().
      put("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Put Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous PUT through Service  ===");
    given().
      param("csiid", 203495L).
      param("source", "db").
    when().
      get("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("csiID", equalTo(203495)).
        body("msrpValue", equalTo(100.99f)).
        body("curPrice", equalTo(9.95f));
    
    System.out.println ("===  DELETE Request through Service  ===");
    given().
      param("csiid", 203495L).
    when().
      delete("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Delete Request Completed Successfully"));

    System.out.println ("===  GET Request from Database through Service that finds nothing  ===");
    given().
      param("csiid", 203495L).
      param("source", "db").
    when().
      get("/external/csidata").
    then().
      assertThat().
        statusCode(200).
        body("errorType", equalTo("Game Not Found"));
  }
}
