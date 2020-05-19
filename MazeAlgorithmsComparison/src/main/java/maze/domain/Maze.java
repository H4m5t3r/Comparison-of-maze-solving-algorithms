
package maze.domain;

/**
 * The class used for creating the maze.
 * @author taleiko
 */
public class Maze {
    /**
     * Uses a two-dimensional array to store the maze.
     */
    private final char[][] maze;

    /**
     * Creates a base for the maze where there are only walls.
     * @param x
     * @param y
     */
    public Maze(final int x, final int y) {
        this.maze = new char[y][x];
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
