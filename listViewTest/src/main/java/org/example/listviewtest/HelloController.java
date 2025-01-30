package org.example.listviewtest;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private GamerListi fxGamer;
    @FXML
    private TextField fxInput;

    @FXML
    private void onAdd() {
        Gamer gamer = new Gamer(fxInput.getText());
        fxGamer.addGamer(gamer);
    }

    public void initialize() {
        fxGamer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

    }
}
