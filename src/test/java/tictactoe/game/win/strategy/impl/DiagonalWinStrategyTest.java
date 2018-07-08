package tictactoe.game.win.strategy.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.exception.value.SizeException;
import tictactoe.game.win.strategy.BoardTraversalOrder;
import tictactoe.model.Board;
import tictactoe.model.Position;
import tictactoe.model.player.Player;

public class DiagonalWinStrategyTest {

    private static final int ID = 1;
    private static final int ID2 = 2;
    private static final String X = "X";
    private static final String O = "O";
    private static final int SIZE = 3;
    private Player player;
    private Player player2;
    private Board board;

    private DiagonalWinStrategy diagonalWinStrategy;

    @Before
    public void setUp() throws SizeException {
        board = new Board(SIZE);
        player = new Player(ID, X);
        player2 = new Player(ID2, O);
        diagonalWinStrategy = new DiagonalWinStrategy();
    }

    @Test
    public void shouldReturnDiagonalTraversalOrderWhenGetBoardTraversalOrder() {
        BoardTraversalOrder boardTraversalOrder = diagonalWinStrategy.getBoardTraversalOrder();
        assertThat(boardTraversalOrder).isEqualTo(BoardTraversalOrder.DIAGONAL);
    }

    @Test
    public void shouldReturnTrueWhenUserHasRightDiagonalLineMarked() {
        markRightDiagonalLine();
        boolean isWinner = diagonalWinStrategy.isWinner(board, player);
        assertThat(isWinner).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenUserHasLeftDiagonalLineMarked() {
        markLeftDiagonalLine();
        boolean isWinner = diagonalWinStrategy.isWinner(board, player);
        assertThat(isWinner).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenUserHasBothDiagonalLinesMarked() {
        markLeftDiagonalLine();
        markRightDiagonalLine();
        boolean isWinner = diagonalWinStrategy.isWinner(board, player);
        assertThat(isWinner).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenOtherUserHasDiagonalLineMarked() {
        markRightDiagonalLine();
        boolean isWinner = diagonalWinStrategy.isWinner(board, player2);
        assertThat(isWinner).isFalse();
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