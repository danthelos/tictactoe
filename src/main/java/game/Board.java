package game;

import java.util.Scanner;

public class Board {

    private static char[][] board = new char[3][3];

    //Constructors
    public Board() {
        this.board = board;
    }

    // Use this method if you want to initialize filled board eq. _XO_XX_OO
    static char[][] getBoard() {
        System.out.print("Enter the cells: ");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        int charPosition = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = inputData.charAt(charPosition);
                charPosition++;
            }
        }
        return board;
    }

    static char[][] initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = CellState.EMPTY.getStateSymbol();
            }
        }
        return board;
    }

    static void printBoard(char board[][]){
        String line = "---------";
        char symbol;

        System.out.println(line);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                //set space or symbol to print in matrix
                switch (board[i][j]) {
                    case '_' :
                        symbol = ' ';
                        break;
                    default:
                        symbol = board[i][j];
                }
                //print matrix
                switch(j) {
                    case 0 :
                        System.out.print("| " + symbol + " ");
                        break;
                    case 1 :
                        System.out.print(symbol + " ");
                        break;
                    case 2 :
                        System.out.print(symbol + " |");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println(line);
    }

    static boolean isCellEmpty(int[] coordinates) {
        if (board[coordinates[0]][coordinates[1]] == CellState.EMPTY.getStateSymbol()) {
            return true;
        }
        return false;
    }

    static void fillCell(int[] coordinates, char userSymbol) {
        board[coordinates[0]][coordinates[1]] = userSymbol;
    }

    static int countOccurrences(char[][] board, char element) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (element == board[i][j])
                    count++;
            }
        }
        return count;
    }

    static boolean isBoardFull (char[][] board){
        if (countOccurrences(board, CellState.EMPTY.getStateSymbol()) == 0) {
            return true;
        }
        return false;
    }

    static GameState checkWinner(char[][] board) {
        char winner = CellState.EMPTY.getStateSymbol();
        //check if there is a winner in row
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                winner = board[i][0];
                //System.out.println("Winner from row number:" + i + " is: " + board[i][0]);
            }
        }

        //check if there is a winner in column
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                winner = board[0][i];
                //System.out.println("Winner from column number:" + i + " is: " + board[0][i]);
            }
        }

        //Check if there is a diagonnal winner
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])  {
                winner = board[1][1];
                //System.out.println("Winner from diagonal front is: " + board[1][1]);
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2])  {
            winner = board[1][1];
            //System.out.println("Winner from diagonal oposite is: " + board[1][1]);
        }
        switch (winner) {
            case 'X' :
                return GameState.X_WON;
            case 'O' :
                return GameState.O_WON;
            default :
                return GameState.GAME_NOT_FINISHED;
        }
    }
}
