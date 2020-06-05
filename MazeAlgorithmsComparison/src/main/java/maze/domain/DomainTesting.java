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
        PerformanceComparator per = new PerformanceComparator();
        per.recursiveBacktrackerTest();
        System.out.println(per.getRecTime() / 1000000 + " ms");
        
        per.deadEndSolveTest();
        System.out.println(per.getDeadEndTime() / 1000000 + " ms");
        
        per.depthFirstSearchTest();
        System.out.println(per.getDepthTime() / 1000000 + " ms");
    }
}
