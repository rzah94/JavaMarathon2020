package day16;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("src/main/java/day16/task1.txt");

        printResult(file);
    }

    public static void printResult(File file) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            OptionalDouble optionalDouble = Arrays.stream(content.toString().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average();

            if (optionalDouble.isEmpty()) {
                throw new IllegalArgumentException("Файл пуст");
            }

            double average = optionalDouble.getAsDouble();

            System.out.println(average + " --> " + (Math.round(average * 1000.0) / 1000.0));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

