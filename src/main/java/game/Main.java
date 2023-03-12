package game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        GameState gameState = GameState.GAME_NOT_FINISHED;
        char[][] gameBoard = Board.getBoard();
        Board.printBoard(gameBoard);
        char userSymbol = Board.calculateUserSymbol(gameBoard);

//        System.out.println("Count of X:" + Board.countOccurrences(gameBoard, 'X'));
//        System.out.println("Count of O:" + Board.countOccurrences(gameBoard, 'O'));
//        System.out.println("Count of empty cells:" + Board.countOccurrences(gameBoard, '_'));
//        System.out.println("Your symbol is: " + Board.calculateUserSymbol(gameBoard));

        int[] coordinates  = Move.getCoordinates();

        //System.out.println("Coordinates: " + Arrays.toString(Move.printCoordinates(coordinates)));
        //System.out.println("If this cell is empty ? " + Board.isCellEmpty(coordinates));

        Board.fillCell(coordinates, userSymbol);
        //System.out.println("Is board full ? " + Board.isBoardFull(gameBoard));
        gameState = Board.checkWinner(gameBoard);

        if (Board.isBoardFull(gameBoard)) {
            gameState = GameState.DRAW;
        }

        Board.printBoard(gameBoard);

        System.out.println(gameState.getStateMessage());


    }
}
