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
    private int mazeLength;
    
    public Logic() {
        this.mazeWidth = 3;
        this.mazeLength = 1;
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
        if (mazeWidth > 3) {
            mazeWidth--;
        }
    }
    /**
     * Increases the generated maze's length.
     */
    public void increaseLength() {
        if (mazeLength < 20) {
            mazeLength++;
        }
    }
    /**
     * Decreases the generated maze's length.
     */
    public void decreaseLength() {
        if (mazeLength > 1) {
            mazeLength--;
        }
    }
    
    public int getWidth() {
        return this.mazeWidth;
    }
    public int getLength() {
        return this.mazeLength;
    }
    
    public void initializeGenerator() {
        generator = new MazeGenerator(mazeWidth, mazeLength);
    }
}
