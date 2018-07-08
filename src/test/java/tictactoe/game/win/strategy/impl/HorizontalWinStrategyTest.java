package tictactoe.game.win.strategy.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.exception.value.SizeException;
import tictactoe.game.win.strategy.BoardTraversalOrder;
import tictactoe.model.Board;
import tictactoe.model.Position;
import tictactoe.model.player.Player;

public class HorizontalWinStrategyTest {

    private static final int ID = 1;
    private static final int ID2 = 2;
    private static final String X = "X";
    private static final String O = "O";
    private static final int SIZE = 3;
    private Player player;
    private Player player2;
    private Board board;

    private HorizontalWinStrategy horizontalWinStrategy;

    @Before
    public void setUp() throws SizeException {
        board = new Board(SIZE);
        player = new Player(ID, X);
        player2 = new Player(ID2, O);
        horizontalWinStrategy = new HorizontalWinStrategy();
    }

    @Test
    public void shouldReturnOrdinaryTraversalOrderWhenGetBoardTraversalOrder() {
        BoardTraversalOrder boardTraversalOrder = horizontalWinStrategy.getBoardTraversalOrder();
        assertThat(boardTraversalOrder).isEqualTo(BoardTraversalOrder.ORDINARY);
    }

    @Test
    public void shouldReturnTrueWhenUserHasHorizontalLineMarked() {
        markHorizontalLine();
        boolean isWinner = horizontalWinStrategy.isWinner(board, player);
        assertThat(isWinner).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenOtherUserHasHorizontalLineMarked() {
        markHorizontalLine();
        boolean isWinner = horizontalWinStrategy.isWinner(board, player2);
        assertThat(isWinner).isFalse();
    }

    private void markHorizontalLine() {
        board.markPosition(new Position(0, 0), player);
        board.markPosition(new Position(0, 1), player);
        board.markPosition(new Position(0, 2), player);
    }

}