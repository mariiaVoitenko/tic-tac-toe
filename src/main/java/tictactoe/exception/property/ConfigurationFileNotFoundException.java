package tictactoe.exception.property;

import java.text.MessageFormat;

public class ConfigurationFileNotFoundException extends ConfigurationException {

    public ConfigurationFileNotFoundException(String fileName) {
        super(MessageFormat.format("File with name {0} is not found", fileName));
    }

}
