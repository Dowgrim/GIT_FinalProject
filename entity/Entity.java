package entity;

import item.*;
import room.*;

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

    /**
     * The player tries to go to another room
     */
    public void goRoom () {
        System.out.println("Sorties disponibles :");
        currentRoom.printExits();
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        try {
            choice = scan.nextInt();
        }
        catch (Exception e) {
            System.out.println("Ce n'est pas un numéro!");
        }
        while (choice <= 0 || choice > currentRoom.getExits().size()) {
            System.out.println("Valeur saisie incorrecte ...");
            try {
                choice = scan.nextInt();
            }
            catch (Exception e) {
                System.out.println("Ce n'est pas un numéro !");
                choice = 0;
                scan.nextLine();
            }
        }
        // CAS A GERER: POSSIBILITE D'ENTRER DANS LA SALLE (clef, torche etc) //
        System.out.println("Vous allez à la salle " + (choice - 1));
        currentRoom = currentRoom.getExits().get(choice-1);
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
