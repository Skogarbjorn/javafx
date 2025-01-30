package org.example.dialogtesting;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label fxNafn;

    @FXML
    private void skraHandler() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Skra leikmann");
        dialog.setHeaderText("Hvad heitir leikmadur?");
        Optional<String> o = dialog.showAndWait();
        o.ifPresent(string -> fxNafn.setText(string));
    }
}
