package day5;

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
}
