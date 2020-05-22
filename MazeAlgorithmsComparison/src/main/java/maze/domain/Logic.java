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
    /**
     * The class that creates mazes.
     */
    private MazeGenerator generator;
    /**
     * The maze's width.
     */
    private int mazeWidth;
    /**
     * The maze's height.
     */
    private int mazeHeight;
    /**
     * The maze's maximum width.
     */
    private final int maxWidth;
    /**
     * The maze's maximum height.
     */
    private final int maxHeight;
    /**
     * The maze's minimum width.
     */
    private final int minWidth;
    /**
     * The maze's minimum height.
     */
    private final int minHeight;

    /**
     * A constructor where the default, maximum and minimum values can be adjusted.
     */
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
        if (mazeWidth < maxWidth) {
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
        if (mazeHeight < maxHeight) {
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

    /**
     * Initializes the maze generator.
     */
    public void initializeGenerator() {
        generator = new MazeGenerator(mazeWidth, mazeHeight);
    }

    /**
     * Tells the maze generator to generate a maze.
     */
    public void generateMaze() {
        generator.generateMaze();
    }

    //Get methods

    /**
     * Returns the two-dimensional character array that visualizes the maze.
     * @return char[][] maze
     */
    public char[][] getMazeFromGenerator() {
        return generator.getMaze();
    }

    /**
     * Returns the current width value.
     * @return mazeWidth
     */
    public int getWidth() {
        return this.mazeWidth;
    }
    /**
     * Returns the current height value.
     * @return mazeHeight
     */
    public int getHeight() {
        return this.mazeHeight;
    }
    /**
     * Returns the maximum width.
     * @return maxWidth
     */
    public int getMaxWidth() {
        return this.maxWidth;
    }
    /**
     * Returns the maximum height.
     * @return maxHeight
     */
    public int getMaxHeight() {
        return this.maxHeight;
    }
    /**
     * Returns the minimum width.
     * @return minWidth
     */
    public int getMinWidth() {
        return this.minWidth;
    }
    /**
     * Returns the minimum height.
     * @return minHeight
     */
    public int getMinHeight() {
        return this.minHeight;
    }
}
