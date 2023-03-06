package game;

public class Main {
    public static void main(String[] args) throws Exception {

        //Matrix matrix = new Matrix();
        char[][] gameBoard = Board.getBoard();
       Board.printBoard(gameBoard);

        int[] coordinates  = Move.getCoordinates();
        System.out.print("Coordinates: " + coordinates[0] + ":" + coordinates[1]);
    }
}
