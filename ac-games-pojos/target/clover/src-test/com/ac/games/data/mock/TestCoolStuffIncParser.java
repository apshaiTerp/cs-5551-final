/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.mock;

import junit.framework.TestCase;

import org.junit.Test;

import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.parser.CoolStuffIncParser;
import com.ac.games.exception.GameNotFoundException;

/**
 * @author ac010168
 *
 */
public class TestCoolStuffIncParser extends TestCase {static class __CLR3_3_028w28wi96a1071{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525634799L,8589935092L,3094,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_cenqua_clover.TestNameSniffer __CLR3_3_0_TEST_NAME_SNIFFER=com_cenqua_clover.TestNameSniffer.NULL_INSTANCE;

  //http://www.coolstuffinc.com/p/203495
  public final static long ABYSS_GAME_ID       = 203495L;
  //http://www.coolstuffinc.com/p/136975
  public final static long COSMIC_ENCOUNTER_ID = 136975L;
  //http://www.coolstuffinc.com/p/136978
  public final static long COSMIC_INCURSION_ID = 136978L;
  //http://www.coolstuffinc.com/p/207653
  public final static long DC_DICE_MASTERS_ID  = 207653L;
  //http://www.coolstuffinc.com/p/999999
  public final static long NOT_FOUND_GAME_ID   = 999999L;
  //http://www.coolstuffinc.com/p/75069
  public final static long MTG_CARD_ID         = 75069L;
  //http://www.coolstuffinc.com/p/76069
  public final static long MTG_CARD_ID2        = 76097L;
  //http://www.coolstuffinc.com/p/94687
  public final static long MTG_APE_TOKEN_ID    = 94687L;
  //http://www.coolstuffinc.com/p/209542
  public final static long RPG_13TH_AGE_ID     = 209542L;
  //http://www.coolstuffinc.com/p/210682
  public final static long NETRUNNER_ID        = 210682L;
  //http://www.coolstuffinc.com/p/137910
  public final static long SUPPLIES_SLEEVES_ID = 137910L;
  //http://www/coolstuffinc.com/p/153126
  public final static long GIFT_CERTIFICATE_ID = 153126L;
  //http://www/coolstuffinc.com/p/169582
  public final static long VIDEO_GAME_ID       = 169582L;
  
