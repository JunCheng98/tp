package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyZooKeepBook;
import seedu.address.model.UpdateStack;

/**
 * Redoes the next action. Only applicable if undo was used before and no edit to the ZooKeepBook was
 * made in between, otherwise this command will do nothing.
 */
public class RedoCommand extends Command {
    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_SUCCESS = "Redo successful";
    public static final String MESSAGE_NO_REDO = "Nothing left to redo";

    private final UpdateStack updateStack;

    /**
     * Creates an RedoCommand that redoes the next action
     */
    public RedoCommand() {
        updateStack = UpdateStack.getUpdateStack();
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (updateStack.getSize() < 1) {
            throw new CommandException(MESSAGE_NO_REDO);
        }

        ReadOnlyZooKeepBook lastState = updateStack.viewRecentUpdate();
        model.setZooKeepBook(lastState);
        updateStack.removeRecentUpdate();
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RedoCommand // instanceof handles nulls
                && updateStack.equals(((RedoCommand) other).updateStack));
    }
}
