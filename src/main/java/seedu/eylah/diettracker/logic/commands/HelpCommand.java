package seedu.eylah.diettracker.logic.commands;

import seedu.eylah.commons.logic.command.CommandResult;
import seedu.eylah.diettracker.model.DietModel;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(DietModel model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false, false);
    }
}
