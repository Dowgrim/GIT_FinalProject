package vue.command.game;

import vue.command.Command;
import vue.command.CommandArguments;
import vue.command.CommandManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 23/01/2015.
 */
public class CrafterCommand extends Command {
    /**
     * Command constructor
     *
     */
    public CrafterCommand() {
        super("crafter", "Vous pouvez crafter dans cette salle");
    }

    @Override
    public void onCommand(CommandArguments arguments) {

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "move "
        );
        //Todo
        //comment utiliser la command !!
    }
}
