package tictactoe.exception.property;

import java.text.MessageFormat;

public class PropertyNotFoundException extends ConfigurationException {

    public PropertyNotFoundException(String key) {
        super(MessageFormat.format("Property with name {0} is not found", key));
    }

}
