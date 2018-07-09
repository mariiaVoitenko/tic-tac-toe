package tictactoe.reader.impl;

import static org.fest.assertions.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.Test;

import tictactoe.model.Position;

public class InputPositionReaderTest {

    private static final int SIZE = 3;
    private static final String INPUT = "1,2";

    private InputPositionReader setUpReader() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(INPUT.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(byteArrayInputStream);
        return new InputPositionReader(scanner, SIZE);
    }

    @Test
    public void shouldReturnPositionWithXEqualToOneAndYEqualToTwo() {
        InputPositionReader inputPositionReader = setUpReader();
        Position position = inputPositionReader.readPosition();
        assertThat(position.getX()).isEqualTo(1);
        assertThat(position.getY()).isEqualTo(2);
    }

}