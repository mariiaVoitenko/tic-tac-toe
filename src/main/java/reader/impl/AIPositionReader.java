package reader.impl;

import java.util.Random;

import model.Position;
import reader.PositionReader;

public class AIPositionReader implements PositionReader {

    private int size;
    private Random random;

    public AIPositionReader(int size) {
        this.size = size;
        random = new Random();
    }

    @Override
    public Position readPosition() {
        return new Position(random.nextInt(size), random.nextInt(size));
    }

}
