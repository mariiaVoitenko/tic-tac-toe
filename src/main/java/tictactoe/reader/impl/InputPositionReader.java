package tictactoe.reader.impl;

import java.util.Scanner;

import tictactoe.message.MessagePrinter;
import tictactoe.model.Position;
import tictactoe.reader.PositionReader;
import tictactoe.validator.InputPositionValidator;
import tictactoe.validator.PositionValidator;

public class InputPositionReader implements PositionReader {

    private Scanner scanner;
    private int size;

    public InputPositionReader(int size) {
        scanner = new Scanner(System.in);
        this.size = size;
    }

    @Override
    public Position readPosition() {
        do {
            String positionInput = scanner.nextLine();
            String[] input = positionInput.split(",");
            if (!InputPositionValidator.validate(input)) {
                MessagePrinter.printWrongPositionMessage();
                continue;
            }
            int x = Integer.valueOf(input[0]);
            int y = Integer.valueOf(input[1]);
            Position position = new Position(x, y);
            if (PositionValidator.isNotValid(position, size)) {
                MessagePrinter.printWrongPositionMessage();
                continue;
            }
            return position;
        }
        while (true);
    }
}
