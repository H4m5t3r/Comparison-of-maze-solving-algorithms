
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
    
    private long recDead1;
    private long recDead2;
    private long recDead3;
    private long recDead4;
    private long recDead5;
    private long krusDead1;
    private long krusDead2;
    private long krusDead3;
    private long krusDead4;
    private long krusDead5;
    
    private long recDepth1;
    private long recDepth2;
    private long recDepth3;
    private long recDepth4;
    private long recDepth5;
    private long krusDepth1;
    private long krusDepth2;
    private long krusDepth3;
    private long krusDepth4;
    private long krusDepth5;

    public PerformanceComparator() {
        this.mazeSize = 3000;
    }
    /**
     * Calls the performance test methods.
     */
    public void runAllTests() {
        recursiveBacktrackerTest();
        recBackSolvingTest();
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
        deadEnd = new DeadEndFilling();
        depth = new DepthFirstSearch();
        rec = new RecursiveBacktracker(mazeSize, mazeSize);
        rec.generateMaze();
        deadEnd.solve(rec.getMaze());
        depth.solve(rec.getMaze());
        
        //5 tests for both of the solvers
        //1
        rec.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(rec.getMaze());
        recDead1 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(rec.getMaze());
        recDepth1 = System.nanoTime() - start;
        
        //2
        rec.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(rec.getMaze());
        recDead2 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(rec.getMaze());
        recDepth2 = System.nanoTime() - start;
        
        //3
        rec.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(rec.getMaze());
        recDead3 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(rec.getMaze());
        recDepth3 = System.nanoTime() - start;
        
        //4
        rec.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(rec.getMaze());
        recDead4 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(rec.getMaze());
        recDepth4 = System.nanoTime() - start;
        
        //5
        rec.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(rec.getMaze());
        recDead5 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(rec.getMaze());
        recDepth5 = System.nanoTime() - start;
    }
    
    public void kruskalSolvingTest() {
        deadEnd = new DeadEndFilling();
        depth = new DepthFirstSearch();
        k = new KruskalMaze(mazeSize, mazeSize);
        k.generateMaze();
        deadEnd.solve(k.getMaze());
        depth.solve(k.getMaze());
        
        //5 tests for both of the solvers
        //1
        k.generateMaze();
        start = System.nanoTime();
        deadEnd.solve(k.getMaze());
        recDead1 = System.nanoTime() - start;
        start = System.nanoTime();
        depth.solve(k.getMaze());
        recDepth1 = System.nanoTime() - start;
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
    
    public long getRecDead1() {
        return recDead1;
    }
    
    public long getRecDead2() {
        return recDead2;
    }
    
    public long getRecDead3() {
        return recDead3;
    }
    
    public long getRecDead4() {
        return recDead4;
    }
    
    public long getRecDead5() {
        return recDead5;
    }
    
    public long getRecDepth1() {
        return recDepth1;
    }
    
    public long getRecDepth2() {
        return recDepth2;
    }
    
    public long getRecDepth3() {
        return recDepth3;
    }
    
    public long getRecDepth4() {
        return recDepth4;
    }
    
    public long getRecDepth5() {
        return recDepth5;
    }
    
}
