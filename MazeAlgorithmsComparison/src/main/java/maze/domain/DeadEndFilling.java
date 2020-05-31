
package maze.domain;

/**
 * A class that uses the dead end filling method to solve perfect mazes.
 * @author taleiko
 */
public class DeadEndFilling {
    /**
     * Takes an ASCII maze as input and solves it.
     * @param maze 
     */
    public void solve(char[][] maze) {
        for (int y = 1; y < maze.length - 1; y += 2) {
            for (int x = 1; x < maze.length - 1; x += 2) {
                isDeadEnd(maze, y, x);
            }
        }
    }
    /**
     * Determines whether or not the given space is a dead end.
     * @param maze
     * @param y
     * @param x
     * @return 
     */
    public boolean isDeadEnd(char[][] maze, int y, int x) {
        if (maze[y][x] == ' ') {
            if (maze[y - 1][x] == ' ' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
                return true;
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == ' '
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
                return true;
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == ' ' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
                return true;
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == ' ') {
                fillDeadEnd(maze, y, x);
                return true;
            }
        }
        return false;
    }
    /**
     * Fills the first corridor it finds since this method is always called
     * after the program knows that this is a dead-end.
     * @param maze
     * @param y
     * @param x
     */
    public void fillDeadEnd(char[][] maze, int y, int x) {
        maze[y][x] = '#';
        if (maze[y - 1][x] == ' ') {
            maze[y - 1][x] = '#';
            isDeadEnd(maze, y - 2, x);
        }
        else if (maze[y][x + 1] == ' ') {
            maze[y][x + 1] = '#';
            isDeadEnd(maze, y, x + 2);
        }
        else if (maze[y + 1][x] == ' ') {
            maze[y + 1][x] = '#';
            isDeadEnd(maze, y + 2, x);
        }
        else {
            maze[y][x - 1] = '#';
            isDeadEnd(maze, y, x - 2);
        }
    }
}
