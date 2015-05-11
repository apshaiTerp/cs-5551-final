package com.ac.games.db.mock;

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
public class MockDataFactory {

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
  public static BGGGame createBGGGame(long gameID) {
    if (gameID == BGG_ABYSS_ID)            return createAbyssGame();
    if (gameID == BGG_COSMIC_ENCOUNTER_ID) return createCosmicEncounterGame();
    if (gameID == BGG_COSMIC_INCURSION_ID) return createCosmicIncursionGame();
    
    //Fail Case
    return null;
  }
  
  private static BGGGame createAbyssGame() {
    BGGGame abyssGame = new BGGGame();
    abyssGame.setBggID(BGG_ABYSS_ID);
    abyssGame.setName("Abyss");
    abyssGame.setYearPublished(2014);
    abyssGame.setMinPlayers(2);
    abyssGame.setMaxPlayers(4);
    abyssGame.setMinPlayingTime(45);
    abyssGame.setMaxPlayingTime(45);
    abyssGame.setImageURL("http://cf.geekdo-images.com/images/pic1965255.jpg");
    abyssGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic1965255_t.jpg");
    abyssGame.setDescription("The Abyss power is once again vacant, so the time has come to get your hands on the throne and its privileges. Use all of your cunning to win or buy votes in the Council. Recruit the most influential Lords and abuse their powers to take control of the most strategic territories. Finally, impose yourself as the only one able to rule the Abyssal people!\n\nAbyss is a game of development, combination and collection in which players try to take control of strategic locations in an underwater city. To achieve this, players must develop on three levels: first by collecting allies, then using them to recruit Lords of the Abyss, who will then grant access to different parts of the city. Players acquire cards through a draft of sorts, and the Lords of the Abyss acquired on those cards grant special powers to the cardholder - but once you use the cards to acquire a location, that power is shut off, so players need to time their land grabs well in order to put themselves in the best position for when the game ends.");
    abyssGame.setBggRating(7.412);
    abyssGame.setBggRatingUsers(1405);
    
    List<String> publishers = new ArrayList<String>(4);
    publishers.add("Bombyx");
    publishers.add("Asmodee");
    publishers.add("Asterion Press");
    publishers.add("REBEL.pl");
    abyssGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(2);
    designers.add("Bruno Cathala");
    designers.add("Charles Chevallier");
    abyssGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(3);
    categories.add("Card Game");
    categories.add("Mythology");
    categories.add("Nautical");
    abyssGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Auction/Bidding");
    mechanisms.add("Hand Management");
    mechanisms.add("Set Collection");
    abyssGame.setMechanisms(mechanisms);
    
    abyssGame.setGameType(GameType.BASE);
    abyssGame.setBggRank(412);
    
    abyssGame.setReviewState(ReviewState.REVIEWED);
    abyssGame.setAddDate(new Date (new Date().getTime() - 10000000));
    abyssGame.setReviewDate(new Date());
    
    return abyssGame;
  }

