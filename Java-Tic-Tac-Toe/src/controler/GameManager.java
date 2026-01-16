package controller;

import java.util.Scanner;

import model.Board;
import model.Player;


public class GameManager {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Scanner input;

    public GameManager() {
        board = new Board();
        input = new Scanner(System.in);
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
    }

    public void startGame() {
        boolean gameEnded = false;
        board.display();

        while (!gameEnded) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row (0-2): ");
            int row = input.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = input.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (board.placeMark(row, col, currentPlayer.getSymbol())) {
                board.display();
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameEnded = true;
                } else if (board.isFull()) {
                    System.out.println("The game is a draw!");
                    gameEnded = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("That spot is already taken. Try again.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
