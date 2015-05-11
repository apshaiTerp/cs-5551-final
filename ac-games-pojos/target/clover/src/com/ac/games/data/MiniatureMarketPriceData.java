/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ac010168
 *
 */
@java.lang.SuppressWarnings({"fallthrough"}) @JsonIgnoreProperties(ignoreUnknown = true)
public class MiniatureMarketPriceData {public static class __CLR3_3_0175175i96a0zu9{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,1716,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Category type header value for Board Games */
  public final static String BOARD_GAMES_CATEGORY       = "/board-games/";
  /** Category type header value for Board Games */
  public final static String LCGS_CATEGORY              = "/board-games/lcgs/";
  /** Category type header value for Board Games */
  public final static String TABLE_TOP_MINIS_CATEGORY   = "/table-top-miniatures/";
  /** Category type header value for Board Games */
  public final static String COLLECTIBLE_MINIS_CATEGORY = "/collectible-miniatures/";
  /** Category type header value for Board Games */
  public final static String CCGS_CATEGORY              = "/collectible-card-games/";
  /** Category type header value for Board Games */
  public final static String RPGS_CATEGORY              = "/role-playing-games/";
  /** Category type header value for Board Games */
  public final static String SUPPLIES_CATEGORY          = "/collectible-card-games/supplies/";
  /** Category type header value for Board Games */
  public final static String ACCESSORIES_CATEGORY       = "/accessories/";
  
  /** Miniature Market Game ID */
  private long mmID;
  /** The SKU used to look up the product.  Used by other vendors as well */
  private String sku;
  /** The Game title from Miniature Market, used to help make matching to BGG game values */
  private String title;
  /** The image shown for the product */
  private String imageURL;
  /** The game availability value, defined by the {@link GameAvailability} enum */
  private GameAvailability availability;
  //**********  The following values are only conditionally present  **********
  /** The MSRP value listed from MM.  Cannot be found the game is not available */
  private double msrpValue;
  /** The current price listed on MM.  Cannot be found the game is not available */
  private double curPrice;
  /** Adding category requirements */
  private MiniatureMarketCategory category;
  /** Adding manufacturer for ease in mapping */
  private String manufacturer;
  
  //**********  These are fields to help with the data review  **********
  /** Flag to help us know the review state of this object */
  private ReviewState reviewState;
  /** Date this record was added to the system */
  private Date addDate;
  /** Date this record was reviewed */
  private Date reviewDate;
  
  /** Helper to process price values */
  public final static DecimalFormat moneyFormat = new DecimalFormat("$###,###.##");
  
