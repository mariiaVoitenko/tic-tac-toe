package exception.value;

public class CharacterIsEmptyException extends ValueValidationException {
    public CharacterIsEmptyException() {
        super("Player character must be not empty");
    }
}