package tictactoe.validator;

import static org.hamcrest.Matchers.containsString;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tictactoe.exception.value.SizeException;

public class SizeValidatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenSizeIsLessThanThree() throws SizeException {
        exception.expect(SizeException.class);
        exception.expectMessage(containsString("Size should be between 3 and 10 inclusively"));
        SizeValidator.validate(1);
    }

    @Test
    public void shouldThrowExceptionWhenSizeIsMoreThanTen() throws SizeException {
        exception.expect(SizeException.class);
        exception.expectMessage(containsString("Size should be between 3 and 10 inclusively"));
        SizeValidator.validate(11);
    }

}