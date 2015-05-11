package com.ac.games.data;

/**
 * @author ac010168
 *
 */
public class GameWeightConverter {

  /** Integer flag corresponding to no GameWeight set */
  public final static int DEFAULT_FLAG  = -1;
  /** Integer flag corresponding to the CHILDREN GameWeight set */
  public final static int CHILDREN_FLAG = 0;
  /** Integer flag corresponding to the FILLER GameWeight set */
  public final static int FILLER_FLAG   = 1;
  /** Integer flag corresponding to the SOCIAL GameWeight set */
  public final static int SOCIAL_FLAG   = 2;
  /** Integer flag corresponding to the LIGHT GameWeight set */
  public final static int LIGHT_FLAG    = 3;
  /** Integer flag corresponding to the FAMILY GameWeight set */
  public final static int FAMILY_FLAG   = 4;
  /** Integer flag corresponding to the MEDIUM GameWeight set */
  public final static int MEDIUM_FLAG   = 5;
  /** Integer flag corresponding to the HEAVY GameWeight set */
  public final static int HEAVY_FLAG    = 6;
  
  /**
   * Helper method to convert from GameWeight enum to a static flag value.
   * @param weight
   * @return
   */
  public static int convertGameWeightToFlag(GameWeight weight) {
    if (weight == null) return DEFAULT_FLAG;
    switch (weight) {
      case CHILDREN : return CHILDREN_FLAG;
      case FILLER   : return FILLER_FLAG;
      case SOCIAL   : return SOCIAL_FLAG;
      case LIGHT    : return LIGHT_FLAG;
      case FAMILY   : return FAMILY_FLAG;
      case MEDIUM   : return MEDIUM_FLAG;
      case HEAVY    : return HEAVY_FLAG;
      default       : return DEFAULT_FLAG;
    }
  }
  
  public static GameWeight convertFlagToGameWeight(int flag) {
    switch(flag) {
      case DEFAULT_FLAG  : return null;
      case CHILDREN_FLAG : return GameWeight.CHILDREN;
      case FILLER_FLAG   : return GameWeight.FILLER;
      case SOCIAL_FLAG   : return GameWeight.SOCIAL;
      case LIGHT_FLAG    : return GameWeight.LIGHT;
      case FAMILY_FLAG   : return GameWeight.FAMILY;
      case MEDIUM_FLAG   : return GameWeight.MEDIUM;
      case HEAVY_FLAG    : return GameWeight.HEAVY;
      default            : return null;
    }
  }
}
