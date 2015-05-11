package com.ac.games.rest.message;

/**
 * @author ac010168
 *
 */
public class SimpleMessageData {
  
  /** A placeholder for the error type.  This may get converted to an enum at some point. */
  private String messageType;
  /** The text we want returned for this message. */
  private String message;
  
  public SimpleMessageData() {
    messageType = "";
    message     = "";
  }
  
  public SimpleMessageData(String messageType, String message) {
    this.messageType = messageType;
    this.message     = message;
  }

  /**
   * @return the errorType
   */
  public String getMessageType() {
    return messageType;
  }

  /**
   * @return the errorMessage
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param messageType the messageType to set
   */
  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
