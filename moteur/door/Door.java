package moteur.door;

import moteur.entity.Entity;
import moteur.room.Room;

import java.util.ArrayList;

/**
 * Created by Michael on 22/01/2015.
 */
public class Door {

    private int seed;

    private int state;

    ArrayList<Room> rooms;
    private Room otherExit;

    public Door(int seed, int state, ArrayList<Room> rooms) {
        this.seed = seed;
        this.state = state;
        this.rooms = rooms;
    }

    public int move(Entity player){
        if(state == 0){
            player.setCurrentRoom(getOtherExit(player.getCurrentRoom()));
        }
        return state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Door door = (Door) o;

        if (seed != door.seed) return false;
        if (state != door.state) return false;
        if (rooms != null ? !rooms.equals(door.rooms) : door.rooms != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seed;
        result = 31 * result + state;
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }

    public void unlock() {
        state = 0;
    }

    public Room getOtherExit(Room exit) {
        if(rooms.get(0).equals(exit)){
            return rooms.get(1);
        }else {
            return rooms.get(0);
        }
    }
}
