package Model;

import java.util.ArrayList;

import Controller.SysData;
//import Controller.SysData;
import Enum.Levels;

public class Question {
	private int QuestionId;
	private Levels QLevel;
	private String Content;
	private ArrayList<String> Answers;
	private String TrueAnswer;

	public Question(int questionId, Levels qLevel, String content, ArrayList<String> answer, String trueAnswer) {
		super();
		this.QuestionId = questionId;
		this.QLevel = qLevel;
		this.Content = content;
		this.Answers =  new ArrayList<String>(); 
		this.TrueAnswer = trueAnswer;
		this.Answers=answer;
	}
	

	public Question() {
		super();
	}


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
		return "Question [QuestionId=" + QuestionId + ", QLevel=" + QLevel + ", Content=" + Content + ", Answer="
				+ Answers + ", TrueAnswer=" + TrueAnswer + "]";
	}

	public static Question CallQuestion(Levels questionLevel)  {
		// Check if the list corresponding to the question level is empty
		if (questionLevel.equals(Levels.Easy) && !SysData.EasyQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.EasyQues.size()); 
			System.out.println("Random Question is: " + SysData.EasyQues.get(index));
			return SysData.EasyQues.get(index); // returning a random easy question
		} else if (questionLevel.equals(Levels.Medium) && !SysData.MidQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.MidQues.size()); 
			System.out.println("Random Question is: " + SysData.MidQues.get(index));
			return SysData.MidQues.get(index); // returning a random medium question
		} else if (!SysData.HardQues.isEmpty()) {
			int index = (int)(Math.random() * SysData.HardQues.size()); 
			System.out.println("Random Question is: " + SysData.HardQues.get(index));
			return SysData.HardQues.get(index); // returning a random Hard question
		} else {
			// Throw an exception indicating no questions available
			return null; //yara!
		}
	}

	public static  int answerFeedback(Question question,boolean Answer,int Position ) // Function that decide the player movement according to his answers of questions 
	{
		if(question.getQLevel().equals(Levels.Easy)) {
			if( Answer== true) {
				return 0+Position;
			}
			else {
				return Position-1;
			}
		}
		else if(question.getQLevel().equals(Levels.Medium)) {
			if( Answer== true) {
				return Position+0;
			}
			else {
				return Position-2;
			}
		}
		else {
			if( Answer== true) {   // true answer for Hard question
				return Position+1;
			}
			else {
				return Position-3;
			}
		}
	}

}
