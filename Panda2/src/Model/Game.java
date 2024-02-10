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

	public int getGameId() {
		return GameId;
	}

	public void setGameId(int gameId) {
		GameId = gameId;
	}

	public Levels getGameLevel() {
		return GameLevel;
	}

	public void setGameLevel(Levels gameLevel) {
		GameLevel = gameLevel;
	}

	public int getRowsNum() {
		return RowsNum;
	}

	public void setRowsNum(int rowsNum) {
		RowsNum = rowsNum;
	}

	public int getColsNum() {
		return ColsNum;
	}

	public void setColsNum(int colsNum) {
		ColsNum = colsNum;
	}

	public int[][] getPlaces() {
		return Places;
	}

	public void setPlaces(int[][] places) {
		Places = places;
	}

	public int getWinnerId() {
		return WinnerId;
	}

	public void setWinnerId(int winnerId) {
		WinnerId = winnerId;
	}

	public ArrayList<Integer> getCurentTurn() {
		return CurentTurn;
	}

	public void setCurentTurn(ArrayList<Integer> curentTurn) {
		CurentTurn = curentTurn;
	}

	public ArrayList<Player> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}

	public ArrayList<Snake> getSnakes() {
		return Snakes;
	}

	public void setSnakes(ArrayList<Snake> snakes) {
		Snakes = snakes;
	}

	public ArrayList<Ladder> getLadders() {
		return Ladders;
	}

	public void setLadders(ArrayList<Ladder> ladders) {
		Ladders = ladders;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public ArrayList<Square> getSquares() {
		return Squares;
	}

	public void setSquares(ArrayList<Square> squares) {
		Squares = squares;
	}
	
	
}
