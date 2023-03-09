package game;

import java.util.Scanner;

public class Board {

    private static char[][] board = new char[3][3];
    private static char userSymbol = 'X';

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
        if (board[coordinates[0]][coordinates[1]] == '_') {
            return true;
        }
        return false;
    }

    static void fillCell(int[] coordinates) {
        board[coordinates[0]][coordinates[1]] = 'X';
    }

    static char calculateUserSymbol(char board[][]) {
        char userSymbol = 'X';
        int amountX = countOccurrences(board,'X');
        int amountY = 0;


        return userSymbol;
    }

    static int countOccurrences(char board[][], int element) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (element == board[i][j])
                    count++;
            }
        }
        return count;
    }
}
