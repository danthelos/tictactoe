package game;

public enum PlayerType {
    HUMAN("user"),
    AI_EASY("easy"),
    AI_MEDIUM("medium");

    //Fields
    private final String playerName;

    //Constructors
    PlayerType(String playerName) {
        this.playerName = playerName;
    }

    //Methods
    public String getPlayerName() {return playerName;}

    //check if string is a playerType name value
    static public boolean isPlayerType(String playerName) {
        PlayerType[] aPlayers = PlayerType.values();
        for (PlayerType aPlayer : aPlayers)
            if (aPlayer.getPlayerName().equals(playerName))
                return true;
        return false;
    }
}
