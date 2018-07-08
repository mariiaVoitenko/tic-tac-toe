package reader;

import model.player.AIPlayer;
import model.player.Player;
import reader.impl.AIPositionReader;
import reader.impl.InputPositionReader;

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
