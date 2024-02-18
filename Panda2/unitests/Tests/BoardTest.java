package Tests;

import static org.junit.Assert.*;
import Model.Board;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        // Create a 3x3 board for testing
        board = new Board(3);
    }

    @Test
    public void testGetPosition() {
        // Test getPosition method for known positions
        assertEquals(1, board.getPosition(0, 0));
        assertEquals(2, board.getPosition(1, 0));
        assertEquals(3, board.getPosition(2, 0));
        assertEquals(6, board.getPosition(0, 1));
        assertEquals(5, board.getPosition(1, 1));
        assertEquals(4, board.getPosition(2, 1));
        assertEquals(7, board.getPosition(0, 2));
        assertEquals(8, board.getPosition(1, 2));
        assertEquals(9, board.getPosition(2, 2));
    }

    @Test
    public void testGetCoordinates() {
        // Test getCoordinates method for known positions
        assertArrayEquals(new int[]{0, 0}, board.getCoordinates(1));
        assertArrayEquals(new int[]{1, 0}, board.getCoordinates(2));
        assertArrayEquals(new int[]{2, 0}, board.getCoordinates(3));
        assertArrayEquals(new int[]{0, 1}, board.getCoordinates(6));
        assertArrayEquals(new int[]{1, 1}, board.getCoordinates(5));
        assertArrayEquals(new int[]{2, 1}, board.getCoordinates(4));
        assertArrayEquals(new int[]{0, 2}, board.getCoordinates(7));
        assertArrayEquals(new int[]{1, 2}, board.getCoordinates(8));
        assertArrayEquals(new int[]{2, 2}, board.getCoordinates(9));
    }

    @Test
    public void testBoardInitialization() {
        // Test the initialization of the board
        assertEquals("Board [board=[1, 2, 3, 4, 5, 6, 7, 8, 9], size=3]", board.toString());
    }
}
