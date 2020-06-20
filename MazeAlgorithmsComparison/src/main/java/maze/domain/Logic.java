
package maze.domain;

import maze.performance_testing.PerformanceComparator;

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
     * Used for running performance tests.
     */
    private PerformanceComparator performance;
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
        minWidth = 2;
        minHeight = 2;
        generator = new MazeGenerator();
        solver = new MazeSolver();
        performance = new PerformanceComparator();
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
        if (mazeWidth > minWidth) {
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
     * Increases the generated maze's height by one.
     */
    public void increaseHeight() {
        if (mazeHeight < maxSize) {
            mazeHeight++;
        }
    }
    /**
     * Decreases the generated maze's height by one.
     */
    public void decreaseHeight() {
        if (mazeHeight > minHeight) {
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
     * Initializes the recursive backtracker maze generator.
     */
    public void initializeRecursiveBacktracker() {
        generator.initializeRecursiveBacktracker(mazeWidth, mazeHeight);
    }
    /**
     * Tells the maze generator to generate a maze using the recursive
     * backtracker method.
     */
    public void generateRecursiveBacktrackerMaze() {
        generator.generateRecursiveBacktrackerMaze();
    }

    /**
     * Initializes the Kruskal maze generator.
     */
    public void initializeKruskal() {
        generator.initializeKruskal(mazeWidth, mazeHeight);
    }
    /**
     * Tells the maze generator to generate a maze using the Kruskal method.
     */
    public void generateKruskalMaze() {
        generator.generateKruskalMaze();
    }
    /**
     * Solves the given maze using the dead-end solve method.
     * @param maze
     */
    public void deadEndSolve(final char[][] maze) {
        solver.deadEndFillSolve(maze);
    }
    /**
     * Solves the given maze using depth-first search.
     * @param maze
     */
    public void depthFirstSolve(final char[][] maze) {
        solver.depthFirstSearch(maze);
    }
    /**
     * Tells the performance comparison class to run the performance tests.
     */
    public void performanceTest() {
        performance.runAllTests();
    }

    //Get methods

    /**
     * Returns the two-dimensional character array that visualizes the maze.
     * @return char[][] maze
     */
    public char[][] getMazeFromRecursiveBacktracker() {
        return generator.getRecursiveBacktrackerMaze();
    }
    /**
     * Returns the two-dimensional character array that visualizes the maze.
     * @return char[][] maze
     */
    public char[][] getMazeFromKruskal() {
        return generator.getKruskalMaze();
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
    /**
     * Returns the recursive backtracker method's performance time.
     * @return recursiveBacktrackerPerformanceTime
     */
    public long getRecTime() {
        return performance.getRecTime();
    }
    /**
     * Returns the Kruskal generator's performance time.
     * @return kruskalPerformanceTime
     */
    public long getKruskalTime() {
        return performance.getKruskalTime();
    }
    /**
     * Returns an array with the dead-end filling method's performance results
     * when solving mazes generated by the recursive backtracker.
     * @return performanceTestResults
     */
    public long[] getRecDead() {
        return performance.getRecDead();
    }
    /**
     * Returns an array with the depth-first search method's performance results
     * when solving mazes generated by the recursive backtracker.
     * @return performanceTestResults
     */
    public long[] getRecDepth() {
        return performance.getRecDepth();
    }
    /**
     * Returns an array with the dead-end filling method's performance results
     * when solving mazes generated by the Kruskal generator.
     * @return performanceTestResults
     */
    public long[] getKrusDead() {
        return performance.getKrusDead();
    }
    /**
     * Returns an array with the depth-first search method's performance results
     * when solving mazes generated by the Kruskal generator.
     * @return performanceTestResults
     */
    public long[] getKrusDepth() {
        return performance.getKrusDepth();
    }
}
