package exception.value;

public class CharacterIsEmptyException extends Exception {
    public CharacterIsEmptyException() {
        super("Player character must be not empty");
    }
}