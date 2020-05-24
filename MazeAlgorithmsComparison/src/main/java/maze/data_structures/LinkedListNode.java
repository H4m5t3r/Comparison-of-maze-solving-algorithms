package maze.data_structures;

/**
 *
 * @author taleiko
 */
public class LinkedListNode {
    private final int number;
    private LinkedListNode next;
    
    public LinkedListNode(int value, LinkedListNode next) {
        this.number = value;
        this.next = next;
    }
    
    public int getValue() {
        return this.number;
    }
    
    public LinkedListNode getNext() {
        return this.next;
    }
    
    public void setNext(LinkedListNode node) {
        this.next = node;
    }
}
