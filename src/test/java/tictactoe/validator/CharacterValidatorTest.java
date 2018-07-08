package tictactoe.validator;

import static org.hamcrest.Matchers.containsString;

import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tictactoe.exception.value.CharacterIsEmptyException;

public class CharacterValidatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenCharacterIsBlank() throws CharacterIsEmptyException {
        exception.expect(CharacterIsEmptyException.class);
        exception.expectMessage(containsString("Player character must be not empty"));
        CharacterValidator.validate(StringUtils.EMPTY);
    }
}