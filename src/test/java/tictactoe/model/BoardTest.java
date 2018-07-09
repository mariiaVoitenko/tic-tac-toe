package tictactoe.model;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tictactoe.exception.value.SizeException;
import tictactoe.model.player.Player;

public class BoardTest {

    private static final int ID = 1;
    private static final int SIZE = 3;
    private static final String CHARACTER = "X";
    private static final String BLANK_STRING = " ";

    private Board board;
    private Player player;
    private Random random = new Random();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @Before
    public void setUp() throws SizeException {
        board = new Board(SIZE);
        player = new Player(ID, CHARACTER);
        System.setOut(new PrintStream(outContent));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenFileDoesNotExist() throws SizeException {
        exception.expect(SizeException.class);
        exception.expectMessage(containsString("Size should be between 3 and 10 inclusively"));
        new Board(15);
    }

    @Test
    public void shouldReturnSize() {
        assertThat(board.getSize()).isEqualTo(SIZE);
    }

    @Test
    public void shouldBeFilledWithEmptyCharactersWhenCreated() {
        Position randomPosition = getRandomPosition();
        assertThat(board.getValue(randomPosition)).isEqualTo(BLANK_STRING);
    }

    @Test
    public void shouldPrintBoard() {
        board.drawBoard();
        assertThat(outContent.toString()).isNotEmpty();
    }

    @Test
    public void shouldMarkPosition() {
        Position position = getRandomPosition();
        board.markPosition(position, player);
        assertThat(board.getValue(position)).isEqualTo(CHARACTER);
    }

    @Test
    public void shouldReturnTrueWhenPositionIsFree() {
        Position position = new Position(0,0);
        Position position2 = new Position(0,1);
        board.markPosition(position, player);
        assertThat(board.isPositionFree(position2)).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenPositionIsNotFree() {
        Position position = getRandomPosition();
        board.markPosition(position, player);
        assertThat(board.isPositionFree(position)).isFalse();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private Position getRandomPosition() {
        return new Position(random.nextInt(SIZE), random.nextInt(SIZE));
    }
}