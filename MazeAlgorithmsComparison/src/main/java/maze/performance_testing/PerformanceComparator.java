
package maze.performance_testing;

import maze.domain.DeadEndFilling;
import maze.domain.DepthFirstSearch;
import maze.domain.MazeGenerator;

/**
 * A class used for running and comparing different algorithms.
 * @author taleiko
 */
public class PerformanceComparator {
    private MazeGenerator generator;
    private DeadEndFilling deadEnd;
    private DepthFirstSearch depth;
    private char[][] temp;
    private char[][] maze;
    private long start;
    private long recTime;
    private long deadEndTime;
    private long depthTime;

    public void recursiveBacktrackerTest() {
        recTime = 0;
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            generator = new MazeGenerator();
            generator.initializeRecursiveBacktracker(1000, 1000);
            generator.generateRecursiveBacktrackerMaze();
            recTime += System.nanoTime() - start;
        }
        recTime /= 10;
    }
    
    public void deadEndSolveTest() {
        deadEndTime = 0;
        temp = generator.getRecursiveBacktrackerMaze();
        maze = new char[temp.length][temp[0].length];
        //Copying the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = temp[i][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            deadEnd = new DeadEndFilling();
            deadEnd.solve(maze);
            deadEndTime += System.nanoTime() - start;
        }
        deadEndTime /= 10;
    }
    
    public void depthFirstSearchTest() {
        depth = new DepthFirstSearch();
        temp = generator.getRecursiveBacktrackerMaze();
        maze = new char[temp.length][temp[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = temp[i][j];
            }
        }
        depthTime = System.nanoTime();
        depth.solve(maze);
        depthTime = System.nanoTime() - depthTime;
    }
    
    public long getRecTime() {
        return recTime;
    }
    
    public long getDeadEndTime() {
        return deadEndTime;
    }
    
    public long getDepthTime() {
        return depthTime;
    }
}
