package tictactoe.reader;

import tictactoe.model.player.AIPlayer;
import tictactoe.model.player.Player;
import tictactoe.reader.impl.AIPositionReader;
import tictactoe.reader.impl.InputPositionReader;

public class PositionReaderFactory {

    private PositionReader aiPositionReader;
    private PositionReader inputPositionReader;

    public PositionReaderFactory(int size) {
        aiPositionReader = new AIPositionReader(size);
        inputPositionReader = new InputPositionReader(size);
    }

    public PositionReader getPositionReader(Player player) {
        return player instanceof AIPlayer ? aiPositionReader : inputPositionReader;
    }
}
