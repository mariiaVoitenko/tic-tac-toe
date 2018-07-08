package game;

import java.util.List;

import configuration.ConfigurationsLoader;
import exception.property.ConfigurationException;
import exception.value.SizeException;
import exception.value.ValueValidationException;
import game.win.WinStrategiesContainer;
import model.Board;
import model.GameProperties;
import model.Position;
import model.player.Player;
import reader.PositionReaderFactory;

public class Game {

    private Board board;
    private List<Player> players;
    private GameProperties gameProperties;
    private PlayerListHandler playerListHandler;
    private PositionReaderFactory positionReaderFactory;
    private int maxTurnsCount;
    private Player currentPlayer;

    public Game() throws ConfigurationException, ValueValidationException {
        ConfigurationsLoader configurationsLoader = new ConfigurationsLoader();
        gameProperties = configurationsLoader.readGameProperties();
        playerListHandler = new PlayerListHandler();
        int size = gameProperties.getSize();
        maxTurnsCount = size * size;
        positionReaderFactory = new PositionReaderFactory(size);
    }

    public void play() throws SizeException {
        board = new Board(gameProperties.getSize());
        players = playerListHandler.createInRandomOrder(gameProperties);
        WinStrategiesContainer winStrategiesContainer = new WinStrategiesContainer(board);
        int turnsCount = 0;
        boolean isGameWon;
        do {
            currentPlayer = getCurrentPlayer(turnsCount);
            MessagePrinter.printTurnMessage(currentPlayer);
            turnsCount = makeTurn() ? ++turnsCount : turnsCount;
            isGameWon = winStrategiesContainer.isGameWon(currentPlayer);
        } while (turnsCount < maxTurnsCount && !isGameWon);
        printResultMessage(isGameWon);
    }

    private Player getCurrentPlayer(int turnsCount) {
        return turnsCount == 0 ? players.get(0) : playerListHandler.getNextPlayer(currentPlayer);
    }

    private boolean makeTurn() {
        Position position = positionReaderFactory.getPositionReader(currentPlayer).readPosition();
        if (!board.isPositionFree(position)) {
            MessagePrinter.printInvalidPositionMessage(position);
            makeTurn();
        } else {
            board.markPosition(position, currentPlayer);
            board.drawBoard();
        }
        return true;
    }


    private void printResultMessage(boolean isGameWon) {
        if (isGameWon) {
            MessagePrinter.printWinGameMessage(currentPlayer);
        } else {
            MessagePrinter.printDrawGameMessage();
        }
    }

}
