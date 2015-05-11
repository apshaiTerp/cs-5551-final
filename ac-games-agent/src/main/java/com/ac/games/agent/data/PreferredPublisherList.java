package com.ac.games.agent.data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ac010168
 *
 */
public class PreferredPublisherList {
  
  public static List<String> getTrustedPublishers() {
    List<String> trustList = new LinkedList<String>();
    trustList.add("Rio Grande Games");
    trustList.add("Asmodee");
    trustList.add("Fantasy Flight Games");
    trustList.add("Alderac Entertainment Group");
    trustList.add("Z-Man Games");
    trustList.add("Mayfair Games");
    trustList.add("Avalon Hill");
    trustList.add("Eagle-Gryphon Games");
    trustList.add("Steve Jackson Games");
    trustList.add("WizKids Games");
    trustList.add("Days of Wonder");
    trustList.add("Portal Games");
    trustList.add("Plaid Hat Games");
    trustList.add("IELLO");
    trustList.add("Tasty Minstrel Games");
    trustList.add("Arcane Wonders");
    trustList.add("Gamelyn Games");
    trustList.add("G3");
    trustList.add("Grey Gnome Games");
    trustList.add("Czech Games Edition");
    trustList.add("Wizards of the Coast");
    trustList.add("Cool Mini Or Not");
    trustList.add("Academy Games");
    trustList.add("Stronghold Games");
    trustList.add("Indie Boards and Cards");
    trustList.add("GMT Games");
    trustList.add("Common Man Games");
    trustList.add("Stonemaier Games");
    trustList.add("Queen Games");
    trustList.add("Dice Hate Me Games");
    trustList.add("Greater Than Games, LLC");
    trustList.add("Ravensburger Spieleverlag GmbH");
    trustList.add("Bezier Games, Inc.");
    trustList.add("HABA - Habermaaß GmbH");
    trustList.add("IDW Games");
    trustList.add("Ystari Games");
    trustList.add("Gamewright");
    trustList.add("Hans im Glück Verlags-GmbH");
    trustList.add("Minion Games");
    trustList.add("R&R Games");
    trustList.add("Cryptozoic Entertainment");
    trustList.add("Lookout Games");
    trustList.add("Cheapass Games");
    trustList.add("Paizo Publishing");
    trustList.add("Calliope Games");
    trustList.add("KOSMOS");
    trustList.add("Flying Frog Productions");
    trustList.add("Funforge");
    trustList.add("Victory Point Games");
    trustList.add("White Goblin Games");
    trustList.add("Level 99 Games");
    trustList.add("Treefrog Games");
    trustList.add("Happy Mitten Games");
    trustList.add("Game Salute");
    trustList.add("Looney Labs");
    trustList.add("Japanime Games");
    trustList.add("Hasbro");
    trustList.add("Parker Brothers");
    trustList.add("Milton Bradley");
    trustList.add("Mattel");
    trustList.add("Red Raven Games");
    trustList.add("Columbia Games");
    trustList.add("Ares Games");
    trustList.add("Upper Deck Entertainment");
    trustList.add("Games Workshop Ltd.");
    trustList.add("Petersen Games");

    return trustList;
  }

  public static List<String> getAvoidPublishers() {
    List<String> avoidList = new LinkedList<String>();
    avoidList.add("(Self-published)");
    avoidList.add("(Web published)");
    avoidList.add("(Unpublished)");
    avoidList.add("(Unknown)");
    
    return avoidList;
  }
}
