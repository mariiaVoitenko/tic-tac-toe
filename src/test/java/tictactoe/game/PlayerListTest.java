package tictactoe.game;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import tictactoe.model.GameProperties;
import tictactoe.model.player.AIPlayer;
import tictactoe.model.player.Player;

public class PlayerListTest {

    private static final int SIZE = 3;
    private static final String PLAYER_1_CHARACTER = "X";
    private static final String PLAYER_2_CHARACTER = "Y";
    private static final String PLAYER_3_CHARACTER = "Z";
    private Predicate<Player> playerPredicate = player -> !(player instanceof AIPlayer);
    private Predicate<Player> aIPlayerPredicate = player -> player instanceof AIPlayer;

    private PlayerList playerList;
    private List<Player> players;

    @Before
    public void setUp() {
        GameProperties gameProperties = new GameProperties(SIZE, PLAYER_1_CHARACTER, PLAYER_2_CHARACTER, PLAYER_3_CHARACTER);
        playerList = new PlayerList(gameProperties);
        players = playerList.getPlayers();
    }

    @Test
    public void shouldReturnNotEmptyListOfPlayers() {
        assertThat(players).hasSize(SIZE);
    }

    @Test
    public void shouldReturnOnlyOneAiPlayer() {
        long aiPlayersCount = getSize(aIPlayerPredicate);
        assertThat(aiPlayersCount).isEqualTo(1);
    }

    @Test
    public void shouldReturnTwoCommonPlayers() {
        long commonPlayersCount = getSize(playerPredicate);
        assertThat(commonPlayersCount).isEqualTo(2);
    }

    @Test
    public void shouldReturnIDEqualToZeroForAIPlayer() {
        Player player = getList(aIPlayerPredicate).get(0);
        assertThat(player.getId()).isEqualTo(0);
    }

    @Test
    public void shouldReturnCharacterEqualToXForAIPlayer() {
        Player player = getList(aIPlayerPredicate).get(0);
        assertThat(player.getCharacter()).isEqualTo(PLAYER_1_CHARACTER);
    }

    @Test
    public void shouldReturnIDsEqualToOneAndTwoForCommonPlayers() {
        Player player1 = getList(playerPredicate).get(0);
        Player player2 = getList(playerPredicate).get(1);
        assertThat(player1.getId()).isIn(1,2);
        assertThat(player2.getId()).isIn(1,2);
    }

    @Test
    public void shouldReturnCharactersEqualToYAndZForCommonPlayers() {
        Player player1 = getList(playerPredicate).get(0);
        Player player2 = getList(playerPredicate).get(1);
        assertThat(player1.getCharacter()).isIn(PLAYER_2_CHARACTER, PLAYER_3_CHARACTER);
        assertThat(player2.getCharacter()).isIn(PLAYER_2_CHARACTER, PLAYER_3_CHARACTER);
    }

    private long getSize(Predicate<Player> playerPredicate) {
        return getList(playerPredicate).size();
    }

    private List<Player> getList(Predicate<Player> playerPredicate) {
        return playerList.getPlayers().stream().filter(playerPredicate).collect(Collectors.toList());
    }

}