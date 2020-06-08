
package maze.data_structures;

/**
 * 
 * @author taleiko
 */
public class UnionFind {
    private final int size;
    private final int[] id;
    private final int[] componentSize;
    
    public UnionFind(int size) {
        this.size = size;
        id = new int[size];
        componentSize = new int[size];
        //Linking each component to itself
        for (int i = 0; i < size; i++) {
            id[i] = i;
            componentSize[i] = 1;
        }
    }
    
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
    
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
    
    public void unify(int a, int b) {
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
    
    public int size() {
        return size;
    }
}
