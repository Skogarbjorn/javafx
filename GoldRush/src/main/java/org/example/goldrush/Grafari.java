package org.example.goldrush;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Grafari objectið sem leikmaður spilar sem
 */
public class Grafari extends Rectangle {
    /**
     * Smiður sem les fxml skrá
     * @throws IOException
     */
    public Grafari() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/goldrush/grafari-view.fxml"));
        loader.setRoot(this);
        loader.load();
    }
}
