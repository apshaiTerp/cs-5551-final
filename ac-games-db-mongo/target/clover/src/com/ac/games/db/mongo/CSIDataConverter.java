/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mongo;

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
public class CSIDataConverter {public static class __CLR3_3_07h7hi96a4ycn{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525818885L,8589935092L,397,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param data The CSI data we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToIDQuery(CoolStuffIncPriceData data) {try{__CLR3_3_07h7hi96a4ycn.R.inc(269);
    __CLR3_3_07h7hi96a4ycn.R.inc(270);if ((((data == null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(271)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(272)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(273);return null;
    
    }__CLR3_3_07h7hi96a4ycn.R.inc(274);BasicDBObject dbObject = new BasicDBObject("csiID", data.getCsiID());
    __CLR3_3_07h7hi96a4ycn.R.inc(275);return dbObject;
  }finally{__CLR3_3_07h7hi96a4ycn.R.flushNeeded();}}
  
  /**
   * Helper method that will construct a basic query using the csiID from the provided price data.
   * 
   * @param csiID The CSI ID we want to build a query for.
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToIDQuery(long csiID) {try{__CLR3_3_07h7hi96a4ycn.R.inc(276);
    __CLR3_3_07h7hi96a4ycn.R.inc(277);if ((((csiID < 0)&&(__CLR3_3_07h7hi96a4ycn.R.iget(278)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(279)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(280);return null;

    }__CLR3_3_07h7hi96a4ycn.R.inc(281);BasicDBObject dbObject = new BasicDBObject("csiID", csiID);
    __CLR3_3_07h7hi96a4ycn.R.inc(282);return dbObject;
  }finally{__CLR3_3_07h7hi96a4ycn.R.flushNeeded();}}
  
  /**
   * Conversion method used to map our price data into a mongo object.
   * 
   * @param data
   * 
   * @return Returns a {@link BasicDBObject} object that represents this query, or null if no price data was provided
   */
  public static BasicDBObject convertCSIToMongo(CoolStuffIncPriceData data) {try{__CLR3_3_07h7hi96a4ycn.R.inc(283);
    __CLR3_3_07h7hi96a4ycn.R.inc(284);if ((((data == null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(285)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(286)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(287);return null;
    
    }__CLR3_3_07h7hi96a4ycn.R.inc(288);BasicDBObject dbObject = new BasicDBObject("csiID", data.getCsiID());
    
    __CLR3_3_07h7hi96a4ycn.R.inc(289);if ((((data.getSku() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(290)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(291)==0&false)))          {__CLR3_3_07h7hi96a4ycn.R.inc(292);dbObject.append("sku", data.getSku());
    }__CLR3_3_07h7hi96a4ycn.R.inc(293);if ((((data.getTitle() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(294)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(295)==0&false)))        {__CLR3_3_07h7hi96a4ycn.R.inc(296);dbObject.append("title", data.getTitle());
    }__CLR3_3_07h7hi96a4ycn.R.inc(297);if ((((data.getPublisher() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(298)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(299)==0&false)))    {__CLR3_3_07h7hi96a4ycn.R.inc(300);dbObject.append("publisher", data.getPublisher());
    }__CLR3_3_07h7hi96a4ycn.R.inc(301);if ((((data.getCategory() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(302)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(303)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(304);dbObject.append("category", CoolStuffIncCategoryConverter.convertCSICategoryToFlag(data.getCategory()));
    }__CLR3_3_07h7hi96a4ycn.R.inc(305);if ((((data.getImageURL() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(306)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(307)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(308);dbObject.append("imageURL", data.getImageURL());
    }__CLR3_3_07h7hi96a4ycn.R.inc(309);if ((((data.getAvailability() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(310)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(311)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(312);dbObject.append("availability", GameAvailabilityConverter.convertGameAvailabilityToFlag(data.getAvailability()));
    }__CLR3_3_07h7hi96a4ycn.R.inc(313);if ((((data.getMsrpValue() != -1.0)&&(__CLR3_3_07h7hi96a4ycn.R.iget(314)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(315)==0&false)))    {__CLR3_3_07h7hi96a4ycn.R.inc(316);dbObject.append("msrpValue", data.getMsrpValue());
    }__CLR3_3_07h7hi96a4ycn.R.inc(317);if ((((data.getCurPrice() != -1.0)&&(__CLR3_3_07h7hi96a4ycn.R.iget(318)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(319)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(320);dbObject.append("curPrice", data.getCurPrice());
    }__CLR3_3_07h7hi96a4ycn.R.inc(321);if ((((data.getReleaseDate() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(322)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(323)==0&false)))  {__CLR3_3_07h7hi96a4ycn.R.inc(324);dbObject.append("releaseDate", data.getReleaseDate());
    }__CLR3_3_07h7hi96a4ycn.R.inc(325);if ((((data.getReviewState() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(326)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(327)==0&false)))  {__CLR3_3_07h7hi96a4ycn.R.inc(328);dbObject.append("reviewState", ReviewStateConverter.convertReviewStateToFlag(data.getReviewState()));
    }__CLR3_3_07h7hi96a4ycn.R.inc(329);if ((((data.getAddDate() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(330)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(331)==0&false)))      {__CLR3_3_07h7hi96a4ycn.R.inc(332);dbObject.append("addDate", data.getAddDate());
    }__CLR3_3_07h7hi96a4ycn.R.inc(333);if ((((data.getReviewDate() != null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(334)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(335)==0&false)))   {__CLR3_3_07h7hi96a4ycn.R.inc(336);dbObject.append("reviewDate", data.getReviewDate());
    
    }__CLR3_3_07h7hi96a4ycn.R.inc(337);return dbObject;
  }finally{__CLR3_3_07h7hi96a4ycn.R.flushNeeded();}}
  
  public static CoolStuffIncPriceData convertMongoToCSI(DBObject dbObject) {try{__CLR3_3_07h7hi96a4ycn.R.inc(338);
    __CLR3_3_07h7hi96a4ycn.R.inc(339);if ((((dbObject == null)&&(__CLR3_3_07h7hi96a4ycn.R.iget(340)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(341)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(342);return null;
    
    }__CLR3_3_07h7hi96a4ycn.R.inc(343);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    __CLR3_3_07h7hi96a4ycn.R.inc(344);if ((((dbObject.containsField("csiID"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(345)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(346)==0&false)))        {__CLR3_3_07h7hi96a4ycn.R.inc(347);data.setCsiID((Long)dbObject.get("csiID"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(348);if ((((dbObject.containsField("sku"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(349)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(350)==0&false)))          {__CLR3_3_07h7hi96a4ycn.R.inc(351);data.setSku((String)dbObject.get("sku"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(352);if ((((dbObject.containsField("title"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(353)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(354)==0&false)))        {__CLR3_3_07h7hi96a4ycn.R.inc(355);data.setTitle((String)dbObject.get("title"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(356);if ((((dbObject.containsField("publisher"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(357)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(358)==0&false)))    {__CLR3_3_07h7hi96a4ycn.R.inc(359);data.setPublisher((String)dbObject.get("publisher"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(360);if ((((dbObject.containsField("category"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(361)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(362)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(363);data.setCategory(CoolStuffIncCategoryConverter.convertFlagToCSICategory((Integer)dbObject.get("category")));
    }__CLR3_3_07h7hi96a4ycn.R.inc(364);if ((((dbObject.containsField("imageURL"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(365)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(366)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(367);data.setImageURL((String)dbObject.get("imageURL"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(368);if ((((dbObject.containsField("availability"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(369)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(370)==0&false))) {__CLR3_3_07h7hi96a4ycn.R.inc(371);data.setAvailability(GameAvailabilityConverter.convertFlagToGameAvailability((Integer)dbObject.get("availability")));
    }__CLR3_3_07h7hi96a4ycn.R.inc(372);if ((((dbObject.containsField("msrpValue"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(373)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(374)==0&false)))    {__CLR3_3_07h7hi96a4ycn.R.inc(375);data.setMsrpValue((Double)dbObject.get("msrpValue"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(376);if ((((dbObject.containsField("curPrice"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(377)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(378)==0&false)))     {__CLR3_3_07h7hi96a4ycn.R.inc(379);data.setCurPrice((Double)dbObject.get("curPrice"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(380);if ((((dbObject.containsField("releaseDate"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(381)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(382)==0&false)))  {__CLR3_3_07h7hi96a4ycn.R.inc(383);data.setReleaseDate((String)dbObject.get("releaseDate "));
    }__CLR3_3_07h7hi96a4ycn.R.inc(384);if ((((dbObject.containsField("reviewState"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(385)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(386)==0&false)))  {__CLR3_3_07h7hi96a4ycn.R.inc(387);data.setReviewState(ReviewStateConverter.convertFlagToReviewState((Integer)dbObject.get("reviewState")));
    }__CLR3_3_07h7hi96a4ycn.R.inc(388);if ((((dbObject.containsField("addDate"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(389)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(390)==0&false)))      {__CLR3_3_07h7hi96a4ycn.R.inc(391);data.setAddDate((Date)dbObject.get("addDate"));
    }__CLR3_3_07h7hi96a4ycn.R.inc(392);if ((((dbObject.containsField("reviewDate"))&&(__CLR3_3_07h7hi96a4ycn.R.iget(393)!=0|true))||(__CLR3_3_07h7hi96a4ycn.R.iget(394)==0&false)))   {__CLR3_3_07h7hi96a4ycn.R.inc(395);data.setReviewDate((Date)dbObject.get("reviewDate"));
    
    }__CLR3_3_07h7hi96a4ycn.R.inc(396);return data;
  }finally{__CLR3_3_07h7hi96a4ycn.R.flushNeeded();}}
}
