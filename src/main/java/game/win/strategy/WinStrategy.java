package game.win.strategy;

import model.Board;
import model.player.Player;

public interface WinStrategy {

    // todo isWinner? Мы же в данном интерфейсе ничего не знаем, будет ли результат основан на одной строке
    // или может быть на другой логике
    boolean isWholeLineFilled(Board board, Player player);

}
