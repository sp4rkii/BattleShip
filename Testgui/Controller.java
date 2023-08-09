package Testgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import shipExceptions.outOfBoundsException;
import shipExceptions.overlapException;
import ships.Ships;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import engine.Game;

public class Controller implements Initializable {
    private Component ship;
    private Game game = new Game();
    private int mapSize = 15;
    private int gridSize;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button rotateButton;
    private GridHandler backgroundGridHandler;
    private DraggableMaker draggableMaker = new DraggableMaker();
    private List<Component> components = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int paneWidth = 750;
        int paneHeight = 750;

        gridSize = (int) Math.min(paneWidth, paneHeight) / mapSize;

        new DraggableMakerGrid(paneWidth, paneHeight, gridSize, pane);
        backgroundGridHandler = new GridHandler(paneWidth, paneHeight, gridSize, pane);
        backgroundGridHandler.updateGrid();

        int rectangleCount = 5;

        int[] rectanglePositions = { 285, 286, 287, 288, 289 };

        String[] shipImages = {
                "Testgui\\Background1.png",
                "Testgui\\Background1.png",
                "Testgui\\Background1.png",
                "Testgui\\Background1.png",
                "Testgui\\Background1.png"
        };

        for (int i = 0; i < rectangleCount; i++) {

            int position = rectanglePositions[i];
            int size = (((game.getBoard1()).getAvailableships()).get(i)).getSpaces();

            int row = position / mapSize;
            int col = position % mapSize;

            int x = col * gridSize;
            int y = row * gridSize;

            if (size % 2 == 0) {
                x -= (size / 2) * gridSize - (gridSize / 2);
                y -= (size / 2) * gridSize - (gridSize / 2);
            } else {
                x -= ((size - 1) / 2) * gridSize;
                y -= ((size - 1) / 2) * gridSize;
            }

            int width = size * gridSize;
            int height = gridSize;
            Component component = new Component(width, height, x, y, Orientation.VERTICAL, shipImages[i]);
            components.add(component);

            pane.getChildren().add(component.getImageView());
            draggableMaker.makeDraggable(component.getImageView(), gridSize, components, this);
        }
    }

    public void rotate() throws outOfBoundsException, overlapException {
        if (ship != null) {
            ship.rotate();
        }
    }

    public void setShip(Component ship) {
        this.ship = ship;
    }

    public Component getShip() {
        return ship;
    }

}
