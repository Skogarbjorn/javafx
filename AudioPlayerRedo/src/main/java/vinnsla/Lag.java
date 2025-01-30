package vinnsla;

import javafx.scene.image.Image;

import java.io.File;

public class Lag {
    private File lag;
    private Image image;

    public Lag(File lag, String image) {
        this.lag = lag;
        this.image = new Image(image);
    }

    public Image getImage() {
        return image;
    }

    public String getLag() {
        return lag.toURI().toString();
    }

    public String toString() {
        return lag.getName();
    }
}
