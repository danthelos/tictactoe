package game;

public class Main {
    public static void main(String[] args) throws Exception {

        GameState gameState = GameState.X_TURN;
        char[][] gameBoard = Board.initializeBoard();

        Board.printBoard(gameBoard);
        //char userSymbol = Board.calculateUserSymbol(gameBoard);

        int[] coordinates  = Move.getCoordinates();

        //System.out.println("Coordinates: " + Arrays.toString(Move.printCoordinates(coordinates)));
        //System.out.println("If this cell is empty ? " + Board.isCellEmpty(coordinates));

        //Board.fillCell(coordinates, userSymbol);
        Board.fillCell(coordinates, gameState.getStateSymbol());

        gameState = Board.checkWinner(gameBoard);

        if (Board.isBoardFull(gameBoard)) {
            gameState = GameState.DRAW;
        }

        Board.printBoard(gameBoard);

        System.out.println(gameState.getStateMessage());
        gameState.switchTurn();



    }
}