  private static BGGGame createCosmicEncounterGame() {
    BGGGame cosmicGame = new BGGGame();
    cosmicGame.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    cosmicGame.setName("Cosmic Encounter");
    cosmicGame.setYearPublished(2008);
    cosmicGame.setMinPlayers(3);
    cosmicGame.setMaxPlayers(5);
    cosmicGame.setMinPlayingTime(60);
    cosmicGame.setMaxPlayingTime(60);
    cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic354780.jpg");
    cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic354780_t.jpg");
    cosmicGame.setDescription("From the Manufacturer\n\nBuild a galactic empire... In the depths of space, the alien races of the Cosmos vie with each other for control of the universe. Alliances form and shift from moment to moment, while cataclysmic battles send starships screaming into the warp.  Players choose from dozens of alien races, each with its own unique power to further its efforts to build an empire that spans the galaxy.\n\nMany classic aliens from earlier editions of this beloved game return, such as the Oracle, the Loser, and the Clone. Newly discovered aliens also join the fray, including Remora, Mite, and Tick-Tock.  This classic game of alien politics returns from the warp once more.\n\nIn Cosmic Encounter, each player is the leader of an alien race. On a player's turn, he or she becomes the offense.  The offense encounters another player on a planet by moving a group of his or her ships through the hyperspace gate to that planet.  The offense draws from the destiny deck which contains colors, wilds and specials.  He or she then takes the hyperspace gate and points at one planet in the system indicated by the drawn destiny card.  The offense vs. the defenses ships are in the encounter and both sides are able to invite allies, play an encounter card as well as special cards to try and tip the encounter in their favor.\n\nThe object of the game is to establish colonies in other players' planetary systems. Players take turns trying to establish colonies. The winner(s) are the first player(s) to have five colonies on any planets outside his or her home system. A player does not need to have colonies in all of the systems, just colonies on five planets outside his or her home system. These colonies may all be in one system or scattered over multiple systems. The players must use force, cunning, and diplomacy to ensure their victory.");
    cosmicGame.setBggRating(7.58417);
    cosmicGame.setBggRatingUsers(12054);
    
    List<String> publishers = new ArrayList<String>(5);
    publishers.add("Arclight");
    publishers.add("Asterion Press");
    publishers.add("Edge Entertainment");
    publishers.add("Fantasy Flight Games");
    publishers.add("Heidelberger Spieleverlag");
    cosmicGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(5);
    designers.add("Bill Eberle");
    designers.add("Jack Kittredge");
    designers.add("Bill Norton");
    designers.add("Peter Olotka");
    designers.add("Kevin Wilson");
    cosmicGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(4);
    categories.add("Bluffing");
    categories.add("Negotiation");
    categories.add("Science Fiction");
    categories.add("Space Exploration");
    cosmicGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Hand Management");
    mechanisms.add("Partnerships");
    mechanisms.add("Variable Player Powers");
    cosmicGame.setMechanisms(mechanisms);
    
    cosmicGame.setGameType(GameType.BASE);
    cosmicGame.setBggRank(74);
    
    List<Long> expansions = new ArrayList<Long>(5);
    expansions.add(114276L);
    expansions.add(87507L);
    expansions.add(153971L);
    expansions.add(61001L);
    expansions.add(143760L);
    cosmicGame.setExpansionIDs(expansions);
    
    return cosmicGame;
  }

  private static BGGGame createCosmicIncursionGame() {
    BGGGame cosmicGame = new BGGGame();
    cosmicGame.setBggID(BGG_COSMIC_INCURSION_ID);
    cosmicGame.setName("Cosmic Encounter: Cosmic Incursion");
    cosmicGame.setYearPublished(2010);
    cosmicGame.setMinPlayers(3);
    cosmicGame.setMaxPlayers(6);
    cosmicGame.setMinPlayingTime(60);
    cosmicGame.setMaxPlayingTime(60);
    cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic657393.jpg");
    cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic657393_t.jpg");
    cosmicGame.setDescription("Adapted from the Fantasy Flight web site:\n\nOver the years, alien empires have risen and fallen. The Vacuum has failed to eliminate the Zombie, the Virus has spread far and wide, and the Loser has turned defeat into victory. 50 different species have tried to conquer the galaxy, and each have made their mark on the universe. Their warring has not gone unnoticed.\n\n20 new alien cultures are now racing towards the site of the conflict. They each want to carve out their own piece of the galaxy for themselves. The aliens may be familiar to some of you (reprints of past favorites), or are aliens no one has ever seen before. The first on our list is a blast from the past; the Sniveler!\n\nIn addition, this expansion includes additions to the Cosmic Encounter universe. From the game-changing Cosmic Quakes to the bounties held within the Reward deck, these additions are sure to spice up your quest for galactic dominance.\n\nEvery game has seen five races converge to do battle for control of an empire. Now, the galaxy gets crowded. A sixth race appears to do battle, and the sixth member of your play group is able to join you. Cosmic Incursion allows a sixth player to get in on the fun.\n\nCosmic Encounter puts you in charge of the fate of an alien race. Each flavor of extraterrestrial strives to be the first to conquer five enemy colonies and establish themselves as the dominant life form. Every faction has a unique power, a power they intend to use to crush their enemies. With over 50 aliens to choose from no two games will be the same.");
    cosmicGame.setBggRating(8.27179);
    cosmicGame.setBggRatingUsers(1781);
    
    List<String> publishers = new ArrayList<String>(4);
    publishers.add("Arclight");
    publishers.add("Edge Entertainment");
    publishers.add("Fantasy Flight Games");
    publishers.add("Heidelberger Spieleverlag");
    cosmicGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(1);
    designers.add("Kevin Wilson");
    cosmicGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(5);
    categories.add("Bluffing");
    categories.add("Negotiation");
    categories.add("Expansion for Base-game");
    categories.add("Science Fiction");
    categories.add("Space Exploration");
    cosmicGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Hand Management");
    mechanisms.add("Partnerships");
    mechanisms.add("Variable Player Powers");
    cosmicGame.setMechanisms(mechanisms);
    
    cosmicGame.setGameType(GameType.EXPANSION);
    cosmicGame.setParentGameID(BGG_COSMIC_ENCOUNTER_ID);
    
    return cosmicGame;
  }
  
