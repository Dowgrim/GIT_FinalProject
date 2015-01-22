package vue.command.manage;

import com.google.common.base.Strings;
import fr.asura.zuul.command.Command;
import fr.asura.zuul.command.CommandArguments;
import fr.asura.zuul.game.zuul.Zuul;
import fr.asura.zuul.i18n.I18n;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class StartCommand extends Command {

    /**
     * StartCommand constructor
     */
    public StartCommand() {
        super("start", I18n.get("start.description"));
    }

    @Override
    public void onCommand(CommandArguments arguments) {

        if (arguments.size() != 1) {
            showUsages();
            return;
        }

        String name = arguments.getArgument(0);

        if (!Strings.isNullOrEmpty(name)) {
            if (name.matches("^.*[a-zA-Z0-9].*$")) {
                if (!Zuul.getBuilding().isInitialized()) {
                    Zuul.getPlayer().setName(name);
                    Zuul.getBuilding().init(Zuul.getPlayer());
                    System.out.println(I18n.get("start.ok", name));
                } else {
                    System.out.println(I18n.get("start.already"));
                }
            } else {
                System.out.println(I18n.get("start.name.an", name));
            }
        } else {
            System.out.println( I18n.get("start.name.noe"));
        }
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "start Asura | Start the game with a player named Asura"
        );
    }

}