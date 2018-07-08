package tictactoe.validator;

import tictactoe.model.Position;

public class PositionValidator {

    public static boolean isNotValid(Position position, int maxValue) {
        return isNotInRange(position.getX(), maxValue) || isNotInRange(position.getY(), maxValue);
    }

    private static boolean isNotInRange(int x, int maxValue) {
        return x >= maxValue || x < 0;
    }

}
