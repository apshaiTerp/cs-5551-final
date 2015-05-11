package com.ac.games.exception;

/**
 * @author ac010168
 *
 */
public class GameNotFoundException extends RuntimeException {
  
  /**
   * Serialized ID to allow this class to be serializable.
   */
  private static final long serialVersionUID = 7663676312434531106L;

  public GameNotFoundException(String message) {
    super(message);
  }

}
