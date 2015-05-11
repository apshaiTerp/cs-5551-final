package com.ac.games.data;

/**
 * @author ac010168
 *
 */
public class MediaItemTypeConverter {

  /** Integer flag corresponding to no MediaType found */
  public final static int DEFAULT_FLAG        = -1;
  /** Media Type indicating a Video Review */
  public final static int REVIEW_VIDEO_FLAG   = 0;
  /** Media Type indicating a Playthru Review */
  public final static int PLAYTHRU_VIDEO_FLAG = 1;
  /** Media Type indicating a Tutorial Review */
  public final static int TUTORIAL_VIDEO_FLAG = 2;
  /** Media Type indicating a Game Manual */
  public final static int RULES_MANUAL_FLAG   = 3;
  /** Media Type indicating a FAQ doc */
  public final static int FAQ_DOC_FLAG        = 4;
  /** Media Type indicating a User Image */
  public final static int USER_IMAGE_FLAG     = 5;
  /** Media Type indicating a User Video */
  public final static int USER_VIDEO_FLAG     = 6;
  /** Media Type indicating a User Link */
  public final static int USER_LINK_FLAG      = 7;
  
  /**
   * Helper method to convert from MediaItemType to an integer flag.
   * @param type
   * @return
   */
  public static int convertMediaItemTypeToFlag(MediaItemType type) {
    if (type == null) return DEFAULT_FLAG;
    switch (type) {
      case REVIEW_VIDEO   : return REVIEW_VIDEO_FLAG;
      case PLAYTHRU_VIDEO : return PLAYTHRU_VIDEO_FLAG;
      case TUTORIAL_VIDEO : return TUTORIAL_VIDEO_FLAG;
      case RULES_MANUAL   : return RULES_MANUAL_FLAG;
      case FAQ_DOC        : return FAQ_DOC_FLAG;
      case USER_IMAGE     : return USER_IMAGE_FLAG;
      case USER_VIDEO     : return USER_VIDEO_FLAG;
      case USER_LINK      : return USER_LINK_FLAG;
      default             : return DEFAULT_FLAG;
    }
  }
  
  /**
   * Helper method to convert from Flag back to MediaItemType
   * @param flag
   * @return
   */
  public static MediaItemType convertFlagToMediaItemType(int flag) {
    switch (flag) {
      case REVIEW_VIDEO_FLAG   : return MediaItemType.REVIEW_VIDEO;
      case PLAYTHRU_VIDEO_FLAG : return MediaItemType.PLAYTHRU_VIDEO;
      case TUTORIAL_VIDEO_FLAG : return MediaItemType.TUTORIAL_VIDEO;
      case RULES_MANUAL_FLAG   : return MediaItemType.RULES_MANUAL;
      case FAQ_DOC_FLAG        : return MediaItemType.FAQ_DOC;
      case USER_IMAGE_FLAG     : return MediaItemType.USER_IMAGE;
      case USER_VIDEO_FLAG     : return MediaItemType.USER_VIDEO;
      case USER_LINK_FLAG      : return MediaItemType.USER_LINK;
      default                  : return null;
    }
  }
}
