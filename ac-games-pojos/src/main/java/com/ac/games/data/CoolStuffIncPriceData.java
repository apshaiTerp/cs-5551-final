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
public class CoolStuffIncPriceData {

  /** Cool Stuff Inc Game ID */
  private long csiID;
  /** The SKU used to look up the product.  Used by other vendors as well */
  private String sku;
  /** The Game title from CSI, used to help make matching to BGG game values */
  private String title;
  /** The image shown for the product */
  private String imageURL;
  /** The game availability value, defined by the {@link GameAvailability} enum */
  private GameAvailability availability;
  /** The game category, as defined by CoolStuffInc, implemented in the {@link CoolStuffIncCategory} enum */
  private CoolStuffIncCategory category;
  //**********  The following values are only conditionally present  **********
  /** The MSRP value listed from CSI.  Cannot be found the game is not available */
  private double msrpValue;
  /** The current price listed on CSI.  Cannot be found the game is not available */
  private double curPrice;
  /** The upcoming release date, listed with PreOrders and some Out of Print products */
  private String releaseDate;
  /** The publisher information, to help with sorting games */
  private String publisher;
  
  //TODO - Probably need to figure out the category so I can weed out the HORDES of CCGs
  //and other single items CSI sells
  
  //**********  These are fields to help with the data review  **********
  /** Flag to help us know the review state of this object */
  private ReviewState reviewState;
  /** Date this record was added to the system */
  private Date addDate;
  /** Date this record was reviewed */
  private Date reviewDate;
  
  /** Helper to process price values */
  public final static DecimalFormat moneyFormat = new DecimalFormat("$###,###.##");
  
  public CoolStuffIncPriceData() {
    csiID        = -1L;
    sku          = null;
    title        = null;
    imageURL     = null;
    availability = null;
    releaseDate  = null;
    msrpValue    = -1.0;
    curPrice     = -1.0;
    reviewState  = null;
    addDate      = null;
    reviewDate   = null;
    category     = null;
    publisher    = null;
  }
  
  public CoolStuffIncPriceData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      CoolStuffIncPriceData jsonData = mapper.readValue(jsonString, CoolStuffIncPriceData.class);
      csiID        = jsonData.csiID;
      sku          = jsonData.sku;
      title        = jsonData.title;
      imageURL     = jsonData.imageURL;
      availability = jsonData.availability;
      releaseDate  = jsonData.releaseDate;
      msrpValue    = jsonData.msrpValue;
      curPrice     = jsonData.curPrice;
      reviewState  = jsonData.reviewState;
      addDate      = jsonData.addDate;
      reviewDate   = jsonData.reviewDate;
      category     = jsonData.category;
      publisher    = jsonData.publisher;
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
    System.out.println ("Printing contents for Game ID " + getCsiID());
    System.out.println ("============================================================");
    System.out.println ("Game Title:          " + getTitle());
    System.out.println ("Publisher:           " + ((getPublisher() == null) ? "[-]" : publisher));
    switch (getCategory()) {
      case COLLECTIBLE : System.out.println ("Category:            Collectible Card Games"); break;
      case DICEMASTERS : System.out.println ("Category:            Dice Masters"); break;
      case BOARDGAMES  : System.out.println ("Category:            Board Games"); break;
      case RPGS        : System.out.println ("Category:            Role Playing Games"); break;
      case LCGS        : System.out.println ("Category:            Living Card Games"); break;
      case SUPPLIES    : System.out.println ("Category:            Supplies"); break;
      case MINIATURES  : System.out.println ("Category:            Miniatures"); break;
      case VIDEOGAMES  : System.out.println ("Category:            Video Games"); break;
      case UNKNOWN     : System.out.println ("Category:            Unknown"); break;
      default          : System.out.println ("Category:            [-]"); break;
    }
    System.out.println ("Game Image:          " + getImageURL());
    System.out.println ("SKU:                 " + getSku());
    switch (getAvailability()) {
      case INSTOCK            : System.out.println ("Availability:        In Stock"); break;
      case PREORDER           : System.out.println ("Availability:        Pre-Order"); break;
      case OUTOFSTOCK         : System.out.println ("Availability:        Out of Stock"); break;
      case NOTYETTAKINGORDERS : System.out.println ("Availability:        Not Yet Taking Orders"); break;
      default : System.out.println ("Availability:        Unknown");
    }
    System.out.println ("Expected Release:    " + ((getReleaseDate() == null) ? "[-]" : releaseDate));
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
   * @return the csiID
   */
  public long getCsiID() {
    return csiID;
  }

  /**
   * @param csiID the csiID to set
   */
  public void setCsiID(long csiID) {
    this.csiID = csiID;
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
   * Adding functionality to this method to strip out the inserted autosizing of the image.
   * 
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {
    if (imageURL == null) this.imageURL = imageURL;
    else this.imageURL = imageURL.replace("c_pad,h_300,w_300/", "");
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
   * @return the releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
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
  public CoolStuffIncCategory getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(CoolStuffIncCategory category) {
    this.category = category;
  }

  /**
   * @return the publisher
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * @param publisher the publisher to set
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}
