package battleship;

import battleship.exception.IllegalCoordinatesException;
import battleship.model.Cell;
import battleship.model.Coordinates;
import battleship.model.ships.DoubleDeckShip;
import battleship.model.ships.Ship;
import battleship.model.ships.SingleDeckShip;
import battleship.service.CoordinatesCheckerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    private final Scanner scanner;
    private final String playerName;
    public static final int GRID_SIZE = 10;
    private final Cell[][] grid = new Cell[GRID_SIZE][GRID_SIZE];

    private final List<Ship> ships = List.of(
        new DoubleDeckShip(), new SingleDeckShip()
    );

    public String getPlayerName() {
        return playerName;
    }

    public Map(String playerName, Scanner scanner) {
        this.scanner = scanner;
        this.playerName = playerName;
        fillGridByCells();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Coordinates askCoordinatesForHits(Map enemyMap) {
        boolean isValidCoords = false;

        Coordinates coordinates = null;

        clearConsole();
        enemyMap.printMapWithHits();
        System.out.println("Стреляет игрок " + playerName + ". Введите координаты для удара (формат x,y): ");

        while (!isValidCoords) {

            String input = scanner.nextLine();

            try {
                coordinates = CoordinatesCheckerService.inputToCoordinates(input);
                // Проверка, что координаты не выходят за пределы поля
                CoordinatesCheckerService.isWithinBounds(coordinates);

                // Проверка, что ранее сюда уже не стреляли
                if (enemyMap.getGrid()[coordinates.getX()][coordinates.getY()].isHit()) {
                    throw new IllegalCoordinatesException("Вы уже стреляли");
                }

                isValidCoords = true;
            } catch (IllegalCoordinatesException e) {
                System.err.println("Ошибка. " + e.getMessage() + ". Попробуйте снова:");
            }
        }

        return coordinates;
    }

    public void makeHit(Map enemyMap) {

        boolean isSuccessHit = true;

        while (isSuccessHit && enemyMap.remainingShipsLives() > 0) {

            Coordinates coordinates = askCoordinatesForHits(enemyMap);
            Cell cell = enemyMap.getGrid()[coordinates.getX()][coordinates.getY()];

            cell.setHit(true);

            clearConsole();
            enemyMap.printMapWithHits();

            if (cell.isHasShip()) {
                if (cell.getShip().getLives() == 0) {
                    System.out.print("УБИЛ!");
                } else {
                    System.out.print("ПОПАЛ!");
                }

            } else {
                isSuccessHit = false;
                System.out.print("МИМО!");
            }

            System.out.println(" Осталось не подбитых палуб: " + enemyMap.remainingShipsLives());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }

    private void fillGridByCells() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Cell();
            }
        }
    }

    public int remainingShipsLives() {
        return ships.stream()
                .mapToInt(Ship::getLives)
                .sum();
    }

    public void fillShips() {

        clearConsole();
        System.out.println("Начнем расставлять корабли на поле " + playerName + ". Другой игрок не смотри!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Ship ship : ships) {
            List<Coordinates> coordinateList = askCoordinatesForFillShips(ship);
            setShip(ship, coordinateList);

            clearConsole();
            printMapWithShips();
            System.out.println("Корабль установлен");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setShip(Ship ship, List<Coordinates> coordinateList) {
        for (Coordinates coordinates : coordinateList) {
            grid[coordinates.getX()][coordinates.getY()].setShip(ship);
        }

        ship.setCoordinatesList(coordinateList);
    }

    private List<Coordinates> askCoordinatesForFillShips(Ship ship) {
        boolean isValidCoords = false;

        List<Coordinates> coordinateList = new ArrayList<>();
        clearConsole();
        printMapWithShips();
        System.out.println("Введите координаты " + ship.getName() + ": (формат x,y;x,y;...): ");

        while (!isValidCoords) {

            String input = scanner.nextLine();

            try {
                coordinateList = CoordinatesCheckerService.inputToCoordinates(input, ship);
                CoordinatesCheckerService.isCorrectCoordinates(grid, coordinateList);
                isValidCoords = true;
            } catch (IllegalCoordinatesException e) {
                System.err.println("Ошибка. " + e.getMessage() + ". Попробуйте снова:");
            }
        }

        return coordinateList;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    public void printMapWithShips() {

        String[] emojiNumbers = {"0\uFE0F⃣", "1\uFE0F⃣", "2\uFE0F⃣", "3\uFE0F⃣", "4\uFE0F⃣", "5\uFE0F⃣",
        "6\uFE0F⃣", "7\uFE0F⃣", "8\uFE0F⃣", "9\uFE0F⃣"};

        System.out.print("     ");
        for (int col = 0; col < grid[0].length; col++) {

            if (col < emojiNumbers.length) {
                System.out.print(String.format("%5s", emojiNumbers[col]));
            }
        }
        System.out.println();

        for (int x = 0; x < grid.length; x++) {
            if (x < emojiNumbers.length) {
                System.out.print(String.format("%5s", emojiNumbers[x]));
            }

            for (int y = 0; y < grid[x].length; y++) {

                if (grid[y][x].isHasShip()) {
                    System.out.print(String.format("%5s", "\uD83D\uDEA2️"));
                } else {
                    System.out.print(String.format("%5s", "◻️"));
                }
            }
            System.out.println();
        }
    }

    public void printMapWithHits() {

        String[] emojiNumbers = {"0\uFE0F⃣", "1\uFE0F⃣", "2\uFE0F⃣", "3\uFE0F⃣", "4\uFE0F⃣", "5\uFE0F⃣",
                "6\uFE0F⃣", "7\uFE0F⃣", "8\uFE0F⃣", "9\uFE0F⃣"};

        System.out.print("    ");
        for (int col = 0; col < grid[0].length; col++) {

            if (col < emojiNumbers.length) {
                System.out.print(String.format("%6s", emojiNumbers[col]));
            }
        }
        System.out.println();

        for (int x = 0; x < grid.length; x++) {
            if (x < emojiNumbers.length) {
                System.out.print(String.format("%5s", emojiNumbers[x]));
            }

            for (int y = 0; y < grid[x].length; y++) {

                Cell cell = grid[y][x];

                // В ячейку не стреляли
                if (! cell.isHit()) {
                    System.out.print(String.format("%5s", "\uD83D\uDFE6"));
                    continue;
                }

                // В ячейку стреляли, на ней нет корабля
                if (! cell.isHasShip()) {
                    System.out.print(String.format("%5s", "⏹\uFE0F"));
                    continue;
                }

                // В ячейку стреляли, на ней корабль, полностью потоплен
                if (cell.getShip().getLives() == 0) {
                    System.out.print(String.format("%5s", "\uD83D\uDFEB"));
                    continue;
                }

                System.out.print(String.format("%5s", "\uD83D\uDFE7"));
            }
            System.out.println();
        }
    }

}
