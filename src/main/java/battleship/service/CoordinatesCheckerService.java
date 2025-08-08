package battleship.service;

import battleship.Map;
import battleship.exception.IllegalCoordinatesException;
import battleship.model.Cell;
import battleship.model.Coordinates;
import battleship.model.ships.Ship;

import java.util.*;

public class CoordinatesCheckerService {

    /*
    - проверка на выход за пределы поля
    - проверка что корабль расположен по горизонтали или вертикали (в одну линию)
    - проверка, что координаты расположены подряд
    - проверка, что не задеваются соседние клетки других кораблей
     */


    // Переводит строку типа "x,y" в Coordinates
    public static Coordinates inputToCoordinates(String input) throws IllegalCoordinatesException {
        if (!input.matches("\\d+,\\d+")) {
            throw new IllegalCoordinatesException("Координаты должны быть указаны в формате: x,y");
        }

        // Собираем координаты
        String[] coordinatesParts = input.split(",");

        int x = Integer.parseInt(coordinatesParts[0]);
        int y = Integer.parseInt(coordinatesParts[1]);

        return new Coordinates(x, y);
    }

    // Переводит строку типа "x1,y1;x2,y2" в List<Coordinates>
    public static List<Coordinates> inputToCoordinates(String input, Ship ship) throws IllegalCoordinatesException {

        String[] coordinateGroups = input.split(";");

        // Проверяем количество групп координат
        if (coordinateGroups.length != ship.getLives()) {
            throw new IllegalCoordinatesException("Количество палуб корабля не совпадает с количеством групп координат");
        }

        List<Coordinates> coordinateList = new ArrayList<>();

        for (String coordinateGroup : coordinateGroups) {
            coordinateList.add(inputToCoordinates(coordinateGroup));
        }

        return coordinateList;
    }

    public static boolean isWithinBounds(int coordinate) {
        return coordinate >= 0 && coordinate < Map.GRID_SIZE;
    }

    public static boolean isWithinBounds(Coordinates coordinates) throws IllegalCoordinatesException {
        if (! isWithinBounds(coordinates.getX()) && ! isWithinBounds(coordinates.getY())) {
            throw new IllegalCoordinatesException("Координаты выходят за пределы поля");
        }
        return true;
    }

    // Проверка за выход за пределы поля
    public static boolean isWithinBounds(List<Coordinates> coordinateList) throws IllegalCoordinatesException {
        for (Coordinates coordinates : coordinateList) {
            isWithinBounds(coordinates);
        }
        return true;
    }

    // примыкающие ячейки не заняты
    public static boolean isNearbyCellsFree(Cell[][] grid, List<Coordinates> coordinateList) throws IllegalCoordinatesException {

        for (Coordinates coordinates: coordinateList) {

            List<Integer> nearbyCoordinatesX = List.of(
                    coordinates.getX() - 1,
                    coordinates.getX(),
                    coordinates.getX() + 1
            );

            List<Integer> nearbyCoordinatesY = List.of(
                    coordinates.getY() - 1,
                    coordinates.getY(),
                    coordinates.getY() + 1
            );

            for (Integer x: nearbyCoordinatesX) {
                for (Integer y: nearbyCoordinatesY) {
                    if (isWithinBounds(x) && isWithinBounds(y)) {
                        if (grid[x][y].isHasShip()) {
                            throw new IllegalCoordinatesException("Координата x = " + x + ", y = " + y + " уже имеет корабль");
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean locatedInLine(List<Coordinates> coordinateList) throws IllegalCoordinatesException {
        Set<Integer> xCoords = new TreeSet<>();
        Set<Integer> yCoords = new TreeSet<>();

        for (Coordinates coordinates : coordinateList) {

            xCoords.add(coordinates.getX());
            yCoords.add(coordinates.getY());
        }

        if (xCoords.size() != 1 && yCoords.size() != 1) {
            throw new IllegalCoordinatesException("Координаты не образуют единую линию");
        }

        if (! areNumbersConsecutive(xCoords) || !areNumbersConsecutive(yCoords)) {
            throw new IllegalCoordinatesException("Координаты идут не по порядку");
        }

        return true;
    }

    public static boolean areNumbersConsecutive(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        int prev = iterator.next();

        while (iterator.hasNext()) {
            int current = iterator.next();

            if (current != prev + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectCoordinates(Cell[][] grid, List<Coordinates> coordinateList) throws IllegalCoordinatesException {

        isWithinBounds(coordinateList);
        locatedInLine(coordinateList);
        isNearbyCellsFree(grid, coordinateList);

        return true;
    }
}
