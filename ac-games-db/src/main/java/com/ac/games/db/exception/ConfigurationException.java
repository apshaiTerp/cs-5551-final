package com.ac.games.db.exception;

/**
 * This Exception should be thrown when a database connection cannot be instantiated.
 * 
 * @author ac010168
 *
 */
public class ConfigurationException extends Exception {

  /**
   * Serializable ID.
   */
  private static final long serialVersionUID = -8957304309652539707L;

  public ConfigurationException(String message) {
    super (message);
  }
  
  public ConfigurationException(Throwable t) {
    super (t);
  }
  
  public ConfigurationException(String message, Throwable parentThrowable) {
    super (message, parentThrowable);
  }
}
