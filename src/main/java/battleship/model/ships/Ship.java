package battleship.model.ships;

import battleship.model.Coordinates;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    private final String name;
    private int lives;
    private List<Coordinates> coordinatesList = new ArrayList<>();

    protected Ship(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void decreaseNumberOfLives() {
        if (lives > 0) {
            lives -= 1;
        }
    }

    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }

    public void addCoordinates(Coordinates coordinates) {
        coordinatesList.add(coordinates);
    }

    public void setCoordinatesList(List<Coordinates> coordinateList) {
        this.coordinatesList = coordinateList;
    }
}
