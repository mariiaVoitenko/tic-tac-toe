package tictactoe;

import exception.property.ConfigurationFileNotFoundException;
import exception.property.PropertyNotFoundException;
import exception.value.CharacterIsEmptyException;
import exception.value.SizeException;
import game.Game;

public class TicTacToe {

    public static void main(String[] args) throws ConfigurationFileNotFoundException, PropertyNotFoundException, SizeException, CharacterIsEmptyException {
        new Game().play();

    }

}
