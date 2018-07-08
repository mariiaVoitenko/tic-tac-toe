package game.win.strategy.impl;

import game.win.strategy.BoardTraversalOrder;
import game.win.strategy.WinStrategy;
import model.Board;
import model.Position;
import model.player.Player;

public abstract class AbstractWinStrategy implements WinStrategy {

    abstract BoardTraversalOrder getBoardTraversalOrder();

    protected boolean isWholeLineFilled(Board board, Player player) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            int symbolsCount = 0;
            for (int j = 0; j < size; j++) {
                Position position = getPosition(i, j);
                String value = board.getValue(position);
                if (isPositionMarkedWithCurrentPlayer(value, player)) {
                    symbolsCount++;
                }
                if (symbolsCount == size) return true;
            }
        }
        return false;
    }

    private Position getPosition(int i, int j) {
        return getBoardTraversalOrder() == BoardTraversalOrder.REVERSED ? new Position(j, i) : new Position(i, j);
    }

    protected boolean isPositionMarkedWithCurrentPlayer(String value, Player player) {
        return value.equals(player.getCharacter());
    }
}
