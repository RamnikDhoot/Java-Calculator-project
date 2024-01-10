 package calculator;

/**
 * This class is used to actually interact with the controller. 
 * It returns the result of a RevPolish calculator or infix calculation depending on the input.
 * 
 * @author zkac269
 *
 */
public class CalcModel {
  RevPolish calc1 = new RevPolish();
  StandardCalc calc2 = new StandardCalc();

  /**
   * This evaluates the result of an expression.
   * 
   * @param string the expression to be evaluated
   * @param infix whether the expression should be evaluated using infix or reverse polish notation
   * @return the result of the expression
   * @throws BadTypeException if the input is not a valid expression
   */
  public float evaluate(String string, Boolean infix) throws BadTypeException {
    if (infix == true) {
      return calc2.evaluate(string);
    }
    return calc1.evaluate(string);
  }
}
