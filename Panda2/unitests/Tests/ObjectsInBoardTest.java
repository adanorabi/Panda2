package Tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Enum.Levels;
import Model.Game;

public class ObjectsInBoardTest {

	Game easy=new Game(1, Levels.Easy, 7, 7);
	Game medium=new Game(2, Levels.Medium, 10, 10);
	Game hard=new Game(2, Levels.Hard, 13, 13);

	@Test
	void EasyLevelObjectstest() {
		easy.createGame();
		easy.PlacespecialSquares(Levels.Easy);
		easy.placeNormalSquares();
		easy.PlaceSnakes();
		easy.placeLadders();
		HashMap<Integer, Integer> obj = new HashMap<Integer, Integer>();
		for (int i=0 ; i<7;i++)
		{
			for(int j=0; j<7; j++)
			{
				obj.put(easy.getPlaces()[i][j], 1);
			}

		}
		for(int i = 3;i<=5;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}
		for(int i=6; i<=9;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}
		for(int i=14; i<=17;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}

	}

	@Test
	void MeduimLevelObjectstest() {
		medium.createGame();
		medium.PlacespecialSquares(Levels.Medium);
		medium.placeNormalSquares();
		medium.PlaceSnakes();
		medium.placeLadders();
		HashMap<Integer, Integer> obj = new HashMap<Integer, Integer>();
		for (int i=0 ; i<10;i++)
		{
			for(int j=0; j<10; j++)
			{
				obj.put(medium.getPlaces()[i][j], 1);
			}

		}
		for(int i = 1;i<=5;i++)
		{
			if(i!=2) {
				if(obj.get(i)!=1)
				{
					fail("Object placement failed at position " + i);
				}
			}

		}
		for(int i=6; i<=11;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}
		for(int i=14; i<=19;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}

	}

	@Test
	void HarrdLevelObjectstest() {
		hard.createGame();
		hard.PlacespecialSquares(Levels.Medium);
		hard.placeNormalSquares();
		hard.PlaceSnakes();
		hard.placeLadders();
		HashMap<Integer, Integer> obj = new HashMap<Integer, Integer>();
		for (int i=0 ; i<13;i++)
		{
			for(int j=0; j<13; j++)
			{
				obj.put(hard.getPlaces()[i][j], 1);
			}

		}
		for(int i = 1;i<=21;i++)
		{
			if(obj.get(i)!=1)
			{
				fail("Object placement failed at position " + i);
			}
		}


	}
}
