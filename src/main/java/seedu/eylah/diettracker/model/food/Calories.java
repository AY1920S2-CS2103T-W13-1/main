package seedu.eylah.diettracker.model.food;

import static java.util.Objects.requireNonNull;
import static seedu.eylah.commons.util.AppUtil.checkArgument;

/**
 * Represents a Food's calories count in the diet tracker of EYLAH.
 * Guarantees: immutable; is valid as declared in {@link #isValidCalories(long)}
 */
public class Calories {

    public static final long LONG_ZERO = 0;
    public static final String MESSAGE_CONSTRAINTS =
            "Calories count should be zero or a positive whole number";
    public final long value;

    /**
     * Constructs a {@code Calories}.
     *
     * @param calories A valid calories number.
     */
    public Calories(long calories) {
        requireNonNull(calories);
        checkArgument(isValidCalories(calories), MESSAGE_CONSTRAINTS);
        this.value = calories;
    }

    public long getValue() {
        return value;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidCalories(long test) {
        return test >= LONG_ZERO;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Calories // instanceof handles nulls
                && value == ((Calories) other).value); // state check
    }

    @Override
    public int hashCode() {
        return Long.valueOf(value).hashCode();
    }
}
