package engine;

import maps.*;
import shipExceptions.outOfBoundsException;
import shipExceptions.overlapException;
import ships.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    private ArrayList<Ships> ships = new ArrayList<Ships>();
    private Ships ship;
    private Map Emap;
    private Map map;

    public Game() {
        ships.add(new Carrier());
        ships.add(new Cruiser());
        ships.add(new Destroyer());
        ships.add(new LongShip());
        ships.add(new Submarine());
        Emap = new Map();
        map = new Map();
    }

    public Ships getShip() {
        return ship;
    }

    public void setShip(Ships ship) {
        this.ship = ship;
    }

    public void rotateShip() throws outOfBoundsException,overlapException {
        ship.rotate();
        Point[] Coordinates = ship.getCoordinates();
        for (int i = 0; i < ship.getCoordinates().length; i++) {
            int x = (int) Coordinates[i].getX();
            int y = (int) Coordinates[i].getY();
            if (y < 0 || y > 14 || x < 0 || x > 14) {
                throw new outOfBoundsException("Invalid coordinates");
            }
            for(int j=0;j<ships.size();j++){
                Ships temp=ships.get(j);
                if(!(ship.getClass() == temp.getClass())){
                    for(int k=0;k<temp.getCoordinates().length;k++){
                         int m = (int) Coordinates[k].getX();
                         int n = (int) Coordinates[k].getY();
                        if(x==m && y==n){
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
                Emap.getMap()[i][j] = new Empty();
                map.getMap()[i][j] = new Empty();
            }
        }
    }
    
}
