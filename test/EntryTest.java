package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EntryTest {
  private Entry testEntry;

  @Test
  // Test 3 - Created a constructor for floats. Then later added tests for getValue and getType.
  void testFloat() throws BadTypeException {
    testEntry = new Entry(5.1f);
    assertEquals(5.1f, testEntry.getValue(), "Tests that the float is saved and can be returned");
    assertEquals(Type.NUMBER, testEntry.getType(), "Tests that the type is Float");
  }

  @Test
  // Test 4 - Created a constructor for symbols. Then later added tests for getVlaue and getType.
  void testSymbol() throws BadTypeException {
    testEntry = new Entry(Symbol.MINUS);
    assertEquals(Symbol.MINUS, testEntry.getSymbol(),
        "Tests that the symbol is saved and can be returned");
    assertEquals(Type.SYMBOL, testEntry.getType(), "Tests that the type is Symbol");
  }

  @Test
  // Test 5 - Created a constructor for strings. Then later added tests for getVlaue and getType.
  void testString() throws BadTypeException {
    testEntry = new Entry("hello");
    assertEquals("hello", testEntry.getString(),
        "Tests that the string is saved and can be returned");
    assertEquals(Type.STRING, testEntry.getType(), "Tests that the type is String");
  }

  @Test
  // Test 6 - Created getType method then added type to the float constructor.
  void testTypeFloat() {
    testEntry = new Entry(1.1f);
    assertEquals(Type.NUMBER, testEntry.getType(),
        "Tests that the value stored is of the correct type");
  }

  @Test
  // Test 7 - Added type to string constructor,
  void testTypeString() {
    testEntry = new Entry("Hello");
    assertEquals(Type.STRING, testEntry.getType(),
        "Tests that the value stored is of the correct type");
  }

  @Test
  // Test 8 - Added type to symbol constructor.
  void testTypeSymbol() {
    testEntry = new Entry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, testEntry.getType(),
        "Tests that the value stored is of the correct type");
  }

  @Test
  // Test 9 - Made BadTypeException class then faked it to make getValue, getString and getSymbol
  // throw the exception.
  void testStringException() {
    testEntry = new Entry("hello");
    assertThrows(BadTypeException.class, () -> testEntry.getSymbol(),
        "The value stored is a string so you cannot return a Symbol");
    assertThrows(BadTypeException.class, () -> testEntry.getValue(),
        "The value stored is a string so you cannot return a float");

  }

  @Test
  // Test 10
  void testSymbolException() {
    testEntry = new Entry(Symbol.PLUS);
    assertThrows(BadTypeException.class, () -> testEntry.getString(),
        "The value stored is a Symbol so you cannot return a String");
    assertThrows(BadTypeException.class, () -> testEntry.getValue(),
        "The value stored is a Symbol so you cannot return a float");
  }

  @Test
  // Test 11
  void testFloatException() {
    testEntry = new Entry(6.0f);
    assertThrows(BadTypeException.class, () -> testEntry.getString(),
        "The value stored is a Float so you cannot return a String");
    assertThrows(BadTypeException.class, () -> testEntry.getSymbol(),
        "The value stored is a Float so you cannot return a Symbol");
  }

  @Test
  // Test 12 - Added the equals method.
  void testEquals() throws BadTypeException {
    Entry test1 = new Entry("hello");
    Entry test2 = new Entry("hello");
    assertEquals(true, test2.equals(test1));
  }

  @Test
  // Test 13 - Added hashcode method.
  void testHashcode() {
    testEntry = new Entry(6.0f);
    assertEquals(true, Integer.class.isInstance(testEntry.hashCode()));
  }

  @Test
  // Test 14 - Added toString method.
  void testToString() {
    testEntry = new Entry("hello");
    assertEquals("Entry [number=null, other=null, str=hello, type=string]", testEntry.toString(),
        "Tests that the entry object is prited as a string correctly");
  }


}
