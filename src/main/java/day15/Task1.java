package day15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/day15/shoes.csv");

        List<Shoes> shoes = getShoes(file);

        List<Shoes> missingShoes = shoes.stream()
                .filter(s -> s.getQuantity() == 0)
                .toList();

        System.out.println(missingShoes);

        File saveFile = new File("src/main/java/day15/missing_shoes.txt");
        saveShoes(missingShoes, saveFile);

    }

    public static List<Shoes> getShoes(File file) throws FileNotFoundException {
        List<Shoes> shoes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] parts = line.split(";");

                    String shoesName = parts[0];
                    int shoesSize = Integer.parseInt(parts[1]);
                    int shoesQuantity = Integer.parseInt(parts[2]);

                    shoes.add(new Shoes(shoesName, shoesSize, shoesQuantity));
                } catch (Exception e) {
                    throw new RuntimeException("Некорректный файл");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return shoes;
    }

    public static void saveShoes(List<Shoes> shoes, File file) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (Shoes s : shoes) {
                writer.write(String.format("%s, %d, %d%n", s.getName(), s.getSize(), s.getQuantity()));
            }

        }
    }
}