  @Test
  public void testAbyssParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2912);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kih6b828w();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testAbyssParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2912,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kih6b828w(){try{__CLR3_3_028w28wi96a1071.R.inc(2912);
    __CLR3_3_028w28wi96a1071.R.inc(2913);System.out.println ("Launching Test testAbyssParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2914);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_ABYSS);
    
    __CLR3_3_028w28wi96a1071.R.inc(2915);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2916);System.out.println ("Processing Abyss...");
    __CLR3_3_028w28wi96a1071.R.inc(2917);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2918);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2919);try {
      __CLR3_3_028w28wi96a1071.R.inc(2920);data = CoolStuffIncParser.parseCSIHTML(htmlContent, ABYSS_GAME_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2921);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2922);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2923);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2924);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testCosmicEncounterParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2925);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_062yc1l299();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testCosmicEncounterParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2925,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_062yc1l299(){try{__CLR3_3_028w28wi96a1071.R.inc(2925);
    __CLR3_3_028w28wi96a1071.R.inc(2926);System.out.println ("Launching Test testCosmicEncounterParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2927);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_COSMIC_ENCOUNTER);
    
    __CLR3_3_028w28wi96a1071.R.inc(2928);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2929);System.out.println ("Processing Cosmic Encounter...");
    __CLR3_3_028w28wi96a1071.R.inc(2930);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2931);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2932);try {
      __CLR3_3_028w28wi96a1071.R.inc(2933);data = CoolStuffIncParser.parseCSIHTML(htmlContent, COSMIC_ENCOUNTER_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2934);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2935);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2936);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2937);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testCosmicIncursionParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2938);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0e4xulg29m();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testCosmicIncursionParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2938,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0e4xulg29m(){try{__CLR3_3_028w28wi96a1071.R.inc(2938);
    __CLR3_3_028w28wi96a1071.R.inc(2939);System.out.println ("Launching Test testCosmicIncursionParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2940);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_COSMIC_INCURSION);
    
    __CLR3_3_028w28wi96a1071.R.inc(2941);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2942);System.out.println ("Processing Cosmic Incursion...");
    __CLR3_3_028w28wi96a1071.R.inc(2943);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2944);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2945);try {
      __CLR3_3_028w28wi96a1071.R.inc(2946);data = CoolStuffIncParser.parseCSIHTML(htmlContent, COSMIC_INCURSION_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2947);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2948);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2949);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2950);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}
  
  @Test
  public void testDCDiceMastersParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2951);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0o417fl29z();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testDCDiceMastersParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2951,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0o417fl29z(){try{__CLR3_3_028w28wi96a1071.R.inc(2951);
    __CLR3_3_028w28wi96a1071.R.inc(2952);System.out.println ("Launching Test testDCDiceMastersParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2953);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_DC_DICE_MASTERS);
    
    __CLR3_3_028w28wi96a1071.R.inc(2954);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2955);System.out.println ("Processing DC Dice Masters...");
    __CLR3_3_028w28wi96a1071.R.inc(2956);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2957);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2958);try {
      __CLR3_3_028w28wi96a1071.R.inc(2959);data = CoolStuffIncParser.parseCSIHTML(htmlContent, DC_DICE_MASTERS_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2960);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2961);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2962);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2963);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testNotFoundParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2964);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kqw63r2ac();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testNotFoundParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2964,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kqw63r2ac(){try{__CLR3_3_028w28wi96a1071.R.inc(2964);
    __CLR3_3_028w28wi96a1071.R.inc(2965);System.out.println ("Launching Test testNotFoundParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2966);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_NOT_FOUND);
    
    __CLR3_3_028w28wi96a1071.R.inc(2967);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2968);System.out.println ("Processing A Non-Existant Game...");
    __CLR3_3_028w28wi96a1071.R.inc(2969);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2970);try {
      __CLR3_3_028w28wi96a1071.R.inc(2971);CoolStuffIncParser.parseCSIHTML(htmlContent, NOT_FOUND_GAME_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2972);fail("This game should not have been found, this should be an error!");
    } catch (GameNotFoundException gnfe) { 
      __CLR3_3_028w28wi96a1071.R.inc(2973);assertNotNull("This is the only correct outcome for this test", gnfe.getMessage());
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2974);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2975);fail("Should not throw other errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2976);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}
  
  @Test
  public void testMTG75069Parser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2977);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0nkt2qb2ap();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testMTG75069Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2977,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0nkt2qb2ap(){try{__CLR3_3_028w28wi96a1071.R.inc(2977);
    __CLR3_3_028w28wi96a1071.R.inc(2978);System.out.println ("Launching Test testMTG75069Parser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2979);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_75069);
    
    __CLR3_3_028w28wi96a1071.R.inc(2980);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2981);System.out.println ("Processing Executioner's Hood...");
    __CLR3_3_028w28wi96a1071.R.inc(2982);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2983);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2984);try {
      __CLR3_3_028w28wi96a1071.R.inc(2985);data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_CARD_ID);
      __CLR3_3_028w28wi96a1071.R.inc(2986);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(2987);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(2988);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(2989);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testMTG76097Parser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),2990);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0mm0gt52b2();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testMTG76097Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),2990,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0mm0gt52b2(){try{__CLR3_3_028w28wi96a1071.R.inc(2990);
    __CLR3_3_028w28wi96a1071.R.inc(2991);System.out.println ("Launching Test testMTG76097Parser()!");

    __CLR3_3_028w28wi96a1071.R.inc(2992);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_76097);
    
    __CLR3_3_028w28wi96a1071.R.inc(2993);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(2994);System.out.println ("Processing Karador, Ghost Chieftain (Oversized Foil)...");
    __CLR3_3_028w28wi96a1071.R.inc(2995);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(2996);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(2997);try {
      __CLR3_3_028w28wi96a1071.R.inc(2998);data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_CARD_ID2);
      __CLR3_3_028w28wi96a1071.R.inc(2999);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3000);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3001);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3002);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testMTG94687Parser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3003);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0d9n1ma2bf();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testMTG94687Parser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3003,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0d9n1ma2bf(){try{__CLR3_3_028w28wi96a1071.R.inc(3003);
    __CLR3_3_028w28wi96a1071.R.inc(3004);System.out.println ("Launching Test testMTG94687Parser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3005);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_94687);
    
    __CLR3_3_028w28wi96a1071.R.inc(3006);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3007);System.out.println ("Processing Ape (Token)...");
    __CLR3_3_028w28wi96a1071.R.inc(3008);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3009);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3010);try {
      __CLR3_3_028w28wi96a1071.R.inc(3011);data = CoolStuffIncParser.parseCSIHTML(htmlContent, MTG_APE_TOKEN_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3012);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3013);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3014);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3015);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testRPGParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3016);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0ufwcxp2bs();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testRPGParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3016,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0ufwcxp2bs(){try{__CLR3_3_028w28wi96a1071.R.inc(3016);
    __CLR3_3_028w28wi96a1071.R.inc(3017);System.out.println ("Launching Test testRPGParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3018);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_RPG);
    
    __CLR3_3_028w28wi96a1071.R.inc(3019);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3020);System.out.println ("Processing 13th Age: Eyes of the Stone Thief Hardcover...");
    __CLR3_3_028w28wi96a1071.R.inc(3021);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3022);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3023);try {
      __CLR3_3_028w28wi96a1071.R.inc(3024);data = CoolStuffIncParser.parseCSIHTML(htmlContent, RPG_13TH_AGE_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3025);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3026);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3027);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3028);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testLCGNetrunnerParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3029);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0bagjf92c5();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testLCGNetrunnerParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3029,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0bagjf92c5(){try{__CLR3_3_028w28wi96a1071.R.inc(3029);
    __CLR3_3_028w28wi96a1071.R.inc(3030);System.out.println ("Launching Test testLCGNetrunnerParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3031);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_LCG_NETRUNNER);
    
    __CLR3_3_028w28wi96a1071.R.inc(3032);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3033);System.out.println ("Processing Netrunner...");
    __CLR3_3_028w28wi96a1071.R.inc(3034);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3035);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3036);try {
      __CLR3_3_028w28wi96a1071.R.inc(3037);data = CoolStuffIncParser.parseCSIHTML(htmlContent, NETRUNNER_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3038);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3039);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3040);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3041);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testSuppliesSleevesParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3042);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0c1bo5q2ci();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testSuppliesSleevesParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3042,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0c1bo5q2ci(){try{__CLR3_3_028w28wi96a1071.R.inc(3042);
    __CLR3_3_028w28wi96a1071.R.inc(3043);System.out.println ("Launching Test testSuppliesSleevesParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3044);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_SUPPLIES_SLEEVES);
    
    __CLR3_3_028w28wi96a1071.R.inc(3045);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3046);System.out.println ("Processing 7 Wonders Sleeves...");
    __CLR3_3_028w28wi96a1071.R.inc(3047);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3048);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3049);try {
      __CLR3_3_028w28wi96a1071.R.inc(3050);data = CoolStuffIncParser.parseCSIHTML(htmlContent, SUPPLIES_SLEEVES_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3051);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3052);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3053);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3054);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}
  
  @Test
  public void testMiniaturesParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3055);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0u1hpxp2cv();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testMiniaturesParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3055,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0u1hpxp2cv(){try{__CLR3_3_028w28wi96a1071.R.inc(3055);
    __CLR3_3_028w28wi96a1071.R.inc(3056);System.out.println ("Launching Test testMiniaturesParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3057);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_MINIATURES);
    
    __CLR3_3_028w28wi96a1071.R.inc(3058);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3059);System.out.println ("Processing Dragon Collector's Set Sleeves...");
    __CLR3_3_028w28wi96a1071.R.inc(3060);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3061);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3062);try {
      __CLR3_3_028w28wi96a1071.R.inc(3063);data = CoolStuffIncParser.parseCSIHTML(htmlContent, SUPPLIES_SLEEVES_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3064);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3065);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3066);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3067);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}

  @Test
  public void testGiftCertificateParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3068);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_02x6g0r2d8();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testGiftCertificateParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3068,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_02x6g0r2d8(){try{__CLR3_3_028w28wi96a1071.R.inc(3068);
    __CLR3_3_028w28wi96a1071.R.inc(3069);System.out.println ("Launching Test testGiftCertificateParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3070);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_GIFT_CERTIFICATE);
    
    __CLR3_3_028w28wi96a1071.R.inc(3071);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3072);System.out.println ("Processing Gift Certificate...");
    __CLR3_3_028w28wi96a1071.R.inc(3073);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3074);try {
      __CLR3_3_028w28wi96a1071.R.inc(3075);CoolStuffIncParser.parseCSIHTML(htmlContent, GIFT_CERTIFICATE_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3076);fail("This game should not have been found, this should be an error!");
    } catch (GameNotFoundException gnfe) { 
      __CLR3_3_028w28wi96a1071.R.inc(3077);assertNotNull("This is the only correct outcome for this test", gnfe.getMessage());
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3078);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3079);fail("Should not throw other errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3080);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}
  
  @Test
  public void testVideoGamesParser() {__CLR3_3_028w28wi96a1071.R.globalSliceStart(getClass().getName(),3081);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR3_3_0kkq6n62dl();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR3_3_028w28wi96a1071.R.rethrow($CLV_t2$);}finally{__CLR3_3_028w28wi96a1071.R.globalSliceEnd(getClass().getName(),"com.ac.games.data.mock.TestCoolStuffIncParser.testVideoGamesParser",__CLR3_3_0_TEST_NAME_SNIFFER.getTestName(),3081,$CLV_p$,$CLV_t$);}}private void  __CLR3_3_0kkq6n62dl(){try{__CLR3_3_028w28wi96a1071.R.inc(3081);
    __CLR3_3_028w28wi96a1071.R.inc(3082);System.out.println ("Launching Test testVideoGamesParser()!");

    __CLR3_3_028w28wi96a1071.R.inc(3083);String htmlContent = MockGameData.generateContentString(MockGameData.CSI_VIDEO_GAME);
    
    __CLR3_3_028w28wi96a1071.R.inc(3084);System.out.println ("------------------------------------------------------");
    //System.out.println (htmlContent);
    __CLR3_3_028w28wi96a1071.R.inc(3085);System.out.println ("Processing 50 Cent Blood on the Sand...");
    __CLR3_3_028w28wi96a1071.R.inc(3086);System.out.println ("------------------------------------------------------");
    
    __CLR3_3_028w28wi96a1071.R.inc(3087);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    __CLR3_3_028w28wi96a1071.R.inc(3088);try {
      __CLR3_3_028w28wi96a1071.R.inc(3089);data = CoolStuffIncParser.parseCSIHTML(htmlContent, VIDEO_GAME_ID);
      __CLR3_3_028w28wi96a1071.R.inc(3090);data.printContentsForDebug();
    } catch (Throwable t) {
      __CLR3_3_028w28wi96a1071.R.inc(3091);t.printStackTrace();
      __CLR3_3_028w28wi96a1071.R.inc(3092);fail("Should not throw errors: " + t.getMessage());
    }
    
    __CLR3_3_028w28wi96a1071.R.inc(3093);assertTrue("The world didn't end during this test", true);
  }finally{__CLR3_3_028w28wi96a1071.R.flushNeeded();}}
}
