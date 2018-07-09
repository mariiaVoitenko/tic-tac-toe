package tictactoe.game.win;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.exception.value.SizeException;
import tictactoe.model.Board;
import tictactoe.model.player.Player;
import util.LineUtils;

public class WinStrategiesContainerTest {

    private static final int ID = 1;
    private static final int SIZE = 3;
    private static final String X = "X";

    private Player player;
    private Board board;

    private WinStrategiesContainer winStrategiesContainer;

    @Before
    public void setUp() throws SizeException {
        board = new Board(SIZE);
        player = new Player(ID, X);
        winStrategiesContainer = new WinStrategiesContainer(board);
    }

    @Test
    public void shouldReturnFalseWhenBoardIsEmpty(){
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenOneHorizontalLineMarkedByUserCharacter(){
        LineUtils.markHorizontalLine(board, player);
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenOneVerticalLineMarkedByUserCharacter(){
        LineUtils.markVerticalLine(board, player);
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenRightDiagonalLineMarkedByUserCharacter(){
        LineUtils.markRightDiagonalLine(board, player);
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenLeftDiagonalLineMarkedByUserCharacter(){
        LineUtils.markLeftDiagonalLine(board, player);
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

}