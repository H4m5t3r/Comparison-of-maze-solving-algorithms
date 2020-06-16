
package tests;

import maze.domain.DeadEndFilling;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class DeadEndFillingTest {
    private DeadEndFilling solve;

    @Before
    public void setUp() {
        solve = new DeadEndFilling();
    }
    
    @Test
    public void isDeadEndTest() {
        char[][] test1 = {
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#'}
        };
        assertTrue(solve.isDeadEnd(test1, 1, 1) == false);
        assertTrue(solve.isDeadEnd(test1, 1, 3) == false);
        assertTrue(solve.isDeadEnd(test1, 3, 1) == false);
        assertTrue(solve.isDeadEnd(test1, 3, 3) == false);
        assertTrue(solve.isDeadEnd(test1, 1, 2) == false);
        assertTrue(solve.isDeadEnd(test1, 2, 1) == false);
        assertTrue(solve.isDeadEnd(test1, 2, 3) == false);
        assertTrue(solve.isDeadEnd(test1, 3, 2) == false);
        
        char[][] test2 = {
            {'#', ' ', '#', '#', ' ', '#'},
            {' ', ' ', '#', ' ', ' ', ' '},
            {'#', ' ', '#', '#', '#', '#'},
            {'#', '#', '#', '#', ' ', '#'},
            {' ', ' ', ' ', '#', ' ', ' '},
            {'#', ' ', '#', '#', ' ', '#'}
        };
        assertTrue(solve.isDeadEnd(test2, 1, 1) == false);
        assertTrue(solve.isDeadEnd(test2, 1, 4) == false);
        assertTrue(solve.isDeadEnd(test2, 4, 1) == false);
        assertTrue(solve.isDeadEnd(test2, 4, 4) == false);
        
        char[][] test3 = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };
        assertTrue(solve.isDeadEnd(test3, 3, 3) == false);
        assertTrue(solve.isDeadEnd(test3, 1, 3) == true);
        assertTrue(solve.isDeadEnd(test3, 3, 1) == true);
        assertTrue(solve.isDeadEnd(test3, 3, 5) == true);
        assertTrue(solve.isDeadEnd(test3, 7, 3) == true);
    }

    @Test
    public void deadEndSolveTest() {
        char[][] test = {
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
        };
        
        char[][] solution = {
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
        };
        
        solve.solve(test);
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                assertTrue(test[i][j] == solution[i][j]);
            }
        }
    }
}
