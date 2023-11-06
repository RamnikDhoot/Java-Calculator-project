package calculator;


/**
 * This is a custom Exception class thrown when trying to return the wrong type of value.
 */
public class BadTypeException extends Exception {

  /**
   * ID for the exception.
   */
  private static final long serialVersionUID = 1L;

  /**
   * A constructor for the exception.
   * 
   * @param message the message to be displayed when the exception is thrown
   */
  public BadTypeException(String message) {
    super(message);
  }

}
