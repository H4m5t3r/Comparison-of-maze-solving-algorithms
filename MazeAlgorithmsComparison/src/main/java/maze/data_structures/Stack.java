
package maze.data_structures;

/**
 * A class that implements a stack data structure where the size of the stack
 * is given.
 * @author taleiko
 */
public class Stack {
    private final int[] stack;
    private int top;
    /**
     * Creates a stack that has space for i integers.
     * @param i 
     */
    public Stack(int i) {
        stack = new int[i];
        top = 0;
    }
    
    public void push(int data) {
        stack[top] = data;
        top++;
    }
    
    public int pop() {
        top--;
        int data = stack[top];
        stack[top] = 0;
        return data;
    }
    
    public int peek() {
        return stack[top - 1];
    }
    
    public int size() {
        return this.top;
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
}
