package exception.value;

public class SizeException extends ValueValidationException {
    public SizeException() {
        super("Size should be between 3 and 10 inclusively");
    }
}
