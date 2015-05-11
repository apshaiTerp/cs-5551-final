/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.db.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ac.games.data.BGGGame;
import com.ac.games.data.BGGGameStats;
import com.ac.games.data.CSIDataStats;
import com.ac.games.data.Collection;
import com.ac.games.data.CollectionItem;
import com.ac.games.data.CoolStuffIncCategory;
import com.ac.games.data.CoolStuffIncPriceData;
import com.ac.games.data.Game;
import com.ac.games.data.GameAvailability;
import com.ac.games.data.GameReltn;
import com.ac.games.data.GameType;
import com.ac.games.data.GameWeight;
import com.ac.games.data.MMDataStats;
import com.ac.games.data.MiniatureMarketCategory;
import com.ac.games.data.MiniatureMarketPriceData;
import com.ac.games.data.ReviewState;
import com.ac.games.data.User;
import com.ac.games.data.UserDetail;
import com.ac.games.data.UserRole;

/**
 * This class helps us create Mock Data in our test categories
 * @author ac010168
 */
public class MockDataFactory {public static class __CLR3_3_038i38ii96a4z0h{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0064\u0062\u002d\u006d\u006f\u006e\u0067\u006f\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525819932L,8589935092L,4852,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}

  /** Static ID for Abyss */
  public final static long BGG_ABYSS_ID = 155987L;
  /** Static ID for Cosmic Encounter */
  public final static long BGG_COSMIC_ENCOUNTER_ID = 39463L;
  /** Static ID for Cosmic Incursion */
  public final static long BGG_COSMIC_INCURSION_ID = 61001L;
  
  /** Static ID for Abyss */
  public final static long CSI_ABYSS_ID = 203495L;
  /** Static ID for Cosmic Encounter */
  public final static long CSI_COSMIC_ENCOUNTER_ID = 136975L;
  /** Static ID for Cosmic Incursion */
  public final static long CSI_COSMIC_INCURSION_ID = 136978L;
  
  /** Static ID for Abyss */
  public final static long MM_ABYSS_ID = 40693L;
  /** Static ID for Cosmic Encounter */
  public final static long MM_COSMIC_ENCOUNTER_ID = 15138L;
  /** Static ID for Cosmic Incursion */
  public final static long MM_COSMIC_INCURSION_ID = 15102L;
  
  /** Non-Intelligent ID for Abyss Game */
  public final static long ABYSS_ID = 1234L;
  /** Non-Intelligent ID for Cosmic Encounte Game */
  public final static long COSMIC_ENCOUNTER_ID = 2345L;
  /** Non-Intelligent ID for Cosmic Incursion Game */
  public final static long COSMIC_INCURSION_ID = 3456L;
  
  /** Non-Intelligent ID for Abyss Game Relation */
  public final static long ABYSS_RELTN_ID = 1234L;
  /** Non-Intelligent ID for Cosmic Encounte Game Relation */
  public final static long COSMIC_ENCOUNTER_RELTN_ID = 2345L;
  /** Non-Intelligent ID for Cosmic Incursion Game Relation */
  public final static long COSMIC_INCURSION_RELTN_ID = 3456L;
  
  /** Non-Intelligent ID for Fake User 1 */
  public final static long USER_ONE_ID   = 1122L;
  /** Non-Intelligent ID for Fake User 2 */
  public final static long USER_TWO_ID   = 1123L;
  /** Non-Intelligent ID for Fake User 3 */
  public final static long USER_THREE_ID = 1124L;
  
  /** Non-Intelligent ID for Fake Collection 1 */
  public final static long COLLECTION_ONE_ID   = 2233L;
  /** Non-Intelligent ID for Fake Collection 2 */
  public final static long COLLECTION_TWO_ID   = 2234L;
  /** Non-Intelligent ID for Fake Collection 3 */
  public final static long COLLECTION_THREE_ID = 2235L;
  
  /** Non-Intelligent ID for Fake Collection 1 */
  public final static long COLLECTION_ITEM_ONE_ID   = 4455L;
  /** Non-Intelligent ID for Fake Collection 2 */
  public final static long COLLECTION_ITEM_TWO_ID   = 4456L;
  /** Non-Intelligent ID for Fake Collection 3 */
  public final static long COLLECTION_ITEM_THREE_ID = 4457L;
  
