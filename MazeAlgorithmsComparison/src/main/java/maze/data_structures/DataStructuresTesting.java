
package maze.data_structures;

/**
 * A file used for testing the data structures.
 * @author taleiko
 */
public class DataStructuresTesting {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 4; i++) {
            l.add(i);
        }
        l.remove(1);
        System.out.println(l.get(1));
        System.out.println(l.get(0));
        l.remove(0);
        System.out.println(l.get(0));
        l.remove(1);
        System.out.println(l.get(0));
        
    }
}
