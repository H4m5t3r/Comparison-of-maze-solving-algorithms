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
        int h = 4;
        int b = 3;
        int k = 11;
        
        System.out.println(h*(k/(h*2-1)) + (k %(h*2-1) + 1));
        
        //Was turned the wrong way
        //h*(k/(h*2-1)) + (k % (h*2-1) + (h-2))
        
        //Finds the first one in the left in each column
        //h*(k/(h*2-1))
        
        
        //h*(k/(h*2-1))-(k/(h*2-1))
    }
}
