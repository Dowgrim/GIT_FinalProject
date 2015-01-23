package moteur.room;

import moteur.Game;
import moteur.craft.Crafter;
import moteur.entity.*;
import moteur.item.Item;
import moteur.item.Key;
import moteur.trap.Trap;
import moteur.door.*;
import vue.command.game.CraftCommand;
import vue.command.game.CrafterCommand;

import java.util.ArrayList;

/**
 * Created by user on 19/01/2015.
 */
public class SpecialRoom extends Room{

    private boolean fragment;
    private ArrayList<Item> itemNeeded = new ArrayList<Item>();
    private ArrayList<Item> itemContained = new ArrayList<Item>();
    private Trap trap;
    private Crafter crafter;

    public SpecialRoom(int number, int x, int y, String description, boolean fragment, ArrayList<Item> itemNeeded,
                       ArrayList<Item> itemContained, Crafter crafter, Trap trap) {
        super(number, x, y, description);
        this.fragment = fragment;
        this.itemNeeded = itemNeeded;
        this.itemContained = itemContained;
        this.crafter = crafter;
        this.trap = trap;
    }


    public SpecialRoom(int number, int x, int y, String description) {
        super(number, x, y, description);
    }

    public boolean isFragment() {
        return fragment;
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
    public void onEnter(Entity player){
        if(trap != null) {
            trap.trap(player);
            trap = null;
        }

        if (!(player.getCurrentRoom().equals(this)))//checks if the player got out of the room because of trap
                return;

        for (Item item : itemNeeded){
            if (!(player.getBag().contains(item))){
                return;
            }
        }
        this.pickUp(player); // picks up all the items of the room
        if(crafter != null){
            Game.addCommand(new CraftCommand());
            Game.addCommand(new CrafterCommand());
        }
    }

    @Override
    public void onLeave(Entity player){
        if(crafter != null){
            Game.removeCommand(new CraftCommand());
            Game.removeCommand(new CrafterCommand());
        }
    }
 }
