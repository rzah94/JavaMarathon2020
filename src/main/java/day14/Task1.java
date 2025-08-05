package day14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {

    private static final Random random = new Random();

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/day14/task12.txt");

        try {
            //writeNumbers(file);
            printSumDigits(file);
        } catch (IllegalFileException e) {
            System.out.println("Некорректный входной файл");
        }


    }

    public static void writeNumbers(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (int i = 0; i < 10; i++) {
                int number = random.nextInt(100);
                writer.write(Integer.toString(number));
                writer.write('\n');
            }

        }
    }

    private static void printSumDigits(File file) throws IOException, IllegalFileException {

        if (!file.isFile()) {
            throw new IllegalFileException("Файл не найден");
        }

        int sum = 0;
        int numbersCount = 0;
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String str;
            while ((str = reader.readLine()) != null) {
                numbersCount++;

                int number = 0;

                try {
                    number = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    throw new IllegalFileException("Некорректный входной файл");
                }
                sum += number;
                numbers.add(number);

            }
        }

        if (numbersCount != 10) {
            throw new IllegalFileException("Некорректный входной файл");
        }

        System.out.println(numbers);
        System.out.println("Sum: " + sum);
    }
}
