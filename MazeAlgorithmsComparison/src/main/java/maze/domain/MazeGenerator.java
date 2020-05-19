
package maze.domain;

/**
 * This class generates a random maze.
 * @author taleiko
 */
public class MazeGenerator {
    /**
     * The maze.
     */
    private final Maze maze;

    /**
     * Creates a new maze generator with the given width and length.
     * @param mazeWidth
     * @param mazeLength
     */
    public MazeGenerator(final int mazeWidth, final int mazeLength) {
        maze = new Maze(mazeWidth, mazeLength);
    }
}
