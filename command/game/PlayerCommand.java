package command.game;

import fr.asura.zuul.command.CommandArguments;
import fr.asura.zuul.game.zuul.Zuul;
import fr.asura.zuul.game.zuul.item.Item;
import fr.asura.zuul.i18n.I18n;

import java.util.Arrays;
import java.util.List;

public class PlayerCommand extends GameCommand {

    /**
     * PlayerCommand constructor
     */
    public PlayerCommand() {
        super("player", I18n.get("player.description"));
    }

    /**
     * Triggered when player command is called
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

        if ("energy".equals(arguments.getArgument(0))) {
            reply(String.valueOf(Zuul.getPlayer().getEnergy()));
        } else if ("name".equals(arguments.getArgument(0))) {
            reply(Zuul.getPlayer().getName());
        } else if ("location".equals(arguments.getArgument(0))) {
            reply(I18n.get("current.location", Zuul.getPlayer().getLocation().getName()));
        } else if ("items".equals(arguments.getArgument(0))) {
            StringBuilder builder = new StringBuilder(256);
            for (Item item : Zuul.getPlayer().getItems().values()) {
                builder.append(item.getName()).append(" - ").append(item.getType()).append(", ");
            }
            String str = (builder.toString().length() > 0)? builder.toString().substring(0, builder.toString().length()-2): I18n.get("item.none");

            reply(str);
        } else {
            reply(I18n.get("player.unknown.argument", arguments.getArgument(0)));
        }

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "player energy | Displays the current player's energy (Available: energy, name, location, items)"
        );
    }

}
