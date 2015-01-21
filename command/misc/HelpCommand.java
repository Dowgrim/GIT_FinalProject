package fr.asura.zuul.command.misc;

import fr.asura.zuul.game.zuul.Zuul;
import fr.asura.zuul.command.Command;
import fr.asura.zuul.command.CommandArguments;
import fr.asura.zuul.i18n.I18n;

import java.util.List;

public class HelpCommand extends Command {

    /**
     * HelpCommand constructor
     */
    public HelpCommand() {
        super("help", I18n.get("help.description"));
    }

    /**
     * Triggered when help command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {

        List<Command> commands = Zuul.getCommandManager().getCommands();

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
