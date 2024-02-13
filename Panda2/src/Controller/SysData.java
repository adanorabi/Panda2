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
		try {
	        // Parse the JSON file
	        JSONObject obj = new JSONObject(new JSONTokener(new FileReader("questions_scheme.json")));

	        // Check if the top-level JSON structure contains the "questions" array
	        if (obj.has("questions")) {
	            JSONArray questionsArray = obj.getJSONArray("questions");
	            
	            // Iterate over each question object in the array
	            for (int i = 0; i < questionsArray.length(); i++) {
	                JSONObject questionObject = questionsArray.getJSONObject(i);

	                // Extract values from the question object
	                String question = questionObject.getString("question");
	                JSONArray answersArray = questionObject.getJSONArray("answers");
	                String correctAnswer = questionObject.getString("correct_ans");
	                String difficulty = questionObject.getString("difficulty");

	                // Print question details (or process them as needed)
	                System.out.println("Question: " + question);
	                System.out.println("Answers:");
	                for (int j = 0; j < answersArray.length(); j++) {
	                    System.out.println((j + 1) + ". " + answersArray.getString(j));
	                }
	                System.out.println("Correct Answer: " + correctAnswer);
	                System.out.println("Difficulty: " + difficulty);
	                System.out.println("--------------------");
	            }
	        } else {
	            System.out.println("JSON does not contain 'questions' array.");
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
}
 