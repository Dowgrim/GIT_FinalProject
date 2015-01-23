package moteur.room;

import com.sun.org.apache.xpath.internal.SourceTree;
import moteur.Game;
import moteur.door.Door;
import moteur.entity.Entity;
import moteur.item.*;
import vue.command.game.CraftCommand;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 19/01/2015.
 */
public class Room {

    private HashMap<Integer, Door> exits = new HashMap<Integer, Door>();
    private int number, x, y;
    private String description;


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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDescription() {
        return description;
    }

    public void display(){}

    public void onEnter(Entity player){
        printExits();
    }

    public void onLeave(Entity player){}

    public boolean haveCorridorExit(){
        for(Door ex : exits.values()){
            if(ex.getOtherExit(this) instanceof Corridor){
                return true;
            }
        }
        return false;
    }

    public void printExits() {
        System.out.println("Sorties disponibles :");
        for (Integer r: exits.keySet()) {
            System.out.println (r + ": " + exits.get(r).getOtherExit(this).getDescription());
        }
    }
    public void addDoor(Door door, int orientation){
        exits.put(orientation, door);
    }
}