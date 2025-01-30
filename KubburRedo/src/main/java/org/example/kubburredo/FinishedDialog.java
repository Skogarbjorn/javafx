package org.example.kubburredo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FinishedDialog extends Dialog<String> {
    @FXML
    private ButtonType fxOk;
    @FXML
    private ButtonType fxNo;
    @FXML
    private TextField fxGamer;

    public FinishedDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("finished-dialog.fxml"));
        loader.setController(this);
        setDialogPane(loader.load());

        setResultConverter(e -> {
            if (e.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return fxGamer.getText();
            }
            return null;
        });
    }
}
