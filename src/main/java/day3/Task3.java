package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < 5; i++) {

                System.out.print("Введите делимое и делитель: ");
                double dividend = scanner.nextDouble();
                double divisor = scanner.nextDouble();

                if (divisor == 0) {
                    System.out.println("Деление на ноль!");
                    continue;
                }

                System.out.println(dividend / divisor);
            }
        }

    }
}
