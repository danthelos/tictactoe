package game;

import java.util.Scanner;
import static game.PlayerType.isPlayerType;

public class Menu {

    static String[] command = new String[3];

    public void menuStart() {

        Scanner scanner = new Scanner(System.in);
        do {
            //Get string of commands eq. 'start user easy' - user play with easy AI 'start user user" - two users play, 'exit' - exit the game
            System.out.print("Input command:");
            command = scanner.nextLine().split(" ");
            //If first parameter eq exit, exit the game
            if (command[0].equals("exit")) {
                System.exit(0);
            }

        } while (!isCommandCorrect(command));

        Game game = new Game(command);
        game.play();
    }

    public boolean isCommandCorrect(String[] command) {
        if (command.length < 3) {
            System.out.println("Bad parameters!");
            return false;
        }
        if (command[0].equals("start") && isPlayerType(command[1]) && isPlayerType(command[2]))
//                (command[1].equals("easy") || command[1].equals("user")) &&
//                (command[2].equals("easy") || command[2].equals("user")))
        {
            return true;
        }
        System.out.println("Bad parameters!");
        return false;
    }
}
