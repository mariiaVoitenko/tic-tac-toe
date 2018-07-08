package model;

import exception.value.SizeException;
import model.player.Player;
import validator.SizeValidator;

public class Board {

    private int size;
    private String[][] board;

    public Board(GameProperties properties) throws SizeException { // todo leave only size in constructor
        size = properties.getSize();
        SizeValidator.validate(size);
        board = new String[size][size];
        fillWithEmptyCharacters();
    }

    public int getSize() {
        return size;
    }

    public void drawBoard() {
        drawUnderline();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j] + " ");
                if (j + 1 == size) {
                    System.out.println("|");
                }
            }
            drawUnderline();
        }
    }

    public void markPosition(Position position, Player player) {
        board[position.getX()][position.getY()] = player.getCharacter();
    }

   // todo доска точно хочет быть ответсвенной за проверку? Может она просто хранит пользователей и возвращает при запросе?
    public boolean isPositionMarkedWithCurrentPlayer(Position position, Player player) {
        return getValue(position).equals(player.getCharacter());
    }

    private String getValue(Position position) {
        return board[position.getX()][position.getY()];
    }

    public boolean isPositionFree(Position position) {
        return board[position.getX()][position.getY()].equals(" ");
    }


    private void fillWithEmptyCharacters() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = " ";
            }
        }
    }

    private void drawUnderline() {
        for (int i = 0; i < size * 4; i++) {
            System.out.print("-");
        }
        System.out.print("-");
        System.out.println();
    }
}
