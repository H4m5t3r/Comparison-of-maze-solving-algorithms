/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.domain;

/**
 * Used by the UI to communicate with the program.
 * @author taleiko
 */
public class Logic {
    private MazeGenerator generator;
    private int mazeWidth;
    private int mazeHeight;
    
    public Logic() {
        this.mazeWidth = 1;
        this.mazeHeight = 1;
    }
    /**
     * Increases the generated maze's width.
     */
    public void increaseWidth() {
        if (mazeWidth < 20) {
            mazeWidth++;
        }
    }
    /**
     * Decreases the generated maze's width.
     */
    public void decreaseWidth() {
        if (mazeWidth > 1) {
            mazeWidth--;
        }
    }
    /**
     * Increases the generated maze's height.
     */
    public void increaseHeight() {
        if (mazeHeight < 20) {
            mazeHeight++;
        }
    }
    /**
     * Decreases the generated maze's height.
     */
    public void decreaseHeight() {
        if (mazeHeight > 1) {
            mazeHeight--;
        }
    }
    
    public int getWidth() {
        return this.mazeWidth;
    }
    public int getHeight() {
        return this.mazeHeight;
    }
    
    public void initializeGenerator() {
        generator = new MazeGenerator(mazeWidth, mazeHeight);
    }
    
    public char[][] getMazeFromGenerator() {
        return generator.getMaze();
    }
}
