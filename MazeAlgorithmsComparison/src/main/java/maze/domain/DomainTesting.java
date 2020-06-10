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
        KruskalMaze k = new KruskalMaze(19, 10);
        k.generateMaze();
        char[][] test = k.getMaze();
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println("");
        }
//        System.out.println(2 < 5 / 2);
    }
}
