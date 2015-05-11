package com.ac.games.db;

import java.util.List;

import com.ac.games.data.BGGGame;
import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CompactSearchData;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameType;
import com.ac.games.data.MMDataStats;
import com.ac.games.data.MediaItem;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.PlaythruItem;
import com.ac.games.data.User;
import com.ac.games.data.UserCollectionStats;
import com.ac.games.data.UserDetail;
import com.ac.games.data.WishlistItem;
import com.ac.games.db.exception.ConfigurationException;
import com.ac.games.db.exception.DatabaseOperationException;

/**
 * This interface needs to account for all database CRUD operations that can be performed.  Additional
 * tasks may be added to here or to an additional interface, but all basic objects from the pojos library
 * should be implemented via method calls in this interface, rather than stacking a bunch of interfaces
 * together.
 * 
 * @author ac010168
 */
public interface GamesDatabase {

  //**********  Implementing Basic Maintenance Tasks for the Database Connection  **********
  /**
   * This method should specifically open the connection to the provided database implementation.
   * @throws ConfigurationException Throws this Exception if there are configuration problems that prevent
   * the database connection from being established.
   */
  public void initializeDBConnection() throws ConfigurationException;
  
  /**
   * This method should specifically close the open connection to the provided database implementation.
   * This method should not throw an error if the database connection has not been opened.
   * 
   * @throws ConfigurationException Throws this Exception if there were problems closing down the open
   * database connection.
   */
  public void closeDBConnection() throws ConfigurationException;
  
