package org.example.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Skiptir um senu með mismunandi views
 */
public class ViewSwitcher {
    private static Scene scene;

    /**
     * Setur senuna sem scene
     * @param scene Sena sem við viljum setja
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skiptir í setta senu
     * @param view Enum view
     */
    public static void switchTo(View view) {
        if (scene == null) {
            return;
        }
        try {
            Parent root = FXMLLoader.load(ViewSwitcher.class.getResource("/org/example/audioplayer/" + view.getFileName()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
