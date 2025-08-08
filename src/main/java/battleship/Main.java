package battleship;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Map mapForPlayer1 = new Map("Player1", scanner);
            mapForPlayer1.fillShips();

            System.out.println();

            Map mapForPlayer2 = new Map("Player2", scanner);
            mapForPlayer2.fillShips();

            Random random = new Random();

            Map firstMap;
            Map secondMap;

            if (random.nextInt(2) == 0) {
                firstMap = mapForPlayer1;
                secondMap = mapForPlayer2;
            } else {
                firstMap = mapForPlayer2;
                secondMap = mapForPlayer1;
            }

            while (firstMap.remainingShipsLives() > 0 && secondMap.remainingShipsLives() > 0) {
                firstMap.makeHit(secondMap);

                // firstMap выиграл, выходим из цикла
                if (secondMap.remainingShipsLives() == 0) {
                    break;
                }
                secondMap.makeHit(firstMap);
            }

            System.out.println("ИГРА ОКОНЧЕНА");

            if (firstMap.remainingShipsLives() == 0) {
                System.out.println("Победил " + secondMap.getPlayerName());
            } else {
                System.out.println("Победил " + firstMap.getPlayerName());
            }
        }
    }
}
