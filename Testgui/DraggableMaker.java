package Testgui;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class DraggableMaker {

    private double mouseAnchorX;
    private double mouseAnchorY;
    private Component ship;


    public void makeDraggable(Node node, int gridSize, List<Component> components, Controller controller) {
        node.setOnMousePressed(mouseEvent -> {
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                Component clickedComponent = findComponentByImageView(components, imageView);
                if (clickedComponent != null) {
                    controller.setShip(clickedComponent);
                }
            }
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

    private Component findComponentByImageView(List<Component> components, ImageView imageView) {
        for (Component component : components) {
            if (component.getImageView() == imageView) {
                return component;
            }
        }
        return null;
    }
}

    