  /** Helper method to generate some game data to be used for validation */
  public static BGGGame createBGGGame(long gameID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4194);
    __CLR3_3_038i38ii96a4z0h.R.inc(4195);if ((((gameID == BGG_ABYSS_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4196)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4197)==0&false)))            {__CLR3_3_038i38ii96a4z0h.R.inc(4198);return createAbyssGame();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4199);if ((((gameID == BGG_COSMIC_ENCOUNTER_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4200)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4201)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4202);return createCosmicEncounterGame();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4203);if ((((gameID == BGG_COSMIC_INCURSION_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4204)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4205)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4206);return createCosmicIncursionGame();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4207);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static BGGGame createAbyssGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4208);
    __CLR3_3_038i38ii96a4z0h.R.inc(4209);BGGGame abyssGame = new BGGGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4210);abyssGame.setBggID(BGG_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4211);abyssGame.setName("Abyss");
    __CLR3_3_038i38ii96a4z0h.R.inc(4212);abyssGame.setYearPublished(2014);
    __CLR3_3_038i38ii96a4z0h.R.inc(4213);abyssGame.setMinPlayers(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4214);abyssGame.setMaxPlayers(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4215);abyssGame.setMinPlayingTime(45);
    __CLR3_3_038i38ii96a4z0h.R.inc(4216);abyssGame.setMaxPlayingTime(45);
    __CLR3_3_038i38ii96a4z0h.R.inc(4217);abyssGame.setImageURL("http://cf.geekdo-images.com/images/pic1965255.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4218);abyssGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic1965255_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4219);abyssGame.setDescription("The Abyss power is once again vacant, so the time has come to get your hands on the throne and its privileges. Use all of your cunning to win or buy votes in the Council. Recruit the most influential Lords and abuse their powers to take control of the most strategic territories. Finally, impose yourself as the only one able to rule the Abyssal people!\n\nAbyss is a game of development, combination and collection in which players try to take control of strategic locations in an underwater city. To achieve this, players must develop on three levels: first by collecting allies, then using them to recruit Lords of the Abyss, who will then grant access to different parts of the city. Players acquire cards through a draft of sorts, and the Lords of the Abyss acquired on those cards grant special powers to the cardholder - but once you use the cards to acquire a location, that power is shut off, so players need to time their land grabs well in order to put themselves in the best position for when the game ends.");
    __CLR3_3_038i38ii96a4z0h.R.inc(4220);abyssGame.setBggRating(7.412);
    __CLR3_3_038i38ii96a4z0h.R.inc(4221);abyssGame.setBggRatingUsers(1405);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4222);List<String> publishers = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4223);publishers.add("Bombyx");
    __CLR3_3_038i38ii96a4z0h.R.inc(4224);publishers.add("Asmodee");
    __CLR3_3_038i38ii96a4z0h.R.inc(4225);publishers.add("Asterion Press");
    __CLR3_3_038i38ii96a4z0h.R.inc(4226);publishers.add("REBEL.pl");
    __CLR3_3_038i38ii96a4z0h.R.inc(4227);abyssGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4228);List<String> designers = new ArrayList<String>(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4229);designers.add("Bruno Cathala");
    __CLR3_3_038i38ii96a4z0h.R.inc(4230);designers.add("Charles Chevallier");
    __CLR3_3_038i38ii96a4z0h.R.inc(4231);abyssGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4232);List<String> categories = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4233);categories.add("Card Game");
    __CLR3_3_038i38ii96a4z0h.R.inc(4234);categories.add("Mythology");
    __CLR3_3_038i38ii96a4z0h.R.inc(4235);categories.add("Nautical");
    __CLR3_3_038i38ii96a4z0h.R.inc(4236);abyssGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4237);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4238);mechanisms.add("Auction/Bidding");
    __CLR3_3_038i38ii96a4z0h.R.inc(4239);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4240);mechanisms.add("Set Collection");
    __CLR3_3_038i38ii96a4z0h.R.inc(4241);abyssGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4242);abyssGame.setGameType(GameType.BASE);
    __CLR3_3_038i38ii96a4z0h.R.inc(4243);abyssGame.setBggRank(412);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4244);abyssGame.setReviewState(ReviewState.REVIEWED);
    __CLR3_3_038i38ii96a4z0h.R.inc(4245);abyssGame.setAddDate(new Date (new Date().getTime() - 10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4246);abyssGame.setReviewDate(new Date());
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4247);return abyssGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static BGGGame createCosmicEncounterGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4248);
    __CLR3_3_038i38ii96a4z0h.R.inc(4249);BGGGame cosmicGame = new BGGGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4250);cosmicGame.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4251);cosmicGame.setName("Cosmic Encounter");
    __CLR3_3_038i38ii96a4z0h.R.inc(4252);cosmicGame.setYearPublished(2008);
    __CLR3_3_038i38ii96a4z0h.R.inc(4253);cosmicGame.setMinPlayers(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4254);cosmicGame.setMaxPlayers(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4255);cosmicGame.setMinPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4256);cosmicGame.setMaxPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4257);cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic354780.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4258);cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic354780_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4259);cosmicGame.setDescription("From the Manufacturer\n\nBuild a galactic empire... In the depths of space, the alien races of the Cosmos vie with each other for control of the universe. Alliances form and shift from moment to moment, while cataclysmic battles send starships screaming into the warp.  Players choose from dozens of alien races, each with its own unique power to further its efforts to build an empire that spans the galaxy.\n\nMany classic aliens from earlier editions of this beloved game return, such as the Oracle, the Loser, and the Clone. Newly discovered aliens also join the fray, including Remora, Mite, and Tick-Tock.  This classic game of alien politics returns from the warp once more.\n\nIn Cosmic Encounter, each player is the leader of an alien race. On a player's turn, he or she becomes the offense.  The offense encounters another player on a planet by moving a group of his or her ships through the hyperspace gate to that planet.  The offense draws from the destiny deck which contains colors, wilds and specials.  He or she then takes the hyperspace gate and points at one planet in the system indicated by the drawn destiny card.  The offense vs. the defenses ships are in the encounter and both sides are able to invite allies, play an encounter card as well as special cards to try and tip the encounter in their favor.\n\nThe object of the game is to establish colonies in other players' planetary systems. Players take turns trying to establish colonies. The winner(s) are the first player(s) to have five colonies on any planets outside his or her home system. A player does not need to have colonies in all of the systems, just colonies on five planets outside his or her home system. These colonies may all be in one system or scattered over multiple systems. The players must use force, cunning, and diplomacy to ensure their victory.");
    __CLR3_3_038i38ii96a4z0h.R.inc(4260);cosmicGame.setBggRating(7.58417);
    __CLR3_3_038i38ii96a4z0h.R.inc(4261);cosmicGame.setBggRatingUsers(12054);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4262);List<String> publishers = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4263);publishers.add("Arclight");
    __CLR3_3_038i38ii96a4z0h.R.inc(4264);publishers.add("Asterion Press");
    __CLR3_3_038i38ii96a4z0h.R.inc(4265);publishers.add("Edge Entertainment");
    __CLR3_3_038i38ii96a4z0h.R.inc(4266);publishers.add("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4267);publishers.add("Heidelberger Spieleverlag");
    __CLR3_3_038i38ii96a4z0h.R.inc(4268);cosmicGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4269);List<String> designers = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4270);designers.add("Bill Eberle");
    __CLR3_3_038i38ii96a4z0h.R.inc(4271);designers.add("Jack Kittredge");
    __CLR3_3_038i38ii96a4z0h.R.inc(4272);designers.add("Bill Norton");
    __CLR3_3_038i38ii96a4z0h.R.inc(4273);designers.add("Peter Olotka");
    __CLR3_3_038i38ii96a4z0h.R.inc(4274);designers.add("Kevin Wilson");
    __CLR3_3_038i38ii96a4z0h.R.inc(4275);cosmicGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4276);List<String> categories = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4277);categories.add("Bluffing");
    __CLR3_3_038i38ii96a4z0h.R.inc(4278);categories.add("Negotiation");
    __CLR3_3_038i38ii96a4z0h.R.inc(4279);categories.add("Science Fiction");
    __CLR3_3_038i38ii96a4z0h.R.inc(4280);categories.add("Space Exploration");
    __CLR3_3_038i38ii96a4z0h.R.inc(4281);cosmicGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4282);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4283);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4284);mechanisms.add("Partnerships");
    __CLR3_3_038i38ii96a4z0h.R.inc(4285);mechanisms.add("Variable Player Powers");
    __CLR3_3_038i38ii96a4z0h.R.inc(4286);cosmicGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4287);cosmicGame.setGameType(GameType.BASE);
    __CLR3_3_038i38ii96a4z0h.R.inc(4288);cosmicGame.setBggRank(74);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4289);List<Long> expansions = new ArrayList<Long>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4290);expansions.add(114276L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4291);expansions.add(87507L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4292);expansions.add(153971L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4293);expansions.add(61001L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4294);expansions.add(143760L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4295);cosmicGame.setExpansionIDs(expansions);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4296);return cosmicGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static BGGGame createCosmicIncursionGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4297);
    __CLR3_3_038i38ii96a4z0h.R.inc(4298);BGGGame cosmicGame = new BGGGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4299);cosmicGame.setBggID(BGG_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4300);cosmicGame.setName("Cosmic Encounter: Cosmic Incursion");
    __CLR3_3_038i38ii96a4z0h.R.inc(4301);cosmicGame.setYearPublished(2010);
    __CLR3_3_038i38ii96a4z0h.R.inc(4302);cosmicGame.setMinPlayers(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4303);cosmicGame.setMaxPlayers(6);
    __CLR3_3_038i38ii96a4z0h.R.inc(4304);cosmicGame.setMinPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4305);cosmicGame.setMaxPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4306);cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic657393.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4307);cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic657393_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4308);cosmicGame.setDescription("Adapted from the Fantasy Flight web site:\n\nOver the years, alien empires have risen and fallen. The Vacuum has failed to eliminate the Zombie, the Virus has spread far and wide, and the Loser has turned defeat into victory. 50 different species have tried to conquer the galaxy, and each have made their mark on the universe. Their warring has not gone unnoticed.\n\n20 new alien cultures are now racing towards the site of the conflict. They each want to carve out their own piece of the galaxy for themselves. The aliens may be familiar to some of you (reprints of past favorites), or are aliens no one has ever seen before. The first on our list is a blast from the past; the Sniveler!\n\nIn addition, this expansion includes additions to the Cosmic Encounter universe. From the game-changing Cosmic Quakes to the bounties held within the Reward deck, these additions are sure to spice up your quest for galactic dominance.\n\nEvery game has seen five races converge to do battle for control of an empire. Now, the galaxy gets crowded. A sixth race appears to do battle, and the sixth member of your play group is able to join you. Cosmic Incursion allows a sixth player to get in on the fun.\n\nCosmic Encounter puts you in charge of the fate of an alien race. Each flavor of extraterrestrial strives to be the first to conquer five enemy colonies and establish themselves as the dominant life form. Every faction has a unique power, a power they intend to use to crush their enemies. With over 50 aliens to choose from no two games will be the same.");
    __CLR3_3_038i38ii96a4z0h.R.inc(4309);cosmicGame.setBggRating(8.27179);
    __CLR3_3_038i38ii96a4z0h.R.inc(4310);cosmicGame.setBggRatingUsers(1781);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4311);List<String> publishers = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4312);publishers.add("Arclight");
    __CLR3_3_038i38ii96a4z0h.R.inc(4313);publishers.add("Edge Entertainment");
    __CLR3_3_038i38ii96a4z0h.R.inc(4314);publishers.add("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4315);publishers.add("Heidelberger Spieleverlag");
    __CLR3_3_038i38ii96a4z0h.R.inc(4316);cosmicGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4317);List<String> designers = new ArrayList<String>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4318);designers.add("Kevin Wilson");
    __CLR3_3_038i38ii96a4z0h.R.inc(4319);cosmicGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4320);List<String> categories = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4321);categories.add("Bluffing");
    __CLR3_3_038i38ii96a4z0h.R.inc(4322);categories.add("Negotiation");
    __CLR3_3_038i38ii96a4z0h.R.inc(4323);categories.add("Expansion for Base-game");
    __CLR3_3_038i38ii96a4z0h.R.inc(4324);categories.add("Science Fiction");
    __CLR3_3_038i38ii96a4z0h.R.inc(4325);categories.add("Space Exploration");
    __CLR3_3_038i38ii96a4z0h.R.inc(4326);cosmicGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4327);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4328);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4329);mechanisms.add("Partnerships");
    __CLR3_3_038i38ii96a4z0h.R.inc(4330);mechanisms.add("Variable Player Powers");
    __CLR3_3_038i38ii96a4z0h.R.inc(4331);cosmicGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4332);cosmicGame.setGameType(GameType.EXPANSION);
    __CLR3_3_038i38ii96a4z0h.R.inc(4333);cosmicGame.setParentGameID(BGG_COSMIC_ENCOUNTER_ID);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4334);return cosmicGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  /** Helper method to generate some game data to be used for validation */
  public static CoolStuffIncPriceData createCSIData(long csiID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4335);
    __CLR3_3_038i38ii96a4z0h.R.inc(4336);if ((((csiID == CSI_ABYSS_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4337)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4338)==0&false)))            {__CLR3_3_038i38ii96a4z0h.R.inc(4339);return createCSIAbyssData();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4340);if ((((csiID == CSI_COSMIC_ENCOUNTER_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4341)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4342)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4343);return createCSICosmicEncounterData();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4344);if ((((csiID == CSI_COSMIC_INCURSION_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4345)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4346)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4347);return createCSICosmicIncursionData();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4348);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static CoolStuffIncPriceData createCSIAbyssData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4349);
    __CLR3_3_038i38ii96a4z0h.R.inc(4350);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4351);data.setCsiID(CSI_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4352);data.setTitle("Abyss");
    __CLR3_3_038i38ii96a4z0h.R.inc(4353);data.setPublisher("Asmodee Editions");
    __CLR3_3_038i38ii96a4z0h.R.inc(4354);data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4355);data.setSku("ASMABY01US");
    __CLR3_3_038i38ii96a4z0h.R.inc(4356);data.setImageURL("http://a4.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Asmodee%20Editions/full/ASMABY01US.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4357);data.setAvailability(GameAvailability.INSTOCK);
    __CLR3_3_038i38ii96a4z0h.R.inc(4358);data.setReleaseDate(null);
    __CLR3_3_038i38ii96a4z0h.R.inc(4359);data.setMsrpValue(59.99);
    __CLR3_3_038i38ii96a4z0h.R.inc(4360);data.setCurPrice(40.99);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4361);data.setReviewState(ReviewState.REVIEWED);
    __CLR3_3_038i38ii96a4z0h.R.inc(4362);data.setAddDate(new Date (new Date().getTime() - 10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4363);data.setReviewDate(new Date());
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4364);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static CoolStuffIncPriceData createCSICosmicEncounterData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4365);
    __CLR3_3_038i38ii96a4z0h.R.inc(4366);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4367);data.setCsiID(CSI_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4368);data.setTitle("Cosmic Encounter Board Game");
    __CLR3_3_038i38ii96a4z0h.R.inc(4369);data.setPublisher("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4370);data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4371);data.setSku("FFGCE01");
    __CLR3_3_038i38ii96a4z0h.R.inc(4372);data.setImageURL("http://a1.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Fantasy%20Flight%20Games/full/FFGCosmicEncounter.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4373);data.setAvailability(GameAvailability.PREORDER);
    __CLR3_3_038i38ii96a4z0h.R.inc(4374);data.setReleaseDate("First quarter 2015");
    __CLR3_3_038i38ii96a4z0h.R.inc(4375);data.setMsrpValue(59.95);
    __CLR3_3_038i38ii96a4z0h.R.inc(4376);data.setCurPrice(41.49);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4377);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static CoolStuffIncPriceData createCSICosmicIncursionData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4378);
    __CLR3_3_038i38ii96a4z0h.R.inc(4379);CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4380);data.setCsiID(CSI_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4381);data.setTitle("Cosmic Encounter: Cosmic Incursion Expansion");
    __CLR3_3_038i38ii96a4z0h.R.inc(4382);data.setPublisher("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4383);data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4384);data.setSku("FFGCE02");
    __CLR3_3_038i38ii96a4z0h.R.inc(4385);data.setImageURL("http://a5.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Fantasy%20Flight%20Games/full/ffg_cosmicencounterCosmicIncursion.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4386);data.setAvailability(GameAvailability.OUTOFSTOCK);
    __CLR3_3_038i38ii96a4z0h.R.inc(4387);data.setReleaseDate(null);
    //data.setMsrpValue(0.0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4388);data.setCurPrice(16.99);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4389);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  /** Helper method to generate some game data to be used for validation */
  public static MiniatureMarketPriceData createMMData(long mmID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4390);
    __CLR3_3_038i38ii96a4z0h.R.inc(4391);if ((((mmID == MM_ABYSS_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4392)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4393)==0&false)))            {__CLR3_3_038i38ii96a4z0h.R.inc(4394);return createMMAbyssData();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4395);if ((((mmID == MM_COSMIC_ENCOUNTER_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4396)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4397)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4398);return createMMCosmicEncounterData();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4399);if ((((mmID == MM_COSMIC_INCURSION_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4400)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4401)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4402);return createMMCosmicIncursionData();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4403);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static MiniatureMarketPriceData createMMAbyssData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4404);
    __CLR3_3_038i38ii96a4z0h.R.inc(4405);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4406);data.setMmID(MM_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4407);data.setTitle("Abyss");
    __CLR3_3_038i38ii96a4z0h.R.inc(4408);data.setManufacturer("Asmodee");
    __CLR3_3_038i38ii96a4z0h.R.inc(4409);data.setSku("ASMABY01US");
    __CLR3_3_038i38ii96a4z0h.R.inc(4410);data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4411);data.setImageURL("http://a4.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Asmodee%20Editions/full/ASMABY01US.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4412);data.setAvailability(GameAvailability.INSTOCK);
    __CLR3_3_038i38ii96a4z0h.R.inc(4413);data.setMsrpValue(59.99);
    __CLR3_3_038i38ii96a4z0h.R.inc(4414);data.setCurPrice(41.39);

    __CLR3_3_038i38ii96a4z0h.R.inc(4415);data.setReviewState(ReviewState.REVIEWED);
    __CLR3_3_038i38ii96a4z0h.R.inc(4416);data.setAddDate(new Date (new Date().getTime() - 10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4417);data.setReviewDate(new Date());

    __CLR3_3_038i38ii96a4z0h.R.inc(4418);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static MiniatureMarketPriceData createMMCosmicEncounterData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4419);
    __CLR3_3_038i38ii96a4z0h.R.inc(4420);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4421);data.setMmID(MM_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4422);data.setTitle("Cosmic Encounter");
    __CLR3_3_038i38ii96a4z0h.R.inc(4423);data.setManufacturer("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4424);data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4425);data.setSku("FFGCE01");
    __CLR3_3_038i38ii96a4z0h.R.inc(4426);data.setImageURL("http://cdn.miniaturemarket.com/media/catalog/product/f/f/ffgce01.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4427);data.setAvailability(GameAvailability.OUTOFSTOCK);
    __CLR3_3_038i38ii96a4z0h.R.inc(4428);data.setMsrpValue(59.95);
    __CLR3_3_038i38ii96a4z0h.R.inc(4429);data.setCurPrice(41.37);

    __CLR3_3_038i38ii96a4z0h.R.inc(4430);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static MiniatureMarketPriceData createMMCosmicIncursionData() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4431);
    __CLR3_3_038i38ii96a4z0h.R.inc(4432);MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4433);data.setMmID(MM_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4434);data.setTitle("Cosmic Encounter Cosmic Incursion Expansion");
    __CLR3_3_038i38ii96a4z0h.R.inc(4435);data.setManufacturer("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4436);data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    __CLR3_3_038i38ii96a4z0h.R.inc(4437);data.setSku("FFGCE02");
    __CLR3_3_038i38ii96a4z0h.R.inc(4438);data.setImageURL("http://cdn.miniaturemarket.com/media/catalog/product/F/F/FFGCE02.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4439);data.setAvailability(GameAvailability.OUTOFSTOCK);
    __CLR3_3_038i38ii96a4z0h.R.inc(4440);data.setMsrpValue(24.95);
    __CLR3_3_038i38ii96a4z0h.R.inc(4441);data.setCurPrice(17.22);

    __CLR3_3_038i38ii96a4z0h.R.inc(4442);return data;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  /** Helper method to generate some game data to be used for validation */
  public static Game createGameData(long gameID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4443);
    __CLR3_3_038i38ii96a4z0h.R.inc(4444);if ((((gameID == ABYSS_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4445)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4446)==0&false)))            {__CLR3_3_038i38ii96a4z0h.R.inc(4447);return createRealAbyssGame();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4448);if ((((gameID == COSMIC_ENCOUNTER_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4449)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4450)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4451);return createRealCosmicEncounterGame();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4452);if ((((gameID == COSMIC_INCURSION_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4453)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4454)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4455);return createRealCosmicIncursionGame();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4456);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static Game createRealAbyssGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4457);
    __CLR3_3_038i38ii96a4z0h.R.inc(4458);Game abyssGame = new Game();
    __CLR3_3_038i38ii96a4z0h.R.inc(4459);abyssGame.setGameID(ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4460);abyssGame.setBggID(BGG_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4461);abyssGame.setName("Abyss");
    __CLR3_3_038i38ii96a4z0h.R.inc(4462);abyssGame.setYearPublished(2014);
    __CLR3_3_038i38ii96a4z0h.R.inc(4463);abyssGame.setMinPlayers(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4464);abyssGame.setMaxPlayers(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4465);abyssGame.setMinPlayingTime(45);
    __CLR3_3_038i38ii96a4z0h.R.inc(4466);abyssGame.setMaxPlayingTime(45);
    __CLR3_3_038i38ii96a4z0h.R.inc(4467);abyssGame.setImageURL("http://cf.geekdo-images.com/images/pic1965255.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4468);abyssGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic1965255_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4469);abyssGame.setDescription("The Abyss power is once again vacant, so the time has come to get your hands on the throne and its privileges. Use all of your cunning to win or buy votes in the Council. Recruit the most influential Lords and abuse their powers to take control of the most strategic territories. Finally, impose yourself as the only one able to rule the Abyssal people!\n\nAbyss is a game of development, combination and collection in which players try to take control of strategic locations in an underwater city. To achieve this, players must develop on three levels: first by collecting allies, then using them to recruit Lords of the Abyss, who will then grant access to different parts of the city. Players acquire cards through a draft of sorts, and the Lords of the Abyss acquired on those cards grant special powers to the cardholder - but once you use the cards to acquire a location, that power is shut off, so players need to time their land grabs well in order to put themselves in the best position for when the game ends.");
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4470);abyssGame.setPrimaryPublisher("Asmodee");
    __CLR3_3_038i38ii96a4z0h.R.inc(4471);List<String> publishers = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4472);publishers.add("Bombyx");
    __CLR3_3_038i38ii96a4z0h.R.inc(4473);publishers.add("Asmodee");
    __CLR3_3_038i38ii96a4z0h.R.inc(4474);publishers.add("Asterion Press");
    __CLR3_3_038i38ii96a4z0h.R.inc(4475);publishers.add("REBEL.pl");
    __CLR3_3_038i38ii96a4z0h.R.inc(4476);abyssGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4477);List<String> designers = new ArrayList<String>(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4478);designers.add("Bruno Cathala");
    __CLR3_3_038i38ii96a4z0h.R.inc(4479);designers.add("Charles Chevallier");
    __CLR3_3_038i38ii96a4z0h.R.inc(4480);abyssGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4481);List<String> categories = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4482);categories.add("Card Game");
    __CLR3_3_038i38ii96a4z0h.R.inc(4483);categories.add("Mythology");
    __CLR3_3_038i38ii96a4z0h.R.inc(4484);categories.add("Nautical");
    __CLR3_3_038i38ii96a4z0h.R.inc(4485);abyssGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4486);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4487);mechanisms.add("Auction/Bidding");
    __CLR3_3_038i38ii96a4z0h.R.inc(4488);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4489);mechanisms.add("Set Collection");
    __CLR3_3_038i38ii96a4z0h.R.inc(4490);abyssGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4491);abyssGame.setGameType(GameType.BASE);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4492);abyssGame.setAddDate(new Date (new Date().getTime() - 10000000));
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4493);return abyssGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static Game createRealCosmicEncounterGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4494);
    __CLR3_3_038i38ii96a4z0h.R.inc(4495);Game cosmicGame = new Game();
    __CLR3_3_038i38ii96a4z0h.R.inc(4496);cosmicGame.setGameID(COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4497);cosmicGame.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4498);cosmicGame.setName("Cosmic Encounter");
    __CLR3_3_038i38ii96a4z0h.R.inc(4499);cosmicGame.setYearPublished(2008);
    __CLR3_3_038i38ii96a4z0h.R.inc(4500);cosmicGame.setMinPlayers(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4501);cosmicGame.setMaxPlayers(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4502);cosmicGame.setMinPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4503);cosmicGame.setMaxPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4504);cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic354780.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4505);cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic354780_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4506);cosmicGame.setDescription("From the Manufacturer\n\nBuild a galactic empire... In the depths of space, the alien races of the Cosmos vie with each other for control of the universe. Alliances form and shift from moment to moment, while cataclysmic battles send starships screaming into the warp.  Players choose from dozens of alien races, each with its own unique power to further its efforts to build an empire that spans the galaxy.\n\nMany classic aliens from earlier editions of this beloved game return, such as the Oracle, the Loser, and the Clone. Newly discovered aliens also join the fray, including Remora, Mite, and Tick-Tock.  This classic game of alien politics returns from the warp once more.\n\nIn Cosmic Encounter, each player is the leader of an alien race. On a player's turn, he or she becomes the offense.  The offense encounters another player on a planet by moving a group of his or her ships through the hyperspace gate to that planet.  The offense draws from the destiny deck which contains colors, wilds and specials.  He or she then takes the hyperspace gate and points at one planet in the system indicated by the drawn destiny card.  The offense vs. the defenses ships are in the encounter and both sides are able to invite allies, play an encounter card as well as special cards to try and tip the encounter in their favor.\n\nThe object of the game is to establish colonies in other players' planetary systems. Players take turns trying to establish colonies. The winner(s) are the first player(s) to have five colonies on any planets outside his or her home system. A player does not need to have colonies in all of the systems, just colonies on five planets outside his or her home system. These colonies may all be in one system or scattered over multiple systems. The players must use force, cunning, and diplomacy to ensure their victory.");
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4507);cosmicGame.setPrimaryPublisher("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4508);List<String> publishers = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4509);publishers.add("Arclight");
    __CLR3_3_038i38ii96a4z0h.R.inc(4510);publishers.add("Asterion Press");
    __CLR3_3_038i38ii96a4z0h.R.inc(4511);publishers.add("Edge Entertainment");
    __CLR3_3_038i38ii96a4z0h.R.inc(4512);publishers.add("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4513);publishers.add("Heidelberger Spieleverlag");
    __CLR3_3_038i38ii96a4z0h.R.inc(4514);cosmicGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4515);List<String> designers = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4516);designers.add("Bill Eberle");
    __CLR3_3_038i38ii96a4z0h.R.inc(4517);designers.add("Jack Kittredge");
    __CLR3_3_038i38ii96a4z0h.R.inc(4518);designers.add("Bill Norton");
    __CLR3_3_038i38ii96a4z0h.R.inc(4519);designers.add("Peter Olotka");
    __CLR3_3_038i38ii96a4z0h.R.inc(4520);designers.add("Kevin Wilson");
    __CLR3_3_038i38ii96a4z0h.R.inc(4521);cosmicGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4522);List<String> categories = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4523);categories.add("Bluffing");
    __CLR3_3_038i38ii96a4z0h.R.inc(4524);categories.add("Negotiation");
    __CLR3_3_038i38ii96a4z0h.R.inc(4525);categories.add("Science Fiction");
    __CLR3_3_038i38ii96a4z0h.R.inc(4526);categories.add("Space Exploration");
    __CLR3_3_038i38ii96a4z0h.R.inc(4527);cosmicGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4528);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4529);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4530);mechanisms.add("Partnerships");
    __CLR3_3_038i38ii96a4z0h.R.inc(4531);mechanisms.add("Variable Player Powers");
    __CLR3_3_038i38ii96a4z0h.R.inc(4532);cosmicGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4533);cosmicGame.setGameType(GameType.BASE);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4534);List<Long> expansions = new ArrayList<Long>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4535);expansions.add(114276L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4536);expansions.add(87507L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4537);expansions.add(153971L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4538);expansions.add(61001L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4539);expansions.add(143760L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4540);cosmicGame.setExpansionIDs(expansions);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4541);return cosmicGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  private static Game createRealCosmicIncursionGame() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4542);
    __CLR3_3_038i38ii96a4z0h.R.inc(4543);Game cosmicGame = new Game();
    __CLR3_3_038i38ii96a4z0h.R.inc(4544);cosmicGame.setGameID(COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4545);cosmicGame.setBggID(BGG_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4546);cosmicGame.setName("Cosmic Encounter: Cosmic Incursion");
    __CLR3_3_038i38ii96a4z0h.R.inc(4547);cosmicGame.setYearPublished(2010);
    __CLR3_3_038i38ii96a4z0h.R.inc(4548);cosmicGame.setMinPlayers(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4549);cosmicGame.setMaxPlayers(6);
    __CLR3_3_038i38ii96a4z0h.R.inc(4550);cosmicGame.setMinPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4551);cosmicGame.setMaxPlayingTime(60);
    __CLR3_3_038i38ii96a4z0h.R.inc(4552);cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic657393.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4553);cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic657393_t.jpg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4554);cosmicGame.setDescription("Adapted from the Fantasy Flight web site:\n\nOver the years, alien empires have risen and fallen. The Vacuum has failed to eliminate the Zombie, the Virus has spread far and wide, and the Loser has turned defeat into victory. 50 different species have tried to conquer the galaxy, and each have made their mark on the universe. Their warring has not gone unnoticed.\n\n20 new alien cultures are now racing towards the site of the conflict. They each want to carve out their own piece of the galaxy for themselves. The aliens may be familiar to some of you (reprints of past favorites), or are aliens no one has ever seen before. The first on our list is a blast from the past; the Sniveler!\n\nIn addition, this expansion includes additions to the Cosmic Encounter universe. From the game-changing Cosmic Quakes to the bounties held within the Reward deck, these additions are sure to spice up your quest for galactic dominance.\n\nEvery game has seen five races converge to do battle for control of an empire. Now, the galaxy gets crowded. A sixth race appears to do battle, and the sixth member of your play group is able to join you. Cosmic Incursion allows a sixth player to get in on the fun.\n\nCosmic Encounter puts you in charge of the fate of an alien race. Each flavor of extraterrestrial strives to be the first to conquer five enemy colonies and establish themselves as the dominant life form. Every faction has a unique power, a power they intend to use to crush their enemies. With over 50 aliens to choose from no two games will be the same.");
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4555);cosmicGame.setPrimaryPublisher("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4556);List<String> publishers = new ArrayList<String>(4);
    __CLR3_3_038i38ii96a4z0h.R.inc(4557);publishers.add("Arclight");
    __CLR3_3_038i38ii96a4z0h.R.inc(4558);publishers.add("Edge Entertainment");
    __CLR3_3_038i38ii96a4z0h.R.inc(4559);publishers.add("Fantasy Flight Games");
    __CLR3_3_038i38ii96a4z0h.R.inc(4560);publishers.add("Heidelberger Spieleverlag");
    __CLR3_3_038i38ii96a4z0h.R.inc(4561);cosmicGame.setPublishers(publishers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4562);List<String> designers = new ArrayList<String>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4563);designers.add("Kevin Wilson");
    __CLR3_3_038i38ii96a4z0h.R.inc(4564);cosmicGame.setDesigners(designers);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4565);List<String> categories = new ArrayList<String>(5);
    __CLR3_3_038i38ii96a4z0h.R.inc(4566);categories.add("Bluffing");
    __CLR3_3_038i38ii96a4z0h.R.inc(4567);categories.add("Negotiation");
    __CLR3_3_038i38ii96a4z0h.R.inc(4568);categories.add("Expansion for Base-game");
    __CLR3_3_038i38ii96a4z0h.R.inc(4569);categories.add("Science Fiction");
    __CLR3_3_038i38ii96a4z0h.R.inc(4570);categories.add("Space Exploration");
    __CLR3_3_038i38ii96a4z0h.R.inc(4571);cosmicGame.setCategories(categories);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4572);List<String> mechanisms = new ArrayList<String>(3);
    __CLR3_3_038i38ii96a4z0h.R.inc(4573);mechanisms.add("Hand Management");
    __CLR3_3_038i38ii96a4z0h.R.inc(4574);mechanisms.add("Partnerships");
    __CLR3_3_038i38ii96a4z0h.R.inc(4575);mechanisms.add("Variable Player Powers");
    __CLR3_3_038i38ii96a4z0h.R.inc(4576);cosmicGame.setMechanisms(mechanisms);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4577);cosmicGame.setGameType(GameType.EXPANSION);
    __CLR3_3_038i38ii96a4z0h.R.inc(4578);cosmicGame.setParentGameID(BGG_COSMIC_ENCOUNTER_ID);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4579);cosmicGame.setAddDate(new Date());
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4580);return cosmicGame;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  /** Helper method to generate some game data to be used for validation */
  public static GameReltn createGameReltnData(long reltnID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4581);
    __CLR3_3_038i38ii96a4z0h.R.inc(4582);if ((((reltnID == ABYSS_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4583)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4584)==0&false)))            {__CLR3_3_038i38ii96a4z0h.R.inc(4585);return createAbyssGameReltn();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4586);if ((((reltnID == COSMIC_ENCOUNTER_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4587)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4588)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4589);return createCosmicEncounterGameReltn();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4590);if ((((reltnID == COSMIC_INCURSION_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4591)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4592)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4593);return createCosmicIncursionGameReltn();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4594);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static GameReltn createAbyssGameReltn() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4595);
    __CLR3_3_038i38ii96a4z0h.R.inc(4596);GameReltn reltn = new GameReltn();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4597);reltn.setReltnID(ABYSS_RELTN_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4598);reltn.setGameID(ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4599);reltn.setBggID(BGG_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4600);List<Long> csiIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4601);csiIDs.add(CSI_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4602);reltn.setCsiIDs(csiIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4603);List<Long> mmIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4604);mmIDs.add(MM_ABYSS_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4605);reltn.setMmIDs(mmIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4606);List<String> asinKeys = new ArrayList<String>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4607);asinKeys.add("B00KU10PH2");
    __CLR3_3_038i38ii96a4z0h.R.inc(4608);reltn.setAsinKeys(asinKeys);
    
    //No other site data for this item
    __CLR3_3_038i38ii96a4z0h.R.inc(4609);reltn.setOtherSites(null);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4610);return reltn;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static GameReltn createCosmicEncounterGameReltn() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4611);
    __CLR3_3_038i38ii96a4z0h.R.inc(4612);GameReltn reltn = new GameReltn();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4613);reltn.setReltnID(COSMIC_ENCOUNTER_RELTN_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4614);reltn.setGameID(COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4615);reltn.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4616);List<Long> csiIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4617);csiIDs.add(CSI_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4618);reltn.setCsiIDs(csiIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4619);List<Long> mmIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4620);mmIDs.add(MM_COSMIC_ENCOUNTER_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4621);reltn.setMmIDs(mmIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4622);List<String> asinKeys = new ArrayList<String>(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4623);asinKeys.add("1589944968");
    __CLR3_3_038i38ii96a4z0h.R.inc(4624);asinKeys.add("978-0874310412");
    __CLR3_3_038i38ii96a4z0h.R.inc(4625);reltn.setAsinKeys(asinKeys);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4626);List<Long> otherSites = new ArrayList<Long>(2);
    __CLR3_3_038i38ii96a4z0h.R.inc(4627);otherSites.add(111222L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4628);otherSites.add(222333L);
    __CLR3_3_038i38ii96a4z0h.R.inc(4629);reltn.setOtherSites(otherSites);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4630);return reltn;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static GameReltn createCosmicIncursionGameReltn() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4631);
    __CLR3_3_038i38ii96a4z0h.R.inc(4632);GameReltn reltn = new GameReltn();
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4633);reltn.setReltnID(COSMIC_INCURSION_RELTN_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4634);reltn.setGameID(COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4635);reltn.setBggID(BGG_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4636);List<Long> csiIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4637);csiIDs.add(CSI_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4638);reltn.setCsiIDs(csiIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4639);List<Long> mmIDs = new ArrayList<Long>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4640);mmIDs.add(MM_COSMIC_INCURSION_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4641);reltn.setMmIDs(mmIDs);
    __CLR3_3_038i38ii96a4z0h.R.inc(4642);List<String> asinKeys = new ArrayList<String>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4643);asinKeys.add("B008KKG4OI");
    __CLR3_3_038i38ii96a4z0h.R.inc(4644);reltn.setAsinKeys(asinKeys);
    
    //No other site data for this item
    __CLR3_3_038i38ii96a4z0h.R.inc(4645);reltn.setOtherSites(null);
    
    __CLR3_3_038i38ii96a4z0h.R.inc(4646);return reltn;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  /** Helper method to generate some game data to be used for validation */
  public static User createUserData(long userID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4647);
    __CLR3_3_038i38ii96a4z0h.R.inc(4648);if ((((userID == USER_ONE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4649)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4650)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4651);return createUserOne();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4652);if ((((userID == USER_TWO_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4653)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4654)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4655);return createUserTwo();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4656);if ((((userID == USER_THREE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4657)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4658)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4659);return createUserThree();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4660);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static User createUserOne() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4661);
    __CLR3_3_038i38ii96a4z0h.R.inc(4662);User user = new User();
    __CLR3_3_038i38ii96a4z0h.R.inc(4663);user.setUserID(USER_ONE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4664);user.setUserName("user_one");
    __CLR3_3_038i38ii96a4z0h.R.inc(4665);user.setFirstName("First");
    __CLR3_3_038i38ii96a4z0h.R.inc(4666);user.setLastName("Bobert");
    __CLR3_3_038i38ii96a4z0h.R.inc(4667);user.setEmailAddress("userone@test.com");
    __CLR3_3_038i38ii96a4z0h.R.inc(4668);user.setCollectionID(COLLECTION_ONE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4669);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static User createUserTwo() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4670);
    __CLR3_3_038i38ii96a4z0h.R.inc(4671);User user = new User();
    __CLR3_3_038i38ii96a4z0h.R.inc(4672);user.setUserID(USER_TWO_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4673);user.setUserName("user_two");
    __CLR3_3_038i38ii96a4z0h.R.inc(4674);user.setFirstName("Second");
    __CLR3_3_038i38ii96a4z0h.R.inc(4675);user.setLastName("Leopold");
    __CLR3_3_038i38ii96a4z0h.R.inc(4676);user.setEmailAddress("usertwo@test.com");
    __CLR3_3_038i38ii96a4z0h.R.inc(4677);user.setCollectionID(COLLECTION_TWO_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4678);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static User createUserThree() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4679);
    __CLR3_3_038i38ii96a4z0h.R.inc(4680);User user = new User();
    __CLR3_3_038i38ii96a4z0h.R.inc(4681);user.setUserID(USER_THREE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4682);user.setUserName("user_three");
    __CLR3_3_038i38ii96a4z0h.R.inc(4683);user.setFirstName("Third");
    __CLR3_3_038i38ii96a4z0h.R.inc(4684);user.setLastName("Louie");
    __CLR3_3_038i38ii96a4z0h.R.inc(4685);user.setEmailAddress("userthree@test.com");
    __CLR3_3_038i38ii96a4z0h.R.inc(4686);user.setCollectionID(COLLECTION_THREE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4687);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  /** Helper method to generate some game data to be used for validation */
  public static UserDetail createUserDetailData(long userID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4688);
    __CLR3_3_038i38ii96a4z0h.R.inc(4689);if ((((userID == USER_ONE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4690)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4691)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4692);return createUserDetailOne();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4693);if ((((userID == USER_TWO_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4694)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4695)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4696);return createUserDetailTwo();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4697);if ((((userID == USER_THREE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4698)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4699)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4700);return createUserDetailThree();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4701);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static UserDetail createUserDetailOne() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4702);
    __CLR3_3_038i38ii96a4z0h.R.inc(4703);UserDetail user = new UserDetail();
    __CLR3_3_038i38ii96a4z0h.R.inc(4704);user.setUserID(USER_ONE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4705);user.setPass("asdf");
    __CLR3_3_038i38ii96a4z0h.R.inc(4706);user.setUserRole(UserRole.USER);
    __CLR3_3_038i38ii96a4z0h.R.inc(4707);user.setCreatedOnDate(new Date(10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4708);user.setLastLoginDate(new Date(10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4709);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static UserDetail createUserDetailTwo() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4710);
    __CLR3_3_038i38ii96a4z0h.R.inc(4711);UserDetail user = new UserDetail();
    __CLR3_3_038i38ii96a4z0h.R.inc(4712);user.setUserID(USER_TWO_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4713);user.setPass("sdfg");
    __CLR3_3_038i38ii96a4z0h.R.inc(4714);user.setUserRole(UserRole.USER);
    __CLR3_3_038i38ii96a4z0h.R.inc(4715);user.setCreatedOnDate(new Date(20000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4716);user.setLastLoginDate(new Date(20000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4717);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static UserDetail createUserDetailThree() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4718);
    __CLR3_3_038i38ii96a4z0h.R.inc(4719);UserDetail user = new UserDetail();
    __CLR3_3_038i38ii96a4z0h.R.inc(4720);user.setUserID(USER_THREE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4721);user.setPass("dfgh");
    __CLR3_3_038i38ii96a4z0h.R.inc(4722);user.setUserRole(UserRole.ADMIN);
    __CLR3_3_038i38ii96a4z0h.R.inc(4723);user.setCreatedOnDate(new Date(30000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4724);user.setLastLoginDate(new Date(30000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4725);return user;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  public static Collection createCollectionData(long collectionID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4726);
    __CLR3_3_038i38ii96a4z0h.R.inc(4727);if ((((collectionID == COLLECTION_ONE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4728)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4729)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4730);return createCollectionOne();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4731);if ((((collectionID == COLLECTION_TWO_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4732)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4733)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4734);return createCollectionTwo();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4735);if ((((collectionID == COLLECTION_THREE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4736)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4737)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4738);return createCollectionThree();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4739);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static Collection createCollectionOne() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4740);
    __CLR3_3_038i38ii96a4z0h.R.inc(4741);Collection collection = new Collection();
    __CLR3_3_038i38ii96a4z0h.R.inc(4742);collection.setCollectionID(COLLECTION_ONE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4743);collection.setGames(new LinkedList<CollectionItem>());
    __CLR3_3_038i38ii96a4z0h.R.inc(4744);collection.setBaseGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4745);collection.setCollectibleGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4746);collection.setExpansionGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4747);return collection;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static Collection createCollectionTwo() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4748);
    __CLR3_3_038i38ii96a4z0h.R.inc(4749);Collection collection = new Collection();
    __CLR3_3_038i38ii96a4z0h.R.inc(4750);collection.setCollectionID(COLLECTION_TWO_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4751);List<CollectionItem> games = new LinkedList<CollectionItem>();
    __CLR3_3_038i38ii96a4z0h.R.inc(4752);games.add(createCollectionItemThree());  //Abyss
    __CLR3_3_038i38ii96a4z0h.R.inc(4753);collection.setGames(games);
    __CLR3_3_038i38ii96a4z0h.R.inc(4754);collection.setBaseGameCount(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4755);collection.setCollectibleGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4756);collection.setExpansionGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4757);return collection;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static Collection createCollectionThree() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4758);
    __CLR3_3_038i38ii96a4z0h.R.inc(4759);Collection collection = new Collection();
    __CLR3_3_038i38ii96a4z0h.R.inc(4760);collection.setCollectionID(COLLECTION_THREE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4761);List<CollectionItem> games = new LinkedList<CollectionItem>();
    __CLR3_3_038i38ii96a4z0h.R.inc(4762);games.add(createCollectionItemOne());  //Cosmic Encounter
    __CLR3_3_038i38ii96a4z0h.R.inc(4763);collection.setGames(games);
    __CLR3_3_038i38ii96a4z0h.R.inc(4764);collection.setBaseGameCount(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4765);collection.setCollectibleGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4766);collection.setExpansionGameCount(0);
    __CLR3_3_038i38ii96a4z0h.R.inc(4767);return collection;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}

  public static CollectionItem createCollectionItemData(long itemID) {try{__CLR3_3_038i38ii96a4z0h.R.inc(4768);
    __CLR3_3_038i38ii96a4z0h.R.inc(4769);if ((((itemID == COLLECTION_ITEM_ONE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4770)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4771)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4772);return createCollectionItemOne();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4773);if ((((itemID == COLLECTION_ITEM_TWO_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4774)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4775)==0&false)))   {__CLR3_3_038i38ii96a4z0h.R.inc(4776);return createCollectionItemTwo();
    }__CLR3_3_038i38ii96a4z0h.R.inc(4777);if ((((itemID == COLLECTION_ITEM_THREE_ID)&&(__CLR3_3_038i38ii96a4z0h.R.iget(4778)!=0|true))||(__CLR3_3_038i38ii96a4z0h.R.iget(4779)==0&false))) {__CLR3_3_038i38ii96a4z0h.R.inc(4780);return createCollectionItemThree();
    
    //Fail Case
    }__CLR3_3_038i38ii96a4z0h.R.inc(4781);return null;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static CollectionItem createCollectionItemOne() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4782);
    __CLR3_3_038i38ii96a4z0h.R.inc(4783);CollectionItem item = new CollectionItem();
    __CLR3_3_038i38ii96a4z0h.R.inc(4784);item.setItemID(COLLECTION_ITEM_ONE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4785);Game game = createRealCosmicEncounterGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4786);item.setGameID(game.getGameID());
    __CLR3_3_038i38ii96a4z0h.R.inc(4787);item.setGame(game);
    __CLR3_3_038i38ii96a4z0h.R.inc(4788);List<GameWeight> weights = new ArrayList<GameWeight>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4789);weights.add(GameWeight.MEDIUM);
    __CLR3_3_038i38ii96a4z0h.R.inc(4790);item.setWeights(weights);
    __CLR3_3_038i38ii96a4z0h.R.inc(4791);item.setDateAcquired(null);
    __CLR3_3_038i38ii96a4z0h.R.inc(4792);item.setWhereAcquired(null);
    __CLR3_3_038i38ii96a4z0h.R.inc(4793);return item;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static CollectionItem createCollectionItemTwo() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4794);
    __CLR3_3_038i38ii96a4z0h.R.inc(4795);CollectionItem item = new CollectionItem();
    __CLR3_3_038i38ii96a4z0h.R.inc(4796);item.setItemID(COLLECTION_ITEM_TWO_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4797);Game game = createRealCosmicIncursionGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4798);item.setGameID(game.getGameID());
    __CLR3_3_038i38ii96a4z0h.R.inc(4799);item.setGame(game);
    __CLR3_3_038i38ii96a4z0h.R.inc(4800);List<GameWeight> weights = new ArrayList<GameWeight>(1);
    __CLR3_3_038i38ii96a4z0h.R.inc(4801);weights.add(GameWeight.HEAVY);
    __CLR3_3_038i38ii96a4z0h.R.inc(4802);item.setWeights(weights);
    __CLR3_3_038i38ii96a4z0h.R.inc(4803);item.setDateAcquired(new Date(10000000));
    __CLR3_3_038i38ii96a4z0h.R.inc(4804);item.setWhereAcquired("Amazon");
    __CLR3_3_038i38ii96a4z0h.R.inc(4805);return item;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  private static CollectionItem createCollectionItemThree() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4806);
    __CLR3_3_038i38ii96a4z0h.R.inc(4807);CollectionItem item = new CollectionItem();
    __CLR3_3_038i38ii96a4z0h.R.inc(4808);item.setItemID(COLLECTION_ITEM_THREE_ID);
    __CLR3_3_038i38ii96a4z0h.R.inc(4809);Game game = createRealAbyssGame();
    __CLR3_3_038i38ii96a4z0h.R.inc(4810);item.setGameID(game.getGameID());
    __CLR3_3_038i38ii96a4z0h.R.inc(4811);item.setGame(game);
    __CLR3_3_038i38ii96a4z0h.R.inc(4812);item.setWeights(null);
    __CLR3_3_038i38ii96a4z0h.R.inc(4813);item.setDateAcquired(new Date(12345678));
    __CLR3_3_038i38ii96a4z0h.R.inc(4814);item.setWhereAcquired(null);
    __CLR3_3_038i38ii96a4z0h.R.inc(4815);return item;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  public static BGGGameStats createBGGGameStats() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4816);
    __CLR3_3_038i38ii96a4z0h.R.inc(4817);BGGGameStats stats = new BGGGameStats();
    __CLR3_3_038i38ii96a4z0h.R.inc(4818);stats.setBaseGameCount(22367);
    __CLR3_3_038i38ii96a4z0h.R.inc(4819);stats.setExpansionGameCount(1243);
    __CLR3_3_038i38ii96a4z0h.R.inc(4820);stats.setCollectibleGameCount(134);
    __CLR3_3_038i38ii96a4z0h.R.inc(4821);stats.setApprovedCount(11111);
    __CLR3_3_038i38ii96a4z0h.R.inc(4822);stats.setRejectedCount(22222);
    __CLR3_3_038i38ii96a4z0h.R.inc(4823);stats.setPendingCount(3333);
    __CLR3_3_038i38ii96a4z0h.R.inc(4824);return stats;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  public static CSIDataStats createCSIDataStats() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4825);
    __CLR3_3_038i38ii96a4z0h.R.inc(4826);CSIDataStats stats = new CSIDataStats();
    __CLR3_3_038i38ii96a4z0h.R.inc(4827);stats.setBoardGameCount(13466);
    __CLR3_3_038i38ii96a4z0h.R.inc(4828);stats.setCollectibleGameCount(1234);
    __CLR3_3_038i38ii96a4z0h.R.inc(4829);stats.setDiceMastersCount(567);
    __CLR3_3_038i38ii96a4z0h.R.inc(4830);stats.setRpgCount(347);
    __CLR3_3_038i38ii96a4z0h.R.inc(4831);stats.setLcgCount(8315);
    __CLR3_3_038i38ii96a4z0h.R.inc(4832);stats.setSuppliesCount(2341);
    __CLR3_3_038i38ii96a4z0h.R.inc(4833);stats.setMiniatureCount(3567);
    __CLR3_3_038i38ii96a4z0h.R.inc(4834);stats.setVideoGameCount(1788);
    __CLR3_3_038i38ii96a4z0h.R.inc(4835);stats.setUnknownCount(1234);
    __CLR3_3_038i38ii96a4z0h.R.inc(4836);stats.setApprovedCount(44444);
    __CLR3_3_038i38ii96a4z0h.R.inc(4837);stats.setRejectedCount(55522);
    __CLR3_3_038i38ii96a4z0h.R.inc(4838);stats.setPendingCount(6677);
    __CLR3_3_038i38ii96a4z0h.R.inc(4839);return stats;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
  
  public static MMDataStats createMMDataStats() {try{__CLR3_3_038i38ii96a4z0h.R.inc(4840);
    __CLR3_3_038i38ii96a4z0h.R.inc(4841);MMDataStats stats = new MMDataStats();
    __CLR3_3_038i38ii96a4z0h.R.inc(4842);stats.setBoardGameCount(1235);
    __CLR3_3_038i38ii96a4z0h.R.inc(4843);stats.setTableTopCount(76724);
    __CLR3_3_038i38ii96a4z0h.R.inc(4844);stats.setCcgCount(1345);
    __CLR3_3_038i38ii96a4z0h.R.inc(4845);stats.setCollectiblesCount(6890);
    __CLR3_3_038i38ii96a4z0h.R.inc(4846);stats.setRpgCount(684);
    __CLR3_3_038i38ii96a4z0h.R.inc(4847);stats.setAccessoriesCount(834);
    __CLR3_3_038i38ii96a4z0h.R.inc(4848);stats.setApprovedCount(88899);
    __CLR3_3_038i38ii96a4z0h.R.inc(4849);stats.setRejectedCount(10112);
    __CLR3_3_038i38ii96a4z0h.R.inc(4850);stats.setPendingCount(2067);
    __CLR3_3_038i38ii96a4z0h.R.inc(4851);return stats;
  }finally{__CLR3_3_038i38ii96a4z0h.R.flushNeeded();}}
}
