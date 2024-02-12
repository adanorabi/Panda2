package Model;

import Enum.Levels;

public class QuestionSquare extends Square{
		private Levels QuesLevel;
		public static int counter=1;
		private int QuesSquareId;
		public QuestionSquare(int squareRow, int squareCol, Levels quesLevel) {
			super( squareRow, squareCol);
			QuesLevel = quesLevel;
			this.QuesSquareId=this.counter++;
		}

		

		
		 public void ChooseQuestion() {  //should be continued!!!
				
			}
		 
	 }
	

