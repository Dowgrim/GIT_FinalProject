package door;

import entity.Entity;
import room.Room;
import sun.font.LayoutPathImpl;

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
    }

    public void move(Entity player){
        if(!rooms.contains(player.getCurrentRoom())) {
            /*
                Affichage erreur
                Appel de la méthode d'affichage ;)
            */
            return;
        }
        if(state == 0){
            if(rooms.get(0).equals(player.getCurrentRoom())){
                player.setCurrentRoom(rooms.get(0));
            } else{
                player.setCurrentRoom(rooms.get(1));
            }
        }
        if(state >= 1){
            /*
                Affichage erreur
                Appel de la méthode d'affichage ;)
            */
        }
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
