
package maze.domain;

/**
 * A class that uses the dead end filling method to solve perfect mazes.
 * @author taleiko
 */
public class DeadEndFilling {
    private int corridorCounter;
    /**
     * Takes an ASCII maze as input and solves it.
     * @param maze
     */
    public void solve(final char[][] maze) {
        for (int y = 1; y < maze.length - 1; y += 2) {
            for (int x = 1; x < maze.length - 1; x += 2) {
                if (maze[y][x] == ' ') {
                    isDeadEnd(maze, y, x);
                }
            }
        }
    }
    /**
     * Determines whether or not the given space is a dead end.
     * @param maze
     * @param y
     * @param x
     * @return isDeadEnd
     */
    public void isDeadEnd(final char[][] maze, final int y, final int x) {
//        this.corridorCounter = 0;
//        if (maze[y - 1][x] == ' ') {
//            corridorCounter++;
//        }
//        if (maze[y][x + 1] == ' ') {
//            corridorCounter++;
//        }
//        if (maze[y + 1][x] == ' ') {
//            corridorCounter++;
//        }
//        if (maze[y][x - 1] == ' ') {
//            corridorCounter++;
//        }
//        if (corridorCounter == 1) {
//            fillDeadEnd(maze, y, x);
//        }
        //The old implementation
        if (maze[y - 1][x] == ' ' && maze[y][x + 1] == '#'
                && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
            fillDeadEnd(maze, y, x);
        } else if (maze[y - 1][x] == '#' && maze[y][x + 1] == ' '
                && maze[y + 1][x] == '#' && maze[y][x - 1] == '#') {
            fillDeadEnd(maze, y, x);
        } else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                && maze[y + 1][x] == ' ' && maze[y][x - 1] == '#') {
            fillDeadEnd(maze, y, x);
        } else if (maze[y - 1][x] == '#' && maze[y][x + 1] == '#'
                && maze[y + 1][x] == '#' && maze[y][x - 1] == ' ') {
            fillDeadEnd(maze, y, x);
        }
    }
    /**
     * Fills the first corridor it finds since this method is always called
     * after the program knows that this is a dead-end.
     * @param maze
     * @param y
     * @param x
     */
    public void fillDeadEnd(final char[][] maze, final int y, final int x) {
        maze[y][x] = '#';
        if (maze[y - 1][x] == ' ') {
            maze[y - 1][x] = '#';
            isDeadEnd(maze, y - 2, x);
        } else if (maze[y][x + 1] == ' ') {
            maze[y][x + 1] = '#';
            isDeadEnd(maze, y, x + 2);
        } else if (maze[y + 1][x] == ' ') {
            maze[y + 1][x] = '#';
            isDeadEnd(maze, y + 2, x);
        } else {
            maze[y][x - 1] = '#';
            isDeadEnd(maze, y, x - 2);
        }
    }
}
