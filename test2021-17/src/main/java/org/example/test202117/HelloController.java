package org.example.test202117;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        TextInputDialog t = new TextInputDialog();
        t.setHeaderText("Skra leikmann");
        t.setContentText("Hvad heitir leikmadur");
        Optional<String> o = t.showAndWait();
        o.ifPresentOrElse(string -> welcomeText.setText(string), () -> welcomeText.setText("ekkert nafn"));
    }
}
