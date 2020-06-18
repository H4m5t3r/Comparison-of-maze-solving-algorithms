
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
        p.runAllTests();
        System.out.println("Done");
        long[] list1 = p.getRecDead();
        long[] list2 = p.getRecDepth();
        long[] list3 = p.getKrusDead();
        long[] list4 = p.getKrusDepth();
        for (int i = 0; i < list4.length; i++) {
            System.out.println(list1[i]);
        }
        System.out.println("");
        for (int i = 0; i < list4.length; i++) {
            System.out.println(list2[i]);
        }
        System.out.println("");
        for (int i = 0; i < list4.length; i++) {
            System.out.println(list3[i]);
        }
        System.out.println("");
        for (int i = 0; i < list4.length; i++) {
            System.out.println(list4[i]);
        }
    }
}
