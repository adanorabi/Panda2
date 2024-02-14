package Controller;

import java.util.ArrayList;


import Model.*;

public class SysData {
	static public  ArrayList<Game> gamesList= new ArrayList<Game>(); // array list that contains the games
	static public  ArrayList<Question> questionList= new ArrayList<Question>();
	static public  ArrayList<Question> HardQues= new ArrayList<Question>();
	static public  ArrayList<Question> MidQues= new ArrayList<Question>();
	static public  ArrayList<Question> EasyQues= new ArrayList<Question>();
	public void UploadGames() {  //should be continued!!!
		
	}
<<<<<<< Updated upstream
	public void UploadQuestions() {  //should be continued!!!
		
=======
<<<<<<< HEAD


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
					if(difficulty.equals("1")) { //easy question
						QLevel=Levels.Easy;

						EasyQues.add(new Question(QuestionId++,QLevel,content,Answers,TrueAnswer)); //building an easy question

					} else if(difficulty.equals("2")) { //medium question
						QLevel=Levels.Medium;
						MidQues.add(new Question(QuestionId++,QLevel,content,Answers,TrueAnswer)); //building an easy question

					}
					else { //hard question
						QLevel=Levels.Hard;
						HardQues.add(new Question(QuestionId++,QLevel,content,Answers,TrueAnswer)); //building an easy question

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

=======
	public void UploadQuestions() {  //should be continued!!!
		
>>>>>>> f3b3024f1fbf4c812230c99927b8b15e2a027b9e
>>>>>>> Stashed changes
	}
}
 