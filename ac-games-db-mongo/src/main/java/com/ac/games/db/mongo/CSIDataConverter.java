package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.CoolStuffIncCategoryConverter;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.GameAvailabilityConverter;
import com.ac.games.data.ReviewStateConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class CSIDataConverter {

  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param data The CSI data we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToIDQuery(CoolStuffIncPriceData data) {
    if (data == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("csiID", data.getCsiID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param csiID The CSI ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToIDQuery(long csiID) {
    if (csiID < 0) return null;

    BasicDBObject dbObject = new BasicDBObject("csiID", csiID);
    return dbObject;
  }
  
  /**
   * Conversion method used to map our price data into a mongo object.
   * 
   * @param data
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToMongo(CoolStuffIncPriceData data) {
    if (data == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("csiID", data.getCsiID());
    
    if (data.getSku() != null)          dbObject.append("sku", data.getSku());
    if (data.getTitle() != null)        dbObject.append("title", data.getTitle());
    if (data.getPublisher() != null)    dbObject.append("publisher", data.getPublisher());
    if (data.getCategory() != null)     dbObject.append("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(data.getCategory()));
    if (data.getImageURL() != null)     dbObject.append("imageURL", data.getImageURL());
    if (data.getAvailability() != null) dbObject.append("availability", GameAvailabilityConverter.convertGameAvailabilityToFlag(data.getAvailability()));
    if (data.getMsrpValue() != -1.0)    dbObject.append("msrpValue", data.getMsrpValue());
    if (data.getCurPrice() != -1.0)     dbObject.append("curPrice", data.getCurPrice());
    if (data.getReleaseDate() != null)  dbObject.append("releaseDate", data.getReleaseDate());
    if (data.getReviewState() != null)  dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(data.getReviewState()));
    if (data.getAddDate() != null)      dbObject.append("addDate", data.getAddDate());
    if (data.getReviewDate() != null)   dbObject.append("reviewDate", data.getReviewDate());
    
    return dbObject;
  }
  
  public static CoolStuffIncPriceData convertMongoToCSI(DBObject dbObject) {
    if (dbObject == null) return null;
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    if (dbObject.containsField("csiID"))        data.setCsiID((Long)dbObject.get("csiID"));
    if (dbObject.containsField("sku"))          data.setSku((String)dbObject.get("sku"));
    if (dbObject.containsField("title"))        data.setTitle((String)dbObject.get("title"));
    if (dbObject.containsField("publisher"))    data.setPublisher((String)dbObject.get("publisher"));
    if (dbObject.containsField("category"))     data.setCategory(CoolStuffIncCategoryConverter.convertFlagToCSICategory((Integer)dbObject.get("category")));
    if (dbObject.containsField("imageURL"))     data.setImageURL((String)dbObject.get("imageURL"));
    if (dbObject.containsField("availability")) data.setAvailability(GameAvailabilityConverter.convertFlagToGameAvailability((Integer)dbObject.get("availability")));
    if (dbObject.containsField("msrpValue"))    data.setMsrpValue((Double)dbObject.get("msrpValue"));
    if (dbObject.containsField("curPrice"))     data.setCurPrice((Double)dbObject.get("curPrice"));
    if (dbObject.containsField("releaseDate"))  data.setReleaseDate((String)dbObject.get("releaseDate "));
    if (dbObject.containsField("reviewState"))  data.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    if (dbObject.containsField("addDate"))      data.setAddDate((Date)dbObject.get("addDate"));
    if (dbObject.containsField("reviewDate"))   data.setReviewDate((Date)dbObject.get("reviewDate"));
    
    return data;
  }
}
