package day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> carBrand = new ArrayList<>();
        carBrand.add("Audi");
        carBrand.add("Renault");
        carBrand.add("Lada");
        carBrand.add("BMW");
        carBrand.add("Volkswagen");

        carBrand.add(3, "Mercedes");
        carBrand.remove(0);

        System.out.println(carBrand);
    }
}
