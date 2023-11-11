package calculator;

import java.util.function.Consumer;

/**
 * Interface between the user input and the results to be shown.
 * 
 * @author zkac269
 *
 */
public interface ViewInterface {

  /**
   * Adds an observer for the calculation.
   * 
   * @param f the calculation
   */
  void addCalcObserver(Runnable f);
  
  /**
   * Adds an observer for the type of calculation (Infix/Reverse polish) to track user interaction.
   * 
   * @param l the type of the calculation
   */
  void addTypeObserver(Consumer<OpType> l);

  /**
   * Get the expression from user input.
   * 
   * @return the expression
   */
  String getExpression();

  /**
   * Used to output the answer to a given expression to the user.
   * 
   * @param answer the answer to an expression
   */
  void setAnswer(String answer);
  
  /**
   * This calls the menu method to display options to the user.
   */
  public void menu();

}