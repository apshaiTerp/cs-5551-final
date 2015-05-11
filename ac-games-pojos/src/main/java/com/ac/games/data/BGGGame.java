package com.ac.games.data;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a POJO representing the basic information read from the BoardGameGeek XML API.
 * 
 * @author ac010168
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BGGGame {
  
  /** The objectid for this game on bgg */
  private long bggID;
  /** The game name indicated with the primary attribute on bgg */
  private String name;
  /** The year this game was published according to bgg */
  private int yearPublished;
  /** The minimum number of players capable of playing this game according to bgg */
  private int minPlayers;
  /** The maximum number of players capable of playing this game according to bgg */
  private int maxPlayers;
  /** The minimum playing time for this game according to bgg */
  private int minPlayingTime;
  /** The maximum playing time for this game according to bgg */
  private int maxPlayingTime;
  /** The primary game image shown for the game on bgg */
  private String imageURL;
  /** The primary game thumbnail image shown for the game on bgg */
  private String imageThumbnailURL;
  /** The game description text from bgg */
  private String description;
  
  /** The game ranking from bgg.  This will change from time to time */
  private double bggRating;
  /** The number of users who contributed to the rankings on bgg.  This will also change from time to time */
  private int bggRatingUsers;
  
  /** 
   * The is the list of publisher companies associated with the release of this game on bgg.
   * This list also includes overseas publishers and distributers.
   */
  private List<String> publishers;
  /**
   * This is the list of designers credited with designing this game on bgg.
   * Some people like following certain designers, so this list needs to be searchable as well.
   */
  private List<String> designers;
  /**
   * This is the list of categories associated with this game on bgg.
   * This is more informative and less rigidly defined than other categories.
   * Would probably be good to make this searchable.
   */
  private List<String> categories;
  /**
   * This is the list of mechanisms used by the game according to bgg.
   * This is also a subjective list built wikipedia-style.  It's more informative
   * than defining.
   */
  private List<String> mechanisms;
  
  //**********  The following values are only situationally defined  **********
  /** This is only defined for BASE (or COLLECTIBLE) games. */
  private int bggRank;
  /** 
   * This is only defined for BASE games.  This will be a list of expansion titles
   * that references the objectIDs of those expansion games. 
   */
  private List<Long> expansionIDs;
  /**
   * This is only defined for EXPANSION games.  This is a reference to the parent
   * objectID value to tie the expansion to it's parent game.
   */
  private long parentGameID;
  
  //**********  This is my only imposed metadata field, which is required  ********** 
  //**********  to help sort out the other optional fields.                **********
  /** Helps identify which type of game this is. */
  private GameType gameType;

  //**********  These are fields to help with the data review  **********
  /** Flag to help us know the review state of this object */
  private ReviewState reviewState;
  /** Date this record was added to the system */
  private Date addDate;
  /** Date this record was reviewed */
  private Date reviewDate;
  
  /**
   * Some games can have a ranking, but haven't been ranked yet (not yet released titles).
   * This is to help us identify that category.
   */
  public final static int NOT_RANKED_RANKING = -999;
  
  /**
   * Basic Constructor.  Default all values to nulls or -1.
   */
  public BGGGame() {
    bggID             = -1L;
    name              = null;
    yearPublished     = -1;
    minPlayers        = -1;
    maxPlayers        = -1;
    minPlayingTime    = -1;
    maxPlayingTime    = -1;
    imageURL          = null;
    imageThumbnailURL = null;
    description       = null;
    
    bggRating         = -1.0;
    bggRatingUsers    = -1;
    
    publishers        = null;
    designers         = null;
    categories        = null;
    mechanisms        = null;
    
    bggRank           = -1;
    expansionIDs      = null;
    parentGameID      = -1;
    gameType          = null;
    
    reviewState       = null;
    addDate           = null;
    reviewDate        = null;
  }
  
  public BGGGame(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      BGGGame game = mapper.readValue(jsonString, BGGGame.class);
      bggID             = game.bggID;
      name              = game.name;
      yearPublished     = game.yearPublished;
      minPlayers        = game.minPlayers;
      maxPlayers        = game.minPlayers;
      minPlayingTime    = game.minPlayingTime;
      maxPlayingTime    = game.maxPlayingTime;
      imageURL          = game.imageURL;
      imageThumbnailURL = game.imageThumbnailURL;
      description       = game.description;
      
      bggRating         = game.bggRating;
      bggRatingUsers    = game.bggRatingUsers;
      
      publishers        = game.publishers;
      designers         = game.designers;
      categories        = game.categories;
      mechanisms        = game.mechanisms;
      
      bggRank           = game.bggRank;
      expansionIDs      = game.expansionIDs;
      parentGameID      = game.parentGameID;
      gameType          = game.gameType;
      
      reviewState       = game.reviewState;
      addDate           = game.addDate;
      reviewDate        = game.reviewDate;
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  
  /**
   * Debug Helper to dump out the contents of this object
   */
  public void printContentsForDebug() {
    System.out.println ("Printing contents for Game ID " + getBggID());
    System.out.println ("============================================================");
    System.out.println ("Name:                " + getName());
    System.out.println ("Year Published:      " + getYearPublished());
    System.out.println ("Players:             " + getMinPlayers() + " - " + getMaxPlayers());
    System.out.println ("Playing Time:        " + getMinPlayingTime() + " - " + getMaxPlayingTime());
    System.out.println ("Image URL:           " + getImageURL());
    System.out.println ("Image Thumbnail URL: " + getImageThumbnailURL());
    System.out.println ("Description:         " + getDescription());
    System.out.println ("BGG Rating:          " + getBggRating() + " (Rated by " + getBggRatingUsers() + ")");

    if (getPublishers() != null) {
      System.out.println ("Publishers:          [" + publishers.size() + "]");
      for (String publisher : publishers)
        System.out.println ("                     " + publisher);
    } else     System.out.println ("Publishers:          [-]");

    if (getDesigners() != null) {
      System.out.println ("Designers:           [" + designers.size() + "]");
      for (String designer : designers)
        System.out.println ("                     " + designer);
    } else     System.out.println ("Designers:           [-]");

    if (getCategories() != null) {
      System.out.println ("Categories:          [" + categories.size() + "]");
      for (String category : categories)
        System.out.println ("                     " + category);
    } else     System.out.println ("Categories:          [-]");

    if (getMechanisms() != null) {
      System.out.println ("Mechanisms:          [" + mechanisms.size() + "]");
      for (String mechanism : mechanisms)
        System.out.println ("                     " + mechanism);
    } else     System.out.println ("Mechanisms:          [-]");

    switch (getGameType()) {
      case BASE        : System.out.println ("Game Type:           Base");        break;
      case EXPANSION   : System.out.println ("Game Type:           Expansion");   break;
      case COLLECTIBLE : System.out.println ("Game Type:           Collectible"); break;
      default : System.out.println ("Game Type:           Undefined");
    }
    
    if (getGameType() == GameType.BASE) {
      System.out.println ("bggRank:             " + ((getBggRank() == NOT_RANKED_RANKING) ? "Not Ranked" : getBggRank()));
      System.out.println ("Parent Game:         N/A");
      if (getExpansionIDs() != null) {
        System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        for (Long expansion : expansionIDs)
          System.out.println ("                     " + expansion);
      } else     System.out.println ("Expansions:          [-]");
    } else if (gameType == GameType.COLLECTIBLE) {
      System.out.println ("bggRank:             " + ((getBggRank() == NOT_RANKED_RANKING) ? "Not Ranked" : getBggRank()));
      System.out.println ("Parent Game:         N/A");
      if (getExpansionIDs() != null) {
        System.out.println ("Expansions:          [" + expansionIDs.size() + "]");
        for (Long expansion : expansionIDs)
          System.out.println ("                     " + expansion);
      } else     System.out.println ("Expansions:          [-]");
    } else if (gameType == GameType.EXPANSION) {
      System.out.println ("bggRank:             N/A");
      System.out.println ("Parent Game:         " + getParentGameID());
      System.out.println ("Expansions:          N/A");
    }
    
    if (getReviewState() == null) {
      System.out.println ("Review State:        [-]");
    } else {
      switch (reviewState) {
        case PENDING  : System.out.println ("Review State:        Pending");  break;
        case REVIEWED : System.out.println ("Review State:        Reviewed"); break;
        case REJECTED : System.out.println ("Review State:        Rejected"); break;
      }
    }
    if (getAddDate() != null) System.out.println ("Add Date:            " + addDate); 
    else                      System.out.println ("Add Date:            [-]"); 
    if (getReviewDate() != null) System.out.println ("Review Date:         " + reviewDate); 
    else                         System.out.println ("Review Date:         [-]"); 
  }
  
  /**
   * @return the bggID
   */
  public long getBggID() {
    return bggID;
  }

  /**
   * @param bggID the bggID to set
   */
  public void setBggID(long bggID) {
    this.bggID = bggID;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the yearPublished
   */
  public int getYearPublished() {
    return yearPublished;
  }

  /**
   * @param yearPublished the yearPublished to set
   */
  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  /**
   * @return the minPlayers
   */
  public int getMinPlayers() {
    return minPlayers;
  }

  /**
   * @param minPlayers the minPlayers to set
   */
  public void setMinPlayers(int minPlayers) {
    this.minPlayers = minPlayers;
  }

  /**
   * @return the maxPlayers
   */
  public int getMaxPlayers() {
    return maxPlayers;
  }

  /**
   * @param maxPlayers the maxPlayers to set
   */
  public void setMaxPlayers(int maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  /**
   * @return the minPlayingTime
   */
  public int getMinPlayingTime() {
    return minPlayingTime;
  }

  /**
   * @param minPlayingTime the minPlayingTime to set
   */
  public void setMinPlayingTime(int minPlayingTime) {
    this.minPlayingTime = minPlayingTime;
  }

  /**
   * @return the maxPlayingTime
   */
  public int getMaxPlayingTime() {
    return maxPlayingTime;
  }

  /**
   * @param maxPlayingTime the maxPlayingTime to set
   */
  public void setMaxPlayingTime(int maxPlayingTime) {
    this.maxPlayingTime = maxPlayingTime;
  }

  /**
   * @return the imageURL
   */
  public String getImageURL() {
    return imageURL;
  }

  /**
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  /**
   * @return the imageThumbnailURL
   */
  public String getImageThumbnailURL() {
    return imageThumbnailURL;
  }

  /**
   * @param imageThumbnailURL the imageThumbnailURL to set
   */
  public void setImageThumbnailURL(String imageThumbnailURL) {
    this.imageThumbnailURL = imageThumbnailURL;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * We've added to this method to strip out line break characters and other HTML-encoded values.
   * We may need to add more as elements get discovered.
   * 
   * @param description the description to set
   */
  public void setDescription(String description) {
    if (description == null)
      this.description = description;
    else {
      this.description = description.replaceAll("<br/>", "\n").replaceAll("&mdash;", "-").trim();
    }
  }

  /**
   * @return the bggRating
   */
  public double getBggRating() {
    return bggRating;
  }

  /**
   * @param bggRating the bggRating to set
   */
  public void setBggRating(double bggRating) {
    this.bggRating = bggRating;
  }

  /**
   * @return the bggRatingUsers
   */
  public int getBggRatingUsers() {
    return bggRatingUsers;
  }

  /**
   * @param bggRatingUsers the bggRatingUsers to set
   */
  public void setBggRatingUsers(int bggRatingUsers) {
    this.bggRatingUsers = bggRatingUsers;
  }

  /**
   * @return the publishers
   */
  public List<String> getPublishers() {
    return publishers;
  }

  /**
   * @param publishers the publishers to set
   */
  public void setPublishers(List<String> publishers) {
    this.publishers = publishers;
  }

  /**
   * @return the designers
   */
  public List<String> getDesigners() {
    return designers;
  }

  /**
   * @param designers the designers to set
   */
  public void setDesigners(List<String> designers) {
    this.designers = designers;
  }

  /**
   * @return the categories
   */
  public List<String> getCategories() {
    return categories;
  }

  /**
   * @param categories the categories to set
   */
  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  /**
   * @return the mechanisms
   */
  public List<String> getMechanisms() {
    return mechanisms;
  }

  /**
   * @param mechanisms the mechanisms to set
   */
  public void setMechanisms(List<String> mechanisms) {
    this.mechanisms = mechanisms;
  }

  /**
   * @return the bggRank
   */
  public int getBggRank() {
    return bggRank;
  }

  /**
   * @param bggRank the bggRank to set
   */
  public void setBggRank(int bggRank) {
    this.bggRank = bggRank;
  }

  /**
   * @return the expansionIDs
   */
  public List<Long> getExpansionIDs() {
    return expansionIDs;
  }

  /**
   * @param expansionIDs the expansionIDs to set
   */
  public void setExpansionIDs(List<Long> expansionIDs) {
    this.expansionIDs = expansionIDs;
  }

  /**
   * @return the parentGameID
   */
  public long getParentGameID() {
    return parentGameID;
  }

  /**
   * @param parentGameID the parentGameID to set
   */
  public void setParentGameID(long parentGameID) {
    this.parentGameID = parentGameID;
  }

  /**
   * @return the gameType
   */
  public GameType getGameType() {
    return gameType;
  }

  /**
   * @param gameType the gameType to set
   */
  public void setGameType(GameType gameType) {
    this.gameType = gameType;
  }

  /**
   * @return the reviewState
   */
  public ReviewState getReviewState() {
    return reviewState;
  }

  /**
   * @param reviewState the reviewState to set
   */
  public void setReviewState(ReviewState reviewState) {
    this.reviewState = reviewState;
  }

  /**
   * @return the addDate
   */
  public Date getAddDate() {
    return addDate;
  }

  /**
   * @param addDate the addDate to set
   */
  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }

  /**
   * @return the reviewDate
   */
  public Date getReviewDate() {
    return reviewDate;
  }

  /**
   * @param reviewDate the reviewDate to set
   */
  public void setReviewDate(Date reviewDate) {
    this.reviewDate = reviewDate;
  }
}
