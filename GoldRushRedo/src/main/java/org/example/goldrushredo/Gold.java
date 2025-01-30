package org.example.goldrushredo;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Gold extends Rectangle {

    public Gold() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gold.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
