package vue.command.game;

import vue.command.CommandArguments;


import java.util.Arrays;
import java.util.List;

public class ItemCommand extends GameCommand {

    /**
     * ItemCommand constructor
     */
    public ItemCommand() {
        super("moteur/item", I18n.get("item.description"));
    }

    /**
     * Triggered when item command is called
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

        if ("list".equals(arguments.getArgument(0))) {
            StringBuilder builder = new StringBuilder(256);
            for (Item item : Zuul.getPlayer().getLocation().getItems().values()) {
                builder.append(item.getName()).append(", ");
            }
            String str = (builder.toString().length() > 0)? builder.toString().substring(0, builder.toString().length() - 2): I18n.get("item.none");

            reply(str);
        } else if ("use".equals(arguments.getArgument(0))) {
            Item item = Zuul.getPlayer().getLocation().getItem(arguments.getArgument(1).substring(0, 1).toUpperCase() +arguments.getArgument(1).substring(1));
            if (item != null)
                item.onUse(Zuul.getPlayer());
            else
                reply(I18n.get("item.not.found", arguments.getArgument(1)));
        } else {
            reply(I18n.get("item.unknown.argument", arguments.getArgument(0)));
        }

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "item list | Displays all items available in this room (Available: list, use)"
        );
    }

}
