package Model;

import java.util.Random;

import Enum.Levels;

public class Ladder {


	private int Length;
	private int XStart;
	private int YStart;
	private int XEnd;
	private int YEnd;
	Random rand = new Random();

	public Ladder(int length) {
		super();
		Length = length;
	}

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public int getXStart() {
		return XStart;
	}

	public void setXStart(int xStart) {
		XStart = xStart;
	}

	public int getYStart() {
		return YStart;
	}

	public void setYStart(int yStart) {
		YStart = yStart;
	}

	public int getXEnd() {
		return XEnd;
	}

	public void setXEnd(int xEnd) {
		XEnd = xEnd;
	}

	public int getYEnd() {
		return YEnd;
	}

	public void setYEnd(int yEnd) {
		YEnd = yEnd;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	public void LadderRandom (Levels level, Ladder ladder) {

		if (level.equals(Levels.Easy)) {
			if (ladder.Length==1) {

				int Endx = rand.nextInt(7);
				int Endy = 1+rand.nextInt(6);
				while(Endy==1 && Endx==0) {
					Endy = 1+rand.nextInt(6);
				}

				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-1);

				ladder.setXStart(Endx);
			}
			else if (ladder.Length==2) {
				
				int Endx = rand.nextInt(7);
				int Endy = 2+rand.nextInt(5);
				while(Endy==2 && Endx==0) {
					Endy = 2+rand.nextInt(5);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-2);

				ladder.setXStart(Endx);
			}
			else if (ladder.Length==3) {
				int Endx = rand.nextInt(5);
				int Endy = 3+rand.nextInt(4);
				while(Endy==3 && Endx==0) {
					Endy = 3+rand.nextInt(4);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-3);
				int Startx;

					Startx=Endx+2;
				
				ladder.setXStart(Startx);

			}
			else if (ladder.Length==4) {
				
				
				int Endx = rand.nextInt(7);
				int Endy = 4+rand.nextInt(3);
				while(Endy==4 && Endx==0) {
					 Endy = 4+rand.nextInt(3);
				}

				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-4);

				ladder.setXStart(Endx);


			}
		}
		else if (level.equals(Levels.Medium)) {
			if (ladder.Length==1) {

				int Endx = rand.nextInt(10);
				int Endy = 1+rand.nextInt(9);
				while(Endy==1 && Endx==0) {
					Endy = 1+rand.nextInt(9);
				}

				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-1);

				ladder.setXStart(Endx);
			}
			else if (ladder.Length==2) {

				int Endx = rand.nextInt(10);
				int Endy = 2+rand.nextInt(8);
				while(Endy==2 && Endx==0) {
					Endy = 2+rand.nextInt(8);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-2);

				ladder.setXStart(Endx);
			}
			else if (ladder.Length==3) {
				int Endx = rand.nextInt(8);
				int Endy = 3+rand.nextInt(7);
				while(Endy==3 && Endx==0) {
					Endy = 3+rand.nextInt(7);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-3);
				int Startx;

					Startx=Endx+2;

				ladder.setXStart(Startx);

			}
			else if (ladder.Length==4) {

				int Endx = rand.nextInt(10);
				int Endy = 4+rand.nextInt(6);
				while(Endy==4 && Endx==0) {
					 Endy = 4+rand.nextInt(6);
				}

				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-4);

				ladder.setXStart(Endx);


			}
			else if(ladder.Length==5) {
				
				int Endx = rand.nextInt(9);
				int Endy = 5+rand.nextInt(5);
				while(Endy==5 && Endx==0) {
					Endy = 5+rand.nextInt(5);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-5);
				int Startx;

					Startx=Endx+1;

				ladder.setXStart(Startx);
				

			}
			else if(ladder.Length==6) {
				int Endx = rand.nextInt(8);
				int Endy = 6+rand.nextInt(4);
				while(Endy==6 && Endx==0) {
					Endy = 6+rand.nextInt(4);
				}
				ladder.setXEnd(Endx);
				ladder.setYEnd(Endy);

				int y=Endy;

				ladder.setYStart(y-6);
				int Startx;
					Startx=Endx+2;
				
				ladder.setXStart(Startx);
			}

		}
	}
}
