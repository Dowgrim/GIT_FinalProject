package room;

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


 }
