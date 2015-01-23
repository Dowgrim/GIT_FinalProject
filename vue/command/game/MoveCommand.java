package vue.command.game;

import moteur.Game;
import moteur.room.Room;
import vue.command.CommandArguments;

import java.util.Arrays;
import java.util.List;

public class MoveCommand extends GameCommand {

    /**
     * MoveCommand constructor
     */
    public MoveCommand() {
        super("move", "Move your player");
    }

    /**
     * Triggered when help command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {
        if (!isInitialized())
            return;

        if (arguments.size() != 1) {
                showUsages();
                return;
        }
        try {
            int direction = Integer.parseInt(arguments.getArgument(0));
            Room r = Game.getPlayer().getCurrentRoom();
            try {
                int res = r.getExits().get(direction).move(Game.getPlayer());

                if (res == 1) {
                    System.out.println("La porte est fermée");
                    return;
                } else if (res == 2) {
                    System.out.println("C'est un mur :/");
                    return;
                }
                System.out.println("Vous êtes maintenant dans la salle numéro " + Game.getPlayer().getCurrentRoom().getNumber());
                System.out.println("Vous êtes donc dans : " + Game.getPlayer().getCurrentRoom().getDescription());
            } catch (Exception e) {
                System.out.println("C'est un mur !");
            }

        } catch (IllegalArgumentException ignored) {
            showUsages();
        }
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "Utilisation de move: move + numéro de salle"
        );
    }

}
