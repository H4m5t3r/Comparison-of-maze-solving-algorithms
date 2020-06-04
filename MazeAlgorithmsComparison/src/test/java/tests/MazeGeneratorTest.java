/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import maze.domain.RecursiveBacktracker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class MazeGeneratorTest {
    private RecursiveBacktracker generator;
    
    @Before
    public void setUp() {
        this.generator = new RecursiveBacktracker(10, 10);
    }
    
    @Test
    public void mazeBaseIsOnlyMadeOfWallsAfterInit() {
        for (int y = 0; y < generator.getMaze().length; y++) {
            for (int x = 0; x < generator.getMaze()[0].length; x++) {
                assertTrue(generator.getMaze()[y][x] == '#');
            }
        }
    }
    
    @Test
    public void removeWallWorks() {
        for (int y = 0; y < generator.getMaze().length; y++) {
            for (int x = 0; x < generator.getMaze()[0].length; x++) {
                assertTrue(generator.getMaze()[y][x] == '#');
                generator.removeWall(y, x);
                assertTrue(generator.getMaze()[y][x] == ' ');
            }
        }
    }
    
    @Test
    public void mazeGenerationTest() {
        generator.generateMaze();
        char[][] testMaze = generator.getMaze();
        //Checks that all rooms have been visited
        for (int i = 1; i < testMaze.length; i += 2) {
            for (int j = 1; j < testMaze[0].length; j += 2) {
                assertTrue(testMaze[i][j] == ' ');
            }
        }
    }
}
