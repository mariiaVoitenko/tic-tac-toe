package tictactoe.configuration;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;

import java.text.MessageFormat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tictactoe.exception.property.ConfigurationFileNotFoundException;
import tictactoe.exception.property.PropertyNotFoundException;
import tictactoe.exception.value.CharacterIsEmptyException;
import tictactoe.model.GameProperties;

public class ConfigurationsLoaderIntegrationTest {

    private static final int EXPECTED_SIZE = 3;
    private static final String SIZE = "size";
    private static final String EXPECTED_PLAYER1_CHARACTER = "X";
    private static final String EXPECTED_PLAYER2_CHARACTER = "Y";
    private static final String EXPECTED_PLAYER3_CHARACTER = "Z";
    private static final String WRONG_PROPERTIES = "wrong.properties";
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String INVALID_PROPERTIES = "invalid.properties";
    private static final String INVALID_CHARACTER_PROPERTIES = "invalid.character.properties";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ConfigurationsLoader configurationsLoader;

    @Test
    public void shouldThrowExceptionWhenFileDoesNotExist() throws ConfigurationFileNotFoundException {
        exception.expect(ConfigurationFileNotFoundException.class);
        String wrongFileMessage = MessageFormat.format("File with name {0} is not found", WRONG_PROPERTIES);
        exception.expectMessage(containsString(wrongFileMessage));
        new ConfigurationsLoader(WRONG_PROPERTIES);
    }

    @Test
    public void shouldSizeEqualToThreeWhenConfigurationFileIsValid() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        configurationsLoader = new ConfigurationsLoader(CONFIG_PROPERTIES);
        GameProperties gameProperties = configurationsLoader.readGameProperties();
        assertThat(gameProperties.getSize()).isEqualTo(EXPECTED_SIZE);
    }

    @Test
    public void shouldPlayer1CharacterEqualToXWhenConfigurationFileIsValid() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        configurationsLoader = new ConfigurationsLoader(CONFIG_PROPERTIES);
        GameProperties gameProperties = configurationsLoader.readGameProperties();
        assertThat(gameProperties.getPlayerCharacters().get(0)).isEqualTo(EXPECTED_PLAYER1_CHARACTER);
    }

    @Test
    public void shouldPlayer2CharacterEqualToYWhenConfigurationFileIsValid() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        configurationsLoader = new ConfigurationsLoader(CONFIG_PROPERTIES);
        GameProperties gameProperties = configurationsLoader.readGameProperties();
        assertThat(gameProperties.getPlayerCharacters().get(1)).isEqualTo(EXPECTED_PLAYER2_CHARACTER);
    }

    @Test
    public void shouldPlayer3CharacterEqualToZWhenConfigurationFileIsValid() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        configurationsLoader = new ConfigurationsLoader(CONFIG_PROPERTIES);
        GameProperties gameProperties = configurationsLoader.readGameProperties();
        assertThat(gameProperties.getPlayerCharacters().get(2)).isEqualTo(EXPECTED_PLAYER3_CHARACTER);
    }

    @Test
    public void shouldThrowPropertyNotFoundExceptionWhenConfigurationFileContainsNoSizeProperty() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        exception.expect(PropertyNotFoundException.class);
        String propertyNotFoundMessage = MessageFormat.format("Property with name {0} is not found", SIZE);
        exception.expectMessage(containsString(propertyNotFoundMessage));
        new ConfigurationsLoader(INVALID_PROPERTIES).readGameProperties();
    }

    @Test
    public void shouldThrowCharacterIsEmptyExceptionWhenConfigurationFileContainsWrongCharacterProperty() throws ConfigurationFileNotFoundException, CharacterIsEmptyException, PropertyNotFoundException {
        exception.expect(CharacterIsEmptyException.class);
        exception.expectMessage(containsString("Player character must be not empty"));
        new ConfigurationsLoader(INVALID_CHARACTER_PROPERTIES).readGameProperties();
    }

}