package com.ac.games.data.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ac.games.data.*;
import com.ac.games.exception.GameNotFoundException;

/**
 * 
 * @author ac010168
 */
public class MiniatureMarketParser {
  
  public static boolean debugMode = false;

  /** A basic date formatter object.  We'll use it to condense dates. */
  public final static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-dd HH:mm:ss.SSS");
  
  /** 
   * Easiest tag to find the title.  Should look like this:
   * <meta property="og:title" content="Cosmic Encounter "/>
   */
  public final static String TITLE_MARKER         = "<meta property=\"og:title\" content=\"";
  /**
   * Tag to help identify the image.  The start of the tag should look like this:
   * <meta property="og:image" content="http://cdn.miniaturemarket.com/media/catalog/product/a/s/asmaby01us.jpg"/>
   */
  public final static String IMAGE_MARKER         = "<meta property=\"og:image\" content=\"";
  
  /** We're going to read the value, if present, out of the meta keywords tag near the top of the file */
  public final static String SKU_MARKER           = "var product_code = \"";
  /** 
   * These values are a little more complicated.  They include the id values in part of the tags.
   * <span class="price" id="old-price-XXXXX">
   *                 $89.10                </span>
   */
  public final static String MSRP_MARKER          = "<span class=\"price\" id=\"old-price-";
  /** 
   * These values are a little more complicated.  They include the id values in part of the tags.
   * <span class="price" id="product-price-XXXXX">
   *                 $66.83                </span>
   */
  public final static String OUR_PRICE_MARKER     = "<span class=\"price\" id=\"product-price-";
  //**********  These are flexible fields  **********
  /** The out of stock marker tag */
  public final static String OUT_OF_STOCK_MARKER  = "class=\"availability out-of-stock\"";
  /** The in stock marker tag */
  public final static String IN_STOCK_MARKER      = "class=\"availability in-stock\"";
  /** 
   * These are fairly straight-forward tags, only one will exist
   * <div class="stock-qty preorder">
   */
  public final static String PREORDER_MARKER      = "<div class=\"stock-qty preorder\">";
  
  /** Alternate marker for ID value when MM page has old price information */
  public final static String ALT_ID_MARKER        = "Product.OptionsPrice({\"productId\":\"";
  /** Alternate marker for the Price value. */
  private final static String ALT_PRICE_MARKER    = "meta property=\"product:price:amount\" content=\"";
  
  /** Marker to help try and identify the Manufacturer/Publisher of a Game */
  private final static String MANUFACTURER_MARKER = "manufacturer-link";
  
  /** Category Tag that indicates Board Games */
  public final static String BOARD_GAMES_MARKER   = " - Board Games\">";
  /** Category Tag that indicates Board Games */
  public final static String TABLE_TOP_MARKER     = " - Table Top Miniatures\">";
  /** Category Tag that indicates Board Games */
  public final static String CCG_MARKER           = " - Collectible Card Games\">";
  /** Category Tag that indicates Board Games */
  public final static String COLLECTIBLES_MARKER  = " - Collectible Miniatures\">";
  /** Category Tag that indicates Board Games */
  public final static String RPG_MARKER           = " - Role Playing Games\">";
  /** Category Tag that indicates Board Games */
  public final static String ACCESSORIES_MARKER   = " - Accessories\">";

