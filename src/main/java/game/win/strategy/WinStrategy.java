package game.win.strategy;

import model.Board;
import model.player.Player;

public interface WinStrategy {

    boolean isWinner(Board board, Player player);

}
