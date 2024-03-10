package Model;
import java.util.Random;

//import Controller.SysData;
import Enum.Levels;
//Dice class that contains dice attribute and it the parent class of EasyDice and MidDice and HardDice -Yara
public class Dice {
	private int NumOfSides;
	private int diceOptions[] ;
	//getters and setters -Yara
	public int getNumOfSides() {
		return this.NumOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		this.NumOfSides = numOfSides;
	}

	public int[] getDiceOptions() {
		return this.diceOptions;
	}

	public void setDiceOptions(int[] diceOptions) {
		this.diceOptions = diceOptions;
	}

	public Object RollDice() {  //Roll Dice a function that roll a dice and choose random object according to dice size-Yara
		Random random = new Random();
		int options=this.getNumOfSides();
		int RandOption = random.nextInt(options);
		return CheckResult(RandOption); //returning the result of the dice it might be steps number or question-Yara
	}

	public Object CheckResult(int diceResult) {  // a function that accept the dice result and return number or question according to the result -Yara
		if(this.diceOptions[diceResult]<7) {
			return diceOptions[diceResult];
		}
		else {
			if (this.diceOptions[diceResult]==7) { // the result is a random easy question -Yara
				Question easyQuestion =Question.CallQuestion(Levels.Easy);
				return easyQuestion;

			}
			else if (this.diceOptions[diceResult]==8) { // the result is a random medium question 
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
