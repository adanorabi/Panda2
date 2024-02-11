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
	private ArrayList<Player> Players;
	private ArrayList<Snake> Snakes ;
	private ArrayList<Ladder> Ladders ;
	private ArrayList<Square> Squares ;
	public static int PlayerTurn=0;

	public Game(int gameId, Levels gameLevel, int rowsNum, int colsNum) {
		super();
		this.GameId = gameId;
		this.GameLevel = gameLevel;
		this.RowsNum = rowsNum;
		this.ColsNum = colsNum;
		this.Places=new int[RowsNum][ColsNum];
		//this.CurentTurn= new ArrayList<Integer>() ;
		this.Players= new ArrayList<Player>() ;
		this.Snakes= new ArrayList<Snake>() ;
		this.Ladders= new ArrayList<Ladder>() ;
		this.Squares= new ArrayList<Square>() ;
	}

	public int getGameId() {
		return this.GameId;
	}

	public void setGameId(int gameId) {
		GameId = gameId;
	}

	public Levels getGameLevel() {
		return this.GameLevel;
	}

	public void setGameLevel(Levels gameLevel) {
		GameLevel = gameLevel;
	}

	public int getRowsNum() {
		return this.RowsNum;
	}

	public void setRowsNum(int rowsNum) {
		this.RowsNum = rowsNum;
	}

	public int getColsNum() {
		return this.ColsNum;
	}

	public void setColsNum(int colsNum) {
		this.ColsNum = colsNum;
	}

	public int[][] getPlaces() {
		return this.Places;
	}

	public void setPlaces(int[][] places) {
		Places = places;
	}

	public int getWinnerId() {
		return this.WinnerId;
	}

	public void setWinnerId(int winnerId) {
		this.WinnerId = winnerId;
	}


	public ArrayList<Player> getPlayers() {
		return this.Players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.Players = players;
	}

	public ArrayList<Snake> getSnakes() {
		return this.Snakes;
	}

	public void setSnakes(ArrayList<Snake> snakes) {
		this.Snakes = snakes;
	}

	public ArrayList<Ladder> getLadders() {
		return this.Ladders;
	}

	public void setLadders(ArrayList<Ladder> ladders) {
		this.Ladders = ladders;
	}

	public ArrayList<Square> getSquares() {
		return this.Squares;
	}

	public void setSquares(ArrayList<Square> squares) {
		this.Squares = squares;
	}
	

	public static int getPlayerTurn() {
		return PlayerTurn;
	}

	public static void setPlayerTurn(int playerTurn) {
		PlayerTurn = playerTurn;
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
//			this.Places[redsnake.getXTailNum()][redsnake.getYTailNum()]=5;
			Snakes.add(redsnake);

			Snake yellowsnake=new Snake(SnakeColor.Yellow); 
			yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
			while(this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]!=0) {
				yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
			}
			this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]=4;
			this.Places[yellowsnake.getXTailNum()][yellowsnake.getYTailNum()]=5;
			Snakes.add(yellowsnake);

			Snake greensnake=new Snake(SnakeColor.Green); 
			greensnake.SnackRandom(Levels.Easy, greensnake);
			while(this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]!=0) {
				greensnake.SnackRandom(Levels.Easy, greensnake);
			}
			this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]=4;
			this.Places[greensnake.getXTailNum()][greensnake.getYTailNum()]=5;
			Snakes.add(greensnake);

			Snake Bluesnake=new Snake(SnakeColor.Blue); 
			Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
			while(this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]!=0) {
				Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
			}
			this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]=4;
			this.Places[Bluesnake.getXTailNum()][Bluesnake.getYTailNum()]=5;
			Snakes.add(Bluesnake);

		}
		else if(this.GameLevel.equals(Levels.Medium)) {
			for(int i=0;i<2;i++) {
				Snake redsnake=new Snake(SnakeColor.Red); 
				redsnake.SnackRandom(Levels.Medium, redsnake);
				while(this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]!=0) {
					redsnake.SnackRandom(Levels.Easy, redsnake);
				}
				this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]=4;
