
package tests;

import maze.domain.KruskalMaze;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class KruskalMazeTest {
    private KruskalMaze kruskal;
    
    @Before
    public void setUp() {
        kruskal = new KruskalMaze(4, 4);
    }
    
    @Test
    public void getRoomAboveTest() {
        //Height: 2
        assertTrue(kruskal.getRoomAbove(0, 2) == 0);
        assertTrue(kruskal.getRoomAbove(3, 2) == 2);
        assertTrue(kruskal.getRoomAbove(6, 2) == 4);
        assertTrue(kruskal.getRoomAbove(9, 2) == 6);
        //Height: 3
        assertTrue(kruskal.getRoomAbove(0, 3) == 0);
        assertTrue(kruskal.getRoomAbove(1, 3) == 1);
        assertTrue(kruskal.getRoomAbove(5, 3) == 3);
        assertTrue(kruskal.getRoomAbove(6, 3) == 4);
        assertTrue(kruskal.getRoomAbove(10, 3) == 6);
        assertTrue(kruskal.getRoomAbove(11, 3) == 7);
        assertTrue(kruskal.getRoomAbove(15, 3) == 9);
        assertTrue(kruskal.getRoomAbove(16, 3) == 10);
        assertTrue(kruskal.getRoomAbove(20, 3) == 12);
        assertTrue(kruskal.getRoomAbove(21, 3) == 13);
        //Height: 4
        assertTrue(kruskal.getRoomAbove(0, 4) == 0);
        assertTrue(kruskal.getRoomAbove(1, 4) == 1);
        assertTrue(kruskal.getRoomAbove(2, 4) == 2);
        assertTrue(kruskal.getRoomAbove(7, 4) == 4);
        assertTrue(kruskal.getRoomAbove(8, 4) == 5);
        assertTrue(kruskal.getRoomAbove(9, 4) == 6);
        assertTrue(kruskal.getRoomAbove(14, 4) == 8);
        assertTrue(kruskal.getRoomAbove(15, 4) == 9);
        assertTrue(kruskal.getRoomAbove(16, 4) == 10);
    }
    
    @Test
    public void getRoomBelowTest() {
        //Height: 2
        assertTrue(kruskal.getRoomBelow(0, 2) == 1);
        assertTrue(kruskal.getRoomBelow(3, 2) == 3);
        assertTrue(kruskal.getRoomBelow(6, 2) == 5);
        assertTrue(kruskal.getRoomBelow(9, 2) == 7);
        //Height: 3
        assertTrue(kruskal.getRoomBelow(0, 3) == 1);
        assertTrue(kruskal.getRoomBelow(1, 3) == 2);
        assertTrue(kruskal.getRoomBelow(5, 3) == 4);
        assertTrue(kruskal.getRoomBelow(6, 3) == 5);
        assertTrue(kruskal.getRoomBelow(10, 3) == 7);
        assertTrue(kruskal.getRoomBelow(11, 3) == 8);
        assertTrue(kruskal.getRoomBelow(15, 3) == 10);
        assertTrue(kruskal.getRoomBelow(16, 3) == 11);
        assertTrue(kruskal.getRoomBelow(20, 3) == 13);
        assertTrue(kruskal.getRoomBelow(21, 3) == 14);
        //Height: 4
        assertTrue(kruskal.getRoomBelow(0, 4) == 1);
        assertTrue(kruskal.getRoomBelow(1, 4) == 2);
        assertTrue(kruskal.getRoomBelow(2, 4) == 3);
        assertTrue(kruskal.getRoomBelow(7, 4) == 5);
        assertTrue(kruskal.getRoomBelow(8, 4) == 6);
        assertTrue(kruskal.getRoomBelow(9, 4) == 7);
        assertTrue(kruskal.getRoomBelow(14, 4) == 9);
        assertTrue(kruskal.getRoomBelow(15, 4) == 10);
        assertTrue(kruskal.getRoomBelow(16, 4) == 11);
    }
    
    @Test
    public void getRoomOnTheLeftTest() {
        //Height: 2
        assertTrue(kruskal.getRoomOnTheLeft(1, 2) == 0);
        assertTrue(kruskal.getRoomOnTheLeft(2, 2) == 1);
        assertTrue(kruskal.getRoomOnTheLeft(4, 2) == 2);
        assertTrue(kruskal.getRoomOnTheLeft(5, 2) == 3);
        assertTrue(kruskal.getRoomOnTheLeft(7, 2) == 4);
        assertTrue(kruskal.getRoomOnTheLeft(8, 2) == 5);
        //Height: 3
        assertTrue(kruskal.getRoomOnTheLeft(2, 3) == 0);
        assertTrue(kruskal.getRoomOnTheLeft(3, 3) == 1);
        assertTrue(kruskal.getRoomOnTheLeft(4, 3) == 2);
        assertTrue(kruskal.getRoomOnTheLeft(7, 3) == 3);
        assertTrue(kruskal.getRoomOnTheLeft(8, 3) == 4);
        assertTrue(kruskal.getRoomOnTheLeft(9, 3) == 5);
        assertTrue(kruskal.getRoomOnTheLeft(12, 3) == 6);
        assertTrue(kruskal.getRoomOnTheLeft(13, 3) == 7);
        assertTrue(kruskal.getRoomOnTheLeft(14, 3) == 8);
        assertTrue(kruskal.getRoomOnTheLeft(17, 3) == 9);
        assertTrue(kruskal.getRoomOnTheLeft(18, 3) == 10);
        assertTrue(kruskal.getRoomOnTheLeft(19, 3) == 11);
        //Height: 4
        assertTrue(kruskal.getRoomOnTheLeft(3, 4) == 0);
        assertTrue(kruskal.getRoomOnTheLeft(4, 4) == 1);
        assertTrue(kruskal.getRoomOnTheLeft(5, 4) == 2);
        assertTrue(kruskal.getRoomOnTheLeft(6, 4) == 3);
        assertTrue(kruskal.getRoomOnTheLeft(10, 4) == 4);
        assertTrue(kruskal.getRoomOnTheLeft(11, 4) == 5);
        assertTrue(kruskal.getRoomOnTheLeft(12, 4) == 6);
        assertTrue(kruskal.getRoomOnTheLeft(13, 4) == 7);
    }
    
    @Test
    public void getRoomOnTheRightTest() {
        //Height: 2
        assertTrue(kruskal.getRoomOnTheRight(1, 2) == 2);
        assertTrue(kruskal.getRoomOnTheRight(2, 2) == 3);
        assertTrue(kruskal.getRoomOnTheRight(4, 2) == 4);
        assertTrue(kruskal.getRoomOnTheRight(5, 2) == 5);
        assertTrue(kruskal.getRoomOnTheRight(7, 2) == 6);
        assertTrue(kruskal.getRoomOnTheRight(8, 2) == 7);
        //Height: 3
        assertTrue(kruskal.getRoomOnTheRight(2, 3) == 3);
        assertTrue(kruskal.getRoomOnTheRight(3, 3) == 4);
        assertTrue(kruskal.getRoomOnTheRight(4, 3) == 5);
        assertTrue(kruskal.getRoomOnTheRight(7, 3) == 6);
        assertTrue(kruskal.getRoomOnTheRight(8, 3) == 7);
        assertTrue(kruskal.getRoomOnTheRight(9, 3) == 8);
        assertTrue(kruskal.getRoomOnTheRight(12, 3) == 9);
        assertTrue(kruskal.getRoomOnTheRight(13, 3) == 10);
        assertTrue(kruskal.getRoomOnTheRight(14, 3) == 11);
        assertTrue(kruskal.getRoomOnTheRight(17, 3) == 12);
        assertTrue(kruskal.getRoomOnTheRight(18, 3) == 13);
        assertTrue(kruskal.getRoomOnTheRight(19, 3) == 14);
        //Height: 4
        assertTrue(kruskal.getRoomOnTheRight(3, 4) == 4);
        assertTrue(kruskal.getRoomOnTheRight(4, 4) == 5);
        assertTrue(kruskal.getRoomOnTheRight(5, 4) == 6);
        assertTrue(kruskal.getRoomOnTheRight(6, 4) == 7);
        assertTrue(kruskal.getRoomOnTheRight(10, 4) == 8);
        assertTrue(kruskal.getRoomOnTheRight(11, 4) == 9);
        assertTrue(kruskal.getRoomOnTheRight(12, 4) == 10);
        assertTrue(kruskal.getRoomOnTheRight(13, 4) == 11);
    }
}
