package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ac.games.data.BGGGame;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.GameTypeConverter;
import com.ac.games.data.ReviewStateConverter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class BGGGameConverter {
  
  /**
   * Helper method that will construct a basic query using the bggID from the provided game.
   * 
   * @param game The Game we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(BGGGame game) {
    if (game == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("bggID", game.getBggID());
    return dbObject;
  }

  /**
   * Helper method that will construct a basic query using the bggID representing the provided game.
   * 
   * @param bggID The game ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertGameToIDQuery(long bggID) {
    if (bggID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("bggID", new Long(bggID));
    return dbObject;
  }

  /**
   * Helper method that will construct a basic database record for the provided game object.
   * 
   * @param game The Game we want to build a database record for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if no game was provided
   */
  public static BasicDBObject convertGameToMongo(BGGGame game) {
    if (game == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("bggID", game.getBggID());
    
    if (game.getName() != null)              dbObject.append("name", game.getName());
    if (game.getYearPublished() != -1)       dbObject.append("yearPublished", game.getYearPublished());
    if (game.getMinPlayers() != -1)          dbObject.append("minPlayers", game.getMinPlayers());
    if (game.getMaxPlayers() != -1)          dbObject.append("maxPlayers", game.getMaxPlayers());
    if (game.getMinPlayingTime() != -1)      dbObject.append("minPlayingTime", game.getMinPlayingTime());
    if (game.getMaxPlayingTime() != -1)      dbObject.append("maxPlayingTime", game.getMaxPlayingTime());
    if (game.getImageURL() != null)          dbObject.append("imageURL", game.getImageURL());
    if (game.getImageThumbnailURL() != null) dbObject.append("imageThumbnailURL", game.getImageThumbnailURL());
    if (game.getDescription() != null)       dbObject.append("description", game.getDescription());
    if (game.getBggRating() != -1.0)         dbObject.append("bggRating", game.getBggRating());
    if (game.getBggRatingUsers() != -1)      dbObject.append("bggRatingUsers", game.getBggRatingUsers());
    if (game.getPublishers() != null)        dbObject.append("publishers", convertList(game.getPublishers()));
    if (game.getDesigners() != null)         dbObject.append("designers", convertList(game.getDesigners()));
    if (game.getCategories() != null)        dbObject.append("categories", convertList(game.getCategories()));
    if (game.getMechanisms() != null)        dbObject.append("mechanisms", convertList(game.getMechanisms()));
    if (game.getBggRank() != -1)             dbObject.append("bggRank", game.getBggRank());
    if (game.getExpansionIDs() != null)      dbObject.append("expansionIDs", convertList(game.getExpansionIDs()));
    if (game.getParentGameID() != -1)        dbObject.append("parentGameID", game.getParentGameID());
    //Need a converter here because BSON won't accept Enums for serializability
    if (game.getGameType() != null)          dbObject.append("gameType", GameTypeConverter.convertGameTypeToFlag(game.getGameType()));
    if (game.getReviewState() != null)       dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(game.getReviewState()));
    if (game.getAddDate() != null)           dbObject.append("addDate", game.getAddDate());
    if (game.getReviewDate() != null)        dbObject.append("reviewDate", game.getReviewDate());
    
    return dbObject;
  }
  
  public static BGGGame convertMongoToGame(DBObject dbObject) {
    if (dbObject == null) return null;
    
    BGGGame game = new BGGGame();
    
    if (dbObject.containsField("bggID"))             game.setBggID((Long)dbObject.get("bggID"));
    if (dbObject.containsField("name"))              game.setName((String)dbObject.get("name"));
    if (dbObject.containsField("yearPublished"))     game.setYearPublished((Integer)dbObject.get("yearPublished"));
    if (dbObject.containsField("minPlayers"))        game.setMinPlayers((Integer)dbObject.get("minPlayers"));
    if (dbObject.containsField("maxPlayers"))        game.setMaxPlayers((Integer)dbObject.get("maxPlayers"));
    if (dbObject.containsField("minPlayingTime"))    game.setMinPlayingTime((Integer)dbObject.get("minPlayingTime"));
    if (dbObject.containsField("maxPlayingTime"))    game.setMaxPlayingTime((Integer)dbObject.get("maxPlayingTime"));
    if (dbObject.containsField("imageURL"))          game.setImageURL((String)dbObject.get("imageURL"));
    if (dbObject.containsField("imageThumbnailURL")) game.setImageThumbnailURL((String)dbObject.get("imageThumbnailURL"));
    if (dbObject.containsField("description"))       game.setDescription((String)dbObject.get("description"));
    if (dbObject.containsField("bggRating"))         game.setBggRating((Double)dbObject.get("bggRating"));
    if (dbObject.containsField("bggRatingUsers"))    game.setBggRatingUsers((Integer)dbObject.get("bggRatingUsers"));
    if (dbObject.containsField("publishers"))        game.setPublishers(convertDBListToStringList((BasicDBList)dbObject.get("publishers")));
    if (dbObject.containsField("designers"))         game.setDesigners(convertDBListToStringList((BasicDBList)dbObject.get("designers")));
    if (dbObject.containsField("categories"))        game.setCategories(convertDBListToStringList((BasicDBList)dbObject.get("categories")));
    if (dbObject.containsField("mechanisms"))        game.setMechanisms(convertDBListToStringList((BasicDBList)dbObject.get("mechanisms")));
    if (dbObject.containsField("bggRank"))           game.setBggRank((Integer)dbObject.get("bggRank"));
    if (dbObject.containsField("expansionIDs"))      game.setExpansionIDs(convertDBListToLongList((BasicDBList)dbObject.get("expansionIDs")));
    if (dbObject.containsField("parentGameID"))      game.setParentGameID((Long)dbObject.get("parentGameID"));
    //Need a converter here because BSON won't accept Enums for serializability
    if (dbObject.containsField("gameType"))          game.setGameType(GameTypeConverter.convertFlagToGameType((Integer)dbObject.get("gameType")));
    if (dbObject.containsField("reviewState"))       game.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    if (dbObject.containsField("addDate"))           game.setAddDate((Date)dbObject.get("addDate"));
    if (dbObject.containsField("reviewDate"))        game.setReviewDate((Date)dbObject.get("reviewDate"));
    
    return game;
  }
  
  public static CompactSearchData convertMongoToCompact(DBObject dbObject) {
    if (dbObject == null) return null;
      
    CompactSearchData data = new CompactSearchData();
    
    if (dbObject.containsField("bggID")) {
      data.setSourceID((Long)dbObject.get("bggID"));  
      data.setSourceField("bggID");
    }
    String nameText = "Unavailable";
    if (dbObject.containsField("name")) nameText = (String)dbObject.get("name");
    if (dbObject.containsField("yearPublished")) nameText += " (" + (Integer)dbObject.get("yearPublished") + ")";
    data.setDisplayString(nameText);
    
    if (dbObject.containsField("imageThumbnailURL")) data.setThumbnailURL((String)dbObject.get("imageThumbnailURL"));

    return data;  
  }
  
  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<?> curList) {
    if (curList == null) return null;
    
    BasicDBList newList = new BasicDBList();
    for (Object obj : curList)
      newList.add(obj);
    return newList;
  }
  
  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<String> convertDBListToStringList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<String> newList = new ArrayList<String>(curList.size());
    for (Object obj : curList) {
      newList.add((String)obj);
    }
    return newList;
  }

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<Long> format.
   */
  private static List<Long> convertDBListToLongList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<Long> newList = new ArrayList<Long>(curList.size());
    for (Object obj : curList) {
      newList.add((Long)obj);
    }
    return newList;
  }
}
