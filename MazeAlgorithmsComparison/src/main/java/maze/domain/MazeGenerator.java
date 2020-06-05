
package maze.domain;

/**
 *
 * @author taleiko
 */
public class MazeGenerator {
    private RecursiveBacktracker recursiveBacktracker;

    public void initializeRecursiveBacktracker(int mazeWidth, int mazeHeight) {
        recursiveBacktracker = new RecursiveBacktracker(mazeWidth, mazeHeight);
    }

    public void generateRecursiveBacktrackerMaze() {
        recursiveBacktracker.generateMaze();
    }

    public char[][] getRecursiveBacktrackerMaze() {
        return recursiveBacktracker.getMaze();
    }
}
