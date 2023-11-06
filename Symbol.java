package calculator;

/**
 * This is an enumerated class that contains the symbols that can be used in the entry class.
 * 
 *
 */
public enum Symbol {
  /**
   * The symbols that entry can use.
   */
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "invalid");

  /**
   * Field that holds the string that corresponds to the symbol that is used.
   */
  private String symbol;

  /**
   * Constructor for the symbol to set the correct string with the correct symbol.
   * 
   * @param s the string associated with the symbol.
   */
  private Symbol(String s) {
    symbol = s;
  }

  /**
   * Prints the enumerated type as a string.
   */
  public String toString() {
    return symbol;
  }

}
