package calculator;


/**
 * Takes the expression entered and evaluates it then returns the answer.
 * 
 * @author zkac269
 *
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private Boolean isInfix;

  private void calculate() throws BadTypeException {
    String userInput = myView.getExpression();
    myView.setAnswer(String.valueOf(myModel.evaluate(userInput, isInfix)));
  }

  private void expressionType(OpType t) {
    if (t == OpType.INFIX) {
      isInfix = true;
    } else {
      isInfix = false;
    }
    myView.setAnswer("Changed to " + t);
  }

  /**
   * Constructor that adds the observers to the view interface.
   * 
   * @param v the view interface
   */
  public CalcController(ViewInterface v) {
    addView(v);
  }

  /**
   * Used to add the observers to the view.
   * 
   * @param v the view interface
   */
  public void addView(ViewInterface v) {
    myView = v;
    v.addCalcObserver(() -> {
      try {
        calculate();
      } catch (BadTypeException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    v.addTypeObserver(this::expressionType);
  }
  
  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
    view.addCalcObserver(() -> {
      try {
        calculate();
      } catch (BadTypeException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    view.addTypeObserver(this::expressionType);
  }

}
