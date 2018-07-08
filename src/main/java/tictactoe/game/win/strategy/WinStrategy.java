package tictactoe.game.win.strategy;

import tictactoe.model.Board;
import tictactoe.model.player.Player;

public interface WinStrategy {

    boolean isWinner(Board board, Player player);

}
