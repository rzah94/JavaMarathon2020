package day5;

public class Task1 {
    public static void main(String[] args) {

        Car car = new Car();
        car.setYearOfProduction(2025);
        car.setColor("Черный");
        car.setModel("Xl-438");

        System.out.println(car.getYearOfProduction());
        System.out.println(car.getColor());
        System.out.println(car.getModel());

    }
}
