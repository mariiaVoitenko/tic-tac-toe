package reader.impl;

import java.util.Scanner;

import model.Position;
import reader.PositionReader;
import validator.PositionValidator;

public class InputPositionReader implements PositionReader {

    private Scanner scanner;
    private int size;

    public InputPositionReader(int size) {
        scanner = new Scanner(System.in);
        this.size = size;
    }

    @Override
    public Position readPosition() {
        String position = scanner.nextLine();
        String[] input = position.split(" ");
        if (input.length < 2 || PositionValidator.isNotValid(input, size)) {
            System.out.println("You should enter 2 digits separates by whitespace");
            readPosition();
        }
        int x = Integer.valueOf(input[0]);
        int y = Integer.valueOf(input[1]);
        return new Position(x, y);
    }
}
