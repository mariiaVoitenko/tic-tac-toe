package exception.value;

import java.text.MessageFormat;

public class PositionIsOutOfRangeException extends RuntimeException {

    public PositionIsOutOfRangeException(int maxValue) {
        super(MessageFormat.format("Position should be between 0 and {0}", maxValue));
    }

}
