package moteur.item;

import moteur.door.Door;
import moteur.entity.Entity;

import java.util.ArrayList;

/**
 * Created by Michael on 19/01/2015.
 */
public class Key extends Item {

    private ArrayList<Door> doors = new ArrayList<Door>();

    public Key(String desc, ArrayList<Door> doors) {
        super(desc);
        this.doors = doors;
    }

    public Key(String desc) {
        super(desc);
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public boolean equals(Item item){
        if (this == item){
            return true;
        }
        else if (!(item instanceof Key)){
            return false;
        }
        else {
            for (Door i : ((Key)item).getDoors()){
                if (!(this.doors.contains(i))){
                    return false;
                }
            }
            return true;
        }
    }

    public void onObtaining(Entity player){
        for(int i = 0; i < doors.size(); i++){
            doors.get(i).unlock();
        }
    }
}
