package calculator;

import java.util.Scanner;

/**
 * Class handling the logic for a calculator using Reverse Polish Notation.
 */
public class RevPolish {
    private NumStack list;

    /**
     * Evaluates a string expression in reverse polish notation.
     *
     * @param str The expression to be calculated.
     * @return The result of the calculation.
     * @throws BadTypeException If an invalid operation or number is encountered.
     * @throws ArithmeticException If there's an attempt to divide by zero.
     */
    public Float evaluate(String str) throws BadTypeException {
        list = new NumStack();
        Scanner reader = new Scanner(str);

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                Entry next = new Entry(reader.nextInt());
                list.push(next);
            } else {
                // Ensure there are enough operands before performing operations
                if (list.size() < 2) {
                    throw new BadTypeException("Not enough operands for the operation");
                }

                Float args2 = list.pop().getValue();
                Float args1 = list.pop().getValue();
                String operator = reader.next();

                Entry answer = switch (operator) {
                    case "+" -> new Entry(args1 + args2);
                    case "-" -> new Entry(args1 - args2);
                    case "*" -> new Entry(args1 * args2);
                    case "/" -> {
                        if (args2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed");
                        }
                        yield new Entry(args1 / args2);
                    }
                    default -> throw new BadTypeException("Invalid operator: " + operator);
                };

                list.push(answer);
            }
        }

        reader.close();
        if (list.size() != 1) {
            throw new BadTypeException("Invalid RPN expression");
        }
        return list.pop().getValue();
    }
}
