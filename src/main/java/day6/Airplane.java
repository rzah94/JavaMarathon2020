package day6;

public class Airplane {
    // изготовитель
    private String producer;

    // год выпуска
    private int year;

    // длина
    private int length;
    // вес
    private int weight;

    // количество топлива в баке
    private int fuel = 0;

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
    }

    public int getFuel() {
        return fuel;
    }

    public void info() {
        System.out.printf("Изготовитель: %s, год выпуска: %d, длина: %d, вес: %d, количество топлива в баке: %d",
                this.producer, this.year, this.length, this.weight, this.fuel);
    }

    public void fillUp(int fuelAmount) {
        this.fuel += fuelAmount;
    }
}
