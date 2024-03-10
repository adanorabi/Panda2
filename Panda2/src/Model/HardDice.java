package Model;
import Enum.Levels;
//A class that extends from Dice and it suitable for hard level game-Yara

public class HardDice extends Dice{
	public HardDice(Levels GameLevel) {//a constructor of hard level dice -Yara

		super();
		setNumOfSides(15);
		setDiceOptions(new int[15]);

		for(int i=0; i<7;i++) {
			getDiceOptions()[i]=i;
		}
		getDiceOptions()[7]=7;; //filling the option of easy question
		getDiceOptions()[8]=7;; //filling the option of easy question
		getDiceOptions()[9]=8;//filling the option of medium  question
		getDiceOptions()[10]=8;//filling the option of medium  question
		getDiceOptions()[11]=9;//filling the option of hard  question
		getDiceOptions()[12]=9;//filling the option of hard  question
		getDiceOptions()[13]=9;//filling the option of hard  question
		getDiceOptions()[14]=9;//filling the option of hard  question

	}
}
