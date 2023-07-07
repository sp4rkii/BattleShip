package Testgui;

import javafx.scene.Node;

public class DraggableMaker {

    private double mouseAnchorX;
    private double mouseAnchorY;

    public void makeDraggable(Node node, int gridSize) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });
    
        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
        });
    
        node.setOnMouseReleased(mouseEvent -> {
            node.setLayoutX(Math.round(node.getLayoutX() / gridSize) * gridSize);
            node.setLayoutY(Math.round(node.getLayoutY() / gridSize) * gridSize);
        });
    }
    
    
}
