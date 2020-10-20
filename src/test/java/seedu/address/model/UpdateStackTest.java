package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UpdateStackTest {
    @Test
    public void execute_get_updateStack() {
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        assertEquals(updateStack, UpdateStack.getUpdateStack());
    }

    @Test
    public void execute_addToUpdate_success() {
        ZooKeepBook book = new ZooKeepBook();
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        updateStack.clearUpdates();
        updateStack.addToUpdate(book);
        assertEquals(updateStack.toString(), "[0 animals]");
    }

    @Test
    public void execute_removeRecentUpdate() {
        ZooKeepBook book = new ZooKeepBook();
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        updateStack.clearUpdates();
        updateStack.addToUpdate(book);
        updateStack.removeRecentUpdate();
        assertEquals(updateStack.toString(), "[]");
    }

    @Test
    public void execute_viewRecentUpdate() {
        ZooKeepBook book = new ZooKeepBook();
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        updateStack.clearUpdates();
        updateStack.addToUpdate(book);
        assertEquals(updateStack.viewRecentUpdate().toString(), "0 animals");
    }

    @Test
    public void execute_getSize() {
        ZooKeepBook book = new ZooKeepBook();
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        updateStack.clearUpdates();
        updateStack.addToUpdate(book);
        assertEquals(updateStack.getSize(), 1);
    }

    @Test
    public void execute_clearUpdates() {
        ZooKeepBook book = new ZooKeepBook();
        UpdateStack updateStack = UpdateStack.getUpdateStack();
        updateStack.clearUpdates();
        assertEquals(updateStack.toString(), "[]");
    }
}
