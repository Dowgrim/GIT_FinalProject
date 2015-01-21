package command.game;

import command.Command;
import command.CommandArguments;

import java.util.Arrays;
import java.util.List;

public class WorkCommand extends GameCommand {

    /**
     * WorkCommand constructor
     */
    public WorkCommand() {
        super("work", I18n.get("work.description"));
    }

    /**
     * Triggered when fun command is called
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

        if ("answer".equals(arguments.getArgument(0))) {
            String answer = arguments.getArgument(1).toLowerCase();
            ExamItem item = (ExamItem) Zuul.getPlayer().getWorking();
            if (Boolean.valueOf(answer).equals(item.getExercice(item.getIndex() - 1).getAnswer())) {
                item.updateScore(1);
            } else {
                item.updateScore(0);
            }
            item.onUse(Zuul.getPlayer());
        } else {
            reply(I18n.get("work.unknown.argument", arguments.getArgument(0)));
        }

    }

    @Override
    public List<String> getUsage() {
        return Arrays.asList(
                "move direction | Move the grid in the direction (Available: L, R, T, B)"
        );
    }

}


