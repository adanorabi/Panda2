package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Enum.Levels;
import Model.Question;

public class JsonObserver {
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

					for (int j = 0; j < answersArray.length(); j++) {

						Answers.add(answersArray.getString(j)); // adding the answers into ArrayList
					}
					Levels QLevel;
					Question q;
					if(difficulty.equals("1")) { //easy question
						QLevel=Levels.Easy;
						q=new Question(SysData.QuestionId++,QLevel,content,Answers,TrueAnswer);
						SysData.EasyQues.add(q); //building an easy question
						SysData.questionList.add(q); //adding a question to the whole questions list

					} else if(difficulty.equals("2")) { //medium question
						QLevel=Levels.Medium;
						q=new Question(SysData.QuestionId++,QLevel,content,Answers,TrueAnswer);
						SysData.MidQues.add(q); //building an easy question
						SysData.questionList.add(q);

					}
					else { //hard question
						QLevel=Levels.Hard;
						q=new Question(SysData.QuestionId++,QLevel,content,Answers,TrueAnswer);
						SysData.HardQues.add(q); //building an easy question
						SysData.questionList.add(q);
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

	public static void AddQuestioToJson(Question newQuestion) {
		// Print a message indicating successful deletion of a question
		System.out.println("question added successfully");

		try {
			// Read existing JSON content from the file
			JSONObject jsonObject;
			try (FileReader fileReader = new FileReader("questions_scheme.json")) {
				jsonObject = new JSONObject(new JSONTokener(fileReader));
			}

			// Retrieve the "questions" array from the JSON content
			JSONArray jsonArray;
			if (jsonObject.has("questions")) {
				jsonArray = jsonObject.getJSONArray("questions");
			} else {
				jsonArray = new JSONArray();
			}

			// Construct JSON object for the new question
			JSONObject questionObj = new JSONObject();
			questionObj.put("question", newQuestion.getContent());
			questionObj.put("answers", new JSONArray(newQuestion.getAnswer()));
			questionObj.put("correct_ans", newQuestion.getTrueAnswer());

			// Add the difficulty property to the question object
			questionObj.put("difficulty", newQuestion.getQLevel().equals(Levels.Easy) ? "1" : newQuestion.getQLevel().equals(Levels.Medium) ? "2" : "3");

			// Add the question object to the jsonArray
			jsonArray.put(questionObj);

			// Write the updated JSON content back to the file
			try (FileWriter writer = new FileWriter("questions_scheme.json")) {
				JSONObject outputObject = new JSONObject();
				outputObject.put("questions", jsonArray);
				writer.write(outputObject.toString(4)); // Indent with 4 spaces for readability
				System.out.println("Question appended to JSON file successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void DeleteQuestioFromJson(String content) {
		try {
			JSONObject jsonObject;
			try (FileReader fileReader = new FileReader("questions_scheme.json")) {
				jsonObject = new JSONObject(new JSONTokener(fileReader));
			}

			JSONArray jsonArray;
			if (jsonObject.has("questions")) {
				jsonArray = jsonObject.getJSONArray("questions");
			} else {
				jsonArray = new JSONArray();
			}

			// List to store indices of questions to remove
			List<Integer> indicesToRemove = new ArrayList<>();

			// Identify questions with matching content and store their indices
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject questionObj = jsonArray.getJSONObject(i);
				if (questionObj.getString("question").equals(content)) {
					indicesToRemove.add(i);
				}
			}

			// Remove questions from the JSON array
			for (int i = indicesToRemove.size() - 1; i >= 0; i--) {
				jsonArray.remove(indicesToRemove.get(i));
			}

			try (FileWriter writer = new FileWriter("questions_scheme.json")) {
				JSONObject outputObject = new JSONObject();
				outputObject.put("questions", jsonArray);
				writer.write(outputObject.toString(4));
				System.out.println("Question deleted from JSON file successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void editQuestion(Question questions[]) {
		UploadQuestions();
		Question oldQuestion=questions[0];
		Question newQuestion=questions[1];
		for(int i=0;i<SysData.questionList.size();i++) {
			if(SysData.questionList.get(i).getContent().equals(oldQuestion.getContent())) {
				DeleteQuestioFromJson(SysData.questionList.get(i).getContent());
				AddQuestioToJson(newQuestion);
				break;
			}
		}
	}


}
