package calculator;

/**
* The ways in a which a calculator may evaluate an arithmetic expression.
* 
*
*/
public enum OpType {
  
/**
* Normal order with operator between arguments like 5 * (3 + 2).
*/
INFIX,

/**
* Reverse Polish notation e.g. 325+*.
*/
POSTFIX;
}
