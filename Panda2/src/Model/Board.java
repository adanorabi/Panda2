package Model;



public class Board {
    private int[] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new int[size * size];
        populateBoard();
    }

    private void populateBoard() {
        int cellValue = 1;
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            if ((size - i) % 2 == 0) {
                // If the row number is even, fill the cells from left to right
                for (int j = 0; j < size; j++) {
                    board[index++] = cellValue++;
                }
            } else {
                // If the row number is odd, fill the cells from right to left
                for (int j = size - 1; j >= 0; j--) {
                    board[index++] = cellValue++;
                }
            }
        }
    }

    public int getPosition(int row, int col) {
        // Convert 2D coordinates to 1D position
        int index;
        if ((size - row - 1) % 2 == 0) {
            // Even rows (0-based) start from the left
            index = (size - row - 1) * size + col;
        } else {
            // Odd rows start from the right
            index = (size - row - 1) * size + (size - col - 1);
        }
        return board[index];
    }

    public int[] getCoordinates(int value) {
        // Find the index of the given value in the board array
        int index = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // Value not found on the board
            return new int[]{-1, -1};
        }

        // Convert 1D index to 2D coordinates
        int row, col;
        if ((size - index / size - 1) % 2 == 0) {
            // Even rows (0-based) start from the left
            row = size - 1 - index / size;
            col = index % size;
        } else {
            // Odd rows start from the right
            row = size - 1 - index / size;
            col = size - 1 - (index % size);
        }

        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int size = 4; // Change the size of the board as needed
        Board board = new Board(size);
        for (int i = 0; i < size * size; i++) {
            int[] coordinates = board.getCoordinates(board.getPosition(i / size, i % size));
            System.out.println("Value: " + board.getPosition(i / size, i % size) + ", Coordinates: (" + coordinates[0] + ", " + coordinates[1] + ")");
        }
    }
}
