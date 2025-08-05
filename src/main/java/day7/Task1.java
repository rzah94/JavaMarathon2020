package day7;

import day7.Airplane;

public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("boing", 1980, 2000, 100);
        Airplane airplane2 = new Airplane("boing", 1980, 1000, 100);

        Airplane.compareAirplanes(airplane1, airplane2);
    }
}