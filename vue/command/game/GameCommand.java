package vue.command.game;

import vue.command.Command;
import vue.command.CommandArguments;
import vue.Game;

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
            System.out.println(I18n.get("game.not.start"));
            return false;
        }
        return true;
    }
}