  /** Helper method to generate some game data to be used for validation */
  public static CoolStuffIncPriceData createCSIData(long csiID) {
    if (csiID == CSI_ABYSS_ID)            return createCSIAbyssData();
    if (csiID == CSI_COSMIC_ENCOUNTER_ID) return createCSICosmicEncounterData();
    if (csiID == CSI_COSMIC_INCURSION_ID) return createCSICosmicIncursionData();
    
    //Fail Case
    return null;
  }
  
  private static CoolStuffIncPriceData createCSIAbyssData() {
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    data.setCsiID(CSI_ABYSS_ID);
    data.setTitle("Abyss");
    data.setPublisher("Asmodee Editions");
    data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    data.setSku("ASMABY01US");
    data.setImageURL("http://a4.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Asmodee%20Editions/full/ASMABY01US.jpg");
    data.setAvailability(GameAvailability.INSTOCK);
    data.setReleaseDate(null);
    data.setMsrpValue(59.99);
    data.setCurPrice(40.99);
    
    data.setReviewState(ReviewState.REVIEWED);
    data.setAddDate(new Date (new Date().getTime() - 10000000));
    data.setReviewDate(new Date());
    
    return data;
  }

  private static CoolStuffIncPriceData createCSICosmicEncounterData() {
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    data.setCsiID(CSI_COSMIC_ENCOUNTER_ID);
    data.setTitle("Cosmic Encounter Board Game");
    data.setPublisher("Fantasy Flight Games");
    data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    data.setSku("FFGCE01");
    data.setImageURL("http://a1.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Fantasy%20Flight%20Games/full/FFGCosmicEncounter.jpg");
    data.setAvailability(GameAvailability.PREORDER);
    data.setReleaseDate("First quarter 2015");
    data.setMsrpValue(59.95);
    data.setCurPrice(41.49);
    
    return data;
  }

  private static CoolStuffIncPriceData createCSICosmicIncursionData() {
    CoolStuffIncPriceData data = new CoolStuffIncPriceData();
    
    data.setCsiID(CSI_COSMIC_INCURSION_ID);
    data.setTitle("Cosmic Encounter: Cosmic Incursion Expansion");
    data.setPublisher("Fantasy Flight Games");
    data.setCategory(CoolStuffIncCategory.BOARDGAMES);
    data.setSku("FFGCE02");
    data.setImageURL("http://a5.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Fantasy%20Flight%20Games/full/ffg_cosmicencounterCosmicIncursion.jpg");
    data.setAvailability(GameAvailability.OUTOFSTOCK);
    data.setReleaseDate(null);
    //data.setMsrpValue(0.0);
    data.setCurPrice(16.99);
    
    return data;
  }

  /** Helper method to generate some game data to be used for validation */
  public static MiniatureMarketPriceData createMMData(long mmID) {
    if (mmID == MM_ABYSS_ID)            return createMMAbyssData();
    if (mmID == MM_COSMIC_ENCOUNTER_ID) return createMMCosmicEncounterData();
    if (mmID == MM_COSMIC_INCURSION_ID) return createMMCosmicIncursionData();
    
    //Fail Case
    return null;
  }
  
  private static MiniatureMarketPriceData createMMAbyssData() {
    MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    data.setMmID(MM_ABYSS_ID);
    data.setTitle("Abyss");
    data.setManufacturer("Asmodee");
    data.setSku("ASMABY01US");
    data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    data.setImageURL("http://a4.res.cloudinary.com/csicdn/image/upload/v1/Images/Products/Misc%20Art/Asmodee%20Editions/full/ASMABY01US.jpg");
    data.setAvailability(GameAvailability.INSTOCK);
    data.setMsrpValue(59.99);
    data.setCurPrice(41.39);

    data.setReviewState(ReviewState.REVIEWED);
    data.setAddDate(new Date (new Date().getTime() - 10000000));
    data.setReviewDate(new Date());

    return data;
  }

