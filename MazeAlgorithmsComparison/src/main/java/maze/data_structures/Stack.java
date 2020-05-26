
package maze.data_structures;

/**
 * A class that implements a stack data structure where the size of the stack
 * is given.
 * @author taleiko
 */
public class Stack {
    /**
     * The array that is used for storing the values in the stack.
     */
    private final int[] stack;
    /**
     * An integer that remembers where the top of the stack is.
     */
    private int top;
    /**
     * Creates a stack that has space for i integers.
     * @param i
     */
    public Stack(int i) {
        stack = new int[i];
        top = 0;
    }
    /**
     * Adds an integer to the stack.
     * @param data
     */
    public void push(int data) {
        stack[top] = data;
        top++;
    }
    /**
     * Removes the value on top of the stack and returns it.
     * @return data
     */
    public int pop() {
        top--;
        int data = stack[top];
        return data;
    }
    /**
     * Returns the value on the top of the stack.
     * @return data
     */
    public int peek() {
        return stack[top - 1];
    }
    /**
     * Returns the number of integers in the stack.
     * @return size
     */
    public int size() {
        return this.top;
    }
    /**
     * Returns true if there are no integers stored in the stack.
     * @return isEmpty
     */
    public boolean isEmpty() {
        return top == 0;
    }
    
    public void show() {
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i]);
            if (i != top - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}
