package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {
  private StandardCalc calc;

  @BeforeEach
  void setup() {
    calc = new StandardCalc();
  }
  
  @Test
  void testList() throws BadTypeException {
    assertEquals(calc.evaluate("test"), 0);
  }
  
  @Test
  void testCalc() throws BadTypeException {
    assertEquals(calc.calculate("test"), 0);
  }

}
