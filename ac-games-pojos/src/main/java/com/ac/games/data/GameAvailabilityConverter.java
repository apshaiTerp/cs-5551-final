package com.ac.games.data;

/**
 * This class exists because even though Enums are serializable by default, they don't
 * serialize when converting through BSON, so we need to have a conversion mapper that
 * translates the Enum into a common flag to assist BSON parsing.
 *
 * @author ac010168
 */
public class GameAvailabilityConverter {

  /** Integer flag corresponding to no GameAvailability set */
  public final static int DEFAULT_FLAG            = -1;
  /** Integer flag corresponding to In Stock */
  public final static int INSTOCK_FLAG            = 0;
  /** Integer flag corresponding to Out of Stock */
  public final static int OUTOFSTOCK_FLAG         = 1;
  /** Integer flag corresponding to Pre Orders */
  public final static int PREORDER_FLAG           = 2;
  /** Integer flag corresponding to Not Yet Taking Orders */
  public final static int NOTYETTAKINGORDERS_FLAG = 3;
  
  /**
   * Helper method to convert from GameAvailability enum to a static flag value.
   * @param availability
   * @return
   */
  public static int convertGameAvailabilityToFlag(GameAvailability availability) {
    if (availability == null) return DEFAULT_FLAG;
    switch (availability) {
      case INSTOCK            : return INSTOCK_FLAG;
      case OUTOFSTOCK         : return OUTOFSTOCK_FLAG;
      case PREORDER           : return PREORDER_FLAG;
      case NOTYETTAKINGORDERS : return NOTYETTAKINGORDERS_FLAG;
      default                 : return DEFAULT_FLAG;
    }
  }
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static GameAvailability convertFlagToGameAvailability(int flag) {
    switch (flag) {
      case DEFAULT_FLAG            : return null;
      case INSTOCK_FLAG            : return GameAvailability.INSTOCK;
      case OUTOFSTOCK_FLAG         : return GameAvailability.OUTOFSTOCK;
      case PREORDER_FLAG           : return GameAvailability.PREORDER;
      case NOTYETTAKINGORDERS_FLAG : return GameAvailability.NOTYETTAKINGORDERS;
      default                      : return null;
    }
  }
}
