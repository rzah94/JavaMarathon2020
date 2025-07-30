package day4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {

        Random random = new Random();

        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        int maxElementsSum = 0;
        int indexMaxSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int prevIndex = i - 1;
            int nextIndex = i + 1;

            if (isIndexExists(numbers, prevIndex) && isIndexExists(numbers, nextIndex)) {

                int sum = numbers[prevIndex] + numbers[i] + numbers[nextIndex];

                if (sum > maxElementsSum) {
                    maxElementsSum = sum;
                    indexMaxSum = prevIndex;
                }
            }
        }

        System.out.println("Максимальная сумма значений: " + maxElementsSum);
        System.out.println("Индекс: " + indexMaxSum);
        System.out.println(Arrays.toString(numbers));
    }

    public static boolean isIndexExists(int[] array, int index) {
        return (index >= 0 && index < array.length);
    }
}
