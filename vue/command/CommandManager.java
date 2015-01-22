package vue.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CommandManager {

    // Map containing all registered commands
    private Map<String, Command> commands = new HashMap<String, Command>();

    /**
     * Dispatch a command coming from the console
     *
     * @param command command to dispatch
     */
    public void dispatch(String command) {
        CommandArguments arguments = new CommandArguments(command);

        Command cmd = commands.get(arguments.getArgument(0));
        if (cmd != null) {
            try {
                cmd.onCommand(arguments.next());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + cmd.getName());
                e.printStackTrace();
            }
        } else {
            System.out.println("Unknown command, try \"help\" to get some help.");
        }
    }

    /**
     * List of all registered commands
     *
     * @return list of all registered commands
     */
    public List<Command> getCommands() {
        return new ArrayList<>(commands.values());
    }

    /**
     * Register a command
     *
     * @param command command to register
     */
    public void register(Command command) {
        checkNotNull(command, "A command can't be null");
        commands.put(command.getName(), command);
    }

    /**
     * Remove a command
     *
     * @param command command to remove
     */
    public void unregister(Command command) {
        checkNotNull(command, "A command can't be null");
        commands.remove(command.getName());
    }

    /**
     * Unregister all commands
     */
    public void empty() {
        commands.clear();
    }

}
