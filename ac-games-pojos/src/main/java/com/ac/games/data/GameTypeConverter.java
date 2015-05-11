package com.ac.games.data;

/**
 * This class exists because even though Enums are serializable by default, they don't
 * serialize when converting through BSON, so we need to have a conversion mapper that
 * translates the Enum into a common flag to assist BSON parsing.
 * 
 * @author ac010168
 */
public class GameTypeConverter {
  
  /** Integer flag corresponding to no GameType set */
  public final static int DEFAULT_FLAG     = -1;
  /** Integer flag corresponding to GameType.BASE */
  public final static int BASE_FLAG        = 0;
  /** Integer flag corresponding to GameType.EXPANSION */
  public final static int EXPANSION_FLAG   = 1;
  /** Integer flag corresponding to GameType,COLLECTIBLE */
  public final static int COLLECTIBLE_FLAG = 2;

  /**
   * Helper method to convert from GameType enum to a static flag value.
   * @param type
   * @return
   */
  public static int convertGameTypeToFlag(GameType type) {
    if (type == null) return DEFAULT_FLAG;
    switch (type) {
      case BASE        : return BASE_FLAG;
      case EXPANSION   : return EXPANSION_FLAG;
      case COLLECTIBLE : return COLLECTIBLE_FLAG;
      default          : return DEFAULT_FLAG;
    }
  }
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static GameType convertFlagToGameType(int flag) {
    switch (flag) {
      case DEFAULT_FLAG     : return null;
      case BASE_FLAG        : return GameType.BASE;
      case EXPANSION_FLAG   : return GameType.EXPANSION;
      case COLLECTIBLE_FLAG : return GameType.COLLECTIBLE;
      default               : return null;
    }
  }
}
