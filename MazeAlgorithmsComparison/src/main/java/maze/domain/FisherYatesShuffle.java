
package maze.domain;

/**
 * Implements a variant of the Fisher-Yates algorithm to shuffle integers in an
 * array.
 * @author taleiko
 */
public class FisherYatesShuffle {
    private Long random;
    private int randomInt;
    private int temp;
    
    public void shuffleIntegerArray(int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            random = System.nanoTime() % i;
            randomInt = random.intValue();
            temp = list[randomInt];
            list[randomInt] = list[i];
            list[i] = temp;
        }
    }
}
