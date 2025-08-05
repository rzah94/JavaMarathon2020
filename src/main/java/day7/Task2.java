package day7;

public class Task2 {
    public static void main(String[] args) {
        Player player1 = new Player("Женя");
        Player player2 = new Player("Витя");
        Player player3 = new Player("Кирилл");
        Player player4 = new Player("Макс");
        Player player5 = new Player("Андрей");
        Player player6 = new Player("Степа");

        Player.info();

        System.out.println(player1);

        for (int i = 0; i < 100; i++) {
            player1.run();
        }

        Player.info();

    }
}
