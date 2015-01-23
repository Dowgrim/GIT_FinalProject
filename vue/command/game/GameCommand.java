package vue.command.game;

import vue.command.Command;
import vue.command.CommandArguments;
import moteur.Game;

public class GameCommand extends Command {

    /**
     * GameCommand constructor
     */
    public GameCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void onCommand(CommandArguments arguments) {}

    /**
     * Triggered when game command is called
     */
    public boolean isInitialized() {
        if (!Game.isInitialized()) {
            System.out.println("Le jeu n'est pas encore lancé");
            return false;
        }
        return true;
    }
}
