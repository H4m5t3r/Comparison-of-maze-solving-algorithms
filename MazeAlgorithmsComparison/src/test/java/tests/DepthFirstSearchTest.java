
package tests;

import maze.domain.DepthFirstSearch;
import maze.domain.RecursiveBacktracker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class DepthFirstSearchTest {
    private DepthFirstSearch depth;
    private RecursiveBacktracker generator;
    
    @Before
    public void setUp() {
        depth = new DepthFirstSearch();
    }
    
    @Test
    public void entranceAndExitFoundTest() {
        char[][] test = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
        };
        depth.solve(test);
        assertTrue(test[0][9] == 'c');
        assertTrue(test[1][9] == ' ');
        assertTrue(test[3][5] == 'e');
    }
    
    @Test
    public void pathFindTest() {
        char[][] test = {
            {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
        };
        
        char[][] solution = {
            {'#', '#', '#', '#', '#', '#', '#', 'c', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', 'c', 'c', 'c', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', 'c', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', 'c', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', 'c', '#'},
            {'#', ' ', ' ', ' ', '#', 'c', 'c', 'c', 'c', 'c', '#'},
            {'#', '#', '#', '#', '#', 'c', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', 'c', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', 'c', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', 'c', 'c', 'c', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', 'c', '#', '#', '#', '#', '#', '#', '#'}
        };
        
        depth.solve(test);
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                assertTrue(test[i][j] == solution[i][j]);
            }
        }
    }
    
    @Test
    public void largerMazeTest() {
        generator = new RecursiveBacktracker(50, 50);
        generator.generateMaze();
        char[][] test =  generator.getMaze();
        depth.solve(test);
        boolean exitFound = false;
        for (int i = 0; i < test[0].length; i++) {
            if (test[test.length - 1][i] == 'c') {
                exitFound = true;
            }
        }
        assertTrue(exitFound);
    }
}
