package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class is for the command line interface of the calculator.
 * It handles user inputs and displays options for using the calculator.
 */
public class AsciiView implements ViewInterface {
    private String question;
    private String answer = "";
    private List<String> history = new ArrayList<>();
    Observer calc = null;
    Observer reset = null;

    /**
     * Outputs the menu and handles user inputs.
     */
    public void menu() {
        Scanner s = new Scanner(System.in);
        boolean finished = false;
        help();

        while (!finished && s.hasNext()) {
            String input = s.nextLine().toUpperCase();

            if (input.isEmpty()) continue;

            char command = input.charAt(0);
            switch (command) {
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
                    question = input.substring(1);
                    System.out.println("Expression set to: " + question);
                    break;
                case 'H':
                    showHistory();
                    break;
                case 'Q':
                    System.out.println("Exiting calculator...");
                    finished = true;
                    break;
                default:
                    help();
            }
        }
        s.close();
    }

    /**
     * Displays the help menu with commands.
     */
    private void help() {
        System.out.println("Use one of the following commands:");
        System.out.println("  ?Expression - Set expression");
        System.out.println("  C - Calculate expression");
        System.out.println("  R - Reset the calculator");
        System.out.println("  H - Show calculation history");
        System.out.println("  Q - Exit the calculator");
    }

    /**
     * Returns the expression input by the user.
     */
    public String getExpression() {
        return question;
    }

    /**
     * Sets the answer and stores it in the history.
     */
    public void setAnswer(String a) {
        this.answer = a;
        history.add(question + " = " + a);
    }

    /**
     * Displays the history of calculations.
     */
    private void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No calculations yet.");
            return;
        }
        System.out.println("Calculation History:");
        history.forEach(System.out::println);
    }

    

  @Override
  public void addCalcObserver(Runnable f) { 
  }

  @Override
  public void addTypeObserver(Consumer<OpType> l) {
    // TODO Auto-generated method stub

  }
} // Code taken from MVC javafx example

