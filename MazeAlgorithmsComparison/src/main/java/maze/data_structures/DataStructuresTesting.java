
package maze.data_structures;

/**
 * A file used for testing the data structures.
 * @author taleiko
 */
public class DataStructuresTesting {
    public static void main(String[] args) {
        Stack s = new Stack(16);
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
