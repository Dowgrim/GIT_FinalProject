package moteur.entity;

import moteur.item.*;
import moteur.room.*;
import java.util.*;


/**
 * Created by Michael on 19/01/2015.
 * Edited by Nicolas
 */

public class Entity {
    private int energy;    // Energy level of the player
    private int fragments; // Number of fragments the player has
    private ArrayList<Item> bag; // The items the player picked up
    public Room currentRoom; // The room in which the player currently is

    public Entity () {
        this.energy = 100; // The player begins with 100 energy points
        this.fragments = 0; // The player begins with no fragment
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Decreases the energy of the player by 'points'
     * @param points
     */
    public void decreaseEnergy(int points) {
        this.energy -= points;
    }

    /**
     * Increases the energy of the player by 'points'
     * @param points
     */
    public void increaseEnergy(int points) {
        this.energy += points;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Gets the bag of the player
     * @return bag
     */
    public ArrayList<Item> getBag() {
        return this.bag;
    }

    /**
     * Returns the number of fragments the player has
     */
    public int getFragments () {
        return this.fragments;
    }

    /**
     * Adds a fragment to the player
     */
    public void addFragment() {
        this.fragments++;
    }

    /**
     * Prints the items present in the student's bag
     */
    public void printBag() {
        if (this.bag.isEmpty()) { // If the bag is empty, prints a message
            System.out.println("Votre sac est vide !");
        } else {
            System.out.print("Votre sac contient :");
            for (Item item : bag) {     // Prints all the items the player has
                System.out.print(item.getDescription() + " ");
            }
            System.out.println();
        }
    }
    }