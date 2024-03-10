package Model;
import Enum.Levels;

public class DiceFactory {
	
	public static Dice createDice(Levels diceLevel) {  // a factory that create a dice according to the level sent by the executer -Yara
		
		switch(diceLevel) {
		case Easy:
			return new EasyDice(diceLevel);
		case Medium:
			return new MidDice(diceLevel);
		case Hard:
			return new HardDice(diceLevel);
		default: 
			return null;

		}
	}
}
