package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Enum.Levels;
import Model.*;

public class SysData {
	static public  ArrayList<Game> gamesList= new ArrayList<Game>(); // array list that contains the games
	static public  ArrayList<Question> questionList= new ArrayList<Question>(); //arraylist that contains questions from all levels
	static public  ArrayList<Question> HardQues= new ArrayList<Question>();
	static public  ArrayList<Question> MidQues= new ArrayList<Question>();	
	static public  ArrayList<Question> EasyQues= new ArrayList<Question>();
	static public int QuestionId=0;
	public void UploadGames() {  

	}
	Levels QLevel;
	String Content;
	ArrayList<String> Answer;
	String TrueAnswer;
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
					String content = questionObject.getString("question");
					JSONArray answersArray = questionObject.getJSONArray("answers");
					String TrueAnswer = questionObject.getString("correct_ans");
					String difficulty = questionObject.getString("difficulty");
					ArrayList <String> Answers=new   ArrayList <String>();

					// Print question details (or process them as needed)
					System.out.println("Content: " + content);
					System.out.println("Answers:");

					for (int j = 0; j < answersArray.length(); j++) {
						System.out.println((j + 1) + ". " + answersArray.getString(j));
						Answers.add(answersArray.getString(j)); // adding the answers into ArrayList

						System.out.println( Answers); 
					}
					System.out.println("Correct Answer: " + TrueAnswer);
					System.out.println("Difficulty: " + difficulty);
					System.out.println("--------------------");
					Levels QLevel;
					Question q;
					if(difficulty.equals("1")) { //easy question
						QLevel=Levels.Easy;
						q=new Question(QuestionId++,QLevel,content,Answers,TrueAnswer);
						EasyQues.add(q); //building an easy question
						questionList.add(q); //adding a question to the whole questions list

					} else if(difficulty.equals("2")) { //medium question
						QLevel=Levels.Medium;
						q=new Question(QuestionId++,QLevel,content,Answers,TrueAnswer);
						MidQues.add(q); //building an easy question
						questionList.add(q);

					}
					else { //hard question
						QLevel=Levels.Hard;
						q=new Question(QuestionId++,QLevel,content,Answers,TrueAnswer);
						HardQues.add(q); //building an easy question
						questionList.add(q);
					}
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
