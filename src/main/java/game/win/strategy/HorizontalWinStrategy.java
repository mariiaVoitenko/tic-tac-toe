package game.win.strategy;

import model.Board;
import model.Position;
import model.player.Player;

public class HorizontalWinStrategy implements WinStrategy {

    @Override
    public boolean isWholeLineFilled(Board board, Player player) {
        int size = board.getSize();
        int symbolsCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Position position = new Position(i, j);
                if (board.isPositionMarkedWithCurrentPlayer(position, player)) {
                    symbolsCount++;
                }
            }
        }
        return symbolsCount == size;
    }

}
