package GUI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class MainSceneController {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image3;

    @FXML
    void handleDragDropped1(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image2.setImage(img);

    }

    @FXML
    void handleDragDropped2(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image4.setImage(img);

    }

    @FXML
    void handleDragDropped3(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image5.setImage(img);

    }

    @FXML
    void handleDragDropped4(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image6.setImage(img);

    }

    @FXML
    void handleDragDropped5(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image7.setImage(img);

    }

    @FXML
    void handleDragDropped6(DragEvent event) {
        Image img = event.getDragboard().getImage();
        image8.setImage(img);

    }

    @FXML
    void handleDragOver(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
    }

    @FXML
    void handleDragDetection(MouseEvent event) {

        Dragboard db = image1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(image1.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    void DragDetect(MouseEvent event) {

        Dragboard db = image3.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(image3.getImage());
        db.setContent(cb);
        event.consume();
    }

}
