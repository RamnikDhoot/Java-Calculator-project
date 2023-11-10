package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack testStack;
  private Entry test;

  @BeforeEach
  // Test 15 - Created stack class with a constructor.
  public void setup() {
    testStack = new Stack();

  }

  @Test
  // Test 16 - Initially faked by setting size field to 0,
  void testSize() {
    assertEquals(testStack.size(), 0, "Tests new stack to see if its size is zero");
  }

  @Test
  // Test 17 - Made push method add 1 to size.
  void testPush() {
    testStack.push(test);
    assertEquals(testStack.size(), 1,
        "Test that push increases the size of the empty stack by one.");
  }

  @Test
  // Test 18 - Added ArrayList values then mad push add an entry to the list. Then made pop method
  // just do size-1.
  void pushTwiceThenPop() {
    Entry one = new Entry("hello");
    Entry two = new Entry(Symbol.PLUS);
    testStack.push(one);
    testStack.push(two);
    assertEquals(2, testStack.size(), "After pushing twice the size should be 2");
    testStack.pop();
    testStack.pop();
    assertEquals(0, testStack.size(), "The stack should now be empty");
  }

  @Test
  // Test 19 - Made pop the return a value.
  void testPushPop() {
    test = new Entry("test");
    testStack.push(test);
    assertEquals("Entry [number=null, other=null, str=test, type=string]",
        testStack.pop().toString(), "Tests that pop returns the newest added value");
  }

  @Test
  // Test 20 - Added EmptyStackException to pop.
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> testStack.pop(),
        "You cannot pop from an empty stack");
  }

  @Test
  // Test 21 - Created top method.
  void testTop() {
    Entry one = new Entry("hello");
    testStack.push(one);
    Entry two = new Entry(2.8f);
    testStack.push(two);
    test = new Entry("test");
    testStack.push(test);
    assertEquals("Entry [number=null, other=null, str=test, type=string]",
        testStack.top().toString(), "Tests that the top is the newest added item");
  }

  @Test
  // Test 22 - Added EmptyStackException to top.
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> testStack.top(),
        "The stack is empty so there is no top");
  }

  @Test
  // Test 23
  void testPushAndPopLots() {
    for (int index = 0; index < 1000; index++) {
      test = new Entry(5.0f + index);
      testStack.push(test);
    }
    assertEquals(1000, testStack.size(), "Pushing 1000 items means the size should be 1000");
    for (int index = 0; index < 1000; index++) {
      testStack.pop();
    }
    assertEquals(0, testStack.size(), "Popping 1000 items means the size should be 0");
  }



}
