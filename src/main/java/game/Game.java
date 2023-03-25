package game;

public class Game {

    //Initialize variables
    private GameState gameState = GameState.GAME_NOT_FINISHED;
    private final char[][] gameBoard = Board.initializeBoard();
    private int[] coordinates = {0,0};
    private String[] command;
    private Player player1 = new Player(MoveState.X_TURN);
    private Player player2 = new Player(MoveState.O_TURN);
    private Player activePlayer = player1;

    //Constructors
    Game(String[] command) {
        this.command = command;
    }

    public void play() {

        //get player type from command string array
        player1.setPlayerType(command[1]);
        player2.setPlayerType(command[2]);

        do {
            Board.printBoard(gameBoard);

            switch (activePlayer.type) {
                case HUMAN:
                    //Player is moving
                    coordinates = Move.getCoordinates();
                    break;
                case AI_EASY:
                    //Computer is moving
                    coordinates = Move.randomCoordinates();
                    System.out.println("Making move level \"easy\"");
                    break;
            }
            //Fill cell with activePlayer symbol
            Board.fillCell(coordinates, activePlayer.getSymbol().getPlayerSymbol());

            //Check if some symbol wins or if it is a draw
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

            //switch active player
            activePlayer = switchPlayer(activePlayer);

        } while (gameState.equals(GameState.GAME_NOT_FINISHED));
    }

    private Player switchPlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
        if (activePlayer.equals(player1)) {
            return player2;
        }
        return player1;
    }
}
