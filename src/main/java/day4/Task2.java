package day4;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        int[] numbers = new int[100];

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        int max = 0;
        int min = 1000;
        int countEndZero = 0;
        int sumEndZero = 0;

        for (int number: numbers) {
            if (number > max) max = number;
            if (number < min) min = number;
            if (number % 10 == 0) {
                countEndZero++;
                sumEndZero += number;
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("количество элементов массива, оканчивающихся на 0: " + countEndZero);
        System.out.println("сумма элементов массива, оканчивающихся на 0: " + sumEndZero);

        System.out.println(Arrays.toString(numbers));
    }
}
