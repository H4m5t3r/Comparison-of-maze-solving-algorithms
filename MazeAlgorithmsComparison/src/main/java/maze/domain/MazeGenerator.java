
package maze.domain;

/**
 * This class generates a random maze.
 * @author taleiko
 */
public class MazeGenerator {
    /**
     * Uses a two-dimensional array to store the maze.
     */
    private final char[][] maze;

    /**
     * Creates a new base for a maze with the given width and length.
     * @param mazeWidth
     * @param mazeLength
     */
    public MazeGenerator(final int mazeWidth, final int mazeLength) {
        maze = new char[mazeWidth * 2 + 1][mazeLength * 2 + 1];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = '#';
            }
        }
    }
    /**
     * Used for carving out corridors in the maze.
     * @param x
     * @param y
     */
    public void removeWall(final int x, final int y) {
        maze[y][x] = ' ';
    }
    /**
     * Returns the current maze.
     * @return maze
     */
    public char[][] getMaze() {
        return maze;
    }
}
