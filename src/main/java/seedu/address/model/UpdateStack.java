package seedu.address.model;

import java.util.Arrays;
import java.util.Stack;

/**
 * Encapsulates a stack containing various future states of the ZooKeepBook, if any.
 * This is a singleton.
 */
public class UpdateStack {
    private static UpdateStack update;

    private final Stack<ReadOnlyZooKeepBook> updateStack;

    private UpdateStack() {
        updateStack = new Stack<>();
    }

    public static UpdateStack getUpdateStack() {
        if (update == null) {
            update = new UpdateStack();
        }
        return update;
    }

    /**
     * Checks if the 2 given ZooKeep books have the same content.
     * @param before the state of the ZooKeep book before an unknown command was executed
     * @param after the state of the ZooKeep book after command execution
     */
    public void checkEdit(ReadOnlyZooKeepBook before, ReadOnlyZooKeepBook after) {
        if (!before.equals(after)) {
            System.out.println("Cleared stack.");
            clearUpdates();
        }
    }

    public void removeRecentUpdate() {
        updateStack.pop();
    }

    public void addToUpdate(ReadOnlyZooKeepBook book) {
        updateStack.push(book);
    }

    public ReadOnlyZooKeepBook viewRecentUpdate() {
        return updateStack.peek();
    }

    public int getSize() {
        return updateStack.size();
    }

    public void clearUpdates() {
        updateStack.clear();
    }

    @Override
    public String toString() {
        return Arrays.toString(updateStack.toArray());
    }
}
