package game;

public class Player {

    MoveState symbol;
    PlayerType type;

    //Constructors
    public Player(MoveState symbol, PlayerType type) {
        this.symbol = symbol;
        this.type = type;
    }

    public Player(MoveState symbol) {
        this.symbol = symbol;
    }

    public Player() {
    }

    public MoveState getSymbol() {
        return symbol;
    }

    public void setSymbol(MoveState symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public void setPlayerType(String playerType) {
        switch(playerType) {
            case "user" :
                setType(PlayerType.HUMAN);
                break;
            case "easy" :
                setType(PlayerType.AI_EASY);
                break;
            case "medium" :
                setType(PlayerType.AI_MEDIUM);
                break;
        }
    }

}
