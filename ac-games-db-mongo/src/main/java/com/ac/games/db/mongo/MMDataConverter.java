package com.ac.games.db.mongo;

import java.util.Date;

import com.ac.games.data.MiniatureMarketCategoryConverter;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.GameAvailabilityConverter;
import com.ac.games.data.ReviewStateConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author ac010168
 *
 */
public class MMDataConverter {

  /**
   * Helper method that will construct a basic query using the mmID from the provided price data.
   * 
   * @param data The MM data we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToIDQuery(MiniatureMarketPriceData data) {
    if (data == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("mmID", data.getMmID());
    return dbObject;
  }
  
  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param mmID The Miniature Market ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToIDQuery(long mmID) {
    if (mmID < 0) return null;

    BasicDBObject dbObject = new BasicDBObject("mmID", mmID);
    return dbObject;
  }
  
  /**
   * Conversion method used to map our price data into a mongo object.
   * 
   * @param data
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertMMToMongo(MiniatureMarketPriceData data) {
    if (data == null) return null;
    
    BasicDBObject dbObject = new BasicDBObject("mmID", data.getMmID());
    
    if (data.getSku() != null)          dbObject.append("sku", data.getSku());
    if (data.getTitle() != null)        dbObject.append("title", data.getTitle());
    if (data.getManufacturer() != null) dbObject.append("manufacturer", data.getManufacturer());
    if (data.getCategory() != null)     dbObject.append("category", MiniatureMarketCategoryConverter.convertMMCategoryToFlag(data.getCategory()));
    if (data.getImageURL() != null)     dbObject.append("imageURL", data.getImageURL());
    if (data.getAvailability() != null) dbObject.append("availability", GameAvailabilityConverter.convertGameAvailabilityToFlag(data.getAvailability()));
    if (data.getMsrpValue() != -1.0)    dbObject.append("msrpValue", data.getMsrpValue());
    if (data.getCurPrice() != -1.0)     dbObject.append("curPrice", data.getCurPrice());
    if (data.getReviewState() != null)  dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(data.getReviewState()));
    if (data.getAddDate() != null)      dbObject.append("addDate", data.getAddDate());
    if (data.getReviewDate() != null)   dbObject.append("reviewDate", data.getReviewDate());
    
    return dbObject;
  }
  
  public static MiniatureMarketPriceData convertMongoToMM(DBObject dbObject) {
    if (dbObject == null) return null;
    
    MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    if (dbObject.containsField("mmID"))         data.setMmID((Long)dbObject.get("mmID"));
    if (dbObject.containsField("sku"))          data.setSku((String)dbObject.get("sku"));
    if (dbObject.containsField("title"))        data.setTitle((String)dbObject.get("title"));
    if (dbObject.containsField("manufacturer")) data.setManufacturer((String)dbObject.get("manufacturer"));
    if (dbObject.containsField("category"))     data.setCategory(MiniatureMarketCategoryConverter.convertFlagToMMCategory((Integer)dbObject.get("category")));
    if (dbObject.containsField("imageURL"))     data.setImageURL((String)dbObject.get("imageURL"));
    if (dbObject.containsField("availability")) data.setAvailability(GameAvailabilityConverter.convertFlagToGameAvailability((Integer)dbObject.get("availability")));
    if (dbObject.containsField("msrpValue"))    data.setMsrpValue((Double)dbObject.get("msrpValue"));
    if (dbObject.containsField("curPrice"))     data.setCurPrice((Double)dbObject.get("curPrice"));
    if (dbObject.containsField("reviewState"))  data.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    if (dbObject.containsField("addDate"))      data.setAddDate((Date)dbObject.get("addDate"));
    if (dbObject.containsField("reviewDate"))   data.setReviewDate((Date)dbObject.get("reviewDate"));
    
    return data;
  }
}
