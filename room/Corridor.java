package room;

import door.Door;

import java.util.ArrayList;

/**
 * Created by user on 19/01/2015.
 */
public class Corridor extends Room {
    public Corridor(ArrayList<Door> exits, int number, int x, int y, String description) {
        super(exits, number, x, y, description);
    }

    public Corridor(){

    }
}
