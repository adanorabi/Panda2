package Tests;

import static org.junit.Assert.*;
import Model.Board;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        // creating a board of size 3*3
        board = new Board(3);
    }

    @Test
    public void testGetPosition() {
        // testing getPosition method - i want to test if the board is being from left to right then from right to left 
        assertEquals(1, board.getPosition(0, 0));// check if the board square number is 1 on the cordenation (0,0)
        assertEquals(2, board.getPosition(1, 0));// check if the board square number is 2 on the cordenation (1,0)
        assertEquals(3, board.getPosition(2, 0));// check if the board square number is 3 on the cordenation (2,0)
        assertEquals(6, board.getPosition(0, 1));// check if the board square number is 6 on the cordenation (0,1)
        assertEquals(5, board.getPosition(1, 1));// check if the board square number is 5 on the cordenation (1,1)
        assertEquals(4, board.getPosition(2, 1));// check if the board square number is 4 on the cordenation (2,1)
        assertEquals(7, board.getPosition(0, 2));// check if the board square number is 7 on the cordenation (0,2)
        assertEquals(8, board.getPosition(1, 2));// check if the board square number is 8 on the cordenation (1,2)
        assertEquals(9, board.getPosition(2, 2));// check if the board square number is 9 on the cordenation (2,2)
    }

    @Test
    public void testGetCoordinates() {
        // testing getCoordinates method
        assertArrayEquals(new int[]{0, 0}, board.getCoordinates(1));// check if the board square number is in cordenation (0,0) on the square 1
        assertArrayEquals(new int[]{1, 0}, board.getCoordinates(2));// check if the board square number is in cordenation (1,0) on the square 2
        assertArrayEquals(new int[]{2, 0}, board.getCoordinates(3));// check if the board square number is in cordenation (2,0) on the square 3
        assertArrayEquals(new int[]{0, 1}, board.getCoordinates(6));// check if the board square number is in cordenation (0,1) on the square 6
        assertArrayEquals(new int[]{1, 1}, board.getCoordinates(5));// check if the board square number is in cordenation (1,1) on the square 5
        assertArrayEquals(new int[]{2, 1}, board.getCoordinates(4));// check if the board square number is in cordenation (2,1) on the square 4
        assertArrayEquals(new int[]{0, 2}, board.getCoordinates(7));// check if the board square number is in cordenation (0,2) on the square 7
        assertArrayEquals(new int[]{1, 2}, board.getCoordinates(8));// check if the board square number is in cordenation (1,2) on the square 8
        assertArrayEquals(new int[]{2, 2}, board.getCoordinates(9));// check if the board square number is in cordenation (2,2) on the square 9
    }

    @Test
    public void testBoardInitialization() {
        // test the initialization of the board - by calling the toSting method that is in the board class
        assertEquals("Board [board=[1, 2, 3, 4, 5, 6, 7, 8, 9], size=3]", board.toString());
    }
}
