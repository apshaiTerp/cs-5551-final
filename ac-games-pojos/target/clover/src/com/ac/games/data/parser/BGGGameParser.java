/* $$ This file has been instrumented by Clover 3.3.0#2014033113020816 $$ */package com.ac.games.data.parser;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ac.games.data.BGGGame;
import com.ac.games.data.GameType;
import com.ac.games.exception.GameNotFoundException;

/**
 * This class should take the XML body output from the BGG API for a single game
 * (examples are http://www.boardgamegeek.com/xmlapi/boardgame/<id>?stats=1) and
 * convert it into a {@link BGGGame} object.
 * 
 * @author ac010168
 */
public class BGGGameParser {public static class __CLR3_3_01k71k7i96a0zyc{public static com_cenqua_clover.CoverageRecorder R;public static com_cenqua_clover.CloverProfile[] profiles = { };static{com_cenqua_clover.CoverageRecorder _R=null;try{com_cenqua_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___3_3_0();if(2014033113020816L!=com_cenqua_clover.CloverVersionInfo.getBuildStamp()){com_cenqua_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_cenqua_clover.Clover.l("[CLOVER] WARNING: Instr=3.3.0#2014033113020816,Runtime="+com_cenqua_clover.CloverVersionInfo.getReleaseNum()+"#"+com_cenqua_clover.CloverVersionInfo.getBuildStamp());}R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getNullRecorder();_R=com_cenqua_clover.Clover.getRecorder("\u002f\u0055\u0073\u0065\u0072\u0073\u002f\u0061\u0063\u0030\u0031\u0030\u0031\u0036\u0038\u002f\u0044\u006f\u0063\u0075\u006d\u0065\u006e\u0074\u0073\u002f\u0075\u006d\u006b\u0063\u002f\u0061\u0063\u002d\u0067\u0061\u006d\u0065\u0073\u002d\u0070\u006f\u006a\u006f\u0073\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1430525633807L,8589935092L,2244,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}
  
  public static boolean debugMode = false;

  /** A basic date formatter object.  We'll use it to condense dates. */
  public final static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-dd HH:mm:ss.SSS");
  
  /**
   * This is a static method used to help parse out {@link BGGGame} content from the BGG XML API
   * request.  This method should generate a complete object, or fail.
   * 
   * @param xmlContent The XML string received from the GET request
   * @return a {@link BGGGame} object fully parsed
   * @throws Throwable Throws this error if there were any parsing issues or other problems
   */
  public static BGGGame parseBGGXML(String xmlContent) throws Throwable {try{__CLR3_3_01k71k7i96a0zyc.R.inc(2023);
    __CLR3_3_01k71k7i96a0zyc.R.inc(2024);Date startDate = null;
    __CLR3_3_01k71k7i96a0zyc.R.inc(2025);if ((((debugMode)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2026)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2027)==0&false))) {{
      __CLR3_3_01k71k7i96a0zyc.R.inc(2028);startDate = new Date();
      __CLR3_3_01k71k7i96a0zyc.R.inc(2029);System.out.println ("Starting Parse at " + dateFormatter.format(startDate));
    }
    
    //First, check for the 'we didn't find what you wanted' message
    }__CLR3_3_01k71k7i96a0zyc.R.inc(2030);int hasGameIDTag = xmlContent.indexOf("<boardgame objectid");
    __CLR3_3_01k71k7i96a0zyc.R.inc(2031);int hasErrorTag  = xmlContent.indexOf("<error message=\"Item not found\"/>");
    __CLR3_3_01k71k7i96a0zyc.R.inc(2032);if (((((hasGameIDTag == -1) && (hasErrorTag != -1))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2033)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2034)==0&false)))
      {__CLR3_3_01k71k7i96a0zyc.R.inc(2035);throw new GameNotFoundException("This game does not exist in the BoardGameGeek library");
      
    }__CLR3_3_01k71k7i96a0zyc.R.inc(2036);DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    __CLR3_3_01k71k7i96a0zyc.R.inc(2037);DocumentBuilder builder        = factory.newDocumentBuilder();
    __CLR3_3_01k71k7i96a0zyc.R.inc(2038);InputSource is                 = new InputSource();
    __CLR3_3_01k71k7i96a0zyc.R.inc(2039);is.setCharacterStream(new StringReader(xmlContent));
    __CLR3_3_01k71k7i96a0zyc.R.inc(2040);Document gameDoc = builder.parse(is);
  
    __CLR3_3_01k71k7i96a0zyc.R.inc(2041);BGGGame game = new BGGGame();
    
