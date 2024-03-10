package Model;
import java.util.Arrays;
// A class that contains Game Board -Yara
public class Board {
	private int[] board;
	private int size;

	public Board(int size) { // a Game board constructor that create a board according to game level and size-Yara
		this.size = size;
		board = new int[size * size];
		populateBoard();
	}


	@Override
	public String toString() {
		return "Board [board=" + Arrays.toString(board) + ", size=" + size + "]";
	}

	private void populateBoard() { // a function that fill the board cells with numbers as in real life board -Yara
		int cellValue = 1;
		int index = 0;
		for (int i = 0; i < size; i++) {
			// Determine the direction based on whether the row is even or odd-Yara
			boolean leftToRight = i % 2 == 0;
			if (leftToRight) {
				// If the row is even, fill the cells from left to right-Yara
				for (int j = 0; j < size; j++) {
					board[index++] = cellValue++;
				}
			} else {
				// If the row is odd, fill the cells from right to left-Yara
				for (int j = size - 1; j >= 0; j--) {
					board[index++] = cellValue++;
				}
			}
		}
	}


	public int getPosition(int col, int row) {//this function Calculate the index of the given row and column coordinates-Yara

		int index;
		if (row % 2 == 0) {
			// Even rows start from the left
			index = row * size + col;
		} else {
			// Odd rows start from the right
			index = row * size + (size - col - 1);
		}
		return board[index];
	}


	public int[] getCoordinates(int value) { //function that Find the index of the given value in the board array-Yara

		int index = -1;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == value) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			// Value not found on the board-Yara
			return new int[]{-1, -1};
		}

		// Calculate row and column coordinates-Yara
		int row = index / size;  // Integer division to get the row-Yara
		int col;
		if (row % 2 == 0) {
			// Even row count left to right-Yara
			col = index % size;
		} else {
			// Odd row count right to left-Yara
			col = size - 1 - (index % size);
		}

		return new int[]{col, row};
	}


}