  private static MiniatureMarketPriceData createMMCosmicEncounterData() {
    MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    data.setMmID(MM_COSMIC_ENCOUNTER_ID);
    data.setTitle("Cosmic Encounter");
    data.setManufacturer("Fantasy Flight Games");
    data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    data.setSku("FFGCE01");
    data.setImageURL("http://cdn.miniaturemarket.com/media/catalog/product/f/f/ffgce01.jpg");
    data.setAvailability(GameAvailability.OUTOFSTOCK);
    data.setMsrpValue(59.95);
    data.setCurPrice(41.37);

    return data;
  }

  private static MiniatureMarketPriceData createMMCosmicIncursionData() {
    MiniatureMarketPriceData data = new MiniatureMarketPriceData();
    
    data.setMmID(MM_COSMIC_INCURSION_ID);
    data.setTitle("Cosmic Encounter Cosmic Incursion Expansion");
    data.setManufacturer("Fantasy Flight Games");
    data.setCategory(MiniatureMarketCategory.BOARDGAMES);
    data.setSku("FFGCE02");
    data.setImageURL("http://cdn.miniaturemarket.com/media/catalog/product/F/F/FFGCE02.jpg");
    data.setAvailability(GameAvailability.OUTOFSTOCK);
    data.setMsrpValue(24.95);
    data.setCurPrice(17.22);

    return data;
  }

  /** Helper method to generate some game data to be used for validation */
  public static Game createGameData(long gameID) {
    if (gameID == ABYSS_ID)            return createRealAbyssGame();
    if (gameID == COSMIC_ENCOUNTER_ID) return createRealCosmicEncounterGame();
    if (gameID == COSMIC_INCURSION_ID) return createRealCosmicIncursionGame();
    
    //Fail Case
    return null;
  }
  
  private static Game createRealAbyssGame() {
    Game abyssGame = new Game();
    abyssGame.setGameID(ABYSS_ID);
    abyssGame.setBggID(BGG_ABYSS_ID);
    abyssGame.setName("Abyss");
    abyssGame.setYearPublished(2014);
    abyssGame.setMinPlayers(2);
    abyssGame.setMaxPlayers(4);
    abyssGame.setMinPlayingTime(45);
    abyssGame.setMaxPlayingTime(45);
    abyssGame.setImageURL("http://cf.geekdo-images.com/images/pic1965255.jpg");
    abyssGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic1965255_t.jpg");
    abyssGame.setDescription("The Abyss power is once again vacant, so the time has come to get your hands on the throne and its privileges. Use all of your cunning to win or buy votes in the Council. Recruit the most influential Lords and abuse their powers to take control of the most strategic territories. Finally, impose yourself as the only one able to rule the Abyssal people!\n\nAbyss is a game of development, combination and collection in which players try to take control of strategic locations in an underwater city. To achieve this, players must develop on three levels: first by collecting allies, then using them to recruit Lords of the Abyss, who will then grant access to different parts of the city. Players acquire cards through a draft of sorts, and the Lords of the Abyss acquired on those cards grant special powers to the cardholder - but once you use the cards to acquire a location, that power is shut off, so players need to time their land grabs well in order to put themselves in the best position for when the game ends.");
    
    abyssGame.setPrimaryPublisher("Asmodee");
    List<String> publishers = new ArrayList<String>(4);
    publishers.add("Bombyx");
    publishers.add("Asmodee");
    publishers.add("Asterion Press");
    publishers.add("REBEL.pl");
    abyssGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(2);
    designers.add("Bruno Cathala");
    designers.add("Charles Chevallier");
    abyssGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(3);
    categories.add("Card Game");
    categories.add("Mythology");
    categories.add("Nautical");
    abyssGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Auction/Bidding");
    mechanisms.add("Hand Management");
    mechanisms.add("Set Collection");
    abyssGame.setMechanisms(mechanisms);
    
    abyssGame.setGameType(GameType.BASE);
    
    abyssGame.setAddDate(new Date (new Date().getTime() - 10000000));
    
    return abyssGame;
  }

