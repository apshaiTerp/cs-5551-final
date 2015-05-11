/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ac.games.data.*;
import com.ac.games.exception.GameNotFoundException;

/**
 * 
 * @author ac010168
 */
public class MiniatureMarketParser {public static class __CLR3_3_01ty1tyi96a1000{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2512,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
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

  public static MiniatureMarketPriceData parseMMHTML(String htmlContent) throws Throwable {try{__CLR3_3_01ty1tyi96a1000.R.inc(2374);
    __CLR3_3_01ty1tyi96a1000.R.inc(2375);Date startDate = null;
    __CLR3_3_01ty1tyi96a1000.R.inc(2376);if ((((debugMode)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2377)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2378)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2379);startDate = new Date();
      __CLR3_3_01ty1tyi96a1000.R.inc(2380);System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2381);if ((((htmlContent == null)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2382)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2383)==0&false)))
      {__CLR3_3_01ty1tyi96a1000.R.inc(2384);throw new GameNotFoundException("No game data was provided, htmlContent was null");
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2385);int notFound404Marker = htmlContent.indexOf("<title>404 Not Found");
    __CLR3_3_01ty1tyi96a1000.R.inc(2386);if ((((notFound404Marker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2387)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2388)==0&false)))
      {__CLR3_3_01ty1tyi96a1000.R.inc(2389);throw new GameNotFoundException("This game does have an entry at MiniatureMarket.com.");
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2390);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    //Get the title
    __CLR3_3_01ty1tyi96a1000.R.inc(2391);int titleMarkerPos = htmlContent.indexOf(TITLE_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2392);if ((((titleMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2393)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2394)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2395);String title = htmlContent.substring(titleMarkerPos + TITLE_MARKER.length(), 
          htmlContent.indexOf("\"/>", titleMarkerPos + TITLE_MARKER.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2396);data.setTitle(title.replace(" - Board Games", "").replace("Board Games", "").trim());
    } }else {__CLR3_3_01ty1tyi96a1000.R.inc(2397);throw new Throwable ("Could not find the Title tag correctly.");

    //Get the SKU
    }__CLR3_3_01ty1tyi96a1000.R.inc(2398);int skuMarkerPos = htmlContent.indexOf(SKU_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2399);if ((((skuMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2400)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2401)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2402);String sku = htmlContent.substring(skuMarkerPos + SKU_MARKER.length(), 
          htmlContent.indexOf("\";", skuMarkerPos + SKU_MARKER.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2403);data.setSku(sku);
    } }else {__CLR3_3_01ty1tyi96a1000.R.inc(2404);throw new Throwable ("Could not find the SKU tag correctly.");

    //Get the MMID, which also contains the clues to the Miniature Market price
    }__CLR3_3_01ty1tyi96a1000.R.inc(2405);int ourPricePos = htmlContent.indexOf(OUR_PRICE_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2406);String idValue = null;
    __CLR3_3_01ty1tyi96a1000.R.inc(2407);if ((((ourPricePos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2408)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2409)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2410);idValue = htmlContent.substring(ourPricePos + OUR_PRICE_MARKER.length(), 
          htmlContent.indexOf("\">", ourPricePos + OUR_PRICE_MARKER.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2411);data.setMmID(Long.parseLong(idValue));
    } }else {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2412);int idPos = htmlContent.indexOf(ALT_ID_MARKER);
      __CLR3_3_01ty1tyi96a1000.R.inc(2413);if ((((idPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2414)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2415)==0&false))) {{
        __CLR3_3_01ty1tyi96a1000.R.inc(2416);idValue = htmlContent.substring(idPos + ALT_ID_MARKER.length(), 
            htmlContent.indexOf("\"", idPos + ALT_ID_MARKER.length()));
        __CLR3_3_01ty1tyi96a1000.R.inc(2417);data.setMmID(Long.parseLong(idValue));
      } }else {__CLR3_3_01ty1tyi96a1000.R.inc(2418);throw new Throwable ("Could not find the ID value correctly.");
    }}
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2419);int boardgamesMarker   = htmlContent.indexOf(BOARD_GAMES_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2420);int tableTopMarker     = htmlContent.indexOf(TABLE_TOP_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2421);int ccgsMarker         = htmlContent.indexOf(CCG_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2422);int collectiblesMarker = htmlContent.indexOf(COLLECTIBLES_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2423);int rpgsMarker         = htmlContent.indexOf(RPG_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2424);int accessoriesMarker  = htmlContent.indexOf(ACCESSORIES_MARKER);
    
    __CLR3_3_01ty1tyi96a1000.R.inc(2425);if ((((boardgamesMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2426)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2427)==0&false)))        {__CLR3_3_01ty1tyi96a1000.R.inc(2428);data.setCategory(MiniatureMarketCategory.BOARDGAMES); 
    }else {__CLR3_3_01ty1tyi96a1000.R.inc(2429);if ((((tableTopMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2430)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2431)==0&false)))     {__CLR3_3_01ty1tyi96a1000.R.inc(2432);data.setCategory(MiniatureMarketCategory.TABLETOP);
    }else {__CLR3_3_01ty1tyi96a1000.R.inc(2433);if ((((ccgsMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2434)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2435)==0&false)))         {__CLR3_3_01ty1tyi96a1000.R.inc(2436);data.setCategory(MiniatureMarketCategory.CCGS);
    }else {__CLR3_3_01ty1tyi96a1000.R.inc(2437);if ((((collectiblesMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2438)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2439)==0&false))) {__CLR3_3_01ty1tyi96a1000.R.inc(2440);data.setCategory(MiniatureMarketCategory.COLLECTIBLES);
    }else {__CLR3_3_01ty1tyi96a1000.R.inc(2441);if ((((rpgsMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2442)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2443)==0&false)))         {__CLR3_3_01ty1tyi96a1000.R.inc(2444);data.setCategory(MiniatureMarketCategory.RPGS);
    }else {__CLR3_3_01ty1tyi96a1000.R.inc(2445);if ((((accessoriesMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2446)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2447)==0&false)))  {__CLR3_3_01ty1tyi96a1000.R.inc(2448);data.setCategory(MiniatureMarketCategory.ACCESSORIES);
    }else                               {__CLR3_3_01ty1tyi96a1000.R.inc(2449);data.setCategory(MiniatureMarketCategory.UNKNOWN);
    
    //Get the Availability status
    }}}}}}__CLR3_3_01ty1tyi96a1000.R.inc(2450);int inStockMarker    = htmlContent.indexOf(IN_STOCK_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2451);int outOfStockMarker = htmlContent.indexOf(OUT_OF_STOCK_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2452);int preOrderMarker   = htmlContent.indexOf(PREORDER_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2453);if ((((outOfStockMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2454)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2455)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2456);if ((((preOrderMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2457)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2458)==0&false))) {__CLR3_3_01ty1tyi96a1000.R.inc(2459);data.setAvailability(GameAvailability.NOTYETTAKINGORDERS);
      }else                      {__CLR3_3_01ty1tyi96a1000.R.inc(2460);data.setAvailability(GameAvailability.OUTOFSTOCK);
    }} }else {__CLR3_3_01ty1tyi96a1000.R.inc(2461);if ((((inStockMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2462)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2463)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2464);if ((((preOrderMarker != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2465)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2466)==0&false))) {__CLR3_3_01ty1tyi96a1000.R.inc(2467);data.setAvailability(GameAvailability.PREORDER);
      }else                      {__CLR3_3_01ty1tyi96a1000.R.inc(2468);data.setAvailability(GameAvailability.INSTOCK);
    }} }else {__CLR3_3_01ty1tyi96a1000.R.inc(2469);throw new Throwable ("I couldn't find out what the availability state is");
    
    }}__CLR3_3_01ty1tyi96a1000.R.inc(2470);final String PRICE_MARKER_ADDITIONS = idValue + "\">";
    //Get the MSRP
    __CLR3_3_01ty1tyi96a1000.R.inc(2471);int msrpMarkerPos = htmlContent.indexOf(MSRP_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2472);if ((((msrpMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2473)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2474)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2475);String msrpValue = htmlContent.substring(msrpMarkerPos + MSRP_MARKER.length() + PRICE_MARKER_ADDITIONS.length(), 
          htmlContent.indexOf("</span>", msrpMarkerPos + MSRP_MARKER.length() + PRICE_MARKER_ADDITIONS.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2476);data.setMsrpValue(Double.parseDouble(msrpValue.trim().replace("$", "")));
    } }else {{ 
      __CLR3_3_01ty1tyi96a1000.R.inc(2477);System.out.println ("Could not find the MSRP Price (old-price) correctly for mmID " + data.getMmID() + ".");
      //throw new Throwable ("Could not find the MSRP Price (old-price) correctly.");
    }
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2478);int priceMarkerPos = htmlContent.indexOf(OUR_PRICE_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2479);if ((((priceMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2480)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2481)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2482);String priceValue = htmlContent.substring(priceMarkerPos + OUR_PRICE_MARKER.length() + PRICE_MARKER_ADDITIONS.length(), 
          htmlContent.indexOf("</span>", priceMarkerPos + OUR_PRICE_MARKER.length() + PRICE_MARKER_ADDITIONS.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2483);data.setCurPrice(Double.parseDouble(priceValue.trim().replace("$", "")));
    } }else {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2484);priceMarkerPos = htmlContent.indexOf(ALT_PRICE_MARKER);
      __CLR3_3_01ty1tyi96a1000.R.inc(2485);if ((((priceMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2486)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2487)==0&false))) {{
        __CLR3_3_01ty1tyi96a1000.R.inc(2488);String priceValue = htmlContent.substring(priceMarkerPos + ALT_PRICE_MARKER.length(), 
            htmlContent.indexOf("\"", priceMarkerPos + ALT_PRICE_MARKER.length()));
        __CLR3_3_01ty1tyi96a1000.R.inc(2489);data.setCurPrice(Double.parseDouble(priceValue.trim()));
      } }else {__CLR3_3_01ty1tyi96a1000.R.inc(2490);throw new Throwable ("Could not find the Current Price correctly.");
    }}
    
    //Get the Image tag
    }__CLR3_3_01ty1tyi96a1000.R.inc(2491);int imageMarkerPos = htmlContent.indexOf(IMAGE_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2492);if ((((imageMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2493)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2494)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2495);String imageString = htmlContent.substring(imageMarkerPos + IMAGE_MARKER.length(), 
          htmlContent.indexOf("\"", imageMarkerPos + IMAGE_MARKER.length()));
      __CLR3_3_01ty1tyi96a1000.R.inc(2496);data.setImageURL(imageString);
    }
    
    //Get the Manufacturer tag (Optional)
    }__CLR3_3_01ty1tyi96a1000.R.inc(2497);int manufacturerMarkerPos = htmlContent.indexOf(MANUFACTURER_MARKER);
    __CLR3_3_01ty1tyi96a1000.R.inc(2498);if ((((manufacturerMarkerPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2499)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2500)==0&false))) {{
      __CLR3_3_01ty1tyi96a1000.R.inc(2501);int endPos = htmlContent.indexOf("</a>", manufacturerMarkerPos);
      __CLR3_3_01ty1tyi96a1000.R.inc(2502);if ((((endPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2503)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2504)==0&false))) {{
        __CLR3_3_01ty1tyi96a1000.R.inc(2505);int startPos = htmlContent.lastIndexOf(">", endPos);
        __CLR3_3_01ty1tyi96a1000.R.inc(2506);if ((((startPos != -1)&&(__CLR3_3_01ty1tyi96a1000.R.iget(2507)!=0|true))||(__CLR3_3_01ty1tyi96a1000.R.iget(2508)==0&false))) {{
          __CLR3_3_01ty1tyi96a1000.R.inc(2509);String manufacturerString = htmlContent.substring(startPos + 1, endPos);
          __CLR3_3_01ty1tyi96a1000.R.inc(2510);data.setManufacturer(manufacturerString);
        }
      }}
    }}
    
    //DEBUG
    //data.printContentsForDebug();
    
    }__CLR3_3_01ty1tyi96a1000.R.inc(2511);return data;
  }finally{__CLR3_3_01ty1tyi96a1000.R.flushNeeded();}}
}
