
package maze.domain;

/**
 *
 * @author taleiko
 */
public class Testing {
    public static void main(String[] args) {
        MazeGenerator gen = new MazeGenerator(20, 20);
        gen.generateMaze();
        char[][] maze = gen.getMaze();
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                System.out.print(maze[y][x]);
            }
            System.out.println("");
        }
        System.out.println("");
        MazeSolver solve = new MazeSolver();
        solve.deadEndFillSolve(maze);
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                System.out.print(maze[y][x]);
            }
            System.out.println("");
        }
    }
}
