
package maze.performance_testing;

/**
 *
 * @author taleiko
 */
public class Testing {
    public static void main(final String[] args) {
        System.out.println("Hello");
        PerformanceComparator p = new PerformanceComparator();
//        p.recursiveBacktrackerTest();
//        System.out.println(p.getRecTime());
        p.kruskalTest();
        System.out.println(p.getKruskalTime());
    }
}
