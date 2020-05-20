/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import maze.domain.MazeGenerator;
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
public class MazeTest {
    private MazeGenerator maze;
    
    @Before
    public void setUp() {
        this.maze = new MazeGenerator(10, 10);
    }
    
    @Test
    public void mazeBaseIsOnlyMadeOfWalls() {
        for (int y = 0; y < maze.getMaze().length; y++) {
            for (int x = 0; x < maze.getMaze()[0].length; x++) {
                assertTrue(maze.getMaze()[y][x] == '#');
            }
        }
    }
    
    @Test
    public void removeWallWorks() {
        for (int y = 0; y < maze.getMaze().length; y++) {
            for (int x = 0; x < maze.getMaze()[0].length; x++) {
                assertTrue(maze.getMaze()[y][x] == '#');
                maze.removeWall(x, y);
                assertTrue(maze.getMaze()[y][x] == ' ');
            }
        }
    }
}
