
package maze.performance_testing;

import maze.domain.DeadEndFilling;
import maze.domain.DepthFirstSearch;
import maze.domain.KruskalMaze;
import maze.domain.RecursiveBacktracker;

/**
 * A class used for running and comparing different algorithms.
 * @author taleiko
 */
public class PerformanceComparator {
    private RecursiveBacktracker rec;
    private KruskalMaze k;
    private DeadEndFilling deadEnd;
    private DepthFirstSearch depth;
    private char[][] testMaze;
    private char[][] maze;
    private long start;
    private long recTime;
    private long kruskalTime;
    private long deadEndTime;
    private long depthTime;
    /**
     * Calls the performance test methods.
     */
    public void runAllTests() {
        recursiveBacktrackerTest();
        deadEndSolveTest();
        depthFirstSearchTest();
    }
    /**
     * Gathers data on long it takes for the recursive backtracker method to
     * generate a maze.
     */
    public void recursiveBacktrackerTest() {
        recTime = 0;
        rec = new RecursiveBacktracker(3000, 3000);
        rec.generateMaze();
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            rec.generateMaze();
            recTime += System.nanoTime() - start;
        }
        recTime /= 10;
    }
    /**
     * Gathers data on long it takes for the recursive kruskal class to generate
     * a maze.
     */
    public void kruskalTest() {
        kruskalTime = 0;
        k = new KruskalMaze(3000, 3000);
        k.generateMaze();
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            k.generateMaze();
            kruskalTime += System.nanoTime() - start;
        }
        kruskalTime /= 10;
    }
    /**
     * Gathers data on long it takes for the dead-end solve method to solve
     * a maze.
     */
    public void deadEndSolveTest() {
        deadEndTime = 0;
        rec = new RecursiveBacktracker(3000, 3000);
        rec.generateMaze();
        testMaze = generator.getRecursiveBacktrackerMaze();
        maze = new char[testMaze.length][testMaze[0].length];
        //Copying the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = testMaze[i][j];
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
    /**
     * Gathers data on long it takes for the depth-first search method to solve
     * a maze.
     */
    public void depthFirstSearchTest() {
        depth = new DepthFirstSearch();
        testMaze = generator.getRecursiveBacktrackerMaze();
        maze = new char[testMaze.length][testMaze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = testMaze[i][j];
            }
        }
        depthTime = System.nanoTime();
        depth.solve(maze);
        depthTime = System.nanoTime() - depthTime;
    }
    /**
     * Returns the recursive backtracker method's performance time.
     * @return recursiveTime
     */
    public long getRecTime() {
        return recTime;
    }
    /**
     * Returns the Kruskal generator's performance time.
     * @return kruskalTime
     */
    public long getKruskalTime() {
        return this.kruskalTime;
    }
    /**
     * Returns the dead-end filling method's performance time.
     * @return deadEndTime
     */
    public long getDeadEndTime() {
        return deadEndTime;
    }
    /**
     * Returns the depth-first search method's performance time.
     * @return depthFirstTime
     */
    public long getDepthTime() {
        return depthTime;
    }
}
