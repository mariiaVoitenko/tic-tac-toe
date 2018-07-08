package model;

public class GameProperties {

    private int size;
    private String[] playerCharacters;

    public GameProperties(int size, String player1Character, String player2Character, String player3Character) {
        this.size = size;
        playerCharacters = new String[3];
        playerCharacters[0] = player1Character;
        playerCharacters[1] = player2Character;
        playerCharacters[2] = player3Character;
    }

    public int getSize() {
        return size;
    }

    public String[] getPlayerCharacters() {
        return playerCharacters;
    }
}
