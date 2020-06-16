
package maze.domain;

import maze.data_structures.LinkedList;
import maze.data_structures.Stack;

/**
 * This class generates a random maze.
 * @author taleiko
 */
public class RecursiveBacktracker {
    /**
     * Uses a two-dimensional array to store the maze.
     */
    private final char[][] maze;
    /**
     * The two-dimensional boolean array which is used to determine whether or
     * not the algorithm has already visited a "room" in the labyrinth.
     */
    private boolean[][] visited;
    /**
     * The stack used for storing the x coordinate of the rooms it visits.
     */
    private Stack stackx;
    /**
     * The stack used for storing the y coordinate of the rooms it visits.
     */
    private Stack stacky;
    /**
     * A list that is shuffled when the order of the directions is chosen.
     */
    private LinkedList directionsList;
    /**
     * The array used for keeping track of what directions have been checked in
     * a specific spot in the maze.
     */
    private Stack directionsStack;
    /**
     * A variable used for cases when the program needs to know many directions
     * there are. In this labyrinth it is assigned the value 4.
     */
    private final int directionsToGo;

    /**
     * Creates a new base for a maze with the given width and length.
     * @param mazeWidth
     * @param mazeHeight
     */
    public RecursiveBacktracker(final int mazeWidth, final int mazeHeight) {
        maze = new char[mazeWidth * 2 + 1][mazeHeight * 2 + 1];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = '#';
            }
        }
        directionsToGo = 4;
        visited = new boolean[mazeWidth][mazeHeight];
        stackx = new Stack(mazeWidth * mazeHeight);
        stacky = new Stack(mazeWidth * mazeHeight);
        directionsList = new LinkedList();
        directionsStack = new Stack(mazeWidth * mazeHeight * directionsToGo);
    }

    /**
     * Generates a maze using recursive backtracking.
     */
    public void generateMaze() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < directionsToGo; i++) {
            directionsList.add(i);
        }
        addRandomDirectionOrderToDirectionsStack();
        visited[0][0] = true;
        removeWall(2 * 0 + 1, 2 * 0 + 1);
        for (int i = 0; i < directionsToGo; i++) {
            directionsStack.push(directionsList.get(i));
        }
        //Recursion begins
        //Starts from the upper left corner, can only go right or down
        for (int i = 0; i < directionsToGo; i++) {
            if (directionsStack.peek() == 1) {
                stackx.push(1);
                stacky.push(0);
                try {
                    if (!visited[0][1]) {
                        recursion();
                        removeWall(1, 2);
                    }
                } catch (Exception e) {
                    stackx.pop();
                    stacky.pop();
                }
            } else if (directionsStack.peek() == 2) {
                stackx.push(0);
                stacky.push(1);
                try {
                    if (!visited[1][0]) {
                        recursion();
                        removeWall(2, 1);
                    }
                } catch (Exception e) {
                    stackx.pop();
                    stacky.pop();
                }
            }
            directionsStack.pop();
        }

        //Adding the entrance and exit
        //Entrance
        long out = (System.nanoTime() % visited.length) * 2 + 1;
        int outint = 1;
        while (outint < out) {
            outint += 2;
        }
        maze[0][outint] = ' ';
        //Exit
        out = (System.nanoTime() % visited.length) * 2 + 1;
        outint = 1;
        while (outint < out) {
            outint += 2;
        }
        maze[maze.length - 1][outint] = ' ';
    }

    /**
     * The recursive method that is used to visit all "rooms" in the maze.
     */
    public void recursion() {
        visited[stacky.peek()][stackx.peek()] = true;
        removeWall(2 * stacky.peek() + 1, 2 * stackx.peek() + 1);
        //Going in all possible directions
        addRandomDirectionOrderToDirectionsStack();
        for (int i = 0; i < directionsToGo; i++) {
            //REPLACE REPETETIVE CODE WITH ONE METHOD?
            switch (directionsStack.peek()) {
                case 0:
                    try {
                        stackx.push(stackx.peek());
                        stacky.push(stacky.peek() - 1);
                        if (!visited[stacky.peek()][stackx.peek()]) {
                            removeWallBetweenRooms(directionsStack.peek());
                            recursion();
                        }
                    } catch (Exception e) {
                        
                    }
                    directionsStack.pop();
                    stackx.pop();
                    stacky.pop();
                    break;
                case 1:
                    try {
                        stackx.push(stackx.peek() + 1);
                        stacky.push(stacky.peek());
                        if (!visited[stacky.peek()][stackx.peek()]) {
                            removeWallBetweenRooms(directionsStack.peek());
                            recursion();
                        }
                    } catch (Exception e) {
                        
                    }
                    directionsStack.pop();
                    stackx.pop();
                    stacky.pop();
                    break;
                case 2:
                    try {
                        stackx.push(stackx.peek());
                        stacky.push(stacky.peek() + 1);
                        if (!visited[stacky.peek()][stackx.peek()]) {
                            removeWallBetweenRooms(directionsStack.peek());
                            recursion();
                        }
                    } catch (Exception e) {
                        
                    }
                    directionsStack.pop();
                    stackx.pop();
                    stacky.pop();
                    break;
                case 3:
                    try {
                        stackx.push(stackx.peek() - 1);
                        stacky.push(stacky.peek());
                        if (!visited[stacky.peek()][stackx.peek()]) {
                            removeWallBetweenRooms(directionsStack.peek());
                            recursion();
                        }
                    } catch (Exception e) {
                        
                    }
                    directionsStack.pop();
                    stackx.pop();
                    stacky.pop();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Adds the four directions to directionsStack in a random order using the
     * linked list.
     */
    public void addRandomDirectionOrderToDirectionsStack() {
        for (int i = 0; i < directionsToGo; i++) {
            directionsList.add(i);
        }
        directionsStack.push(directionsList.remove(System.nanoTime() % 4));
        directionsStack.push(directionsList.remove(System.nanoTime() % 3));
        directionsStack.push(directionsList.remove(System.nanoTime() % 2));
        directionsStack.push(directionsList.remove(0));
    }
    /**
     * Used for carving out corridors in the maze.
     * @param y
     * @param x
     */
    public void removeWall(final int y, final int x) {
        maze[y][x] = ' ';
    }
    /**
     * Checks what direction the algorithm came from and carves a path between
     * the rooms.
     * @param direction
     */
    public void removeWallBetweenRooms(final int direction) {
        switch (direction) {
            case 0:
                removeWall(2 * stacky.peek() + 2, 2 * stackx.peek() + 1);
                break;
            case 1:
                removeWall(2 * stacky.peek() + 1, 2 * stackx.peek());
                break;
            case 2:
                removeWall(2 * stacky.peek(), 2 * stackx.peek() + 1);
                break;
            default:
                removeWall(2 * stacky.peek() + 1, 2 * stackx.peek() + 2);
                break;
        }
    }
    /**
     * Returns the current maze.
     * @return maze
     */
    public char[][] getMaze() {
        return maze;
    }
}
