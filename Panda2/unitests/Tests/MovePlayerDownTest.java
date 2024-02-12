package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.SnakeColor;
import Model.Snake;

class MovePlayerDownTest {

	  @Test
	    public void testMovePlayerDown_PlayerAtBlueHead() {
	        Snake snake = new Snake(SnakeColor.Blue);
	        // Set snake's head position
	        snake.setXHeadNum(3);
	        snake.setYHeadNum(4);
	        // Set snake's tail position
	        snake.setXTailNum(3);
	        snake.setYTailNum(1);

	        int[] result = snake.MovePlayerDown(3, 4);

	        assertEquals(3, result[0]);
	        assertEquals(1, result[1]);
	    }

	  @Test
	    public void testMovePlayerDown_PlayerAtGreenHead() {
	        Snake snake = new Snake(SnakeColor.Green);
	        // Set snake's head position
	        snake.setXHeadNum(3);
	        snake.setYHeadNum(4);
	        // Set snake's tail position
	        snake.setXTailNum(3);
	        snake.setYTailNum(2);

	        int[] result = snake.MovePlayerDown(3, 4);

	        assertEquals(3, result[0]);
	        assertEquals(2, result[1]);
	    }

	  @Test
	    public void testMovePlayerDown_PlayerAtRedHead() {
	        Snake snake = new Snake(SnakeColor.Red);
	        // Set snake's head position
	        snake.setXHeadNum(3);
	        snake.setYHeadNum(4);
	        // Set snake's tail position
	        snake.setXTailNum(0);
	        snake.setYTailNum(0);

	        int[] result = snake.MovePlayerDown(3, 4);

	        assertEquals(0, result[0]);
	        assertEquals(0, result[1]);
	    }
	  
	  @Test
	    public void testMovePlayerDown_PlayerAtYellowHead() {
	        Snake snake = new Snake(SnakeColor.Yellow);
	        // Set snake's head position
	        snake.setXHeadNum(3);
	        snake.setYHeadNum(4);
	        // Set snake's tail position
	        snake.setXTailNum(3);
	        snake.setYTailNum(3);

	        int[] result = snake.MovePlayerDown(3, 4);

	        assertEquals(3, result[0]);
	        assertEquals(3, result[1]);
	    }

}


