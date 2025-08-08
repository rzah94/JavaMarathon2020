package battleship.model;

import battleship.model.ships.Ship;

public class Cell {
    private boolean hasShip = false;
    private boolean isHit = false;
    private Ship ship = null;

    public Cell() {
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public boolean isHit() {
        return isHit;
    }

    public Ship getShip() {
        return ship;
    }

    public void setHit(boolean hit) {
        isHit = hit;
        if (hit && ship != null) {
            ship.decreaseNumberOfLives();
        }
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        this.hasShip = true;
    }
}
