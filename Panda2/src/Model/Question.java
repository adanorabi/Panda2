package Model;
import java.util.ArrayList;

import Controller.SysData;
//import Controller.SysData;
import Enum.Levels;
//------------------------Question class that contains question metods By Yara--------------------
public class Question {
	private int QuestionId;

	private String Content;
	private ArrayList<String> Answers;
	private String TrueAnswer;	
	private Levels QLevel;

	public Question(int questionId, Levels qLevel,String content, ArrayList<String> answer, String trueAnswer ) {
		super();
		this.QuestionId = questionId;
		this.Content = content;
		this.Answers =  new ArrayList<String>(); 
		this.TrueAnswer = trueAnswer;
		this.Answers=answer;	
		this.QLevel = qLevel;
	}

	public Question() {
		super();
	}

	//getters and setters
	public int getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	public Levels getQLevel() {
		return QLevel;
	}

	public void setQLevel(Levels qLevel) {
		QLevel = qLevel;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public ArrayList<String> getAnswer() {
		return this.Answers;
	}

	public void setAnswer(ArrayList<String> answer) {
		this.Answers = answer;
	}

	public String getTrueAnswer() {
		return TrueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		TrueAnswer = trueAnswer;
	}



	@Override
	public String toString() {
		return "Question [QuestionId=" + QuestionId + ", QLevel=" + QLevel + ", Content=" + Content + ", Answers="
				+ Answers + ", TrueAnswer=" + TrueAnswer + "]";
	}


	public static Question CallQuestion(Levels questionLevel)  {  // a function that choose a random question according to the level received -Yara
		// Check if the list corresponding to the question level is empty
		if (questionLevel.equals(Levels.Easy) && !SysData.EasyQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.EasyQues.size()); 
			return SysData.EasyQues.get(index); // returning a random easy question

		} else if (questionLevel.equals(Levels.Medium) && !SysData.MidQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.MidQues.size()); 
			return SysData.MidQues.get(index); // returning a random medium question

		} else if (!SysData.HardQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.HardQues.size()); 
			return SysData.HardQues.get(index); // returning a random Hard question
		} else {
			// Throw an exception indicating no questions available
			return null; 
		}
	}

	public static  int answerFeedback(Question question,boolean Answer,int Position ) // Function that decide the player movement according to his answers of questions-Yara 
	{
		int newpos;
		if(question.getQLevel().equals(Levels.Easy)) {
			if( Answer== true) {
				newpos= 0+Position;
				return newpos;
			}
			else {
				newpos= Position-1;
				return newpos;
			}
		}
		else if(question.getQLevel().equals(Levels.Medium)) {
			if( Answer== true) {

				newpos= Position;
				return newpos;
			}

			else {
				newpos= Position-2;
				return newpos;
			}
		}

		else {
			if( Answer== true) {   // true answer for Hard question

				newpos= Position+1;

				return newpos;

			}
			else {
				newpos= Position-3;

				return newpos;
			}
		}
	}
}


