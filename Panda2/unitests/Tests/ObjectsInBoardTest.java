package Tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Enum.Levels;
import Model.Game;
import Model.Question;
import Model.QuestionSquare;
import Model.Square;
import Model.SurpriseSquare;

public class ObjectsInBoardTest {

	private Game easy;

	@Test
	public void testEasyLevelObjects() {
		easy = new Game(1, Levels.Easy, 7, 7);
		easy.createGame();
		easy.PlacespecialSquares(Levels.Easy);
		easy.placeNormalSquares();
		easy.PlaceSnakes();
		easy.placeLadders();
		if(easy.getLadders().size()!=4 || easy.getSnakes().size()!=4)
		{
			fail("Object placement failed at position ");

		}
		int numOfQ=0;
		for (Square s : easy.getSquares())
		{
			if (s instanceof QuestionSquare)
			{
				numOfQ++;
			}
		}
		if(numOfQ !=3)
		{
			fail("Object placement failed at position ");
		}
		
	}

}
