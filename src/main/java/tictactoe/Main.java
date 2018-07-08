package tictactoe;

import tictactoe.exception.property.ConfigurationException;
import tictactoe.exception.value.ValueValidationException;
import tictactoe.game.Game;

public class Main {

    private static final String CONFIG_PROPERTIES = "config.properties";

    public static void main(String[] args) throws ConfigurationException, ValueValidationException {
        new Game(CONFIG_PROPERTIES).play();
    }


}
