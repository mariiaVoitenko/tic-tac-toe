package tictactoe;

import exception.property.ConfigurationException;
import exception.value.ValueValidationException;
import game.Game;

public class TicTacToe {

    public static void main(String[] args) throws ConfigurationException, ValueValidationException {
        new Game().play();
    }


}