  private static Game createRealCosmicEncounterGame() {
    Game cosmicGame = new Game();
    cosmicGame.setGameID(COSMIC_ENCOUNTER_ID);
    cosmicGame.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    cosmicGame.setName("Cosmic Encounter");
    cosmicGame.setYearPublished(2008);
    cosmicGame.setMinPlayers(3);
    cosmicGame.setMaxPlayers(5);
    cosmicGame.setMinPlayingTime(60);
    cosmicGame.setMaxPlayingTime(60);
    cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic354780.jpg");
    cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic354780_t.jpg");
    cosmicGame.setDescription("From the Manufacturer\n\nBuild a galactic empire... In the depths of space, the alien races of the Cosmos vie with each other for control of the universe. Alliances form and shift from moment to moment, while cataclysmic battles send starships screaming into the warp.  Players choose from dozens of alien races, each with its own unique power to further its efforts to build an empire that spans the galaxy.\n\nMany classic aliens from earlier editions of this beloved game return, such as the Oracle, the Loser, and the Clone. Newly discovered aliens also join the fray, including Remora, Mite, and Tick-Tock.  This classic game of alien politics returns from the warp once more.\n\nIn Cosmic Encounter, each player is the leader of an alien race. On a player's turn, he or she becomes the offense.  The offense encounters another player on a planet by moving a group of his or her ships through the hyperspace gate to that planet.  The offense draws from the destiny deck which contains colors, wilds and specials.  He or she then takes the hyperspace gate and points at one planet in the system indicated by the drawn destiny card.  The offense vs. the defenses ships are in the encounter and both sides are able to invite allies, play an encounter card as well as special cards to try and tip the encounter in their favor.\n\nThe object of the game is to establish colonies in other players' planetary systems. Players take turns trying to establish colonies. The winner(s) are the first player(s) to have five colonies on any planets outside his or her home system. A player does not need to have colonies in all of the systems, just colonies on five planets outside his or her home system. These colonies may all be in one system or scattered over multiple systems. The players must use force, cunning, and diplomacy to ensure their victory.");
    
    cosmicGame.setPrimaryPublisher("Fantasy Flight Games");
    List<String> publishers = new ArrayList<String>(5);
    publishers.add("Arclight");
    publishers.add("Asterion Press");
    publishers.add("Edge Entertainment");
    publishers.add("Fantasy Flight Games");
    publishers.add("Heidelberger Spieleverlag");
    cosmicGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(5);
    designers.add("Bill Eberle");
    designers.add("Jack Kittredge");
    designers.add("Bill Norton");
    designers.add("Peter Olotka");
    designers.add("Kevin Wilson");
    cosmicGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(4);
    categories.add("Bluffing");
    categories.add("Negotiation");
    categories.add("Science Fiction");
    categories.add("Space Exploration");
    cosmicGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Hand Management");
    mechanisms.add("Partnerships");
    mechanisms.add("Variable Player Powers");
    cosmicGame.setMechanisms(mechanisms);
    
    cosmicGame.setGameType(GameType.BASE);
    
    List<Long> expansions = new ArrayList<Long>(5);
    expansions.add(114276L);
    expansions.add(87507L);
    expansions.add(153971L);
    expansions.add(61001L);
    expansions.add(143760L);
    cosmicGame.setExpansionIDs(expansions);
    
    return cosmicGame;
  }

