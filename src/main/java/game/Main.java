package game;

public class Main {
    public static void main(String[] args) throws Exception {

        //Initialize board and game states
        GameState gameState = GameState.GAME_NOT_FINISHED;
        PlayerState playerState = PlayerState.X_TURN;
        char[][] gameBoard = Board.initializeBoard();
        int[] coordinates = {0,0};

        //Game start
        do {
            Board.printBoard(gameBoard);

            switch (playerState) {
                case X_TURN:
                    coordinates = Move.getCoordinates();
                    break;
                case O_TURN:
                    coordinates = Move.randomCoordinates();
                    System.out.println("Making move level \"easy\"");
                    break;
            }
            Board.fillCell(coordinates, playerState.getPlayerSymbol());

            gameState = Board.checkWinner(gameBoard);
            if (gameState.equals(GameState.O_WON) || gameState.equals(GameState.X_WON)) {
                Board.printBoard(gameBoard);
                System.out.println(gameState.getStateMessage());
                break;
            }
            if (Board.isBoardFull(gameBoard)) {
                gameState = GameState.DRAW;
                Board.printBoard(gameBoard);
                System.out.println(gameState.getStateMessage());
                break;
            }
            playerState = PlayerState.switchPlayer(playerState);

        } while (gameState.equals(GameState.GAME_NOT_FINISHED));
    }
}
