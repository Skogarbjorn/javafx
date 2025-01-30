package vinnsla;

import javafx.scene.image.Image;

public class Lag {
    private String url;
    private String nafn;
    private Image image;

    public Lag(String url, String nafn, String imgUrl) {
        this.url = url;
        this.nafn = nafn;
        image = new Image(imgUrl);
    }

    public String toString() {
        return nafn;
    }

    public String getURL() {
        return url;
    }

    public Image getImage() {
        return image;
    }
}
