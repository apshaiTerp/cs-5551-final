package com.ac.games.rest.data;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Placeholder class for Admin Login Data
 * 
 * @author ac010168
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginData {

  private String userName;
  private String password;
  
  public LoginData() {
    userName     = null;
    password     = null;
  }
  
  public LoginData(String jsonString) {
    super();
    ObjectMapper mapper = new ObjectMapper();
    try {
      LoginData jsonData = mapper.readValue(jsonString, LoginData.class);
      setUserName(jsonData.getUserName());
      setPassword(jsonData.getPassword());
    } catch (JsonParseException jpe) {
      jpe.printStackTrace();
    } catch (JsonMappingException jme) {
      jme.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  
  public LoginData(String userName, String emailAddress, String password) {
    setUserName(userName);
    setPassword(password);
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
