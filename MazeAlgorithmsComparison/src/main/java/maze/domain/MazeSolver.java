
package maze.domain;

/**
 * A class that uses different maze solving algorithms to solve the mazes that
 * are generated in the MazeGenerator class.
 * @author taleiko
 */
public class MazeSolver {
    private char[][] solvedMaze;
    private DeadEndFilling deadEndFill;
    
    public MazeSolver() {
        deadEndFill = new DeadEndFilling();
    }
    
    public void deadEndFillSolve(char[][] maze) {
        deadEndFill.solve(maze);
    }
}
