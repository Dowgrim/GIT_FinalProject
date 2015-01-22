package moteur.room;

import moteur.entity.Entity;

import java.util.ArrayList;

/**
 * Created by user on 20/01/2015.
 */
public class Checkpoint extends Room{
    Entity player;

    public Entity getPlayer() {
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public Checkpoint(ArrayList<Room> exits, int number, int x, int y, String description, Entity player) {
        super(exits, number, x, y, description);
        this.player = player;

    }
}