  public MiniatureMarketPriceData() {try{__CLR3_3_0175175i96a0zu9.R.inc(1553);
    __CLR3_3_0175175i96a0zu9.R.inc(1554);mmID         = -1L;
    __CLR3_3_0175175i96a0zu9.R.inc(1555);sku          = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1556);title        = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1557);imageURL     = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1558);availability = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1559);msrpValue    = -1.0;
    __CLR3_3_0175175i96a0zu9.R.inc(1560);curPrice     = -1.0;
    __CLR3_3_0175175i96a0zu9.R.inc(1561);reviewState  = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1562);addDate      = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1563);reviewDate   = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1564);category     = null;
    __CLR3_3_0175175i96a0zu9.R.inc(1565);manufacturer = null;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}
  
  public MiniatureMarketPriceData(String jsonString) {
    super();__CLR3_3_0175175i96a0zu9.R.inc(1567);try{__CLR3_3_0175175i96a0zu9.R.inc(1566);
    __CLR3_3_0175175i96a0zu9.R.inc(1568);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0175175i96a0zu9.R.inc(1569);try {
      __CLR3_3_0175175i96a0zu9.R.inc(1570);MiniatureMarketPriceData jsonData = mapper.readValue(jsonString, MiniatureMarketPriceData.class);
      __CLR3_3_0175175i96a0zu9.R.inc(1571);mmID         = jsonData.mmID;
      __CLR3_3_0175175i96a0zu9.R.inc(1572);sku          = jsonData.sku;
      __CLR3_3_0175175i96a0zu9.R.inc(1573);title        = jsonData.title;
      __CLR3_3_0175175i96a0zu9.R.inc(1574);imageURL     = jsonData.imageURL;
      __CLR3_3_0175175i96a0zu9.R.inc(1575);availability = jsonData.availability;
      __CLR3_3_0175175i96a0zu9.R.inc(1576);msrpValue    = jsonData.msrpValue;
      __CLR3_3_0175175i96a0zu9.R.inc(1577);curPrice     = jsonData.curPrice;
      __CLR3_3_0175175i96a0zu9.R.inc(1578);reviewState  = jsonData.reviewState;
      __CLR3_3_0175175i96a0zu9.R.inc(1579);addDate      = jsonData.addDate;
      __CLR3_3_0175175i96a0zu9.R.inc(1580);reviewDate   = jsonData.reviewDate;
      __CLR3_3_0175175i96a0zu9.R.inc(1581);category     = jsonData.category;
      __CLR3_3_0175175i96a0zu9.R.inc(1582);manufacturer = jsonData.manufacturer;
    } catch (JsonParseException jpe) {
      __CLR3_3_0175175i96a0zu9.R.inc(1583);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0175175i96a0zu9.R.inc(1584);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0175175i96a0zu9.R.inc(1585);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}
  
  /**
   * Debug Helper to dump out the contents of this object
   */
  public void printContentsForDebug() {try{__CLR3_3_0175175i96a0zu9.R.inc(1586);
    __CLR3_3_0175175i96a0zu9.R.inc(1587);System.out.println ("Printing contents for Game ID " + getMmID());
    __CLR3_3_0175175i96a0zu9.R.inc(1588);System.out.println ("============================================================");
    __CLR3_3_0175175i96a0zu9.R.inc(1589);System.out.println ("Game Title:          " + getTitle());
    boolean __CLB3_3_0_bool0=false;__CLR3_3_0175175i96a0zu9.R.inc(1590);switch (getCategory()) {
      case BOARDGAMES   :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1591);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1592);System.out.println ("Category:            Board Games"); __CLR3_3_0175175i96a0zu9.R.inc(1593);break;
      case TABLETOP     :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1594);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1595);System.out.println ("Category:            Table Top Miniatures"); __CLR3_3_0175175i96a0zu9.R.inc(1596);break;
      case CCGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1597);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1598);System.out.println ("Category:            Collectible Card Games"); __CLR3_3_0175175i96a0zu9.R.inc(1599);break;
      case LCGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1600);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1601);System.out.println ("Category:            Living Card Games"); __CLR3_3_0175175i96a0zu9.R.inc(1602);break;
      case COLLECTIBLES :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1603);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1604);System.out.println ("Category:            Collectible Miniatures"); __CLR3_3_0175175i96a0zu9.R.inc(1605);break;
      case RPGS         :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1606);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1607);System.out.println ("Category:            Role Playing Games"); __CLR3_3_0175175i96a0zu9.R.inc(1608);break;
      case ACCESSORIES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1609);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1610);System.out.println ("Category:            Accessories"); __CLR3_3_0175175i96a0zu9.R.inc(1611);break;
      case UNKNOWN      :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1612);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1613);System.out.println ("Category:            Unknown"); __CLR3_3_0175175i96a0zu9.R.inc(1614);break;
      default           :if (!__CLB3_3_0_bool0) {__CLR3_3_0175175i96a0zu9.R.inc(1615);__CLB3_3_0_bool0=true;} __CLR3_3_0175175i96a0zu9.R.inc(1616);System.out.println ("Category:            [-]"); __CLR3_3_0175175i96a0zu9.R.inc(1617);break;
    }
    __CLR3_3_0175175i96a0zu9.R.inc(1618);System.out.println ("Game Image:          " + getImageURL());
    __CLR3_3_0175175i96a0zu9.R.inc(1619);System.out.println ("SKU:                 " + getSku());
    __CLR3_3_0175175i96a0zu9.R.inc(1620);System.out.println ("Manufacturer:        " + getManufacturer());
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0175175i96a0zu9.R.inc(1621);switch (getAvailability()) {
      case INSTOCK            :if (!__CLB3_3_0_bool1) {__CLR3_3_0175175i96a0zu9.R.inc(1622);__CLB3_3_0_bool1=true;} __CLR3_3_0175175i96a0zu9.R.inc(1623);System.out.println ("Availability:        In Stock"); __CLR3_3_0175175i96a0zu9.R.inc(1624);break;
      case PREORDER           :if (!__CLB3_3_0_bool1) {__CLR3_3_0175175i96a0zu9.R.inc(1625);__CLB3_3_0_bool1=true;} __CLR3_3_0175175i96a0zu9.R.inc(1626);System.out.println ("Availability:        Pre-Order"); __CLR3_3_0175175i96a0zu9.R.inc(1627);break;
      case OUTOFSTOCK         :if (!__CLB3_3_0_bool1) {__CLR3_3_0175175i96a0zu9.R.inc(1628);__CLB3_3_0_bool1=true;} __CLR3_3_0175175i96a0zu9.R.inc(1629);System.out.println ("Availability:        Out of Stock"); __CLR3_3_0175175i96a0zu9.R.inc(1630);break;
      case NOTYETTAKINGORDERS :if (!__CLB3_3_0_bool1) {__CLR3_3_0175175i96a0zu9.R.inc(1631);__CLB3_3_0_bool1=true;} __CLR3_3_0175175i96a0zu9.R.inc(1632);System.out.println ("Availability:        Not Yet Taking Orders"); __CLR3_3_0175175i96a0zu9.R.inc(1633);break;
      default :if (!__CLB3_3_0_bool1) {__CLR3_3_0175175i96a0zu9.R.inc(1634);__CLB3_3_0_bool1=true;} __CLR3_3_0175175i96a0zu9.R.inc(1635);System.out.println ("Availability:        Unknown");
    }
    __CLR3_3_0175175i96a0zu9.R.inc(1636);System.out.println ("MSRP:                " + (((((getMsrpValue() == -1L) )&&(__CLR3_3_0175175i96a0zu9.R.iget(1637)!=0|true))||(__CLR3_3_0175175i96a0zu9.R.iget(1638)==0&false))? "[-]" : moneyFormat.format(getMsrpValue())));
    __CLR3_3_0175175i96a0zu9.R.inc(1639);System.out.println ("Current Price:       " + (((((getCurPrice() == -1L) )&&(__CLR3_3_0175175i96a0zu9.R.iget(1640)!=0|true))||(__CLR3_3_0175175i96a0zu9.R.iget(1641)==0&false))? "[-]" : moneyFormat.format(getCurPrice())));

    __CLR3_3_0175175i96a0zu9.R.inc(1642);if ((((getReviewState() == null)&&(__CLR3_3_0175175i96a0zu9.R.iget(1643)!=0|true))||(__CLR3_3_0175175i96a0zu9.R.iget(1644)==0&false))) {{
      __CLR3_3_0175175i96a0zu9.R.inc(1645);System.out.println ("Review State:        [-]");
    } }else {{
      boolean __CLB3_3_0_bool2=false;__CLR3_3_0175175i96a0zu9.R.inc(1646);switch (reviewState) {
        case PENDING  :if (!__CLB3_3_0_bool2) {__CLR3_3_0175175i96a0zu9.R.inc(1647);__CLB3_3_0_bool2=true;} __CLR3_3_0175175i96a0zu9.R.inc(1648);System.out.println ("Review State:        Pending");  __CLR3_3_0175175i96a0zu9.R.inc(1649);break;
        case REVIEWED :if (!__CLB3_3_0_bool2) {__CLR3_3_0175175i96a0zu9.R.inc(1650);__CLB3_3_0_bool2=true;} __CLR3_3_0175175i96a0zu9.R.inc(1651);System.out.println ("Review State:        Reviewed"); __CLR3_3_0175175i96a0zu9.R.inc(1652);break;
        case REJECTED :if (!__CLB3_3_0_bool2) {__CLR3_3_0175175i96a0zu9.R.inc(1653);__CLB3_3_0_bool2=true;} __CLR3_3_0175175i96a0zu9.R.inc(1654);System.out.println ("Review State:        Rejected"); __CLR3_3_0175175i96a0zu9.R.inc(1655);break;
      }
    }
    }__CLR3_3_0175175i96a0zu9.R.inc(1656);if ((((getAddDate() != null)&&(__CLR3_3_0175175i96a0zu9.R.iget(1657)!=0|true))||(__CLR3_3_0175175i96a0zu9.R.iget(1658)==0&false))) {__CLR3_3_0175175i96a0zu9.R.inc(1659);System.out.println ("Add Date:            " + addDate); 
    }else                      {__CLR3_3_0175175i96a0zu9.R.inc(1660);System.out.println ("Add Date:            [-]"); 
    }__CLR3_3_0175175i96a0zu9.R.inc(1661);if ((((getReviewDate() != null)&&(__CLR3_3_0175175i96a0zu9.R.iget(1662)!=0|true))||(__CLR3_3_0175175i96a0zu9.R.iget(1663)==0&false))) {__CLR3_3_0175175i96a0zu9.R.inc(1664);System.out.println ("Review Date:         " + reviewDate); 
    }else                         {__CLR3_3_0175175i96a0zu9.R.inc(1665);System.out.println ("Review Date:         [-]"); 
  }}finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the mmID
   */
  public long getMmID() {try{__CLR3_3_0175175i96a0zu9.R.inc(1666);
    __CLR3_3_0175175i96a0zu9.R.inc(1667);return mmID;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param mmID the mmID to set
   */
  public void setMmID(long mmID) {try{__CLR3_3_0175175i96a0zu9.R.inc(1668);
    __CLR3_3_0175175i96a0zu9.R.inc(1669);this.mmID = mmID;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the sku
   */
  public String getSku() {try{__CLR3_3_0175175i96a0zu9.R.inc(1670);
    __CLR3_3_0175175i96a0zu9.R.inc(1671);return sku;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param sku the sku to set
   */
  public void setSku(String sku) {try{__CLR3_3_0175175i96a0zu9.R.inc(1672);
    __CLR3_3_0175175i96a0zu9.R.inc(1673);this.sku = sku;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the title
   */
  public String getTitle() {try{__CLR3_3_0175175i96a0zu9.R.inc(1674);
    __CLR3_3_0175175i96a0zu9.R.inc(1675);return title;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {try{__CLR3_3_0175175i96a0zu9.R.inc(1676);
    __CLR3_3_0175175i96a0zu9.R.inc(1677);this.title = title;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the imageURL
   */
  public String getImageURL() {try{__CLR3_3_0175175i96a0zu9.R.inc(1678);
    __CLR3_3_0175175i96a0zu9.R.inc(1679);return imageURL;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {try{__CLR3_3_0175175i96a0zu9.R.inc(1680);
    __CLR3_3_0175175i96a0zu9.R.inc(1681);this.imageURL = imageURL;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the availability
   */
  public GameAvailability getAvailability() {try{__CLR3_3_0175175i96a0zu9.R.inc(1682);
    __CLR3_3_0175175i96a0zu9.R.inc(1683);return availability;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param availability the availability to set
   */
  public void setAvailability(GameAvailability availability) {try{__CLR3_3_0175175i96a0zu9.R.inc(1684);
    __CLR3_3_0175175i96a0zu9.R.inc(1685);this.availability = availability;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the msrpValue
   */
  public double getMsrpValue() {try{__CLR3_3_0175175i96a0zu9.R.inc(1686);
    __CLR3_3_0175175i96a0zu9.R.inc(1687);return msrpValue;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param msrpValue the msrpValue to set
   */
  public void setMsrpValue(double msrpValue) {try{__CLR3_3_0175175i96a0zu9.R.inc(1688);
    __CLR3_3_0175175i96a0zu9.R.inc(1689);this.msrpValue = msrpValue;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the curPrice
   */
  public double getCurPrice() {try{__CLR3_3_0175175i96a0zu9.R.inc(1690);
    __CLR3_3_0175175i96a0zu9.R.inc(1691);return curPrice;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param curPrice the curPrice to set
   */
  public void setCurPrice(double curPrice) {try{__CLR3_3_0175175i96a0zu9.R.inc(1692);
    __CLR3_3_0175175i96a0zu9.R.inc(1693);this.curPrice = curPrice;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the reviewState
   */
  public ReviewState getReviewState() {try{__CLR3_3_0175175i96a0zu9.R.inc(1694);
    __CLR3_3_0175175i96a0zu9.R.inc(1695);return reviewState;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param reviewState the reviewState to set
   */
  public void setReviewState(ReviewState reviewState) {try{__CLR3_3_0175175i96a0zu9.R.inc(1696);
    __CLR3_3_0175175i96a0zu9.R.inc(1697);this.reviewState = reviewState;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the addDate
   */
  public Date getAddDate() {try{__CLR3_3_0175175i96a0zu9.R.inc(1698);
    __CLR3_3_0175175i96a0zu9.R.inc(1699);return addDate;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param addDate the addDate to set
   */
  public void setAddDate(Date addDate) {try{__CLR3_3_0175175i96a0zu9.R.inc(1700);
    __CLR3_3_0175175i96a0zu9.R.inc(1701);this.addDate = addDate;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the reviewDate
   */
  public Date getReviewDate() {try{__CLR3_3_0175175i96a0zu9.R.inc(1702);
    __CLR3_3_0175175i96a0zu9.R.inc(1703);return reviewDate;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param reviewDate the reviewDate to set
   */
  public void setReviewDate(Date reviewDate) {try{__CLR3_3_0175175i96a0zu9.R.inc(1704);
    __CLR3_3_0175175i96a0zu9.R.inc(1705);this.reviewDate = reviewDate;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the category
   */
  public MiniatureMarketCategory getCategory() {try{__CLR3_3_0175175i96a0zu9.R.inc(1706);
    __CLR3_3_0175175i96a0zu9.R.inc(1707);return category;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param category the category to set
   */
  public void setCategory(MiniatureMarketCategory category) {try{__CLR3_3_0175175i96a0zu9.R.inc(1708);
    __CLR3_3_0175175i96a0zu9.R.inc(1709);this.category = category;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the manufacturer
   */
  public String getManufacturer() {try{__CLR3_3_0175175i96a0zu9.R.inc(1710);
    __CLR3_3_0175175i96a0zu9.R.inc(1711);return manufacturer;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @param manufacturer the manufacturer to set
   */
  public void setManufacturer(String manufacturer) {try{__CLR3_3_0175175i96a0zu9.R.inc(1712);
    __CLR3_3_0175175i96a0zu9.R.inc(1713);this.manufacturer = manufacturer;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

  /**
   * @return the moneyformat
   */
  public static DecimalFormat getMoneyformat() {try{__CLR3_3_0175175i96a0zu9.R.inc(1714);
    __CLR3_3_0175175i96a0zu9.R.inc(1715);return moneyFormat;
  }finally{__CLR3_3_0175175i96a0zu9.R.flushNeeded();}}

}
