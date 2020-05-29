
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

    public void isDeadEnd(char[][] maze, int y, int x) {
        if (maze[y][x] == ' ') {
            if (maze[y - 1][x] == ' ' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == ' '
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == ' ' && maze[y][x - 1] == '#') {
                fillDeadEnd(maze, y, x);
            }
            else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                    && maze[y + 1][x] == '#' && maze[y][x - 1] == ' ') {
                fillDeadEnd(maze, y, x);
            }
        }
    }

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
        else if (maze[y][x - 1] == ' ') {
            maze[y][x - 1] = '#';
            isDeadEnd(maze, y, x - 2);
        }
    }
}
