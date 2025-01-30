package goldrush.verkefni5;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class Leikbord extends Pane {

    public Leikbord() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/goldrush/verkefni5/fxmlFiles/leikbord-view.fxml"));
            System.out.println("gamer");
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
