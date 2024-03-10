package Model;
// -----------Square class a parent class of SurpriseSquare and question Square BY Yara--------------
public class Square {
 
//normal square attributes 
	private int SquareRow;
	private int SquareCol;
//normal square constructor
	public Square( int squareRow, int squareCol) {
		super();
		SquareRow = squareRow;
		SquareCol = squareCol;
	}
//getters and setters
	public int getSquareRow() {
		return SquareRow;
	}

	public void setSquareRow(int squareRow) {
		SquareRow = squareRow;
	}

	public int getSquareCol() {
		return SquareCol;
	}

	public void setSquareCol(int squareCol) {
		SquareCol = squareCol;
	}




}
