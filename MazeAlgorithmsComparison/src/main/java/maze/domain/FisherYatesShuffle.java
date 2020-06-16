
package maze.domain;

/**
 * Implements a variant of the Fisher-Yates algorithm to shuffle integers in an
 * array.
 * @author taleiko
 */
public class FisherYatesShuffle {
    /**
     * Used for getting a random index to swap with by converting it to an
     * integer.
     */
    private Long random;
    /**
     * The integer used for storing the swapped integer temporarily.
     */
    private int temp;

    /**
     * Shuffles a given integer array that contains integers.
     * @param list
     */
    public void shuffleIntegerArray(final int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            random = System.nanoTime() % i;
            temp = list[random.intValue()];
            list[random.intValue()] = list[i];
            list[i] = temp;
        }
    }
}
