package com.ac.games.rest;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;

/**
 * @author ac010168
 *
 * Primary Launcher for the REST Service
 */
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {
  
  public static GamesDatabase database;
  
  /** The Host URL for our Mongo Instance */
  //public static String databaseHost = "192.168.1.9";
  public static String databaseHost = "localhost";
  /** The Host Port for our Mongo Instance */
  public static int    databasePort = 27017;
  /** The Host Database Name for our Mongo Database */
  public static String databaseName = "livedb";
  
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
  
  /** Main method, which is starting point for service using Spring launcher */
  public static void main(String[] args) {
    
    //TODO - Eventually decide on how to dynamically define the database parameters
    try {
      database = MongoDBFactory.createMongoGamesDatabase(databaseHost, databasePort, databaseName);
      database.initializeDBConnection();
    } catch (ConfigurationException e) {
      e.printStackTrace();
      System.out.println ("Shutting down system!");
      System.exit(1);
    }
    
    SpringApplication.run(Application.class, args);
  }
  
  @PreDestroy
  public static void shutdownHook() {
    try {
      database.closeDBConnection();
    } catch (ConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println (">>>  I'm inside the shutdownHook  <<");
  }
}
