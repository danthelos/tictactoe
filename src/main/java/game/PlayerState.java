package game;

public enum PlayerState {
    X_TURN('X'),
    O_TURN('O');

    //Filds
    char playerSymbol;

    //Constructors
    PlayerState(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    //Methods
    static PlayerState switchPlayer(PlayerState playerState) {
        if (playerState.equals(PlayerState.X_TURN)) {
            return PlayerState.O_TURN;
        }
        return PlayerState.X_TURN;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }
}
