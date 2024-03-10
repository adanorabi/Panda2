package Model;

import java.util.Random;

import Enum.Levels;
import Enum.SnakeColor;
//-------------------------------------Yomna-----------------------------------
public class Snake extends MovePlayerTemplate {

	private SnakeColor Color;

	private int XHeadNum;// the x coordinate for the Snake Head
	private int YHeadNum;// the y coordinate for the Snake Tail
	private int XTailNum;// the x coordinate for the Snake Head
	private int YTailNum;// the y coordinate for the Sanke Tail
	Random rand = new Random();
	public static int counter=6;// the ladders id start from number 6 so we can recognize that the item in the board is a ladder
	private int SnakeId;
// constructor
	public Snake(SnakeColor color) {
		super();
		Color = color;
		this.SnakeId=this.counter++;
	}

	
//getters and setters	
	public int getSnakeId() {
		return SnakeId;
	}

	public void setSnakeId(int snakeId) {
		SnakeId = snakeId;
	}

	public SnakeColor getColor() {
		return Color;
	}

	public void setColor(SnakeColor color) {
		Color = color;
	}

	public int getXHeadNum() {
		return XHeadNum;
	}

	public void setXHeadNum(int xHeadNum) {
		XHeadNum = xHeadNum;
	}

	public int getYHeadNum() {
		return YHeadNum;
	}

	public void setYHeadNum(int yHeadNum) {
		YHeadNum = yHeadNum;
	}

	public int getXTailNum() {
		return XTailNum;
	}

	public void setXTailNum(int xTailNum) {
		XTailNum = xTailNum;
	}

	public int getYTailNum() {
		return YTailNum;
	}

