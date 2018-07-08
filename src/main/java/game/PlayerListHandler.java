package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.GameProperties;
import model.player.AIPlayer;
import model.player.Player;

public class PlayerListHandler {

    private List<Player> players;

    public List<Player> createInRandomOrder(GameProperties gameProperties) {
        players = new ArrayList<>();
        players.add(new AIPlayer(0, gameProperties.getPlayerCharacters().get(0)));
        for (int i = 1; i < gameProperties.getPlayerCharacters().size(); i++) {
            players.add(new Player(i, gameProperties.getPlayerCharacters().get(i)));
        }

        Collections.shuffle(players);
        return players;
    }

    public Player getNextPlayer(Player currentPlayer) {
        int index = players.indexOf(currentPlayer);
        boolean isCurrentIndexLast = index == players.size() - 1;
        int nextIndex = isCurrentIndexLast ? 0 : index + 1;
        return players.get(nextIndex);
    }
}
