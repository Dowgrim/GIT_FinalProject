package vue.command.misc;

import fr.asura.zuul.game.zuul.Zuul;
import fr.asura.zuul.command.Command;
import fr.asura.zuul.command.CommandArguments;
import fr.asura.zuul.i18n.I18n;

public class VersionCommand extends Command {

    /**
     * VersionCommand constructor
     */
    public VersionCommand() {
        super("version", I18n.get("version.description"));
    }

    /**
     * Triggered when version command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {
        System.out.println("Zuul version: " + Zuul.class.getPackage().getImplementationVersion());
    }

}