	public void setYTailNum(int yTailNum) {
		YTailNum = yTailNum;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	
//	SnakeRandom function decides the coordinate of the Head and the Tail of the Snake by taking random number for them
//	the random has constrains for example: the Snake did not take a place outside the gameboard
//	and also make the random for the y coordinate so it always be the H"thecolorodthesnake"y-T"thecolorodthesnake"y= the length of the snake
//	it receive the level of the game so it can decide the number and the types of the snakes
//	and it receive the snake itself
	public void SnackRandom (Levels level, Snake snake) {

		if (level.equals(Levels.Easy)) {
			if (snake.Color.equals(SnakeColor.Blue)) {

				int HBluex = rand.nextInt(7);
				int HBluey = 3+rand.nextInt(4);
				while(HBluex==6 && HBluey==6) {
					HBluey = 3+rand.nextInt(4);
				}
				snake.setXHeadNum(HBluex);
				snake.setYHeadNum(HBluey);

				int y=HBluey;

				snake.setYTailNum(y-3);
				snake.setXTailNum(HBluex);
			}
			else if (snake.Color.equals(SnakeColor.Green)) {

				int HGreenx = rand.nextInt(7);
				int HGreeny = 2+rand.nextInt(5);
				while(HGreenx==6 && HGreeny==6 ) {
					HGreeny = 2+rand.nextInt(5);
				}
				snake.setXHeadNum(HGreenx);
				snake.setYHeadNum(HGreeny);

				int y=HGreeny;

				snake.setYTailNum(y-2);
				int TGreenx = rand.nextInt(7);
				while(HGreenx>TGreenx) {
					TGreenx = rand.nextInt(7);
				}
				snake.setXTailNum(TGreenx);
			}
			else if (snake.Color.equals(SnakeColor.Red)) {
				int redx = rand.nextInt(7);
				int redy = rand.nextInt(7);
				while((redx==6 && redy==6) || (redx==0 && redy==0)) {
					redy = rand.nextInt(7);
				}
				snake.setXHeadNum(redx);
				snake.setXTailNum(0);
				snake.setYHeadNum(redy);
				snake.setYTailNum(0);

			}
			else if (snake.Color.equals(SnakeColor.Yellow)) {

				int Hyellowx = rand.nextInt(7);
				int Hyellowy = 1+rand.nextInt(6);
				while(Hyellowx==6 && Hyellowy==6) {
					Hyellowy = 1+rand.nextInt(6);
				}
				snake.setXHeadNum(Hyellowx);
				snake.setYHeadNum(Hyellowy);

				int y=Hyellowy;

				snake.setYTailNum(y-1);
				int Tyellowx = rand.nextInt(7);
				while(Hyellowx>Tyellowx) {
					Tyellowx = rand.nextInt(7);
				}
				snake.setXTailNum(Tyellowx);


			}
		}
		else if (level.equals(Levels.Medium)) {
			if (snake.Color.equals(SnakeColor.Blue)) {

				int HBluex = rand.nextInt(10);
				int HBluey = 3+rand.nextInt(7);
				while(HBluex==9 && HBluey==9) {
					HBluey = 3+rand.nextInt(7);
				}
				snake.setXHeadNum(HBluex);
				snake.setYHeadNum(HBluey);

				int y=HBluey;

				snake.setYTailNum(y-3);
				snake.setXTailNum(HBluex);
			}
			else if (snake.Color.equals(SnakeColor.Green)) {

				int HGreenx = rand.nextInt(10);
				int HGreeny = 2+rand.nextInt(8);
				while(HGreenx==9 && HGreeny==9) {
					HGreeny = 2+rand.nextInt(8);
				}
				snake.setXHeadNum(HGreenx);
				snake.setYHeadNum(HGreeny);

				int y=HGreeny;

				snake.setYTailNum(y-2);
				int TGreenx = rand.nextInt(10);
				while(HGreenx>TGreenx) {
					TGreenx = rand.nextInt(10);
				}
				snake.setXTailNum(TGreenx);
			}
			else if (snake.Color.equals(SnakeColor.Red)) {
				int redx = rand.nextInt(10);
				int redy = rand.nextInt(10);
				while((redx==9 && redy==9) || (redx==0 && redy==0)) {
					redy = rand.nextInt(10);
				}
				snake.setXHeadNum(redx);
				snake.setXTailNum(0);
				snake.setYHeadNum(redy);
				snake.setYTailNum(0);

			}
			else if (snake.Color.equals(SnakeColor.Yellow)) {

				int Hyellowx = rand.nextInt(10);
				int Hyellowy = 1+rand.nextInt(9);
				while(Hyellowx==9 && Hyellowy==9) {
					Hyellowy = 1+rand.nextInt(9);
				}
				snake.setXHeadNum(Hyellowx);
				snake.setYHeadNum(Hyellowy);

				int y=Hyellowy;

				snake.setYTailNum(y-1);
				int Tyellowx = rand.nextInt(10);
				while(Hyellowx>Tyellowx) {
					Tyellowx = rand.nextInt(10);
				}
				snake.setXTailNum(Tyellowx);


			}

		}
		else if (level.equals(Levels.Hard)) {

			if (snake.Color.equals(SnakeColor.Blue)) {

				int HBluex = rand.nextInt(13);
				int HBluey = 3+rand.nextInt(10);
				while(HBluex==12 && HBluey==12) {
					HBluey = 3+rand.nextInt(10);
				}
				snake.setXHeadNum(HBluex);
				snake.setYHeadNum(HBluey);

				int y=HBluey;

				snake.setYTailNum(y-3);
				snake.setXTailNum(HBluex);
			}
			else if (snake.Color.equals(SnakeColor.Green)) {

				int HGreenx = rand.nextInt(13);
				int HGreeny = 2+rand.nextInt(11);
				while(HGreenx==12 && HGreeny==12) {
					HGreeny = 2+rand.nextInt(11);
				}
				snake.setXHeadNum(HGreenx);
				snake.setYHeadNum(HGreeny);

				int y=HGreeny;

				snake.setYTailNum(y-2);
				int TGreenx = rand.nextInt(13);
				while(HGreenx>TGreenx) {
					TGreenx = rand.nextInt(13);
				}
				snake.setXTailNum(TGreenx);
			}
			else if (snake.Color.equals(SnakeColor.Red)) {
				int redx = rand.nextInt(13);
				int redy = rand.nextInt(13);
				while((redx==12 && redy==12) || (redx==0 && redy==0)) {
					redy = rand.nextInt(13);
				}
				snake.setXHeadNum(redx);
				snake.setXTailNum(0);
				snake.setYHeadNum(redy);
				snake.setYTailNum(0);

			}
			else if (snake.Color.equals(SnakeColor.Yellow)) {

				int Hyellowx = rand.nextInt(13);
				int Hyellowy = 1+rand.nextInt(12);
				while(Hyellowx==12 && Hyellowy==12) {
					Hyellowy = 1+rand.nextInt(12);
				}
				snake.setXHeadNum(Hyellowx);
				snake.setYHeadNum(Hyellowy);

				int y=Hyellowy;

				snake.setYTailNum(y-1);
				int Tyellowx = rand.nextInt(13);
				while(Hyellowx>Tyellowx) {
					Tyellowx = rand.nextInt(13);
				}
				snake.setXTailNum(Tyellowx);


			}
		}
	}
	
//	MovePlayer function in this function it takes the coordinate of the player and checks if he stand on Snake head,
//	then he move him down to the Snake tail (change his coordinate to be the same as the Snake tail)
	 @Override
	 public int[] MovePlayer (int playerX, int playerY) {
		 int XYTail[]=new int[2];
			
			if(this.getXHeadNum()==playerX && this.getYHeadNum()==playerY) {
				

				XYTail[0]=this.getXTailNum();
				XYTail[1]=this.getYTailNum();
			}
			return XYTail;
		 
	 }
	


}
