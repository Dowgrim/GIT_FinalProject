package vue;

import commands.*;
import moteur.entity.Entity;
import moteur.room.*;
import java.util.*;

/**
 * Created by Nicolas on 20/01/15.
 */


public class Game {
    private Parser parser;
    private ArrayList<Room> map = new ArrayList<Room>();
    public static Entity player;
    private Locale locale;
    public static ResourceBundle resource;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
        this.player = new Entity();
        createRooms(); // Creates all the rooms
        parser = new Parser();
        chooseLanguage();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        // create the rooms
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Merci d'avoir joué à ce jeu !");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Bienvenue dans notre jeu !");
        System.out.println(("Préparez-vous à affronter de nombreuses épreuves !"));
        System.out.println("Tapez 'help' si vous ne savez pas quoi faire..");
        System.out.println();
    }

    /**
     * Chooses the language for the game
     */
    public void chooseLanguage() {
        locale = Locale.getDefault();
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir la langue souhaitée (fr/eng):");
        String str = scan.nextLine();
        while (!(str.equals("fr")) && !(str.equals("eng"))) { // While he made a wrong choice, restart it
            System.out.println("Cette langue n'existe pas, saisissez en une autre:");
            str = scan.nextLine();
        }
        if (str.equals("eng")) { // If he chose english, changes the locale to the english one
            locale = new Locale("en", "US");
        }
        resource = ResourceBundle.getBundle("zuul.languages.Zuul", locale); // Loads the resourceBundle
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command
     *            The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Cette commande n'existe pas !");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                player.goRoom();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case BAG:
                player.printBag();
                break;
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("Vous devez trouver des fragments de clef pour avancer dans le jeu.");
        System.out.println("Allez de salle en salle pour progresser !");
        System.out.println();
        System.out.println("Les commandes que vous pouvez utiliser :");
        parser.showCommands();
    }

    /**
     * Generates items for each room
     */
    public void generateAllItems() {
        for (Room r : map) {
            r.generateItems();
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Ne tapez que quit pour quitter..");
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }
}