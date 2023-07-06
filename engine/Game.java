package engine;

import maps.*;
import shipExceptions.outOfBoundsException;
import shipExceptions.overlapException;
import ships.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    private ArrayList<Ships> Availableships = new ArrayList<Ships>();
    private ArrayList<Ships> ships = new ArrayList<Ships>();
    private Ships ship = new Empty();
    private Map map;

    public Game() {
        Availableships.add(new Carrier());
        Availableships.add(new Cruiser());
        Availableships.add(new Destroyer());
        Availableships.add(new LongShip());
        Availableships.add(new Submarine());
        map = new Map();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Ships getShip() {
        return ship;
    }

    public void setShip(Ships ship) {
        this.ship = ship;
    }

    public void rotateShip() throws outOfBoundsException, overlapException {
        ship.rotate();
        Point[] Coordinates = ship.getCoordinates();
        for (int i = 0; i < ship.getCoordinates().length; i++) {
            int x = (int) Coordinates[i].getX();
            int y = (int) Coordinates[i].getY();
            if (y < 0 || y > 14 || x < 0 || x > 14) {
                throw new outOfBoundsException("Invalid coordinates");
            }
            for (int j = 0; j < ships.size(); j++) {
                Ships temp = ships.get(j);
                if (!(ship.getClass() == temp.getClass())) {
                    for (int k = 0; k < temp.getCoordinates().length; k++) {
                        int m = (int) Coordinates[k].getX();
                        int n = (int) Coordinates[k].getY();
                        if (x == m && y == n) {
                            throw new overlapException("Overlapped ships");
                        }
                    }
                }
            }
        }
    }

    public void setMap() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                map.getMap()[i][j] = new Empty();
            }
        }
    }

    public void addShip() throws outOfBoundsException, overlapException {
        if (!(ship instanceof Empty)) {
            Availableships.remove(ship);
            ships.add(ship);
            ship.rotate();
            rotateShip();
            Point[] Coordinates = ship.getCoordinates();
            for (int i = 0; i < ship.getCoordinates().length; i++) {
                int x = (int) Coordinates[i].getX();
                int y = (int) Coordinates[i].getY();
                map.getMap()[x][y] = ship;
            }
            ship = new Empty();
        }
    }

    public void removeShip() {
        if (!(ship instanceof Empty)) {
            if (ship.getSpaces() == 0) {
                ships.remove(ship);
                ship = new Empty();
            }
        }
    }

    public boolean gameover() {
        return ships.size() == 0 && Availableships.size() == 0;
    }

    public void startGame() {

    }
}
