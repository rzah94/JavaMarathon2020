package day14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(parseFileToObjList());
    }

    public static List<Person> parseFileToObjList() {

        List<Person> people = new ArrayList<>();

        File file = new File("src/main/java/day14/people.txt");

        Pattern pattern = Pattern.compile("^[A-Za-zА-Яа-яёЁ]+\\s+\\d+$");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!pattern.matcher(line).matches()) {
                    throw new IllegalFileException("Некорректный файл");
                }

                String[] parts = line.split("\\s+");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);

                if (age <= 0) {
                    throw new IllegalFileException("Некорректный файл");
                }

                people.add(new Person(name, age));
            }


        } catch (FileNotFoundException | IllegalFileException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return people;
    }
}
