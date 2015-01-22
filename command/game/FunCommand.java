package command.game;

import command.CommandArguments;


import java.util.Arrays;
import java.util.List;

public class FunCommand extends GameCommand {

    /**
     * FunCommand constructor
     */
    public FunCommand() {
        super("fun", I18n.get("fun.description"));
    }

    /**
     * Triggered when fun command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {
        if (!isInitialized())
            return;

        if (arguments.size() < 1) {
            showUsages();
            return;
        }

        if ("move".equals(arguments.getArgument(0))) {
            String direction = arguments.getArgument(1).toUpperCase();
            if (direction != null && direction.length() == 1) {
                String dir = "TRLB";
                if (dir.contains(direction))
                    Zuul.getFun().move(direction);
                else
                    reply(I18n.get("fun.unknown.direction", direction));
            }
        } else if ("reset".equals(arguments.getArgument(0))) {
            reply(I18n.get("fun.reset"));
            Zuul.getFun().reset();
        } else if ("leave".equals(arguments.getArgument(0))) {
            reply(I18n.get("fun.leave", String.valueOf(Zuul.getPlayer().getFunBestScore())));
            Zuul.getPlayer().lostItem();
            Zuul.getFun().leave();
            Zuul.timerRun();
        } else {
            reply(I18n.get("fun.unknown.argument", arguments.getArgument(0)));
        }

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "move direction | Move the grid in the direction (Available: L, R, T, B)"
        );
    }

}
