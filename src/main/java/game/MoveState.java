package game;

public enum MoveState {
    X_TURN('X'),
    O_TURN('O');

    //Fields
    char playerSymbol;

    //Constructors
    MoveState() {}

    MoveState(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    //Methods
    static MoveState switchPlayer(MoveState moveState) {
        if (moveState.equals(MoveState.X_TURN)) {
            return MoveState.O_TURN;
        }
        return MoveState.X_TURN;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

}
