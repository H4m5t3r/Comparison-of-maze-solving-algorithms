package maze.data_structures;

/**
 * The nodes used by the LinkedList class.
 * @author taleiko
 */
public class LinkedListNode {
    /**
     * The integer stored in the node.
     */
    private final int number;
    /**
     * The next node in the list.
     */
    private LinkedListNode next;

    /**
     * A constructor that creates a node with a value and the next node.
     * @param value
     * @param nextNode
     */
    public LinkedListNode(final int value, final LinkedListNode nextNode) {
        this.number = value;
        this.next = nextNode;
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
    public void setNext(final LinkedListNode node) {
        this.next = node;
    }
}
