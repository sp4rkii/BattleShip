package engine;

import maps.*;

public class Game {
    Board board1;
    Board board11;
    Board board2;
    Board board22;

    public Game() {
        board1 = new Board();
        board11 = new Board();
        board2 = new Board();
        board22 = new Board();
    }

    public Board getBoard1() {
        return board1;
    }

    public void setBoard1(Board board1) {
        this.board1 = board1;
    }

    public Board getBoard11() {
        return board11;
    }

    public void setBoard11(Board board11) {
        this.board11 = board11;
    }

    public Board getBoard2() {
        return board2;
    }

    public void setBoard2(Board board2) {
        this.board2 = board2;
    }

    public Board getBoard22() {
        return board2;
    }

    public void setBoard22(Board board2) {
        this.board2 = board2;
    }

    public boolean gameover() {
        return (board1.getShips().size() == 0 && board1.getAvailableships().size() == 0)
                || (board2.getShips().size() == 0 && board2.getAvailableships().size() == 0);
    }

}