  //**********  Implementing Basic CRUD Operations for BGGData  **********
  /**
   * This method should query the database for the requested {@link BGGGame} by bggID.
   * 
   * @param bggID The bggID from BoardGameGeek for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public BGGGame readBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link BGGGame} data into the database.  If the object already
   * exists, this method should throw a {@link DatabaseOperationException}.
   * 
   * @param game The {@link BGGGame} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link BGGGame} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param game The {@link BGGGame} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateBGGGameData(BGGGame game) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link BGGGame} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param bggID The bggID from BoardGameGeek for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteBGGGameData(long bggID) throws ConfigurationException, DatabaseOperationException;
  
  //**********  Implementing Basic CRUD Operations for CoolStuffIncPriceData  **********
  /**
   * This method should query the database for the requested {@link CoolStuffIncPriceData} by csiID.
   * 
   * @param csiID The csiID from CoolStuffInc for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public CoolStuffIncPriceData readCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link CoolStuffIncPriceData} data into the database.  If the object already
   * exists, this method should throw a {@link DatabaseOperationException}.
   * 
   * @param csiData The {@link CoolStuffIncPriceData} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link CoolStuffIncPriceData} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param csiData The {@link CoolStuffIncPriceData} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateCSIPriceData(CoolStuffIncPriceData csiData) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link CoolStuffIncPriceData} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param csiID The csiID from CoolStuffInc for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteCSIPriceData(long csiID) throws ConfigurationException, DatabaseOperationException;

  //**********  Implementing Basic CRUD Operations for MiniatureMarketPriceData  **********
  /**
   * This method should query the database for the requested {@link MiniatureMarketPriceData} by mmID.
   * 
   * @param mmID The mmID from Miniature Market for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public MiniatureMarketPriceData readMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link MiniatureMarketPriceData} data into the database.  If the object already
   * exists, this method should throw a {@link DatabaseOperationException}.
   * 
   * @param mmData The {@link MiniatureMarketPriceData} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link MiniatureMarketPriceData} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param mmData The {@link MiniatureMarketPriceData} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateMMPriceData(MiniatureMarketPriceData mmData) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link MiniatureMarketPriceData} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param mmID The mmID from Miniature Market for this game.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteMMPriceData(long mmID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Query to read {@link Game} content from the database
   * 
   * @param gameID The gameID we want to find
   * 
   * @return A {@link Game} object, nor null if not found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   */
  public Game readGame(long gameID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Query to read {@link Game} content from the database
   * 
   * @param bggID The bggID this game was based on
   * 
   * @return A {@link Game} object, nor null if not found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   */
  public Game readGameByBGGID(long bggID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Query to read {@link Game} content from the database
   * 
   * @param gameName The name of the game we want to search for
   * @param addWildCard Flag to determine if we want to add wild card searching to our search name
   * @param gameTypeFilter Filter by game type, such as BASE or EXPANSION only.  Default is BASE_AND_COLLECTIBLE
   * 
   * @return a List of {@link Game} entries matching this name pattern
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<Game> readGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Query to read {@link Game} content from the database
   * 
   * @param gameName The name of the game we want to search for
   * @param primaryPublisher The name of the primary publisher, if available
   * @param yearPublished The year this game was published.
   * 
   * @return a List of {@link Game} entries matching this name pattern
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public CompactSearchData readGameFromAutoName(String gameName, String primaryPublisher, int yearPublished) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link Game} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param game The {@link Game} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertGame(Game game) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the new {@link Game} data into the database.  If the object does not
   * exist, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param game The {@link Game} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateGame(Game game) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link Game} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param gameID The gameID for this Game in the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteGame(long gameID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Query to read {@link GameReltn} content from the database
   * 
   * @param gameID The gameID we want to find
   * 
   * @return A {@link GameReltn} object, nor null if not found
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   */
  public GameReltn readGameReltn(long gameID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link GameReltn} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param gameReltn The {@link GameReltn} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the new {@link Game} data into the database.  If the object does not
   * exist, this method can throw a {@link DatabaseOperationException}.  Probably the most common
   * interaction with this object aside from queries.
   * 
   * @param gameReltn The {@link GameReltn} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateGameReltn(GameReltn gameReltn) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method will probably never be used.  It is valid for implementations to not support this
   * operation.  Adding for CRUD completionism.  It's a syndrome.
   * 
   * @param reltnID The reltnID for this GameReltn in the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteGameReltn(long reltnID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Custom Query to get the list of all BoardGameGeek bggIDs currently in our index.
   * 
   * @return A list of bggIDs, or an empty list if none exist.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   */
  public List<Long> getBggIDList() throws ConfigurationException, DatabaseOperationException;

  /**
   * Custom Query to get the list of all CoolStuffInc csiIDs currently in our index.
   * 
   * @return A list of csiIDs, or an empty list if none exist.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<Long> getCSIIDList() throws ConfigurationException, DatabaseOperationException;

  /**
   * Custom Query to get the list of all Miniature Market mmIDs currently in our index.
   * 
   * @return A list of mmIDs, or an empty list if none exist.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<Long> getMMIDList() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Custom Query to get the list of all Game gameIDs currently in our index.
   * 
   * @return A list of gameIDs, or an empty list if none exist.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<Long> getGameIDList() throws ConfigurationException, DatabaseOperationException;

  /**
   * Custom Query to get the list of all GameReltn reltnIDs currently in our index.
   * 
   * @return A list of reltnIDs, or an empty list if none exist.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<Long> getGameReltnIDList() throws ConfigurationException, DatabaseOperationException;

  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxBGGGameID() throws ConfigurationException, DatabaseOperationException;

  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxCSIDataID() throws ConfigurationException, DatabaseOperationException;

  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxMMDataID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxGameID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxGameReltnID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the total count of rows in this table.
   * 
   * @return the count of rows found, which may be 0.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public int getBGGGameCount() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the total count of rows in this table.
   * 
   * @return the count of rows found, which may be 0.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public int getCSIDataCount() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the total count of rows in this table.
   * 
   * @return the count of rows found, which may be 0.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public int getMMDataCount() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the total count of rows in this table.
   * 
   * @return the count of rows found, which may be 0.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public int getGameCount() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link User} by userName.
   * 
   * @param userID The userName for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public User readUser(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link User} by userName.
   * 
   * @param userName The userName for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public User readUser(String userName) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link User} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param user The {@link User} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertUser(User user) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link User} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param user The {@link User} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateUser(User user) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link User} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param userID The userID for this user detail.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteUser(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxUserID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link UserDetail} by userName.
   * 
   * @param userID The userName for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public UserDetail readUserDetail(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link UserDetail} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param userDetail The {@link UserDetail} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link UserDetail} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param userDetail The {@link UserDetail} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateUserDetail(UserDetail userDetail) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link UserDetail} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param userID The userID for this user detail.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteUserDetail(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link Collection} by collectionID.
   * 
   * @param collectionID The collectionID for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public Collection readCollection(long collectionID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link Collection} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param collection The {@link Collection} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertCollection(Collection collection) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link Collection} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param collection The {@link Collection} object to be written to the database.
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateCollection(Collection collection) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link Collection} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param collectionID The collectionID for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteCollection(long collectionID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxCollectionID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link CollectionItem} by itemID.
   * 
   * @param itemID The itemID for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public CollectionItem readCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link CollectionItem} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link CollectionItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should update the existing {@link CollectionItem} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link CollectionItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateCollectionItem(CollectionItem item) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link CollectionItem} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param itemID The itemID for this game.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteCollectionItem(long itemID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxCollectionItemID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link MediaItem}(s) by mediaID.
   * 
   * @param mediaID The mediaID for this media item.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public MediaItem readMediaItemByMediaID(long mediaID) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should query the database for the requested {@link MediaItem}(s) by userID.
   * 
   * @param userID The userID we want to find all media items for
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<MediaItem> readMediaItemsByUserID(long userID) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should query the database for the requested {@link MediaItem}(s) by gameID.
   * 
   * @param gameID The gameID we want to find all media items for
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<MediaItem> readMediaItemsByGameID(long gameID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should insert the new {@link MediaItem} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link MediaItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should update the existing {@link MediaItem} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link MediaItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateMediaItem(MediaItem item) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link CollectionItem} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param mediaID The mediaID for this media item.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteMediaItem(long mediaID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxMediaItemID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link WishlistItem} by wishID.
   * 
   * @param wishID The wishID for this wishlist item.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public WishlistItem readWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should insert the new {@link WishlistItem} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link WishlistItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should update the existing {@link WishlistItem} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link WishlistItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updateWishlistItem(WishlistItem item) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link WishlistItem} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param wishID The wishID for this media item.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteWishlistItem(long wishID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxWishlistItemID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should query the database for the requested {@link PlaythruItem} by playthruID.
   * 
   * @param playthruID The playthruID for this playthrough.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public PlaythruItem readPlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should insert the new {@link PlaythruItem} data into the database.  If the object already
   * exists, this method can throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link PlaythruItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertPlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException;

  /**
   * This method should update the existing {@link WishlistItem} data into the database.  If the object does
   * not exist (or no rows were updated), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param item The {@link WishlistItem} object to be written to the database.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void updatePlaythruItem(PlaythruItem item) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * This method should delete the requested {@link WishlistItem} data from the database.  If the object does
   * not exist (or no rows were deleted), this method may throw a {@link DatabaseOperationException}.
   * 
   * @param playthruID The playthruID for this media item.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deletePlaythruItem(long playthruID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Simple method that allows me to fetch the maximum ID value for this column
   * 
   * @return the maxID value found, or -1 if unable to find it.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public long getMaxPlaythruItemID() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Delete a stats row by stat type.
   * 
   * @param statType The statType we want to remove
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void deleteStatsRow(String statType) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get Game stats for BGGGame data
   * 
   * @return A {@link BGGGameStats} object.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public BGGGameStats readBGGGameStats() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Write game stats for BBGGame data
   * 
   * @param stats The stats for this data type
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertBGGGameStats(BGGGameStats stats) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get Game stats for CSI data
   * 
   * @return A {@link CSIDataStats} object.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public CSIDataStats readCSIDataStats() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Write game stats for CSI data
   * 
   * @param stats The stats for this data type
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertCSIDataStats(CSIDataStats stats) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get Game stats for MM data
   * 
   * @return A {@link MMDataStats} object.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public MMDataStats readMMDataStats() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Write game stats for MM data
   * 
   * @param stats The stats for this data type
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public void insertMMDataStats(MMDataStats stats) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link BGGGame} entry or entries by gameName.
   * 
   * @param gameName The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * @param gameTypeFilter A filter to limit the game types returned 
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<BGGGame> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read compact {@link BGGGame} entry or entries by gameName.
   * 
   * @param gameName The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * @param gameTypeFilter A filter to limit the game types returned 
   * @param resultLimit Limit the number of rows returned
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CompactSearchData> readBGGGameByName(String gameName, boolean addWildCard, GameType gameTypeFilter, int resultLimit) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link BGGGame} entry for items that need review.  This will return a single item that requires review
   * based on the priority assigned by the reviewType.
   * 
   * @param reviewType The review type, typically either 'new' or 'old'
   * 
   * @return A single item requiring reivew, or null if no items require review
   * 
   * @throws ConfigurationException
   * @throws DatabaseOperationException
   */
  public BGGGame readBGGGameForReview(String reviewType) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link CoolStuffIncPriceData} entry or entries by gameName.
   * 
   * @param title The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CoolStuffIncPriceData> readCSIDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException;

  /**
   * Read {@link CoolStuffIncPriceData} entry or entries by gameName.
   * 
   * @param title The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * @param rowLimit Limit the number of results returned, primarily for auto-complete.
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CompactSearchData> readCSIDataByTitle(String title, boolean addWildCard, int rowLimit) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link CoolStuffIncPriceData} entry for items that need review.  This will return a single item that requires review
   * based on the priority assigned by the reviewType.
   * 
   * @param reviewType The review type, typically either 'new' or 'old'
   * 
   * @return A single item requiring reivew, or null if no items require review
   * 
   * @throws ConfigurationException
   * @throws DatabaseOperationException
   */
  public CoolStuffIncPriceData readCSIDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link MiniatureMarketPriceData} entry or entries by gameName.
   * 
   * @param title The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<MiniatureMarketPriceData> readMMDataByTitle(String title, boolean addWildCard) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link MiniatureMarketPriceData} entry or entries by gameName.
   * 
   * @param title The name we want to search for
   * @param addWildCard Flag to indicate whether we should wildcard the ending, to help with tasks like auto-complete.
   * @param rowLimit Limit the number of rows returned, primarily for auto-complete.
   * 
   * @return A List of Games (or an empty list if nothing was found).  Do not return null.
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CompactSearchData> readMMDataByTitle(String title, boolean addWildCard, int rowLimit) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Read {@link MiniatureMarketPriceData} entry for items that need review.  This will return a single item that requires review
   * based on the priority assigned by the reviewType.
   * 
   * @param reviewType The review type, typically either 'new' or 'old'
   * 
   * @return A single item requiring reivew, or null if no items require review
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public MiniatureMarketPriceData readMMDataForReview(String reviewType) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Searches for all Game Names and formats them into a searchable String for auto-complete fields
   * 
   * @return A List of Sorted Strings for searching
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<String> readGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Searches for all Game Names and formats them into a searchable String for auto-complete fields
   * 
   * @return A List of Sorted Strings for searching
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<String> readBGGGameNamesForAutoComplete() throws ConfigurationException, DatabaseOperationException;

  /**
   * Searches for all Game Titles and formats them into a searchable String for auto-complete fields
   * 
   * @return A List of Sorted Strings for searching
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<String> readCSITitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException;

  /**
   * Searches for all Game Titles and formats them into a searchable String for auto-complete fields
   * 
   * @return A List of Sorted Strings for searching
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<String> readMMTitlesForAutoComplete() throws ConfigurationException, DatabaseOperationException;

  /**
   * Reads the smaller truncated form of the Game object for the provided gameIDs
   * 
   * @param gameIDs The GameIDs we want found, tokenized by commas
   * 
   * @return A CompactSearchData object for this particular entry
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CompactSearchData> readGamesCompact(String gameIDs) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Generates the Collection Stats for a user's collection.
   * 
   * @param userID The UserID we want to generate stats for.
   * 
   * @return A UserCollectionStats collection of stats for this user's collection
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public UserCollectionStats readCollectionStats(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Gets the X most recent new items in a user's collection.
   * 
   * @param userID The User for our collection
   * @param topX  The number of most recent games we want returned
   * 
   * @return A List of CollectionItem entries for us to consider
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<CollectionItem> getNewestCollectionItems(long userID, int topX) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get the entire wishlist for this userID.
   * 
   * @param userID The userID we want to get the wishlist for.
   * 
   * @return A List of WishlistItem entries
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<WishlistItem> readWishlistForUser(long userID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get all wishlist entries matching this game
   * 
   * @param gameID The gameID we want to get the wishlist entries for.
   * 
   * @return A List of WishlistItem entries
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public List<WishlistItem> readWishlistByGame(long gameID) throws ConfigurationException, DatabaseOperationException;
  
  /**
   * Get a single item for some reason
   * 
   * @param userID The userID we want to get the wishlist for.
   * @param gameID The gameID we want to get the wishlist for.
   * 
   * @return A List of WishlistItem entries
   * 
   * @throws ConfigurationException Throws this exception if the database connection is not active.
   * @throws DatabaseOperationException Throws this exception if there are errors during the execution
   * of the requested operation.
   */
  public WishlistItem readWishlistItem(long userID, long gameID)  throws ConfigurationException, DatabaseOperationException;
}
