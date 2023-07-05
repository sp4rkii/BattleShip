package engine;

import maps.*;
import shipExceptions.outOfBoundsException;
import ships.*;
import java.awt.*;

public class Game {
    private Ships[] ships;
    private Ships ship;
    private Map Emap;
    private Map map;

    public Game() {
        ships = new Ships[5];
        ships[0] = new Carrier();
        ships[1] = new Cruiser();
        ships[2] = new Destroyer();
        ships[3] = new LongShip();
        ships[4] = new Submarine();
        Emap = new Map();
        map = new Map();
    }

    public Ships getShip() {
        return ship;
    }

    public void setShip(Ships ship) {
        this.ship = ship;
    }

    public void rotateShip() throws outOfBoundsException {
        ship.rotate();
        Point[] Coordinates = ship.getCoordinates();
        for (int i = 0; i < ship.getCoordinates().length; i++) {
            int x = (int) Coordinates[i].getX();
            int y = (int) Coordinates[i].getY();
            if (y < 0 || y > 14 || x < 0 || x > 14) {
                throw new outOfBoundsException("Invalid coordinates");
            }
        }
    }

    public void setMap() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Emap.getMap()[i][j] = new Empty();
                map.getMap()[i][j] = new Empty();
            }
        }
    }
}
