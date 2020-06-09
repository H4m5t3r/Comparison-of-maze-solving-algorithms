
package maze.domain;

import maze.data_structures.UnionFind;

/**
 * Generates a maze labyrinth by creating a minimum spanning tree.
 * @author taleiko
 */
public class KruskalMaze {
    private final char[][] maze;
    private final int[] corridors;
    private final FisherYatesShuffle shuffle;
    private final UnionFind u;
    
    public KruskalMaze(int mazeHeight, int mazeWidth) {
        maze = new char[mazeHeight * 2 + 1][mazeWidth * 2 + 1];
        corridors = new int[(mazeHeight - 1) * mazeWidth + (mazeWidth - 1) *
                mazeHeight];
        shuffle = new FisherYatesShuffle();
        u = new UnionFind(mazeWidth * mazeHeight);
    }
    
    public void generateKruskalMaze() {
        //Generating the base for the maze with rooms but no corridors.
        for (int i = 0; i < maze.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < maze[0].length; j++) {
                    maze[i][j] = '#';
                }
            } else {
                for (int j = 0; j < maze[0].length; j += 2) {
                    maze[i][j] = '#';
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
            if (corridors[i] % (maze.length - 2) < maze.length / 2) {
                //Vertical corridor
//                if ((maze[corridors[i] % (maze.length - 2)) * 2]
//                [corridor[i] / (maze.length - 2) * 2 + 1]) {
                    
                }
//            } else {
//                //Horizontal corridor
//            }
        }
    }
    
    public int getRoomAbove(final int corridor, final int height) {
        return corridor - corridor / (height * 2 - 1) * (height - 1);
    }
    
    public int getRoomBelow(final int corridor, final int height) {
        return corridor - (corridor / (height * 2 - 1) * (height - 1) - 1);
    }
    
    public int getRoomOnTheLeft(final int corridor, final int height) {
        return height * (corridor / (height * 2 - 1)) +
                (corridor % (height * 2 - 1) - (height - 1));
    }
    
    public int getRoomOnTheRight(final int corridor, final int height) {
        return height * (corridor / (height * 2 - 1)) +
                (corridor % (height * 2 - 1) + 1);
    }
}
