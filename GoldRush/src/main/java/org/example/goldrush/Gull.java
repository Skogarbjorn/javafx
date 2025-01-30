package org.example.goldrush;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Gull object sem leikmaður nær í
 */
public class Gull extends Rectangle {

    /**
     * Smiður sem les fxml skrá
     */
    public Gull() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/goldrush/gull-view.fxml"));
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
