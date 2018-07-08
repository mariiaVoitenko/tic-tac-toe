package game.win.strategy.impl;

import game.win.strategy.BoardTraversalOrder;
import model.Board;
import model.Position;
import model.player.Player;

public class DiagonalWinStrategy extends AbstractWinStrategy {

    @Override
    public boolean isWinner(Board board, Player player) {
        int size = board.getSize();
        int rightDiagonalSymbolsCount = 0;
        int leftDiagonalSymbolsCount = 0;
        for (int i = 0; i < size; i++) {
            Position position = new Position(i, i);
            String value = board.getValue(position);
            if (isPositionMarkedWithCurrentPlayer(value, player)) {
                rightDiagonalSymbolsCount++;
            }
            position = new Position(size - 1 - i, i);
            value = board.getValue(position);
            if (isPositionMarkedWithCurrentPlayer(value, player)) {
                leftDiagonalSymbolsCount++;
            }
        }
        return rightDiagonalSymbolsCount == size || leftDiagonalSymbolsCount == size;
    }

    @Override
    public BoardTraversalOrder getBoardTraversalOrder() {
        return BoardTraversalOrder.DIAGONAL;
    }

}
