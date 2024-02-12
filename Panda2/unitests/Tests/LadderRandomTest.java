package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Levels;
import Model.Ladder;

class LadderRandomTest {

	 @Test
	    public void testLadderRandom_Length1_Easy() {
	        Ladder ladder = new Ladder(1);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 6);
	        assertTrue(ladder.getYEnd() >= 1 && ladder.getYEnd() <= 6);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 1);
	    }

	    @Test
	    public void testLadderRandom_Length2_Easy() {
	        Ladder ladder = new Ladder(2);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 6);
	        assertTrue(ladder.getYEnd() >= 2 && ladder.getYEnd() <= 6);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 2);
	    }

	    @Test
	    public void testLadderRandom_Length3_Easy() {
	        Ladder ladder = new Ladder(3);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 4);
	        assertTrue(ladder.getYEnd() >= 3 && ladder.getYEnd() <= 6);
	        assertEquals(ladder.getXStart(), ladder.getXEnd() + 2);
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 3);
	    }

	    @Test
	    public void testLadderRandom_Length4_Easy() {
	        Ladder ladder = new Ladder(4);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 6);
	        assertTrue(ladder.getYEnd() >= 4 && ladder.getYEnd() <= 6);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 4);
	    }
	    
	    @Test
	    public void testLadderRandom_Length1_Medium() {
	        Ladder ladder = new Ladder(1);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 9);
	        assertTrue(ladder.getYEnd() >= 1 && ladder.getYEnd() <= 9);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 1);
	    }

	    @Test
	    public void testLadderRandom_Length2_Medium() {
	        Ladder ladder = new Ladder(2);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 9);
	        assertTrue(ladder.getYEnd() >= 2 && ladder.getYEnd() <= 9);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 2);
	    }

	    @Test
	    public void testLadderRandom_Length3_Medium() {
	        Ladder ladder = new Ladder(3);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 7);
	        assertTrue(ladder.getYEnd() >= 3 && ladder.getYEnd() <= 9);
	        assertEquals(ladder.getXStart(), ladder.getXEnd() + 2);
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 3);
	    }

	    @Test
	    public void testLadderRandom_Length4_Medium() {
	        Ladder ladder = new Ladder(4);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 9);
	        assertTrue(ladder.getYEnd() >= 4 && ladder.getYEnd() <= 9);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 4);
	    }
	    
	    @Test
	    public void testLadderRandom_Length5_Medium() {
	        Ladder ladder = new Ladder(3);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 9);
	        assertTrue(ladder.getYEnd() >= 3 && ladder.getYEnd() <= 9);
	        assertEquals(ladder.getXStart(), ladder.getXEnd() + 2);
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 5);
	    }

	    @Test
	    public void testLadderRandom_Length6_Medium() {
	        Ladder ladder = new Ladder(4);
	        ladder.LadderRandom(Levels.Easy, ladder);
	        assertTrue(ladder.getXEnd() >= 0 && ladder.getXEnd() <= 6);
	        assertTrue(ladder.getYEnd() >= 4 && ladder.getYEnd() <= 6);
	        assertEquals(ladder.getXStart(), ladder.getXEnd());
	        assertEquals(ladder.getYStart(), ladder.getYEnd() - 4);
	    }

}


