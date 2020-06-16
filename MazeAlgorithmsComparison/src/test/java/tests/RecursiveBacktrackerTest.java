
package tests;

import maze.domain.RecursiveBacktracker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class RecursiveBacktrackerTest {
    private RecursiveBacktracker recBacktracker;
    
    @Before
    public void setUp() {
        this.recBacktracker = new RecursiveBacktracker(10, 10);
    }
    
    @Test
    public void mazeBaseIsOnlyMadeOfWallsAfterInit() {
        for (int y = 0; y < recBacktracker.getMaze().length; y++) {
            for (int x = 0; x < recBacktracker.getMaze()[0].length; x++) {
                assertTrue(recBacktracker.getMaze()[y][x] == '#');
            }
        }
    }
    
    @Test
    public void removeWallWorks() {
        for (int y = 0; y < recBacktracker.getMaze().length; y++) {
            for (int x = 0; x < recBacktracker.getMaze()[0].length; x++) {
                assertTrue(recBacktracker.getMaze()[y][x] == '#');
                recBacktracker.removeWall(y, x);
                assertTrue(recBacktracker.getMaze()[y][x] == ' ');
            }
        }
    }
    
    @Test
    public void mazeGenerationTest() {
        recBacktracker.generateMaze();
        char[][] testMaze = recBacktracker.getMaze();
        //Checks that all rooms have been visited
        for (int i = 1; i < testMaze.length; i += 2) {
            for (int j = 1; j < testMaze[0].length; j += 2) {
                assertTrue(testMaze[i][j] == ' ');
            }
        }
    }
}
