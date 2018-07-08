package model.player;

public class Player {

    private int id;
    private String character;

    public Player(int id, String character) {
        this.id = id;
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

}
