/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.domain;

import maze.performance_testing.PerformanceComparator;

/**
 *
 * @author taleiko
 */
public class DomainTesting {
    public static void main(String[] args) {
//        KruskalMaze k = new KruskalMaze(3, 3);
//        k.generateKruskalMaze();
        FisherYatesShuffle s = new FisherYatesShuffle();
        int[] l = new int[10];
        for (int i = 0; i < l.length; i++) {
            l[i] = i + 1;
        }
        s.shuffleIntegerArray(l);
        for (int i = 0; i < l.length; i++) {
            System.out.print(l[i] + ", ");
        }
    }
}
