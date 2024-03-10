package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.json.JSONTokener;


import Enum.Levels;
import Enum.PlayerColor;
import Model.*;

public class SysData {
	static public  ArrayList<Game> gamesList= new ArrayList<Game>(); // array list that contains the games
	static public  ArrayList<Question> questionList= new ArrayList<Question>(); //arraylist that contains questions from all levels-Yara
	static public  ArrayList<Question> HardQues= new ArrayList<Question>();//arraylist that contains questions hard levels-Yara
	static public  ArrayList<Question> MidQues= new ArrayList<Question>();	//arraylist that contains questions medium levels-Yara
	static public  ArrayList<Question> EasyQues= new ArrayList<Question>();//arraylist that contains questions easy levels-Yara
	static public  ArrayList<Player> winnerPlayer= new ArrayList<Player>();
	static public int QuestionId=0;
	Levels QLevel;
	String Content;

	ArrayList<String> Answer;
	String TrueAnswer;

	public static void UploadQuestions() {  //A function that pulling out the questions from json file by reading them and saving them in arraylists-Yara

		try {
			HardQues.clear();
			MidQues.clear();
			EasyQues.clear();
			questionList.clear();
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

	public static void AddQuestioToJson(Question newQuestion) { // adding new question to json file -Yara
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
		UploadQuestions();
	}

	public static void DeleteQuestioFromJson(String content) { //Deleting a question fro json file and updating it -Yara
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
		UploadQuestions();
	}

	public static void editQuestion(Question questions[]) { // function that receive json array of old and new question and update question in json -Yara
		UploadQuestions();
		System.out.println("Editing!!!!!!!!!!!!!!!");
		Question oldQuestion=questions[0];
		Question newQuestion=questions[1];
		if(oldQuestion.getQLevel().equals(Levels.Easy)) {
			for(int i=0;i<EasyQues.size();i++) {
				if(EasyQues.get(i).getContent().equals(oldQuestion.getContent())) {
					DeleteQuestioFromJson(EasyQues.get(i).getContent());
					AddQuestioToJson(newQuestion);
					break;
				}
			}
		}
		else if(oldQuestion.getQLevel().equals(Levels.Medium))
		{
			for(int i=0;i<MidQues.size();i++) {
				if(MidQues.get(i).getContent().equals(oldQuestion.getContent())) {
					DeleteQuestioFromJson(MidQues.get(i).getContent());
					AddQuestioToJson(newQuestion);
					break;
				}
			}
		}

		else{
			for(int i=0;i<HardQues.size();i++) {
				if(HardQues.get(i).getContent().equals(oldQuestion.getContent())) {
					DeleteQuestioFromJson(HardQues.get(i).getContent());
					AddQuestioToJson(newQuestion);
					break;

				}

			}
		}

		UploadQuestions();

	}
//----------------------------Yomna-----------------------------
//	AddGame this function receive the game that we want to add to the Exel file that have all the game history
	
	public static void AddGame(Game g) {
// read AllGames.csv exel file
		String filePath = "AllGames.csv";

		System.out.println("starting write user.csv file: " + filePath);
//		call writeCsv function and send for it the file and the game 
		writeCsv(filePath,g);


	}

// writeCsv function receive the filepath of the exel file that have the history of the games
//	and receive the the game that we need to add it to the file
//	this function add the history of the game that it received and add it to the exel file
	public static void writeCsv(String filePath,Game g) {


		FileWriter fileWriter = null;
		try {

			fileWriter = new FileWriter(filePath,true);
			System.out.println(g);
//			add the game id to the file
			fileWriter.append(String.valueOf(g.getGameId()));
			fileWriter.append(",");
//			add the game level to the exel file
			fileWriter.append(String.valueOf(g.getGameLevel()));
			fileWriter.append(",");
//			run over the players arraylist that have the game
			for(Player p: g.getPlayers()) {
//				checkes if the getWinnerId of the game is the same as the playerid that in the arraylist
				if(p.getPlayerID()==g.getWinnerId()) {
//					add the nickname of the winner player to the exel file 
					fileWriter.append(String.valueOf(p.getNickName()));
					fileWriter.append(",");
//					add the playercolor of the winnerplayer to the exel file
					fileWriter.append(String.valueOf(p.getPlayerColor()));
					fileWriter.append(",");
				}
			}
//			add the endtime of the game to the exel file
			fileWriter.append(String.valueOf(g.getEndTime()));
			fileWriter.append("\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



	}



// readCsv function receive the filepath of the exel that we are saving the history of the games 
//	the function read the exel file so we can take the history data from it
	public static int readCsv(String filePath) {
		BufferedReader reader = null;
		int swap = 0;

		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			line = reader.readLine(); // Read the first line


				// Start reading the file
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split(",");
//					check if the file is not empty
					if(!fields[0].isEmpty()) {
						if (fields.length > 0) {
//							build new game and new player so we can give them the data from the exel
							Game game = new Game();
							Player player = new Player();
//							get the game id from the exel file
							if (swap < Integer.parseInt(fields[0])) {
								swap = Integer.parseInt(fields[0]);
							}
							System.out.println("swap in sysy data " + swap);
							game.setGameId(swap);
//							get the level of the game from the exel file
							if (fields[1].equals("Easy")) {
								game.setGameLevel(Levels.Easy);
							} else if (fields[1].equals("Medium")) {
								game.setGameLevel(Levels.Medium);
							} else if (fields[1].equals("Hard")) {
								game.setGameLevel(Levels.Hard);
							}
//							get the player nickname from the exel file
							player.setNickName(fields[2]);
//							get the player color from the exel file
							if (fields[3].equals(PlayerColor.Red)) {
								player.setPlayerColor(PlayerColor.Red);
							} else if (fields[3].equals(PlayerColor.Blue)) {
								player.setPlayerColor(PlayerColor.Blue);
							} else if (fields[3].equals(PlayerColor.Green)) {
								player.setPlayerColor(PlayerColor.Green);
							} else if (fields[3].equals(PlayerColor.Yellow)) {
								player.setPlayerColor(PlayerColor.Yellow);
							}
//							get the endtime of the game from the exel file
							game.setEndTime(fields[4]);
//							add the new game to the arraylist of the games gamesList
							gamesList.add(game);
							System.out.println(game.getGameLevel());
							System.out.println(game.getGameId());
//							add the new player to the arraylist of the winnerplayers winnerPlayer
							winnerPlayer.add(player);
						}
					}else {
//						print if the file is empty, so it will not read  it
						System.out.println("the file is empty");
					}
				}
			
			return swap;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;

	}


}