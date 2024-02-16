package Controller;

import Enum.Levels;
import Model.Board;
import Model.Dice;
import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainF= new MainFrame();
		mainF.setVisible(true);
		SysData.UploadQuestions(); 
		System.out.println(SysData.EasyQues);
		System.out.println(SysData.MidQues);
		System.out.println(SysData.HardQues);
		Board board=new Board(7);  //yara!
		System.out.println(board);
		//System.out.println("The position of the second coordinate is : "+board.getPosition(1, 0));
		//System.out.println("The coordinates of the last is : "+board.getCoordinates(49));
		int size=7;
		 System.out.println("Testing getPosition method:");
	        for (int row = 0; row < size; row++) {
	            for (int col = 0; col < size; col++) {
	                int position = board.getPosition(col, row);
	                System.out.println("Position at (" + col + ", " + row + "): " + position);
	            }
	        }

	        // Test getCoordinates method
	        System.out.println("\nTesting getCoordinates method:");
	        for (int i = 1; i <= size * size; i++) {
	            int[] coordinates = board.getCoordinates(i);
	            System.out.println("Value: " + i + ", Coordinates: (" + coordinates[0] + ", " + coordinates[1] + ")");
	        }
	        Dice d=new Dice(Levels.Hard);
	    System.out.println("--------------------------Rolling Dice-------------------------");
	    for(int j=0;j<9;j++) {
	    	System.out.println("dice option: "+	d.RollDice());
	    }
	    
	}

}