//				this.Places[redsnake.getXTailNum()][redsnake.getYTailNum()]=5;
				Snakes.add(redsnake);
			}

			Snake yellowsnake=new Snake(SnakeColor.Yellow); 
			yellowsnake.SnackRandom(Levels.Medium, yellowsnake);
			while(this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]!=0) {
				yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
			}
			this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]=4;
			this.Places[yellowsnake.getXTailNum()][yellowsnake.getYTailNum()]=5;
			Snakes.add(yellowsnake);

			for(int i=0;i<2;i++) {
				Snake greensnake=new Snake(SnakeColor.Green); 
				greensnake.SnackRandom(Levels.Medium, greensnake);
				while(this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]!=0) {
					greensnake.SnackRandom(Levels.Easy, greensnake);
				}
				this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]=4;
				this.Places[greensnake.getXTailNum()][greensnake.getYTailNum()]=5;
				Snakes.add(greensnake);
			}


			Snake Bluesnake=new Snake(SnakeColor.Blue); 
			Bluesnake.SnackRandom(Levels.Medium, Bluesnake);
			while(this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]!=0) {
				Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
			}
			this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]=4;
			this.Places[Bluesnake.getXTailNum()][Bluesnake.getYTailNum()]=5;
			Snakes.add(Bluesnake);
		}
		else if(this.GameLevel.equals(Levels.Hard)) {
			for(int i=0;i<2;i++) {
				Snake redsnake=new Snake(SnakeColor.Red); 
				redsnake.SnackRandom(Levels.Hard, redsnake);
				while(this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]!=0) {
					redsnake.SnackRandom(Levels.Easy, redsnake);
				}
				this.Places[redsnake.getXHeadNum()][redsnake.getYHeadNum()]=4;
//				this.Places[redsnake.getXTailNum()][redsnake.getYTailNum()]=5;
				Snakes.add(redsnake);
			}
			for(int i=0;i<2;i++) {
				Snake yellowsnake=new Snake(SnakeColor.Yellow); 
				yellowsnake.SnackRandom(Levels.Hard, yellowsnake);
				while(this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]!=0) {
					yellowsnake.SnackRandom(Levels.Easy, yellowsnake);
				}	
				this.Places[yellowsnake.getXHeadNum()][yellowsnake.getYHeadNum()]=4;
				this.Places[yellowsnake.getXTailNum()][yellowsnake.getYTailNum()]=5;
				Snakes.add(yellowsnake);
			}

			for(int i=0;i<2;i++) {
				Snake greensnake=new Snake(SnakeColor.Green); 
				greensnake.SnackRandom(Levels.Hard, greensnake);
				while(this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]!=0) {
					greensnake.SnackRandom(Levels.Easy, greensnake);
				}
				this.Places[greensnake.getXHeadNum()][greensnake.getYHeadNum()]=4;
				this.Places[greensnake.getXTailNum()][greensnake.getYTailNum()]=5;
				Snakes.add(greensnake);
			}
			for(int i=0;i<2;i++) {
				Snake Bluesnake=new Snake(SnakeColor.Blue); 
				Bluesnake.SnackRandom(Levels.Hard, Bluesnake);
				while(this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]!=0) {
					Bluesnake.SnackRandom(Levels.Easy, Bluesnake);
				}
				this.Places[Bluesnake.getXHeadNum()][Bluesnake.getYHeadNum()]=4;
				this.Places[Bluesnake.getXTailNum()][Bluesnake.getYTailNum()]=5;
				Snakes.add(Bluesnake);
			}


		}

	}
	public void placeLadders() {
		Boolean flag=true;
		if (this.GameLevel==Levels.Easy) {
			for(int i=0;i<4;i++) {
				Ladder ladder=new Ladder(i+1);
			
				while(flag) {
					ladder.LadderRandom (Levels.Easy, ladder);
					if(this.Places[ladder.getXEnd()][ladder.getYEnd()]==0&&this.Places[ladder.getXStart()][ladder.getYStart()]==0) {
						this.Places[ladder.getXEnd()][ladder.getYEnd()]=6;
						this.Places[ladder.getXStart()][ladder.getYStart()]=7;
						Ladders.add(ladder);
						flag=false;
					}


				}
				flag=true;
			}


		}
		else if(this.GameLevel==Levels.Medium)  {
			for(int i=0;i<6;i++) {
				Ladder ladder=new Ladder(i+1);
			
				while(flag) {
					ladder.LadderRandom (Levels.Medium, ladder);
					if(this.Places[ladder.getXEnd()][ladder.getYEnd()]==0&&this.Places[ladder.getXStart()][ladder.getYStart()]==0) {
						this.Places[ladder.getXEnd()][ladder.getYEnd()]=6;
						this.Places[ladder.getXStart()][ladder.getYStart()]=7;
						flag=false;	
						Ladders.add(ladder);
					}


				}
				flag=true;
			}

		}
		else {
			for(int i=0;i<8;i++) {
				Ladder ladder=new Ladder(i+1);
	
				while(flag) {
					ladder.LadderRandom (Levels.Hard, ladder);
					if(this.Places[ladder.getXEnd()][ladder.getYEnd()]==0&&this.Places[ladder.getXStart()][ladder.getYStart()]==0) {
						this.Places[ladder.getXEnd()][ladder.getYEnd()]=6;
						this.Places[ladder.getXStart()][ladder.getYStart()]=7;
						Ladders.add(ladder);
						flag=false;
					}

				}
				flag=true;
			}
			for (int r =0; r<13; r++) {
				System.out.println("");

				for (int j =0; j<13; j++) {

					System.out.print("(" + r + "," + j + "):" + this.Places[r][j] +" ");
				}

			}
		}
	}


	public Player CurrentTurn() {
		
		if(PlayerTurn==this.getPlayers().size()) {
			PlayerTurn=0;
		}
		return this.getPlayers().get(PlayerTurn++);
		
	}


}
