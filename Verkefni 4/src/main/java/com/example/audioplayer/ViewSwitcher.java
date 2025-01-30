package com.example.audioplayer;

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
            Parent root = FXMLLoader.load(PlayerApplication.class.getResource(view.getFxmlName()));
            scene.setRoot(root);

        } catch (IOException ignored) {}
    }
}
