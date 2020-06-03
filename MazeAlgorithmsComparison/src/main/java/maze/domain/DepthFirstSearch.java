
package maze.domain;

/**
 * A class that uses depth-first search to solve perfect mazes.
 * @author taleiko
 */
public class DepthFirstSearch {
    private boolean exitFound;
    
    public void solve(final char[][] maze) {
        exitFound = false;
        
        //Marking the exit
        for (int i = 1; i < maze[0].length; i += 2) {
            if (maze[maze.length - 1][i] == ' ') {
                maze[maze.length - 1][i] = 'e';
            }
        }

        //Looking for the entrance and starting the search
        for (int i = 1; i < maze[0].length; i += 2) {
            if (maze[0][i] == ' ') {
                maze[0][i] = '#';
                search(maze, 1, i);
                maze[0][i] = 'c';
                break;
            }
        }
    }

    private void search(final char[][] maze, final int y, final int x) {
        maze[y][x] = 'c';
        
        //Debugging
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        
        //Checking all four directions
        if ((maze[y + 1][x] == ' ' || maze[y+1][x] == 'e') && exitFound == false) {
            if (maze[y + 1][x] == 'e') {
                maze[y + 1][x] = 'c';
                exitFound = true;
            } else {
                maze[y + 1][x] = 'c';
                search(maze, y + 2, x);
                if (!exitFound) {
                    maze[y + 1][x] = ' ';
                }
            }
        }
        if (maze[y][x - 1] == ' ' && exitFound == false) {
            maze[y][x - 1] = 'c';
            search(maze, y, x - 2);
            if (!exitFound) {
                maze[y][x - 1] = ' ';
            }
        }
        if (maze[y - 1][x] == ' ' && exitFound == false) {
            maze[y - 1][x] = 'c';
            search(maze, y - 2, x);
            if (!exitFound) {
                maze[y - 1][x] = ' ';
            }
        }
        if (maze[y][x + 1] == ' ' && exitFound == false) {
            maze[y][x + 1] = 'c';
            search(maze, y, x + 2);
            if (!exitFound) {
                maze[y][x + 1] = ' ';
            }
        }
        
        //Marking this room as incorrect if it doesn't lead to the exit
        if (!exitFound) {
            maze[y][x] = ' ';
        }
    }
}
