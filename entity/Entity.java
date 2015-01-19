package entity;

import item.*;
import room.*;

import java.util.*;


/**
 * Created by Michael on 19/01/2015.
 */

public class Entity {
    private int energy;    // Energy level of the player
    private int fragments; // Number of fragments the player has
    private ArrayList<Item> bag; // The items the player picked up
    public Room currentRoom; // The room in which the player currently is

    public Entity () {
        this.energy = 100; // The player begins with 100 energy points
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

    public void pickUp() {
        Item item;
        Iterator  i = currentRoom.getItemContained().iterator();
        while (i.hasNext()) {
            item = (Item) i.next();
            this.bag.add(item);
            i.remove();
        }
        if (currentRoom.isFragment()) {
            this.fragments++;
            currentRoom.setFragment(false);
        }
    }
    }
