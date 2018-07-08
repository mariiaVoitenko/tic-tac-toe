package game;

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

    private int maxTurnsCount;
    private GameProperties gameProperties;
    private PositionReaderFactory positionReaderFactory;

    public Game() throws ConfigurationException, ValueValidationException {
        ConfigurationsLoader configurationsLoader = new ConfigurationsLoader();
        gameProperties = configurationsLoader.readGameProperties();
        maxTurnsCount =  gameProperties.getSize() *  gameProperties.getSize();
        positionReaderFactory = new PositionReaderFactory(gameProperties.getSize());
    }

    public void play() throws SizeException {
        Player currentPlayer;
        Board board = new Board(gameProperties.getSize());
        PlayerList playerList = new PlayerList(gameProperties);
        WinStrategiesContainer winStrategiesContainer = new WinStrategiesContainer(board);
        int turnsCount = 0;
        boolean isGameWon;
        do {
            currentPlayer = getCurrentPlayer(turnsCount, playerList);
            turnsCount = makeTurn(currentPlayer, board) ? ++turnsCount : turnsCount;
            isGameWon = winStrategiesContainer.isGameWon(currentPlayer);
        } while (turnsCount < maxTurnsCount && !isGameWon);
        printResultMessage(isGameWon, currentPlayer);
    }

    private Player getCurrentPlayer(int turnsCount, PlayerList playerList) {
        int currentIndex = turnsCount % playerList.getPlayers().size();
        return playerList.getPlayers().get(currentIndex);
    }

    private boolean makeTurn(Player currentPlayer, Board board) {
        MessagePrinter.printTurnMessage(currentPlayer);
        Position position = positionReaderFactory.getPositionReader(currentPlayer).readPosition();
        boolean successfulTurn = false;
        if (!board.isPositionFree(position)) {
            MessagePrinter.printInvalidPositionMessage(position);
        } else {
            board.markPosition(position, currentPlayer);
            board.drawBoard();
            successfulTurn = true;
        }
        return successfulTurn;
    }

    private void printResultMessage(boolean isGameWon, Player currentPlayer) {
        if (isGameWon) {
            MessagePrinter.printWinGameMessage(currentPlayer);
        } else {
            MessagePrinter.printDrawGameMessage();
        }
    }

}
