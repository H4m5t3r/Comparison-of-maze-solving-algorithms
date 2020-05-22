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
    private final int maxWidth;
    private final int maxHeight;
    private final int minWidth;
    private final int minHeight;
    
    public Logic() {
        this.mazeWidth = 2;
        this.mazeHeight = 2;
        this.maxWidth = 20;
        this.maxHeight = 20;
        this.minWidth = 1;
        this.minHeight = 1;
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
    
    public void initializeGenerator() {
        generator = new MazeGenerator(mazeWidth, mazeHeight);
    }
    
    public void generateMaze() {
        generator.generateMaze();
    }
    
    //Get methods
    
    public char[][] getMazeFromGenerator() {
        return generator.getMaze();
    }
    
    public int getWidth() {
        return this.mazeWidth;
    }
    public int getHeight() {
        return this.mazeHeight;
    }
    
    public int getMaxWidth() {
        return this.maxWidth;
    }
    public int getMaxHeight() {
        return this.maxHeight;
    }
    
    public int getMinWidth() {
        return this.minWidth;
    }
    public int getMinHeight() {
        return this.minHeight;
    }
}
