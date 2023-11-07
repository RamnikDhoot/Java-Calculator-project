package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SymbolTest {

  @Test
  // Test 1 - Created the symbol enum. Then added the test for toSting()
  void testReturnsString() {
    Symbol one = Symbol.PLUS;
    assertEquals("+", one.toString(), "Tests the correct string is output");
  }

}
