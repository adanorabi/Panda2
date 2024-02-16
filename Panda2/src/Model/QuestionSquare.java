package Model;

import Enum.Levels;

public class QuestionSquare extends Square{
		private Levels QuesLevel;
		public static int counter=3;
		private int QuesSquareId;
		public QuestionSquare(int squareRow, int squareCol, Levels quesLevel) {
			super( squareRow, squareCol);
			QuesLevel = quesLevel;
			this.QuesSquareId=this.counter++;
		}

				
		 public Levels getQuesLevel() {
			return QuesLevel;
		}


		public void setQuesLevel(Levels quesLevel) {
			QuesLevel = quesLevel;
		}


		public int getQuesSquareId() {
			return QuesSquareId;
		}

		public void setQuesSquareId(int quesSquareId) {
			QuesSquareId = quesSquareId;
		}


	
		 
	 }
	

