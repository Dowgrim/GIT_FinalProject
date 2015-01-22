package command.manage;

import command.Command;
import command.CommandArguments;

import java.util.Arrays;
import java.util.List;

public class LanguageCommand extends Command {

    /**
     * ChangeLanguageCommand constructor
     */
    public LanguageCommand() {
        super("language", I18n.get("language.description"));
    }

    /**
     * Triggered when help command is called
     *
     * @param arguments arguments needed by this command
     */
    @Override
    public void onCommand(CommandArguments arguments) {

        if (arguments.size() != 1) {
            showUsages();
            return;
        }

        String language = arguments.getArgument(0).toUpperCase();

        try {
            I18n.setLanguage(I18n.SupportedLanguage.valueOf(language));

            Zuul.getCommandManager().empty();
            Zuul.registerCommands();

            System.out.println(I18n.get("language.changed", language));
        } catch(IllegalArgumentException ignored){
            System.out.println(I18n.get("language.not.supported", language));
        }
    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "language " + I18n.SupportedLanguage.FR + " | Set the language to " + I18n.SupportedLanguage.FR
        );
    }

}
