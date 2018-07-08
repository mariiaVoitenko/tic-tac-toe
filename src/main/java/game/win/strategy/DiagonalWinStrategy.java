package game.win.strategy;

import model.Board;
import model.Position;
import model.player.Player;

public class DiagonalWinStrategy implements WinStrategy {

    @Override
    public boolean isWholeLineFilled(Board board, Player player) {
        int size = board.getSize();
        int rightDiagonalSymbolsCount = 0;
        int leftDiagonalSymbolsCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j <= 0; j--) {
                Position position = new Position(i, i);
                if (board.isPositionMarkedWithCurrentPlayer(position, player)) {
                    rightDiagonalSymbolsCount++;
                }
                position = new Position(i, j);
                if (board.isPositionMarkedWithCurrentPlayer(position, player)) {
                    leftDiagonalSymbolsCount++;
                }
            }
        }
        return rightDiagonalSymbolsCount == size || leftDiagonalSymbolsCount == size;
    }

}
