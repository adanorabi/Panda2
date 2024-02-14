package Model;

import java.util.ArrayList;

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

	
	
	
}
