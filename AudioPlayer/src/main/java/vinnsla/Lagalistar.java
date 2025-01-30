package vinnsla;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Heldur utanum alla listana sem eru í media möppunni
 */
public class Lagalistar {
    private static Lagalisti[] lagalistar;
    private static int index=0;

    public static void setIndex(int i) {
        index = i;
    }

    public static Lagalisti getLagalisti() {
        return lagalistar[index];
    }

    /**
     * Býr til Lagalisti object fyrir hverja möppu í media
     * @param url
     * @throws URISyntaxException
     */
    public static void initializeLagalisti(URL url) throws URISyntaxException {
        File folder = new File(url.toURI());
        File[] listofAlbums = folder.listFiles();
        lagalistar = new Lagalisti[listofAlbums.length];
        for (File file : listofAlbums) {
            if (file.isDirectory()) {
                appendToLagalistar(file.getName());
            }
        }
    }

    /**
     * Bætir við Lagalisti objecti í fylkið
     * @param name Nafn folders
     * @throws URISyntaxException ef path er ekki fundinn
     */
    private static void appendToLagalistar(String name) throws URISyntaxException {
        for (int i = 0; i < lagalistar.length; i++) {
            if (lagalistar[i] == null) {
                lagalistar[i] = new Lagalisti(name);
                break;
            }
        }
    }

    /**
     * Skilar lengd fylkisins
     * @return lengd
     */
    public static int getLength() {
        return lagalistar.length;
    }
}
