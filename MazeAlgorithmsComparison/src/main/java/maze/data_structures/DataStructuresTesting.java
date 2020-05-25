
package maze.data_structures;

import java.util.ArrayDeque;

/**
 * A file used for testing the data structures.
 * @author taleiko
 */
public class DataStructuresTesting {
    public static void main(String[] args) {
        long start = System.nanoTime();
        Stack stack = new Stack(40000);
        long time1 = System.nanoTime();
        System.out.println(time1 - start);
        for (int i = 0; i < 40000; i++) {
            stack.push(i);
        }
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);
    }
}
