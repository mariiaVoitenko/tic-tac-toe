package tictactoe.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tictactoe.model.GameProperties;
import tictactoe.model.player.AIPlayer;
import tictactoe.model.player.Player;

public class PlayerList {

    private List<Player> players;

    public PlayerList(GameProperties gameProperties){
        players = new ArrayList<>();
        players.add(new AIPlayer(0, gameProperties.getPlayerCharacters().get(0)));
        for (int i = 1; i < gameProperties.getPlayerCharacters().size(); i++) {
            players.add(new Player(i, gameProperties.getPlayerCharacters().get(i)));
        }
        Collections.shuffle(players);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
