package Model;

import java.util.Random;

public class SurpriseSquare extends Square {
	
	public static int counter=1;
	private int SurpSquareId;

	public SurpriseSquare( int squareRow, int squareCol) {
		super(squareRow, squareCol);
		// TODO Auto-generated constructor stub
		this.SurpSquareId=this.counter++;
	}
	
	
	public int getSurpSquareId() {
		return SurpSquareId;
	}

	public void setSurpSquareId(int surpSquareId) {
		SurpSquareId = surpSquareId;
	}



	public int RandSurprise() { //should be continued!!!

		double randomNum = Math.random(); // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)


		Random random = new Random();

		// Generate a random integer between 0 and 1
		int randomNumber = random.nextInt(2); // Generates a random integer between 0 (inclusive) and 2 (exclusive)

		// Map 0 to option 1 and 1 to option 2
		int option = randomNumber == 0 ? 1 : 0;

		if (option == 0) {
			return -10;
		}
		else {
			return 10;
		}



	}


}
