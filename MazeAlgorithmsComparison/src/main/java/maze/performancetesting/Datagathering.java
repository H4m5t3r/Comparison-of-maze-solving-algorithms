
package maze.performancetesting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import maze.domain.DeadEndFilling;
import maze.domain.DepthFirstSearch;
import maze.domain.KruskalMaze;
import maze.domain.RecursiveBacktracker;

/**
 * Creates text files containing test data. The tests are the same as in
 * PerformanceComparator, but here they are run 100 times each. The time unit is
 * nanoseconds. The tests took 5-10 minutes to complete.
 * @author taleiko
 */
public class Datagathering {
    public static void main(final String[] args) throws IOException {
        System.out.println("Hello");
        //Generation
        File recfile = new File("recb.txt");
        FileWriter fwrec = new FileWriter(recfile);
        PrintWriter pwrec = new PrintWriter(fwrec);
        
        File krusfile = new File("kruskal.txt");
        FileWriter fwkrus = new FileWriter(krusfile);
        PrintWriter pwkrus = new PrintWriter(fwkrus);
        
        //Solving recursive backtracker mazes
        File deadRecFile = new File("deadRec.txt");
        FileWriter fwDeadRec = new FileWriter(deadRecFile);
        PrintWriter pwDeadRec = new PrintWriter(fwDeadRec);
        
        File depthRecFile = new File("depthRec.txt");
        FileWriter fwDepthRec = new FileWriter(depthRecFile);
        PrintWriter pwDepthRec = new PrintWriter(fwDepthRec);
        
        //Solving Kruskal mazes
        File deadKruskalFile = new File("deadKruskal.txt");
        FileWriter fwDeadKruskal = new FileWriter(deadKruskalFile);
        PrintWriter pwDeadKruskal = new PrintWriter(fwDeadKruskal);
        
        File depthKruskalFile = new File("depthKruskal.txt");
        FileWriter fwDepthKruskal = new FileWriter(depthKruskalFile);
        PrintWriter pwDepthKruskal = new PrintWriter(fwDepthKruskal);
        
        long start;
        char[][] deadRecMaze = new char[3000 * 2 + 1][3000 * 2 + 1];
        char[][] depthRecMaze = new char[3000 * 2 + 1][3000 * 2 + 1];
        char[][] deadKruskalMaze = new char[3000 * 2 + 1][3000 * 2 + 1];
        char[][] depthKruskalMaze = new char[3000 * 2 + 1][3000 * 2 + 1];
        
        //Pre-compilation
        RecursiveBacktracker recb = new RecursiveBacktracker(3000, 3000);
        recb.generateMaze();
        KruskalMaze kruskal = new KruskalMaze(3000, 3000);
        kruskal.generateMaze();
        DeadEndFilling dead = new DeadEndFilling();
        DepthFirstSearch depth = new DepthFirstSearch();
        for (int i = 0; i < deadRecMaze.length; i++) {
            for (int j = 0; j < depthKruskalMaze[0].length; j++) {
                deadRecMaze[i][j] = recb.getMaze()[i][j];
                depthRecMaze[i][j] = recb.getMaze()[i][j];
                deadKruskalMaze[i][j] = kruskal.getMaze()[i][j];
                depthKruskalMaze[i][j] = kruskal.getMaze()[i][j];
            }
        }
        dead.solve(deadRecMaze);
        depth.solve(depthRecMaze);
        dead.solve(deadKruskalMaze);
        depth.solve(depthKruskalMaze);
        
        
        //Data gathering
        for (int percent = 0; percent < 10; percent++) {
            System.out.println(percent * 10 + "%");
            for (int i = 0; i < 10; i++) {
                
                start = System.nanoTime();
                recb = new RecursiveBacktracker(3000, 3000);
                recb.generateMaze();
                pwrec.println(System.nanoTime() - start);
                start = System.nanoTime();
                kruskal = new KruskalMaze(3000, 3000);
                kruskal.generateMaze();
                pwkrus.println(System.nanoTime() - start);

                //Copying the mazes
                for (int j = 0; j < depthKruskalMaze.length; j++) {
                    for (int k = 0; k < depthKruskalMaze[0].length; k++) {
                        deadRecMaze[j][k] = recb.getMaze()[j][k];
                        depthRecMaze[j][k] = recb.getMaze()[j][k];
                        deadKruskalMaze[j][k] = kruskal.getMaze()[j][k];
                        depthKruskalMaze[j][k] = kruskal.getMaze()[j][k];
                    }
                }

                start = System.nanoTime();
                dead.solve(deadRecMaze);
                pwDeadRec.println(System.nanoTime() - start);

                start = System.nanoTime();
                depth.solve(depthRecMaze);
                pwDepthRec.println(System.nanoTime() - start);

                start = System.nanoTime();
                dead.solve(deadKruskalMaze);
                pwDeadKruskal.println(System.nanoTime() - start);

                start = System.nanoTime();
                depth.solve(depthKruskalMaze);
                pwDepthKruskal.println(System.nanoTime() - start);
            }
        }
        
        pwrec.close();
        pwkrus.close();
        pwDeadRec.close();
        pwDepthRec.close();
        pwDeadKruskal.close();
        pwDepthKruskal.close();
        System.out.println("Done");
    }
}
