/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.mock;

import java.util.List;

import org.junit.Test;

import com.ac.games.data.BGGGame;
import com.ac.games.data.parser.BGGGameParser;
import com.ac.games.exception.GameNotFoundException;

import junit.framework.TestCase;

/**
 * @author ac010168
 *
 */
public class TestBGGParser extends TestCase {static class __CLR3_3_023i23ii96a1068{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525634799L,8589935092L,2912,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_cenqua_clover.TestNameSniffer __CLR3_3_0_TEST_NAME_SNIFFER=com_cenqua_clover.TestNameSniffer.NULL_INSTANCE;
  
  public final static long ABYSS_GAME_ID               = 155987L;
  public final static long COSMIC_ENCOUNTER_GAME_ID    = 39463L;
  public final static long COSMIC_INCURSION_GAME_ID    = 61001L;
  public final static long MAGIC_THE_GATHERING_GAME_ID = 463L;
  public final static long DC_DICE_MASTERS_GAME_ID     = 138649L;
  public final static long NOT_FOUND_GAME_ID           = 999999L;

  @Test
  public void testAbyssParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2718);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kih6b823i();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testAbyssParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2718,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kih6b823i(){try{__CLR3_3_023i23ii96a1068.R.inc(2718);
    __CLR3_3_023i23ii96a1068.R.inc(2719);System.out.println ("Launching Test testAbyssParser()!");
    
    __CLR3_3_023i23ii96a1068.R.inc(2720);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_ABYSS);
    
    __CLR3_3_023i23ii96a1068.R.inc(2721);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2722);System.out.println ("Processing Abyss...");
    __CLR3_3_023i23ii96a1068.R.inc(2723);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2724);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2725);try {
      __CLR3_3_023i23ii96a1068.R.inc(2726);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2727);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2728);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2729);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2730);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}
  
  @Test
  public void testCosmicEncounterParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2731);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_062yc1l23v();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testCosmicEncounterParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2731,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_062yc1l23v(){try{__CLR3_3_023i23ii96a1068.R.inc(2731);
    __CLR3_3_023i23ii96a1068.R.inc(2732);System.out.println ("Launching Test testCosmicEncounterParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2733);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_COSMIC_ENCOUNTER);
    
    __CLR3_3_023i23ii96a1068.R.inc(2734);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2735);System.out.println ("Processing Cosmic Encounter...");
    __CLR3_3_023i23ii96a1068.R.inc(2736);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2737);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2738);try {
      __CLR3_3_023i23ii96a1068.R.inc(2739);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2740);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2741);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2742);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2743);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testCosmicIncursionParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2744);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0e4xulg248();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testCosmicIncursionParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2744,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0e4xulg248(){try{__CLR3_3_023i23ii96a1068.R.inc(2744);
    __CLR3_3_023i23ii96a1068.R.inc(2745);System.out.println ("Launching Test testCosmicIncursionParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2746);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_COSMIC_INCURSION);
    
    __CLR3_3_023i23ii96a1068.R.inc(2747);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2748);System.out.println ("Processing Cosmic Incursion...");
    __CLR3_3_023i23ii96a1068.R.inc(2749);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2750);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2751);try {
      __CLR3_3_023i23ii96a1068.R.inc(2752);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2753);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2754);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2755);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2756);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testMagicTheGatheringParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2757);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0ulnphl24l();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testMagicTheGatheringParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2757,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0ulnphl24l(){try{__CLR3_3_023i23ii96a1068.R.inc(2757);
    __CLR3_3_023i23ii96a1068.R.inc(2758);System.out.println ("Launching Test testMagicTheGatheringParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2759);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_MAGIC_THE_GATHERING);
    
    __CLR3_3_023i23ii96a1068.R.inc(2760);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2761);System.out.println ("Processing Magic the Gathering...");
    __CLR3_3_023i23ii96a1068.R.inc(2762);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2763);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2764);try {
      __CLR3_3_023i23ii96a1068.R.inc(2765);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2766);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2767);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2768);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2769);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testDCDiceMastersParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2770);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0o417fl24y();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testDCDiceMastersParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2770,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0o417fl24y(){try{__CLR3_3_023i23ii96a1068.R.inc(2770);
    __CLR3_3_023i23ii96a1068.R.inc(2771);System.out.println ("Launching Test testDCDiceMastersParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2772);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_DC_DICE_MASTERS);
    
    __CLR3_3_023i23ii96a1068.R.inc(2773);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2774);System.out.println ("Processing DC Dice Masters...");
    __CLR3_3_023i23ii96a1068.R.inc(2775);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2776);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2777);try {
      __CLR3_3_023i23ii96a1068.R.inc(2778);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2779);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2780);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2781);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2782);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testNotFoundParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2783);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kqw63r25b();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testNotFoundParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2783,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kqw63r25b(){try{__CLR3_3_023i23ii96a1068.R.inc(2783);
    __CLR3_3_023i23ii96a1068.R.inc(2784);System.out.println ("Launching Test testNotFoundParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2785);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_NOT_FOUND);
    
    __CLR3_3_023i23ii96a1068.R.inc(2786);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2787);System.out.println ("Processing A Non-Existant Game...");
    __CLR3_3_023i23ii96a1068.R.inc(2788);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2789);try {
      __CLR3_3_023i23ii96a1068.R.inc(2790);BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2791);fail("This game should not have been found, this should be an error!");
    } catch (GameNotFoundException gnfe) { 
      __CLR3_3_023i23ii96a1068.R.inc(2792);assertNotNull("This is the only correct outcome for this test", gnfe.getMessage());
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2793);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2794);fail("Should not throw other errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2795);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}
  
  @Test
  public void testBGG53Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2796);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0cwezvw25o();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGG53Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2796,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0cwezvw25o(){try{__CLR3_3_023i23ii96a1068.R.inc(2796);
    __CLR3_3_023i23ii96a1068.R.inc(2797);System.out.println ("Launching Test testBGG53Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2798);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_53);
    
    __CLR3_3_023i23ii96a1068.R.inc(2799);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2800);System.out.println ("Processing Brauerei...");
    __CLR3_3_023i23ii96a1068.R.inc(2801);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2802);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2803);try {
      __CLR3_3_023i23ii96a1068.R.inc(2804);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2805);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2806);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2807);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2808);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGG1369Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2809);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0nokxob261();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGG1369Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2809,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0nokxob261(){try{__CLR3_3_023i23ii96a1068.R.inc(2809);
    __CLR3_3_023i23ii96a1068.R.inc(2810);System.out.println ("Launching Test testBGG1369Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2811);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_1369);
    
    __CLR3_3_023i23ii96a1068.R.inc(2812);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2813);System.out.println ("Processing Earthdefenders...");
    __CLR3_3_023i23ii96a1068.R.inc(2814);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2815);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2816);try {
      __CLR3_3_023i23ii96a1068.R.inc(2817);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2818);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2819);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2820);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2821);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGG1818Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2822);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_03hxiyk26e();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGG1818Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2822,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_03hxiyk26e(){try{__CLR3_3_023i23ii96a1068.R.inc(2822);
    __CLR3_3_023i23ii96a1068.R.inc(2823);System.out.println ("Launching Test testBGG1818Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2824);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_1818);
    
    __CLR3_3_023i23ii96a1068.R.inc(2825);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2826);System.out.println ("Processing Black Ice...");
    __CLR3_3_023i23ii96a1068.R.inc(2827);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2828);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2829);try {
      __CLR3_3_023i23ii96a1068.R.inc(2830);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2831);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2832);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2833);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2834);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}
  
  @Test
  public void testBGGMultiFullParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2835);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0y15k9u26r();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGGMultiFullParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2835,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0y15k9u26r(){try{__CLR3_3_023i23ii96a1068.R.inc(2835);
    __CLR3_3_023i23ii96a1068.R.inc(2836);System.out.println ("Launching Test testBGGMultiFullParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2837);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_12001_12020);
    
    __CLR3_3_023i23ii96a1068.R.inc(2838);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2839);System.out.println ("Processing List of 20 Games...");
    __CLR3_3_023i23ii96a1068.R.inc(2840);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2841);List<BGGGame> games = null;
    __CLR3_3_023i23ii96a1068.R.inc(2842);try {
      __CLR3_3_023i23ii96a1068.R.inc(2843);games = BGGGameParser.parseMultiBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2844);System.out.println ("The total games parsed from list is: " + games.size());
      __CLR3_3_023i23ii96a1068.R.inc(2845);for (BGGGame game : games) {{
        __CLR3_3_023i23ii96a1068.R.inc(2846);System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      }__CLR3_3_023i23ii96a1068.R.inc(2847);assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 20);
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2848);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2849);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2850);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGGMultiPartiallParser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2851);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_062djs6277();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGGMultiPartiallParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2851,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_062djs6277(){try{__CLR3_3_023i23ii96a1068.R.inc(2851);
    __CLR3_3_023i23ii96a1068.R.inc(2852);System.out.println ("Launching Test testBGGMultiPartiallParser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2853);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_BATCH_ALT);
    
    __CLR3_3_023i23ii96a1068.R.inc(2854);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2855);System.out.println ("Processing List of 17 Games...");
    __CLR3_3_023i23ii96a1068.R.inc(2856);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2857);List<BGGGame> games = null;
    __CLR3_3_023i23ii96a1068.R.inc(2858);try {
      __CLR3_3_023i23ii96a1068.R.inc(2859);games = BGGGameParser.parseMultiBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2860);System.out.println ("The total games parsed from list is: " + games.size());
      __CLR3_3_023i23ii96a1068.R.inc(2861);for (BGGGame game : games) {{
        __CLR3_3_023i23ii96a1068.R.inc(2862);System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      }__CLR3_3_023i23ii96a1068.R.inc(2863);assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 17);
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2864);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2865);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2866);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGGNested18460Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2867);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0vo9h1i27n();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGGNested18460Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2867,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0vo9h1i27n(){try{__CLR3_3_023i23ii96a1068.R.inc(2867);
    __CLR3_3_023i23ii96a1068.R.inc(2868);System.out.println ("Launching Test testBGGNested18460Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2869);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_NESTED_18460);
    
    __CLR3_3_023i23ii96a1068.R.inc(2870);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2871);System.out.println ("Processing List of 20 Games...");
    __CLR3_3_023i23ii96a1068.R.inc(2872);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2873);List<BGGGame> games = null;
    __CLR3_3_023i23ii96a1068.R.inc(2874);try {
      __CLR3_3_023i23ii96a1068.R.inc(2875);games = BGGGameParser.parseMultiBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2876);System.out.println ("The total games parsed from list is: " + games.size());
      __CLR3_3_023i23ii96a1068.R.inc(2877);for (BGGGame game : games) {{
        __CLR3_3_023i23ii96a1068.R.inc(2878);System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      }__CLR3_3_023i23ii96a1068.R.inc(2879);assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 20);
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2880);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2881);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2882);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGGMultiNest29663Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2883);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_09qb7zl283();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGGMultiNest29663Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2883,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_09qb7zl283(){try{__CLR3_3_023i23ii96a1068.R.inc(2883);
    __CLR3_3_023i23ii96a1068.R.inc(2884);System.out.println ("Launching Test testBGGMultiNest29663Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2885);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_MULTINEST_29663);
    
    __CLR3_3_023i23ii96a1068.R.inc(2886);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2887);System.out.println ("Processing List of 19 Games...");
    __CLR3_3_023i23ii96a1068.R.inc(2888);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2889);List<BGGGame> games = null;
    __CLR3_3_023i23ii96a1068.R.inc(2890);try {
      __CLR3_3_023i23ii96a1068.R.inc(2891);games = BGGGameParser.parseMultiBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2892);System.out.println ("The total games parsed from list is: " + games.size());
      __CLR3_3_023i23ii96a1068.R.inc(2893);for (BGGGame game : games) {{
        __CLR3_3_023i23ii96a1068.R.inc(2894);System.out.println ("  I parsed game content for " + game.getName() + " [bggid: " + 
            game.getBggID() + "]");
      }
      }__CLR3_3_023i23ii96a1068.R.inc(2895);assertTrue("I didn't get all the elements I was expecting: " + games.size(), games.size() == 19);
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2896);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2897);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2898);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}

  @Test
  public void testBGG50968Parser() {__CLR3_3_023i23ii96a1068.R.globalSliceStart(getClass().getName(),2899);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0yedzx228j();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_023i23ii96a1068.R.rethrow($CLV_t2$);}finally{__CLR3_3_023i23ii96a1068.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestBGGParser.testBGG50968Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2899,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0yedzx228j(){try{__CLR3_3_023i23ii96a1068.R.inc(2899);
    __CLR3_3_023i23ii96a1068.R.inc(2900);System.out.println ("Launching Test testBGG50968Parser()!");

    __CLR3_3_023i23ii96a1068.R.inc(2901);String xmlContent = MockGameData.generateContentString(MockGameData.BGG_50968);
    
    __CLR3_3_023i23ii96a1068.R.inc(2902);System.out.println ("------------------------------------------------------");
    //System.out.println (xmlContent);
    __CLR3_3_023i23ii96a1068.R.inc(2903);System.out.println ("Processing Gary Gygax's Living Fantasy...");
    __CLR3_3_023i23ii96a1068.R.inc(2904);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_023i23ii96a1068.R.inc(2905);BGGGame game = null;
    __CLR3_3_023i23ii96a1068.R.inc(2906);try {
      __CLR3_3_023i23ii96a1068.R.inc(2907);game = BGGGameParser.parseBGGXML(xmlContent);
      __CLR3_3_023i23ii96a1068.R.inc(2908);game.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_023i23ii96a1068.R.inc(2909);t.printStackTrace();
      __CLR3_3_023i23ii96a1068.R.inc(2910);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_023i23ii96a1068.R.inc(2911);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_023i23ii96a1068.R.flushNeeded();}}
}
