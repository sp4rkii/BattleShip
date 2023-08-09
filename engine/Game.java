package engine;

import maps.*;

public class Game {
    Board board;
    Board board1;

    public Game() {
        board1 = new Board();
        board = new Board();
    }

    public Board getBoard1() {
        return board1;
    }

    public void setBoard1(Board board1) {
        this.board1 = board1;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean gameover() {
        return (board.getShips().size() == 0 && board.getAvailableships().size() == 0);
    }

}
