import craft.Crafter;
import entity.Entity;
import item.Item;
import room.Corridor;
import room.Room;
import trap.Trap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michael on 20/01/2015.
 */
public class Game {


    private Random rand;


    // Command manager
    private final static command.CommandManager cmd = new command.CommandManager();

    //The player
    Entity player = new Entity();



    public Game() {
    }

    public void createRandomGame(){



    }
}

    public Room createRandomFloor(int x, int y){

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

    public void start() {
        registerCommands();

        System.out.println(I18n.get("welcome"));
        System.out.println(I18n.get("start"));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (String command = reader.readLine(); !"stop".equalsIgnoreCase(command); command = reader.readLine()) {
                if (player.isPlaying()) {
                    command = player.getPlaying() + " " + command;
                }
                if (player.isWorking()) {
                    command = "work " + command;
                }
                cmd.dispatch(command);
            }
        } catch (Exception e) {
            System.out.println(I18n.get("error.is"));
            e.printStackTrace();
        }
    }


    /**
     * Register all commands.
     */
    public static void registerCommands() {
        // Misc commands
        cmd.register(new HelpCommand());
        cmd.register(new VersionCommand());

        // Manage commands
        cmd.register(new LanguageCommand());

        // Game commands
        cmd.register(new StartCommand());
        cmd.register(new BuildingCommand());
        cmd.register(new PlayerCommand());
        cmd.register(new MoveCommand());
        cmd.register(new ItemCommand());
        cmd.register(new FunCommand());
        cmd.register(new WorkCommand());
    }

}
