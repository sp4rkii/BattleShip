package Testgui;

import Testgui.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private int gridSize = 600;

    @FXML
    private AnchorPane pane;

    private GridHandler backgroundGridHandler;
    private DraggableMakerGrid draggableMakerGrid;
    private DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int gridSize = 30; // Adjust the grid size as needed
        draggableMakerGrid = new DraggableMakerGrid(pane.getPrefWidth(), pane.getPrefHeight(), gridSize, pane);
        backgroundGridHandler = new GridHandler(pane.getPrefWidth(), pane.getPrefHeight(), gridSize, pane);
        backgroundGridHandler.updateGrid();

        // Create and add multiple components
        int rectangleCount = 5; // Number of rectangles to place on the map
        int mapSize = 15; // Size of the map

        // Define positions and sizes of rectangles
        int[] rectanglePositions = { 110, 0, 101, 10, 111 };
        int[] rectangleSizes = { 3, 4, 5, 2, 3 };

        for (int i = 0; i < rectangleCount; i++) {
            int position = rectanglePositions[i];
            int size = rectangleSizes[i];
        
            int row = position / mapSize;
            int col = position % mapSize;
        
            int x = col * gridSize;
            int y = row * gridSize;
        
            if (size % 2 == 0) {
                x -= (size / 2) * gridSize - (gridSize / 2); // Adjust x position for even-sized rectangles
                y -= (gridSize / 2); // Adjust y position for even-sized rectangles
            } else {
                x -= ((size - 1) / 2) * gridSize; // Adjust x position for odd-sized rectangles
            }
        
            int width = size * gridSize;
            int height = gridSize;
        
            Component component = new Component(width, height, x, y, Orientation.VERTICAL);
        
            pane.getChildren().add(component.getImageView());
            draggableMaker.makeDraggable(component.getImageView(), gridSize);
        }
        
        

    }

}