  public static MiniatureMarketPriceData parseMMHTML(String htmlContent) throws Throwable {
    Date startDate = null;
    if (debugMode) {
      startDate = new Date();
      System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    if (htmlContent == null)
      throw new GameNotFoundException("No game data was provided, htmlContent was null");
    
    int notFound404Marker = htmlContent.indexOf("<title>404 Not Found");
    if (notFound404Marker != -1)
      throw new GameNotFoundException("This game does have an entry at MiniatureMarket.com.");
    
    MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    //Get the title
    int titleMarkerPos = htmlContent.indexOf(TITLE_MARKER);
    if (titleMarkerPos != -1) {
      String title = htmlContent.substring(titleMarkerPos + TITLE_MARKER.length(), 
          htmlContent.indexOf("\"/>", titleMarkerPos + TITLE_MARKER.length()));
      data.setTitle(title.replace(" - Board Games", "").replace("Board Games", "").trim());
    } else throw new Throwable ("Could not find the Title tag correctly.");

    //Get the SKU
    int skuMarkerPos = htmlContent.indexOf(SKU_MARKER);
    if (skuMarkerPos != -1) {
      String sku = htmlContent.substring(skuMarkerPos + SKU_MARKER.length(), 
          htmlContent.indexOf("\";", skuMarkerPos + SKU_MARKER.length()));
      data.setSku(sku);
    } else throw new Throwable ("Could not find the SKU tag correctly.");

    //Get the MMID, which also contains the clues to the Miniature Market price
    int ourPricePos = htmlContent.indexOf(OUR_PRICE_MARKER);
    String idValue = null;
    if (ourPricePos != -1) {
      idValue = htmlContent.substring(ourPricePos + OUR_PRICE_MARKER.length(), 
          htmlContent.indexOf("\">", ourPricePos + OUR_PRICE_MARKER.length()));
      data.setMmID(Long.parseLong(idValue));
    } else {
      int idPos = htmlContent.indexOf(ALT_ID_MARKER);
      if (idPos != -1) {
        idValue = htmlContent.substring(idPos + ALT_ID_MARKER.length(), 
            htmlContent.indexOf("\"", idPos + ALT_ID_MARKER.length()));
        data.setMmID(Long.parseLong(idValue));
      } else throw new Throwable ("Could not find the ID value correctly.");
    }
    
    int boardgamesMarker   = htmlContent.indexOf(BOARD_GAMES_MARKER);
    int tableTopMarker     = htmlContent.indexOf(TABLE_TOP_MARKER);
    int ccgsMarker         = htmlContent.indexOf(CCG_MARKER);
    int collectiblesMarker = htmlContent.indexOf(COLLECTIBLES_MARKER);
    int rpgsMarker         = htmlContent.indexOf(RPG_MARKER);
    int accessoriesMarker  = htmlContent.indexOf(ACCESSORIES_MARKER);
    
    if (boardgamesMarker != -1)        data.setCategory(MiniatureMarketCategory.BOARDGAMES); 
    else if (tableTopMarker != -1)     data.setCategory(MiniatureMarketCategory.TABLETOP);
    else if (ccgsMarker != -1)         data.setCategory(MiniatureMarketCategory.CCGS);
    else if (collectiblesMarker != -1) data.setCategory(MiniatureMarketCategory.COLLECTIBLES);
    else if (rpgsMarker != -1)         data.setCategory(MiniatureMarketCategory.RPGS);
    else if (accessoriesMarker != -1)  data.setCategory(MiniatureMarketCategory.ACCESSORIES);
    else                               data.setCategory(MiniatureMarketCategory.UNKNOWN);
    
    //Get the Availability status
    int inStockMarker    = htmlContent.indexOf(IN_STOCK_MARKER);
    int outOfStockMarker = htmlContent.indexOf(OUT_OF_STOCK_MARKER);
    int preOrderMarker   = htmlContent.indexOf(PREORDER_MARKER);
    if (outOfStockMarker != -1) {
      if (preOrderMarker != -1) data.setAvailability(GameAvailability.NOTYETTAKINGORDERS);
      else                      data.setAvailability(GameAvailability.OUTOFSTOCK);
    } else if (inStockMarker != -1) {
      if (preOrderMarker != -1) data.setAvailability(GameAvailability.PREORDER);
      else                      data.setAvailability(GameAvailability.INSTOCK);
    } else throw new Throwable ("I couldn't find out what the availability state is");
    
    final String PRICE_MARKER_ADDITIONS = idValue + "\">";
    //Get the MSRP
    int msrpMarkerPos = htmlContent.indexOf(MSRP_MARKER);
    if (msrpMarkerPos != -1) {
      String msrpValue = htmlContent.substring(msrpMarkerPos + MSRP_MARKER.length() + PRICE_MARKER_ADDITIONS.length(), 
          htmlContent.indexOf("</span>", msrpMarkerPos + MSRP_MARKER.length() + PRICE_MARKER_ADDITIONS.length()));
      data.setMsrpValue(Double.parseDouble(msrpValue.trim().replace("$", "")));
    } else { 
      System.out.println ("Could not find the MSRP Price (old-price) correctly for mmID " + data.getMmID() + ".");
      //throw new Throwable ("Could not find the MSRP Price (old-price) correctly.");
    }
    
    int priceMarkerPos = htmlContent.indexOf(OUR_PRICE_MARKER);
    if (priceMarkerPos != -1) {
      String priceValue = htmlContent.substring(priceMarkerPos + OUR_PRICE_MARKER.length() + PRICE_MARKER_ADDITIONS.length(), 
          htmlContent.indexOf("</span>", priceMarkerPos + OUR_PRICE_MARKER.length() + PRICE_MARKER_ADDITIONS.length()));
      data.setCurPrice(Double.parseDouble(priceValue.trim().replace("$", "")));
    } else {
      priceMarkerPos = htmlContent.indexOf(ALT_PRICE_MARKER);
      if (priceMarkerPos != -1) {
        String priceValue = htmlContent.substring(priceMarkerPos + ALT_PRICE_MARKER.length(), 
            htmlContent.indexOf("\"", priceMarkerPos + ALT_PRICE_MARKER.length()));
        data.setCurPrice(Double.parseDouble(priceValue.trim()));
      } else throw new Throwable ("Could not find the Current Price correctly.");
    }
    
    //Get the Image tag
    int imageMarkerPos = htmlContent.indexOf(IMAGE_MARKER);
    if (imageMarkerPos != -1) {
      String imageString = htmlContent.substring(imageMarkerPos + IMAGE_MARKER.length(), 
          htmlContent.indexOf("\"", imageMarkerPos + IMAGE_MARKER.length()));
      data.setImageURL(imageString);
    }
    
    //Get the Manufacturer tag (Optional)
    int manufacturerMarkerPos = htmlContent.indexOf(MANUFACTURER_MARKER);
    if (manufacturerMarkerPos != -1) {
      int endPos = htmlContent.indexOf("</a>", manufacturerMarkerPos);
      if (endPos != -1) {
        int startPos = htmlContent.lastIndexOf(">", endPos);
        if (startPos != -1) {
          String manufacturerString = htmlContent.substring(startPos + 1, endPos);
          data.setManufacturer(manufacturerString);
        }
      }
    }
    
    //DEBUG
    //data.printContentsForDebug();
    
    return data;
  }
}
