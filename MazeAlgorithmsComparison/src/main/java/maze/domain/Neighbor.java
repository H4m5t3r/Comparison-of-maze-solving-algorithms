
package maze.domain;

/**
 * 
 * @author taleiko
 */
public class Neighbor {
    private final int x;
    private final int y;
    private final boolean visited;
    
    public Neighbor(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }
}
