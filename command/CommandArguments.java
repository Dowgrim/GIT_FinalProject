package command;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandArguments {

    // Space splitter
    private final static Splitter SPACE = Splitter.on(" ").trimResults().omitEmptyStrings();
    // List of String arguments
    private List<String> arguments;
    // Flag
    private int index = 0;

    /**
     * CommandArgument constructor
     *
     * @param arguments List arguments
     */
    public CommandArguments(List<String> arguments) {
        this.arguments = new ArrayList<>(arguments);
    }

    /**
     * CommandArgument constructor
     *
     * @param arguments Array arguments
     */
    public CommandArguments(String[] arguments) {
        this(Arrays.asList(arguments));
    }

    /**
     * CommandArgument constructor
     *
     * @param arguments String arguments
     */
    public CommandArguments(String arguments) {
        this(SPACE.splitToList(Strings.nullToEmpty(arguments).trim()));
    }

    /**
     * Number of arguments
     *
     * @return number of arguments
     */
    public int size() {
        return arguments.size() - index;
    }

    /**
     * Returns true if any more arguments are presents
     *
     * @return true if there is still enough arguments
     */
    public boolean hasMore() {
        return index < arguments.size();
    }

    /**
     * Increment the argument index
     *
     * @return this with an incremented index
     */
    public CommandArguments next() {
        if (++index > arguments.size()) --index;
        return this;
    }

    /**
     * Get an argument with a specific index
     *
     * @param index index of desired argument
     * @return string argument if it was found, or null
     */
    public String getArgument(int index) {
        if (index < 0) return null;

        try {
            return arguments.get(this.index + index);
        } catch (IndexOutOfBoundsException ignored) {
            return null;
        }
    }

    /**
     * Get an integer argument
     * @param index index of desired argument
     * @return integer argument if it was found, or null
     */
    public int getInt(int index) {
        String arg = getArgument(index);
        if(arg == null) throw new NumberFormatException();

        return Integer.parseInt(arg);
    }

    /**
     * Get a short argument
     * @param index index of desired argument
     * @return short argument if it was found, or null
     */
    public short getShort(int index) {
        String arg = getArgument(index);
        if(arg == null) throw new NumberFormatException();

        return Short.parseShort(arg);
    }

    /**
     * Get a long argument
     * @param index index of desired argument
     * @return long argument if it was found, or null
     */
    public long getLong(int index) {
        String arg = getArgument(index);
        if(arg == null) throw new NumberFormatException();

        return Long.parseLong(arg);
    }
}
