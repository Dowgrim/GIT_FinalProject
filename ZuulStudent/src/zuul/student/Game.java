package zuul.student;

import java.util.*;
import zuul.commands.*;
import zuul.rooms.*;

/**
 @author Nicolas HORY and Cindy NAJJAR
 **/

public class Game {
    private Parser parser;
    private Locale locale;
    public static ResourceBundle resource;
    private Room currentRoom;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    public static Student student;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {  
    	Scanner scanName = new Scanner(System.in);
    	System.out.println("Veuillez saisir votre nom : ");
    	String studentName = scanName.nextLine();
    	this.student = new Student(studentName); // Gets the name of the student
        chooseLanguage(); // Chooses the language (english or french)
        createRooms(); // Creates all the rooms
        parser = new Parser();
    }   
    
    /**
     * Allows the player to choose the language, and choose which resourceBundle to use according to this choice
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
     * Create all the rooms and link their exits together.
     */
    private void createRooms() { // We pass the locale in argument to allow traduction of room messages
        // create the rooms
        Corridor corridor1 = new Corridor(resource.getString("desc.cor1"));
        Corridor corridor2 = new Corridor(resource.getString("desc.cor2"));
        LabRoom lab = new LabRoom(resource.getString("desc.lab"));
        ClassRoom amphi1 = new ClassRoom(resource.getString("desc.amphi1"));
        ClassRoom amphi2 = new ClassRoom(resource.getString("desc.amphi2"));
        ExamRoom exam = new ExamRoom(resource.getString("desc.exam"));
        Room lunchroom = new Room(resource.getString("desc.lunch"));
        Library library = new Library(resource.getString("desc.lib"));

        // initialize room exits
        corridor1.setExit("east", amphi2);
        corridor1.setExit("south", lab);
        corridor1.setExit("west", amphi1);
        corridor1.setExit("north", corridor2);

        amphi2.setExit("west", corridor1);
        amphi1.setExit("east", corridor1);

        lab.setExit("north", corridor1);

        corridor2.setExit("north", exam);
        corridor2.setExit("east", library);
        corridor2.setExit("west", lunchroom);
        corridor2.setExit("south", corridor1);

        exam.setExit("south", corridor2);
        lunchroom.setExit("east", corridor2);
        library.setExit("west", corridor2);
        library.getBooks().add(new Book("POO"));
        
        rooms.add(corridor1);
        rooms.add(corridor2);
        rooms.add(amphi1);
        rooms.add(amphi2);
        rooms.add(lab);
        rooms.add(library);
        rooms.add(lunchroom);
        rooms.add(exam);
        
        // Generates all items in all rooms
        generateAllItems();
        currentRoom = corridor1;	// start game in corridor 1
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.
        if (currentRoom instanceof Corridor) {
        	((Corridor)currentRoom).printStateLight();
        }
        currentRoom.displayObjects();
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println(resource.getString("game.end"));
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println(resource.getString("game.welcome"));
        System.out.println(resource.getString("game.desc"));
        System.out.println(resource.getString("game.help"));
        System.out.println();
        System.out.println(resource.getString("desc.room") + currentRoom.getShortDescription());
        currentRoom.displayExits();
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
            System.out.println(resource.getString("game.unknown"));
            break;
            
        case TABLET:
        	boolean hasTablet = student.checkItem("Tablet");
        	if (hasTablet) {
        		student.useTablet();
        	} else {
        		System.out.println(resource.getString("no.tablet"));
        	}
        	break;
            
        case PLAY:
        	if (currentRoom.getShortDescription().equals(resource.getString("desc.lunch"))) {
        		student.playBabyfoot();
        	} else {
        		System.out.println(resource.getString("game.lunch"));
        	}
        	break;

        case HELP:
            printHelp();
            break;

        case GO:
            goRoom(command);
            break;
            
        case READ:
        	readPooBook();
        	break;

        case QUIT:
            wantToQuit = quit(command);
            break;
            
        case BAG:
        	student.printBag();
        	break;

        case LIGHT:
            if (currentRoom instanceof Corridor){ // If we are in a corridor, changes the light
            	((Corridor)currentRoom).changeLight();
            } else { // Else prints an error
            	System.out.println(resource.getString("light.prob") + currentRoom.getShortDescription());  
            }
            break;
            
        case DRINK:
        	if (currentRoom.getShortDescription().equals(resource.getString("desc.lunch"))) {
        		student.drinkCoffee();
        	} else {
        		System.out.println(resource.getString("drink.error")); // The student can't driknk out of the lunchroom
        	}
        	break;
        	

        case PICKUP:
            currentRoom.pickUp(command);
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
        System.out.println(resource.getString("help.first"));
        System.out.println(resource.getString("help.second"));
        System.out.println();
        System.out.println(resource.getString("help.third"));
        parser.showCommands();
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(resource.getString("go.error"));
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println(resource.getString("go.door"));
        } else {
        	boolean canPass = true; // Tells if the student can pass to the next room
        	if (nextRoom instanceof Library) {
            	boolean checkLib = ((Library)nextRoom).openLibrary();
            	if (checkLib == false) { // Checks if the library is open or not
            		System.out.println(resource.getString("lib.error")); // If not, prints an error, and the student can't pass
            		canPass = false;
            	}
            }
           if (canPass) { // If you can enter the room
	            currentRoom = nextRoom; 
	            student.checkEnergy(); // Checks if the student has enough energy
	            currentRoom.displayExits(); // Prints the exits of the room
	            System.out.println(resource.getString("desc.room") + currentRoom.getShortDescription());
	            checkTypeRoom(); // Checks the type of the room, and act in function of it
           }
        }
    }
    
    /**
     * Depending on the class of the room, we call methods needed
     */
    private void checkTypeRoom() {
    	   if (currentRoom instanceof Corridor) {  // If you are in a corrridor
           	((Corridor)currentRoom).printStateLight();  // Prints the state of the light
           }
           currentRoom.displayObjects(); // Displays the objects present
           checkLunchroom(); // Checks if we are in the lunchroom, and if the player has to play babyfoot
           if (currentRoom instanceof ClassRoom) {
           	((ClassRoom) currentRoom).generateClassLecture(); // generates a lecture if in a classroom
           } else if (currentRoom instanceof LabRoom){
           	((LabRoom) currentRoom).generateLab(); // Generates a lab if we are in a labroom
           } else if (currentRoom instanceof ExamRoom) {
               if (student.canDoExam()) {
                   ((ExamRoom) currentRoom).generateExam(); // If the student can do the exam, start it
               } else {
            	   System.out.println(resource.getString("exam.impossible"));
               }
           }
   }
    
    /**
     * Reads the pooBook (called with the command 'read')
     */    
    private void readPooBook() {
    	int presentBook = student.findBook();
    	if (currentRoom instanceof Library) { // If we are in the library
    		if (presentBook != -1) { // If the student already picked the book
    			System.out.println(resource.getString("book.bag"));
    			((Book)student.getItems().get(presentBook)).readBook();   // reads it 			
    		} else {
	    		Book pooBook = ((Library) currentRoom).getBooks().get(0); // If the book is still in the library
	    		pooBook.readBook(); // Reads the only interesting book of the library, POO one
	    		student.items.add(pooBook); // Adds the books to the student's bag
	    		((Library) currentRoom).getBooks().remove(0); // Removes the book from the library
	    		System.out.println(resource.getString("take.book"));
    		}
    	} else { // If we are not in the library
    		if (presentBook!= -1) {	// If the student already picked the book
    			System.out.println(resource.getString("book.bag"));
    			((Book)student.getItems().get(presentBook)).readBook();    // reads it
    		} else {
    			System.out.println(resource.getString("book.prob")); // else prints an error message
    		}
    	}
    }
    
    /**
     * Generate the items in every room
     */
    private void generateAllItems() {
    	for (Room room : rooms) {
    		room.generateItems();
    	}
    }
    
    /**
     * If we are in the lunchroom, randomly chooses if the player has to play babyfoot
     */
    private void checkLunchroom() {    
    	if (currentRoom.getShortDescription().equals(resource.getString("desc.lunch"))) {
    		int playBabyfoot = (int)(Math.random() * 3); //This number decides if the player has to play babyfoot
    		if (playBabyfoot == 0)			  // We say that there is one chance on 3 not to have the choice
    		{
    			System.out.println(resource.getString("play.yes"));
    			student.playBabyfoot();
    		}
    		else
    		{
    			System.out.println(resource.getString("play.no"));
    		}
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
            System.out.println(resource.getString("quit.error"));
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }
}
