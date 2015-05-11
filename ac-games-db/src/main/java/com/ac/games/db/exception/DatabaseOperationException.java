package com.ac.games.db.exception;

/**
 * This Exception should be thrown when a database operation fails to complete.
 * This is to help mask the difference between underlying systems, standing in
 * as a replacement for more common Exceptions like SQLException.
 * 
 * @author ac010168
 *
 */
public class DatabaseOperationException extends RuntimeException {

  /**
   * Serializable ID
   */
  private static final long serialVersionUID = -1979844211911570622L;
  
  public DatabaseOperationException(String message) {
    super(message);
  }
  
  public DatabaseOperationException(Throwable t) {
    super(t);
  }

  public DatabaseOperationException(String message, Throwable parentThrowable) {
    super(message, parentThrowable);
  }
}
