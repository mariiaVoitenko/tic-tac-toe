package tictactoe.game.win;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.exception.value.SizeException;
import tictactoe.model.Board;
import tictactoe.model.Position;
import tictactoe.model.player.Player;

public class WinStrategiesContainerIntegrationTest {

    private static final int ID = 1;
    private static final String X = "X";
    private static final int SIZE = 3;
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
        markHorizontalLine();
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenOneVerticalLineMarkedByUserCharacter(){
        markVerticalLine();
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenRightDiagonalLineMarkedByUserCharacter(){
        markRightDiagonalLine();
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenLeftDiagonalLineMarkedByUserCharacter(){
        markLeftDiagonalLine();
        boolean result = winStrategiesContainer.isGameWon(player);
        assertThat(result).isTrue();
    }

    private void markHorizontalLine() {
        board.markPosition(new Position(0,0),player);
        board.markPosition(new Position(0,1),player);
        board.markPosition(new Position(0,2),player);
    }

    private void markVerticalLine() {
        board.markPosition(new Position(0,0),player);
        board.markPosition(new Position(1,0),player);
        board.markPosition(new Position(2,0),player);
    }

    private void markRightDiagonalLine() {
        board.markPosition(new Position(0,0),player);
        board.markPosition(new Position(1,1),player);
        board.markPosition(new Position(2,2),player);
    }

    private void markLeftDiagonalLine() {
        board.markPosition(new Position(0,2),player);
        board.markPosition(new Position(1,1),player);
        board.markPosition(new Position(2,0),player);
    }

}