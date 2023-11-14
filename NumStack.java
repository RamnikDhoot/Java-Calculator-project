package calculator;

import java.util.EmptyStackException;

/**
 * This is a stack of numeric values to be a facade for the underlying stack class.
 * 
 * @author ZKAC269
 */
public class NumStack {

  Stack newStack;

  /**
   * constructor for the NumStack object.
   */
  public NumStack() {
    newStack = new Stack();
  }

  /**
   * Returns the size of the object by calling size on the stack object.
   * 
   * @return size of the stack
   */
  public Integer size() {
    return newStack.size();
  }

  /**
   * Adds the number to the top of the stack.
   * 
   * @param test the number to be put onto the stack
   */
  public void push(Entry test) {
    newStack.push(test);

  }

  /**
   * The newest item that was added to the stack.
   * 
   * @return the item at the top of the stack.
   */
  public Entry top() {
    return newStack.top();
  }

  /**
   * Removes the newest entry added from the stack. Catches any EmptyStackException thrown by the
   * stack class.
   * 
   * @return the entry that was removed.
   */
  public Entry pop() {
    Entry popped = null;
    try {
      popped = newStack.pop();
    } catch (EmptyStackException e) {
      ;
    }
    return popped;

  }

  /**
   * Checks if the stack is empty.
   * 
   * @return if the stack is empty.
   */
  public Boolean isEmpty() {
    return newStack.size() == 0;
  }

}
