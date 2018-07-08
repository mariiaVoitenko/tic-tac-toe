package validator;

import exception.value.PositionIsOutOfRangeException;

public class PositionValidator {

    public static boolean isNotValid(String[] input, int maxValue) {
        try {
            int x = Integer.valueOf(input[0]);
            int y = Integer.valueOf(input[1]);
            return isNotInRange(x, maxValue) || isNotInRange(y, maxValue);
        } catch (NumberFormatException e) {
            throw new PositionIsOutOfRangeException(maxValue);
        }
    }

    private static boolean isNotInRange(int x, int maxValue) {
        return x >= maxValue && x < 0;
    }

}
