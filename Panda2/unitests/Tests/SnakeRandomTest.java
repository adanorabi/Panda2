package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Levels;
import Enum.SnakeColor;
import Model.Snake;

class SnakeRandomTest {

	@Test
	public void testSnackRandom_Easy_Blue() {
		Snake snake = new Snake(SnakeColor.Blue);
		snake.SnackRandom(Levels.Easy, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 6);
		assertTrue(snake.getYHeadNum() >= 3 && snake.getYHeadNum() <= 6);

	}

	@Test
	public void testSnackRandom_Easy_Green() {
		Snake snake = new Snake(SnakeColor.Green);
		snake.SnackRandom(Levels.Easy, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 6);
		assertTrue(snake.getYHeadNum() >= 2 && snake.getYHeadNum() <= 6);
	}

	@Test
	public void testSnackRandom_Easy_Red() {
		Snake snake = new Snake(SnakeColor.Red);
		snake.SnackRandom(Levels.Easy, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 6);
		assertTrue(snake.getYHeadNum() >= 0 && snake.getYHeadNum() <= 6);
		assertEquals(snake.getXHeadNum(), snake.getXTailNum());
		assertEquals(snake.getYHeadNum(), snake.getYTailNum());
	}

	@Test
	public void testSnackRandom_Easy_Yellow() {
		Snake snake = new Snake(SnakeColor.Yellow);
		snake.SnackRandom(Levels.Easy, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 6);
		assertTrue(snake.getYHeadNum() >= 1 && snake.getYHeadNum() <= 6);
	}

	@Test
	public void testSnackRandom_Medium_Blue() {
		Snake snake = new Snake(SnakeColor.Blue);
		snake.SnackRandom(Levels.Medium, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 9);
		assertTrue(snake.getYHeadNum() >= 3 && snake.getYHeadNum() <= 9);

	}
	@Test
	public void testSnackRandom_Medium_Green() {
		Snake snake = new Snake(SnakeColor.Green);
		snake.SnackRandom(Levels.Medium, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 9);
		assertTrue(snake.getYHeadNum() >= 2 && snake.getYHeadNum() <= 9);
	}
	
	@Test
	public void testSnackRandom_Medium_Red() {
		Snake snake = new Snake(SnakeColor.Red);
		snake.SnackRandom(Levels.Medium, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 9);
		assertTrue(snake.getYHeadNum() >= 0 && snake.getYHeadNum() <= 9);
		assertEquals(snake.getXHeadNum(), snake.getXTailNum());
		assertEquals(snake.getYHeadNum(), snake.getYTailNum());
	}
	
	@Test
	public void testSnackRandom_Medium_Yellow() {
		Snake snake = new Snake(SnakeColor.Yellow);
		snake.SnackRandom(Levels.Medium, snake);
		assertTrue(snake.getXHeadNum() >= 0 && snake.getXHeadNum() <= 9);
		assertTrue(snake.getYHeadNum() >= 1 && snake.getYHeadNum() <= 9);
	}


}




