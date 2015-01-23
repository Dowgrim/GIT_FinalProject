package vue.command.misc;

import moteur.Game;
import vue.command.Command;
import vue.command.CommandArguments;

import java.util.List;

public class HelpCommand extends Command {

    /**
     * HelpCommand constructor
     */
    public HelpCommand() {
        super("help", "Print all Command");
    }

    /**
     * Triggered when help command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {
        List<Command> commands = Game.getCommandManager().getCommands();

        StringBuilder builder = new StringBuilder(256);
        for (Command command : commands) {
            builder.append(command.getName())
                    .append(" | ")
                    .append(command.getDescription());
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }

}
