package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TypeTest {

  @Test
  // Test 2 - Created the enum for type. Then added the test for toString method.
  void testReturnsString() {
    Type one = Type.NUMBER;
    assertEquals("number", one.toString(), "Tests the correct string is output");
  }

}
