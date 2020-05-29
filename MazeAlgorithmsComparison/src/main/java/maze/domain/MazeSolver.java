
package maze.domain;

/**
 * A class that uses different maze solving algorithms to solve the mazes that
 * are generated in the MazeGenerator class.
 * @author taleiko
 */
public class MazeSolver {
    /**
     * The class that solves mazes using the dead-end filling method.
     */
    private final DeadEndFilling deadEndFill;
    /**
     * Initializes the maze solver.
     */
    public MazeSolver() {
        deadEndFill = new DeadEndFilling();
    }
    /**
     * Calls the solve method in the DeadEndFilling class.
     * @param maze 
     */
    public void deadEndFillSolve(char[][] maze) {
        deadEndFill.solve(maze);
    }
}
