package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField tfTitle;

    @FXML
    void btnokclicked(ActionEvent event) {
        Stage mainWindow = (Stage) tfTitle.getScene().getWindow();
        mainWindow.setTitle(tfTitle.getText());

    }

}
