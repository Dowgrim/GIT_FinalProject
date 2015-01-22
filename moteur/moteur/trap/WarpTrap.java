package moteur.trap;

import moteur.entity.Entity;
import moteur.room.Room;

/**
 * Created by user on 20/01/2015.
 */
public class WarpTrap implements Trap {
    private Room room;
    public WarpTrap(Room room){
        this.room = room;
    }
    public void trap(Entity player){
        player.setCurrentRoom(room); // sends the player to a new room
    }
}
