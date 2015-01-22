package moteur.room;

import moteur.door.Door;
import moteur.entity.Entity;

import java.util.ArrayList;

/**
 * Created by user on 20/01/2015.
 */
public class Checkpoint extends Room{
    Entity player;

    private int posX;

    private int posY;

    public Entity getPlayer() {
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public Checkpoint(int number, int posX, int posY, String description, Entity player) {
        super(number, 0, 0, description);
        this.player = player;
        this.posX = posX;
        this.posY = posY;
    }


    public Checkpoint(int number, int x, int y, Entity player) {
        super(number, x, y, "Un check point, vous êtes sauvé !");
        this.player = player;
    }

}
