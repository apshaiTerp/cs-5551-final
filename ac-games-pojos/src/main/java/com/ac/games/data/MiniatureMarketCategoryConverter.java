package com.ac.games.data;

/**
 * @author ac010168
 *
 */
public class MiniatureMarketCategoryConverter {

  /** Integer flag corresponding to no CoolStuffIncCategory found */
  public final static int DEFAULT_FLAG      = -1;
  /** Integer flag corresponding to CCGs */
  public final static int BOARDGAMES_FLAG   = 0; 
  /** Integer flag corresponding to Dice Masters (which is a subtype of CCG that matters) */
  public final static int TABLETOP_FLAG     = 1;
  /** Integer flag corresponding to CCGs */
  public final static int CCGS_FLAG         = 2;
  /** Integer flag corresponding to LCGs */
  public final static int LCGS_FLAG         = 3;
  /** Integer flag corresponding to Role Playing Games */
  public final static int COLLECTIBLES_FLAG = 4;
  /** Integer flag corresponding to Living Card Games */
  public final static int RPGS_FLAG         = 5;
  /** Integer flag corresponding to Supplies */
  public final static int ACCESSORIES_FLAG  = 6;
  /** Integer flag corresponding to Miniatures */
  public final static int UNKNOWN_FLAG      = 7;
  
  /**
   * Helper method to convert from MiniatureMarketCategory enum to a static flag value.
   * @param category
   * @return
   */
  public static int convertMMCategoryToFlag(MiniatureMarketCategory category) {
    if (category == null) return DEFAULT_FLAG;
    switch (category) {
      case BOARDGAMES   : return BOARDGAMES_FLAG;
      case TABLETOP     : return TABLETOP_FLAG;
      case CCGS         : return CCGS_FLAG;
      case LCGS         : return LCGS_FLAG;
      case COLLECTIBLES : return COLLECTIBLES_FLAG;
      case RPGS         : return RPGS_FLAG;
      case ACCESSORIES  : return ACCESSORIES_FLAG;
      case UNKNOWN      : return UNKNOWN_FLAG;
      default           : return DEFAULT_FLAG;
    }
  }

  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static MiniatureMarketCategory convertFlagToMMCategory(int flag) {
    switch (flag) {
      case BOARDGAMES_FLAG   : return MiniatureMarketCategory.BOARDGAMES;
      case TABLETOP_FLAG     : return MiniatureMarketCategory.TABLETOP;
      case CCGS_FLAG         : return MiniatureMarketCategory.CCGS;
      case LCGS_FLAG         : return MiniatureMarketCategory.LCGS;
      case COLLECTIBLES_FLAG : return MiniatureMarketCategory.COLLECTIBLES;
      case RPGS_FLAG         : return MiniatureMarketCategory.RPGS;
      case ACCESSORIES_FLAG  : return MiniatureMarketCategory.ACCESSORIES;
      case UNKNOWN_FLAG      : return MiniatureMarketCategory.UNKNOWN;
      default                : return null;
    }
  }
}
