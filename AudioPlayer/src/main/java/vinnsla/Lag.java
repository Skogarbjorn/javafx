package vinnsla;

import javafx.scene.image.Image;

import java.io.File;

/**
 * Klasi sem heldur utan um einstök lög
 */
public class Lag {
    private String url;
    private Image image;
    private String name;

    /**
     * Smiður sem setur url og nafn lags
     * @param file file-ið sem lagið er í
     */
    public Lag(File file) {
        this.url = file.toURI().toString();
        this.name = file.getName();
    }


    /**
     * Skilar mynd lagsins
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * Setur mynd lagsins
     * @param path path að myndinni
     */
    public void setImage(String path) {
        image = new Image(path);
    }

    /**
     * Skilar url fyrir lagið
     * @return
     */
    public String getURL() {
        return url;
    }

    /**
     * Skilar nafni lagsins
     * @return nafn
     */
    public String toString() {
        return name;
    }
}
