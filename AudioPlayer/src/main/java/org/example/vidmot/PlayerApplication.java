package org.example.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vinnsla.Lagalistar;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Entry klasi
 */
public class PlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Lagalistar.initializeLagalisti(getClass().getResource("/vidmot/media/"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/audioplayer/heima-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 218, 410);
        stage.setTitle("Player");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main fall
     * @param args Input notanda
     */
    public static void main(String[] args) {
        launch();
    }
}
