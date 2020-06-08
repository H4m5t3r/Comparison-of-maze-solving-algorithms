
package maze.domain;

/**
 * Generates a maze labyrinth by creating a minimum spanning tree.
 * @author taleiko
 */
public class KruskalMaze {
    private final char[][] maze;
    private final int[] corridors;
    private FisherYatesShuffle shuffle;
    
    public KruskalMaze(int mazeHeight, int mazeWidth) {
        maze = new char[mazeHeight * 2 + 1][mazeWidth * 2 + 1];
        corridors = new int[(mazeHeight - 1) * mazeWidth + (mazeWidth - 1) *
                mazeHeight];
        shuffle = new FisherYatesShuffle();
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
        for (int i = 0; i < corridors.length; i++) {
            corridors[i] = i + 1;
        }
        shuffle.shuffleIntegerArray(corridors);
        
        //for each potential corridor
        for (int i = 0; i < corridors.length; i++) {
            if (corridors[i] % (maze.length - 2) < maze.length / 2) {
                //Vertival corridor
//                if ((maze[corridors[i] % (maze.length - 2)) * 2]
//                [corridor[i] / (maze.length - 2) * 2 + 1]) {
                    
                }
//            } else {
//                //Horizontal corridor
//            }
        }
    }
}
