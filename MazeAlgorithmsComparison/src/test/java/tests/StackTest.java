
package tests;

import maze.data_structures.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class StackTest {
    private Stack s;
    private int length;
    
    @Before
    public void setUp() {
        length = 20;
        s = new Stack(length);
    }

    @Test
    public void StackTest() {
        assertTrue(s.isEmpty() == true);
        for (int i = 0; i < length; i++) {
            s.push(i);
        }
        assertTrue(s.isEmpty() == false);
        assertTrue(s.peek() == length - 1);
        assertTrue(s.size() == length);
        for (int i = length - 1; i > -1; i--) {
            assertTrue(s.pop() == i);
        }
        assertTrue(s.isEmpty() == true);
    }
}
