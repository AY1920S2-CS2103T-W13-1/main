package seedu.eylah.diettracker.logic.parser;

import static seedu.eylah.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.eylah.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.eylah.commons.logic.parser.exception.ParseException;
import seedu.eylah.diettracker.logic.commands.AddCommand;
import seedu.eylah.diettracker.logic.commands.BmiCommand;
import seedu.eylah.diettracker.logic.commands.Command;
import seedu.eylah.diettracker.logic.commands.DeleteCommand;
import seedu.eylah.diettracker.logic.commands.EditCommand;
import seedu.eylah.diettracker.logic.commands.HeightCommand;
import seedu.eylah.diettracker.logic.commands.HelpCommand;
import seedu.eylah.diettracker.logic.commands.ListCommand;
import seedu.eylah.diettracker.logic.commands.MetricsCommand;
import seedu.eylah.diettracker.logic.commands.ModeCommand;
import seedu.eylah.diettracker.logic.commands.WeightCommand;

/**
 * Parses user input.
 */
public class FoodBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);
        case HeightCommand.COMMAND_WORD:
            return new HeightCommandParser().parse(arguments);
        case WeightCommand.COMMAND_WORD:
            return new WeightCommandParser().parse(arguments);
        case BmiCommand.COMMAND_WORD:
            return new BmiCommandParser().parse(arguments);
        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);
        case ListCommand.COMMAND_WORD:
            return new ListCommandParser().parse(arguments);
        case ModeCommand.COMMAND_WORD:
            return new ModeCommandParser().parse(arguments);
        case MetricsCommand.COMMAND_WORD:
            return new MetricsCommandParser().parse(arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