    //Begin inspecting all nodes
    __CLR3_3_01k71k7i96a0zyc.R.inc(2042);NodeList nodeList = gameDoc.getDocumentElement().getChildNodes();
    __CLR3_3_01k71k7i96a0zyc.R.inc(2043);for (int i = 0; (((i < nodeList.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2044)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2045)==0&false)); i++) {{
      __CLR3_3_01k71k7i96a0zyc.R.inc(2046);Node node = nodeList.item(i);
      
      __CLR3_3_01k71k7i96a0zyc.R.inc(2047);if ((((node.getNodeType() == Node.ELEMENT_NODE)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2048)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2049)==0&false))) {{
        __CLR3_3_01k71k7i96a0zyc.R.inc(2050);Element elem = (Element)node;
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2051);String objectID = node.getAttributes().getNamedItem("objectid").getNodeValue();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2052);game.setBggID(Long.parseLong(objectID));
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2053);if (((((elem.getElementsByTagName("yearpublished").getLength() != 0) && (elem.getElementsByTagName("yearpublished").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2054)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2055)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2056);Integer yearPublishedValue  = Integer.parseInt(elem.getElementsByTagName("yearpublished").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2057);game.setYearPublished(yearPublishedValue);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2058);if (((((elem.getElementsByTagName("maxplayers").getLength() != 0) && (elem.getElementsByTagName("maxplayers").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2059)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2060)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2061);Integer maxPlayerValue      = Integer.parseInt(elem.getElementsByTagName("maxplayers").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2062);game.setMaxPlayers(maxPlayerValue);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2063);if (((((elem.getElementsByTagName("minplayers").getLength() != 0) && (elem.getElementsByTagName("minplayers").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2064)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2065)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2066);Integer minPlayerValue      = Integer.parseInt(elem.getElementsByTagName("minplayers").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2067);game.setMinPlayers(minPlayerValue);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2068);if (((((elem.getElementsByTagName("maxplaytime").getLength() != 0) && (elem.getElementsByTagName("maxplaytime").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2069)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2070)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2071);Integer maxPlayingTimeValue = Integer.parseInt(elem.getElementsByTagName("maxplaytime").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2072);game.setMaxPlayingTime(maxPlayingTimeValue);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2073);if (((((elem.getElementsByTagName("minplaytime").getLength() != 0) && (elem.getElementsByTagName("minplaytime").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2074)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2075)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2076);Integer minPlayingTimeValue = Integer.parseInt(elem.getElementsByTagName("minplaytime").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2077);game.setMinPlayingTime(minPlayingTimeValue);
        }        
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2078);if (((((elem.getElementsByTagName("image").getLength() != 0) && (elem.getElementsByTagName("image").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2079)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2080)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2081);String imageValue          = "http:" + elem.getElementsByTagName("image").item(0).getChildNodes().item(0).getNodeValue();
          __CLR3_3_01k71k7i96a0zyc.R.inc(2082);game.setImageURL(imageValue);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2083);if (((((elem.getElementsByTagName("thumbnail").getLength() != 0) && (elem.getElementsByTagName("thumbnail").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2084)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2085)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2086);String imageThumbnailValue = "http:" + elem.getElementsByTagName("thumbnail").item(0).getChildNodes().item(0).getNodeValue();
          __CLR3_3_01k71k7i96a0zyc.R.inc(2087);game.setImageThumbnailURL(imageThumbnailValue);
        }
        
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2088);String description         = elem.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2089);game.setDescription(description);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2090);String nameValue           = "Could not be found";
        __CLR3_3_01k71k7i96a0zyc.R.inc(2091);NodeList nameElements = elem.getElementsByTagName("name");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2092);for (int j = 0; (((j < nameElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2093)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2094)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2095);Node nameNode = nameElements.item(j);
          __CLR3_3_01k71k7i96a0zyc.R.inc(2096);if ((((nameNode.getAttributes().getNamedItem("primary") != null)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2097)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2098)==0&false)))
            {__CLR3_3_01k71k7i96a0zyc.R.inc(2099);nameValue = nameNode.getChildNodes().item(0).getNodeValue();
        }}
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2100);game.setName(nameValue);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2101);List<String> publishers = new LinkedList<String>();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2102);NodeList publisherElements = elem.getElementsByTagName("boardgamepublisher");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2103);for (int j = 0; (((j < publisherElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2104)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2105)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2106);publishers.add(publisherElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2107);game.setPublishers(publishers);

        __CLR3_3_01k71k7i96a0zyc.R.inc(2108);List<String> designers = new LinkedList<String>();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2109);NodeList designerElements = elem.getElementsByTagName("boardgamedesigner");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2110);for (int j = 0; (((j < designerElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2111)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2112)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2113);designers.add(designerElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2114);game.setDesigners(designers);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2115);List<String> categories = new LinkedList<String>();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2116);NodeList categoryElements = elem.getElementsByTagName("boardgamecategory");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2117);for (int j = 0; (((j < categoryElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2118)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2119)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2120);categories.add(categoryElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2121);game.setCategories(categories);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2122);List<String> mechanisms = new LinkedList<String>();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2123);NodeList mechanicElements = elem.getElementsByTagName("boardgamemechanic");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2124);for (int j = 0; (((j < mechanicElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2125)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2126)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2127);mechanisms.add(mechanicElements.item(j).getChildNodes().item(0).getNodeValue());
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2128);game.setMechanisms(mechanisms);
        
        //Figure out the GameType and some of the dependent fields
        __CLR3_3_01k71k7i96a0zyc.R.inc(2129);GameType gameType = null;
        
        //Figure out the extra fields
        __CLR3_3_01k71k7i96a0zyc.R.inc(2130);List<Long> expansionGames = new LinkedList<Long>();
        __CLR3_3_01k71k7i96a0zyc.R.inc(2131);NodeList expansionElements = elem.getElementsByTagName("boardgameexpansion");
        
        //If there are no hits, this is a standalone game and therefore a base
        __CLR3_3_01k71k7i96a0zyc.R.inc(2132);if ((((expansionElements.getLength() == 0)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2133)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2134)==0&false)))
          {__CLR3_3_01k71k7i96a0zyc.R.inc(2135);gameType = GameType.BASE;
        }else {{
          //Assume it's a Base, then confirm whether it's an expansion
          __CLR3_3_01k71k7i96a0zyc.R.inc(2136);gameType = GameType.BASE;
          //Search the element list.  The game name doesn't matter as much as does the id embedded as an attribute
          __CLR3_3_01k71k7i96a0zyc.R.inc(2137);for (int j = 0; (((j < expansionElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2138)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2139)==0&false)); j++) {{
            __CLR3_3_01k71k7i96a0zyc.R.inc(2140);Node expansionNode = expansionElements.item(j);
            __CLR3_3_01k71k7i96a0zyc.R.inc(2141);long subGameID = Long.parseLong(expansionNode.getAttributes().getNamedItem("objectid").getNodeValue());

            //If we have the inbound tag, that indicates a leaf node, or in other words, and Expansion title
            __CLR3_3_01k71k7i96a0zyc.R.inc(2142);if ((((expansionNode.getAttributes().getNamedItem("inbound") != null)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2143)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2144)==0&false))) {{
              __CLR3_3_01k71k7i96a0zyc.R.inc(2145);gameType = GameType.EXPANSION;
              __CLR3_3_01k71k7i96a0zyc.R.inc(2146);game.setParentGameID(subGameID);
            } }else {__CLR3_3_01k71k7i96a0zyc.R.inc(2147);expansionGames.add(subGameID);
          }}
          }__CLR3_3_01k71k7i96a0zyc.R.inc(2148);if ((((gameType == GameType.BASE)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2149)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2150)==0&false)))
            {__CLR3_3_01k71k7i96a0zyc.R.inc(2151);game.setExpansionIDs(expansionGames);
        }}

        //Logic around how to figure out base game or expansion needs to go here
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2152);NodeList familyElements = elem.getElementsByTagName("boardgamefamily");
        __CLR3_3_01k71k7i96a0zyc.R.inc(2153);for (int j = 0; (((j < familyElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2154)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2155)==0&false)); j++) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2156);String family = familyElements.item(j).getChildNodes().item(0).getNodeValue();
          __CLR3_3_01k71k7i96a0zyc.R.inc(2157);if (((((family.equalsIgnoreCase("CCGs (Collectible Card Games)")) && (gameType == GameType.BASE))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2158)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2159)==0&false)))
            {__CLR3_3_01k71k7i96a0zyc.R.inc(2160);gameType = GameType.COLLECTIBLE;
        }}
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2161);game.setGameType(gameType);
        
        //Now gather statistics
        __CLR3_3_01k71k7i96a0zyc.R.inc(2162);Element statsElement   = (Element)elem.getElementsByTagName("statistics").item(0);
        __CLR3_3_01k71k7i96a0zyc.R.inc(2163);Element ratingsElement = (Element)statsElement.getElementsByTagName("ratings").item(0);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2164);if (((((ratingsElement.getElementsByTagName("average").getLength() != 0) && (ratingsElement.getElementsByTagName("average").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2165)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2166)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2167);Double average     = Double.parseDouble(ratingsElement.getElementsByTagName("average").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2168);game.setBggRating(average);
        }
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2169);if (((((ratingsElement.getElementsByTagName("usersrated").getLength() != 0) && (ratingsElement.getElementsByTagName("usersrated").item(0).getChildNodes().getLength() != 0))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2170)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2171)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2172);Integer usersRated = Integer.parseInt(ratingsElement.getElementsByTagName("usersrated").item(0).getChildNodes().item(0).getNodeValue());
          __CLR3_3_01k71k7i96a0zyc.R.inc(2173);game.setBggRatingUsers(usersRated);
        }
        
        //Only get the bggRank if not an expansion
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2174);if ((((gameType != GameType.EXPANSION)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2175)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2176)==0&false))) {{
          __CLR3_3_01k71k7i96a0zyc.R.inc(2177);Element ranksElement = (Element)ratingsElement.getElementsByTagName("ranks").item(0);
          __CLR3_3_01k71k7i96a0zyc.R.inc(2178);NodeList rankElements = ranksElement.getElementsByTagName("rank");
          __CLR3_3_01k71k7i96a0zyc.R.inc(2179);for (int j = 0; (((j < rankElements.getLength())&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2180)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2181)==0&false)); j++) {{
            __CLR3_3_01k71k7i96a0zyc.R.inc(2182);Node rankNode = rankElements.item(j);
            __CLR3_3_01k71k7i96a0zyc.R.inc(2183);if ((((rankNode.getAttributes().getNamedItem("type") != null)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2184)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2185)==0&false))) {{
              __CLR3_3_01k71k7i96a0zyc.R.inc(2186);String rankTypeValue = rankNode.getAttributes().getNamedItem("type").getNodeValue();
              __CLR3_3_01k71k7i96a0zyc.R.inc(2187);String rankNameValue = rankNode.getAttributes().getNamedItem("name").getNodeValue();
              
              //If the game can have a ranking, that doesn't mean one is defined yet.  Make sure to check
              //to prevent NumberFormatExceptions.
              __CLR3_3_01k71k7i96a0zyc.R.inc(2188);if ((((rankTypeValue.equalsIgnoreCase("subtype") && rankNameValue.equalsIgnoreCase("boardgame"))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2189)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2190)==0&false))) {{
                __CLR3_3_01k71k7i96a0zyc.R.inc(2191);String rankString = rankNode.getAttributes().getNamedItem("value").getNodeValue();
                __CLR3_3_01k71k7i96a0zyc.R.inc(2192);if ((((rankString.equalsIgnoreCase("Not Ranked"))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2193)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2194)==0&false)))
                  {__CLR3_3_01k71k7i96a0zyc.R.inc(2195);game.setBggRank(BGGGame.NOT_RANKED_RANKING);
                }else {{
                  __CLR3_3_01k71k7i96a0zyc.R.inc(2196);Integer rank = Integer.parseInt(rankString);
                  __CLR3_3_01k71k7i96a0zyc.R.inc(2197);game.setBggRank(rank);
                }
              }}
            }}
            
          }}
        }}
        
        //if (debugMode)
        //  game.printContentsForDebug();
      }}
    }}

    }__CLR3_3_01k71k7i96a0zyc.R.inc(2198);if ((((debugMode)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2199)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2200)==0&false))) {{
      __CLR3_3_01k71k7i96a0zyc.R.inc(2201);Date endDate = new Date();
      __CLR3_3_01k71k7i96a0zyc.R.inc(2202);System.out.println ("Ending Parse at " + dateFormatter.format(endDate));
      __CLR3_3_01k71k7i96a0zyc.R.inc(2203);double trueElapsed = ((double)(endDate.getTime() - startDate.getTime())) / 1000.0;
      __CLR3_3_01k71k7i96a0zyc.R.inc(2204);System.out.println ("Total Elapsed Time: [" + trueElapsed + " s.]");
    }

    }__CLR3_3_01k71k7i96a0zyc.R.inc(2205);return game;
  }finally{__CLR3_3_01k71k7i96a0zyc.R.flushNeeded();}}
  
  /**
   * This method is designed to allow us to parse mutiple board game requests.  These
   * are results that are bound between {code}<boardgame objectid=".."..> and </boardgame>{code}.
   * This method should break the provided XML into the smaller sub-game blocks of XML and
   * allow the regular {@link #parseBGGXML(String)} method to process them as expected.
   * 
   * @param xmlContent The full XML string involved.
   * 
   * @return A List of {@link BGGGame} objects, or an empty list if none found.
   * 
   * @throws Throwable Throws if something goes wrong during parsing.
   */
  public static List<BGGGame> parseMultiBGGXML(String xmlContent) throws Throwable {try{__CLR3_3_01k71k7i96a0zyc.R.inc(2206);
    //First, check for the 'we didn't find what you wanted' message
    __CLR3_3_01k71k7i96a0zyc.R.inc(2207);int hasGameIDTag = xmlContent.indexOf("<boardgame objectid");
    __CLR3_3_01k71k7i96a0zyc.R.inc(2208);int hasErrorTag  = xmlContent.indexOf("<error message=\"Item not found\"/>");
    __CLR3_3_01k71k7i96a0zyc.R.inc(2209);if (((((hasGameIDTag == -1) && (hasErrorTag != -1))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2210)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2211)==0&false)))
      {__CLR3_3_01k71k7i96a0zyc.R.inc(2212);throw new GameNotFoundException("These games do not exist in the BoardGameGeek library");
    
    }__CLR3_3_01k71k7i96a0zyc.R.inc(2213);List<BGGGame> foundGames = new LinkedList<BGGGame>();
    __CLR3_3_01k71k7i96a0zyc.R.inc(2214);while (true) {{
      __CLR3_3_01k71k7i96a0zyc.R.inc(2215);int startGameTag = xmlContent.indexOf("<boardgame objectid");
      __CLR3_3_01k71k7i96a0zyc.R.inc(2216);int endGameTag   = xmlContent.indexOf("</boardgame>");
      
      //If true, we've hit the end of the games list.
      __CLR3_3_01k71k7i96a0zyc.R.inc(2217);if (((((startGameTag == -1) && (endGameTag == -1))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2218)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2219)==0&false))) {{
        __CLR3_3_01k71k7i96a0zyc.R.inc(2220);break;
      }
      //If we have a start, but not a close, we have malformed XML
      }__CLR3_3_01k71k7i96a0zyc.R.inc(2221);if (((((startGameTag != -1) && (endGameTag == -1))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2222)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2223)==0&false))) {{
        __CLR3_3_01k71k7i96a0zyc.R.inc(2224);throw new RuntimeException ("The List XML was malformed: open <boardgame> without close.");
      }
      //If we have a close, but not a start, we have malformed XML
      }__CLR3_3_01k71k7i96a0zyc.R.inc(2225);if (((((startGameTag != -1) && (endGameTag == -1))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2226)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2227)==0&false))) {{
        __CLR3_3_01k71k7i96a0zyc.R.inc(2228);throw new RuntimeException ("The List XML was malformed: close </boardgame> without open.");
      }
      
      //We've got to check to see if there's a nested boardgametag within a game, which for some reason
      //does happen from time to time.
      }__CLR3_3_01k71k7i96a0zyc.R.inc(2229);int nestedGameTag = xmlContent.indexOf("<boardgame objectid", startGameTag + 20);
      __CLR3_3_01k71k7i96a0zyc.R.inc(2230);while (((((nestedGameTag != -1) && (nestedGameTag < endGameTag))&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2231)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2232)==0&false))) {{
        __CLR3_3_01k71k7i96a0zyc.R.inc(2233);endGameTag = xmlContent.indexOf("</boardgame>", endGameTag + 10);
        
        __CLR3_3_01k71k7i96a0zyc.R.inc(2234);if ((((endGameTag == -1)&&(__CLR3_3_01k71k7i96a0zyc.R.iget(2235)!=0|true))||(__CLR3_3_01k71k7i96a0zyc.R.iget(2236)==0&false)))
          {__CLR3_3_01k71k7i96a0zyc.R.inc(2237);throw new RuntimeException("The List XML was malformed: Nested <boardgame> tag unclosed properly");
       
        }__CLR3_3_01k71k7i96a0zyc.R.inc(2238);nestedGameTag = xmlContent.indexOf("<boardgame objectid", nestedGameTag + 20);
      }
      
      //Generate substring that includes start and end tag content.
      }__CLR3_3_01k71k7i96a0zyc.R.inc(2239);String singleGameXML = "<boardgames>" + xmlContent.substring(startGameTag, endGameTag + 12) + "</boardgames>";
      
      __CLR3_3_01k71k7i96a0zyc.R.inc(2240);BGGGame singleGame = parseBGGXML(singleGameXML);
      __CLR3_3_01k71k7i96a0zyc.R.inc(2241);foundGames.add(singleGame);
      
      __CLR3_3_01k71k7i96a0zyc.R.inc(2242);xmlContent = xmlContent.substring(endGameTag + 12);
    }
    }__CLR3_3_01k71k7i96a0zyc.R.inc(2243);return foundGames;
  }finally{__CLR3_3_01k71k7i96a0zyc.R.flushNeeded();}}
}
