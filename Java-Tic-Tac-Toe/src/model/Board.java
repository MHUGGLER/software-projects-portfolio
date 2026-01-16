package model;

public class Board {
    private final BoardPiece[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new BoardPiece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new BoardPiece(' '); // Initialize all spots as blank
            }
        }
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (board[row][col].getPiece() == ' ') {
            board[row][col].setPiece(symbol);
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0].getPiece() == symbol &&
                board[i][1].getPiece() == symbol &&
                board[i][2].getPiece() == symbol) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i].getPiece() == symbol &&
                board[1][i].getPiece() == symbol &&
                board[2][i].getPiece() == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0].getPiece() == symbol &&
            board[1][1].getPiece() == symbol &&
            board[2][2].getPiece() == symbol) {
            return true;
        }
        else if (board[0][2].getPiece() == symbol &&
            board[1][1].getPiece() == symbol &&
            board[2][0].getPiece() == symbol) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getPiece() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getPiece() + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}

//(helper methods).

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].getPiece() == ' ';
    }

    public void removeMark(int row, int col) {
        board[row][col].setPiece(' ');
    }
}
