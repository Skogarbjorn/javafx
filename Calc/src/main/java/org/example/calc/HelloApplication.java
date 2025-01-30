package org.example.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 330, 400);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();
        controller.setScene(scene);

        scene.setOnKeyPressed(e -> controller.handleKeyPress(e));
    }

    public static void main(String[] args) {
        launch();
    }
}
