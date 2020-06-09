/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.domain;

/**
 *
 * @author taleiko
 */
public class DomainTesting {
    public static void main(String[] args) {
        KruskalMaze k = new KruskalMaze(4, 3);
        k.removeCorridor(3);
    }
}
