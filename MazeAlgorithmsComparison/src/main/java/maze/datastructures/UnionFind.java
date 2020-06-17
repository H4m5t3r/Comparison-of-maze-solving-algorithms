
package maze.datastructures;

/**
 * A class that implements a union-find data structure.
 * @author taleiko
 */
public class UnionFind {
    /**
     * The number of nodes in the union-find structure.
     */
    private final int size;
    /**
     * The array that stores every node's parent node.
     */
    private final int[] id;
    /**
     * Stores the the size of the component that each node is in.
     */
    private final int[] componentSize;
    /**
     * A constructor that takes the predetermined size (number of nodes) as
     * input.
     * @param givenSize
     */
    public UnionFind(final int givenSize) {
        this.size = givenSize;
        id = new int[givenSize];
        componentSize = new int[givenSize];
        //Linking each component to itself
        for (int i = 0; i < givenSize; i++) {
            id[i] = i;
            componentSize[i] = 1;
        }
    }
    /**
     * Returns the root of the set that p is part of.
     * @param p
     * @return root
     */
    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        //Compression
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }
    /**
     * Returns true if a and b are in the same set.
     * @param a
     * @param b
     * @return areConnected
     */
    public boolean connected(final int a, final int b) {
        return find(a) == find(b);
    }
    /**
     * Unifies the sets that a and b are part of if they are not the same.
     * @param a
     * @param b
     */
    public void unify(final int a, final int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2) {
            return;
        }
        //Not in the same component
        if (componentSize[root1] < componentSize[root2]) {
            componentSize[root2] += componentSize[root1];
            id[root1] = root2;
        } else {
            componentSize[root1] += componentSize[root2];
            id[root2] = root1;
        }
    }
    /**
     * Returns the number of nodes in the structure.
     * @return numberOfNodes
     */
    public int size() {
        return size;
    }
}
