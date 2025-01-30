package rafmagn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RafmagnApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(RafmagnApplication.class.getResource("rafmagn-view.fxml"));
        Scene s = new Scene(loader.load(), 900, 300);
        stage.setScene(s);
        stage.setTitle("gamer");
        stage.show();
    }
}
