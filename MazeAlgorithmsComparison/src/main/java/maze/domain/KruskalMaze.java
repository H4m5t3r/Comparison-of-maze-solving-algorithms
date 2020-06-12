
package maze.domain;

import maze.data_structures.UnionFind;

/**
 * A class that generates mazes by creating a minimum spanning tree.
 * @author taleiko
 */
public class KruskalMaze {
    private final char[][] maze;
    private final int[] corridors;
    private final FisherYatesShuffle shuffle;
    private final UnionFind u;
    /**
     * A constructor that takes the maze's width and height as input.
     * @param mazeWidth
     * @param mazeHeight
     */
    public KruskalMaze(int mazeWidth, int mazeHeight) {
        maze = new char[mazeHeight * 2 + 1][mazeWidth * 2 + 1];
        corridors = new int[(mazeHeight - 1) * mazeWidth + (mazeWidth - 1) *
                mazeHeight];
        shuffle = new FisherYatesShuffle();
        u = new UnionFind(mazeWidth * mazeHeight);
    }
    /**
     * Generates a maze by creating a minimum spanning tree.
     */
    public void generateMaze() {
        //Generating the base for the maze with rooms but no corridors between
        //them.
        for (int i = 0; i < maze.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < maze[0].length; j++) {
                    maze[i][j] = '#';
                }
            } else {
                for (int j = 0; j < maze[0].length; j++) {
                    if (j % 2 == 0) {
                        maze[i][j] = '#';
                    } else {
                        maze[i][j] = ' ';
                    }
                }
            }
        }

        //The random generation begins
        //Creating an array with all potential corridors and shuffling it
        for (int i = 0; i < corridors.length; i++) {
            corridors[i] = i;
        }
        shuffle.shuffleIntegerArray(corridors);
        
        //for each potential corridor
        for (int i = 0; i < corridors.length; i++) {
            if (corridors[i] % (maze.length - 2) < (maze.length - 2) / 2) {
                //Vertical corridor, checks if the room above and below are
                //connected. If not, it connects them.
                if (!u.connected(
                        getRoomAbove(corridors[i], (maze.length - 1) / 2),
                        getRoomBelow(corridors[i], (maze.length - 1) / 2))) {
                    u.unify(getRoomAbove(corridors[i], (maze.length - 1) / 2),
                            getRoomBelow(corridors[i], (maze.length - 1) / 2));
                    removeCorridor(corridors[i]);
                }
            } else {
                //Horizontal corridor, checks if the room to the left and to the
                //right are connected. If not, it connects them.
                if (!u.connected(
                        getLeftRoom(corridors[i], (maze.length - 1) / 2),
                        getRightRoom(corridors[i], (maze.length - 1) / 2))) {
                    u.unify(getLeftRoom(corridors[i], (maze.length - 1) / 2),
                            getRightRoom(corridors[i], (maze.length - 1) / 2));
                    removeCorridor(corridors[i]);
                }
            }
        }
        //Adding the entrance and exit
        //Entrance
        Long out = (System.nanoTime() % ((maze[0].length - 1) / 2));
        int outint = out.intValue();
        maze[0][outint * 2 + 1] = ' ';
        //Exit
        out = (System.nanoTime() % ((maze[0].length - 1) / 2));
        outint = out.intValue();
        maze[maze.length - 1][outint * 2 + 1] = ' ';
    }
    /**
     * Takes the number of a corridor as input and calculates the number of the
     * room above it.
     * @param corridor
     * @param height
     * @return roomAbove
     */
    public int getRoomAbove(final int corridor, final int height) {
        return corridor - corridor / (height * 2 - 1) * (height - 1);
    }
    /**
     * Takes the number a corridor as input and calculates the number of the
     * room below it.
     * @param corridor
     * @param height
     * @return roomBelow
     */
    public int getRoomBelow(final int corridor, final int height) {
        return corridor - (corridor / (height * 2 - 1) * (height - 1) - 1);
    }
    /**
     * Takes the number of a corridor as input and calculates the number of the
     * room to the left of it
     * @param corridor
     * @param height
     * @return roomToTheLeft
     */
    public int getLeftRoom(final int corridor, final int height) {
        return height * (corridor / (height * 2 - 1)) +
                (corridor % (height * 2 - 1) - (height - 1));
    }
    /**
     * Takes the number of a corridor as input and calculates the number of the
     * room to the right of it.
     * @param corridor
     * @param height
     * @return roomToTheRight
     */
    public int getRightRoom(final int corridor, final int height) {
        return height * (corridor / (height * 2 - 1)) +
                (corridor % (height * 2 - 1) + 1);
    }
    /**
     * Calculates the corridor's coordinates in the maze and replaces '#' with
     * ' ' (connects the two rooms).
     * @param corridor
     */
    public void removeCorridor(int corridor) {
        if (corridor % (maze.length - 2) < (maze.length - 2) / 2) {
            //Even column
            maze[2 + (corridor % (maze.length - 2)) * 2]
                    [1 + (corridor / (maze.length - 2)) * 2] = ' ';
        } else {
            //Odd column
            maze[1 + ((corridor % (maze.length - 2)) - ((maze.length - 2) / 2)) * 2]
                    [2 + (corridor / (maze.length - 2)) * 2] = ' ';
        }
    }
    /**
     * Returns the generated maze.
     * @return 
     */
    public char[][] getMaze() {
        return this.maze;
    }
}
