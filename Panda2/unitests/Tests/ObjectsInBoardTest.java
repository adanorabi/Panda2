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
//	private Game medium;
//	private Game hard;

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
//
//	@Test
//	public void testMediumLevelObjects() {
//		medium = new Game(2, Levels.Medium, 10, 10);
//		medium.createGame();
//		medium.PlacespecialSquares(Levels.Medium);
//		medium.placeNormalSquares();
//		medium.PlaceSnakes();
//		medium.placeLadders();
//		if(medium.getLadders().size()!=6 || medium.getSnakes().size()!=6) {
//			fail("Object placement failed at position ");
//
//		}
//		int numOfQ=0;
//		int numOfS=0;
//		for (Square s : medium.getSquares())
//		{
//			if (s instanceof QuestionSquare)
//			{
//				numOfQ++;
//			}
//			else if (s instanceof SurpriseSquare)
//			{
//				numOfS++;
//			}
//		}
//		if(numOfQ !=3 || numOfS!=1 )
//		{
//			fail("Object placement failed at position ");
//		}
//	}
//
//	@Test
//	public void testHardLevelObjects() {
//		hard = new Game(3, Levels.Hard, 13, 13);
//		hard.createGame();
//		hard.PlacespecialSquares(Levels.Hard);
//		hard.placeNormalSquares();
//		hard.PlaceSnakes();
//		hard.placeLadders();
//		if(hard.getLadders().size()!=8 || hard.getSnakes().size()!=8) {
//			fail("Object placement failed at position ");
//
//		}
//		int numOfQ=0;
//		int numOfS=0;
//		for (Square s : hard.getSquares())
//		{
//			if (s instanceof QuestionSquare)
//			{
//				numOfQ++;
//			}
//			else if (s instanceof SurpriseSquare)
//			{
//				numOfS++;
//			}
//		}
//		if(numOfQ !=3 || numOfS!=2 )
//		{
//			fail("Object placement failed at position ");
//		}
//	}
}
