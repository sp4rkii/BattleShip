package Testgui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class GridHandler extends GridBase {

    private String backgroundImageUrl = "Testgui\\istockphoto-1300107681-612x612.jpg";

    public GridHandler(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        super(planeWidth, planeHeight, gridSize, anchorPane);
    }

    public void updateGrid() {
        Image backgroundImage = new Image(backgroundImageUrl);

        for (int i = 0; i < getTileAmount(); i++) {
            int x = (i % getTilesAcross());
            int y = (i / getTilesAcross());

            Rectangle rectangle = new Rectangle(x * getGridSize(), y * getGridSize(), getGridSize(), getGridSize());
            rectangle.setFill(new ImagePattern(backgroundImage)); // Set the background image

            getAnchorPane().getChildren().add(rectangle);
        }
    }
}
