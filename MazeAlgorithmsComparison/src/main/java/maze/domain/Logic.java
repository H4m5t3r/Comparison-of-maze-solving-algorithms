
package maze.domain;

/**
 * Used by the UI to communicate with the program.
 * @author taleiko
 */
public class Logic {
    /**
     * The class that creates mazes.
     */
    private MazeGenerator generator;
    /**
     * The class that takes mazes as input and solves them.
     */
    private MazeSolver solver;
    /**
     * The maze's width.
     */
    private int mazeWidth;
    /**
     * The maze's height.
     */
    private int mazeHeight;
    /**
     * The maze's maximum width.
     */
    private final int maxSize;
    /**
     * The maze's minimum width.
     */
    private final int minWidth;
    /**
     * The maze's minimum height.
     */
    private final int minHeight;
    /**
     * The default value for the width and height of the maze.
     */
    private final int defaultValue;

    /**
     * A constructor where the default, maximum and minimum values can be
     * adjusted.
     */
    public Logic() {
        defaultValue = 100;
        mazeWidth = defaultValue;
        mazeHeight = defaultValue;
        maxSize = 150;
        minWidth = 1;
        minHeight = 1;
        solver = new MazeSolver();
    }
    /**
     * Increases the generated maze's width.
     */
    public void increaseWidth() {
        if (mazeWidth < maxSize) {
            mazeWidth++;
        }
    }
    /**
     * Decreases the generated maze's width.
     */
    public void decreaseWidth() {
        if (mazeWidth > 1) {
            mazeWidth--;
        }
    }

    /**
     * Sets the width.
     * @param w
     */
    public void setWidth(final int w) {
        if (w <= maxSize) {
            if (w > 0) {
                mazeWidth = w;
            } else {
                mazeWidth = 1;
            }
        } else {
            mazeWidth = maxSize;
        }
    }
    /**
     * Increases the generated maze's height.
     */
    public void increaseHeight() {
        if (mazeHeight < maxSize) {
            mazeHeight++;
        }
    }
    /**
     * Decreases the generated maze's height.
     */
    public void decreaseHeight() {
        if (mazeHeight > 1) {
            mazeHeight--;
        }
    }
    /**
     * Sets the height.
     * @param h
     */
    public void setHeight(final int h) {
        if (h <= maxSize) {
            if (h > 0) {
                mazeHeight = h;
            } else {
                mazeHeight = 1;
            }
        } else {
            mazeHeight = maxSize;
        }
    }

    /**
     * Initializes the maze generator.
     */
    public void initializeGenerator() {
        generator = new MazeGenerator(mazeWidth, mazeHeight);
    }

    /**
     * Tells the maze generator to generate a maze.
     */
    public void generateMaze() {
        generator.generateMaze();
    }
    /**
     * Solves the given maze using the dead-end solve method.
     * @param maze
     */
    public void deadEndSolve(final char[][] maze) {
        solver.deadEndFillSolve(maze);
        //Debugging
//        for (int y = 0; y < maze.length; y++) {
//            for (int x = 0; x < maze[0].length; x++) {
//                System.out.print(maze[y][x]);
//            }
//            System.out.println("");
//        }
//        System.out.println("");
    }
    
    public void depthFirstSolve(final char[][] maze) {
        solver.depthFirstSearch(maze);
    }

    //Get methods

    /**
     * Returns the two-dimensional character array that visualizes the maze.
     * @return char[][] maze
     */
    public char[][] getMazeFromGenerator() {
        return generator.getMaze();
    }

    /**
     * Returns the current width value.
     * @return mazeWidth
     */
    public int getWidth() {
        return this.mazeWidth;
    }
    /**
     * Returns the current height value.
     * @return mazeHeight
     */
    public int getHeight() {
        return this.mazeHeight;
    }
    /**
     * Returns the maximum width.
     * @return maxWidth
     */
    public int getMaxWidth() {
        return this.maxSize;
    }
    /**
     * Returns the maximum height.
     * @return maxSize
     */
    public int getMaxHeight() {
        return this.maxSize;
    }
    /**
     * Returns the minimum width.
     * @return minWidth
     */
    public int getMinWidth() {
        return this.minWidth;
    }
    /**
     * Returns the minimum height.
     * @return minHeight
     */
    public int getMinHeight() {
        return this.minHeight;
    }
}
