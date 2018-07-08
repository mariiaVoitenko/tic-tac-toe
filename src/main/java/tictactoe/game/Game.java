package tictactoe.game;

import tictactoe.configuration.ConfigurationsLoader;
import tictactoe.exception.property.ConfigurationException;
import tictactoe.exception.value.SizeException;
import tictactoe.exception.value.ValueValidationException;
import tictactoe.game.win.WinStrategiesContainer;
import tictactoe.message.MessagePrinter;
import tictactoe.model.Board;
import tictactoe.model.GameProperties;
import tictactoe.model.Position;
import tictactoe.model.player.Player;
import tictactoe.reader.PositionReaderFactory;

public class Game {

    private int maxTurnsCount;
    private GameProperties gameProperties;
    private PositionReaderFactory positionReaderFactory;

    public Game(String fileName) throws ConfigurationException, ValueValidationException {
        ConfigurationsLoader configurationsLoader = new ConfigurationsLoader(fileName);
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
