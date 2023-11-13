package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class revPolishTest {
  RevPolish calc;

  @BeforeEach
  void setup() {
    calc = new RevPolish();
  }

  @Test
  void testList() throws BadTypeException {
    assertEquals(calc.evaluate("1 3 +"), 4);
  }

  @Test
  void testEight() throws BadTypeException {
    assertEquals(calc.evaluate("1 2 3 4 5 6 7 8 + + + + + + +"), 36);
  }

  @Test
  void testMinus() throws BadTypeException {
    assertEquals(0, calc.evaluate("1 1 -"));
  }

  @Test
  void testMinusEight() throws BadTypeException {
    assertEquals(-20, calc.evaluate("1 2 3 4 5 6 7 8 - - - - - - -"));
  }

  @Test
  void testMultiply() throws BadTypeException {
    assertEquals(24, calc.evaluate("1 2 3 4 * * *"));
  }

  @Test
  void testDivide() throws BadTypeException {
    assertEquals((float) 0.5, calc.evaluate("2 1 /"));
  }

  @Test
  void test1() throws BadTypeException {
    assertEquals(5, calc.evaluate("2 1 3 / +"));
  }

  @Test
  void test2() throws BadTypeException {
    assertEquals(12, calc.evaluate("2 1 4 7 7 / + + *"));
  }

  @Test
  void test3() throws BadTypeException {
    assertEquals(23, calc.evaluate("11 12  +"));
  }

  @Test
  void test4() throws BadTypeException {
    assertEquals((float) 10.083334, calc.evaluate("11 12 1 3 9 4  + - + / *"));
  }



}
