
package maze.domain;

import java.util.ArrayDeque;

/**
 * This class generates a random maze.
 * @author taleiko
 */
public class MazeGenerator {
    /**
     * Uses a two-dimensional array to store the maze.
     */
    private final char[][] maze;
    private boolean[][] visited;
    private final ArrayDeque<Cell> stack;
    private Cell current;

    /**
     * Creates a new base for a maze with the given width and length.
     * @param mazeWidth
     * @param mazeHeight
     */
    public MazeGenerator(final int mazeWidth, final int mazeHeight) {
        maze = new char[mazeWidth * 2 + 1][mazeHeight * 2 + 1];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = '#';
            }
        }
        visited = new boolean[mazeWidth][mazeHeight];
        stack = new ArrayDeque<>();
    }
    
    /**
     * Generates a maze using recursive backtracking.
     */
    public void generateMaze() {
        current = new Cell(0, 0);
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
//        removeWall();
        try {
            removeWall(-1, -1);
        } catch (Exception e) {
            
        }
    }
    /**
     * Used for carving out corridors in the maze.
     * @param x
     * @param y
     */
    public void removeWall(final int x, final int y) {
        maze[x][y] = ' ';
    }
    /**
     * Returns the current maze.
     * @return maze
     */
    public char[][] getMaze() {
        return maze;
    }
}
