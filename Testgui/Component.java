package Testgui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Component {
    private ImageView imageView;
    private int startPositionX;
    private int startPositionY;

    public Component(int width, int height, int startPositionX, int startPositionY, Orientation orientation) {
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;

        // Load the image
        Image image = new Image("Testgui/Background1.png");

        // Create the ImageView and set the image
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setX(startPositionX);
        imageView.setY(startPositionY);

        // Set the orientation
        if (orientation == Orientation.VERTICAL) {
            imageView.setRotate(90); // Rotate the image 90 degrees to display it vertically
        }
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
}
