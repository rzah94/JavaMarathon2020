package day16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task2 {

    private static Random random = new Random();

    public static void main(String[] args) {

        int amount =  1000;
        int[] numbers = getRandomNumbers(amount);

        File file = new File("src/main/java/day16/file1.txt");
        File file2 = new File("src/main/java/day16/file2.txt");
        writeNumbers(file, numbers);

        List<Integer> numbersFromFile = readFile(file);

        List<Double> avgGroupNumbers = getAvgGroupNumber(numbersFromFile);

        writeNumbers(file2, avgGroupNumbers);

        printResult(file2);



    }

    public static List<Double> getAvgGroupNumber(List<Integer> numbers) {
        if (numbers.size() % 20 != 0) {
            throw new IllegalArgumentException("Некорректное количество чисел");
        }

        List<Double> result = new ArrayList<>();

        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            group.add(numbers.get(i));

            if ((i + 1) % 20 == 0) {

                double averane = group.stream()
                        .mapToInt(Integer::valueOf)
                        .average()
                        .getAsDouble();

                result.add(averane);

                group.clear();
            }
        }

        return result;
    }

    public static int[] getRandomNumbers(int amount) {
        int[] numbers = new int[amount];

        for (int i = 0; i < amount; i++) {
            numbers[i] = random.nextInt(100);
        }

        return numbers;
    }

    public static void writeNumbers(File file, int[] numbers) {

        String content = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        try {
            Files.writeString(Path.of(file.getPath()), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNumbers(File file, List<Double> numbers) {
        String content = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        try {
            Files.writeString(Path.of(file.getPath()), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> readFile(File file) {
        try {
            String content = Files.readString(Path.of(file.getPath()));

            return Arrays.stream(content.split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printResult(File file) {
        try {
            String content = Files.readString(Path.of(file.getPath()));

            double sum = Arrays.stream(content.split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .sum();

            System.out.println(Math.round(sum));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
