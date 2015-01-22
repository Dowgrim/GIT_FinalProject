package command.game;

import command.CommandArguments;

import java.util.Arrays;
import java.util.List;

public class MoveCommand extends GameCommand {

    /**
     * MoveCommand constructor
     */
    public MoveCommand() {
        super("move", I18n.get("move.description"));
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

        if (Zuul.getPlayer().isMobile()) {
            if (arguments.size() != 1) {
                showUsages();
                return;
            }

            String direction = arguments.getArgument(0);

            try {
                Cardinal cardinal = Cardinal.valueOf(direction.toUpperCase());
                Room neighbour = Zuul.getPlayer().getLocation().getNeighbour(cardinal);
                System.out.println(Zuul.getPlayer().getLocation().getName());
                if (neighbour != null) {
                    System.out.println(I18n.get("move.done", direction));
                    neighbour.onEnter(Zuul.getHour(), Zuul.getPlayer());
                } else {
                    System.out.println(I18n.get("move.impossible", direction));
                }
            } catch (IllegalArgumentException ignored) {
                showUsages();
            }
        } else {
            System.out.println(I18n.get("move.stuck", Zuul.getPlayer().getLocation().getName()));
        }
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "move " + Cardinal.NORTH + " | move the player to the " + Cardinal.NORTH
        );
    }

}
