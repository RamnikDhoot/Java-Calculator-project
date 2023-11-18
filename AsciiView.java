package calculator;


import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class is for the command line interface of the calculator.
 * It will output options to the user and explain how to use the calculator on the command line.
 * @author zkac269
 *
 */
public class AsciiView implements ViewInterface {
  private String question;
  Observer calc = null;
  Observer reset = null;

  /**
   *This outputs the menu for the user to read.
   *It shows all the options the user has.
   */
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    // The order of these checks is critical because hasNext blocks
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          if (calc != null) {
            calc.notifyObservers();
          }
          break;
        case 'R':
          if (reset != null) {
            reset.notifyObservers();
          }
          break;
        case '?':
          question = t.substring(1);
          System.out.println("Expression set to: " + question);
          break;
        case 'Q':
          System.out.println("End");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  T - to reset the calculator");
    System.out.println("  Q - to exit");
  }

  /**
   *Returns the expression that is input into the command line.
   */
  public String getExpression() {
    return question;
  }

  /**
   *Gets the answer.
   */
  public void setAnswer(String a) {
  }

  @Override
  public void addCalcObserver(Runnable f) { 
  }

  @Override
  public void addTypeObserver(Consumer<OpType> l) {
    // TODO Auto-generated method stub

  }
} // Code taken from MVC javafx example

