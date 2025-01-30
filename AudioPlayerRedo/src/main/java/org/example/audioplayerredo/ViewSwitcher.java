package org.example.audioplayerredo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    private static Scene scene;

    public static void setScene(Scene s) {
        scene = s;
    }

    public static void switchTo(View view) {
        if (scene == null) return;
        try {
            Parent root = FXMLLoader.load(ViewSwitcher.class.getResource("/org/example/audioplayerredo/" + view.getName()));
            scene.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
