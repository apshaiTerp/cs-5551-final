package com.ac.games.data;

/**
 * @author ac010168
 *
 */
public class UserRoleConverter {

  /** Integer flag corresponding to no UserRole set */
  public final static int DEFAULT_FLAG = -1;
  /** Integer flag corresponding to the Admin UserRole set */
  public final static int ADMIN_FLAG   = 0;
  /** Integer flag corresponding to the User UserRole set */
  public final static int USER_FLAG    = 1;

  /**
   * Helper method to convert from UserRole enum to a static flag value.
   * @param role
   * @return
   */
  public static int convertUserRoleToFlag(UserRole role) {
    if (role == null) return DEFAULT_FLAG;
    switch (role) {
      case ADMIN : return ADMIN_FLAG;
      case USER  : return USER_FLAG;
      default    : return DEFAULT_FLAG;
    }
  }
  
  /**
   * Helper method to convert from static flag value to enum.
   * @param flag
   * @return
   */
  public static UserRole convertFlagToUserRole(int flag) {
    switch (flag) {
      case DEFAULT_FLAG : return null;
      case ADMIN_FLAG   : return UserRole.ADMIN;
      case USER_FLAG    : return UserRole.USER;
      default           : return null;
    }
  }
}
