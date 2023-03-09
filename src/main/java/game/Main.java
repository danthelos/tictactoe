package game;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        char[][] gameBoard = Board.getBoard();
        Board.printBoard(gameBoard);

        int[] coordinates  = Move.getCoordinates();

        //System.out.println("Coordinates: " + Arrays.toString(Move.printCoordinates(coordinates)));
        //System.out.println("If this cell is empty ? " + Board.isCellEmpty(coordinates));

        Board.fillCell(coordinates);

        Board.printBoard(gameBoard);
    }
}
