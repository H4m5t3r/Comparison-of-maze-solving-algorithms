/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import maze.domain.FisherYatesShuffle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class FisherYatesShuffleTest {
    private FisherYatesShuffle s;
    private int[] list;
    
    @Before
    public void setUp() {
        s = new FisherYatesShuffle();
    }

    @Test
    public void everyIntegerStillPresentAfterShuffle() {
        list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        s.shuffleIntegerArray(list);
        boolean integerFound = false;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[j] == i) {
                    integerFound = true;
                }
            }
            assertTrue(integerFound);
            integerFound = false;
        }
    }
}
