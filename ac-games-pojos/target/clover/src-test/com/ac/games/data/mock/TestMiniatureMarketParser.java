/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.mock;

import junit.framework.TestCase;

import org.junit.Test;

import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.parser.MiniatureMarketParser;
import com.ac.games.exception.GameNotFoundException;

/**
 * @author ac010168
 *
 */
public class TestMiniatureMarketParser extends TestCase {static class __CLR3_3_02dy2dyi96a107s{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525634799L,8589935092L,3276,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_cenqua_clover.TestNameSniffer __CLR3_3_0_TEST_NAME_SNIFFER=com_cenqua_clover.TestNameSniffer.NULL_INSTANCE;

  @Test
  public void testAbyssParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3094);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kih6b82dy();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testAbyssParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3094,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kih6b82dy(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3094);
    __CLR3_3_02dy2dyi96a107s.R.inc(3095);System.out.println ("Launching Test testAbyssParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3096);String htmlContent = MockGameData.generateContentString(MockGameData.MM_ABYSS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3097);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3098);System.out.println ("Processing Abyss...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3099);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3100);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3101);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3102);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3103);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3104);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3105);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3106);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testCosmicEncounterParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3107);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_062yc1l2eb();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testCosmicEncounterParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3107,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_062yc1l2eb(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3107);
    __CLR3_3_02dy2dyi96a107s.R.inc(3108);System.out.println ("Launching Test testCosmicEncounterParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3109);String htmlContent = MockGameData.generateContentString(MockGameData.MM_COSMIC_ENCOUNTER);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3110);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3111);System.out.println ("Processing Cosmic Encounter...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3112);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3113);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3114);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3115);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3116);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3117);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3118);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3119);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testCosmicIncursionParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3120);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0e4xulg2eo();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testCosmicIncursionParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3120,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0e4xulg2eo(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3120);
    __CLR3_3_02dy2dyi96a107s.R.inc(3121);System.out.println ("Launching Test testCosmicIncursionParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3122);String htmlContent = MockGameData.generateContentString(MockGameData.MM_COSMIC_INCURSION);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3123);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3124);System.out.println ("Processing Cosmic Incursion...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3125);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3126);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3127);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3128);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3129);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3130);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3131);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3132);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testDCDiceMastersParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3133);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0o417fl2f1();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testDCDiceMastersParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3133,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0o417fl2f1(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3133);
    __CLR3_3_02dy2dyi96a107s.R.inc(3134);System.out.println ("Launching Test testDCDiceMastersParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3135);String htmlContent = MockGameData.generateContentString(MockGameData.MM_DC_DICE_MASTERS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3136);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3137);System.out.println ("Processing DC Dice Masters...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3138);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3139);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3140);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3141);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3142);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3143);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3144);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3145);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testXWingIG2000Parser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3146);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0qf6kk32fe();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testXWingIG2000Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3146,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0qf6kk32fe(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3146);
    __CLR3_3_02dy2dyi96a107s.R.inc(3147);System.out.println ("Launching Test testXWingIG2000Parser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3148);String htmlContent = MockGameData.generateContentString(MockGameData.MM_XWING_IG2000);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3149);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3150);System.out.println ("Processing XWing IG2000...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3151);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3152);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3153);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3154);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3155);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3156);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3157);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3158);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testNotFoundParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3159);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kqw63r2fr();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testNotFoundParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3159,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kqw63r2fr(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3159);
    __CLR3_3_02dy2dyi96a107s.R.inc(3160);System.out.println ("Launching Test testNotFoundParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3161);String htmlContent = MockGameData.generateContentString(MockGameData.MM_NOT_FOUND);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3162);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3163);System.out.println ("Processing A Non-Existant Game...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3164);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3165);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3166);MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3167);fail("This game should not have been found, this should be an error!");
    } catch (GameNotFoundException gnfe) { 
      __CLR3_3_02dy2dyi96a107s.R.inc(3168);assertNotNull("This is the only correct outcome for this test", gnfe.getMessage());
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3169);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3170);fail("Should not throw other errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3171);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMM5137Parser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3172);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0xgqwko2g4();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMM5137Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3172,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0xgqwko2g4(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3172);
    __CLR3_3_02dy2dyi96a107s.R.inc(3173);System.out.println ("Launching Test testMM5137Parser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3174);String htmlContent = MockGameData.generateContentString(MockGameData.MM_5137);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3175);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3176);System.out.println ("Processing War at Sea #64 Yukikaze...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3177);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3178);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3179);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3180);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3181);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3182);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3183);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3184);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMAccessoriesParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3185);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0xj9pqc2gh();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMAccessoriesParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3185,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0xj9pqc2gh(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3185);
    __CLR3_3_02dy2dyi96a107s.R.inc(3186);System.out.println ("Launching Test testMMAccessoriesParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3187);String htmlContent = MockGameData.generateContentString(MockGameData.MM_ACCESSORIES);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3188);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3189);System.out.println ("Processing Dek Prot Small Card Sleeves Ivy Green 50...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3190);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3191);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3192);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3193);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3194);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3195);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3196);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3197);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMBoardGamesParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3198);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0dfzx7x2gu();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMBoardGamesParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3198,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0dfzx7x2gu(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3198);
    __CLR3_3_02dy2dyi96a107s.R.inc(3199);System.out.println ("Launching Test testMMBoardGamesParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3200);String htmlContent = MockGameData.generateContentString(MockGameData.MM_BOARDGAMES);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3201);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3202);System.out.println ("Processing 1st and Goal...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3203);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3204);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3205);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3206);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3207);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3208);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3209);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3210);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMCCGsParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3211);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kmpuo42h7();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMCCGsParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3211,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kmpuo42h7(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3211);
    __CLR3_3_02dy2dyi96a107s.R.inc(3212);System.out.println ("Launching Test testMMCCGsParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3213);String htmlContent = MockGameData.generateContentString(MockGameData.MM_CCGS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3214);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3215);System.out.println ("Processing Ultra Pro Side Loading Deck Box Magic the Gathering...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3216);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3217);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3218);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3219);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3220);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3221);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3222);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3223);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMCollectibleMinisParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3224);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0vp7h5k2hk();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMCollectibleMinisParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3224,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0vp7h5k2hk(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3224);
    __CLR3_3_02dy2dyi96a107s.R.inc(3225);System.out.println ("Launching Test testMMCollectibleMinisParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3226);String htmlContent = MockGameData.generateContentString(MockGameData.MM_COLLECTIBLEMINIS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3227);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3228);System.out.println ("Processing Marvel Heroclix Avengers Movie Marquee Figure Thor Clearance...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3229);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3230);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3231);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3232);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3233);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3234);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3235);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3236);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMRPGsParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3237);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0iawc6a2hx();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMRPGsParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3237,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0iawc6a2hx(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3237);
    __CLR3_3_02dy2dyi96a107s.R.inc(3238);System.out.println ("Launching Test testMMRPGsParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3239);String htmlContent = MockGameData.generateContentString(MockGameData.MM_RPGS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3240);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3241);System.out.println ("Processing Pathfinder RPG Module - Daughters of Fury...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3242);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3243);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3244);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3245);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3246);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3247);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3248);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3249);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMTableTopMinisParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3250);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_01d22gn2ia();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMTableTopMinisParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3250,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_01d22gn2ia(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3250);
    __CLR3_3_02dy2dyi96a107s.R.inc(3251);System.out.println ("Launching Test testMMTableTopMinisParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3252);String htmlContent = MockGameData.generateContentString(MockGameData.MM_TABLETOPMINIS);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3253);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3254);System.out.println ("Processing Alkemy - Kingdom of Avalon Starter Box...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3255);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3256);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3257);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3258);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3259);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3260);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3261);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3262);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}

  @Test
  public void testMMUnknownParser() {__CLR3_3_02dy2dyi96a107s.R.globalSliceStart(getClass().getName(),3263);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0bjywbm2in();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_02dy2dyi96a107s.R.rethrow($CLV_t2$);}finally{__CLR3_3_02dy2dyi96a107s.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestMiniatureMarketParser.testMMUnknownParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3263,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0bjywbm2in(){try{__CLR3_3_02dy2dyi96a107s.R.inc(3263);
    __CLR3_3_02dy2dyi96a107s.R.inc(3264);System.out.println ("Launching Test testMMUnknownParser()!");

    __CLR3_3_02dy2dyi96a107s.R.inc(3265);String htmlContent = MockGameData.generateContentString(MockGameData.MM_UNKNOWN);
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3266);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_02dy2dyi96a107s.R.inc(3267);System.out.println ("Processing Funko POP Star Wars...");
    __CLR3_3_02dy2dyi96a107s.R.inc(3268);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3269);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    __CLR3_3_02dy2dyi96a107s.R.inc(3270);try {
      __CLR3_3_02dy2dyi96a107s.R.inc(3271);data = MiniatureMarketParser.parseMMHTML(htmlContent);
      __CLR3_3_02dy2dyi96a107s.R.inc(3272);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_02dy2dyi96a107s.R.inc(3273);t.printStackTrace();
      __CLR3_3_02dy2dyi96a107s.R.inc(3274);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_02dy2dyi96a107s.R.inc(3275);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_02dy2dyi96a107s.R.flushNeeded();}}
}
