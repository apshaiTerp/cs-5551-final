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
public class CoolStuffIncPriceData {public static class __CLR3_3_0jejei96a0znp{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,877,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

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
  
  public CoolStuffIncPriceData() {try{__CLR3_3_0jejei96a0znp.R.inc(698);
    __CLR3_3_0jejei96a0znp.R.inc(699);csiID        = -1L;
    __CLR3_3_0jejei96a0znp.R.inc(700);sku          = null;
    __CLR3_3_0jejei96a0znp.R.inc(701);title        = null;
    __CLR3_3_0jejei96a0znp.R.inc(702);imageURL     = null;
    __CLR3_3_0jejei96a0znp.R.inc(703);availability = null;
    __CLR3_3_0jejei96a0znp.R.inc(704);releaseDate  = null;
    __CLR3_3_0jejei96a0znp.R.inc(705);msrpValue    = -1.0;
    __CLR3_3_0jejei96a0znp.R.inc(706);curPrice     = -1.0;
    __CLR3_3_0jejei96a0znp.R.inc(707);reviewState  = null;
    __CLR3_3_0jejei96a0znp.R.inc(708);addDate      = null;
    __CLR3_3_0jejei96a0znp.R.inc(709);reviewDate   = null;
    __CLR3_3_0jejei96a0znp.R.inc(710);category     = null;
    __CLR3_3_0jejei96a0znp.R.inc(711);publisher    = null;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}
  
  public CoolStuffIncPriceData(String jsonString) {
    super();__CLR3_3_0jejei96a0znp.R.inc(713);try{__CLR3_3_0jejei96a0znp.R.inc(712);
    __CLR3_3_0jejei96a0znp.R.inc(714);ObjectMapper mapper = new ObjectMapper();
    __CLR3_3_0jejei96a0znp.R.inc(715);try {
      __CLR3_3_0jejei96a0znp.R.inc(716);CoolStuffIncPriceData jsonData = mapper.readValue(jsonString, CoolStuffIncPriceData.class);
      __CLR3_3_0jejei96a0znp.R.inc(717);csiID        = jsonData.csiID;
      __CLR3_3_0jejei96a0znp.R.inc(718);sku          = jsonData.sku;
      __CLR3_3_0jejei96a0znp.R.inc(719);title        = jsonData.title;
      __CLR3_3_0jejei96a0znp.R.inc(720);imageURL     = jsonData.imageURL;
      __CLR3_3_0jejei96a0znp.R.inc(721);availability = jsonData.availability;
      __CLR3_3_0jejei96a0znp.R.inc(722);releaseDate  = jsonData.releaseDate;
      __CLR3_3_0jejei96a0znp.R.inc(723);msrpValue    = jsonData.msrpValue;
      __CLR3_3_0jejei96a0znp.R.inc(724);curPrice     = jsonData.curPrice;
      __CLR3_3_0jejei96a0znp.R.inc(725);reviewState  = jsonData.reviewState;
      __CLR3_3_0jejei96a0znp.R.inc(726);addDate      = jsonData.addDate;
      __CLR3_3_0jejei96a0znp.R.inc(727);reviewDate   = jsonData.reviewDate;
      __CLR3_3_0jejei96a0znp.R.inc(728);category     = jsonData.category;
      __CLR3_3_0jejei96a0znp.R.inc(729);publisher    = jsonData.publisher;
    } catch (JsonParseException jpe) {
      __CLR3_3_0jejei96a0znp.R.inc(730);jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      __CLR3_3_0jejei96a0znp.R.inc(731);jme.printStackTrace();
    } catch (IOException ioe) {
      __CLR3_3_0jejei96a0znp.R.inc(732);ioe.printStackTrace();
    }
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}
  
  /**
   * Debug Helper to dump out the contents of this object
   */
  public void printContentsForDebug() {try{__CLR3_3_0jejei96a0znp.R.inc(733);
    __CLR3_3_0jejei96a0znp.R.inc(734);System.out.println ("Printing contents for Game ID " + getCsiID());
    __CLR3_3_0jejei96a0znp.R.inc(735);System.out.println ("============================================================");
    __CLR3_3_0jejei96a0znp.R.inc(736);System.out.println ("Game Title:          " + getTitle());
    __CLR3_3_0jejei96a0znp.R.inc(737);System.out.println ("Publisher:           " + (((((getPublisher() == null) )&&(__CLR3_3_0jejei96a0znp.R.iget(738)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(739)==0&false))? "[-]" : publisher));
    boolean __CLB3_3_0_bool0=false;__CLR3_3_0jejei96a0znp.R.inc(740);switch (getCategory()) {
      case COLLECTIBLE :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(741);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(742);System.out.println ("Category:            Collectible Card Games"); __CLR3_3_0jejei96a0znp.R.inc(743);break;
      case DICEMASTERS :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(744);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(745);System.out.println ("Category:            Dice Masters"); __CLR3_3_0jejei96a0znp.R.inc(746);break;
      case BOARDGAMES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(747);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(748);System.out.println ("Category:            Board Games"); __CLR3_3_0jejei96a0znp.R.inc(749);break;
      case RPGS        :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(750);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(751);System.out.println ("Category:            Role Playing Games"); __CLR3_3_0jejei96a0znp.R.inc(752);break;
      case LCGS        :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(753);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(754);System.out.println ("Category:            Living Card Games"); __CLR3_3_0jejei96a0znp.R.inc(755);break;
      case SUPPLIES    :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(756);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(757);System.out.println ("Category:            Supplies"); __CLR3_3_0jejei96a0znp.R.inc(758);break;
      case MINIATURES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(759);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(760);System.out.println ("Category:            Miniatures"); __CLR3_3_0jejei96a0znp.R.inc(761);break;
      case VIDEOGAMES  :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(762);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(763);System.out.println ("Category:            Video Games"); __CLR3_3_0jejei96a0znp.R.inc(764);break;
      case UNKNOWN     :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(765);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(766);System.out.println ("Category:            Unknown"); __CLR3_3_0jejei96a0znp.R.inc(767);break;
      default          :if (!__CLB3_3_0_bool0) {__CLR3_3_0jejei96a0znp.R.inc(768);__CLB3_3_0_bool0=true;} __CLR3_3_0jejei96a0znp.R.inc(769);System.out.println ("Category:            [-]"); __CLR3_3_0jejei96a0znp.R.inc(770);break;
    }
    __CLR3_3_0jejei96a0znp.R.inc(771);System.out.println ("Game Image:          " + getImageURL());
    __CLR3_3_0jejei96a0znp.R.inc(772);System.out.println ("SKU:                 " + getSku());
    boolean __CLB3_3_0_bool1=false;__CLR3_3_0jejei96a0znp.R.inc(773);switch (getAvailability()) {
      case INSTOCK            :if (!__CLB3_3_0_bool1) {__CLR3_3_0jejei96a0znp.R.inc(774);__CLB3_3_0_bool1=true;} __CLR3_3_0jejei96a0znp.R.inc(775);System.out.println ("Availability:        In Stock"); __CLR3_3_0jejei96a0znp.R.inc(776);break;
      case PREORDER           :if (!__CLB3_3_0_bool1) {__CLR3_3_0jejei96a0znp.R.inc(777);__CLB3_3_0_bool1=true;} __CLR3_3_0jejei96a0znp.R.inc(778);System.out.println ("Availability:        Pre-Order"); __CLR3_3_0jejei96a0znp.R.inc(779);break;
      case OUTOFSTOCK         :if (!__CLB3_3_0_bool1) {__CLR3_3_0jejei96a0znp.R.inc(780);__CLB3_3_0_bool1=true;} __CLR3_3_0jejei96a0znp.R.inc(781);System.out.println ("Availability:        Out of Stock"); __CLR3_3_0jejei96a0znp.R.inc(782);break;
      case NOTYETTAKINGORDERS :if (!__CLB3_3_0_bool1) {__CLR3_3_0jejei96a0znp.R.inc(783);__CLB3_3_0_bool1=true;} __CLR3_3_0jejei96a0znp.R.inc(784);System.out.println ("Availability:        Not Yet Taking Orders"); __CLR3_3_0jejei96a0znp.R.inc(785);break;
      default :if (!__CLB3_3_0_bool1) {__CLR3_3_0jejei96a0znp.R.inc(786);__CLB3_3_0_bool1=true;} __CLR3_3_0jejei96a0znp.R.inc(787);System.out.println ("Availability:        Unknown");
    }
    __CLR3_3_0jejei96a0znp.R.inc(788);System.out.println ("Expected Release:    " + (((((getReleaseDate() == null) )&&(__CLR3_3_0jejei96a0znp.R.iget(789)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(790)==0&false))? "[-]" : releaseDate));
    __CLR3_3_0jejei96a0znp.R.inc(791);System.out.println ("MSRP:                " + (((((getMsrpValue() == -1L) )&&(__CLR3_3_0jejei96a0znp.R.iget(792)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(793)==0&false))? "[-]" : moneyFormat.format(getMsrpValue())));
    __CLR3_3_0jejei96a0znp.R.inc(794);System.out.println ("Current Price:       " + (((((getCurPrice() == -1L) )&&(__CLR3_3_0jejei96a0znp.R.iget(795)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(796)==0&false))? "[-]" : moneyFormat.format(getCurPrice())));

    __CLR3_3_0jejei96a0znp.R.inc(797);if ((((getReviewState() == null)&&(__CLR3_3_0jejei96a0znp.R.iget(798)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(799)==0&false))) {{
      __CLR3_3_0jejei96a0znp.R.inc(800);System.out.println ("Review State:        [-]");
    } }else {{
      boolean __CLB3_3_0_bool2=false;__CLR3_3_0jejei96a0znp.R.inc(801);switch (reviewState) {
        case PENDING  :if (!__CLB3_3_0_bool2) {__CLR3_3_0jejei96a0znp.R.inc(802);__CLB3_3_0_bool2=true;} __CLR3_3_0jejei96a0znp.R.inc(803);System.out.println ("Review State:        Pending");  __CLR3_3_0jejei96a0znp.R.inc(804);break;
        case REVIEWED :if (!__CLB3_3_0_bool2) {__CLR3_3_0jejei96a0znp.R.inc(805);__CLB3_3_0_bool2=true;} __CLR3_3_0jejei96a0znp.R.inc(806);System.out.println ("Review State:        Reviewed"); __CLR3_3_0jejei96a0znp.R.inc(807);break;
        case REJECTED :if (!__CLB3_3_0_bool2) {__CLR3_3_0jejei96a0znp.R.inc(808);__CLB3_3_0_bool2=true;} __CLR3_3_0jejei96a0znp.R.inc(809);System.out.println ("Review State:        Rejected"); __CLR3_3_0jejei96a0znp.R.inc(810);break;
      }
    }
    }__CLR3_3_0jejei96a0znp.R.inc(811);if ((((getAddDate() != null)&&(__CLR3_3_0jejei96a0znp.R.iget(812)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(813)==0&false))) {__CLR3_3_0jejei96a0znp.R.inc(814);System.out.println ("Add Date:            " + addDate); 
    }else                      {__CLR3_3_0jejei96a0znp.R.inc(815);System.out.println ("Add Date:            [-]"); 
    }__CLR3_3_0jejei96a0znp.R.inc(816);if ((((getReviewDate() != null)&&(__CLR3_3_0jejei96a0znp.R.iget(817)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(818)==0&false))) {__CLR3_3_0jejei96a0znp.R.inc(819);System.out.println ("Review Date:         " + reviewDate); 
    }else                         {__CLR3_3_0jejei96a0znp.R.inc(820);System.out.println ("Review Date:         [-]"); 
  }}finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the csiID
   */
  public long getCsiID() {try{__CLR3_3_0jejei96a0znp.R.inc(821);
    __CLR3_3_0jejei96a0znp.R.inc(822);return csiID;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param csiID the csiID to set
   */
  public void setCsiID(long csiID) {try{__CLR3_3_0jejei96a0znp.R.inc(823);
    __CLR3_3_0jejei96a0znp.R.inc(824);this.csiID = csiID;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the sku
   */
  public String getSku() {try{__CLR3_3_0jejei96a0znp.R.inc(825);
    __CLR3_3_0jejei96a0znp.R.inc(826);return sku;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param sku the sku to set
   */
  public void setSku(String sku) {try{__CLR3_3_0jejei96a0znp.R.inc(827);
    __CLR3_3_0jejei96a0znp.R.inc(828);this.sku = sku;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the title
   */
  public String getTitle() {try{__CLR3_3_0jejei96a0znp.R.inc(829);
    __CLR3_3_0jejei96a0znp.R.inc(830);return title;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {try{__CLR3_3_0jejei96a0znp.R.inc(831);
    __CLR3_3_0jejei96a0znp.R.inc(832);this.title = title;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the imageURL
   */
  public String getImageURL() {try{__CLR3_3_0jejei96a0znp.R.inc(833);
    __CLR3_3_0jejei96a0znp.R.inc(834);return imageURL;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * Adding functionality to this method to strip out the inserted autosizing of the image.
   * 
   * @param imageURL the imageURL to set
   */
  public void setImageURL(String imageURL) {try{__CLR3_3_0jejei96a0znp.R.inc(835);
    __CLR3_3_0jejei96a0znp.R.inc(836);if ((((imageURL == null)&&(__CLR3_3_0jejei96a0znp.R.iget(837)!=0|true))||(__CLR3_3_0jejei96a0znp.R.iget(838)==0&false))) {__CLR3_3_0jejei96a0znp.R.inc(839);this.imageURL = imageURL;
    }else {__CLR3_3_0jejei96a0znp.R.inc(840);this.imageURL = imageURL.replace("c_pad,h_300,w_300/", "");
  }}finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the availability
   */
  public GameAvailability getAvailability() {try{__CLR3_3_0jejei96a0znp.R.inc(841);
    __CLR3_3_0jejei96a0znp.R.inc(842);return availability;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param availability the availability to set
   */
  public void setAvailability(GameAvailability availability) {try{__CLR3_3_0jejei96a0znp.R.inc(843);
    __CLR3_3_0jejei96a0znp.R.inc(844);this.availability = availability;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the msrpValue
   */
  public double getMsrpValue() {try{__CLR3_3_0jejei96a0znp.R.inc(845);
    __CLR3_3_0jejei96a0znp.R.inc(846);return msrpValue;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param msrpValue the msrpValue to set
   */
  public void setMsrpValue(double msrpValue) {try{__CLR3_3_0jejei96a0znp.R.inc(847);
    __CLR3_3_0jejei96a0znp.R.inc(848);this.msrpValue = msrpValue;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the curPrice
   */
  public double getCurPrice() {try{__CLR3_3_0jejei96a0znp.R.inc(849);
    __CLR3_3_0jejei96a0znp.R.inc(850);return curPrice;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param curPrice the curPrice to set
   */
  public void setCurPrice(double curPrice) {try{__CLR3_3_0jejei96a0znp.R.inc(851);
    __CLR3_3_0jejei96a0znp.R.inc(852);this.curPrice = curPrice;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the releaseDate
   */
  public String getReleaseDate() {try{__CLR3_3_0jejei96a0znp.R.inc(853);
    __CLR3_3_0jejei96a0znp.R.inc(854);return releaseDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(String releaseDate) {try{__CLR3_3_0jejei96a0znp.R.inc(855);
    __CLR3_3_0jejei96a0znp.R.inc(856);this.releaseDate = releaseDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the reviewState
   */
  public ReviewState getReviewState() {try{__CLR3_3_0jejei96a0znp.R.inc(857);
    __CLR3_3_0jejei96a0znp.R.inc(858);return reviewState;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param reviewState the reviewState to set
   */
  public void setReviewState(ReviewState reviewState) {try{__CLR3_3_0jejei96a0znp.R.inc(859);
    __CLR3_3_0jejei96a0znp.R.inc(860);this.reviewState = reviewState;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the addDate
   */
  public Date getAddDate() {try{__CLR3_3_0jejei96a0znp.R.inc(861);
    __CLR3_3_0jejei96a0znp.R.inc(862);return addDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param addDate the addDate to set
   */
  public void setAddDate(Date addDate) {try{__CLR3_3_0jejei96a0znp.R.inc(863);
    __CLR3_3_0jejei96a0znp.R.inc(864);this.addDate = addDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the reviewDate
   */
  public Date getReviewDate() {try{__CLR3_3_0jejei96a0znp.R.inc(865);
    __CLR3_3_0jejei96a0znp.R.inc(866);return reviewDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param reviewDate the reviewDate to set
   */
  public void setReviewDate(Date reviewDate) {try{__CLR3_3_0jejei96a0znp.R.inc(867);
    __CLR3_3_0jejei96a0znp.R.inc(868);this.reviewDate = reviewDate;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the category
   */
  public CoolStuffIncCategory getCategory() {try{__CLR3_3_0jejei96a0znp.R.inc(869);
    __CLR3_3_0jejei96a0znp.R.inc(870);return category;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param category the category to set
   */
  public void setCategory(CoolStuffIncCategory category) {try{__CLR3_3_0jejei96a0znp.R.inc(871);
    __CLR3_3_0jejei96a0znp.R.inc(872);this.category = category;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @return the publisher
   */
  public String getPublisher() {try{__CLR3_3_0jejei96a0znp.R.inc(873);
    __CLR3_3_0jejei96a0znp.R.inc(874);return publisher;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}

  /**
   * @param publisher the publisher to set
   */
  public void setPublisher(String publisher) {try{__CLR3_3_0jejei96a0znp.R.inc(875);
    __CLR3_3_0jejei96a0znp.R.inc(876);this.publisher = publisher;
  }finally{__CLR3_3_0jejei96a0znp.R.flushNeeded();}}
}
