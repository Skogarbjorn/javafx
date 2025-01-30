package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox layout = fxmlLoader.load();
        layout.setStyle("-fx-background-color: #000000");
        Scene scene = new Scene(layout, 320, 240);
        stage.setScene(scene);
        stage.setTitle("Tea Party");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
