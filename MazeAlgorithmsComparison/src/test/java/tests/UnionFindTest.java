
package tests;

import maze.data_structures.UnionFind;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class UnionFindTest {
    private UnionFind union;
    
    @Test
    public void noElementsConntectedAtStart() {
        union = new UnionFind(6);
        for (int i = 0; i < union.size() - 1; i++) {
            assertTrue(!union.connected(i, i+1));
        }
        assertTrue(!union.connected(5, 0));
    }
    
    @Test
    public void unifyWorks() {
        union = new UnionFind(5);
        union.unify(0, 1);
        assertTrue(union.connected(0, 1));
        assertTrue(union.connected(1, 0));
        union.unify(2, 3);
        assertTrue(union.connected(2, 3));
        assertTrue(union.connected(3, 2));
        
        //Should not be connected
        assertTrue(!union.connected(0, 3));
        assertTrue(!union.connected(1, 3));
        assertTrue(!union.connected(3, 0));
        assertTrue(!union.connected(3, 1));
        
        assertTrue(!union.connected(0, 2));
        assertTrue(!union.connected(1, 2));
        assertTrue(!union.connected(2, 0));
        assertTrue(!union.connected(2, 1));
        
        assertTrue(!union.connected(4, 0));
        assertTrue(!union.connected(4, 1));
        assertTrue(!union.connected(4, 2));
        assertTrue(!union.connected(4, 3));
        assertTrue(!union.connected(0, 4));
        assertTrue(!union.connected(1, 4));
        assertTrue(!union.connected(2, 4));
        assertTrue(!union.connected(3, 4));
        
        union.unify(0, 3);
        
        
        //Does nothing if two components are already connected
        union.unify(0, 1);
        union.unify(0, 2);
        union.unify(0, 3);
        union.unify(1, 0);
        union.unify(1, 2);
        union.unify(1, 3);
        union.unify(2, 0);
        union.unify(2, 1);
        union.unify(2, 3);
        union.unify(3, 0);
        union.unify(3, 1);
        union.unify(3, 2);
        
        //Should now be connected
        assertTrue(union.connected(0, 3));
        assertTrue(union.connected(1, 3));
        assertTrue(union.connected(3, 0));
        assertTrue(union.connected(3, 1));
        
        assertTrue(union.connected(0, 2));
        assertTrue(union.connected(1, 2));
        assertTrue(union.connected(2, 0));
        assertTrue(union.connected(2, 1));
        //Should still not be connected
        assertTrue(!union.connected(4, 0));
        assertTrue(!union.connected(4, 1));
        assertTrue(!union.connected(4, 2));
        assertTrue(!union.connected(4, 3));
        assertTrue(!union.connected(0, 4));
        assertTrue(!union.connected(1, 4));
        assertTrue(!union.connected(2, 4));
        assertTrue(!union.connected(3, 4));
    }
    
    @Test
    public void findsCorrectRoot() {
        union = new UnionFind(5);
        //Every integer should be its own root
        for (int i = 0; i < union.size(); i++) {
            assertTrue(union.find(i) == i);
        }
        union.unify(0, 1);
        assertTrue(union.find(0) == 0);
        assertTrue(union.find(1) == 0);
        
        union.unify(2, 3);
        union.unify(3, 4);
        assertTrue(union.find(2) == 2);
        assertTrue(union.find(3) == 2);
        assertTrue(union.find(4) == 2);
        
        union.unify(1, 4);
        assertTrue(union.find(0) == 2);
        assertTrue(union.find(1) == 2);
        assertTrue(union.find(2) == 2);
        assertTrue(union.find(3) == 2);
        assertTrue(union.find(4) == 2);
    }
}
