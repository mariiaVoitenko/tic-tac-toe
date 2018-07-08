package tictactoe.reader.impl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import tictactoe.model.Position;

public class AIPositionReaderTest {

    private static final int SIZE = 3;
    private AIPositionReader aiPositionReader = new AIPositionReader(SIZE);

    @Test
    public void shouldReturnNotNullPosition() {
        Position position = aiPositionReader.readPosition();
        assertThat(position).isNotNull();
    }

    @Test
    public void shouldReturnXPositionLessThenSize() {
        Position position = aiPositionReader.readPosition();
        assertThat(position.getX()).isLessThan(SIZE);
    }

    @Test
    public void shouldReturnYPositionLessThenSize() {
        Position position = aiPositionReader.readPosition();
        assertThat(position.getY()).isLessThan(SIZE);
    }

}