package Model;

import java.util.ArrayList;
import java.util.Random;

import Enum.Levels;
import Enum.SnakeColor;

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
	
	public void createGame() {


		// Initialize board with empty Places
		for (int i = 0; i < this.RowsNum; i++) {
			for (int j = 0; j < this.ColsNum; j++) {
				this.Places[i][j] = 0; // 0 represents an empty place		
				//	System.out.println(	this.Places[i][j]);
			}
		}

	}
	public void PlacespecialSquares(Levels gameLevel) { //should be continueed have to check that snake and ladder not in the same place
		int randQol;
		int randRow;
		Random random = new Random();
		Boolean flag=true;
		Levels leverArr[]=new Levels[3];
		leverArr[0]=Levels.Easy;
		leverArr[1]=Levels.Medium;
		leverArr[2]=Levels.Hard;
		if(gameLevel==Levels.Easy) {
			for(int i=0;i<3;i++) {//adding a questionSquare to the game board
				flag=true;
				while(flag) {
					randQol = random.nextInt(ColsNum) ;
					randRow = random.nextInt(RowsNum) ;
					if(this.Places[randRow][randQol]==0) {
						while(randQol==0 && randRow==0 || randQol==6 && randRow==6) {
							randRow = random.nextInt(RowsNum);
						}
						this.Places[randRow][randQol]=3;
						flag=false;
						Squares.add(new QuestionSquare(randRow,randQol,leverArr[i]));
					}

				}
			}

		}

		else if(gameLevel== Levels.Medium) {
			for(int i=0;i<3;i++) {//adding a questionSquare to the game board
				flag=true;
				while(flag) {

					randQol = random.nextInt(ColsNum) ;
					randRow = random.nextInt(RowsNum) ;
					if(this.Places[randRow][randQol]==0) {
						while(randQol==0 && randRow==0 || randQol==9 && randRow==9) {
							randRow = random.nextInt(RowsNum);
						}
						this.Places[randRow][randQol]=3;
						flag=false;
						Squares.add(new QuestionSquare(randRow,randQol,leverArr[i]));
					}

				}
			}
			flag=true;
			while(flag) {
				randQol = random.nextInt(ColsNum) ;
				randRow = random.nextInt(RowsNum);
				if(this.Places[randRow][randQol]==0) {
					while(randQol==0 && randRow==0 || randQol==9 && randRow==9) {
						randRow = random.nextInt(RowsNum);
					}
					this.Places[randRow][randQol]=2;
					Squares.add(new SurpriseSquare(randRow,randQol));
					flag=false;
				}

			}


		}
		else {
			for(int i=0;i<3;i++) {//adding a questionSquare to the game board
				flag=true;
				while(flag) {

					randQol = random.nextInt(ColsNum) ;
					randRow = random.nextInt(RowsNum) ;
					if(this.Places[randRow][randQol]==0) {
						while(randQol==0 && randRow==0 || randQol==12 && randRow==12) {
							randRow = random.nextInt(RowsNum);
						}
						this.Places[randRow][randQol]=3;
						flag=false;
						Squares.add(new QuestionSquare(randRow,randQol,leverArr[i]));
					}

				}
			}

			flag=true;
			for(int i=0;i<2;i++) {
				flag=true;
				while(flag) {
					randQol = random.nextInt(ColsNum) ;
					randRow = random.nextInt(RowsNum);
					if(this.Places[randRow][randQol]==0) {
						while(randQol==0 && randRow==0 || randQol==12 && randRow==12) {
							randRow = random.nextInt(RowsNum);
						}
						this.Places[randRow][randQol]=2;
						Squares.add(new SurpriseSquare(randRow,randQol));
						flag=false;
					}

				}
			}
		}
	}
	
	public void placeNormalSquares() {

		int i,j;
		for(i=0;i<this.RowsNum;i++) {
			for(j=0;j<this.RowsNum;j++) {
				if(this.Places[i][j]==0) {
					Squares.add(new Square(i,j)) ; 
				}
			}
		}

	}
	
	public void PlaceSnakes() {
		if(this.GameLevel.equals(Levels.Easy)) {
			Snake redsnake=new Snake(SnakeColor.Red); 
			redsnake.SnackRandom(Levels.Easy, redsnake);
			while(this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]!=0) {
				redsnake.SnackRandom(Levels.Easy, redsnake);
			}
			this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]=4;
			this.Places[redsnake.getXTailNum()][redsnake.getYTailNum()]=4;
			Snakes.add(redsnake);

			Snake yellowsnake=new Snake(SnakeColor.Yellow); 
			yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
			while(this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]!=0) {
				yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
			}
			this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]=4;
			this.Places[yellowsnake.getXTailNum()][yellowsnake.getYTailNum()]=4;
			Snakes.add(yellowsnake);

			Snake greensnake=new Snake(SnakeColor.Green); 
			greensnake.SnackRandom(Levels.Easy, greensnake);
			while(this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]!=0) {
				greensnake.SnackRandom(Levels.Easy, greensnake);
			}
			this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]=4;
			this.Places[greensnake.getXTailNum()][greensnake.getYTailNum()]=4;
			Snakes.add(greensnake);

			Snake Bluesnake=new Snake(SnakeColor.Blue); 
			Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
			while(this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]!=0) {
				Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
			}
			this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]=4;
			this.Places[Bluesnake.getXTailNum()][Bluesnake.getYTailNum()]=4;
			Snakes.add(Bluesnake);

		}
	}

}
