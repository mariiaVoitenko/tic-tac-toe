package game.win.strategy.impl;

import game.win.strategy.BoardTraversalOrder;
import model.Board;
import model.player.Player;

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
