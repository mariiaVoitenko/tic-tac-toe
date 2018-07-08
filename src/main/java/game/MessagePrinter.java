package game;

import java.text.MessageFormat;

import model.Position;
import model.player.AIPlayer;
import model.player.Player;

public class MessagePrinter {

    public static void printWrongPositionMessage(){
        System.out.println("You should enter 2 digits separates by comma");
    }

    public static void printTurnMessage(Player player) {
        if (player instanceof AIPlayer) {
            System.out.println("Now it is computer turn");
        } else {
            System.out.println(MessageFormat.format("Time to make a turn for {0} player with character {1}. " +
                            "Please, enter 2 integers separated by comma"
                    , player.getId() + 1, player.getCharacter()));
        }
    }

    public static void printInvalidPositionMessage(Position position){
        System.out.println(MessageFormat.format("Position {0} {1} is already marked", position.getX(), position.getY()));
    }

    public static void printWinGameMessage(Player player){
        System.out.println(MessageFormat.format("Player {0} won the game!", player.getId()));
    }

    public static void printDrawGameMessage(){
        System.out.println("Draw!");
    }

}
