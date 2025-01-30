package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;

public class Lagalisti {
    private File folder;
    private Image image;

    private ObservableList<Lag> songs;

    public Lagalisti(File f) {
        folder = f;
        image = new Image("file:" + folder.getPath() + "/" + folder.getName() + "/" + folder.getName() + ".jpg");
        addSongs();
    }

    private void addSongs() {
        songs = FXCollections.observableArrayList();
        File[] files = folder.listFiles();
        File[] pictures = new File[0];
        for (File f : folder.listFiles()) {
            if (!f.isDirectory()) {
                String picture = folder.toURI() + "pictures/" + f.getName();
                int dotIndex = picture.lastIndexOf(".");
                Lag lag = new Lag(f, picture.substring(0, dotIndex) + ".jpg");
                songs.add(lag);
            }
        }
    }

    public ObservableList<Lag> getSongs() {
        return songs;
    }

    public String toString() {
        return folder.getName();
    }

    public Image getImage() {
        return image;
    }
}
