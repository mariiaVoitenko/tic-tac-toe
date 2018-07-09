package tictactoe.game.win.strategy.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.exception.value.SizeException;
import tictactoe.game.win.strategy.BoardTraversalOrder;
import tictactoe.model.Board;
import tictactoe.model.player.Player;
import util.LineUtils;

public class VerticalWinStrategyTest {

    private static final int ID = 1;
    private static final int ID2 = 2;
    private static final int SIZE = 3;
    private static final String X = "X";
    private static final String O = "O";

    private Board board;
    private Player player;
    private Player player2;

    private VerticalWinStrategy verticalWinStrategy;

    @Before
    public void setUp() throws SizeException {
        board = new Board(SIZE);
        player = new Player(ID, X);
        player2 = new Player(ID2, O);
        verticalWinStrategy = new VerticalWinStrategy();
    }

    @Test
    public void shouldReturnReversedTraversalOrderWhenGetBoardTraversalOrder() {
        BoardTraversalOrder boardTraversalOrder = verticalWinStrategy.getBoardTraversalOrder();
        assertThat(boardTraversalOrder).isEqualTo(BoardTraversalOrder.REVERSED);
    }

    @Test
    public void shouldReturnTrueWhenUserHasVerticalLineMarked() {
        LineUtils.markVerticalLine(board, player);
        boolean isWinner = verticalWinStrategy.isWinner(board, player);
        assertThat(isWinner).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenOtherUserHasVerticalLineMarked() {
        LineUtils.markVerticalLine(board, player);
        boolean isWinner = verticalWinStrategy.isWinner(board, player2);
        assertThat(isWinner).isFalse();
    }

}