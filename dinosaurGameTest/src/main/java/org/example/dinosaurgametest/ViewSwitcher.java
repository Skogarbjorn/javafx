package org.example.dinosaurgametest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view) {
        try {
            Parent root = FXMLLoader.load(DinoApplication.class.getResource(view.getName()));
            scene.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
