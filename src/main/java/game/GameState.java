package game;

public enum GameState {
    X_WON("X wins"),
    O_WON("O wins"),
    GAME_NOT_FINISHED("Game not finished"),
    DRAW("Draw");

    //Fields
    private String stateMessage;
    private char stateSymbol;

    //Constructors
    GameState(String stateMessage) {
        this.stateMessage = stateMessage;
    }
    GameState(String stateMessage, char stateSymbol) {
        this.stateMessage = stateMessage;
        this.stateSymbol = stateSymbol;
    }

    //Methods
    public String getStateMessage() {
        return stateMessage;
    }

    public char getStateSymbol() {
        return stateSymbol;
    }
}
