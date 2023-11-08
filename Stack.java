package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This is an implementation of a stack of Entry objects.
 * 
 * @author ZKAC269
 *
 */
public class Stack {

  /**
   * The list of values in the stack.
   */
  ArrayList<Entry> values;

  /**
   * The size of the stack.
   */
  int size;

  /**
   * The constructor for a stack object.
   */
  public Stack() {
    values = new ArrayList<Entry>();
  }

  /**
   * Returns the size of the stack.
   * 
   * @return size of the stack.
   */
  public int size() {
    return size;
  }

  /**
   * Adds an entry to the top of the stack.
   * 
   * @param i the entry to be put on the stack.
   */
  public void push(Entry i) {
    size += 1;
    values.add(i);

  }

  /**
   * Removes the newest entry added from the stack(top).
   * 
   * @return the entry that was removed.
   * @throws EmptyStackException thrown when the stack is empty and we try to remove an entry.
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry pop = values.get(values.size() - 1);
    values.remove(values.size() - 1);
    size -= 1;
    return pop;
  }

  /**
   * The newest item added to the stack.
   * 
   * @return a copy of the item at the top of the stack.
   * @throws EmptyStackException thrown when the stack is empty and we try to get the top entry.
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return values.get(values.size() - 1);
  }

}


