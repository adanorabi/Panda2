package Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Enum.Levels;
import Model.Dice;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Annotation indicating that this class is a JUnit test class and will use parameterized tests
@RunWith(Parameterized.class)
public class DiceTest {

    // Instance variables to store parameters for testing
    private Levels gameLevel;
    private int expectedNumOfSides;
    private int[] expectedDiceOptions;

    // Constructor to initialize instance variables with parameters from parameterized tests
    public DiceTest(Levels gameLevel, int expectedNumOfSides, int[] expectedDiceOptions) {
        this.gameLevel = gameLevel;
        this.expectedNumOfSides = expectedNumOfSides;
        this.expectedDiceOptions = expectedDiceOptions;
    }

    // Method providing parameters for parameterized tests
    @Parameterized.Parameters
    public static Collection<Object[]> testParameters() {
        return Arrays.asList(new Object[][]{
                {Levels.Easy, 8, new int[]{0, 1, 2, 3, 4, 7, 8, 9}},
                {Levels.Medium, 13, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9}},
                {Levels.Hard, 15, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9, 9, 9}}
        });
    }

    // Actual test method
    @Test
    public void testConstructor() {
        // Creating an instance of the Dice class with the provided game level
        Dice dice = new Dice(gameLevel);
        
        // Asserting that the number of sides matches the expected value
        assertEquals(expectedNumOfSides, dice.getNumOfSides());
        
        // Asserting that the dice options match the expected array
        assertArrayEquals(expectedDiceOptions, dice.getDiceOptions());
    }
}
