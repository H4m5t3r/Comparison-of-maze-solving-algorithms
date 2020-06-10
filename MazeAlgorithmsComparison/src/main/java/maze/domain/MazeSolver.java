
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
     * The class that solves mazes using depth-first search.
     */
    private final DepthFirstSearch depthFirst;

    /**
     * Initializes the maze solver.
     */
    public MazeSolver() {
        deadEndFill = new DeadEndFilling();
        depthFirst = new DepthFirstSearch();
    }
    /**
     * Calls the solve method in the DeadEndFilling class.
     * @param maze
     */
    public void deadEndFillSolve(final char[][] maze) {
        deadEndFill.solve(maze);
    }
    /**
     * Calls the solve method in the DeptFirstSearch class.
     * @param maze 
     */
    public void depthFirstSearch(final char[][] maze) {
        depthFirst.solve(maze);
    }
}
