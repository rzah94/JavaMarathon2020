package day2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int floor = -1;

            try {
                System.out.print("Введите количество этажей: ");
                floor = scanner.nextInt();
            } catch (InputMismatchException e) {

            }

            if (floor >= 1 && floor <= 4) {
                System.out.println("Малоэтажный дом");
            } else if (floor >= 5 && floor <= 8) {
                System.out.println("Среднеэтажный дом");
            } else if (floor >= 9) {
                System.out.println("Многоэтажный дом");
            } else {
                System.err.println("Ошибка ввода");
            }
        }
    }
}
