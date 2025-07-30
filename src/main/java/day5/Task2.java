package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorbike motorbike = new Motorbike(2025, "Черный", "Xl-438");

        System.out.println(motorbike.getYearOfProduction());
        System.out.println(motorbike.getColor());
        System.out.println(motorbike.getModel());
    }
}
