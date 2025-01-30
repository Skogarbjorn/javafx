package goldrush.verkefni5;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gull extends ImageView {
    public Gull() {
        super(); // Call to the superclass constructor

        // Set the image and properties directly
        this.setImage(new Image("/goldrush/verkefni5/Assets/images/Gold_Coin.gif"));
        this.setFitWidth(80);
        this.setFitHeight(80);
        this.setPreserveRatio(true);
    }
}
