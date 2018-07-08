package tictactoe.validator;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import tictactoe.model.Position;

public class PositionValidatorTest {

    @Mock
    public Position position = mock(Position.class);

    @Test
    public void shouldReturnTrueWhenPositionIsNotValid() {
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(-1);
        boolean result = PositionValidator.isNotValid(position, 0);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenXIsInRangeAndYNot() {
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(-1);
        boolean result = PositionValidator.isNotValid(position, 2);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenYIsInRangeAndXNot() {
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(1);
        boolean result = PositionValidator.isNotValid(position, 2);
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenPositionIsValid() {
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(0);
        boolean result = PositionValidator.isNotValid(position, 2);
        assertThat(result).isFalse();
    }

}