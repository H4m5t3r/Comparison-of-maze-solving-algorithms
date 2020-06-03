
package maze.domain;

import maze.data_structures.Stack;

/**
 * A class that uses depth-first search to solve perfect mazes.
 * @author taleiko
 */
public class DepthFirstSearch {
    private boolean exitFound;
    
    public void solve(final char[][] maze) {
        System.out.println("Hi");
        exitFound = false;
        
        //Marking the exit
        for (int i = 1; i < maze[0].length; i += 2) {
            if (maze[maze.length - 1][i] == ' ') {
                System.out.println(i);
                maze[maze.length - 1][i] = 'e';
            }
        }

        //Looking for the entrance and starting the search
        for (int i = 0; i < maze[0].length; i++) {
            System.out.println(i);
            if (maze[0][i] == ' ') {
                System.out.println(i);
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
        if (maze[y - 1][x] == ' ' && exitFound == false) {
            if (maze[y - 1][x] == 'e') {
                maze[y - 1][x] = 'c';
                exitFound = true;
            } else {
                maze[y - 1][x] = 'c';
                search(maze, y - 2, x);
                if (!exitFound) {
                    maze[y - 1][x] = ' ';
                }
            }
        }
        if (maze[y][x + 1] == ' ' && exitFound == false) {
            if (maze[y][x + 1] == 'e') {
                maze[y][x + 1] = 'c';
                exitFound = true;
            } else {
                maze[y][x + 1] = 'c';
                search(maze, y, x + 2);
                if (!exitFound) {
                    maze[y][x + 1] = ' ';
                }
            }
        }
        if ((maze[y + 1][x] == ' ' || maze[y+1][x] == 'e') && exitFound == false) {
            if (maze[y + 1][x] == 'e') {
                System.out.println("Gotcha!!!");
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
            if (maze[y][x - 1] == 'e') {
                maze[y][x - 1] = 'c';
                exitFound = true;
            } else {
                maze[y][x - 1] = 'c';
                search(maze, y, x - 2);
                if (!exitFound) {
                    maze[y][x - 1] = ' ';
                }
            }
        }
        //Marking this room as incorrect if it doesn't lead to the exit
        if (!exitFound) {
            maze[y][x] = ' ';
        }
    }
}
