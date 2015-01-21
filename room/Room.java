package room;

import entity.Entity;
import item.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Michael on 19/01/2015.
 */
public class Room {

    private ArrayList<Room> exits = new ArrayList<Room>();
    private int number, x, y;

    public Room(ArrayList<Room> exits, int number, int x, int y, String description) {
        this.exits = exits;
        this.number = number;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public ArrayList<Room> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Room> exits) {
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

    public void printExits() {
        for (int i = 0; i < exits.size(); i++) {
            System.out.println((i+1) + ": " + exits.get(i));
        }
    }
}
