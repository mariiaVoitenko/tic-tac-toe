package tictactoe.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import tictactoe.exception.property.ConfigurationFileNotFoundException;
import tictactoe.exception.property.PropertyNotFoundException;
import tictactoe.exception.value.CharacterIsEmptyException;
import tictactoe.model.GameProperties;
import tictactoe.validator.CharacterValidator;

public class ConfigurationsLoader {

    private static final String SIZE = "size";
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String PLAYER3 = "player3";

    private Properties properties;

    public ConfigurationsLoader(String fileName) throws ConfigurationFileNotFoundException {
        properties = new Properties();
        try {
            InputStream resource = this.getClass().getClassLoader().getResourceAsStream(fileName);
            if (Objects.isNull(resource)) {
                throw new ConfigurationFileNotFoundException(fileName);
            }
            properties.load(resource);
        } catch (IOException e) {
            throw new ConfigurationFileNotFoundException(fileName);
        }
    }

    public GameProperties readGameProperties() throws PropertyNotFoundException, CharacterIsEmptyException {
        int size = readSizeProperty();
        String player1Character = readCharacterProperty(PLAYER1);
        String player2Character = readCharacterProperty(PLAYER2);
        String player3Character = readCharacterProperty(PLAYER3);
        return new GameProperties(size, player1Character, player2Character, player3Character);
    }

    private int readSizeProperty() throws PropertyNotFoundException {
        String sizeProperty = getProperty(SIZE);
        return Integer.valueOf(sizeProperty);
    }

    private String readCharacterProperty(String propertyName) throws PropertyNotFoundException, CharacterIsEmptyException {
        String charProperty = getProperty(propertyName);
        CharacterValidator.validate(charProperty);
        return charProperty;
    }

    private String getProperty(String key) throws PropertyNotFoundException {
        String property = properties.getProperty(key);
        if (Objects.isNull(property)) {
            throw new PropertyNotFoundException(key);
        }
        return property;
    }

}
