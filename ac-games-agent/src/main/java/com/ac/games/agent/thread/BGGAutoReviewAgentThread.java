package com.ac.games.agent.thread;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ac.games.agent.data.PreferredPublisherList;
import com.ac.games.data.BGGGame;
import com.ac.games.data.Game;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameType;
import com.ac.games.data.ReviewState;
import com.ac.games.data.ReviewStateConverter;
import com.ac.games.db.mongo.BGGGameConverter;
import com.ac.games.db.mongo.GameConverter;
import com.ac.games.db.mongo.GameReltnConverter;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author ac010168
 *
 */
public class BGGAutoReviewAgentThread extends Thread {

  public BGGAutoReviewAgentThread() {
    super();
  }
  
  /*
   * (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {
    executeMainTask();
  }
  
  /**
   * Helper method to do the main work of this Agent
   */
  private void executeMainTask() {
    //We want to start by weeding out any junk data entries, which should be less when finalized, but could be a lot now.
    //For most of this class, we are going to bypass the service and communicate directly with the database because the
    //queryies we need to run are too specific.
    //Console console = System.console();
    
    MongoClient client = null;
    try {
      client = new MongoClient("localhost", 27017);
    } catch (UnknownHostException e) {
      e.printStackTrace();
      return;
    }
    
    DB mongoDB = client.getDB("livedb");
    DBCollection bggCollection   = mongoDB.getCollection("bgggame");
    DBCollection gameCollection  = mongoDB.getCollection("game");
    DBCollection reltnCollection = mongoDB.getCollection("gamereltn");
    
    //Categories of invalid of junk criteria
    //Base game with no player data
    //db.bgggame.find( { reviewState: 0, minPlayers: {$exists:false}} )
    BasicDBObject queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("minPlayers", new BasicDBObject("$exists", false));
    
    System.out.println ("Running the following Query:\n  db.bgggame.find( " + queryObject.toString() + " )");
    //String value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    DBCursor cursor = bggCollection.find(queryObject);
    List<BGGGame> gamesToReject = new LinkedList<BGGGame>();
    
    cursor.limit(20000);
    //DEBUG
    int readCount = 0;
    
    while (cursor.hasNext()) {
      //DEBUG
      readCount++;
      System.out.println ("Reading in row " + readCount);
      
      DBObject object = cursor.next();
      BGGGame game = BGGGameConverter.convertMongoToGame(object);
      game.setReviewState(ReviewState.REJECTED);
      game.setReviewDate(new Date());
      gamesToReject.add(game);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    
    System.out.println ("I found " + gamesToReject.size() + " games with missing player data fields that are about to be rejected.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    int count = 0;
    for (BGGGame game : gamesToReject) {
      count++;
      System.out.println ("[" + count + "/" + gamesToReject.size() + "] Rejecting " + game.getName() + " (bggID:" + game.getBggID() + ")");
      
      DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
      DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
      
      bggCollection.update(matchObject, writeObject, true, false);
    }
    gamesToReject.clear();
    
    if (readCount == 20000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting.");
      return;
    }
    
    /****************************************************************************************************/
    //We need to pull sequence values in case we'll be adding anything:
    long maxGameID  = Math.max(0, getMaxGameSequenceValue(gameCollection));
    long maxReltnID = Math.max(0, getMaxGameReltnSequenceValue(reltnCollection));
    
    /****************************************************************************************************/
    //Now we want to identify and auto-approve games with no publisher listed.
    //First we do parents, then we do children
    //db.bgggame.find( { reviewState: 0, gameType: {$in: [0, 2]}, publishers : {$exists:true}, $where:'this.publishers.length<1'} )
    BasicDBList parentList = new BasicDBList();
    parentList.add(0);
    parentList.add(2);
    
    queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("gameType", new BasicDBObject("$in", parentList));
    queryObject.append("publishers", new BasicDBObject("$exists", true));
    queryObject.append("publishers.1", new BasicDBObject("$exists", false));
    
    System.out.println ("Running the following Query:\n  db.bgggame.find( " + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    cursor = bggCollection.find(queryObject);
    List<BGGGame> gamesToApprove = new LinkedList<BGGGame>();
    
    cursor.limit(20000);
    readCount = 0;
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      BGGGame game = BGGGameConverter.convertMongoToGame(object);
      game.setReviewState(ReviewState.REVIEWED);
      game.setReviewDate(new Date());
      gamesToApprove.add(game);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    
    System.out.println ("I found " + gamesToApprove.size() + " games with simple publisher data that are about to be approved.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    count = 0;
    for (BGGGame game : gamesToApprove) {
      count++;
      System.out.println ("[" + count + "/" + gamesToApprove.size() + "] Approving " + game.getName() + " (bggID:" + game.getBggID() + ")");
      
      DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
      DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
      
      bggCollection.update(matchObject, writeObject, true, false);
      
      String primaryPublisher = "No Publisher Listed";
      if ((game.getPublishers() != null) && (game.getPublishers().size() == 1))
        primaryPublisher = game.getPublishers().get(0);
      
      maxGameID++;
      Game newGame = convertBGGGameToGame(game, maxGameID, 0, primaryPublisher);
      
      maxReltnID++;
      GameReltn newGameReltn = new GameReltn();
      newGameReltn.setReltnID(maxReltnID);
      newGameReltn.setGameID(maxGameID);
      newGameReltn.setBggID(game.getBggID());
      newGameReltn.setCsiIDs(new ArrayList<Long>());
      newGameReltn.setMmIDs(new ArrayList<Long>());
      newGameReltn.setAsinKeys(new ArrayList<String>());
      newGameReltn.setOtherSites(new ArrayList<Long>());
      
      //Our upserts should join against the bggID, so that if we are updating, we will match correctly.
      BasicDBObject matchGameObject  = new BasicDBObject("bggID", game.getBggID());
      BasicDBObject matchReltnObject = new BasicDBObject("bggID", game.getBggID());
      
      DBObject writeGameObject  = GameConverter.convertGameToMongo(newGame);
      DBObject writeReltnObject = GameReltnConverter.convertGameReltnToMongo(newGameReltn);
      
      gameCollection.update(matchGameObject, writeGameObject, true, false);
      reltnCollection.update(matchReltnObject, writeReltnObject, true, false);
    }
    gamesToApprove.clear();

    if (readCount == 20000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting.");
      return;
    }
    
    /****************************************************************************************************/
    //Now we want to identify and auto-approve as many BASE/COLLECTIBLE games as possible that have multiple
    //publishers.  We have two lists, a large one of 'trusted' Publishers, and a small one of publisher descriptions
    //to be avoided.  Once we get our list, we want to try and filter through those items and make some assumptions.
    queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("gameType", new BasicDBObject("$in", parentList));
    queryObject.append("publishers", new BasicDBObject("$exists", true));
    queryObject.append("publishers.1", new BasicDBObject("$exists", true));
    
    System.out.println ("Running the following Query:\n  db.bgggame.find( "  + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
     
    cursor = bggCollection.find(queryObject);
    
    cursor.limit(20000);
    readCount = 0;
    
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      BGGGame game = BGGGameConverter.convertMongoToGame(object);
      gamesToApprove.add(game);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    
    System.out.println ("I found " + gamesToApprove.size() + " games with complex publisher data that are about to be approved.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    List<String> preferredList = PreferredPublisherList.getTrustedPublishers();
    int unableToApproveCount = 0;
    count = 0;
    for (BGGGame game : gamesToApprove) {
      count++;
      System.out.println ("[" + count + "/" + gamesToApprove.size() + "] Approving " + game.getName() + " (bggID:" + game.getBggID() + ")");
      
      List<String> publishers = new ArrayList<String>();
      //Need this to be a separate list so we don't affect the underlying game.
      for (String curPub : game.getPublishers())
        publishers.add(new String(curPub));
      
      String primaryPublisher = "";
      boolean approve = false;
      
      boolean isSelfPublished = false;
      boolean isWebPublished  = false;
      boolean isUnpublished   = false;
      boolean isUnknown       = false;
      
      if (publishers.contains("(Self-published)")) {
        isSelfPublished = true;
        publishers.remove("(Self-published)");
      }
      if (publishers.contains("(Web published)")) {
        isWebPublished = true;
        publishers.remove("(Web published)");
      }
      if (publishers.contains("(Unpublished)")) {
        isUnpublished = true;
        publishers.remove("(Unpublished)");
      }
      if (publishers.contains("(Unknown)")) {
        isUnknown = true;
        publishers.remove("(Unknown)");
      }

      if (publishers.size() == 0) {
        //System.out.println ("!" + game.getName() + " has no only avoided publishers");
        if (isSelfPublished)     primaryPublisher = "(Self-published)";
        else if (isWebPublished) primaryPublisher = "(Web published)";
        else if (isUnpublished)  primaryPublisher = "(Unpublished)";
        else if (isUnknown)      primaryPublisher = "(Unknown)";
        approve = true;
      }
      if (publishers.size() == 1) {
        primaryPublisher = publishers.get(0);
        approve = true;
      }
      
      //If eliminating bad fields didn't help, then we need to look through our trusted list and see what we find
      if (!approve) {
        int foundHits = 0;
        for (String publisher : publishers) {
          if (preferredList.contains(publisher)) {
            foundHits++;
          }
        }
        
        if (foundHits == 0) {
          //There were no trusted results, then we should set the value to "Mulitple Publishers"
          //This can always be corrected as needed later
          primaryPublisher = "Multiple Publishers";
          approve = true;
        }
        
        if (foundHits == 1) {
          //This is kind of the perfect spot.  We found just one trusted hit.  Of course, now we need to find it again
          for (String publisher : publishers) {
            if (preferredList.contains(publisher)) {
              primaryPublisher = publisher;
            }
          }
          approve = true;
        }
        
        if (foundHits >= 2) {
          //This is the case that needs manual inspecting.  These have mutliple 'trusted' games in their list.
          //We cannot touch this row.
          String publisherList = "|";
          for (String publisher : publishers) {
            if (preferredList.contains(publisher)) {
              publisherList += publisher + "|";
            }
          }
          System.out.println ("  This game could not be auto-reviewed because of the following publisher set:\n  " + publisherList);
          approve = false;
        }
      }
      
      if (approve) {
        game.setReviewState(ReviewState.REVIEWED);
        game.setAddDate(new Date());
        
        DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
        DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
        
        bggCollection.update(matchObject, writeObject, true, false);

        maxGameID++;
        Game newGame = convertBGGGameToGame(game, maxGameID, 0, primaryPublisher);
        
        maxReltnID++;
        GameReltn newGameReltn = new GameReltn();
        newGameReltn.setReltnID(maxReltnID);
        newGameReltn.setGameID(maxGameID);
        newGameReltn.setBggID(game.getBggID());
        newGameReltn.setCsiIDs(new ArrayList<Long>());
        newGameReltn.setMmIDs(new ArrayList<Long>());
        newGameReltn.setAsinKeys(new ArrayList<String>());
        newGameReltn.setOtherSites(new ArrayList<Long>());
        
        //Our upserts should join against the bggID, so that if we are updating, we will match correctly.
        BasicDBObject matchGameObject  = new BasicDBObject("bggID", game.getBggID());
        BasicDBObject matchReltnObject = new BasicDBObject("bggID", game.getBggID());
        
        DBObject writeGameObject  = GameConverter.convertGameToMongo(newGame);
        DBObject writeReltnObject = GameReltnConverter.convertGameReltnToMongo(newGameReltn);
        
        gameCollection.update(matchGameObject, writeGameObject, true, false);
        reltnCollection.update(matchReltnObject, writeReltnObject, true, false);
      } else {
        unableToApproveCount++;
      }
    }//end for all games with multiple publishers
    System.out.println ("I approved " + (gamesToApprove.size() - unableToApproveCount) + " of " + 
        gamesToApprove.size() + " BASE/COLLECTION games with multiple publishers");
    System.out.println ("There were " + unableToApproveCount + " games that had multiple trusted publishers and could not be approved.");
    
    gamesToApprove.clear();

    if (readCount == 20000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting.");
      return;
    }
    
    /****************************************************************************************************/
    //Now we want to identify and auto-approve games with no publisher listed.
    //Now we are tackling the children
    //db.bgggame.find( { reviewState: 0, gameType: 1, publishers : {$exists:true}, $where:'this.publishers.length<2'} )
    queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("gameType", 1);
    queryObject.append("publishers", new BasicDBObject("$exists", true));
    queryObject.append("publishers.1", new BasicDBObject("$exists", false));
    
    System.out.println ("Running the following Query:\n  db.bgggame.find( " + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    cursor = bggCollection.find(queryObject);
    
    cursor.limit(20000);
    readCount = 0;
    
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      BGGGame game = BGGGameConverter.convertMongoToGame(object);
      game.setReviewState(ReviewState.REVIEWED);
      game.setReviewDate(new Date());
      gamesToApprove.add(game);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    
    System.out.println ("I found " + gamesToApprove.size() + " game expansions with simple publisher data that are about to be approved.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    count = 0;
    int rejectNoParentCount = 0;
    int rejectBecauseParentCount = 0;
    int skipCount = 0;
    for (BGGGame game : gamesToApprove) {
      count++;
      System.out.println ("[" + count + "/" + gamesToApprove.size() + "] Approving " + game.getName() + " (bggID:" + game.getBggID() + ")");
      
      boolean rejectFlag = false;
      if (game.getParentGameID() <= 0) {
        System.out.println ("  Changing review to Rejected because this game has no parentGameID defined");
        rejectNoParentCount++;
        rejectFlag = true;
      }
      
      if (!rejectFlag) {
        //Before we approve an expansion, we need to check a few things.
        //First, does its parent already exist in the system?  If not, we must reject it
        //This is the query we need to figure out what we want:
        //db.bgggame.aggregate( [ { $match: { bggID: xxxxxx}}, 
        //                        { $project: { bggID: 1, reviewState: 1, publisherSize: { $size: "$publishers"}}} ])
        BasicDBObject matchBGGIDAggregate = new BasicDBObject("$match", new BasicDBObject("bggID", game.getParentGameID()));
        BasicDBObject subProjectObject = new BasicDBObject();
        subProjectObject.append("bggID", 1);
        subProjectObject.append("reviewState", 1);
        subProjectObject.append("publisherSize", new BasicDBObject("$size", "$publishers"));
        BasicDBObject projectAggregate = new BasicDBObject("$project", subProjectObject);
        
        List<DBObject> pipeline = new ArrayList<DBObject>(2);
        pipeline.add(matchBGGIDAggregate);
        pipeline.add(projectAggregate);
        AggregationOutput output = bggCollection.aggregate(pipeline);
        
        long parentBGGGameID = -1;
        ReviewState parentReviewState = null;
        int parentPublisherSize = 0;
        for (DBObject object : output.results()) {
          if (object.containsField("bggID"))         parentBGGGameID     = (Long)object.get("bggID");
          if (object.containsField("reviewState"))   parentReviewState   = ReviewStateConverter.convertFlagToReviewState((Integer)object.get("reviewState"));
          if (object.containsField("publisherSize")) parentPublisherSize = (Integer)object.get("publisherSize");
        }
        //If we didn't find the parent game identified, reject it
        if (parentBGGGameID == -1) {
          System.out.println ("  Changing review to Rejected because this game's parentGameID doesn't exist");
          rejectFlag = true;
        }
        
        if (parentReviewState == ReviewState.PENDING) {
          System.out.println ("  Skipping this game expansion because it's parent game hasn't been processed yet.");
          System.out.println ("  That might be because the parent game has a publisherSize value of " + parentPublisherSize);
          skipCount++;
          continue;
        }
        if (parentReviewState == ReviewState.REJECTED) {
          System.out.println ("  Changing review to Rejected because this game's parent game was also rejected");
          rejectBecauseParentCount++;
          rejectFlag = true;
        }
      }
      
      //Now, assuming we're still in the clear, we need to find the actual Game ID from the Game table of the parent Game
      long parentGameID = 0;
      if (!rejectFlag) {
        BasicDBObject findParentObject  = new BasicDBObject("bggID", game.getParentGameID());
        BasicDBObject limitParentObject = new BasicDBObject("_id", 0);
        limitParentObject.append("gameID", 1);
        cursor = gameCollection.find(findParentObject, limitParentObject);
        while (cursor.hasNext()) {
          DBObject object = cursor.next();
          if (object.containsField("gameID")) parentGameID = (Long)object.get("gameID");
        }
        if (parentGameID == 0) {
          System.out.println ("  Changing review to Rejected because this game's parent game ID in Game doesn't exist");
          rejectFlag = true;
        }
      }
      
      if (rejectFlag) {
        //If the game is rejected, just run the reject
        game.setReviewState(ReviewState.REJECTED);
        
        DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
        DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
        
        bggCollection.update(matchObject, writeObject, true, false);
      } else {
        //If the game is approved, change the game state, then write the corresponding data pieces,
        //The new Game and GameReltn entry, as well as update the parent entry to add this game as an expansion
        DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
        DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
        
        bggCollection.update(matchObject, writeObject, true, false);
        
        String primaryPublisher = "No Publisher Listed";
        if ((game.getPublishers() != null) && (game.getPublishers().size() == 1))
          primaryPublisher = game.getPublishers().get(0);
        
        maxGameID++;
        Game newGame = convertBGGGameToGame(game, maxGameID, parentGameID, primaryPublisher);
        
        maxReltnID++;
        GameReltn newGameReltn = new GameReltn();
        newGameReltn.setReltnID(maxReltnID);
        newGameReltn.setGameID(maxGameID);
        newGameReltn.setBggID(game.getBggID());
        newGameReltn.setCsiIDs(new ArrayList<Long>());
        newGameReltn.setMmIDs(new ArrayList<Long>());
        newGameReltn.setAsinKeys(new ArrayList<String>());
        newGameReltn.setOtherSites(new ArrayList<Long>());
        
        //Our upserts should join against the bggID, so that if we are updating, we will match correctly.
        BasicDBObject matchGameObject  = new BasicDBObject("bggID", game.getBggID());
        BasicDBObject matchReltnObject = new BasicDBObject("bggID", game.getBggID());
        
        DBObject writeGameObject  = GameConverter.convertGameToMongo(newGame);
        DBObject writeReltnObject = GameReltnConverter.convertGameReltnToMongo(newGameReltn);
        
        gameCollection.update(matchGameObject, writeGameObject, true, false);
        reltnCollection.update(matchReltnObject, writeReltnObject, true, false);
        
        //Now we need to add the new expansion gameID to the expansion ID list of the parent game
        BasicDBObject findParentQuery = new BasicDBObject("gameID", parentGameID);
        cursor = gameCollection.find(findParentQuery);
        Game parentGame = null;
        while (cursor.hasNext()) {
          DBObject object = cursor.next();
          parentGame = GameConverter.convertMongoToGame(object);
        }
        try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
        
        List<Long> expansions = parentGame.getExpansionIDs();
        if (expansions == null) expansions = new ArrayList<Long>();
        expansions.add(newGame.getGameID());
        parentGame.setExpansionIDs(expansions);
        
        BasicDBObject writeParentGame = GameConverter.convertGameToMongo(parentGame);
        gameCollection.update(findParentQuery, writeParentGame);
      }
    }
    
    System.out.println ("I reviewed " + gamesToApprove.size() + " game expansions, with the following exceptions:");
    System.out.println ("  I skipped " + skipCount + " because the parent games were not yet processed");
    System.out.println ("  I rejected " + rejectNoParentCount + " because the parent game does not exist");
    System.out.println ("  I skipped " + rejectBecauseParentCount + " because the parent games was also rejected");
    System.out.println ("So, in total, I reviewed " + (gamesToApprove.size() - skipCount - rejectNoParentCount - 
        rejectBecauseParentCount) + " expansion games");

    gamesToApprove.clear();
    
    if (readCount == 20000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting.");
      return;
    }
    
    /****************************************************************************************************/
    //Now we want to identify and auto-approve expansions that have multiple publishers when possible.
    //db.bgggame.find( { reviewState: 0, gameType: 1, publishers : {$exists:true}, publishers.1 : {$exists:true} } )
    queryObject = new BasicDBObject();
    queryObject.append("reviewState", 0);
    queryObject.append("gameType", 1);
    queryObject.append("publishers", new BasicDBObject("$exists", true));
    queryObject.append("publishers.1", new BasicDBObject("$exists", true));
    
    System.out.println ("Running the following Query:\n  db.bgggame.find( " + queryObject.toString() + " )");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    cursor = bggCollection.find(queryObject);
    cursor.limit(20000);
    readCount = 0;
    while (cursor.hasNext()) {
      readCount++;
      DBObject object = cursor.next();
      BGGGame game = BGGGameConverter.convertMongoToGame(object);
      game.setReviewState(ReviewState.REVIEWED);
      game.setReviewDate(new Date());
      gamesToApprove.add(game);
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    
    System.out.println ("I found " + gamesToApprove.size() + " game expansions with simple publisher data that are about to be approved.");
    //value = console.readLine("< Press Enter to Proceed >");
    //if (value.equalsIgnoreCase("q"))  {
    //  try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
    //  return;
    //}
    
    count = 0;
    rejectNoParentCount      = 0;
    rejectBecauseParentCount = 0;
    skipCount                = 0;
    unableToApproveCount     = 0;
    for (BGGGame game : gamesToApprove) {
      count++;
      System.out.println ("[" + count + "/" + gamesToApprove.size() + "] Approving " + game.getName() + " (bggID:" + game.getBggID() + ")");
      
      boolean rejectFlag = false;
      if (game.getParentGameID() <= 0) {
        System.out.println ("  Changing review to Rejected because this game has no parentGameID defined");
        rejectNoParentCount++;
        rejectFlag = true;
      }
      
      if (!rejectFlag) {
        //Before we approve an expansion, we need to check a few things.
        //First, does its parent already exist in the system?  If not, we must reject it
        //This is the query we need to figure out what we want:
        //db.bgggame.aggregate( [ { $match: { bggID: xxxxxx}}, 
        //                        { $project: { bggID: 1, reviewState: 1, publisherSize: { $size: "$publishers"}}} ])
        BasicDBObject matchBGGIDAggregate = new BasicDBObject("$match", new BasicDBObject("bggID", game.getParentGameID()));
        BasicDBObject subProjectObject = new BasicDBObject();
        subProjectObject.append("bggID", 1);
        subProjectObject.append("reviewState", 1);
        subProjectObject.append("publisherSize", new BasicDBObject("$size", "$publishers"));
        BasicDBObject projectAggregate = new BasicDBObject("$project", subProjectObject);
        
        List<DBObject> pipeline = new ArrayList<DBObject>(2);
        pipeline.add(matchBGGIDAggregate);
        pipeline.add(projectAggregate);
        AggregationOutput output = bggCollection.aggregate(pipeline);
        
        long parentBGGGameID = -1;
        ReviewState parentReviewState = null;
        int parentPublisherSize = 0;
        for (DBObject object : output.results()) {
          if (object.containsField("bggID"))         parentBGGGameID     = (Long)object.get("bggID");
          if (object.containsField("reviewState"))   parentReviewState   = ReviewStateConverter.convertFlagToReviewState((Integer)object.get("reviewState"));
          if (object.containsField("publisherSize")) parentPublisherSize = (Integer)object.get("publisherSize");
        }
        //If we didn't find the parent game identified, reject it
        if (parentBGGGameID == -1) {
          System.out.println ("  Changing review to Rejected because this game's parentGameID doesn't exist");
          rejectFlag = true;
        }
        
        if (parentReviewState == ReviewState.PENDING) {
          System.out.println ("  Skipping this game expansion because it's parent game hasn't been processed yet.");
          System.out.println ("  That might be because the parent game has a publisherSize value of " + parentPublisherSize);
          skipCount++;
          continue;
        }
        if (parentReviewState == ReviewState.REJECTED) {
          System.out.println ("  Changing review to Rejected because this game's parent game was also rejected");
          rejectBecauseParentCount++;
          rejectFlag = true;
        }
      }
      
      //Now, assuming we're still in the clear, we need to find the actual Game ID from the Game table of the parent Game
      long parentGameID = 0;
      String parentPrimaryPublisher = "";
      if (!rejectFlag) {
        BasicDBObject findParentObject  = new BasicDBObject("bggID", game.getParentGameID());
        BasicDBObject limitParentObject = new BasicDBObject("_id", 0);
        limitParentObject.append("gameID", 1);
        limitParentObject.append("primaryPublisher", 1);
        cursor = gameCollection.find(findParentObject, limitParentObject);
        while (cursor.hasNext()) {
          DBObject object = cursor.next();
          if (object.containsField("gameID"))           parentGameID = (Long)object.get("gameID");
          if (object.containsField("primaryPublisher")) parentPrimaryPublisher = (String)object.get("primaryPublisher");
        }
        if (parentGameID == 0) {
          System.out.println ("  Changing review to Rejected because this game's parent game ID in Game doesn't exist");
          rejectFlag = true;
        }
      }
      
      if (rejectFlag) {
        //If the game is rejected, just run the reject
        game.setReviewState(ReviewState.REJECTED);
        
        DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
        DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
        
        bggCollection.update(matchObject, writeObject, true, false);
      } else {
        //At this point, we're clear from most points of view, but now we need to look into the publisher situation.
        //We're going to be borrowing a lot of code from above to try and figure this out.
        
        //Simple check, if parent's primaryPublisher is in our list, then we'll use that.
        //Otherwise, we need to figure this out using the same logic above, which could result in a skip
        
        String newPrimaryPublisher = "";
        boolean approve = false;
        
        if (!game.getPublishers().contains(parentPrimaryPublisher)) {
          List<String> publishers = new ArrayList<String>();
          //Need this to be a separate list so we don't affect the underlying game.
          for (String curPub : game.getPublishers())
            publishers.add(new String(curPub));
          
          boolean isSelfPublished = false;
          boolean isWebPublished  = false;
          boolean isUnpublished   = false;
          boolean isUnknown       = false;
          
          if (publishers.contains("(Self-published)")) {
            isSelfPublished = true;
            publishers.remove("(Self-published)");
          }
          if (publishers.contains("(Web published)")) {
            isWebPublished = true;
            publishers.remove("(Web published)");
          }
          if (publishers.contains("(Unpublished)")) {
            isUnpublished = true;
            publishers.remove("(Unpublished)");
          }
          if (publishers.contains("(Unknown)")) {
            isUnknown = true;
            publishers.remove("(Unknown)");
          }

          if (publishers.size() == 0) {
            //System.out.println ("!" + game.getName() + " has no only avoided publishers");
            if (isSelfPublished)     newPrimaryPublisher = "(Self-published)";
            else if (isWebPublished) newPrimaryPublisher = "(Web published)";
            else if (isUnpublished)  newPrimaryPublisher = "(Unpublished)";
            else if (isUnknown)      newPrimaryPublisher = "(Unknown)";
            approve = true;
          }
          if (publishers.size() == 1) {
            newPrimaryPublisher = publishers.get(0);
            approve = true;
          }
          
          //If eliminating bad fields didn't help, then we need to look through our trusted list and see what we find
          if (!approve) {
            int foundHits = 0;
            for (String publisher : publishers) {
              if (preferredList.contains(publisher)) {
                foundHits++;
              }
            }
            
            if (foundHits == 0) {
              //There were no trusted results, then we should set the value to "Mulitple Publishers"
              //This can always be corrected as needed later
              newPrimaryPublisher = "Multiple Publishers";
              approve = true;
            }
            
            if (foundHits == 1) {
              //This is kind of the perfect spot.  We found just one trusted hit.  Of course, now we need to find it again
              for (String publisher : publishers) {
                if (preferredList.contains(publisher)) {
                  newPrimaryPublisher = publisher;
                }
              }
              approve = true;
            }
            
            if (foundHits >= 2) {
              //This is the case that needs manual inspecting.  These have mutliple 'trusted' games in their list.
              //We cannot touch this row.
              String publisherList = "|";
              for (String publisher : publishers) {
                if (preferredList.contains(publisher)) {
                  publisherList += publisher + "|";
                }
              }
              System.out.println ("  This game could not be auto-reviewed because of the following publisher set:\n  " + publisherList);
              approve = false;
            }
          }
        } else {
          newPrimaryPublisher = parentPrimaryPublisher;
          approve = true;
        }
        
        if (approve) {
          //If the game is approved, change the game state, then write the corresponding data pieces,
          //The new Game and GameReltn entry, as well as update the parent entry to add this game as an expansion
          DBObject matchObject = BGGGameConverter.convertGameToIDQuery(game);
          DBObject writeObject = BGGGameConverter.convertGameToMongo(game);
          
          bggCollection.update(matchObject, writeObject, true, false);
          
          maxGameID++;
          Game newGame = convertBGGGameToGame(game, maxGameID, parentGameID, newPrimaryPublisher);
          
          maxReltnID++;
          GameReltn newGameReltn = new GameReltn();
          newGameReltn.setReltnID(maxReltnID);
          newGameReltn.setGameID(maxGameID);
          newGameReltn.setBggID(game.getBggID());
          newGameReltn.setCsiIDs(new ArrayList<Long>());
          newGameReltn.setMmIDs(new ArrayList<Long>());
          newGameReltn.setAsinKeys(new ArrayList<String>());
          newGameReltn.setOtherSites(new ArrayList<Long>());
          
          //Our upserts should join against the bggID, so that if we are updating, we will match correctly.
          BasicDBObject matchGameObject  = new BasicDBObject("bggID", game.getBggID());
          BasicDBObject matchReltnObject = new BasicDBObject("bggID", game.getBggID());
          
          DBObject writeGameObject  = GameConverter.convertGameToMongo(newGame);
          DBObject writeReltnObject = GameReltnConverter.convertGameReltnToMongo(newGameReltn);
          
          gameCollection.update(matchGameObject, writeGameObject, true, false);
          reltnCollection.update(matchReltnObject, writeReltnObject, true, false);
          
          //Now we need to add the new expansion gameID to the expansion ID list of the parent game
          BasicDBObject findParentQuery = new BasicDBObject("gameID", parentGameID);
          cursor = gameCollection.find(findParentQuery);
          Game parentGame = null;
          while (cursor.hasNext()) {
            DBObject object = cursor.next();
            parentGame = GameConverter.convertMongoToGame(object);
          }
          try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
          
          List<Long> expansions = parentGame.getExpansionIDs();
          if (expansions == null) expansions = new ArrayList<Long>();
          expansions.add(newGame.getGameID());
          parentGame.setExpansionIDs(expansions);
          
          BasicDBObject writeParentGame = GameConverter.convertGameToMongo(parentGame);
          gameCollection.update(findParentQuery, writeParentGame);
        } else {
          unableToApproveCount++;
        }
      }
    }
    
    System.out.println ("I reviewed " + gamesToApprove.size() + " game expansions with multiple expansions, with the following exceptions:");
    System.out.println ("  I skipped " + skipCount + " because the parent games were not yet processed");
    System.out.println ("  I rejected " + rejectNoParentCount + " because the parent game does not exist");
    System.out.println ("  I skipped " + rejectBecauseParentCount + " because the parent games was also rejected");
    System.out.println ("  I skipped " + unableToApproveCount + " because there were multiple trusted publishers and I couldn't decide.");
    System.out.println ("So, in total, I reviewed " + (gamesToApprove.size() - skipCount - rejectNoParentCount - 
        rejectBecauseParentCount - unableToApproveCount) + " expansion games");

    gamesToApprove.clear();

    if (readCount == 20000) {
      System.out.println ("I don't want to hit heap memory issues again, so exiting.");
      return;
    }
    
    System.out.println ("Automated Approval Complete!");
    
    try { client.close(); } catch (Throwable t) { /** Ignore Errors */ }
  }
  
  private Game convertBGGGameToGame(BGGGame bggGame, long gameID, long parentGameID, String primaryPublisher) {
    Game game = new Game();
    game.setGameID(gameID);
    game.setBggID(bggGame.getBggID());
    game.setName(bggGame.getName());
    game.setYearPublished(bggGame.getYearPublished());
    game.setMinPlayers(bggGame.getMinPlayers());
    game.setMaxPlayers(bggGame.getMaxPlayers());
    game.setMinPlayingTime(bggGame.getMinPlayingTime());
    game.setMaxPlayingTime(bggGame.getMaxPlayingTime());
    game.setImageURL(bggGame.getImageURL());
    game.setImageThumbnailURL(bggGame.getImageThumbnailURL());
    game.setDescription(bggGame.getDescription());
    game.setPrimaryPublisher(primaryPublisher);
    game.setPublishers(bggGame.getPublishers());
    game.setDesigners(bggGame.getDesigners());
    game.setCategories(bggGame.getCategories());
    game.setMechanisms(bggGame.getMechanisms());
    game.setGameType(bggGame.getGameType());
    game.setAddDate(new Date());
    
    //If it's a parent game, Let's set an empty list so we can make it easier to update later
    if ((game.getGameType() == GameType.BASE) || (game.getGameType() == GameType.COLLECTIBLE))
      game.setExpansionIDs(new LinkedList<Long>());
    else
      game.setParentGameID(parentGameID);
    
    return game;
  }
  
  private long getMaxGameSequenceValue(DBCollection collection) {
    long result = -1;
    //This is the format we are trying to emulate:
    //db.collection.aggregate( { $group : { _id  : "", count : { $sum : 1 } } } )
    
    BasicDBObject filterObject = new BasicDBObject("_id", 0);
    filterObject.append("gameID", 1);
    BasicDBObject sortObject   = new BasicDBObject("gameID", -1);

    DBCursor cursor = collection.find(new BasicDBObject(), filterObject).sort(sortObject).limit(1);
    while (cursor.hasNext()) {
      DBObject object = cursor.next();
      result = (Long)object.get("gameID");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    return result;
  }

  private long getMaxGameReltnSequenceValue(DBCollection collection) {
    long result = -1;
    //This is the format we are trying to emulate:
    //db.collection.aggregate( { $group : { _id  : "", count : { $sum : 1 } } } )
    
    BasicDBObject filterObject = new BasicDBObject("_id", 0);
    filterObject.append("reltnID", 1);
    BasicDBObject sortObject   = new BasicDBObject("reltnID", -1);

    DBCursor cursor = collection.find(new BasicDBObject(), filterObject).sort(sortObject).limit(1);
    while (cursor.hasNext()) {
      DBObject object = cursor.next();
      result = (Long)object.get("reltnID");
    }
    try { cursor.close(); } catch (Throwable t) { /** Ignore Errors */ }
    return result;
  }
}
