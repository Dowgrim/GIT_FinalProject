package room;

import entity.Entity;
import item.Item;
import item.Key;

import java.util.ArrayList;

/**
 * Created by user on 19/01/2015.
 */
public class SpecialRoom extends Room{

    private boolean locked, fragment;
    private ArrayList<Item> itemNeeded = new ArrayList<Item>();
    private ArrayList<Item> itemContained = new ArrayList<Item>();

    public SpecialRoom(ArrayList<Room> exits, int number, int x, int y, String description, boolean locked,
                       boolean fragment, ArrayList<Item> itemNeeded, ArrayList<Item> itemContained) {
        super(exits, number, x, y, description);
        this.locked = locked;
        this.fragment = fragment;
        this.itemNeeded = itemNeeded;
        this.itemContained = itemContained;
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
        for (int i = getItemContained().size(); i >= 0; --i) {
            item = getItemContained().get(i);
            player.getBag().add(item); // Adds each item to the bag of the player
            getItemContained().remove(i);  // Removes it from the room
        }
        if (isFragment()) {
            player.addFragment();
            setFragment(false);
        }
    }

    public boolean tryUnlock(ArrayList<Item> bag){
        for (Item item : itemNeeded){
            if (!(bag.contains(item))){
                return false;
            }
        }
        locked = false;
        return true;
    }


 }