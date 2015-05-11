package com.ac.games.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ac.games.data.BGGGame;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.User;
import com.ac.games.db.GamesDatabase;
import com.ac.games.db.MongoDBFactory;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;
import com.ac.games.rest.Application;
import com.ac.games.rest.data.SplitList;
import com.ac.games.rest.data.WrapList;
import com.ac.games.rest.message.SimpleErrorData;

/**
 * This class should be the intercepter for REST service access for any Autocomplete
 * fields.
 * <p>
 * It should handle anything under the /auto entry
 * 
 * @author ac010168
 *
 */
@RestController
@RequestMapping("/auto")
public class AutocompleteController {

  @RequestMapping(method = RequestMethod.GET, produces="application/json;charset=UTF-8")
  public Object getAutoComplete(@RequestParam(value="source") String source,
                                @RequestParam(value="value", defaultValue="full") String value,
                                @RequestParam(value="userid", defaultValue="-1") long userID) {
    
    if (source == null)
      return new SimpleErrorData("Invalid Parameters", "The source parameter was not provided");
    if (value == null)
      return new SimpleErrorData("Invalid Parameters", "The value parameter was not provided");

    if ((!source.equalsIgnoreCase("game")) && (!source.equalsIgnoreCase("bgg")) && (!source.equalsIgnoreCase("csi")) && 
        (!source.equalsIgnoreCase("mm")) && (!source.equalsIgnoreCase("item")))
      return new SimpleErrorData("Invalid Parameters", "The source parameter value of " + source + " is not a valid source value.");
    
    if (source.equalsIgnoreCase("item") && (userID == -1))
      return new SimpleErrorData("Invalid Parameters", "Requests with source=item must provide a valid userid");
    
    GamesDatabase database = null; 
    Object results = null;
    
    if (value.trim().length() < 3)
      return new ArrayList<CompactSearchData>();
    
    try {
      if (Application.database == null)
        Application.database = MongoDBFactory.createMongoGamesDatabase(Application.databaseHost, Application.databasePort, Application.databaseName);
      database = Application.database;
      database.initializeDBConnection();
      
      if (value.equalsIgnoreCase("full")) {
        if (source.equalsIgnoreCase("game"))
          results = new WrapList(database.readGameNamesForAutoComplete());
        else if (source.equalsIgnoreCase("bgg"))
          results = new WrapList(database.readBGGGameNamesForAutoComplete());
        else if (source.equalsIgnoreCase("csi"))
          results = new WrapList(database.readCSITitlesForAutoComplete());
        else if (source.equalsIgnoreCase("mm"))
          results = new WrapList(database.readMMTitlesForAutoComplete());
      } else {
        System.out.println ("The value I'm going to deconstruct is: " + value);
        
        if (source.equalsIgnoreCase("game")) {
          //The value format should be "gameName (<optional publisher> - <optional year published>)
          //OR <gameID>
          
          if (value.startsWith("<")) {
            value = value.replace("<", "");
            value = value.replace(">", "");
            
            results = database.readGamesCompact(value);
          } else {
            String gameName   = null;
            String primaryPub = null;
            int yearPublished = -1;
            
            int openParen = value.lastIndexOf("(");
            if (openParen == -1)
              gameName = value.trim();
            else {
              gameName = value.substring(0, openParen - 1).trim();
              String filterSubString = value.substring(openParen + 1, value.length() - 1);
              int splitPos = filterSubString.indexOf(" - ");
              if (splitPos != -1) {
                //It has a publisher and a date
                primaryPub = filterSubString.substring(0, splitPos).trim();
                yearPublished = Integer.parseInt(filterSubString.substring(splitPos+3).trim());
              } else {
                //It is a publisher OR a date
                try {
                  yearPublished = Integer.parseInt(filterSubString);
                } catch (NumberFormatException nfe) {
                  primaryPub = filterSubString;
                }
              }
            }
            
            System.out.println ("Game Name:     " + gameName);
            System.out.println ("Primary Pub:   " + primaryPub);
            System.out.println ("yearPublished: " + yearPublished);
            
            CompactSearchData data = database.readGameFromAutoName(gameName, primaryPub, yearPublished);
            
            if (data == null)
              results =  new SimpleErrorData("No Game Found", "I could not find the requested game.");
            else 
              results = data;
          }
        } else if (source.equalsIgnoreCase("item")) {
          //Assume it's got the same range values
          value = value.replace("<", "");
          value = value.replace(">", "");
          
          SplitList splitList = new SplitList();
          List<CompactSearchData> foundItems = database.readGamesCompact(value);
          if (foundItems == null)
            results = splitList;
          else if (foundItems.size() == 0)
            results = splitList;
          else {
            //We've got a modest amount of work to do here.
            User curUser = database.readUser(userID);
            if (curUser == null)
              return new SimpleErrorData("No User Found", "There is no User in the system matching this userid");
            
            Collection curCollection = database.readCollection(curUser.getCollectionID());
            if (curCollection == null)
              return new SimpleErrorData("No Collection Found", "This user does not appear to have a collection yet");
            
            List<CollectionItem> ownedGames = curCollection.getGames();
            if ((ownedGames == null) || (ownedGames.size() == 0)) {
              splitList.setOtherGames(foundItems);
              results = splitList;
            } else {
              //There are some games being reported, and some games in the collection.
              //We need to walk through the games found, determine if they are owned, and assign them appropriately
              for (CompactSearchData curGame : foundItems) {
                boolean found = false;
                for (CollectionItem item : ownedGames) {
                  if (curGame.getSourceID() == item.getGameID()) {
                    found = true;
                    curGame.setSourceField("Game ID: " + curGame.getSourceID() + "  [You Own This Game]");
                    curGame.setSourceID(item.getItemID());
                    splitList.addNewOwnedItem(curGame);
                    break;
                  }
                }
                if (!found)
                  splitList.addNewOtherGame(curGame);
              }
              results = splitList;
            }
          }
        } else if (source.equalsIgnoreCase("bgg")) {
          //The value format should be "gameName (bggID - <optional year published>)
          long bggID = -1;
          int openParen = value.lastIndexOf("(");
          
          String filterSubString = value.substring(openParen + 1, value.length() - 1);
          int splitPos = filterSubString.indexOf(" - ");
          
          //If we have the split pos, then substring again, otherwise just take the value
          if (splitPos != -1)
            filterSubString = filterSubString.substring(0, splitPos).trim();
          else filterSubString = filterSubString.trim();
          
          try {
            bggID = Long.parseLong(filterSubString);
            
            System.out.println ("bggID: " + bggID);
            
            
            BGGGame game = database.readBGGGameData(bggID);
            if (game == null)
              results =  new SimpleErrorData("No Game Found", "I could not find the requested game.");
            else 
              results = game;
          } catch (Throwable t) {
            results = new SimpleErrorData("Processing Error", "Unable to retrieve BGGGame data from value " + value);
            t.printStackTrace();
          }
        } else if (source.equalsIgnoreCase("csi")) {
          //The value format should be "title (csiID - category)
          long csiID = -1;
          int openParen = value.lastIndexOf("(");
          
          String filterSubString = value.substring(openParen + 1, value.length() - 1);
          int splitPos = filterSubString.indexOf(" - ");
          
          //If we have the split pos, then substring again, otherwise just take the value
          if (splitPos != -1)
            filterSubString = filterSubString.substring(0, splitPos).trim();
          else filterSubString = filterSubString.trim();
          
          try {
            csiID = Long.parseLong(filterSubString);
            CoolStuffIncPriceData data = database.readCSIPriceData(csiID);
            if (data == null)
              results =  new SimpleErrorData("No Game Found", "I could not find the requested game.");
            else 
              results = data;
          } catch (Throwable t) {
            results = new SimpleErrorData("Processing Error", "Unable to retrieve CSI data from value " + value);
          }
        } else if (source.equalsIgnoreCase("mm")) {
          //The value format should be "title (mmID - category)
          long mmID = -1;
          int openParen = value.lastIndexOf("(");
          
          String filterSubString = value.substring(openParen + 1, value.length() - 1);
          int splitPos = filterSubString.indexOf(" - ");
          
          //If we have the split pos, then substring again, otherwise just take the value
          if (splitPos != -1)
            filterSubString = filterSubString.substring(0, splitPos).trim();
          else filterSubString = filterSubString.trim();
          
          try {
            mmID = Long.parseLong(filterSubString);
            MiniatureMarketPriceData data = database.readMMPriceData(mmID);
            if (data == null)
              results =  new SimpleErrorData("No Game Found", "I could not find the requested game.");
            else 
              results = data;
          } catch (Throwable t) {
            results = new SimpleErrorData("Processing Error", "Unable to retrieve MM data from value " + value);
          }
        }
      }
    } catch (DatabaseOperationException doe) {
      doe.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Operation Error", "An error occurred running the request: " + doe.getMessage());
    } catch (ConfigurationException ce) {
      ce.printStackTrace();
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
      return new SimpleErrorData("Database Configuration Error", "An error occurred accessing the database: " + ce.getMessage());
    } finally {
      //try { if (database != null) database.closeDBConnection(); } catch (Throwable t2) { /** Ignore Errors */ }
    }
    
    return results;
  }
}

