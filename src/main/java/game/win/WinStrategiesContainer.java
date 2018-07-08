package game.win;

import java.util.List;

import game.win.strategy.DiagonalWinStrategy;
import game.win.strategy.HorizontalWinStrategy;
import game.win.strategy.VerticalWinStrategy;
import game.win.strategy.WinStrategy;
import model.Board;
import model.player.Player;

public class WinStrategiesContainer {

    private List<WinStrategy> winStrategies;
    private Board board;

    public WinStrategiesContainer (Board board) {
        this.board = board;
        winStrategies.add(new DiagonalWinStrategy());
        winStrategies.add(new HorizontalWinStrategy());
        winStrategies.add(new VerticalWinStrategy());
    }

    public boolean isGameWon(Player player) {
        return winStrategies.stream()
                .anyMatch(winStrategy -> winStrategy.isWholeLineFilled(board, player));
    }

}
