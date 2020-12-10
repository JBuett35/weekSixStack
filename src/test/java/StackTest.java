/** Created by James Buettner on Thursday, December 10, 2020 for CSC 422. */

//class for unit testing Stack class
import static org.junit.Assert.*;
import org.junit.Test;
public class StackTest {
    @Test
    public void testConstructors() {
        // testing constructors
        try {
            // creating a Stack using default capacity 20
            Stack<Integer> stk = new Stack<Integer>();
            // pushing 20 elements to stack, should not cause an exception
            for (int i = 0; i < 20; i++) {
                stk.push(i);
            }
            // reinitializing stack with capacity 25
            stk = new Stack<Integer>(25);
            // pushing 5 elements, should not cause an exception
            for (int i = 0; i < 25; i++) {
                stk.push(i);
            }
        } catch (Exception e) {
            // exception occurred, test failed
            fail(e.getMessage());
        }
    }
    @Test
    public void testPushPop() {
        // creating stack and testing push and pop operations
        Stack<Integer> stack = new Stack<Integer>();
        try {
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
            }
            // asserting that the stack retrieves the values in reverse order of
            // input
            for (int i = 5; i >= 1; i--) {
                assertEquals(i, (int) stack.pop());
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // now the stack is empty, it should cause an exception when pop is
        // called
        try {
            stack.pop();
            fail("Should cause exception when pop is called on empty stack");
        } catch (EmptyStackException e) {
            // test passed
        }
        // creating a stack of capacity 3
        stack = new Stack<Integer>(3);
        // trying to push 10 values to it, should cause exception
        try {
            for (int i = 0; i < 10; i++) {
                stack.push(i);
            }
            fail("Should cause exception when push is called on full stack");
        } catch (FullStackException e) {
            // test passed
        }
    }
    @Test
    public void testPeek() {
        // creating a stack and testing peek method
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 5; i++) {
            try {
                stack.push(i);
                // verifying that the pushed value is at the top
                assertEquals(i, (int) stack.peek());
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }
    @Test
    public void testEmpty() {
        // creating a stack and testing empty method
        Stack<Integer> stack = new Stack<Integer>();
        // should be empty initially
        assertEquals(stack.empty(), true);
        // adding a value
        try {
            stack.push(1);
        } catch (FullStackException e) {
            fail(e.getMessage());
        }
        // now it shouldnt be empty
        assertEquals(stack.empty(), false);
    }
}