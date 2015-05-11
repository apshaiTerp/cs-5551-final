package com.ac.games.data;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniatureMarketPriceData {

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
  
  public MiniatureMarketPriceData() {
    mmID         = -1L;
    sku          = null;
    title        = null;
    imageURL     = null;
    availability = null;
    msrpValue    = -1.0;
    curPrice     = -1.0;
    reviewState  = null;
    addDate      = null;
    reviewDate   = null;
    category     = null;
    manufacturer = null;
  }
  
  public MiniatureMarketPriceData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      MiniatureMarketPriceData jsonData = mapper.readValue(jsonString, MiniatureMarketPriceData.class);
      mmID         = jsonData.mmID;
      sku          = jsonData.sku;
      title        = jsonData.title;
      imageURL     = jsonData.imageURL;
      availability = jsonData.availability;
      msrpValue    = jsonData.msrpValue;
      curPrice     = jsonData.curPrice;
      reviewState  = jsonData.reviewState;
      addDate      = jsonData.addDate;
      reviewDate   = jsonData.reviewDate;
      category     = jsonData.category;
      manufacturer = jsonData.manufacturer;
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
    System.out.println ("Printing contents for Game ID " + getMmID());
    System.out.println ("============================================================");
    System.out.println ("Game Title:          " + getTitle());
    switch (getCategory()) {
      case BOARDGAMES   : System.out.println ("Category:            Board Games"); break;
      case TABLETOP     : System.out.println ("Category:            Table Top Miniatures"); break;
      case CCGS         : System.out.println ("Category:            Collectible Card Games"); break;
      case LCGS         : System.out.println ("Category:            Living Card Games"); break;
      case COLLECTIBLES : System.out.println ("Category:            Collectible Miniatures"); break;
      case RPGS         : System.out.println ("Category:            Role Playing Games"); break;
      case ACCESSORIES  : System.out.println ("Category:            Accessories"); break;
      case UNKNOWN      : System.out.println ("Category:            Unknown"); break;
      default           : System.out.println ("Category:            [-]"); break;
    }
    System.out.println ("Game Image:          " + getImageURL());
    System.out.println ("SKU:                 " + getSku());
    System.out.println ("Manufacturer:        " + getManufacturer());
    switch (getAvailability()) {
      case INSTOCK            : System.out.println ("Availability:        In Stock"); break;
      case PREORDER           : System.out.println ("Availability:        Pre-Order"); break;
      case OUTOFSTOCK         : System.out.println ("Availability:        Out of Stock"); break;
      case NOTYETTAKINGORDERS : System.out.println ("Availability:        Not Yet Taking Orders"); break;
      default : System.out.println ("Availability:        Unknown");
    }
    System.out.println ("MSRP:                " + ((getMsrpValue() == -1L) ? "[-]" : moneyFormat.format(getMsrpValue())));
    System.out.println ("Current Price:       " + ((getCurPrice() == -1L) ? "[-]" : moneyFormat.format(getCurPrice())));

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
   * @return the mmID
   */
  public long getMmID() {
    return mmID;
  }

  /**
   * @param mmID the mmID to set
   */
  public void setMmID(long mmID) {
    this.mmID = mmID;
  }

  /**
   * @return the sku
   */
  public String getSku() {
    return sku;
  }

  /**
   * @param sku the sku to set
   */
  public void setSku(String sku) {
    this.sku = sku;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
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
   * @return the availability
   */
  public GameAvailability getAvailability() {
    return availability;
  }

  /**
   * @param availability the availability to set
   */
  public void setAvailability(GameAvailability availability) {
    this.availability = availability;
  }

  /**
   * @return the msrpValue
   */
  public double getMsrpValue() {
    return msrpValue;
  }

  /**
   * @param msrpValue the msrpValue to set
   */
  public void setMsrpValue(double msrpValue) {
    this.msrpValue = msrpValue;
  }

  /**
   * @return the curPrice
   */
  public double getCurPrice() {
    return curPrice;
  }

  /**
   * @param curPrice the curPrice to set
   */
  public void setCurPrice(double curPrice) {
    this.curPrice = curPrice;
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

  /**
   * @return the category
   */
  public MiniatureMarketCategory getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(MiniatureMarketCategory category) {
    this.category = category;
  }

  /**
   * @return the manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * @param manufacturer the manufacturer to set
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * @return the moneyformat
   */
  public static DecimalFormat getMoneyformat() {
    return moneyFormat;
  }

}
