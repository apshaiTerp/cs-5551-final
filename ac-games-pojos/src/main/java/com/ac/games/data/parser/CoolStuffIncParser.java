package com.ac.games.data.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ac.games.data.CoolStuffIncCategory;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.GameAvailability;
import com.ac.games.exception.GameNotFoundException;

/**
 * @author ac010168
 *
 */
public class CoolStuffIncParser {

  public static boolean debugMode = false;

  /** A basic date formatter object.  We'll use it to condense dates. */
  public final static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-dd HH:mm:ss.SSS");
  
  //**********  Key markers in the text that we can just text search for  **********
  public final static String IN_STOCK_MARKER     = "<link itemprop=\"availability\" href=\"http://schema.org/InStock\"";
  public final static String OUT_OF_STOCK_MARKER = "<link itemprop=\"availability\" href=\"http://schema.org/OutOfStock\"";
  public final static String PRE_ORDER_MARKER    = "<link itemprop=\"availability\" href=\"http://schema.org/PreOrder\"";
  
  /** 
   * Easiest tag to find the title.  Should look like this:
   * <meta property="og:title" content="Abyss">
   */
  public final static String TITLE_MARKER        = "<meta property=\"og:title\" content=\"";
  /**
   * Tag to help identify the image.  The start of the tag should look like this:
   * <meta property="og:image" content="http://blah/blah/blah.jpg
   */
  public final static String IMAGE_MARKER        = "<meta property=\"og:image\" content=\"";
  /** We're going to read the value, if present, out of the meta keywords tag near the top of the file */
  public final static String SKU_MARKER          = "SKU: ";
  /** We're going to read the value, if present, out of the meta keywords tag near the top of the file */
  public final static String MSRP_MARKER         = "MSRP: $";
  /** We're going to read the value, if present, out of the meta keywords tag near the top of the file */
  public final static String OUR_PRICE_MARKER    = "Our Price: $";
  /** 
   * This is the marker that indicated a future release.  
   * It might be present for Out of Stock items or PreOrders 
   */
  public final static String EXPECTED_MARKER     = "expected release: ";
  
  //Adding the markers for the various categories
  /** Simple Text Marker for the CCG Category */
  public final static String CCG_MARKER          = "| Collectable Card Games,";
  /** Simple Text Marker for the Dice Masters Category (A subcategory of CCGs) */ 
  public final static String DICE_MASTERS_MARKER = "| Dice Masters |";
  /** Simple Text Marker for the Board Games Category */ 
  public final static String BOARD_GAMES_MARKER  = "| Board Games |";
  /** Simple Text Marker for the Role Playing Games Category */ 
  public final static String RPG_MARKER          = "| Role Playing Games |";
  /** Simple Text Marker for the Living Card Games Category */ 
  public final static String LCG_MARKER          = "| Living Card Games |";
  /** Simple Text Marker for the Supplies Category */ 
  public final static String SUPPLIES_MARKER     = "| Supplies |";
  /** Simple Text Marker for the Miniatures Category */ 
  public final static String MINIATURES_MARKER   = "| Miniatures, ";
  /** Simple Text Marker for the Miniatures Category */ 
  public final static String VIDEOGAMES_MARKER   = "| Video Games |";
  
  /** Marker for the Publisher, which should be contained in the meta keywords block */
  public final static String PUBLISHER_MARKER    = "Publisher: ";
  
