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

import com.ac.games.data.User;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.controller.LoginController;
import com.ac.games.rest.controller.UserController;
import com.ac.games.rest.data.LoginData;
import com.ac.games.rest.data.NewUserData;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author ac010168
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-mvc-configuration.xml")
@WebAppConfiguration
public class UserControllerTest {

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
    RestAssuredMockMvc.standaloneSetup(new UserController());
    
    System.out.println ("===  Generate Mock Data  ===");
    //The New User entry:
    NewUserData newUser = new NewUserData();
    newUser.setUserName("junituser");
    newUser.setPassword("resutinuj");
    newUser.setFirstName("JUnit");
    newUser.setLastName("User");
    newUser.setEmailAddress("notarealaddress@email.com");
    
    System.out.println ("===  POST Request from BoardGameGeek through Service  ===");
    given().
      contentType("application/json").
      body(newUser).
    when().
      post("/user").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The New User " + newUser.getUserName() + " was created."));
    
    System.out.println ("===  Validation GET Request from Previous POST through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("username", newUser.getUserName()).
    when().
      get("/user").
    then().
      assertThat().
        statusCode(200).
        body("userName", equalTo(newUser.getUserName())).
        body("firstName", equalTo(newUser.getFirstName())).
        body("lastName", equalTo(newUser.getLastName())).
        body("emailAddress", equalTo(newUser.getEmailAddress()));
    
    //Quick Version
    System.out.println ("===  GET for Use Request from BoardGameGeek through Service  ===");
    User reqUser = given().param("username", newUser.getUserName()).when().get("/user").as(User.class);
    
    RestAssuredMockMvc.standaloneSetup(new LoginController());

    //Test the password side of creation
    System.out.println ("===  Setup Login Call  ===");
    LoginData loginData = new LoginData();
    loginData.setUserName(newUser.getUserName());
    loginData.setPassword(newUser.getPassword());
    
    System.out.println ("===  Validation of Login Task through POST  ===");
    //Run our Select from BGG Master Data
    given().
      contentType("application/json").
      body(loginData).
    when().
      post("/login").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Login Successful")).
        body("message", equalTo("The Login Validated Successfully"));
    
    RestAssuredMockMvc.standaloneSetup(new UserController());

    System.out.println ("===  PUT Request from Altered Content through Service  ===");
    reqUser.setEmailAddress("adifferentaddress@email.com");
    reqUser.setLastName("Hookadas");
    
    given().
      param("userid", reqUser.getUserID()).
      contentType("application/json").
      body(reqUser).
    when().
      put("/user").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Put Request Completed Successfully"));
    
    System.out.println ("===  Validation GET Request from Previous PUT through Service  ===");
    //Run our Select from BGG Master Data
    given().
      param("userid", reqUser.getUserID()).
    when().
      get("/user").
    then().
      assertThat().
        statusCode(200).
        body("emailAddress", equalTo("adifferentaddress@email.com")).
        body("lastName", equalTo("Hookadas"));
    
    //Now test the change user settings through /login option
    RestAssuredMockMvc.standaloneSetup(new LoginController());

    System.out.println ("===  Second PUT Request from Altered Content through Service  ===");
    NewUserData changeData = new NewUserData();
    changeData.setUserName(newUser.getUserName());
    changeData.setFirstName("Different");
    changeData.setLastName(reqUser.getLastName());
    changeData.setEmailAddress(reqUser.getEmailAddress());
    changeData.setPassword("aNewPassw0rd");

    given().
      param("userid", reqUser.getUserID()).
      contentType("application/json").
      body(changeData).
    when().
      put("/login").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful"));

    //Test the password side of creation
    System.out.println ("===  Setup Login Call  ===");
    loginData = new LoginData();
    loginData.setUserName(changeData.getUserName());
    loginData.setPassword(changeData.getPassword());
    
    System.out.println ("===  Validation of Login Task through POST  ===");
    //Run our Select from BGG Master Data
    given().
      contentType("application/json").
      body(loginData).
    when().
      post("/login").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Login Successful")).
        body("message", equalTo("The Login Validated Successfully"));
    
    RestAssuredMockMvc.standaloneSetup(new UserController());

    //Now we need to validate that both /user and /login work correctly.
    System.out.println ("===  Validation GET Requests from Second PUT through Service  ===");
    given().
      param("userid", reqUser.getUserID()).
    when().
      get("/user").
    then().
      assertThat().
        statusCode(200).
        body("emailAddress", equalTo("adifferentaddress@email.com")).
        body("firstName", equalTo("Different")).
        body("lastName", equalTo("Hookadas"));

    System.out.println ("===  DELETE Request through Service  ===");
    given().
      param("userid", reqUser.getUserID()).
    when().
      delete("/user").
    then().
      assertThat().
        statusCode(200).
        body("messageType", equalTo("Operation Successful")).
        body("message", equalTo("The Delete Request Completed Successfully"));
    
    System.out.println ("===  GET Request from Database through Service that finds nothing  ===");
    given().
      param("userid", reqUser.getUserID()).
    when().
      get("/user").
    then().
      assertThat().
        statusCode(200).
        body("errorType", equalTo("User Not Found"));
    
    RestAssuredMockMvc.standaloneSetup(new LoginController());

    given().
      contentType("application/json").
      body(loginData).
    when().
      post("/login").
    then().
      assertThat().
        statusCode(200).
        body("errorType", equalTo("Login Error")).
        body("errorMessage", equalTo("There is no User with the user name " + changeData.getUserName() + " in the system"));
  }
}
