package Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Enum.Levels;
import Model.Board;
import Model.Dice;
import Model.Game;
import Model.Question;
import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainF= new MainFrame();
		mainF.setVisible(true);
		
		SysData.UploadQuestions(); 
<<<<<<< HEAD
=======
		System.out.println(SysData.EasyQues);
		System.out.println(SysData.MidQues);
		System.out.println(SysData.HardQues);
		Board board=new Board(10);  //yara!
		System.out.println(board);
		//System.out.println("The position of the second coordinate is : "+board.getPosition(1, 0));
		//System.out.println("The coordinates of the last is : "+board.getCoordinates(49));
		int size=10;
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
	    System.out.println("/n");
	    System.out.println("/n");
	    System.out.println("/n");
	    System.out.println("Iteration 3: lets check the json "); //yara!
//	    Levels QLevel=Levels.Easy;
//		String Content="How are you";
//		ArrayList<String> Answer=new ArrayList<>();
//		Answer.add("good");
//		Answer.add("fine");
//		Answer.add("bad");
//		Answer.add("so bad");
//		String TrueAnswer="bad";
//		Question q=new Question(SysData.QuestionId++,QLevel,Content,Answer,TrueAnswer);
//	   SysData.appendQuestionToJson(q);
	    

	    
	}
>>>>>>> e0488d2637db8d6f4f9093e6e93018e3cf8d83e0
	
		Levels QLevel=Levels.Easy;
		String Content="What is a characteristic of Scrum methodology?";
		ArrayList<String> Answer=new ArrayList<>();
		Answer.add("good");
		Answer.add("fine");
		Answer.add("bad");
		Answer.add("so bad");
		String TrueAnswer="bad";
		Question q1=new Question(SysData.QuestionId++,QLevel,Content,Answer,TrueAnswer);
	
		Question q2=new Question(SysData.QuestionId++,Levels.Hard,"We Can Do This?",Answer,TrueAnswer);
		//SysData. AddQuestioToJson(q1);
	
		Question[] questions;
		questions=new Question[2];
		questions[0]=q1;
		questions[1]=q2;
		SysData.editQuestion(questions);
	//SysData.DeleteQuestioFromJson("What does MVC stand for in the context of software architecture?");
	}
}


//Board board=new Board(10);  //yara!
//System.out.println(board);
//System.out.println("The position of the second coordinate is : "+board.getPosition(1, 0));
//System.out.println("The coordinates of the last is : "+board.getCoordinates(49));
//int size=10;
// System.out.println("Testing getPosition method:");
//    for (int row = 0; row < size; row++) {
//        for (int col = 0; col < size; col++) {
//            int position = board.getPosition(col, row);
//            System.out.println("Position at (" + col + ", " + row + "): " + position);
//        }
//    }

// Test getCoordinates method
//    System.out.println("\nTesting getCoordinates method:");
//    for (int i = 1; i <= size * size; i++) {
//        int[] coordinates = board.getCoordinates(i);
//        System.out.println("Value: " + i + ", Coordinates: (" + coordinates[0] + ", " + coordinates[1] + ")");
//    }
// Dice d=new Dice(Levels.Hard);
//System.out.println("--------------------------Rolling Dice-------------------------");
//for(int j=0;j<9;j++) {
//	System.out.println("dice option: "+	d.RollDice());
//}
//System.out.println("\n");
//System.out.println("\n");
//System.out.println("\n");
//System.out.println("\n");
//System.out.println("\n");
//System.out.println("\n");
//System.out.println(SysData.EasyQues);
//System.out.println("\n");
//System.out.println("\n");
//
//System.out.println(SysData.MidQues);
//System.out.println("\n");
//System.out.println("\n");
//System.out.println(SysData.HardQues);