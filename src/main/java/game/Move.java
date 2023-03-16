package game;

import java.util.Random;
import java.util.Scanner;

public class Move {
    static int[] coordinates = new int[2];

    static int[] getCoordinates() {
        Scanner scanner = new Scanner(System.in);
        do {
            //coordinates should be given in "real" manner - from 1 to 3 (for 3x3 board, not from 0 to 2 - app will change it to array coordinates
            System.out.print("Enter the coordinates:");
            try {
                coordinates[0] = scanner.nextInt() - 1;
                coordinates[1] = scanner.nextInt() - 1;
            }
            catch (Exception notNumber) {
                System.out.println("You should enter numbers!");
                getCoordinates();
            }
        } while (!ifCoordinatesOK(coordinates));

        return coordinates;
    }

    static int[] printCoordinates(int[] coordinates) {
        int[] coordinatesToPrint = new int[2];

        coordinatesToPrint[0] = coordinates[0] + 1;
        coordinatesToPrint[1] = coordinates[1] + 1;

        return coordinatesToPrint;
    }

    static boolean ifCoordinatesOK(int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];

        if(x < 0 || x >= 3 || y < 0 || y >= 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (!Board.isCellEmpty(coordinates)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    static int[] randomCoordinates() {
        Random random = new Random();
        int lower = 0;
        int upper = 2;
        int intervalLength = upper - lower + 1;

        do {
            coordinates[0] = random.nextInt(intervalLength) + lower;
            coordinates[1] = random.nextInt(intervalLength) + lower;
        } while (!Board.isCellEmpty(coordinates));

        return coordinates;
    }


}
