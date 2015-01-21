package item;

import java.util.ArrayList;

/**
 * Created by Michael on 19/01/2015.
 */
public class Key extends Item {
    private ArrayList<Integer> rooms = new ArrayList<Integer>();

    public Key(String desc, ArrayList<Integer> rooms) {
        super(desc);
        this.rooms = rooms;
    }

    public Key(String desc) {
        super(desc);
    }

    public ArrayList<Integer> getRooms() {
        return rooms;
    }


    public boolean equals(Item item){
        if (this == item){
            return true;
        }
        else if (!(item instanceof Key)){
            return false;
        }
        else {
            for (int i : ((Key)item).getRooms()){
                if (!(this.rooms.contains(i))){
                    return false;
                }
            }
            return true;
        }
    }
}
