package moteur.entity;

import moteur.item.*;
import moteur.room.*;
import java.util.*;



/**
 * Created by Michael on 19/01/2015.
 * Edited by Nicolas
 */

public class Entity extends Living {
    private int energy;    // Energy level of the player
    private int fragments; // Number of fragments the player has
    private ArrayList<Item> bag; // The items the player picked up
    private Map<Class<?>, Object> effects = new HashMap<Class<?>, Object>(); // Contains the effects applied to the player


    public Entity () {
        this.energy = 100; // The player begins with 100 energy points
        this.fragments = 0; // The player begins with no fragment
    }

    public Entity (Room room) {
        this.energy = 100; // The player begins with 100 energy points
        this.fragments = 0; // The player begins with no fragment
        currentRoom = room;
    }

    /**
     * The effects currently applied to the player
     * @return HashMap
     */
    public void addEffect(Effect effect) {
        Effect old = effect.getClass().cast(effects.get(effect.getClass()));
        if (old == null) {
            effects.put(effect.getClass(), this);
        } else {
            if (old.getPower() < effect.getPower()) {
                effects.put(effect.getClass(), this);
            }
        }
    }

    /**
     *
     * @param room
     */
    @Override
    public void setCurrentRoom(Room room){
        currentRoom.onLeave(this);
        super.setCurrentRoom(room);
        currentRoom.onEnter(this);
    }

    public void removeEffect(Effect effect) {
        effects.remove(effect);
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

    @Override
    public void nextTurn() {
        for(Object ef : effects.values()){
            ((Effect)ef).apply(this);
        }
    }
}
