package Model;

public class Dice {
	private int NumOfSides;

	public int getNumOfSides() {
		return NumOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		NumOfSides = numOfSides;
	}

	public Dice(int numOfSides) {
		super();
		NumOfSides = numOfSides;
	}
}
