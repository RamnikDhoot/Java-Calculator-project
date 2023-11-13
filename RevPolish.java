package calculator;

import java.util.Scanner;

/**
 * Class which has all the logic for the calculator. It uses reverse polish notation.
 * 
 * @author zkac269
 *
 */
public class RevPolish {
  private NumStack list;

  /**
   * Takes a string expression and calculates it then returns the result. 
   * The expression should be in reverse polish notation.
   *
   * @param str the expression to be calculated
   * @return the result of the calculation
   * @throws BadTypeException if a part of the string is the wrong type
   */
  public Float evaluate(String str) throws BadTypeException { // should return a float
    list = new NumStack();
    Scanner reader = new Scanner(str);


    while (reader.hasNext()) {
      if (reader.hasNextInt()) {
        Entry next = new Entry(reader.nextInt());
        list.push(next);
      } else {
        Float args1 = list.pop().getValue();
        Float args2 = list.pop().getValue();
        switch (reader.next()) {
          case "+":
            Entry answer = new Entry(args1 + args2);
            list.push(answer);
            break;
          case "-":
            Entry answer1 = new Entry(args1 - args2);
            list.push(answer1);
            break;
          case "*":
            Entry answer2 = new Entry(args1 * args2);
            list.push(answer2);
            break;
          case "/":
            Entry answer3 = new Entry(args1 / args2);
            list.push(answer3);
            break;
          default:
            continue;
        }
      }


    }
    reader.close();
    return list.pop().getValue();
    // The code for the reader was taken from an example by Dave in the Debug Lecture example.
  }
}

