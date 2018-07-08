package tictactoe.validator;

import org.apache.commons.lang3.StringUtils;

import tictactoe.exception.value.CharacterIsEmptyException;

public class CharacterValidator {

    public static void validate(String playerCharacter) throws CharacterIsEmptyException {
        if (StringUtils.isBlank(playerCharacter)) {
            throw new CharacterIsEmptyException();
        }
    }

}
