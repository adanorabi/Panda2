package Model;
import Enum.Levels;
// A class that extends from Dice and it suitable for easy level game-Yara
public class EasyDice extends Dice{

	public EasyDice(Levels GameLevel) { // a constructor of easy level dice -Yara
		super();
		setNumOfSides(8);
		setDiceOptions(new int[8]);
		for(int i=0; i<5;i++) {
			getDiceOptions()[i]=i;

		}
		getDiceOptions()[5]=7;; //filling the option of easy question
		getDiceOptions()[6]=8;//filling the option of medium  question
		getDiceOptions()[7]=9;//filling the option of hard  question

	}
}
