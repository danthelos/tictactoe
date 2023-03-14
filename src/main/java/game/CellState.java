package game;

public enum CellState {
    X('X'),
    O('O'),
    EMPTY('_');

    //Fields
    private char stateSymbol;

    //Constructors
    CellState(char stateSymbol) {
        this.stateSymbol = stateSymbol;
    }

    //Methods
    public char getStateSymbol() {
        return stateSymbol;
    }

}
