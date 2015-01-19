package zuul.commands;

/**
 * Representations for all the valid command words for the game along with a
 * string in a particular language.
 * 
 * @author Michael Kölling and David J. Barnes, Nicolas Hory and Cindy Najjar
 * @version 2011.08.10
 */
public enum CommandWord {
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), BAG("bag"), READ("read"), UNKNOWN("?"), LIGHT("light"), PICKUP("pickup"), PLAY("play"), DRINK("drink"), TABLET("tablet");

    // The command string.
    private String commandString;

    /**
     * Initialise with the corresponding command string.
     * 
     * @param commandString
     *            The command string.
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * @return The command word as a string.
     */
    public String toString() {
        return commandString;
    }
}
