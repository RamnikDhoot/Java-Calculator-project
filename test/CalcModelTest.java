package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {
  CalcModel test;

  @BeforeEach
  void stetup() {
    test = new CalcModel();
  }

  @Test
  void testEvaluate() throws BadTypeException {
    test.evaluate("1", true);
  }
  
  @Test
  void testRevPolish() throws BadTypeException {
    assertEquals(test.evaluate("1 2 3 + +", false),6);
  }


}
