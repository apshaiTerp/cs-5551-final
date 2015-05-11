package com.ac.games.data.parser;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ac.games.data.BGGGame;
import com.ac.games.data.GameType;
import com.ac.games.exception.GameNotFoundException;

/**
 * This class should take the XML body output from the BGG API for a single game
 * (examples are http://www.boardgamegeek.com/xmlapi/boardgame/<id>?stats=1) and
 * convert it into a {@link BGGGame} object.
 * 
 * @author ac010168
 */
public class BGGGameParser {
  
  public static boolean debugMode = false;

  /** A basic date formatter object.  We'll use it to condense dates. */
  public final static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-dd HH:mm:ss.SSS");
  
  /**
   * This is a static method used to help parse out {@link BGGGame} content from the BGG XML API
   * request.  This method should generate a complete object, or fail.
   * 
   * @param xmlContent The XML string received from the GET request
   * @return a {@link BGGGame} object fully parsed
   * @throws Throwable Throws this error if there were any parsing issues or other problems
   */
  public static BGGGame parseBGGXML(String xmlContent) throws Throwable {
    Date startDate = null;
    if (debugMode) {
      startDate = new Date();
      System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    //First, check for the 'we didn't find what you wanted' message
    int hasGameIDTag = xmlContent.indexOf("<boardgame objectid");
    int hasErrorTag  = xmlContent.indexOf("<error message=\"Item not found\"/>");
    if ((hasGameIDTag == -1) && (hasErrorTag != -1))
      throw new GameNotFoundException("This game does not exist in the BoardGameGeek library");
      
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder        = factory.newDocumentBuilder();
    InputSource is                 = new InputSource();
    is.setCharacterStream(new StringReader(xmlContent));
    Document gameDoc = builder.parse(is);
  
    BGGGame game = new BGGGame();
    
    //Begin inspecting all nodes
    NodeList nodeList = gameDoc.getDocumentElement().getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element elem = (Element)node;
        
        String objectID = node.getAttributes().getNamedItem("objectid").getNodeValue();
        game.setBggID(Long.parseLong(objectID));
        
        if ((elem.getElementsByTagName("yearpublished").getLength() != 0) && (elem.getElementsByTagName("yearpublished").item(0).getChildNodes().getLength() != 0)) {
          Integer yearPublishedValue  = Integer.parseInt(elem.getElementsByTagName("yearpublished").item(0).getChildNodes().item(0).getNodeValue());
          game.setYearPublished(yearPublishedValue);
        }
        if ((elem.getElementsByTagName("maxplayers").getLength() != 0) && (elem.getElementsByTagName("maxplayers").item(0).getChildNodes().getLength() != 0)) {
          Integer maxPlayerValue      = Integer.parseInt(elem.getElementsByTagName("maxplayers").item(0).getChildNodes().item(0).getNodeValue());
          game.setMaxPlayers(maxPlayerValue);
        }
        if ((elem.getElementsByTagName("minplayers").getLength() != 0) && (elem.getElementsByTagName("minplayers").item(0).getChildNodes().getLength() != 0)) {
          Integer minPlayerValue      = Integer.parseInt(elem.getElementsByTagName("minplayers").item(0).getChildNodes().item(0).getNodeValue());
          game.setMinPlayers(minPlayerValue);
        }
        if ((elem.getElementsByTagName("maxplaytime").getLength() != 0) && (elem.getElementsByTagName("maxplaytime").item(0).getChildNodes().getLength() != 0)) {
          Integer maxPlayingTimeValue = Integer.parseInt(elem.getElementsByTagName("maxplaytime").item(0).getChildNodes().item(0).getNodeValue());
          game.setMaxPlayingTime(maxPlayingTimeValue);
        }
        if ((elem.getElementsByTagName("minplaytime").getLength() != 0) && (elem.getElementsByTagName("minplaytime").item(0).getChildNodes().getLength() != 0)) {
          Integer minPlayingTimeValue = Integer.parseInt(elem.getElementsByTagName("minplaytime").item(0).getChildNodes().item(0).getNodeValue());
          game.setMinPlayingTime(minPlayingTimeValue);
        }        
        if ((elem.getElementsByTagName("image").getLength() != 0) && (elem.getElementsByTagName("image").item(0).getChildNodes().getLength() != 0)) {
          String imageValue          = "http:" + elem.getElementsByTagName("image").item(0).getChildNodes().item(0).getNodeValue();
          game.setImageURL(imageValue);
        }
        if ((elem.getElementsByTagName("thumbnail").getLength() != 0) && (elem.getElementsByTagName("thumbnail").item(0).getChildNodes().getLength() != 0)) {
          String imageThumbnailValue = "http:" + elem.getElementsByTagName("thumbnail").item(0).getChildNodes().item(0).getNodeValue();
          game.setImageThumbnailURL(imageThumbnailValue);
        }
        
        String description         = elem.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue();
        game.setDescription(description);
        
        String nameValue           = "Could not be found";
        NodeList nameElements = elem.getElementsByTagName("name");
        for (int j = 0; j < nameElements.getLength(); j++) {
          Node nameNode = nameElements.item(j);
          if (nameNode.getAttributes().getNamedItem("primary") != null)
            nameValue = nameNode.getChildNodes().item(0).getNodeValue();
        }
        game.setName(nameValue);
        
        List<String> publishers = new LinkedList<String>();
        NodeList publisherElements = elem.getElementsByTagName("boardgamepublisher");
        for (int j = 0; j < publisherElements.getLength(); j++) {
          publishers.add(publisherElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        game.setPublishers(publishers);

        List<String> designers = new LinkedList<String>();
        NodeList designerElements = elem.getElementsByTagName("boardgamedesigner");
        for (int j = 0; j < designerElements.getLength(); j++) {
          designers.add(designerElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        game.setDesigners(designers);
        
        List<String> categories = new LinkedList<String>();
        NodeList categoryElements = elem.getElementsByTagName("boardgamecategory");
        for (int j = 0; j < categoryElements.getLength(); j++) {
          categories.add(categoryElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        game.setCategories(categories);
        
        List<String> mechanisms = new LinkedList<String>();
        NodeList mechanicElements = elem.getElementsByTagName("boardgamemechanic");
        for (int j = 0; j < mechanicElements.getLength(); j++) {
          mechanisms.add(mechanicElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        game.setMechanisms(mechanisms);
        
        //Figure out the GameType and some of the dependent fields
        GameType gameType = null;
        
        //Figure out the extra fields
        List<Long> expansionGames = new LinkedList<Long>();
        NodeList expansionElements = elem.getElementsByTagName("boardgameexpansion");
        
        //If there are no hits, this is a standalone game and therefore a base
        if (expansionElements.getLength() == 0)
          gameType = GameType.BASE;
        else {
          //Assume it's a Base, then confirm whether it's an expansion
          gameType = GameType.BASE;
          //Search the element list.  The game name doesn't matter as much as does the id embedded as an attribute
          for (int j = 0; j < expansionElements.getLength(); j++) {
            Node expansionNode = expansionElements.item(j);
            long subGameID = Long.parseLong(expansionNode.getAttributes().getNamedItem("objectid").getNodeValue());

            //If we have the inbound tag, that indicates a leaf node, or in other words, and Expansion title
            if (expansionNode.getAttributes().getNamedItem("inbound") != null) {
              gameType = GameType.EXPANSION;
              game.setParentGameID(subGameID);
            } else expansionGames.add(subGameID);
          }
          if (gameType == GameType.BASE)
            game.setExpansionIDs(expansionGames);
        }

        //Logic around how to figure out base game or expansion needs to go here
        NodeList familyElements = elem.getElementsByTagName("boardgamefamily");
        for (int j = 0; j < familyElements.getLength(); j++) {
          String family = familyElements.item(j).getChildNodes().item(0).getNodeValue();
          if ((family.equalsIgnoreCase("CCGs (Collectible Card Games)")) && (gameType == GameType.BASE))
            gameType = GameType.COLLECTIBLE;
        }
        game.setGameType(gameType);
        
        //Now gather statistics
        Element statsElement   = (Element)elem.getElementsByTagName("statistics").item(0);
        Element ratingsElement = (Element)statsElement.getElementsByTagName("ratings").item(0);
        
        if ((ratingsElement.getElementsByTagName("average").getLength() != 0) && (ratingsElement.getElementsByTagName("average").item(0).getChildNodes().getLength() != 0)) {
          Double average     = Double.parseDouble(ratingsElement.getElementsByTagName("average").item(0).getChildNodes().item(0).getNodeValue());
          game.setBggRating(average);
        }
        if ((ratingsElement.getElementsByTagName("usersrated").getLength() != 0) && (ratingsElement.getElementsByTagName("usersrated").item(0).getChildNodes().getLength() != 0)) {
          Integer usersRated = Integer.parseInt(ratingsElement.getElementsByTagName("usersrated").item(0).getChildNodes().item(0).getNodeValue());
          game.setBggRatingUsers(usersRated);
        }
        
        //Only get the bggRank if not an expansion
        if (gameType != GameType.EXPANSION) {
          Element ranksElement = (Element)ratingsElement.getElementsByTagName("ranks").item(0);
          NodeList rankElements = ranksElement.getElementsByTagName("rank");
          for (int j = 0; j < rankElements.getLength(); j++) {
            Node rankNode = rankElements.item(j);
            if (rankNode.getAttributes().getNamedItem("type") != null) {
              String rankTypeValue = rankNode.getAttributes().getNamedItem("type").getNodeValue();
              String rankNameValue = rankNode.getAttributes().getNamedItem("name").getNodeValue();
              
              //If the game can have a ranking, that doesn't mean one is defined yet.  Make sure to check
              //to prevent NumberFormatExceptions.
              if (rankTypeValue.equalsIgnoreCase("subtype") && rankNameValue.equalsIgnoreCase("boardgame")) {
                String rankString = rankNode.getAttributes().getNamedItem("value").getNodeValue();
                if (rankString.equalsIgnoreCase("Not Ranked"))
                  game.setBggRank(BGGGame.NOT_RANKED_RANKING);
                else {
                  Integer rank = Integer.parseInt(rankString);
                  game.setBggRank(rank);
                }
              }
            }
            
          }
        }
        
        //if (debugMode)
        //  game.printContentsForDebug();
      }
    }

    if (debugMode) {
      Date endDate = new Date();
      System.out.println ("Ending Parse at " + dateFormatter.format(endDate));
      double trueElapsed = ((double)(endDate.getTime() - startDate.getTime())) / 1000.0;
      System.out.println ("Total Elapsed Time: [" + trueElapsed + " s.]");
    }

    return game;
  }
  
  /**
   * This method is designed to allow us to parse mutiple board game requests.  These
   * are results that are bound between {code}<boardgame objectid=".."..> and </boardgame>{code}.
   * This method should break the provided XML into the smaller sub-game blocks of XML and
   * allow the regular {@link #parseBGGXML(String)} method to process them as expected.
   * 
   * @param xmlContent The full XML string involved.
   * 
   * @return A List of {@link BGGGame} objects, or an empty list if none found.
   * 
   * @throws Throwable Throws if something goes wrong during parsing.
   */
  public static List<BGGGame> parseMultiBGGXML(String xmlContent) throws Throwable {
    //First, check for the 'we didn't find what you wanted' message
    int hasGameIDTag = xmlContent.indexOf("<boardgame objectid");
    int hasErrorTag  = xmlContent.indexOf("<error message=\"Item not found\"/>");
    if ((hasGameIDTag == -1) && (hasErrorTag != -1))
      throw new GameNotFoundException("These games do not exist in the BoardGameGeek library");
    
    List<BGGGame> foundGames = new LinkedList<BGGGame>();
    while (true) {
      int startGameTag = xmlContent.indexOf("<boardgame objectid");
      int endGameTag   = xmlContent.indexOf("</boardgame>");
      
      //If true, we've hit the end of the games list.
      if ((startGameTag == -1) && (endGameTag == -1)) {
        break;
      }
      //If we have a start, but not a close, we have malformed XML
      if ((startGameTag != -1) && (endGameTag == -1)) {
        throw new RuntimeException ("The List XML was malformed: open <boardgame> without close.");
      }
      //If we have a close, but not a start, we have malformed XML
      if ((startGameTag != -1) && (endGameTag == -1)) {
        throw new RuntimeException ("The List XML was malformed: close </boardgame> without open.");
      }
      
      //We've got to check to see if there's a nested boardgametag within a game, which for some reason
      //does happen from time to time.
      int nestedGameTag = xmlContent.indexOf("<boardgame objectid", startGameTag + 20);
      while ((nestedGameTag != -1) && (nestedGameTag < endGameTag)) {
        endGameTag = xmlContent.indexOf("</boardgame>", endGameTag + 10);
        
        if (endGameTag == -1)
          throw new RuntimeException("The List XML was malformed: Nested <boardgame> tag unclosed properly");
       
        nestedGameTag = xmlContent.indexOf("<boardgame objectid", nestedGameTag + 20);
      }
      
      //Generate substring that includes start and end tag content.
      String singleGameXML = "<boardgames>" + xmlContent.substring(startGameTag, endGameTag + 12) + "</boardgames>";
      
      BGGGame singleGame = parseBGGXML(singleGameXML);
      foundGames.add(singleGame);
      
      xmlContent = xmlContent.substring(endGameTag + 12);
    }
    return foundGames;
  }
}
