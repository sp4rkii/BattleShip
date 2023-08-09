package maps;

import ships.*;

public class Map {
    private Ships[][] map;

    public Map() {
        map = new Ships[15][15];
    }

    public Ships[][] getMap() {
        return map;
    }

    public void setMap(Ships[][] map) {
        this.map = map;
    }

}
