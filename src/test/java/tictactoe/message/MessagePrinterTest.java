package tictactoe.message;

import static org.fest.assertions.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tictactoe.model.Position;
import tictactoe.model.player.AIPlayer;
import tictactoe.model.player.Player;

public class MessagePrinterTest {

    private static final int ID = 1;
    private static final int X = 1;
    private static final int Y = 1;
    private static final String CHARACTER = "X";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Player player;
    private Player aiPlayer;
    private Position position;

    @Before
    public void setUp() {
        player = new Player(ID, CHARACTER);
        aiPlayer = new AIPlayer(ID, CHARACTER);
        position = new Position(X, Y);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintWrongPositionMessage() {
        MessagePrinter.printWrongPositionMessage();
        assertThat("You should enter 2 digits separates by comma" + LINE_SEPARATOR).isEqualTo(outContent.toString());
    }

    @Test
    public void shouldPrintTurnMessageForCommonPlayer() {
        MessagePrinter.printTurnMessage(player);
        String message = MessageFormat.format("Time to make a turn for {0} player with character {1}. " +
                "Please, enter 2 integers separated by comma" + LINE_SEPARATOR, ID + 1, CHARACTER);
        assertThat(message).isEqualTo(outContent.toString());
    }

    @Test
    public void shouldPrintTurnMessageForAIPlayer() {
        MessagePrinter.printTurnMessage(aiPlayer);
        assertThat("Now it is computer turn" + LINE_SEPARATOR).isEqualTo(outContent.toString());
    }

    @Test
    public void shouldPrintInvalidPositionMessage() {
        MessagePrinter.printInvalidPositionMessage(position);
        String message = MessageFormat.format("Position {0} {1} is already marked", position.getX(), position.getY());
        assertThat(message + LINE_SEPARATOR).isEqualTo(outContent.toString());
    }

    @Test
    public void shouldPrintWinGameMessage() {
        MessagePrinter.printWinGameMessage(player);
        String message = MessageFormat.format("Player {0} won the tictactoe.game!", player.getId());
        assertThat(message + LINE_SEPARATOR).isEqualTo(outContent.toString());
    }

    @Test
    public void shouldPrintDrawMessage() {
        MessagePrinter.printDrawGameMessage();
        assertThat("Draw!" + LINE_SEPARATOR).isEqualTo(outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}