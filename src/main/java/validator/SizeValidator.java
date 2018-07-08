package validator;

import exception.value.SizeException;

public class SizeValidator {

    private static final int MINIMUM_FIELD_SIZE = 3;
    private static final int MAXIMUM_FIELD_SIZE = 10;

    public static void validate(int size) throws SizeException {
        if (size < MINIMUM_FIELD_SIZE || size > MAXIMUM_FIELD_SIZE) {
            throw new SizeException();
        }
    }

}
