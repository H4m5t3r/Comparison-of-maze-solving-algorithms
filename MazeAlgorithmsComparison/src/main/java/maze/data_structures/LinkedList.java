package maze.data_structures;

/**
 *
 * @author taleiko
 */
public class LinkedList {
    private LinkedListNode first;
    private int size;
    
    public LinkedList() {
        this.size = 0;
        this.first = null;
    }
    
    public void add(int i) {
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
    
    public int get(long v) {
        LinkedListNode search = this.first;
        for (int j = 0; j < v; j++) {
            search = search.getNext();
        }
        return search.getValue();
    }
    
    public void insert(int i, int v) {
        if (i == 0) {
            LinkedListNode wasFirst = new LinkedListNode(this.first.getValue(), this.first.getNext());
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
    
    public void remove(long i) {
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
    
    public void copyTo(LinkedList list) {
        for (int i = 0; i < this.size; i++) {
            list.add(this.get(i));
        }
    }
    
    public void clear() {
        this.first = null;
        this.size = 0;
    }
    
    public int size() {
        return this.size;
    }
}
