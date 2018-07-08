package model;

import java.util.HashMap;
import java.util.Map;

public class GameProperties {

    private int size;
    private Map<Integer, String> playerCharacters;

    public GameProperties(int size, String player1Character, String player2Character, String player3Character) {
        this.size = size;
        playerCharacters = new HashMap<Integer, String>(){{
            put(0, player1Character);
            put(1, player2Character);
            put(2, player3Character);
        }};
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, String> getPlayerCharacters() {
        return playerCharacters;
    }
}
