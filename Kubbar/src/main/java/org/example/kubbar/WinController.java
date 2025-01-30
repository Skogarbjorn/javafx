package org.example.kubbar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WinController {
    private static HelloController helloController;
    @FXML
    private void onAgain(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        helloController.reset();
    }

    public static void setController(HelloController e) {
        helloController = e;
    }
}
