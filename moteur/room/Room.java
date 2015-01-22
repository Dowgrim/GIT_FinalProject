package moteur.room;

import moteur.door.Door;
import moteur.entity.Entity;
import moteur.item.*;

import java.util.ArrayList;

/**
 * Created by Michael on 19/01/2015.
 */
public class Room {

    private ArrayList<Door> exits = new ArrayList<Door>();
    private int number, x, y;

    public Room(ArrayList<Door> exits, int number, int x, int y, String description) {
        this.exits = exits;
        this.number = number;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public Room() {
    }

    public ArrayList<Door> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Door> exits) {
        this.exits = exits;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public void display(){}

    public boolean tryUnlock(ArrayList<Item> bag){
        return true;
    }

    public void enter(Entity player){}

    public boolean haveCorridorExit(){
        for(Door ex : exits){
            if(ex.getOtherExit(this) instanceof Corridor){
                return true;
            }
        }
        return false;
    }

    public String printExits(){
        //TODO
        return "lol";
    }
}