  private static Game createRealCosmicIncursionGame() {
    Game cosmicGame = new Game();
    cosmicGame.setGameID(COSMIC_INCURSION_ID);
    cosmicGame.setBggID(BGG_COSMIC_INCURSION_ID);
    cosmicGame.setName("Cosmic Encounter: Cosmic Incursion");
    cosmicGame.setYearPublished(2010);
    cosmicGame.setMinPlayers(3);
    cosmicGame.setMaxPlayers(6);
    cosmicGame.setMinPlayingTime(60);
    cosmicGame.setMaxPlayingTime(60);
    cosmicGame.setImageURL("http://cf.geekdo-images.com/images/pic657393.jpg");
    cosmicGame.setImageThumbnailURL("http://cf.geekdo-images.com/images/pic657393_t.jpg");
    cosmicGame.setDescription("Adapted from the Fantasy Flight web site:\n\nOver the years, alien empires have risen and fallen. The Vacuum has failed to eliminate the Zombie, the Virus has spread far and wide, and the Loser has turned defeat into victory. 50 different species have tried to conquer the galaxy, and each have made their mark on the universe. Their warring has not gone unnoticed.\n\n20 new alien cultures are now racing towards the site of the conflict. They each want to carve out their own piece of the galaxy for themselves. The aliens may be familiar to some of you (reprints of past favorites), or are aliens no one has ever seen before. The first on our list is a blast from the past; the Sniveler!\n\nIn addition, this expansion includes additions to the Cosmic Encounter universe. From the game-changing Cosmic Quakes to the bounties held within the Reward deck, these additions are sure to spice up your quest for galactic dominance.\n\nEvery game has seen five races converge to do battle for control of an empire. Now, the galaxy gets crowded. A sixth race appears to do battle, and the sixth member of your play group is able to join you. Cosmic Incursion allows a sixth player to get in on the fun.\n\nCosmic Encounter puts you in charge of the fate of an alien race. Each flavor of extraterrestrial strives to be the first to conquer five enemy colonies and establish themselves as the dominant life form. Every faction has a unique power, a power they intend to use to crush their enemies. With over 50 aliens to choose from no two games will be the same.");
    
    cosmicGame.setPrimaryPublisher("Fantasy Flight Games");
    List<String> publishers = new ArrayList<String>(4);
    publishers.add("Arclight");
    publishers.add("Edge Entertainment");
    publishers.add("Fantasy Flight Games");
    publishers.add("Heidelberger Spieleverlag");
    cosmicGame.setPublishers(publishers);
    
    List<String> designers = new ArrayList<String>(1);
    designers.add("Kevin Wilson");
    cosmicGame.setDesigners(designers);
    
    List<String> categories = new ArrayList<String>(5);
    categories.add("Bluffing");
    categories.add("Negotiation");
    categories.add("Expansion for Base-game");
    categories.add("Science Fiction");
    categories.add("Space Exploration");
    cosmicGame.setCategories(categories);
    
    List<String> mechanisms = new ArrayList<String>(3);
    mechanisms.add("Hand Management");
    mechanisms.add("Partnerships");
    mechanisms.add("Variable Player Powers");
    cosmicGame.setMechanisms(mechanisms);
    
    cosmicGame.setGameType(GameType.EXPANSION);
    cosmicGame.setParentGameID(BGG_COSMIC_ENCOUNTER_ID);
    
    cosmicGame.setAddDate(new Date());
    
    return cosmicGame;
  }
  
  /** Helper method to generate some game data to be used for validation */
  public static GameReltn createGameReltnData(long reltnID) {
    if (reltnID == ABYSS_ID)            return createAbyssGameReltn();
    if (reltnID == COSMIC_ENCOUNTER_ID) return createCosmicEncounterGameReltn();
    if (reltnID == COSMIC_INCURSION_ID) return createCosmicIncursionGameReltn();
    
    //Fail Case
    return null;
  }
  
  private static GameReltn createAbyssGameReltn() {
    GameReltn reltn = new GameReltn();
    
    reltn.setReltnID(ABYSS_RELTN_ID);
    reltn.setGameID(ABYSS_ID);
    reltn.setBggID(BGG_ABYSS_ID);
    List<Long> csiIDs = new ArrayList<Long>(1);
    csiIDs.add(CSI_ABYSS_ID);
    reltn.setCsiIDs(csiIDs);
    List<Long> mmIDs = new ArrayList<Long>(1);
    mmIDs.add(MM_ABYSS_ID);
    reltn.setMmIDs(mmIDs);
    List<String> asinKeys = new ArrayList<String>(1);
    asinKeys.add("B00KU10PH2");
    reltn.setAsinKeys(asinKeys);
    
    //No other site data for this item
    reltn.setOtherSites(null);
    
    return reltn;
  }
  
  private static GameReltn createCosmicEncounterGameReltn() {
    GameReltn reltn = new GameReltn();
    
    reltn.setReltnID(COSMIC_ENCOUNTER_RELTN_ID);
    reltn.setGameID(COSMIC_ENCOUNTER_ID);
    reltn.setBggID(BGG_COSMIC_ENCOUNTER_ID);
    List<Long> csiIDs = new ArrayList<Long>(1);
    csiIDs.add(CSI_COSMIC_ENCOUNTER_ID);
    reltn.setCsiIDs(csiIDs);
    List<Long> mmIDs = new ArrayList<Long>(1);
    mmIDs.add(MM_COSMIC_ENCOUNTER_ID);
    reltn.setMmIDs(mmIDs);
    List<String> asinKeys = new ArrayList<String>(2);
    asinKeys.add("1589944968");
    asinKeys.add("978-0874310412");
    reltn.setAsinKeys(asinKeys);
    
    List<Long> otherSites = new ArrayList<Long>(2);
    otherSites.add(111222L);
    otherSites.add(222333L);
    reltn.setOtherSites(otherSites);
    
    return reltn;
  }
  
