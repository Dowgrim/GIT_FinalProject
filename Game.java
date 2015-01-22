import com.sun.org.apache.xml.internal.security.utils.I18n;
import craft.Crafter;
import door.Door;
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
    private Entity player = new Entity();

    //List of first Room of all floor
    private ArrayList<Room> firstRooms = new ArrayList<Room>();

    //If the game have been initialized
    private boolean isInitialized = false;

    Random rand = new Random();



    public Game() {
    }

    public void createRandomGame(int nbFloor, ArrayList<Integer> Xs, ArrayList<Integer> Ys){
        ArrayList<ArrayList<Room>> allRooms = new ArrayList<ArrayList<Room>>();

        for(int i = 0; i < nbFloor; i++) {
            allRooms.add(createRandomFloor(Xs.get(i), Ys.get(i)));
        }
    }


    public ArrayList<Room> createRandomFloor(int x, int y){



        //rooms total de l'étage
        ArrayList<Room> rooms;

        ArrayList<Corridor> corridors;

        ArrayList<Door> doors;


        for(int i = 0; i < x;  i++){
            for(int j = 0; j < y; j++) {
                //Corridor ou room
                if(rand.nextInt(10) >= 5){
                    r = new Corridor();







                }else{

                    ArrayList<Item> FloorItem = new ArrayList<Item>();
                    boolean keyFrag = false;
                    ArrayList<Item> ItemNeeded = new ArrayList<Item>();
                    boolean lock = false;
                    Crafter craft;
                    Trap trap;

                    //Salle Piégé
                    if(rand.nextInt(10) >= 6){
                        trap = createRandomTrap();
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
                        craft = createRandomCraft();
                    }
                }
            }
        }


    return null;
   }


    public ArrayList<Room> generateCorridors(Random rand){
        ArrayList<Room> rooms = new ArrayList<Room>();
        if(rand.nextInt(10) >= 5){
            rooms.add(new Corridor());
    }


    public Crafter createRandomCraft(){


    }

    public Item createRandomItemNeeded(){

    }


    public Item createRandomItem(){

    }

    public Trap createRandomTrap(){

    }

    public void start() {
        registerCommands();

        System.out.println(I18n.get("welcome"));
        System.out.println(I18n.get("start"));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (String command = reader.readLine(); !"stop".equalsIgnoreCase(command); command = reader.readLine()) {
                cmd.dispatch(command);
            }
        } catch (Exception e) {
            System.out.println(I18n.get("error.is"));
            e.printStackTrace();
        }
    }

    public boolean isInitialized() {
        return isInitialized;
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
