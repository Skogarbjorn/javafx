package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Klasi sem heldur utanum lista af lögum
 */
public class Lagalisti {
    private ObservableList<Lag> listi = FXCollections.observableArrayList();

    private int index;

    private Image albumCover;

    /**
     * Smiður sem býr til Lag object fyrir hvert lag inni í plata möppunni
     * @param plata Path að möppunni
     * @throws URISyntaxException ef path er ekki fundinn
     */
    public Lagalisti(String plata) throws URISyntaxException {
        albumCover = new Image(getClass().getResource("/vidmot/media/").toString() + plata + "/" + plata + "/" + plata + ".jpg");
        File folder = new File(getClass().getResource("/vidmot/media/" + plata + "/").toURI());
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                File song = file.getAbsoluteFile();
                listi.add(new Lag(song));
            }
        }

        File picturesFolder = new File(getClass().getResource("/vidmot/media/" + plata + "/pictures/").toURI());
        File[] listOfPictures = picturesFolder.listFiles();
        int counter = 0;
        for (File picture : listOfPictures) {
            String path = picture.getAbsolutePath();
            listi.get(counter).setImage(path);
            counter++;
        }
    }

    /**
     * Skilar listanum
     * @return listinn
     */
    public ObservableList<Lag> getListi() {
        return listi;
    }

    /**
     * Setur hvaða lag á að nota
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Skilar mynd listans
     * @return
     */
    public Image getAlbumCover() {
        return albumCover;
    }
}
