package tictactoe.validator;

public class InputPositionValidator {

    public static boolean validate(String[] input) {
        try {
            int x = Integer.valueOf(input[0]);
            int y = Integer.valueOf(input[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

}
