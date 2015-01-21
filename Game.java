import craft.Crafter;
import item.Item;
import room.Corridor;
import room.Room;
import trap.Trap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michael on 20/01/2015.
 */
public class Game {


    private Random rand;

    public Game() {
    }

    public Game createRandomFloor(int x, int y){

        Random rand = new Random();

        //rooms total de l'étage
        ArrayList<Room> rooms;

        //Si un fragment a déjà été ajouté à l'étage ou pas
        boolean frag = false;


        Room r;


        //Corridor ou room
        if(rand.nextInt(10) >= 5){
            r = new Corridor();
        }else{
            ArrayList<Trap> pieges = new ArrayList<Trap>();
            ArrayList<Item> FloorItem = new ArrayList<Item>();
            boolean keyFrag = false;
            ArrayList<Item> ItemNeeded = new ArrayList<Item>();
            boolean lock = false;
            Crafter craft;

            //Salle Piégé
            if(rand.nextInt(10) >= 5){
                pieges.add(createRandomTrap(rand.nextInt(DATA.getPieges().size())));
            }
            for(int j = rand.nextInt(3); j > 0; j--){
                if(rand.nextInt(10) >= 5) {
                    FloorItem.add(createRandomItem(rand.nextInt(DATA.getItems().size())));
                }
            }
            if(!frag && rand.nextInt(20) == 0){
                keyFrag = true;
                frag = true;
            }
            for(int j = rand.nextInt(3); j > 0; j--){
                if(rand.nextInt(10) >= 5){
                    ItemNeeded.add(createRandomItemNeeded(rand.nextInt(Data.getItemsNeeded().size())));
                }
            }
            if(rand.nextInt(10) >= 5){
                lock = true;
            }
            if(rand.nextInt(20) == 0){
                craft =
            }


        }



        for(int i = 0; i < x;  i++){
            for(int j = 0; j < y; j++) {

            }
        }


    return null;
   }


    public ArrayList<Room> generateCorridors(Random rand){
        ArrayList<Room> rooms = new ArrayList<Room>();
        if(rand.nextInt(10) >= 5){
            rooms.add(new Corridor());
    }



    public Item createRandomItemNeeded(int rand){

    }


    public Item createRandomItem(int rand){

    }

    public Trap createRandomTrap(int rand){

    }

}
