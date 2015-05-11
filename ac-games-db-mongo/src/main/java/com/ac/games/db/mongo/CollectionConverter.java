package com.ac.games.db.mongo;

import java.util.ArrayList;
import java.util.List;

import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class CollectionConverter {

  /**
   * Helper method that will construct a basic query using the itemID from the provided game.
   * 
   * @param item The CollectionItem we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionToIDQuery(Collection collection) {
    if (collection == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("collectionID", collection.getCollectionID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the collectionID from the provided game.
   * 
   * @param collectionID The Collection we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no game was provided
   */
  public static BasicDBObject convertCollectionToIDQuery(long collectionID) {
    if (collectionID < 0) return null;
    
    BasicDBObject dbObject = new BasicDBObject("collectionID", collectionID);
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic database object representing the provided data.
   * 
   * @param item The object we want to add to the database.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this object, or null if nothing was provided
   */
  public static BasicDBObject convertCollectionToMongo(Collection collection) {
    if (collection == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("collectionID", collection.getCollectionID());
    if (collection.getGames() != null) dbObject.append("games", convertList(collection.getGames()));
    //Default values are always 0, so we should write them no matter what
    dbObject.append("baseGameCount", collection.getBaseGameCount());
    dbObject.append("collectibleGameCount", collection.getCollectibleGameCount());
    dbObject.append("expansionGameCount", collection.getExpansionGameCount());

    return dbObject;
  }
  
  /**
   * Convert a Mongo BSON record back into a {@link Collection} object.
   * 
   * @param dbObject The Mongo DBObject result
   * 
   * @return a {@link Collection} object, or null if the dbObject was null
   */
  public static Collection convertMongoToCollection(DBObject dbObject) {
    if (dbObject == null) return null;
    
    Collection collection = new Collection();
    if (dbObject.containsField("collectionID"))         collection.setCollectionID((Long)dbObject.get("collectionID"));
    if (dbObject.containsField("games"))                collection.setGames(convertDBListToCollectionItemList((BasicDBList)dbObject.get("games")));
    if (dbObject.containsField("baseGameCount"))        collection.setBaseGameCount((Integer)dbObject.get("baseGameCount"));
    if (dbObject.containsField("collectibleGameCount")) collection.setCollectibleGameCount((Integer)dbObject.get("collectibleGameCount"));
    if (dbObject.containsField("expansionGameCount"))   collection.setExpansionGameCount((Integer)dbObject.get("expansionGameCount"));

    return collection;
  }

  /**
   * Helper method to parse Lists into List format for Mongo.  Parameterized as <?> to
   * allow for generic mapping, provided those objects are simple objects.
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in BasicDBList format.
   */
  private static BasicDBList convertList(List<CollectionItem> curList) {
    if (curList == null) return null;
    
    BasicDBList newList = new BasicDBList();
    for (CollectionItem obj : curList)
      newList.add(CollectionItemConverter.convertCollectionItemToMongo(obj));
    return newList;
  }

  /**
   * Helper method to parse Lists from Mongo into Java.  
   * 
   * @param curList The List of elements (not null) to be converted into an array.
   * @return A new list in List<String> format.
   */
  private static List<CollectionItem> convertDBListToCollectionItemList(BasicDBList curList) {
    if (curList == null) return null;
    
    List<CollectionItem> newList = new ArrayList<CollectionItem>(curList.size());
    for (Object obj : curList) {
      newList.add(CollectionItemConverter.convertMongoToCollectionItem((DBObject)obj));
    }
    return newList;
  }
}
