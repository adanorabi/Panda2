package Model;

import Enum.Levels;

public class MidDice extends Dice {
	public MidDice(Levels GameLevel) {

		super();
		setNumOfSides(13);
		setDiceOptions(new int[13]);

		for(int i=0; i<7;i++) {
			getDiceOptions()[i]=i;

		}
		getDiceOptions()[7]=7;; //filling the option of easy question
		getDiceOptions()[8]=7;; //filling the option of easy question
		getDiceOptions()[9]=8;//filling the option of medium  question
		getDiceOptions()[10]=8;//filling the option of medium  question
		getDiceOptions()[11]=9;//filling the option of hard  question
		getDiceOptions()[12]=9;//filling the option of hard  question

	}
}