  private static GameReltn createCosmicIncursionGameReltn() {
    GameReltn reltn = new GameReltn();
    
    reltn.setReltnID(COSMIC_INCURSION_RELTN_ID);
    reltn.setGameID(COSMIC_INCURSION_ID);
    reltn.setBggID(BGG_COSMIC_INCURSION_ID);
    List<Long> csiIDs = new ArrayList<Long>(1);
    csiIDs.add(CSI_COSMIC_INCURSION_ID);
    reltn.setCsiIDs(csiIDs);
    List<Long> mmIDs = new ArrayList<Long>(1);
    mmIDs.add(MM_COSMIC_INCURSION_ID);
    reltn.setMmIDs(mmIDs);
    List<String> asinKeys = new ArrayList<String>(1);
    asinKeys.add("B008KKG4OI");
    reltn.setAsinKeys(asinKeys);
    
    //No other site data for this item
    reltn.setOtherSites(null);
    
    return reltn;
  }
  
  /** Helper method to generate some game data to be used for validation */
  public static User createUserData(long userID) {
    if (userID == USER_ONE_ID)   return createUserOne();
    if (userID == USER_TWO_ID)   return createUserTwo();
    if (userID == USER_THREE_ID) return createUserThree();
    
    //Fail Case
    return null;
  }
  
  private static User createUserOne() {
    User user = new User();
    user.setUserID(USER_ONE_ID);
    user.setUserName("user_one");
    user.setFirstName("First");
    user.setLastName("Bobert");
    user.setEmailAddress("userone@test.com");
    user.setCollectionID(COLLECTION_ONE_ID);
    return user;
  }
  
  private static User createUserTwo() {
    User user = new User();
    user.setUserID(USER_TWO_ID);
    user.setUserName("user_two");
    user.setFirstName("Second");
    user.setLastName("Leopold");
    user.setEmailAddress("usertwo@test.com");
    user.setCollectionID(COLLECTION_TWO_ID);
    return user;
  }
  
  private static User createUserThree() {
    User user = new User();
    user.setUserID(USER_THREE_ID);
    user.setUserName("user_three");
    user.setFirstName("Third");
    user.setLastName("Louie");
    user.setEmailAddress("userthree@test.com");
    user.setCollectionID(COLLECTION_THREE_ID);
    return user;
  }

  /** Helper method to generate some game data to be used for validation */
  public static UserDetail createUserDetailData(long userID) {
    if (userID == USER_ONE_ID)   return createUserDetailOne();
    if (userID == USER_TWO_ID)   return createUserDetailTwo();
    if (userID == USER_THREE_ID) return createUserDetailThree();
    
    //Fail Case
    return null;
  }
  
  private static UserDetail createUserDetailOne() {
    UserDetail user = new UserDetail();
    user.setUserID(USER_ONE_ID);
    user.setPass("asdf");
    user.setUserRole(UserRole.USER);
    user.setCreatedOnDate(new Date(10000000));
    user.setLastLoginDate(new Date(10000000));
    return user;
  }
  
  private static UserDetail createUserDetailTwo() {
    UserDetail user = new UserDetail();
    user.setUserID(USER_TWO_ID);
    user.setPass("sdfg");
    user.setUserRole(UserRole.USER);
    user.setCreatedOnDate(new Date(20000000));
    user.setLastLoginDate(new Date(20000000));
    return user;
  }
  
  private static UserDetail createUserDetailThree() {
    UserDetail user = new UserDetail();
    user.setUserID(USER_THREE_ID);
    user.setPass("dfgh");
    user.setUserRole(UserRole.ADMIN);
    user.setCreatedOnDate(new Date(30000000));
    user.setLastLoginDate(new Date(30000000));
    return user;
  }

  public static Collection createCollectionData(long collectionID) {
    if (collectionID == COLLECTION_ONE_ID)   return createCollectionOne();
    if (collectionID == COLLECTION_TWO_ID)   return createCollectionTwo();
    if (collectionID == COLLECTION_THREE_ID) return createCollectionThree();
    
    //Fail Case
    return null;
  }
  
  private static Collection createCollectionOne() {
    Collection collection = new Collection();
    collection.setCollectionID(COLLECTION_ONE_ID);
    collection.setGames(new LinkedList<CollectionItem>());
    collection.setBaseGameCount(0);
    collection.setCollectibleGameCount(0);
    collection.setExpansionGameCount(0);
    return collection;
  }
  
