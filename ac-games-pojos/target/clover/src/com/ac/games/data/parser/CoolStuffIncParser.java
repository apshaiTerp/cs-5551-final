/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.parser;

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
public class CoolStuffIncParser {public static class __CLR3_3_01qc1qci96a0zz7{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2374,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

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
  public static CoolStuffIncPriceData parseCSIHTML(String htmlContent, final long csiID) throws Throwable {try{__CLR3_3_01qc1qci96a0zz7.R.inc(2244);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2245);Date startDate = null;
    __CLR3_3_01qc1qci96a0zz7.R.inc(2246);if ((((debugMode)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2247)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2248)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2249);startDate = new Date();
      __CLR3_3_01qc1qci96a0zz7.R.inc(2250);System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2251);if ((((htmlContent == null)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2252)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2253)==0&false)))
      {__CLR3_3_01qc1qci96a0zz7.R.inc(2254);throw new GameNotFoundException("No game data was provided, htmlContent was null");
    
    //Check for the "Product not found." text that let's us know we didn't find what we
    //were looking for
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2255);int notFoundTag = htmlContent.indexOf("Product not found.");
    
    __CLR3_3_01qc1qci96a0zz7.R.inc(2256);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_01qc1qci96a0zz7.R.inc(2257);data.setCsiID(csiID);
    
    __CLR3_3_01qc1qci96a0zz7.R.inc(2258);int titleMarkerPos = htmlContent.indexOf(TITLE_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2259);String title = null;
    __CLR3_3_01qc1qci96a0zz7.R.inc(2260);if ((((titleMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2261)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2262)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2263);title = htmlContent.substring(titleMarkerPos + TITLE_MARKER.length(), 
          htmlContent.indexOf("\">", titleMarkerPos + TITLE_MARKER.length()));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2264);data.setTitle(title);
    } }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2265);throw new Throwable ("Could not find the Title tag correctly.");
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2266);if (((((notFoundTag != -1) && (title.startsWith("CoolStuffInc.com")))&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2267)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2268)==0&false)))
      {__CLR3_3_01qc1qci96a0zz7.R.inc(2269);throw new GameNotFoundException("This game does have an entry at CoolStuffInc.com.");
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2270);if ((((title.startsWith("Gift Certificate"))&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2271)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2272)==0&false)))
      {__CLR3_3_01qc1qci96a0zz7.R.inc(2273);throw new GameNotFoundException("This game is not actually a game, it's a gift certificate form.");
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2274);int skuMarkerPos = htmlContent.indexOf(SKU_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2275);if ((((skuMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2276)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2277)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2278);String sku = htmlContent.substring(skuMarkerPos + SKU_MARKER.length(), 
          htmlContent.indexOf(", ", skuMarkerPos + SKU_MARKER.length()));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2279);data.setSku(sku);
    } }else {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2280);data.setSku(null);
      //throw new Throwable ("Could not find the SKU item correctly.");
    }
    
    //Now let's look for the multiple possible categories
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2281);int ccgMarkerPos         = htmlContent.indexOf(CCG_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2282);int diceMastersMarkerPos = htmlContent.indexOf(DICE_MASTERS_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2283);int boardGameMarkerPos   = htmlContent.indexOf(BOARD_GAMES_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2284);int rpgMarkerPos         = htmlContent.indexOf(RPG_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2285);int lcgMarkerPos         = htmlContent.indexOf(LCG_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2286);int suppliesMarkerPos    = htmlContent.indexOf(SUPPLIES_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2287);int miniaturesMarkerPos  = htmlContent.indexOf(MINIATURES_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2288);int videoGamesMarkerPos  = htmlContent.indexOf(VIDEOGAMES_MARKER);
    
    __CLR3_3_01qc1qci96a0zz7.R.inc(2289);if ((((ccgMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2290)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2291)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2292);if ((((diceMastersMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2293)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2294)==0&false)))   {__CLR3_3_01qc1qci96a0zz7.R.inc(2295);data.setCategory(CoolStuffIncCategory.DICEMASTERS);
      }else                              {__CLR3_3_01qc1qci96a0zz7.R.inc(2296);data.setCategory(CoolStuffIncCategory.COLLECTIBLE);
    }} 
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2297);if ((((boardGameMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2298)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2299)==0&false)))  {__CLR3_3_01qc1qci96a0zz7.R.inc(2300);data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2301);if ((((rpgMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2302)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2303)==0&false)))        {__CLR3_3_01qc1qci96a0zz7.R.inc(2304);data.setCategory(CoolStuffIncCategory.RPGS);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2305);if ((((lcgMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2306)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2307)==0&false)))        {__CLR3_3_01qc1qci96a0zz7.R.inc(2308);data.setCategory(CoolStuffIncCategory.LCGS);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2309);if ((((suppliesMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2310)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2311)==0&false)))   {__CLR3_3_01qc1qci96a0zz7.R.inc(2312);data.setCategory(CoolStuffIncCategory.SUPPLIES);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2313);if ((((miniaturesMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2314)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2315)==0&false))) {__CLR3_3_01qc1qci96a0zz7.R.inc(2316);data.setCategory(CoolStuffIncCategory.MINIATURES);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2317);if ((((videoGamesMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2318)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2319)==0&false))) {__CLR3_3_01qc1qci96a0zz7.R.inc(2320);data.setCategory(CoolStuffIncCategory.VIDEOGAMES);
    }else                                {__CLR3_3_01qc1qci96a0zz7.R.inc(2321);data.setCategory(CoolStuffIncCategory.UNKNOWN);
    
    }}}}}}}__CLR3_3_01qc1qci96a0zz7.R.inc(2322);int imageMarkerPos = htmlContent.indexOf(IMAGE_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2323);if ((((imageMarkerPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2324)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2325)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2326);String imageString = htmlContent.substring(imageMarkerPos + IMAGE_MARKER.length(), 
          htmlContent.indexOf("\"", imageMarkerPos + IMAGE_MARKER.length()));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2327);data.setImageURL(imageString);
    }
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2328);int isInStock    = htmlContent.indexOf(IN_STOCK_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2329);int isOutOfStock = htmlContent.indexOf(OUT_OF_STOCK_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2330);int isPreOrder   = htmlContent.indexOf(PRE_ORDER_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2331);int expectedPos  = htmlContent.toLowerCase().indexOf(EXPECTED_MARKER.toLowerCase());
    
    __CLR3_3_01qc1qci96a0zz7.R.inc(2332);if ((((isInStock != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2333)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2334)==0&false)))         {__CLR3_3_01qc1qci96a0zz7.R.inc(2335);data.setAvailability(GameAvailability.INSTOCK);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2336);if ((((isPreOrder != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2337)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2338)==0&false)))   {__CLR3_3_01qc1qci96a0zz7.R.inc(2339);data.setAvailability(GameAvailability.PREORDER);
    }else {__CLR3_3_01qc1qci96a0zz7.R.inc(2340);if ((((isOutOfStock != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2341)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2342)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2343);if ((((expectedPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2344)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2345)==0&false))) {__CLR3_3_01qc1qci96a0zz7.R.inc(2346);data.setAvailability(GameAvailability.NOTYETTAKINGORDERS);
      }else                   {__CLR3_3_01qc1qci96a0zz7.R.inc(2347);data.setAvailability(GameAvailability.OUTOFSTOCK);
    }}
    }else {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2348);System.out.println ("  Not able to find an availability.  Setting it to Out Of Stock");
      __CLR3_3_01qc1qci96a0zz7.R.inc(2349);data.setAvailability(GameAvailability.OUTOFSTOCK);
    }

    //Gather the expected release date, if any
    }}}__CLR3_3_01qc1qci96a0zz7.R.inc(2350);if ((((expectedPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2351)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2352)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2353);String releaseString = htmlContent.substring(expectedPos + EXPECTED_MARKER.length(), 
          htmlContent.indexOf(".", expectedPos + EXPECTED_MARKER.length()));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2354);data.setReleaseDate(releaseString);
    }
    
    //If the game is not out of stock, we should be able to find the price, and might
    //find some price markers even if the game is out of stock.
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2355);int msrpPos  = htmlContent.indexOf(MSRP_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2356);if ((((msrpPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2357)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2358)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2359);double msrpValue = Double.parseDouble(htmlContent.substring(msrpPos + MSRP_MARKER.length(), 
          htmlContent.indexOf(", ", msrpPos + MSRP_MARKER.length())));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2360);data.setMsrpValue(msrpValue);
    }
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2361);int pricePos = htmlContent.indexOf(OUR_PRICE_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2362);if ((((pricePos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2363)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2364)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2365);double priceValue = Double.parseDouble(htmlContent.substring(pricePos + OUR_PRICE_MARKER.length(), 
          htmlContent.indexOf(", ", pricePos + OUR_PRICE_MARKER.length())));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2366);data.setCurPrice(priceValue);
    }
    
    }__CLR3_3_01qc1qci96a0zz7.R.inc(2367);int publisherPos  = htmlContent.indexOf(PUBLISHER_MARKER);
    __CLR3_3_01qc1qci96a0zz7.R.inc(2368);if ((((publisherPos != -1)&&(__CLR3_3_01qc1qci96a0zz7.R.iget(2369)!=0|true))||(__CLR3_3_01qc1qci96a0zz7.R.iget(2370)==0&false))) {{
      __CLR3_3_01qc1qci96a0zz7.R.inc(2371);String publisherValue = htmlContent.substring(publisherPos + PUBLISHER_MARKER.length(), 
          htmlContent.indexOf(",", publisherPos + PUBLISHER_MARKER.length()));
      __CLR3_3_01qc1qci96a0zz7.R.inc(2372);data.setPublisher(publisherValue);
    }

    }__CLR3_3_01qc1qci96a0zz7.R.inc(2373);return data;
  }finally{__CLR3_3_01qc1qci96a0zz7.R.flushNeeded();}}
}
