package ships;

import java.awt.Point;

public abstract class Ships {
    private int spaces;
    private Orientation direction;
    private Point point;
    private Point[] coordinates;

    public Ships(int spaces) {
        this.spaces = spaces;
        direction = Orientation.HORIZONTAL;
        coordinates = new Point[spaces];
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        if (spaces < 0) {
            this.spaces = 0;
            return;
        }
        this.spaces = spaces;
    }

    public Orientation getDirection() {
        return direction;
    }

    public void setDirection(Orientation direction) {
        this.direction = direction;
    }

    public boolean isDead() {
        return spaces == 0;
    }

    public abstract void rotate();
}
