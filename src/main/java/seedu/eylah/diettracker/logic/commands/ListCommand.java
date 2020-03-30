package seedu.eylah.diettracker.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.eylah.diettracker.model.Model.PREDICATE_SHOW_ALL_FOODS;

import seedu.eylah.diettracker.logic.commands.exceptions.CommandException;
import seedu.eylah.diettracker.model.Model;

/**
 * Lists all food and their calories.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": lists all food in the book. Use tags to list "
            + "different things."
            + "Parameters: [-f] [-d] [-t [numDays]]";
    public static final String MESSAGE_SUCCESS = "All foods over period based on input tag has been listed.\n";

    private String mode = "-d";
    private int numDays;

    /**
     * Creates a ListCommand to list the foods consumed for a certain duration of time based on the input mode.
     */
    public ListCommand(String mode) {
        this.mode = mode;
    }

    /**
     * Creates a ListCommand to list the foods over the last numDays number of days.
     */
    public ListCommand(String mode, int numDays) {
        this.mode = mode;
        this.numDays = numDays;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        String listString;

        if (mode.equals("-t")) {
            model.updateFilteredFoodList(PREDICATE_SHOW_ALL_FOODS);
            String listDays = model.listFoods(mode, numDays);
            return new CommandResult(String.format(listDays));
        } else {
            model.updateFilteredFoodList(PREDICATE_SHOW_ALL_FOODS);
            String listAll = model.listFoods(mode);
            return new CommandResult(listAll);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListCommand // instanceof handles nulls
                );
    }
}
