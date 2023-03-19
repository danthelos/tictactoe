package game;

public class Game {

    //Set who has first move (X or O)
    private PlayerState playerState = PlayerState.X_TURN;
    private GameState gameState = GameState.GAME_NOT_FINISHED;
    private final char[][] gameBoard = Board.initializeBoard();
    private int[] coordinates = {0,0};

    public void play() {
        do {
            Board.printBoard(gameBoard);

            switch (playerState) {
                case X_TURN:
                    //Player is moving
                    coordinates = Move.getCoordinates();
                    break;
                case O_TURN:
                    //Computer is moving
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
