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

@RunWith(Parameterized.class)
public class DiceTest {
    private Levels gameLevel;
    private int expectedNumOfSides;
    private int[] expectedDiceOptions;

    public DiceTest(Levels gameLevel, int expectedNumOfSides, int[] expectedDiceOptions) {
        this.gameLevel = gameLevel;
        this.expectedNumOfSides = expectedNumOfSides;
        this.expectedDiceOptions = expectedDiceOptions;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testParameters() {
        return Arrays.asList(new Object[][]{
                {Levels.Easy, 8, new int[]{0, 1, 2, 3, 4, 7, 8, 9}},
                {Levels.Medium, 13, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9}},
                {Levels.Hard, 15, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9, 9, 9}}
        });
    }

    @Test
    public void testConstructor() {
        Dice dice = new Dice(gameLevel);
        assertEquals(expectedNumOfSides, dice.getNumOfSides());
        assertArrayEquals(expectedDiceOptions, dice.getDiceOptions());
    }
}
