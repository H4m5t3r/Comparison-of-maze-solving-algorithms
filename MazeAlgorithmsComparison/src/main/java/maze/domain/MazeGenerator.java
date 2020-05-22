
package maze.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class generates a random maze.
 * @author taleiko
 */
public class MazeGenerator {
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
    private ArrayDeque<Integer> stackx;
    /**
     * The stack used for storing the y coordinate of the rooms it visits.
     */
    private ArrayDeque<Integer> stacky;
    /**
     * A temporary array which will be removed if I find a better way to
     * randomize the directions.
     */
    private Integer[] directions;
    /**
     * A list that is shuffled when the order of the directions is chosen.
     */
    private List<Integer> directionsList;
    /**
     * The array used for keeping track of what directions have been checked in
     * a specific spot in the maze.
     */
    private ArrayDeque<Integer> directionsStack;
    /**
     * A variable used for cases when the program needs to know many directions
     * there are. In this labyrinth it is assigned the value 4.
     */
    private int directionsToGo;

    /**
     * Creates a new base for a maze with the given width and length.
     * @param mazeWidth
     * @param mazeHeight
     */
    public MazeGenerator(final int mazeWidth, final int mazeHeight) {
        maze = new char[mazeWidth * 2 + 1][mazeHeight * 2 + 1];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                maze[y][x] = '#';
            }
        }
        directionsToGo = 4;
        visited = new boolean[mazeWidth][mazeHeight];
        stackx = new ArrayDeque<>();
        stacky = new ArrayDeque<>();
        //MAKE A BETTER VERSION
        directions = new Integer[directionsToGo];
        for (int i = 0; i < directions.length; i++) {
            directions[i] = i;
        }
        directionsList = Arrays.asList(directions);
        directionsStack = new ArrayDeque<>();
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
        visited[0][0] = true;
        removeWall(2 * 0 + 1, 2 * 0 + 1);
//        Collections.shuffle(directionsList);
        for (int i = 0; i < directionsToGo; i++) {
            directionsStack.push(directionsList.get(i));
        }
        //Recursion begins
        for (int i = 0; i < directionsToGo; i++) {
            if (directionsStack.peek() == 1) {
                stackx.push(1);
                stacky.push(0);
                try {
                    removeWall(1, 2);
                    recursion();
                } catch (Exception e) {
                    stackx.pop();
                    stacky.pop();
                }
            }
//            else if (directionsStack.peek() == 2) {
//                stackx.push(0);
//                stacky.push(1);
//                try {
//                    removeWall(2, 1);
//                    recursion();
//                } catch (Exception e) {
//                    stackx.pop();
//                    stacky.pop();
//                }
//            }
            directionsStack.pop();
        }
    }

    /**
     * The recursive method that is used to visit all "rooms" in the maze.
     */
    public void recursion() {
        visited[stacky.peek()][stackx.peek()] = true;
        removeWall(2 * stacky.peek() + 1, 2 * stackx.peek() + 1);
        //Debugging
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                System.out.print(maze[y][x]);
            }
            System.out.println("");
        }
        System.out.println("");
        //Going in all possible directions
//        Collections.shuffle(directionsList);
        for (int i = 0; i < directionsList.size(); i++) {
            directionsStack.push(directionsList.get(i));
        }
        for (int i = 0; i < directionsToGo; i++) {
            //REPLACE REPETETIVE CODE WITH ONE METHOD
            if (null != directionsStack.peek()) {
                switch (directionsStack.peek()) {
                    case 0:
                        try {
                            stackx.push(stackx.peek());
                            stacky.push(stacky.peek() - 1);
                            if (!visited[stacky.peek()][stackx.peek()]) {
                                System.out.println("Going UP");
                                removeWallBetweenRooms(0);
                                recursion();
                            }
                        } catch (Exception e) {
                            System.out.println("ErrorUP");
                            stackx.pop();
                            stacky.pop();
                        }
                        directionsStack.pop();
                        break;
                    case 1:
                        try {
                            stackx.push(stackx.peek() + 1);
                            stacky.push(stacky.peek());
                            if (!visited[stacky.peek()][stackx.peek()]) {
                                System.out.println("Going RIGHT");
                                removeWallBetweenRooms(1);
                                recursion();
                            }
                        } catch (Exception e) {
                            System.out.println("ErrorRIGHT");
                            stackx.pop();
                            stacky.pop();
                        }
                        directionsStack.pop();
                        break;
                    case 2:
                        try {
                            stackx.push(stackx.peek());
                            stacky.push(stacky.peek() + 1);
                            if (!visited[stacky.peek()][stackx.peek()]) {
                                System.out.println("Going DOWN");
                                removeWallBetweenRooms(2);
                                recursion();
                            }
                        } catch (Exception e) {
                            System.out.println("ErrorDOWN");
                            stackx.pop();
                            stacky.pop();
                        }
                        directionsStack.pop();
                        break;
                    case 3:
                        try {
                            stackx.push(stackx.peek() - 1);
                            stacky.push(stacky.peek());
                            if (!visited[stacky.peek()][stackx.peek()]) {
                                System.out.println("Going LEFT");
                                removeWallBetweenRooms(3);
                                recursion();
                            }
                        } catch (Exception e) {
                            System.out.println("ErrorLEFT");
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
