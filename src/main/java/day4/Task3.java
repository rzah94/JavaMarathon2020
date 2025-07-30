package day4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        final int m = 12;
        final int n = 8;

        int[][] numbers = new int[m][n];

        Random random = new Random();

        int indexRowWithMaxNumber = 0;
        int maxRowSum = 0;

        for (int i = 0; i < numbers.length; i++) {

            int rowSum = 0;

            for (int j = 0; j < numbers[i].length; j++) {

                int number = random.nextInt(50);
                numbers[i][j] = number;

                rowSum += number;
            }


            System.out.print(Arrays.toString(numbers[i]));
            System.out.print(" = " + rowSum + " ");
            System.out.println();


            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                indexRowWithMaxNumber = i;
            }
        }


        System.out.printf("Индекс строки, сумма чисел в которой максимальна: %d (%d)", indexRowWithMaxNumber, maxRowSum);


    }
}
