package moteur.entity;

import moteur.room.Room;

/**
 * Created by user on 22/01/2015.
 */
public class Living {
    public Room currentRoom; // The room in which the player currently is
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
