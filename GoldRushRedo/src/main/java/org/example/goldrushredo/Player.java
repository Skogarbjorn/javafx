package org.example.goldrushredo;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Player extends Rectangle {

    public Player() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("player.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
