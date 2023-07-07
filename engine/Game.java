package engine;

import maps.*;

public class Game {
    Board board1;

    Map map1;
    Board board2;
    Map map2;

    public Game() {
        board1 = new Board();
        map1 = new Map();
        board2 = new Board();
        map2 = new Map();
    }

    public Board getBoard1() {
        return board1;
    }

    public void setBoard1(Board board1) {
        this.board1 = board1;
    }

    public Map getMap1() {
        return map1;
    }

    public void setMap1(Map map1) {
        this.map1 = map1;
    }

    public Board getBoard2() {
        return board2;
    }

    public void setBoard2(Board board2) {
        this.board2 = board2;
    }

    public Map getMap2() {
        return map2;
    }

    public void setMap2(Map map2) {
        this.map2 = map2;
    }

    public boolean gameover() {
        return (board1.getShips().size() == 0 && board1.getAvailableships().size() == 0)
                || (board2.getShips().size() == 0 && board2.getAvailableships().size() == 0);
    }

}
