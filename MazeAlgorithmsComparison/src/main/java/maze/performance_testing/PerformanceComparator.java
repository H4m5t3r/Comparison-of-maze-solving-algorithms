
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
    private final int mazeSize;
    
    private final long[] recDead;
    private final long[] krusDead;
    private final long[] recDepth;
    private final long[] krusDepth;

    public PerformanceComparator() {
        deadEnd = new DeadEndFilling();
        depth = new DepthFirstSearch();
        this.mazeSize = 2000;
        this.maze = new char[mazeSize * 2 + 1][mazeSize * 2 + 1];
        this.recDead = new long[5];
        this.krusDead = new long[5];
        this.recDepth = new long[5];
        this.krusDepth = new long[5];
    }
    /**
     * Calls the performance test methods.
     */
    public void runAllTests() {
        recursiveBacktrackerTest();
        kruskalTest();
        recBackSolvingTest();
        kruskalSolvingTest();
    }
    /**
     * Gathers data on long it takes for the recursive backtracker method to
     * generate a maze.
     */
    public void recursiveBacktrackerTest() {
        recTime = 0;
        rec = new RecursiveBacktracker(mazeSize, mazeSize);
        rec.generateMaze();
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            rec = new RecursiveBacktracker(mazeSize, mazeSize);
            rec.generateMaze();
            recTime += System.nanoTime() - start;
        }
        recTime /= 10;
    }
    /**
     * Gathers data on long it takes for the kruskal class to generate a maze.
     */
    public void kruskalTest() {
        kruskalTime = 0;
        k = new KruskalMaze(mazeSize, mazeSize);
        k.generateMaze();
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            k = new KruskalMaze(mazeSize, mazeSize);
            k.generateMaze();
            kruskalTime += System.nanoTime() - start;
        }
        kruskalTime /= 10;
    }
    /**
     * Gathers data on long it takes for the dead-end solve method to solve
     * a maze.
     */
    public void recBackSolvingTest() {
        //Pre-running the methods to avoid extra compilation time later on.
        rec = new RecursiveBacktracker(mazeSize, mazeSize);
        rec.generateMaze();
        //Copying the maze
        for (int y = 0; y < rec.getMaze().length; y++) {
            for (int x = 0; x < rec.getMaze()[0].length; x++) {
                maze[y][x] = rec.getMaze()[y][x];
            }
        }
        deadEnd.solve(maze);
        //Copying the maze again
        for (int y = 0; y < rec.getMaze().length; y++) {
            for (int x = 0; x < rec.getMaze()[0].length; x++) {
                maze[y][x] = rec.getMaze()[y][x];
            }
        }
        depth.solve(maze);
        
        //5 tests for both of the solvers
        for (int i = 0; i < 5; i++) {
            //Dead-end filling
            rec = new RecursiveBacktracker(mazeSize, mazeSize);
            rec.generateMaze();
            for (int y = 0; y < rec.getMaze().length; y++) {
                for (int x = 0; x < rec.getMaze()[0].length; x++) {
                    maze[y][x] = rec.getMaze()[y][x];
                }
            }
            start = System.nanoTime();
            deadEnd.solve(maze);
            recDead[i] = System.nanoTime() - start;
            //Depth-first search
            for (int y = 0; y < rec.getMaze().length; y++) {
                for (int x = 0; x < rec.getMaze()[0].length; x++) {
                    maze[y][x] = rec.getMaze()[y][x];
                }
            }
            start = System.nanoTime();
            depth.solve(maze);
            recDepth[i] = System.nanoTime() - start;
        }
    }
    
    public void kruskalSolvingTest() {
        //Pre-running the methods to avoid extra compilation time later on.
        k = new KruskalMaze(mazeSize, mazeSize);
        k.generateMaze();
        //Copying the maze
        for (int y = 0; y < k.getMaze().length; y++) {
            for (int x = 0; x < k.getMaze()[0].length; x++) {
                maze[y][x] = k.getMaze()[y][x];
            }
        }
        deadEnd.solve(maze);
        //Copying the maze again
        for (int y = 0; y < k.getMaze().length; y++) {
            for (int x = 0; x < k.getMaze()[0].length; x++) {
                maze[y][x] = k.getMaze()[y][x];
            }
        }
        depth.solve(maze);
        //5 tests for both of the solvers
        for (int i = 0; i < 5; i++) {
            //Dead-end filling
            k = new KruskalMaze(mazeSize, mazeSize);
            k.generateMaze();
            for (int y = 0; y < k.getMaze().length; y++) {
                for (int x = 0; x < k.getMaze()[0].length; x++) {
                    maze[y][x] = k.getMaze()[y][x];
                }
            }
            start = System.nanoTime();
            deadEnd.solve(maze);
            krusDead[i] = System.nanoTime() - start;
            //Depth-first search
            for (int y = 0; y < k.getMaze().length; y++) {
                for (int x = 0; x < k.getMaze()[0].length; x++) {
                    maze[y][x] = k.getMaze()[y][x];
                }
            }
            start = System.nanoTime();
            depth.solve(maze);
            krusDepth[i] = System.nanoTime() - start;
        }
    }
    
    //Get methods
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
    
    public long[] getRecDead() {
        return this.recDead;
    }
    
    public long[] getRecDepth() {
        return this.recDepth;
    }
    
    public long[] getKrusDead() {
        return this.krusDead;
    }
    
    public long[] getKrusDepth() {
        return this.krusDepth;
    }
}
