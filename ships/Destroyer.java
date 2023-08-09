package ships;

import java.awt.Point;

public class Destroyer extends Ships {
    public Destroyer() {
        super(2);
    }

    @Override
    public void rotate() {
        int x = (int) this.getPoint().getX();
        int y = (int) this.getPoint().getY();
        if (this.getDirection().equals(Orientation.HORIZONTAL)) {
            this.setDirection(Orientation.VERTICAL);
            this.getCoordinates()[0] = this.getPoint();
            this.getCoordinates()[1] = new Point(x - 1, y);

        } else {

            this.setDirection(Orientation.HORIZONTAL);
            this.getCoordinates()[0] = this.getPoint();
            this.getCoordinates()[1] = new Point(x, y - 1);

        }
    }
}
