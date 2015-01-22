package moteur;

import moteur.door.Door;
import moteur.entity.Entity;
import moteur.room.Checkpoint;
import moteur.room.Corridor;
import moteur.room.Room;
import moteur.room.SpecialRoom;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michael on 20/01/2015.
 */
public class Game {


    private Random rand = new Random();

    private Entity player;

    //List of first Room of all floor
    private ArrayList<Room> firstRooms = new ArrayList<Room>();

    //If the game have been initialized
    private boolean isInitialized = false;



    public Game() {
        player = new Entity();
        firstRooms.set(0, floor());
        start();
    }

    /*public void createRandomGame(int nbFloor, ArrayList<Integer> Xs, ArrayList<Integer> Ys, Entity player){
        ArrayList<ArrayList<Room>> allRooms = new ArrayList<ArrayList<Room>>();

        for(int i = 0; i < nbFloor; i++) {
            allRooms.add(createRandomFloor(Xs.get(i), Ys.get(i)));
        }
    }*/


   /* public ArrayList<Room> createRandomFloor(int nb, int x, int y, Entity player, int posX, int posY){

        //rooms total de l'étage
        ArrayList<Room> rooms = new ArrayList<Room>();

        ArrayList<Corridor> corridors;

        ArrayList<Door> doors;

        rooms.add(new Checkpoint(nb+'0'+'0', 1, 1, player));

        for(int i = 0; i < ((x*y)/3)+rand.nextInt(x);  i++){
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

    }*/

    public void start() {
        //registerCommands();

        System.out.println("Welcome !!");

        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (String command = reader.readLine(); !"stop".equalsIgnoreCase(command); command = reader.readLine()) {
                cmd.dispatch(command);
            }
        } catch (Exception e) {
            System.out.println(I18n.get("error.is"));
            e.printStackTrace();
        }*/

        firstRooms.add(floor());



    }

    public Checkpoint floor(){

        ArrayList<Room> rooms = new ArrayList<Room>();

        Checkpoint cp = new Checkpoint(136, 1, 1, player);
        rooms.add(cp);

        Corridor co1 = new Corridor(135, 1, 1, "Corridor1");
        Corridor co2 = new Corridor(125, 1, 1, "Corridor2");
        Corridor co3 = new Corridor(115, 1, 1, "Corridor3");
        Corridor co4 = new Corridor(114, 1, 1, "Corridor4");

        Room r1 = new SpecialRoom(145, 1, 1, "Room1");
        Room r2 = new SpecialRoom(134, 1, 1, "Room2");
        Room r3 = new SpecialRoom(124, 1, 1, "Room3");
        Room r4 = new SpecialRoom(113, 1, 1, "Room4");
        Room r5 = new SpecialRoom(104, 1, 1, "Room5");
        Room r6 = new SpecialRoom(116, 1, 1, "Room6");
        Room r7 = new SpecialRoom(126, 1, 1, "Room6");
        Room r8 = new SpecialRoom(105, 1, 1, "Room8");

        ArrayList<Room> ar1 = new ArrayList<Room>();
        ar1.add(cp);
        ar1.add(co1);
        Door d1 = new Door(13536, 0, ar1);
        cp.addDoor(d1, 0);
        co1.addDoor(d1, 2);

        ArrayList<Room> ar2 = new ArrayList<Room>();
        ar2.add(co1);
        ar2.add(co2);
        Door d2 = new Door(13525, 0, ar2);
        co1.addDoor(d2, 3);
        co2.addDoor(d2, 1);

        ArrayList<Room> ar3 = new ArrayList<Room>();
        ar3.add(co2);
        ar3.add(co3);
        Door d3 = new Door(12515, 0, ar3);
        co2.addDoor(d3, 3);
        co3.addDoor(d3, 1);

        ArrayList<Room> ar4 = new ArrayList<Room>();
        ar4.add(co3);
        ar4.add(co4);
        Door d4 = new Door(11514, 0, ar4);
        co3.addDoor(d4, 0);
        co4.addDoor(d4, 2);

        ArrayList<Room> ar5 = new ArrayList<Room>();
        ar5.add(co1);
        ar5.add(r1);
        Door d5 = new Door(13545, 0, ar5);
        co1.addDoor(d5, 1);
        r1.addDoor(d5, 3);

        ArrayList<Room> ar6 = new ArrayList<Room>();
        ar6.add(co1);
        ar6.add(r2);
        Door d6 = new Door(13534, 0, ar6);
        co1.addDoor(d6, 0);
        r2.addDoor(d6, 2);

        ArrayList<Room> ar7 = new ArrayList<Room>();
        ar7.add(co2);
        ar7.add(r7);
        Door d7 = new Door(12526, 0, ar7);
        co2.addDoor(d7, 2);
        r7.addDoor(d7, 0);

        ArrayList<Room> ar8 = new ArrayList<Room>();
        ar8.add(co2);
        ar8.add(r3);
        Door d8 = new Door(12524, 0, ar8);
        co2.addDoor(d8, 0);
        r3.addDoor(d8, 2);

        ArrayList<Room> ar9 = new ArrayList<Room>();
        ar9.add(co4);
        ar9.add(r5);
        Door d9 = new Door(13534, 0, ar9);
        co4.addDoor(d9, 3);
        r5.addDoor(d9, 1);

        ArrayList<Room> ar10 = new ArrayList<Room>();
        ar10.add(co4);
        ar10.add(r4);
        Door d10 = new Door(13534, 0, ar10);
        co4.addDoor(d10, 0);
        r4.addDoor(d10, 2);

        ArrayList<Room> ar11 = new ArrayList<Room>();
        ar11.add(co4);
        ar11.add(r3);
        Door d11 = new Door(13534, 0, ar11);
        co4.addDoor(d11, 1);
        r3.addDoor(d11, 3);

        ArrayList<Room> ar12 = new ArrayList<Room>();
        ar12.add(co3);
        ar12.add(r6);
        Door d12 = new Door(13534, 0, ar11);
        co3.addDoor(d12, 3);
        r6.addDoor(d12, 1);

        ArrayList<Room> ar13 = new ArrayList<Room>();
        ar13.add(co3);
        ar13.add(r7);
        Door d13 = new Door(13534, 0, ar11);
        co3.addDoor(d13, 1);
        r7.addDoor(d13, 3);

        //TODO finir ....
        return cp;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Register all commands.
     */
    /*public static void registerCommands() {
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
    }*/
    public static void main(String[] args) {
        Game game = new Game();
    }
}
