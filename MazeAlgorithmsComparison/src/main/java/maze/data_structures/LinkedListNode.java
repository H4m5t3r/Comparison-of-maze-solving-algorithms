package maze.data_structures;

/**
 * The nodes used by the LinkedList class.
 * @author taleiko
 */
public class LinkedListNode {
    private final int number;
    private LinkedListNode next;
    
    /**
     * A constructor that creates a node with a value and the next node.
     * @param value
     * @param next 
     */
    public LinkedListNode(int value, LinkedListNode next) {
        this.number = value;
        this.next = next;
    }
    /**
     * Returns the integer stored in the node.
     * @return number
     */
    public int getValue() {
        return this.number;
    }
    /**
     * Returns the next node in the list.
     * @return next
     */
    public LinkedListNode getNext() {
        return this.next;
    }
    /**
     * Sets the node that comes next in the list.
     * @param node 
     */
    public void setNext(LinkedListNode node) {
        this.next = node;
    }
}
