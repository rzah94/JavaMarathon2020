package day7;

import java.util.Random;

public class Player {
    private static final int MAX_STAMINA = 100;
    private static final int MIN_STAMINA_INIT = 90;
    private static final int MIN_STAMINA = 0;
    private static int countPlayers = 0;
    private String name;
    // Выносливость
    private int stamina;

    public Player(String name) {
        this.name = name;
        countPlayers++;

        Random random = new Random();

        this.stamina = random.nextInt(MAX_STAMINA - MIN_STAMINA_INIT + 1) + MIN_STAMINA_INIT;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public static void info() {
        if (countPlayers < 6) {
            System.out.printf("Команды неполные. На поле еще есть %s свободных мест%n", (6 - countPlayers));
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void run() {

        if (stamina > 0) {
            stamina--;
            System.out.printf("Игрок %s бежит, выносливость равна %d%n", this.name, this.stamina);
        } else {
            System.out.printf("Игрок %s не может бежать, т.к. находится вне поля%n", this.name);
            return;
        }

        if (stamina == 0) {
            System.out.printf("Игрок %s уходит с поля%n", this.name);
            countPlayers--;
        }
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", stamina=" + stamina + '}';
    }
}
