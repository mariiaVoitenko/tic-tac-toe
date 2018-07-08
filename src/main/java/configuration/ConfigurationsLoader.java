package configuration;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import exception.property.ConfigurationFileNotFoundException;
import exception.property.PropertyNotFoundException;
import exception.value.CharacterIsEmptyException;
import model.GameProperties;
import validator.CharacterValidator;

public class ConfigurationsLoader {

    private static final String SIZE = "size";
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String PLAYER3 = "player3";
    private static final String CONFIG_PROPERTIES = "config.properties";

    private Properties properties;

    public ConfigurationsLoader() throws ConfigurationFileNotFoundException {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
        } catch (IOException e) {
            throw new ConfigurationFileNotFoundException(CONFIG_PROPERTIES);
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
