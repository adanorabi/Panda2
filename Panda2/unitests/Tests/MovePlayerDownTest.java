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

	  

}


