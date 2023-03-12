package game;

public enum GameState {
    X_WON("X wins"),
    O_WON("O wins"),
    GAME_NOT_FINISHED("Game not finished"),
    DRAW("Draw");

    //Fields
    private String stateMessage;

    //Constructors
    GameState(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    //Methods
    public String getStateMessage() {
        return stateMessage;
    }
}
