package zuul.rooms;

import java.util.*;
import zuul.commands.Command;
import zuul.student.*;


/**
	@author Nicolas HORY and Cindy NAJJAR
*/

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> objects = new ArrayList<Item>();        // stores items which are in a room

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

	/**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return Game.resource.getString("desc.room") + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public ArrayList<Item> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Item> objects) {
        this.objects = objects;
    }
    
    /**
     * Generates items randomly in the room
     */
    public void generateItems() {
     		ArrayList<String> it = new ArrayList<String>(Arrays.asList("Tablet","Sheet", "Coffee"));
    		int probObj;
    		for (int i = 0; i < it.size();i++) {
    			if (i ==1) { // For the Sheet
    				probObj = (int)(Math.random() * 8); // The probability is 1/8
    			} else {
    				probObj = (int)(Math.random() * 2); // The probability is 1/2
    			}
    			if (probObj == 0) {
    				this.objects.add(new Item(it.get(i)));
    			}
    		}    		
    }
    
    /**
     * Displays the items present in the room
     */
    public void displayObjects() {
    	if (!(this instanceof Corridor) || ((Corridor)this).isLighted()) { // Checks if we are in a normal room, or in a lighted corridor
	        System.out.print(Game.resource.getString("room.obj")); 
	        if (this.getObjects().isEmpty()) { // Checks if the room is empty
	        	System.out.println(Game.resource.getString("obj.error"));
	        } else {
	        	for (Item e : this.getObjects()) { // For each object present
	        		System.out.print(e.getDescription() + " "); // Prints its description
	        	}
	        	System.out.println();
	        }
    	}
    }
    
    /**
     * Displays the exits of the room
     */
    public void displayExits() {
    	System.out.println("\n" + Game.resource.getString("room.exits"));
    	for (String exit : exits.keySet()) {
    		System.out.println(" - " + exit + " : " + exits.get(exit).getShortDescription());
    	}
    	System.out.println();
    }
    
    /**
     * Picks all the items of the room and put them in the bag of the student
     * @param command
     * @param student
     */
    public void pickUp(Command command) {
        if (command.hasSecondWord()) {
            System.out.println(Game.resource.getString("pick.error"));
        } 
        else if ((this instanceof Corridor && !((Corridor)this).isLighted())) { // If we are in a corridor not lighted
        	System.out.println(Game.resource.getString("pick.light")); // Prints an error message
        }
        else if (this.getObjects().isEmpty()) { // If the room is empty
        	System.out.println(Game.resource.getString("pick.nothing")); // Prints a message 
        } else {
            for (Item e : this.getObjects()) {            
                    Game.student.getItems().add(e);	// Adds all the items to tthe student
             }            
            this.setObjects(new ArrayList<Item>()); // Makes the room's list of objects empty
            System.out.println(Game.resource.getString("pick.done"));
            Game.student.printBag();
        }
    }
}