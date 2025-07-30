package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите делимое и делитель: ");
            double dividend = scanner.nextDouble();
            double divisor = scanner.nextDouble();

            while (divisor != 0) {
                System.out.println(dividend / divisor);

                System.out.print("Введите делимое и делитель: ");
                dividend = scanner.nextDouble();
                divisor = scanner.nextDouble();
            }
        }
    }
}
