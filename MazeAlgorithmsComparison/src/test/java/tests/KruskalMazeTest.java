
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
        assertTrue(kruskal.getLeftRoom(1, 2) == 0);
        assertTrue(kruskal.getLeftRoom(2, 2) == 1);
        assertTrue(kruskal.getLeftRoom(4, 2) == 2);
        assertTrue(kruskal.getLeftRoom(5, 2) == 3);
        assertTrue(kruskal.getLeftRoom(7, 2) == 4);
        assertTrue(kruskal.getLeftRoom(8, 2) == 5);
        //Height: 3
        assertTrue(kruskal.getLeftRoom(2, 3) == 0);
        assertTrue(kruskal.getLeftRoom(3, 3) == 1);
        assertTrue(kruskal.getLeftRoom(4, 3) == 2);
        assertTrue(kruskal.getLeftRoom(7, 3) == 3);
        assertTrue(kruskal.getLeftRoom(8, 3) == 4);
        assertTrue(kruskal.getLeftRoom(9, 3) == 5);
        assertTrue(kruskal.getLeftRoom(12, 3) == 6);
        assertTrue(kruskal.getLeftRoom(13, 3) == 7);
        assertTrue(kruskal.getLeftRoom(14, 3) == 8);
        assertTrue(kruskal.getLeftRoom(17, 3) == 9);
        assertTrue(kruskal.getLeftRoom(18, 3) == 10);
        assertTrue(kruskal.getLeftRoom(19, 3) == 11);
        //Height: 4
        assertTrue(kruskal.getLeftRoom(3, 4) == 0);
        assertTrue(kruskal.getLeftRoom(4, 4) == 1);
        assertTrue(kruskal.getLeftRoom(5, 4) == 2);
        assertTrue(kruskal.getLeftRoom(6, 4) == 3);
        assertTrue(kruskal.getLeftRoom(10, 4) == 4);
        assertTrue(kruskal.getLeftRoom(11, 4) == 5);
        assertTrue(kruskal.getLeftRoom(12, 4) == 6);
        assertTrue(kruskal.getLeftRoom(13, 4) == 7);
    }
    
    @Test
    public void getRoomOnTheRightTest() {
        //Height: 2
        assertTrue(kruskal.getRightRoom(1, 2) == 2);
        assertTrue(kruskal.getRightRoom(2, 2) == 3);
        assertTrue(kruskal.getRightRoom(4, 2) == 4);
        assertTrue(kruskal.getRightRoom(5, 2) == 5);
        assertTrue(kruskal.getRightRoom(7, 2) == 6);
        assertTrue(kruskal.getRightRoom(8, 2) == 7);
        //Height: 3
        assertTrue(kruskal.getRightRoom(2, 3) == 3);
        assertTrue(kruskal.getRightRoom(3, 3) == 4);
        assertTrue(kruskal.getRightRoom(4, 3) == 5);
        assertTrue(kruskal.getRightRoom(7, 3) == 6);
        assertTrue(kruskal.getRightRoom(8, 3) == 7);
        assertTrue(kruskal.getRightRoom(9, 3) == 8);
        assertTrue(kruskal.getRightRoom(12, 3) == 9);
        assertTrue(kruskal.getRightRoom(13, 3) == 10);
        assertTrue(kruskal.getRightRoom(14, 3) == 11);
        assertTrue(kruskal.getRightRoom(17, 3) == 12);
        assertTrue(kruskal.getRightRoom(18, 3) == 13);
        assertTrue(kruskal.getRightRoom(19, 3) == 14);
        //Height: 4
        assertTrue(kruskal.getRightRoom(3, 4) == 4);
        assertTrue(kruskal.getRightRoom(4, 4) == 5);
        assertTrue(kruskal.getRightRoom(5, 4) == 6);
        assertTrue(kruskal.getRightRoom(6, 4) == 7);
        assertTrue(kruskal.getRightRoom(10, 4) == 8);
        assertTrue(kruskal.getRightRoom(11, 4) == 9);
        assertTrue(kruskal.getRightRoom(12, 4) == 10);
        assertTrue(kruskal.getRightRoom(13, 4) == 11);
    }
}
