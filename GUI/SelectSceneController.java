package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class SelectSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void SwitchToSelectScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectScene2.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
