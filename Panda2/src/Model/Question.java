package Model;

import java.util.ArrayList;

import Enum.Levels;

public class Question {
	private int QuestionId;
	private Levels QLevel;
	private String Content;
	private ArrayList<String> Answer = new ArrayList<String>(); 
	private String TrueAnswer;

}
