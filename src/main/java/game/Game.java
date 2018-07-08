package game;

import java.text.MessageFormat;
import java.util.List;

import configuration.ConfigurationsLoader;
import exception.property.ConfigurationFileNotFoundException;
import exception.property.PropertyNotFoundException;
import exception.value.CharacterIsEmptyException;
import exception.value.SizeException;
import game.win.WinStrategiesContainer;
import model.Board;
import model.GameProperties;
import model.Position;
import model.player.Player;
import reader.PositionReaderFactory;

public class Game {

    private Board board;
    private List<Player> players;
    private PositionReaderFactory positionReaderFactory;
    private WinStrategiesContainer winStrategiesContainer;

    private int maxTurnsCount;
    private Player currentPlayer;

    public Game() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, SizeException, PropertyNotFoundException {
        ConfigurationsLoader configurationsLoader = new ConfigurationsLoader();
        GameProperties gameProperties = configurationsLoader.readGameProperties();
        maxTurnsCount = gameProperties.getSize() * gameProperties.getSize();
        board = new Board(gameProperties); // try move board inside play()
        positionReaderFactory = new PositionReaderFactory(gameProperties.getSize());
        players = PlayerListCreator.createInRandomOrder(gameProperties);
        winStrategiesContainer = new WinStrategiesContainer(board);
    }

    public void play() {
        int turnsCount = 0;
        currentPlayer = players.get(0);
        do {
            Position position = positionReaderFactory.getPositionReader(currentPlayer).readPosition();
            System.out.println(MessageFormat.format("Time to make a turn for {0} player", currentPlayer.getId() + 1));
            if (board.isPositionFree(position)) {
                board.markPosition(position, currentPlayer);
                board.drawBoard();
                setNextPlayer();
                turnsCount++;
            }
            System.out.println(MessageFormat.format("Position {0} {1} is already marked", position.getX(), position.getY()));
        } while (turnsCount < maxTurnsCount && winStrategiesContainer.isGameWon(currentPlayer));
    }

    private void setNextPlayer() {
        int index = players.indexOf(currentPlayer);
        boolean isCurrentIndexLast = index == players.size() - 1;
        int nextIndex = isCurrentIndexLast ? 0 : index + 1;
        currentPlayer = players.get(nextIndex);
    }


}
