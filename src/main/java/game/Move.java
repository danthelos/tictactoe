package game;

import java.util.Scanner;

public class Move {
    static int[] coordinates = new int[2];

    static int[] getCoordinates() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates:");
        coordinates[0] = scanner.nextInt();
        coordinates[1] = scanner.nextInt();
        return coordinates;
    }


}
