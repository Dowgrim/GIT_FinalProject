package moteur.room;

import moteur.craft.Crafter;
import moteur.entity.*;
import moteur.item.Item;
import moteur.item.Key;
import moteur.trap.Trap;
import moteur.door.*;

import java.util.ArrayList;

/**
 * Created by user on 19/01/2015.
 */
public class SpecialRoom extends Room{

    private boolean locked, fragment;
    private ArrayList<Item> itemNeeded = new ArrayList<Item>();
    private ArrayList<Item> itemContained = new ArrayList<Item>();
    private Trap trap;
    private Crafter crafter;

    public SpecialRoom(ArrayList<Door> exits, int number, int x, int y, String description, boolean locked,
                       boolean fragment, ArrayList<Item> itemNeeded, ArrayList<Item> itemContained, Crafter crafter, Trap trap) {
        super(exits, number, x, y, description);
        this.locked = locked;
        this.fragment = fragment;
        this.itemNeeded = itemNeeded;
        this.itemContained = itemContained;
        this.crafter = crafter;
        this.trap = trap;
    }

    public boolean isFragment() {
        return fragment;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setFragment(boolean frag) {
        this.fragment = frag;
    }

    public ArrayList<Item> getItemContained() {
        return this.itemContained;
    }

    /**
    * Picks up all the items present in the room
    */
    public void pickUp(Entity player) {
        Item item;
        if (isFragment()) {
            player.addFragment();
            setFragment(false);
        }
        if (getItemContained().isEmpty()) {
            return;
        }
        for (int i = getItemContained().size(); i >= 0; --i) {
            item = getItemContained().get(i);
            player.getBag().add(item); // Adds each item to the bag of the player
            getItemContained().remove(i);  // Removes it from the room
        }

    }

    @Override
    public boolean tryUnlock(ArrayList<Item> bag){
        for (Item item : itemNeeded){
            if (!(bag.contains(item))){
                return false;
            }
        }
        locked = false;
        return true;
    }

    @Override
    public void enter(Entity player){
        boolean unlocked = tryUnlock(player.getBag());
        if (unlocked) {
            trap.trap(player);
            if (!(player.getCurrentRoom().equals(this))) { //checks if the player got out of the room because of trap
                return;
            }
            this.pickUp(player); // picks up all the items of the room
            crafter.craft(player); // Crafts if possible
         }
    }
 }
