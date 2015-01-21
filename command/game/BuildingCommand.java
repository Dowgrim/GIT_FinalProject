package command.game;

import fr.asura.zuul.command.CommandArguments;
import fr.asura.zuul.game.zuul.Zuul;
import fr.asura.zuul.i18n.I18n;

import java.util.Arrays;
import java.util.List;

public class BuildingCommand extends GameCommand {

    /**
     * BuildingCommand constructor
     */
    public BuildingCommand() {
        super("building", I18n.get("building.description"));
    }

    /**
     * Triggered when building command is called
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

        if ("map".equals(arguments.getArgument(0))) {
            reply(Zuul.getBuilding().map());
        } else if ("schedule".equals(arguments.getArgument(0))) {
            System.out.println(Zuul.getBuilding().schedule());
        } else if ("time".equals(arguments.getArgument(0))) {
            reply(I18n.get("hour", String.valueOf(Zuul.getHour())));
        } else {
            reply(I18n.get("building.unknown.argument", arguments.getArgument(0)));
        }

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "building map | Displays the map (Available: map, schedule)"
        );
    }

}