  /**
   * This is a static method used to parse out {@link CoolStuffIncPriceData} content from 
   * the provided HTML page.  This method should generate a complete object or fail.
   * 
   * @param htmlContent The HTML page we asked for.
   * @param csiID Need to provide this value since it's not actually in the page to be parsed.
   * @return a {@link CoolStuffIncPriceData} object fully formed.
   * @throws Throwable Throws this error if there were any parsing issues encountered.
   */
  public static CoolStuffIncPriceData parseCSIHTML(String htmlContent, final long csiID) throws Throwable {
    Date startDate = null;
    if (debugMode) {
      startDate = new Date();
      System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    if (htmlContent == null)
      throw new GameNotFoundException("No game data was provided, htmlContent was null");
    
    //Check for the "Product not found." text that let's us know we didn't find what we
    //were looking for
    int notFoundTag = htmlContent.indexOf("Product not found.");
    
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    data.setCsiID(csiID);
    
    int titleMarkerPos = htmlContent.indexOf(TITLE_MARKER);
    String title = null;
    if (titleMarkerPos != -1) {
      title = htmlContent.substring(titleMarkerPos + TITLE_MARKER.length(), 
          htmlContent.indexOf("\">", titleMarkerPos + TITLE_MARKER.length()));
      data.setTitle(title);
    } else throw new Throwable ("Could not find the Title tag correctly.");
    
    if ((notFoundTag != -1) && (title.startsWith("CoolStuffInc.com")))
      throw new GameNotFoundException("This game does have an entry at CoolStuffInc.com.");
    
    if (title.startsWith("Gift Certificate"))
      throw new GameNotFoundException("This game is not actually a game, it's a gift certificate form.");
    
    int skuMarkerPos = htmlContent.indexOf(SKU_MARKER);
    if (skuMarkerPos != -1) {
      String sku = htmlContent.substring(skuMarkerPos + SKU_MARKER.length(), 
          htmlContent.indexOf(", ", skuMarkerPos + SKU_MARKER.length()));
      data.setSku(sku);
    } else {
      data.setSku(null);
      //throw new Throwable ("Could not find the SKU item correctly.");
    }
    
    //Now let's look for the multiple possible categories
    int ccgMarkerPos         = htmlContent.indexOf(CCG_MARKER);
    int diceMastersMarkerPos = htmlContent.indexOf(DICE_MASTERS_MARKER);
    int boardGameMarkerPos   = htmlContent.indexOf(BOARD_GAMES_MARKER);
    int rpgMarkerPos         = htmlContent.indexOf(RPG_MARKER);
    int lcgMarkerPos         = htmlContent.indexOf(LCG_MARKER);
    int suppliesMarkerPos    = htmlContent.indexOf(SUPPLIES_MARKER);
    int miniaturesMarkerPos  = htmlContent.indexOf(MINIATURES_MARKER);
    int videoGamesMarkerPos  = htmlContent.indexOf(VIDEOGAMES_MARKER);
    
    if (ccgMarkerPos != -1) {
      if (diceMastersMarkerPos != -1)   data.setCategory(CoolStuffIncCategory.DICEMASTERS);
      else                              data.setCategory(CoolStuffIncCategory.COLLECTIBLE);
    } 
    else if (boardGameMarkerPos != -1)  data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    else if (rpgMarkerPos != -1)        data.setCategory(CoolStuffIncCategory.RPGS);
    else if (lcgMarkerPos != -1)        data.setCategory(CoolStuffIncCategory.LCGS);
    else if (suppliesMarkerPos != -1)   data.setCategory(CoolStuffIncCategory.SUPPLIES);
    else if (miniaturesMarkerPos != -1) data.setCategory(CoolStuffIncCategory.MINIATURES);
    else if (videoGamesMarkerPos != -1) data.setCategory(CoolStuffIncCategory.VIDEOGAMES);
    else                                data.setCategory(CoolStuffIncCategory.UNKNOWN);
    
    int imageMarkerPos = htmlContent.indexOf(IMAGE_MARKER);
    if (imageMarkerPos != -1) {
      String imageString = htmlContent.substring(imageMarkerPos + IMAGE_MARKER.length(), 
          htmlContent.indexOf("\"", imageMarkerPos + IMAGE_MARKER.length()));
      data.setImageURL(imageString);
    }
    
    int isInStock    = htmlContent.indexOf(IN_STOCK_MARKER);
    int isOutOfStock = htmlContent.indexOf(OUT_OF_STOCK_MARKER);
    int isPreOrder   = htmlContent.indexOf(PRE_ORDER_MARKER);
    int expectedPos  = htmlContent.toLowerCase().indexOf(EXPECTED_MARKER.toLowerCase());
    
    if (isInStock != -1)         data.setAvailability(GameAvailability.INSTOCK);
    else if (isPreOrder != -1)   data.setAvailability(GameAvailability.PREORDER);
    else if (isOutOfStock != -1) {
      if (expectedPos != -1) data.setAvailability(GameAvailability.NOTYETTAKINGORDERS);
      else                   data.setAvailability(GameAvailability.OUTOFSTOCK);
    }
    else {
      System.out.println ("  Not able to find an availability.  Setting it to Out Of Stock");
      data.setAvailability(GameAvailability.OUTOFSTOCK);
    }

    //Gather the expected release date, if any
    if (expectedPos != -1) {
      String releaseString = htmlContent.substring(expectedPos + EXPECTED_MARKER.length(), 
          htmlContent.indexOf(".", expectedPos + EXPECTED_MARKER.length()));
      data.setReleaseDate(releaseString);
    }
    
    //If the game is not out of stock, we should be able to find the price, and might
    //find some price markers even if the game is out of stock.
    int msrpPos  = htmlContent.indexOf(MSRP_MARKER);
    if (msrpPos != -1) {
      double msrpValue = Double.parseDouble(htmlContent.substring(msrpPos + MSRP_MARKER.length(), 
          htmlContent.indexOf(", ", msrpPos + MSRP_MARKER.length())));
      data.setMsrpValue(msrpValue);
    }
    int pricePos = htmlContent.indexOf(OUR_PRICE_MARKER);
    if (pricePos != -1) {
      double priceValue = Double.parseDouble(htmlContent.substring(pricePos + OUR_PRICE_MARKER.length(), 
          htmlContent.indexOf(", ", pricePos + OUR_PRICE_MARKER.length())));
      data.setCurPrice(priceValue);
    }
    
    int publisherPos  = htmlContent.indexOf(PUBLISHER_MARKER);
    if (publisherPos != -1) {
      String publisherValue = htmlContent.substring(publisherPos + PUBLISHER_MARKER.length(), 
          htmlContent.indexOf(",", publisherPos + PUBLISHER_MARKER.length()));
      data.setPublisher(publisherValue);
    }

    return data;
  }
}
