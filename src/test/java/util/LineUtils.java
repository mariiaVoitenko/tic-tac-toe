package util;

import tictactoe.model.Board;
import tictactoe.model.Position;
import tictactoe.model.player.Player;

public class LineUtils {

    public static void markHorizontalLine(Board board, Player player) {
        board.markPosition(new Position(0, 0), player);
        board.markPosition(new Position(0, 1), player);
        board.markPosition(new Position(0, 2), player);
    }

    public static void markVerticalLine(Board board, Player player) {
        board.markPosition(new Position(0, 0), player);
        board.markPosition(new Position(1, 0), player);
        board.markPosition(new Position(2, 0), player);
    }

    public static void markRightDiagonalLine(Board board, Player player) {
        board.markPosition(new Position(0, 0), player);
        board.markPosition(new Position(1, 1), player);
        board.markPosition(new Position(2, 2), player);
    }

    public static void markLeftDiagonalLine(Board board, Player player) {
        board.markPosition(new Position(0, 2), player);
        board.markPosition(new Position(1, 1), player);
        board.markPosition(new Position(2, 0), player);
    }

}
