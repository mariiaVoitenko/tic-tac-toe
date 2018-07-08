package game.win;

import java.util.ArrayList;
import java.util.List;

import game.win.strategy.impl.DiagonalWinStrategy;
import game.win.strategy.impl.HorizontalWinStrategy;
import game.win.strategy.impl.VerticalWinStrategy;
import game.win.strategy.WinStrategy;
import model.Board;
import model.player.Player;

public class WinStrategiesContainer {

    private List<WinStrategy> winStrategies;
    private Board board;

    public WinStrategiesContainer (Board board) {
        this.board = board;
        winStrategies = new ArrayList<>();
        winStrategies.add(new DiagonalWinStrategy());
        winStrategies.add(new HorizontalWinStrategy());
        winStrategies.add(new VerticalWinStrategy());
    }

    public boolean isGameWon(Player player) {
        return winStrategies.stream()
                .anyMatch(winStrategy -> winStrategy.isWinner(board, player));
    }

}
