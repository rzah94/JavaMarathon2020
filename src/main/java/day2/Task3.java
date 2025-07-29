package day2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число a: ");
            int a = scanner.nextInt();
            System.out.print("Введите число b: ");
            int b = scanner.nextInt();

            int currentNumber = ++a;

            while (currentNumber < b) {
                if (currentNumber % 5 == 0 && currentNumber % 10 != 0) {
                    System.out.print(currentNumber + " ");
                }
                currentNumber++;
            }
        }
    }
}
