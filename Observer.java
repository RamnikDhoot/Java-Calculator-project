package calculator;

/**
 * This defines a new functional type that we can then name as more meaningful for an observer
 * notification.
 * 
 * @author zkac269
 *
 */
@FunctionalInterface
public interface Observer {
  /**
   * The named mechanism that we will use when we are notifying an Observer.
   */
  public void notifyObservers();
}
