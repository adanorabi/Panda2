package Model;

import java.util.ArrayList;

import Enum.Levels;

public class Game {
	
	private int GameId;
	private Levels GameLevel;
	private int RowsNum;
	private int ColsNum;
	private int Places[][];
	private int WinnerId;
	private ArrayList<Integer> CurentTurn= new ArrayList<Integer>() ;
	private ArrayList<Player> Players= new ArrayList<Player>() ;
	private ArrayList<Snake> Snakes= new ArrayList<Snake>() ;
	private ArrayList<Ladder> Ladders= new ArrayList<Ladder>() ;
	private Dice dice;
	private ArrayList<Square> Squares= new ArrayList<Square>() ;

	public Game(int gameId, Levels gameLevel, int rowsNum, int colsNum) {
		super();
		GameId = gameId;
		GameLevel = gameLevel;
		RowsNum = rowsNum;
		ColsNum = colsNum;
		Places=new int[RowsNum][ColsNum];
	}
}
