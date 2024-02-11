package Model;

import Enum.Levels;

public class Dice {
	private int NumOfSides;

	public int getNumOfSides() {
		return NumOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		NumOfSides = numOfSides;
	}

	public Dice(Levels GameLevel) {
		super();
		if (GameLevel==Levels.Easy) {
			this.NumOfSides = 8;
		}
		else if(GameLevel==Levels.Medium) {
					this.NumOfSides =13 ;
		}
		else {
			this.NumOfSides =15 ;
			
		}

	}
	
}
