package room;

import item.Item;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/01/2015.
 */
public class Teleporter extends SpecialRoom{
    private ArrayList<Room> potentialsExits = new ArrayList<Room>();

    public Teleporter(ArrayList<Room> exits, int number, int x, int y, String description, boolean locked, boolean fragment,
                      ArrayList<Item> itemNeeded, ArrayList<Item> itemContained) {
        super(new ArrayList<Room>(), number, x, y, description, locked, fragment, itemNeeded, itemContained);
        this.potentialsExits = exits;
    }

    public ArrayList<Room> getPotentialsExits() {
        return potentialsExits;
    }

    public void setPotentialsExits(ArrayList<Room> potentialsExits) {
        this.potentialsExits = potentialsExits;
    }

    //le teleporteur a une seule sortie qui change à chaque tour, selectionnée parmis les potentialsExits
    public void generateExit(){
        this.setExits(new ArrayList<Room>());
        Random rnd = new Random();
        int exit = rnd.nextInt(potentialsExits.size());
        Room destination = potentialsExits.get(exit);
        this.getExits().add(destination);
    }
}
