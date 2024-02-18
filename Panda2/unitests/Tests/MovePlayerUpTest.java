package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Ladder;

class MovePlayerUpTest {

	@Test
	public void testMovePlayerUp_Length1() {
		Ladder ladder = new Ladder(1);
		// Assuming ladder length is 1
		// Set ladder start position
		ladder.setXStart(5);
		ladder.setYStart(2);
		// Set ladder end position
		ladder.setXEnd(5);
		ladder.setYEnd(3);

		int[] result = ladder.MovePlayerUp(5, 2);

		assertEquals(5, result[0]);
		assertEquals(3, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length2() {
		Ladder ladder = new Ladder(2);
		// Assuming ladder length is 2
		// Set ladder start position
		ladder.setXStart(4);
		ladder.setYStart(3);
		// Set ladder end position
		ladder.setXEnd(4);
		ladder.setYEnd(5);

		int[] result = ladder.MovePlayerUp(4, 3);

		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length3() {
		Ladder ladder = new Ladder(3);
		// Assuming ladder length is 3
		// Set ladder start position
		ladder.setXStart(8);
		ladder.setYStart(4);
		// Set ladder end position
		ladder.setXEnd(6);
		ladder.setYEnd(7);

		int[] result = ladder.MovePlayerUp(8, 4);

		assertEquals(6, result[0]);
		assertEquals(7, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length4() {
		Ladder ladder = new Ladder(4);
		// Assuming ladder length is 4
		// Set ladder start position
		ladder.setXStart(3);
		ladder.setYStart(5);
		// Set ladder end position
		ladder.setXEnd(3);
		ladder.setYEnd(9);

		int[] result = ladder.MovePlayerUp(3, 5);

		assertEquals(3, result[0]);
		assertEquals(9, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length5() {
		Ladder ladder = new Ladder(5);
		// Assuming ladder length is 5
		// Set ladder start position
		ladder.setXStart(8);
		ladder.setYStart(6);
		// Set ladder end position
		ladder.setXEnd(7);
		ladder.setYEnd(11);

		int[] result = ladder.MovePlayerUp(8, 6);

		assertEquals(7, result[0]);
		assertEquals(11, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length6() {
		Ladder ladder = new Ladder(6);
		// Assuming ladder length is 6
		// Set ladder start position
		ladder.setXStart(9);
		ladder.setYStart(7);
		// Set ladder end position
		ladder.setXEnd(11);
		ladder.setYEnd(13);

		int[] result = ladder.MovePlayerUp(9, 7);

		assertEquals(11, result[0]);
		assertEquals(13, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length7() {
		Ladder ladder = new Ladder(7);
		// Assuming ladder length is 7
		// Set ladder start position
		ladder.setXStart(2);
		ladder.setYStart(4);
		// Set ladder end position
		ladder.setXEnd(2);
		ladder.setYEnd(11);

		int[] result = ladder.MovePlayerUp(2, 4);

		assertEquals(2, result[0]);
		assertEquals(11, result[1]);
	}

	@Test
	public void testMovePlayerUp_Length8() {
		Ladder ladder = new Ladder(8);
		// Assuming ladder length is 8
		// Set ladder start position
		ladder.setXStart(8);
		ladder.setYStart(1);
		// Set ladder end position
		ladder.setXEnd(5);
		ladder.setYEnd(9);

		int[] result = ladder.MovePlayerUp(8, 1);

		assertEquals(5, result[0]);
		assertEquals(9, result[1]);
	}

}
