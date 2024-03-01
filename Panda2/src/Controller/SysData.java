package Controller;

import java.io.BufferedReader;

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
import Enum.PlayerColor;
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
	
	public static void AddGame(Game g) {
		g.setWinnerId(1);
		g.setEndTime(50);

		gamesList.add(g);
		String filePath = "C:\\Users\\amroz\\Documents\\GitHub\\Panda2\\Panda2\\GameH.csv";

		System.out.println("starting write user.csv file: " + filePath);
		writeCsv(filePath);

		System.out.println("starting read user.csv file");
		readCsv(filePath);
	}

	public static void writeCsv(String filePath) {


		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			fileWriter.append("GameId, GameLevel, WinnerId, Time\n");
			for(Game g: SysData.gamesList) {
				System.out.println(g);
				fileWriter.append(String.valueOf(g.getGameId()));
				fileWriter.append(",");
				fileWriter.append(String.valueOf(g.getGameLevel()));
				fileWriter.append(",");
				//		    fileWriter.append(String.valueOf(g.getWinnerId()));
				//		    fileWriter.append(",");
				fileWriter.append(String.valueOf(g.getEndTime()));
				for(Player p: g.getPlayers()) {
					if(p.getPlayerID()==g.getWinnerId()) {
						fileWriter.append(String.valueOf(p.getNickName()));
						fileWriter.append(",");
						fileWriter.append(String.valueOf(p.getPlayerColor()));
						fileWriter.append(",");
					}
				}
				fileWriter.append("\n");
			}
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

	public static void readCsv(String filePath) {
		BufferedReader reader = null;

		try {
			List<Game> Games = new ArrayList<Game>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");


				if(fields.length > 0) {
					Game game = new Game();
					Player player = new Player();
					game.setGameId(Integer.parseInt(fields[0]));
					if(fields[1].equals(Levels.Easy)) {
						game.setGameLevel(Levels.Easy);
					}else if(fields[1].equals(Levels.Medium)) {
						game.setGameLevel(Levels.Medium);
					}else if(fields[1].equals(Levels.Hard)) {
						game.setGameLevel(Levels.Hard);
					}
					if(fields[3].equals(PlayerColor.Red)) {
						player.setPlayerColor(PlayerColor.Red);
					}else if(fields[3].equals(PlayerColor.Blue)) {
						player.setPlayerColor(PlayerColor.Blue);
					}else if(fields[3].equals(PlayerColor.Green)) {
						player.setPlayerColor(PlayerColor.Green);
					}else if(fields[3].equals(PlayerColor.Yellow)) {
						player.setPlayerColor(PlayerColor.Yellow);
					}

					//		        game.setWinnerId(Integer.parseInt(fields[2]));

					game.setEndTime(Integer.parseInt(fields[4]));
					gamesList.add(game);
				}
			}

			for(Game g: gamesList) {
				for(Player pl: g.getPlayers()) {
					if(pl.getPlayerID()== g.getWinnerId()) {
						System.out.printf("GameId=%d, GameLevel=%s, WinnerNickName=%s, WinnerColor=%s, Time=%d%n]\n", g.getGameId(), 
								g.getGameLevel(), pl.getNickName(),pl.getPlayerColor(),g.getEndTime());
						System.out.println("Yes!! you did it");
					}

				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
