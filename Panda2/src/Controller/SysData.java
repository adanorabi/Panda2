package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Enum.Levels;
import Model.*;

public class SysData {
	static public  ArrayList<Game> gamesList= new ArrayList<Game>(); // array list that contains the games
	static public  ArrayList<Question> questionList= new ArrayList<Question>();
	static public  ArrayList<Question> HardQues= new ArrayList<Question>();
	static public  ArrayList<Question> MidQues= new ArrayList<Question>();
	static public  ArrayList<Question> EasyQues= new ArrayList<Question>();
	public void UploadGames() {  //should be continued!!!
		
	}
	
	
	/* int QuestionId;
	 Levels QLevel;
	 String Content;
	 ArrayList<String> Answer;
	 String TrueAnswer;*/
	public static void UploadQuestions() {  //A function that pulling out the questions from json file
		
		
	}
}
 