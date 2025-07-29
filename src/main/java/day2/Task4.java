package day2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Введите x: ");
            double x = scanner.nextDouble();
            double y = 420;

            if (x >= 5) {
                y = (Math.pow(x, 2) - 10) / (x + 7);
            } else if (x > -3 || x < 5) {
                y = (x + 3) * (Math.pow(x, 2) - 2);
            }
            System.out.println("y = " + y);

        }

    }
}