  private static Collection createCollectionTwo() {
    Collection collection = new Collection();
    collection.setCollectionID(COLLECTION_TWO_ID);
    List<CollectionItem> games = new LinkedList<CollectionItem>();
    games.add(createCollectionItemThree());  //Abyss
    collection.setGames(games);
    collection.setBaseGameCount(1);
    collection.setCollectibleGameCount(0);
    collection.setExpansionGameCount(0);
    return collection;
  }
  
  private static Collection createCollectionThree() {
    Collection collection = new Collection();
    collection.setCollectionID(COLLECTION_THREE_ID);
    List<CollectionItem> games = new LinkedList<CollectionItem>();
    games.add(createCollectionItemOne());  //Cosmic Encounter
    collection.setGames(games);
    collection.setBaseGameCount(1);
    collection.setCollectibleGameCount(0);
    collection.setExpansionGameCount(0);
    return collection;
  }

  public static CollectionItem createCollectionItemData(long itemID) {
    if (itemID == COLLECTION_ITEM_ONE_ID)   return createCollectionItemOne();
    if (itemID == COLLECTION_ITEM_TWO_ID)   return createCollectionItemTwo();
    if (itemID == COLLECTION_ITEM_THREE_ID) return createCollectionItemThree();
    
    //Fail Case
    return null;
  }
  
  private static CollectionItem createCollectionItemOne() {
    CollectionItem item = new CollectionItem();
    item.setItemID(COLLECTION_ITEM_ONE_ID);
    Game game = createRealCosmicEncounterGame();
    item.setGameID(game.getGameID());
    item.setGame(game);
    List<GameWeight> weights = new ArrayList<GameWeight>(1);
    weights.add(GameWeight.MEDIUM);
    item.setWeights(weights);
    item.setDateAcquired(null);
    item.setWhereAcquired(null);
    return item;
  }
  
  private static CollectionItem createCollectionItemTwo() {
    CollectionItem item = new CollectionItem();
    item.setItemID(COLLECTION_ITEM_TWO_ID);
    Game game = createRealCosmicIncursionGame();
    item.setGameID(game.getGameID());
    item.setGame(game);
    List<GameWeight> weights = new ArrayList<GameWeight>(1);
    weights.add(GameWeight.HEAVY);
    item.setWeights(weights);
    item.setDateAcquired(new Date(10000000));
    item.setWhereAcquired("Amazon");
    return item;
  }
  
  private static CollectionItem createCollectionItemThree() {
    CollectionItem item = new CollectionItem();
    item.setItemID(COLLECTION_ITEM_THREE_ID);
    Game game = createRealAbyssGame();
    item.setGameID(game.getGameID());
    item.setGame(game);
    item.setWeights(null);
    item.setDateAcquired(new Date(12345678));
    item.setWhereAcquired(null);
    return item;
  }
  
  public static BGGGameStats createBGGGameStats() {
    BGGGameStats stats = new BGGGameStats();
    stats.setBaseGameCount(22367);
    stats.setExpansionGameCount(1243);
    stats.setCollectibleGameCount(134);
    stats.setApprovedCount(11111);
    stats.setRejectedCount(22222);
    stats.setPendingCount(3333);
    return stats;
  }
  
  public static CSIDataStats createCSIDataStats() {
    CSIDataStats stats = new CSIDataStats();
    stats.setBoardGameCount(13466);
    stats.setCollectibleGameCount(1234);
    stats.setDiceMastersCount(567);
    stats.setRpgCount(347);
    stats.setLcgCount(8315);
    stats.setSuppliesCount(2341);
    stats.setMiniatureCount(3567);
    stats.setVideoGameCount(1788);
    stats.setUnknownCount(1234);
    stats.setApprovedCount(44444);
    stats.setRejectedCount(55522);
    stats.setPendingCount(6677);
    return stats;
  }
  
  public static MMDataStats createMMDataStats() {
    MMDataStats stats = new MMDataStats();
    stats.setBoardGameCount(1235);
    stats.setTableTopCount(76724);
    stats.setCcgCount(1345);
    stats.setCollectiblesCount(6890);
    stats.setRpgCount(684);
    stats.setAccessoriesCount(834);
    stats.setApprovedCount(88899);
    stats.setRejectedCount(10112);
    stats.setPendingCount(2067);
    return stats;
  }
}
