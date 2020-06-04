
package maze.domain;

/**
 *
 * @author taleiko
 */
public class MazeGenerator {
    private RecursiveBacktracker recursiveBacktracker;

    void initializeRecursiveBacktracker(int mazeWidth, int mazeHeight) {
        recursiveBacktracker = new RecursiveBacktracker(mazeWidth, mazeHeight);
    }

    void generateRecursiveBacktrackerMaze() {
        recursiveBacktracker.generateMaze();
    }

    public char[][] getRecursiveBacktrackerMaze() {
        return recursiveBacktracker.getMaze();
    }
}
