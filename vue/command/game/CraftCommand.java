package vue.command.game;

import vue.command.Command;
import vue.command.CommandArguments;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 23/01/2015.
 */
public class CraftCommand extends Command {

    /**
     * Command constructor
     *
     */
    public CraftCommand() {
        super("craft", "Permet de crafter des objets");
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
