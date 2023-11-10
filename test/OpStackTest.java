package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OpStackTest {
  private OpStack opStack;
  private Entry test;

  @BeforeEach
  void setup() {
    opStack = new OpStack();

  }
  
  @Test
  void testSize() {
    assertEquals(opStack.size(), 0, "Tests new stack to see if its size is zero");
  }
  
  @Test
  void testPush() {
    opStack.push(test);
    assertEquals(opStack.size(), 1,
        "Test that push increases the size of the empty stack by one.");
  }
  
  @Test
  void testTop() {
    Entry one = new Entry("hello");
    opStack.push(one);
    Entry two = new Entry(2.8f);
    opStack.push(two);
    test = new Entry("test");
    opStack.push(test);
    assertEquals("Entry [number=null, other=null, str=test, type=string]",
        opStack.top().toString(), "Tests that the top is the newest added item");
  }
  
  @Test
  // pop cannot throw any exception as it is caught in the method.
  void testPop() {
    Entry one = new Entry("hello");
    Entry two = new Entry(Symbol.PLUS);
    opStack.push(one);
    opStack.push(two);;
    assertEquals(2, opStack.size(), "After pushing twice the size should be 2");
    opStack.pop();
    opStack.pop();
    assertEquals(0, opStack.size(), "The stack should now be empty");
  }
  
  @Test
  void testIsEmpty() {
    assertEquals(opStack.isEmpty(), true, "Tests that the stack is empty");
  }

}
