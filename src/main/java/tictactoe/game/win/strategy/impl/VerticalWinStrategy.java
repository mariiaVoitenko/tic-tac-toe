package tictactoe.game.win.strategy.impl;

import tictactoe.game.win.strategy.BoardTraversalOrder;
import tictactoe.model.Board;
import tictactoe.model.player.Player;

public class VerticalWinStrategy extends AbstractWinStrategy {

    @Override
    public boolean isWinner(Board board, Player player) {
        return isWholeLineFilled(board, player);
    }

    @Override
    public BoardTraversalOrder getBoardTraversalOrder() {
        return BoardTraversalOrder.REVERSED;
    }

}
