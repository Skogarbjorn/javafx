package goldrush.verkefni5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GoldApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/goldrush/verkefni5/fxmlFiles/gold-rush-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 500, 600);
            primaryStage.setTitle("GoldRush");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        launch();
    }
}
