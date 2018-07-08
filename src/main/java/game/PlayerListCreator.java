package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.GameProperties;
import model.player.AIPlayer;
import model.player.Player;

public class PlayerListCreator {

    public static List<Player> createInRandomOrder(GameProperties gameProperties) {
        List<Player> players = new ArrayList<>();
        players.add(new AIPlayer(0, gameProperties.getPlayerCharacters()[0]));
        for (int i = 1; i < gameProperties.getPlayerCharacters().length; i++) {
            players.add(new Player(i, gameProperties.getPlayerCharacters()[i])); // todo get char by id
        }
        Collections.shuffle(players); // todo move to play method? Each call to play() will have different order
        return players;
    }


}
