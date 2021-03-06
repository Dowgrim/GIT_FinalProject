package vue.command;

import java.util.Collections;
import java.util.List;

public abstract class Command {

    // Command name
    private String name;
    // Command description
    private String description;

    /**
     * Command constructor
     *
     * @param name        Command name
     * @param description Command description
     */
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Return the command name
     *
     * @return command name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the command description
     * @return command description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Show command usage
     */
    public void showUsages() {
        for (String usage : getUsage())
            System.out.println(usage);
    }

    public List<String> getUsage() {
        return Collections.emptyList();
    }

    /**
     * Triggered when a command is called
     * @param arguments arguments needed by this command
     */
    public abstract void onCommand(CommandArguments arguments);

    /**
     * Give an answer to the user
     * @param message message printed
     * @param messages even more messages printed
     */
    public void reply(String message, String ... messages) {
        System.out.println("> " + message);
        for (String msg : messages)
            System.out.println("> " + msg);
    }

}
