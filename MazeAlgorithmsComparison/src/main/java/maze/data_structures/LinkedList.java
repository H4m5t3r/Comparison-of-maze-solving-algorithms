package maze.data_structures;

/**
 * A linked list data structure that uses the class LinkedListNode as nodes.
 * @author taleiko
 */
public class LinkedList {
    /**
     * The first node in the list.
     */
    private LinkedListNode first;
    /**
     * The size of the stack that is updated when integers are added and
     * removed.
     */
    private int size;

    /**
     * A constructor that sets the size to 0 and the first node in the list to
     * null since no nodes are added when the list is initialized.
     */
    public LinkedList() {
        this.size = 0;
        this.first = null;
    }
    /**
     * Adds the i to the end of the list.
     * @param i
     */
    public void add(final int i) {
        if (this.first == null) {
            this.first = new LinkedListNode(i, null);
        } else {
            LinkedListNode node = new LinkedListNode(i, null);
            LinkedListNode n = this.first;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(node);
        }
        this.size++;
    }
    /**
     * Returns the value at v.
     * @param v
     * @return integerAtV
     */
    public int get(final long v) {
        LinkedListNode search = this.first;
        for (int j = 0; j < v; j++) {
            search = search.getNext();
        }
        return search.getValue();
    }
    /**
     * Adds a value to the list without replacing any variables. It can be used
     * An example would be if you have a list with the values 0 and 2 in it and
     * want to insert the value 1 between them.
     * @param i
     * @param v
     */
    public void insert(final int i, final int v) {
        if (i == 0) {
            LinkedListNode wasFirst = new LinkedListNode(this.first.getValue(),
                    this.first.getNext());
            LinkedListNode newFirst = new LinkedListNode(v, wasFirst);
            this.first = newFirst;
        } else {
            LinkedListNode node = new LinkedListNode(v, null);
            LinkedListNode search = this.first;
            for (int j = 0; j < i - 1; j++) {
                search = search.getNext();
            }
            node.setNext(search.getNext());
            search.setNext(node);
        }
        this.size++;
    }
    /**
     * Removes the value with the index i from the list.
     * @param i
     */
    public void remove(final long i) {
        if (i == this.size - 1) {
            LinkedListNode search = this.first;
            for (int j = 0; j < i - 1; j++) {
                search = search.getNext();
            }
            search.setNext(null);
        } else if (i == 0) {
            this.first = this.first.getNext();
        } else {
            LinkedListNode search = this.first;
            for (int j = 0; j < i - 1; j++) {
                search = search.getNext();
            }
            search.setNext(search.getNext().getNext());
        }
        this.size--;
    }
    /**
     * Copies the values on the list to another list.
     * @param list
     */
    public void copyTo(final LinkedList list) {
        list.clear();
        for (int i = 0; i < this.size; i++) {
            list.add(this.get(i));
        }
    }
    /**
     * Removes all values from the list.
     */
    public void clear() {
        this.first = null;
        this.size = 0;
    }
    /**
     * Returns the number of integers on the list.
     * @return size
     */
    public int size() {
        return this.size;
    }
}
