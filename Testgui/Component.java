package Testgui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Component {
    private ImageView imageView;
    private int startPositionX;
    private int startPositionY;
    private Component ship;
    boolean isPlaced;

    public Component(int width, int height, int startPositionX, int startPositionY, Orientation orientation,
            String shipImagePath) {
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;

        Image image = new Image(shipImagePath);

        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setX(startPositionX);
        imageView.setY(startPositionY);

        if (orientation == Orientation.VERTICAL) {
            imageView.setRotate(90);
        }
        imageView.setOnMouseClicked(event -> {
            setShip(this);
        });
    }

    public void setShip(Component ship) {
        this.ship = ship;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void rotate() {
        imageView.setRotate(imageView.getRotate() + 90);
    }
}
