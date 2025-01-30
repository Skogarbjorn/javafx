package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.File;
import java.net.URISyntaxException;

public class Lagalistar extends ListView<Lagalisti> {
    public static Lagalisti selected;

    public Lagalistar() {
        setItems(FXCollections.observableArrayList());
        try {
            File folder = new File(getClass().getResource("/vidmot/media/").toURI());
            File[] allFiles = folder.listFiles();
            for (File f : folder.listFiles()) {
                if (f.isDirectory()) {
                    addAlbum(f);
                }
            }

        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public ObservableList<Lagalisti> getAlbums() {
        return getItems();
    }

    private void addAlbum(File f) {
        Lagalisti album = new Lagalisti(f);
        getItems().add(album);
    }
}
