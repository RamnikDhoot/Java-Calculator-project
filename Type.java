package calculator;

/**
 * This is an enumerated class that contains the types of values that an entry can have.
 * 
 *
 */
public enum Type {
  /**
   * The types that entry can use.
   */
  NUMBER("number"), SYMBOL("symbol"), STRING("string"), INVALID("invalid");

  /**
   * Field that holds the string that corresponds to the type that is used.
   */
  private String type;

  /**
   * Constructor for the type to set the correct string with the correct type.
   * 
   * @param s the string associated with the type.
   */
  private Type(String s) {
    type = s;
  }

  /**
   * Prints the enumerated type as a string.
   */
  public String toString() {
    return type;
  }

}
