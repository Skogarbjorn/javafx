package org.example.dinosaurgametest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BarApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(BarApp.class.getResource("menubar.fxml"));
        Scene s = new Scene(loader.load(), 300, 300);
        stage.setScene(s);
        stage.show();
    }
}
