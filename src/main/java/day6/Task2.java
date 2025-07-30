package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("boing", 1980, 2000, 100);
        airplane.fillUp(10);
        airplane.info();
    }
}
