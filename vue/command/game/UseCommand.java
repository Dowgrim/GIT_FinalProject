package vue.command.game;

import vue.command.Command;
import vue.command.CommandArguments;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 23/01/2015.
 */
public class UseCommand extends Command {

    /**
     * Command constructor
     *
     */
    public UseCommand(String name, String description) {
        super("use", "Utilise un Item du sac");
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
