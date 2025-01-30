package goldrush.verkefni5;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Grafari extends ImageView { // player object
    public Grafari() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/goldrush/verkefni5/fxmlFiles/grafari-view.fxml")); // tekur fxml file fyrir grafari
            loader.setRoot(this); // set root adferdin sem er greynilega mikilvaeg?
            loader.load(); // stillir upp leikinum med thessi setting
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
