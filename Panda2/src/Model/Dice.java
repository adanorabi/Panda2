package Model;
import java.util.Random;

//import Controller.SysData;
import Enum.Levels;

public class Dice {
	private int NumOfSides;
	private int diceOptions[] ;

	public int getNumOfSides() {
		return this.NumOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		this.NumOfSides = numOfSides;
	}


	public int[] getDiceOptions() {
		return diceOptions;
	}

	public void setDiceOptions(int[] diceOptions) {
		this.diceOptions = diceOptions;
	}

	public Dice(Levels GameLevel) {
		super();
	
		if (GameLevel==Levels.Easy) {
			this.NumOfSides = 8;
			this.diceOptions=new int[NumOfSides];
			for(int i=0; i<5;i++) {
				this.diceOptions[i]=i;

			}
			this.diceOptions[5]=7; //filling the option of easy question
			this.diceOptions[6]=8; //filling the option of medium  question
			this.diceOptions[7]=9; //filling the option of hard  question

		}
		else if(GameLevel==Levels.Medium) {
			this.NumOfSides =13 ;
			this.diceOptions=new int[NumOfSides];  //filling the places with the number of steps that the player should move
			for(int i=0; i<7;i++) {
				this.diceOptions[i]=i;

			}
			this.diceOptions[7]=7; //filling the option of easy question
			this.diceOptions[8]=7;
			this.diceOptions[9]=8; //filling the option of medium question
			this.diceOptions[10]=8;
			this.diceOptions[11]=9;//filling the option of hard  question
			this.diceOptions[12]=9;
		}
		else {
			this.NumOfSides =15 ;
			this.diceOptions=new int[NumOfSides];
			for(int i=0; i<7;i++) {   //filling the places with the number of steps that the player should move
				this.diceOptions[i]=i;

			}
			this.diceOptions[7]=7; //filling the option of easy question
			this.diceOptions[8]=7;
			this.diceOptions[9]=8;	//filling the option of medium question
			this.diceOptions[10]=8;
			this.diceOptions[11]=9; //filling the option of hard  question
			this.diceOptions[12]=9;
			this.diceOptions[13]=9;
			this.diceOptions[14]=9;

		}

	}
	public Object RollDice() {
		Random random = new Random();
		int options=this.getNumOfSides();
		int RandOption = random.nextInt(options);
		return CheckResult(RandOption); //returning the result of the dice it might be steps number or question
	}
	public Object CheckResult(int diceResult) {
		if(this.diceOptions[diceResult]<7) {
			return diceOptions[diceResult];
		}
		else {
			if (this.diceOptions[diceResult]==7) { // the result is a random easy question 
				Question easyQuestion =Question.CallQuestion(Levels.Easy);
				return easyQuestion;

			}
			else if (this.diceOptions[diceResult]==7) { // the result is a random medium question 
				Question mediumQuestion=Question.CallQuestion(Levels.Medium);
				return mediumQuestion;

			}
			else {			// the result is a random hard question 
				Question hardQuestion=Question.CallQuestion(Levels.Hard);
				return hardQuestion;


			}
		}


	}
	
}
