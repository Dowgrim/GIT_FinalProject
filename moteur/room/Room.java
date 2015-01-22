package moteur.room;

import moteur.door.Door;
import moteur.entity.Entity;
import moteur.item.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 19/01/2015.
 */
public class Room {

    private HashMap<Integer, Door> exits = new HashMap<Integer, Door>();
    private int number, x, y;

    public Room(HashMap<Integer, Door> exits, int number, int x, int y, String description) {
        this.exits = exits;
        this.number = number;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public Room(int number, int x, int y, String description) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public HashMap<Integer, Door> getExits() {
        return exits;
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


    public int getY() {
        return y;
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

    public void enter(Entity player){
        System.out.println(description);
    }

    public boolean haveCorridorExit(){
        for(Door ex : exits.values()){
            if(ex.getOtherExit(this) instanceof Corridor){
                return true;
            }
        }
        return false;
    }

    public void printExits() {
        for (int i = 0; i < exits.size(); i++) {
            System.out.println((i+1) + ": " + exits.get(i));
        }
    }

    public void addDoor(Door door, int orientation){

    }


}