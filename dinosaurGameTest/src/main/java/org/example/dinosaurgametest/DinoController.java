package org.example.dinosaurgametest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DinoController {

    @FXML
    private Label fxLabel;

    @FXML
    private void start() {
        ViewSwitcher.setScene(fxLabel.getScene());
        ViewSwitcher.switchTo(View.GAME);
    }
}
