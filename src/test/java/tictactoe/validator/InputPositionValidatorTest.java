package tictactoe.validator;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class InputPositionValidatorTest {

    @Test
    public void shouldReturnTrueWhenInputIsValid() {
        String[] input = {"1", "0"};
        boolean result = InputPositionValidator.validate(input);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenInputIsNotValid() {
        String[] input = {"a", "b", "c"};
        boolean result = InputPositionValidator.validate(input);
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenInputIsEmpty() {
        String[] input = {};
        boolean result = InputPositionValidator.validate(input);
        assertThat(result).isFalse();
    }


}