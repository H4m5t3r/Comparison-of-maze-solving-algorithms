
package tests;

import maze.domain.Logic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taleiko
 */
public class LogicTest {
    private Logic logic;

    @Before
    public void setUp() {
        this.logic = new Logic();
    }

    @Test
    public void changeWidthWorksCorrectly() {
        int originalWidth = logic.getWidth();
        //Increasing and decreasing works
        logic.increaseWidth();
        assertTrue(logic.getWidth() == originalWidth + 1);
        logic.decreaseWidth();
        assertTrue(logic.getWidth() == originalWidth);
        //Does not increase past the maximum value
        for (int i = logic.getWidth(); i < logic.getMaxWidth() + 1; i++) {
            logic.increaseWidth();
        }
        assertTrue(logic.getWidth() == logic.getMaxWidth());
        //Does not decrease below the minimum value
        for (int i = logic.getWidth(); i > logic.getMinWidth() - 1; i--) {
            logic.decreaseWidth();
        }
        assertTrue(logic.getWidth() == logic.getMinWidth());
        
        //setWidth
        logic.setWidth(logic.getMaxWidth() - 4);
        assertTrue(logic.getWidth() == logic.getMaxWidth() - 4);
        logic.setWidth(-1);
        assertTrue(logic.getWidth() == 1);
        logic.setWidth(logic.getMaxWidth() + 1);
        assertTrue(logic.getWidth() == logic.getMaxWidth());
    }
    
    @Test
    public void changeHeightWorksCorrectly() {
        int originalHeight = logic.getHeight();
        //Increasing and decreasing works
        logic.increaseHeight();
        assertTrue(logic.getHeight() == originalHeight + 1);
        logic.decreaseHeight();
        assertTrue(logic.getHeight() == originalHeight);
        //Does not increase past the maximum value
        for (int i = logic.getHeight(); i < logic.getMaxHeight() + 1; i++) {
            logic.increaseHeight();
        }
        assertTrue(logic.getHeight() == logic.getMaxHeight());
        //Does not decrease below the minimum value
        for (int i = logic.getHeight(); i > logic.getMinHeight() - 1; i--) {
            logic.decreaseHeight();
        }
        assertTrue(logic.getHeight() == logic.getMinHeight());
        
        //setHeight
        logic.setHeight(logic.getMaxHeight() - 4);
        assertTrue(logic.getHeight() == logic.getMaxHeight() - 4);
        logic.setHeight(-1);
        assertTrue(logic.getHeight() == 1);
        logic.setHeight(logic.getMaxHeight() + 1);
        assertTrue(logic.getHeight() == logic.getMaxHeight());
    }
    
    @Test
    public void generatorTest() {
        for (int i = logic.getHeight(); i < logic.getMaxHeight(); i++) {
            logic.increaseHeight();
        }
        for (int i = logic.getWidth(); i < logic.getMaxWidth(); i++) {
            logic.increaseWidth();
        }
        logic.initializeRecursiveBacktracker();
        assertTrue(logic.getMazeFromRecursiveBacktracker().length == logic.getHeight() * 2 + 1);
        assertTrue(logic.getMazeFromRecursiveBacktracker()[0].length == logic.getWidth() * 2 + 1);
        //ADD TESTS THAT CHECK THAT EVERY "ROOM" IS A BLANK SPACE WHEN THE
        //MAZE GENERATING METHOD IS COMPLETE
    }
}
