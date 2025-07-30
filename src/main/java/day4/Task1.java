package day4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        int countAbove8 = 0;
        int countEquals1 = 0;
        int countEven = 0;
        int countOdd = 0;
        int totalSum = 0;

        for (int i = 0; i < arraySize; i++) {

            int number = random.nextInt(10);

            array[i] = number;

            if (number > 8) countAbove8++;
            if (number == 1) countEquals1++;
            if (number % 2 == 0) countEven++;
            else countOdd++;
            totalSum += number;
        }

        System.out.println(Arrays.toString(array));

        System.out.println("Информация о массиве:");
        System.out.println("Длина массива: " + array.length);

        System.out.println("Количество чисел больше 8: " + countAbove8);
        System.out.println("Количество чисел равных 1: " + countEquals1);
        System.out.println("Количество четных чисел: " + countEven);
        System.out.println("Количество нечетных чисел: " + countOdd);
        System.out.println("Сумма всех элементов массива: " + totalSum);

        scanner.close();
    }


}
