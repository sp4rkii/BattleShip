package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class SelectScene2Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    ImageView Carrier;
    @FXML
    ImageView Cruiser;
    @FXML
    ImageView Destroyer;
    @FXML
    ImageView LongShip;
    @FXML
    ImageView Submarine;

    @FXML
    private void DragDetectionCarrier(MouseEvent event) {
        Dragboard db = Carrier.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Carrier.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void DragDetectionCruiser(MouseEvent event) {
        Dragboard db = Cruiser.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Cruiser.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void DragDetectionDestroyer(MouseEvent event) {
        Dragboard db = Destroyer.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Destroyer.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void DragDetectionLongShip(MouseEvent event) {
        Dragboard db = LongShip.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(LongShip.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void DragDetectionSubmarine(MouseEvent event) {
        Dragboard db = Submarine.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Submarine.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void SwitchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
