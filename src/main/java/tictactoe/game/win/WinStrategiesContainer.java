package tictactoe.game.win;

import java.util.ArrayList;
import java.util.List;

import tictactoe.game.win.strategy.impl.DiagonalWinStrategy;
import tictactoe.game.win.strategy.impl.HorizontalWinStrategy;
import tictactoe.game.win.strategy.impl.VerticalWinStrategy;
import tictactoe.game.win.strategy.WinStrategy;
import tictactoe.model.Board;
import tictactoe.model.player.Player;

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
