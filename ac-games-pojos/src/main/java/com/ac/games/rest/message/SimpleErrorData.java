package com.ac.games.rest.message;

/**
 * @author ac010168
 *
 */
public class SimpleErrorData {
  
  /** A placeholder for the error type.  This may get converted to an enum at some point. */
  private String errorType;
  /** The text we want returned for this message. */
  private String errorMessage;
  
  
  public SimpleErrorData() {
    errorType    = "";
    errorMessage = "";
  }
  
  public SimpleErrorData(String errorType, String errorMessage) {
    this.errorType    = errorType;
    this.errorMessage = errorMessage;
  }

  /**
   * @return the errorType
   */
  public String getErrorType() {
    return errorType;
  }

  /**
   * @param errorType the errorType to set
   */
  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  /**
   * @param errorMessage the errorMessage to set
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * @return the errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }
}
