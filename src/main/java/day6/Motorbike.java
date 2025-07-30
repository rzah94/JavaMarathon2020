package day6;

public class Motorbike {
    private int yearOfProduction;
    private String color;
    private String model;


    public Motorbike(int yearOfProduction, String color, String model) {
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public int yearDifference(int year) {
        return year - this.yearOfProduction;
    }
}
