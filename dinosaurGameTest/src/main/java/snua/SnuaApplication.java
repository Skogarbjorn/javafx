package snua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnuaApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader l = new FXMLLoader(SnuaApplication.class.getResource("snua-view.fxml"));
        Scene s = new Scene(l.load(), 400, 400);
        stage.setScene(s);
        stage.show();
    }
}
