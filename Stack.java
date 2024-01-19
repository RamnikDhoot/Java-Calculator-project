package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This is an implementation of a stack of Entry objects.
 */
public class Stack {

    /**
     * The list of values in the stack.
     */
    private ArrayList<Entry> values;

    /**
     * The constructor for a stack object.
     */
    public Stack() {
        values = new ArrayList<>();
    }

    /**
     * Returns the size of the stack.
     * 
     * @return size of the stack.
     */
    public int size() {
        return values.size();
    }

    /**
     * Adds an entry to the top of the stack.
     * 
     * @param entry the entry to be put on the stack.
     */
    public void push(Entry entry) {
        values.add(entry);
    }

    /**
     * Removes the newest entry added from the stack (top).
     * 
     * @return the entry that was removed.
     * @throws EmptyStackException thrown when the stack is empty.
     */
    public Entry pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return values.remove(values.size() - 1);
    }

    /**
     * Returns the item at the top of the stack without removing it.
     * 
     * @return the item at the top of the stack.
     * @throws EmptyStackException thrown when the stack is empty.
     */
    public Entry peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return values.get(values.size() - 1);
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * Clears the stack.
     */
    public void clear() {
        values.clear();
    }
}
