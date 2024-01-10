package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
    private OpStack opStack;
    private Entry testEntry;

    @BeforeEach
    void setup() {
        opStack = new OpStack();
        testEntry = new Entry("test");
    }

    @Test
    void testSize() {
        assertEquals(0, opStack.size(), "Stack should be empty on initialization");
    }

    @Test
    void testPush() {
        opStack.push(testEntry);
        assertEquals(1, opStack.size(), "Push should increase stack size by one");
    }

    @Test
    void testTopWithEmptyStack() {
        assertThrows(EmptyStackException.class, () -> opStack.top(),
                "Accessing top of empty stack should throw EmptyStackException");
    }

    @Test
    void testTop() {
        opStack.push(testEntry);
        assertSame(testEntry, opStack.top(), "Top should return the last pushed item");
    }

    @Test
    void testPopWithEmptyStack() {
        assertThrows(EmptyStackException.class, () -> opStack.pop(),
                "Popping from empty stack should throw EmptyStackException");
    }

    @Test
    void testPop() {
        opStack.push(testEntry);
        assertSame(testEntry, opStack.pop(), "Pop should remove and return the last item");
        assertEquals(0, opStack.size(), "Stack size should decrease after pop");
    }

    @Test
    void testIsEmpty() {
        assertTrue(opStack.isEmpty(), "New stack should be empty");
        opStack.push(testEntry);
        assertFalse(opStack.isEmpty(), "Stack with items should not be empty");
    }

    @Test
    void testClear() {
        opStack.push(testEntry);
        opStack.push(new Entry("another"));
        opStack.clear();
        assertTrue(opStack.isEmpty(), "Clear should remove all items from the stack");
    }

    @Test
    void testMultipleOperations() {
        opStack.push(new Entry("first"));
        opStack.push(new Entry("second"));
        opStack.pop();
        Entry topEntry = new Entry("third");
        opStack.push(topEntry);
        assertSame(topEntry, opStack.top(), "Top should be the last pushed item");
        assertEquals(2, opStack.size(), "Stack size should reflect number of push/pop operations");
    }

    // Add more tests here for any additional methods or edge cases in your OpStack class
}
