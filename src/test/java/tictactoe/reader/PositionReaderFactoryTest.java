package tictactoe.reader;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import tictactoe.model.player.AIPlayer;
import tictactoe.model.player.Player;
import tictactoe.reader.impl.AIPositionReader;
import tictactoe.reader.impl.InputPositionReader;

public class PositionReaderFactoryTest {

    private static final int SIZE = 3;
    private static final int ID = 1;
    private static final int ID2 = 2;
    private static final String CHARACTER = "X";
    private static final String CHARACTER2 = "O";
    private PositionReaderFactory positionReaderFactory;
    private Player player;
    private Player aiPlayer;

    @Before
    public void setUp(){
        player = new Player(ID, CHARACTER);
        aiPlayer = new AIPlayer(ID2, CHARACTER2);
        positionReaderFactory = new PositionReaderFactory(SIZE);
    }

    @Test
    public void shouldReturnAIPositionReaderWhenPlayerIsAI(){
        PositionReader positionReader = positionReaderFactory.getPositionReader(aiPlayer);
        assertThat(positionReader).isInstanceOf(AIPositionReader.class);
    }

    @Test
    public void shouldReturnInputPositionReaderWhenPlayerIsCommon(){
        PositionReader positionReader = positionReaderFactory.getPositionReader(player);
        assertThat(positionReader).isInstanceOf(InputPositionReader.class);
    }

}