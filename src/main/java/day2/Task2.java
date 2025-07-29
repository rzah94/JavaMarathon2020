package day2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число a: ");
            int a = scanner.nextInt();
            System.out.print("Введите число b: ");
            int b = scanner.nextInt();

            for (int i = ++a; i < b; i++) {

                if (i % 5 == 0 && i % 10 != 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
