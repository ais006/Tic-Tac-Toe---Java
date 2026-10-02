import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TIC-TAC-TOE ===");

        while (true) {

            printBoard();

            System.out.println(
                    "Player " + currentPlayer +
                            ", enter row and column (1-3):"
            );

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("This cell is already occupied. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    static void printBoard() {

        System.out.println();

        System.out.println("   1   2   3");
        System.out.println("1  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("  ---+---+---");
        System.out.println("2  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("  ---+---+---");
        System.out.println("3  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);

        System.out.println();
    }

    static void switchPlayer() {

        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    static boolean checkWinner() {

        // Check rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {

                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {

            if (board[0][i] != ' ' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {

                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {

            return true;
        }

        // Check second diagonal
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {

            return true;
        }

        return false;
    }

    static boolean isDraw() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}


