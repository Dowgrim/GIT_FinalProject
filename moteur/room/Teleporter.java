package moteur.room;

import moteur.craft.Crafter;
import moteur.door.Door;
import moteur.item.Item;
import moteur.trap.Trap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/01/2015.
 */
public class Teleporter extends SpecialRoom{
    public static ArrayList<Room> potentialsExits = new ArrayList<Room>();

    private Room teleporExit;

    public Teleporter(ArrayList<Room> potentialsExits, int number, int x, int y, String description) {
        super(number, x, y, description);
        this.potentialsExits = potentialsExits;
    }

    public ArrayList<Room> getPotentialsExits() {
        return potentialsExits;
    }

    public void setPotentialsExits(ArrayList<Room> potentialsExits) {
        this.potentialsExits = potentialsExits;
    }

    //le teleporteur a une seule sortie qui change à chaque tour, selectionnée parmis les potentialsExits
    public void generateExit(){
        this.setPotentialsExits(new ArrayList<Room>());
        Random rnd = new Random();
        int exit = rnd.nextInt(potentialsExits.size());
        Room destination = potentialsExits.get(exit);
        teleporExit = destination;
    }



}