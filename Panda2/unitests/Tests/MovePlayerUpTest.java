package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Ladder;

class MovePlayerUpTest {

	

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

		int[] result = ladder.MovePlayer(8, 1);
		assertEquals(5, result[0]);
		assertEquals(9, result[1]);
	}

}
